package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.vitalitylabs.graphics.ImageResizer;
import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.SearchContainer;

public class SettingsComponent extends JPanel {

	private static final long serialVersionUID = -3127170925162005517L;
	private SearchContainer searchContainer;
	private JLabel settingsIcon;
	private boolean isHover;

	public SettingsComponent(SearchContainer searchContainer) {
		this.searchContainer = searchContainer;
		this.setLayout(null);
		this.setSize(40, 40);
		this.setLocation(searchContainer.getRoot().getWidth() - 55, 0);
		this.setBackground(LunarColors.clear);
		isHover = false;

		settingsIcon = new JLabel("");
		settingsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		settingsIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(SettingsComponent.class.getResource("/lib/searchareaicons/dots.png")).getImage(), 24,
				24)));
		settingsIcon.setBounds(0, 0, 40, 40);
		settingsIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				settingsIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
						new ImageIcon(SettingsComponent.class.getResource("/lib/searchareaicons/dots-hover.png")).getImage(), 24,
						24)));
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				settingsIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
						new ImageIcon(SettingsComponent.class.getResource("/lib/searchareaicons/dots.png")).getImage(), 24,
						24)));
				isHover = false;
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		add(settingsIcon);
	}

	public void tick() {
		this.setLocation(searchContainer.getRoot().getWidth() - 55, 0);
		
		if (isHover) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			this.setCursor(Cursor.getDefaultCursor());
		}
	}

}
