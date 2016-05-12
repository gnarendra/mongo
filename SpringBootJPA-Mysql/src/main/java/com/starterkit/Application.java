/**
 * 
 */
package com.starterkit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ismailibrahim.s@cognizant.com
 *
 */

@SpringBootApplication
public class Application implements CommandLineRunner{

	
	/**
	 * Loading all beans for this application
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SpringApplication.run(new Object[] { Application.class }, args);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		
	}
}
