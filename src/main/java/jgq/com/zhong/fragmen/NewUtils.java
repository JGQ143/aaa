package jgq.com.zhong.fragmen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

class NewUtils {

    public static String getjson(String baseUrl) {

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(baseUrl);


        try {
            HttpResponse response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200){
                HttpEntity entity = response.getEntity();

                String s = EntityUtils.toString(entity);

                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseUrl;
    }

    public static boolean isCoon(Context context) {

        boolean available=false;


        ConnectivityManager connmanager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connmanager.getActiveNetworkInfo();

        if (networkInfo!=null){
             available = connmanager.getActiveNetworkInfo().isAvailable();
        }
        return available;
    }
}
