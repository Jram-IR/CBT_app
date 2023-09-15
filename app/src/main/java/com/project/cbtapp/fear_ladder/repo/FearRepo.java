package com.project.cbtapp.fear_ladder.repo;

import static com.project.cbtapp.fear_ladder.domain.CreateUserProfile.USERS;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.cbtapp.fear_ladder.dto.FearItems;
import com.project.cbtapp.fear_ladder.dto.FearModel;

import java.util.ArrayList;
import java.util.Objects;

public class FearRepo {
    public static final String TAG = "FearModel";
    public static final String FEAR  = "Fears";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    private String email;

    public FearRepo() {
    }

    public void setEmail() {
        this.email = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();
    }

    public void createFear(String fearName, ArrayList<FearItems> fearItems)
    {
        DocumentReference fearRef = db.collection(USERS).document(email).collection(FEAR).document();
        FearModel fearModel = new FearModel();
        fearModel.setId(fearRef.getId());
        fearModel.setFearList(fearItems);
        fearModel.setFearName(fearName);
        fearRef.set(fearModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Fear item added successfully");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });
    }

    public void updateFear(FearModel fearModel)
    {
        DocumentReference fearRef = db.collection(USERS).document(email).collection(FEAR).document();
        fearRef.set(fearModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG,"Fear updated");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });
    }

}
