package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.reflection.Field;
import com.google.flatbuffers.reflection.KeyValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class Object extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public Object get(int i10) {
            return get(new Object(), i10);
        }

        public Object getByKey(String str) {
            return Object.__lookup_by_key(null, __vector(), str, this.f9443bb);
        }

        public Object get(Object object, int i10) {
            return object.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }

        public Object getByKey(Object object, String str) {
            return Object.__lookup_by_key(object, __vector(), str, this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static Object __lookup_by_key(Object object, int i10, String str, ByteBuffer byteBuffer) {
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
                    if (object == null) {
                        object = new Object();
                    }
                    return object.__assign(i__indirect, byteBuffer);
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

    public static void addBytesize(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(4, i10, 0);
    }

    public static void addDeclarationFile(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(7, i10, 0);
    }

    public static void addDocumentation(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(6, i10, 0);
    }

    public static void addFields(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addIsStruct(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(2, z10, false);
    }

    public static void addMinalign(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(3, i10, 0);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(i10);
        flatBufferBuilder.slot(0);
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

    public static int createFieldsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createObject(FlatBufferBuilder flatBufferBuilder, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15, int i16) {
        flatBufferBuilder.startTable(8);
        addDeclarationFile(flatBufferBuilder, i16);
        addDocumentation(flatBufferBuilder, i15);
        addAttributes(flatBufferBuilder, i14);
        addBytesize(flatBufferBuilder, i13);
        addMinalign(flatBufferBuilder, i12);
        addFields(flatBufferBuilder, i11);
        addName(flatBufferBuilder, i10);
        addIsStruct(flatBufferBuilder, z10);
        return endObject(flatBufferBuilder);
    }

    public static int endObject(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        flatBufferBuilder.required(iEndTable, 6);
        return iEndTable;
    }

    public static Object getRootAsObject(ByteBuffer byteBuffer) {
        return getRootAsObject(byteBuffer, new Object());
    }

    public static void startAttributesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startDocumentationVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startFieldsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startObject(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(8);
    }

    public Object __assign(int i10, ByteBuffer byteBuffer) {
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

    public int bytesize() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String declarationFile() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer declarationFileAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer declarationFileInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public String documentation(int i10) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int documentationLength() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector documentationVector() {
        return documentationVector(new StringVector());
    }

    public Field fields(int i10) {
        return fields(new Field(), i10);
    }

    public Field fieldsByKey(String str) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return Field.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int fieldsLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public Field.Vector fieldsVector() {
        return fieldsVector(new Field.Vector());
    }

    public boolean isStruct() {
        int i__offset = __offset(8);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    @Override // com.google.flatbuffers.Table
    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return Table.compareStrings(Table.__offset(4, num.intValue(), byteBuffer), Table.__offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public int minalign() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
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

    public static Object getRootAsObject(ByteBuffer byteBuffer, Object object) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return object.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
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
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public Field fields(Field field, int i10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return field.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public Field fieldsByKey(Field field, String str) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return Field.__lookup_by_key(field, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public Field.Vector fieldsVector(Field.Vector vector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
