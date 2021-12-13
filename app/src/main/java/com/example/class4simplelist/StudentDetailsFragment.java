package com.example.class4simplelist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.class4simplelist.model.Model;
import com.example.class4simplelist.model.Student;


public class StudentDetailsFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        TextView nameTv = view.findViewById(R.id.sd_name_tv);
        TextView idTv = view.findViewById(R.id.sd_id_tv);


        String idS= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentid();
        Student student = Model.instance.getStudentById(idS);

        if (student != null)
        {
            nameTv.setText(student.getName());
            idTv.setText(student.getId());
        }

        Button editBtn = view.findViewById(R.id.EditBtnSI);
        editBtn.setOnClickListener
                (Navigation.createNavigateOnClickListener
                        (StudentDetailsFragmentDirections.actionStudentDetailsFragmentToStudentEditFragment(idS)));
        return view;
    }
}