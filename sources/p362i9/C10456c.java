package p362i9;

import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: i9.c */
/* loaded from: classes3.dex */
public class C10456c extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if (NotifyTimerSpManager.getInstance().isSpaceNotifyTimerStart()) {
            C11839m.m70688i("NotifyTimerCheckTask", "check space notify timer");
            NotifyTimerSpManager.getInstance().recordSpaceNotifyTimerEnd();
            CloudSpaceNotifyUtil.getInstance().checkNotifyRule(new NotificationConfigManager().getConfigFromFile(), NotifyTimerSpManager.getInstance().getSpaceNotiTotalSpace(), NotifyTimerSpManager.getInstance().getSpaceNotiFromAlbum());
        }
        if (NotifyTimerSpManager.getInstance().isAutoBackupNotifyTimerStart()) {
            C11839m.m70688i("NotifyTimerCheckTask", "check auto backup failed notify timer");
            NotifyTimerSpManager.getInstance().recordAutoBackupNotifyTimerEnd();
            UserSpaceUtil.sendSpaceNotEnough(true, NotifyTimerSpManager.getInstance().getBackupNotiNeedData());
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.NOTIFY_TIMER_CHECK;
    }
}
