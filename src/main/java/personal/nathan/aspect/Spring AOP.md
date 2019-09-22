### 切面(Aspect)
一个关注点的模块化，这个关注点可能会横切多个对象。

### 连接点（JoinPoint）
连接点指程序执行过程中的某一行为，例如调用HelloService.sayHello

### 通知（Advice）
指切面对于某个连接点所产生的动作。其中，一个切面可以包含多个通知。
* 前置通知
在连接点之前执行
* 后置通知
在连接点退出时执行，无论是否抛出异常。
* 返回后通知
在连接点正常返回后执行，不包括异常情况
* 环绕通知
包含前后通知。
* 异常通知
抛出异常时导致退出时的通知

### 切入点（Pointcut）
切入点是指匹配连接点的断言，在AOP中通知和一个切入点表达式关联。
切面中的所有通知所关注的连接点都由切入点表达式决定。

### 目标对象（Target Object）
目标对象是指被一个或者多个切面所通知的对象。
实际运行中，AOP操作的是TargetObject的代理对象。

### AOP代理（Aop Proxy）
Spring AOP中有两种代理方式：JDK动态代理和CGLib代理。
默认情况下，目标对象实现了接口时采用jdk动态代理。反之则CGLib。

### 切点表达式
* execution 
由于Spring切面粒度最小是达到方法级别。
而execution表达式可以用于明确指定方法返回类型，类名，方法名和参数名等与方法相关的部件。
并且在Spring中，大部分需要使用AOP的业务场景也只需要达到方法级别即可，因而execution表达式的使用是最为广泛的。
如下是execution表达式的语法：
```$xslt
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
```
这里问号表示当前项可以有也可以没有，其中各项的语义如下：
* modifiers-pattern：方法的可见性，如public，protected；
* ret-type-pattern：方法的返回值类型，如int，void等；
* declaring-type-pattern：方法所在类的全路径名，如com.spring.Aspect；
* name-pattern：方法名类型，如businessService()；
* param-pattern：方法的参数类型，如java.lang.String；
* throws-pattern：方法抛出的异常类型，如java.lang.Exception；
通配符说明：
* *通配符，该通配符主要用于匹配单个单词，或者是以某个词为前缀或后缀的单词。
* ..通配符，该通配符表示0个或多个项，主要用于declaring-type-pattern和param-pattern中。
如果用于declaring-type-pattern中，则表示匹配当前包及其子包。
如果用于param-pattern中，则表示匹配0个或多个参数。

* within
粒度为类
* annotation
注解
* args

