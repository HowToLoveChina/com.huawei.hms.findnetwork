package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;

/* renamed from: com.huawei.openalliance.ad.views.j */
/* loaded from: classes2.dex */
public class C8134j extends RelativeLayout {

    /* renamed from: a */
    protected View f37923a;

    /* renamed from: b */
    protected TextView f37924b;

    /* renamed from: c */
    protected TextView f37925c;

    /* renamed from: d */
    protected boolean f37926d;

    /* renamed from: e */
    protected int f37927e;

    public C8134j(Context context) {
        super(context);
        this.f37927e = 1;
    }

    /* renamed from: a */
    public void m50325a() {
        if (this.f37926d || this.f37927e != 1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin += AbstractC7811dd.m48326f(getContext());
            setLayoutParams(layoutParams2);
        }
    }

    public void setOrientation(int i10) {
        this.f37927e = i10;
    }

    public void setShowLogo(boolean z10) {
        this.f37926d = z10;
        m50325a();
    }

    public C8134j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37927e = 1;
    }

    /* renamed from: a */
    public void m50326a(String str, String str2) {
        if (this.f37924b != null && !TextUtils.isEmpty(str)) {
            this.f37924b.setText(str);
        }
        if (this.f37925c == null || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f37925c.setText(str2);
    }

    public C8134j(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37927e = 1;
    }
}
