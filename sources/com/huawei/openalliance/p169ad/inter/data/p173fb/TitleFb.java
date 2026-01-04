package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class TitleFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public TitleFb get(int i10) {
            return get(new TitleFb(), i10);
        }

        public TitleFb get(TitleFb titleFb, int i10) {
            return titleFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addLen(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    public static void addText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static int createTitleFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        addLen(flatBufferBuilder, i11);
        addText(flatBufferBuilder, i10);
        return endTitleFb(flatBufferBuilder);
    }

    public static int endTitleFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static TitleFb getRootAsTitleFb(ByteBuffer byteBuffer) {
        return getRootAsTitleFb(byteBuffer, new TitleFb());
    }

    public static void startTitleFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public TitleFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public int len() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String text() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer textAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer textInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public static TitleFb getRootAsTitleFb(ByteBuffer byteBuffer, TitleFb titleFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return titleFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
