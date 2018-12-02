package com.waracle.androidtest.view.cakelist;

import com.waracle.androidtest.model.Cake;

import java.util.List;

public interface PlaceHolderViewContract {
    void displayList(List<Cake> cakes);
    void showError();
}
