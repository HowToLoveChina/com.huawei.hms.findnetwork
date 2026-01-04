package tr;

import java.nio.charset.StandardCharsets;

/* renamed from: tr.j */
/* loaded from: classes8.dex */
public class C13066j {

    /* renamed from: a */
    public String f59450a;

    /* renamed from: b */
    public long f59451b;

    /* renamed from: c */
    public byte[] f59452c;

    /* renamed from: tr.j$b */
    public static final class b {

        /* renamed from: a */
        public String f59453a;

        /* renamed from: b */
        public long f59454b;

        /* renamed from: c */
        public byte[] f59455c;

        /* renamed from: d */
        public C13066j m78822d() {
            return new C13066j(this);
        }

        /* renamed from: e */
        public b m78823e(byte[] bArr) {
            this.f59455c = bArr;
            return this;
        }

        /* renamed from: f */
        public b m78824f(long j10) {
            this.f59454b = j10;
            return this;
        }

        /* renamed from: g */
        public b m78825g(String str) {
            this.f59453a = str;
            return this;
        }
    }

    public C13066j(b bVar) {
        this.f59450a = bVar.f59453a;
        this.f59451b = bVar.f59454b;
        this.f59452c = bVar.f59455c;
    }

    /* renamed from: a */
    public final byte[] m78818a() {
        return this.f59452c;
    }

    public String toString() {
        return "ResponseBodyAdapter{contentType='" + this.f59450a + "', contentLength=" + this.f59451b + ", responseByte=" + new String(this.f59452c, StandardCharsets.UTF_8) + '}';
    }
}
