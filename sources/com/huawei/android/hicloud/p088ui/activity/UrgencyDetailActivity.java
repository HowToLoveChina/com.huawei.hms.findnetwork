package com.huawei.android.hicloud.p088ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.p106db.bean.UrgencyButtons;
import com.huawei.hicloud.notification.p106db.bean.UrgencyDetail;
import com.huawei.hicloud.notification.p106db.bean.UrgencyDetailPicture;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import ge.C9913h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p674ub.C13152i;
import p684un.C13222a;
import p684un.C13230i;
import sk.C12809f;

/* loaded from: classes3.dex */
public class UrgencyDetailActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public String f16318A;

    /* renamed from: B */
    public String f16319B;

    /* renamed from: C */
    public String f16320C;

    /* renamed from: D */
    public String f16321D;

    /* renamed from: E */
    public NotchTopFitRelativeLayout f16322E;

    /* renamed from: F */
    public NotchFitRelativeLayout f16323F;

    /* renamed from: p */
    public ImageView f16324p;

    /* renamed from: q */
    public TextView f16325q;

    /* renamed from: r */
    public TextView f16326r;

    /* renamed from: s */
    public TextView f16327s;

    /* renamed from: t */
    public AutoSizeButton f16328t;

    /* renamed from: u */
    public AutoSizeButton f16329u;

    /* renamed from: v */
    public List<UrgencyButtons> f16330v;

    /* renamed from: w */
    public String f16331w;

    /* renamed from: x */
    public String f16332x;

    /* renamed from: y */
    public String[] f16333y;

    /* renamed from: z */
    public String[] f16334z;

    /* renamed from: O1 */
    private void m22543O1() {
        UrgencyDetail urgencyDetail;
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        String stringExtra = hiCloudSafeIntent.getStringExtra("urgency_goto_detail");
        this.f16319B = hiCloudSafeIntent.getStringExtra("detail_urgency_ID");
        if (stringExtra != null) {
            try {
                urgencyDetail = (UrgencyDetail) new Gson().fromJson(stringExtra, UrgencyDetail.class);
            } catch (Exception e10) {
                C11839m.m70687e("UrgencyDetailActivity", "getUrencyDetail exception:" + e10.getMessage());
                return;
            }
        } else {
            urgencyDetail = null;
        }
        if (urgencyDetail == null) {
            C11839m.m70687e("UrgencyDetailActivity", "getUrency detail fialed");
            return;
        }
        this.f16320C = C13152i.m79071w(urgencyDetail.getContent());
        this.f16321D = C13152i.m79071w(urgencyDetail.getDetailLinkName());
        this.f16332x = C13152i.m79071w(urgencyDetail.getTitle());
        this.f16331w = urgencyDetail.getDetailLink();
        this.f16330v = urgencyDetail.getButtons();
        UrgencyDetailPicture picture = urgencyDetail.getPicture();
        m22549Q1(this.f16330v);
        m22550R1(picture);
        m22552U1();
    }

    /* renamed from: S1 */
    private void m22544S1() {
        this.f16322E = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.urgency_detail_topfit);
        this.f16323F = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.urgency_detail);
        this.f16324p = (ImageView) C12809f.m76829b(this, R$id.urgency_picture);
        this.f16325q = (TextView) C12809f.m76829b(this, R$id.urgency_picture_title);
        this.f16326r = (TextView) C12809f.m76829b(this, R$id.urgency_content);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.urgency_knowe_more);
        this.f16327s = textView;
        textView.setOnClickListener(this);
        this.f16328t = (AutoSizeButton) C12809f.m76829b(this, R$id.urgency_button1);
        this.f16329u = (AutoSizeButton) C12809f.m76829b(this, R$id.urgency_button2);
        this.f16328t.setOnClickListener(this);
        this.f16329u.setOnClickListener(this);
        C11842p.m70874v1(this, this.f16328t);
        C11842p.m70874v1(this, this.f16329u);
        mo19005p1();
    }

    /* renamed from: L1 */
    public final void m22545L1(String str) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "manage":
                Intent intent = new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class);
                C13230i.m79525e1(intent, "1", "2");
                intent.putExtra("is_from_main_activity", false);
                startActivity(intent);
                break;
            case "buy_more":
                C12126b.m72707c(C13222a.m79465g(this), new Bundle());
                break;
            case "upgrade":
            case "relogin":
                C9913h.m61574q().m61600x(this);
                C9913h.m61574q().m61589P(false);
                break;
            default:
                C11839m.m70689w("UrgencyDetailActivity", "no match type");
                break;
        }
    }

    /* renamed from: M1 */
    public final void m22546M1() {
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(RemoteMessageConst.URGENCY);
        sb2.append(str);
        sb2.append("icon");
        sb2.append(this.f16319B);
        String string = sb2.toString();
        if (TextUtils.isEmpty(string) || !m22547N1(string).equals(this.f16318A)) {
            return;
        }
        C11839m.m70688i("UrgencyDetailActivity", "picture has existence");
        Bitmap bitmapM70501B = C11829c.m70501B(string);
        if (bitmapM70501B != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, bitmapM70501B);
            ImageView imageView = this.f16324p;
            if (imageView != null) {
                imageView.setImageDrawable(bitmapDrawable);
            }
        }
    }

    /* renamed from: N1 */
    public final String m22547N1(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyDetailActivity", "generateFileHash exceptions:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: P1 */
    public final void m22548P1(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("UrgencyDetailActivity", "uriStr is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (C0209d.m1251f(intent)) {
            startActivity(intent);
        } else {
            C11839m.m70687e("UrgencyDetailActivity", "click known more: cannot resolve intent");
        }
    }

    /* renamed from: Q1 */
    public final void m22549Q1(List<UrgencyButtons> list) {
        int size;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        this.f16333y = new String[size];
        this.f16334z = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            this.f16333y[i10] = list.get(i10).getActionType();
            this.f16334z[i10] = C13152i.m79071w(list.get(i10).getName());
        }
    }

    /* renamed from: R1 */
    public final void m22550R1(UrgencyDetailPicture urgencyDetailPicture) {
        if (urgencyDetailPicture == null) {
            C11839m.m70687e("UrgencyDetailActivity", "getUrgencyDetailPictureErr null");
        } else {
            this.f16318A = urgencyDetailPicture.getHash();
        }
    }

    /* renamed from: T1 */
    public final void m22551T1(int i10) {
        if (i10 == 2) {
            String[] strArr = this.f16334z;
            String str = strArr[0];
            String str2 = strArr[1];
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f16328t.setText(str);
            this.f16329u.setText(str2);
            return;
        }
        if (i10 != 1) {
            this.f16328t.setVisibility(8);
            this.f16329u.setVisibility(8);
            return;
        }
        String str3 = this.f16334z[0];
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f16328t.setText(str3);
        this.f16329u.setVisibility(8);
    }

    /* renamed from: U1 */
    public final void m22552U1() {
        if (TextUtils.isEmpty(this.f16320C)) {
            this.f16326r.setVisibility(4);
        } else {
            this.f16326r.setText(this.f16320C);
        }
        if (TextUtils.isEmpty(this.f16321D) || TextUtils.isEmpty(this.f16331w)) {
            this.f16327s.setVisibility(8);
        } else {
            this.f16327s.setText(this.f16321D);
        }
        if (TextUtils.isEmpty(this.f16332x)) {
            this.f16325q.setVisibility(4);
        } else {
            this.f16325q.setText(this.f16332x);
        }
        String[] strArr = this.f16334z;
        if (strArr != null) {
            m22551T1(strArr.length);
        } else {
            this.f16328t.setVisibility(8);
            this.f16329u.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16322E);
        arrayList.add(this.f16323F);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        int id2 = view.getId();
        if (id2 == R$id.urgency_button1) {
            String[] strArr2 = this.f16333y;
            if (strArr2 != null) {
                m22545L1(strArr2[0]);
                return;
            }
            return;
        }
        if (id2 == R$id.urgency_knowe_more) {
            m22548P1(this.f16331w);
        } else if (id2 == R$id.urgency_button2 && (strArr = this.f16333y) != null && strArr.length == 2) {
            m22545L1(strArr[1]);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.urgency_detail_layout);
        m22544S1();
        m22543O1();
        m22546M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.urgency_detail_layout);
        m22544S1();
        m22543O1();
        m22546M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
