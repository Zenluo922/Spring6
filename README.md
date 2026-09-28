# Spring6 重点学习指南

> 依据《Spring6_语雀版讲义》整理（共 19 章，约 1.1 万行）
> 制定时间：2026-09-27 ｜ 目标：**10~14 天学完 Spring6**，为 SpringBoot 项目实战 + 11 月投简历腾时间
>
> **核心策略：这份讲义是 XML 驱动的传统讲法，企业里（SpringBoot 时代）XML 基本绝迹。**
> 所以：**XML 部分以"理解原理"为目标，注解部分以"熟练手写"为目标，别在 XML 语法细节上死磕。**
> 但生命周期、循环依赖、作用域这些"XML 时代的知识"恰恰是面试最爱问的，必须掌握。

---

## 〇、优先级总览

| 优先级 | 含义 | 章节清单 |
|--------|------|----------|
| 🔥🔥🔥 必须精通 | 动手写 + 能给面试官讲明白 | 3 入门 / 4 IoC与DI / 5 作用域 / 8 生命周期 / 9 循环依赖 / 12 注解开发 / 14 代理模式 / 15 AOP / 16 事务 / 18 整合MyBatis |
| 🔥🔥 重点掌握 | 理解 + 会用，关键小节需精通 | 1 启示录 / 6 工厂模式 / 7 Bean实例化(7.4/7.5必精) / 11 手写框架(亮点选做) |
| 🔥 快速过 | 1~2 小时浏览，知道有这回事 | 2 概述 / 10 反射回顾 / 13 JdbcTemplate / 17 整合JUnit5 |
| ⏭ 面试前突击 | 不用现在学，投简历前背一遍 | 19 八大设计模式 |

**如果时间只剩 10 天的最短路径：**
3 → 4（概念+常用注入）→ 5 → 7.4/7.5 → 8 → 9 → 12 → 14 → 15 → 16 → 18

---

## 一、分章重点明细

### 第 1 章 Spring启示录 🔥🔥（半天）
- **必须吃透三个概念**：OCP 开闭原则 → DIP 依赖倒置 → IoC 控制反转的推导过程
- 这是回答面试题 *"谈谈你对 IoC 的理解"* 的标准开场白：从三层架构的耦合问题讲起
- 不用记代码，把思想演变逻辑用自己的话讲一遍即可

### 第 2 章 Spring概述 🔥（半小时）
- 8 大模块扫一眼：知道核心是 **Core Container（容器）**，AOP、DataAccess 后面会学到
- 官网、下载方式略过，现在都用 Maven 依赖

### 第 3 章 第一个Spring程序 🔥🔥🔥（半天，必动手）
- **3.3** 第一个程序：Maven 引依赖 → 写 XML → getBean()，完整跑通一遍
- **3.4 剖析是本章灵魂**，其中两个高频面试题：
  - **ApplicationContext vs BeanFactory**：前者一次性加载（饿汉），后者懒加载；前者功能更全（国际 化/事件/环境）
  - getBean 的四种重载、refresh() 的作用
- **3.5 Log4j2**：跟着配一遍能跑就行，不深究（SpringBoot 里直接用自带日志）

### 第 4 章 Spring对IoC的实现 🔥🔥🔥（2 天，全书最重章节之一）
- **4.1 / 4.2 概念辨析必背**：IoC 是思想，DI 是实现手段 —— *面试题：IoC 和 DI 的区别*
- **4.3 set注入专题**（讲义最长的节）重点掌握这些注入即可：
  - 注入 Bean 对象（ref）、简单类型（value）⭐ 最常用
  - 数组 / List / Set / Map / Properties ⭐ 理解结构
  - null 值、特殊字符（XML 转义、CDATA）看一眼
  - 级联属性赋值、util 注入 List 给多个 Bean 复用 → 了解即可
- 4.4 p 命名空间 / 4.5 c 命名空间 / 4.6 util 命名空间 → 🔥 各看 20 分钟，语法不背
- 4.7 XML 自动装配（byName/byType）→ 🔥 了解思想即可，注解版的 @Autowired 才是重点
- **4.8 引入外部 properties 文件** 🔥🔥：`context:property-placeholder` + `${}`，这是 SpringBoot `application.yml` 配置抽取思想的源头，jdbc.properties 这个例子要动手

