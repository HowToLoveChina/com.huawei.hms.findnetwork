package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.huawei.cloud.base.http.c */
/* loaded from: classes.dex */
public final class C4598c extends AbstractC4596b {

    /* renamed from: c */
    public final byte[] f21148c;

    /* renamed from: d */
    public final int f21149d;

    /* renamed from: e */
    public final int f21150e;

    public C4598c(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    /* renamed from: b */
    public boolean mo28153b() {
        return true;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4596b
    /* renamed from: c */
    public InputStream mo28163c() {
        return new ByteArrayInputStream(this.f21148c, this.f21149d, this.f21150e);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4596b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C4598c mo28165e(String str) {
        return (C4598c) super.mo28165e(str);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public long getLength() {
        return this.f21150e;
    }

    public C4598c(String str, byte[] bArr, int i10, int i11) {
        super(str);
        this.f21148c = (byte[]) C4627a0.m28391d(bArr);
        C4627a0.m28390c(i10 >= 0 && i11 >= 0 && i10 + i11 <= bArr.length, "offset %s, length %s, array length %s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(bArr.length));
        this.f21149d = i10;
        this.f21150e = i11;
    }
}
