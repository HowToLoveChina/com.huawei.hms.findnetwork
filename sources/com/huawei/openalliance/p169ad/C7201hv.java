package com.huawei.openalliance.p169ad;

import android.os.Process;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.text.SimpleDateFormat;

/* renamed from: com.huawei.openalliance.ad.hv */
/* loaded from: classes8.dex */
public class C7201hv {

    /* renamed from: a */
    private String f33128a;

    /* renamed from: b */
    private String f33129b;

    /* renamed from: c */
    private int f33130c;

    /* renamed from: e */
    private String f33132e;

    /* renamed from: f */
    private int f33133f;

    /* renamed from: d */
    private long f33131d = 0;

    /* renamed from: g */
    private final StringBuilder f33134g = new StringBuilder();

    public C7201hv(String str, int i10, String str2) {
        this.f33128a = null;
        this.f33129b = "HA";
        this.f33130c = 0;
        this.f33128a = str;
        this.f33130c = i10;
        if (str2 != null) {
            this.f33129b = str2;
        }
        m43879c();
    }

    /* renamed from: c */
    private C7201hv m43879c() {
        this.f33131d = System.currentTimeMillis();
        this.f33132e = Thread.currentThread().getName();
        this.f33133f = Process.myPid();
        return this;
    }

    /* renamed from: a */
    public <T> C7201hv m43880a(T t10) {
        this.f33134g.append(t10);
        return this;
    }

    /* renamed from: b */
    public String m43882b() {
        StringBuilder sb2 = new StringBuilder();
        m43878b(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        m43877a(sb2);
        m43878b(sb2);
        return sb2.toString();
    }

    /* renamed from: b */
    private StringBuilder m43878b(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append((CharSequence) this.f33134g);
        return sb2;
    }

    /* renamed from: a */
    public String m43881a() {
        StringBuilder sb2 = new StringBuilder();
        m43877a(sb2);
        return sb2.toString();
    }

    /* renamed from: a */
    private StringBuilder m43877a(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormatM47545a = AbstractC7741ao.m47545a("yyyy-MM-dd HH:mm:ss.SSS");
        sb2.append('[');
        sb2.append(simpleDateFormatM47545a.format(Long.valueOf(this.f33131d)));
        String strM43841a = AbstractC7189hs.m43841a(this.f33130c);
        sb2.append(' ');
        sb2.append(strM43841a);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f33128a);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f33129b);
        sb2.append(' ');
        sb2.append(this.f33133f);
        sb2.append(':');
        sb2.append(this.f33132e);
        sb2.append(']');
        return sb2;
    }
}
