package p214d2;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import p630s2.C12676k;
import p759x1.InterfaceC13681f;

/* renamed from: d2.b */
/* loaded from: classes.dex */
public class C8988b implements InterfaceC13681f {

    /* renamed from: b */
    public final InterfaceC8989c f45587b;

    /* renamed from: c */
    public final URL f45588c;

    /* renamed from: d */
    public final String f45589d;

    /* renamed from: e */
    public String f45590e;

    /* renamed from: f */
    public URL f45591f;

    /* renamed from: g */
    public volatile byte[] f45592g;

    /* renamed from: h */
    public int f45593h;

    public C8988b(URL url) {
        this(url, InterfaceC8989c.f45595b);
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        messageDigest.update(m56819d());
    }

    /* renamed from: c */
    public String m56818c() {
        String str = this.f45589d;
        return str != null ? str : ((URL) C12676k.m76276d(this.f45588c)).toString();
    }

    /* renamed from: d */
    public final byte[] m56819d() {
        if (this.f45592g == null) {
            this.f45592g = m56818c().getBytes(InterfaceC13681f.f61610a);
        }
        return this.f45592g;
    }

    /* renamed from: e */
    public Map<String, String> m56820e() {
        return this.f45587b.mo56824a();
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (!(obj instanceof C8988b)) {
            return false;
        }
        C8988b c8988b = (C8988b) obj;
        return m56818c().equals(c8988b.m56818c()) && this.f45587b.equals(c8988b.f45587b);
    }

    /* renamed from: f */
    public final String m56821f() {
        if (TextUtils.isEmpty(this.f45590e)) {
            String string = this.f45589d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) C12676k.m76276d(this.f45588c)).toString();
            }
            this.f45590e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f45590e;
    }

    /* renamed from: g */
    public final URL m56822g() throws MalformedURLException {
        if (this.f45591f == null) {
            this.f45591f = new URL(m56821f());
        }
        return this.f45591f;
    }

    /* renamed from: h */
    public URL m56823h() throws MalformedURLException {
        return m56822g();
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        if (this.f45593h == 0) {
            int iHashCode = m56818c().hashCode();
            this.f45593h = iHashCode;
            this.f45593h = (iHashCode * 31) + this.f45587b.hashCode();
        }
        return this.f45593h;
    }

    public String toString() {
        return m56818c();
    }

    public C8988b(String str) {
        this(str, InterfaceC8989c.f45595b);
    }

    public C8988b(URL url, InterfaceC8989c interfaceC8989c) {
        this.f45588c = (URL) C12676k.m76276d(url);
        this.f45589d = null;
        this.f45587b = (InterfaceC8989c) C12676k.m76276d(interfaceC8989c);
    }

    public C8988b(String str, InterfaceC8989c interfaceC8989c) {
        this.f45588c = null;
        this.f45589d = C12676k.m76274b(str);
        this.f45587b = (InterfaceC8989c) C12676k.m76276d(interfaceC8989c);
    }
}
