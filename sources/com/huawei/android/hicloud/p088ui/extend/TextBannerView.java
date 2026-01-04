package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.huawei.hicloud.sync.R$anim;
import com.huawei.hicloud.sync.R$styleable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p514o9.C11839m;
import p514o9.C11842p;
import p815ym.AbstractC14026a;

/* loaded from: classes3.dex */
public class TextBannerView extends RelativeLayout {

    /* renamed from: a */
    public ViewFlipper f17996a;

    /* renamed from: b */
    public List<TextView> f17997b;

    /* renamed from: c */
    public int f17998c;

    /* renamed from: d */
    public boolean f17999d;

    /* renamed from: e */
    public int f18000e;

    /* renamed from: f */
    public int f18001f;

    /* renamed from: g */
    public int f18002g;

    /* renamed from: h */
    public boolean f18003h;

    /* renamed from: i */
    public int f18004i;

    /* renamed from: j */
    public int f18005j;

    /* renamed from: k */
    public int f18006k;

    /* renamed from: l */
    public int f18007l;

    /* renamed from: m */
    public int f18008m;

    /* renamed from: n */
    public int f18009n;

    /* renamed from: o */
    public int f18010o;

    /* renamed from: p */
    public List<String> f18011p;

    /* renamed from: q */
    public boolean f18012q;

    /* renamed from: r */
    public boolean f18013r;

    /* renamed from: s */
    public RunnableC3942b f18014s;

