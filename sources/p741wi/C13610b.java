package p741wi;

import com.huawei.cloud.base.http.AbstractC4623z;
import com.huawei.hms.drive.C5203bh;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: wi.b */
/* loaded from: classes.dex */
public final class C13610b extends AbstractC4623z {

    /* renamed from: a */
    public final C5203bh f61229a;

    /* renamed from: b */
    public final int f61230b;

    /* renamed from: c */
    public final String f61231c;

    /* renamed from: d */
    public final ArrayList<String> f61232d;

    /* renamed from: e */
    public final ArrayList<String> f61233e;

    public C13610b(C5203bh c5203bh) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f61232d = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.f61233e = arrayList2;
        this.f61229a = c5203bh;
        int iM31129b = c5203bh.m31129b();
        this.f61230b = iM31129b == -1 ? 0 : iM31129b;
        this.f61231c = c5203bh.m31130c();
        for (Map.Entry<String, List<String>> entry : c5203bh.m31132e().m30927c().entrySet()) {
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
        C5203bh c5203bh = this.f61229a;
        if (c5203bh != null) {
            c5203bh.close();
        }
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: b */
    public InputStream mo28353b() throws IOException {
        InputStream inputStreamM31160b = this.f61229a.m31133f().m31160b();
        if (inputStreamM31160b == null) {
            return null;
        }
        return new a(inputStreamM31160b);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: c */
    public String mo28354c() {
        return this.f61229a.m31127a("Content-Encoding");
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: d */
    public String mo28355d() {
        return this.f61229a.m31127a("Content-Type");
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: e */
    public int mo28356e() {
        return this.f61232d.size();
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: f */
    public String mo28357f(int i10) {
        return this.f61232d.get(i10);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: g */
    public String mo28358g(int i10) {
        return this.f61233e.get(i10);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: h */
    public String mo28359h() {
        return this.f61231c;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: i */
    public int mo28360i() {
        return this.f61230b;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4623z
    /* renamed from: j */
    public String mo28361j() {
        String strM31127a = this.f61229a.m31127a("0");
        if (strM31127a == null || !strM31127a.startsWith("HTTP/1.")) {
            return null;
        }
        return strM31127a;
    }

    /* renamed from: k */
    public long m81826k() {
        String strM31127a = this.f61229a.m31127a("Content-Length");
        if (strM31127a == null) {
            return -1L;
        }
        return Long.parseLong(strM31127a);
    }

    /* renamed from: wi.b$a */
    public final class a extends FilterInputStream {

        /* renamed from: a */
        public long f61234a;

        public a(InputStream inputStream) {
            super(inputStream);
            this.f61234a = 0L;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 == -1) {
                m81827s();
            } else {
                this.f61234a++;
            }
            return i10;
        }

        /* renamed from: s */
        public final void m81827s() throws IOException {
            long jM81826k = C13610b.this.m81826k();
            if (jM81826k == -1) {
                return;
            }
            long j10 = this.f61234a;
            if (j10 == 0 || j10 >= jM81826k) {
                return;
            }
            throw new IOException("Connection closed prematurely: bytesRead = " + this.f61234a + ", Content-Length = " + jM81826k);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 == -1) {
                m81827s();
            } else {
                this.f61234a += i12;
            }
            return i12;
        }
    }
}
