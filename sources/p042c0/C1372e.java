package p042c0;

import android.util.Base64;
import java.util.List;
import p243e0.C9373h;

/* renamed from: c0.e */
/* loaded from: classes.dex */
public final class C1372e {

    /* renamed from: a */
    public final String f5883a;

    /* renamed from: b */
    public final String f5884b;

    /* renamed from: c */
    public final String f5885c;

    /* renamed from: d */
    public final List<List<byte[]>> f5886d;

    /* renamed from: e */
    public final int f5887e = 0;

    /* renamed from: f */
    public final String f5888f;

    public C1372e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f5883a = (String) C9373h.m58745f(str);
        this.f5884b = (String) C9373h.m58745f(str2);
        this.f5885c = (String) C9373h.m58745f(str3);
        this.f5886d = (List) C9373h.m58745f(list);
        this.f5888f = m7879a(str, str2, str3);
    }

    /* renamed from: a */
    public final String m7879a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    /* renamed from: b */
    public List<List<byte[]>> m7880b() {
        return this.f5886d;
    }

    /* renamed from: c */
    public int m7881c() {
        return this.f5887e;
    }

    /* renamed from: d */
    public String m7882d() {
        return this.f5888f;
    }

    /* renamed from: e */
    public String m7883e() {
        return this.f5883a;
    }

    /* renamed from: f */
    public String m7884f() {
        return this.f5884b;
    }

    /* renamed from: g */
    public String m7885g() {
        return this.f5885c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f5883a + ", mProviderPackage: " + this.f5884b + ", mQuery: " + this.f5885c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f5886d.size(); i10++) {
            sb2.append(" [");
            List<byte[]> list = this.f5886d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f5887e);
        return sb2.toString();
    }
}
