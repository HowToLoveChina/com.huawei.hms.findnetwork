package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class BiddingInfoFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public BiddingInfoFb get(int i10) {
            return get(new BiddingInfoFb(), i10);
        }

        public BiddingInfoFb get(BiddingInfoFb biddingInfoFb, int i10) {
            return biddingInfoFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addCur(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addLurl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addNurl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addPrice(FlatBufferBuilder flatBufferBuilder, float f10) {
        flatBufferBuilder.addFloat(1, f10, 0.0d);
    }

    public static int createBiddingInfoFb(FlatBufferBuilder flatBufferBuilder, int i10, float f10, int i11, int i12) {
        flatBufferBuilder.startTable(4);
        addNurl(flatBufferBuilder, i12);
        addLurl(flatBufferBuilder, i11);
        addPrice(flatBufferBuilder, f10);
        addCur(flatBufferBuilder, i10);
        return endBiddingInfoFb(flatBufferBuilder);
    }

    public static int endBiddingInfoFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static BiddingInfoFb getRootAsBiddingInfoFb(ByteBuffer byteBuffer) {
        return getRootAsBiddingInfoFb(byteBuffer, new BiddingInfoFb());
    }

    public static void startBiddingInfoFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(4);
    }

    public BiddingInfoFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String cur() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer curAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer curInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String lurl() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer lurlAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer lurlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String nurl() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nurlAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer nurlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public float price() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getFloat(i__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public static BiddingInfoFb getRootAsBiddingInfoFb(ByteBuffer byteBuffer, BiddingInfoFb biddingInfoFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return biddingInfoFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
