package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ca.C1400c;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p514o9.C11828b;
import sk.C12809f;

@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class MemberRightView extends LinearLayout {

    /* renamed from: a */
    public View f17170a;

    /* renamed from: b */
    public ImageView f17171b;

    /* renamed from: c */
    public TextView f17172c;

    /* renamed from: d */
    public TextView f17173d;

    /* renamed from: e */
    public TextView f17174e;

    /* renamed from: f */
    public TextView f17175f;

    /* renamed from: g */
    public TextView f17176g;

    /* renamed from: h */
    public TextView f17177h;

    /* renamed from: i */
    public LinearLayout f17178i;

    /* renamed from: j */
    public String f17179j;

    /* renamed from: k */
    public C11828b f17180k;

    /* renamed from: l */
    public Context f17181l;

    /* renamed from: m */
    public RecyclerView f17182m;

    public MemberRightView(Context context) {
        super(context);
        this.f17180k = new C11828b(C1400c.m8058d());
        this.f17181l = context;
        m23607a();
    }

    /* renamed from: a */
    public final void m23607a() {
        View viewInflate = LayoutInflater.from(this.f17181l).inflate(R$layout.member_right_fragment, this);
        this.f17170a = viewInflate;
        this.f17171b = (ImageView) C12809f.m76831d(viewInflate, R$id.image_icon);
        this.f17172c = (TextView) C12809f.m76831d(this.f17170a, R$id.image_title);
        this.f17173d = (TextView) C12809f.m76831d(this.f17170a, R$id.image_intrudation);
        this.f17174e = (TextView) C12809f.m76831d(this.f17170a, R$id.server_object);
        this.f17175f = (TextView) C12809f.m76831d(this.f17170a, R$id.server_object_value);
        this.f17176g = (TextView) C12809f.m76831d(this.f17170a, R$id.right_introduct);
        this.f17177h = (TextView) C12809f.m76831d(this.f17170a, R$id.right_introduct_value);
        this.f17178i = (LinearLayout) C12809f.m76831d(this.f17170a, R$id.right_text_layout);
        this.f17182m = (RecyclerView) C12809f.m76831d(this.f17170a, R$id.mem_right_table);
    }

    public String getFlagTag() {
        return this.f17179j;
    }

    public void setTag(String str) {
        this.f17179j = str;
    }

    public MemberRightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17180k = new C11828b(C1400c.m8058d());
        this.f17181l = context;
        m23607a();
    }
}
