package io.sam.easyexcel;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.merge.AbstractMergeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/3 17:25
 */
@Slf4j
public class CustomizeMergeStrategy extends AbstractMergeStrategy {

    List<Integer> fruitGroupCount = Arrays.asList(2,3,5);
    List<Integer> mergeColumn = Arrays.asList(0,1,4);
    //是否已合并单元格
    private AtomicBoolean hadMerge = new AtomicBoolean(false);

    @Override
    protected void merge(Sheet sheet, Cell cell, Head head, Integer relativeRowIndex) {
        if (!hadMerge.get()) {
            log.info("合并单元格");
            int rowCnt = cell.getRow().getRowNum();
            for (Integer count : fruitGroupCount) {
                for (Integer column : mergeColumn) {
                    CellRangeAddress cellRangeAddress = new CellRangeAddress(rowCnt, rowCnt + count - 1, column, column);
                    sheet.addMergedRegionUnsafe(cellRangeAddress);
                }
                rowCnt += count;
            }
            hadMerge.compareAndSet(false,true);
        }

    }
}
