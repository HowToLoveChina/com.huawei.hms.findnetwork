package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* renamed from: com.huawei.openalliance.ad.wc */
/* loaded from: classes8.dex */
public final class C8208wc extends Table {
    /* renamed from: a */
    public static int m50990a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    /* renamed from: b */
    public static void m50994b(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    /* renamed from: c */
    public static void m50995c(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    /* renamed from: d */
    public static void m50996d(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    /* renamed from: a */
    public static int m50991a(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13) {
        flatBufferBuilder.startTable(4);
        m50996d(flatBufferBuilder, i13);
        m50995c(flatBufferBuilder, i12);
        m50994b(flatBufferBuilder, i11);
        m50993a(flatBufferBuilder, i10);
        return m50990a(flatBufferBuilder);
    }

    /* renamed from: a */
    public static int m50992a(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    /* renamed from: a */
    public static void m50993a(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }
}
