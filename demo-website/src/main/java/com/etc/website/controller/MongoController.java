package com.etc.website.controller;

import com.etc.base.entity.BusinessLogRecord;
import com.etc.base.mapper.BusinessLogRecordMapper;
import com.etc.base.vo.ValueObject;
import com.etc.website.configuration.GridConfig;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ChenDang
 * @date 2019/10/29 0029
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    BusinessLogRecordMapper businessLogRecordMapper;
    //获取mongodb的GridFS对象
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridConfig gridConfig;

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/mapreduce")
    public String mapreduce(){

        MapReduceOptions options = MapReduceOptions.options();
        options.outputCollection("log_business_record");
        options.outputTypeReduce();
        //options.finalizeFunction("classpath*:finalize.js");
        StringBuffer mapFunc = new StringBuffer();
        mapFunc.append("function(){emit(this.user_id,this.sales);}");
        StringBuffer reduceFuc = new StringBuffer("function(key,value){return Array.sum(value);}");
        StringBuffer outFunc = new StringBuffer("result001");
       /* MapReduceResults<ValueObject> reduceResults =
                mongoTemplate.mapReduce("log_business_record",  "classpath*:map.js",
                        "classpath*:reduce.js", options, ValueObject.class);*/

        MapReduceResults<ValueObject> reduceResults =
                mongoTemplate.mapReduce("log_business_record",  mapFunc.toString(),
                        reduceFuc.toString(), options, ValueObject.class);
        reduceResults.forEach(System.out::println);
        return "mapreduce";
    }

    @RequestMapping("/insert")
    public String insert(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        BusinessLogRecord record = new BusinessLogRecord();
        record.set_id(String.valueOf(System.currentTimeMillis()));
        record.setBeginTime(sdf.format(new Date()));
        record.setBrowserName("Google");
        record.setClassName(this.getClass().getName());
        record.setEndTime(sdf.format(new Date()));
        record.setErrMsg("");
        record.setLogType("SEARCH");
        record.setMethodName("insert");
        record.setModule("mongodb");
        record.setOperatorType("INSERT");
        record.setOsName("WINDOWS");
        record.setParam("");
        record.setRespTime("2s");
        record.setStatus("SUCCESS");
        record.setTerminal("none");
        record.setTitle("mongodb查询");
        record.setUrl("www.baidu.com");
        Random random = new Random();
        Integer i = random.nextInt(100);
        record.setSales(i);
        record.setUserId(i.toString());
        record.setUserIp("192.168.1.1");
        record.setUserLocation("福建厦门");
        record.setUserName("test");
        record.setUpdateTime(new Date());
        record.setCreateTime(new Date());
        businessLogRecordMapper.insert(record);
        return "insert success";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest request) throws Exception{

        Part part = request.getPart("uploadFile");
        //提交文件的名称
        String fileName = part.getSubmittedFileName();
        //获取输入流
        InputStream inputStream = part.getInputStream();
        //获取文件类型
        String contentType = part.getContentType();
        //把文件存储到mongodb，会返回这个文件的基本信息
        ObjectId gridFS = gridFsTemplate.store(inputStream,fileName,contentType);
        return "upload success:"+gridFS.toHexString();
    }

    @RequestMapping(value = "/downloadFile")
    public void downloadFile(@RequestParam(name = "file_id") String fileId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件
        GridFSFile gfsfile = gridFsTemplate.findOne(query);
        GridFsResource fsResource = gridConfig.convertGridFSFile2Resource(gfsfile);
        String fileName = gfsfile.getFilename().replace(",", "");
        //处理中文文件名乱码
        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
                request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
                || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            //非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        // 通知浏览器进行文件下载
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        IOUtils.copy(fsResource.getInputStream(),response.getOutputStream());
    }

    /**
     * 删除文件
     *
     * @param fileId
     * @return
     */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    @ResponseBody
    public String deleteFile(@RequestParam(name = "file_id") String fileId) {
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件
        GridFSFile gfsfile = gridFsTemplate.findOne(query);
        /*if (gfsfile == null) {
            return ServiceResultHelper.genResultWithFaild(Constant.ErrorCode.FILE_NOT_EXIST_ERROR_MSG, Constant.ErrorCode.FILE_NOT_EXIST_ERROR);
        }*/
        gridFsTemplate.delete(query);
        return "delete success";
        //return ServiceResultHelper.genResultWithSuccess();
    }
}
