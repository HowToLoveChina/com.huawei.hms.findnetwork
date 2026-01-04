package com.huawei.uikit.hwrecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.AbstractC0879r;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwrecyclerview.C8721R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;

/* loaded from: classes4.dex */
public class HwDefaultItemAnimator extends AbstractC0879r {

    /* renamed from: A */
    private static final int f43390A = 100;

    /* renamed from: B */
    private static final float f43391B = 0.85f;

    /* renamed from: C */
    private static final int f43392C = 200;

    /* renamed from: D */
    private static final int f43393D = 255;

    /* renamed from: E */
    private static TimeInterpolator f43394E = null;

    /* renamed from: o */
    static final int f43395o = 1;

    /* renamed from: p */
    static final int f43396p = 2;

    /* renamed from: q */
    static final int f43397q = 3;

    /* renamed from: r */
    private static final String f43398r = "DefaultItemAnimator";

    /* renamed from: s */
    private static final int f43399s = 10;

    /* renamed from: t */
    private static final float f43400t = 0.7f;

    /* renamed from: u */
    private static final float f43401u = 0.9f;

    /* renamed from: v */
    private static final int f43402v = 150;

    /* renamed from: w */
    private static final int f43403w = 150;

    /* renamed from: x */
    private static final int f43404x = 150;

    /* renamed from: y */
    private static final float f43405y = 0.0f;

    /* renamed from: z */
    private static final float f43406z = 0.3f;

    /* renamed from: a */
    private List<RecyclerView.AbstractC0833c0> f43407a = new ArrayList(10);

    /* renamed from: b */
    private List<RecyclerView.AbstractC0833c0> f43408b = new ArrayList(10);

    /* renamed from: c */
    private List<bkfsb> f43409c = new ArrayList(10);

    /* renamed from: d */
    private List<boqdu> f43410d = new ArrayList(10);

    /* renamed from: e */
    private List<List<RecyclerView.AbstractC0833c0>> f43411e = new ArrayList(10);

    /* renamed from: f */
    private List<List<bkfsb>> f43412f = new ArrayList(10);

    /* renamed from: g */
    private List<List<boqdu>> f43413g = new ArrayList(10);

    /* renamed from: h */
    private List<RecyclerView.AbstractC0833c0> f43414h = new ArrayList(10);

    /* renamed from: i */
    private List<RecyclerView.AbstractC0833c0> f43415i = new ArrayList(10);

    /* renamed from: j */
    private List<RecyclerView.AbstractC0833c0> f43416j = new ArrayList(10);

    /* renamed from: k */
    private List<RecyclerView.AbstractC0833c0> f43417k = new ArrayList(10);

    /* renamed from: l */
    private int f43418l = 1;

    /* renamed from: m */
    private ItemDeleteCallBack f43419m = null;

    /* renamed from: n */
    private Animator f43420n = null;

    public interface ItemDeleteCallBack {
        Animator playDisappearAnimator();
    }

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f43421a;

