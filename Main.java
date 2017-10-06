//package com.capmon;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import java.util.logging.Logger;




//import RateJSONParser;


public class Main {
public final static Logger LOGGER = Logger.getLogger(Main.class .getName());
	 public static void main(String [] args ) throws IOException {
		 LOGGER.setLevel(Level.INFO);

				 FileHandler fh;

				 try{
				 	fh = new FileHandler("my.log");
				 	LOGGER.addHandler(fh);
					SimpleFormatter formatter = new SimpleFormatter();
							 	fh.setFormatter(formatter);

				 	LOGGER.info("hello");
				 }catch(Exception e){
				 	System.out.println("logger error");

				 }



	        String data;
	        int count = 10;
	        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	       // Date dateobj = new Date();

	        BufferedWriter writer = new BufferedWriter(new FileWriter("logfile.csv"));

	        //writer.write (data);


	        writer.append("Date");
	        writer.append(",");
	        writer.append("Rate");
	        writer.append(",");
	        //writer.append("Link");
	        //writer.append(",");
	        writer.append('\n');
	        while (count > 0) {

	            data = ((new RateHttpClient()).getRateData());
	           data = RateJSONParser.Rate(data);
	            Date dateobj = new Date();
							data = data.split(",")[0];




	            try {


	                //Close writer


	                //count--;
									LOGGER.info(df.format(dateobj) + "," + data);


	                writer.append(df.format(dateobj));
	                writer.append(",");
	               // writer.append(RateJSONParser.Rate(data));
	                //curent.write(RateJSONParser.Rate(data));
	             writer.append(data);
	            currentWriter(data);
	               writer.append(",");
	                writer.append('\n');
	                //writer.close();

//curent.close();

	            } catch (Exception e) {
	                e.printStackTrace();
	                //curent.close();
	                //writer.close();
	            }
	            // curent.close();
	             delay();

	           // curent.close();
	        }

	            // rate =  RateJSONParser.Rate(data);
	        writer.close();
//	        curent.close();

	            ///System.out.println(rate);
	            //System.out.println("Hello");

	            //String rateString = "10";


	       // return rateString;




	}



	public static void delay(){

		try{
		Thread.sleep(10000);
	}catch(Exception e){}

	}

	public static void currentWriter(String data)throws IOException{


		 BufferedWriter curent = new BufferedWriter(new FileWriter("current.txt"));

		try{



			 curent.write(data);

		}catch(Exception e) { curent.close();}


		curent.close();

	}

}
