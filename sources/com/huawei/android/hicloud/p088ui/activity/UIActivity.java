package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.commonlib.receiver.SystemKeyEventReceiver;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.manager.IconManager;
import com.huawei.android.hicloud.p088ui.ScrollToTopListener;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$color;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import hu.C10343b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0239x;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;
import td.C13008a;

/* loaded from: classes3.dex */
public class UIActivity extends PermissionCheckActivity implements ScrollToTopListener {

    /* renamed from: k */
    public ScrollView f16168k;

    /* renamed from: l */
    public ListView f16169l;

    /* renamed from: m */
    public RecyclerView f16170m;

    /* renamed from: o */
    public SystemKeyEventReceiver f16172o;

    /* renamed from: h */
    public String f16165h = "";

    /* renamed from: i */
    public String f16166i = "";

    /* renamed from: j */
    public String f16167j = "";

    /* renamed from: n */
    public List<View> f16171n = new ArrayList();

    /* renamed from: B1 */
    private void m22361B1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: s1 */
    public static boolean m22363s1(Context context) {
        if (context == null) {
            C11839m.m70687e("UIActivity", "context is null");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.hidisk.action.EXTERNAL_FILE_VIEWER");
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    /* renamed from: A1 */
    public final void m22364A1(Intent intent) {
        if (intent == null) {
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        String stringExtra = hiCloudSafeIntent.getStringExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (stringExtra != null && stringExtra.equals("1")) {
            mo18601b1().m79585f0("mecloud_notify_pullnew_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_notify_pullnew_click", "4", "3");
        }
        if (stringExtra != null && stringExtra.equals("2")) {
            LinkedHashMap linkedHashMapM22372a1 = m22372a1(hiCloudSafeIntent);
            String stringExtra2 = intent.getStringExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE);
            String stringExtra3 = intent.getStringExtra("scene_id");
            float floatExtra = intent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f);
            linkedHashMapM22372a1.put(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, stringExtra2);
            linkedHashMapM22372a1.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(floatExtra));
            linkedHashMapM22372a1.put("scene_id", stringExtra3);
            mo18601b1().m79591l0("mecloud_notify_cloudspace_click", linkedHashMapM22372a1);
            UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_click", "4", "7", linkedHashMapM22372a1);
        }
        if (stringExtra != null && stringExtra.equals("3")) {
            LinkedHashMap linkedHashMapM22372a12 = m22372a1(hiCloudSafeIntent);
            linkedHashMapM22372a12.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(intent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f)));
            mo18601b1().m79591l0("mecloud_notify_cloudspace_not_enough_click", linkedHashMapM22372a12);
            UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_not_enough_click", "4", "8", linkedHashMapM22372a12);
        }
        if (stringExtra == null || !stringExtra.equals("6")) {
            return;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("forced_upgrade_type", Integer.valueOf(C10028c.m62182c0().m62278U()));
        mo18601b1().m79591l0("upgrade_notice_click", linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", "upgrade_notice_click", "4", "12", "forced_upgrade_type", String.valueOf(C10028c.m62182c0().m62278U()));
    }

    /* renamed from: C1 */
    public void mo19982C1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            int color = getColor(R$color.hicloud_hmos_bg);
            C11842p.m70842n1(actionBar, new ColorDrawable(color));
            actionBar.setBackgroundDrawable(new ColorDrawable(color));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: D1 */
    public void mo20612D1() throws Resources.NotFoundException {
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.hicloud_hmos_bg);
            Window window = getWindow();
            if (window != null) {
                window.getDecorView().setBackgroundColor(color);
            }
        }
    }

    /* renamed from: E1 */
    public void m22365E1(int i10) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(i10));
        }
    }

    /* renamed from: F1 */
    public void mo22366F1() throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
    }

    /* renamed from: G1 */
    public void m22367G1(int i10) {
        setRequestedOrientation(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.ScrollToTopListener
    /* renamed from: H */
    public void mo18481H() {
        ScrollView scrollView = this.f16168k;
        if (scrollView != null) {
            scrollView.fullScroll(33);
            return;
        }
        ListView listView = this.f16169l;
        if (listView != null) {
            listView.smoothScrollToPosition(0);
            return;
        }
        RecyclerView recyclerView = this.f16170m;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    /* renamed from: H1 */
    public void m22368H1() {
        Window window = getWindow();
        int color = getColor(R$color.hicloud_hmos_bg);
        if (window != null) {
            window.setStatusBarColor(color);
        }
    }

    /* renamed from: I1 */
    public void m22369I1() {
        Window window = getWindow();
        int color = getColor(R$color.transparent);
        if (window != null) {
            window.setStatusBarColor(color);
        }
    }

    /* renamed from: J1 */
    public void mo21192J1() {
    }

    /* renamed from: K1 */
    public final void m22370K1() {
        SystemKeyEventReceiver systemKeyEventReceiver = this.f16172o;
        if (systemKeyEventReceiver != null) {
            systemKeyEventReceiver.m15909c(this);
        }
    }

    /* renamed from: Y0 */
    public boolean mo21832Y0() {
        return true;
    }

    /* renamed from: Z0 */
    public void m22371Z0() {
        if (mo19304e1() != -1) {
            this.f16170m = (RecyclerView) C12809f.m76829b(this, mo19304e1());
        }
    }

    /* renamed from: a1 */
    public final LinkedHashMap m22372a1(Intent intent) {
        Bundle bundleExtra;
        if (intent == null) {
            C11839m.m70689w("UIActivity", "intent is null!");
            return null;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, false);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (booleanExtra && (bundleExtra = hiCloudSafeIntent.getBundleExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO)) != null) {
            linkedHashMapM79499C.put("notify_id", Integer.valueOf(bundleExtra.getInt("notify_id")));
            linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(bundleExtra.getInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE)));
            linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID, bundleExtra.getString(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID));
        }
        return linkedHashMapM79499C;
    }

    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13227f.m79492i1();
    }

    /* renamed from: c1 */
    public int mo20343c1() {
        return -1;
    }

    /* renamed from: d1 */
    public List<View> mo13289d1() {
        return null;
    }

    /* renamed from: e1 */
    public int mo19304e1() {
        return -1;
    }

    /* renamed from: f1 */
    public int mo18507f1() {
        return -1;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
            C11839m.m70687e("UIActivity", "finish activity exception , activity :" + getClass().getName());
        }
    }

    /* renamed from: g1 */
    public boolean m22373g1() {
        if (getPackageManager() != null) {
            return !C0209d.m1269j1() ? m22376j1() : m22374h1();
        }
        C11839m.m70689w("UIActivity", "gotoFileManagerPick getPackageManager is null");
        return false;
    }

    /* renamed from: h1 */
    public final boolean m22374h1() {
        Intent intent = new Intent("com.hihonor.honorcloud.intent.action.PICK");
        C0209d.m1302r2(intent, "com.hihonor.filemanager");
        if (new HiCloudSafeIntent(intent).resolveActivity(getPackageManager()) == null) {
            return m22376j1();
        }
        C11839m.m70688i("UIActivity", "gotoHonorFileManagerPick , resolveActivity is not null");
        try {
            startActivityForResult(intent, 10043);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("UIActivity", "gotoHonorFileManagerPick startActivity error:" + e10.toString());
            return false;
        }
    }

    /* renamed from: i1 */
    public void m22375i1(Context context, int i10) {
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17164A(context, i10, null);
        }
    }

    /* renamed from: j1 */
    public final boolean m22376j1() {
        Intent intent = new Intent("com.huawei.hidisk.intent.action.PICK");
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        if (new HiCloudSafeIntent(intent).resolveActivity(getPackageManager()) == null) {
            C11839m.m70687e("UIActivity", "gotoHwFileManagerPick resolveActivity is null");
            return false;
        }
        C11839m.m70688i("UIActivity", "gotoHwFileManagerPick , resolveActivity is not null");
        try {
            startActivityForResult(intent, 10043);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("UIActivity", "gotoHwFileManagerPick startActivity error:" + e10.toString());
            return false;
        }
    }

    /* renamed from: k1 */
    public void m22377k1(final Context context) {
        if (context == null) {
            C11839m.m70687e("UIActivity", "context is null");
            return;
        }
        if (getPackageManager() == null) {
            C11839m.m70687e("UIActivity", "gotoHwCloudDrive package manager is null");
            return;
        }
        IconManager iconManager = new IconManager(context);
        if (iconManager.m16463w(iconManager.m16456p())) {
            m22383u1(context);
            return;
        }
        mo18601b1().m79567R("mecloud_filemanager_icon_is_not_exist", new LinkedHashMap<>());
        UBAAnalyze.m29943D("CKC", "mecloud_filemanager_icon_is_not_exist");
        if (iconManager.m16434A("filemanagerLastTime")) {
            iconManager.m16450R(new IconManager.CallBack() { // from class: com.huawei.android.hicloud.ui.activity.t8
                @Override // com.huawei.android.hicloud.manager.IconManager.CallBack
                /* renamed from: a */
                public final void mo16466a() {
                    this.f17744a.m22383u1(context);
                }
            });
        } else {
            m22383u1(context);
        }
    }

    /* renamed from: l1 */
    public void m22378l1() {
        Bundle extras;
        try {
            if (getIntent() == null || (extras = getIntent().getExtras()) == null) {
                return;
            }
            boolean zM63681c = new C10343b(extras).m63681c("is_activity_need_back_to_main");
            boolean z10 = extras.getBoolean("is_from_webview_filemanager");
            if (!zM63681c || z10) {
                return;
            }
            C11019b.m66371t().m66457z0(this);
            new HwAnimationReflection(this).m15927c(2);
        } catch (Exception unused) {
            C11839m.m70687e("UIActivity", "intent get extra error");
        }
    }

    /* renamed from: m1 */
    public void mo22379m1() {
        if (!C11842p.m70753O0(this) || C11842p.m70771U0()) {
            C0209d.m1159C2(this);
        } else {
            C0209d.m1169F0(this);
        }
    }

    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
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

    /* renamed from: o1 */
    public void m22380o1() {
        if (mo20343c1() != -1) {
            this.f16169l = (ListView) C12809f.m76829b(this, mo20343c1());
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8801) {
            C13195l.m79272J().m79301Q(this, i10, i11, intent);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70723E0(this);
        C12806c.m76820k(this, this.f16171n);
        if (mo21832Y0()) {
            mo22379m1();
        }
        mo22366F1();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C11842p.m70723E0(this);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        getWindow().setFlags(16777216, 16777216);
        m22364A1(getIntent());
        m22361B1();
        mo22366F1();
        C12808e.m76822a(this);
        mo21453q1();
        mo22379m1();
        C0239x.m1671c().m1676f(getClass().getSimpleName());
        MessageCenterManager.getInstance().processNotifyClickEvent(getIntent());
        mo20612D1();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11836j.m70658k().m70670m(this);
        mo21192J1();
        C13008a.m78300b().m78305f(this);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        C11829c.m70579g1(getClass().getCanonicalName());
        return mo13429v1(i10, keyEvent);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        mo22385x1();
        m22364A1(intent);
        MessageCenterManager.getInstance().processNotifyClickEvent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        mo18601b1().m79579Y(this, this.f16165h, this.f16166i);
        UBAAnalyze.m29965Z("PVC", getClass().getCanonicalName(), "1", "100", this.f16165h, this.f16166i, super.mo18593F0());
        m22370K1();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11842p.m70723E0(this);
        if (C11019b.m66371t().m66402V(this)) {
            C11836j.m70658k().m70677t(this);
        }
        mo18601b1().m79583c0(this, this.f16165h, this.f16166i);
        UBAAnalyze.m29969b0("PVC", getClass().getCanonicalName(), "1", "100", this.f16165h, this.f16166i);
        mo18601b1().m79581a0(0);
        C13008a.m78300b().m78304e(this);
        C11019b.m66371t().m66421h(this);
        m22386y1();
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
    public void mo19005p1() {
        List<View> listMo13289d1 = mo13289d1();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo13289d1);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo13289d1);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m22387z1(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: q1 */
    public void mo21453q1() {
    }

    /* renamed from: r1 */
    public void m22381r1() {
        if (mo18507f1() != -1) {
            this.f16168k = (ScrollView) C12809f.m76829b(this, mo18507f1());
        }
    }

    /* renamed from: t1 */
    public final void m22383u1(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_RECENTLY_DELETED");
            C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            hiCloudSafeIntent.putExtra("fromToScene", 1);
            hiCloudSafeIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(hiCloudSafeIntent);
        } catch (Exception e10) {
            C11839m.m70687e("UIActivity", "goto filemanager recentlyDeletedActivity error:" + e10.toString());
        }
    }

    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        return super.onKeyDown(i10, keyEvent);
    }

    /* renamed from: w1 */
    public void mo22384w1() {
        try {
            Intent intent = getIntent();
            if (intent != null) {
                this.f16167j = intent.getStringExtra(NotifyConstants.CloudStorageConstants.AD_NAME_KEY);
                C11839m.m70688i("UIActivity", "adId is " + this.f16167j);
            }
        } catch (Exception unused) {
            C11839m.m70688i("UIActivity", "parseAdId intent exception");
        }
    }

    /* renamed from: x1 */
    public boolean mo22385x1() {
        String strM79465g = C13222a.m79465g(this);
        if (strM79465g != null && strM79465g.equals("5")) {
            mo22384w1();
            this.f16165h = "3";
            this.f16166i = this.f16167j;
            return true;
        }
        if (strM79465g != null && strM79465g.equals("0")) {
            this.f16165h = "2";
            this.f16166i = "";
            return true;
        }
        String strM79502E = C13230i.m79502E(this);
        String strM79501D = C13230i.m79501D(this);
        if (TextUtils.isEmpty(strM79501D)) {
            this.f16165h = "1";
            this.f16166i = "100";
            return false;
        }
        this.f16165h = strM79501D;
        this.f16166i = strM79502E;
        C11839m.m70688i("UIActivity", "parseAnalyticsTypeValue type:" + this.f16165h + " value" + this.f16166i);
        return true;
    }

    /* renamed from: y1 */
    public final void m22386y1() {
        if (this.f16172o == null) {
            this.f16172o = new SystemKeyEventReceiver(getClass().getCanonicalName());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.f16172o.m15907a(this, intentFilter);
    }

    /* renamed from: z1 */
    public void m22387z1(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f16171n.addAll(list);
    }
}
