package id.bagusip.projectkel1.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import id.bagusip.projectkel1.R;

public class QueueTicketEmployeeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    
    ListView list_queue_ticket_emp;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_ticket_employee);
        
        list_queue_ticket_emp = findViewById(R.id.list_queue_ticket_emp);
        list_queue_ticket_emp.setOnItemClickListener(this);
        
        getJSON();
    }

    private void getJSON() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        
    }
}