package com.waracle.androidtest.netowrk;

import com.waracle.androidtest.model.Cake;

import java.util.List;

public interface CakesRequestCallBacks {
    void onSuccess(List<Cake> CakesList);

    void onFailure();
}
