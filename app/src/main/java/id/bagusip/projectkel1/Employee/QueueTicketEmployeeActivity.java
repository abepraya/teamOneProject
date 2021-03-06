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
import android.widget.AdapterView;
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
import id.bagusip.projectkel1.databinding.ActivityOnGoingTicketEmployeeBinding;
import id.bagusip.projectkel1.databinding.ActivityQueueTicketEmployeeBinding;

public class QueueTicketEmployeeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String role, access_token, email, JSON_STRING;
    ListView list_queue_ticket_emp;
    private ProgressDialog loading;
    private View view;
    private boolean isDataExist = false;

    ActivityQueueTicketEmployeeBinding binding;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQueueTicketEmployeeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");
        
        list_queue_ticket_emp = binding.listQueueTicketEmp;
//                list_on_going_ticket = binding.listOnGoingTicket;
//        list_queue_ticket_emp.setOnItemClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        getJsonData();
    }

    private void getJsonData() {
        class GetJsonData extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(QueueTicketEmployeeActivity.this, "Ambil Data Queue Ticket", "Harap menunggu...", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_TICKET_QUEUE,email);
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
                displayAllDataQueueTicket();
            }
        }
        GetJsonData getJsonData = new GetJsonData();
        getJsonData.execute();
    }

    private void displayAllDataQueueTicket() {
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
                String problem_name = object.getString("t.problem_name");
                String problem_detail = object.getString("t.problem_detail");


                HashMap<String, String> ongoing_ticket = new HashMap<>();
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ID, id_ticket);
                ongoing_ticket.put(Konfigurasi.KEY_NAMA_EMP, nama_emp);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_CREATED_DATE, create_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_PROBLEM_NAME, problem_name);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_PROBLEM_DETAIL, problem_detail);
                Log.d("queue_ticket", String.valueOf(ongoing_ticket));
                list.add(ongoing_ticket);
            }

            if(jsonArray.length() == 0){
                isDataExist = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                QueueTicketEmployeeActivity.this, list, R.layout.list_queue_ticket_employee,
                new String[]{"id_ticket",
                        "nama_emp",
                        "create_date",
                        "problem_name",
                        "problem_detail"},
                new int[]{R.id.txtIdTicketQueueEmp,
                        R.id.txtEmpNameQueueTicketEmp,
                        R.id.txtCreateDateTicketQueueEmp,
                        R.id.txtProbNameQueueTicketEmps,
                        R.id.txtDetProbQueueTicketEmp}
        );
        list_queue_ticket_emp.setAdapter(adapter);
        if(!isDataExist){
            binding.listQueueTicketEmp.setEmptyView(binding.txtNoDataTicketEmpQueue.txtNoDataMessage);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        
    }
}