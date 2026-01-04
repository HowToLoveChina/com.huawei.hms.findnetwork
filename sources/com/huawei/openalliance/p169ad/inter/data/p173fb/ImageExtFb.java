package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class ImageExtFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public ImageExtFb get(int i10) {
            return get(new ImageExtFb(), i10);
        }

        public ImageExtFb get(ImageExtFb imageExtFb, int i10) {
            return imageExtFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addCheckSha256Flag(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(3, i10, 0);
    }

    public static void addFormat(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addSha256(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addSize(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(0, j10, 0L);
    }

    public static int createImageExtFb(FlatBufferBuilder flatBufferBuilder, long j10, int i10, int i11, int i12) {
        flatBufferBuilder.startTable(4);
        addSize(flatBufferBuilder, j10);
        addCheckSha256Flag(flatBufferBuilder, i12);
        addFormat(flatBufferBuilder, i11);
        addSha256(flatBufferBuilder, i10);
        return endImageExtFb(flatBufferBuilder);
    }

    public static int endImageExtFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static ImageExtFb getRootAsImageExtFb(ByteBuffer byteBuffer) {
        return getRootAsImageExtFb(byteBuffer, new ImageExtFb());
    }

    public static void startImageExtFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(4);
    }

    public ImageExtFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public int checkSha256Flag() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String format() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer formatAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer formatInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String sha256() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sha256AsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer sha256InByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public long size() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public static ImageExtFb getRootAsImageExtFb(ByteBuffer byteBuffer, ImageExtFb imageExtFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return imageExtFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
