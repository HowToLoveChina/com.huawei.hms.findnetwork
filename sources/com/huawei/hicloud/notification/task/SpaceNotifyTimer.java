package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.util.TimerCheckCallback;
import java.util.HashMap;
import java.util.Timer;
import p015ak.C0209d;

/* loaded from: classes6.dex */
public class SpaceNotifyTimer implements TimerCheckCallback {
    private static final int MAX_MILLISEC = 300000;
    private static final int MIN_MILLISEC = 0;
    private static final String TAG = "SpaceNotifyTimer";
    private boolean isFromAlbum;
    private Timer timer = new Timer();
    private long totalNeedSpace;

    public SpaceNotifyTimer(long j10, boolean z10) {
        this.totalNeedSpace = j10;
        this.isFromAlbum = z10;
    }

    private void reportCheckSuccess() {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.KEY_SPACE_NOTICE_DELAY_EVENT, NotifyConstants.NotificationReport.EVENT_NAME_DELAY_TIMER_CHECK_SUCCESS);
        map.put(NotifyConstants.NotificationReport.KEY_TOTAL_NEED_SPACE, String.valueOf(this.totalNeedSpace));
        map.put("is_from_album", String.valueOf(this.isFromAlbum));
        NotificationReportUtil.reportSpaceNoticeDelay(map);
    }

    private void reportTimerStart(int i10) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.KEY_SPACE_NOTICE_DELAY_EVENT, NotifyConstants.NotificationReport.EVENT_NAME_START_DELAY_TIMER);
        map.put(NotifyConstants.NotificationReport.KEY_DELAY_RANDOM_TIME, String.valueOf(i10));
        map.put(NotifyConstants.NotificationReport.KEY_TOTAL_NEED_SPACE, String.valueOf(this.totalNeedSpace));
        map.put("is_from_album", String.valueOf(this.isFromAlbum));
        NotificationReportUtil.reportSpaceNoticeDelay(map);
    }

    @Override // com.huawei.hicloud.notification.util.TimerCheckCallback
    public void checkFailed() {
        NotifyLogger.m29915i(TAG, "check failed");
        this.timer.cancel();
    }

    @Override // com.huawei.hicloud.notification.util.TimerCheckCallback
    public void checkSuccess() {
        NotifyLogger.m29915i(TAG, "check success");
        reportCheckSuccess();
        this.timer.cancel();
        CloudSpaceNotifyUtil.getInstance().checkNotifyRule(new NotificationConfigManager().getConfigFromFile(), this.totalNeedSpace, this.isFromAlbum);
    }

    public void execute() {
        NotifyLogger.m29915i(TAG, "timer execute");
        NotifyTimerSpManager.getInstance().recordSpaceNotifyTimerStart(this.totalNeedSpace, this.isFromAlbum);
        SpaceNotifyTimerTask spaceNotifyTimerTask = new SpaceNotifyTimerTask(this);
        int iM1260h0 = C0209d.m1260h0(0, 300000);
        NotifyLogger.m29915i(TAG, "timer schedule millisecond: " + iM1260h0);
        this.timer.schedule(spaceNotifyTimerTask, (long) iM1260h0);
        reportTimerStart(iM1260h0);
    }
}
