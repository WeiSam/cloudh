package io.sam.oom;

import org.junit.Test;

/**
 * @author zhuweimu
 * @classname OOMTest
 * @description
 * @date 2021/2/24 16:53
 */
public class OOMTest {

    /**
     * 模拟栈溢出
     */
    @Test
    public void testStackOOM() {
        loadData();
    }

    private void loadData() {
        loadData();
    }

    /**
     *
     * -XX:MetaspaceSize=1m -XX:MaxMetaspaceSize=1m
     */
    @Test
    public void testMetaspace() throws Exception {
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                User user = null;
                try {
                    user = User.class.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.run();
            }).start();
        }

        Thread.sleep(1000000);

    }
}
