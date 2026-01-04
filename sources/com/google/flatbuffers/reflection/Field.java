package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.reflection.KeyValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class Field extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public Field get(int i10) {
            return get(new Field(), i10);
        }

        public Field getByKey(String str) {
            return Field.__lookup_by_key(null, __vector(), str, this.f9443bb);
        }

        public Field get(Field field, int i10) {
            return field.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }

        public Field getByKey(Field field, String str) {
            return Field.__lookup_by_key(field, __vector(), str, this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static Field __lookup_by_key(Field field, int i10, String str, ByteBuffer byteBuffer) {
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
                    if (field == null) {
                        field = new Field();
                    }
                    return field.__assign(i__indirect, byteBuffer);
                }
                int i14 = i13 + 1;
                i12 += i14;
                i11 -= i14;
            }
        }
        return null;
    }

    public static void addAttributes(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(9, i10, 0);
    }

    public static void addDefaultInteger(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(4, j10, 0L);
    }

    public static void addDefaultReal(FlatBufferBuilder flatBufferBuilder, double d10) {
        flatBufferBuilder.addDouble(5, d10, 0.0d);
    }

    public static void addDeprecated(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(6, z10, false);
    }

    public static void addDocumentation(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(10, i10, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addShort(2, (short) i10, 0);
    }

    public static void addKey(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(8, z10, false);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(i10);
        flatBufferBuilder.slot(0);
    }

    public static void addOffset(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addShort(3, (short) i10, 0);
    }

    public static void addOffset64(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(13, z10, false);
    }

    public static void addOptional(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(11, z10, false);
    }

    public static void addPadding(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addShort(12, (short) i10, 0);
    }

    public static void addRequired(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(7, z10, false);
    }

    public static void addType(FlatBufferBuilder flatBufferBuilder, int i10) {
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

    public static int createField(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, long j10, double d10, boolean z10, boolean z11, boolean z12, int i14, int i15, boolean z13, int i16, boolean z14) {
        flatBufferBuilder.startTable(14);
        addDefaultReal(flatBufferBuilder, d10);
        addDefaultInteger(flatBufferBuilder, j10);
        addDocumentation(flatBufferBuilder, i15);
        addAttributes(flatBufferBuilder, i14);
        addType(flatBufferBuilder, i11);
        addName(flatBufferBuilder, i10);
        addPadding(flatBufferBuilder, i16);
        addOffset(flatBufferBuilder, i13);
        addId(flatBufferBuilder, i12);
        addOffset64(flatBufferBuilder, z14);
        addOptional(flatBufferBuilder, z13);
        addKey(flatBufferBuilder, z12);
        addRequired(flatBufferBuilder, z11);
        addDeprecated(flatBufferBuilder, z10);
        return endField(flatBufferBuilder);
    }

    public static int endField(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        flatBufferBuilder.required(iEndTable, 6);
        return iEndTable;
    }

    public static Field getRootAsField(ByteBuffer byteBuffer) {
        return getRootAsField(byteBuffer, new Field());
    }

    public static void startAttributesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startDocumentationVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startField(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(14);
    }

    public Field __assign(int i10, ByteBuffer byteBuffer) {
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
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return KeyValue.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int attributesLength() {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public KeyValue.Vector attributesVector() {
        return attributesVector(new KeyValue.Vector());
    }

    public long defaultInteger() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public double defaultReal() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f9449bb.getDouble(i__offset + this.bb_pos);
        }
        return 0.0d;
    }

    public boolean deprecated() {
        int i__offset = __offset(16);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String documentation(int i10) {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int documentationLength() {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector documentationVector() {
        return documentationVector(new StringVector());
    }

    /* renamed from: id */
    public int m12420id() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public boolean key() {
        int i__offset = __offset(20);
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

    public int offset() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public boolean offset64() {
        int i__offset = __offset(30);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean optional() {
        int i__offset = __offset(26);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public int padding() {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return this.f9449bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public boolean required() {
        int i__offset = __offset(18);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public Type type() {
        return type(new Type());
    }

    public static Field getRootAsField(ByteBuffer byteBuffer, Field field) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return field.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public KeyValue attributes(KeyValue keyValue, int i10) {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return keyValue.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public KeyValue attributesByKey(KeyValue keyValue, String str) {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return KeyValue.__lookup_by_key(keyValue, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public KeyValue.Vector attributesVector(KeyValue.Vector vector) {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector documentationVector(StringVector stringVector) {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public Type type(Type type) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return type.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }
}
