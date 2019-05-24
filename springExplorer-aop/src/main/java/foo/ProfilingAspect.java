package foo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class ProfilingAspect {  
    @Around("profileMethod()")  
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {  
       System.out.println("weavering");
       StopWatch sw = new StopWatch(getClass().getSimpleName());  
       try {  
           sw.start(pjp.getSignature().getName());  
        
           return pjp.proceed();  
       } finally {  
           sw.stop();  
           System.out.println(sw.prettyPrint());  
       }  
    }  
    @Pointcut("execution(public * foo..*(..))")  
    public void profileMethod() {}  
}
