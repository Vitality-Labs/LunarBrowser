package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Color;

import javax.swing.JPanel;

import com.vitalitylabs.graphics.ImageResizer;
import com.vitalitylabs.graphics.LunarColors;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SecurityComponent extends JPanel {

	private JPanel parent;
	/**
	 * @wbp.nonvisual location=90,-21
	 */
	private final JSeparator separator = new JSeparator();
	private JLabel lockIcon;

	public SecurityComponent(JPanel parent) {
		this.parent = parent;
		this.setLayout(null);
		this.setLocation(2, 2);
		this.setSize(40, 28 - 4); // parent.getHeight()
		this.setBackground(LunarColors.clear);

		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setSize(1, this.getHeight() - 4);
		separator.setLocation(this.getWidth() - 4, 2);
		separator.setForeground(LunarColors.background_light);
		separator.setBackground(LunarColors.background_light);
		this.add(separator);

		lockIcon = new JLabel("");
		lockIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(SecurityComponent.class.getResource("/lib/searchareaicons/http-unsecure-icon.png"))
						.getImage(),
				14, 14)));
		lockIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lockIcon.setBounds(7, 1, 22, 22);
		lockIcon.setToolTipText("Unsecure connection.");
		add(lockIcon);
	}
	
	public void isUnsecure() {
		lockIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(SecurityComponent.class.getResource("/lib/searchareaicons/http-unsecure-icon.png"))
						.getImage(),
				14, 14)));
		lockIcon.setToolTipText("Unsecure connection.");
	}
	
	public void isSecure() {
		lockIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(SecurityComponent.class.getResource("/lib/searchareaicons/https-secure-icon.png"))
						.getImage(),
				14, 14)));
		lockIcon.setToolTipText("Secure connection.");
	}

	public void tick() {

	}

}
