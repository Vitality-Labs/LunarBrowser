package com.vitalitylabs.graphics.components.subcomponents;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.vitalitylabs.graphics.ImageResizer;
import com.vitalitylabs.graphics.LunarColors;

import javax.swing.ImageIcon;

public class LogoArea extends JPanel {
	
	private static final long serialVersionUID = -6262831889075340383L;

	public LogoArea() {
		this.setLayout(null);
		this.setSize(40, 40);
		this.setLocation(0, 0);
		this.setBackground(LunarColors.light_highlight);
		
		JLabel icon = new JLabel("");
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setIcon(new ImageIcon(ImageResizer.getScaledImage(new ImageIcon(LogoArea.class.getResource("/lib/Icon.png")).getImage(), 14, 14)));  // new ImageIcon(LogoArea.class.getResource("/lib/Icon.png"))
		icon.setBounds(0, 0, 40, 40);
		add(icon);
	}
}
