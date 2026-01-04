package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.vp */
/* loaded from: classes8.dex */
public final class C8194vp extends Table {
    /* renamed from: a */
    public static int m50796a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50799b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    /* renamed from: a */
    public static int m50797a(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        m50799b(flatBufferBuilder, i11);
        m50798a(flatBufferBuilder, i10);
        return m50796a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static void m50798a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }
}
