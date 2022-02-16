package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import id.bagusip.projectkel1.config.HttpHandler;

public class DetailQueueTicketDeveloperActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt_id_queue_ticket_dev, txt_status_queue_ticket_dev, txt_name_emp_queue_ticket_dev,
            txt_create_date_queue_ticket_dev, txt_problem_name_queue_ticket_dev,
            txt_problem_detail_queue_ticket_dev, txt_branch_name_queue_ticket_dev;
    Button btn_assign_ticket_dev, btn_reject_ticket_dev;
    String ticket_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_queue_ticket_developer);
        txt_id_queue_ticket_dev = findViewById(R.id.txt_id_queue_ticket_dev);
        txt_status_queue_ticket_dev = findViewById(R.id.txt_status_queue_ticket_dev);
        txt_name_emp_queue_ticket_dev = findViewById(R.id.txt_status_queue_ticket_dev);
        txt_create_date_queue_ticket_dev = findViewById(R.id.txt_create_date_queue_ticket_dev);
        txt_problem_name_queue_ticket_dev = findViewById(R.id.txt_problem_name_queue_ticket_dev);
        txt_problem_detail_queue_ticket_dev = findViewById(R.id.txt_problem_detail_queue_ticket_dev);
        txt_branch_name_queue_ticket_dev = findViewById(R.id.txt_branch_name_queue_ticket_dev);
        btn_assign_ticket_dev = findViewById(R.id.btn_assign_ticket_dev);
        btn_reject_ticket_dev = findViewById(R.id.btn_reject_ticket_dev);

        Intent receiveIntent = getIntent();
//        ticket_id = receiveIntent.getStringExtra(Konfigurasi.TICKET_ID);
        txt_id_queue_ticket_dev.setText(ticket_id);
        btn_assign_ticket_dev.setOnClickListener(this);
        btn_reject_ticket_dev.setOnClickListener(this);

        getJSON();

    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailQueueTicketDeveloperActivity.this,
                        "Mengambil Data", "Harap menunggu...",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
//                String result = handler.sendGetResponse(Konfigurasi.URL_DETAIL_QUEUE_TICKET_DEVELOPER, ticket_id);
//                return result;
                return null;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                displayDetailQueue(message);
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();

    }

    private void displayDetailQueue(String message) {

    }

    @Override
    public void onClick(View view) {
        if( view == btn_assign_ticket_dev){
            Toast.makeText(this, "Belum Tambahin Fungsi Assign", Toast.LENGTH_SHORT).show();
        } else if (view == btn_reject_ticket_dev )
            Toast.makeText(this, "Belum Tambahin Fungsi Reject", Toast.LENGTH_SHORT).show();
    }
}