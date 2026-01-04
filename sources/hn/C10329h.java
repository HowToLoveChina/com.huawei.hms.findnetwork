package hn;

import com.huawei.hicloud.bean.SilenceDurationBean;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import gn.InterfaceC10024g;
import java.util.List;
import kn.C11074k;
import p015ak.C0209d;
import p015ak.C0213f;
import p371ik.C10527a;
import p401jn.C10901a;
import p748wp.C13624a;

/* renamed from: hn.h */
/* loaded from: classes6.dex */
public class C10329h implements InterfaceC10024g {
    @Override // gn.InterfaceC10024g
    /* renamed from: a */
    public boolean mo62169a(NotificationTask notificationTask) {
        NotifyLogger.m29913d("NoticeBeforeBackupPopUpDecision", "enter into show()");
        BackupBeforeNotice backupBeforeNoticeM66715r = C11074k.m66715r();
        if (backupBeforeNoticeM66715r == null) {
            NotifyLogger.m29914e("NoticeBeforeBackupPopUpDecision", "backupBeforeNotice config is null");
            C11074k.m66693O(notificationTask.getEventType(), 1, "backupBeforeNotice config is null");
            return false;
        }
        float dayOnce = backupBeforeNoticeM66715r.getDayOnce();
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e("NoticeBeforeBackupPopUpDecision", "spaceProxy is null");
            return false;
        }
        NotifyLogger.m29913d("NoticeBeforeBackupPopUpDecision", "backupEventId is:" + notificationTask.getEventType());
        if (!spaceProxy.isNoticeFrequencySatisfyDayOnceConfig(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, dayOnce)) {
            String str = "notice frequency is not satisfy dayOnce Config,dayOnce is:" + dayOnce;
            NotifyLogger.m29915i("NoticeBeforeBackupPopUpDecision", str);
            C11074k.m66693O(notificationTask.getEventType(), 1, str);
            return false;
        }
        List<SilenceDurationBean> silencePeriod = backupBeforeNoticeM66715r.getSilencePeriod();
        if (!C11074k.m66679A(silencePeriod)) {
            notificationTask.setData(C10527a.m64633k(backupBeforeNoticeM66715r));
            return true;
        }
        NotifyLogger.m29915i("NoticeBeforeBackupPopUpDecision", "current time is in silent notify time");
        C11074k.m66693O(notificationTask.getEventType(), 1, "current time is in silent notify time");
        if (C0209d.m1309t1(C0213f.m1377a())) {
            C13624a.m81979b().m81980c(new C10901a(), C11074k.m66720w(silencePeriod, "HH:mm"));
        }
        return false;
    }
}
