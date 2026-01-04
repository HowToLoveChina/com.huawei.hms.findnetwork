package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.vu */
/* loaded from: classes8.dex */
public final class C8199vu extends Table {
    /* renamed from: a */
    public static int m50867a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50870b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    /* renamed from: c */
    public static void m50871c(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 0);
    }

    /* renamed from: d */
    public static void m50872d(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(3, i10, 0);
    }

    /* renamed from: e */
    public static void m50873e(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    /* renamed from: f */
    public static void m50874f(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(5, i10, 0);
    }

    /* renamed from: a */
    public static int m50868a(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14, int i15) {
        flatBufferBuilder.startTable(6);
        m50874f(flatBufferBuilder, i15);
        m50873e(flatBufferBuilder, i14);
        m50872d(flatBufferBuilder, i13);
        m50871c(flatBufferBuilder, i12);
        m50870b(flatBufferBuilder, i11);
        m50869a(flatBufferBuilder, i10);
        return m50867a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static void m50869a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }
}
