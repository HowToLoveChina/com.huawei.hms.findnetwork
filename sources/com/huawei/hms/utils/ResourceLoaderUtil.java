package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;

/* loaded from: classes8.dex */
public abstract class ResourceLoaderUtil {

    /* renamed from: a */
    private static Context f30212a;

    /* renamed from: b */
    private static String f30213b;

    public static int getAnimId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", f30213b);
    }

    public static int getColorId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, RemoteMessageConst.Notification.COLOR, f30213b);
    }

    public static int getDimenId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", f30213b);
    }

    public static Drawable getDrawable(String str) {
        Context context = f30212a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", f30213b);
    }

    public static int getIdId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", f30213b);
    }

    public static int getLayoutId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", f30213b);
    }

    public static String getString(String str) {
        Context context = f30212a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, ExtractOWiFiHelper.STING_NODE, f30213b);
    }

    public static int getStyleId(String str) {
        Context context = f30212a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, TemplateStyleRecord.STYLE, f30213b);
    }

    public static Context getmContext() {
        return f30212a;
    }

    public static void setmContext(Context context) {
        f30212a = context;
        if (context != null) {
            f30213b = context.getPackageName();
        } else {
            f30213b = null;
            HMSLog.m36986e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = f30212a;
        if (context == null) {
            return "";
        }
        return context.getResources().getString(getStringId(str), objArr);
    }
}
