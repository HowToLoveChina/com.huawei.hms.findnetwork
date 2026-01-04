package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.vx */
/* loaded from: classes8.dex */
public final class C8202vx extends Table {
    /* renamed from: a */
    public static int m50961a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50966b(FlatBufferBuilder flatBufferBuilder, float f10) {
        flatBufferBuilder.addFloat(3, f10, 0.0d);
    }

    /* renamed from: c */
    public static void m50968c(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(5, i10, 0);
    }

    /* renamed from: a */
    public static int m50962a(FlatBufferBuilder flatBufferBuilder, long j10, int i10, float f10, float f11, int i11, int i12) {
        flatBufferBuilder.startTable(6);
        m50965a(flatBufferBuilder, j10);
        m50968c(flatBufferBuilder, i12);
        m50967b(flatBufferBuilder, i11);
        m50966b(flatBufferBuilder, f11);
        m50963a(flatBufferBuilder, f10);
        m50964a(flatBufferBuilder, i10);
        return m50961a(flatBufferBuilder);
    }

    /* renamed from: b */
    public static void m50967b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(4, i10, 0);
    }

    /* renamed from: a */
    public static void m50963a(FlatBufferBuilder flatBufferBuilder, float f10) {
        flatBufferBuilder.addFloat(2, f10, 0.0d);
    }

    /* renamed from: a */
    public static void m50964a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    /* renamed from: a */
    public static void m50965a(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(0, j10, 0L);
    }
}
