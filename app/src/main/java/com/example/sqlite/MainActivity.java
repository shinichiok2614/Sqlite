package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonCreateDatabase, buttonDeleteDatabase, buttonCreateTable, buttonDeleteTable, buttonInsertRow,
            buttonDeleteRow, buttonUpdateRow, buttonQueryingData, buttonInsertStudent, buttonQueryingSinhvien,
            buttonView;
    EditText editTextDeleteTable, editTextInsertStudent;
    DatabaseHandler a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCreateDatabase = (Button) findViewById(R.id.buttonCreateDatabase);
        buttonDeleteTable = (Button) findViewById(R.id.buttonDeleteTable);
        buttonDeleteDatabase = (Button) findViewById(R.id.buttonDeleteDatabase);
        buttonCreateTable = (Button) findViewById(R.id.buttonCreateTable);
        buttonInsertRow = (Button) findViewById(R.id.buttonInsertRow);
        buttonDeleteRow = (Button) findViewById(R.id.buttonDeleteRow);
        buttonUpdateRow = (Button) findViewById(R.id.buttonUpdateRow);
        buttonQueryingData = (Button) findViewById(R.id.buttonQueryingData);
        buttonInsertStudent = (Button) findViewById(R.id.buttonInsertStudent);
        buttonQueryingSinhvien = (Button) findViewById(R.id.buttonQueryingSinhvien);
        buttonView = (Button) findViewById(R.id.buttonView);
        buttonCreateDatabase.setOnClickListener(this);
        buttonView.setOnClickListener(this);
        buttonInsertStudent.setOnClickListener(this);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Student student = new Student("John", "123 Main st", "1234231415");
        databaseHandler.addStudent(student);
        Student getStudent = databaseHandler.getStudent(1);
//        Log.i("student", getStudent.getId()+getStudent.getName());
//        Log.i("student", "getStudent: " + getStudent.getName());
//        databaseHandler.deleteStudent(1);
//        Log.i("student", "deleteStudent: " + getStudent.getName());
//        Student student1 = new Student(1,"Evans", "1234", "442514");
//        databaseHandler.updateStudent(student1);
//        Log.i("student", "updateStudent: " + getStudent.getName());
//        databaseHandler.getAllStudent();
//        List<Student> list = databaseHandler.getAllStudent();
//        for (Student i : list) {
//            Log.i("student", "getAllStudent: " + i.getId() + " " + i.getName() + " " + i.getAddress() + " " + i.getPhone_number());
//        }
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.buttonCreateDatabase) {
//            Log.i("list", "button create database");
//            a = new DatabaseHandler(this);
//            a.onCreate(a.getWritableDatabase());
//        }
////        if (v.getId() == R.id.buttonCreateTable) {
////            a.onCreate(a.getWritableDatabase());
////        }
//        if (v.getId() == R.id.buttonInsertStudent) {
//            Student student = new Student("John", "123 main st", "2342`");
//            a.addStudent(student);
//        }
//        if (v.getId() == R.id.buttonView) {
////a.getAllStudents();
//            List<Student> students = a.getAllStudents();
//            students.forEach(a -> Log.i("list", a.toString()));
//
//        }
    }
}
