package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ca.C1400c;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p514o9.C11828b;
import p802y8.C13917a;
import p802y8.C13918b;
import p802y8.C13921e;
import sk.C12809f;

@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class WishMemberRightView extends LinearLayout {

    /* renamed from: a */
    public View f17498a;

    /* renamed from: b */
    public ImageView f17499b;

    /* renamed from: c */
    public TextView f17500c;

    /* renamed from: d */
    public TextView f17501d;

    /* renamed from: e */
    public TextView f17502e;

    /* renamed from: f */
    public EditText f17503f;

    /* renamed from: g */
    public TextView f17504g;

    /* renamed from: h */
    public TextView f17505h;

    /* renamed from: i */
    public EditText f17506i;

    /* renamed from: j */
    public TextView f17507j;

    /* renamed from: k */
    public String f17508k;

    /* renamed from: l */
    public final C11828b f17509l;

    /* renamed from: m */
    public final Context f17510m;

    /* renamed from: n */
    public TextWatcher f17511n;

    /* renamed from: o */
    public TextWatcher f17512o;

    public WishMemberRightView(Context context) {
        super(context);
        this.f17509l = new C11828b(C1400c.m8058d());
        this.f17510m = context;
        m23890b();
    }

    /* renamed from: b */
    public final void m23890b() {
        View viewInflate = LayoutInflater.from(this.f17510m).inflate(R$layout.member_right_fragment_wish, this);
        this.f17498a = viewInflate;
        this.f17499b = (ImageView) C12809f.m76831d(viewInflate, R$id.image_icon);
        this.f17500c = (TextView) C12809f.m76831d(this.f17498a, R$id.image_title);
        this.f17501d = (TextView) C12809f.m76831d(this.f17498a, R$id.image_introduction);
        this.f17502e = (TextView) C12809f.m76831d(this.f17498a, R$id.server_object);
        this.f17503f = (EditText) C12809f.m76831d(this.f17498a, R$id.edt_wish_title);
        this.f17504g = (TextView) C12809f.m76831d(this.f17498a, R$id.tv_count_limit_title);
        this.f17505h = (TextView) C12809f.m76831d(this.f17498a, R$id.right_introduce);
        this.f17506i = (EditText) C12809f.m76831d(this.f17498a, R$id.edt_wish_detail);
        this.f17507j = (TextView) C12809f.m76831d(this.f17498a, R$id.tv_count_limit_detail);
        this.f17498a.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17559a.m23891c(view);
            }
        });
        C13918b.m83426D(this.f17510m, this.f17504g, 0, 30);
        C13918b.m83426D(this.f17510m, this.f17507j, 0, 200);
        C13917a c13917a = new C13917a();
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(30);
        InputFilter.LengthFilter lengthFilter2 = new InputFilter.LengthFilter(200);
        this.f17503f.setFilters(new InputFilter[]{c13917a, lengthFilter});
        this.f17506i.setFilters(new InputFilter[]{c13917a, lengthFilter2});
        this.f17511n = new C13921e(this.f17510m, 1, this.f17504g);
        this.f17512o = new C13921e(this.f17510m, 2, this.f17507j);
        this.f17503f.addTextChangedListener(this.f17511n);
        this.f17506i.addTextChangedListener(this.f17512o);
    }

    /* renamed from: c */
    public final /* synthetic */ void m23891c(View view) {
        Context context = this.f17510m;
        if (context instanceof Activity) {
            C13918b.m83438u((Activity) context);
        }
    }

    public String getFlagTag() {
        return this.f17508k;
    }

    public String getWishDetailText() {
        Editable text;
        EditText editText = this.f17506i;
        return (editText == null || (text = editText.getText()) == null) ? "" : text.toString();
    }

    public String getWishTitleText() {
        Editable text;
        EditText editText = this.f17503f;
        return (editText == null || (text = editText.getText()) == null) ? "" : text.toString();
    }

    public void setTag(String str) {
        this.f17508k = str;
    }

    public WishMemberRightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17509l = new C11828b(C1400c.m8058d());
        this.f17510m = context;
        m23890b();
    }
}
