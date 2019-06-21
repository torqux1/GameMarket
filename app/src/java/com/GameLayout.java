package com;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.adapters.GameCategoryAdapter;
import com.adapters.GameItemAdapter;
import com.models.CategoryItems;
import com.models.GameCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GameLayout extends AppCompatActivity implements OnGameClicked {
    protected GameItemAdapter gameAdapter;
    protected RecyclerView recyclerViewGame;
    protected List<String> items;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Create launched", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.game_category_layout);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        List<CategoryItems> thumbs=(List<CategoryItems>)bundle.getSerializable("game");
        items = (List<String>)bundle.getStringArrayList("list");
        recyclerViewGame = (RecyclerView)findViewById(R.id.gameVIew);
        gameAdapter = new GameItemAdapter(thumbs);
        gameAdapter.setCallback(this);
        recyclerViewGame.setLayoutManager(new LinearLayoutManager(recyclerViewGame.getContext()));
        recyclerViewGame.setAdapter(gameAdapter);
    }


    @Override
    public void onGameCLicked(CategoryItems category, int position) {
        this.items.add(category.getItemTitle() + "," + category.getItemPrice());
        Intent intent = new Intent(this,UserActivity.class);
        intent.putStringArrayListExtra("items", (ArrayList<String>) items);
        startActivity(intent);
    }
	
}
