/**
 * 
 */
package com.staterkit.cloud.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author narendra.gurram@cognizant.com
 *
 */

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	/**
	 * loading all beans for this application
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		SpringApplication.run(new Object[] { Application.class }, args);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		
	}
}
