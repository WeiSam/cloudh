package io.sam;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import java.io.File;
import java.util.*;

/**
 * @author zhuweimu
 * @classname EasyExcelTest
 * @description
 * @date 2021/1/4 11:22
 */
@Slf4j
public class EasyExcelTest {

    /**
     * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面
     */
    @Test
    public void synchronousRead() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        String fileName = "F:/文档资料/对接文档/笔录/智能笔录系统v4.0.2版本需求评审/笔录模板范例1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
//        List<DemoData> list = EasyExcel.read(fileName).head(DemoData.class).sheet().doReadSync();
//        for (DemoData data : list) {
//            LOGGER.info("读取到数据:{}", JSON.toJSONString(data));
//        }

        List<ReadSheet> readSheets = EasyExcel.read(fileName).build().excelExecutor().sheetList();
        for (ReadSheet readSheet : readSheets) {
            List<Map<Integer, String>> datas = EasyExcel.read(fileName).headRowNumber(-1)
                    .sheet(readSheet.getSheetNo()).doReadSync();
            log.info("data:{}",JSON.toJSONString(datas));
        }
        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        List<Map<Integer, String>> listMap = EasyExcel.read(fileName).doReadAllSync();
        for (Map<Integer, String> data : listMap) {
            // 返回每条数据的键值对 表示所在的列 和所在列的值
            log.info("读取到数据:{}", JSON.toJSONString(data));
        }
    }

    @Test
    public void test2() {
        String fileName = "F:/文档资料/对接文档/笔录/智能笔录系统v4.0.2版本需求评审/笔录模板范例.xlsx";
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<Map<String, String>> list = ExcelImportUtil.importExcel(new File(fileName),Map.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }

    @Test
    public void name() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("12", Arrays.asList("123","456","34"));
        System.out.println(map.containsValue("123"));
        System.out.println(map.containsValue("23"));
    }
}
