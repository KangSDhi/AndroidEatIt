package com.example.androideatit.Decoration;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemLinearDecoration extends RecyclerView.ItemDecoration {

    private int smallPadding;
    private int largePadding;

    public ItemLinearDecoration(int smallPadding, int largePadding) {
        this.smallPadding = smallPadding;
        this.largePadding = largePadding;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.right = smallPadding;
        outRect.left = smallPadding;
        outRect.top = largePadding;
    }
}
