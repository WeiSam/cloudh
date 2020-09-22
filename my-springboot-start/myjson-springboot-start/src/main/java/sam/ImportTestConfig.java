package sam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @classname ImportTestConfig
 * @description springboot 启动类项目包外，添加进spring容器中，需要spring.factories
 * 文件中添加启动加载，包路径相同不加也可以加载到
 * @date 2020/9/22 13:55
 */
@Configuration
public class ImportTestConfig {

    @Value("${test.age}")
    Integer age;

    @Bean
    public TestModel testModel(){
        TestModel testModel = new TestModel();
        testModel.setName("sam");
        testModel.setAge(age);
        return testModel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