### 第 5 章 Bean的作用域 🔥🔥🔥（半天）
- **singleton vs prototype** 的区别必须张口就来（默认 singleton、一个 vs 多个实例）
- 面试追问点：**singleton 是否线程安全？**（有可变成员变量时不安全 → 别在 Bean 里放可变共享状态）
- 5.3 request/session/application/websocket 四个 web 作用域，知道概念即可

### 第 6 章 GoF之工厂模式 🔥🔥（1 天）
- **6.2 简单工厂 + 6.3 工厂方法**：必须能手写 UML + 代码（设计模式面试第一高频，和 Spring 的 Bean 工厂呼应）
- 6.4 抽象工厂：了解即可，面试能说出"产品族"这个词就行

### 第 7 章 Bean的实例化方式 🔥🔥（半天）
- 7.1 构造方法实例化：默认方式，掌握
- 7.2 简单工厂 / 7.3 factory-bean：了解
- **7.4 FactoryBean 接口 🔥🔥🔥**：必须动手写一次。Spring 底层大量使用（第 18 章整合 MyBatis 的 SqlSessionFactoryBean 就是它）
- **7.5 BeanFactory vs FactoryBean 区别 🔥🔥🔥**：面试必背 —— 前者是 IoC 容器（工厂），后者是创建 Bean 的 Bean（产品）
- 7.6 注入自定义 Date：看一眼 SimpleDateFormat 工厂思路即可

### 第 8 章 Bean的生命周期 🔥🔥🔥（1 天）面试超高频
- **5 步 → 7 步 → 10 步必须能完整背出**：
  - 5 步：实例化 → 属性赋值 → 初始化（init-method）→ 使用 → 销毁（destroy-method）
  - 7 步：加上 **BeanPostProcessor** 的 before / after 增强（AOP 的雏形就在这里）
  - 10 步：加上三个 Aware 回调（BeanNameAware / BeanClassLoaderAware / ApplicationContextAware）
- 重点理解 **BeanPostProcessor**：它就是 Spring 提前留好的扩展点
- 8.7 自己 new 的对象交给 Spring 管理（DefaultListableBeanFactory.registerSingleton）：看一遍

### 第 9 章 Bean的循环依赖 🔥🔥🔥（半天）面试超高频
- 结论必须记牢：**只有 singleton + setter 注入**的循环依赖 Spring 能自动解决
- **构造注入、prototype 作用域**的循环依赖解决不了 → 会直接报错
- 9.5 三级缓存机理：理解"提前暴露引用"的核心思想（一级单例池 / 二级早期暴露 / 三级工厂），面试深挖到这层就够
- 补充认知：SpringBoot 2.6+ 默认禁止循环依赖，出现循环依赖首先应考虑设计问题

### 第 10 章 回顾反射机制 🔥（1~2 小时）
- Java 基础已学过反射，这里快速回顾：获取 Method、invoke、操作 Field
- 唯一目的：为第 11 章手写框架铺路，不新学东西

### 第 11 章 手写Spring框架 🔥🔥（1 天，强烈建议做）
- 跟着 11 步写一个 mini-Spring：解析 XML → 反射实例化 → Map 存储 → 依赖注入
- **价值**：彻底看穿 IoC 容器本质，面试说一句"我手写过简化版 Spring 框架"就是差异化亮点
- 时间实在不够可以只跟到第八步（能 getBean 即可），后三步浏览

### 第 12 章 IoC注解式开发 🔥🔥🔥（1.5 天）全书最实用章节
- 12.1 注解回顾：快速过
- **12.2 声明 Bean 的注解**：@Component / @Repository / @Service / @Controller 及各自使用层
- **12.3 组件扫描**：`context:component-scan`，use-default-filters、include-filter / exclude-filter
- 12.4 选择性实例化：了解
- **12.5 负责注入的注解 🔥🔥🔥 本章灵魂**：
  - **@Autowired**（byType 优先，多个时配 @Qualifier）
  - **@Resource**（byName 优先）—— *面试题：@Autowired 和 @Resource 的区别*（必背：所属规范、匹配策略、required 属性）
  - @Value 注入简单类型、@Qualifier 精确指定
- **12.6 全注解开发**：@Configuration + @ComponentScan → 这是通往 SpringBoot 的大门，必须熟练

