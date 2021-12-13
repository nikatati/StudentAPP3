package com.example.class4simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class4simplelist.model.Model;
import com.example.class4simplelist.model.Student;

public class EditStudentActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Intent intent=getIntent();
        String id1=intent.getStringExtra("id");
        String name1=intent.getStringExtra("name");
        TextView text=findViewById(R.id.editStudent);
        int  position=getIntent().getExtras().getInt("position");

        Button cancel=findViewById(R.id.cancel2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditStudentActivity.super.onBackPressed();
            }
        });

        Button save=findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                EditText name=findViewById(R.id.new_name_et);
                EditText id=findViewById(R.id.new_id_tv);
                String name1=name.getText().toString();
                String id1=id.getText().toString();
                boolean cb=true;

                Student student= new Student(cb,name1,id1);
                Model.instance.editStudent(position,student);
            }
        });
    }
}