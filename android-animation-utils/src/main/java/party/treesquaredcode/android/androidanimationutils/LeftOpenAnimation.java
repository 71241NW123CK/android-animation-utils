package party.treesquaredcode.android.androidanimationutils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class LeftOpenAnimation extends Animation {
    View view;
    float viewWidth;
    float parallaxWidth;

    public LeftOpenAnimation(View view, int viewWidthDimenResId, int parallaxWidthDimenResId) {
        this.view = view;
        this.viewWidth = view.getContext().getResources().getDimension(viewWidthDimenResId);
        this.parallaxWidth = view.getContext().getResources().getDimension(parallaxWidthDimenResId);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        view.getLayoutParams().width = (int) (interpolatedTime * viewWidth);
        view.setPadding((int) ((interpolatedTime - 1.0f) * parallaxWidth), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        view.requestLayout();
    }
}
