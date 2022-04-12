package com.example.myresume.api;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ApiConnection extends AsyncTask <String, Void, String>{
    private Context context;
    private String url;
    Stuff stuff;


    public ApiConnection(Context context, String url, Stuff stuff) {
        this.context = context;
        this.url = url;
        this.stuff = stuff;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        stuff.onPreExe();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("content-type", "application/json");
            connection.setRequestProperty("accept", "application/json");
            connection.setReadTimeout(10000);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            String json = stuff.backgroundSetup();
            writer.write(json);
            writer.flush();
            writer.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String str;
            String result = "";
            while ((str = bufferedReader.readLine()) != null) {
                result += str;
            }
            return result;
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null){
            stuff.onPostExe(s);
        } else {
            Toast.makeText(context, "لطفا از ارتباط اینترنت اطمینان حاصل فرمایید!", Toast.LENGTH_SHORT).show();
        }
    }

    public interface Stuff {
        String backgroundSetup ();
        void onPreExe();
        void onPostExe (String s);
    }

}
