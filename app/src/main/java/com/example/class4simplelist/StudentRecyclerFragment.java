package com.example.class4simplelist;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class4simplelist.model.Model;
import com.example.class4simplelist.model.Student;

import java.util.List;

public class StudentRecyclerFragment extends Fragment
{
    List<Student> data;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        view= inflater.inflate(R.layout.fragment_student_recycler, container, false);
        data = Model.instance.getStudentList();

        RecyclerView list = view.findViewById(R.id.Studentlist_list_recycler);
        list.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);

        MyAdapter adapter= new MyAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener ()
        {
            @Override
            public void onItemClick(int position,View v) {
                Student st = data.get(position);
                Log.d("Tag","row was clicked"+ position);
                StudentRecyclerFragmentDirections.ActionStudentRecyclerFragmentToStudentInfoFragment action =
                        StudentRecyclerFragmentDirections.actionStudentRecyclerFragmentToStudentInfoFragment(st.getId());
                Navigation.findNavController(v).navigate(action);
            }
        });
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void setHasOptionsMenu(boolean hasMenu)
    {
        super.setHasOptionsMenu(hasMenu);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.student_list_menu,menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_settings:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
//-----------------------------------------------------------------------------------------------------------

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        OnItemClickListener listener;
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener)
        {
            super(itemView);
            nameTv = itemView.findViewById(R.id.list_row_name_tv);
            idTv = itemView.findViewById(R.id.list_row_id_tv);
            cb = itemView.findViewById(R.id.list_row_cb);

            this.listener = listener;
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(pos,view);
                    }
                }
            });
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Log.d("TAG","cb was clicked " + pos);
                }
            });
        }
    }

    interface OnItemClickListener
    {
        void onItemClick(int position,View v);
    }

    //--------------------------------------------------------------------------------
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {
        OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener)
        {
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            LayoutInflater inflater= getLayoutInflater();
            View rowView = inflater.inflate(R.layout.student_list_row,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(rowView,listener);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
        {
            Student student = data.get(position);
            holder.idTv.setText(student.getId());
            holder.nameTv.setText(student.getName());
            //holder.cb.setChecked(student.cb);
        }

        @Override
        public int getItemCount()
        {
            return data.size();
        }
    }
}