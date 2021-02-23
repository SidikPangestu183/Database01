package com.db01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "mahasiswa.db";
	private static final int DATABASE_VERSION = 1;
	
	public DataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE mahasiswa(nirm integer primary key,"
				+"nama text null, tgl text null, jk text null, jurusan text null);";
		Log.d("Data","onCreate: " + sql);
		db.execSQL(sql);
		
		sql = "INSERT INTO mahasiswa (nirm, nama, tgl, jk, jurusan) VALUES ('001' "
				+"'Sidik','1999-02-12','Laki-Laki','Sistem Informasi');";
		db.execSQL(sql);
		
		sql = "INSERT INTO mahasiswa (nirm, nama, tgl, jk, jurusan) VALUES ('002' "
				+"'Agus','2000-03-10','Laki-Laki','Sistem Informasi');";
		db.execSQL(sql);
		
		sql = "INSERT INTO mahasiswa (nirm, nama, tgl, jk, jurusan) VALUES ('003' "
				+"'Andik','2001-01-11','Laki-Laki','Sistem Komputer');";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade (SQLiteDatabase db, int arg1, int arg2) {
		
	}
	}
