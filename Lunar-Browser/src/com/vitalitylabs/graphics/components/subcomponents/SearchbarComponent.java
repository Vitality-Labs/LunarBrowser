package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.SearchContainer;

public class SearchbarComponent extends JPanel {

	private static final long serialVersionUID = -1608791467241831106L;
	private SearchContainer searchContainer;
	private SearchElement searchElement;
	private SecurityComponent securityComponent;
	private JPanel contentPanel;
	private boolean isHovering;
	
	public SearchbarComponent(SearchContainer searchContainer) {
		this.searchContainer = searchContainer;
		this.setLayout(null);
		this.setSize((int) (searchContainer.getRoot().getWidth() * 0.7f), 40);
		this.setLocation((int) (searchContainer.getRoot().getWidth() * 0.18f), 0);
		this.setBackground(LunarColors.clear);
		
		contentPanel = new JPanel();
		contentPanel.setSize(this.getWidth(), 28);
		contentPanel.setLocation(0, 6);
		contentPanel.setLayout(null);
		contentPanel.setBackground(LunarColors.background_dark);
		contentPanel.setBorder(new LineBorder(LunarColors.background_light, 1, true));
		contentPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				isHovering = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				isHovering = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(contentPanel);
		
		securityComponent = new SecurityComponent(contentPanel);
		contentPanel.add(securityComponent);
		
		searchElement = new SearchElement(contentPanel, this);
		contentPanel.add(searchElement);
	}

	public void tick() {
		this.setSize((int) (searchContainer.getRoot().getWidth() * 0.7f), 40);
		this.setLocation((int) (searchContainer.getRoot().getWidth() * 0.18f), 0);
		
		if (contentPanel != null) 
			contentPanel.setSize(this.getWidth(), 28);
		
		if (searchElement != null)
			searchElement.tick();
		
		if (isHovering) {
			contentPanel.setBorder(new LineBorder(LunarColors.main, 2, true));
		} else {
			contentPanel.setBorder(new LineBorder(LunarColors.background_light, 1, true));
		}
	}

	public boolean isHovering() {
		return isHovering;
	}

	public void setHovering(boolean isHovering) {
		this.isHovering = isHovering;
	}

	public SearchContainer getSearchContainer() {
		return searchContainer;
	}

	public SearchElement getSearchElement() {
		return searchElement;
	}

	public SecurityComponent getSecurityComponent() {
		return securityComponent;
	}
	
}
