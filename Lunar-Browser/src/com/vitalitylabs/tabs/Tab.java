package com.vitalitylabs.tabs;

import java.awt.Component;

import org.cef.CefClient;
import org.cef.OS;
import org.cef.browser.CefBrowser;

import com.vitalitylabs.graphics.components.subcomponents.TabElement;
import com.vitalitylabs.systemreader.SystemReader;

public class Tab {

	private TabManager tabManager;
	private TabElement tabElement;
	private CefClient client;
	private CefBrowser browser;
	private int index;
	private String currentUrl;
	
	public Tab(TabManager tabManager, int index) {
		this.tabManager = tabManager;
		this.index = index;
		this.client = tabManager.lunar.getCefApp().createClient();
		
		if (SystemReader.isWindows()) {
			this.browser = client.createBrowser(tabManager.lunar.getDefaultURL(), OS.isWindows(), false);
		} else if (SystemReader.isMac()) {
			this.browser = client.createBrowser(tabManager.lunar.getDefaultURL(), OS.isMacintosh(), false);
		} else if (SystemReader.isUnix()) {
			this.browser = client.createBrowser(tabManager.lunar.getDefaultURL(), OS.isLinux(), false);
		} else {
			System.out.println("Unsupported OS");
		}
		
		currentUrl = tabManager.lunar.getDefaultURL();
		
		initGraphics();
	}
	
	public Tab(TabManager tabManager, String url, int index) {
		this.tabManager = tabManager;
		this.index = index;
		this.client = tabManager.lunar.getCefApp().createClient();
		
		if (SystemReader.isWindows()) {
			this.browser = client.createBrowser(url, OS.isWindows(), false);
		} else if (SystemReader.isMac()) {
			this.browser = client.createBrowser(url, OS.isMacintosh(), false);
		} else if (SystemReader.isUnix()) {
			this.browser = client.createBrowser(url, OS.isLinux(), false);
		} else {
			System.out.println("Unsupported OS");
		}
		
		currentUrl = url;
		
		initGraphics();
	}
	
	public void initGraphics() {
		tabElement = new TabElement(this, tabManager.lunar.getGraphicsManager(), index);
		tabElement.initialize();
	}
	
	public Component getBrowserUI() {
		return browser.getUIComponent();
	}

	public TabManager getTabManager() {
		return tabManager;
	}

	public TabElement getTabElement() {
		return tabElement;
	}

	public int getIndex() {
		return index;
	}
}
