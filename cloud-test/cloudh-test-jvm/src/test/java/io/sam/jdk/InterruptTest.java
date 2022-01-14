package io.sam.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhuweimu
 * @description
 * @date 2022/1/7 14:54
 */
@Slf4j
public class InterruptTest {

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (;;){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Error e){

                }catch (Throwable e){

                }
                log.info("线程开始执行");
            }
        });
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        log.info("===============中断线程===============");
        Thread.sleep(2000);
        log.info("结束");
    }
}
