package com.vitalitylabs.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.vitalitylabs.Lunar;
import com.vitalitylabs.graphics.components.BrowserContent;
import com.vitalitylabs.graphics.components.SearchContainer;
import com.vitalitylabs.graphics.components.TabContainer;

public class GraphicsManager {

	public Lunar l;
	public Lunar getLunar() {
		return l;
	}
	
	private JFrame frame = new JFrame("Lunar Browser");
	private ComponentResizer componentResizer;
	private ComponentMover componentMover;
	
	// GUI Compnents
	
	private TabContainer tabContainer;
	private SearchContainer searchContainer;
	private BrowserContent browserContent;
	
	private boolean isMaximized;
	private Dimension lastSize;
	private int lastX, lastY;
	
	public GraphicsManager(Lunar l) {
		this.l = l;
	}
	
	public void initialize() {
		componentResizer = new ComponentResizer();
		componentMover = new ComponentMover();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {
				closeApp();
			}

			@Override
			public void windowClosing(WindowEvent arg0) {}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}

			@Override
			public void windowOpened(WindowEvent arg0) {}
			
		});
		frame.setLayout(null);
		frame.setSize(1280, 720);
		frame.getContentPane().setBackground(LunarColors.background_main);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GraphicsManager.class.getResource("/lib/Icon.png")));
		frame.setMinimumSize(new Dimension(400, 120));
		if (!Lunar.devMode)
			frame.setUndecorated(true);
		frame.setResizable(true);
		frame.setVisible(true);
		
		tabContainer = new TabContainer(this);
		tabContainer.initialize();
		frame.add(tabContainer.getRoot());
		
		searchContainer = new SearchContainer(this);
		searchContainer.initialize();
		frame.add(searchContainer.getRoot());
		
		browserContent = new BrowserContent(this);
		browserContent.initialize();
		frame.add(browserContent.getRoot());
		
		componentMover.setDraggableRegion(0, 0, frame.getWidth(), 40);
		componentMover.registerComponent(frame);
		componentResizer.registerComponent(frame);
		toggleMax();
	}
	
	public void closeApp() {
		frame.dispose();
		System.exit(0);
	}
	
	public void toggleMax() {
		if (!isMaximized) {
			lastX = frame.getX();
			lastY = frame.getY();
			lastSize = frame.getSize();
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			isMaximized = true;
		} else {
			frame.setSize(lastSize);
			frame.setLocation(lastX, lastY);
			isMaximized = false;
		}
	}
	
	public void tick() {
		if (frame != null)
			frame.repaint();
		
		if (tabContainer != null)
			tabContainer.tick();
		
		if (searchContainer != null)
			searchContainer.tick();
		
		if (browserContent != null)
			browserContent.tick();
	}

	public JFrame getFrame() {
		return frame;
	}

	public TabContainer getTabContainer() {
		return tabContainer;
	}

	public SearchContainer getSearchContainer() {
		return searchContainer;
	}

	public BrowserContent getBrowserContent() {
		return browserContent;
	}

	public boolean isMaximized() {
		return isMaximized;
	}

	public void setMaximized(boolean isMaximized) {
		this.isMaximized = isMaximized;
	}
	
}
