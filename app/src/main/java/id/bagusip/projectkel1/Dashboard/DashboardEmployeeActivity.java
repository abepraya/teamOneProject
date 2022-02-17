package id.bagusip.projectkel1.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.bagusip.projectkel1.Employee.CreateTicketActivity;
import id.bagusip.projectkel1.Employee.MyTicketActivity;
import id.bagusip.projectkel1.MainActivity;
import id.bagusip.projectkel1.R;

public class DashboardEmployeeActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cardMyTicket, cardCreateTicket;
    String role, access_token, email, name_emp;
    TextView txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_employee);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");
        name_emp = extras.getString("name_emp");


        cardMyTicket = findViewById(R.id.cardMyTicket);
        cardCreateTicket = findViewById(R.id.cardCreateTicket);
        txtNama = findViewById(R.id.txtNama);

        txtNama.setText(name_emp);

        cardMyTicket.setOnClickListener(this);
        cardCreateTicket.setOnClickListener(this);

        getSupportActionBar().setElevation(0);

//        Toast.makeText(this, name_emp, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if(view == cardCreateTicket){
            Intent intent = new Intent(DashboardEmployeeActivity.this, CreateTicketActivity.class);
            Bundle extras = new Bundle();
            extras.putString("role",role);
            extras.putString("access_token",access_token);
            extras.putString("email",email);
            intent.putExtras(extras);
            startActivity(intent);
        }
        else if (view == cardMyTicket){
            Intent intent = new Intent(DashboardEmployeeActivity.this, MyTicketActivity.class);
            Bundle extras = new Bundle();
            extras.putString("role",role);
            extras.putString("access_token",access_token);
            extras.putString("email",email);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}