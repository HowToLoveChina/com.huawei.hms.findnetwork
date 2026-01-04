package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p015ak.C0241z;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudWishDetailActivity extends UIActivity {

    /* renamed from: p */
    public View f14666p;

    /* renamed from: q */
    public View f14667q;

    /* renamed from: r */
    public String f14668r;

    /* renamed from: s */
    public String f14669s;

    /* renamed from: t */
    public String f14670t;

    /* renamed from: B1 */
    private void m20319B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.wish_list_detail);
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
    }

    /* renamed from: L1 */
    private void m20320L1() {
        this.f14666p = C12809f.m76829b(this, R$id.main_layout);
        this.f14667q = C12809f.m76829b(this, R$id.content_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_wish_title);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.tv_wish_content);
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.tv_wish_date);
        if (!TextUtils.isEmpty(this.f14668r)) {
            textView.setText(this.f14668r);
        }
        if (!TextUtils.isEmpty(this.f14669s)) {
            textView2.setText(this.f14669s);
        }
        if (TextUtils.isEmpty(this.f14670t)) {
            return;
        }
        textView3.setText(DateFormat.getDateFormat(this).format(new Date(C0241z.m1688f(this.f14670t))));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14666p);
        arrayList.add(this.f14667q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_wish_list_detail);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f14668r = safeIntent.getStringExtra("title");
        this.f14669s = safeIntent.getStringExtra("content");
        this.f14670t = safeIntent.getStringExtra(CallLogCons.DATE);
        m20319B1();
        m20320L1();
        mo19005p1();
    }
}
