package com.huawei.android.hicloud.p088ui.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$styleable;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class HiCloudExceptionView extends RelativeLayout implements View.OnClickListener, InterfaceC12805b {

    /* renamed from: a */
    public Context f17844a;

    /* renamed from: b */
    public ImageView f17845b;

    /* renamed from: c */
    public TextView f17846c;

    /* renamed from: d */
    public RelativeLayout f17847d;

    /* renamed from: e */
    public TextView f17848e;

    /* renamed from: f */
    public ImageView f17849f;

    /* renamed from: g */
    public RelativeLayout f17850g;

    /* renamed from: h */
    public RelativeLayout f17851h;

    /* renamed from: i */
    public NotchFitRelativeLayout f17852i;

    /* renamed from: j */
    public View.OnClickListener f17853j;

    /* renamed from: k */
    public View.OnClickListener f17854k;

    public HiCloudExceptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17844a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hicloud_exception_attr);
        m23913h(context);
        m23911d(typedArrayObtainStyledAttributes);
    }

    /* renamed from: d */
    private void m23911d(TypedArray typedArray) {
        if (typedArray != null) {
            m23912g(typedArray);
            m23917e(typedArray);
            m23918f(typedArray);
            typedArray.recycle();
        }
    }

    /* renamed from: g */
    private void m23912g(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(R$styleable.hicloud_exception_attr_exception_img);
        if (drawable != null) {
            this.f17845b.setVisibility(0);
            this.f17845b.setImageDrawable(drawable);
        }
    }

    /* renamed from: h */
    private void m23913h(Context context) {
        if (context == null) {
            return;
        }
        if (C0209d.m1195O(context) >= 1.75f) {
            View.inflate(context, R$layout.hicloud_exception_layout_scale_1dot75, this);
        } else {
            View.inflate(context, R$layout.hicloud_exception_layout, this);
        }
        this.f17851h = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_exception);
        this.f17852i = (NotchFitRelativeLayout) C12809f.m76831d(this, R$id.notch_fit_exception_out_frame);
        this.f17845b = (ImageView) C12809f.m76831d(this, R$id.hicloud_exception_img);
        this.f17846c = (TextView) C12809f.m76831d(this, R$id.hicloud_exception_content);
        setContentViewMax(this.f17844a);
        this.f17847d = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_exception_handle);
        this.f17848e = (TextView) C12809f.m76831d(this, R$id.hicloud_exception_handle_tip);
        this.f17849f = (ImageView) C12809f.m76831d(this, R$id.hicloud_exception_handle_arrow);
        this.f17850g = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_exception_column);
        C11842p.m70721D1(this.f17846c, 2.0f);
        C11842p.m70721D1(this.f17848e, 2.0f);
        this.f17851h.setOnClickListener(this);
        this.f17847d.setOnClickListener(this);
    }

    /* renamed from: a */
    public void m23914a() {
        this.f17851h.setVisibility(8);
    }

    /* renamed from: b */
    public void m23915b() {
        this.f17849f.setVisibility(4);
    }

    /* renamed from: c */
    public void m23916c() {
        this.f17848e.setVisibility(8);
    }

    /* renamed from: e */
    public final void m23917e(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_exception_attr_exception_content);
        if (string != null) {
            this.f17846c.setVisibility(0);
            this.f17846c.setText(string);
        }
    }

    /* renamed from: f */
    public void m23918f(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_exception_attr_exception_handle_msg);
        if (string != null) {
            this.f17848e.setVisibility(0);
            this.f17848e.setText(string);
        }
    }

    /* renamed from: i */
    public void m23919i() {
        this.f17851h.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.hicloud_exception) {
            View.OnClickListener onClickListener = this.f17854k;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            } else {
                if (C0209d.m1333z1(this.f17844a)) {
                    m23914a();
                    return;
                }
                return;
            }
        }
        if (id2 == R$id.hicloud_exception_handle) {
            View.OnClickListener onClickListener2 = this.f17853j;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
                return;
            }
            C11829c.m70612r1(this.f17844a);
            C13227f.m79492i1().m79585f0("action_code_backup_detail_set_wlan", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_detail_set_wlan", "1", "77");
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentViewMax(this.f17844a);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        this.f17852i.onRotation180(windowInsets);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        this.f17852i.onRotation270(windowInsets);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        this.f17852i.onRotation90(windowInsets);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        this.f17852i.onRotationPortrait(windowInsets);
    }

    public void setContent(int i10) throws Resources.NotFoundException {
        String string = getResources().getString(i10);
        this.f17846c.setVisibility(0);
        this.f17846c.setText(string);
    }

    public void setContentViewMax(Context context) {
        if (context == null) {
            return;
        }
        if ((context instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) context)) {
            this.f17846c.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this.f17844a, 32)));
        } else {
            this.f17846c.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this.f17844a, 32)));
        }
    }

    public void setHandleClickListener(View.OnClickListener onClickListener) {
        this.f17853j = onClickListener;
    }

    public void setHandleTip(int i10) throws Resources.NotFoundException {
        String string = getResources().getString(i10);
        this.f17848e.setVisibility(0);
        this.f17848e.setText(string);
    }

    public void setImage(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10, null);
        this.f17845b.setVisibility(0);
        this.f17845b.setImageDrawable(drawable);
    }

    public void setRetryClickListener(View.OnClickListener onClickListener) {
        this.f17854k = onClickListener;
    }
}
