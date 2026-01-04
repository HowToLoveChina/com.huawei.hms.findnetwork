package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.request.agreement.request.ConsentRecord;
import com.huawei.hicloud.request.agreement.request.ConsentRecordWithStatus;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideRsp;
import com.huawei.hicloud.sync.R$color;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p336he.C10161l;
import p446l7.C11256d;
import p446l7.C11258f;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p709vj.C13452e;
import p783xp.C13843a;
import p846zj.C14306d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PushMarketingNoticeActivity extends UIActivity {

    /* renamed from: A */
    public CheckBox f15829A;

    /* renamed from: B */
    public CheckBox f15830B;

    /* renamed from: D */
    public char[] f15832D;

    /* renamed from: G */
    public QueryPushGuideRsp f15835G;

    /* renamed from: p */
    public NotchTopFitLinearLayout f15839p;

    /* renamed from: q */
    public ScrollView f15840q;

    /* renamed from: r */
    public RelativeLayout f15841r;

    /* renamed from: s */
    public LinearLayout f15842s;

    /* renamed from: t */
    public View f15843t;

    /* renamed from: u */
    public View f15844u;

    /* renamed from: v */
    public NotchFitLinearLayout f15845v;

    /* renamed from: w */
    public ProgressBar f15846w;

    /* renamed from: x */
    public UnionSwitch f15847x;

    /* renamed from: y */
    public CheckBox f15848y;

    /* renamed from: z */
    public CheckBox f15849z;

    /* renamed from: C */
    public String f15831C = "";

    /* renamed from: E */
    public boolean f15833E = false;

    /* renamed from: F */
    public boolean f15834F = false;

    /* renamed from: H */
    public boolean f15836H = false;

    /* renamed from: I */
    public boolean f15837I = false;

    /* renamed from: J */
    public Handler f15838J = new HandlerC3447a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$a */
    public class HandlerC3447a extends Handler {
        public HandlerC3447a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 31003:
                    C11839m.m70688i("PushMarketingNoticeActivity", "query push guide success");
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof QueryPushGuideRsp)) {
                        PushMarketingNoticeActivity.this.f15835G = (QueryPushGuideRsp) obj;
                        PushMarketingNoticeActivity.this.m22002f2();
                        PushMarketingNoticeActivity.this.m22004h2();
                        break;
                    }
                    break;
                case 31004:
                    C11839m.m70688i("PushMarketingNoticeActivity", "query push guide failed");
                    PushMarketingNoticeActivity.this.m22002f2();
                    PushMarketingNoticeActivity.this.m22004h2();
                    break;
                case 31005:
                    PushMarketingNoticeActivity.this.m21995T1(message);
                    break;
                default:
                    C11839m.m70688i("PushMarketingNoticeActivity", "mHandler default break");
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$b */
    public class C3448b implements CompoundButton.OnCheckedChangeListener {
        public C3448b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                PushMarketingNoticeActivity.this.m21996X1();
            } else {
                PushMarketingNoticeActivity.this.m21994S1();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$c */
    public class C3449c implements CompoundButton.OnCheckedChangeListener {
        public C3449c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            PushMarketingNoticeActivity.this.m22000d2(0, z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$d */
    public class C3450d implements CompoundButton.OnCheckedChangeListener {
        public C3450d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            PushMarketingNoticeActivity.this.m22000d2(1, z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$e */
    public class C3451e implements CompoundButton.OnCheckedChangeListener {
        public C3451e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            PushMarketingNoticeActivity.this.m22000d2(2, z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$f */
    public class C3452f implements CompoundButton.OnCheckedChangeListener {
        public C3452f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            PushMarketingNoticeActivity.this.m22000d2(3, z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PushMarketingNoticeActivity$g */
    public static class C3453g extends AbstractC12367d {

        /* renamed from: a */
        public Handler f15856a;

        public C3453g(Handler handler) {
            this.f15856a = handler;
        }

        /* renamed from: c */
        private int m22005c() {
            String strM80910f = C13452e.m80781L().m80910f();
            if (strM80910f != null && (strM80910f.equals(String.valueOf(1)) || strM80910f.equals(String.valueOf(2)))) {
                return 1;
            }
            C11839m.m70688i("PushMarketingNoticeActivity", "childAccountModeFromLogin can not get result");
            return C14306d.m85215p();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                int iM22005c = m22005c();
                Message messageObtain = Message.obtain(this.f15856a);
                messageObtain.what = 31005;
                messageObtain.obj = Integer.valueOf(iM22005c);
                this.f15856a.sendMessage(messageObtain);
            } catch (Exception e10) {
                C11839m.m70687e("PushMarketingNoticeActivity", "CheckIsChildAccountTask err :" + e10.toString());
                Message messageObtain2 = Message.obtain(this.f15856a);
                messageObtain2.what = 31005;
                messageObtain2.obj = -1;
                this.f15856a.sendMessage(messageObtain2);
            }
        }
    }

    /* renamed from: U1 */
    private void m21989U1() {
        this.f15847x.setOnCheckedChangeListener(new C3448b());
        this.f15848y.setOnCheckedChangeListener(new C3449c());
        this.f15849z.setOnCheckedChangeListener(new C3450d());
        this.f15829A.setOnCheckedChangeListener(new C3451e());
        this.f15830B.setOnCheckedChangeListener(new C3452f());
    }

    /* renamed from: V1 */
    private void m21990V1(String str) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.hicloud_hmos_bg);
            C0209d.m1306s2(getActionBar(), this, color);
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: W1 */
    private void m21991W1() {
        this.f15840q = (ScrollView) C12809f.m76829b(this, R$id.push_guide_scroll_view);
        this.f15841r = (RelativeLayout) C12809f.m76829b(this, R$id.push_guide_null_scroll_view);
        this.f15842s = (LinearLayout) C12809f.m76829b(this, R$id.child_account_not_support_layout);
        this.f15843t = C12809f.m76829b(this, R$id.notch_fit_load_view);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_loading);
        this.f15844u = viewM76829b;
        if (viewM76829b != null) {
            viewM76829b.setVisibility(0);
        }
        this.f15839p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.notch_push_notch_main_layout);
        this.f15845v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.card_notch_fit);
        this.f15846w = (ProgressBar) C12809f.m76829b(this, R$id.push_notice_loading_progress);
        this.f15847x = (UnionSwitch) C12809f.m76829b(this, R$id.push_notice_switch);
        this.f15848y = (CheckBox) C12809f.m76829b(this, R$id.push_notice_item_switch_1);
        this.f15849z = (CheckBox) C12809f.m76829b(this, R$id.push_notice_item_switch_2);
        this.f15829A = (CheckBox) C12809f.m76829b(this, R$id.push_notice_item_switch_3);
        this.f15830B = (CheckBox) C12809f.m76829b(this, R$id.push_notice_item_switch_4);
    }

    /* renamed from: Y1 */
    private void m21992Y1() {
        C11839m.m70688i("PushMarketingNoticeActivity", "queryPushGuideStatus");
        this.f15840q.setVisibility(0);
        this.f15841r.setVisibility(8);
        m21998a2();
        if (!C0209d.m1333z1(this)) {
            C11839m.m70688i("PushMarketingNoticeActivity", "no network");
            return;
        }
        C12515a.m75110o().m75172d(new C11256d(new WeakReference(this.f15838J)));
        m22001e2();
    }

    /* renamed from: b2 */
    private void m21993b2() {
        C11842p.m70760Q1(this, C12809f.m76831d(this.f15843t, R$id.layout_loading));
        C11842p.m70760Q1(this, this.f15842s);
    }

    /* renamed from: S1 */
    public final void m21994S1() {
        char[] cArr = this.f15832D;
        if (cArr == null) {
            C11839m.m70687e("PushMarketingNoticeActivity", "clearSubConsentStatus mSubConsentStatus is null");
            return;
        }
        int length = cArr.length;
        for (int i10 = 0; i10 < length && i10 < 4; i10++) {
            this.f15832D[i10] = '0';
        }
        this.f15848y.setChecked(false);
        this.f15849z.setChecked(false);
        this.f15829A.setChecked(false);
        this.f15830B.setChecked(false);
    }

    /* renamed from: T1 */
    public final void m21995T1(Message message) {
        try {
            if (((Integer) message.obj).intValue() == 1) {
                this.f15837I = true;
                this.f15842s.setVisibility(0);
                this.f15843t.setVisibility(8);
            } else {
                m21992Y1();
            }
        } catch (Exception e10) {
            C11839m.m70687e("PushMarketingNoticeActivity", "CHECK_CHILD_ACCOUNT_RESULT err :" + e10.toString());
            m21992Y1();
        }
    }

    /* renamed from: X1 */
    public final void m21996X1() {
        char[] cArr = this.f15832D;
        if (cArr == null) {
            C11839m.m70687e("PushMarketingNoticeActivity", "openAllSubConsentStatus mSubConsentStatus is null");
            return;
        }
        int length = cArr.length;
        for (int i10 = 0; i10 < length && i10 < 4; i10++) {
            this.f15832D[i10] = '1';
        }
        this.f15848y.setChecked(true);
        this.f15849z.setChecked(true);
        this.f15829A.setChecked(true);
        this.f15830B.setChecked(true);
    }

    /* renamed from: Z1 */
    public final void m21997Z1() {
        C11839m.m70688i("PushMarketingNoticeActivity", "saveSubConsent");
        char[] cArr = this.f15832D;
        if (cArr == null) {
            C11839m.m70688i("PushMarketingNoticeActivity", "setSwitchStatus mSubConsentStatus is null");
            return;
        }
        String strValueOf = String.valueOf(cArr);
        this.f15831C = strValueOf;
        if (this.f15834F && TextUtils.equals(strValueOf, "0000222222222222")) {
            C11839m.m70688i("PushMarketingNoticeActivity", "need sign ,but data no change");
            return;
        }
        C10028c.m62182c0().m62296Y1(this.f15831C);
        boolean zContains = this.f15831C.contains("1");
        C11839m.m70688i("PushMarketingNoticeActivity", "main switch is " + zContains);
        C12515a.m75110o().m75172d(new C11258f(zContains, this.f15831C, ""));
    }

    /* renamed from: a2 */
    public final void m21998a2() {
        String strM62234K0 = C10028c.m62182c0().m62234K0();
        C11839m.m70686d("PushMarketingNoticeActivity", "last  pushGuideSubConsent" + strM62234K0);
        if (TextUtils.isEmpty(strM62234K0)) {
            strM62234K0 = "0000222222222222";
        }
        this.f15831C = strM62234K0;
        m22003g2();
    }

    /* renamed from: c2 */
    public final void m21999c2() {
        int length = this.f15832D.length;
        for (int i10 = 0; i10 < length && i10 < 4; i10++) {
            char c10 = this.f15832D[i10];
            if (c10 == '1') {
                if (i10 == 0) {
                    this.f15848y.setChecked(true);
                } else if (i10 == 1) {
                    this.f15849z.setChecked(true);
                } else if (i10 == 2) {
                    this.f15829A.setChecked(true);
                } else if (i10 == 3) {
                    this.f15830B.setChecked(true);
                }
            } else if (c10 == '0') {
                if (i10 == 0) {
                    this.f15848y.setChecked(false);
                } else if (i10 == 1) {
                    this.f15849z.setChecked(false);
                } else if (i10 == 2) {
                    this.f15829A.setChecked(false);
                } else if (i10 == 3) {
                    this.f15830B.setChecked(false);
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15839p);
        arrayList.add(this.f15845v);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m22000d2(int i10, boolean z10) {
        char[] cArr = this.f15832D;
        if (cArr == null) {
            C11839m.m70687e("PushMarketingNoticeActivity", "setSubSwitch mSubConsentStatus is null");
            return;
        }
        cArr[i10] = z10 ? '1' : '0';
        HicloudPushGuideManager.getInstance();
        boolean zCheckSubConsentStatus = HicloudPushGuideManager.checkSubConsentStatus(this.f15832D);
        this.f15833E = zCheckSubConsentStatus;
        if (zCheckSubConsentStatus) {
            this.f15847x.setCheckedProgrammatically(true);
        } else {
            this.f15847x.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: e2 */
    public final void m22001e2() {
        this.f15847x.setEnabled(false);
        this.f15848y.setEnabled(false);
        this.f15849z.setEnabled(false);
        this.f15829A.setEnabled(false);
        this.f15830B.setEnabled(false);
    }

    /* renamed from: f2 */
    public final void m22002f2() {
        this.f15847x.setEnabled(true);
        this.f15848y.setEnabled(true);
        this.f15849z.setEnabled(true);
        this.f15829A.setEnabled(true);
        this.f15830B.setEnabled(true);
    }

    /* renamed from: g2 */
    public final void m22003g2() {
        String str = this.f15831C;
        if (str == null) {
            C11839m.m70688i("PushMarketingNoticeActivity", "setSwitchStatus mSubConsent is null");
            return;
        }
        this.f15832D = str.toCharArray();
        HicloudPushGuideManager.getInstance();
        this.f15833E = HicloudPushGuideManager.checkSubConsentStatus(this.f15832D);
        m21999c2();
        if (this.f15833E) {
            this.f15847x.setCheckedProgrammatically(true);
        } else {
            this.f15847x.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: h2 */
    public final void m22004h2() {
        ConsentRecordWithStatus consentRecordWithStatus;
        QueryPushGuideRsp queryPushGuideRsp = this.f15835G;
        if (queryPushGuideRsp == null) {
            C11839m.m70688i("PushMarketingNoticeActivity", "rsp is null");
            m21998a2();
            return;
        }
        List<ConsentRecordWithStatus> recordWithStatusArrayList = queryPushGuideRsp.getRecordWithStatusArrayList();
        if (recordWithStatusArrayList == null || (consentRecordWithStatus = recordWithStatusArrayList.get(0)) == null) {
            C11839m.m70688i("PushMarketingNoticeActivity", "no data");
            this.f15831C = "0000222222222222";
            m21998a2();
            return;
        }
        ConsentRecord latestSignRecord = consentRecordWithStatus.getLatestSignRecord();
        if (latestSignRecord != null) {
            this.f15831C = latestSignRecord.getSubConsent();
            if (C10028c.m62182c0().m62238L0()) {
                C11839m.m70688i("PushMarketingNoticeActivity", "last time sign failed,wait sign again");
                String strM62234K0 = C10028c.m62182c0().m62234K0();
                this.f15831C = TextUtils.isEmpty(strM62234K0) ? "0000222222222222" : strM62234K0;
            } else {
                C10028c.m62182c0().m62296Y1(latestSignRecord.getSubConsent());
            }
            C11839m.m70686d("PushMarketingNoticeActivity", "latestSignRecord,mSubConsent:" + this.f15831C);
        } else {
            this.f15831C = "0000222222222222";
        }
        this.f15834F = consentRecordWithStatus.isNeedSign();
        C11839m.m70686d("PushMarketingNoticeActivity", "subConsent：" + this.f15831C);
        m22003g2();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f15836H = true;
        super.onBackPressed();
        if (this.f15837I) {
            return;
        }
        m21997Z1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m21993b2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        C10161l.m63342b().m63345d(this);
        m21990V1(getString(R$string.push_marketing_notice_title));
        setContentView(R$layout.activity_push_marketing_notice);
        m21991W1();
        mo19005p1();
        m21989U1();
        m21993b2();
        C12515a.m75110o().m75172d(new C3453g(this.f15838J));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f15837I || this.f15836H) {
            return;
        }
        m21997Z1();
    }
}
