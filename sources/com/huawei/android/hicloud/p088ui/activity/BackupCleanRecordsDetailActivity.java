package com.huawei.android.hicloud.p088ui.activity;

import ae.C0113d;
import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupCleanLoadingDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupCleanRecordConfirmDialog;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p618rm.C12580p;
import p684un.C13225d;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupCleanRecordsDetailActivity extends CloudBackupBaseUiActivity implements View.OnClickListener {

    /* renamed from: Q */
    public static final String f13544Q = "BackupCleanRecordsDetailActivity";

    /* renamed from: C */
    public NotchTopFitLinearLayout f13545C;

    /* renamed from: D */
    public NotchFitLinearLayout f13546D;

    /* renamed from: E */
    public TextView f13547E;

    /* renamed from: F */
    public TextView f13548F;

    /* renamed from: G */
    public RecyclerView f13549G;

    /* renamed from: H */
    public RecyclerView f13550H;

    /* renamed from: I */
    public boolean f13551I;

    /* renamed from: J */
    public CloudRecoveryItem f13552J;

    /* renamed from: K */
    public CloudRestoreItem f13553K;

    /* renamed from: L */
    public C0113d f13554L;

    /* renamed from: M */
    public C0113d f13555M;

    /* renamed from: N */
    public BackupCleanLoadingDialog f13556N;

    /* renamed from: O */
    public HandlerC3126b f13557O;

    /* renamed from: P */
    public final Handler.Callback f13558P = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.f
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17603a.m18622k2(message);
        }
    };

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupCleanRecordsDetailActivity$b */
    public static class HandlerC3126b extends Handler {

        /* renamed from: a */
        public WeakReference<BackupCleanRecordsDetailActivity> f13559a;

        public HandlerC3126b(BackupCleanRecordsDetailActivity backupCleanRecordsDetailActivity) {
            this.f13559a = new WeakReference<>(backupCleanRecordsDetailActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BackupCleanRecordsDetailActivity backupCleanRecordsDetailActivity = this.f13559a.get();
            if (backupCleanRecordsDetailActivity == null || backupCleanRecordsDetailActivity.isFinishing()) {
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                backupCleanRecordsDetailActivity.m18618g2();
                return;
            }
            if (i10 == 2) {
                backupCleanRecordsDetailActivity.f13554L.m760J(true);
                backupCleanRecordsDetailActivity.m18625p2("music");
            } else {
                if (i10 != 4) {
                    return;
                }
                backupCleanRecordsDetailActivity.m18615d2(message.arg1);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupCleanRecordsDetailActivity$c */
    public class C3127c extends AbstractC12367d {
        public C3127c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                if (new C12519c().m75297h(1).contains("music")) {
                    C11839m.m70686d(BackupCleanRecordsDetailActivity.f13544Q, "query3rdList music is virtual");
                    BackupCleanRecordsDetailActivity.this.f13557O.sendEmptyMessage(2);
                }
            } catch (C9721b e10) {
                C11839m.m70687e(BackupCleanRecordsDetailActivity.f13544Q, "query3rdList error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: l2 */
    public static /* synthetic */ int m18611l2(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75591y(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: n2 */
    public static /* synthetic */ int m18612n2(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75586t(cloudRestoreItem.getAppName(), cloudRestoreItem2.getAppName());
    }

    /* renamed from: q2 */
    private void m18613q2() {
        C13225d.m79490f1().m79585f0("mecloud_smart_clear_backup_record_detail", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_smart_clear_backup_record_detail", "1", "80");
    }

    /* renamed from: c2 */
    public void m18614c2() {
        C11839m.m70688i(f13544Q, "confirmCleanup");
        BackupCleanLoadingDialog backupCleanLoadingDialog = new BackupCleanLoadingDialog(this);
        this.f13556N = backupCleanLoadingDialog;
        backupCleanLoadingDialog.show();
        BackupCleanRecordsManager.getInstance().deleteBackupRecord(this.f13552J, this.f13557O);
        this.f13557O.sendEmptyMessageDelayed(1, 5000L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13545C);
        arrayList.add(this.f13546D);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m18615d2(int i10) {
        C11839m.m70688i(f13544Q, "deleteRecordFailed");
        BackupCleanLoadingDialog backupCleanLoadingDialog = this.f13556N;
        if (backupCleanLoadingDialog != null && backupCleanLoadingDialog.isShowing()) {
            this.f13556N.dismiss();
        }
        if (this.f13557O.hasMessages(1)) {
            this.f13557O.removeMessages(1);
        }
        if (i10 == 1) {
            C11841o.m70708d(this, getString(R$string.delete_failed_toast), 0);
        } else {
            C11841o.m70708d(this, getString(R$string.recovery_no_data_server_error), 0);
        }
    }

    /* renamed from: e2 */
    public final void m18616e2() {
        if (!m18621j2()) {
            CloudBackup3rdIconUtil.download3rdIcons(this.f13552J.getRecordDeviceId(), this.f13552J.getBackupId(), this.f13552J.getDeviceType());
        }
        CloudBackup3rdIconUtil.downloadVirtualIcon();
    }

    /* renamed from: f2 */
    public final boolean m18617f2(String str, List<CloudRestoreItem> list, RecyclerView.AbstractC0846p abstractC0846p, C0113d c0113d) {
        if (list == null || !(abstractC0846p instanceof LinearLayoutManager) || c0113d == null) {
            C11839m.m70689w(f13544Q, "findItemToRefresh: param is error");
            return false;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) abstractC0846p;
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (str.equals(list.get(i10).getAppId())) {
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                String str2 = f13544Q;
                C11839m.m70686d(str2, "findItemToRefresh: firstVisiblePosition=" + iFindFirstVisibleItemPosition + ", lastVisiblePosition=" + iFindLastVisibleItemPosition);
                if (i10 < iFindFirstVisibleItemPosition || i10 > iFindLastVisibleItemPosition) {
                    return true;
                }
                C11839m.m70686d(str2, "findItemToRefresh: position = " + i10);
                c0113d.m5214k(i10);
                return true;
            }
        }
        return false;
    }

    /* renamed from: g2 */
    public final void m18618g2() {
        C11839m.m70688i(f13544Q, "finishLoadingAndActivity");
        BackupCleanLoadingDialog backupCleanLoadingDialog = this.f13556N;
        if (backupCleanLoadingDialog != null && backupCleanLoadingDialog.isShowing()) {
            this.f13556N.dismiss();
        }
        finish();
    }

    /* renamed from: h2 */
    public final CloudRestoreItem m18619h2() {
        List<CloudRestoreItem> itemList = this.f13552J.getItemList();
        if (itemList == null || itemList.isEmpty()) {
            return null;
        }
        for (CloudRestoreItem cloudRestoreItem : itemList) {
            if ("thirdAppData".equals(cloudRestoreItem.getAppId())) {
                C11839m.m70688i(f13544Q, "getThirdAppDataItem");
                return cloudRestoreItem;
            }
        }
        return null;
    }

    /* renamed from: i2 */
    public void m18620i2() {
        ActionBar actionBar;
        LayoutInflater.from(this).inflate(R$layout.activity_backup_clean_records_detail, (ViewGroup) this.f13894y, true);
        if (!this.f13551I && (actionBar = getActionBar()) != null) {
            ActionBarEx.setEndIcon(actionBar, true, ContextCompat.getDrawable(this, R$drawable.hidisk_ic_toolbar_delete), this);
        }
        m22365E1(R$string.backup_clean_records);
        mo19982C1();
        this.f13545C = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.clean_record_detail_root_layout);
        this.f13546D = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.clean_record_detail_layout);
        this.f13547E = (TextView) C12809f.m76829b(this, R$id.tv_backup_device);
        this.f13548F = (TextView) C12809f.m76829b(this, R$id.tv_backup_time);
        this.f13549G = (RecyclerView) C12809f.m76829b(this, R$id.rv_backup_modules);
        this.f13550H = (RecyclerView) C12809f.m76829b(this, R$id.rv_backup_app_data);
        this.f13888s.setOnClickListener(this);
        this.f13895z.setOnClickListener(this);
        mo19005p1();
    }

    /* renamed from: j2 */
    public final boolean m18621j2() {
        CloudRecoveryItem cloudRecoveryItem = this.f13552J;
        if (cloudRecoveryItem != null) {
            return CBSBaseReq.CURRENT_API_VERSION.equalsIgnoreCase(cloudRecoveryItem.getVersion());
        }
        return false;
    }

    /* renamed from: k2 */
    public final /* synthetic */ boolean m18622k2(Message message) {
        int i10 = message.what;
        if (i10 == 32322) {
            Bundle data = message.getData();
            if (data == null) {
                return false;
            }
            this.f13552J.setItemList(((CloudRecoveryItem) data.getParcelable("recordItem")).getItemList());
            m18627s2();
            return false;
        }
        if (i10 != 32422) {
            if (i10 != 33001) {
                return false;
            }
            m18625p2((String) message.obj);
            return false;
        }
        if (C0209d.m1333z1(this)) {
            m19237Q1(R$string.recovery_no_data_server_error);
            return false;
        }
        C11839m.m70688i(f13544Q, "net disconnected");
        m19239S1();
        return false;
    }

    /* renamed from: m2 */
    public final /* synthetic */ void m18623m2(View view) {
        if (this.f13554L.m755E()) {
            this.f13550H.setVisibility(8);
        } else {
            this.f13550H.setVisibility(0);
        }
    }

    /* renamed from: o2 */
    public final void m18624o2() {
        boolean zM1333z1 = C0209d.m1333z1(this);
        C11839m.m70686d(f13544Q, "queryV3RecordsDetail isNetWorkConnected =" + zM1333z1);
        if (!zM1333z1) {
            m19239S1();
        } else {
            CloudBackupService.getInstance().showV3RecordsDetail(this.f13552J.getBackupDeviceId(), this.f13552J.getBackupId(), this.f13552J.isNewBmRecord(), this.f13552J.getBmDataType() == 3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w(f13544Q, "click too fast");
            return;
        }
        int id2 = view.getId();
        if (id2 == C0209d.m1308t0("icon2")) {
            if (this.f13894y.getVisibility() == 8) {
                C11839m.m70686d(f13544Q, "ui loading");
                return;
            } else if (C0209d.m1333z1(this)) {
                new BackupCleanRecordConfirmDialog(this).show();
                return;
            } else {
                C11839m.m70688i(f13544Q, "network disconnected");
                C11841o.m70708d(this, getString(R$string.gallery_no_network_tips), 0);
                return;
            }
        }
        if (id2 == R$id.bt_no_net) {
            C11829c.m70612r1(this);
        } else if (id2 == R$id.rl_network_not_connect) {
            if (C0209d.m1333z1(this)) {
                m18626r2();
            } else {
                m19239S1();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C11839m.m70688i(f13544Q, "onCreate");
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f13551I = safeIntent.getBooleanExtra("isLatest", false);
        CloudRecoveryItem cloudRecoveryItem = (CloudRecoveryItem) safeIntent.m53580d("recordItem", CloudRecoveryItem.class);
        this.f13552J = cloudRecoveryItem;
        cloudRecoveryItem.setRecordDeviceId(safeIntent.getStringExtra("recordDeviceId"));
        this.f13552J.setBackupDeviceId(safeIntent.getStringExtra(CloudBackupConstant.BACKUP_DEVICE_ID));
        this.f13552J.setVersion(safeIntent.getStringExtra("version"));
        m18620i2();
        CBCallBack.getInstance().registerCallback(this.f13558P);
        this.f13557O = new HandlerC3126b(this);
        m18626r2();
        m18613q2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i(f13544Q, "onDestroy");
        CBCallBack.getInstance().unregisterCallback(this.f13558P);
    }

    /* renamed from: p2 */
    public void m18625p2(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(f13544Q, "refreshItemIcon: appId is empty");
            return;
        }
        String str2 = f13544Q;
        C11839m.m70688i(str2, "refreshItemIcon: " + str);
        CloudRestoreItem cloudRestoreItem = this.f13553K;
        if (cloudRestoreItem != null && m18617f2(str, cloudRestoreItem.m29202r(), this.f13550H.getLayoutManager(), this.f13555M)) {
            C11839m.m70688i(str2, "refreshItemIcon appdata");
            return;
        }
        CloudRecoveryItem cloudRecoveryItem = this.f13552J;
        if (cloudRecoveryItem == null || !m18617f2(str, cloudRecoveryItem.getItemList(), this.f13549G.getLayoutManager(), this.f13554L)) {
            return;
        }
        C11839m.m70688i(str2, "refreshItemIcon modules");
    }

    /* renamed from: r2 */
    public final void m18626r2() {
        m19238R1();
        if (m18621j2()) {
            C11839m.m70688i(f13544Q, "current record version is v3");
            m18624o2();
        } else {
            C11839m.m70688i(f13544Q, "current record version is v2");
            m18627s2();
        }
    }

    /* renamed from: s2 */
    public final void m18627s2() {
        mo19236O1();
        CloudRecoveryItem cloudRecoveryItem = this.f13552J;
        if (cloudRecoveryItem == null) {
            C11839m.m70687e(f13544Q, "initData: recordItem is null");
            return;
        }
        if (cloudRecoveryItem.isCurrent()) {
            this.f13547E.setText(getString(R$string.cloudbackup_self_device_new_update, CloudBackupUtil.getDeviceDisplayName(this, this.f13552J)));
        } else {
            this.f13547E.setText(CloudBackupUtil.getDeviceDisplayName(this, this.f13552J));
        }
        if (this.f13551I) {
            this.f13548F.setText(getString(R$string.connect_string_colon, getString(R$string.latest_backup_record), DateUtils.formatDateTime(this, this.f13552J.getBackupEndTime(), C11842p.m70824j())));
        } else {
            this.f13548F.setText(DateUtils.formatDateTime(this, this.f13552J.getBackupEndTime(), C11842p.m70824j()));
        }
        this.f13549G.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f13549G.setNestedScrollingEnabled(false);
        List<CloudRestoreItem> itemList = this.f13552J.getItemList();
        itemList.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BackupCleanRecordsDetailActivity.m18611l2((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
            }
        });
        C0113d c0113d = new C0113d(this, itemList);
        this.f13554L = c0113d;
        this.f13549G.setAdapter(c0113d);
        this.f13554L.m761K(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17581a.m18623m2(view);
            }
        });
        CloudRestoreItem cloudRestoreItemM18619h2 = m18619h2();
        this.f13553K = cloudRestoreItemM18619h2;
        if (cloudRestoreItemM18619h2 != null) {
            this.f13554L.m759I(true);
            this.f13550H.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.f13550H.setNestedScrollingEnabled(false);
            List<CloudRestoreItem> listM29202r = this.f13553K.m29202r();
            listM29202r.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.e
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return BackupCleanRecordsDetailActivity.m18612n2((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                }
            });
            C0113d c0113d2 = new C0113d(this, listM29202r);
            this.f13555M = c0113d2;
            this.f13550H.setAdapter(c0113d2);
        }
        m18616e2();
        C12515a.m75110o().m75172d(new C3127c());
    }
}
