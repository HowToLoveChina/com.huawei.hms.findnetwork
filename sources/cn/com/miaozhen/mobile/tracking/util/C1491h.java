package cn.com.miaozhen.mobile.tracking.util;

import android.content.Context;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import ijiami_release01.NCall;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.h */
/* loaded from: classes.dex */
public class C1491h {
    /* renamed from: a */
    private static Object m8465a(Context context) {
        return NCall.m64616IL(new Object[]{Integer.valueOf(SyncType.DELAY_START_SYNC), context});
    }

    /* renamed from: b */
    public static String m8471b(Context context) {
        return (String) NCall.m64616IL(new Object[]{140, context});
    }

    /* renamed from: c */
    private static int m8474c(Context context, String str) {
        return NCall.m64614II(new Object[]{143, context, str});
    }

    /* renamed from: d */
    private static int m8475d(Context context, String str) {
        return NCall.m64614II(new Object[]{Integer.valueOf(RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT), context, str});
    }

    /* renamed from: a */
    private static Object m8466a(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) {
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    /* renamed from: b */
    private static boolean m8472b() {
        return NCall.m64619IZ(new Object[]{141});
    }

    /* renamed from: a */
    private static Object m8467a(Object obj, String str, Class[] clsArr, Object... objArr) {
        return m8466a(obj.getClass(), str, obj, clsArr, objArr);
    }

    /* renamed from: b */
    public static boolean m8473b(Context context, String str) {
        return NCall.m64619IZ(new Object[]{142, context, str});
    }

    /* renamed from: a */
    private static Object m8468a(String str, String str2, Class[] clsArr, Object... objArr) {
        return m8466a(Class.forName(str), str2, null, clsArr, objArr);
    }

    /* renamed from: a */
    private static boolean m8469a() {
        return NCall.m64619IZ(new Object[]{138});
    }

    /* renamed from: a */
    public static boolean m8470a(Context context, String str) {
        return NCall.m64619IZ(new Object[]{139, context, str});
    }
}
