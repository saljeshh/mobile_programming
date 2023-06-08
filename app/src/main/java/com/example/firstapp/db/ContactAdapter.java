package com.example.firstapp.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.ContactClickListener;
import com.example.firstapp.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Contact> contacts;
    private ContactClickListener mListener;

    public ContactAdapter(Context mContext, ArrayList<Contact> contacts, ContactClickListener mListener) {
        this.mContext = mContext;
        this.contacts = contacts;
        this.mListener = mListener;
        this.mInflater=LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.data_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact contact = contacts.get(position);
        holder.tvPhone.setText(contact.getPhone_number());
        holder.tvName.setText(contact.getName());
        holder.llMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDialog(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void showDialog(int position){
        String options[] = new String[]{"Update", "Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Select Options").setSingleChoiceItems(options, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch(which){
                    case 0:
                        if(mListener!=null){
                            mListener.onContactUpdate(position);
                        }
                        break;
                    case 1:
                        confirmDelete(position);
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void confirmDelete(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Delete").setMessage("Are you sure you want to delete").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(mListener != null){
                    mListener.onContactDelete(position);
                }
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPhone;
        LinearLayout llMain;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            llMain = itemView.findViewById(R.id.llmain);
        }
    }
}
