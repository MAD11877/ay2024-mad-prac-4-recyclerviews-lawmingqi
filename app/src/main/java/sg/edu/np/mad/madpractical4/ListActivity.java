package sg.edu.np.mad.madpractical4;

import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import sg.edu.np.mad.madpractical2.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Creating List of 20  users
        ArrayList<User> userArrayList = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i <= 20; i++){
            Boolean followingRandom = random.nextBoolean();

            User user = new User("User"+String.valueOf(random.nextInt(100000)),"Description"+String.valueOf(random.nextInt(100000)),i,followingRandom);
            userArrayList.add(user);
        }


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter userAdapter =  new UserAdapter(userArrayList, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);

    }
}