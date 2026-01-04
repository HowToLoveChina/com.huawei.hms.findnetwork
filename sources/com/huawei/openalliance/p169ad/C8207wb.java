package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.wb */
/* loaded from: classes8.dex */
public final class C8207wb extends Table {
    /* renamed from: a */
    public static int m50986a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50989b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    /* renamed from: a */
    public static int m50987a(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        m50989b(flatBufferBuilder, i11);
        m50988a(flatBufferBuilder, i10);
        return m50986a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static void m50988a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(0, i10, 0);
    }
}
