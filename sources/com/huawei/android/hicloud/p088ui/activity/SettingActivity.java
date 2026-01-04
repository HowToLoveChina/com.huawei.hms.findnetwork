package com.huawei.android.hicloud.p088ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.hihonor.android.os.Build;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.DeviceRecordsActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.task.simple.C3016b2;
import com.huawei.android.os.BuildEx;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.feedback.FeedbackMailProcessor;
import com.huawei.feedback.FeedbackSdkProcessor;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordsRsp;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceOperation;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceRecordsRsp;
import com.huawei.secure.android.common.intent.SafeIntent;
import ge.C9913h;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p335hd.C10145h;
import p422k9.C11018a;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13223b;
import p684un.C13227f;
import p709vj.C13452e;
import p783xp.C13843a;
import p846zj.C14306d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SettingActivity extends UIActivity implements View.OnClickListener, HiCloudItemCheckedChangeListener {

    /* renamed from: A */
    public HiCloudItemView f15966A;

    /* renamed from: B */
    public HiCloudItemView f15967B;

    /* renamed from: C */
    public HiCloudItemView f15968C;

    /* renamed from: D */
    public HiCloudExceptionView f15969D;

    /* renamed from: F */
    public C3468b f15971F;

    /* renamed from: G */
    public C13108a f15972G;

    /* renamed from: u */
    public NotchTopFitLinearLayout f15980u;

    /* renamed from: v */
    public HiCloudItemView f15981v;

    /* renamed from: w */
    public View f15982w;

    /* renamed from: x */
    public HiCloudItemView f15983x;

    /* renamed from: y */
    public HiCloudItemView f15984y;

    /* renamed from: z */
    public HiCloudItemView f15985z;

    /* renamed from: p */
    public DeviceRecordsActivity.C3269c f15975p = new DeviceRecordsActivity.C3269c();

    /* renamed from: q */
    public DeviceRecordsActivity.C3268b f15976q = new DeviceRecordsActivity.C3268b();

    /* renamed from: r */
    public int f15977r = 0;

    /* renamed from: s */
    public boolean f15978s = true;

    /* renamed from: t */
    public boolean f15979t = true;

    /* renamed from: E */
    public LocalReceiver f15970E = null;

    /* renamed from: H */
    public List<HiCloudItemView> f15973H = new ArrayList();

    /* renamed from: I */
    public Handler f15974I = new HandlerC3467a();

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            String stringExtra = safeIntent.getStringExtra("accessoryName");
            C11839m.m70686d("SettingActivity", "onReceive: " + action);
            if ("com.huawei.android.hicloud.sendmessage".equals(action)) {
                SettingActivity.this.f15966A.m23975f();
                SettingActivity.this.f15966A.setEnabled(true);
                FeedbackMailProcessor.getInstance().jumpToMailView(context, stringExtra, C10028c.m62182c0().m62237L());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SettingActivity$a */
    public class HandlerC3467a extends Handler {
        public HandlerC3467a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                if (SettingActivity.this.f15979t) {
                    C11839m.m70688i("SettingActivity", " basic server returns data successfully");
                    SettingActivity.this.m22150a2(message);
                } else {
                    C11839m.m70688i("SettingActivity", " cbs server returns data successfully");
                    SettingActivity.this.m22154b2(message);
                }
                SettingActivity.this.m22156d2();
                if (!C2783d.m16127b0(SettingActivity.this)) {
                    SettingActivity.this.f15978s = false;
                    return;
                }
                Intent intent = new Intent(SettingActivity.this, (Class<?>) DeviceRecordsActivity.class);
                intent.putExtra("isFromBasic", SettingActivity.this.f15979t);
                SettingActivity.this.startActivity(intent);
                return;
            }
            if (-1 == i10) {
                C11839m.m70688i("SettingActivity", "QueryDeviceRecordsTask failed");
                SettingActivity.this.m22156d2();
                if (message.arg1 == 404) {
                    SettingActivity.this.f15979t = false;
                    C11839m.m70688i("SettingActivity", "start accessing the cbs server ");
                    SettingActivity.this.m22155c2();
                    return;
                }
                return;
            }
            C11839m.m70688i("SettingActivity", "handleMessage, set push notify status msg type is： " + message.what);
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            int i11 = message.what;
            if (1 == i11) {
                c10028cM62182c0.m62336h2("push_receive_status", true);
                SettingActivity.this.f15981v.setCheckedProgrammatically(true);
                C13223b.m79484l(SettingActivity.this, 1, 1);
                C13227f.m79492i1().m79587h0("mecloud_setting_click_notifycation", "1", "1", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29971c0("PVC", "mecloud_setting_click_notifycation", "4", "4", "1", "1");
            } else if (2 == i11) {
                c10028cM62182c0.m62336h2("push_receive_status", false);
                SettingActivity.this.f15981v.setCheckedProgrammatically(false);
                C13223b.m79484l(SettingActivity.this, 0, 1);
                C13227f.m79492i1().m79587h0("mecloud_setting_click_notifycation", "2", "2", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29971c0("PVC", "mecloud_setting_click_notifycation", "4", "4", "2", "2");
            } else if (3 == i11) {
                SettingActivity.this.f15981v.setCheckedProgrammatically(!SettingActivity.this.f15981v.m23986s());
                if (SettingActivity.this.f15981v.m23986s()) {
                    SettingActivity settingActivity = SettingActivity.this;
                    Toast.makeText(settingActivity, settingActivity.getString(R$string.close_push_swith_failed), 0).show();
                    C13227f.m79492i1().m79587h0("mecloud_setting_click_notifycation", "2", "1", C13452e.m80781L().m80971t0());
                    UBAAnalyze.m29971c0("PVC", "mecloud_setting_click_notifycation", "4", "4", "2", "1");
                } else {
                    SettingActivity settingActivity2 = SettingActivity.this;
                    Toast.makeText(settingActivity2, settingActivity2.getString(R$string.open_push_switch_failed), 0).show();
                    C13227f.m79492i1().m79587h0("mecloud_setting_click_notifycation", "1", "2", C13452e.m80781L().m80971t0());
                    UBAAnalyze.m29971c0("PVC", "mecloud_setting_click_notifycation", "4", "4", "1", "2");
                }
            }
            SettingActivity.this.f15981v.m23975f();
            SettingActivity.this.f15981v.m23968H();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SettingActivity$b */
    public class C3468b extends BroadcastReceiver {
        public C3468b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C11839m.m70686d("SettingActivity", "onReceive: " + action);
            if (!"checkFinish".equals(action)) {
                C11839m.m70687e("SettingActivity", "action error");
            } else if (safeIntent.getBooleanExtra("visibility", false)) {
                SettingActivity.this.f15967B.m23963C();
            } else {
                SettingActivity.this.f15967B.m23975f();
            }
        }

        public /* synthetic */ C3468b(SettingActivity settingActivity, HandlerC3467a handlerC3467a) {
            this();
        }
    }

    /* renamed from: V1 */
    private void m22146V1() {
        this.f15973H.add(this.f15981v);
        this.f15973H.add(this.f15983x);
        this.f15973H.add(this.f15984y);
        this.f15973H.add(this.f15985z);
        this.f15973H.add(this.f15966A);
        this.f15973H.add(this.f15967B);
        this.f15973H.add(this.f15968C);
    }

    /* renamed from: W1 */
    private void m22147W1(List<CBSSyncRecordOperation> list) {
        if (list != null) {
            Iterator<CBSSyncRecordOperation> it = list.iterator();
            while (it.hasNext()) {
                if (m22149Y1(it.next())) {
                    it.remove();
                }
            }
            Collections.sort(list, this.f15975p);
            C11836j.m70658k().m70673p(list);
        }
    }

    /* renamed from: X1 */
    private void m22148X1() {
        this.f15980u = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.setting_layout);
        this.f15969D = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.mydevice_content);
        this.f15983x = hiCloudItemView;
        hiCloudItemView.setOnClickListener(this);
        if (!"CN".equals(C13452e.m80781L().m80942m()) && !C14306d.m85208i()) {
            HiCloudItemView hiCloudItemView2 = (HiCloudItemView) C12809f.m76829b(this, R$id.notice_content);
            this.f15984y = hiCloudItemView2;
            hiCloudItemView2.setVisibility(0);
            this.f15984y.setOnClickListener(this);
        }
        if (!C14306d.m85208i()) {
            HiCloudItemView hiCloudItemView3 = (HiCloudItemView) C12809f.m76829b(this, R$id.term_content);
            this.f15985z = hiCloudItemView3;
            hiCloudItemView3.setVisibility(0);
            this.f15985z.setOnClickListener(this);
        }
        HiCloudItemView hiCloudItemView4 = (HiCloudItemView) C12809f.m76829b(this, R$id.check_update_content);
        this.f15967B = hiCloudItemView4;
        hiCloudItemView4.setOnClickListener(this);
        HiCloudItemView hiCloudItemView5 = (HiCloudItemView) C12809f.m76829b(this, R$id.feedback_content);
        this.f15966A = hiCloudItemView5;
        hiCloudItemView5.setOnClickListener(this);
        this.f15966A.setVisibility(0);
        this.f15966A.setOnClickListener(this);
        HiCloudItemView hiCloudItemView6 = (HiCloudItemView) C12809f.m76829b(this, R$id.about_content);
        this.f15968C = hiCloudItemView6;
        hiCloudItemView6.setOnClickListener(this);
        this.f15968C.m23973d();
        this.f15981v = (HiCloudItemView) C12809f.m76829b(this, R$id.push_notify_item);
        this.f15982w = C12809f.m76829b(this, R$id.about_push_division);
        if (C0209d.m1277l1()) {
            C11839m.m70686d("SettingActivity", "MAGIC SDK is: " + Build.VERSION.MAGIC_SDK_INT);
        } else {
            C11839m.m70686d("SettingActivity", "EMUI SDK is: " + BuildEx.VERSION.EMUI_SDK_INT);
        }
        if ((C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12) && C13452e.m80781L().m80803F0().booleanValue()) {
            this.f15981v.setVisibility(0);
            this.f15982w.setVisibility(0);
            this.f15981v.setItemOnCheckedChangeListener(this);
            this.f15981v.setCheckedProgrammatically(C10028c.m62182c0().m62388s("push_receive_status"));
        } else {
            this.f15982w.setVisibility(8);
        }
        m22381r1();
    }

    /* renamed from: Y1 */
    private boolean m22149Y1(CBSSyncRecordOperation cBSSyncRecordOperation) {
        return TextUtils.isEmpty(cBSSyncRecordOperation.getOpDesc()) || (TextUtils.isEmpty(cBSSyncRecordOperation.getAliasName()) && TextUtils.isEmpty(cBSSyncRecordOperation.getDevDisplayName())) || TextUtils.isEmpty(cBSSyncRecordOperation.getDeviceID()) || TextUtils.isEmpty(cBSSyncRecordOperation.getLastUpdateTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2 */
    public void m22150a2(Message message) {
        CBSSyncRecordsRsp cBSSyncRecordsRsp = (CBSSyncRecordsRsp) message.obj;
        if (cBSSyncRecordsRsp != null) {
            List<CBSSyncRecordOperation> opRecordList = cBSSyncRecordsRsp.getOpRecordList();
            if (opRecordList == null || opRecordList.size() <= 0) {
                C11839m.m70688i("SettingActivity", "no records");
                return;
            }
            C11839m.m70688i("SettingActivity", "queryBasicDeviceRecordSuccess size=" + opRecordList.size());
            m22147W1(opRecordList);
        }
    }

    /* renamed from: e2 */
    private void m22151e2() {
        this.f15970E = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.sendmessage");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        this.f15972G = c13108aM78878b;
        c13108aM78878b.m78880c(this.f15970E, intentFilter);
        if (this.f15971F == null) {
            this.f15971F = new C3468b(this, null);
        }
        this.f15972G.m78880c(this.f15971F, new IntentFilter("checkFinish"));
    }

    /* renamed from: f2 */
    private void m22152f2() {
        LocalReceiver localReceiver = this.f15970E;
        if (localReceiver != null) {
            try {
                this.f15972G.m78883f(localReceiver);
                this.f15970E = null;
            } catch (Exception unused) {
                C11839m.m70687e("SettingActivity", "mLocalReceiver unregister error");
            }
        }
        C3468b c3468b = this.f15971F;
        if (c3468b != null) {
            try {
                this.f15972G.m78883f(c3468b);
                this.f15971F = null;
            } catch (Exception unused2) {
                C11839m.m70687e("SettingActivity", "checkUpdateReceiver unregister error");
            }
        }
    }

    /* renamed from: Z1 */
    public final void m22153Z1() {
        C13227f.m79492i1().m79585f0("mecloud_setting_click_suggestion", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_setting_click_suggestion", "1", "4");
        FeedbackSdkProcessor.getInstance(this, new C11018a()).jumpToSdkView(this, 2, true);
    }

    /* renamed from: b2 */
    public final void m22154b2(Message message) {
        CBSDeviceRecordsRsp cBSDeviceRecordsRsp = (CBSDeviceRecordsRsp) message.obj;
        if (cBSDeviceRecordsRsp != null) {
            List<CBSDeviceOperation> deviceOperations = cBSDeviceRecordsRsp.getDeviceOperations();
            if (deviceOperations == null || deviceOperations.size() <= 0) {
                C11839m.m70688i("SettingActivity", "no records");
                return;
            }
            C11839m.m70688i("SettingActivity", "query records size=" + deviceOperations.size());
            Collections.sort(deviceOperations, this.f15976q);
            C11836j.m70658k().m70674q(deviceOperations);
        }
    }

    /* renamed from: c2 */
    public final void m22155c2() {
        C13227f.m79492i1().m79585f0("mecloud_setting_click_mydevice", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_setting_click_mydevice", "1", "4");
        if (!C0209d.m1333z1(this)) {
            this.f15969D.m23919i();
            return;
        }
        this.f15969D.m23914a();
        if (this.f15977r != 1) {
            this.f15977r = 1;
            this.f15983x.m23963C();
            C12515a.m75110o().m75172d(new C3016b2(this.f15974I, this.f15979t));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener
    /* renamed from: d0 */
    public void mo21351d0(HiCloudItemView hiCloudItemView, boolean z10) {
        C11839m.m70686d("SettingActivity", "onCheckedChanged");
        this.f15981v.m23978i();
        this.f15981v.m23963C();
        C12515a.m75110o().m75172d(new C10145h(getApplicationContext(), z10, this.f15974I));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15980u);
        arrayList.add(this.f15969D);
        arrayList.add(this.f15981v);
        arrayList.add(this.f15983x);
        arrayList.add(this.f15984y);
        arrayList.add(this.f15985z);
        arrayList.add(this.f15966A);
        arrayList.add(this.f15967B);
        arrayList.add(this.f15968C);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m22156d2() {
        this.f15977r = 0;
        this.f15983x.m23975f();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: f1 */
    public int mo18507f1() {
        return R$id.setting_scroll_view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (R$id.mydevice_content == view.getId()) {
            m22155c2();
            return;
        }
        if (R$id.notice_content == view.getId()) {
            Intent intent = new Intent(this, (Class<?>) AgreementLogActivity.class);
            intent.putExtra("term_type_key", (short) 10013);
            startActivity(intent);
            C13227f.m79492i1().m79585f0("mecloud_setting_click_notice", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_notice", "4", "4");
            return;
        }
        if (R$id.term_content == view.getId()) {
            Intent intent2 = new Intent(this, (Class<?>) AgreementLogActivity.class);
            intent2.putExtra("term_type_key", (short) 125);
            startActivity(intent2);
            C13227f.m79492i1().m79585f0("mecloud_setting_click_agreement", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_agreement", "1", "4");
            return;
        }
        if (R$id.feedback_content == view.getId()) {
            m22153Z1();
            return;
        }
        if (R$id.check_update_content == view.getId()) {
            C9913h.m61574q().m61600x(this);
            C9913h.m61574q().m61589P(false);
        } else if (R$id.about_content == view.getId()) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_about", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_about", "1", "4");
            startActivity(new Intent(this, (Class<?>) AboutActivity.class));
        } else if (R$id.push_notify_item == view.getId()) {
            this.f15981v.setChecked(!r7.m23986s());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C2783d.m16181t0(this.f15973H);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.settings);
        m22365E1(R$string.setting_general_title);
        m22148X1();
        mo19005p1();
        m22146V1();
        m22151e2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        super.onDestroy();
        C11836j.m70658k().m70663e();
        m22152f2();
        C9913h.m61574q().m61577D();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.f15978s) {
            return;
        }
        startActivity(new Intent(this, (Class<?>) DeviceRecordsActivity.class));
        this.f15978s = true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f15969D != null) {
            if (C0209d.m1333z1(this)) {
                this.f15969D.m23914a();
            } else {
                this.f15969D.m23919i();
            }
        }
    }
}
