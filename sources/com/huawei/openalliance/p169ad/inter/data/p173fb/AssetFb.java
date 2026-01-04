package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class AssetFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public AssetFb get(int i10) {
            return get(new AssetFb(), i10);
        }

        public AssetFb get(AssetFb assetFb, int i10) {
            return assetFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addAlias(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addContext(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addData(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addFilePath(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(7, i10, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(0, i10, 0);
    }

    public static void addImg(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addTitle(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(6, i10, 0);
    }

    public static void addVideo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(5, i10, 0);
    }

    public static int createAssetFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        flatBufferBuilder.startTable(8);
        addFilePath(flatBufferBuilder, i17);
        addTitle(flatBufferBuilder, i16);
        addVideo(flatBufferBuilder, i15);
        addImg(flatBufferBuilder, i14);
        addData(flatBufferBuilder, i13);
        addContext(flatBufferBuilder, i12);
        addAlias(flatBufferBuilder, i11);
        addId(flatBufferBuilder, i10);
        return endAssetFb(flatBufferBuilder);
    }

    public static int endAssetFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static AssetFb getRootAsAssetFb(ByteBuffer byteBuffer) {
        return getRootAsAssetFb(byteBuffer, new AssetFb());
    }

    public static void startAssetFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(8);
    }

    public AssetFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String alias() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer aliasAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer aliasInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String context() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contextAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer contextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public DataFb data() {
        return data(new DataFb());
    }

    public String filePath() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer filePathAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer filePathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    /* renamed from: id */
    public int m44864id() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public ImageFb img() {
        return img(new ImageFb());
    }

    public TitleFb title() {
        return title(new TitleFb());
    }

    public VideoFb video() {
        return video(new VideoFb());
    }

    public static AssetFb getRootAsAssetFb(ByteBuffer byteBuffer, AssetFb assetFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return assetFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public DataFb data(DataFb dataFb) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return dataFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public ImageFb img(ImageFb imageFb) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return imageFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public TitleFb title(TitleFb titleFb) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return titleFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public VideoFb video(VideoFb videoFb) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return videoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }
}
