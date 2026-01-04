package com.huawei.cloud.pay.p098ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.cloud.pay.R$id;
import com.huawei.cloud.pay.R$layout;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.p098ui.uiextend.view.TextBtnCard;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.ChangeUserStatusResp;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9159b;
import hu.C10342a;
import io.C10582a;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0234s;
import p015ak.C0241z;
import p037bp.C1270a;
import p054cj.C1442a;
import p232dp.InterfaceC9285d;
import p292fn.C9733f;
import p431ko.C11075a;
import p454lj.C11287j;
import p454lj.C11296s;
import p454lj.EnumC11283f;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes5.dex */
public class InactiveUserActivity extends UIActivity {

    /* renamed from: A */
    public long f21422A;

    /* renamed from: D */
    public String f21425D;

    /* renamed from: F */
    public boolean f21427F;

    /* renamed from: p */
    public long f21428p;

    /* renamed from: q */
    public View f21429q;

    /* renamed from: r */
    public View f21430r;

    /* renamed from: s */
    public View f21431s;

    /* renamed from: t */
    public View f21432t;

    /* renamed from: u */
    public TextView f21433u;

    /* renamed from: v */
    public AutoSizeButton f21434v;

    /* renamed from: w */
    public AutoSizeButton f21435w;

    /* renamed from: y */
    public ViewGroup f21437y;

    /* renamed from: z */
    public long f21438z;

    /* renamed from: x */
    public boolean f21436x = false;

    /* renamed from: B */
    public boolean f21423B = false;

    /* renamed from: C */
    public boolean f21424C = false;

    /* renamed from: E */
    public boolean f21426E = false;

    /* renamed from: com.huawei.cloud.pay.ui.InactiveUserActivity$a */
    public class C4666a implements C11075a.a<QuotaSpaceInfo> {
        public C4666a() {
        }

        @Override // p431ko.C11075a.a
        /* renamed from: b */
        public void mo19190b() {
            InactiveUserActivity.this.m28505J2();
        }

        @Override // p431ko.C11075a.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public QuotaSpaceInfo mo19189a() {
            return ((InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class)).mo17175h();
        }

        /* renamed from: e */
        public final /* synthetic */ void m28560e() throws IllegalAccessException, IllegalArgumentException {
            InactiveUserActivity.this.m28539E2();
        }

