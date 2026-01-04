package p401jn;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import gn.InterfaceC10020c;
import java.util.HashMap;
import java.util.TimerTask;
import kn.C11074k;

/* renamed from: jn.a */
/* loaded from: classes6.dex */
public class C10901a extends TimerTask {
    /* renamed from: a */
    public final void m65922a() {
        HashMap map = new HashMap();
        map.put("report_operation_type", "notice_before_backup_timer_start");
        map.put("timer_start_time", String.valueOf(C11074k.m66717t()));
        NotificationReportUtil.reportNotificationTimer("notice_before_backup_timer_start", map);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        NotifyLogger.m29915i("NoticeBeforeBackupTimer", "NoticeBeforeBackupTimer begin execute");
        InterfaceC10020c.get().mo62163b(new C4972b(1, ""));
        m65922a();
    }
}
