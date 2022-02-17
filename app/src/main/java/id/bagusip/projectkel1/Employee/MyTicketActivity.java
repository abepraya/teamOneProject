package id.bagusip.projectkel1.Employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.bagusip.projectkel1.Dashboard.DashboardEmployeeActivity;
import id.bagusip.projectkel1.R;

public class MyTicketActivity extends AppCompatActivity implements View.OnClickListener{
    CardView cardQueueTicket, cardOngoingTicket, cardSolvedTicket;
    String role, access_token, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        role = extras.getString("role");
        access_token = extras.getString("access_token");
        email = extras.getString("email");

        cardQueueTicket = findViewById(R.id.cardQueueTicket);
        cardOngoingTicket = findViewById(R.id.cardOngoingTicket);
        cardSolvedTicket = findViewById(R.id.cardSolvedTicket);

        cardQueueTicket.setOnClickListener(this);
        cardOngoingTicket.setOnClickListener(this);
        cardSolvedTicket.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == cardQueueTicket){
            Intent intent = new Intent(MyTicketActivity.this, QueueTicketEmployeeActivity.class);
            Bundle extras = new Bundle();
            extras.putString("role",role);
            extras.putString("access_token",access_token);
            extras.putString("email",email);
            intent.putExtras(extras);
            startActivity(intent);
        }
        else if(view == cardOngoingTicket){
            Intent intent = new Intent(MyTicketActivity.this, OnGoingTicketEmployeeActivity.class);
            Bundle extras = new Bundle();
            extras.putString("role",role);
            extras.putString("access_token",access_token);
            extras.putString("email",email);
            intent.putExtras(extras);
            startActivity(intent);
        }
        else if(view == cardSolvedTicket){
            Intent intent = new Intent(MyTicketActivity.this, SolvedTicketEmployeeActivity.class);
            Bundle extras = new Bundle();
            extras.putString("role",role);
            extras.putString("access_token",access_token);
            extras.putString("email",email);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}