    /* renamed from: com.huawei.android.hicloud.ui.extend.TextBannerView$b */
    public class RunnableC3942b implements Runnable {
        public RunnableC3942b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            if (!TextBannerView.this.f18013r) {
                TextBannerView.this.m24048p();
                return;
            }
            TextBannerView textBannerView = TextBannerView.this;
            textBannerView.setInAnimation(textBannerView.f18006k);
            TextBannerView textBannerView2 = TextBannerView.this;
            textBannerView2.setOutAnimation(textBannerView2.f18007l);
            TextBannerView.this.f17996a.showNext();
            TextBannerView.this.postDelayed(this, r0.f17998c + TextBannerView.this.f18008m);
        }
    }

    public TextBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17997b = new ArrayList();
        this.f17998c = 3000;
        this.f17999d = false;
        this.f18001f = -16777216;
        this.f18002g = 16;
        this.f18003h = false;
        this.f18005j = 0;
        this.f18006k = R$anim.anim_right_in;
        this.f18007l = R$anim.anim_left_out;
        this.f18008m = 1500;
        this.f18009n = -1;
        this.f18010o = 0;
        this.f18011p = new ArrayList();
        this.f18014s = new RunnableC3942b();
        m24042j(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInAnimation(int i10) throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i10);
        animationLoadAnimation.setDuration(this.f18008m);
        this.f17996a.setInAnimation(animationLoadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutAnimation(int i10) throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i10);
        animationLoadAnimation.setDuration(this.f18008m);
        this.f17996a.setOutAnimation(animationLoadAnimation);
    }

    /* renamed from: i */
    public void m24041i() {
        this.f17996a.removeAllViews();
        this.f17997b.clear();
        m24048p();
    }

    /* renamed from: j */
    public final void m24042j(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextBannerViewStyle, i10, 0);
        this.f17998c = typedArrayObtainStyledAttributes.getInteger(R$styleable.TextBannerViewStyle_setInterval, this.f17998c);
        this.f17999d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextBannerViewStyle_setSingleLine, false);
        this.f18001f = typedArrayObtainStyledAttributes.getColor(R$styleable.TextBannerViewStyle_setTextColor, this.f18001f);
        int i12 = R$styleable.TextBannerViewStyle_setTextSize;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            int dimension = (int) typedArrayObtainStyledAttributes.getDimension(i12, this.f18002g);
            this.f18002g = dimension;
            this.f18002g = C11842p.m70814g1(context, dimension);
        }
        this.f18008m = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setAnimDuration, this.f18008m);
        int i13 = R$styleable.TextBannerViewStyle_setDirection;
        this.f18003h = typedArrayObtainStyledAttributes.hasValue(i13);
        this.f18005j = typedArrayObtainStyledAttributes.getInt(i13, this.f18005j);
        this.f18004i = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setGravity, this.f18004i);
        this.f18000e = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_maxLine, this.f18000e);
        if (!this.f18003h || (i11 = this.f18005j) == 0) {
            this.f18006k = R$anim.anim_bottom_in;
            this.f18007l = R$anim.anim_top_out;
        } else if (i11 == 1) {
            this.f18006k = R$anim.anim_top_in;
            this.f18007l = R$anim.anim_bottom_out;
        } else if (i11 == 2) {
            this.f18006k = R$anim.anim_right_in;
            this.f18007l = R$anim.anim_left_out;
        } else if (i11 == 3) {
            this.f18006k = R$anim.anim_left_in;
            this.f18007l = R$anim.anim_right_out;
        }
        this.f18009n = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setFlags, this.f18009n);
        m24044l();
        this.f18010o = typedArrayObtainStyledAttributes.getInt(R$styleable.TextBannerViewStyle_setTypeface, this.f18010o);
        m24043k();
        this.f17996a = new ViewFlipper(getContext());
        this.f17997b = new ArrayList();
        this.f17996a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        addView(this.f17996a);
        m24047o();
    }

    /* renamed from: k */
    public final void m24043k() {
        int i10 = this.f18010o;
        if (i10 == 1) {
            this.f18010o = 1;
            return;
        }
        if (i10 == 2) {
            this.f18010o = 2;
        } else if (i10 != 3) {
            this.f18010o = 0;
        } else {
            this.f18010o = 3;
        }
    }

    /* renamed from: l */
    public final void m24044l() {
        int i10 = this.f18009n;
        if (i10 == 0) {
            this.f18009n = 17;
        } else if (i10 != 1) {
            this.f18009n = 1;
        } else {
            this.f18009n = 9;
        }
    }

    /* renamed from: m */
    public void m24045m(String str, int i10) {
        TextView textView;
        List<TextView> list = this.f17997b;
        if (list == null || list.size() < i10 + 1 || (textView = this.f17997b.get(i10)) == null) {
            return;
        }
        textView.setText(str);
    }

    /* renamed from: n */
    public final void m24046n(TextView textView, String str) {
        int i10;
        textView.setText(str);
        textView.setSingleLine(this.f17999d);
        if (!this.f17999d && (i10 = this.f18000e) != 0) {
            textView.setMaxLines(i10);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.f18001f);
        textView.setTextSize(this.f18002g);
        textView.getPaint().setFlags(this.f18009n);
        textView.setTypeface(null, this.f18010o);
        int i11 = this.f18004i;
        if (i11 == 1) {
            textView.setGravity(i11);
        }
    }

    /* renamed from: o */
    public void m24047o() {
        C11839m.m70686d("TextBannerView", "startViewAnimator isStarted = " + this.f18013r + ", isDetachedFromWindow = " + this.f18012q);
        if (this.f18013r || this.f18012q) {
            return;
        }
        this.f18013r = true;
        postDelayed(this.f18014s, this.f17998c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C11839m.m70686d("TextBannerView", "onAttached");
        this.f18012q = false;
        m24047o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C11839m.m70686d("TextBannerView", "onDetached");
        this.f18012q = true;
        m24048p();
    }

    /* renamed from: p */
    public void m24048p() {
        C11839m.m70686d("TextBannerView", "stopViewAnimator isStarted " + this.f18013r);
        if (this.f18013r) {
            removeCallbacks(this.f18014s);
            this.f17996a.setInAnimation(null);
            this.f17996a.setOutAnimation(null);
            this.f18013r = false;
        }
    }

    public void setData(Map<String, Integer> map) {
        TextView textView;
        Set<Map.Entry<String, Integer>> setEntrySet = map.entrySet();
        if (AbstractC14026a.m84159a(setEntrySet)) {
            return;
        }
        int i10 = 0;
        if (this.f17997b.isEmpty()) {
            this.f17996a.removeAllViews();
            this.f17997b.clear();
            for (Map.Entry<String, Integer> entry : setEntrySet) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                TextView textView2 = new TextView(getContext());
                m24046n(textView2, key);
                textView2.setTextColor(iIntValue);
                this.f17996a.addView(textView2, i10);
                this.f17997b.add(textView2);
                i10++;
            }
            return;
        }
        for (Map.Entry<String, Integer> entry2 : setEntrySet) {
            if (i10 >= this.f17997b.size()) {
                textView = new TextView(getContext());
                this.f17996a.addView(textView, i10);
                this.f17997b.add(textView);
            } else {
                textView = this.f17997b.get(i10);
            }
            String key2 = entry2.getKey();
            int iIntValue2 = entry2.getValue().intValue();
            m24046n(textView, key2);
            textView.setTextColor(iIntValue2);
            i10++;
        }
    }

    public void setDatas(List<String> list) {
        this.f18011p = list;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f17996a.removeAllViews();
        this.f17997b.clear();
        for (int i10 = 0; i10 < this.f18011p.size(); i10++) {
            TextView textView = new TextView(getContext());
            m24046n(textView, this.f18011p.get(i10));
            this.f17996a.addView(textView, i10);
            this.f17997b.add(textView);
        }
    }

    public TextBannerView(Context context) {
        this(context, null);
    }
}
