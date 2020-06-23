package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Component;

import javax.swing.JPanel;

import com.vitalitylabs.graphics.GraphicsElement;
import com.vitalitylabs.graphics.GraphicsManager;

public class TabElement extends GraphicsElement {

	private String URL;
	private JPanel panel;
	
	public TabElement(GraphicsManager manager, String URL) {
		super(manager);
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public Component getRoot() {
		return null;
	}

}
