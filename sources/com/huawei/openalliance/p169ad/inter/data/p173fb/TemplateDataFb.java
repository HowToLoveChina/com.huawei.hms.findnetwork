package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import com.huawei.openalliance.p169ad.inter.data.p173fb.MotionDataFb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class TemplateDataFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public TemplateDataFb get(int i10) {
            return get(new TemplateDataFb(), i10);
        }

        public TemplateDataFb get(TemplateDataFb templateDataFb, int i10) {
            return templateDataFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addComponentContext(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addMotionData(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addMotions(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addTemplateContext(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static int createMotionDataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createTemplateDataFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13) {
        flatBufferBuilder.startTable(4);
        addComponentContext(flatBufferBuilder, i13);
        addMotionData(flatBufferBuilder, i12);
        addMotions(flatBufferBuilder, i11);
        addTemplateContext(flatBufferBuilder, i10);
        return endTemplateDataFb(flatBufferBuilder);
    }

    public static int endTemplateDataFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static TemplateDataFb getRootAsTemplateDataFb(ByteBuffer byteBuffer) {
        return getRootAsTemplateDataFb(byteBuffer, new TemplateDataFb());
    }

    public static void startMotionDataVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startTemplateDataFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(4);
    }

    public TemplateDataFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String componentContext() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer componentContextAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer componentContextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public MotionDataFb motionData(int i10) {
        return motionData(new MotionDataFb(), i10);
    }

    public int motionDataLength() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public MotionDataFb.Vector motionDataVector() {
        return motionDataVector(new MotionDataFb.Vector());
    }

    public String motions() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer motionsAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer motionsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String templateContext() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer templateContextAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer templateContextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public static TemplateDataFb getRootAsTemplateDataFb(ByteBuffer byteBuffer, TemplateDataFb templateDataFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return templateDataFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MotionDataFb motionData(MotionDataFb motionDataFb, int i10) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return motionDataFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public MotionDataFb.Vector motionDataVector(MotionDataFb.Vector vector) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
