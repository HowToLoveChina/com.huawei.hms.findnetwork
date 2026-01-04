package com.google.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void clear() {
        this.buffer.clear();
    }

    @Override // com.google.flatbuffers.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // com.google.flatbuffers.ReadBuf
    public byte get(int i10) {
        return this.buffer.get(i10);
    }

    @Override // com.google.flatbuffers.ReadBuf
    public boolean getBoolean(int i10) {
        return get(i10) != 0;
    }

    @Override // com.google.flatbuffers.ReadBuf
    public double getDouble(int i10) {
        return this.buffer.getDouble(i10);
    }

    @Override // com.google.flatbuffers.ReadBuf
    public float getFloat(int i10) {
        return this.buffer.getFloat(i10);
    }

    @Override // com.google.flatbuffers.ReadBuf
    public int getInt(int i10) {
        return this.buffer.getInt(i10);
    }

    @Override // com.google.flatbuffers.ReadBuf
    public long getLong(int i10) {
        return this.buffer.getLong(i10);
    }

    @Override // com.google.flatbuffers.ReadBuf
    public short getShort(int i10) {
        return this.buffer.getShort(i10);
    }

    @Override // com.google.flatbuffers.ReadBuf
    public String getString(int i10, int i11) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i10, i11);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf, com.google.flatbuffers.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void put(byte[] bArr, int i10, int i11) {
        this.buffer.put(bArr, i10, i11);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void putBoolean(boolean z10) {
        this.buffer.put(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void putDouble(double d10) {
        this.buffer.putDouble(d10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void putFloat(float f10) {
        this.buffer.putFloat(f10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void putInt(int i10) {
        this.buffer.putInt(i10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void putLong(long j10) {
        this.buffer.putLong(j10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void putShort(short s10) {
        this.buffer.putShort(s10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public boolean requestCapacity(int i10) {
        return i10 <= this.buffer.limit();
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void set(int i10, byte b10) {
        requestCapacity(i10 + 1);
        this.buffer.put(i10, b10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void setBoolean(int i10, boolean z10) {
        set(i10, z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void setDouble(int i10, double d10) {
        requestCapacity(i10 + 8);
        this.buffer.putDouble(i10, d10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void setFloat(int i10, float f10) {
        requestCapacity(i10 + 4);
        this.buffer.putFloat(i10, f10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void setInt(int i10, int i11) {
        requestCapacity(i10 + 4);
        this.buffer.putInt(i10, i11);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void setLong(int i10, long j10) {
        requestCapacity(i10 + 8);
        this.buffer.putLong(i10, j10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void setShort(int i10, short s10) {
        requestCapacity(i10 + 2);
        this.buffer.putShort(i10, s10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void put(byte b10) {
        this.buffer.put(b10);
    }

    @Override // com.google.flatbuffers.ReadWriteBuf
    public void set(int i10, byte[] bArr, int i11, int i12) {
        requestCapacity((i12 - i11) + i10);
        int iPosition = this.buffer.position();
        this.buffer.position(i10);
        this.buffer.put(bArr, i11, i12);
        this.buffer.position(iPosition);
    }
}
