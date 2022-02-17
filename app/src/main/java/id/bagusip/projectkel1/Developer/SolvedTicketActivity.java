package id.bagusip.projectkel1.Developer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import id.bagusip.projectkel1.R;

public class SolvedTicketActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list_solved_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_ticket);

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