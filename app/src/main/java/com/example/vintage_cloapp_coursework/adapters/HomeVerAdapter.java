package com.example.vintage_cloapp_coursework.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vintage_cloapp_coursework.R;
import com.example.vintage_cloapp_coursework.models.CartModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder>{


    private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<CartModel> list;

    public HomeVerAdapter(Context context, ArrayList<CartModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  String mName = list.get(position).getName();
        final  String mPrice = list.get(position).getPrice();
        final  String mRating = list.get(position).getRating();
        final int mImage = list.get(position).getImage();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context,"Added To Cart",Toast.LENGTH_SHORT).show();
                        list.add(new CartModel(mImage,mName,mPrice, mRating));
                        bottomSheetDialog.dismiss();

                    }
                });

                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName =  sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice =  sheetView.findViewById(R.id.bottom_money_ammount);
                TextView bottomRating =  sheetView.findViewById(R.id.bottom_ratings_num);

                bottomName.setText(mName);
                bottomPrice.setText(mPrice);
                bottomRating.setText(mRating);
                bottomImg.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();


            }
        });

    }

    @Override
    public int getItemCount() {
          return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,rating,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.productname);
            rating = itemView.findViewById(R.id.ratings);
            price = itemView.findViewById(R.id.price);

        }
    }
}
