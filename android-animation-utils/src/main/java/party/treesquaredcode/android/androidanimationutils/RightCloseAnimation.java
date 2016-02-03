package party.treesquaredcode.android.androidanimationutils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RightCloseAnimation extends Animation {
    View view;
    float viewWidth;
    float parallaxWidth;

    public RightCloseAnimation(View view, int viewWidthDimenResId, int parallaxWidthDimenResId) {
        this.view = view;
        this.viewWidth = view.getContext().getResources().getDimension(viewWidthDimenResId);
        this.parallaxWidth = view.getContext().getResources().getDimension(parallaxWidthDimenResId);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        view.getLayoutParams().width = (int) ((1.0f - interpolatedTime) * viewWidth);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), (int) (-interpolatedTime * parallaxWidth), view.getPaddingBottom());
        view.requestLayout();
    }
}
