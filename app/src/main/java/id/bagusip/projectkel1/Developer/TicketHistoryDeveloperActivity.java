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
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;
import id.bagusip.projectkel1.databinding.ActivityTicketHistoryDeveloperBinding;

public class TicketHistoryDeveloperActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ActivityTicketHistoryDeveloperBinding binding;
    private String id_division, id_emp, JSON_STRING;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTicketHistoryDeveloperBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.listHistoryTicketDev.setDivider(null);

        Intent getIntentParams = getIntent();
        id_division = getIntentParams.getStringExtra(Konfigurasi.TAG_JSON_ID_DIVISION);
        id_emp = getIntentParams.getStringExtra(Konfigurasi.KEY_ID_EMP);

        binding.listHistoryTicketDev.setOnItemClickListener(this);

        displayAllHistoryTicket();
    }

    private void displayAllHistoryTicket() {
        class DisplayQueueData extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TicketHistoryDeveloperActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message,false, false );
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_ALL_HISTORY_TICKET_DEVELOPER, id_emp);
                return result;
            }

            @Override
            protected void onPostExecute(String dataJson) {
                super.onPostExecute(dataJson);
                loading.dismiss();
                JSON_STRING = dataJson;
                getDataQueueTicket();
            }
        }
        DisplayQueueData displayQueueData = new DisplayQueueData();
        displayQueueData.execute();
    }

    private void getDataQueueTicket() {
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
                TicketHistoryDeveloperActivity.this, list, R.layout.activity_list_history_ticket_developer,
                new String[]{
                        Konfigurasi.KEY_TICKET_ID,
                        Konfigurasi.KEY_NAMA_EMP,
                        Konfigurasi.KEY_TICKET_ASSIGNED_DATE,
                        Konfigurasi.KEY_TICKET_END_DATE
                },
                new int[]{
                        R.id.txtdev_id_ticket_history,
                        R.id.txtdev_name_emp_history,
                        R.id.txtdev_assign_date_history,
                        R.id.txtdev_end_date_history
                }
        );
        binding.listHistoryTicketDev.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Intent moveDetailHistoryTicket = new Intent(this, DetailTicketHistoryDeveloperActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String ticketId = map.get(Konfigurasi.KEY_TICKET_ID).toString();
        moveDetailHistoryTicket.putExtra(Konfigurasi.TAG_JSON_ID_TICKET, ticketId);
        moveDetailHistoryTicket.putExtra(Konfigurasi.TAG_JSON_ID_DIVISION, id_division);
        moveDetailHistoryTicket.putExtra(Konfigurasi.KEY_ID_EMP, id_emp);
        startActivity(moveDetailHistoryTicket);
    }
}