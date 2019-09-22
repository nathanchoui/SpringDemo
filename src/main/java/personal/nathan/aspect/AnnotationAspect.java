package personal.nathan.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by za-zhangwei002 on 19-9-22.
 */
@Aspect
@Slf4j
@Component
public class AnnotationAspect {

    @Pointcut("execution(* personal.nathan.service..*(..))")
    public void aspect() {}

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        log.info("before前置advice " + joinPoint);
    }

    @After("aspect()")
    public void after(JoinPoint joinPoint) {
        log.info("after后置advice " + joinPoint);
    }

    @Around("aspect()")
    public void around(JoinPoint joinPoint) {
        log.info("around start");
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable t) {
            log.error(t.getMessage());
        }
        finally {
            log.info("consume: "+ (System.currentTimeMillis() - start) + " ms.");
            log.info("around end");
        }
    }

    @AfterReturning("aspect()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info(joinPoint.getTarget().toString());
    }

    @AfterThrowing(pointcut = "aspect()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {

    }
}
