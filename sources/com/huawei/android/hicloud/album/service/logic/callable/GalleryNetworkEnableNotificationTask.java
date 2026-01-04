package com.huawei.android.hicloud.album.service.logic.callable;

import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$string;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0235t;
import p015ak.C0238w;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p581qk.AbstractC12367d;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class GalleryNetworkEnableNotificationTask extends AbstractC12367d {
    private static final List<Integer> FREQUENCY_LIST = new ArrayList(Arrays.asList(0, 7, 14, 30, 30, 30));
    private static final String TAG = "GalleryNetworkEnableNotificationTask";
    private Context mContext;
    private NotificationManager mManager;

    public GalleryNetworkEnableNotificationTask(Context context) {
        this.mContext = context;
        this.mManager = (NotificationManager) context.getSystemService("notification");
    }

    private boolean checkFrequency() {
        int iM6972m = C1136q.m6972m();
        if (iM6972m < FREQUENCY_LIST.size()) {
            int intervalDays = getIntervalDays(iM6972m);
            long jM6963d = C1136q.m6963d();
            C1120a.m6675d(TAG, String.format(Locale.ENGLISH, "isEligibleForNotification preShowTime = %s, showCount = %s, intervalDays = %s, currentTime = %s", Long.valueOf(jM6963d), Integer.valueOf(iM6972m), Integer.valueOf(intervalDays), Long.valueOf(System.currentTimeMillis())));
            return Math.abs(System.currentTimeMillis() - jM6963d) >= ((long) intervalDays) * 86400000;
        }
        C1120a.m6677i(TAG, "maximum showCount of notification has been reached, showCount is " + iM6972m);
        return false;
    }

    private void completeNotification() {
        NotificationCompat.Builder builderM1669j;
        C1120a.m6677i(TAG, "complete GalleryNetworkEnableNotification start");
        String string = this.mContext.getString(R$string.notification_enable_gallery_network_title);
        String string2 = this.mContext.getString(R$string.notification_enable_gallery_network_text);
        if (NotifyUtil.isSilentNotifyTime()) {
            C0235t c0235tM1645e = C0235t.m1645e();
            Context context = this.mContext;
            builderM1669j = c0235tM1645e.m1648g(context, string, "2", context.getString(R$string.channel_backup_notification));
        } else {
            builderM1669j = C0238w.m1663f().m1669j(this.mContext, string);
        }
        builderM1669j.m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3807h(true).m3811l(string).m3810k(string2);
        this.mManager.notify(404, builderM1669j.m3804d());
        C1136q.m6984y(System.currentTimeMillis());
        C1136q.m6958P();
        C1120a.m6677i(TAG, "complete GalleryNetworkEnableNotification end");
    }

    private int getIntervalDays(int i10) {
        if (i10 >= 0) {
            return FREQUENCY_LIST.get(i10).intValue();
        }
        C1120a.m6678w(TAG, "getIntervalDays showCount is illegal");
        return Integer.MAX_VALUE;
    }

    private boolean isEligibleForNotification() {
        if (!C13452e.m80781L().m80842P0()) {
            C1120a.m6677i(TAG, "isEligibleForNotification false, not login");
            return false;
        }
        if (C1122c.m6687C1(this.mContext)) {
            C1120a.m6677i(TAG, "isEligibleForNotification false, support CloudFreqAndNewBusiness");
            return false;
        }
        if (!C1122c.m6807m1(this.mContext)) {
            C1120a.m6677i(TAG, "isEligibleForNotification false, cloudAlbumSwitch off");
            return false;
        }
        if (queryGalleryNetworkSwitch()) {
            C1120a.m6677i(TAG, "isEligibleForNotification false, mobileSwitch already on");
            return false;
        }
        if (checkFrequency()) {
            return true;
        }
        C1120a.m6677i(TAG, "isEligibleForNotification false, checkFrequency false");
        return false;
    }

    private boolean queryGalleryNetworkSwitch() {
        String[] strArr = {"is_gallery_network_on"};
        Uri uri = C1122c.f5352f;
        try {
            try {
                cursorQuery = C0209d.m1227Y1(this.mContext, uri) ? this.mContext.getContentResolver().query(uri, null, "featureName = ?", strArr, null) : null;
                if (cursorQuery == null) {
                    C1120a.m6678w(TAG, "queryGallery is null");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                    C1120a.m6677i(TAG, strArr[0] + " = " + string);
                    if (string.contains("false")) {
                        cursorQuery.close();
                        return false;
                    }
                }
                cursorQuery.close();
                return true;
            } catch (Exception e10) {
                C1120a.m6676e(TAG, "queryGallery Exception:" + e10.toString());
                if (0 != 0) {
                    cursorQuery.close();
                }
                return true;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        sendNotification();
    }

    public void sendNotification() {
        if (isEligibleForNotification()) {
            completeNotification();
        } else {
            C1120a.m6677i(TAG, "sendGalleryNetworkEnableNotification is not meeting conditions");
        }
    }
}
