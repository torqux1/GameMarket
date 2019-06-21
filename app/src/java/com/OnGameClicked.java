package com.example.lenovo.fragmentsdialogslists;

import com.example.lenovo.fragmentsdialogslists.adapters.GameItemAdapter;
import com.example.lenovo.fragmentsdialogslists.models.CategoryItems;


public interface OnGameClicked {
    void onGameCLicked(CategoryItems category, int position);
}
