package com.example.class4simplelist;

import static android.provider.Contacts.SettingsColumns.KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class4simplelist.model.Model;
import com.example.class4simplelist.model.Student;

import java.security.Key;

public class AddStudentActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        TextView text=findViewById(R.id.addStudent);
        EditText inputname=findViewById(R.id.new_name_et);
        EditText inputid=findViewById(R.id.new_id_tv);
        Button cancel=findViewById(R.id.cancel1);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddStudentActivity.super.onBackPressed();

            }
        });

        Button save=findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inputname.getText().toString();
                String id=inputid.getText().toString();
                boolean cb=true;
                Student student=new Student(cb,name,id);
                Model.instance.addNewStudent(student);
                //Intent intent=new Intent(AddStudentActivity.this,StudentRecyclerActivity.class);
                //startActivity(intent);
            }
        });
    }



    private void saveFromEditText(String text) {
        SharedPreferences sharedPref=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString(KEY,text);
        editor.apply();
    }

    private String getValue()
    {
        SharedPreferences sharedPref=getPreferences(Context.MODE_PRIVATE);
        String savedValue=sharedPref.getString(KEY,"");
        return savedValue;
    }
}