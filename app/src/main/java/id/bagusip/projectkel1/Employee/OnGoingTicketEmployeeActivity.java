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
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;
import id.bagusip.projectkel1.databinding.ActivityOnGoingTicketEmployeeBinding;

public class OnGoingTicketEmployeeActivity extends AppCompatActivity {
    String role, access_token, email, temp_json, JSON_STRING;
    ListView list_on_going_ticket;
    private ProgressDialog loading;
    private View view;
    private boolean isDataExist = false;

    ActivityOnGoingTicketEmployeeBinding binding;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnGoingTicketEmployeeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);
//        setContentView(R.layout.activity_on_going_ticket_employee);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");

        list_on_going_ticket = binding.listOnGoingTicket;
        getJsonData();
    }

    private void getJsonData() {
        class GetJsonData extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(OnGoingTicketEmployeeActivity.this, "Ambil Data Ticket", "Harap menunggu...", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_TICKET_ONGOING,email);
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
                displayAllDataOnGoingTicket();
            }
        }
        GetJsonData getJsonData = new GetJsonData();
        getJsonData.execute();
    }

    private void displayAllDataOnGoingTicket() {
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
                String problem_name = object.getString("p.problem_name");
                String solver_name = object.getString("name_solver");
                String problem_detail = object.getString("t.problem_detail");


                HashMap<String, String> ongoing_ticket = new HashMap<>();
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ID, id_ticket);
                ongoing_ticket.put(Konfigurasi.KEY_NAMA_EMP, nama_emp);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_CREATED_DATE, create_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ASSIGNED_DATE, assign_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_PROBLEM_NAME, problem_name);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_SOLVER_NAME_CARD, solver_name);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_PROBLEM_DETAIL, problem_detail);
                Log.d("ongoing_ticket", String.valueOf(ongoing_ticket));
                list.add(ongoing_ticket);
            }

            if(jsonArray.length() == 0){
                isDataExist = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                OnGoingTicketEmployeeActivity.this, list, R.layout.list_ongoing_ticket_employee,
                new String[]{
                        "id_ticket", //1
                        "nama_emp", //2
                        "create_date", //3
                        "assign_date", //4
                        "problem_name", //5
                        "name_solver", //6
                        "problem_detail"}, //7
                new int[]{
                        R.id.txtIdTicketOnGoingEmp,   //1
                        R.id.txtEmpNameOnGoingTicketEmp, //2
                        R.id.txtSubmitDateTicketOngoingEmp, //3
                        R.id.txtAssignDateTicketOngoingEmp, //4
                        R.id.txtProbNameOnGoingEmp, //5
                        R.id.txtDevNameOngoingEmp, //6
                        R.id.txt_detail_problem, //7

                }
        );
        list_on_going_ticket.setAdapter(adapter);
        if(!isDataExist){
            binding.listOnGoingTicket.setEmptyView(binding.txtNoDataTicketEmpOngoing.txtNoDataMessage);
        }
    }
}