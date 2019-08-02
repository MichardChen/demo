package com.etc.website.controller;

import com.alibaba.excel.metadata.TableStyle;
import com.etc.component.easyexcel.excel.ExcelUtil;
import com.etc.component.easyexcel.rest.ExportInfo;
import com.etc.component.easyexcel.rest.ImportInfo;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-06-05
 * @Time 16:56
 */
@RestController
@RequestMapping("/easyexcel")
public class ExcelController {
    /**
     * 读取 Excel（允许多个 sheet）
     */
    @RequestMapping(value = "/readExcelWithSheets", method = RequestMethod.POST)
    public Object readExcelWithSheets(MultipartFile excel) {
        return ExcelUtil.readExcel(excel, new ImportInfo());
    }

    /**
     * 读取 Excel（指定某个 sheet）
     */
    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public Object readExcel(MultipartFile excel, int sheetNo,
                            @RequestParam(defaultValue = "1") int headLineNum) {
        return ExcelUtil.readExcel(excel, new ImportInfo(), sheetNo, headLineNum);
    }

    /**
     * 导出 Excel（一个 sheet）
     */
    @RequestMapping(value = "/writeExcel", method = RequestMethod.GET)
    public void writeExcel(HttpServletResponse response) throws IOException {
        List<ExportInfo> list = getList();
        String fileName = "批量新参保模板";
        String sheetName = "格式模板（五险)";
        TableStyle commonStyle = new TableStyle();
        commonStyle.setTableContentBackGroundColor(IndexedColors.YELLOW);
        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ExportInfo(),commonStyle);
    }

    /**
     * 导出 Excel（多个 sheet）
     */
    @RequestMapping(value = "/writeExcelWithSheets", method = RequestMethod.GET)
    public void writeExcelWithSheets(HttpServletResponse response) throws IOException {
        List<ExportInfo> list = getList();
        String fileName = "一个 Excel 文件";
        String sheetName1 = "第一个 sheet";
        String sheetName2 = "第二个 sheet";
        String sheetName3 = "第三个 sheet";

        ExcelUtil.writeExcelWithSheets(response, list, fileName, sheetName1, new ExportInfo())
                .write(list, sheetName2, new ExportInfo())
                .write(list, sheetName3, new ExportInfo())
                .finish();
    }

    private List<ExportInfo> getList() {
        List<ExportInfo> list = new ArrayList<>();
        ExportInfo model1 = new ExportInfo();
        model1.setAac002("352601196002151557");
        model1.setAac003("郭玉林");
        model1.setAac004("男");
        model1.setAac005("汉族");
        model1.setAac009("城镇（非农业户口）");
        model1.setAac007("20190617");
        model1.setAac011("中等专科");
        model1.setAae007("364000");
        model1.setBae528("13809090909");
        model1.setAac010("龙岩市新罗区");
        model1.setAae006("龙岩市曹溪镇东山村");
        model1.setAae005("18290921219");
        list.add(model1);
        return list;
    }
}
