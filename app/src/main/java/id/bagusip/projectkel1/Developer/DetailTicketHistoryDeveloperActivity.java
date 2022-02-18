package id.bagusip.projectkel1.Developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;
import id.bagusip.projectkel1.databinding.ActivityDetailTicketHistoryDeveloperBinding;

public class DetailTicketHistoryDeveloperActivity extends AppCompatActivity {

    private ActivityDetailTicketHistoryDeveloperBinding binding;
    private String ticket_id, emp_id;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailTicketHistoryDeveloperBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        Intent getIntentParams = getIntent();
        ticket_id = getIntentParams.getStringExtra(Konfigurasi.TAG_JSON_ID_TICKET);
        emp_id = getIntentParams.getStringExtra(Konfigurasi.KEY_ID_EMP);

        displayDetailHistoryTicket();
    }

    private void displayDetailHistoryTicket() {
        class DisplayDetailHistoryTicket extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailTicketHistoryDeveloperActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message, false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetMultiParamsResponse(Konfigurasi.URL_GET_DETAIL_HISTORY_TICKET_DEVELOPER,"id_solver", emp_id, "id_ticket", ticket_id);
                return result;
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);
                loading.dismiss();
                getDataHistory(data);
            }
        }
        DisplayDetailHistoryTicket displayDetailHistoryTicket = new DisplayDetailHistoryTicket();
        displayDetailHistoryTicket.execute();
    }


    private void getDataHistory(String jsonData) {
        try{
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject object = result.getJSONObject(0);

            String idTicket, status,assignDate, endDate, devNote, problemName, createDate, nameEmp, branchName, problemDetail;
            idTicket = object.getString(Konfigurasi.KEY_TICKET_ID);
            status = object.getString(Konfigurasi.KEY_TICKET_STATUS);
            assignDate = object.getString(Konfigurasi.KEY_TICKET_ASSIGNED_DATE);
            endDate = object.getString(Konfigurasi.KEY_TICKET_END_DATE);
            problemName = object.getString(Konfigurasi.KEY_PROBLEM_NAME);
            createDate = object.getString(Konfigurasi.KEY_CREATE_DATE);
            nameEmp = object.getString(Konfigurasi.KEY_NAME_EMP);
            branchName = object.getString(Konfigurasi.KEY_NAME_BRANCH);
            problemDetail = object.getString(Konfigurasi.KEY_PROBLEM_DETAIL);
            devNote = object.getString(Konfigurasi.KEY_NOTE_DEVELOPER);


            binding.txtIdHistoryTicketDev.setText(idTicket);
            binding.txtStatusHistoryTicketDev.setText(status);
//            binding.txt.setText(endDate);
//            binding.txtAss.setText(assignDate);
            binding.txtProblemNameHistoryTicketDev.setText(problemName);
            binding.txtCreateDateHistoryTicketDev.setText(createDate);
            binding.txtNameEmpHistoryTicketDev.setText(nameEmp);
            binding.txtBranchNameHistoryTicketDev.setText(branchName);
            binding.txtProblemDetailHistoryTicketDev.setText(problemDetail);
//            binding.txtDevN.setText(devNote);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}