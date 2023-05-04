package com.example.firstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment implements View.OnClickListener {
    EditText edtFirstName, edtLastName;
    Button btnOk, btnCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_dialog_layout, container, false);

        edtFirstName = view.findViewById(R.id.edt_name);
        edtLastName = view.findViewById(R.id.edt__lastname);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);

        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ok:
                if(isValid()){
                    dismiss();
                }
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }

    private boolean isValid(){
        if(edtFirstName.getText().toString().isEmpty()){
            edtFirstName.setError("First Name is Reqiuired");
            edtFirstName.requestFocus();
            return false;
        } else if (edtLastName.getText().toString().isEmpty()) {
            edtLastName.setError("Last Name is Reqiuired");
            edtLastName.requestFocus();
            return false;
        }
        return true;
    }
}
