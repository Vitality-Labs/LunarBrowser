package com.vitalitylabs.graphics.components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import com.vitalitylabs.graphics.GraphicsElement;
import com.vitalitylabs.graphics.GraphicsManager;

public class BrowserContent extends GraphicsElement {

	private JPanel panel;
	
	public BrowserContent(GraphicsManager manager) {
		super(manager);
	}

	@Override
	public void initialize() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 80);
		panel.setSize(getManager().getFrame().getWidth(), getManager().getFrame().getContentPane().getHeight() - 80);
		panel.setBackground(Color.RED);
	}

	@Override
	public void tick() {
		if (panel != null) {
			panel.setSize(getManager().getFrame().getWidth(), getManager().getFrame().getContentPane().getHeight() - 80);
		}
	}

	@Override
	public Component getRoot() {
		return panel;
	}

}
