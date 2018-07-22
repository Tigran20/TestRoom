package com.example.system.testroom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DbAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView emptyView;
    private FloatingActionButton mFloatingActionButton;
    private List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_list);

        bd();
    }

    private void bd() {
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();

        mFloatingActionButton = findViewById(R.id.fab);
        emptyView = findViewById(R.id.empty_view);
        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        adapter = new DbAdapter(this, employees);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        employees = employeeDao.getAll();
        adapter.setData(employees);

        if (employees.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }

        mFloatingActionButton.setOnClickListener(view -> {
            Employee employee = new Employee();
            employee.name = "Alex Troy";
            employee.salary = 974;
            employeeDao.insert(employee);
        });
    }
}
