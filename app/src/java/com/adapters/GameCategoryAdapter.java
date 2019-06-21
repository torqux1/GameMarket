package com.example.lenovo.fragmentsdialogslists.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.lenovo.fragmentsdialogslists.models.GameCategory;
import com.example.lenovo.fragmentsdialogslists.IOnItemClicked;
import com.example.lenovo.fragmentsdialogslists.R;
import java.util.List;


public class GameCategoryAdapter extends RecyclerView.Adapter<GameCategoryAdapter.MyViewHolder> {
    private static List<GameCategory> categoryList;
    private static IOnItemClicked itemClicekd;

    public void setCallback(IOnItemClicked itemClicekd){
        this.itemClicekd = itemClicekd;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
        return new MyViewHolder(itemView);
    }

    public GameCategoryAdapter(List<GameCategory> newsList) {
        this.categoryList = newsList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GameCategory game = categoryList.get(position);
        holder.categoryTitle.setText(game.getName());
        holder.categoryDesc.setText(game.getDescription());
        holder.image.setImageResource(game.getImage());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView categoryTitle,categoryDesc;
        public ImageView image;
        public RelativeLayout parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            categoryTitle = (TextView) itemView.findViewById(R.id.category_title);
            categoryDesc = (TextView) itemView.findViewById(R.id.category_desc);
            image = (ImageView)itemView.findViewById(R.id.imageView);
            parent = (RelativeLayout)itemView.findViewById(R.id.parent);
            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemClicekd!=null){
                        itemClicekd.onItemClicked(categoryList.get(getAdapterPosition()),getAdapterPosition());
                    }
                }
            });
        }
    }
}
