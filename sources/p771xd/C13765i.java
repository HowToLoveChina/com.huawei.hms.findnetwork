package p771xd;

import android.content.Intent;
import com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler;
import com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity;
import p514o9.C11839m;

/* renamed from: xd.i */
/* loaded from: classes3.dex */
public class C13765i implements IActivityResultHandler<OOBECloudBackupRecordsActivity> {
    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler
    /* renamed from: d */
    public void mo17027c(OOBECloudBackupRecordsActivity oOBECloudBackupRecordsActivity, Intent intent) {
        C11839m.m70688i("HwidRequestHandler", "onActivityResultCancel");
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler
    /* renamed from: e */
    public void mo17026b(OOBECloudBackupRecordsActivity oOBECloudBackupRecordsActivity, int i10, Intent intent) {
        C11839m.m70688i("HwidRequestHandler", "onActivityResultCustom resultCode = " + i10);
        if (1001 == i10) {
            C11839m.m70688i("HwidRequestHandler", "BACKUP_RECOVERY_SUCCESS");
            oOBECloudBackupRecordsActivity.setResult(1001);
            oOBECloudBackupRecordsActivity.finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler
    /* renamed from: f */
    public void mo17025a(OOBECloudBackupRecordsActivity oOBECloudBackupRecordsActivity, Intent intent) {
        C11839m.m70688i("HwidRequestHandler", "OOBE_RECOVERING RESULT_OK");
        oOBECloudBackupRecordsActivity.setResult(-1);
        oOBECloudBackupRecordsActivity.finish();
    }
}
