package org.sferadev.multipleuser;

import java.io.DataOutputStream;
import java.io.IOException;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class UserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void feature(View v) throws IOException {
    	Process p = Runtime.getRuntime().exec("su");
        DataOutputStream os = new DataOutputStream(p.getOutputStream());            
        os.writeBytes("setprop fw.max_users 4\n");  
        os.flush();
}

    public void um(View v) {
        String url = "https://play.google.com/store/apps/details?id=com.appaholics.um";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    
    public void post(View v) {
        String url = "http://forum.xda-developers.com/showthread.php?t=1807751";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }
    
}
