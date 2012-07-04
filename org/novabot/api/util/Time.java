package org.novabot.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Basic Time class.
 * @version 0.1
 * @author Tanner, Motheen
 */
public class Time {

	/**
	 * Sleeps the script for a specified ammount of time (in milliseconds)
	 * @param millis The time to sleep
	 */
	public static void sleep(final int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Sleeps a random amount of time between min and max
	 * @param min The minimum amount of time
	 * @param max The maximum amount of time
	 */
	public static void sleep(final int min, final int max) {
		sleep(Random.random(min, max));
	}
	
	/**
	 * Gets the systems time.
	 * @return Current Time in Milliseconds
	 */
	public static long getTime(){
		return System.currentTimeMillis();
	}
	
	/**
	 * Converts milliseconds to readable time in a string.
	 * @param ms The time in milliseconds
	 * @return String
	 */
	public static String toString(final Long ms){
		long s = ms/1000;
		long sec = s % 60;
		long min = (s % 3600) / 60;
		long hrs = s / 3600;
		
		return hrs + ":" + min + ":" + sec;
	}
	
}
