package com.example.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.entity.Entity;

public class DBContext {

	private DBHelper dbHelper;

	public DBContext(Context context) {
		dbHelper = new DBHelper(context, "gis.db", null, 1);
	}

	public void delete_a() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_a", null, null);
		Log.i("tag", "delete ok");
	}
	public void delete_b() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_b", null, null);
		Log.i("tag", "delete ok");
	}
	public void delete_c() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_c", null, null);
		Log.i("tag", "delete ok");
	}
	public void delete_d() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_d", null, null);
		Log.i("tag", "delete ok");
	}
	public void delete_e() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_e", null, null);
		Log.i("tag", "delete ok");
	}
	public void delete_f() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_f", null, null);
		Log.i("tag", "delete ok");
	}
	public void delete_g() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("weather_g", null, null);
		Log.i("tag", "delete ok");
	}

	public Cursor query_a(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_a where city=?";
		return db.rawQuery(sql, new String[] { city });
	}
	public Cursor query_b(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_b where city=?";
		return db.rawQuery(sql, new String[] { city });
	}
	public Cursor query_c(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_c where city=?";
		return db.rawQuery(sql, new String[] { city });
	}
	public Cursor query_d(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_d where city=?";
		return db.rawQuery(sql, new String[] { city });
	}
	public Cursor query_e(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_e where city=?";
		return db.rawQuery(sql, new String[] { city });
	}
	public Cursor query_f(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_f where city=?";
		return db.rawQuery(sql, new String[] { city });
	}
	public Cursor query_g(String city) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_g where city=?";
		return db.rawQuery(sql, new String[] { city });
	}

	public Cursor query_a() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_a ";
		return db.rawQuery(sql, null);
	}
	
	public Cursor query_b() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_b ";
		return db.rawQuery(sql, null);
	}
	public Cursor query_c() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_c ";
		return db.rawQuery(sql, null);
	}
	public Cursor query_d() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_d ";
		return db.rawQuery(sql, null);
	}
	public Cursor query_e() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_e ";
		return db.rawQuery(sql, null);
	}
	public Cursor query_f() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_f ";
		return db.rawQuery(sql, null);
	}
	public Cursor query_g() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "select _id,city,jun,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec,avg "
				+ "from weather_g ";
		return db.rawQuery(sql, null);
	}

	public void insert_a(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		// Log.i("tag", entity.getCity());
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_a", null, values);
	}
	public void insert_b(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_b", null, values);
	}
	public void insert_c(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_c", null, values);
	}
	public void insert_d(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_d", null, values);
	}
	public void insert_e(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_e", null, values);
	}
	public void insert_f(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_f", null, values);
	}
	public void insert_g(Entity entity) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("city", entity.getCity());
		values.put("jun", entity.getM1());
		values.put("feb", entity.getM2());
		values.put("mar", entity.getM3());
		values.put("apr", entity.getM4());
		values.put("may", entity.getM5());
		values.put("june", entity.getM6());
		values.put("july", entity.getM7());
		values.put("aug", entity.getM8());
		values.put("sep", entity.getM9());
		values.put("oct", entity.getM10());
		values.put("nov", entity.getM11());
		values.put("dec", entity.getM12());
		values.put("avg", entity.getYear());
		db.insert("weather_g", null, values);
	}

	class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String sql_a = "create table if not exists weather_a ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_a);
			String sql_b = "create table if not exists weather_b ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_b);
			String sql_c = "create table if not exists weather_c ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_c);
			String sql_d = "create table if not exists weather_d ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_d);
			String sql_e = "create table if not exists weather_e ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_e);
			String sql_f = "create table if not exists weather_f ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_f);
			String sql_g = "create table if not exists weather_g ("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_g);
			String sql_h = "create table if not exists weather_h("
					+ "_id integer primary key autoincrement,"
					+ "city varchar(200) not null," + "jun varchar(200),"
					+ "feb varchar(200)," + "mar varchar(200),"
					+ "apr varchar(200)," + "may varchar(200),"
					+ "june varchar(200)," + "july varchar(200),"
					+ "aug varchar(200)," + "sep varchar(200),"
					+ "oct varchar(200)," + "nov varchar(200),"
					+ "dec varchar(200)," + "avg varchar(200)" + ")";
			db.execSQL(sql_h);
			Log.i("info", "create table ok");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}
}
