package com.example.vintage_cloapp_coursework.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vintage_cloapp_coursework.R;
import com.example.vintage_cloapp_coursework.models.HomeHorModel;
import com.example.vintage_cloapp_coursework.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>{


    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    Context context;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    public HomeHorAdapter(Context context, ArrayList<HomeHorModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));




    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check){
            ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.palm_angel_monclizzy,"Palm Angel Monclizzy","4.8", "$5000"));
            homeVerModels.add(new HomeVerModel(R.drawable.stussy_jacket,"Stussy 8 Ball Jacket ","4.4", "$275"));
            homeVerModels.add(new HomeVerModel(R.drawable.f1_jacket,"Nascar Formula 1  Jacket ","3.9", "$75"));


            updateVerticalRec.callBack(position,homeVerModels);
            check = false;
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();

                    if(position == 0){//Jacket
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.palm_angel_monclizzy,"Palm Angel Monclizzy","4.8", "$5000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.stussy_jacket,"Stussy 8 Ball Jacket ","4.4", "$275"));
                        homeVerModels.add(new HomeVerModel(R.drawable.f1_jacket,"Nascar Formula 1  Jacket ","3.9", "$75"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if (position ==1 ){//Tshirt
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.slick_angel_tshirt," Slick Angel Tshirt","3.2", "$19"));
                        homeVerModels.add(new HomeVerModel(R.drawable.anime_girl_tshirt,"Anime Girl Tshirt ","4.4", "$27"));
                        homeVerModels.add(new HomeVerModel(R.drawable.band_tshirt,"Band Tshirt ","3.9", "$15"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if (position ==2 ){//Shorts
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.star_shorts,"Star Shorts","4.8", "$50"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if (position ==3 ){//Pants
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.green_cargo_pants,"Green Cargo Pants","4.8", "$32"));
                        homeVerModels.add(new HomeVerModel(R.drawable.camo_cargo_pants,"Surplus Infantry Cargo Pants ","4.4", "$75"));


                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if (position ==4 ){//Hats
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.black_trucker_hat,"Black Trucker Hat","4.8", "$21"));


                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if (position ==5 ){//Shoes
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.nb_350s_green,"Green NB 550s","4.8", "$120"));
                        homeVerModels.add(new HomeVerModel(R.drawable.blue_lv_shoes,"Louis Vuitton (Bleu Ciel)","3.9", "$1500"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if (position ==6 ){//Bags
                        ArrayList<HomeVerModel>homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.brown_nike_sling_bag,"Brown Nike Sling Bag","4.8", "$5000"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                }
            });
                if(select){
                        if(position == 0){
                            holder. cardView.setBackgroundResource(R.drawable.change_bg);
                        }
                }
                else{
                    if(row_index == position){
                        holder. cardView.setBackgroundResource(R.drawable.change_bg);
                    }else{
                        holder. cardView.setBackgroundResource(R.drawable.defualt_bg);
                    }
                }


        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name =  itemView.findViewById(R.id.hor_text);
            cardView =  itemView.findViewById(R.id.cardView);


        }
    }
}
