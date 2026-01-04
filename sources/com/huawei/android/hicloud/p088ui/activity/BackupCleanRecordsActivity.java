package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupCleanRecordsAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupCleanRecordsActivity extends UIActivity {

    /* renamed from: v */
    public static final String f13537v = "BackupCleanRecordsActivity";

    /* renamed from: p */
    public RecyclerView f13538p;

    /* renamed from: q */
    public NotchTopFitRelativeLayout f13539q;

    /* renamed from: r */
    public NotchFitLinearLayout f13540r;

    /* renamed from: s */
    public LinearLayout f13541s;

    /* renamed from: t */
    public BackupCleanRecordsAdapter f13542t;

    /* renamed from: u */
    public List<CloudBackupDeviceInfo> f13543u;

    /* renamed from: L1 */
    private void m18597L1() {
        this.f13538p.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f13538p.addItemDecoration(new BackupCleanRecordsAdapter.C4014a(C11842p.m70840n(this, 12)));
        this.f13538p.setNestedScrollingEnabled(false);
        BackupCleanRecordsAdapter backupCleanRecordsAdapter = new BackupCleanRecordsAdapter(this);
        this.f13542t = backupCleanRecordsAdapter;
        this.f13538p.setAdapter(backupCleanRecordsAdapter);
    }

    /* renamed from: M1 */
    private void m18598M1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.backup_clean_records);
        }
        mo19982C1();
        this.f13539q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.clean_records_root_layout);
        this.f13540r = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.clean_records_layout);
        this.f13538p = (RecyclerView) C12809f.m76829b(this, R$id.rv_backup_records);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.layout_empty);
        this.f13541s = linearLayout;
        C11842p.m70760Q1(this, linearLayout);
        mo19005p1();
    }

    /* renamed from: N1 */
    public final void m18599N1() {
        C13225d.m79490f1().m79585f0("mecloud_smart_clear_backup_records", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_smart_clear_backup_records", "1", "80");
    }

    /* renamed from: O1 */
    public final void m18600O1(CopyOnWriteArrayList<CloudBackupDeviceInfo> copyOnWriteArrayList) {
        List<CloudBackupDeviceInfo> list = this.f13543u;
        if (list == null) {
            this.f13543u = new ArrayList();
        } else {
            list.clear();
        }
        this.f13543u.addAll(copyOnWriteArrayList);
        BackupCleanRecordsAdapter backupCleanRecordsAdapter = this.f13542t;
        if (backupCleanRecordsAdapter != null) {
            backupCleanRecordsAdapter.m24692F(this.f13543u);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13539q);
        arrayList.add(this.f13540r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70760Q1(this, this.f13541s);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C11839m.m70688i(f13537v, "onCreate");
        setContentView(R$layout.activity_backup_clean_records);
        m18598M1();
        m18597L1();
        m18599N1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (BackupCleanRecordsManager.getInstance().getCleanRecordsNum() == 0) {
            this.f13541s.setVisibility(0);
            this.f13540r.setVisibility(8);
        } else {
            this.f13541s.setVisibility(8);
            this.f13540r.setVisibility(0);
            m18600O1(BackupCleanRecordsManager.getInstance().getAllBackupRecords());
        }
    }
}