        public aauaf(View view) {
            this.f43421a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwDefaultItemAnimator.f43398r, "animatorScale: onAnimationUpdate: animation is null");
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                this.f43421a.setScaleX(fFloatValue);
                this.f43421a.setScaleY(fFloatValue);
            }
        }
    }

    public class aayti implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f43423a;

        public aayti(List list) {
            this.f43423a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (RecyclerView.AbstractC0833c0 abstractC0833c0 : this.f43423a) {
                if (HwDefaultItemAnimator.this.f43418l == 3) {
                    HwDefaultItemAnimator.this.m54918a(abstractC0833c0, false, (List<Animator>) null);
                } else {
                    HwDefaultItemAnimator.this.m54916a(abstractC0833c0);
                }
            }
            this.f43423a.clear();
            HwDefaultItemAnimator.this.f43411e.remove(this.f43423a);
        }
    }

    public class afdzw extends BitmapDrawable {

        /* renamed from: a */
        private int f43425a;

        /* renamed from: b */
        private int f43426b;

        public /* synthetic */ afdzw(HwDefaultItemAnimator hwDefaultItemAnimator, Resources resources, Bitmap bitmap, bxac bxacVar) {
            this(resources, bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (canvas == null) {
                Log.e(HwDefaultItemAnimator.f43398r, "draw: canvas is null");
                return;
            }
            canvas.save();
            canvas.translate(this.f43425a, this.f43426b);
            super.draw(canvas);
            canvas.restore();
        }

        private afdzw(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m54953a(int i10, int i11) {
            this.f43425a = i10;
            this.f43426b = i11;
        }
    }

    public class aijfr extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43428a;

        /* renamed from: b */
        final /* synthetic */ Animator f43429b;

        /* renamed from: c */
        final /* synthetic */ ViewPropertyAnimator f43430c;

        /* renamed from: d */
        final /* synthetic */ View f43431d;

        public aijfr(RecyclerView.AbstractC0833c0 abstractC0833c0, Animator animator, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f43428a = abstractC0833c0;
            this.f43429b = animator;
            this.f43430c = viewPropertyAnimator;
            this.f43431d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f43429b.cancel();
            if (HwDefaultItemAnimator.this.f43420n != null) {
                HwDefaultItemAnimator.this.f43420n.cancel();
                HwDefaultItemAnimator.this.f43420n = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwDefaultItemAnimator.this.f43420n = null;
            this.f43430c.setListener(null);
            this.f43431d.setAlpha(1.0f);
            this.f43431d.setScaleX(1.0f);
            this.f43431d.setScaleY(1.0f);
            HwDefaultItemAnimator.this.dispatchRemoveFinished(this.f43428a);
            HwDefaultItemAnimator.this.f43416j.remove(this.f43428a);
            HwDefaultItemAnimator.this.m54913a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchRemoveStarting(this.f43428a);
        }
    }

    public class akxao extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boqdu f43433a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f43434b;

        /* renamed from: c */
        final /* synthetic */ View f43435c;

        public akxao(boqdu boqduVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f43433a = boqduVar;
            this.f43434b = viewPropertyAnimator;
            this.f43435c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43434b.setListener(null);
            this.f43435c.setAlpha(1.0f);
            this.f43435c.setTranslationX(0.0f);
            this.f43435c.setTranslationY(0.0f);
            HwDefaultItemAnimator.this.dispatchChangeFinished(this.f43433a.f43460a, true);
            HwDefaultItemAnimator.this.f43417k.remove(this.f43433a.f43460a);
            HwDefaultItemAnimator.this.m54913a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchChangeStarting(this.f43433a.f43460a, true);
        }
    }

    public class alzfb extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43437a;

        /* renamed from: b */
        final /* synthetic */ View f43438b;

        /* renamed from: c */
        final /* synthetic */ ViewPropertyAnimator f43439c;

        public alzfb(RecyclerView.AbstractC0833c0 abstractC0833c0, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f43437a = abstractC0833c0;
            this.f43438b = view;
            this.f43439c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f43438b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43439c.setListener(null);
            HwDefaultItemAnimator.this.dispatchAddFinished(this.f43437a);
            HwDefaultItemAnimator.this.f43414h.remove(this.f43437a);
            HwDefaultItemAnimator.this.m54913a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchAddStarting(this.f43437a);
        }
    }

    public class anbq implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ BitmapDrawable f43441a;

        /* renamed from: b */
        final /* synthetic */ ViewParent f43442b;

        public anbq(BitmapDrawable bitmapDrawable, ViewParent viewParent) {
            this.f43441a = bitmapDrawable;
            this.f43442b = viewParent;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwDefaultItemAnimator.f43398r, "animateMoveImplPre: onAnimationUpdate: animation is null");
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                this.f43441a.setAlpha(((Integer) animatedValue).intValue());
                ((ViewGroup) this.f43442b).invalidate();
            }
        }
    }

    public class avpbg extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boqdu f43444a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f43445b;

        /* renamed from: c */
        final /* synthetic */ View f43446c;

        public avpbg(boqdu boqduVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f43444a = boqduVar;
            this.f43445b = viewPropertyAnimator;
            this.f43446c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43445b.setListener(null);
            this.f43446c.setAlpha(1.0f);
            this.f43446c.setTranslationX(0.0f);
            this.f43446c.setTranslationY(0.0f);
            HwDefaultItemAnimator.this.dispatchChangeFinished(this.f43444a.f43461b, false);
            HwDefaultItemAnimator.this.f43417k.remove(this.f43444a.f43461b);
            HwDefaultItemAnimator.this.m54913a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchChangeStarting(this.f43444a.f43461b, false);
        }
    }

    public class awsks extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43448a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f43449b;

        /* renamed from: c */
        final /* synthetic */ View f43450c;

        public awsks(RecyclerView.AbstractC0833c0 abstractC0833c0, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f43448a = abstractC0833c0;
            this.f43449b = viewPropertyAnimator;
            this.f43450c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43449b.setListener(null);
            this.f43450c.setAlpha(1.0f);
            HwDefaultItemAnimator.this.dispatchRemoveFinished(this.f43448a);
            HwDefaultItemAnimator.this.f43416j.remove(this.f43448a);
            HwDefaultItemAnimator.this.m54913a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchRemoveStarting(this.f43448a);
        }
    }

    public class bfscp implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f43452a;

        public bfscp(List list) {
            this.f43452a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f43452a.iterator();
            while (it.hasNext()) {
                HwDefaultItemAnimator.this.m54919a((boqdu) it.next());
            }
            this.f43452a.clear();
            HwDefaultItemAnimator.this.f43413g.remove(this.f43452a);
        }
    }

    public static class bkfsb {

        /* renamed from: a */
        private RecyclerView.AbstractC0833c0 f43454a;

        /* renamed from: b */
        private int f43455b;

        /* renamed from: c */
        private int f43456c;

        /* renamed from: d */
        private int f43457d;

        /* renamed from: e */
        private int f43458e;

        public bkfsb(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
            this.f43454a = abstractC0833c0;
            this.f43455b = i10;
            this.f43456c = i11;
            this.f43457d = i12;
            this.f43458e = i13;
        }
    }

    public class blfhz implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f43459a;

        public blfhz(View view) {
            this.f43459a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwDefaultItemAnimator.f43398r, "getAlphaAnimatorUpdateListener: onAnimationUpdate: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            View view = this.f43459a;
            if (view != null) {
                view.setAlpha(fFloatValue);
            }
        }
    }

    public static class boqdu {

        /* renamed from: a */
        private RecyclerView.AbstractC0833c0 f43460a;

        /* renamed from: b */
        private RecyclerView.AbstractC0833c0 f43461b;

        /* renamed from: c */
        private int f43462c;

        /* renamed from: d */
        private int f43463d;

        /* renamed from: e */
        private int f43464e;

        /* renamed from: f */
        private int f43465f;

        public /* synthetic */ boqdu(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02, bxac bxacVar) {
            this(abstractC0833c0, abstractC0833c02);
        }

        public String toString() {
            return "ChangeInfo{mOldHolder=" + this.f43460a + ", mNewHolder=" + this.f43461b + ", mFromX=" + this.f43462c + ", mFromY=" + this.f43463d + ", mToX=" + this.f43464e + ", mToY=" + this.f43465f + '}';
        }

        private boqdu(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            this.f43460a = abstractC0833c0;
            this.f43461b = abstractC0833c02;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m54962a(int i10, int i11, int i12, int i13) {
            this.f43462c = i10;
            this.f43463d = i11;
            this.f43464e = i12;
            this.f43465f = i13;
        }
    }

    public class bqmxo extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43466a;

        /* renamed from: b */
        final /* synthetic */ Animator f43467b;

        /* renamed from: c */
        final /* synthetic */ boolean f43468c;

        /* renamed from: d */
        final /* synthetic */ List f43469d;

        /* renamed from: e */
        final /* synthetic */ View f43470e;

        /* renamed from: f */
        final /* synthetic */ ViewPropertyAnimator f43471f;

        public bqmxo(RecyclerView.AbstractC0833c0 abstractC0833c0, Animator animator, boolean z10, List list, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f43466a = abstractC0833c0;
            this.f43467b = animator;
            this.f43468c = z10;
            this.f43469d = list;
            this.f43470e = view;
            this.f43471f = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            List list;
            this.f43467b.cancel();
            if (this.f43468c && (list = this.f43469d) != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).cancel();
                }
            }
            this.f43470e.setAlpha(1.0f);
            this.f43470e.setScaleX(1.0f);
            this.f43470e.setScaleY(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43471f.setListener(null);
            if (this.f43468c) {
                HwDefaultItemAnimator.this.dispatchMoveFinished(this.f43466a);
                HwDefaultItemAnimator.this.f43415i.remove(this.f43466a);
                HwDefaultItemAnimator.this.m54913a();
            } else {
                HwDefaultItemAnimator.this.dispatchAddFinished(this.f43466a);
                HwDefaultItemAnimator.this.f43414h.remove(this.f43466a);
                HwDefaultItemAnimator.this.m54913a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchMoveStarting(this.f43466a);
        }
    }

    public class brnby implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f43473a;

        public brnby(View view) {
            this.f43473a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwDefaultItemAnimator.f43398r, "getScaleAnimatorUpdateListener: onAnimationUpdate: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            View view = this.f43473a;
            if (view != null) {
                view.setScaleX(fFloatValue);
                this.f43473a.setScaleY(fFloatValue);
            }
        }
    }

    public class bwuqo extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroupOverlay f43474a;

        /* renamed from: b */
        final /* synthetic */ BitmapDrawable f43475b;

        public bwuqo(ViewGroupOverlay viewGroupOverlay, BitmapDrawable bitmapDrawable) {
            this.f43474a = viewGroupOverlay;
            this.f43475b = bitmapDrawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43474a.remove(this.f43475b);
        }
    }

    public class bxac implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f43477a;

        /* renamed from: b */
        final /* synthetic */ List f43478b;

        public bxac(List list, List list2) {
            this.f43477a = list;
            this.f43478b = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10 = true;
            for (Object obj : this.f43477a) {
                if (obj instanceof bkfsb) {
                    bkfsb bkfsbVar = (bkfsb) obj;
                    if (HwDefaultItemAnimator.this.f43418l != 1) {
                        HwDefaultItemAnimator.this.m54918a(bkfsbVar.f43454a, true, (List<Animator>) (z10 ? this.f43478b : null));
                    } else {
                        HwDefaultItemAnimator.this.m54917a(bkfsbVar.f43454a, bkfsbVar.f43455b, bkfsbVar.f43456c, bkfsbVar.f43457d, bkfsbVar.f43458e);
                    }
                    z10 = false;
                }
            }
            this.f43477a.clear();
            HwDefaultItemAnimator.this.f43412f.remove(this.f43477a);
        }
    }

    public class bzqlh implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ float f43480a;

        /* renamed from: b */
        final /* synthetic */ float f43481b;

        /* renamed from: c */
        final /* synthetic */ View f43482c;

        public bzqlh(float f10, float f11, View view) {
            this.f43480a = f10;
            this.f43481b = f11;
            this.f43482c = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwDefaultItemAnimator.f43398r, "animateRemoveImplEx: animatorScale: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f10 = this.f43480a;
            float f11 = this.f43481b;
            this.f43482c.setScaleX(f10 - ((f10 - 0.3f) * fFloatValue));
            this.f43482c.setScaleY(f11 - ((f11 - 0.3f) * fFloatValue));
        }
    }

    public class bzrwd extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43484a;

        /* renamed from: b */
        final /* synthetic */ int f43485b;

        /* renamed from: c */
        final /* synthetic */ View f43486c;

        /* renamed from: d */
        final /* synthetic */ int f43487d;

        /* renamed from: e */
        final /* synthetic */ ViewPropertyAnimator f43488e;

        public bzrwd(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f43484a = abstractC0833c0;
            this.f43485b = i10;
            this.f43486c = view;
            this.f43487d = i11;
            this.f43488e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f43485b != 0) {
                this.f43486c.setTranslationX(0.0f);
            }
            if (this.f43487d != 0) {
                this.f43486c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43488e.setListener(null);
            HwDefaultItemAnimator.this.dispatchMoveFinished(this.f43484a);
            HwDefaultItemAnimator.this.f43415i.remove(this.f43484a);
            HwDefaultItemAnimator.this.m54913a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwDefaultItemAnimator.this.dispatchMoveStarting(this.f43484a);
        }
    }

    /* renamed from: a */
    private boolean m54929a(boolean z10, boolean z11, boolean z12, boolean z13) {
        return z10 || z11 || z12 || z13;
    }

    @TargetApi(11)
    public static Animator getCheckStateAnimator(View view, boolean z10) {
        ValueAnimator valueAnimatorM54910a;
        ValueAnimator valueAnimatorM54932b;
        Context context = view.getContext();
        if (z10) {
            valueAnimatorM54910a = m54910a(context, 1.0f, 0.7f, 150);
            valueAnimatorM54932b = m54932b(context, 1.0f, 0.9f, 150);
        } else {
            valueAnimatorM54910a = m54910a(context, 0.7f, 1.0f, 150);
            valueAnimatorM54932b = m54932b(context, 0.9f, 1.0f, 150);
        }
        valueAnimatorM54910a.addUpdateListener(m54909a(view));
        valueAnimatorM54932b.addUpdateListener(m54931b(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorM54910a, valueAnimatorM54932b);
        return animatorSet;
    }

    public static void resetViewByCheckStatus(View view, boolean z10) {
        if (view == null) {
            Log.w(f43398r, "resetViewByCheckStatus: view is null.");
            return;
        }
        if (z10) {
            view.setAlpha(0.7f);
            view.setScaleX(0.9f);
            view.setScaleY(0.9f);
        } else {
            view.setAlpha(1.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
    }

    public static void startCheckStateAnimator(View view, boolean z10) {
        if (view == null) {
            Log.w(f43398r, "startCheckStateAnimator: fail to get view.");
            return;
        }
        Animator checkStateAnimator = getCheckStateAnimator(view, z10);
        if (checkStateAnimator != null) {
            checkStateAnimator.start();
        }
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateAdd(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        m54943d(abstractC0833c0);
        abstractC0833c0.f4327a.setAlpha(0.0f);
        this.f43408b.add(abstractC0833c0);
        return true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateChange(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02, int i10, int i11, int i12, int i13) {
        if (abstractC0833c0 == abstractC0833c02) {
            return animateMove(abstractC0833c0, i10, i11, i12, i13);
        }
        float translationX = abstractC0833c0.f4327a.getTranslationX();
        float translationY = abstractC0833c0.f4327a.getTranslationY();
        float alpha = abstractC0833c0.f4327a.getAlpha();
        m54943d(abstractC0833c0);
        abstractC0833c0.f4327a.setAlpha(alpha);
        abstractC0833c0.f4327a.setTranslationX(translationX);
        abstractC0833c0.f4327a.setTranslationY(translationY);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        if (abstractC0833c02 != null) {
            m54943d(abstractC0833c02);
            abstractC0833c02.f4327a.setTranslationX(-i14);
            abstractC0833c02.f4327a.setTranslationY(-i15);
            abstractC0833c02.f4327a.setAlpha(0.0f);
        }
        boqdu boqduVar = new boqdu(abstractC0833c0, abstractC0833c02, null);
        boqduVar.m54962a(i10, i11, i12, i13);
        this.f43410d.add(boqduVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateMove(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
        View view = abstractC0833c0.f4327a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) abstractC0833c0.f4327a.getTranslationY());
        m54943d(abstractC0833c0);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            dispatchMoveFinished(abstractC0833c0);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f43409c.add(new bkfsb(abstractC0833c0, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateRemove(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        m54943d(abstractC0833c0);
        this.f43407a.add(abstractC0833c0);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean canReuseUpdatedViewHolder(RecyclerView.AbstractC0833c0 abstractC0833c0, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(abstractC0833c0, list);
    }

    public void defineAnimateAddData(ViewPropertyAnimator viewPropertyAnimator) {
    }

    public void defineAnimateMoveData(int i10, ViewPropertyAnimator viewPropertyAnimator) {
    }

    public void defineAnimateRemoveData(ViewPropertyAnimator viewPropertyAnimator) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public void endAnimation(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        view.animate().cancel();
        for (int size = this.f43409c.size() - 1; size >= 0; size--) {
            if (this.f43409c.get(size).f43454a == abstractC0833c0) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(abstractC0833c0);
                this.f43409c.remove(size);
            }
        }
        m54925a(this.f43410d, abstractC0833c0);
        if (this.f43407a.remove(abstractC0833c0)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(abstractC0833c0);
        }
        if (this.f43408b.remove(abstractC0833c0)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(abstractC0833c0);
        }
        for (int size2 = this.f43413g.size() - 1; size2 >= 0; size2--) {
            List<boqdu> list = this.f43413g.get(size2);
            m54925a(list, abstractC0833c0);
            if (list.isEmpty()) {
                this.f43413g.remove(size2);
            }
        }
        m54935b(view, abstractC0833c0);
        m54914a(view, abstractC0833c0);
        this.f43416j.remove(abstractC0833c0);
        this.f43414h.remove(abstractC0833c0);
        this.f43417k.remove(abstractC0833c0);
        this.f43415i.remove(abstractC0833c0);
        m54913a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public void endAnimations() {
        for (int size = this.f43409c.size() - 1; size >= 0; size--) {
            bkfsb bkfsbVar = this.f43409c.get(size);
            View view = bkfsbVar.f43454a.f4327a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(bkfsbVar.f43454a);
            this.f43409c.remove(size);
        }
        for (int size2 = this.f43407a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f43407a.get(size2));
            this.f43407a.remove(size2);
        }
        for (int size3 = this.f43408b.size() - 1; size3 >= 0; size3--) {
            RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43408b.get(size3);
            abstractC0833c0.f4327a.setAlpha(1.0f);
            dispatchAddFinished(abstractC0833c0);
            this.f43408b.remove(size3);
        }
        for (int size4 = this.f43410d.size() - 1; size4 >= 0; size4--) {
            m54937b(this.f43410d.get(size4));
        }
        this.f43410d.clear();
        if (isRunning()) {
            m54934b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean isRunning() {
        if (this.f43408b.isEmpty() && this.f43410d.isEmpty() && this.f43409c.isEmpty() && this.f43407a.isEmpty() && this.f43415i.isEmpty() && this.f43416j.isEmpty() && this.f43414h.isEmpty() && this.f43417k.isEmpty() && this.f43411e.isEmpty() && this.f43413g.isEmpty()) {
            return !this.f43412f.isEmpty();
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public void runPendingAnimations() {
        boolean z10 = !this.f43407a.isEmpty();
        boolean z11 = !this.f43409c.isEmpty();
        boolean z12 = !this.f43410d.isEmpty();
        boolean z13 = !this.f43408b.isEmpty();
        if (m54929a(z10, z11, z13, z12)) {
            m54940c();
            if (z11) {
                m54938b(z10);
            }
            if (z12) {
                m54926a(z10);
            }
            if (z13) {
                m54927a(z10, z11, z12);
            }
        }
    }

    /* renamed from: b */
    private void m54938b(boolean z10) {
        ArrayList<bkfsb> arrayList = new ArrayList(this.f43409c.size());
        arrayList.addAll(this.f43409c);
        this.f43412f.add(arrayList);
        this.f43409c.clear();
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        if (this.f43418l != 1) {
            for (bkfsb bkfsbVar : arrayList) {
                Animator animatorM54930b = m54930b(bkfsbVar.f43454a, bkfsbVar.f43455b, bkfsbVar.f43456c, bkfsbVar.f43457d, bkfsbVar.f43458e);
                if (animatorM54930b != null) {
                    arrayList2.add(animatorM54930b);
                }
            }
        }
        bxac bxacVar = new bxac(arrayList, arrayList2);
        if (!z10) {
            bxacVar.run();
            return;
        }
        View view = ((bkfsb) arrayList.get(0)).f43454a.f4327a;
        if (this.f43418l == 1) {
            C9603h0.m59888i0(view, bxacVar, getRemoveDuration());
        } else {
            C9603h0.m59888i0(view, bxacVar, 100L);
        }
    }

    /* renamed from: c */
    private void m54940c() {
        ItemDeleteCallBack itemDeleteCallBack;
        for (RecyclerView.AbstractC0833c0 abstractC0833c0 : this.f43407a) {
            if (this.f43418l == 1) {
                m54936b(abstractC0833c0);
            } else {
                m54942c(abstractC0833c0);
            }
        }
        if (this.f43418l == 3 && (itemDeleteCallBack = this.f43419m) != null) {
            this.f43420n = itemDeleteCallBack.playDisappearAnimator();
        }
        this.f43407a.clear();
    }

    /* renamed from: d */
    private void m54943d(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (f43394E == null) {
            f43394E = new ValueAnimator().getInterpolator();
        }
        abstractC0833c0.f4327a.animate().setInterpolator(f43394E);
        endAnimation(abstractC0833c0);
    }

    /* renamed from: a */
    public void m54951a(int i10) {
        if (i10 <= 3 && i10 >= 1) {
            this.f43418l = i10;
        } else {
            Log.e(f43398r, "setLayoutMode: mode is invalid.");
        }
    }

    /* renamed from: c */
    private void m54942c(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f43416j.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.setDuration(150L).alpha(0.0f).setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), C8721R.interpolator.cubic_bezier_interpolator_type_33_33)).setListener(m54906a(abstractC0833c0, valueAnimatorOfFloat, viewPropertyAnimatorAnimate)).start();
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), R.interpolator.fast_out_linear_in));
        valueAnimatorOfFloat.addUpdateListener(new bzqlh(scaleX, scaleY, view));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: a */
    private void m54926a(boolean z10) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.addAll(this.f43410d);
        this.f43413g.add(arrayList);
        this.f43410d.clear();
        bfscp bfscpVar = new bfscp(arrayList);
        if (z10) {
            C9603h0.m59888i0(((boqdu) arrayList.get(0)).f43460a.f4327a, bfscpVar, getRemoveDuration());
        } else {
            bfscpVar.run();
        }
    }

    /* renamed from: a */
    private void m54927a(boolean z10, boolean z11, boolean z12) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.addAll(this.f43408b);
        this.f43411e.add(arrayList);
        this.f43408b.clear();
        aayti aaytiVar = new aayti(arrayList);
        if (!z10 && !z11 && !z12) {
            aaytiVar.run();
            return;
        }
        long removeDuration = z10 ? getRemoveDuration() : 0L;
        long moveDuration = z11 ? getMoveDuration() : 0L;
        if (this.f43418l != 1 && z10) {
            removeDuration = 100;
            moveDuration = 0;
        }
        long changeDuration = z12 ? getChangeDuration() : 0L;
        C9603h0.m59888i0(((RecyclerView.AbstractC0833c0) arrayList.get(0)).f4327a, aaytiVar, moveDuration > changeDuration ? removeDuration + moveDuration : removeDuration + changeDuration);
    }

    /* renamed from: b */
    private void m54936b(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f43416j.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.setDuration(getRemoveDuration());
        defineAnimateRemoveData(viewPropertyAnimatorAnimate);
        viewPropertyAnimatorAnimate.alpha(0.0f).setListener(new awsks(abstractC0833c0, viewPropertyAnimatorAnimate, view)).start();
    }

    /* renamed from: c */
    private void m54941c(View view) {
        view.setAlpha(0.0f);
        view.setScaleX(f43391B);
        view.setScaleY(f43391B);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    /* renamed from: b */
    private Animator m54930b(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
        View view = abstractC0833c0.f4327a;
        BitmapDrawable bitmapDrawableM54911a = m54911a(view, i12 - i10, i13 - i11);
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            Log.e(f43398r, "animateMoveImplPre: viewParent is not instance of ViewGroup");
            return null;
        }
        ViewGroupOverlay overlay = ((ViewGroup) parent).getOverlay();
        if (overlay != null && bitmapDrawableM54911a != null) {
            overlay.add(bitmapDrawableM54911a);
            view.setAlpha(0.0f);
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
            valueAnimatorOfInt.setDuration(150L);
            valueAnimatorOfInt.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), C8721R.interpolator.cubic_bezier_interpolator_type_33_33));
            valueAnimatorOfInt.addListener(new bwuqo(overlay, bitmapDrawableM54911a));
            valueAnimatorOfInt.addUpdateListener(new anbq(bitmapDrawableM54911a, parent));
            valueAnimatorOfInt.start();
            return valueAnimatorOfInt;
        }
        Log.e(f43398r, "animateMoveImplPre: overlayView or drawable is null");
        return null;
    }

    /* renamed from: a */
    private Animator.AnimatorListener m54906a(RecyclerView.AbstractC0833c0 abstractC0833c0, Animator animator, ViewPropertyAnimator viewPropertyAnimator) {
        return new aijfr(abstractC0833c0, animator, viewPropertyAnimator, abstractC0833c0.f4327a);
    }

    /* renamed from: a */
    private BitmapDrawable m54911a(View view, int i10, int i11) {
        int width = view.getWidth();
        int height = view.getHeight();
        bxac bxacVar = null;
        if (width > 0 && height > 0) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmapCreateBitmap));
            afdzw afdzwVar = new afdzw(this, view.getResources(), bitmapCreateBitmap, bxacVar);
            afdzwVar.setBounds(0, 0, width, height);
            afdzwVar.m54953a(view.getLeft() - i10, view.getTop() - i11);
            return afdzwVar;
        }
        Log.w(f43398r, "getDrawableByView: width or height is invalid.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54916a(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (abstractC0833c0 == null) {
            return;
        }
        View view = abstractC0833c0.f4327a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f43414h.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.setDuration(getAddDuration());
        defineAnimateAddData(viewPropertyAnimatorAnimate);
        viewPropertyAnimatorAnimate.alpha(1.0f).setListener(new alzfb(abstractC0833c0, view, viewPropertyAnimatorAnimate)).start();
    }

    /* renamed from: b */
    private void m54937b(boqdu boqduVar) {
        if (boqduVar.f43460a != null) {
            m54928a(boqduVar, boqduVar.f43460a);
        }
        if (boqduVar.f43461b != null) {
            m54928a(boqduVar, boqduVar.f43461b);
        }
    }

    /* renamed from: b */
    private void m54935b(View view, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        for (int size = this.f43412f.size() - 1; size >= 0; size--) {
            List<bkfsb> list = this.f43412f.get(size);
            int size2 = list.size() - 1;
            while (true) {
                if (size2 < 0) {
                    break;
                }
                if (list.get(size2).f43454a == abstractC0833c0) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(abstractC0833c0);
                    list.remove(size2);
                    if (list.isEmpty()) {
                        this.f43412f.remove(size);
                    }
                } else {
                    size2--;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54917a(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
        View view = abstractC0833c0.f4327a;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f43415i.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.setDuration(getMoveDuration());
        defineAnimateMoveData(i15, viewPropertyAnimatorAnimate);
        viewPropertyAnimatorAnimate.setListener(new bzrwd(abstractC0833c0, i14, view, i15, viewPropertyAnimatorAnimate)).start();
    }

    /* renamed from: b */
    private void m54934b() {
        for (int size = this.f43412f.size() - 1; size >= 0; size--) {
            List<bkfsb> list = this.f43412f.get(size);
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                bkfsb bkfsbVar = list.get(size2);
                View view = bkfsbVar.f43454a.f4327a;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(bkfsbVar.f43454a);
                list.remove(size2);
                if (list.isEmpty()) {
                    this.f43412f.remove(list);
                }
            }
        }
        for (int size3 = this.f43411e.size() - 1; size3 >= 0; size3--) {
            List<RecyclerView.AbstractC0833c0> list2 = this.f43411e.get(size3);
            for (int size4 = list2.size() - 1; size4 >= 0; size4--) {
                RecyclerView.AbstractC0833c0 abstractC0833c0 = list2.get(size4);
                abstractC0833c0.f4327a.setAlpha(1.0f);
                dispatchAddFinished(abstractC0833c0);
                list2.remove(size4);
                if (list2.isEmpty()) {
                    this.f43411e.remove(list2);
                }
            }
        }
        for (int size5 = this.f43413g.size() - 1; size5 >= 0; size5--) {
            List<boqdu> list3 = this.f43413g.get(size5);
            for (int size6 = list3.size() - 1; size6 >= 0; size6--) {
                m54937b(list3.get(size6));
                if (list3.isEmpty()) {
                    this.f43413g.remove(list3);
                }
            }
        }
        m54924a(this.f43416j);
        m54924a(this.f43415i);
        m54924a(this.f43414h);
        m54924a(this.f43417k);
        dispatchAnimationsFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54918a(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10, List<Animator> list) {
        View view = abstractC0833c0.f4327a;
        m54941c(view);
        if (z10) {
            this.f43415i.add(abstractC0833c0);
        } else {
            this.f43414h.add(abstractC0833c0);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f43391B, 1.0f);
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        Animator.AnimatorListener animatorListenerM54907a = m54907a(abstractC0833c0, z10, viewPropertyAnimatorAnimate, valueAnimatorOfFloat, list);
        viewPropertyAnimatorAnimate.alpha(1.0f).setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), C8721R.interpolator.cubic_bezier_interpolator_type_33_33));
        viewPropertyAnimatorAnimate.setDuration(200L).setListener(animatorListenerM54907a).start();
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), R.interpolator.fast_out_slow_in));
        valueAnimatorOfFloat.addUpdateListener(new aauaf(view));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: a */
    private Animator.AnimatorListener m54907a(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10, ViewPropertyAnimator viewPropertyAnimator, Animator animator, List<Animator> list) {
        return new bqmxo(abstractC0833c0, animator, z10, list, abstractC0833c0.f4327a, viewPropertyAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54919a(boqdu boqduVar) {
        RecyclerView.AbstractC0833c0 abstractC0833c0 = boqduVar.f43460a;
        View view = abstractC0833c0 == null ? null : abstractC0833c0.f4327a;
        RecyclerView.AbstractC0833c0 abstractC0833c02 = boqduVar.f43461b;
        View view2 = abstractC0833c02 != null ? abstractC0833c02.f4327a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f43417k.add(boqduVar.f43460a);
            duration.translationX(boqduVar.f43464e - boqduVar.f43462c);
            duration.translationY(boqduVar.f43465f - boqduVar.f43463d);
            duration.alpha(0.0f).setListener(new akxao(boqduVar, duration, view)).start();
        }
        if (view2 != null) {
            m54915a(view2, boqduVar);
        }
    }

    /* renamed from: a */
    private void m54915a(View view, boqdu boqduVar) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f43417k.add(boqduVar.f43461b);
        viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new avpbg(boqduVar, viewPropertyAnimatorAnimate, view)).start();
    }

    @TargetApi(11)
    /* renamed from: b */
    private static ValueAnimator m54932b(Context context, float f10, float f11, int i10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_slow_in));
        return valueAnimatorOfFloat;
    }

    /* renamed from: a */
    private void m54925a(List<boqdu> list, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        for (int size = list.size() - 1; size >= 0; size--) {
            boqdu boqduVar = list.get(size);
            if (m54928a(boqduVar, abstractC0833c0) && boqduVar.f43460a == null && boqduVar.f43461b == null) {
                list.remove(boqduVar);
            }
        }
    }

    @TargetApi(11)
    /* renamed from: b */
    private static ValueAnimator.AnimatorUpdateListener m54931b(View view) {
        return new brnby(view);
    }

    /* renamed from: a */
    private boolean m54928a(boqdu boqduVar, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        boolean z10 = false;
        if (boqduVar.f43461b != abstractC0833c0) {
            if (boqduVar.f43460a != abstractC0833c0) {
                return false;
            }
            boqduVar.f43460a = null;
            z10 = true;
        } else {
            boqduVar.f43461b = null;
        }
        abstractC0833c0.f4327a.setAlpha(1.0f);
        abstractC0833c0.f4327a.setTranslationX(0.0f);
        abstractC0833c0.f4327a.setTranslationY(0.0f);
        dispatchChangeFinished(abstractC0833c0, z10);
        return true;
    }

    /* renamed from: a */
    private void m54914a(View view, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        for (int size = this.f43411e.size() - 1; size >= 0; size--) {
            List<RecyclerView.AbstractC0833c0> list = this.f43411e.get(size);
            if (list.remove(abstractC0833c0)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(abstractC0833c0);
                if (list.isEmpty()) {
                    this.f43411e.remove(size);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54913a() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    /* renamed from: a */
    private void m54924a(List<RecyclerView.AbstractC0833c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f4327a.animate().cancel();
        }
    }

    /* renamed from: a */
    public void m54952a(ItemDeleteCallBack itemDeleteCallBack) {
        this.f43419m = itemDeleteCallBack;
    }

    @TargetApi(11)
    /* renamed from: a */
    private static ValueAnimator m54910a(Context context, float f10, float f11, int i10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, C8721R.interpolator.cubic_bezier_interpolator_type_33_33));
        return valueAnimatorOfFloat;
    }

    @TargetApi(11)
    /* renamed from: a */
    private static ValueAnimator.AnimatorUpdateListener m54909a(View view) {
        return new blfhz(view);
    }
}
