package al;

import cl.InterfaceC1447b;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;

/* renamed from: al.a */
/* loaded from: classes6.dex */
public abstract class AbstractC0242a implements InterfaceC1447b {
    private static final String TAG = "BaseAppProcessorCallback";

    private void updateDownloadResult(int i10, boolean z10) {
        if (i10 == 0) {
            getReportInfo().setAgdDownloadSuccess(Boolean.valueOf(z10));
        } else if (i10 == 1) {
            getReportInfo().setPpsDownloadSuccess(Boolean.valueOf(z10));
        }
    }

    public abstract RestoreModuleReportInfo getReportInfo();

    public abstract String getTAG();

    public abstract void notifyLauncher(int i10);

    public abstract void onDownloadFinish();

    public abstract void onInstallFail();

    public abstract void onInstallSuccess();

    public abstract void onInstalling();

    @Override // cl.InterfaceC1447b
    public void onStatusChange(int i10, int i11, int i12) {
        if (i11 == 3 || i11 == 2) {
            boolean z10 = i11 == 3;
            update3rdProgress(i12, z10, true);
            if (z10) {
                onDownloadFinish();
                return;
            }
            return;
        }
        if (i11 == 1) {
            updateDownloadResult(i10, false);
            return;
        }
        if (i11 == 4) {
            notifyLauncher(0);
            return;
        }
        if (i11 == 5) {
            onInstalling();
            notifyLauncher(1);
        } else if (i11 == 6) {
            onInstallSuccess();
            notifyLauncher(2);
            updateDownloadResult(i10, true);
        } else if (i11 == 7) {
            onInstallFail();
            notifyLauncher(-1);
        }
    }

    public abstract void update3rdProgress(int i10, boolean z10, boolean z11);
}
