package id.bagusip.projectkel1.Developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import id.bagusip.projectkel1.OnGoingTicketDeveloperActivity;
import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;
import id.bagusip.projectkel1.databinding.ActivityDetailQueueTicketDeveloperBinding;

public class DetailQueueTicketDeveloperActivity extends AppCompatActivity implements View.OnClickListener {
    private String id_ticket, id_division, id_emp;
    private ActivityDetailQueueTicketDeveloperBinding binding;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailQueueTicketDeveloperBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent receiveIntent = getIntent();
        id_ticket = receiveIntent.getStringExtra(Konfigurasi.TAG_JSON_ID_TICKET);
        id_division = receiveIntent.getStringExtra(Konfigurasi.TAG_JSON_ID_DIVISION);
        id_emp = receiveIntent.getStringExtra(Konfigurasi.KEY_ID_EMP);

        binding.btnAssignTicketDev.setOnClickListener(this);
        updateQueueTicket();

    }

    private void updateQueueTicket() {

        class UpdateQueueTicket extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailQueueTicketDeveloperActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message, false,false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetMultiParamsResponse(Konfigurasi.URL_GET_DETAIL_QUEUE_TICKET_DEVELOPER, "id_division", id_division, "id_ticket", id_ticket);
                return result;
            }

            @Override
            protected void onPostExecute(String jsonData) {
                super.onPostExecute(jsonData);
                loading.dismiss();
                displayOnGoingTicket(jsonData);
            }
        }
        UpdateQueueTicket updateQueueTicket = new UpdateQueueTicket();
        updateQueueTicket.execute();

    }

    private void displayOnGoingTicket(String jsonData) {
        try{
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject object = result.getJSONObject(0);

            String idTicket, status, assignDate, problemName, createDate, nameEmp, branchName, problemDetail;
            idTicket = object.getString(Konfigurasi.KEY_TICKET_ID);
            status = object.getString(Konfigurasi.KEY_TICKET_STATUS);
            problemName = object.getString(Konfigurasi.KEY_PROBLEM_NAME);
            createDate = object.getString(Konfigurasi.KEY_CREATE_DATE);
            nameEmp = object.getString(Konfigurasi.KEY_NAME_EMP);
            branchName = object.getString(Konfigurasi.KEY_NAME_BRANCH);
            problemDetail = object.getString(Konfigurasi.KEY_PROBLEM_DETAIL);

            binding.txtIdQueueTicketDev.setText(idTicket);
            binding.txtStatusQueueTicketDev.setText(status);
            binding.txtProblemNameQueueTicketDev.setText(problemName);
            binding.txtCreateDateQueueTicketDev.setText(createDate);
            binding.txtNameEmpQueueTicketDev.setText(nameEmp);
            binding.txtBranchNameQueueTicketDev.setText(branchName);
            binding.txtProblemDetailQueueTicketDev.setText(problemDetail);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onClick(View buttons) {
        if (binding.btnAssignTicketDev.equals(buttons)){
            new AlertDialog.Builder(this).setTitle(Konfigurasi.STATUS_SOLVED)
                    .setMessage("Are you sure you want to Assign this ticket?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            saveData();
                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }
    }

    private void saveData() {
        class SaveData extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailQueueTicketDeveloperActivity.this, ConstantMenu.loading_title, ConstantMenu.loading_message, false, false);
            }
            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                HashMap<String, String> params = new HashMap<>();
                String idTicket, idSolver;

                idTicket = binding.txtIdQueueTicketDev.getText().toString();
                idSolver = id_emp;

                params.put(Konfigurasi.KEY_TICKET_ID, idTicket);
                params.put(Konfigurasi.KEY_ID_SOLVER, idSolver);
                String result = handler.sendPostRequest(Konfigurasi.URL_UPDATE_ON_GOING_TICKET_DETAIL_DEVELOPER, params);
                return result;
            }
            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                startActivity(new Intent(DetailQueueTicketDeveloperActivity.this, QueueTicketDeveloperActivity.class));
            }
        }
        SaveData saveData = new SaveData();
        saveData.execute();
    }
}