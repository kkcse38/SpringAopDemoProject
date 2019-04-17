package com.java.aop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aop.dao.AccountDao;
import com.java.aop.dao.MemberShipDao;
import com.java.aop.dao.UserDao;


@SpringBootApplication
public class SpringaopApplication implements CommandLineRunner{

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private MemberShipDao memberShipDao;
	
	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringaopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String[] beans = context.getBeanDefinitionNames();
		Arrays.sort(beans);
		
//		for(String bean : beans)
//			System.out.println("Bean is "+bean);
		
		if(accountDao != null)
			System.out.println("\naccountDao bean is created :"+accountDao.getClass().getName()+"\n");
		
		//call the business code, check the console where before advice should run
		accountDao.addAccount();
		accountDao.addAccount();
		
		memberShipDao.addAccount();
		
		userDao.addAccount();
		
		
	}

}
