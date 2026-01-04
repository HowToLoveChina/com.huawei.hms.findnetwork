package com.google.flatbuffers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int MAX_BUFFER_SIZE = 2147483639;

    /* renamed from: bb */
    ByteBuffer f9444bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    Map<String, Integer> string_pool;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i10);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // com.google.flatbuffers.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i10) {
            return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i10, ByteBufferFactory byteBufferFactory) {
        this(i10, byteBufferFactory, null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int i10;
        int iCapacity = byteBuffer.capacity();
        if (iCapacity == 0) {
            i10 = 1024;
        } else {
            i10 = MAX_BUFFER_SIZE;
            if (iCapacity == MAX_BUFFER_SIZE) {
                throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            }
            if (((-1073741824) & iCapacity) == 0) {
                i10 = iCapacity << 1;
            }
        }
        byteBuffer.position(0);
        ByteBuffer byteBufferNewByteBuffer = byteBufferFactory.newByteBuffer(i10);
        byteBufferNewByteBuffer.position(byteBufferNewByteBuffer.clear().capacity() - iCapacity);
        byteBufferNewByteBuffer.put(byteBuffer);
        return byteBufferNewByteBuffer;
    }

    public static boolean isFieldPresent(Table table, int i10) {
        return table.__offset(i10) != 0;
    }

    public void Nested(int i10) {
        if (i10 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z10) {
        prep(1, 0);
        putBoolean(z10);
    }

    public void addByte(byte b10) {
        prep(1, 0);
        putByte(b10);
    }

    public void addDouble(double d10) {
        prep(8, 0);
        putDouble(d10);
    }

    public void addFloat(float f10) {
        prep(4, 0);
        putFloat(f10);
    }

    public void addInt(int i10) {
        prep(4, 0);
        putInt(i10);
    }

    public void addLong(long j10) {
        prep(8, 0);
        putLong(j10);
    }

    public void addOffset(int i10) {
        prep(4, 0);
        putInt((offset() - i10) + 4);
    }

    public void addShort(short s10) {
        prep(2, 0);
        putShort(s10);
    }

    public void addStruct(int i10, int i11, int i12) {
        if (i11 != i12) {
            Nested(i11);
            slot(i10);
        }
    }

    public void clear() {
        this.space = this.f9444bb.capacity();
        this.f9444bb.clear();
        this.minalign = 1;
        while (true) {
            int i10 = this.vtable_in_use;
            if (i10 <= 0) {
                break;
            }
            int[] iArr = this.vtable;
            int i11 = i10 - 1;
            this.vtable_in_use = i11;
            iArr[i11] = 0;
        }
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        Map<String, Integer> map = this.string_pool;
        if (map != null) {
            map.clear();
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - length;
        this.space = i10;
        byteBuffer.position(i10);
        this.f9444bb.put(bArr);
        return endVector();
    }

    public int createSharedString(String str) {
        Map<String, Integer> map = this.string_pool;
        if (map == null) {
            this.string_pool = new HashMap();
            int iCreateString = createString(str);
            this.string_pool.put(str, Integer.valueOf(iCreateString));
            return iCreateString;
        }
        Integer numValueOf = map.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(createString(str));
            this.string_pool.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    public <T extends Table> int createSortedVectorOfTables(T t10, int[] iArr) {
        t10.sortTables(iArr, this.f9444bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int iEncodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, iEncodedLength, 1);
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - iEncodedLength;
        this.space = i10;
        byteBuffer.position(i10);
        this.utf8.encodeUtf8(charSequence, this.f9444bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i10, int i11, int i12) {
        int i13 = i10 * i11;
        startVector(i10, i11, i12);
        ByteBuffer byteBuffer = this.f9444bb;
        int i14 = this.space - i13;
        this.space = i14;
        byteBuffer.position(i14);
        ByteBuffer byteBufferOrder = this.f9444bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i13);
        return byteBufferOrder;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f9444bb;
    }

    public int endTable() {
        int i10;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int iOffset = offset();
        int i11 = this.vtable_in_use - 1;
        while (i11 >= 0 && this.vtable[i11] == 0) {
            i11--;
        }
        for (int i12 = i11; i12 >= 0; i12--) {
            int i13 = this.vtable[i12];
            addShort((short) (i13 != 0 ? iOffset - i13 : 0));
        }
        addShort((short) (iOffset - this.object_start));
        addShort((short) ((i11 + 3) * 2));
        int i14 = 0;
        loop2: while (true) {
            if (i14 >= this.num_vtables) {
                i10 = 0;
                break;
            }
            int iCapacity = this.f9444bb.capacity() - this.vtables[i14];
            int i15 = this.space;
            short s10 = this.f9444bb.getShort(iCapacity);
            if (s10 == this.f9444bb.getShort(i15)) {
                for (int i16 = 2; i16 < s10; i16 += 2) {
                    if (this.f9444bb.getShort(iCapacity + i16) != this.f9444bb.getShort(i15 + i16)) {
                        break;
                    }
                }
                i10 = this.vtables[i14];
                break loop2;
            }
            i14++;
        }
        if (i10 != 0) {
            int iCapacity2 = this.f9444bb.capacity() - iOffset;
            this.space = iCapacity2;
            this.f9444bb.putInt(iCapacity2, i10 - iOffset);
        } else {
            int i17 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i17 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i17 * 2);
            }
            int[] iArr2 = this.vtables;
            int i18 = this.num_vtables;
            this.num_vtables = i18 + 1;
            iArr2[i18] = offset();
            ByteBuffer byteBuffer = this.f9444bb;
            byteBuffer.putInt(byteBuffer.capacity() - iOffset, offset() - iOffset);
        }
        this.nested = false;
        return iOffset;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finish(int i10, boolean z10) {
        prep(this.minalign, (z10 ? 4 : 0) + 4);
        addOffset(i10);
        if (z10) {
            addInt(this.f9444bb.capacity() - this.space);
        }
        this.f9444bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i10) {
        finish(i10, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z10) {
        this.force_defaults = z10;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.f9444bb = byteBuffer;
        byteBuffer.clear();
        this.f9444bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.f9444bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        Map<String, Integer> map = this.string_pool;
        if (map != null) {
            map.clear();
        }
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f9444bb.capacity() - this.space;
    }

    public void pad(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBuffer = this.f9444bb;
            int i12 = this.space - 1;
            this.space = i12;
            byteBuffer.put(i12, (byte) 0);
        }
    }

    public void prep(int i10, int i11) {
        if (i10 > this.minalign) {
            this.minalign = i10;
        }
        int i12 = ((~((this.f9444bb.capacity() - this.space) + i11)) + 1) & (i10 - 1);
        while (this.space < i12 + i10 + i11) {
            int iCapacity = this.f9444bb.capacity();
            ByteBuffer byteBuffer = this.f9444bb;
            ByteBuffer byteBufferGrowByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.f9444bb = byteBufferGrowByteBuffer;
            if (byteBuffer != byteBufferGrowByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space += this.f9444bb.capacity() - iCapacity;
        }
        pad(i12);
    }

    public void putBoolean(boolean z10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - 1;
        this.space = i10;
        byteBuffer.put(i10, z10 ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - 1;
        this.space = i10;
        byteBuffer.put(i10, b10);
    }

    public void putDouble(double d10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - 8;
        this.space = i10;
        byteBuffer.putDouble(i10, d10);
    }

    public void putFloat(float f10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - 4;
        this.space = i10;
        byteBuffer.putFloat(i10, f10);
    }

    public void putInt(int i10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i11 = this.space - 4;
        this.space = i11;
        byteBuffer.putInt(i11, i10);
    }

    public void putLong(long j10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - 8;
        this.space = i10;
        byteBuffer.putLong(i10, j10);
    }

    public void putShort(short s10) {
        ByteBuffer byteBuffer = this.f9444bb;
        int i10 = this.space - 2;
        this.space = i10;
        byteBuffer.putShort(i10, s10);
    }

    public void required(int i10, int i11) {
        int iCapacity = this.f9444bb.capacity() - i10;
        if (this.f9444bb.getShort((iCapacity - this.f9444bb.getInt(iCapacity)) + i11) != 0) {
            return;
        }
        throw new AssertionError("FlatBuffers: field " + i11 + " must be set");
    }

    public byte[] sizedByteArray(int i10, int i11) {
        finished();
        byte[] bArr = new byte[i11];
        this.f9444bb.position(i10);
        this.f9444bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer byteBufferDuplicate = this.f9444bb.duplicate();
        byteBufferDuplicate.position(this.space);
        byteBufferDuplicate.limit(this.f9444bb.capacity());
        return new ByteBufferBackedInputStream(byteBufferDuplicate);
    }

    public void slot(int i10) {
        this.vtable[i10] = offset();
    }

    public void startTable(int i10) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i10) {
            this.vtable = new int[i10];
        }
        this.vtable_in_use = i10;
        Arrays.fill(this.vtable, 0, i10, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i10, int i11, int i12) {
        notNested();
        this.vector_num_elems = i11;
        int i13 = i10 * i11;
        prep(4, i13);
        prep(i12, i13);
        this.nested = true;
    }

    public FlatBufferBuilder(int i10, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i10 = i10 <= 0 ? 1024 : i10;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.f9444bb = byteBuffer;
            byteBuffer.clear();
            this.f9444bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f9444bb = byteBufferFactory.newByteBuffer(i10);
        }
        this.utf8 = utf8;
        this.space = this.f9444bb.capacity();
    }

    public void addBoolean(int i10, boolean z10, boolean z11) {
        if (this.force_defaults || z10 != z11) {
            addBoolean(z10);
            slot(i10);
        }
    }

    public void addByte(int i10, byte b10, int i11) {
        if (this.force_defaults || b10 != i11) {
            addByte(b10);
            slot(i10);
        }
    }

    public void addDouble(int i10, double d10, double d11) {
        if (this.force_defaults || d10 != d11) {
            addDouble(d10);
            slot(i10);
        }
    }

    public void addFloat(int i10, float f10, double d10) {
        if (this.force_defaults || f10 != d10) {
            addFloat(f10);
            slot(i10);
        }
    }

    public void addInt(int i10, int i11, int i12) {
        if (this.force_defaults || i11 != i12) {
            addInt(i11);
            slot(i10);
        }
    }

    public void addLong(int i10, long j10, long j11) {
        if (this.force_defaults || j10 != j11) {
            addLong(j10);
            slot(i10);
        }
    }

    public void addShort(int i10, short s10, int i11) {
        if (this.force_defaults || s10 != i11) {
            addShort(s10);
            slot(i10);
        }
    }

    public void finishSizePrefixed(int i10, String str) {
        finish(i10, str, true);
    }

    public void addOffset(int i10, int i11, int i12) {
        if (this.force_defaults || i11 != i12) {
            addOffset(i11);
            slot(i10);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.f9444bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i10, int i11) {
        startVector(1, i11, 1);
        ByteBuffer byteBuffer = this.f9444bb;
        int i12 = this.space - i11;
        this.space = i12;
        byteBuffer.position(i12);
        this.f9444bb.put(bArr, i10, i11);
        return endVector();
    }

    public void finish(int i10) {
        finish(i10, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f9444bb;
        int i10 = this.space - iRemaining;
        this.space = i10;
        byteBuffer2.position(i10);
        this.f9444bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i10, String str, boolean z10) {
        prep(this.minalign, (z10 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i11 = 3; i11 >= 0; i11--) {
                addByte((byte) str.charAt(i11));
            }
            finish(i10, z10);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f9444bb;
        int i10 = this.space - iRemaining;
        this.space = i10;
        byteBuffer2.position(i10);
        this.f9444bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i10, String str) {
        finish(i10, str, false);
    }

    public FlatBufferBuilder(int i10) {
        this(i10, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }
}
