package cn.com.miaozhen.mobile.tracking.api;

import android.content.Context;
import cn.com.miaozhen.mobile.tracking.util.C1488e;
import ijiami_release01.NCall;
import java.util.HashSet;

/* renamed from: cn.com.miaozhen.mobile.tracking.api.c */
/* loaded from: classes.dex */
public class C1479c extends Thread {

    /* renamed from: a */
    private String f6328a;

    /* renamed from: b */
    private Context f6329b;

    /* renamed from: c */
    private boolean f6330c;

    /* renamed from: d */
    private boolean f6331d = false;

    /* renamed from: e */
    private C1488e f6332e;

    /* renamed from: f */
    private HashSet<String> f6333f;

    public C1479c(String str, Context context, boolean z10) {
        this.f6332e = null;
        this.f6333f = null;
        this.f6328a = str;
        this.f6329b = context;
        this.f6330c = z10;
        this.f6333f = new HashSet<>();
        this.f6332e = C1488e.m8431a(context);
    }

    /* renamed from: a */
    private synchronized void m8374a() {
        NCall.m64618IV(new Object[]{47, this});
    }

    @Override // java.lang.Thread
    public void interrupt() {
        NCall.m64618IV(new Object[]{50, this});
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        NCall.m64618IV(new Object[]{51, this});
    }

    /* renamed from: a */
    private void m8375a(String str, long j10) {
        NCall.m64618IV(new Object[]{48, this, str, Long.valueOf(j10)});
    }

    /* renamed from: a */
    private void m8376a(String str, String str2) {
        NCall.m64618IV(new Object[]{49, this, str, str2});
    }
}
