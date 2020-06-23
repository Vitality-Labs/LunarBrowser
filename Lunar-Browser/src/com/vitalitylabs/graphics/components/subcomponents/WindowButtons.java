package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.vitalitylabs.graphics.ImageResizer;
import com.vitalitylabs.graphics.LunarColors;
import com.vitalitylabs.graphics.components.TabContainer;

public class WindowButtons extends JPanel {

	private static final long serialVersionUID = 6477488708508006652L;
	private TabContainer tb;
	private boolean isHover;

	public WindowButtons(TabContainer tb) {
		this.tb = tb;
		this.setLayout(null);
		this.setSize(120, 40);
		this.setLocation(tb.getRoot().getWidth() - 135, 0);
		this.setBackground(LunarColors.clear);
		isHover = false;

		JLabel minimizeIcon = new JLabel("");
		minimizeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/basebutton.png")).getImage(), 12, 12)));
		minimizeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeIcon.setBounds(0, 0, 40, 40);
		minimizeIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tb.getManager().getFrame().setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				minimizeIcon.setIcon(new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/minbutton.png")));
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				minimizeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
						new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/basebutton.png")).getImage(), 12, 12)));
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
		add(minimizeIcon);

		JLabel maximizeIcon = new JLabel("");
		maximizeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/basebutton.png")).getImage(), 12, 12)));
		maximizeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		maximizeIcon.setBounds(40, 0, 40, 40);
		maximizeIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tb.getManager().toggleMax();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				maximizeIcon.setIcon(new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/maxbutton.png")));
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				maximizeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
						new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/basebutton.png")).getImage(), 12, 12)));
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
		add(maximizeIcon);

		JLabel closeIcon = new JLabel("");
		closeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/basebutton.png")).getImage(), 12, 12)));
		closeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		closeIcon.setBounds(80, 0, 40, 40);
		closeIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				tb.getManager().closeApp();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				closeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
						new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/closebutton.png")).getImage(), 14, 14)));
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				closeIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
						new ImageIcon(WindowButtons.class.getResource("/lib/windowicons/basebutton.png")).getImage(), 12, 12)));
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
		add(closeIcon);
	}

	public void tick() {

		if (isHover) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			this.setCursor(Cursor.getDefaultCursor());
		}

		this.setLocation(tb.getRoot().getWidth() - 135, 0);
	}

}
