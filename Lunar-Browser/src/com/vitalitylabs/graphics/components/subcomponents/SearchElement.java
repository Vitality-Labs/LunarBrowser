package com.vitalitylabs.graphics.components.subcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.vitalitylabs.graphics.LunarColors;

public class SearchElement extends JPanel {

	private SearchbarComponent searchbarComponent;
	private JPanel parent;
	private JTextField txtInput;
	
	public SearchElement(JPanel parent, SearchbarComponent searchbarComponent) {
		this.searchbarComponent = searchbarComponent;
		this.parent = parent;
		this.setLayout(null);
		this.setSize(parent.getWidth() - 80, parent.getHeight() - 5);
		this.setLocation(42, 2);
		this.setBackground(Color.BLUE);
		
		txtInput = new JTextField();
		txtInput.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtInput.setForeground(LunarColors.text);
		txtInput.setBackground(LunarColors.clear);
		txtInput.setText("Test");
		txtInput.setBounds(0, 0, this.getWidth(), this.getHeight());
		txtInput.setBorder(null);
		txtInput.setColumns(10);
		txtInput.setCaretColor(LunarColors.caret);
		txtInput.setSelectionColor(LunarColors.main);
		txtInput.setSelectedTextColor(LunarColors.text);
		txtInput.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					parseText();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		txtInput.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				searchbarComponent.setHovering(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				searchbarComponent.setHovering(false);
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
		add(txtInput);
	}
	
	public void parseText() {
		System.out.println("URL: " + txtInput.getText());
		
		if (txtInput.getText().substring(0, 5).equalsIgnoreCase("https")) {
			searchbarComponent.getSecurityComponent().isSecure();
		} else {
			searchbarComponent.getSecurityComponent().isUnsecure();
		}
	}

	public void tick() {
		this.setSize(parent.getWidth() - 80, parent.getHeight() - 5);
		
		if (txtInput != null)
			txtInput.setBounds(0, 0, this.getWidth(), this.getHeight());
	}
}
