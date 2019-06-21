package com;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.adapters.GameCategoryAdapter;
import com.adapters.GameItemAdapter;
import com.models.CategoryItems;
import com.models.GameCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static Constants;


public class MainActivity extends AppCompatActivity implements IOnItemClicked,View.OnClickListener{
    protected Button loginButton;
    protected TextView userView;
    protected TextView passview;
    private List<String> itemsForUser;
    private TextView success;
    protected GameItemAdapter gameAdapter;
    protected RecyclerView recyclerViewGame;
    protected GameCategoryAdapter adapter;
    protected RecyclerView recyclerView;
    private DrawerLayout mDrawerLayout;
    private final USERNAME = 'root';
    private final PASSWORD = 'root';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        List<GameCategory> categories = GameCategory.listAll(GameCategory.class);
        userView = (TextView) findViewById(R.id.username_type);
        passview = (TextView) findViewById(R.id.pass_type);
        success = (TextView) findViewById(R.id.success);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        recyclerView = (RecyclerView)findViewById(R.id.left_drawer);
        adapter = new GameCategoryAdapter(categories);
        itemsForUser = new ArrayList<>();
        Intent intent = this.getIntent();
        
		if(intent.hasExtra("items")){
            itemsForUser = intent.getStringArrayListExtra("items");
        }
        adapter.setCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }



    @Override
    public void onItemClicked(GameCategory category, int position) {
        List<CategoryItems> categoyList = category.getAllCategoryItems(category);
        Bundle bundle = new Bundle();
        bundle.putSerializable("game", (Serializable) categoyList);
        bundle.putStringArrayList("list", (ArrayList<String>) itemsForUser);

        Intent intent = new Intent(this,GameLayout.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.loginButton){
            if(userView.getText().toString().equals(USERNAME) && passview.getText().toString().equals(PASSWORD)){
                Bundle bundle = new Bundle();
                Intent intent = this.getIntent();
                if(intent.hasExtra("items")){
                    itemsForUser = intent.getStringArrayListExtra("items");
                }
                bundle.putStringArrayList("list", (ArrayList<String>) itemsForUser);
                Intent intent1 = new Intent(this,UserActivity.class);
                intent1.putExtras(bundle);

                startActivity(intent1);
                Toast.makeText(this, Constants.SUCC_LOGIN, Toast.LENGTH_SHORT).show();
                loginButton.setVisibility(View.GONE);
                userView.setVisibility(View.GONE);
                passview.setVisibility(View.GONE);
                success.setText(Constants.CURR_LOGGED_IN);

            }
            else {
                Toast.makeText(this,Constants.UNSUCC_LOGIN, Toast.LENGTH_SHORT).show();
            }
        }
    }
}


