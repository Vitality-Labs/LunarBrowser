package com.vitalitylabs.systemclock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.vitalitylabs.Lunar;

public class SystemClock {

	public Lunar l;
	private Timer clock = new Timer(10, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			l.tick();
		}
		
	});
	
	public SystemClock(Lunar l) {
		this.l = l;
	}
	
	public void startClock() {
		clock.start();
	}
	
}
