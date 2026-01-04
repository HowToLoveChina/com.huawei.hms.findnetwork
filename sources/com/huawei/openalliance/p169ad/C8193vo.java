package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.vo */
/* loaded from: classes8.dex */
public final class C8193vo extends Table {
    /* renamed from: a */
    public static int m50792a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50795b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    /* renamed from: a */
    public static int m50793a(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        m50795b(flatBufferBuilder, i11);
        m50794a(flatBufferBuilder, i10);
        return m50792a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static void m50794a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }
}
