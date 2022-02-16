package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;

import id.bagusip.projectkel1.config.HttpHandler;

public class OnGoingTicketDeveloperActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list_on_going_ticket;
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_ticket_developer);

        list_on_going_ticket = findViewById(R.id.list_on_going_ticket);
        list_on_going_ticket.setOnItemClickListener(this);

        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String>
        {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(OnGoingTicketDeveloperActivity.this,
                        "Mengambil Data", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
//                String result = handler.sendGetResponse(Konfigurasi.URL_ALL_ON_GOING_TICKET_DEVELOPER);
//                return result;
                return null;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                JSON_STRING = message;

                // menampilkan data dalam bentuk list view
                // displayOnGoingTicket();
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*Intent myIntent = new Intent(OnGoingTicketDeveloperActivity.this, DetailOnGoingTicketDeveloperActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String tiket= map.get(Konfigurasi.TAG_JSON_ID_TICKET).toString();
        myIntent.putExtra(Konfigurasi.TICKET_ID, tiket);
        startActivity(myIntent);
        */
    }
}