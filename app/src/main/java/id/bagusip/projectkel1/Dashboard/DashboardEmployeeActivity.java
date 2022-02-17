package id.bagusip.projectkel1.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.bagusip.projectkel1.Employee.CreateTicketActivity;
import id.bagusip.projectkel1.Employee.MyTicketActivity;
import id.bagusip.projectkel1.MainActivity;
import id.bagusip.projectkel1.R;

public class DashboardEmployeeActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cardMyTicket, cardCreateTicket;
    String role, access_token, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_employee);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");


        cardMyTicket = findViewById(R.id.cardMyTicket);
        cardCreateTicket = findViewById(R.id.cardCreateTicket);

        cardMyTicket.setOnClickListener(this);
        cardCreateTicket.setOnClickListener(this);

        Toast.makeText(this, access_token, Toast.LENGTH_SHORT).show();
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