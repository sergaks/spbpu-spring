package ru.spbstu.sc.examples.helloworld.impl;

import ru.spbstu.sc.examples.helloworld.WorldProvider;

public class WorldProviderImpl implements WorldProvider {

	private String world;
	
	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}
}
