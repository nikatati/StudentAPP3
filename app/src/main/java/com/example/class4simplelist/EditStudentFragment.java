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


public class EditStudentFragment extends Fragment
{
    List<Student> data;
    EditText EditName;
    EditText EditId;
    EditText EditCb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_edit_student, container, false);
        data= Model.instance.getStudentList();
        EditName = view.findViewById(R.id.se_name_tv);
        EditId = view.findViewById(R.id.se_id_tv);

        String studentId = EditStudentFragmentArgs.fromBundle(getArguments()).getStudentid();
        Student student = Model.instance.getStudentById(studentId);
        if (student != null)
        {
            EditName.setText(student.getName());
            EditId.setText(student.getId());
        }

        Button CancelBtn = view.findViewById(R.id.edit_cancel_btn);
        CancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_studentEditFragment_to_studentListFragment);
            }
        });

        Button SaveBtn = view.findViewById(R.id.edit_save_btn);
        SaveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameE = EditName.getText().toString();
                String idE = EditId.getText().toString();
                student.name=nameE;
                student.id=idE;
                Navigation.findNavController(view).navigate(R.id.action_studentEditFragment_to_studentListFragment);
            }
        });

        Button DeleteBtn = view.findViewById(R.id.edit_delete_btn);
        DeleteBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Model.instance.deleteStudent(student);
                Navigation.findNavController(view).navigate(R.id.action_studentEditFragment_to_studentListFragment);
            }
        });
        return view;
    }
}