package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.vy */
/* loaded from: classes8.dex */
public final class C8203vy extends Table {
    /* renamed from: a */
    public static int m50969a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50973b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    /* renamed from: a */
    public static int m50970a(FlatBufferBuilder flatBufferBuilder, int i10, int i11, float f10) {
        flatBufferBuilder.startTable(3);
        m50971a(flatBufferBuilder, f10);
        m50973b(flatBufferBuilder, i11);
        m50972a(flatBufferBuilder, i10);
        return m50969a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static void m50971a(FlatBufferBuilder flatBufferBuilder, float f10) {
        flatBufferBuilder.addFloat(2, f10, 0.0d);
    }

    /* renamed from: a */
    public static void m50972a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(0, i10, 0);
    }
}
