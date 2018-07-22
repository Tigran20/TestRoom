package com.example.system.testroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {

    private Context mContext;
    private List<Employee> mEmployees;

    public DbAdapter(Context context, List<Employee> employees) {
        mContext = context;
        mEmployees = employees;
    }

    @NonNull
    @Override
    public DbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.inventory_item, viewGroup, false);
        return new DbAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DbAdapter.ViewHolder holder, int position) {
        Employee employee = mEmployees.get(position);
        holder.name.setText(employee.name);
        holder.salary.setText(String.valueOf(employee.salary));
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

    public void setData(List<Employee> newData) {
        mEmployees = newData;
        notifyDataSetChanged();
    }
}
