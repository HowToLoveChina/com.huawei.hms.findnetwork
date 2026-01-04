package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import fk.C9721b;
import gp.C10028c;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p581qk.AbstractC12366c;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes2.dex */
public class CloudBackupNotifyJobTask extends AbstractC12366c {
    private static final long DAY_MILLIS = 86400000;
    private static final String TAG = "CloudBackupNotifyJobTask";
    private long lastSuccessTime;
    private long millis;
    private final SettingOperator operator;

    public CloudBackupNotifyJobTask(int i10) {
        super(i10);
        this.operator = new SettingOperator();
        this.millis = 0L;
        this.lastSuccessTime = 0L;
    }

    private void doNotifyCheck() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        C11839m.m70688i(TAG, "doNotifyCheck isOpen: " + zM62388s);
        if (zM62388s) {
            if (!isCloudNoSpace()) {
                List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.BACKUP_CYCLE, UserSpaceUtil.getUserTagsUseCache("BackupNotifyJobTask"));
                long jQuerynotifycycle = this.operator.querynotifycycle();
                if (extraNotificationBean != null && extraNotificationBean.size() != 0) {
                    Iterator<ExtraNotificationBean> it = extraNotificationBean.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        long unBackupDays = it.next().getUnBackupDays();
                        if (unBackupDays == 0) {
                            unBackupDays = jQuerynotifycycle;
                        }
                        if (checkNotifyCondition(unBackupDays)) {
                            ICBServiceProtocol.getInstance().doNewBackupNotify(this.millis, this.lastSuccessTime);
                            break;
                        }
                    }
                } else if (checkNotifyCondition(jQuerynotifycycle)) {
                    ICBServiceProtocol.getInstance().doNewBackupNotify(this.millis, this.lastSuccessTime);
                }
            } else {
                C11839m.m70688i(TAG, "doNotifyCheck internal nosapce");
            }
        }
        CloudBackupJobManager.getInstance().registerNotifyScheduler(true);
    }

    private boolean isCloudNoSpace() {
        C13030i c13030i = new C13030i();
        try {
            C13029h c13029hM78495f = c13030i.m78495f(4);
            C13029h c13029hM78495f2 = c13030i.m78495f(2);
            C13029h c13029hM78495f3 = c13030i.m78495f(1);
            if (c13029hM78495f == null || !TextUtils.equals(c13029hM78495f.m78474q(), "001_1007")) {
                if (c13029hM78495f2 == null || !TextUtils.equals(c13029hM78495f2.m78474q(), "001_1007")) {
                    if (c13029hM78495f3 == null) {
                        return false;
                    }
                    if (!TextUtils.equals(c13029hM78495f3.m78474q(), "001_1007")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "getBackupTags error: " + e10.getMessage());
            return false;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        doNotifyCheck();
    }

    public boolean checkNotifyCondition(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jQuerylastsuccesstime = this.operator.querylastsuccesstime();
        long jQuerylastnotifytime = this.operator.querylastnotifytime();
        long jQueryinitopentime = this.operator.queryinitopentime();
        if (jQuerylastsuccesstime == 0) {
            this.millis = jCurrentTimeMillis - jQueryinitopentime;
            this.lastSuccessTime = jQueryinitopentime;
            C11839m.m70688i(TAG, "has no backup record, day = " + ((this.millis - 1) / 86400000));
        } else {
            this.millis = jCurrentTimeMillis - jQuerylastsuccesstime;
            this.lastSuccessTime = jQuerylastsuccesstime;
            C11839m.m70688i(TAG, "has success backup record, day = " + ((this.millis - 1) / 86400000));
        }
        long j11 = j10 * 86400000;
        boolean z10 = this.millis > j11 && jCurrentTimeMillis - jQuerylastnotifytime > j11;
        C11839m.m70688i(TAG, "notify flag = " + z10);
        return z10;
    }

    @Override // p581qk.AbstractC12366c, p616rk.AbstractRunnableC12516b
    public void release() {
        super.release();
    }
}
