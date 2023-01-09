package com.example.vintage_cloapp_coursework.activites.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vintage_cloapp_coursework.R;
import com.example.vintage_cloapp_coursework.adapters.HomeHorAdapter;
import com.example.vintage_cloapp_coursework.adapters.HomeVerAdapter;
import com.example.vintage_cloapp_coursework.adapters.UpdateVerticalRec;
import com.example.vintage_cloapp_coursework.models.HomeHorModel;
import com.example.vintage_cloapp_coursework.models.HomeVerModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

        RecyclerView homeHorizontalRec,homeVerticalRec;
        ArrayList<HomeHorModel> homeHorModelList;


        HomeHorAdapter homeHorAdapter;
        ////////////////////////////////VerticalRec
        ArrayList<HomeVerModel> homeVerModelList;
        HomeVerAdapter homeVerAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);


        homeVerticalRec = root.findViewById(R.id.home_ver_rec);


        ////////////////////////////////HorozontalRecylerview

        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new  HomeHorModel(R.drawable.jacket_icon,"Jacket"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.tshirt_icon,"Tshirt"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.shorts_icon,"Shorts"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.pants_icons,"Pants"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.hats_icon,"Hats"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.shoes_icon,"Shoes"));
        homeHorModelList.add(new  HomeHorModel(R.drawable.bags_icons,"Bags"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);



        ////////////////////////////////VerticalRecylerview

        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.stussy_jacket,"Stussy 8 Ball Jacket ","4.4", "$275"));
        homeVerModelList.add(new HomeVerModel(R.drawable.f1_jacket,"Nascar Formula 1  Jacket ","3.9", "$75"));
        homeVerModelList.add(new HomeVerModel(R.drawable.palm_angel_monclizzy,"Palm Angel Monclizzy","4.8", "$5000"));



        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);


        homeVerticalRec.setAdapter(homeVerAdapter);

        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //homeVerticalRec.setHasFixedSize(true);
        //homeVerticalRec.setNestedScrollingEnabled(false);


        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}