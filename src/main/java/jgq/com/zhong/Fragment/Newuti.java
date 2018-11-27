package jgq.com.zhong.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Newuti {

    public static String getJson(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            int responseCode = urlConnection.getResponseCode();

            if (responseCode == 200){
                InputStream inputStream = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String temp="";

                StringBuilder stringBuilder = new StringBuilder();

                while ((temp=bufferedReader.readLine())!=null){
                    stringBuilder.append(temp);
                }

                String s = stringBuilder.toString();

                return s;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlString;
    }
}
