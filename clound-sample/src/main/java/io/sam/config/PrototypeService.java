package io.sam.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/24 14:42
 */
@Data
//@Scope(value = "prototype")
@Service
public class PrototypeService {

    @Autowired
    private PrototypeService prototypeTest;

    public String test(){
        return "prototype";
    }

}
