package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wq */
/* loaded from: classes8.dex */
public final class C8222wq extends Table {

    /* renamed from: com.huawei.openalliance.ad.wq$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51252a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8222wq m51253a(int i10) {
            return m51254a(new C8222wq(), i10);
        }

        /* renamed from: a */
        public C8222wq m51254a(C8222wq c8222wq, int i10) {
            return c8222wq.m51250b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51248a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8222wq m51250b(int i10, ByteBuffer byteBuffer) {
        m51249a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51249a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51251b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