### 第 13 章 JdbcTemplate 🔥（半天，快速过）
- 增删改查 + 批量操作各看一遍，知道 queryForObject / query 的用法即可
- **企业实际用 MyBatis-Plus，这里不投入时间**，它唯一的意义是让你知道"没有 MyBatis 时原生 JDBC 封装长什么样"
- 13.12 德鲁伊连接池配置看一眼（面试可能问"用过什么连接池"）

### 第 14 章 GoF之代理模式 🔥🔥🔥（1 天）AOP 的地基
- 14.2 静态代理：必须理解"目标类 + 代理类"结构及其缺点（接口一变全要改）
- **14.3 动态代理 🔥🔥🔥 必须能手写**：JDK 动态代理（Proxy.newProxyInstance + InvocationHandler）
- 面试题 *"AOP 的底层原理"* 的答案就在这：**JDK 动态代理（基于接口）vs CGLIB（基于继承）**
- 讲义里 14.3 的两个动态代理案例（method invocation 计时、日志）都要敲

### 第 15 章 面向切面编程AOP 🔥🔥🔥（2 天）面试+实战双高频
- **15.2 七大术语**必须能准确说出：切面 Aspect / 连接点 JoinPoint / 切点 Pointcut / 通知 Advice（前缀/返回/异常/环绕/最终）…（面试让"说说 AOP 的概念"就答术语 + 一个例子）
- **15.3 切点表达式**：`execution(修饰符 返回值 包.类.方法(参数))` 语法必须会写、会看
- **15.4 注解式 AOP 全部要熟练**：
  - @Before / @AfterReturning / @AfterThrowing / @Around / @After 五种通知 + 执行顺序
  - JoinPoint 获取目标方法信息、@Order 控制切面顺序、@Pointcut 抽取公共切点
- **15.5 事务案例 + 15.6 安全日志案例：必须动手**，安全日志是面试讲"AOP 实际用途"的最好例子（日志/事务/权限/性能监控四大场景）

### 第 16 章 Spring对事务的支持 🔥🔥🔥（1.5 天）全书压轴重点
- **16.1 理论必背**：
  - 事务四大特性 ACID、三大读问题（脏读/不可重复读/幻读）、四大隔离级别
  - **七大传播行为**（REQUIRED / REQUIRES_NEW / NESTED 重点，其余了解）—— *面试超高频：Spring 事务传播行为有哪些*
- **16.2 转账案例必动手**：先看没有事务时的问题，体会"为什么需要声明式事务"
- **16.3 声明式事务 🔥🔥🔥**：
  - @Transactional 全属性：isolation / propagation / **rollbackFor** / noRollbackFor / readOnly / timeout
  - **必须记住的坑：默认只对 RuntimeException 和 Error 回滚，自定义异常必须加 `rollbackFor = Exception.class`**
  - 全注解式事务配置（@Configuration + @EnableTransactionManagement）要会写

### 第 17 章 Spring整合JUnit 🔥（半小时）
- **只看 17.2（JUnit5）**：@ExtendWith(SpringExtension.class) + @ContextConfiguration 两行注解会用即可
- 17.1 JUnit4 部分直接跳过，SpringBoot 里 @SpringBootTest 更简单

### 第 18 章 Spring6集成MyBatis 🔥🔥🔥（1 天）SSM 最后一块拼图
- 必须完整动手：pom 依赖 → SqlSessionFactoryBean → MapperScannerConfigurer → Service 层整合事务 → 测试
- 搞懂"MyBatis 的 Mapper 接口为什么不用写实现类就能被注入"（答案连着第 7 章 FactoryBean）
- 18.3 import 多配置文件拆分：了解
- **这一章学完，你就有完整 SSM 能力了，是 Tlias 项目实战的直接地基**

### 第 19 章 Spring中的八大模式 ⏭（面试前突击）
- 现在不用学，**投简历前一周背一遍**：简单工厂（BeanFactory）/ 工厂方法 / 单例（默认作用域）/ 代理（AOP）/ 装饰器（Java IO）/ 观察者（事件机制）/ 策略 / 模板方法（JdbcTemplate）
- 面试问"Spring 用到了哪些设计模式"，说出 5 个 + 各举一处源码场景就很加分

---

## 二、面试高频题自测清单

学完后逐条自测，答不上来回看对应章节：