        @Override // p431ko.C11075a.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onResult(QuotaSpaceInfo quotaSpaceInfo) {
            InactiveUserActivity.this.f21438z = quotaSpaceInfo.getTotal();
            InactiveUserActivity.this.f21422A = quotaSpaceInfo.getUsed();
            InactiveUserActivity inactiveUserActivity = InactiveUserActivity.this;
            inactiveUserActivity.m28540F2(inactiveUserActivity.f21438z, InactiveUserActivity.this.f21422A);
            String strM80790C = C13452e.m80781L().m80790C();
            if (TextUtils.isEmpty(strM80790C) || strM80790C.trim().length() <= 1) {
                InactiveUserActivity inactiveUserActivity2 = InactiveUserActivity.this;
                inactiveUserActivity2.f21427F = inactiveUserActivity2.f21438z > 5368709120L;
                InactiveUserActivity inactiveUserActivity3 = InactiveUserActivity.this;
                inactiveUserActivity3.f21436x = inactiveUserActivity3.f21422A > InactiveUserActivity.this.f21438z;
            } else {
                InactiveUserActivity.this.f21427F = !C13452e.m80781L().m80791C0();
                InactiveUserActivity.this.f21436x = false;
            }
            C0226l0.m1584d(new Runnable() { // from class: ij.j
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException {
                    this.f50710a.m28560e();
                }
            });
        }
    }

    /* renamed from: com.huawei.cloud.pay.ui.InactiveUserActivity$b */
    public class C4667b implements C11075a.a<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ boolean f21440a;

        /* renamed from: b */
        public final /* synthetic */ boolean f21441b;

        public C4667b(boolean z10, boolean z11) {
            this.f21440a = z10;
            this.f21441b = z11;
        }

        @Override // p431ko.C11075a.a
        /* renamed from: b */
        public void mo19190b() {
            InactiveUserActivity.this.m28541H2();
        }

        @Override // p431ko.C11075a.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean mo19189a() {
            return C9159b.m57569h();
        }

        /* renamed from: f */
        public final /* synthetic */ void m28565f(boolean z10) throws IllegalAccessException, IllegalArgumentException {
            InactiveUserActivity.this.m28545k2(z10);
        }

        /* renamed from: g */
        public final /* synthetic */ void m28566g(boolean z10) throws IllegalAccessException, IllegalArgumentException {
            InactiveUserActivity.this.m28543L2();
            C11287j.m67726i(InactiveUserActivity.this, z10 ? EnumC11283f.BIND_EMAIL_FAILED_REBIND : EnumC11283f.NEED_BIND_EMAIL);
        }

        @Override // p431ko.C11075a.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Boolean bool) {
            InactiveUserActivity.this.f21424C = bool.booleanValue();
            if (this.f21440a && bool.booleanValue()) {
                C9159b.m57572k("bond_email_success");
            }
            if (InactiveUserActivity.this.f21423B) {
                final boolean z10 = this.f21440a;
                C0226l0.m1584d(new Runnable() { // from class: ij.k
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException {
                        this.f50711a.m28565f(z10);
                    }
                });
            } else if (this.f21441b || bool.booleanValue()) {
                InactiveUserActivity.this.m28547m2(this.f21441b).execute();
            } else {
                final boolean z11 = this.f21440a;
                C0226l0.m1584d(new Runnable() { // from class: ij.l
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException {
                        this.f50713a.m28566g(z11);
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.cloud.pay.ui.InactiveUserActivity$c */
    public class C4668c implements C11075a.a<ChangeUserStatusResp> {

        /* renamed from: a */
        public final /* synthetic */ boolean f21443a;

        public C4668c(boolean z10) {
            this.f21443a = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void m28569e(boolean z10) throws IllegalAccessException, IllegalArgumentException {
            if (z10) {
                InactiveUserActivity.this.m28545k2(false);
                return;
            }
            InactiveUserActivity.this.m28543L2();
            InactiveUserActivity inactiveUserActivity = InactiveUserActivity.this;
            C11287j.m67726i(inactiveUserActivity, inactiveUserActivity.f21423B ? EnumC11283f.ACTIVATION_SUCCESS : EnumC11283f.ACTIVATION_FAILED);
        }

        @Override // p431ko.C11075a.a
        /* renamed from: b */
        public void mo19190b() {
            InactiveUserActivity.this.m28541H2();
        }

        @Override // p431ko.C11075a.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ChangeUserStatusResp mo19189a() {
            return new C10582a(null).m64927b();
        }

        @Override // p431ko.C11075a.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onResult(ChangeUserStatusResp changeUserStatusResp) {
            InactiveUserActivity.this.f21423B = changeUserStatusResp.isActiveSuccess().booleanValue();
            final boolean z10 = this.f21443a;
            C0226l0.m1584d(new Runnable() { // from class: ij.m
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException {
                    this.f50715a.m28569e(z10);
                }
            });
        }
    }

    /* renamed from: D2 */
    private void m28503D2() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        if (safeIntent.hasExtra("user_activeness_info")) {
            Serializable serializableExtra = safeIntent.getSerializableExtra("user_activeness_info");
            if (serializableExtra instanceof HashMap) {
                HashMap map = (HashMap) serializableExtra;
                if (C9159b.m57563b(map)) {
                    this.f21428p = C0241z.m1688f((String) map.get("validToTime"));
                }
            }
        }
    }

    /* renamed from: G2 */
    private void m28504G2() {
        C11842p.m70874v1(this, this.f21434v);
        C11842p.m70874v1(this, this.f21435w);
        int iM70731H = C11842p.m70731H(this, (int) C11842p.m70844o(this, 36));
        int iM70731H2 = C11842p.m70731H(this, (int) C11842p.m70844o(this, 60));
        C11842p.m70763R1(this, this.f21432t, iM70731H2);
        C11842p.m70763R1(this, this.f21429q, iM70731H);
        C11842p.m70763R1(this, C12809f.m76829b(this, R$id.layout_no_service_icon), iM70731H2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J2 */
    public void m28505J2() {
        this.f21437y.setVisibility(8);
        this.f21429q.setVisibility(8);
        this.f21431s.setVisibility(8);
        this.f21430r.setVisibility(0);
    }

    /* renamed from: K2 */
    private void m28506K2() {
        this.f21431s.setVisibility(0);
        this.f21429q.setVisibility(8);
        this.f21430r.setVisibility(8);
        this.f21437y.setVisibility(8);
    }

    /* renamed from: M2 */
    public static void m28509M2(Activity activity, HashMap<String, String> map) {
        if (C9159b.m57568g()) {
            C1442a.m8291w("InactiveUserActivity", "not jump because already enter from Start flow.");
        } else {
            m28535s2(activity, map);
        }
    }

    /* renamed from: n2 */
    private void m28533n2() {
        if (!C11296s.m67786J(this)) {
            m28506K2();
        } else {
            m28542I2(R$string.cloudpay_loading);
            new C11075a(new C4666a()).execute();
        }
    }

    /* renamed from: o2 */
    private void m28534o2() {
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nodata);
        this.f21430r = viewM76829b;
        viewM76829b.setOnClickListener(new View.OnClickListener() { // from class: ij.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50702a.m28553v2(view);
            }
        });
        this.f21433u = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        this.f21431s = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f21432t = C12809f.m76829b(this, R$id.layout_nonet_icon);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f21434v = autoSizeButton;
        autoSizeButton.setOnClickListener(new View.OnClickListener() { // from class: ij.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50703a.m28554w2(view);
            }
        });
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f21435w = autoSizeButton2;
        autoSizeButton2.setOnClickListener(new View.OnClickListener() { // from class: ij.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50704a.m28555x2(view);
            }
        });
        m28504G2();
    }

    /* renamed from: s2 */
    public static boolean m28535s2(Activity activity, HashMap<String, String> map) {
        if (activity == null) {
            C1442a.m8289e("InactiveUserActivity", "not jump because context is null!");
            return false;
        }
        if (map == null || !C9159b.m57563b(map)) {
            C1442a.m8289e("InactiveUserActivity", "not jump because inactiveData is invalid!");
            return false;
        }
        C9159b.m57575n(true);
        C9159b.m57576o(false);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user_activeness_info", map);
        Intent intent = new Intent(activity, (Class<?>) InactiveUserActivity.class);
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        C10342a.m63678d(activity, intent, 10049);
        return true;
    }

    /* renamed from: A2 */
    public final /* synthetic */ void m28536A2(View view) {
        m28550r2(false, false);
        C9159b.m57572k("click_active_btn");
    }

    /* renamed from: B2 */
    public final /* synthetic */ void m28537B2(View view) {
        m28544N2();
    }

    /* renamed from: C2 */
    public final /* synthetic */ void m28538C2() throws IllegalAccessException, IllegalArgumentException {
        m28543L2();
        C11287j.m67726i(this, EnumC11283f.ACTIVATION_FAILED);
    }

    /* renamed from: E2 */
    public final void m28539E2() throws IllegalAccessException, IllegalArgumentException {
        if (this.f21427F) {
            if (this.f21423B) {
                m28545k2(false);
                return;
            } else {
                m28550r2(true, false);
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getString(R$string.tips_first));
        stringBuffer.append(System.lineSeparator());
        stringBuffer.append(getString(R$string.tips_second));
        stringBuffer.append(System.lineSeparator());
        String string = stringBuffer.toString();
        this.f21437y.removeAllViews();
        if (!this.f21436x || C13452e.m80781L().m80887a1()) {
            this.f21437y.addView(new TextBtnCard(this, StringUtil.emptyIfBlank(string) + getString(R$string.tips_less_than_5gb_new, C9159b.m57564c(this.f21428p)), getString(R$string.active_cloud_space_btn), new View.OnClickListener() { // from class: ij.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f50705a.m28536A2(view);
                }
            }));
        } else {
            this.f21437y.addView(new TextBtnCard(this, getString(R$string.tips_more_than_5gb, string, m28546l2(5368709120L), C9159b.m57564c(this.f21428p)), getString(R$string.increase_cloud_space_btn), m28548p2()));
            this.f21437y.addView(new TextBtnCard(this, getString(R$string.tips_more_than_5gb_clear_space_new, m28546l2(5368709120L)), getString(R$string.clean_cloud_space_btn), m28549q2()));
        }
        this.f21437y.addView(new TextBtnCard(this, getString(R$string.tips_delete_according_to_agreement, C9159b.m57564c(this.f21428p)), getString(R$string.view_how_to_export_data), new View.OnClickListener() { // from class: ij.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50706a.m28537B2(view);
            }
        }));
        m28543L2();
    }

    /* renamed from: F2 */
    public final void m28540F2(long j10, long j11) {
        if (this.f21426E) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("totalSpaceSize", String.valueOf(j10));
        linkedHashMap.put("useSpaceSize", String.valueOf(j11));
        C13227f.m79492i1().m79567R("enter_active_page", linkedHashMap);
        UBAAnalyze.m29947H("PVC", "enter_active_page", linkedHashMap);
        this.f21426E = true;
    }

    /* renamed from: H2 */
    public final void m28541H2() {
        C0226l0.m1584d(new Runnable() { // from class: ij.a
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException {
                this.f50701a.m28538C2();
            }
        });
    }

    /* renamed from: I2 */
    public void m28542I2(int i10) {
        this.f21429q.setVisibility(0);
        this.f21430r.setVisibility(8);
        this.f21437y.setVisibility(8);
        this.f21431s.setVisibility(8);
        this.f21433u.setText(i10);
    }

    /* renamed from: L2 */
    public final void m28543L2() {
        this.f21437y.setVisibility(0);
        this.f21429q.setVisibility(8);
        this.f21431s.setVisibility(8);
        this.f21430r.setVisibility(8);
    }

    /* renamed from: N2 */
    public final void m28544N2() {
        if (this.f21425D == null) {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C1442a.m8289e("InactiveUserActivity", "hiCloudSysParamMap is null");
                return;
            }
            this.f21425D = hiCloudSysParamMapM60757p.getViewHowToExportData();
        }
        String string = this.f21425D;
        if (TextUtils.isEmpty(string)) {
            C1442a.m8289e("InactiveUserActivity", "HowToExportDataUrl is empty");
        } else {
            String strM80942m = C13452e.m80781L().m80942m();
            if (!TextUtils.isEmpty(strM80942m)) {
                strM80942m = strM80942m.toLowerCase(Locale.US);
            }
            string = Uri.parse(string).buildUpon().appendQueryParameter(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1627e()).appendQueryParameter("countryCode", strM80942m).toString();
        }
        C1442a.m8288d("InactiveUserActivity", "viewHowToExportData url is:" + string);
        m28551t2(string);
        C9159b.m57572k("click_how_to_export_btn");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(findViewById(R$id.active_page));
        arrayList.add(findViewById(R$id.notch_center_fit_frame));
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        setResult(this.f21423B ? 1 : 0);
        super.finish();
    }

    /* renamed from: k2 */
    public final void m28545k2(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        if (this.f21424C) {
            C11287j.m67726i(this, z10 ? EnumC11283f.ACTIVATION_SUCCESSES_AFTER_BIND_EMAIL : EnumC11283f.ACTIVATION_SUCCESS);
        } else if (z10) {
            C11287j.m67726i(this, EnumC11283f.BIND_EMAIL_FAILED_TIP);
        } else {
            this.f21437y.removeAllViews();
            long j10 = this.f21438z - this.f21422A;
            int i10 = R$string.activation_succeeded_tip_bind_email;
            Object[] objArr = new Object[3];
            objArr[0] = m28546l2(this.f21438z);
            if (j10 < 0) {
                j10 = 0;
            }
            objArr[1] = m28546l2(j10);
            objArr[2] = getString(R$string.new_need_bind_email);
            this.f21437y.addView(new TextBtnCard(this, getString(i10, objArr), getString(R$string.goto_bind_email_btn), new View.OnClickListener() { // from class: ij.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f50707a.m28552u2(view);
                }
            }));
        }
        m28543L2();
    }

    /* renamed from: l2 */
    public final String m28546l2(long j10) {
        return C0223k.m1529l(C0209d.m1299r(this, j10, "CS"));
    }

    /* renamed from: m2 */
    public final C11075a m28547m2(boolean z10) {
        return new C11075a(new C4668c(z10));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C1442a.m8290i("InactiveUserActivity", "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 10050) {
            m28550r2(false, true);
        } else if (i10 == 10051 || i10 == 10052) {
            m28533n2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f21435w);
        m28504G2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        mo13327n1();
        m22365E1(R$string.active_cloud_space_title);
        setContentView(R$layout.activity_inactive_user);
        C11829c.m70609q1(this, getWindow());
        View viewFindViewById = findViewById(R$id.layout_loading);
        this.f21429q = viewFindViewById;
        viewFindViewById.setVisibility(0);
        mo19005p1();
        this.f21437y = (ViewGroup) findViewById(R$id.card_list_container);
        m28534o2();
        m28503D2();
        m28533n2();
    }

    /* renamed from: p2 */
    public final View.OnClickListener m28548p2() {
        return new View.OnClickListener() { // from class: ij.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50709a.m28556y2(view);
            }
        };
    }

    /* renamed from: q2 */
    public final View.OnClickListener m28549q2() {
        return new View.OnClickListener() { // from class: ij.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50708a.m28557z2(view);
            }
        };
    }

    /* renamed from: r2 */
    public final void m28550r2(boolean z10, boolean z11) {
        m28542I2(R$string.try_active);
        new C11075a(new C4667b(z11, z10)).execute();
    }

    /* renamed from: t2 */
    public final void m28551t2(String str) {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();
        C0209d.m1302r2(intent, getPackageName());
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        intent.putExtra("url", str);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("is_support_dark_mode", true);
        if (intent.resolveActivity(packageManager) == null) {
            C1442a.m8290i("InactiveUserActivity", "can not jump to webview, jump to browser");
            intent = new HiCloudSafeIntent(new Intent());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(packageManager) == null) {
                C1442a.m8290i("InactiveUserActivity", "can not jump to browser");
                return;
            }
        }
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C1442a.m8289e("InactiveUserActivity", "startActivity failed" + e10.getMessage());
        }
    }

    /* renamed from: u2 */
    public final /* synthetic */ void m28552u2(View view) {
        C9159b.m57562a(this);
    }

    /* renamed from: v2 */
    public final /* synthetic */ void m28553v2(View view) {
        m28533n2();
    }

    /* renamed from: w2 */
    public final /* synthetic */ void m28554w2(View view) {
        m28533n2();
    }

    /* renamed from: x2 */
    public final /* synthetic */ void m28555x2(View view) {
        C11829c.m70612r1(this);
    }

    /* renamed from: y2 */
    public final /* synthetic */ void m28556y2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CloudSpaceUpgradeActivity.class);
        C10342a.m63678d(this, intent, 10052);
        C9159b.m57572k("click_increase_space_btn");
    }

    /* renamed from: z2 */
    public final /* synthetic */ void m28557z2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HisyncSpaceDetailActivity.class);
        C10342a.m63678d(this, intent, 10051);
        C9159b.m57572k("click_clean_space_btn");
    }
}
