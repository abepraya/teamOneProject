package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.bagusip.projectkel1.config.HttpHandler;

public class QueueTicketDeveloperActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list_queue_ticket;
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_ticket_developer);

        list_queue_ticket = findViewById(R.id.list_queue_ticket);
        list_queue_ticket.setOnItemClickListener(this);

        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String>
        {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(QueueTicketDeveloperActivity.this,
                        "Mengambil Data", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_ALL_QUEUE_TICKET_DEVELOPER);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                JSON_STRING = message;

                // menampilkan data dalam bentuk list view
                displayQueueTicket();
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void displayQueueTicket() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            Log.d("DATA_JSON: ", JSON_STRING);


            for (int i = 0; i < result.length(); i++) {
                JSONObject object = result.getJSONObject(i);
                String id_ticket = object.getString(Konfigurasi.TAG_JSON_ID_TICKET);
                String create_date = object.getString(Konfigurasi.TAG_JSON_CREATE_DATE);
                String name_emp = object.getString(Konfigurasi.TAG_JSON_NAME_EMP);
                String problem_name = object.getString(Konfigurasi.TAG_JSON_PROBLEM_NAME);


                HashMap<String, String> queue = new HashMap<>();
                queue.put(Konfigurasi.TAG_JSON_ID_TICKET, id_ticket);
                queue.put(Konfigurasi.TAG_JSON_CREATE_DATE, create_date);
                queue.put(Konfigurasi.TAG_JSON_NAME_EMP, name_emp);
                queue.put(Konfigurasi.TAG_JSON_PROBLEM_NAME, problem_name);

                // ubah format json menjadi array list
                list.add(queue);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // adapter untuk meletakan array list kedalam list view
        ListAdapter adapter = new SimpleAdapter(
                QueueTicketDeveloperActivity.this, list,
                R.layout.activity_list_queue_ticket_developer,
                new String[]{Konfigurasi.TAG_JSON_ID_TICKET, Konfigurasi.TAG_JSON_CREATE_DATE, Konfigurasi.TAG_JSON_NAME_EMP, Konfigurasi.TAG_JSON_PROBLEM_NAME},
                new int[]{R.id.txt_id_ticket_on_going_dev, R.id.txt_create_date_on_going_dev, R.id.txt_name_emp_on_going_dev, R.id.txt_problem_name}
        );
        list_queue_ticket.setAdapter(adapter);
    }

    //Kalau Mau Buat Detail Queue
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent myIntent = new Intent(QueueTicketDeveloperActivity.this, DetailQueueTicketDeveloperActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String tiket= map.get(Konfigurasi.TAG_JSON_ID_TICKET).toString();
        myIntent.putExtra(Konfigurasi.TICKET_ID, tiket);
        startActivity(myIntent);
    }
}