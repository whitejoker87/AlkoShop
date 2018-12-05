package ru.whitejoker.alkoshop.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import ru.whitejoker.alkoshop.R;
import ru.whitejoker.alkoshop.model.UserOrder;
import ru.whitejoker.alkoshop.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainViewModel model;
    private MainFragmentBinding binding;

    private RecyclerView listOrders;
    private OrdersListAdapter ordersListAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.main_fragment,
                container,
                false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listOrders = binding.listOrders;
        listOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        model = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainViewModel.class);
        model.getDataFromJSON().observe(this, new Observer<List<UserOrder>>() {
            @Override
            public void onChanged(@Nullable List<UserOrder> orders) {
                if (orders != null) {
                    if (listOrders.getAdapter() == null) {
                        ordersListAdapter = new OrdersListAdapter(orders);
                        listOrders.setAdapter(ordersListAdapter);
                    }
                    else ordersListAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
