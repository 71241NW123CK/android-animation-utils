package party.treesquaredcode.android.androidanimationutils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class VerticalOpenAnimation extends Animation {
    View view;
    float viewHeight;
    float parallaxHeight;

    public VerticalOpenAnimation(View view, int viewHeightDimenResId, int parallaxHeightDimenResId) {
        this.view = view;
        this.viewHeight = view.getContext().getResources().getDimension(viewHeightDimenResId);
        this.parallaxHeight = view.getContext().getResources().getDimension(parallaxHeightDimenResId);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        view.getLayoutParams().height = (int) (interpolatedTime * viewHeight);
        view.setPadding(view.getPaddingLeft(), (int) ((interpolatedTime - 1.0f) * parallaxHeight), view.getPaddingRight(), view.getPaddingBottom());
        view.requestLayout();
    }
}
