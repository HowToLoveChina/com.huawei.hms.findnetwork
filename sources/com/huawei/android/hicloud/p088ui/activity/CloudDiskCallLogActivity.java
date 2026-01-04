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
import p426kd.AsyncTaskC11034h;
import p516ob.C11845a;

/* loaded from: classes3.dex */
public class CloudDiskCallLogActivity extends CloudDiskOperateBaseActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: d2 */
    public String mo19678d2(ModuleItem moduleItem) {
        return moduleItem.getDeviceID();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: e2 */
    public List<ModuleItem> mo19679e2() {
        return C11845a.m70927n("calllog");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: f2 */
    public List<CBSDevice> mo19680f2() {
        return C11845a.m70928o("calllog");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
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
            if (r0 == r1) goto L9b
            r1 = 1014(0x3f6, float:1.421E-42)
            if (r0 == r1) goto L23
            r1 = 1021(0x3fd, float:1.431E-42)
            if (r0 == r1) goto L18
            r1 = 1103(0x44f, float:1.546E-42)
            if (r0 == r1) goto L9b
            boolean r3 = super.mo19681g2(r4)
            return r3
        L18:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto La2
            r3.m19731W1(r4)
            goto La2
        L23:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto La2
            int r4 = r4.arg1
            r0 = -1
            if (r4 != r0) goto L3c
            int r4 = com.huawei.android.sync.R$string.module_download_fail
            java.lang.String r4 = r3.getString(r4)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
            goto L93
        L3c:
            r0 = 2
            if (r4 != r0) goto L57
            int r4 = com.huawei.android.sync.R$string.data_download_notAllSucccess_alert
            int r0 = com.huawei.android.sync.R$string.cloudbackup_Calllog
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
            goto L93
        L57:
            if (r4 != 0) goto L79
            java.lang.String r4 = "CloudDiskCallLogActivity"
            java.lang.String r0 = "CloudDiskModuleRst SUCCESS"
            p514o9.C11839m.m70686d(r4, r0)
            int r4 = com.huawei.android.sync.R$string.data_download_done_short
            int r0 = com.huawei.android.sync.R$string.dialer_app_name
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            r0 = 1
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r0)
            r4.show()
            goto L93
        L79:
            r0 = 3
            if (r4 != r0) goto L93
            int r4 = com.huawei.android.sync.R$string.cloudbackup_report_cancel
            int r0 = com.huawei.android.sync.R$string.cloudbackup_Calllog
            java.lang.String r0 = r3.getString(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r4 = r3.getString(r4, r0)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
        L93:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto La2
            r3.notifyDataSetChanged()
            goto La2
        L9b:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto La2
            r3.notifyDataSetChanged()
        La2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudDiskCallLogActivity.mo19681g2(android.os.Message):boolean");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: i2 */
    public boolean mo19682i2() {
        return AsyncTask.Status.RUNNING.equals(AsyncTaskC11034h.m66524c(getApplicationContext(), this.f14281u).getStatus());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: k2 */
    public void mo19683k2() {
        this.f14282v = "autocallloglistkey";
        this.f14278r = this;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!C0209d.m1166E1()) {
            finish();
        }
        super.onCreate(bundle);
        m22365E1(R$string.cloudbackup_Calllog);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        AsyncTaskC11034h.m66524c(getApplicationContext(), null);
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
        AsyncTaskC11034h asyncTaskC11034hM66524c = AsyncTaskC11034h.m66524c(getApplicationContext(), this.f14281u);
        asyncTaskC11034hM66524c.m66530g(z10);
        asyncTaskC11034hM66524c.m66529f(z11);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC11034hM66524c.getStatus())) {
            return;
        }
        asyncTaskC11034hM66524c.execute(new Void[0]);
    }
}
