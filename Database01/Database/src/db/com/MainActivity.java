package db.com;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{
    String[] daftar;
    ListView lvData;
    Cursor cursor;
    DataHelper dbCenter;
    public static MainActivity ma;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnTambah =(Button) findViewById(R.id.button1);
        btnTambah.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent inten = new Intent(MainActivity.this, TambahData.class);
				startActivity(inten);
			}
        });
        
        ma = this;
        dbCenter = new DataHelper(this);
        RefreshList();
    }

	public void RefreshList() {
		SQLiteDatabase db = dbCenter.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FORM mahasiswa", null);
		daftar = new String[cursor.getCount()];
		
		for(int i = 0; i<cursor.getCount();i++){
			cursor.moveToFirst();
			daftar[i] = cursor.getString(1).toString();
		}
		
		lvData = (ListView) findViewById(R.id.listView1);
		lvData.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, daftar));
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}