package id.bagusip.projectkel1;

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

import id.bagusip.projectkel1.Developer.DetailOnGoingTicketDeveloperActivity;
import id.bagusip.projectkel1.Employee.OnGoingTicketEmployeeActivity;
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

public class OnGoingTicketDeveloperActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView list_on_going_ticket;
    private String JSON_STRING, id_division, id_emp;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_ticket_developer);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent getIntentParams = getIntent();
        id_division = getIntentParams.getStringExtra(Konfigurasi.response_login_id_division);
        id_emp = getIntentParams.getStringExtra(Konfigurasi.KEY_ID_EMP);

        list_on_going_ticket = findViewById(R.id.listdev_on_going_ticket);
        list_on_going_ticket.setOnItemClickListener(this);

        displayListTicket();
    }

    private void displayListTicket() {
        class DisplayListTicket extends AsyncTask<Void, Void, String>
        {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(OnGoingTicketDeveloperActivity.this,
                        ConstantMenu.loading_title, ConstantMenu.loading_message,
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_ALL_ON_GOING_TICKET_DEVELOPER, id_emp);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                JSON_STRING = message;
                displayAllDataOnGoingTicket();
            }
        }
        DisplayListTicket displayListTicket = new DisplayListTicket();
        displayListTicket.execute();
    }

    private void displayAllDataOnGoingTicket() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray jsonArray = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id_ticket = object.getString(Konfigurasi.KEY_TICKET_ID);
                String nama_emp = object.getString(Konfigurasi.KEY_NAME_EMP);
                String create_date = object.getString(Konfigurasi.KEY_CREATE_DATE);
                String assign_date = object.getString(Konfigurasi.KEY_TICKET_ASSIGNED_DATE);


                HashMap<String, String> ongoing_ticket = new HashMap<>();
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ID, id_ticket);
                ongoing_ticket.put(Konfigurasi.KEY_NAMA_EMP, nama_emp);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_CREATED_DATE, create_date);
                ongoing_ticket.put(Konfigurasi.KEY_TICKET_ASSIGNED_DATE, assign_date);

                list.add(ongoing_ticket);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                this, list, R.layout.activity_list_on_going_ticket_developer,
                new String[]{"id_ticket", "nama_emp", "create_date", "assign_date"},
                new int[]{R.id.txtdev_id_ticket_on_going, R.id.txtdev_name_on_going, R.id.txtdev_create_date_on_going,R.id.txtdev_assign_date_on_going}
        );
        list_on_going_ticket.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent moveDetailTicket = new Intent(this, DetailOnGoingTicketDeveloperActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String ticketId = map.get(Konfigurasi.KEY_TICKET_ID).toString();
        moveDetailTicket.putExtra(Konfigurasi.TAG_JSON_ID_TICKET, ticketId);
        moveDetailTicket.putExtra(Konfigurasi.TAG_JSON_ID_DIVISION, id_division);
        moveDetailTicket.putExtra(Konfigurasi.KEY_ID_EMP, id_emp);
        startActivity(moveDetailTicket);
    }
}