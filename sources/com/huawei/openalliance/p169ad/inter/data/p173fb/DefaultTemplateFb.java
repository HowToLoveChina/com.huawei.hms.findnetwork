package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class DefaultTemplateFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public DefaultTemplateFb get(int i10) {
            return get(new DefaultTemplateFb(), i10);
        }

        public DefaultTemplateFb get(DefaultTemplateFb defaultTemplateFb, int i10) {
            return defaultTemplateFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addDefTptId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addTptFcCtl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(1, i10, 0);
    }

    public static int createDefaultTemplateFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        addTptFcCtl(flatBufferBuilder, i11);
        addDefTptId(flatBufferBuilder, i10);
        return endDefaultTemplateFb(flatBufferBuilder);
    }

    public static int endDefaultTemplateFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static DefaultTemplateFb getRootAsDefaultTemplateFb(ByteBuffer byteBuffer) {
        return getRootAsDefaultTemplateFb(byteBuffer, new DefaultTemplateFb());
    }

    public static void startDefaultTemplateFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public DefaultTemplateFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String defTptId() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer defTptIdAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer defTptIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int tptFcCtl() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static DefaultTemplateFb getRootAsDefaultTemplateFb(ByteBuffer byteBuffer, DefaultTemplateFb defaultTemplateFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return defaultTemplateFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
