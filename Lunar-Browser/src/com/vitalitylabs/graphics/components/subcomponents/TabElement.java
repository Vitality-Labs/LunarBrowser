package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import com.vitalitylabs.graphics.GraphicsElement;
import com.vitalitylabs.graphics.GraphicsManager;
import com.vitalitylabs.tabs.Tab;

public class TabElement extends GraphicsElement {

	private Tab parent;
	private String URL;
	private int index;
	private JPanel panel;
	
	public TabElement(Tab parent, GraphicsManager manager, int index) {
		super(manager);
		this.parent = parent;
		this.index = index;
	}

	@Override
	public void initialize() {
		panel.setLayout(null);
		panel.setSize((int) (getManager().getTabContainer().getRoot().getWidth() * 0.1), 40);
		panel.setLocation(40 + (index * panel.getWidth()), 0);
		panel.setBackground(Color.BLUE);
		getManager().getTabContainer().addTab(this);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public Component getRoot() {
		return panel;
	}

}
