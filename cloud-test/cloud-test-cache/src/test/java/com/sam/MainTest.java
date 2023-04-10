package com.sam;

import io.sam.Intercepts.TableNameIntercept;
import org.junit.Test;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/10 14:45
 */
public class MainTest {

    @Test
    public void testIndex() {
        System.out.println(TableNameIntercept.index(1));
    }
}
