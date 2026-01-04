package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class MotionDataFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public MotionDataFb get(int i10) {
            return get(new MotionDataFb(), i10);
        }

        public MotionDataFb get(MotionDataFb motionDataFb, int i10) {
            return motionDataFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addDataId(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(0, j10, 0L);
    }

    public static void addDuration(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(7, i10, 0);
    }

    public static void addFilePath(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(8, i10, 0);
    }

    public static void addFormat(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(3, i10, 0);
    }

    public static void addSha256(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(6, i10, 0);
    }

    public static void addSize(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(5, i10, 0);
    }

    public static void addUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 0);
    }

    public static int createMotionDataFb(FlatBufferBuilder flatBufferBuilder, long j10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        flatBufferBuilder.startTable(9);
        addDataId(flatBufferBuilder, j10);
        addFilePath(flatBufferBuilder, i17);
        addDuration(flatBufferBuilder, i16);
        addSha256(flatBufferBuilder, i15);
        addSize(flatBufferBuilder, i14);
        addFormat(flatBufferBuilder, i13);
        addHeight(flatBufferBuilder, i12);
        addWidth(flatBufferBuilder, i11);
        addUrl(flatBufferBuilder, i10);
        return endMotionDataFb(flatBufferBuilder);
    }

    public static int endMotionDataFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MotionDataFb getRootAsMotionDataFb(ByteBuffer byteBuffer) {
        return getRootAsMotionDataFb(byteBuffer, new MotionDataFb());
    }

    public static void startMotionDataFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(9);
    }

    public MotionDataFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public long dataId() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public int duration() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String filePath() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer filePathAsByteBuffer() {
        return __vector_as_bytebuffer(20, 1);
    }

    public ByteBuffer filePathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 20, 1);
    }

    public String format() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer formatAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer formatInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public int height() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String sha256() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sha256AsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer sha256InByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public int size() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String url() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer urlAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer urlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public int width() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static MotionDataFb getRootAsMotionDataFb(ByteBuffer byteBuffer, MotionDataFb motionDataFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return motionDataFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
