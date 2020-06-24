package com.vitalitylabs.tabs;

import java.util.ArrayList;

import com.vitalitylabs.Lunar;
import com.vitalitylabs.tabs.Tab;

public class TabManager {
	
	public Lunar lunar;
	private ArrayList<Tab> openTabs = new ArrayList<Tab>();
	
	public TabManager(Lunar l) {
		this.lunar = l;
	}
	
	public void openNewTab() {
		openTabs.add(new Tab(this, openTabs.size()));
	}
	
	public void openNewTab(String url) {
		openTabs.add(new Tab(this, url, openTabs.size()));
	}

}
