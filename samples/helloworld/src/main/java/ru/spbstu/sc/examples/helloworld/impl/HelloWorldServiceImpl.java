package ru.spbstu.sc.examples.helloworld.impl;

import ru.spbstu.sc.examples.helloworld.HelloProvider;
import ru.spbstu.sc.examples.helloworld.HelloWorldService;
import ru.spbstu.sc.examples.helloworld.WorldProvider;

public class HelloWorldServiceImpl implements HelloWorldService {

	private HelloProvider helloProvider;
	private WorldProvider worldProvider;
	private String format;
	
	
	public void sayIt() {
		String hello = helloProvider.getHello();
		String world = worldProvider.getWorld();
		System.out.println(String.format(format, hello, world));
	}
	
	public static void main(String[] args) {
		System.out.println(String.format("%s %s", "helloo", "world"));
	}

	public HelloProvider getHelloProvider() {
		return helloProvider;
	}

	public void setHelloProvider(HelloProvider helloProvider) {
		this.helloProvider = helloProvider;
	}

	public WorldProvider getWorldProvider() {
		return worldProvider;
	}

	public void setWorldProvider(WorldProvider worldProvider) {
		this.worldProvider = worldProvider;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
