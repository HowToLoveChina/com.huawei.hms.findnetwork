package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.ProgressLoadingButtonView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.NewMergeAlertDialog;
import com.huawei.android.hicloud.task.simple.C3079r1;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1008c;
import p335hd.C10140c;
import p422k9.C11019b;
import p446l7.C11257e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p709vj.C13452e;
import sk.C12809f;
import tm.C13040c;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class UniformGuideFrontActivity extends UniformGuideActivity {

    /* renamed from: K1 */
    public LinearLayout f16285K1;

    /* renamed from: L1 */
    public HwButton f16286L1;

    /* renamed from: M1 */
    public HwButton f16287M1;

    /* renamed from: N1 */
    public TextView f16288N1;

    /* renamed from: O1 */
    public TextView f16289O1;

    /* renamed from: P1 */
    public TextView f16290P1;

    /* renamed from: Q1 */
    public TextView f16291Q1;

    /* renamed from: R1 */
    public ProgressLoadingButtonView f16292R1;

    /* renamed from: S1 */
    public boolean f16293S1;

    /* renamed from: T1 */
    public boolean f16294T1;

    /* renamed from: J1 */
    public Bundle f16284J1 = new Bundle();

    /* renamed from: U1 */
    public C3079r1 f16295U1 = null;

    /* renamed from: V1 */
    public Handler f16296V1 = new HandlerC3522a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideFrontActivity$a */
    public class HandlerC3522a extends Handler {
        public HandlerC3522a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            C11839m.m70688i("UniformGuideFrontActivity", "mQueryHandler start");
            if (UniformGuideFrontActivity.this.m22514P4(message)) {
                return;
            }
            UniformGuideFrontActivity.this.m22515Q4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideFrontActivity$b */
    public class HandlerC3523b extends Handler {
        public HandlerC3523b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (UniformGuideFrontActivity.this.isFinishing() || UniformGuideFrontActivity.this.isDestroyed()) {
                C11839m.m70687e("UniformGuideFrontActivity", "grshandler,the activity is not avaiable");
                return;
            }
            int i10 = message.what;
            if (8 == i10) {
                C11839m.m70688i("UniformGuideFrontActivity", "check grs urls success");
                C1008c.m6035v().m6051P(C0213f.m1377a(), UniformGuideFrontActivity.this.new HandlerC3524c(), false);
            } else if (9 == i10) {
                UniformGuideFrontActivity.this.m22515Q4();
                C11839m.m70688i("UniformGuideFrontActivity", "check grs urls fail");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideFrontActivity$c */
    public class HandlerC3524c extends Handler {
        public HandlerC3524c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            UniformGuideFrontActivity.this.m22517S4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity
    /* renamed from: A4 */
    public void mo22466A4(C10028c c10028c) {
        C11839m.m70688i("UniformGuideFrontActivity", "newDefaultSwitchCheck: is UniformGuideFrontActivity, not check");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: C2 */
    public void mo16699C2() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: D2 */
    public void mo16700D2() {
        C13040c.m78609F().m78654j0(C0213f.m1377a(), C13452e.m80781L().m80942m(), true);
        m22520V4();
        C12515a.m75110o().m75175e(new C10140c(new HandlerC3523b(), false), false);
        m17008v3();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: E1 */
    public void mo16704E1() {
        Intent intent = new Intent();
        if (this.f12595X != null && this.f16284J1 != null) {
            C11839m.m70688i("UniformGuideFrontActivity", "phoneFinderSwitchView.isChecked: " + this.f12595X.isChecked());
            this.f16284J1.putBoolean("phoneFinder", this.f12595X.isChecked());
        }
        intent.putExtra("tempKeyBundle", this.f16284J1);
        for (Map.Entry<String, Boolean> entry : this.f12598Y0.entrySet()) {
            this.f16284J1.putBoolean(entry.getKey(), entry.getValue().booleanValue());
        }
        this.f16284J1.putBoolean("cloudbackup", this.f12585S.isChecked());
        this.f16284J1.putBoolean("is_agree_to_basic_user", m16987n2());
        setResult(-1, intent);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: F2 */
    public void mo16929F2(View view) throws Throwable {
        super.mo16929F2(view);
        if (view.getId() != R$id.guide_agree_button) {
            if (view.getId() == R$id.guide_cancel_button) {
                onBackPressed();
                if (this.f16293S1) {
                    UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.UNIFORM_CLICK_CANCLE);
                    return;
                }
                return;
            }
            return;
        }
        C11839m.m70688i("UniformGuideFrontActivity", "frontPhoneFinderStatus: " + this.f12616h1);
        if (C0209d.m1269j1()) {
            C11839m.m70688i("UniformGuideFrontActivity", "onCreateCheckPermission");
            m16935H2();
        } else {
            m17003u1();
        }
        AdSwitchManager.getInstance().saveAdSwitch();
        if (this.f16293S1) {
            UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.UNIFORM_CLICK_AGREE);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        this.f16285K1 = (LinearLayout) C12809f.m76829b(this, R$id.button_layout);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.guide_agree_button);
        this.f16286L1 = hwButton;
        hwButton.setOnClickListener(this);
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.guide_cancel_button);
        this.f16287M1 = hwButton2;
        hwButton2.setOnClickListener(this);
        this.f16292R1 = (ProgressLoadingButtonView) C12809f.m76829b(this, R$id.guide_continue_progress_btn);
        if (C0209d.m1285n1() && C0209d.m1202Q0()) {
            TextView textView = (TextView) C12809f.m76829b(this, R$id.open_contact_sub_title);
            this.f16288N1 = textView;
            textView.setText(R$string.uniform_backup_subtitle_new_new);
            TextView textView2 = (TextView) C12809f.m76829b(this, R$id.open_sync_sub_title);
            this.f16289O1 = textView2;
            textView2.setText(R$string.uniform_sync_subtitle_new_new);
            TextView textView3 = (TextView) C12809f.m76829b(this, R$id.open_sync_title);
            this.f16290P1 = textView3;
            textView3.setText(R$string.cloud_applications);
            TextView textView4 = (TextView) C12809f.m76829b(this, R$id.cloud_sync_titel);
            this.f16291Q1 = textView4;
            textView4.setText(R$string.uniform_sync_items_title_new_new);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity
    /* renamed from: H4 */
    public void mo22473H4(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.f12598Y0.containsKey(next)) {
                Boolean bool = this.f12598Y0.get(next);
                this.f16284J1.putBoolean(next, bool == null ? false : bool.booleanValue());
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: M */
    public void mo16564M() {
        View viewM76829b;
        super.mo16564M();
        if (!C0209d.m1269j1() || (viewM76829b = C12809f.m76829b(this, R$id.welcome_icon_privacy)) == null) {
            return;
        }
        C11839m.m70688i("UniformGuideFrontActivity", "perivacy icon view is not null");
        viewM76829b.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: N1 */
    public void mo16946N1() {
        ProgressLoadingButtonView progressLoadingButtonView = this.f16292R1;
        if (progressLoadingButtonView != null) {
            progressLoadingButtonView.setVisibility(8);
        }
        HwButton hwButton = this.f16286L1;
        if (hwButton != null) {
            hwButton.setVisibility(0);
        }
    }

    /* renamed from: P4 */
    public final boolean m22514P4(Message message) {
        if (isFinishing() || isDestroyed()) {
            C11839m.m70687e("UniformGuideFrontActivity", "queryhandler,the activity is not avaiable");
            return true;
        }
        C11839m.m70688i("UniformGuideFrontActivity", "Receive msg=" + message.what);
        return false;
    }

    /* renamed from: Q4 */
    public final void m22515Q4() throws Throwable {
        super.mo16700D2();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: R2 */
    public void mo16952R2(boolean z10) throws Throwable {
        C11839m.m70688i("UniformGuideFrontActivity", "phoneFinderSwitchView isOpen: " + z10);
        this.f16284J1.putBoolean("phoneFinder", z10);
        m16947O1();
        mo16941K2();
    }

    /* renamed from: R4 */
    public final void m22516R4() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f16293S1 = hiCloudSafeIntent.getBooleanExtra("is_from_stock_active", false);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("is_from_stock_active_notify", false);
        this.f16294T1 = booleanExtra;
        if (this.f16293S1 && booleanExtra) {
            UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.CLICK_NOTIFY);
            UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.SHOW_ACTIVITY);
        }
    }

    /* renamed from: S4 */
    public final void m22517S4() {
        this.f16295U1 = new C3079r1(this, this.f16296V1, true, 1);
        C12515a.m75110o().m75175e(this.f16295U1, false);
    }

    /* renamed from: T4 */
    public final void m22518T4() {
        C10028c.m62182c0().m62288W1();
    }

    /* renamed from: U4 */
    public void m22519U4() {
        Iterator<String> it = this.f16270t1.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f16284J1.putBoolean(next, false);
            this.f12598Y0.put(next, Boolean.FALSE);
        }
    }

    /* renamed from: V4 */
    public final void m22520V4() {
        C10028c.m62183d0(this).m62377p3("is_hicloud_terms_confirm", true);
        C12515a.m75110o().m75172d(new C11257e(C0213f.m1377a(), true, true, true, true));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: X1 */
    public void mo16725X1() {
        boolean z10 = false;
        if (!C0209d.m1166E1() || C0209d.m1293p1()) {
            this.f12618i1 = false;
        }
        if (!C0209d.m1166E1()) {
            this.f12628n1 = false;
        }
        if (this.f12622k1 && C11019b.m66371t().m66391K(this)) {
            z10 = true;
        }
        this.f12622k1 = z10;
        this.f12585S.setCheckedProgrammatically(this.f12614g1);
        this.f12599Z.setChecked(this.f12620j1);
        this.f12605c0.setChecked(this.f12626m1);
        this.f12603b0.setChecked(this.f12624l1);
        this.f12607d0.setChecked(this.f12628n1);
        this.f12601a0.setChecked(this.f12618i1);
        this.f12609e0.setChecked(this.f12622k1);
        m16960Y2("addressbook", this.f12620j1);
        m16960Y2("calendar", this.f12624l1);
        m16960Y2(HNConstants.DataType.MEDIA, this.f12618i1);
        m16960Y2("notepad", this.f12626m1);
        m16960Y2("wlan", this.f12628n1);
        m16960Y2("browser", this.f12622k1);
        m22495q4();
        if (this.f12604b1 || C0209d.m1269j1()) {
            return;
        }
        m16935H2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: d2 */
    public void mo16970d2() {
        if (C11829c.m70536O0() && m22498u4()) {
            C11839m.m70688i("UniformGuideFrontActivity", "initPhoneFinderSwitch supportPhoneFinder");
            if (C0209d.m1166E1()) {
                this.f12595X.setCheckedProgrammatically(this.f12616h1);
                return;
            } else {
                m17014y1();
                return;
            }
        }
        C11839m.m70688i("UniformGuideFrontActivity", "initPhoneFinderSwitch not support");
        this.f12589U.setVisibility(8);
        m16944M1();
        this.f12595X.setCheckedProgrammatically(false);
        this.f12616h1 = false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: g3 */
    public void mo16729g3() {
        this.f16284J1.putBoolean("cloudbackup", this.f12585S.isChecked());
        this.f16284J1.putBoolean("is_agree_to_basic_user", m16987n2());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity
    /* renamed from: n4 */
    public void mo22492n4(Message message) {
        C11839m.m70688i("UniformGuideFrontActivity", "handleLocalDataCheckMsg");
        m16947O1();
        int i10 = message.arg1;
        int i11 = message.what;
        if (i11 != 1046) {
            if (i11 == 1047) {
                mo22473H4(this.f16269s1);
                CommonReportUtil.reportLocalDataCheckResult("0", null);
                m22468C4();
                return;
            }
            return;
        }
        if (this.f16259A1 == null) {
            this.f16259A1 = new NewMergeAlertDialog(this, this, i10);
        }
        this.f16270t1 = (ArrayList) message.obj;
        C11839m.m70688i("UniformGuideFrontActivity", "MSG_SYNC_LOCAL_DATA_EXIST, module size = " + this.f16270t1.size());
        this.f16259A1.show(this.f16270t1, "");
        m22486h4();
        mo22473H4(this.f16269s1);
        CommonReportUtil.reportLocalDataCheckResult("1", this.f16269s1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onCanceled(String str, int i10) {
        if ("all_module".equals(str)) {
            m22519U4();
            C2783d.m16114V0(str, "1", "2", i10);
        }
        m22468C4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        UnionSwitch unionSwitch;
        super.onConfigurationChanged(configuration);
        if (m22493o4()) {
            setContentView(mo16578c());
            mo16559G();
            mo16564M();
            m16557E();
            mo16566O();
            this.f12637t0 = 0;
            mo16554C();
            mo16618x0();
            if (this.f12602a1) {
                mo16730h2();
            } else {
                mo16728g2();
            }
            AlertDialog alertDialog = this.f12635r0;
            if (alertDialog == null || !alertDialog.isShowing() || (unionSwitch = this.f12597Y) == null) {
                return;
            }
            unionSwitch.setCheckedProgrammatically(false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, int i10) {
        if ("all_module".equals(str)) {
            mo22473H4(this.f16270t1);
        }
        m22468C4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m22518T4();
        super.onCreate(bundle);
        C11839m.m70688i("UniformGuideFrontActivity", "onCreate");
        m16557E();
        m22516R4();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: t3 */
    public void mo17002t3() {
        LinearLayout linearLayout = this.f16285K1;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            if (m22493o4() && C11842p.m70753O0(this)) {
                return;
            }
            C11842p.m70733H1(this.f16285K1, C11842p.m70864t(this));
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: u3 */
    public void mo17005u3() {
        HwButton hwButton;
        ProgressLoadingButtonView progressLoadingButtonView = this.f16292R1;
        if (progressLoadingButtonView != null && (hwButton = this.f16286L1) != null) {
            progressLoadingButtonView.setLayoutHeight(hwButton.getHeight());
            this.f16292R1.setVisibility(0);
        }
        HwButton hwButton2 = this.f16286L1;
        if (hwButton2 != null) {
            hwButton2.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity
    /* renamed from: z4 */
    public void mo22501z4(C10028c c10028c) {
        C11839m.m70688i("UniformGuideFrontActivity", "newDefaultDriveSwitchCheck: is UniformGuideFrontActivity, not check");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity, com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10) {
        C11839m.m70688i("UniformGuideFrontActivity", "onConfirmed");
        if ("all_module".equals(str)) {
            Iterator<String> it = this.f16270t1.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!arrayList.contains(next)) {
                    this.f16284J1.putBoolean(next, false);
                    this.f12598Y0.put(next, Boolean.FALSE);
                }
            }
            mo22473H4(arrayList);
        }
        m22468C4();
    }
}
