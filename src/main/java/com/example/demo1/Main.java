package com.example.demo1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// classpath:applicationContext.xml 에 선언해 준 bean 값을 읽어 들인다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		// ctx에서 "greeter"라는 이름의 빈 값을 가지고 오는데 가지고 올 때 타입은 Greeter.class이다.
		// bean id greeter 에 선언해준 <property name="format" value="%s, Hello, World!" />을 Greeter.class에 있는 setFormat 메소드를 통해 format 변수에 넣어준다.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		// Greeter 메소드 호출대로, format "%s, Hello, World!" 에 Spring 값을 대입한 String 값을 return 해준다.
		String msg = g.greet("Spring");
		//String msg = g.setFormat("Spring");

		System.out.println(msg);
		ctx.close();
	}
}
