package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.TabContainer;

public class NewTabButton extends JPanel {

	private static final long serialVersionUID = 318651032531116954L;
	private TabContainer tabContainer;
	private int xPos;
	private JLabel buttonIcon;
	private boolean isHover;
	
	public NewTabButton(TabContainer tabContainer) {
		this.tabContainer = tabContainer;
		this.setLayout(null);
		this.setSize(40, 40);
		setX();
		this.setLocation(xPos, 0);
		this.setBackground(LunarColors.clear);
		this.setBorder(new LineBorder(LunarColors.background_main, 1));
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabContainer.getManager().l.openTab();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				isHover = false;
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if (buttonIcon != null) {
					buttonIcon.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (buttonIcon != null) {
					buttonIcon.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
				}
			}
			
		});
		
		buttonIcon = new JLabel("+");
		buttonIcon.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		buttonIcon.setHorizontalAlignment(SwingConstants.CENTER);
		buttonIcon.setBounds(0, 0, 40, 38);
		buttonIcon.setForeground(LunarColors.text);
		add(buttonIcon);
	}
	
	public void setX() {
		xPos = 40;
		for (int i = 0; i < tabContainer.getTabElements().size(); i++) {
			xPos += tabContainer.getTabElements().get(i).getRoot().getWidth();
		}
	}
	
	public void tick() {
		setX();
		
		if (isHover) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.setBackground(LunarColors.hover);
		} else {
			this.setCursor(Cursor.getDefaultCursor());
			this.setBackground(LunarColors.clear);
		}
	}
}
