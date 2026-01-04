package com.huawei.android.hicloud.sync.syncutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.SyncRiskManagementActivity;
import com.huawei.android.hicloud.p088ui.activity.SyncRiskNotificationActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.SyncRiskNotificationManager;
import com.huawei.hicloud.notification.p106db.bean.HiCloudRiskRule;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyContentOperator;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import p015ak.C0209d;
import p514o9.C11839m;
import p684un.C13223b;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.p */
/* loaded from: classes3.dex */
public class C2987p {
    /* renamed from: a */
    public static boolean m17951a(Activity activity) {
        boolean zM80927i1 = C13452e.m80781L().m80927i1();
        if (zM80927i1 && activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SyncRiskManagementActivity.class));
            C11839m.m70688i("SyncRiskUtil", "checkSyncRisk, now finish");
            activity.finish();
        }
        return zM80927i1;
    }

    /* renamed from: b */
    public static NoticeContent m17952b(int i10) throws Throwable {
        C11839m.m70686d("SyncRiskUtil", "getNoticeContent, noticeType:" + i10);
        SpaceNotifyContentOperator spaceNotifyContentOperator = new SpaceNotifyContentOperator();
        String currentLanguage = HNUtil.getCurrentLanguage();
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        if (TextUtils.isEmpty(currentLanguage)) {
            C11839m.m70687e("SyncRiskUtil", "getNoticeContent language null");
            return new NoticeContent();
        }
        NoticeContent noticeContentQueryContent = spaceNotifyContentOperator.queryContent(i10, 118, currentLanguage, "");
        if (noticeContentQueryContent == null) {
            C11839m.m70688i("SyncRiskUtil", "cannot find content by language-country=" + currentLanguage);
            noticeContentQueryContent = spaceNotifyContentOperator.queryContentByLanguage(i10, 118, currentBaseLanguage, "");
        }
        if (noticeContentQueryContent != null) {
            return noticeContentQueryContent;
        }
        C11839m.m70688i("SyncRiskUtil", "cannot find content by language=" + currentBaseLanguage);
        return spaceNotifyContentOperator.queryContentByLanguage(i10, 118, FaqConstants.DEFAULT_ISO_LANGUAGE, "");
    }

    /* renamed from: c */
    public static void m17953c(Context context) throws Throwable {
        HiCloudRiskRule hiCloudRiskRule;
        if (context == null) {
            C11839m.m70687e("SyncRiskUtil", "showSyncRiskNotification context is null");
            return;
        }
        C11839m.m70686d("SyncRiskUtil", "showSyncRiskNotification");
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        long jM62247N = c10028cM62183d0.m62247N("sync_risk_notify_time");
        long jM62247N2 = c10028cM62183d0.m62247N("sync_risk_desktop_notify_time");
        NotificationConfig syncRiskNoticeConfig = new SyncRiskNotificationManager().getSyncRiskNoticeConfig();
        float dayonce = (syncRiskNoticeConfig == null || (hiCloudRiskRule = syncRiskNoticeConfig.getHiCloudRiskRule()) == null) ? 7.0f : hiCloudRiskRule.getDayonce();
        NoticeContent noticeContentM17952b = m17952b(3);
        if (noticeContentM17952b == null) {
            C11839m.m70687e("SyncRiskUtil", "showSyncRiskNotification notice is null");
            return;
        }
        String title = noticeContentM17952b.getTitle();
        String mainText = noticeContentM17952b.getMainText();
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(mainText)) {
            C11839m.m70687e("SyncRiskUtil", "showSyncRiskNotification title or content is null");
            return;
        }
        if (dayonce == -1.0f || System.currentTimeMillis() - jM62247N < 8.64E7f * dayonce) {
            C11839m.m70688i("SyncRiskUtil", "Do not show showSyncRiskNotification, lastNotifyTime: " + jM62247N + ", frequency day: " + dayonce);
        } else {
            C11839m.m70688i("SyncRiskUtil", "showSyncRiskNotification, lastNotifyTime: " + jM62247N + ", frequency day: " + dayonce);
            new BackupNotificationManager(context.getApplicationContext()).sendSyncRiskNotification(context.getApplicationContext(), title, mainText);
        }
        if (jM62247N2 != 0) {
            C11839m.m70688i("SyncRiskUtil", "Do not show desktop notification, lastNotifyTime: " + jM62247N2);
            return;
        }
        if (C0209d.m1265i1(context)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11839m.m70688i("SyncRiskUtil", "showSyncRiskNotification, show desktop notification, currentTime: " + jCurrentTimeMillis);
            c10028cM62183d0.m62197C2("sync_risk_desktop_notify_time", jCurrentTimeMillis);
            C13223b.m79473a(context, "risk_desktop", "1");
            UBAAnalyze.m29954O("PVC", "risk_desktop", "4", "38");
            Intent intent = new Intent();
            intent.setClass(context, SyncRiskNotificationActivity.class);
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.putExtra("risk_notify_title_key", title);
            intent.putExtra("risk_notify_ctt_key", mainText);
            context.startActivity(intent);
        }
    }
}
