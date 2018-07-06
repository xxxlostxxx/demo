scheduleAtFixedRate()  
   周期性执行 包含执行时间 初始给定初始延时  x+ny 时间
   周期太短 则上个任务完成 下个任务立即被调用
    
scheduleWithFixedDelay() 
   周期性执行 不包含执行时间 开始与初始延时时间  上个任务结束和下个任务开始时间差固定
   
   
     public ThreadPoolExecutor(int corePoolSize,
                               int maximumPoolSize,
                               long keepAliveTime,
                               TimeUnit unit,
                               BlockingQueue<Runnable> workQueue,
                               ThreadFactory threadFactory,
                               RejectedExecutionHandler handler) {
         if (corePoolSize < 0 ||
             maximumPoolSize <= 0 ||
             maximumPoolSize < corePoolSize ||
             keepAliveTime < 0)
             throw new IllegalArgumentException();
         if (workQueue == null || threadFactory == null || handler == null)
             throw new NullPointerException();
         this.corePoolSize = corePoolSize;
         this.maximumPoolSize = maximumPoolSize;
         this.workQueue = workQueue;
         this.keepAliveTime = unit.toNanos(keepAliveTime);
         this.threadFactory = threadFactory;
         this.handler = handler;
     }
workQueue   
任务队列，被提交但是尚未被执行的任务 
BlockingQueue接口的对象，泛型Runnable接口

1.直接提交队列
SynchronousQueue 对象提供  无容量 每次insert 等待一个delete 每个delete等待对应的插入
提交的任务不会被真实保存，总是将新任务提交给线程 
无空闲线程则创建，达到最大执行拒绝
2.有界任务队列
ArrayBlockingQueue 实现
构造函数必须带一个容量参数，表示该队列的最大容量
新任务执行 
线程数小于corePoolSize 优先创建线程  
大于corePoolSize 优先加入等待队列 
若队列已满 线程小于maximumPoolSize 创建新的线程执行任务
大于maximumPoolSize 执行拒绝策略

3.无界任务队列
LinkedBlockingQueue 实现
除非系统资源耗尽 不然不存在入队失败
线程数小于corePoolSize 优先创建线程  
达到corePoolSize 不会继续增加 加入队列等待

4.优先任务队列
带有执行优先级的队列
PriorityBlockingQueue 实现 特殊的无界队列


handler: 拒绝策略
内置策略：
   1. AbortPolicy 直接抛出异常，阻止系统正常工作
   2. CallerRunsPolicy 只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务
                        不真的丢弃任务，任务提交线程的性能急剧下降
   3. DiscardOledestPolicy 丢弃最老的一个请求，即即将被执行的一个任务，并尝试再次提交当前任务
   4. DiscardPolicy 默默丢弃无法处理的任务，不予任何处理 







   