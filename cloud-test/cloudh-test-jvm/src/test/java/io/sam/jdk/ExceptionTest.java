package io.sam.jdk;

import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuweimu
 * @desc
 * @date 2022/5/29 12:08
 */
@Slf4j
public class ExceptionTest {

    @Test
    public void testFinaly() {
        System.out.println(add());
        System.out.println(addColltion());
    }

    private int add() {
        Integer count  = 0;
        try {
            count++;
            int i = 1/0;
            log.info("try count = {}",count);
        }catch (Exception e){
            count++;
            log.info("catch count = {}",count);
            return count;
        }finally {
            count++;
            log.info("try finally = {}",count);
        }
        return count;
    }

    private int addObject() {
        UserDto userDto = new UserDto();
        Integer count  = 0;
        try {
            count++;
            userDto.setAge(count);
//            int i = 1/0;
            log.info("try count = {}",count);
        }catch (Exception e){
            count++;
            userDto.setAge(count);
            log.info("catch count = {}",count);
            return userDto.getAge();
        }finally {
            count++;
            userDto.setAge(count);
            log.info("finally count = {}",count);
        }
        return userDto.getAge();
    }

    private int addObject2() {
        UserDto userDto = new UserDto();
        userDto.setAge(0);
        try {
            userDto.setAge(1);
            int i = 1/0;
            log.info("try count = {}",userDto.getAge());
        }catch (Exception e){
            userDto.setAge(2);
            log.info("catch count = {}",userDto.getAge());
            return userDto.getAge();
        }finally {
            userDto.setAge(3);
            log.info("finally count = {}",userDto.getAge());
        }
        return userDto.getAge();
    }

    private List<Integer> addColltion() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            int i = 1 / 0;
        } catch (Exception e) {
            list.add(2);
            return list;
        } finally {
            list.add(3);
        }
        return list;
    }
    public void testThrow() throws Exception {
        try {
            log.info("{}",throwT(1));
        } catch (Exception e) {
            log.info("发生异常");
            throw e;
        }finally {
            log.info("执行finally");
        }
    }

    public String throwT(int num) throws Exception {
        if (num == 1) {
            throw new Exception("异常");
        }
        return "成功";
    }
}
