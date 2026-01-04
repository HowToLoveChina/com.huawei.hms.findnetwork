package com.huawei.android.hicloud.p088ui.activity;

import ae.C0183y0;
import android.accounts.OperationCanceledException;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.oobe.p086ui.activity.SimplifyOOBEQueryinfoActivity;
import com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultObservable;
import com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBackupDeviceInfoFragment;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.NotSupportSecondUserDialog;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import gp.C10028c;
import hu.C10343b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import je.C10806t;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0219i;
import p034bc.C1161a;
import p034bc.C1162b;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12590s0;
import p681uj.C13195l;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;
import p771xd.C13764h;
import p771xd.C13765i;
import p771xd.C13766j;
import p771xd.C13767k;
import p815ym.AbstractC14026a;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBECloudBackupRecordsActivity extends CloudBackupBaseUiActivity implements InterfaceC13449b, IActivityResultObservable, View.OnClickListener {

    /* renamed from: D */
    public RelativeLayout f15636D;

    /* renamed from: E */
    public ScrollView f15637E;

    /* renamed from: F */
    public NotchFitLinearLayout f15638F;

    /* renamed from: H */
    public boolean f15640H;

    /* renamed from: I */
    public int f15641I;

    /* renamed from: L */
    public RelativeLayout f15644L;

    /* renamed from: M */
    public TempBackupRecordsBackupDeviceInfoFragment f15645M;

    /* renamed from: N */
    public C1161a<OOBECloudBackupRecordsActivity> f15646N;

    /* renamed from: O */
    public Bundle f15647O;

    /* renamed from: P */
    public C0183y0 f15648P;

    /* renamed from: Q */
    public ProgressDialog f15649Q;

    /* renamed from: C */
    public String f15635C = "";

    /* renamed from: G */
    public String f15639G = "showDeviceListPage";

    /* renamed from: J */
    public String f15642J = "showDeviceListPage";

    /* renamed from: K */
    public boolean f15643K = false;

    /* renamed from: R */
    public final Map<String, InterfaceC3421b> f15650R = new HashMap();

    /* renamed from: S */
    public Set<String> f15651S = new HashSet();

    /* renamed from: T */
    public final Handler f15652T = new HandlerC3420a();

    /* renamed from: U */
    public Handler.Callback f15653U = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.p7
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17702a.m21711p2(message);
        }
    };

    /* renamed from: com.huawei.android.hicloud.ui.activity.OOBECloudBackupRecordsActivity$a */
    public class HandlerC3420a extends Handler {
        public HandlerC3420a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (OOBECloudBackupRecordsActivity.this.isDestroyed() || OOBECloudBackupRecordsActivity.this.isFinishing()) {
                C11839m.m70689w("OOBECloudBackupRecordsActivity", "OOBEBackupRecoveryActivity is destoryed");
                return;
            }
            int i10 = message.what;
            if (1002 == i10) {
                OOBECloudBackupRecordsActivity.this.m21719d2();
                OOBECloudBackupRecordsActivity.this.m21718c2();
            } else if (6 == i10) {
                OOBECloudBackupRecordsActivity.this.m21714w2();
            }
        }
    }

    @FunctionalInterface
    /* renamed from: com.huawei.android.hicloud.ui.activity.OOBECloudBackupRecordsActivity$b */
    public interface InterfaceC3421b {
        /* renamed from: a */
        void mo21736a(List<CloudBackupDeviceInfo> list);
    }

    /* renamed from: f2 */
    private void m21709f2(CloudRecoveryItem cloudRecoveryItem, int i10) {
        try {
            Intent intent = new Intent(this, (Class<?>) CloudRestoreOptionsActivity.class);
            intent.addFlags(65536);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_from_recovery", false);
            bundle.putInt(FamilyShareConstants.ENTRY_TYPE, 1);
            String strM68636f = C11477c.m68636f(cloudRecoveryItem.getDeviceIdd());
            if (this.f15651S.contains(cloudRecoveryItem.getDeviceIdd())) {
                C11839m.m70688i("OOBECloudBackupRecordsActivity", "oobe no need encrypt");
            } else {
                cloudRecoveryItem.setDeviceIdd(strM68636f);
                this.f15651S.add(strM68636f);
            }
            bundle.putParcelable("backup_content_detail_list", cloudRecoveryItem);
            bundle.putString("entrance_of_restore", this.f15635C);
            bundle.putString("device_count", String.valueOf(1));
            bundle.putString("record_count", String.valueOf(1));
            bundle.putString("record_index", String.valueOf(i10));
            bundle.putBoolean("new_version_flag", true);
            bundle.putInt("record_count_type_int", 1);
            bundle.putBoolean("isNewBmRecord", cloudRecoveryItem.isNewBmRecord());
            intent.putExtras(bundle);
            intent.putExtra("backup_is_temp_backup_type", cloudRecoveryItem.isTempBackup());
            startActivityForResult(intent, PayStatusCodes.PAY_STATE_PARAM_ERROR);
            overridePendingTransition(0, 0);
        } catch (Exception e10) {
            C11839m.m70687e("OOBECloudBackupRecordsActivity", " navToBackupContentDetail " + e10.getMessage());
        }
    }

    /* renamed from: i2 */
    private void m21710i2() {
        Bundle extras = new HiCloudSafeIntent(getIntent()).getExtras();
        if (extras != null) {
            this.f15641I = new C10343b(extras).m63687i(FamilyShareConstants.ENTRY_TYPE, 1);
            C11839m.m70686d("OOBECloudBackupRecordsActivity", "initIntentData,entryType:" + this.f15641I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p2 */
    public /* synthetic */ boolean m21711p2(Message message) {
        C0183y0 c0183y0;
        int i10 = message.what;
        if (i10 != 32315) {
            if (i10 != 33055 || (c0183y0 = this.f15648P) == null) {
                return false;
            }
            c0183y0.notifyDataSetChanged();
            return false;
        }
        if (message.arg1 == 0) {
            m21734y2(message);
            return false;
        }
        C11839m.m70688i("OOBECloudBackupRecordsActivity", "query backup records error.");
        mo19229P1(R$string.current_device_no_backup_records, R$drawable.pay_sync_nodata);
        return false;
    }

    /* renamed from: t2 */
    public static void m21713t2(ViewGroup viewGroup, Context context) {
        if (viewGroup == null) {
            C11839m.m70687e("OOBECloudBackupRecordsActivity", "viewGroup is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(context) + C11842p.m70789a0(context), 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w2 */
    public void m21714w2() {
        if (this.f15649Q == null) {
            this.f15649Q = new ProgressDialog(this);
        }
        if (this.f15649Q.isShowing() || isFinishing()) {
            return;
        }
        this.f15649Q.setMessage(getResources().getString(R$string.wait_loging));
        this.f15649Q.setCancelable(false);
        this.f15649Q.show();
    }

    /* renamed from: A2 */
    public void m21715A2() {
        if (C11842p.m70759Q0() || this.f15641I == 2) {
            setRequestedOrientation(1);
        }
    }

    /* renamed from: B2 */
    public void m21716B2() {
        this.f15646N.m7256c();
    }

    /* renamed from: C2 */
    public final void m21717C2() {
        if (this.f15641I == 1) {
            C0216g0.m1402e(this).m1421S("SOURCE_STARTGUIDE", "SOURCE_ID_OOBE");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        m19237Q1(R$string.connect_server_fail_msg1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        C11839m.m70688i("OOBECloudBackupRecordsActivity", " login success");
        if (C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
            C11839m.m70688i("OOBECloudBackupRecordsActivity", " handle quick migrate");
            C10806t.m65776c(this);
            C10806t.m65777d(this);
            C10806t.m65781h();
            C10806t.m65783j(this);
            C10806t.m65780g(this);
            C10806t.m65779f(this);
            RestoreNotifyUtil.getInstance().saveOOBEState(this);
            C0209d.m1318v2(this);
            C10028c.m62182c0().m62377p3("quick_migrate_flag", false);
            m21730s2();
            return;
        }
        if (!C13452e.m80781L().m80803F0().booleanValue() || C0219i.m1463a() < 27 || C0209d.m1269j1()) {
            Intent intent = new Intent(this, (Class<?>) SimplifyOOBEQueryinfoActivity.class);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f15641I);
            intent.putExtra("intent_from_settings_data", true);
            intent.putExtra("intent_from_settings", this.f15643K);
            startActivityForResult(intent, 10014);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) WelcomeToBackupRecordsActivity.class);
        intent2.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f15641I);
        intent2.putExtra("intent_from_settings_data", true);
        intent2.putExtra("intent_from_settings", this.f15643K);
        startActivityForResult(intent2, 10014);
    }

    /* renamed from: c2 */
    public final void m21718c2() {
        C10028c.m62182c0().m62377p3("is_migrate_terms_confirm", true);
        if (!C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            m21733x2();
        } else {
            if (!C0209d.m1333z1(this)) {
                m19239S1();
                return;
            }
            m19238R1();
            CloudBackupService.getInstance().register(this.f15653U);
            CloudBackupService.getInstance().queryUserBackupInfo();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        List<View> listMo13289d1 = super.mo13289d1();
        if (listMo13289d1 == null) {
            listMo13289d1 = new ArrayList<>();
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15638F;
        if (notchFitLinearLayout != null) {
            listMo13289d1.add(notchFitLinearLayout);
        }
        listMo13289d1.add(this.f15644L);
        return listMo13289d1;
    }

    /* renamed from: d2 */
    public final void m21719d2() {
        ProgressDialog progressDialog = this.f15649Q;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
                this.f15649Q = null;
            } catch (IllegalArgumentException unused) {
                C11839m.m70687e("OOBECloudBackupRecordsActivity", "waitdialog dismiss IllegalArgumentException");
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        setResult(0);
        finish();
    }

    /* renamed from: e2 */
    public final void m21720e2(int i10) {
        if (-1 == i10) {
            setResult(-1);
            finish();
        } else {
            setResult(0);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultObservable
    /* renamed from: f0 */
    public void mo17028f0(int i10, int i11, Intent intent) {
        if (i10 == 10019) {
            C11839m.m70686d("OOBECloudBackupRecordsActivity", "receive hms update result ,but do nothing");
        }
        if (100301 == i11) {
            setResult(C5963j.f27043l);
            finish();
            return;
        }
        if ((i10 == 30001 || i10 == 30002) && i11 == -1) {
            setResult(-1);
            finish();
        } else if (i10 == 30001 && i11 == 0) {
            C11839m.m70686d("OOBECloudBackupRecordsActivity", "recover return");
        } else {
            m21720e2(i11);
        }
    }

    /* renamed from: g2 */
    public void m21721g2(int i10) {
        if (i10 == -1) {
            C11019b.m66371t().m66409b(this.f15647O, this);
        } else if (i10 == 0) {
            finish();
        }
        this.f15647O = null;
    }

    /* renamed from: h2 */
    public void m21722h2() {
        this.f15650R.put("showDeviceListPage", new InterfaceC3421b() { // from class: com.huawei.android.hicloud.ui.activity.l7
            @Override // com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity.InterfaceC3421b
            /* renamed from: a */
            public final void mo21736a(List list) {
                this.f17667a.m21732v2(list);
            }
        });
        this.f15650R.put("showRecordListPage", new InterfaceC3421b() { // from class: com.huawei.android.hicloud.ui.activity.m7
            @Override // com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity.InterfaceC3421b
            /* renamed from: a */
            public final void mo21736a(List list) {
                this.f17677a.m21731u2(list);
            }
        });
        this.f15650R.put("showRecoverPage", new InterfaceC3421b() { // from class: com.huawei.android.hicloud.ui.activity.n7
            @Override // com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity.InterfaceC3421b
            /* renamed from: a */
            public final void mo21736a(List list) {
                this.f17683a.m21735z2(list);
            }
        });
        m19238R1();
        if (C13612b.m81829B().isLogin() && C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
            m21718c2();
            return;
        }
        this.f15640H = false;
        if (this.f15641I == 2) {
            C13612b.m81829B().m81856U(this, this);
        } else {
            C1162b.m7257a().m7258b(this, new InterfaceC13456i() { // from class: com.huawei.android.hicloud.ui.activity.o7
                @Override // p709vj.InterfaceC13456i
                public final void loginResult(boolean z10) {
                    this.f17693a.m21728o2(z10);
                }
            });
        }
    }

    /* renamed from: j2 */
    public final void m21723j2() {
        if (C0209d.m1166E1()) {
            return;
        }
        new NotSupportSecondUserDialog(this).show();
    }

    /* renamed from: k2 */
    public void m21724k2() {
        m22365E1(R$string.backup_manager_cloudbackup);
        mo19982C1();
        LayoutInflater.from(this).inflate(R$layout.activity_oobe_device_list, (ViewGroup) this.f13894y, true);
        this.f15638F = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_top);
        this.f13895z.setOnClickListener(this);
        this.f13888s.setOnClickListener(this);
        this.f15637E = (ScrollView) C12809f.m76829b(this, R$id.records_list_layout);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_recovery_queryconfig_failed_frame_column);
        this.f15636D = relativeLayout;
        C11842p.m70795b2(this, relativeLayout);
        this.f15644L = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_recovery_queryconfig_failed_frame);
        ScrollDisabledListView scrollDisabledListView = (ScrollDisabledListView) C12809f.m76829b(this, R$id.oobe_device_list);
        this.f15645M = (TempBackupRecordsBackupDeviceInfoFragment) C12809f.m76828a(getFragmentManager(), R$id.fragment_temp_backup_records);
        C0183y0 c0183y0 = new C0183y0(this, this);
        this.f15648P = c0183y0;
        scrollDisabledListView.setAdapter((ListAdapter) c0183y0);
        m21713t2(this.f15638F, this);
        m21713t2(this.f15644L, this);
        C11842p.m70745L1(this.f13886q, this);
        C11842p.m70745L1(this.f13887r, this);
        C11842p.m70745L1(this.f13890u, this);
    }

    /* renamed from: l2 */
    public final void m21725l2() {
        if (2 == this.f15641I) {
            m22365E1(com.huawei.android.hicloud.oobe.R$string.from_hisync);
            this.f15643K = true;
            m21723j2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    /* renamed from: m2 */
    public final void m21726m2(View view) {
        if (!C0209d.m1333z1(this)) {
            C11839m.m70688i("OOBECloudBackupRecordsActivity", "jump2BackupRecordsPage error, no network");
            m19239S1();
            return;
        }
        int iM1057f = ((C0183y0.a) view.getTag()).m1057f();
        if (iM1057f < 0) {
            C11839m.m70687e("OOBECloudBackupRecordsActivity", "jump2BackupRecordsPage error ,position from holder < 0");
            return;
        }
        CloudBackupDeviceInfo cloudBackupDeviceInfo = (CloudBackupDeviceInfo) this.f15648P.getItem(iM1057f);
        if (cloudBackupDeviceInfo.getRecoveryItems().size() > 1 || C12590s0.m75854g2(cloudBackupDeviceInfo.getRecoveryItems())) {
            C11839m.m70688i("OOBECloudBackupRecordsActivity", "jump2BackupRecordsPage,recoveryItemList size > 1 or has one harmony record");
            m21727n2(cloudBackupDeviceInfo);
        } else if (cloudBackupDeviceInfo.getRecoveryItems().size() == 1) {
            m21709f2(cloudBackupDeviceInfo.getRecoveryItems().get(0), 1);
        } else {
            C11839m.m70689w("OOBECloudBackupRecordsActivity", "jump2BackupRecordsPage warning,no record");
        }
    }

    /* renamed from: n2 */
    public final void m21727n2(CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        if (cloudBackupDeviceInfo == null) {
            C11839m.m70687e("OOBECloudBackupRecordsActivity", "jump2BackupRecordsPageByDetail error,backupRecord is null");
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
        if ("showRecordListPage".equals(this.f15642J)) {
            intent.addFlags(65536);
        }
        intent.putExtra("is_current_device", cloudBackupDeviceInfo.isCurrent());
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        intent.putExtra("backup_device_id", cloudBackupDeviceInfo.getBackupDeviceId());
        intent.putExtra("backup_device_category", cloudBackupDeviceInfo.getDeviceCategory());
        Bundle bundle = new Bundle();
        bundle.putParcelable("cloudBackupDeviceInfo", cloudBackupDeviceInfo);
        intent.putExtra(CommonPickerConstant.RequestParams.KEY_DEVICE_INFO, bundle);
        startActivityForResult(intent, PayStatusCodes.PAY_STATE_TIME_OUT);
    }

    /* renamed from: o2 */
    public final /* synthetic */ void m21728o2(boolean z10) {
        if (z10) {
            C1162b.m7257a().m7260d(this, this);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.action.START_BY_OOBE_APP");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        try {
            startActivityForResult(intent, 1003);
        } catch (Exception e10) {
            C11839m.m70687e("OOBECloudBackupRecordsActivity", "startActivityForResult error:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70686d("OOBECloudBackupRecordsActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if ((i10 == 30002 || i10 == 30001) && i11 == 11) {
            C11839m.m70686d("OOBECloudBackupRecordsActivity", "setResult to migrate");
            setResult(11, intent);
            finish();
            return;
        }
        if (i10 == 8701) {
            C13195l.m79272J().m79299O(this, this, i10, i11, intent);
            return;
        }
        if (i11 == 2) {
            C11839m.m70688i("OOBECloudBackupRecordsActivity", "back to oobe page from cloudBackupRecordsActivity");
            if (C0216g0.m1402e(this).m1437o()) {
                C11839m.m70688i("OOBECloudBackupRecordsActivity", "auto jump options");
                finish();
                return;
            }
            return;
        }
        if (i10 != 30001 || !C0216g0.m1402e(this).m1437o()) {
            this.f15646N.m7254a(this, i10, i11, intent);
            return;
        }
        C11839m.m70688i("OOBECloudBackupRecordsActivity", "auto jump options");
        try {
            C0216g0.m1402e(this).m1414L(false);
            this.f15646N.m7254a(this, i10, i11, intent);
            if (isFinishing()) {
                return;
            }
            finish();
        } catch (Exception e10) {
            C11839m.m70687e("OOBECloudBackupRecordsActivity", "finish error: " + e10.getMessage());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.backup_detail == id2) {
            m21726m2(view);
            return;
        }
        if (R$id.bt_no_net == id2) {
            C11829c.m70612r1(this);
            return;
        }
        if (R$id.rl_network_not_connect == id2) {
            m19238R1();
            if (C0209d.m1333z1(this)) {
                m21722h2();
            } else {
                m19239S1();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m21729r2();
        super.onCreate(bundle);
        m21710i2();
        m21724k2();
        mo19005p1();
        m21722h2();
        m21715A2();
        int i10 = this.f15641I;
        if (1 == i10) {
            this.f15635C = "1";
        } else if (2 == i10) {
            this.f15635C = "3";
        }
        m21725l2();
        C12808e.m76822a(this);
        m21717C2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f15653U != null) {
            CloudBackupService.getInstance().unregister(this.f15653U);
        }
        ProgressDialog progressDialog = this.f15649Q;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f15649Q = null;
        }
        m21716B2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11842p.m70751N1(this, getWindow());
    }

    /* renamed from: r2 */
    public void m21729r2() {
        C1161a<OOBECloudBackupRecordsActivity> c1161a = new C1161a<>();
        this.f15646N = c1161a;
        c1161a.m7255b(1003, new C13764h());
        this.f15646N.m7255b(10014, new C13767k());
        this.f15646N.m7255b(10022, new C13766j());
        this.f15646N.m7255b(10010, new C13765i());
    }

    /* renamed from: s2 */
    public void m21730s2() {
        C11839m.m70688i("OOBECloudBackupRecordsActivity", " get the config success");
        Message messageObtain = Message.obtain();
        messageObtain.what = 1002;
        this.f15652T.sendMessage(messageObtain);
    }

    /* renamed from: u2 */
    public final void m21731u2(List<CloudBackupDeviceInfo> list) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70689w("OOBECloudBackupRecordsActivity", "showBackupRecordList error,input deviceList is empty");
        } else {
            m21727n2(list.get(0));
            C0216g0.m1402e(this).m1414L(true);
        }
    }

    /* renamed from: v2 */
    public final void m21732v2(List<CloudBackupDeviceInfo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CloudBackupDeviceInfo cloudBackupDeviceInfo : list) {
            if (cloudBackupDeviceInfo.isTempBackup()) {
                arrayList2.add(cloudBackupDeviceInfo);
            } else {
                arrayList.add(cloudBackupDeviceInfo);
            }
        }
        this.f15648P.m1048a(arrayList);
        this.f15645M.m24315g(this.f15635C);
        this.f15645M.m24314f(arrayList2);
        mo19236O1();
        this.f15637E.setVisibility(0);
        this.f15648P.notifyDataSetChanged();
    }

    /* renamed from: x2 */
    public final void m21733x2() {
        this.f15638F.setVisibility(8);
        this.f15644L.setVisibility(0);
        this.f13886q.setVisibility(8);
        this.f13894y.setVisibility(0);
    }

    /* renamed from: y2 */
    public final void m21734y2(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            mo19229P1(R$string.current_device_no_backup_records, R$drawable.pay_sync_nodata);
            return;
        }
        if (!C0209d.m1333z1(this)) {
            m19239S1();
            return;
        }
        final ArrayList parcelableArrayList = data.getParcelableArrayList("userBackupInfo");
        if (AbstractC14026a.m84159a(parcelableArrayList)) {
            C11839m.m70689w("OOBECloudBackupRecordsActivity", "get user deviceInfo is empty");
            mo19229P1(R$string.current_device_no_backup_records, R$drawable.pay_sync_nodata);
            return;
        }
        if (parcelableArrayList.size() == 1) {
            C11839m.m70688i("OOBECloudBackupRecordsActivity", "deviceInfos size is one.");
            this.f15642J = "showRecordListPage";
            List<CloudRecoveryItem> recoveryItems = ((CloudBackupDeviceInfo) parcelableArrayList.get(0)).getRecoveryItems();
            if (recoveryItems != null && recoveryItems.size() == 1 && recoveryItems.get(0).getBackupRecordLabel() != 3) {
                this.f15642J = "showRecoverPage";
            }
        }
        C11839m.m70688i("OOBECloudBackupRecordsActivity", "pageJumpStrategy:" + this.f15642J);
        Optional.ofNullable(this.f15650R.get(this.f15642J)).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.q7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((OOBECloudBackupRecordsActivity.InterfaceC3421b) obj).mo21736a(parcelableArrayList);
            }
        });
    }

    /* renamed from: z2 */
    public final void m21735z2(List<CloudBackupDeviceInfo> list) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70689w("OOBECloudBackupRecordsActivity", "showBackupRecordList error,input deviceList is empty");
        } else {
            m21709f2(list.get(0).getRecoveryItems().get(0), 1);
            C0216g0.m1402e(this).m1414L(true);
        }
    }
}
