package al;

import cl.InterfaceC1454i;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import fk.C9721b;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: al.b */
/* loaded from: classes6.dex */
public abstract class AbstractC0243b implements InterfaceC1454i {
    private static final String TAG = "BaseAppRestoreStatusHelper";

    private void updateInstallVersion(int i10, long j10) {
        if (i10 == 0) {
            getReportInfo().setAgdDownloadVersion(String.valueOf(j10));
        } else if (1 == i10) {
            getReportInfo().setPpsDownloadVersion(String.valueOf(j10));
        }
    }

    @Override // cl.InterfaceC1454i
    public boolean checkAppVersion(int i10) {
        long versionCode = ICBUtil.getVersionCode(C0213f.m1377a().getPackageManager(), getAppId());
        long versionCode2 = getVersionCode();
        C11839m.m70688i(TAG, "checkAppVersion need download，installAppVersion:" + versionCode + ",backup version:" + versionCode2);
        updateInstallVersion(i10, versionCode);
        return versionCode >= versionCode2;
    }

    public abstract String getAppId();

    public abstract RestoreModuleReportInfo getReportInfo();

    public abstract long getVersionCode();

    @Override // cl.InterfaceC1454i
    public abstract void isAbort() throws C9721b;

    @Override // cl.InterfaceC1454i
    public abstract boolean isPause();
}
