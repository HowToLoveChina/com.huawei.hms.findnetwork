package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class AdvertiserInfoFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public AdvertiserInfoFb get(int i10) {
            return get(new AdvertiserInfoFb(), i10);
        }

        public AdvertiserInfoFb get(AdvertiserInfoFb advertiserInfoFb, int i10) {
            return advertiserInfoFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addKey(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addSeq(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(0, i10, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static int createAdvertiserInfoFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12) {
        flatBufferBuilder.startTable(3);
        addValue(flatBufferBuilder, i12);
        addKey(flatBufferBuilder, i11);
        addSeq(flatBufferBuilder, i10);
        return endAdvertiserInfoFb(flatBufferBuilder);
    }

    public static int endAdvertiserInfoFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static AdvertiserInfoFb getRootAsAdvertiserInfoFb(ByteBuffer byteBuffer) {
        return getRootAsAdvertiserInfoFb(byteBuffer, new AdvertiserInfoFb());
    }

    public static void startAdvertiserInfoFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public AdvertiserInfoFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String key() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer keyAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer keyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public int seq() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String value() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public static AdvertiserInfoFb getRootAsAdvertiserInfoFb(ByteBuffer byteBuffer, AdvertiserInfoFb advertiserInfoFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return advertiserInfoFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
