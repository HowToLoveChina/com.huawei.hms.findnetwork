package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.reflection.EnumVal;
import com.google.flatbuffers.reflection.KeyValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class Enum extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public Enum get(int i10) {
            return get(new Enum(), i10);
        }

        public Enum getByKey(String str) {
            return Enum.__lookup_by_key(null, __vector(), str, this.f9443bb);
        }

        public Enum get(Enum r22, int i10) {
            return r22.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }

        public Enum getByKey(Enum r22, String str) {
            return Enum.__lookup_by_key(r22, __vector(), str, this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static Enum __lookup_by_key(Enum r62, int i10, String str, ByteBuffer byteBuffer) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int i11 = byteBuffer.getInt(i10 - 4);
        int i12 = 0;
        while (i11 != 0) {
            int i13 = i11 / 2;
            int i__indirect = Table.__indirect(((i12 + i13) * 4) + i10, byteBuffer);
            int iCompareStrings = Table.compareStrings(Table.__offset(4, byteBuffer.capacity() - i__indirect, byteBuffer), bytes, byteBuffer);
            if (iCompareStrings > 0) {
                i11 = i13;
            } else {
                if (iCompareStrings >= 0) {
                    if (r62 == null) {
                        r62 = new Enum();
                    }
                    return r62.__assign(i__indirect, byteBuffer);
                }
                int i14 = i13 + 1;
                i12 += i14;
                i11 -= i14;
            }
        }
        return null;
    }

    public static void addAttributes(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addDeclarationFile(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(6, i10, 0);
    }

    public static void addDocumentation(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(5, i10, 0);
    }

    public static void addIsUnion(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(2, z10, false);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(i10);
        flatBufferBuilder.slot(0);
    }

    public static void addUnderlyingType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addValues(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
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

    public static int createEnum(FlatBufferBuilder flatBufferBuilder, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        flatBufferBuilder.startTable(7);
        addDeclarationFile(flatBufferBuilder, i15);
        addDocumentation(flatBufferBuilder, i14);
        addAttributes(flatBufferBuilder, i13);
        addUnderlyingType(flatBufferBuilder, i12);
        addValues(flatBufferBuilder, i11);
        addName(flatBufferBuilder, i10);
        addIsUnion(flatBufferBuilder, z10);
        return endEnum(flatBufferBuilder);
    }

    public static int createValuesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endEnum(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        flatBufferBuilder.required(iEndTable, 6);
        flatBufferBuilder.required(iEndTable, 10);
        return iEndTable;
    }

    public static Enum getRootAsEnum(ByteBuffer byteBuffer) {
        return getRootAsEnum(byteBuffer, new Enum());
    }

    public static void startAttributesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startDocumentationVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startEnum(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public static void startValuesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public Enum __assign(int i10, ByteBuffer byteBuffer) {
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
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return KeyValue.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int attributesLength() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public KeyValue.Vector attributesVector() {
        return attributesVector(new KeyValue.Vector());
    }

    public String declarationFile() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer declarationFileAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer declarationFileInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public String documentation(int i10) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int documentationLength() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector documentationVector() {
        return documentationVector(new StringVector());
    }

    public boolean isUnion() {
        int i__offset = __offset(8);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    @Override // com.google.flatbuffers.Table
    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return Table.compareStrings(Table.__offset(4, num.intValue(), byteBuffer), Table.__offset(4, num2.intValue(), byteBuffer), byteBuffer);
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

    public Type underlyingType() {
        return underlyingType(new Type());
    }

    public EnumVal values(int i10) {
        return values(new EnumVal(), i10);
    }

    public EnumVal valuesByKey(long j10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return EnumVal.__lookup_by_key(null, __vector(i__offset), j10, this.f9449bb);
        }
        return null;
    }

    public int valuesLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public EnumVal.Vector valuesVector() {
        return valuesVector(new EnumVal.Vector());
    }

    public static Enum getRootAsEnum(ByteBuffer byteBuffer, Enum r32) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return r32.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public KeyValue attributes(KeyValue keyValue, int i10) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return keyValue.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public KeyValue attributesByKey(KeyValue keyValue, String str) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return KeyValue.__lookup_by_key(keyValue, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public KeyValue.Vector attributesVector(KeyValue.Vector vector) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector documentationVector(StringVector stringVector) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public Type underlyingType(Type type) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return type.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public EnumVal values(EnumVal enumVal, int i10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return enumVal.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public EnumVal valuesByKey(EnumVal enumVal, long j10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return EnumVal.__lookup_by_key(enumVal, __vector(i__offset), j10, this.f9449bb);
        }
        return null;
    }

    public EnumVal.Vector valuesVector(EnumVal.Vector vector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
