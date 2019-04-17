package com.java.aop.dao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {
	
	//here condition is not applied for any particular class, so the this before method will execute before addAccount of any class.
//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice(){
//		System.out.println("Before addAccount Advice\n");
//	}
	
	
	//here condition is applied for the AccountDao class only, 
	//so the before advice method will execute only for AccountDao class
//	@Before("execution(public void com.java.aop.dao.AccountDao.addAccount())")
//	public void beforeAddAccountAdvice(){
//		System.out.println("Before addAccount Advice\n");
//	}
//	
	
	@Before("execution(public void add*())")
	public void beforeAddAccountAdviceforAllMethods(){
		System.out.println("Before addAccount Advice\n");
	}
}
