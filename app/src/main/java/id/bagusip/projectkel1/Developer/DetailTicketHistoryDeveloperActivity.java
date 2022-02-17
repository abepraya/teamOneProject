package id.bagusip.projectkel1.Developer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.bagusip.projectkel1.R;

public class DetailTicketHistoryDeveloperActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_id_history_ticket_dev, txt_status_history_ticket_dev,
            txt_problem_name_history_ticket_dev, txt_create_date_history_ticket_dev,
            txt_name_emp_history_ticket_dev, txt_branch_name_history_ticket_dev;

    EditText txt_problem_detail_history_ticket_dev;
    Button btn_back_to_history_ticket_dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ticket_history_developer);

        txt_id_history_ticket_dev = findViewById(R.id.txt_id_history_ticket_dev);
        txt_status_history_ticket_dev = findViewById(R.id.txt_status_history_ticket_dev);
        txt_problem_name_history_ticket_dev = findViewById(R.id.txt_problem_name_history_ticket_dev);
        txt_create_date_history_ticket_dev = findViewById(R.id.txt_create_date_history_ticket_dev);
        txt_name_emp_history_ticket_dev = findViewById(R.id.txt_name_emp_history_ticket_dev);
        txt_branch_name_history_ticket_dev = findViewById(R.id.txt_branch_name_history_ticket_dev);
        txt_problem_detail_history_ticket_dev = findViewById(R.id.txt_problem_detail_history_ticket_dev);
        btn_back_to_history_ticket_dev = findViewById(R.id.btn_back_to_history_ticket_dev);

        btn_back_to_history_ticket_dev.setOnClickListener(this);

        getJSON();
    }

    private void getJSON() {
    }

    @Override
    public void onClick(View view) {

    }
}