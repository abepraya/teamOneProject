package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout textEmployeeName, textEmployeeEmail, textEmployeeAddress,
            textEmployeePassword, textEmployeePhone, textDatePickerOfBirth,
            textEmployeeJobTitle;

    EditText dateOfBirth;
    Spinner spinnerIDDivision, spinnerIDBranch;
    DatePickerDialog.OnDateSetListener dateOfBirthPicker;
    CardView cardViewRegister;
    TextView txtLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textEmployeeName = findViewById(R.id.employeeName);
        textEmployeeEmail = findViewById(R.id.employeeEmail);
        textEmployeeAddress = findViewById(R.id.employeeAddress);
        textEmployeePassword = findViewById(R.id.employeePassword);
        textDatePickerOfBirth = findViewById(R.id.datePickerOfBirth);
        textEmployeeJobTitle = findViewById(R.id.employeeJobTitle);
        textEmployeePhone = findViewById(R.id.employeePhone);
        dateOfBirth = findViewById(R.id.dateOfBirth);
        cardViewRegister = findViewById(R.id.btnRegister);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateOfBirthPicker,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }

        });

        cardViewRegister.setOnClickListener(this);

        dateOfBirthPicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = year+"-"+month+"-"+dayOfMonth;
                dateOfBirth.setText(date);
            }
        };


    }

    @Override
    public void onClick(View view) {
        String nama = textEmployeeName.getEditText().getText().toString();
        String email = textEmployeeEmail.getEditText().getText().toString();
        String address = textEmployeeAddress.getEditText().getText().toString();
        String password = textEmployeePassword.getEditText().getText().toString();
        String phone = textEmployeePhone.getEditText().getText().toString();
        String date_of_birth = textDatePickerOfBirth.getEditText().getText().toString();
        String job_title = textEmployeeJobTitle.getEditText().getText().toString();
        if(view == cardViewRegister){
            Toast.makeText(getApplicationContext(), address, Toast.LENGTH_SHORT).show();
            Log.d("res",nama+"\n"+email+"\n"+address+"\n"+password+"\n"+phone+"\n"+date_of_birth+"\n"+job_title);
        }
    }
}