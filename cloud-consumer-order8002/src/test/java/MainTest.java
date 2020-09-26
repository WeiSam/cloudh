import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhuweimu
 * @Classname MainTest
 * @Description
 * @Date 2020/7/27 13:49
 */
@Slf4j
public class MainTest {

    @Test
    public void test01(){
        String str = "11,12,,3435,56";
        Arrays.stream(str.split("[,]")).forEach(System.out::println);
        log.info(str);
    }
}