| # | 面试题 | 出处 | 掌握标准 |
|---|--------|------|----------|
| 1 | 谈谈你对 IoC 的理解 | 第1、4章 | 从三层架构耦合问题讲到控制反转，1 分钟 |
| 2 | IoC 和 DI 的区别 | 第4章 | 一句话：思想 vs 实现手段 |
| 3 | ApplicationContext 和 BeanFactory 的区别 | 第3章 | 加载时机、功能范围各 2 点 |
| 4 | BeanFactory 和 FactoryBean 的区别 | 第7章 | 容器 vs 特殊 Bean，各举例 |
| 5 | Bean 的作用域？singleton 线程安全吗 | 第5章 | 两种默认区别 + 有状态 Bean 的风险 |
| 6 | Bean 的生命周期 | 第8章 | 完整背出 10 步 |
| 7 | Spring 怎么解决循环依赖？哪些情况解决不了 | 第9章 | 三级缓存思想 + 两种失败场景 |
| 8 | @Autowired 和 @Resource 的区别 | 第12章 | 匹配策略 + 所属规范（JSR-250） |
| 9 | Spring 事务传播行为有哪些 | 第16章 | 至少说出 REQUIRED / REQUIRES_NEW 并解释 |
| 10 | @Transactional 什么时候会失效（不回滚） | 第16章 | 默认回滚规则 + rollbackFor |
| 11 | 说说 AOP 及其七大术语 | 第15章 | 术语 + 举日志/事务例子 |
| 12 | AOP 底层原理？JDK 动态代理和 CGLIB 区别 | 第14章 | 能手写 JDK 动态代理 |
| 13 | Spring 用到了哪些设计模式 | 第6、19章 | 说出 5 个以上 |

---

## 三、时间规划建议（总计 12~14 天）

| 阶段 | 天数 | 内容 | 产出检验 |
|------|------|------|----------|
| 第 1 阶段：IoC 核心 | 4~4.5 天 | 1→2→3→4→5→7 | 能画图讲清 IoC/DI/BeanFactory，set 注入常见 8 种场景都敲过 |
| 第 2 阶段：深入 Bean | 2 天 | 8→9→(10)→(11) | 生命周期 10 步背熟；能给别人讲三级缓存 |
| 第 3 阶段：注解开发 | 1.5 天 | 12 | 全注解方式重写第 4 章的案例 |
| 第 4 阶段：AOP+事务 | 3.5 天 | 14→15→16 | 手写 JDK 动态代理；转账事务案例跑通；安全日志案例跑通 |
| 第 5 阶段：整合收官 | 1.5 天 | 13(过)→17(过)→18 | Spring+MyBatis 完整 CRUD + 事务 demo 跑通 |

> 每章代码必须跟着敲，建议在 Spring6 目录下按章建 module（`spring6-ch03` …）。
> 敲完一节，合上讲义问自己：这章面试会怎么问？

---

## 四、学习检验标准（学完 Spring6 你应该能做到）

- [ ] 用 1 分钟口头讲清"没有 Spring 的世界有什么问题 → Spring 怎么解决"
- [ ] 手写：注解式 Spring（@Configuration + @ComponentScan）+ @Autowired 注入 + JUnit5 测试
- [ ] 手写：一个 AOP 切面（环绕通知 + 切点表达式 + 记录方法执行时间）
- [ ] 手写：@Transactional 事务方法，并能说出 rollbackFor 的坑
- [ ] 手写：Spring + MyBatis 整合配置（XML 版），并解释每个 Bean 的作用
- [ ] 背出：Bean 生命周期 10 步、循环依赖三级缓存思想、@Autowired vs @Resource

---

## 五、避坑提醒

1. **别在 XML 语法上完美主义**——p/c/util 命名空间、复杂集合注入这些，看懂就行，工作用不到，面试也不考写法
2. **第 4 章 4.3 有 1100 多行**，是全书最长的一节，挑重点注入类型练，别逐行看完
3. **第 11 章手写框架是亮点不是必修**，时间紧优先保 15、16、18 章
4. **第 13 章 JdbcTemplate 不要恋战**，它是"历史知识"，MyBatis-Plus 才是你的主力
5. 学完 Spring6 别停，尽快进入 SpringBoot（AI+JavaWeb 项目实战篇），**项目经验比框架细节更值钱**——你的 deadline 是 11 月投简历
6. 遇到注解想不起 XML 时代的对应物时回来查第 4 章即可，正向（XML→注解→SpringBoot）是学习顺序，逆向是使用方式
