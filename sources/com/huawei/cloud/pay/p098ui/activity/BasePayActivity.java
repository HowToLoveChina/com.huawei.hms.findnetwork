package com.huawei.cloud.pay.p098ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.huawei.android.hicloud.commonlib.receiver.SystemKeyEventReceiver;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.secure.android.common.intent.SafeIntent;
import fj.C9719h;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import p015ak.C0209d;
import p015ak.C0219i;
import p054cj.C1442a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11842p;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p746wn.C13622a;
import p783xp.C13843a;
import sk.C12806c;
import sk.C12808e;

/* loaded from: classes5.dex */
public class BasePayActivity extends PermissionCheckActivity {

    /* renamed from: B */
    public SystemKeyEventReceiver f21446B;

    /* renamed from: h */
    public ActionBar f21447h;

    /* renamed from: i */
    public C11060c f21448i;

    /* renamed from: m */
    public UserPackage f21452m;

    /* renamed from: n */
    public ProgressDialog f21453n;

    /* renamed from: p */
    public int f21455p;

    /* renamed from: q */
    public int f21456q;

    /* renamed from: r */
    public String[] f21457r;

    /* renamed from: s */
    public String f21458s;

    /* renamed from: t */
    public String f21459t;

    /* renamed from: u */
    public String f21460u;

    /* renamed from: v */
    public String f21461v;

    /* renamed from: w */
    public float f21462w;

    /* renamed from: x */
    public String f21463x;

    /* renamed from: y */
    public String f21464y;

    /* renamed from: z */
    public String f21465z;

    /* renamed from: j */
    public String f21449j = "";

    /* renamed from: k */
    public String f21450k = "";

    /* renamed from: l */
    public String f21451l = "";

    /* renamed from: o */
    public List<View> f21454o = new ArrayList();

    /* renamed from: A */
    public C4669a f21445A = new C4669a();

