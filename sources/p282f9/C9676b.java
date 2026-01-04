package p282f9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientNotifyUtil;
import com.huawei.android.hicloud.cloudbackup.provider.CloudBackupStateProvider;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.common.mission.Mission;
import com.huawei.hicloud.notificationv2.bean.ActionTimeRecord;
import java.util.Optional;
import java.util.function.Consumer;
import kn.C11074k;
import p015ak.C0213f;
import p514o9.C11839m;
import p766x8.C13729h;

/* renamed from: f9.b */
/* loaded from: classes3.dex */
public class C9676b implements Mission {
    /* renamed from: b */
    public static /* synthetic */ void m60440b(Uri uri, Context context) {
        context.getContentResolver().call(uri, CloudBackupStateProvider.METHOD_START_MAIN_PROCESS, (String) null, (Bundle) null);
    }

    @Override // com.huawei.android.hicloud.common.mission.Mission
    /* renamed from: e0 */
    public void mo15610e0() {
        if (ICBUtil.isProcessAlive(C0213f.m1377a(), C0213f.m1377a().getApplicationContext().getPackageName())) {
            C11839m.m70688i("BackupNotifyMission", "mainProcess already alive.");
            return;
        }
        final Uri uri = Uri.parse("content://com.huawei.hidisk.cloudbackup.backupstate");
        Optional.ofNullable(C0213f.m1377a()).ifPresent(new Consumer() { // from class: f9.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9676b.m60440b(uri, (Context) obj);
            }
        });
        C11074k.m66695Q(new ActionTimeRecord(1, System.currentTimeMillis()), 48);
    }

    @Override // com.huawei.android.hicloud.common.mission.Mission
    /* renamed from: f0 */
    public void mo15611f0() {
        super.mo15611f0();
    }

    @Override // com.huawei.android.hicloud.common.mission.Mission
    /* renamed from: h0 */
    public boolean mo15613h0() {
        Context applicationContext = C0213f.m1377a().getApplicationContext();
        BackupSpaceInsufficientNotifyUtil backupSpaceInsufficientNotifyUtil = new BackupSpaceInsufficientNotifyUtil();
        if (!new C13729h().isDsStartMainFrequencySatisfied()) {
            C11839m.m70689w("BackupNotifyMission", "Ds start main process too much times");
            backupSpaceInsufficientNotifyUtil.saveFrequencyControlInfo(applicationContext, "freqInfo", true);
            return false;
        }
        boolean zM66681C = C11074k.m66681C();
        boolean zIsAutoBackupDlgCheckTaskExecuteNow = backupSpaceInsufficientNotifyUtil.isAutoBackupDlgCheckTaskExecuteNow();
        C11839m.m70688i("BackupNotifyMission", "conditionCheck, noticeBeforeCheckResult: " + zM66681C + ", isAutoBackupDlgCheckResult: " + zIsAutoBackupDlgCheckTaskExecuteNow);
        backupSpaceInsufficientNotifyUtil.saveFrequencyControlInfo(applicationContext, "freqInfo", false);
        backupSpaceInsufficientNotifyUtil.saveFrequencyControlInfo(applicationContext, "noticeBeforeCheckResult", zM66681C);
        return zM66681C || zIsAutoBackupDlgCheckTaskExecuteNow;
    }

    @Override // com.huawei.android.hicloud.common.mission.Mission
    public EnumC9677c identity() {
        return EnumC9677c.BACKUP_NOTIFY;
    }
}
