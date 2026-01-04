package com.huawei.android.hicloud.p088ui.activity;

import ae.C0156p0;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import p426kd.AsyncTaskC11037k;
import p514o9.C11839m;
import p516ob.C11845a;

/* loaded from: classes3.dex */
public class CloudDiskNotepadActivity extends CloudDiskOperateBaseActivity {
    /* renamed from: T2 */
    public final void m19698T2(Message message) {
        if (isFinishing()) {
            return;
        }
        int i10 = message.arg1;
        if (i10 == -1) {
            if ("version_not_cpt".equals(((CloudDiskModuleRst) message.obj).getFailReason())) {
                Toast.makeText(this, getString(R$string.data_structure_not_cmt), 0).show();
            } else {
                Toast.makeText(this, getString(R$string.module_download_fail), 0).show();
            }
        } else if (i10 == 2) {
            Toast.makeText(this, getString(R$string.data_download_notAllSucccess_alert, getString(R$string.cloudbackup_back_item_notepad)), 0).show();
        } else if (i10 == 0) {
            C11839m.m70686d("CloudDiskNotepadActivity", "CloudDiskModuleRst SUCCESS");
            Toast.makeText(this, getString(R$string.data_download_done_short, getString(R$string.notepad_app_name)), 1).show();
        } else if (i10 == 3) {
            Toast.makeText(this, getString(R$string.cloudbackup_report_cancel, getString(R$string.cloudbackup_back_item_notepad)), 0).show();
        }
        C0156p0 c0156p0 = this.f14269Y;
        if (c0156p0 != null) {
            c0156p0.notifyDataSetChanged();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: d2 */
    public String mo19678d2(ModuleItem moduleItem) {
        return moduleItem.getDeviceIdMD5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: e2 */
    public List<ModuleItem> mo19679e2() {
        return C11845a.m70927n("notepad");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: f2 */
    public List<CBSDevice> mo19680f2() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
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
            if (r0 == r1) goto L50
            r1 = 1012(0x3f4, float:1.418E-42)
            if (r0 == r1) goto L50
            r1 = 1015(0x3f7, float:1.422E-42)
            if (r0 == r1) goto L4c
            r1 = 1018(0x3fa, float:1.427E-42)
            if (r0 == r1) goto L2a
            r1 = 1022(0x3fe, float:1.432E-42)
            if (r0 == r1) goto L20
            r1 = 1108(0x454, float:1.553E-42)
            if (r0 == r1) goto L50
            boolean r3 = super.mo19681g2(r4)
            return r3
        L20:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto L57
            r3.m19731W1(r4)
            goto L57
        L2a:
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto L57
            java.lang.Object r4 = r4.obj
            com.huawei.hicloud.base.bean.CloudDiskModuleRst r4 = (com.huawei.hicloud.base.bean.CloudDiskModuleRst) r4
            int r4 = r4.getRetCode()
            r0 = -1
            if (r4 != r0) goto L48
            int r4 = com.huawei.android.sync.R$string.notepad_merge_failed
            java.lang.String r4 = r3.getString(r4)
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r2)
            r4.show()
        L48:
            r3.m19708D2()
            goto L57
        L4c:
            r3.m19698T2(r4)
            goto L57
        L50:
            ae.p0 r3 = r3.f14269Y
            if (r3 == 0) goto L57
            r3.notifyDataSetChanged()
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudDiskNotepadActivity.mo19681g2(android.os.Message):boolean");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: i2 */
    public boolean mo19682i2() {
        return AsyncTask.Status.RUNNING.equals(AsyncTaskC11037k.m66546f(getApplicationContext(), this.f14281u).getStatus());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity
    /* renamed from: k2 */
    public void mo19683k2() {
        this.f14282v = "notepad";
        this.f14278r = this;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m22365E1(R$string.cloudbackup_back_item_notepad);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        AsyncTaskC11037k.m66546f(getApplicationContext(), null);
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
        AsyncTaskC11037k asyncTaskC11037kM66546f = AsyncTaskC11037k.m66546f(getApplicationContext(), this.f14281u);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC11037kM66546f.getStatus())) {
            return;
        }
        asyncTaskC11037kM66546f.execute(new Void[0]);
    }
}
