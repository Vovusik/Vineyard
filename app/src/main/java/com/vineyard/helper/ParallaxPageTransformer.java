package com.vineyard.helper;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

// Плавний перехід між картинками у ViewPager
public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    private List<ParallaxTransformInformation> mViewsToParallax = new ArrayList<>();

    public ParallaxPageTransformer() {
    }

    public void addViewToParallax(ParallaxTransformInformation viewInfo) {
        if (mViewsToParallax != null) {
            mViewsToParallax.add(viewInfo);
        }
    }

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();

        if (position < -1) {
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1 && mViewsToParallax != null) { // [-1,1]
            for (ParallaxTransformInformation parallaxTransformInformation : mViewsToParallax) {
                applyParallaxEffect(view, position, pageWidth, parallaxTransformInformation,
                        position > 0);
            }
        } else {
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }
    }

    private void applyParallaxEffect(View view, float position, int pageWidth,
                                     ParallaxTransformInformation information, boolean isEnter) {
        if (information.isValid() && view.findViewById(information.resource) != null) {
            if (isEnter && !information.isEnterDefault()) {
                view.findViewById(information.resource)
                        .setTranslationX(-position * (pageWidth / information.parallaxEnterEffect));
            } else if (!isEnter && !information.isExitDefault()) {
                view.findViewById(information.resource)
                        .setTranslationX(-position * (pageWidth / information.parallaxExitEffect));
            }
        }
    }


    /**
     * Information to make the parallax effect in a concrete view.
     * <p>
     * parallaxEffect positive values reduces the speed of the view in the translation
     * ParallaxEffect negative values increase the speed of the view in the translation
     * Try values to see the different effects. I recommend 2, 0.75 and 0.5
     */
    public static class ParallaxTransformInformation {

        static final float PARALLAX_EFFECT_DEFAULT = -101.1986f;

        int resource;
        float parallaxEnterEffect;
        float parallaxExitEffect;

        public ParallaxTransformInformation(int resource, float parallaxEnterEffect,
                                            float parallaxExitEffect) {
            this.resource = resource;
            this.parallaxEnterEffect = parallaxEnterEffect;
            this.parallaxExitEffect = parallaxExitEffect;
        }

        boolean isValid() {
            return parallaxEnterEffect != 0 && parallaxExitEffect != 0 && resource != -1;
        }

        boolean isEnterDefault() {
            return parallaxEnterEffect == PARALLAX_EFFECT_DEFAULT;
        }

        boolean isExitDefault() {
            return parallaxExitEffect == PARALLAX_EFFECT_DEFAULT;
        }
    }
}
