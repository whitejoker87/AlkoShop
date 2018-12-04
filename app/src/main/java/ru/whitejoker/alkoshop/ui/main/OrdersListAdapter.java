package ru.whitejoker.alkoshop.ui.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.whitejoker.alkoshop.R;
import ru.whitejoker.alkoshop.UserOrder;
import ru.whitejoker.alkoshop.databinding.OrderBinding;

public class OrdersListAdapter extends RecyclerView.Adapter<OrdersListAdapter.OrderViewHolder> {

    OrdersItemListAdapter ordersItemListAdapter;

    List<UserOrder> ordersList;

    public OrdersListAdapter(List<UserOrder> ordersList) {
        if (ordersList == null) {
            throw new IllegalArgumentException("ordersList must be not null");
        }
        this.ordersList = ordersList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        OrderBinding orderBinding = DataBindingUtil.inflate(inflater, R.layout.order, parent,false);
        return new OrderViewHolder(orderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.bind(ordersList.get(position));
        ordersItemListAdapter = new OrdersItemListAdapter(ordersList.get(position).getItems());
        holder.orderBinding.recyclerView.setAdapter(ordersItemListAdapter);
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        OrderBinding orderBinding;

        public OrderViewHolder(OrderBinding orderBinding) {
            super(orderBinding.getRoot());
            RecyclerView ordersList = orderBinding.recyclerView;
            RecyclerView.LayoutManager layout = new LinearLayoutManager(orderBinding.getRoot().getContext());
            if (!layout.isAutoMeasureEnabled())layout.setAutoMeasureEnabled(true);
            ordersList.setLayoutManager(layout);
        }

        public void bind(UserOrder order) {
            orderBinding.setOrder(order);
            orderBinding.executePendingBindings();
        }

    }

}
