package codix.eu.soa_ws.service.doc.aspect;

import codix.eu.soa_ws.service.doc.util.JsonUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by: tnthien
 * $Revision: 1.0 $Date: 2018/08/24 9:42 AM
 * $Log: LoggingAspect.java
 */
@Aspect
@Component
public class LoggingAspect
{
  private final static Logger logger = Logger.getLogger(LoggingAspect.class);

  @Pointcut("within(@org.springframework.stereotype.Service *)")
  protected void loggingOperation()
  {
  }

  @Before("loggingOperation()")
  @Order(1)
  public void logBefore(JoinPoint joinPoint)
  {
    logger.debug("START METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
  }

  @Before("execution(* codix.eu.soa_ws.service.doc.bu.*.validateRequest(..))")
  @Order(2)
  public void logBeforeValidateRequest(JoinPoint joinPoint)
  {
    final Object[] args = joinPoint.getArgs();
    final Object request = args[0];
    logger.info("INTO VALIDATE REQUEST -> " + JsonUtil.toString(request));
  }

  @AfterReturning("loggingOperation()")
  @Order(3)
  public void logAfter(JoinPoint joinPoint)
  {
    logger.debug("FINISH METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
  }

  //TODO
  /*@AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
  @Order(3)
  public void logAfterThrowing(JoinPoint joinPoint, Throwable e)
  {
    logger.error("An exception has been thrown in " + joinPoint.getSignature().getName() + "()");
    logger.error("Cause :" + e.getCause());
  }*/

  /*@Around("execution(* codix.eu.soa_ws.service.doc.bu.*.*(..))")
  @Order(4)
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
  {
    logger.info("The method " + joinPoint.getSignature().getName() + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    try {
      Object result = joinPoint.proceed();
      logger.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
      return result;
    }
    catch (IllegalArgumentException e) {
      logger.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in " + joinPoint.getSignature().getName() + "()");
      throw e;
    }
  }*/

}
