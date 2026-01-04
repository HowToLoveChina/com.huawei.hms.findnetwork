package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class ImageFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public ImageFb get(int i10) {
            return get(new ImageFb(), i10);
        }

        public ImageFb get(ImageFb imageFb, int i10) {
            return imageFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addExt(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 0);
    }

    public static void addLocalPath(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    public static int createImageFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14) {
        flatBufferBuilder.startTable(5);
        addLocalPath(flatBufferBuilder, i14);
        addExt(flatBufferBuilder, i13);
        addHeight(flatBufferBuilder, i12);
        addWidth(flatBufferBuilder, i11);
        addUrl(flatBufferBuilder, i10);
        return endImageFb(flatBufferBuilder);
    }

    public static int endImageFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static ImageFb getRootAsImageFb(ByteBuffer byteBuffer) {
        return getRootAsImageFb(byteBuffer, new ImageFb());
    }

    public static void startImageFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(5);
    }

    public ImageFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public ImageExtFb ext() {
        return ext(new ImageExtFb());
    }

    public int height() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String localPath() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer localPathAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer localPathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
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
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static ImageFb getRootAsImageFb(ByteBuffer byteBuffer, ImageFb imageFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return imageFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public ImageExtFb ext(ImageExtFb imageExtFb) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return imageExtFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }
}
