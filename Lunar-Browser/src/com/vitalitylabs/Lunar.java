package com.vitalitylabs;

import com.vitalitylabs.graphics.GraphicsManager;
import com.vitalitylabs.systemclock.SystemClock;

public class Lunar {
	
	private SystemClock clock;
	private GraphicsManager graphicsManager;
	public static boolean devMode = true;

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
	
	public void tick() {
		if (graphicsManager != null)
			graphicsManager.tick();
	}
	
}
