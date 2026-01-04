package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class AdSourceFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public AdSourceFb get(int i10) {
            return get(new AdSourceFb(), i10);
        }

        public AdSourceFb get(AdSourceFb adSourceFb, int i10) {
            return adSourceFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addDisplayPosition(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 0);
    }

    public static void addDspLogo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addDspName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static int createAdSourceFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12) {
        flatBufferBuilder.startTable(3);
        addDisplayPosition(flatBufferBuilder, i12);
        addDspLogo(flatBufferBuilder, i11);
        addDspName(flatBufferBuilder, i10);
        return endAdSourceFb(flatBufferBuilder);
    }

    public static int endAdSourceFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static AdSourceFb getRootAsAdSourceFb(ByteBuffer byteBuffer) {
        return getRootAsAdSourceFb(byteBuffer, new AdSourceFb());
    }

    public static void startAdSourceFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public AdSourceFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public int displayPosition() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String dspLogo() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer dspLogoAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer dspLogoInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String dspName() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer dspNameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer dspNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public static AdSourceFb getRootAsAdSourceFb(ByteBuffer byteBuffer, AdSourceFb adSourceFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return adSourceFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
