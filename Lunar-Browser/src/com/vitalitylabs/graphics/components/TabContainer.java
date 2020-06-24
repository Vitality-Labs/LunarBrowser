package com.vitalitylabs.graphics.components;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.vitalitylabs.graphics.GraphicsElement;
import com.vitalitylabs.graphics.GraphicsManager;
import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.subcomponents.LogoArea;
import com.vitalitylabs.graphics.components.subcomponents.NewTabButton;
import com.vitalitylabs.graphics.components.subcomponents.TabElement;
import com.vitalitylabs.graphics.components.subcomponents.WindowButtons;

public class TabContainer extends GraphicsElement {

	private JPanel panel;
	private LogoArea textArea;
	private WindowButtons wb;
	private ArrayList<TabElement> tabElements = new ArrayList<TabElement>();
	private NewTabButton newTabButton;
	public TabContainer(GraphicsManager manager) {
		super(manager);
	}

	@Override
	public void initialize() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 0);
		panel.setSize(getManager().getFrame().getWidth(), 40);
		panel.setBackground(LunarColors.background_dark);
		
		textArea = new LogoArea();
		panel.add(textArea);
		
		wb = new WindowButtons(this);
		panel.add(wb);
		
		newTabButton = new NewTabButton(this);
		panel.add(newTabButton);
	}
	
	public void addTab(TabElement te) {
		tabElements.add(te);
		panel.add(te.getRoot());
	}

	@Override
	public void tick() {
		if (panel != null) {
			panel.setSize(getManager().getFrame().getWidth(), 40);
		}
		
		if (wb != null)
			wb.tick();
		
		if (newTabButton != null)
			newTabButton.tick();
	}

	@Override
	public JPanel getRoot() {
		return panel;
	}

	public ArrayList<TabElement> getTabElements() {
		return tabElements;
	}

}
