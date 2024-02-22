package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentDB";
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT,"
                + COLUMN_ADDRESS + " TEXT," + COLUMN_PHONE_NUMBER + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ADDRESS, student.getAddress());
        values.put(COLUMN_PHONE_NUMBER, student.getPhone_number());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Student getStudent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID,
                        COLUMN_NAME, COLUMN_ADDRESS, COLUMN_PHONE_NUMBER}, COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Student student = new Student(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        cursor.close();
        return student;
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery(selectQuery, null);
        if (cr.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cr.getString(0)));
                student.setName(cr.getString(1));
                student.setAddress(cr.getString(2));
                student.setPhone_number(cr.getString(3));
            } while (cr.moveToNext());
        }
        cr.close();
        return students;
    }

    public void updateStudent(Student student) {
        Log.i("student", "databaseHandler.update: " + student.getId());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ADDRESS, student.getAddress());
        values.put(COLUMN_PHONE_NUMBER, student.getPhone_number());
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(student.getId())});
        db.close();
    }

//    public void deleteStudent(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(student.getId())});
//        db.close();
//    }
//    public void deleteStudent(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(id)});
//        db.close();
//    }
}


//package com.example.sqlite;
//
//import static android.content.Context.MODE_PRIVATE;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHandler extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "QuanlySinhVien";
//    private static final int DATABASE_VERSION = 1;
//    private static final String TABLE_NAME = "tblsinhvien";
//    private static final String KEY_ID = "id";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_ADDRESS = "address";
//    private static final String KEY_PHONE_NUMBER = "phone_number";
////public void createDatabase() {
////    SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
////}
//    public DatabaseHandler(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db = SQLiteDatabase.openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//        String create_student_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_PHONE_NUMBER);
//        db.execSQL(create_student_table);
//        Log.i("list", "create table");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String drop_student_table = String.format("DROP TABLE IF EXIST %s", TABLE_NAME);
//        db.execSQL(drop_student_table);
//
//        onCreate(db);
//    }
//
//    public void addStudent(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, student.getName());
//        values.put(KEY_ADDRESS, student.getAddress());
//        values.put(KEY_PHONE_NUMBER, student.getPhone_number());
//        db.insert(TABLE_NAME, null, values);
//        Log.i("list", "add Student");
//        db.close();
//    }
//
//    public Student getStudent(int studentId) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + "=?", new String[]{String.valueOf(studentId)}, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        Student student = new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
//        return student;
//    }
//
//    public List<Student> getAllStudents() {
//        List<Student> list = new ArrayList<>();
//        String query = "SELECT * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        cursor.moveToFirst();
//        while (cursor.isAfterLast() == false) {
//            Student student = new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
//            list.add(student);
//            cursor.moveToNext();
//        }
//        Log.i("list", "getAllStudent");
//        return list;
//    }
//}
//
////import android.content.Context;
////        import android.database.sqlite.SQLiteDatabase;
////        import android.database.sqlite.SQLiteOpenHelper;
////
