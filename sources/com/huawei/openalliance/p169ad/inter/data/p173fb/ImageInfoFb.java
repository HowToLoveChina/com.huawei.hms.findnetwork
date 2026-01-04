package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class ImageInfoFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public ImageInfoFb get(int i10) {
            return get(new ImageInfoFb(), i10);
        }

        public ImageInfoFb get(ImageInfoFb imageInfoFb, int i10) {
            return imageInfoFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addCheckSha256(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(6, z10, false);
    }

    public static void addFileSize(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(4, i10, 0);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(3, i10, 0);
    }

    public static void addImageType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(7, i10, 0);
    }

    public static void addOriginalUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addSha256(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(5, i10, 0);
    }

    public static void addUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 0);
    }

    public static int createImageInfoFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, int i16) {
        flatBufferBuilder.startTable(8);
        addImageType(flatBufferBuilder, i16);
        addSha256(flatBufferBuilder, i15);
        addFileSize(flatBufferBuilder, i14);
        addHeight(flatBufferBuilder, i13);
        addWidth(flatBufferBuilder, i12);
        addOriginalUrl(flatBufferBuilder, i11);
        addUrl(flatBufferBuilder, i10);
        addCheckSha256(flatBufferBuilder, z10);
        return endImageInfoFb(flatBufferBuilder);
    }

    public static int endImageInfoFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static ImageInfoFb getRootAsImageInfoFb(ByteBuffer byteBuffer) {
        return getRootAsImageInfoFb(byteBuffer, new ImageInfoFb());
    }

    public static void startImageInfoFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(8);
    }

    public ImageInfoFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public boolean checkSha256() {
        int i__offset = __offset(16);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public int fileSize() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int height() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String imageType() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer imageTypeAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer imageTypeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public String originalUrl() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer originalUrlAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer originalUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String sha256() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sha256AsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer sha256InByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public String url() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer urlAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer urlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int width() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static ImageInfoFb getRootAsImageInfoFb(ByteBuffer byteBuffer, ImageInfoFb imageInfoFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return imageInfoFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
