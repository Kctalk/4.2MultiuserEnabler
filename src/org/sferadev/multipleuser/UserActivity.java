package org.sferadev.multipleuser;

import java.io.DataOutputStream;
import java.io.IOException;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
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
        os.writeBytes(getExecStr());  
        os.flush();
}
																																																																																																																																																																	
    private String getExecStr(){
    	StringBuffer sb = new StringBuffer();
    	sb.append("setprop fw.max_users 7\n");
    	sb.append("mkdir -p /data/local/userinit.d\n");
    	sb.append("echo \"#!/system/bin/sh\" > /data/local/userinit.d/90multipleuser\n");
    	sb.append("echo \"setprop fw.max_user 7\" >> /data/local/userinit.d/90multipleuser\n");
    	sb.append("busybox chmod +x /data/local/userinit.d/90multipleuser\n");
    	return sb.toString();
    }
    
    public void um(View v) {
        String url = "https://play.google.com/store/apps/details?id=com.appaholics.um";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    
    public void muappshare(View v) {
        String url = "https://play.google.com/store/apps/details?id=com.fivehellions.android.muappshare";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.exit:
                finish();
                return true;
                
           case R.id.about:
   			Intent intent = new Intent(this, AboutActivity.class);
   	        this.startActivity(intent);
   	        break;
   			
   		}
        
        return false;
    }
    
}
