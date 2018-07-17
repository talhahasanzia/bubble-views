package com.sigledraft.bubbleviews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class EditBubbleView extends android.support.v7.widget.AppCompatEditText {
    private int originalWidth;
    private boolean isExpanded=false;

    public EditBubbleView(Context context) {
        super(context);
    }

    public EditBubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditBubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundResource(R.drawable.bubble_border);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (originalWidth == 0) {
            originalWidth = getMeasuredWidth();
        }
    }

    private void applyExpandAnimation(int width) {
        ValueAnimator expandAnimator = ValueAnimator.ofInt(getMeasuredWidth(), width);
        expandAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int expandScale = (int) valueAnimator.getAnimatedValue();
                EditBubbleView.this.getLayoutParams().width = (expandScale);
                EditBubbleView.this.requestLayout();
            }
        });
        expandAnimator.setDuration(3000L);
        expandAnimator.start();
        isExpanded=true;

    }

    private void reset()
    {
        getLayoutParams().width=originalWidth;
        requestLayout();
        isExpanded=false;
    }

    public void toggleBubble(int expandingWidth)
    {
        if(isExpanded)
        {
            reset();
        }
        else{
            applyExpandAnimation(expandingWidth);
        }
    }
}
