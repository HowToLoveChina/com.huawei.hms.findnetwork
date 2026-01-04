package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.reflection.Enum;
import com.google.flatbuffers.reflection.Object;
import com.google.flatbuffers.reflection.SchemaFile;
import com.google.flatbuffers.reflection.Service;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class Schema extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public Schema get(int i10) {
            return get(new Schema(), i10);
        }

        public Schema get(Schema schema, int i10) {
            return schema.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static boolean SchemaBufferHasIdentifier(ByteBuffer byteBuffer) {
        return Table.__has_identifier(byteBuffer, "BFBS");
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addAdvancedFeatures(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(6, j10, 0L);
    }

    public static void addEnums(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addFbsFiles(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(7, i10, 0);
    }

    public static void addFileExt(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addFileIdent(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addObjects(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addRootTable(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addServices(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(5, i10, 0);
    }

    public static int createEnumsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createFbsFilesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createObjectsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createSchema(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16) {
        flatBufferBuilder.startTable(8);
        addAdvancedFeatures(flatBufferBuilder, j10);
        addFbsFiles(flatBufferBuilder, i16);
        addServices(flatBufferBuilder, i15);
        addRootTable(flatBufferBuilder, i14);
        addFileExt(flatBufferBuilder, i13);
        addFileIdent(flatBufferBuilder, i12);
        addEnums(flatBufferBuilder, i11);
        addObjects(flatBufferBuilder, i10);
        return endSchema(flatBufferBuilder);
    }

    public static int createServicesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endSchema(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        flatBufferBuilder.required(iEndTable, 6);
        return iEndTable;
    }

    public static void finishSchemaBuffer(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.finish(i10, "BFBS");
    }

    public static void finishSizePrefixedSchemaBuffer(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.finishSizePrefixed(i10, "BFBS");
    }

    public static Schema getRootAsSchema(ByteBuffer byteBuffer) {
        return getRootAsSchema(byteBuffer, new Schema());
    }

    public static void startEnumsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startFbsFilesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startObjectsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startSchema(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(8);
    }

    public static void startServicesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public Schema __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public long advancedFeatures() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public Enum enums(int i10) {
        return enums(new Enum(), i10);
    }

    public Enum enumsByKey(String str) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return Enum.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int enumsLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public Enum.Vector enumsVector() {
        return enumsVector(new Enum.Vector());
    }

    public SchemaFile fbsFiles(int i10) {
        return fbsFiles(new SchemaFile(), i10);
    }

    public SchemaFile fbsFilesByKey(String str) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return SchemaFile.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int fbsFilesLength() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public SchemaFile.Vector fbsFilesVector() {
        return fbsFilesVector(new SchemaFile.Vector());
    }

    public String fileExt() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fileExtAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer fileExtInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public String fileIdent() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fileIdentAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer fileIdentInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public Object objects(int i10) {
        return objects(new Object(), i10);
    }

    public Object objectsByKey(String str) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return Object.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int objectsLength() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public Object.Vector objectsVector() {
        return objectsVector(new Object.Vector());
    }

    public Object rootTable() {
        return rootTable(new Object());
    }

    public Service services(int i10) {
        return services(new Service(), i10);
    }

    public Service servicesByKey(String str) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return Service.__lookup_by_key(null, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public int servicesLength() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public Service.Vector servicesVector() {
        return servicesVector(new Service.Vector());
    }

    public static Schema getRootAsSchema(ByteBuffer byteBuffer, Schema schema) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return schema.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public Enum enums(Enum r22, int i10) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return r22.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public Enum enumsByKey(Enum r22, String str) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return Enum.__lookup_by_key(r22, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public Enum.Vector enumsVector(Enum.Vector vector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public SchemaFile fbsFiles(SchemaFile schemaFile, int i10) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return schemaFile.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public SchemaFile fbsFilesByKey(SchemaFile schemaFile, String str) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return SchemaFile.__lookup_by_key(schemaFile, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public SchemaFile.Vector fbsFilesVector(SchemaFile.Vector vector) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public Object objects(Object object, int i10) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return object.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public Object objectsByKey(Object object, String str) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return Object.__lookup_by_key(object, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public Object.Vector objectsVector(Object.Vector vector) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public Object rootTable(Object object) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return object.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public Service services(Service service, int i10) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return service.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public Service servicesByKey(Service service, String str) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return Service.__lookup_by_key(service, __vector(i__offset), str, this.f9449bb);
        }
        return null;
    }

    public Service.Vector servicesVector(Service.Vector vector) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
