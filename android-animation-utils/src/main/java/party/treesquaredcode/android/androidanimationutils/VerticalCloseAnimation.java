package party.treesquaredcode.android.androidanimationutils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class VerticalCloseAnimation extends Animation {
    View view;
    float viewHeight;
    float parallaxHeight;

    public VerticalCloseAnimation(View view, int viewHeightDimensionResId, int parallaxHeightDimensionResId) {
        this.view = view;
        this.viewHeight = view.getContext().getResources().getDimension(viewHeightDimensionResId);
        this.parallaxHeight = view.getContext().getResources().getDimension(parallaxHeightDimensionResId);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        view.getLayoutParams().height = (int) ((1.0f - interpolatedTime) * viewHeight);
        view.setPadding(view.getPaddingLeft(), (int) (-interpolatedTime * parallaxHeight), view.getPaddingRight(), view.getPaddingBottom());
        view.requestLayout();
    }
}
