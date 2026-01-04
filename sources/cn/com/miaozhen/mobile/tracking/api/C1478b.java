package cn.com.miaozhen.mobile.tracking.api;

import android.content.Context;
import cn.com.miaozhen.mobile.tracking.api.C1480d;
import cn.com.miaozhen.mobile.tracking.p055a.C1466c;
import cn.com.miaozhen.mobile.tracking.util.C1490g;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import ijiami_release01.NCall;
import java.util.HashMap;
import java.util.Map;

/* renamed from: cn.com.miaozhen.mobile.tracking.api.b */
/* loaded from: classes.dex */
public class C1478b {

    /* renamed from: a */
    private static C1478b f6320a;

    /* renamed from: b */
    public static C1490g<String, MzCallBack> f6321b;

    /* renamed from: c */
    public static C1490g<String, C1480d.a> f6322c;

    /* renamed from: d */
    public static Map<String, String> f6323d;

    /* renamed from: e */
    public static Map<String, Long> f6324e;

    /* renamed from: f */
    private static String[] f6325f;

    /* renamed from: g */
    private final Context f6326g;

    /* renamed from: h */
    private C1479c f6327h = null;

    static {
        NCall.m64618IV(new Object[]{52});
    }

    private C1478b(Context context) {
        if (context == null) {
            throw new NullPointerException("RecordEventMessage context can`t be null!");
        }
        this.f6326g = context;
        f6323d = new HashMap();
        f6324e = new HashMap();
    }

    /* renamed from: a */
    private long m8368a(C1466c c1466c, long j10) {
        return NCall.m64615IJ(new Object[]{53, this, c1466c, Long.valueOf(j10)});
    }

    /* renamed from: b */
    public static C1478b m8371b(Context context) {
        return (C1478b) NCall.m64616IL(new Object[]{56, context});
    }

    /* renamed from: c */
    private static String m8372c(Context context) {
        return (String) NCall.m64616IL(new Object[]{57, context});
    }

    /* renamed from: a */
    public static String m8369a(Context context) {
        return (String) NCall.m64616IL(new Object[]{54, context});
    }

    /* renamed from: a */
    private static String m8370a(String str, String str2, String str3, String str4) {
        return (String) NCall.m64616IL(new Object[]{55, str, str2, str3, str4});
    }

    /* renamed from: a */
    public synchronized void m8373a(String str, MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{58, this, str, mzCallBack, aVar});
    }
}
