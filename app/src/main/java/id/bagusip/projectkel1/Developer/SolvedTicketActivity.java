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
        binding.listSolvedTicket.setDivider(null);

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
                String reporter = object.getString(Konfigurasi.KEY_REPORTER);
                String person_in_charge = object.getString(Konfigurasi.KEY_PERSON_IN_CHARGE);
                String assign_date = object.getString(Konfigurasi.KEY_TICKET_ASSIGNED_DATE);
                String end_date = object.getString(Konfigurasi.KEY_TICKET_END_DATE);
                String problem_name = object.getString(Konfigurasi.KEY_PROBLEM_NAME);
                String problem_detail = object.getString(Konfigurasi.KEY_PROBLEM_DETAIL);
                String create_date = object.getString(Konfigurasi.KEY_CREATE_DATE);
                String dev_note = object.getString(Konfigurasi.KEY_NOTE_DEVELOPER);


                HashMap<String, String> queueTicket = new HashMap<>();
                queueTicket.put(Konfigurasi.KEY_TICKET_ID, id_ticket);
                queueTicket.put(Konfigurasi.KEY_REPORTER, reporter);
                queueTicket.put(Konfigurasi.KEY_PERSON_IN_CHARGE, person_in_charge);
                queueTicket.put(Konfigurasi.KEY_TICKET_ASSIGNED_DATE, assign_date);
                queueTicket.put(Konfigurasi.KEY_TICKET_END_DATE, end_date);
                queueTicket.put(Konfigurasi.KEY_PROBLEM_NAME, problem_name);
                queueTicket.put(Konfigurasi.KEY_PROBLEM_DETAIL, problem_detail);
                queueTicket.put(Konfigurasi.KEY_CREATE_DATE, create_date);
                queueTicket.put(Konfigurasi.KEY_NOTE_DEVELOPER, dev_note);
                list.add(queueTicket);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                SolvedTicketActivity.this, list, R.layout.list_solved_ticket_developer,
                new String[]{
                        Konfigurasi.KEY_TICKET_ID,
                        Konfigurasi.KEY_REPORTER,
                        Konfigurasi.KEY_CREATE_DATE,
                        Konfigurasi.KEY_TICKET_ASSIGNED_DATE,
                        Konfigurasi.KEY_TICKET_END_DATE,
                        Konfigurasi.KEY_PROBLEM_NAME,
                        Konfigurasi.KEY_PERSON_IN_CHARGE,
                        Konfigurasi.KEY_PROBLEM_DETAIL,
                        Konfigurasi.KEY_NOTE_DEVELOPER
                },
                new int[]{
                        R.id.txtDevIdTicketSolved,
                        R.id.txtDevEmpNameSolvedTicket,
                        R.id.txtDevSubmitDateTicketSolved,
                        R.id.txtDevAssignDateTicketSolved,
                        R.id.txtDevDateSolvedTicket,
                        R.id.txtDevProbNameSolved,
                        R.id.txtDevSolverName,
                        R.id.txtDevDetailProbSolved,
                        R.id.txtDevNoteSolvedTicket}
        );
        binding.listSolvedTicket.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}