package io.sam.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/18 18:01
 */
public class CglibTest {

    @Test
    public void testcglib() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_p oxy_class");
    }
}
