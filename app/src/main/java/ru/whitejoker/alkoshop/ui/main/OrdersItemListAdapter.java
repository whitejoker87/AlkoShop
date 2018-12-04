package ru.whitejoker.alkoshop.ui.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.whitejoker.alkoshop.R;
import ru.whitejoker.alkoshop.UserOrderItem;
import ru.whitejoker.alkoshop.databinding.OrderItemBinding;

public class OrdersItemListAdapter extends RecyclerView.Adapter<OrdersItemListAdapter.OrdersItemViewHolder> {

    List<UserOrderItem> orderItems;

    public OrdersItemListAdapter(List<UserOrderItem> orderItems) {

        if (orderItems == null) {
            throw new IllegalArgumentException("ItemsList must not be null");
        }
        this.orderItems = orderItems;
    }


    @NonNull
    @Override
    public OrdersItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        OrderItemBinding orderItemBinding = DataBindingUtil.inflate(inflater, R.layout.order_item, parent, false);
        return new OrdersItemViewHolder(orderItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersItemViewHolder holder, int position) {
        holder.bind(orderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class OrdersItemViewHolder extends RecyclerView.ViewHolder {

        OrderItemBinding orderItemBinding;

        public OrdersItemViewHolder(OrderItemBinding orderItemBinding) {
            super(orderItemBinding.getRoot());
            this.orderItemBinding = orderItemBinding;
        }

        public void bind(UserOrderItem orderItem) {
            orderItemBinding.setOrderItem(orderItem);
            orderItemBinding.executePendingBindings();
        }
    }
}
