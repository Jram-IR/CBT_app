package com.project.cbtapp.fear_ladder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.cbtapp.R;
import com.project.cbtapp.databinding.ActivityMainBinding;

public class AppMainActivity extends AppCompatActivity {

    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public static final String TAG = "AppMainActivity";

    private NavController navController;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(R.layout.activity_app_main);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "null");
        FirebaseUser user = mAuth.getCurrentUser();
        if(user==null)
        {
            Log.d(TAG, "null");
            startActivity(new Intent(AppMainActivity.this, AuthActivity.class));
            finish();
        }
        super.onStart();
    }
}