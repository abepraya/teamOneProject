package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout textEmployeeName, textEmployeeEmail, textEmployeeAddress,
            textEmployeePassword, textEmployeePhone, textDatePickerOfBirth,
            textEmployeeJobTitle;

    EditText dateOfBirth;
    Spinner spinnerIDDivision, spinnerIDBranch;
    DatePickerDialog.OnDateSetListener dateOfBirthPicker;
    CardView cardViewRegister;
    TextView txtLogin;
    private int idDivision, idBranch;
    String temp_json, JSON_STRING;

    ArrayList<String> arrayListIdDivision = new ArrayList<>();
    ArrayList<String> arrayListNameDivision = new ArrayList<>();
    ArrayList<String> arrayListIDBranch = new ArrayList<>();
    ArrayList<String> arrayListNameBranch = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setElevation(0);

        textEmployeeName = findViewById(R.id.employeeName);
        textEmployeeEmail = findViewById(R.id.employeeEmail);
        textEmployeeAddress = findViewById(R.id.employeeAddress);
        textEmployeePassword = findViewById(R.id.employeePassword);
        textDatePickerOfBirth = findViewById(R.id.datePickerOfBirth);
        textEmployeeJobTitle = findViewById(R.id.employeeJobTitle);
        textEmployeePhone = findViewById(R.id.employeePhone);
        dateOfBirth = findViewById(R.id.dateOfBirth);
        cardViewRegister = findViewById(R.id.btnRegister);
        spinnerIDDivision = findViewById(R.id.spinnerIDDivision);
        spinnerIDBranch = findViewById(R.id.spinnerIDBranch);

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

        getJSON();
    }

    private void getJSON()
    {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(RegisterActivity.this, "Getting Data", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String resultDivision = handler.sendGetResponse(Konfigurasi.URL_GET_DIVISION);
                String resultBranch = handler.sendGetResponse(Konfigurasi.URL_GET_BRANCH);
                temp_json = resultDivision;
                Log.d("GetData", resultDivision);
                Log.d("GetDataIns", resultBranch); //terpanggil
                return resultBranch;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();

                JSON_STRING = s;
                Log.d("Data_JSON_COM", JSON_STRING);

                JSONObject jsonObjectBranch = null;
                JSONObject jsonObjectDivision = null;
                ArrayList<String> arrayListBranch = new ArrayList<>();
                ArrayList<String> arrayListDivision = new ArrayList<>();



                try {
                    jsonObjectBranch = new JSONObject(JSON_STRING);
                    jsonObjectDivision = new JSONObject(temp_json);
                    JSONArray jsonArrayBranch = jsonObjectBranch.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
                    JSONArray jsonArrayDivision = jsonObjectDivision.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
                    Log.d("Data_JSON_LIST: ", String.valueOf(jsonArrayBranch) +
                            "\n" + jsonArrayDivision);


                    for (int i = 0; i < jsonArrayBranch.length(); i++) {
                        JSONObject object = jsonArrayBranch.getJSONObject(i);
                        // String name = object.getString(Konfigurasi.TAG_JSON_NAMA_MAT);
                        String idBranch = object.getString(Konfigurasi.KEY_BRANCH);
                        String branchName = object.getString(Konfigurasi.KEY_NAME_BRANCH);
                        arrayListIDBranch.add(idBranch);

                        arrayListNameBranch.add(branchName);
                        Log.d("DataArrMat: ", String.valueOf(branchName));
                    }
                    for (int i = 0; i < jsonArrayDivision.length(); i++) {
                        JSONObject object = jsonArrayDivision.getJSONObject(i);
                        String idDivision = object.getString(Konfigurasi.KEY_DIVISION);
                        String divisionName = object.getString(Konfigurasi.KEY_NAME_DIVISION);
                        arrayListIdDivision.add(idDivision);

                        arrayListNameDivision.add(divisionName);
                        Log.d("DataArrIns: ", String.valueOf(divisionName));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                ArrayAdapter<String> adapterDivision = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayListNameDivision);
                ArrayAdapter<String> adapterBranch = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayListNameBranch);
                adapterDivision.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapterBranch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinnerIDDivision.setAdapter(adapterDivision);
                spinnerIDBranch.setAdapter(adapterBranch);
                //Log.d("spin", String.valueOf(arrayList));

                spinnerIDDivision.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        idDivision = Integer.parseInt(arrayListIdDivision.get(i));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                spinnerIDBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        idBranch = Integer.parseInt(arrayListIDBranch.get(i));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    @Override
    public void onClick(View view) {
        if(view == cardViewRegister){
            saveData();
            Intent myIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(myIntent);
        }
    }

    private void saveData() {
        String nama = textEmployeeName.getEditText().getText().toString();
        String email = textEmployeeEmail.getEditText().getText().toString();
        String address = textEmployeeAddress.getEditText().getText().toString();
        String password = textEmployeePassword.getEditText().getText().toString();
        String phone = textEmployeePhone.getEditText().getText().toString();
        String date_of_birth = textDatePickerOfBirth.getEditText().getText().toString();
        String job_title = textEmployeeJobTitle.getEditText().getText().toString();
        String spin_id_branch = String.valueOf(idBranch);
        String spin_id_division = String.valueOf(idDivision);

        class SimpanDataEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this,
                        "Menyimpan Data", "Harap Tunggu ...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                // params digunakan untuk meyimpan ke HttpHandler
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA_EMP, nama);
                params.put(Konfigurasi.KEY_NAMA_EMAIL, email);
                params.put(Konfigurasi.KEY_NAMA_ADDRESS, address);
                params.put(Konfigurasi.KEY_NAMA_PASSWORD, password);
                params.put(Konfigurasi.KEY_NAMA_PHONE, phone);
                params.put(Konfigurasi.KEY_NAMA_BIRTHDATE, date_of_birth);
                params.put(Konfigurasi.KEY_NAMA_JOB_TITLE, job_title);
                params.put(Konfigurasi.KEY_NAMA_ID_BRANCH, spin_id_branch);
                params.put(Konfigurasi.KEY_NAMA_ID_DIVISION, spin_id_division);
                HttpHandler handler = new HttpHandler();
                // HttpHandler untuk kirim data pakai sendPostRequest
                String result = handler.sendPostRequest(Konfigurasi.URL_CREATE_ACCOUNT, params);
                Log.d("result",result);
//                Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_SHORT).show();
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                System.out.println("testing : "+s);
                // method untuk clear setelah data ditambah di form
                clearText();
            }
        }
        SimpanDataEmployee simpanDataEmployee = new SimpanDataEmployee();
        simpanDataEmployee.execute();
    }

    private void clearText() {
        textEmployeeName.getEditText().setText("");
        textEmployeeEmail.getEditText().setText("");
        textEmployeeAddress.getEditText().setText("");
        textEmployeePassword.getEditText().setText("");
        textEmployeePhone.getEditText().setText("");
        textDatePickerOfBirth.getEditText().setText("");
        textEmployeeJobTitle.getEditText().setText("");
        // untuk pointer langsung menuju kolom nama di layout
        textEmployeeName.requestFocus();
    }
}