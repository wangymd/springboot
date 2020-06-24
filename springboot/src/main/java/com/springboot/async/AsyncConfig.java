package com.springboot.async;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 1、ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
2、ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务。您不会任务请求。但是这种策略会降低对于新任务提交速度，影响程序的整体性能。另外，这个策略喜欢增加队列容量。如果您的应用程序可以承受此延迟并且你不能任务丢弃任何一个任务请求的话，你可以选择这个策略。
3、ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
4、ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。
 */
@Configuration
public class AsyncConfig implements AsyncConfigurer {

  private static final int CORE_POOL_SIZE = 6;
  private static final int MAX_POOL_SIZE = 10;
  private static final int QUEUE_CAPACITY = 100;

  @Bean
  public Executor taskExecutor() {
    // Spring 默认配置是核心线程数大小为1，最大线程容量大小不受限制，队列容量也不受限制。
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    // 核心线程数
    executor.setCorePoolSize(CORE_POOL_SIZE);
    // 最大线程数
    executor.setMaxPoolSize(MAX_POOL_SIZE);
    // 队列大小
    executor.setQueueCapacity(QUEUE_CAPACITY);
    // 当最大池已满时，此策略保证不会丢失任务请求，但是可能会影响应用程序整体性能。
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.setThreadNamePrefix("My ThreadPoolTaskExecutor-");
    executor.initialize();
    return executor;
  }
}
