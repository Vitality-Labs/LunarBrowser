package com.vitalitylabs.graphics;

import java.awt.Component;

public abstract class GraphicsElement {
	
	public GraphicsManager manager;
	
	public GraphicsElement(GraphicsManager manager) {
		this.manager = manager;
	}
	
	public abstract void initialize();
	public abstract void tick();
	public abstract Component getRoot();

	public GraphicsManager getManager() {
		return manager;
	}

}
