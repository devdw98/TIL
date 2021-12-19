package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;

@Aspect //aop로 쓸 수 있음
@ComponentScan //bean으로 등록하는 방법1
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))")//타겟팅 - 모두 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        //시간 로직
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            Object result = joinPoint.proceed(); //다음 메소드로 진행
            return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
        }

    }
}
