package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import p426kd.AsyncTaskC11038l;
import p516ob.C11845a;

/* loaded from: classes3.dex */
public class CloudDiskRecordingActivity extends CloudDiskOperateBaseActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: d2 */
    public String mo19678d2(ModuleItem moduleItem) {
        return moduleItem.getDeviceIdMD5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: e2 */
    public List<ModuleItem> mo19679e2() {
        return C11845a.m70927n("recordig");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: f2 */
    public List<CBSDevice> mo19680f2() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
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
            if (r0 == r1) goto L92
            r1 = 1016(0x3f8, float:1.424E-42)
            if (r0 == r1) goto L24
            r1 = 1023(0x3ff, float:1.434E-42)
            if (r0 == r1) goto L19
            r1 = 99813(0x185e5, float:1.39868E-40)
            if (r0 == r1) goto L92
            boolean r3 = super.mo19681g2(r4)
            return r3
        L19:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto L99
            r3.m19731W1(r4)
            goto L99
        L24:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto L99
            int r4 = r4.arg1
            r0 = -1
            if (r4 != r0) goto L3d
            int r4 = com.huawei.android.sync.R$string.module_download_fail
            java.lang.String r4 = r3.getString(r4)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
            goto L8a
        L3d:
            r0 = 2
            if (r4 != r0) goto L58
            int r4 = com.huawei.android.sync.R$string.data_download_notAllSucccess_alert
            int r0 = com.huawei.android.sync.R$string.recovering_recorder
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
            goto L8a
        L58:
            if (r4 != 0) goto L7a
            java.lang.String r4 = "CloudDiskRecordingActivity"
            java.lang.String r0 = "CloudDiskModuleRst SUCCESS"
            p514o9.C11839m.m70686d(r4, r0)
            int r4 = com.huawei.android.sync.R$string.data_download_done_short
            int r0 = com.huawei.android.sync.R$string.recorder_app_name
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            r0 = 1
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r0)
            r4.show()
            goto L8a
        L7a:
            r0 = 3
            if (r4 != r0) goto L8a
            int r4 = com.huawei.android.sync.R$string.cloudbackup_report_cancel
            java.lang.String r4 = r3.getString(r4)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
        L8a:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto L99
            r3.notifyDataSetChanged()
            goto L99
        L92:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto L99
            r3.notifyDataSetChanged()
        L99:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudDiskRecordingActivity.mo19681g2(android.os.Message):boolean");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: i2 */
    public boolean mo19682i2() {
        return AsyncTask.Status.RUNNING.equals(AsyncTaskC11038l.m66556b(getApplicationContext(), this.f14281u).getStatus());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: k2 */
    public void mo19683k2() {
        this.f14282v = "autorecordingkey";
        this.f14278r = this;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m22365E1(R$string.cloudbackup_back_item_record);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        AsyncTaskC11038l.m66556b(getApplicationContext(), null);
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
        AsyncTaskC11038l asyncTaskC11038lM66556b = AsyncTaskC11038l.m66556b(getApplicationContext(), this.f14281u);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC11038lM66556b.getStatus())) {
            return;
        }
        asyncTaskC11038lM66556b.execute(new Void[0]);
    }
}
