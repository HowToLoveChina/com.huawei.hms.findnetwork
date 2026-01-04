package com.huawei.android.hicloud.p088ui.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$styleable;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12318k0;
import p674ub.C13152i;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class HiCloudUrgencyView extends RelativeLayout implements View.OnClickListener, InterfaceC12805b {

    /* renamed from: a */
    public Context f19493a;

    /* renamed from: b */
    public ImageView f19494b;

    /* renamed from: c */
    public TextView f19495c;

    /* renamed from: d */
    public ImageView f19496d;

    /* renamed from: e */
    public RelativeLayout f19497e;

    /* renamed from: f */
    public RelativeLayout f19498f;

    /* renamed from: g */
    public NotchFitRelativeLayout f19499g;

    /* renamed from: h */
    public String f19500h;

    /* renamed from: i */
    public String f19501i;

    /* renamed from: j */
    public String f19502j;

    public HiCloudUrgencyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19493a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hicloud_exception_attr);
        m25775d(context);
        m25772a(typedArrayObtainStyledAttributes);
    }

    /* renamed from: a */
    private void m25772a(TypedArray typedArray) {
        if (typedArray != null) {
            m25774c(typedArray);
            m25773b(typedArray);
            typedArray.recycle();
        }
    }

    /* renamed from: b */
    private void m25773b(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_exception_attr_exception_content);
        if (string != null) {
            this.f19495c.setVisibility(0);
            this.f19495c.setText(string);
        }
    }

    /* renamed from: c */
    private void m25774c(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(R$styleable.hicloud_exception_attr_exception_img);
        if (drawable != null) {
            this.f19494b.setVisibility(0);
            this.f19494b.setImageDrawable(drawable);
        }
    }

    /* renamed from: d */
    private void m25775d(Context context) {
        View.inflate(context, R$layout.hicloud_urgency_layout, this);
        this.f19498f = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_urgency);
        this.f19499g = (NotchFitRelativeLayout) C12809f.m76831d(this, R$id.notch_fit_urgency_out_frame);
        this.f19494b = (ImageView) C12809f.m76831d(this, R$id.hicloud_urgency_img);
        this.f19495c = (TextView) C12809f.m76831d(this, R$id.hicloud_urgency_content);
        this.f19496d = (ImageView) C12809f.m76831d(this, R$id.hicloud_urgency_handle_arrow);
        this.f19497e = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_urgency_column);
        this.f19498f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intentM79111y;
        if (TextUtils.isEmpty(this.f19500h)) {
            C11839m.m70687e("HiCloudUrencyView", "mGotoType null");
            return;
        }
        try {
            if (this.f19500h.equals("detail")) {
                intentM79111y = new Intent();
                C0209d.m1302r2(intentM79111y, "com.huawei.hidisk");
                intentM79111y.setAction("com.huawei.android.hicloud.ui.activity.UrgencyDetailActivity");
                intentM79111y.putExtra("urgency_goto_detail", this.f19501i);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("urgency goto", String.valueOf("HiCloudUrencyView:detail-" + this.f19501i + ",Time =" + System.currentTimeMillis()));
                C12318k0.m74089a("urgency notice event", linkedHashMap);
            } else if (this.f19500h.equals("web")) {
                intentM79111y = C13152i.m79070o().m79111y(this.f19502j);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("urgency goto", String.valueOf("HiCloudUrencyView:web-" + this.f19502j + ",Time =" + System.currentTimeMillis()));
                C12318k0.m74089a("urgency notice event", linkedHashMap2);
            } else {
                intentM79111y = null;
            }
            Context context = getContext();
            if (context == null || intentM79111y == null) {
                return;
            }
            context.startActivity(intentM79111y);
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudUrencyView", "startActivity exception:" + e10.toString());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m25775d(this.f19493a);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        this.f19499g.onRotationPortrait(windowInsets);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        this.f19499g.onRotation270(windowInsets);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        this.f19499g.onRotation90(windowInsets);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        this.f19499g.onRotationPortrait(windowInsets);
    }

    public void setContent(String str) {
        this.f19495c.setVisibility(0);
        this.f19495c.setText(str);
    }

    public void setContentViewMax(Context context) {
        if (context == null) {
            return;
        }
        if ((context instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) context)) {
            this.f19495c.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this.f19493a, 32)));
        } else {
            this.f19495c.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this.f19493a, 32)));
        }
    }

    public void setDetailJsonStr(String str) {
        this.f19501i = str;
    }

    public void setGotoType(String str) {
        this.f19500h = str;
    }

    public void setImage(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10, null);
        this.f19494b.setVisibility(0);
        this.f19494b.setImageDrawable(drawable);
    }

    public void setUrl(String str) {
        this.f19502j = str;
    }
}
