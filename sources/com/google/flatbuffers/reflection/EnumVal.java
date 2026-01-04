package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.reflection.KeyValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class EnumVal extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public EnumVal get(int i10) {
            return get(new EnumVal(), i10);
        }

        public EnumVal getByKey(long j10) {
            return EnumVal.__lookup_by_key(null, __vector(), j10, this.f9443bb);
        }

        public EnumVal get(EnumVal enumVal, int i10) {
            return enumVal.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }

        public EnumVal getByKey(EnumVal enumVal, long j10) {
            return EnumVal.__lookup_by_key(enumVal, __vector(), j10, this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static EnumVal __lookup_by_key(EnumVal enumVal, int i10, long j10, ByteBuffer byteBuffer) {
        int i11 = byteBuffer.getInt(i10 - 4);
        int i12 = 0;
        while (i11 != 0) {
            int i13 = i11 / 2;
            int i__indirect = Table.__indirect(((i12 + i13) * 4) + i10, byteBuffer);
            long j11 = byteBuffer.getLong(Table.__offset(6, byteBuffer.capacity() - i__indirect, byteBuffer));
            char c10 = j11 > j10 ? (char) 1 : j11 < j10 ? (char) 65535 : (char) 0;
            if (c10 > 0) {
                i11 = i13;
            } else {
                if (c10 >= 0) {
                    if (enumVal == null) {
                        enumVal = new EnumVal();
                    }
                    return enumVal.__assign(i__indirect, byteBuffer);
                }
                int i14 = i13 + 1;
                i12 += i14;
                i11 -= i14;
            }
        }
        return null;
    }

    public static void addAttributes(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(5, i10, 0);
    }

    public static void addDocumentation(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addUnionType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(j10);
        flatBufferBuilder.slot(1);
    }

    public static int createAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createDocumentationVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createEnumVal(FlatBufferBuilder flatBufferBuilder, int i10, long j10, int i11, int i12, int i13) {
        flatBufferBuilder.startTable(6);
        addValue(flatBufferBuilder, j10);
        addAttributes(flatBufferBuilder, i13);
        addDocumentation(flatBufferBuilder, i12);
        addUnionType(flatBufferBuilder, i11);
        addName(flatBufferBuilder, i10);
        return endEnumVal(flatBufferBuilder);
    }

    public static int endEnumVal(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        return iEndTable;
    }

    public static EnumVal getRootAsEnumVal(ByteBuffer byteBuffer) {
        return getRootAsEnumVal(byteBuffer, new EnumVal());
    }

    public static void startAttributesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startDocumentationVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startEnumVal(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(6);
    }

    public EnumVal __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public KeyValue attributes(int i10) {
        return attributes(new KeyValue(), i10);
    }

    public KeyValue attributesByKey(String str) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return KeyValue.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int attributesLength() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public KeyValue.Vector attributesVector() {
        return attributesVector(new KeyValue.Vector());
    }

    public String documentation(int i10) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int documentationLength() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector documentationVector() {
        return documentationVector(new StringVector());
    }

    @Override // com.google.flatbuffers.Table
    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        long j10 = byteBuffer.getLong(Table.__offset(6, num.intValue(), byteBuffer));
        long j11 = byteBuffer.getLong(Table.__offset(6, num2.intValue(), byteBuffer));
        if (j10 > j11) {
            return 1;
        }
        return j10 < j11 ? -1 : 0;
    }

    public String name() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public Type unionType() {
        return unionType(new Type());
    }

    public long value() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public static EnumVal getRootAsEnumVal(ByteBuffer byteBuffer, EnumVal enumVal) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return enumVal.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public KeyValue attributes(KeyValue keyValue, int i10) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return keyValue.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public KeyValue attributesByKey(KeyValue keyValue, String str) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return KeyValue.__lookup_by_key(keyValue, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public KeyValue.Vector attributesVector(KeyValue.Vector vector) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector documentationVector(StringVector stringVector) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public Type unionType(Type type) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return type.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }
}
