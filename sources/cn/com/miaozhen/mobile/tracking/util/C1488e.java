package cn.com.miaozhen.mobile.tracking.util;

import android.content.Context;
import ijiami_release01.NCall;
import java.io.InputStream;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.e */
/* loaded from: classes.dex */
public class C1488e {

    /* renamed from: a */
    private static C1488e f6361a;

    /* renamed from: b */
    private Context f6362b;

    /* renamed from: cn.com.miaozhen.mobile.tracking.util.e$a */
    public interface a {
        /* renamed from: a */
        void mo8437a(String str);
    }

    private C1488e(Context context) {
        this.f6362b = context;
    }

    /* renamed from: a */
    public static C1488e m8431a(Context context) {
        return (C1488e) NCall.m64616IL(new Object[]{102, context});
    }

    /* renamed from: b */
    public byte[] m8436b(Context context, String str) {
        return (byte[]) NCall.m64616IL(new Object[]{107, this, context, str});
    }

    /* renamed from: a */
    public String m8433a(Context context, String str, a aVar) {
        return (String) NCall.m64616IL(new Object[]{104, this, context, str, aVar});
    }

    /* renamed from: a */
    public byte[] m8434a(Context context, String str) {
        return (byte[]) NCall.m64616IL(new Object[]{105, this, context, str});
    }

    /* renamed from: a */
    private static byte[] m8432a(InputStream inputStream) {
        return (byte[]) NCall.m64616IL(new Object[]{103, inputStream});
    }

    /* renamed from: a */
    public byte[] m8435a(String str) {
        return (byte[]) NCall.m64616IL(new Object[]{106, this, str});
    }
}
