package com.example.a231;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    BackgroundTask(Context ctx){

        this.ctx=ctx;

    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url="http://10.55.7.221/register.php";

        String method=params[0];
        if (method.equals("register"))
        {


            String name=params[1];
            String rollno=params[2];
            String department=params[3];
            String longitudee=params[4];
            String latitude=params[5];


            try {
                URL url=new URL(reg_url);

                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoOutput(true);


                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
                data += "&" + URLEncoder.encode("rollno", "UTF-8") + "=" +
                        URLEncoder.encode(rollno, "UTF-8");
                data += "&" + URLEncoder.encode("department", "UTF-8") + "=" +
                        URLEncoder.encode(department, "UTF-8");
                data += "&" + URLEncoder.encode("longitudee", "UTF-8") + "=" +
                        URLEncoder.encode(String.valueOf(longitudee), "UTF-8");

                data += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" +
                        URLEncoder.encode(String.valueOf(latitude), "UTF-8");





                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                outputStream.close();

                InputStream IS=httpURLConnection.getInputStream();
                IS.close();



                return "Regiatration Sucessfully";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }



    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
