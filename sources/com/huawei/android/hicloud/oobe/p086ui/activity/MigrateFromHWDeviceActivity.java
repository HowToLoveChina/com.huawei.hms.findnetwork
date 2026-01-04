package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import ck.C1443a;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.dialog.OOBEBackupRecoveryWlanDialog;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.identity.AddressConstants;
import gp.C10028c;
import hu.C10343b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p681uj.C13192i;
import p684un.C13227f;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MigrateFromHWDeviceActivity extends OOBEAuthCallbackActivity implements View.OnClickListener {

    /* renamed from: e */
    public DisableSupportedRelativeLayout f12317e;

    /* renamed from: f */
    public DisableSupportedRelativeLayout f12318f;

    /* renamed from: g */
    public DisableSupportedRelativeLayout f12319g;

    /* renamed from: h */
    public View f12320h;

    /* renamed from: i */
    public View f12321i;

    /* renamed from: j */
    public int f12322j;

    /* renamed from: k */
    public C2813b f12323k = null;

    /* renamed from: l */
    public Context f12324l = this;

    /* renamed from: m */
    public OOBEBackupRecoveryWlanDialog f12325m;

    /* renamed from: n */
    public LinearLayout f12326n;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity$a */
    public class ViewOnSystemUiVisibilityChangeListenerC2812a implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC2812a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70636z1(MigrateFromHWDeviceActivity.this.getWindow());
            C11829c.m70633y1(MigrateFromHWDeviceActivity.this.getApplicationContext(), MigrateFromHWDeviceActivity.this.getWindow());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity$b */
    public class C2813b extends BroadcastReceiver {

        /* renamed from: a */
        public WeakReference<MigrateFromHWDeviceActivity> f12328a;

        public C2813b(MigrateFromHWDeviceActivity migrateFromHWDeviceActivity) {
            this.f12328a = new WeakReference<>(migrateFromHWDeviceActivity);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r8, android.content.Intent r9) {
            /*
                r7 = this;
                java.lang.String r8 = ""
                java.lang.String r0 = "receive the RecoveryResultReceiver"
                java.lang.String r1 = "MigrateFromHWDeviceActivity"
                p514o9.C11839m.m70688i(r1, r0)
                java.lang.ref.WeakReference<com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity> r0 = r7.f12328a
                java.lang.Object r0 = r0.get()
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r0 = (com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity) r0
                if (r0 != 0) goto L14
                return
            L14:
                if (r9 == 0) goto Lb5
                r2 = -1
                java.lang.String r3 = "entrance_level"
                java.lang.String r3 = r9.getStringExtra(r3)     // Catch: java.lang.RuntimeException -> L2f
                java.lang.String r4 = "resultId"
                int r4 = r9.getIntExtra(r4, r2)     // Catch: java.lang.RuntimeException -> L2c
                java.lang.String r5 = "resultSrc"
                java.lang.String r8 = r9.getStringExtra(r5)     // Catch: java.lang.RuntimeException -> L2a
                goto L4a
            L2a:
                r9 = move-exception
                goto L32
            L2c:
                r9 = move-exception
            L2d:
                r4 = r2
                goto L32
            L2f:
                r9 = move-exception
                r3 = r8
                goto L2d
            L32:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "RecoveryResultReceiver onReceive:"
                r5.append(r6)
                java.lang.String r9 = r9.toString()
                r5.append(r9)
                java.lang.String r9 = r5.toString()
                p514o9.C11839m.m70687e(r1, r9)
            L4a:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r5 = "receive the RecoveryResultReceiver result = "
                r9.append(r5)
                r9.append(r4)
                java.lang.String r5 = "  resultSrc = "
                r9.append(r5)
                r9.append(r8)
                java.lang.String r5 = " from = "
                r9.append(r5)
                r9.append(r3)
                java.lang.String r9 = r9.toString()
                p514o9.C11839m.m70688i(r1, r9)
                if (r4 != 0) goto Lb5
                java.lang.String r9 = "clone"
                boolean r8 = r9.equals(r8)
                if (r8 == 0) goto L81
                java.lang.String r8 = "from_hw"
                boolean r8 = r8.equals(r3)
                if (r8 != 0) goto L81
                return
            L81:
                java.lang.String r8 = "from_hw deal"
                p514o9.C11839m.m70688i(r1, r8)
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r8 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.this
                int r8 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.m16518i(r8)
                r9 = 1
                if (r8 != r9) goto La7
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r8 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.this
                android.content.Context r9 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.m16519j(r8)
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r3 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.this
                int r3 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.m16518i(r3)
                r8.m16546d(r9, r1, r3)
                r0.setResult(r2)
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r7 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.this
                r7.finish()
                goto Lb5
            La7:
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r8 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.this
                int r8 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.m16518i(r8)
                r9 = 2
                if (r8 != r9) goto Lb5
                com.huawei.android.hicloud.oobe.ui.activity.MigrateFromHWDeviceActivity r7 = com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.this
                r7.finish()
            Lb5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.oobe.p086ui.activity.MigrateFromHWDeviceActivity.C2813b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* renamed from: n */
    private void m16520n() {
        if (getResources().getConfiguration().orientation != 2) {
            C11842p.m70791a2(this.f12326n);
        } else {
            if (C11842p.m70774V0(this)) {
                return;
            }
            C11842p.m70775V1(this, this.f12326n);
        }
    }

    /* renamed from: o */
    private void m16521o() {
        ((DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.from_clone)).setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.from_hicloud);
        this.f12317e = disableSupportedRelativeLayout;
        disableSupportedRelativeLayout.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.from_hisuit);
        this.f12318f = disableSupportedRelativeLayout2;
        disableSupportedRelativeLayout2.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout3 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.from_sd);
        this.f12319g = disableSupportedRelativeLayout3;
        disableSupportedRelativeLayout3.setOnClickListener(this);
        this.f12320h = C12809f.m76829b(this, R$id.migrate_divider1);
        this.f12321i = C12809f.m76829b(this, R$id.migrate_divider3);
        OOBEBackupRecoveryWlanDialog oOBEBackupRecoveryWlanDialog = new OOBEBackupRecoveryWlanDialog(this);
        this.f12325m = oOBEBackupRecoveryWlanDialog;
        if (1 == this.f12322j) {
            oOBEBackupRecoveryWlanDialog.m17071g(true);
        }
        m16525l();
        this.f12326n = (LinearLayout) C12809f.m76829b(this, R$id.from_hw_device_main_frame);
        if (C11842p.m70771U0()) {
            m16520n();
        }
        if (this.f12322j == 1) {
            m16522v();
        }
    }

    /* renamed from: v */
    private void m16522v() {
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) C12809f.m76829b(this, R$id.main_layout)).getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(this) + C11842p.m70789a0(this), 0, 0);
        }
    }

    /* renamed from: x */
    private void m16523x() {
        Class clsM66441r = C11019b.m66371t().m66441r("AccountMismatchAlertActivity");
        if (clsM66441r != null) {
            startActivity(new Intent(this, (Class<?>) clsM66441r));
        }
    }

    /* renamed from: k */
    public final void m16524k(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (18 == i10) {
            c10028cM62182c0.m62377p3("is_migrate_terms_confirm", true);
            m16528q(true);
            return;
        }
        if (19 == i10) {
            c10028cM62182c0.m62377p3("is_migrate_terms_confirm", true);
            m16530s(true);
            return;
        }
        if (20 == i10) {
            c10028cM62182c0.m62377p3("is_migrate_terms_confirm", true);
            m16527p(true);
        } else if (21 == i10) {
            c10028cM62182c0.m62377p3("is_migrate_terms_confirm", true);
            m16529r(true);
        } else if (10019 != i10) {
            setResult(-1);
            finish();
        }
    }

    /* renamed from: l */
    public final void m16525l() {
        if (C1443a.f6216d.booleanValue()) {
            this.f12317e.setVisibility(8);
            this.f12320h.setVisibility(8);
        } else {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            if (c10028cM62182c0 != null && c10028cM62182c0.m62395t1("is_already_configed_NV4") && !c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
                C11839m.m70688i("MigrateFromHWDeviceActivity", "the backupservice is not avi and the info is get");
                this.f12317e.setVisibility(8);
                this.f12320h.setVisibility(8);
            }
        }
        if (1 == this.f12322j && !C0209d.m1202Q0()) {
            this.f12318f.setVisibility(8);
            C12809f.m76829b(this, R$id.migrate_divider2).setVisibility(8);
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.action.START_BY_OOBE_APP");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        PackageManager packageManager = getPackageManager();
        if (intent.resolveActivity(packageManager) == null) {
            this.f12317e.setVisibility(8);
            this.f12320h.setVisibility(8);
        }
        Intent intent2 = new Intent();
        intent2.setAction("com.huawei.KoBackup.Entrance");
        if (intent2.resolveActivity(packageManager) == null) {
            this.f12319g.setVisibility(8);
            this.f12321i.setVisibility(8);
        } else {
            if (C0209d.m1191M1(this)) {
                return;
            }
            this.f12319g.setVisibility(8);
            this.f12321i.setVisibility(8);
        }
    }

    /* renamed from: m */
    public final void m16526m() {
        Bundle extras;
        this.f12322j = 1;
        Intent intent = getIntent();
        if (intent == null || (extras = new HiCloudSafeIntent(intent).getExtras()) == null) {
            return;
        }
        this.f12322j = new C10343b(extras).m63687i(FamilyShareConstants.ENTRY_TYPE, 1);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int intExtra;
        C11839m.m70688i("MigrateFromHWDeviceActivity", "requestCode ：" + i10 + ", resultCode :" + i11);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (-1 == i11) {
            m16524k(i10);
            return;
        }
        if (4 == i11) {
            C11839m.m70686d("MigrateFromHWDeviceActivity", "receive hms update result ,from queryinfoactivity");
            return;
        }
        if (i10 == 10019) {
            C11839m.m70686d("MigrateFromHWDeviceActivity", "receive hms update result ,but do nothing");
            return;
        }
        if (i11 == 1 && i10 == 10001) {
            m16531t();
            return;
        }
        if (1002 == i11) {
            m16546d(this.f12324l, "MigrateFromHWDeviceActivity", this.f12322j);
            return;
        }
        if (i11 == 702) {
            m16523x();
            return;
        }
        if (3 == i11 && 10006 == i10) {
            if (intent == null) {
                C11839m.m70687e("MigrateFromHWDeviceActivity", "hms data is null");
                return;
            }
            try {
                intExtra = hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1);
            } catch (RuntimeException e10) {
                C11839m.m70687e("MigrateFromHWDeviceActivity", "onActivityResult:" + e10.toString());
                intExtra = -1;
            }
            if (intExtra != -1) {
                C13192i.m79258g().m79265k(this, 10019, intExtra, 2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1226Y0()) {
            return;
        }
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("is_migrate_terms_confirm");
        if (view.getId() == R$id.from_clone) {
            m16527p(zM62395t1);
            return;
        }
        if (view.getId() == R$id.from_hicloud) {
            m16528q(zM62395t1);
        } else if (view.getId() == R$id.from_hisuit) {
            m16530s(zM62395t1);
        } else if (view.getId() == R$id.from_sd) {
            m16529r(zM62395t1);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C11842p.m70771U0()) {
            m16520n();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C13192i.m79258g().m79267m(true);
        if (C11842p.m70759Q0()) {
            setRequestedOrientation(1);
        }
        m16526m();
        setContentView(R$layout.migrate_from_hw_device);
        this.f12324l = this;
        m16521o();
        this.f12323k = new C2813b(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.intent.action.MIGRATE_DATA");
        this.f12324l.registerReceiver(this.f12323k, intentFilter, "com.huawei.hicloud.permission.MIGRATE_DATA", null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11842p.m70836m(this);
        C13192i.m79258g().m79267m(false);
        C2813b c2813b = this.f12323k;
        if (c2813b != null) {
            this.f12324l.unregisterReceiver(c2813b);
        }
        OOBEBackupRecoveryWlanDialog oOBEBackupRecoveryWlanDialog = this.f12325m;
        if (oOBEBackupRecoveryWlanDialog != null) {
            oOBEBackupRecoveryWlanDialog.dismiss();
            this.f12325m = null;
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16544a());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void onResume() {
        C13192i.m79258g().m79267m(true);
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
        m16533w();
    }

    /* renamed from: p */
    public final void m16527p(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z10) {
            m16548h(20, this, this.f12322j);
        } else if (C0209d.m1184K0(this.f12324l, "com.hicloud.android.clone")) {
            m16534y();
        } else {
            C11839m.m70688i("MigrateFromHWDeviceActivity", "phone clone uninstall");
            Toast.makeText(this, getString(R$string.clone_uninstall_to_market), 0).show();
        }
    }

    /* renamed from: q */
    public final void m16528q(boolean z10) {
        if (!C0209d.m1254f2(this)) {
            this.f12325m.m17068d();
        } else if (z10) {
            m16531t();
        } else {
            m16548h(18, this, this.f12322j);
        }
    }

    /* renamed from: r */
    public final void m16529r(boolean z10) {
        if (!z10) {
            m16548h(21, this, this.f12322j);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.KoBackup.Entrance");
            C0209d.m1302r2(intent, "com.huawei.KoBackup");
            Bundle bundle = new Bundle();
            bundle.putInt("entrance_type", this.f12322j);
            intent.putExtras(bundle);
            startActivityForResult(intent, 10015);
        } catch (ActivityNotFoundException unused) {
            C11839m.m70687e("MigrateFromHWDeviceActivity", "sd backrecovery not exit");
        }
    }

    /* renamed from: s */
    public final void m16530s(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z10) {
            m16548h(19, this, this.f12322j);
            return;
        }
        if (!C0209d.m1184K0(this.f12324l, "com.hicloud.android.clone")) {
            C11839m.m70688i("MigrateFromHWDeviceActivity", "phone clone uninstall");
            Toast.makeText(this, getString(R$string.clone_uninstall_to_market), 0).show();
            return;
        }
        Intent intent = new Intent("com.hicloud.android.clone.action.hisuit.startup");
        intent.setComponent(new ComponentName("com.hicloud.android.clone", "com.huawei.android.clone.activity.receiver.RestoreFromHisuiteActivity"));
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f12322j);
        m16532u(intent);
        new HwAnimationReflection(this).m15927c(1);
    }

    /* renamed from: t */
    public final void m16531t() {
        Class clsM66441r = C11019b.m66371t().m66441r("OOBECloudBackupRecordsActivity");
        if (clsM66441r == null) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) clsM66441r);
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f12322j);
        intent.putExtras(bundle);
        if (C11019b.m66371t().m66378D()) {
            Toast.makeText(this, getString(R$string.oobe_in_backuping_alert), 0).show();
            return;
        }
        if (!C11019b.m66371t().m66380E()) {
            C11839m.m70686d("MigrateFromHWDeviceActivity", "startActivityForResult RequestCode.OOBE_BACKUP");
            startActivityForResult(intent, NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE);
            return;
        }
        if (1 != this.f12322j) {
            C11019b.m66371t().m66373A0(this);
            return;
        }
        if (!C11019b.m66371t().m66382F()) {
            Toast.makeText(this, getString(R$string.oobe_in_recovering_alert), 0).show();
            return;
        }
        C11839m.m70686d("MigrateFromHWDeviceActivity", "CBAccess.inRestoreFirst()=" + C11019b.m66371t().m66382F());
        Intent intent2 = new Intent(this, (Class<?>) OOBERecoveringActivity.class);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("current_status", 2);
        bundle2.putInt(FamilyShareConstants.ENTRY_TYPE, this.f12322j);
        intent2.putExtras(bundle2);
        startActivity(intent2);
    }

    /* renamed from: u */
    public final void m16532u(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("MigrateFromHWDeviceActivity", "startActivity failed");
        }
    }

    /* renamed from: w */
    public void m16533w() {
        if (1 == this.f12322j) {
            C11829c.m70636z1(getWindow());
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2812a());
            C11829c.m70633y1(this, getWindow());
        }
    }

    /* renamed from: y */
    public final void m16534y() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent;
        if (1 == this.f12322j) {
            m16535z();
        } else {
            String strM70547U = C11829c.m70547U(this);
            if (TextUtils.isEmpty(strM70547U)) {
                C11839m.m70686d("MigrateFromHWDeviceActivity", "TextUtils.isEmpty(cloneTopActName)");
                m16535z();
                new HwAnimationReflection(this).m15927c(1);
                return;
            }
            try {
                C11839m.m70686d("MigrateFromHWDeviceActivity", "TextUtils.isEmpty(cloneTopActName) else");
                intent = new Intent(this, Class.forName(strM70547U));
            } catch (ClassNotFoundException unused) {
                C11839m.m70687e("MigrateFromHWDeviceActivity", "clone class not found");
                intent = null;
            }
            if (intent != null) {
                C11839m.m70686d("MigrateFromHWDeviceActivity", "TextUtils.isEmpty(cloneTopActName) intent != null");
                Bundle bundle = new Bundle();
                bundle.putInt("choose_phone_type", 1);
                bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f12322j);
                bundle.putString("entrance_level", "from_hw");
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
        new HwAnimationReflection(this).m15927c(1);
    }

    /* renamed from: z */
    public final void m16535z() {
        Intent intent = new Intent("com.hicloud.android.clone.action.receive.show");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(new ComponentName("com.hicloud.android.clone", "com.huawei.android.clone.activity.receiver.ShowQRCodeActivity"));
        intent.putExtra("choose_phone_type", 1);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f12322j);
        intent.putExtra("entrance_level", "from_hw");
        m16532u(intent);
    }
}
