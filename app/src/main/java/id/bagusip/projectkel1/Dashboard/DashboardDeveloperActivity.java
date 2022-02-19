package id.bagusip.projectkel1.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.bagusip.projectkel1.Developer.SolvedTicketActivity;
import id.bagusip.projectkel1.Developer.TicketHistoryDeveloperActivity;
import id.bagusip.projectkel1.MainActivity;
import id.bagusip.projectkel1.OnGoingTicketDeveloperActivity;
import id.bagusip.projectkel1.Developer.QueueTicketDeveloperActivity;
import id.bagusip.projectkel1.R;
import id.bagusip.projectkel1.Utility.ConstantMenu;
import id.bagusip.projectkel1.config.Konfigurasi;

public class DashboardDeveloperActivity extends AppCompatActivity implements View.OnClickListener {

    private String role, access_token, email, name_emp, id_division, id_emp;
    private CardView menuDevQueueTicket, menuDevOnGoingTicket, menuDevSolvedTicket, menuDevTicketHistory;
    private TextView txtMenuDevNameDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_developer);

        getSupportActionBar().setElevation(0);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        txtMenuDevNameDashboard = findViewById(R.id.txtMenuDevNameDashboard);

        menuDevOnGoingTicket = findViewById(R.id.menuDevOnGoingTicket);
        menuDevQueueTicket = findViewById(R.id.menuDevQueueTicket);
        menuDevSolvedTicket = findViewById(R.id.menuDevSolvedTicket);
        menuDevTicketHistory = findViewById(R.id.menuDevTicketHistory);

        role = extras.getString(Konfigurasi.response_login_role);
        access_token = extras.getString(Konfigurasi.response_login_user_access_token);
        email = extras.getString(Konfigurasi.response_login_email);
        name_emp = extras.getString(Konfigurasi.response_login_user_name);
        id_division = extras.getString(Konfigurasi.response_login_id_division);
        id_emp = extras.getString(Konfigurasi.KEY_ID_EMP);

        txtMenuDevNameDashboard.setText(name_emp);

        menuDevTicketHistory.setOnClickListener(this);
        menuDevOnGoingTicket.setOnClickListener(this);
        menuDevQueueTicket.setOnClickListener(this);
        menuDevSolvedTicket.setOnClickListener(this);

    }

    @Override
    public void onClick(View menu) {
        Bundle bundleParams = new Bundle();
        bundleParams.putString(Konfigurasi.response_login_user_role, role);
        bundleParams.putString(Konfigurasi.response_login_email, email);
        bundleParams.putString(Konfigurasi.response_login_user_access_token, access_token);
        bundleParams.putString(Konfigurasi.KEY_NAMA_ID_DIVISION, id_division);
        bundleParams.putString(Konfigurasi.KEY_ID_EMP, id_emp);

        switch (menu.getId()){
            case R.id.menuDevOnGoingTicket:
                Intent moveOnGoingTicket = new Intent(this, OnGoingTicketDeveloperActivity.class);
                moveOnGoingTicket.putExtras(bundleParams);
                startActivity(moveOnGoingTicket);
                break;
            case R.id.menuDevQueueTicket:
                Intent moveQueueTicket = new Intent(this, QueueTicketDeveloperActivity.class);
                moveQueueTicket.putExtras(bundleParams);
                startActivity(moveQueueTicket);
                break;
            case R.id.menuDevSolvedTicket:
                Intent moveSolvedTicket = new Intent(this, SolvedTicketActivity.class);
                moveSolvedTicket.putExtras(bundleParams);
                startActivity(moveSolvedTicket);
                break;
            case R.id.menuDevTicketHistory:
                Intent moveMenuTicketHistory = new Intent(this, TicketHistoryDeveloperActivity.class);
                moveMenuTicketHistory.putExtras(bundleParams);
                startActivity(moveMenuTicketHistory);
                break;
            default:
                Toast.makeText(this, ConstantMenu.error_message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                Intent intent = new Intent(DashboardDeveloperActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() { }
}