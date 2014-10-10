package ru.spbstu.sc.examples.helloworld.impl;

import ru.spbstu.sc.examples.helloworld.HelloProvider;

public class HelloProviderImpl implements HelloProvider {

	private String hello;
	
	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
}
