package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class MonitorFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public MonitorFb get(int i10) {
            return get(new MonitorFb(), i10);
        }

        public MonitorFb get(MonitorFb monitorFb, int i10) {
            return monitorFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addEventType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addRetryFlag(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 1);
    }

    public static void addUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static int createMonitorFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12) {
        flatBufferBuilder.startTable(3);
        addRetryFlag(flatBufferBuilder, i12);
        addUrl(flatBufferBuilder, i11);
        addEventType(flatBufferBuilder, i10);
        return endMonitorFb(flatBufferBuilder);
    }

    public static int createUrlVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endMonitorFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MonitorFb getRootAsMonitorFb(ByteBuffer byteBuffer) {
        return getRootAsMonitorFb(byteBuffer, new MonitorFb());
    }

    public static void startMonitorFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public static void startUrlVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public MonitorFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String eventType() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer eventTypeAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer eventTypeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int retryFlag() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 1;
    }

    public String url(int i10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int urlLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector urlVector() {
        return urlVector(new StringVector());
    }

    public static MonitorFb getRootAsMonitorFb(ByteBuffer byteBuffer, MonitorFb monitorFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return monitorFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public StringVector urlVector(StringVector stringVector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
