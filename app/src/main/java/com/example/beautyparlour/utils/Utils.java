package com.example.beautyparlour.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Locale;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Utils {
    private static final Utils ourInstance = new Utils();
    private static RequestQueue requestQueue;
    private static Gson gson;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences userInfo;
    //private static Context mContext;

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    public static void initialize(Context context) {
        //mContext = context;
        try {
            final SSLContext ctx = SSLContext.getInstance(
                    "TLS");
            final X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(final X509Certificate[] xcs, final String string) throws CertificateException {
// do nothing
                }

                @Override
                public void checkServerTrusted(final X509Certificate[] xcs, final String string) throws CertificateException {
// do nothing
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLContext.setDefault(ctx);
            requestQueue = Volley.newRequestQueue(context, new HurlStack(null, ctx.getSocketFactory()));
        } catch (final Exception ex) {
            requestQueue = Volley.newRequestQueue(context);
            ex.printStackTrace();
        }
        gson = new Gson();
        userInfo = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
        sharedPreferences = context.getSharedPreferences("oyebooks", Context.MODE_PRIVATE);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public Gson getGson() {
        return gson;
    }

    public void addRequest(Request request) {
        request.setTag(Constants.TAG);
        request.setShouldCache(false);
        request.setRetryPolicy(new DefaultRetryPolicy(Constants.TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestQueue.getCache().clear();
        requestQueue.add(request);
    }


    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(Constants.LOGGED_IN, false);
    }

    public void setLoggedIn(boolean loggedIn) {
        sharedPreferences.edit()
                .putBoolean(Constants.LOGGED_IN, loggedIn)
                .apply();
    }

    public void setEmail(String email) {
        sharedPreferences.edit()
                .putString(Constants.EMAIL, email)
                .apply();
    }

    public String getEmail() {
        return sharedPreferences.getString(Constants.EMAIL, null);
    }

    public void logout() {
        sharedPreferences.edit().clear().apply();
        userInfo.edit().clear().apply();
    }

    public void setPhone(String phone) {
        userInfo.edit()
                .putString(Constants.USER_PHONE, phone)
                .apply();
    }

    public void setName(String name) {
        userInfo.edit()
                .putString(Constants.USER_NAME, name)
                .apply();
    }

    public String getName() {
        return userInfo.getString(Constants.USER_NAME, null);
    }

    public String getPhone() {
        return userInfo.getString(Constants.USER_PHONE, null);
    }

    public void setPhoto(String name) {
        userInfo.edit()
                .putString(Constants.USER_PIC, name)
                .apply();
    }

    public String getPhoto() {
        return userInfo.getString(Constants.USER_PIC, null);
    }

    public void setId(String name) {
        userInfo.edit()
                .putString(Constants.USER_ID, name)
                .apply();
    }

    public String getId() {
        return userInfo.getString(Constants.USER_ID, null);
    }

    public static String getFormatted(String date) {
        String parts[] = date.split("-");
        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        //return String.format(Locale.getDefault(), "%s %s, %s", parts[2], month[Integer.parseInt(parts[1]) - 1], parts[0]);
        try {
            return String.format(Locale.getDefault(), "%s %s, %s", parts[2], month[Integer.parseInt(parts[1]) - 1], parts[0]);
        } catch (Exception e) {
            return date;
        }
    }
}

