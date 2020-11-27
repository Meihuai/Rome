package com.example.registration.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: registration
 * @description: 线程池监听
 * @author: meihua
 * @created: 2020/11/27 12:39
 */
public class ThreadPool {

    private ThreadPoolExecutor mexecutor;

    private volatile static  boolean State =true;

    private volatile static ThreadPool instance;

    private static final Logger logger = LoggerFactory.getLogger(ThreadPool.class);


    private ThreadPool(int coreNum) {
        if (mexecutor == null) {
            // TODO 用单例模式创建线程池
            mexecutor = new ThreadPoolExecutor(coreNum == 0 ? 3 : coreNum, coreNum, 0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingDeque<Runnable>(),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());
        }
    }

    public static ThreadPool getInstance(int coreNum) {
        if (instance == null) {
            synchronized (ThreadPool.class){
                if (instance==null){
                    instance = new ThreadPool(coreNum);
                    logger.info(" RedisListenerThreadPool start ");
                }
            }
        }
        return instance;
    }

    public static boolean isState() {
        return State;
    }

    public synchronized static void setState(boolean state) {
        State = state;
    }

    public void executor(Runnable runnable) {
        if (null == runnable) {
            return;
        }
        mexecutor.execute(runnable);
    }

    public Map<String,Integer> getInfo() {
        if (null == mexecutor) {
            return null;
        }
        Map<String,Integer> map = new HashMap<>(8);

        int queueSize = mexecutor.getQueue().size();
        map.put("当前排队线程数：",mexecutor.getQueue().size());
        map.put("当前活动线程数：", mexecutor.getActiveCount());
        map.put("当前核心线程数:",mexecutor.getCorePoolSize());
        Long completedTaskCount = mexecutor.getCompletedTaskCount();
        map.put("执行完成线程数：",  completedTaskCount.intValue());
        Long taskCount = mexecutor.getTaskCount();
        map.put("执行完成线程数：",  taskCount.intValue());
        logger.info("QueueConsumerThreadPool info：" + map);
        return map;
    }

    public void destroy() {
        if (mexecutor != null) {
            // 终止线程池
            mexecutor.shutdown();
        }
    }

}
