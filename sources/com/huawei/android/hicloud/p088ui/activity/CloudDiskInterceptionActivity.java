package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import p015ak.C0209d;
import p426kd.AsyncTaskC11036j;
import p516ob.C11845a;

/* loaded from: classes3.dex */
public class CloudDiskInterceptionActivity extends CloudDiskOperateBaseActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: d2 */
    public String mo19678d2(ModuleItem moduleItem) {
        return moduleItem.getDeviceIdMD5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: e2 */
    public List<ModuleItem> mo19679e2() {
        return C11845a.m70927n("phonemanager");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: f2 */
    public List<CBSDevice> mo19680f2() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: g2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo19681g2(android.os.Message r4) {
        /*
            r3 = this;
            int r0 = r4.what
            r1 = 1011(0x3f3, float:1.417E-42)
            r2 = 0
            if (r0 == r1) goto La8
            r1 = 1012(0x3f4, float:1.418E-42)
            if (r0 == r1) goto La8
            r1 = 1017(0x3f9, float:1.425E-42)
            if (r0 == r1) goto L27
            r1 = 1024(0x400, float:1.435E-42)
            if (r0 == r1) goto L1c
            r1 = 1110(0x456, float:1.555E-42)
            if (r0 == r1) goto La8
            boolean r3 = super.mo19681g2(r4)
            return r3
        L1c:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto Laf
            r3.m19731W1(r4)
            goto Laf
        L27:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto Laf
            int r4 = r4.arg1
            r0 = -1
            if (r4 != r0) goto L40
            int r4 = com.huawei.android.sync.R$string.module_download_fail
            java.lang.String r4 = r3.getString(r4)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
            goto La0
        L40:
            r0 = 2
            if (r4 != r0) goto L5b
            int r4 = com.huawei.android.sync.R$string.data_download_notAllSucccess_alert
            int r0 = com.huawei.android.sync.R$string.cloudbackup_app_phonemanager_desc
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
            goto La0
        L5b:
            if (r4 != 0) goto L86
            java.lang.String r4 = "CloudDiskInterceptionActivity"
            java.lang.String r0 = "CloudDiskModuleRst SUCCESS"
            p514o9.C11839m.m70686d(r4, r0)
            boolean r4 = p514o9.C11842p.m70762R0()
            if (r4 == 0) goto L6d
            int r4 = com.huawei.android.sync.R$string.cloudbackup_app_tabletmanager_desc
            goto L6f
        L6d:
            int r4 = com.huawei.android.sync.R$string.cloudbackup_app_phonemanager_desc
        L6f:
            int r0 = com.huawei.android.sync.R$string.data_download_done_short
            java.lang.String r4 = r3.getString(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r4 = r3.getString(r0, r4)
            r0 = 1
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r0)
            r4.show()
            goto La0
        L86:
            r0 = 3
            if (r4 != r0) goto La0
            int r4 = com.huawei.android.sync.R$string.cloudbackup_report_cancel
            int r0 = com.huawei.android.sync.R$string.cloudbackup_app_phonemanager_desc
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
        La0:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto Laf
            r3.notifyDataSetChanged()
            goto Laf
        La8:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto Laf
            r3.notifyDataSetChanged()
        Laf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudDiskInterceptionActivity.mo19681g2(android.os.Message):boolean");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: i2 */
    public boolean mo19682i2() {
        return AsyncTask.Status.RUNNING.equals(AsyncTaskC11036j.m66538d(getApplicationContext(), this.f14281u).getStatus());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: k2 */
    public void mo19683k2() {
        this.f14282v = "autophonemanagerkey";
        this.f14278r = this;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C0209d.m1166E1()) {
            finish();
        }
        m22365E1(R$string.cloudbackup_back_item_phonemanager);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        AsyncTaskC11036j.m66538d(getApplicationContext(), null);
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        this.f14279s.m69597n(this.f14281u, 2);
        super.onResume();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: v2 */
    public void mo19684v2(boolean z10, boolean z11) {
        AsyncTaskC11036j asyncTaskC11036jM66538d = AsyncTaskC11036j.m66538d(getApplicationContext(), this.f14281u);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC11036jM66538d.getStatus())) {
            return;
        }
        asyncTaskC11036jM66538d.execute(new Void[0]);
    }
}
