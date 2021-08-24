package com.example.mobilejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormActivity extends AppCompatActivity {


    private EditText edtTxtFName, edtTxtLName , edtTxtState , edtTxtDeleg , editTxtPhone , edtTxtCompanyName , edtTxtTradeMark, edtTxtCIN, edtTxtActivity, edtTxtAdress, edtTxtCodePostal ;
    private TextView txtFName,txtLName,txtState, txtDeleg, txtPhoneNum, txtCompanyName,txtTradeMark, txtCIN, txtActivity, txtAdress, txtCodePostal, txtAgree  ;
    private CheckBox isCard ,checkAgree ;
    private Button btnRegisterForm,btnCategories;
    private ConstraintLayout parent;
    private boolean isExpanded = false;
    private RelativeLayout expandableLayout;
    private RadioButton rdBtnSubs1, rdBtnSubs2, rdBtnSubs3;
    private static final String FILE_NAME = "Form.txt";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        InitializeViewsF();

        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExpanded) {
                    expandableLayout.setVisibility(View.GONE);
                    isExpanded = false;
                } else if (!(isExpanded)) {
                    expandableLayout.setVisibility(View.VISIBLE);
                    isExpanded = true;
                }
            }
        });

        btnRegisterForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register();


            }
        });
    }

    private void Register() {
        if (VerifData()){
            Customer customer = new Customer(-1,edtTxtFName.getText().toString(),edtTxtLName.getText().toString(),edtTxtState.getText().toString(),edtTxtDeleg.getText().toString(),
                    edtTxtCompanyName.getText().toString(),edtTxtTradeMark.getText().toString(),Integer.parseInt(edtTxtCIN.getText().toString()),edtTxtActivity.getText().toString(),
                    edtTxtAdress.getText().toString(),Integer.parseInt(edtTxtCodePostal.getText().toString()),isCard.isChecked(),checkAgree.isChecked(),Integer.parseInt(editTxtPhone.getText().toString()),rdBtnSubs1.isChecked(),rdBtnSubs2.isChecked(),rdBtnSubs3.isChecked() );



            DataBaseHelper dataBaseHelper = new DataBaseHelper(FormActivity.this);

            dataBaseHelper.addCustomer(customer);
            showSnackBar();
        } else {
            Toast.makeText(FormActivity.this, "أدخل من فضلك جميع البيانات", Toast.LENGTH_SHORT).show();
        }
    }

    private void showSnackBar() {
        Snackbar.make(parent, "لقد تم تسجيلك", Snackbar.LENGTH_INDEFINITE).setAction("رجوع", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTxtFName.setText("");
                edtTxtLName.setText("");
                edtTxtState.setText("");
                edtTxtDeleg.setText("");
                editTxtPhone.setText("");
                edtTxtCompanyName.setText("");
                edtTxtTradeMark.setText("");
                edtTxtCIN.setText("");
                edtTxtActivity.setText("");
                edtTxtAdress.setText("");
                edtTxtCodePostal.setText("");
                checkAgree.setChecked(false);
                isCard.setChecked(false);
                rdBtnSubs1.setChecked(true);
                rdBtnSubs2.setChecked(false);
                rdBtnSubs2.setChecked(false);
            }
        }).show();
    }

    @SuppressLint("ResourceAsColor")
    private boolean VerifData(){
        if (edtTxtFName.getText().toString().equals("")){
            txtFName.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtLName.getText().toString().equals("")){
            txtLName.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtState.getText().toString().equals("")){
            txtState.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtDeleg.getText().toString().equals("")){
            txtDeleg.setTextColor(Color.RED);
            return false;
        }


        if (editTxtPhone.getText().toString().equals("") || editTxtPhone.getText().toString().length() != 8 ){
            txtPhoneNum.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtCompanyName.getText().toString().equals("")){
            txtCompanyName.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtTradeMark.getText().toString().equals("")){
            txtTradeMark.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtCIN.getText().toString().equals("")|| edtTxtCIN.getText().toString().length() != 8){
            txtCIN.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtActivity.getText().toString().equals("")){
            txtActivity.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtAdress.getText().toString().equals("")){
            txtAdress.setTextColor(Color.RED);
            return false;
        }

        if (edtTxtCodePostal.getText().toString().equals("") || edtTxtCodePostal.getText().toString().length() != 4){
            txtCodePostal.setTextColor(Color.RED);
            return false;
        }

        if (!checkAgree.isChecked()){
            txtAgree.setTextColor(Color.RED);
            return false;
        }

        return true;
    }

    private void InitializeViewsF() {
        txtFName = findViewById(R.id.txtFName);
        txtLName = findViewById(R.id.txtLName);
        txtState = findViewById(R.id.txtState);
        txtDeleg = findViewById(R.id.txtDeleg);
        txtPhoneNum = findViewById(R.id.txtPhoneNum);
        txtCompanyName = findViewById(R.id.txtCompanyName);
        txtTradeMark = findViewById(R.id.txtTradeMark);
        txtCIN = findViewById(R.id.txtCIN);
        txtActivity = findViewById(R.id.txtActivity);
        txtAdress = findViewById(R.id.txtAdress);
        txtCodePostal = findViewById(R.id.txtCodePostal);
        txtAgree = findViewById(R.id.txtAgree);
        edtTxtFName = findViewById(R.id.edtTxtFName);
        edtTxtLName = findViewById(R.id.edtTxtLName);
        edtTxtState = findViewById(R.id.edtTxtState);
        edtTxtDeleg = findViewById(R.id.edtTxtDeleg);
        editTxtPhone = findViewById(R.id.editTxtPhone);
        edtTxtCompanyName = findViewById(R.id.edtTxtCompanyName);
        edtTxtTradeMark = findViewById(R.id.edtTxtTradeMark);
        edtTxtCIN = findViewById(R.id.edtTxtCIN);
        edtTxtActivity = findViewById(R.id.edtTxtActivity);
        edtTxtAdress = findViewById(R.id.edtTxtAdress);
        edtTxtCodePostal = findViewById(R.id.edtTxtCodePostal);
        isCard = findViewById(R.id.isCard);
        checkAgree = findViewById(R.id.checkAgree);
        btnRegisterForm = findViewById(R.id.btnRegisterForm);
        parent = findViewById(R.id.parent);
        rdBtnSubs1 = findViewById(R.id.rdBtnSubs1);
        rdBtnSubs2 = findViewById(R.id.rdBtnSubs2);
        rdBtnSubs3 = findViewById(R.id.rdBtnSubs3);
        expandableLayout=findViewById(R.id.expandableLayout);
        btnCategories=findViewById(R.id.btnCategories);

    }


}