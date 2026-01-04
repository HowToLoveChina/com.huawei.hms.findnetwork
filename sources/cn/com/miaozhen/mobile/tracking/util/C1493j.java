package cn.com.miaozhen.mobile.tracking.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.location.BDLocation;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import ijiami_release01.NCall;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.j */
/* loaded from: classes.dex */
public class C1493j {
    /* renamed from: a */
    public static synchronized long m8486a(Context context, String str, String str2) {
        return NCall.m64615IJ(new Object[]{154, context, str, str2});
    }

    /* renamed from: b */
    public static synchronized String m8491b(Context context, String str, String str2) {
        return (String) NCall.m64616IL(new Object[]{159, context, str, str2});
    }

    /* renamed from: c */
    public static synchronized boolean m8493c(Context context, String str, String str2) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(BDLocation.TypeNetWorkLocation), context, str, str2});
    }

    /* renamed from: a */
    public static synchronized SharedPreferences m8487a(Context context, String str) {
        return (SharedPreferences) NCall.m64616IL(new Object[]{155, context, str});
    }

    /* renamed from: b */
    public static void m8492b(Context context, String str) {
        NCall.m64618IV(new Object[]{Integer.valueOf(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE), context, str});
    }

    /* renamed from: a */
    public static String m8488a(Context context) {
        return (String) NCall.m64616IL(new Object[]{156, context});
    }

    /* renamed from: a */
    public static synchronized void m8489a(Context context, String str, String str2, long j10) {
        NCall.m64618IV(new Object[]{157, context, str, str2, Long.valueOf(j10)});
    }

    /* renamed from: a */
    public static synchronized void m8490a(Context context, String str, String str2, String str3) {
        NCall.m64618IV(new Object[]{158, context, str, str2, str3});
    }
}
