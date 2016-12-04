package edu.keith.demo;

/**
 * Created by Administrator on 2016/4/21.
 */
public class ExtendTest {
	public static void main(String[] args) {
		Child child = new Child();
	}
}

class Parent {
	static {
		System.out.println("static in parent");
	}
	{
		System.out.println("print in parent");
	}
}

class Child extends Parent {
	static {
		System.out.println("static in child");
	}
	{
		System.out.println("print in child");
	}

	public static void doSomething() {
		System.out.println("do something");
	}
}
