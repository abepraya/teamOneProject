package id.bagusip.projectkel1.Developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.bagusip.projectkel1.R;

public class DetailOnGoingTicketDeveloperActivity extends AppCompatActivity {

    TextView txt_id_on_going_ticket_dev, txt_status_on_going_ticket_dev,
            txt_problem_name_on_going_ticket_dev, txt_name_emp_on_going_ticket_dev,
            txt_create_date_on_going_ticket_dev, txt_branch_name_on_going_ticket_dev,
            txt_problem_detail_on_going_ticket_dev;
    EditText txt_dev_note_on_going_ticket_dev;
    Button btn_solve_ticket_dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_on_going_ticket_developer);

        txt_id_on_going_ticket_dev = findViewById(R.id.txt_id_on_going_ticket_dev);
        txt_status_on_going_ticket_dev = findViewById(R.id.txt_status_on_going_ticket_dev);
        txt_problem_name_on_going_ticket_dev = findViewById(R.id.txt_problem_name_on_going_ticket_dev);
        txt_name_emp_on_going_ticket_dev = findViewById(R.id.txt_name_emp_on_going_ticket_dev);
        txt_create_date_on_going_ticket_dev = findViewById(R.id.txt_create_date_on_going_ticket_dev);
        txt_branch_name_on_going_ticket_dev = findViewById(R.id.txt_branch_name_on_going_ticket_dev);
        txt_problem_detail_on_going_ticket_dev = findViewById(R.id.txt_problem_detail_on_going_ticket_dev);
        txt_dev_note_on_going_ticket_dev = findViewById(R.id.txt_dev_note_on_going_ticket_dev);
        btn_solve_ticket_dev = findViewById(R.id.btn_solve_ticket_dev);

        btn_solve_ticket_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        getJSON();
    }

    private void getJSON() {
    }
}