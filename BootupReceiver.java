package app.one.wordgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;

public class BootupReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context c, Intent i) {
		// TODO Auto-generated method stub
		/*IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryIntent = c.registerReceiver(null, ifilter);
		int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
		*/
	    // Error checking that probably isn't needed but I added just in case.
	    c.startService(new Intent(c,CallServiceTask.class));	
	   
	}
}
	
	

