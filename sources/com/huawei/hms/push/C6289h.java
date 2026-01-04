package com.huawei.hms.push;

import android.R;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.constant.OsType;

/* renamed from: com.huawei.hms.push.h */
/* loaded from: classes8.dex */
public class C6289h {
    /* renamed from: a */
    private static int m36526a(Context context) {
        int i10 = context.getApplicationInfo().icon;
        if (i10 != 0) {
            return i10;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", OsType.ANDROID);
        HMSLog.m36983d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.m36983d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return R.drawable.sym_def_app_icon;
    }

    /* renamed from: b */
    private static int m36529b(Context context, C6296o c6296o) throws NoSuchFieldException, PackageManager.NameNotFoundException, NumberFormatException {
        int iM36599a = 0;
        if (context == null || c6296o == null) {
            HMSLog.m36988i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!TextUtils.isEmpty(c6296o.m36578l())) {
            String[] strArrSplit = c6296o.m36578l().split("/");
            if (strArrSplit.length == 3) {
                iM36599a = C6300s.m36600a(context, strArrSplit[1], strArrSplit[2]);
            }
        }
        if (iM36599a == 0) {
            iM36599a = C6300s.m36599a(context, "com.huawei.messaging.default_notification_icon");
        }
        return iM36599a != 0 ? iM36599a : m36526a(context);
    }

    /* renamed from: a */
    public static Bitmap m36527a(Context context, C6296o c6296o) {
        if (context == null || c6296o == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.m36988i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            }
            if ("com.huawei.android.pushagent".equals(c6296o.m36576j())) {
                return null;
            }
            HMSLog.m36988i("PushSelfShowLog", "get left bitmap from " + c6296o.m36576j());
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(c6296o.m36576j())).getBitmap();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m36986e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.m36986e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    /* renamed from: a */
    public static void m36528a(Context context, Notification.Builder builder, C6296o c6296o) {
        if (context != null && builder != null && c6296o != null) {
            builder.setSmallIcon(m36529b(context, c6296o));
        } else {
            HMSLog.m36986e("PushSelfShowLog", "msg is null");
        }
    }
}
