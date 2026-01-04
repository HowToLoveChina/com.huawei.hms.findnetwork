package nf;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import p514o9.C11839m;

/* renamed from: nf.y */
/* loaded from: classes4.dex */
public class C11692y {
    /* renamed from: b */
    public static /* synthetic */ void m69747b(ImageView imageView) {
        m69748c(imageView, R$drawable.near_link_search);
        C11839m.m70686d("FrameAnimationUtil", "startIconShowAnimation");
    }

    /* renamed from: c */
    public static void m69748c(ImageView imageView, int i10) {
        if (imageView == null) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        imageView.setImageResource(i10);
        ((AnimationDrawable) imageView.getDrawable()).start();
    }

    /* renamed from: d */
    public static void m69749d(final ImageView imageView) {
        if (imageView == null) {
            return;
        }
        new Handler().post(new Runnable() { // from class: nf.x
            @Override // java.lang.Runnable
            public final void run() {
                C11692y.m69747b(imageView);
            }
        });
    }

    /* renamed from: e */
    public static void m69750e(ImageView imageView) {
        AnimationDrawable animationDrawable;
        if (imageView == null || (animationDrawable = (AnimationDrawable) imageView.getDrawable()) == null || !animationDrawable.isRunning()) {
            return;
        }
        animationDrawable.stop();
        C11839m.m70686d("FrameAnimationUtil", "stopFrameAnimation");
    }
}
