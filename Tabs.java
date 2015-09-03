package app.one.wordgenerator;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.widget.TabHost.*;
import android.view.*;
public class Tabs extends Activity implements View.OnClickListener{

	TabHost th;
	TabSpec ts;
	Button tab1,tab2,tab3;
	TextView t,display;
	ArrayList<TabHost.TabSpec>list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		list = new ArrayList<TabHost.TabSpec>();
		ts=th.newTabSpec("1");
		ts.setContent(R.id.tab1);
		ts.setIndicator("tab1");
		th.addTab(ts);
		ts=th.newTabSpec("2");
		ts.setContent(R.id.tab2);
		ts.setIndicator("tab2");
		th.addTab(ts);
		ts=th.newTabSpec("3");
		ts.setContent(R.id.tab3);
		ts.setIndicator("tab3");
		th.addTab(ts);
		display = (TextView) findViewById(R.id.tvlist);
		//display.setText(list.size());
		//th.clearAllTabs();
		/*
		TabSpec t1 = th.newTabSpec("tag1");
		t1.setContent(R.id.tab1);
		t1.setIndicator("Tab1");
		th.addTab(t1);
		
		TabSpec t2 = th.newTabSpec("tag2");
		t2.setContent(R.id.tab2);
		t2.setIndicator("Tab2");
		th.addTab(t2);
		
		TabSpec t3 = th.newTabSpec("tag3");
		t3.setContent(R.id.tab3);
		t3.setIndicator("Tab3");
		th.addTab(t3);
		*/
		tab1 =(Button) findViewById(R.id.bTab1);
		tab2 =(Button) findViewById(R.id.bTab2);
		tab3 =(Button) findViewById(R.id.bTab3);
		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bTab1:
			TabSpec ourSpec = th.newTabSpec("kuchbhidoyaar");
			ourSpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					return null;
				}
			});
			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			break;
		case R.id.bTab2:
			TabSpec mySpec = th.newTabSpec("meratag");
			mySpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub
					String s="This is a new Tab.";
					t=new TextView(Tabs.this);
					t.setText(s);
					return t;
				}
			});
			mySpec.setIndicator("Add new");
			th.addTab(mySpec);
			break;
		case R.id.bTab3:
			//list.remove(list.size()-1);
			th.setCurrentTab(0);
			th.clearAllTabs();
			for(TabHost.TabSpec spec : list)
				th.addTab(spec);
			break;
		}
	}
}
