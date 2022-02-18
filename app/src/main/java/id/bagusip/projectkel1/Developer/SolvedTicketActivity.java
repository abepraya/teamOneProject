package id.bagusip.projectkel1.Developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.config.Konfigurasi;

public class SolvedTicketActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView list_solved_ticket;
    private String id_division, id_emp;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_ticket);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent getIntentParams = getIntent();
        id_division = getIntentParams.getStringExtra(Konfigurasi.response_login_id_division);
        id_emp = getIntentParams.getStringExtra(Konfigurasi.KEY_ID_EMP);
        System.out.println("id_division:" + id_division);
        System.out.println("id_emp:" + id_emp);

        list_solved_ticket =findViewById(R.id.list_solved_ticket);
        list_solved_ticket.setOnItemClickListener(this);

        getJSON();
    }

    private void getJSON() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}