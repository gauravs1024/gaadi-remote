package com.example.gadiremote;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class sendurl extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String...urls){
        try{
            URL url=new URL(urls[0]);
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responsecode=connection.getResponseCode();
            if(responsecode== HttpsURLConnection.HTTP_OK){
                return "URL sent succesfully";
            }
            else{
                return "Failed to connect to node mcu Response code: "+responsecode;
            }
        }


        catch(IOException e){
            e.printStackTrace();
            return "Error:" +e.getMessage();
        }

    }
}
