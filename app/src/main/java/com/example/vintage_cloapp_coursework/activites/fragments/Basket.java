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
import com.example.vintage_cloapp_coursework.adapters.CartAdapter;
import com.example.vintage_cloapp_coursework.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class Basket extends Fragment {

    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    //ArrayList<HomeVerModel> modelList = new ArrayList<>();
    //Context context;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //HomeVerAdapter adapter = new HomeVerAdapter(context, modelList);

        View view = inflater.inflate(R.layout.basket_fragment,container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.palm_angel_monclizzy, "Palm Angel Monclizzy","$5000","4.9"));
        list.add(new CartModel(R.drawable.anime_girl_tshirt,"Anime Girl Tshirt ","$27", "4.4"));
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);















        /*
        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();

        /*Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<CartModel> cartList = bundle.getParcelableArrayList("cart_list");
            // Use the values from the cartList array to update the UI or perform some other action
            list.addAll(cartList);
            cartAdapter.notifyDataSetChanged();
        }*/
        /*
        list.add(new CartModel(R.drawable.palm_angel_monclizzy, "Palm Angel Monclizzy","$5000","4.9"));
        list.add(new CartModel(R.drawable.anime_girl_tshirt,"Anime Girl Tshirt ","$27", "4.4"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);


        */

        return view;

    }

}