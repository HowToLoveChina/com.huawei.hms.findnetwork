package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class FeedbackInfoFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public FeedbackInfoFb get(int i10) {
            return get(new FeedbackInfoFb(), i10);
        }

        public FeedbackInfoFb get(FeedbackInfoFb feedbackInfoFb, int i10) {
            return feedbackInfoFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(2, j10, 0L);
    }

    public static void addLabel(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    public static int createFeedbackInfoFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, long j10) {
        flatBufferBuilder.startTable(3);
        addId(flatBufferBuilder, j10);
        addType(flatBufferBuilder, i11);
        addLabel(flatBufferBuilder, i10);
        return endFeedbackInfoFb(flatBufferBuilder);
    }

    public static int endFeedbackInfoFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static FeedbackInfoFb getRootAsFeedbackInfoFb(ByteBuffer byteBuffer) {
        return getRootAsFeedbackInfoFb(byteBuffer, new FeedbackInfoFb());
    }

    public static void startFeedbackInfoFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public FeedbackInfoFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: id */
    public long m44865id() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public String label() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer labelAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer labelInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int type() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static FeedbackInfoFb getRootAsFeedbackInfoFb(ByteBuffer byteBuffer, FeedbackInfoFb feedbackInfoFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return feedbackInfoFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
