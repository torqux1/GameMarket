package com.example.lenovo.fragmentsdialogslists;

import android.os.Bundle;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lenovo.fragmentsdialogslists.adapters.GameItemAdapter;
import com.example.lenovo.fragmentsdialogslists.adapters.UserAdapter;
import com.example.lenovo.fragmentsdialogslists.models.CategoryItems;
import com.example.lenovo.fragmentsdialogslists.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class UserActivity extends AppCompatActivity {
    private User user;
    private TextView name;
    private TextView currentBill;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<String> items;
    private ImageView imageView;
    private final TEST_USER = 'Ivaylo';
	
    public UserActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_account);
        recyclerView = (RecyclerView) findViewById(R.id.profileView);
        Intent intent = this.getIntent();


        if (intent.hasExtra("items")) {
            items =
                    intent.getStringArrayListExtra("items");
        }
        else items = new ArrayList<>();

        userAdapter = new UserAdapter(items);
        imageView = (ImageView) findViewById(R.id.imageView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(userAdapter);
        user = new User(TEST_USER, R.mipmap.me);
        name = (TextView) findViewById(R.id.username);
        currentBill = (TextView) findViewById(R.id.currentBill);
        name.setText("User: "+ user.getUsername());
        imageView.setImageResource(R.mipmap.newprofile);
        currentBill.setText("Current bill: " + String.valueOf(getPrizeOfItems()));

    }

    private double getPrizeOfItems(){
        double prize = 0;
        for (String item : items) {
            String[] tokens = item.split("\\,");
            prize+=Double.valueOf(tokens[1]);
        }
        return prize;
    }
}

