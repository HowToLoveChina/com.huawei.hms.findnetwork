package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.wa */
/* loaded from: classes8.dex */
public final class C8206wa extends Table {
    /* renamed from: a */
    public static int m50981a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50984b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    /* renamed from: c */
    public static void m50985c(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    /* renamed from: a */
    public static int m50982a(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12) {
        flatBufferBuilder.startTable(3);
        m50985c(flatBufferBuilder, i12);
        m50984b(flatBufferBuilder, i11);
        m50983a(flatBufferBuilder, i10);
        return m50981a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static void m50983a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(0, i10, 0);
    }
}
