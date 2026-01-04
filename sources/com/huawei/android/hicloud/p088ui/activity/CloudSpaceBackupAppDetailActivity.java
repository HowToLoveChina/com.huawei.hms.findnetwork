package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.AlertDialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloudSpaceDeleteModuleDialog;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11829c;
import p514o9.C11839m;
import p618rm.C12580p;
import p783xp.C13843a;
import p814yl.C13998b0;
import p847zk.C14329v;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceBackupAppDetailActivity extends CloudSpaceBackupBaseActivity implements AdapterView.OnItemClickListener, BackupSpaceDetailAdapter.DeleteBackupModuleListener, BackupSpaceDetailAdapter.CheckBoxChangedListener, SearchView.OnQueryTextListener, AlertDialogCallback {

    /* renamed from: S0 */
    public ListView f14436S0;

    /* renamed from: T0 */
    public HwProgressBar f14437T0;

    /* renamed from: U0 */
    public NotchTopFitRelativeLayout f14438U0;

    /* renamed from: V0 */
    public NotchFitLinearLayout f14439V0;

    /* renamed from: W0 */
    public BackupSpaceDetailAdapter f14440W0;

    /* renamed from: X0 */
    public SearchView f14441X0;

    /* renamed from: Z0 */
    public TextView f14443Z0;

    /* renamed from: a1 */
    public TextView f14444a1;

    /* renamed from: b1 */
    public TextView f14445b1;

    /* renamed from: c1 */
    public AutoSizeButton f14446c1;

    /* renamed from: d1 */
    public CloudSpaceDeleteModuleDialog f14447d1;

    /* renamed from: e1 */
    public LinearLayout f14448e1;

    /* renamed from: f1 */
    public String f14449f1;

    /* renamed from: g1 */
    public long f14450g1;

    /* renamed from: h1 */
    public int f14451h1;

    /* renamed from: Y0 */
    public final List<AppDetailsInfo> f14442Y0 = new ArrayList();

    /* renamed from: i1 */
    public List<String> f14452i1 = new ArrayList();

    /* renamed from: j1 */
    public Handler.Callback f14453j1 = new C3239a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupAppDetailActivity$a */
    public class C3239a implements Handler.Callback {
        public C3239a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Bundle data;
            AppDetailsInfo appDetailsInfo;
            switch (message.what) {
                case 33001:
                    String str = (String) message.obj;
                    if (CloudSpaceBackupAppDetailActivity.this.f14440W0 != null) {
                        CloudSpaceBackupAppDetailActivity.this.f14440W0.m24832s(CloudSpaceBackupAppDetailActivity.this.f14436S0, str, false);
                    }
                    return false;
                case 33042:
                    if (message.arg1 == 0) {
                        CloudSpaceBackupAppDetailActivity.this.f14450g1 = 0L;
                        CloudSpaceBackupAppDetailActivity.this.m20016h3();
                    } else {
                        CloudSpaceBackupAppDetailActivity.this.m20015g3();
                    }
                    return false;
                case 34333:
                    try {
                        data = message.getData();
                    } catch (Exception e10) {
                        C11839m.m70686d("CloudSpaceBackupAppDetailActivity", "handle msg item is error:" + e10.toString());
                    }
                    if (data == null || (appDetailsInfo = (AppDetailsInfo) data.getSerializable("AppDetailsInfo")) == null) {
                        return false;
                    }
                    C11839m.m70686d("CloudSpaceBackupAppDetailActivity", "handle msg item is:" + appDetailsInfo.toString());
                    if (CloudSpaceBackupAppDetailActivity.this.f14440W0 != null) {
                        CloudSpaceBackupAppDetailActivity.this.f14440W0.m24833t(CloudSpaceBackupAppDetailActivity.this.f14436S0, appDetailsInfo);
                    }
                    return false;
                case 34334:
                    CloudSpaceBackupAppDetailActivity.this.m20014f3(message.arg1);
                    return false;
                default:
                    return false;
            }
        }
    }

    /* renamed from: g2 */
    private void m20008g2() {
        this.f14438U0 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14439V0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.record_detail_list);
        ListView listView = (ListView) C12809f.m76829b(this, R$id.record_sys_list);
        this.f14436S0 = listView;
        listView.setOnItemClickListener(this);
        this.f14437T0 = (HwProgressBar) C12809f.m76829b(this, R$id.device_title_progress);
        this.f14441X0 = (SearchView) C12809f.m76829b(this, R$id.searchview);
        this.f14446c1 = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_backup_btn);
        this.f14445b1 = (TextView) C12809f.m76829b(this, R$id.app_not_exist);
        this.f14448e1 = (LinearLayout) C12809f.m76829b(this, R$id.title_layout);
        this.f16192J0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        if (!C0209d.m1333z1(this)) {
            this.f16192J0.m23919i();
        }
        this.f14446c1.setOnClickListener(this);
        this.f14446c1.setVisibility(8);
        this.f14446c1.setEnabled(false);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.device_complete);
        this.f14444a1 = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.device_manage);
        this.f14443Z0 = textView2;
        textView2.setOnClickListener(this);
    }

    /* renamed from: i3 */
    private void m20009i3() {
        this.f14455N0 = new C13998b0();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        try {
            this.f14449f1 = hiCloudSafeIntent.getStringExtra("deviceId");
            this.f14459R0 = hiCloudSafeIntent.getBooleanExtra("isSupportsClose", false);
            this.f14451h1 = hiCloudSafeIntent.getIntExtra("backup_delete_report_entry", 0);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceBackupAppDetailActivity", "getIntent error : " + e10.toString());
        }
        BackupSpaceDetailAdapter backupSpaceDetailAdapter = new BackupSpaceDetailAdapter(this, this, true);
        this.f14440W0 = backupSpaceDetailAdapter;
        backupSpaceDetailAdapter.m24828o(this);
        this.f14440W0.m24827n(this);
        this.f14440W0.m24815b(C14329v.m85349e0().m85423b0());
        this.f14440W0.notifyDataSetChanged();
        C14329v.m85349e0().m85399P();
        this.f14440W0.m24829p(false);
        this.f14436S0.setAdapter((ListAdapter) this.f14440W0);
        this.f14441X0.setOnQueryTextListener(this);
    }

    /* renamed from: o3 */
    private void m20012o3(String str) {
        List<AppDetailsInfo> listM85423b0 = C14329v.m85349e0().m85423b0();
        if (str.isEmpty()) {
            this.f14442Y0.clear();
            this.f14445b1.setVisibility(8);
            this.f14448e1.setVisibility(0);
            if (this.f14440W0.m24819f()) {
                Iterator<AppDetailsInfo> it = listM85423b0.iterator();
                while (it.hasNext()) {
                    it.next().setUiStyle(1);
                }
            } else {
                Iterator<AppDetailsInfo> it2 = listM85423b0.iterator();
                while (it2.hasNext()) {
                    it2.next().setUiStyle(0);
                }
            }
            listM85423b0.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.h4
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75576j((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
                }
            });
            this.f14440W0.m24818e().clear();
            this.f14440W0.m24818e().addAll(listM85423b0);
        } else {
            this.f14442Y0.clear();
            for (AppDetailsInfo appDetailsInfo : listM85423b0) {
                String str2 = appDetailsInfo.getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME);
                Locale locale = Locale.ENGLISH;
                if (str2.toLowerCase(locale).contains(str.toLowerCase(locale))) {
                    this.f14442Y0.add(appDetailsInfo);
                }
            }
            if (this.f14442Y0.size() == 0) {
                this.f14445b1.setVisibility(0);
                this.f14448e1.setVisibility(8);
            } else {
                this.f14445b1.setVisibility(8);
                this.f14448e1.setVisibility(0);
            }
            this.f14442Y0.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.i4
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75576j((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
                }
            });
            this.f14440W0.m24818e().clear();
            this.f14440W0.m24818e().addAll(this.f14442Y0);
        }
        this.f14436S0.setAdapter((ListAdapter) this.f14440W0);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter.DeleteBackupModuleListener
    /* renamed from: K */
    public void mo20013K(int i10, String str) {
        if (!C0209d.m1333z1(this)) {
            C11829c.m70612r1(this);
            return;
        }
        m20022T2();
        String str2 = this.f14440W0.m24818e().get(i10).getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME);
        CloudSpaceDeleteModuleDialog cloudSpaceDeleteModuleDialog = new CloudSpaceDeleteModuleDialog(this, this, 0, this.f14459R0, false);
        this.f14447d1 = cloudSpaceDeleteModuleDialog;
        cloudSpaceDeleteModuleDialog.setPosition(i10);
        this.f14447d1.setCurrentAppId(str);
        this.f14447d1.show(getString(this.f14459R0 ? R$string.dialog_single_module_delete_and_close_tips : R$string.dialog_single_module_delete_tips, str2), getString(R$string.dialog_close_backup_switch_tips, str2));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14438U0);
        arrayList.add(this.f16192J0);
        arrayList.add(this.f14439V0);
        arrayList.add(this.f14441X0);
        return arrayList;
    }

    /* renamed from: f3 */
    public final void m20014f3(int i10) {
        if (i10 == 1 || i10 == 2) {
            this.f14437T0.setVisibility(8);
        }
    }

    /* renamed from: g3 */
    public final void m20015g3() {
        boolean zM24819f = this.f14440W0.m24819f();
        for (AppDetailsInfo appDetailsInfo : this.f14440W0.m24818e()) {
            if (appDetailsInfo.isCheck()) {
                if (zM24819f) {
                    appDetailsInfo.setUiStyle(1);
                } else {
                    appDetailsInfo.setUiStyle(0);
                }
            }
        }
        this.f14440W0.notifyDataSetChanged();
        m20017l3(false);
    }

    /* renamed from: h3 */
    public final void m20016h3() {
        this.f14452i1.clear();
        m20017l3(true);
        List<AppDetailsInfo> listM85423b0 = C14329v.m85349e0().m85423b0();
        this.f14440W0.m24815b(listM85423b0);
        if (listM85423b0.size() <= 0) {
            m20018m3();
        } else if (this.f14440W0.getCount() == 0) {
            this.f14445b1.setVisibility(0);
            this.f14448e1.setVisibility(8);
        } else {
            this.f14445b1.setVisibility(8);
            this.f14448e1.setVisibility(0);
        }
    }

    /* renamed from: l3 */
    public final void m20017l3(boolean z10) {
        AutoSizeButton autoSizeButton = this.f14446c1;
        if (autoSizeButton == null) {
            return;
        }
        if (z10) {
            autoSizeButton.setEnabled(false);
            this.f14446c1.setText(getString(R$string.delete_backup));
            return;
        }
        autoSizeButton.setEnabled(true);
        long j10 = this.f14450g1;
        if (j10 <= 0) {
            this.f14446c1.setText(getString(this.f14459R0 ? R$string.delete_backup_and_close_multiple_choice : R$string.delete_backup));
        } else {
            this.f14446c1.setText(getString(this.f14459R0 ? R$string.delete_backup_and_close_multiple_choice_size : R$string.delete_backup_multiple_choice, C0223k.m1524g(this, j10)));
        }
    }

    /* renamed from: m3 */
    public final void m20018m3() {
        setResult(0, new Intent());
        finish();
    }

    /* renamed from: n3 */
    public final void m20019n3(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14436S0.getLayoutParams();
        layoutParams.bottomMargin = i10;
        this.f14436S0.setLayoutParams(layoutParams);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m20018m3();
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        m20022T2();
        int id2 = view.getId();
        if (id2 == R$id.device_manage) {
            this.f14443Z0.setVisibility(8);
            this.f14444a1.setVisibility(0);
            this.f14446c1.setVisibility(0);
            this.f14440W0.m24829p(true);
            this.f14436S0.setAdapter((ListAdapter) this.f14440W0);
            this.f14452i1.clear();
            long j10 = this.f14450g1;
            if (j10 > 0) {
                this.f14446c1.setText(getString(this.f14459R0 ? R$string.delete_backup_and_close_multiple_choice_size : R$string.delete_backup_multiple_choice, C0223k.m1524g(this, j10)));
            } else {
                this.f14446c1.setText(getString(this.f14459R0 ? R$string.delete_backup_and_close_multiple_choice : R$string.delete_backup));
                this.f14446c1.setEnabled(false);
            }
            m20019n3(getResources().getDimensionPixelSize(R$dimen.cloud_space_92_dp));
            return;
        }
        if (id2 != R$id.device_complete) {
            if (id2 == R$id.delete_backup_btn) {
                if (!C0209d.m1333z1(this)) {
                    C11829c.m70612r1(this);
                    return;
                }
                CloudSpaceDeleteModuleDialog cloudSpaceDeleteModuleDialog = new CloudSpaceDeleteModuleDialog(this, this, 1, this.f14459R0, false);
                this.f14447d1 = cloudSpaceDeleteModuleDialog;
                cloudSpaceDeleteModuleDialog.show(getString(this.f14459R0 ? R$string.dialog_multiple_choice_delete_and_close_tips : R$string.dialog_multiple_choice_delete_tips), getString(R$string.dialog_multiple_choice_close_switch_tips));
                return;
            }
            return;
        }
        this.f14452i1.clear();
        for (AppDetailsInfo appDetailsInfo : this.f14440W0.m24818e()) {
            if (appDetailsInfo.isCheck()) {
                this.f14450g1 -= appDetailsInfo.getTotalSize();
            }
        }
        this.f14444a1.setVisibility(8);
        this.f14443Z0.setVisibility(0);
        this.f14446c1.setVisibility(8);
        this.f14440W0.m24829p(false);
        this.f14440W0.notifyDataSetChanged();
        m20019n3(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.AlertDialogCallback
    public void onClickNegative(int i10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.AlertDialogCallback
    public void onClickPositive(String str, boolean z10) {
        if (!C0209d.m1333z1(this)) {
            C11829c.m70612r1(this);
            return;
        }
        int iM24820g = this.f14440W0.m24820g(str);
        if (iM24820g >= this.f14440W0.m24818e().size()) {
            return;
        }
        if (this.f14447d1.getDialogType() == 0) {
            this.f14440W0.m24818e().get(iM24820g).setCheck(true);
            this.f14452i1.clear();
            this.f14452i1.add(str);
        } else {
            this.f14446c1.setEnabled(false);
        }
        ArrayList arrayList = new ArrayList(this.f14452i1);
        Iterator<String> it = this.f14452i1.iterator();
        long totalSize = 0;
        while (it.hasNext()) {
            int iM24820g2 = this.f14440W0.m24820g(it.next());
            if (iM24820g2 < this.f14440W0.m24818e().size()) {
                totalSize += this.f14440W0.getItem(iM24820g2).getTotalSize();
            }
        }
        C14329v.m85349e0().m85415X(arrayList, this.f14459R0, this.f14449f1, totalSize, this.f14451h1, 0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.cloud_space_backup_app_detail);
        m22365E1(R$string.frag_app_data_title);
        mo19982C1();
        C11839m.m70688i("CloudSpaceBackupAppDetailActivity", "activity created");
        m20008g2();
        mo19005p1();
        m20009i3();
        CBCallBack.getInstance().registerCallback(this.f14453j1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CBCallBack.getInstance().unregisterCallback(this.f14453j1);
        Iterator<AppDetailsInfo> it = C14329v.m85349e0().m85423b0().iterator();
        while (it.hasNext()) {
            it.next().setCheck(false);
        }
        CloudSpaceDeleteModuleDialog cloudSpaceDeleteModuleDialog = this.f14447d1;
        if (cloudSpaceDeleteModuleDialog != null) {
            cloudSpaceDeleteModuleDialog.dismiss();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        AppDetailsInfo item;
        BackupSpaceDetailAdapter backupSpaceDetailAdapter = this.f14440W0;
        if (backupSpaceDetailAdapter == null || !backupSpaceDetailAdapter.m24819f() || (item = this.f14440W0.getItem(i10)) == null) {
            return;
        }
        String backupAppName = item.getBackupAppName();
        boolean zIsCheck = item.isCheck();
        item.setCheck(!zIsCheck);
        if (zIsCheck) {
            this.f14450g1 -= item.getTotalSize();
        } else {
            this.f14450g1 += item.getTotalSize();
        }
        if (item.isCheck()) {
            this.f14452i1.add(backupAppName);
        } else {
            this.f14452i1.remove(backupAppName);
        }
        this.f14446c1.setEnabled(this.f14452i1.size() > 0);
        long j11 = this.f14450g1;
        if (j11 > 0) {
            this.f14446c1.setText(getString(this.f14459R0 ? R$string.delete_backup_and_close_multiple_choice_size : R$string.delete_backup_multiple_choice, C0223k.m1524g(this, j11)));
        } else {
            this.f14446c1.setText(getString(this.f14459R0 ? R$string.delete_backup_and_close_multiple_choice : R$string.delete_backup));
        }
        this.f14440W0.notifyDataSetChanged();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m20018m3();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        m20012o3(str);
        return false;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        m20012o3(str);
        return false;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter.DeleteBackupModuleListener
    /* renamed from: r0 */
    public void mo20020r0(int i10, String str) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m20018m3();
        return true;
    }
}
