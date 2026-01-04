package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class Type extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public Type get(int i10) {
            return get(new Type(), i10);
        }

        public Type get(Type type, int i10) {
            return type.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addBaseSize(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addInt(4, (int) j10, 4);
    }

    public static void addBaseType(FlatBufferBuilder flatBufferBuilder, byte b10) {
        flatBufferBuilder.addByte(0, b10, 0);
    }

    public static void addElement(FlatBufferBuilder flatBufferBuilder, byte b10) {
        flatBufferBuilder.addByte(1, b10, 0);
    }

    public static void addElementSize(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addInt(5, (int) j10, 0);
    }

    public static void addFixedLength(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addShort(3, (short) i10, 0);
    }

    public static void addIndex(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, -1);
    }

    public static int createType(FlatBufferBuilder flatBufferBuilder, byte b10, byte b11, int i10, int i11, long j10, long j11) {
        flatBufferBuilder.startTable(6);
        addElementSize(flatBufferBuilder, j11);
        addBaseSize(flatBufferBuilder, j10);
        addIndex(flatBufferBuilder, i10);
        addFixedLength(flatBufferBuilder, i11);
        addElement(flatBufferBuilder, b11);
        addBaseType(flatBufferBuilder, b10);
        return endType(flatBufferBuilder);
    }

    public static int endType(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static Type getRootAsType(ByteBuffer byteBuffer) {
        return getRootAsType(byteBuffer, new Type());
    }

    public static void startType(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(6);
    }

    public Type __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public long baseSize() {
        if (__offset(12) != 0) {
            return this.f9449bb.getInt(r0 + this.bb_pos) & 4294967295L;
        }
        return 4L;
    }

    public byte baseType() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.get(i__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public byte element() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.get(i__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public long elementSize() {
        if (__offset(14) != 0) {
            return this.f9449bb.getInt(r0 + this.bb_pos) & 4294967295L;
        }
        return 0L;
    }

    public int fixedLength() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public int index() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return -1;
    }

    public static Type getRootAsType(ByteBuffer byteBuffer, Type type) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return type.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
