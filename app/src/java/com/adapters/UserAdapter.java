package com.example.lenovo.fragmentsdialogslists.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.models.GameCategory;
import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private static List<String> itemList;

    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_items_list, parent, false);
        return new UserAdapter.MyViewHolder(itemView);
    }

    public UserAdapter(List<String> items) {
        this.itemList = items;
    }

    public void onBindViewHolder(UserAdapter.MyViewHolder holder, int position) {
        String[] tokens = itemList.get(position).split("\\,");
        String prize = tokens[1];
        String name = tokens[0];
        holder.productPrize.setText("Prize: " + prize);
        holder.productName.setText(name);
    }

    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productPrize;
        public RelativeLayout parent;


        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.itemName);
            productPrize = (TextView) itemView.findViewById(R.id.itemPrice);

        }
    }
}
