package com.huawei.android.hicloud.p088ui.extend;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import com.huawei.hicloud.sync.R$styleable;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12806c;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class NotchTopFitRelativeLayout extends RelativeLayout implements InterfaceC12805b {

    /* renamed from: a */
    public int f17944a;

    /* renamed from: b */
    public int f17945b;

    /* renamed from: c */
    public Context f17946c;

    /* renamed from: d */
    public boolean f17947d;

    public NotchTopFitRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17944a = 0;
        this.f17945b = 0;
        this.f17946c = context;
        if (context != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.notch_style);
            this.f17947d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.notch_style_isFullScreen, true);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (!C11829c.m70563b0(context) || C0219i.m1463a() < 17) {
            return;
        }
        this.f17944a = C11842p.m70789a0(context);
        if (C0209d.m1249e1()) {
            this.f17945b = this.f17944a;
        }
    }

    /* renamed from: a */
    public void m23999a() {
        this.f17944a = 0;
        int iM76811b = C12806c.m76811b(getContext());
        if (iM76811b == 1) {
            onRotation90(null);
            return;
        }
        if (iM76811b == 3) {
            onRotation270(null);
        } else if (2 == iM76811b) {
            onRotation180(null);
        } else {
            onRotationPortrait(null);
        }
    }

    /* renamed from: b */
    public final void m24000b() {
        if (this.f17947d) {
            setPadding(0, this.f17944a, 0, 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        if (!C11829c.m70556Y0(this.f17946c)) {
            setPadding(0, 0, 0, 0);
        } else {
            int i10 = this.f17944a;
            setPadding(0, i10, 0, i10);
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        if (C0209d.m1249e1()) {
            this.f17945b = this.f17944a;
        }
        setPadding(0, this.f17945b, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        if (C0209d.m1249e1()) {
            this.f17945b = this.f17944a;
        }
        setPadding(0, this.f17945b, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        Context context = this.f17946c;
        if (context instanceof Activity) {
            if (C0209d.m1237b1(context)) {
                boolean zM70502B0 = C11829c.m70502B0((Activity) this.f17946c);
                if (!C12806c.m76819j((Activity) this.f17946c) || zM70502B0) {
                    setPadding(0, 0, 0, 0);
                    return;
                } else {
                    m24000b();
                    return;
                }
            }
            if (C11829c.m70502B0((Activity) this.f17946c) && C11842p.m70750N0()) {
                m24000b();
            } else if (C11829c.m70556Y0(this.f17946c)) {
                m24000b();
            } else {
                setPadding(0, 0, 0, 0);
            }
        }
    }
}
