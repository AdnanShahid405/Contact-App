package com.example.dbdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbdemo.R;
import com.example.dbdemo.displayContact;
import com.example.dbdemo.model.contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private List<contact> contactList;

    public RecyclerViewAdapter(Context context, List<contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
contact contact=contactList.get(position);
holder.contactname.setText(contact.getName());
holder.phonenumber.setText(contact.getPhonenumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView contactname;
        public TextView phonenumber;
        public ImageView iconbutton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contactname=itemView.findViewById(R.id.name);
            phonenumber=itemView.findViewById(R.id.phone_number);
            iconbutton=itemView.findViewById(R.id.icon_button);
            iconbutton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
            contact contact = contactList.get(position);
            String name = contact.getName();
            String phone = contact.getPhonenumber();
            Toast.makeText(context, "The position is " + String.valueOf(position) +
                    " Name: " + name + ", Phone:" + phone, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, displayContact.class);
            intent.putExtra("Rname", name);
            intent.putExtra("Rphone", phone);
            context.startActivity(intent);
        }
    }
}
