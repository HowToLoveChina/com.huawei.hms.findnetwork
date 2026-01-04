package p405jt;

import android.os.Process;
import com.huawei.hms.network.embedded.C5929g4;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: jt.m */
/* loaded from: classes2.dex */
public class C10927m {

    /* renamed from: a */
    public String f51825a;

    /* renamed from: b */
    public String f51826b;

    /* renamed from: c */
    public int f51827c;

    /* renamed from: e */
    public String f51829e;

    /* renamed from: f */
    public int f51830f;

    /* renamed from: d */
    public long f51828d = 0;

    /* renamed from: g */
    public final StringBuilder f51831g = new StringBuilder();

    public C10927m(String str, int i10, String str2) {
        this.f51825a = null;
        this.f51826b = "HA";
        this.f51827c = 0;
        this.f51825a = str;
        this.f51827c = i10;
        if (str2 != null) {
            this.f51826b = str2;
        }
        m66031e();
    }

    /* renamed from: a */
    public String m66027a() {
        StringBuilder sb2 = new StringBuilder();
        m66028b(sb2);
        return sb2.toString();
    }

    /* renamed from: b */
    public final StringBuilder m66028b(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append((CharSequence) this.f51831g);
        return sb2;
    }

    /* renamed from: c */
    public <T> C10927m m66029c(T t10) {
        this.f51831g.append(t10);
        return this;
    }

    /* renamed from: d */
    public final StringBuilder m66030d(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.f51828d)));
        String strM65980a = AbstractC10916b.m65980a(this.f51827c);
        sb2.append(' ');
        sb2.append(strM65980a);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f51825a);
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f51826b);
        sb2.append(' ');
        sb2.append(this.f51830f);
        sb2.append(':');
        sb2.append(this.f51829e);
        sb2.append(']');
        return sb2;
    }

    /* renamed from: e */
    public final C10927m m66031e() {
        this.f51828d = System.currentTimeMillis();
        this.f51829e = Thread.currentThread().getName();
        this.f51830f = Process.myPid();
        return this;
    }

    /* renamed from: f */
    public String m66032f() {
        StringBuilder sb2 = new StringBuilder();
        m66030d(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        m66030d(sb2);
        m66028b(sb2);
        return sb2.toString();
    }
}
