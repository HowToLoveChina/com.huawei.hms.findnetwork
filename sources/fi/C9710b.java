package fi;

import android.app.NotificationManager;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import ba.C1159m;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import fk.C9721b;
import p015ak.C0209d;
import p015ak.C0213f;
import p054cj.C1442a;
import p258ei.C9494c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: fi.b */
/* loaded from: classes.dex */
public class C9710b extends AbstractC12367d {

    /* renamed from: a */
    public C1159m f47919a;

    /* renamed from: b */
    public Intent f47920b;

    public C9710b(C1159m c1159m, Intent intent) {
        this.f47919a = c1159m;
        this.f47920b = intent;
    }

    /* renamed from: c */
    public void m60562c(int i10) {
        int i11;
        boolean z10;
        NotificationManager notificationManager = (NotificationManager) C0213f.m1377a().getSystemService("notification");
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        boolean z11 = false;
        if (activeNotifications.length <= 0) {
            C1442a.m8290i("FrontAcceptSuccessNotifyTask", "notifications is null");
            i11 = 0;
            z10 = false;
        } else {
            boolean z12 = false;
            i11 = 0;
            z10 = false;
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification.getNotification() == null) {
                    C1442a.m8290i("FrontAcceptSuccessNotifyTask", "notification is null");
                } else {
                    String group = statusBarNotification.getNotification().getGroup();
                    if (group == null) {
                        C1442a.m8290i("FrontAcceptSuccessNotifyTask", "Notification group is null");
                    } else if ("com.huawei.android.hicloud".equals(group)) {
                        i11++;
                        if (statusBarNotification.getId() == 22) {
                            z10 = true;
                        }
                        if (statusBarNotification.getId() == i10) {
                            z12 = true;
                        }
                    }
                }
            }
            z11 = z12;
        }
        C1442a.m8290i("FrontAcceptSuccessNotifyTask", "cancelNotify needCancel is " + z11 + ", notifyId" + i10);
        if (z11) {
            notificationManager.cancel(i10);
            C1442a.m8290i("FrontAcceptSuccessNotifyTask", "cancelNotify hiCloudNotiCount is " + i11 + ", containGroupID is " + z10);
            if (i11 == 2 && z10) {
                notificationManager.cancel(22);
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C1159m c1159m = this.f47919a;
        if (c1159m == null || this.f47920b == null) {
            C11839m.m70687e("FrontAcceptSuccessNotifyTask", "match result or intent is null, not show notify");
            return;
        }
        String strM1303s = C0209d.m1303s(NoticeWithActivityUtil.getStrFromDBByResource(this.f47919a.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONT_APP_NOTIFY_BAR_TITLE), c1159m.m7240e());
        String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(this.f47919a.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONT_APP_NOTIFY_BAR_TEXT);
        if (!TextUtils.isEmpty(strM1303s) && !TextUtils.isEmpty(strFromDBByResource)) {
            C9494c.m59390r().m59398K();
        }
        new HiCloudNotificationManager(C0213f.m1377a()).sendAcceptFrontAppPrizeNotify(strM1303s, strFromDBByResource, this.f47920b);
        m60562c(775);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return super.getEnum();
    }
}
