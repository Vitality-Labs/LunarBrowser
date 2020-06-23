package com.vitalitylabs.graphics.components;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.vitalitylabs.graphics.GraphicsElement;
import com.vitalitylabs.graphics.GraphicsManager;
import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.subcomponents.LogoArea;
import com.vitalitylabs.graphics.components.subcomponents.WindowButtons;
import com.vitalitylabs.graphics.tabs.Tab;

public class TabContainer extends GraphicsElement {

	private JPanel panel;
	private JPanel textArea;
	private WindowButtons wb;
	private ArrayList<Tab> openTabs = new ArrayList<Tab>();
	
	public TabContainer(GraphicsManager manager) {
		super(manager);
	}

	@Override
	public void initialize() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 0);
		panel.setSize(manager.getFrame().getWidth(), 40);
		panel.setBackground(LunarColors.background_dark);
		
		textArea = new LogoArea();
		panel.add(textArea);
		
		wb = new WindowButtons(this);
		panel.add(wb);
	}

	@Override
	public void tick() {
		if (panel != null) {
			panel.setSize(manager.getFrame().getWidth(), 40);
		}
		
		if (wb != null)
			wb.tick();
	}

	@Override
	public JPanel getRoot() {
		return panel;
	}

}
