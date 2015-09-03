package app.one.wordgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Environment;
import android.os.IBinder;
import android.text.format.DateFormat;

public class CallServiceTask extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Timer timer =new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				Intent batteryIntent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
			    int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
			    int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

			    File file=new File(Environment.getExternalStorageDirectory(), "a.txt");
			    float outValue = 50.0f;
			    if(!(level == -1 || scale == -1)){
			    	outValue = (float)level * 100.0f/ (float)scale ;
			    }
		    	try{
		        	if(!file.exists())
		        		file.createNewFile();
		        	FileWriter f = new FileWriter(file,true);
		        	BufferedWriter buffer = new BufferedWriter(f);
		        	String str = DateFormat.getTimeFormat(getApplicationContext()).format(new Date());
		        	str = str + ":" + outValue + "\n";
		        	buffer.write(str);
		        	buffer.close();
		    	} catch(IOException e){
			    	e.printStackTrace();
			    }
			}
		};
		
		timer.scheduleAtFixedRate(task, 0, 30000);
		return super.onStartCommand(intent, flags, startId);
	}
	

}	
