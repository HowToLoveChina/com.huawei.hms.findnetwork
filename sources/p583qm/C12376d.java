package p583qm;

import com.huawei.cloud.base.http.AbstractC4623z;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.C11922g0;

/* renamed from: qm.d */
/* loaded from: classes6.dex */
public class C12376d extends AbstractC4623z {

    /* renamed from: a */
    public final C11922g0 f57192a;

    /* renamed from: b */
    public final int f57193b;

    /* renamed from: c */
    public final String f57194c;

    /* renamed from: d */
    public final ArrayList<String> f57195d;

    /* renamed from: e */
    public final ArrayList<String> f57196e;

    public C12376d(C11922g0 c11922g0) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f57195d = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.f57196e = arrayList2;
        this.f57192a = c11922g0;
        int iM71597u = c11922g0.m71597u();
        this.f57193b = iM71597u == -1 ? 0 : iM71597u;
        this.f57194c = c11922g0.m71602z();
        for (Map.Entry<String, List<String>> entry : c11922g0.m71601y().m71858k().entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                for (String str : entry.getValue()) {
                    if (str != null) {
                        arrayList.add(key);
                        arrayList2.add(str);
                    }
                }
            }
        }
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: a */
    public void mo28352a() {
        C11922g0 c11922g0 = this.f57192a;
        if (c11922g0 != null) {
            c11922g0.close();
        }
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: b */
    public InputStream mo28353b() throws IOException {
        InputStream inputStreamM71632s = this.f57192a.m71595s().m71632s();
        if (inputStreamM71632s == null) {
            return null;
        }
        return new a(inputStreamM71632s);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: c */
    public String mo28354c() {
        return this.f57192a.m71599w("Content-Encoding");
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: d */
    public String mo28355d() {
        return this.f57192a.m71599w("Content-Type");
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: e */
    public int mo28356e() {
        return this.f57195d.size();
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: f */
    public String mo28357f(int i10) {
        return this.f57195d.get(i10);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: g */
    public String mo28358g(int i10) {
        return this.f57196e.get(i10);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: h */
    public String mo28359h() {
        return this.f57194c;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: i */
    public int mo28360i() {
        return this.f57193b;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: j */
    public String mo28361j() {
        String strM71599w = this.f57192a.m71599w("0");
        if (strM71599w == null || !strM71599w.startsWith("HTTP/1.")) {
            return null;
        }
        return strM71599w;
    }

    /* renamed from: k */
    public long m74440k() {
        String strM71599w = this.f57192a.m71599w("Content-Length");
        if (strM71599w == null) {
            return -1L;
        }
        return Long.parseLong(strM71599w);
    }

    /* renamed from: qm.d$a */
    public final class a extends FilterInputStream {

        /* renamed from: a */
        public long f57197a;

        public a(InputStream inputStream) {
            super(inputStream);
            this.f57197a = 0L;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 == -1) {
                m74441s();
            } else {
                this.f57197a += i12;
            }
            return i12;
        }

        /* renamed from: s */
        public final void m74441s() throws IOException {
            long jM74440k = C12376d.this.m74440k();
            if (jM74440k == -1) {
                return;
            }
            long j10 = this.f57197a;
            if (j10 == 0 || j10 >= jM74440k) {
                return;
            }
            throw new IOException("Connection closed prematurely: bytesRead = " + this.f57197a + ", Content-Length = " + jM74440k);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 == -1) {
                m74441s();
            } else {
                this.f57197a++;
            }
            return i10;
        }
    }
}
