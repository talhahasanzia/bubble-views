package com.sigledraft.bubbleedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sigledraft.bubbleviews.EditBubbleView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditBubbleView editBubbleView =findViewById(R.id.bubble_view);
        width=Math.round(editBubbleView.getLayoutParams().width*1.5f);
        editBubbleView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditBubbleView editBubbleView = (EditBubbleView) view;
        editBubbleView.toggleBubble(width);
    }
}
