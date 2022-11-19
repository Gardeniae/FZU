package com.qxy.fzu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private EditText from;
    private TextView result;
    String TAG=getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        from=this.findViewById(R.id.from);
        submit=this.findViewById(R.id.submit);
        result=this.findViewById(R.id.result);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient  client = new OkHttpClient();


                RequestBody requestBody = new FormBody.Builder()
                        .add("string",from.getText().toString())
                        .build();
                Request request = new Request.Builder()
                        .url("https://springboot-4hhj-10621-5-1314224843.sh.run.tcloudbase.com/App/get")   //设置目标网络地址
			.post(requestBody)
                        .build();

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String  responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                result.setText(responseData);
                            }
                        });


                        Log.d(TAG, "onResponse: " + responseData);
                    }
                });


            }
        });
    }
}