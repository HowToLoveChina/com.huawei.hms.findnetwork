package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wv */
/* loaded from: classes8.dex */
public final class C8227wv extends Table {

    /* renamed from: com.huawei.openalliance.ad.wv$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51290a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8227wv m51291a(int i10) {
            return m51292a(new C8227wv(), i10);
        }

        /* renamed from: a */
        public C8227wv m51292a(C8227wv c8227wv, int i10) {
            return c8227wv.m51288b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51286a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8227wv m51288b(int i10, ByteBuffer byteBuffer) {
        m51287a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51287a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51289b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
