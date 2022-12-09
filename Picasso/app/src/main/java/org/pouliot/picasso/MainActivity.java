package org.pouliot.picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import org.pouliot.picasso.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView rv = binding.RvPicasso;
        rv.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        List<String> imagesUrls = new ArrayList<String>(Arrays.asList("https://i.imgur.com/b9wdgss.jpeg", "https://i.imgur.com/p26YodG.jpeg", "https://i.imgur.com/ZyRITA8.jpeg", "https://i.imgur.com/EuvIFgt.jpeg", "https://i.imgur.com/uitm0qw.jpeg"));
        rvAdapter = new RvAdapter(imagesUrls, MainActivity.this);
        rvAdapter.notifyDataSetChanged();
        rv.setAdapter(rvAdapter);
        Log.i(TAG, "onCreate: " + rvAdapter.imagesUrls.toString());
    }

}