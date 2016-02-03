package party.treesquaredcode.android.androidanimationutils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by rht on 10/14/15.
 */
public class RightOpenAnimation extends Animation {
    View view;
    float viewWidth;
    float parallaxWidth;

    public RightOpenAnimation(View view, int viewWidthDimenResId, int parallaxWidthDimenResId) {
        this.view = view;
        this.viewWidth = view.getContext().getResources().getDimension(viewWidthDimenResId);
        this.parallaxWidth = view.getContext().getResources().getDimension(parallaxWidthDimenResId);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        view.getLayoutParams().width = (int) (interpolatedTime * viewWidth);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), (int) ((interpolatedTime - 1.0f) * parallaxWidth), view.getPaddingBottom());
        view.requestLayout();
    }
}
