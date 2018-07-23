package com.example.system.testroom.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.system.testroom.R;
import com.example.system.testroom.model.Employee;

import java.util.List;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {

    private List<Employee> mEmployees;

    public DbAdapter(List<Employee> employees) {
        mEmployees = employees;
    }

    @NonNull
    @Override
    public DbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inventory_item, viewGroup, false);
        return new DbAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DbAdapter.ViewHolder holder, int position) {
        Employee employee = mEmployees.get(position);
        holder.name.setText(employee.getName());
        holder.salary.setText(String.valueOf(employee.getSalary()));
    }

    public void setData(List<Employee> newData) {
        mEmployees = newData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mEmployees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView salary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            salary = itemView.findViewById(R.id.product_price);
        }
    }
}
