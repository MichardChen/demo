package com.etc.component.easyexcel.rest;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 导出 Excel 时使用的映射实体类，Excel 模型
 * @ExcelProperty注解用来标记表格的表头,value支持多级表头,
 * 用一级表头一致框架自动会对表头进行合并,index表示标记字段在excel中的顺序，
 * 不是在excel中的位置
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@Data
@Setter
@Getter
public class ExportInfo extends BaseRowModel {

    /**
     * 姓名占2个单元格，并合并
     */
    @ExcelProperty(value = {"","身份证号码"},index = 0)
    private String aac002;

    @ExcelProperty(value = {"基本信息","姓名"},index = 1)
    private String aac003;

    @ExcelProperty(value = {"","性别"},index = 2)
    private String aac004;

    @ExcelProperty(value = {"","民族"},index = 3)
    private String aac005;

    @ExcelProperty(value = {"","户口性质"},index = 4)
    private String aac009;

    @ExcelProperty(value = {"","参加工作日期"},index = 5)
    private String aac007;

    @ExcelProperty(value = {"","学历"},index = 6)
    private String aac011;

    @ExcelProperty(value = {"","邮政编码"},index = 7)
    private String aae007;

    @ExcelProperty(value = {"","手机号码"},index = 8)
    private String bae528;

    @ExcelProperty(value = {"","户籍所在地"},index = 9)
    private String aac010;

    @ExcelProperty(value = {"","通讯地址"},index = 10)
    private String aae006;

    @ExcelProperty(value = {"","联系电话"},index = 11)
    private String aae005;
}
