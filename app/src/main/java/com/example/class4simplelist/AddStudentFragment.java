package com.example.class4simplelist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.class4simplelist.model.Model;
import com.example.class4simplelist.model.Student;

import java.util.List;


public class AddStudentFragment extends Fragment
{

    List<Student> data;
    EditText EditName;
    EditText EditId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        data= Model.instance.getStudentList();
        EditName = view.findViewById(R.id.sp_name_tv);
        EditId = view.findViewById(R.id.sp_id_tv);

        Button SaveBtn = view.findViewById(R.id.add_save_btn);
        SaveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view2)
            {
                String name = EditName.getText().toString();
                String id = EditId.getText().toString();
                boolean cb= false;
                Student StudentNew =new Student(cb,name,id);
                data.add(StudentNew);
                Navigation.findNavController(view).navigate(R.id.action_addStudentFragment_to_studentRecyclerFragment);
            }
        });

        Button CancelBtn = view.findViewById(R.id.add_cancel_btn);
        CancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_addStudentFragment_to_studentRecyclerFragment);
            }
        });
        return view;
    }
}