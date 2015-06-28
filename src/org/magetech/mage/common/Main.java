package org.magetech.mage.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.magetech.mage.config.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * config file builder for creating a update information config
 * @author Isaac Wheeler
 * @version Jun 28, 2015
 * CopyRight: 2015 Isaac Wheeler All Rights Reserved
 */
public class Main {

	/**
	 * quick and dirty impltation of the Gson config building
	 * @param args version number and location
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if(args.length != 2){
			System.err.println("The config Builder is missing argments, or has to many argments");
			System.exit(1);
		}
		
		File config = new File("UpdateInfo.json");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		if (!config.exists()) {
			config.createNewFile();
			config configJson = new config(args[0], args[1]);
			String json = gson.toJson(configJson);
			PrintWriter out = new PrintWriter(config);
			out.write(json);
			out.flush();
			out.close();

		} else {
			config.delete();
			config.createNewFile();
			config configJson = new config(args[0], args[1]);
			String json = gson.toJson(configJson);
			PrintWriter out = new PrintWriter(config);
			out.write(json);
			out.flush();
			out.close();
		}
	}

}
