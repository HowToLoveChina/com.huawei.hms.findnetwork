package com.huawei.hms.network.file.p130a;

import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.C6241l;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.download.api.GetRequest;

/* renamed from: com.huawei.hms.network.file.a.d */
/* loaded from: classes8.dex */
public class C6188d extends AbstractC6240k<GetRequest> {

    /* renamed from: v */
    private String f29274v;

    /* renamed from: w */
    long f29275w;

    /* renamed from: x */
    long f29276x;

    /* renamed from: y */
    private C6191g f29277y;

    public C6188d(long j10, long j11, long j12, String str, int i10, long j13) {
        super(null, j10, j13);
        this.f29277y = new C6191g();
        this.f29484t = i10;
        this.f29275w = j11;
        this.f29276x = j12;
        this.f29274v = str;
    }

    /* renamed from: A */
    public long m36019A() {
        return this.f29275w;
    }

    /* renamed from: B */
    public String m36020B() {
        return m36018a(m36341p().getId(), this.f29274v);
    }

    /* renamed from: C */
    public boolean m36021C() {
        return this.f29484t > 1 || this.f29275w + this.f29482r > 0 || this.f29276x > 0;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: a */
    public long mo36022a() {
        return (this.f29276x - this.f29275w) + 1;
    }

    /* renamed from: b */
    public void m36025b(long j10) {
        this.f29481q = j10;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: d */
    public InterfaceC6234e.b mo36026d() {
        return InterfaceC6234e.b.DOWNLOAD;
    }

    /* renamed from: e */
    public void m36027e(int i10) {
        this.f29484t = i10;
    }

    /* renamed from: f */
    public void m36028f(String str) {
        this.f29274v = str;
    }

    @Override // com.huawei.hms.network.file.core.task.AbstractC6240k
    /* renamed from: m */
    public C6191g mo36029m() {
        return this.f29277y;
    }

    @Override // com.huawei.hms.network.file.core.task.AbstractC6240k
    public String toString() {
        return "DownloadTask{startPos=" + this.f29275w + ", endPos=" + this.f29276x + ", finishedSize=" + this.f29482r + super.toString() + '}';
    }

    @Override // com.huawei.hms.network.file.core.task.AbstractC6240k
    /* renamed from: x */
    public AbstractC6240k mo36030x() {
        C6188d c6188d = new C6188d(m36341p(), (C6241l) m36346u(), this.f29482r, this.f29275w, this.f29276x, this.f29274v, this.f29484t, mo36241f());
        c6188d.f29277y = this.f29277y;
        c6188d.m36327b(m36337k());
        c6188d.mo36236a(mo36238b());
        return c6188d;
    }

    /* renamed from: y */
    public long m36031y() {
        return this.f29276x;
    }

    /* renamed from: z */
    public String m36032z() {
        return this.f29274v;
    }

    public C6188d(long j10, long j11, long j12, String str, long j13) {
        this(j10, j11, j12, str, 1, j13);
    }

    /* renamed from: a */
    public static String m36018a(long j10, String str) {
        return str + ".tmp" + j10;
    }

    public C6188d(GetRequest getRequest, long j10, long j11, long j12, String str, int i10) {
        super(getRequest, j10);
        this.f29277y = new C6191g();
        this.f29484t = i10;
        this.f29275w = j11;
        this.f29276x = j12;
        this.f29274v = str;
        this.f29481q = getRequest.getFileSize();
    }

    /* renamed from: a */
    public void m36023a(long j10, long j11) {
        this.f29275w = j10;
        this.f29276x = j11;
    }

    public C6188d(GetRequest getRequest, long j10, long j11, long j12, String str, int i10, long j13) {
        super(getRequest, j10, j13);
        this.f29277y = new C6191g();
        this.f29484t = i10;
        this.f29275w = j11;
        this.f29276x = j12;
        this.f29274v = str;
        if (getRequest != null) {
            this.f29481q = getRequest.getFileSize();
        }
    }

    /* renamed from: a */
    public void m36024a(long j10, long j11, int i10) {
        this.f29277y.m36039a(j10, j11, i10);
    }

    public C6188d(GetRequest getRequest, C6241l c6241l, long j10, long j11, long j12, String str, int i10, long j13) {
        super(getRequest, j10, j13);
        this.f29277y = new C6191g();
        this.f29484t = i10;
        this.f29275w = j11;
        this.f29276x = j12;
        this.f29274v = str;
        if (getRequest != null) {
            this.f29481q = getRequest.getFileSize();
        }
        m36323a(c6241l);
    }
}
