package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wh */
/* loaded from: classes8.dex */
public final class C8213wh extends Table {

    /* renamed from: com.huawei.openalliance.ad.wh$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51061a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8213wh m51062a(int i10) {
            return m51063a(new C8213wh(), i10);
        }

        /* renamed from: a */
        public C8213wh m51063a(C8213wh c8213wh, int i10) {
            return c8213wh.m51060b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public StringVector m51056a() {
        return m51057a(new StringVector());
    }

    /* renamed from: b */
    public int m51059b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public StringVector m51057a(StringVector stringVector) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8213wh m51060b(int i10, ByteBuffer byteBuffer) {
        m51058a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51058a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
