import io.sam.ProviderPaymentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 12:11
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderPaymentApplication.class)
public class BaseTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRest(){
        System.out.println("开始");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("127.0.0.1:8001/check", String.class);
        System.out.println(forEntity);
    }
}
