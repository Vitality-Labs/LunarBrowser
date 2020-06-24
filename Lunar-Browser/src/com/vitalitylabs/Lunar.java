package com.vitalitylabs;

import org.cef.CefApp;

import com.vitalitylabs.graphics.GraphicsManager;
import com.vitalitylabs.systemclock.SystemClock;
import com.vitalitylabs.tabs.TabManager;

public class Lunar {
	
	private CefApp cefApp = CefApp.getInstance(); 
	private SystemClock clock;
	private GraphicsManager graphicsManager;
	private TabManager tabManager;
	public static boolean devMode = true;
	private String defaultURL = "https://www.google.com/";

	public static void main(String[] args) {
		String arg = null;
		
		if (args.length >= 1) {
			arg = args[0];
		}
		
		new Lunar(arg);
	}

	public Lunar(String arg) {
		clock = new SystemClock(this);
		graphicsManager = new GraphicsManager(this);
		graphicsManager.initialize();
		
		clock.startClock();
	}
	
	public void openTab() {
		if (tabManager != null)
			tabManager.openNewTab();
	}
	
	public void tick() {
		if (graphicsManager != null)
			graphicsManager.tick();
	}

	public CefApp getCefApp() {
		return cefApp;
	}

	public SystemClock getClock() {
		return clock;
	}

	public GraphicsManager getGraphicsManager() {
		return graphicsManager;
	}

	public String getDefaultURL() {
		return defaultURL;
	}

	public TabManager getTabManager() {
		return tabManager;
	}
	
}
