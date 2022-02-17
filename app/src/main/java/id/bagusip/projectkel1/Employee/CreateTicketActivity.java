package id.bagusip.projectkel1.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import id.bagusip.projectkel1.Dashboard.DashboardEmployeeActivity;
import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.RegisterActivity;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

public class CreateTicketActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinProblem;
    String temp_json, JSON_STRING, role, access_token, email;
    MaterialButton submit_ticket;
    EditText edit_name_emp, edit_start_date, edit_desc;
    DatePickerDialog.OnDateSetListener date_pick_start_date;
    ArrayList<String> arrayListIdProblem = new ArrayList<>();
    ArrayList<String> arrayListNameProblem = new ArrayList<>();
    int id_problem;
    Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ticket);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");

//        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();

//        edit_name_emp = findViewById(R.id.edit_name_emp);
        spinProblem = findViewById(R.id.spinProblem);
        edit_start_date = findViewById(R.id.edit_start_date);
        edit_desc = findViewById(R.id.edit_desc);

        submit_ticket = findViewById(R.id.submit_ticket);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getJSON();

        edit_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateTicketActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,date_pick_start_date,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }

        });

        date_pick_start_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = year+"-"+month+"-"+dayOfMonth;
                edit_start_date.setText(date);
            }
        };
        submit_ticket.setOnClickListener(this);
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(CreateTicketActivity.this, "Getting Data", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String resultProblem = handler.sendGetResponse(Konfigurasi.URL_GET_PROBLEM);
                Log.d("GetData", resultProblem);
                return resultProblem;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();

                JSON_STRING = s;
                Log.d("Data_JSON_COM", JSON_STRING);

                JSONObject jsonObjectProblem = null;


                try {
                    jsonObjectProblem = new JSONObject(JSON_STRING);
                    JSONArray jsonArrayProblem = jsonObjectProblem.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
                    Log.d("Data_JSON_LIST: ", String.valueOf(jsonArrayProblem));


                    for (int i = 0; i < jsonArrayProblem.length(); i++) {
                        JSONObject object = jsonArrayProblem.getJSONObject(i);
                        // String name = object.getString(Konfigurasi.TAG_JSON_NAMA_MAT);
                        String id_problem = object.getString(Konfigurasi.KEY_ID_PROBLEM);
                        String problem_name = object.getString(Konfigurasi.KEY_PROBLEM_NAME);
                        arrayListIdProblem.add(id_problem);

                        arrayListNameProblem.add(problem_name);
                        Log.d("DataArrMat: ", String.valueOf(problem_name));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                ArrayAdapter<String> adapterProblem = new ArrayAdapter<String>(CreateTicketActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayListNameProblem);

                adapterProblem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinProblem.setAdapter(adapterProblem);
                //Log.d("spin", String.valueOf(arrayList));

                spinProblem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        id_problem  = Integer.parseInt(arrayListIdProblem.get(i));
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
        if(view == submit_ticket){
            confirm_new_ticket();
        }
    }

    private void confirm_new_ticket() {
        new AlertDialog.Builder(CreateTicketActivity.this)
                .setTitle("Create New Ticket")
                .setMessage("Are you sure you want add this ticket?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        submit_new_ticket();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void submit_new_ticket() {

//        String nama = edit_name_emp.getText().toString();
        String spin_id_problem = String.valueOf(id_problem);
        String submit_date = edit_start_date.getText().toString();
        String description = edit_desc.getText().toString();


        class SimpanDataEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(CreateTicketActivity.this,
                        "Menyimpan Data", "Harap Tunggu ...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                // params digunakan untuk meyimpan ke HttpHandler
                HashMap<String, String> params = new HashMap<>();
//                params.put(Konfigurasi.KEY_NAMA_EMP, nama);
                params.put(Konfigurasi.KEY_ID_PROBLEM, spin_id_problem);
                params.put(Konfigurasi.KEY_CREATE_DATE, submit_date);
                params.put(Konfigurasi.KEY_PROBLEM_DETAIL, description);
                params.put(Konfigurasi.KEY_NAMA_EMAIL, email);
                HttpHandler handler = new HttpHandler();
                // HttpHandler untuk kirim data pakai sendPostRequest
                String result = handler.sendPostRequest(Konfigurasi.URL_CREATE_TICKET, params);
                Log.d("result",result);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                System.out.println("testing : "+s);
                // method untuk clear setelah data ditambah di form
                clearText();
                Intent intent = new Intent(CreateTicketActivity.this, DashboardEmployeeActivity.class);
                startActivity(intent);
            }
        }
        SimpanDataEmployee simpanDataEmployee = new SimpanDataEmployee();
        simpanDataEmployee.execute();
    }

    private void clearText() {
        edit_start_date.setText("");
        edit_desc.setText("");

        edit_desc.requestFocus();
    }
}