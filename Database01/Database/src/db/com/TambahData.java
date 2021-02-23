package db.com;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class TambahData extends Activity{
  protected Cursor cursor;
  DataHelper dbHelper;
  Button btnSave, btnCancel;
  EditText edtNirm, edtNama, edtTgl, edtJk, edtJurusan;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data);
        
        dbHelper = new DataHelper(this);
        
        edtNirm = (EditText) findViewById(R.id.editText1);
        edtNama = (EditText) findViewById(R.id.editText2);
        edtTgl = (EditText) findViewById(R.id.editText3);
        edtJk = (EditText) findViewById(R.id.editText4);
        edtJurusan = (EditText) findViewById(R.id.editText5);
        btnSave = (Button) findViewById(R.id.button1);
        btnCancel = (Button) findViewById(R.id.button2);
        
        btnSave.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				String sql = "INSERT INTO mahasiswa VALUES('"
						+ edtNirm.getText().toString()
						+"','"
						+ edtNama.getText().toString()
						+"','"
						+ edtTgl.getText().toString()
						+"','"
						+ edtJurusan.getText().toString() + "')";
				db.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
				MainActivity.ma.RefreshList();
				finish();
			}
        });
        
        btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
    	});
	}
}