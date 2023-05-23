package io.sam.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 复杂头数据.这里最终效果是第一行就一个主标题，第二行分类
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER,verticalAlignment = VerticalAlignmentEnum.CENTER)
public class ComplexHeadData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("接口")
    private String name11;
    @ExcelProperty("姓名")
    private String nameA;
}
