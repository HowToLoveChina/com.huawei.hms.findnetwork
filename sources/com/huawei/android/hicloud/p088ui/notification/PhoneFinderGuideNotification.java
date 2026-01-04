package com.huawei.android.hicloud.p088ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0238w;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class PhoneFinderGuideNotification {
    private static final String GROUP_NAME = "com.huawei.android.hicloud";
    private static final int NOTIFY_ID = 512;
    private static final String TAG = "PhoneFinderGuideNotification";
    private Context mContext;
    private NotificationManager mManager;

    public PhoneFinderGuideNotification(Context context) {
        this.mContext = context;
        if (context != null) {
            this.mManager = (NotificationManager) context.getSystemService("notification");
        }
    }

    private Notification generateNotification() throws Resources.NotFoundException {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.mContext, "com.huawei.android.remotecontrol.ui.PhoneFinderActivity"));
        intent.putExtra("guide_open_phone_finder", false);
        intent.putExtra("is_from_cloud_notification", true);
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_OPEN_PHONEFINDER_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        String string = this.mContext.getResources().getString(C11842p.m70762R0() ? R$string.Popupwindow_opentitle_pad : R$string.Popupwindow_opentitle);
        return C0238w.m1663f().m1668i(this.mContext, string).m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(this.mContext.getResources().getString(i10)).m3811l(string).m3810k(this.mContext.getResources().getString(R$string.pf_tips_track_when_lost)).m3809j(pendingIntentM1248e0).m3815p(bundle).m3817r(GROUP_NAME).m3800C(System.currentTimeMillis()).m3807h(true).m3804d();
    }

    public void sendNotification() throws Resources.NotFoundException {
        if (this.mManager == null) {
            C11839m.m70688i(TAG, "mManager is null");
        } else {
            this.mManager.notify(512, generateNotification());
        }
    }
}
