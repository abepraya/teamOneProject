package id.bagusip.projectkel1.Developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import id.bagusip.projectkel1.OnGoingTicketDeveloperActivity;
import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.Utility.Utility;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

public class DetailOnGoingTicketDeveloperActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_id_on_going_ticket_dev, txt_status_on_going_ticket_dev,
            txt_problem_name_on_going_ticket_dev, txt_name_emp_on_going_ticket_dev,
            txt_create_date_on_going_ticket_dev, txt_branch_name_on_going_ticket_dev,
            txt_problem_detail_on_going_ticket_dev, txt_assign_date_on_going_ticket_dev;
    private EditText txt_dev_note_on_going_ticket_dev;
    private Button btn_solve_ticket_dev;

    private String id_division, id_ticket, id_emp;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_on_going_ticket_developer);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent getIntentParams = getIntent();
        id_ticket = getIntentParams.getStringExtra(Konfigurasi.TAG_JSON_ID_TICKET);
        id_emp = getIntentParams.getStringExtra(Konfigurasi.KEY_ID_EMP);
        id_division = getIntentParams.getStringExtra(Konfigurasi.TAG_JSON_ID_DIVISION);

        txt_assign_date_on_going_ticket_dev = findViewById(R.id.txt_assign_on_going_ticket_dev);
        txt_id_on_going_ticket_dev = findViewById(R.id.txt_id_on_going_ticket_dev);
        txt_status_on_going_ticket_dev = findViewById(R.id.txt_status_on_going_ticket_dev);
        txt_problem_name_on_going_ticket_dev = findViewById(R.id.txt_problem_name_on_going_ticket_dev);
        txt_name_emp_on_going_ticket_dev = findViewById(R.id.txt_name_emp_on_going_ticket_dev);
        txt_create_date_on_going_ticket_dev = findViewById(R.id.txt_create_date_on_going_ticket_dev);
        txt_branch_name_on_going_ticket_dev = findViewById(R.id.txt_branch_name_on_going_ticket_dev);
        txt_problem_detail_on_going_ticket_dev = findViewById(R.id.txt_problem_detail_on_going_ticket_dev);
        txt_dev_note_on_going_ticket_dev = findViewById(R.id.txt_dev_note_on_going_ticket_dev);
        btn_solve_ticket_dev = findViewById(R.id.btn_solve_ticket_dev);

        btn_solve_ticket_dev.setOnClickListener(this);

        updateOnGoingTicket();
    }

    private void updateOnGoingTicket() {

        class UpdateOnGoingTicket extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailOnGoingTicketDeveloperActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message, false,false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();

                String result = handler.sendGetMultiParamsResponse(Konfigurasi.URL_GET_DETAIL_ON_GOING_TICKET_DEVELOPER, id_emp, id_ticket);
                return result;
            }

            @Override
            protected void onPostExecute(String jsonData) {
                super.onPostExecute(jsonData);
                loading.dismiss();
                displayOnGoingTicket(jsonData);
            }
        }
        UpdateOnGoingTicket updateOnGoingTicket = new UpdateOnGoingTicket();
        updateOnGoingTicket.execute();

    }

    private void displayOnGoingTicket(String jsonData) {
        try{
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject object = result.getJSONObject(0);

            String idTicket, status, assignDate, problemName, createDate, nameEmp, branchName, problemDetail;
            idTicket = object.getString(Konfigurasi.KEY_TICKET_ID);
            status = object.getString(Konfigurasi.KEY_TICKET_STATUS);
            assignDate = object.getString(Konfigurasi.KEY_TICKET_ASSIGNED_DATE);
            problemName = object.getString(Konfigurasi.KEY_PROBLEM_NAME);
            createDate = object.getString(Konfigurasi.KEY_CREATE_DATE);
            nameEmp = object.getString(Konfigurasi.KEY_NAME_EMP);
            branchName = object.getString(Konfigurasi.KEY_NAME_BRANCH);
            problemDetail = object.getString(Konfigurasi.KEY_PROBLEM_DETAIL);

            txt_id_on_going_ticket_dev.setText(idTicket);
            txt_status_on_going_ticket_dev.setText(status);
            txt_assign_date_on_going_ticket_dev.setText(assignDate);
            txt_problem_name_on_going_ticket_dev.setText(problemName);
            txt_create_date_on_going_ticket_dev.setText(createDate);
            txt_name_emp_on_going_ticket_dev.setText(nameEmp);
            txt_branch_name_on_going_ticket_dev.setText(branchName);
            txt_problem_detail_on_going_ticket_dev.setText(problemDetail);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onClick(View buttons) {
        if (btn_solve_ticket_dev.equals(buttons)){
            Toast.makeText(this, "Submit", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(this).setTitle(Konfigurasi.STATUS_SOLVED)
                    .setMessage("Are you sure you want to solve this problem?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                saveData();
                            }
                        })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }
    }

    private void saveData() {
        class SaveData extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailOnGoingTicketDeveloperActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message, false, false);
            }
            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                HashMap<String, String> params = new HashMap<>();
                String idTicket, noteDeveloper;

                idTicket = txt_id_on_going_ticket_dev.getText().toString();
                noteDeveloper = txt_dev_note_on_going_ticket_dev.getText().toString().trim();

                params.put(Konfigurasi.KEY_TICKET_ID, idTicket);
                params.put(Konfigurasi.KEY_NOTE_DEVELOPER, noteDeveloper);
                String result = handler.sendPostRequest(Konfigurasi.URL_UPDATE_ON_GOING_TICKET_DETAIL_DEVELOPER, params);
                return result;
            }
            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                startActivity(new Intent(DetailOnGoingTicketDeveloperActivity.this, OnGoingTicketDeveloperActivity.class));
            }
        }
        SaveData saveData = new SaveData();
        saveData.execute();
    }
}