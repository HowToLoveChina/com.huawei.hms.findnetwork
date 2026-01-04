package je;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.huawei.android.p073ds.R$drawable;
import p514o9.C11839m;

/* renamed from: je.l */
/* loaded from: classes3.dex */
public class C10798l {

    /* renamed from: je.l$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ImageView f51563a;

        public a(ImageView imageView) {
            this.f51563a = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            C10798l.m65718c(this.f51563a, R$drawable.backup_dialog_icon_loop);
        }
    }

    /* renamed from: b */
    public static /* synthetic */ void m65717b(ImageView imageView) {
        m65718c(imageView, R$drawable.backup_dialog_icon_loop);
        C11839m.m70686d("FrameAnimationUtil", "startIconShowAnimation");
    }

    /* renamed from: c */
    public static void m65718c(ImageView imageView, int i10) {
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
    public static void m65719d(final ImageView imageView) {
        if (imageView == null) {
            return;
        }
        new Handler().post(new Runnable() { // from class: je.k
            @Override // java.lang.Runnable
            public final void run() {
                C10798l.m65717b(imageView);
            }
        });
    }

    /* renamed from: e */
    public static void m65720e(ImageView imageView) {
        m65718c(imageView, R$drawable.backup_dialog_icon_show);
        new Handler().postDelayed(new a(imageView), 1380L);
    }

    /* renamed from: f */
    public static void m65721f(ImageView imageView) {
        AnimationDrawable animationDrawable;
        if (imageView == null || (animationDrawable = (AnimationDrawable) imageView.getDrawable()) == null || !animationDrawable.isRunning()) {
            return;
        }
        animationDrawable.stop();
        C11839m.m70686d("FrameAnimationUtil", "stopFrameAnimation");
    }
}