    /* renamed from: com.huawei.cloud.pay.ui.activity.BasePayActivity$a */
    public class C4669a implements InterfaceC13450c {
        public C4669a() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            if (errorStatus == null) {
                C1442a.m8289e("BasePayActivity", "errorStatus is null");
                BasePayActivity.this.mo23013e1();
                return;
            }
            int errorCode = errorStatus.getErrorCode();
            String errorReason = errorStatus.getErrorReason();
            if (errorCode == 3002) {
                BasePayActivity.this.mo23010c1();
            }
            C1442a.m8290i("BasePayActivity", "onError, error code = " + errorCode + ", error reason = " + errorReason);
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            if (C11296s.m67786J(BasePayActivity.this)) {
                BasePayActivity.this.mo22827d1();
            } else {
                BasePayActivity.this.mo23014f1();
                Toast.makeText(BasePayActivity.this, R$string.cloudpay_net_disconnect_alert, 0).show();
            }
        }
    }

    /* renamed from: I1 */
    public static void m28572I1(Activity activity) {
        if (activity == null) {
            return;
        }
        if (!C13843a.m83076a0(activity)) {
            activity.setRequestedOrientation(1);
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        if (requestedOrientation == -1 || requestedOrientation == 4 || requestedOrientation == 10) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    /* renamed from: N1 */
    private void m28573N1() {
        SystemKeyEventReceiver systemKeyEventReceiver = this.f21446B;
        if (systemKeyEventReceiver != null) {
            systemKeyEventReceiver.m15909c(this);
        }
    }

    /* renamed from: x1 */
    private void m28574x1() {
        if (this.f21446B == null) {
            this.f21446B = new SystemKeyEventReceiver(getClass().getCanonicalName());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.f21446B.m15907a(this, intentFilter);
    }

    /* renamed from: A1 */
    public void m28575A1(String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06011"), "06011", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(this, c11060cM66626a, linkedHashMap);
    }

    /* renamed from: B1 */
    public void mo19444B1() {
    }

    /* renamed from: C1 */
    public void mo19445C1() {
    }

    /* renamed from: D1 */
    public void mo19446D1() {
        Intent intent = new Intent();
        intent.setAction("android.settings.WIRELESS_SETTINGS");
        intent.putExtra("use_emui_ui", true);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C1442a.m8289e("BasePayActivity", "startActivity: setNet failed");
        }
    }

    /* renamed from: E1 */
    public void mo19447E1() {
    }

    /* renamed from: F1 */
    public void mo19448F1() {
    }

    /* renamed from: G1 */
    public void mo19449G1() {
    }

    /* renamed from: H1 */
    public void mo19450H1() {
    }

    /* renamed from: J1 */
    public void m28576J1(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                C11842p.m70742K1(view);
            } else {
                C1442a.m8289e("BasePayActivity", "View is null");
            }
        }
    }

    /* renamed from: K1 */
    public void m28577K1(int i10, View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                C11842p.m70739J1(view, C11842p.m70840n(this, i10));
            } else {
                C1442a.m8289e("BasePayActivity", "View is null");
            }
        }
    }

    /* renamed from: L1 */
    public void m28578L1() {
        m28579M1(getString(R$string.cloudpay_loading));
    }

    /* renamed from: M1 */
    public void m28579M1(String str) {
        m28583a1();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f21453n = progressDialog;
        progressDialog.setMessage(str);
        this.f21453n.setCancelable(false);
        this.f21453n.show();
    }

    /* renamed from: X0 */
    public void m28580X0(Intent intent) {
        intent.putExtra("nav_source", this.f21455p);
        intent.putExtra("nav_trace_id", this.f21456q);
        intent.putExtra("nav_operation_path", this.f21458s);
        intent.putExtra("appId", this.f21459t);
        intent.putExtra("packageName", this.f21460u);
        intent.putExtra("user_tags_key", this.f21461v);
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, this.f21462w);
    }

    /* renamed from: Y0 */
    public final void m28581Y0(C4669a c4669a) {
        C13195l.m79272J().m79324o(this, C13452e.m80781L().m80905e(), 8905, c4669a);
    }

    /* renamed from: Z0 */
    public void m28582Z0() {
        m28581Y0(this.f21445A);
    }

    /* renamed from: a1 */
    public void m28583a1() {
        ProgressDialog progressDialog;
        if (isFinishing() || (progressDialog = this.f21453n) == null || !progressDialog.isShowing()) {
            return;
        }
        this.f21453n.dismiss();
        this.f21453n = null;
    }

    /* renamed from: b1 */
    public void mo22821b1() {
    }

    /* renamed from: c1 */
    public void mo23010c1() {
    }

    /* renamed from: d1 */
    public void mo22827d1() {
    }

    /* renamed from: e1 */
    public void mo23013e1() {
    }

    /* renamed from: f1 */
    public void mo23014f1() {
    }

    /* renamed from: g1 */
    public int m28584g1(int i10) {
        return (int) (((C11842p.m70876w(this).widthPixels - (C11842p.m70844o(this, 24) * 2.0f)) - ((i10 - 1) * C11842p.m70844o(this, 16))) / i10);
    }

    /* renamed from: h1 */
    public List<View> mo19475h1() {
        return null;
    }

    /* renamed from: i1 */
    public String mo23018i1() {
        return "BasePayActivity";
    }

    /* renamed from: j1 */
    public void m28585j1() {
        if (!C11842p.m70753O0(this) || C11842p.m70771U0()) {
            C0209d.m1159C2(this);
        } else {
            C0209d.m1169F0(this);
        }
    }

    /* renamed from: k1 */
    public void mo20371k1() {
        if (this.f21447h == null) {
            this.f21447h = getActionBar();
        }
        ActionBar actionBar = this.f21447h;
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /* renamed from: l1 */
    public void mo23770l1() {
        if (C11842p.m70771U0()) {
            if (C11842p.m70753O0(this)) {
                mo19447E1();
                return;
            } else {
                mo19448F1();
                return;
            }
        }
        if (C11842p.m70747M0(this)) {
            if (C11842p.m70753O0(this)) {
                mo19444B1();
                return;
            } else {
                mo19445C1();
                return;
            }
        }
        if (C11842p.m70753O0(this)) {
            mo19449G1();
        } else {
            mo19450H1();
        }
    }

    /* renamed from: m1 */
    public final void m28586m1(Intent intent) {
        String str;
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        this.f21455p = hiCloudSafeIntent.getIntExtra("nav_source", 0);
        this.f21456q = hiCloudSafeIntent.getIntExtra("nav_trace_id", -1);
        this.f21459t = hiCloudSafeIntent.getStringExtra("appId");
        this.f21460u = hiCloudSafeIntent.getStringExtra("packageName");
        this.f21461v = hiCloudSafeIntent.getStringExtra("user_tags_key");
        this.f21462w = hiCloudSafeIntent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f);
        this.f21463x = hiCloudSafeIntent.getStringExtra("startupSource");
        this.f21464y = hiCloudSafeIntent.getStringExtra("startupSourceId");
        this.f21465z = hiCloudSafeIntent.getStringExtra("cfgId");
        String stringExtra = hiCloudSafeIntent.getStringExtra("nav_operation_path");
        if (TextUtils.isEmpty(stringExtra)) {
            str = "";
        } else {
            str = stringExtra + "-";
        }
        this.f21458s = str + mo23018i1();
        if (this.f21456q == -1) {
            this.f21456q = new Random().nextInt(10000);
        }
    }

    /* renamed from: n1 */
    public void m28587n1() {
        List<View> listMo19475h1 = mo19475h1();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo19475h1);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo19475h1);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m28594w1(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: o1 */
    public void m28588o1(String str) {
        C11060c c11060c = new C11060c();
        this.f21448i = c11060c;
        c11060c.m66636B(str);
        this.f21448i.m66643I(C11058a.m66627b(str));
        this.f21448i.m66637C("com.huawei.hidisk\u0001_cloudspace");
        this.f21448i.m66670z("2.0");
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8905) {
            C13195l.m79272J().m79297M(this, this.f21445A, i11, intent);
        } else if (i10 == 8801) {
            C13195l.m79272J().m79301Q(this, i10, i11, intent);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70723E0(this);
        C12806c.m76820k(this, this.f21454o);
        m28585j1();
        mo23770l1();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11842p.m70723E0(this);
        mo20371k1();
        m28572I1(this);
        getWindow().setFlags(16777216, 16777216);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C11829c.m70591k1(this);
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
        }
        C9719h.m60646d().m60648a(this);
        m28595y1(new HiCloudSafeIntent(getIntent()));
        C12808e.m76822a(this);
        m28585j1();
        m28586m1(getIntent());
        MessageCenterManager.getInstance().processNotifyClickEvent(getIntent());
        C1442a.m8288d("BasePayActivity", "currentActivity:" + mo23018i1() + ",mNavSource:" + this.f21455p + ",mNavTraceId:" + this.f21456q);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f21453n;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f21453n = null;
        }
        C9719h.m60646d().m60651f(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        C11829c.m70579g1(getClass().getCanonicalName());
        return mo19553r1(i10, keyEvent);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m28592t1();
        m28595y1(new HiCloudSafeIntent(intent));
        MessageCenterManager.getInstance().processNotifyClickEvent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79579Y(this, this.f21449j, this.f21450k);
        UBAAnalyze.m29965Z("PVC", getClass().getCanonicalName(), "1", "31", this.f21449j, this.f21450k, super.mo18593F0());
        m28573N1();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79583c0(this, this.f21449j, this.f21450k);
        UBAAnalyze.m29969b0("PVC", getClass().getCanonicalName(), "1", "31", this.f21449j, this.f21450k);
        m28574x1();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C11829c.m70575f0();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C11829c.m70506C1();
    }

    /* renamed from: p1 */
    public boolean m28589p1() {
        UserPackage userPackage = this.f21452m;
        return userPackage != null && 1 == userPackage.getIsAutoPay();
    }

    /* renamed from: q1 */
    public boolean m28590q1() {
        UserPackage userPackage = this.f21452m;
        if (userPackage == null) {
            return false;
        }
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(userPackage);
        CloudSpace toBeEffectivePackage = this.f21452m.getToBeEffectivePackage();
        return cloudSpaceM67757a != null && cloudSpaceM67757a.getCapacity() > toBeEffectivePackage.getCapacity() && toBeEffectivePackage.getCapacity() > 0;
    }

    /* renamed from: r1 */
    public boolean mo19553r1(int i10, KeyEvent keyEvent) {
        return super.onKeyDown(i10, keyEvent);
    }

    /* renamed from: s1 */
    public void m28591s1() {
        try {
            this.f21451l = new HiCloudSafeIntent(getIntent()).getStringExtra(NotifyConstants.CloudStorageConstants.AD_NAME_KEY);
            C1442a.m8290i("BasePayActivity", "adId=" + this.f21451l);
        } catch (Exception unused) {
            C1442a.m8290i("BasePayActivity", "parseAdId intent exception");
        }
    }

    /* renamed from: t1 */
    public boolean m28592t1() {
        String strM79465g = C13222a.m79465g(this);
        if ("0".equals(strM79465g)) {
            this.f21449j = "2";
            this.f21450k = "";
            return true;
        }
        if ("5".equals(strM79465g)) {
            m28591s1();
            this.f21449j = "3";
            this.f21450k = this.f21451l;
            return true;
        }
        String strM79501D = C13230i.m79501D(this);
        String strM79502E = C13230i.m79502E(this);
        if (TextUtils.isEmpty(strM79501D)) {
            return false;
        }
        this.f21449j = strM79501D;
        this.f21450k = strM79502E;
        C1442a.m8290i("BasePayActivity", "parseAnalyticsTypeValue type:" + this.f21449j + " value" + this.f21450k);
        return true;
    }

    /* renamed from: u1 */
    public void m28593u1(LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("nav_source", String.valueOf(this.f21455p));
        linkedHashMap.put("trace_id", String.valueOf(this.f21456q));
        linkedHashMap.put("opr_path", this.f21458s);
        linkedHashMap.put("appId", this.f21459t);
        linkedHashMap.put("packageName", this.f21460u);
        linkedHashMap.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(this.f21462w));
        if (!TextUtils.isEmpty(this.f21463x)) {
            linkedHashMap.put("startupSource", this.f21463x);
        }
        if (!TextUtils.isEmpty(this.f21464y)) {
            linkedHashMap.put("startupSourceId", this.f21464y);
        }
        if (TextUtils.isEmpty(this.f21465z)) {
            return;
        }
        linkedHashMap.put("cfgId", this.f21465z);
    }

    /* renamed from: v1 */
    public void mo22881v1() {
    }

    /* renamed from: w1 */
    public void m28594w1(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f21454o.addAll(list);
    }

    /* renamed from: y1 */
    public final void m28595y1(SafeIntent safeIntent) {
        if (safeIntent == null) {
            return;
        }
        String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        float floatExtra = safeIntent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f);
        if (stringExtra.equals("1")) {
            C13227f.m79492i1().m79585f0("mecloud_notify_pullnew_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_notify_pullnew_click", "4", "3");
        }
        if (stringExtra.equals("2")) {
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            String stringExtra2 = safeIntent.getStringExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE);
            String stringExtra3 = safeIntent.getStringExtra("scene_id");
            linkedHashMapM79499C.put(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, stringExtra2);
            linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(floatExtra));
            linkedHashMapM79499C.put("scene_id", stringExtra3);
            C13227f.m79492i1().m79591l0("mecloud_notify_cloudspace_click", linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_click", "4", "5", linkedHashMapM79499C);
        }
        if (stringExtra.equals("3")) {
            LinkedHashMap linkedHashMapM79499C2 = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C2.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(floatExtra));
            C13227f.m79492i1().m79591l0("mecloud_notify_cloudspace_not_enough_click", linkedHashMapM79499C2);
            UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_not_enough_click", "4", "8", linkedHashMapM79499C2);
        }
        if (stringExtra.equals("9")) {
            LinkedHashMap linkedHashMapM79499C3 = C13230i.m79499C(C13452e.m80781L().m80971t0());
            String stringExtra4 = safeIntent.getStringExtra("app_package_name");
            linkedHashMapM79499C3.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(floatExtra));
            linkedHashMapM79499C3.put("app_package_name", stringExtra4);
            if (safeIntent.getBooleanExtra("is_v5_scene", false)) {
                linkedHashMapM79499C3.put("v5_dialog_version_key", InterfaceC5323b.f24693t);
            }
            C13227f.m79492i1().m79591l0("accept_gift_notify_click", linkedHashMapM79499C3);
            UBAAnalyze.m29958S("PVC", "accept_gift_notify_click", "4", "17", linkedHashMapM79499C3);
        }
    }

    /* renamed from: z1 */
    public void m28596z1(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            m28593u1(linkedHashMap);
            C13227f.m79492i1().m79567R(str, linkedHashMap);
            UBAAnalyze.m29958S("PVC", str, "1", "32", linkedHashMap);
            m28575A1(str, linkedHashMap);
        } catch (Exception e10) {
            C1442a.m8289e("BasePayActivity", "reportEvent error occur:" + e10.getMessage());
        }
    }
}
