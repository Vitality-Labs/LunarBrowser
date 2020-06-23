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

public class PageMoveContainer extends JPanel {

	private static final long serialVersionUID = 3767378509191655269L;
	@SuppressWarnings("unused")
	private SearchContainer searchContainer;
	private JLabel backIcon;
	private JLabel refreshIcon;
	private JLabel forwardIcon;
	
	private boolean isHover;

	public PageMoveContainer(SearchContainer searchContainer) {
		this.searchContainer = searchContainer;
		this.setLayout(null);
		this.setSize(120, 40);
		this.setLocation(0, 0);
		this.setBackground(LunarColors.clear);

		backIcon = new JLabel("");
		backIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(PageMoveContainer.class.getResource("/lib/searchareaicons/backnull-icon.png")).getImage(),
				16, 16)));
		backIcon.setHorizontalAlignment(SwingConstants.CENTER);
		backIcon.setBounds(0, 0, 40, 40);
		backIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				isHover = false;
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
		add(backIcon);

		refreshIcon = new JLabel("");
		refreshIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(PageMoveContainer.class.getResource("/lib/searchareaicons/refresh-icon.png")).getImage(),
				16, 16)));
		refreshIcon.setHorizontalAlignment(SwingConstants.CENTER);
		refreshIcon.setBounds(40, 0, 40, 40);
		refreshIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				isHover = false;
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
		add(refreshIcon);

		forwardIcon = new JLabel("");
		forwardIcon.setIcon(new ImageIcon(ImageResizer.getScaledImage(
				new ImageIcon(PageMoveContainer.class.getResource("/lib/searchareaicons/forwardnull-icon.png"))
						.getImage(),
				16, 16)));
		forwardIcon.setHorizontalAlignment(SwingConstants.CENTER);
		forwardIcon.setBounds(80, 0, 40, 40);
		forwardIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				isHover = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				isHover = false;
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
		add(forwardIcon);
	}

	public void tick() {

		if (isHover) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			this.setCursor(Cursor.getDefaultCursor());
		}
		
	}

}
