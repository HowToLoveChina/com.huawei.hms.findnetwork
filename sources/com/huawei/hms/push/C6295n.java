package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: com.huawei.hms.push.n */
/* loaded from: classes8.dex */
public class C6295n {

    /* renamed from: a */
    private static int f29675a;

    /* renamed from: a */
    public static synchronized void m36541a(Context context, C6296o c6296o) {
        int iHashCode;
        int iHashCode2;
        int i10;
        int iHashCode3;
        if (context != null) {
            try {
                if (!m36545a(c6296o)) {
                    HMSLog.m36983d("PushSelfShowLog", "showNotification, the msg id = " + c6296o.m36581o());
                    if (f29675a == 0) {
                        f29675a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(c6296o.m36577k())) {
                        String strM36582p = c6296o.m36582p();
                        if (!TextUtils.isEmpty(strM36582p)) {
                            int iHashCode4 = strM36582p.hashCode();
                            c6296o.m36567a(iHashCode4);
                            HMSLog.m36983d("PushSelfShowLog", "notification msgTag = " + iHashCode4);
                        }
                        if (c6296o.m36583r() != -1) {
                            iHashCode = c6296o.m36583r();
                            iHashCode3 = (c6296o.m36576j() + System.currentTimeMillis()).hashCode();
                            i10 = iHashCode3 + 1;
                            iHashCode2 = (c6296o.m36583r() + c6296o.m36576j() + context.getPackageName()).hashCode();
                        } else {
                            int i11 = f29675a;
                            int i12 = i11 + 1;
                            int i13 = i11 + 2;
                            int i14 = i11 + 3;
                            int i15 = i11 + 4;
                            f29675a = i15;
                            iHashCode2 = i15;
                            iHashCode = i12;
                            iHashCode3 = i13;
                            i10 = i14;
                        }
                    } else {
                        iHashCode = (c6296o.m36577k() + c6296o.m36576j()).hashCode();
                        int i16 = f29675a;
                        int i17 = i16 + 1;
                        int i18 = i16 + 2;
                        f29675a = i18;
                        iHashCode2 = (c6296o.m36577k() + c6296o.m36576j() + context.getPackageName()).hashCode();
                        i10 = i18;
                        iHashCode3 = i17;
                    }
                    HMSLog.m36983d("PushSelfShowLog", "notifyId:" + iHashCode + ",openNotifyId:" + iHashCode3 + ",delNotifyId:" + i10 + ",alarmNotifyId:" + iHashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = iHashCode;
                    iArr[1] = iHashCode3;
                    iArr[2] = i10;
                    if (c6296o.m36571e() <= 0) {
                        iHashCode2 = 0;
                    }
                    iArr[3] = iHashCode2;
                    Notification notificationM36537a = C6286e.m36524d() ? m36537a(context, c6296o, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && notificationM36537a != null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        notificationManager.notify(iHashCode, notificationM36537a);
                        C6293l.m36536a(context, c6296o.m36581o(), c6296o.m36568b(), "100");
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: b */
    private static PendingIntent m36546b(Context context, C6296o c6296o, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], m36538a(context, c6296o, iArr, "2", HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK), C6286e.m36516a());
    }

    /* renamed from: c */
    private static PendingIntent m36549c(Context context, C6296o c6296o, int[] iArr) {
        Intent intentM36538a = m36538a(context, c6296o, iArr, "1", HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (!m36544a()) {
            return PendingIntent.getBroadcast(context, iArr[1], intentM36538a, C6286e.m36516a());
        }
        intentM36538a.setClass(context, TransActivity.class);
        intentM36538a.setFlags(268468224);
        return PendingIntent.getActivity(context, iArr[1], intentM36538a, C6286e.m36516a());
    }

    /* renamed from: d */
    private static void m36551d(C6296o c6296o, Notification.Builder builder) {
        String strM36585t = c6296o.m36585t();
        String strM36575i = c6296o.m36575i();
        if (TextUtils.isEmpty(strM36575i)) {
            builder.setContentText(strM36585t);
            return;
        }
        builder.setContentText(strM36575i);
        if (TextUtils.isEmpty(strM36585t)) {
            return;
        }
        builder.setContentTitle(strM36585t);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static void m36547b(Context context, Notification.Builder builder, C6296o c6296o) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String strM36576j = c6296o.m36576j();
            if (TextUtils.isEmpty(strM36576j)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", strM36576j);
            builder.setExtras(bundle);
        }
    }

    /* renamed from: c */
    private static void m36550c(C6296o c6296o, Notification.Builder builder) {
        builder.setTicker(c6296o.m36587w());
    }

    /* renamed from: b */
    private static void m36548b(C6296o c6296o, Notification.Builder builder) {
        String strM36584s = c6296o.m36584s();
        if (TextUtils.isEmpty(strM36584s)) {
            return;
        }
        builder.setSubText(strM36584s);
    }

    /* renamed from: a */
    private static boolean m36544a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: a */
    private static Intent m36538a(Context context, C6296o c6296o, int[] iArr, String str, int i10) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", c6296o.m36580n()).putExtra("selfshow_token", c6296o.m36588x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i10);
        return intent;
    }

    /* renamed from: a */
    private static Notification m36537a(Context context, C6296o c6296o, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (C6291j.m36532a(c6296o) == EnumC6292k.STYLE_BIGTEXT) {
            C6291j.m36533a(builder, c6296o.m36572f(), c6296o);
        }
        C6289h.m36528a(context, builder, c6296o);
        m36548b(c6296o, builder);
        m36551d(c6296o, builder);
        m36542a(context, c6296o, builder);
        m36539a(builder);
        m36543a(c6296o, builder);
        m36550c(c6296o, builder);
        builder.setContentIntent(m36549c(context, c6296o, iArr));
        builder.setDeleteIntent(m36546b(context, c6296o, iArr));
        builder.setChannelId("HwPushChannelID");
        m36547b(context, builder, c6296o);
        m36540a(context, builder, c6296o);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static void m36540a(Context context, Notification.Builder builder, C6296o c6296o) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !C6286e.m36519a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String strM36576j = c6296o.m36576j();
        HMSLog.m36988i("PushSelfShowLog", "the package name of notification is:" + strM36576j);
        if (!TextUtils.isEmpty(strM36576j)) {
            String strM36518a = C6286e.m36518a(context, strM36576j);
            HMSLog.m36988i("PushSelfShowLog", "the app name is:" + strM36518a);
            if (strM36518a != null) {
                bundle.putCharSequence("android.extraAppName", strM36518a);
            }
        }
        builder.setExtras(bundle);
    }

    /* renamed from: a */
    private static void m36542a(Context context, C6296o c6296o, Notification.Builder builder) {
        Bitmap bitmapM36527a = C6289h.m36527a(context, c6296o);
        if (bitmapM36527a != null) {
            builder.setLargeIcon(bitmapM36527a);
        }
    }

    /* renamed from: a */
    private static void m36539a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    /* renamed from: a */
    private static void m36543a(C6296o c6296o, Notification.Builder builder) {
        builder.setAutoCancel(c6296o.m36570d() == 1);
        builder.setOngoing(false);
    }

    /* renamed from: a */
    private static boolean m36545a(C6296o c6296o) {
        return c6296o == null || (TextUtils.isEmpty(c6296o.m36585t()) && TextUtils.isEmpty(c6296o.m36575i()));
    }
}
