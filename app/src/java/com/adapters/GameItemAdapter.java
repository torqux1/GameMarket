package com.example.lenovo.fragmentsdialogslists.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.lenovo.fragmentsdialogslists.IOnItemClicked;
import com.example.lenovo.fragmentsdialogslists.OnGameClicked;
import com.example.lenovo.fragmentsdialogslists.R;
import com.example.lenovo.fragmentsdialogslists.models.CategoryItems;
import com.example.lenovo.fragmentsdialogslists.models.GameCategory;
import java.util.List;


public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.MyViewHolder> {
    private static List<CategoryItems> gameList;
    private static OnGameClicked itemClicekd;

    public void setCallback(OnGameClicked itemClicekd) {
        this.itemClicekd = itemClicekd;
    }

    @Override
    public GameItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_list, parent, false);
        return new GameItemAdapter.MyViewHolder(itemView);
    }

    public GameItemAdapter(List<CategoryItems> gameList) {
        this.gameList = gameList;
    }

    @Override
    public void onBindViewHolder(GameItemAdapter.MyViewHolder holder, int position) {
        CategoryItems game = gameList.get(position);
        holder.gameTitle.setText(game.getItemTitle());
        holder.gameDesc.setText(game.getItemDescription());
        holder.prizze.setText(game.getItemPrice());
        holder.image.setImageResource(game.getImageURI());
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView gameTitle, gameDesc, prizze;
        public ImageView image;
        public RelativeLayout parent;

        public MyViewHolder(View itemView) {
            super(itemView);
            gameTitle = (TextView) itemView.findViewById(R.id.gameName);
            gameDesc = (TextView) itemView.findViewById(R.id.gameDesc);
            image = (ImageView) itemView.findViewById(R.id.imageView2);
            prizze = (TextView) itemView.findViewById(R.id.prizze);
            parent = (RelativeLayout) itemView.findViewById(R.id.parent2);
            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClicekd != null) {
                        itemClicekd.onGameCLicked(gameList.get(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });
        }
    }
}



