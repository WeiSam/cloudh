package io.sam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest05 {

    public static String dateToStr(int millisSeconds) {
        Date date = new Date(millisSeconds);
//        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.nonSafe;
        return simpleDateFormat.format(date);
    }

    private static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            int j = i;
            executorService.execute(() -> {
                String date = dateToStr(j * 1000);
                // 从结果中可以看出是线程安全的，时间没有重复的。
                System.out.println(date);
            });
        }
        executorService.shutdown();
    }
}

class ThreadSafeFormatter {

    public static SimpleDateFormat nonSafe = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };

    // java8的写法，装逼神器
//    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
//            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}