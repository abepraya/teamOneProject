package id.bagusip.projectkel1.Developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;
import id.bagusip.projectkel1.databinding.ActivitySolvedTicketBinding;

public class SolvedTicketActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String id_division, id_emp, id_ticket, JSON_STRING;
    private ActivitySolvedTicketBinding binding;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySolvedTicketBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent getIntentParams = getIntent();
        id_division = getIntentParams.getStringExtra(Konfigurasi.TAG_JSON_ID_DIVISION);
        id_emp = getIntentParams.getStringExtra(Konfigurasi.KEY_ID_EMP);
        id_ticket = getIntentParams.getStringExtra(Konfigurasi.TAG_JSON_ID_TICKET);

        binding.listSolvedTicket.setOnItemClickListener(this);

        displayAllSolvedTicket();
    }

    private void displayAllSolvedTicket() {
        class DisplayAllSolvedTicket extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SolvedTicketActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message,false, false );
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_ALL_SOLVED_TICKET_DEVELOPER, id_emp);
                return result;
            }

            @Override
            protected void onPostExecute(String dataJson) {
                super.onPostExecute(dataJson);
                loading.dismiss();
                JSON_STRING = dataJson;
                getDataSolveTicket();
            }
        }
        DisplayAllSolvedTicket displayAllSolvedTicket = new DisplayAllSolvedTicket();
        displayAllSolvedTicket.execute();
    }

    private void getDataSolveTicket() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray jsonArray = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id_ticket = object.getString(Konfigurasi.KEY_TICKET_ID);
                String name_emp = object.getString(Konfigurasi.KEY_NAME_EMP);
                String assign_date = object.getString(Konfigurasi.KEY_TICKET_ASSIGNED_DATE);
                String end_date = object.getString(Konfigurasi.KEY_TICKET_END_DATE);


                HashMap<String, String> ongoing_ticket = new HashMap<>();
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ID, id_ticket);
                ongoing_ticket.put(Konfigurasi.KEY_NAMA_EMP, name_emp);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ASSIGNED_DATE, assign_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_END_DATE, end_date);
                list.add(ongoing_ticket);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                SolvedTicketActivity.this, list, R.layout.list_item_solved_ticket,
                new String[]{Konfigurasi.KEY_TICKET_ID, Konfigurasi.KEY_NAMA_EMP, Konfigurasi.KEY_TICKET_CREATED_DATE, Konfigurasi.KEY_PROBLEM_NAME},
                new int[]{R.id.txtdev_queue_id_ticket, R.id.txtdev_queue_name_emp, R.id.txtdev_queue_create_date,R.id.txtdev_queue_problem_name}
        );
        binding.listSolvedTicket.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}