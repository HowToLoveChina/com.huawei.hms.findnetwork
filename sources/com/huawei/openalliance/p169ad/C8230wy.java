package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wy */
/* loaded from: classes8.dex */
public final class C8230wy extends Table {

    /* renamed from: com.huawei.openalliance.ad.wy$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51318a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8230wy m51319a(int i10) {
            return m51320a(new C8230wy(), i10);
        }

        /* renamed from: a */
        public C8230wy m51320a(C8230wy c8230wy, int i10) {
            return c8230wy.m51315b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51313a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8230wy m51315b(int i10, ByteBuffer byteBuffer) {
        m51314a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51314a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51316b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: c */
    public String m51317c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
