package com.google.flatbuffers.reflection;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class KeyValue extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public KeyValue get(int i10) {
            return get(new KeyValue(), i10);
        }

        public KeyValue getByKey(String str) {
            return KeyValue.__lookup_by_key(null, __vector(), str, this.f9443bb);
        }

        public KeyValue get(KeyValue keyValue, int i10) {
            return keyValue.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }

        public KeyValue getByKey(KeyValue keyValue, String str) {
            return KeyValue.__lookup_by_key(keyValue, __vector(), str, this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static KeyValue __lookup_by_key(KeyValue keyValue, int i10, String str, ByteBuffer byteBuffer) {
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
                    if (keyValue == null) {
                        keyValue = new KeyValue();
                    }
                    return keyValue.__assign(i__indirect, byteBuffer);
                }
                int i14 = i13 + 1;
                i12 += i14;
                i11 -= i14;
            }
        }
        return null;
    }

    public static void addKey(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(i10);
        flatBufferBuilder.slot(0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static int createKeyValue(FlatBufferBuilder flatBufferBuilder, int i10, int i11) {
        flatBufferBuilder.startTable(2);
        addValue(flatBufferBuilder, i11);
        addKey(flatBufferBuilder, i10);
        return endKeyValue(flatBufferBuilder);
    }

    public static int endKeyValue(FlatBufferBuilder flatBufferBuilder) {
        int iEndTable = flatBufferBuilder.endTable();
        flatBufferBuilder.required(iEndTable, 4);
        return iEndTable;
    }

    public static KeyValue getRootAsKeyValue(ByteBuffer byteBuffer) {
        return getRootAsKeyValue(byteBuffer, new KeyValue());
    }

    public static void startKeyValue(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public KeyValue __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String key() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer keyAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer keyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    @Override // com.google.flatbuffers.Table
    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return Table.compareStrings(Table.__offset(4, num.intValue(), byteBuffer), Table.__offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public String value() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public static KeyValue getRootAsKeyValue(ByteBuffer byteBuffer, KeyValue keyValue) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return keyValue.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
