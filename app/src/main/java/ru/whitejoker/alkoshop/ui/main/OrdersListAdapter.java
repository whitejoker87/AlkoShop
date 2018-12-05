package ru.whitejoker.alkoshop.ui.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.whitejoker.alkoshop.R;
import ru.whitejoker.alkoshop.model.UserOrder;
import ru.whitejoker.alkoshop.model.UserOrderItem;
import ru.whitejoker.alkoshop.databinding.OrderBinding;

public class OrdersListAdapter extends RecyclerView.Adapter<OrdersListAdapter.OrderViewHolder> {

    private List<UserOrder> ordersList;

    OrdersListAdapter(List<UserOrder> ordersList) {
        if (ordersList == null) {
            throw new IllegalArgumentException("ordersList must be not null");
        }
        this.ordersList = ordersList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        OrderBinding orderBinding = DataBindingUtil.inflate(inflater, R.layout.order, parent, false);
        return new OrderViewHolder(orderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        List<UserOrderItem> items = ordersList.get(position).getItems();
        int sum = 0;
        for (UserOrderItem item:items) {
            sum += item.getPrice();
        }
        holder.bind(ordersList.get(position));
        String sumStr = "Сумма заказа: " + sum;
        String toPayStr = "К оплате: " + (sum + ordersList.get(position).getDelivery() - ordersList.get(position).getDiscountRub());
        holder.orderBinding.tvSumOrder.setText(sumStr);
        holder.orderBinding.tvToPay.setText(toPayStr);
        OrdersItemListAdapter ordersItemListAdapter = new OrdersItemListAdapter(items);
        holder.orderBinding.recyclerOrderItems.setAdapter(ordersItemListAdapter);
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        OrderBinding orderBinding;

        OrderViewHolder(OrderBinding orderBinding) {
            super(orderBinding.getRoot());
            this.orderBinding = orderBinding;
            RecyclerView ordersList = orderBinding.recyclerOrderItems;
            RecyclerView.LayoutManager layout = new LinearLayoutManager(orderBinding.getRoot().getContext());
            if (!layout.isAutoMeasureEnabled())layout.setAutoMeasureEnabled(true);
            ordersList.setLayoutManager(layout);
        }

        void bind(UserOrder order) {
            orderBinding.setOrder(order);
            orderBinding.executePendingBindings();
        }

    }

}
