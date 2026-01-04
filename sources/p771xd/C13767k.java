package p771xd;

import android.content.Intent;
import com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler;
import com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity;
import p514o9.C11839m;

/* renamed from: xd.k */
/* loaded from: classes3.dex */
public class C13767k implements IActivityResultHandler<OOBECloudBackupRecordsActivity> {
    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler
    /* renamed from: d */
    public void mo17027c(OOBECloudBackupRecordsActivity oOBECloudBackupRecordsActivity, Intent intent) {
        C11839m.m70688i("HwidRequestHandler", "onActivityResultCancel");
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler
    /* renamed from: e */
    public void mo17026b(OOBECloudBackupRecordsActivity oOBECloudBackupRecordsActivity, int i10, Intent intent) {
        C11839m.m70688i("HwidRequestHandler", "onActivityResultCustom resultCode = " + i10);
        if (3 == i10) {
            oOBECloudBackupRecordsActivity.setResult(3);
            oOBECloudBackupRecordsActivity.finish();
            return;
        }
        if (702 == i10) {
            oOBECloudBackupRecordsActivity.setResult(702);
            oOBECloudBackupRecordsActivity.finish();
        } else if (703 == i10) {
            oOBECloudBackupRecordsActivity.setResult(0);
            oOBECloudBackupRecordsActivity.finish();
        } else if (4 == i10) {
            oOBECloudBackupRecordsActivity.setResult(4, intent);
            oOBECloudBackupRecordsActivity.finish();
        } else {
            oOBECloudBackupRecordsActivity.setResult(i10);
            oOBECloudBackupRecordsActivity.finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler
    /* renamed from: f */
    public void mo17025a(OOBECloudBackupRecordsActivity oOBECloudBackupRecordsActivity, Intent intent) {
        C11839m.m70688i("HwidRequestHandler", "onActivityResultOk oobe login successful");
        C11839m.m70688i("HwidRequestHandler", " get the config success");
        oOBECloudBackupRecordsActivity.m21730s2();
    }
}
