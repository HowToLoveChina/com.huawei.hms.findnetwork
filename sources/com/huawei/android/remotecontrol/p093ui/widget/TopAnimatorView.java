package com.huawei.android.remotecontrol.p093ui.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.android.remotecontrol.sdk.R$dimen;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class TopAnimatorView extends LinearLayout {
    private static final String TAG = "TopAnimatorView";
    private int animatorState;
    private View closeStateCircle;
    private View defaultCircle;
    private ObjectAnimator innerLoopWaveAlpha;
    private ObjectAnimator innerLoopWaveScaleX;
    private ObjectAnimator innerLoopWaveScaleY;
    private boolean isSwitchOpen;
    private int locateAnimatorState;
    private ImageView locateFailIcon;
    private ImageView locateIcon;
    private ImageView loopInnerWave;
    private ImageView loopOutWave;
    private View openStateCircle;
    private ObjectAnimator outLoopWaveAlpha;
    private ObjectAnimator outLoopWaveScaleX;
    private ObjectAnimator outLoopWaveScaleY;

    public interface AnimatorState {
        public static final int CLOSE_STATE = 1;
        public static final int DEFAULT_STATE = -1;
        public static final int OPEN_STATE = 0;
    }

    public interface LocateAnimatorState {
        public static final int BOUNCE_1 = 3;
        public static final int BOUNCE_2 = 4;
        public static final int DEFAULT_STATE = -1;
        public static final int DOWN = 2;
        public static final int JUMP = 1;
        public static final int SQUAT = 0;
    }

    public abstract class PFAnimatorListenerAdapter implements Animation.AnimationListener {
        private PFAnimatorListenerAdapter() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public TopAnimatorView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet getInnerLoopWaveAnimatorSet(int i10) {
        ImageView imageView = this.loopInnerWave;
        float[] fArr = TopAnimatorConfig.WAVE_SCALE;
        this.innerLoopWaveScaleX = ObjectAnimator.ofFloat(imageView, TopAnimatorConfig.AnimatorType.SCALE_X, fArr).setDuration(1500L);
        this.innerLoopWaveScaleY = ObjectAnimator.ofFloat(this.loopInnerWave, TopAnimatorConfig.AnimatorType.SCALE_Y, fArr).setDuration(1500L);
        this.innerLoopWaveAlpha = ObjectAnimator.ofFloat(this.loopInnerWave, TopAnimatorConfig.AnimatorType.ALPHA, TopAnimatorConfig.WAVE_ALPHA).setDuration(1500L);
        setWaveColor(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.innerLoopWaveScaleX).with(this.innerLoopWaveScaleY).with(this.innerLoopWaveAlpha);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet getOutLoopWaveAnimatorSet(int i10) {
        ImageView imageView = this.loopOutWave;
        float[] fArr = TopAnimatorConfig.WAVE_SCALE;
        this.outLoopWaveScaleX = ObjectAnimator.ofFloat(imageView, TopAnimatorConfig.AnimatorType.SCALE_X, fArr).setDuration(1500L);
        this.outLoopWaveScaleY = ObjectAnimator.ofFloat(this.loopOutWave, TopAnimatorConfig.AnimatorType.SCALE_Y, fArr).setDuration(1500L);
        this.outLoopWaveAlpha = ObjectAnimator.ofFloat(this.loopOutWave, TopAnimatorConfig.AnimatorType.ALPHA, TopAnimatorConfig.WAVE_ALPHA).setDuration(1500L);
        setWaveColor(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.outLoopWaveScaleX).with(this.outLoopWaveScaleY).with(this.outLoopWaveAlpha);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void greenCircleReveal() {
        this.openStateCircle.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, this.defaultCircle.getWidth() / 2, (this.defaultCircle.getHeight() / 2) + (this.locateIcon.getWidth() / 2));
        scaleAnimation.setDuration(400L);
        scaleAnimation.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TopAnimatorView.this.loopOutWave.setVisibility(0);
                TopAnimatorView.this.loopInnerWave.setVisibility(0);
                TopAnimatorView.this.getOutLoopWaveAnimatorSet(2).start();
                AnimatorSet innerLoopWaveAnimatorSet = TopAnimatorView.this.getInnerLoopWaveAnimatorSet(2);
                innerLoopWaveAnimatorSet.setStartDelay(500L);
                innerLoopWaveAnimatorSet.start();
            }
        });
        this.openStateCircle.startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redCircleReveal() {
        this.closeStateCircle.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, this.defaultCircle.getWidth() / 2, (this.defaultCircle.getHeight() / 2) + (this.locateIcon.getWidth() / 2));
        scaleAnimation.setDuration(400L);
        scaleAnimation.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TopAnimatorView.this.animatorState != 1) {
                    return;
                }
                TopAnimatorView.this.loopOutWave.setVisibility(0);
                TopAnimatorView.this.loopInnerWave.setVisibility(0);
                TopAnimatorView.this.getOutLoopWaveAnimatorSet(1).start();
                AnimatorSet innerLoopWaveAnimatorSet = TopAnimatorView.this.getInnerLoopWaveAnimatorSet(1);
                innerLoopWaveAnimatorSet.setStartDelay(500L);
                innerLoopWaveAnimatorSet.start();
                TopAnimatorView.this.locateFailIcon.setVisibility(0);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 1.0f);
                scaleAnimation2.setInterpolator(new DecelerateInterpolator(1.5f));
                scaleAnimation2.setDuration(300L);
                TopAnimatorView.this.locateFailIcon.startAnimation(scaleAnimation2);
            }
        });
        this.closeStateCircle.startAnimation(scaleAnimation);
    }

    private void resetView() {
        stop();
        this.loopOutWave.setVisibility(8);
        this.loopInnerWave.setVisibility(8);
        this.defaultCircle.setVisibility(0);
        this.closeStateCircle.setVisibility(8);
        this.openStateCircle.setVisibility(8);
        this.locateFailIcon.setVisibility(8);
        this.locateAnimatorState = -1;
        this.locateIcon.clearAnimation();
        this.defaultCircle.clearAnimation();
        this.closeStateCircle.clearAnimation();
        this.openStateCircle.clearAnimation();
        this.locateFailIcon.clearAnimation();
    }

    private void safeEnd(ObjectAnimator objectAnimator) {
        if (objectAnimator == null) {
            return;
        }
        try {
            objectAnimator.end();
        } catch (Exception e10) {
            C13981a.m83988e(TAG, "safeEnd Exception" + e10.toString());
        }
    }

    private void setWaveColor(int i10) {
        if (i10 == 1) {
            ImageView imageView = this.loopOutWave;
            int i11 = R$drawable.animator_red_wave;
            imageView.setImageResource(i11);
            this.loopInnerWave.setImageResource(i11);
            return;
        }
        if (i10 != 2) {
            return;
        }
        ImageView imageView2 = this.loopOutWave;
        int i12 = R$drawable.animator_green_wave;
        imageView2.setImageResource(i12);
        this.loopInnerWave.setImageResource(i12);
    }

    private synchronized void startAnimation(boolean z10) {
        int i10 = !z10 ? 1 : 0;
        int i11 = this.animatorState;
        if (i11 == -1 || i11 != i10) {
            this.animatorState = i10;
            this.isSwitchOpen = z10;
            resetView();
            startOpenChangeAnimator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBounceAnimator() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -getResources().getDimension(R$dimen.cloud_space_5_dp));
        translateAnimation.setDuration(100L);
        translateAnimation.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TopAnimatorView.this.locateAnimatorState == 3) {
                    TopAnimatorView.this.startBounceStep2();
                }
            }
        });
        this.locateAnimatorState = 3;
        this.locateIcon.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBounceStep2() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -getResources().getDimension(R$dimen.cloud_space_5_dp), 0.0f);
        translateAnimation.setDuration(100L);
        translateAnimation.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TopAnimatorView.this.locateAnimatorState == 4) {
                    TopAnimatorView.this.startBounceStep3();
                }
            }
        });
        this.locateAnimatorState = 4;
        this.locateIcon.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBounceStep3() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -getResources().getDimension(R$dimen.cloud_space_2_dp), 0.0f);
        translateAnimation.setDuration(80L);
        translateAnimation.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -TopAnimatorView.this.getResources().getDimension(R$dimen.cloud_space_2_dp));
                translateAnimation2.setDuration(80L);
                TopAnimatorView.this.locateIcon.startAnimation(translateAnimation2);
            }
        });
        this.locateIcon.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownAnimator() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.1f, 1.0f, 1, 1.0f, 1, 1.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -getResources().getDimension(R$dimen.cloud_space_10_dp), 0.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        animationSet.setDuration(200L);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TopAnimatorView.this.locateAnimatorState == 2) {
                    if (TopAnimatorView.this.isSwitchOpen) {
                        TopAnimatorView.this.greenCircleReveal();
                    } else {
                        TopAnimatorView.this.redCircleReveal();
                    }
                    TopAnimatorView.this.startBounceAnimator();
                }
            }
        });
        this.locateAnimatorState = 2;
        this.locateIcon.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startJumpAnimator() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.9f, 1.1f, 1, 1.0f, 1, 1.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -getResources().getDimension(R$dimen.cloud_space_10_dp));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        animationSet.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TopAnimatorView.this.locateAnimatorState == 1) {
                    TopAnimatorView.this.startDownAnimator();
                }
            }
        });
        this.locateAnimatorState = 1;
        this.locateIcon.startAnimation(animationSet);
    }

    private void startOpenChangeAnimator() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.9f, 1, 1.0f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setAnimationListener(new PFAnimatorListenerAdapter() { // from class: com.huawei.android.remotecontrol.ui.widget.TopAnimatorView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TopAnimatorView.this.locateAnimatorState == 0) {
                    TopAnimatorView.this.startJumpAnimator();
                }
            }
        });
        this.locateAnimatorState = 0;
        this.locateIcon.startAnimation(scaleAnimation);
    }

    public void onDestroy() {
    }

    public void onSwitchClosed() {
        startAnimation(false);
    }

    public void onSwitchOpen() {
        startAnimation(true);
    }

    public void stop() {
        safeEnd(this.outLoopWaveScaleX);
        safeEnd(this.outLoopWaveScaleY);
        safeEnd(this.outLoopWaveAlpha);
        safeEnd(this.innerLoopWaveScaleX);
        safeEnd(this.innerLoopWaveScaleY);
        safeEnd(this.innerLoopWaveAlpha);
    }

    public TopAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopAnimatorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.locateAnimatorState = -1;
        this.animatorState = -1;
        View viewInflate = View.inflate(getContext(), R$layout.top_animator_view, this);
        this.loopOutWave = (ImageView) C12809f.m76831d(viewInflate, R$id.pf_loop_out_wave);
        this.loopInnerWave = (ImageView) C12809f.m76831d(viewInflate, R$id.pf_loop_inner_wave);
        this.defaultCircle = viewInflate.findViewById(R$id.pf_map_circle_default);
        this.closeStateCircle = viewInflate.findViewById(R$id.pf_map_circle_close);
        this.openStateCircle = viewInflate.findViewById(R$id.pf_map_circle_open);
        this.locateIcon = (ImageView) C12809f.m76831d(viewInflate, R$id.pf_map_location_icon);
        this.locateFailIcon = (ImageView) C12809f.m76831d(viewInflate, R$id.pf_map_location_fail_icon);
    }
}
