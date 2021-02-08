package io.sam;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhuweimu
 * @classname MainTest
 * @description
 * @date 2021/1/20 17:53
 */
public class MainTest {

    @Test
    public void name() throws IOException {
        String data = "";
        JsonFactory factory = new JsonFactory();
        JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name","sam");
//        jsonGenerator.writeObjectField("date",new Date());
        jsonGenerator.writeEndObject();
        jsonGenerator.close();
    }


}
