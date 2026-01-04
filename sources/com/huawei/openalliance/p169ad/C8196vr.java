package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.vr */
/* loaded from: classes8.dex */
public final class C8196vr extends Table {
    /* renamed from: a */
    public static int m50842a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50844b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(0, i10, 0);
    }

    /* renamed from: a */
    public static int m50843a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startTable(1);
        m50844b(flatBufferBuilder, i10);
        return m50842a(flatBufferBuilder);
    }
}
