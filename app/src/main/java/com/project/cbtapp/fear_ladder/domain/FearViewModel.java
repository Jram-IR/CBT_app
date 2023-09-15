package com.project.cbtapp.fear_ladder.domain;

import androidx.lifecycle.ViewModel;

import com.project.cbtapp.fear_ladder.dto.FearItems;
import com.project.cbtapp.fear_ladder.dto.FearModel;
import com.project.cbtapp.fear_ladder.repo.FearRepo;

import java.util.ArrayList;

public class FearViewModel extends ViewModel {
    public final FearRepo repo = new FearRepo();
    public void setEmail()
    {
        repo.setEmail();
    }
    public void createFear(String fearName, ArrayList<FearItems> fearItems )
    {
        repo.createFear(fearName,fearItems);
    }

    public void updateFear(FearModel fear)
    {
        repo.updateFear(fear);
    }
}
