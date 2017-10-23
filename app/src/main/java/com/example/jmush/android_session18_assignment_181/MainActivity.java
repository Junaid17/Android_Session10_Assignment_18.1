package com.example.jmush.android_session18_assignment_181;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    //Create Broadcast Receiver Object along with class definition
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            //Find textview control created in main.xml
            TextView tv = (TextView) findViewById(R.id.textView);
            //Set TextView with text
            tv.setText("Battery Level: " + Integer.toString(level) + "%");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Register the receiver which triggers event
        //when battery charge is changed
        registerReceiver(broadcastReceiver, new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED));

    }
}
