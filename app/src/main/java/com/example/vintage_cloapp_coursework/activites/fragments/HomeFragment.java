package com.example.vintage_cloapp_coursework.activites.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vintage_cloapp_coursework.R;
import com.example.vintage_cloapp_coursework.adapters.HomeHorAdapter;
import com.example.vintage_cloapp_coursework.databinding.FragmentHomeBinding;
import com.example.vintage_cloapp_coursework.models.HomeHorModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

        RecyclerView homeHorizontalRec;
        List<HomeHorModel> homeHorModelList;
        HomeHorAdapter homeHorAdapter;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));


        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new  HomeHorModel(R.drawable.jacket_icon,"Jacket"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.tshirt_icon,"Tshirt"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.shorts_icon,"Shorts"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.pants_icons,"Pants"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.hats_icon,"Hats"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.shoes_icon,"Shoes"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.bags_icons,"Bags"));

        homeHorAdapter = new HomeHorAdapter(getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
        return root;
    }


}