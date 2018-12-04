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

import java.io.InputStreamReader;

import ru.whitejoker.alkoshop.R;
import ru.whitejoker.alkoshop.UserOrdersResponse;
import ru.whitejoker.alkoshop.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainViewModel model;
    private MainFragmentBinding binding;

    private RecyclerView listOrders;

    UserOrdersResponse response;

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
        model = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        model.getReaderJSON().observe(this, new Observer<InputStreamReader>() {
            @Override
            public void onChanged(@Nullable InputStreamReader inputStreamReader) {
                response = UserOrdersResponse.fromJson(inputStreamReader);
                listOrders.setAdapter(new OrdersListAdapter(response.getData()));
            }
        });
        // TODO: Use the ViewModel
    }

}
