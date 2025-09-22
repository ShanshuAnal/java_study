✅ 对比分析：Semaphore vs Lock + Condition
方面	    Semaphore	                        Lock + Condition
轻量级	是，直接靠内核原语实现	                略重，需配合锁机制
可读性	简洁、直观（特别是多个线程调度）	        状态表达更明确
可控性	弱，信号量一旦 release()，不能撤销	    强，线程可以更精准地等待状态
适合场景	简单顺序控制（先后执行等）	            复杂状态机、条件判断

你该选哪个？	
如果线程间是流程型依赖，用 Semaphore；
如果是状态型依赖，用 Lock + Condition

✅ 结论建议：
在 FizzBuzz 这种属于“状态驱动”的场景下，Lock + Condition 更优雅，逻辑清晰，可扩展性好；

Semaphore 更适用于任务编排场景，如 Foo first-second-third；

如果你对状态管理敏感，推荐用 Lock + Condition，因为：

语义表达清晰；
更符合“谁等什么、等到什么时机唤醒”的逻辑；
更容易扩展或调试。