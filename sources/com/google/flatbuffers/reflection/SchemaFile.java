package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class SchemaFile extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public SchemaFile get(int i10) {
            return get(new SchemaFile(), i10);
        }

        public SchemaFile getByKey(String str) {
            return SchemaFile.__lookup_by_key(null, __vector(), str, this.f9443bb);
        }

        public SchemaFile get(SchemaFile schemaFile, int i10) {
            return schemaFile.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }

        public SchemaFile getByKey(SchemaFile schemaFile, String str) {
            return SchemaFile.__lookup_by_key(schemaFile, __vector(), str, this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static SchemaFile __lookup_by_key(SchemaFile schemaFile, int i10, String str, ByteBuffer byteBuffer) {
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
                    if (schemaFile == null) {
                        schemaFile = new SchemaFile();
                    }
                    return schemaFile.__assign(i__indirect, byteBuffer);
                }
                int i14 = i13 + 1;
                i12 += i14;
                i11 -= i14;
            }
        }
        return null;
    }

    public static void addFilename(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(i10);
        flatBufferBuilder.slot(0);
    }

    public static void addIncludedFilenames(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static int createIncludedFilenamesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createSchemaFile(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        addIncludedFilenames(flatBufferBuilder, i11);
        addFilename(flatBufferBuilder, i10);
        return endSchemaFile(flatBufferBuilder);
    }

    public static int endSchemaFile(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        return iEndTable;
    }

    public static SchemaFile getRootAsSchemaFile(ByteBuffer byteBuffer) {
        return getRootAsSchemaFile(byteBuffer, new SchemaFile());
    }

    public static void startIncludedFilenamesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startSchemaFile(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public SchemaFile __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String filename() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer filenameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer filenameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String includedFilenames(int i10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int includedFilenamesLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector includedFilenamesVector() {
        return includedFilenamesVector(new StringVector());
    }

    @Override // com.google.flatbuffers.Table
    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return Table.compareStrings(Table.__offset(4, num.intValue(), byteBuffer), Table.__offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public static SchemaFile getRootAsSchemaFile(ByteBuffer byteBuffer, SchemaFile schemaFile) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return schemaFile.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public StringVector includedFilenamesVector(StringVector stringVector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
