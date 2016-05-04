package com.mercury.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.mercury.beans.User;

@Aspect
public class LogAdvice {
	@Around("execution(* com.mercury.dao.impl.HelloDaoBean01.update(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		User user = (User) pjp.getArgs()[0];
		System.out.println(user.getName() + " starts updating");
		Object obj = pjp.proceed();
		System.out.println(user.getName() + " ends updating");
		return obj;
	}
	
	@AfterReturning(
			pointcut="execution(* com.mercury.dao.impl.HelloDaoBean01.query(..))",
			returning="result"
			)
	public void logAfterReturning(JoinPoint jp, Object result){
		System.out.println("Returning a list of users: " + result.getClass().getName());
	}
}
