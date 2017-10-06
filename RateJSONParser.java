//package com.capmon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


//import org.json.JSONarray;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RateJSONParser {

    public static String Rate(String Data) throws IOException {


        JSONObject mainJson = new JSONObject(Data);
        JSONArray loadArray = mainJson.getJSONArray("loads");
        StringBuffer rateBuffer = new StringBuffer();




        try {
/*
example for writing csv file
FileWriter writer = new FileWriter("test.csv");

writer.append("ID");
writer.append(',');
writer.append("name");
writer.append(',');
...
writer.append('\n');

writer.flush();
writer.close();

 */
          //  DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

           // BufferedWriter curent = new BufferedWriter(new FileWriter("current.txt"));


           // JSONObject childObject = loadArray.getJSONObject(0);

            for(int i = 0; i < loadArray.length();i++){
                JSONObject childObject = loadArray.getJSONObject(i);
               String link = childObject.getString("link");

                long rate = childObject.getLong("rate");
               // curent.write(String.valueOf(rate));

               // Date dateobj = new Date();

                //rateBuffer.append((df.format(dateobj)));
                //rateBuffer.append(",");
               // System.out.println(df.format(dateobj));
             //rateBuffer.append(link);
                //rateBuffer.append(",");
              // rateBuffer.append(df.format(dateobj));
              //rateBuffer.append(",");
             rateBuffer.append(rate);
             rateBuffer.append(",");

             // for adding date to the time stamp

               //   rateBuffer.append(" Bytes/Second : on Link : ");
               // link = link.substring(36); /// truncating  string from to start to remove http://....

//               rateBuffer.append(link);
              //  rateBuffer.append("\r\n");





            }











        } catch (JSONException e) {

        }

        return rateBuffer.toString();
    }



}
