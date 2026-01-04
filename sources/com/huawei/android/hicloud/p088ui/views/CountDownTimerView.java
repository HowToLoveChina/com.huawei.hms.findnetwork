package com.huawei.android.hicloud.p088ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.hms.network.embedded.C5863b6;
import p015ak.C0213f;
import p054cj.C1442a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class CountDownTimerView extends AppCompatTextView {

    /* renamed from: h */
    public long f19437h;

    /* renamed from: i */
    public long f19438i;

    /* renamed from: j */
    public long f19439j;

    /* renamed from: k */
    public boolean f19440k;

    /* renamed from: l */
    public boolean f19441l;

    /* renamed from: m */
    public boolean f19442m;

    /* renamed from: n */
    public String f19443n;

    /* renamed from: o */
    public CountDownFinishListener f19444o;

    /* renamed from: p */
    public final Runnable f19445p;

    public interface CountDownFinishListener {
        void onFinish();
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.CountDownTimerView$a */
    public class RunnableC4285a implements Runnable {
        public RunnableC4285a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CountDownTimerView.this.f19441l) {
                CountDownTimerView.this.m25745t();
            }
        }
    }

    public CountDownTimerView(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    public final void m25743A(long j10) {
        setText(m25746u(j10));
    }

    /* renamed from: B */
    public final void m25744B() {
        boolean z10 = this.f19440k && this.f19442m && isShown();
        if (z10 != this.f19441l) {
            if (z10) {
                m25745t();
            } else {
                removeCallbacks(this.f19445p);
            }
            this.f19441l = z10;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f19440k = false;
        m25744B();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        m25744B();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f19440k = i10 == 0;
        m25744B();
    }

    public void setOnCountDownFinishListener(CountDownFinishListener countDownFinishListener) {
        this.f19444o = countDownFinishListener;
    }

    /* renamed from: t */
    public final void m25745t() {
        long jElapsedRealtime = this.f19439j - SystemClock.elapsedRealtime();
        long j10 = 0;
        if (jElapsedRealtime <= 0) {
            m25749x();
            return;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        m25743A(jElapsedRealtime);
        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
        long j11 = this.f19438i;
        if (jElapsedRealtime < j11) {
            long j12 = jElapsedRealtime - jElapsedRealtime3;
            if (j12 >= 0) {
                j10 = j12;
            }
        } else {
            long j13 = j11 - jElapsedRealtime3;
            while (j13 < 0) {
                j13 += this.f19438i;
            }
            j10 = j13;
        }
        postDelayed(this.f19445p, j10);
    }

    /* renamed from: u */
    public final String m25746u(long j10) throws Resources.NotFoundException {
        try {
            if (j10 >= 259200000) {
                int iCeil = (int) Math.ceil((j10 * 1.0d) / 8.64E7d);
                String quantityString = C0213f.m1377a().getResources().getQuantityString(R$plurals.common_days, iCeil, Integer.valueOf(iCeil));
                return TextUtils.isEmpty(this.f19443n) ? quantityString : String.format(this.f19443n, quantityString);
            }
            long j11 = j10 / 1000;
            String str = String.format("%02d:%02d:%02d", Integer.valueOf((int) (j10 / C5863b6.g.f26453g)), Integer.valueOf((int) ((j11 % 3600) / 60)), Integer.valueOf((int) (j11 % 60)));
            return TextUtils.isEmpty(this.f19443n) ? str : String.format(this.f19443n, str);
        } catch (NumberFormatException e10) {
            C1442a.m8289e("CountDownTimerView", "formatTime err" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: v */
    public void m25747v(long j10, long j11) {
        this.f19437h = j10;
        this.f19438i = j11;
        long jElapsedRealtime = SystemClock.elapsedRealtime() + this.f19437h;
        this.f19439j = jElapsedRealtime;
        m25743A(jElapsedRealtime);
    }

    /* renamed from: w */
    public final void m25748w(TypedArray typedArray) {
        if (typedArray != null) {
            this.f19443n = typedArray.getString(R$styleable.count_down_timer_prefixText);
            typedArray.recycle();
        }
    }

    /* renamed from: x */
    public final void m25749x() {
        m25751z();
        CountDownFinishListener countDownFinishListener = this.f19444o;
        if (countDownFinishListener != null) {
            countDownFinishListener.onFinish();
        }
    }

    /* renamed from: y */
    public void m25750y() {
        this.f19442m = true;
        m25744B();
    }

    /* renamed from: z */
    public void m25751z() {
        this.f19442m = false;
        m25744B();
    }

    public CountDownTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownTimerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19443n = "";
        this.f19445p = new RunnableC4285a();
        m25748w(context.obtainStyledAttributes(attributeSet, R$styleable.count_down_timer));
    }
}
