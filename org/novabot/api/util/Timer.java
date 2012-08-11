package org.novabot.api.util;

/**
 * A simple timer class
 * @version 0.1
 * @author Tanner
 */

public class Timer {
	
	public long start;
	public long duration;
	public long end;
	
	/**
	 * Creates a new timer.
	 * @param i, the length in milliseconds for the timer to count down from.
	 */
	public Timer(int duration){
			start = System.currentTimeMillis();
			this.duration = duration;
			end = start + duration;
	}

	/**
	 * Restores the time to its original value.
	 */
	public void reset() {
		start = System.currentTimeMillis();
		end = start + duration;
	}

	/**
	 * Sets the timer's end (in milliseconds.)
	 * @param d, the new end for the timer.
	 */
	public void endIn(long duration) {
		start = System.currentTimeMillis();
		this.duration = duration;
		end = start + duration;
	}
	
	/**
	 * Checks if the time is running.
	 * @return <tt>true</tt> if the timer is running and <tt>false</tt> if it is not.
	 */
	public boolean isRunning(){
		return System.currentTimeMillis() < end;
	}
	
	/**
	 * Gets the time remaining in a timer.
	 * @return the remaining milliseconds left in the timer.
	 */
	public long getRemaining(){
		return end - System.currentTimeMillis();
	}
}