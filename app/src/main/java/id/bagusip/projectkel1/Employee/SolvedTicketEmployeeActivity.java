package id.bagusip.projectkel1.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

public class SolvedTicketEmployeeActivity extends AppCompatActivity {
    String role, access_token, email, JSON_STRING;
    ListView list_emp_solved_ticket;
    private ProgressDialog loading;
    private View view;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_ticket_employee);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");

        list_emp_solved_ticket = findViewById(R.id.list_emp_solved_ticket);
        getJsonData();
    }

    private void getJsonData() {
        class GetJsonData extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SolvedTicketEmployeeActivity.this, "Ambil Data Solved Ticket", "Harap menunggu...", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_TICKET_SOLVED,email);
                Log.d("result",result);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                JSON_STRING = message;
                Log.d("DATA_JSON: ", JSON_STRING);
                // Toast.makeText(view.getContext(), JSON_STRING, Toast.LENGTH_LONG).show();

                // menampilkan data json kedalam list view
                displayAllDataSolvedTicket();
            }
        }
        GetJsonData getJsonData = new GetJsonData();
        getJsonData.execute();
    }

    private void displayAllDataSolvedTicket() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray jsonArray = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id_ticket = object.getString("t.id_ticket");
                String nama_emp = object.getString("e.name_emp");
                String create_date = object.getString("t.create_date");
                String assign_date = object.getString("t.assign_date");
                String end_date = object.getString("t.end_date");


                HashMap<String, String> ongoing_ticket = new HashMap<>();
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ID, id_ticket);
                ongoing_ticket.put(Konfigurasi.KEY_NAMA_EMP, nama_emp);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_CREATED_DATE, create_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ASSIGNED_DATE, assign_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_END_DATE, end_date);
                Log.d("ongoing_ticket", String.valueOf(ongoing_ticket));
                list.add(ongoing_ticket);

//                Log.d("list_ticket", String.valueOf(list));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                SolvedTicketEmployeeActivity.this, list, R.layout.list_solved_ticket_employee,
                new String[]{"id_ticket", "nama_emp", "create_date", "end_date"},
                new int[]{R.id.txtIdTicketSolvedEmp, R.id.txtEmpNameSolvedTicketEmp, R.id.txtSubmitDateTicketSolvedEmp,R.id.txtSolvedDateTicketSolvedEmp}
        );
        list_emp_solved_ticket.setAdapter(adapter);
    }
}