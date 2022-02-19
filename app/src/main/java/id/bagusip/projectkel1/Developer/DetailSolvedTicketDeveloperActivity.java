package id.bagusip.projectkel1.Developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.bagusip.projectkel1.R;

public class DetailSolvedTicketDeveloperActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_id_solved_ticket_dev, txt_status_solved_ticket_dev,
            txt_problem_name_solved_ticket_dev, txt_create_date_solved_ticket_dev,
            txt_name_emp_solved_ticket_dev, txt_branch_name_solved_ticket_dev;

    EditText txt_problem_detail_solved_ticket_dev;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_solved_ticket_developer);

        txt_id_solved_ticket_dev = findViewById(R.id.txt_id_solved_ticket_dev);
        txt_status_solved_ticket_dev = findViewById(R.id.txt_status_solved_ticket_dev);
        txt_problem_name_solved_ticket_dev = findViewById(R.id.txt_problem_name_solved_ticket_dev);
        txt_create_date_solved_ticket_dev = findViewById(R.id.txt_create_date_solved_ticket_dev);
        txt_name_emp_solved_ticket_dev = findViewById(R.id.txt_name_emp_solved_ticket_dev);
        txt_branch_name_solved_ticket_dev = findViewById(R.id.txt_branch_name_solved_ticket_dev);
        txt_problem_detail_solved_ticket_dev = findViewById(R.id.txt_problem_detail_solved_ticket_dev);


//        Intent recievedIntent = getIntent();

        getJSON();


    }

    private void getJSON() {
    }

    @Override
    public void onClick(View view) {

    }
}