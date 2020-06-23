package com.vitalitylabs.graphics.components;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.vitalitylabs.graphics.GraphicsElement;
import com.vitalitylabs.graphics.GraphicsManager;
import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.subcomponents.PageMoveContainer;
import com.vitalitylabs.graphics.components.subcomponents.SearchbarComponent;
import com.vitalitylabs.graphics.components.subcomponents.SettingsComponent;

public class SearchContainer extends GraphicsElement {
	
	private JPanel panel;
	private PageMoveContainer pageMoveContainer;
	private SettingsComponent settingsComponent;
	private SearchbarComponent searchbarComponent;

	public SearchContainer(GraphicsManager manager) {
		super(manager);
	}

	@Override
	public void initialize() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0, 40);
		panel.setSize(manager.getFrame().getWidth(), 40);
		panel.setBackground(LunarColors.background_main);
		panel.setBorder(new LineBorder(LunarColors.background_dark, 1, false));
		
		pageMoveContainer = new PageMoveContainer(this);
		panel.add(pageMoveContainer);
		
		settingsComponent = new SettingsComponent(this);
		panel.add(settingsComponent);
		
		searchbarComponent = new SearchbarComponent(this);
		panel.add(searchbarComponent);
	}

	@Override
	public void tick() {
		if (panel != null) {
			panel.setSize(manager.getFrame().getWidth(), 40);
		}
		
		if (pageMoveContainer != null)
			pageMoveContainer.tick();
		
		if (settingsComponent != null)
			settingsComponent.tick();
		
		if (searchbarComponent != null)
			searchbarComponent.tick();
	}

	@Override
	public JPanel getRoot() {
		return panel;
	}

	public PageMoveContainer getPageMoveContainer() {
		return pageMoveContainer;
	}

	public SettingsComponent getSettingsComponent() {
		return settingsComponent;
	}

	public SearchbarComponent getSearchbarComponent() {
		return searchbarComponent;
	}

}
