package com.db01;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Database01Activity extends Activity {
    /** Called when the activity is first created. */
    
	String[] daftar;
	ListView lvData;
	Cursor cursor;
	DataHelper dbCenter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dbCenter = new DataHelper (this);
        RefreshList();
        
    }
	public void RefreshList () {
		SQLiteDatabase db = dbCenter.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FROM mahasiswa", null);
		daftar = new String[cursor.getCount()];
		cursor.moveToFirst();
		
		for (int i = 0; i < cursor.getCount ();i++) {
			cursor.moveToPosition(i);
			daftar[i] = cursor.getString(1).toString();
			
		}
		
		lvData = (ListView) findViewById(R.id.listView1);
		lvData.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,daftar));
		
	}
}