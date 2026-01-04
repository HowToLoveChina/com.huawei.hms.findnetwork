package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xb */
/* loaded from: classes8.dex */
public final class C8234xb extends Table {

    /* renamed from: com.huawei.openalliance.ad.xb$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51401a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8234xb m51402a(int i10) {
            return m51403a(new C8234xb(), i10);
        }

        /* renamed from: a */
        public C8234xb m51403a(C8234xb c8234xb, int i10) {
            return c8234xb.m51399b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public StringVector m51395a(StringVector stringVector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public StringVector m51398b() {
        return m51395a(new StringVector());
    }

    /* renamed from: c */
    public int m51400c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public String m51396a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8234xb m51399b(int i10, ByteBuffer byteBuffer) {
        m51397a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51397a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
