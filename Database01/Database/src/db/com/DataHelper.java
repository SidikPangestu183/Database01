package db.com;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "mahasiswa.db";
	private static final int DATABASE_VERSION = 1;
	
	public DataHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE mahasiswa(nirm integer primary key, "
				+ "nama text null, tgl text null, jk text null, jurusan text null);";
		Log.d("Data", "onCreate: " + sql);
		db.execSQL(sql);
		
		sql = "INSERT INTO mahasiswa(nirm, nama, tgl, jk, jurusan) VALUES ('1001', "
				+ "'Sule', '1994-20-11', ' Laki-laki', 'Sistem Informasi');";
		db.execSQL(sql);
		
		sql = "INSERT INTO mahasiswa(nirm, nama, tgl, jk, jurusan) VALUES ('1002', "
				+ "'Andre', '1995-04-03', ' Laki-laki', 'Sistem Komputer');";
		db.execSQL(sql);
		
		sql = "INSERT INTO mahasiswa(nirm, nama, tgl, jk, jurusan) VALUES ('1003', "
				+ "'Parto', '1994-23-10', ' Laki-laki', 'Manajemen Informatika');";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
