package com.example.class4simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.class4simplelist.model.Model;

public class StudentDetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Intent intent=getIntent();

        String id=intent.getStringExtra("id");
        String name1=intent.getStringExtra("name");
        int  position=getIntent().getExtras().getInt("position");
        TextView text=findViewById(R.id.StudentInfo_text_v);
        TextView name=findViewById(R.id.details_name_tv);
        name.setText(name1);

        TextView id_s=findViewById(R.id.details_id_tv);
        id_s.setText(id);
        Model.instance.getStudentById(id);
        text.setText(id);

        Button buttonOne = findViewById(R.id.edit_bttn);
        buttonOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Button Clicked");
                Intent intent1 = new Intent(StudentDetailsActivity.this, EditStudentActivity.class);
                intent1.putExtra("position",position);
                startActivity(intent1);
            }
        });
    }
}