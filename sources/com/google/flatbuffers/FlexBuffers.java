package com.google.flatbuffers;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        public Blob(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f9445bb.data());
            byteBufferWrap.position(this.end);
            byteBufferWrap.limit(this.end + size());
            return byteBufferWrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i10) {
            return this.f9445bb.get(this.end + i10);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i10 = 0; i10 < size; i10++) {
                bArr[i10] = this.f9445bb.get(this.end + i10);
            }
            return bArr;
        }

        @Override // com.google.flatbuffers.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // com.google.flatbuffers.FlexBuffers.Object
        public String toString() {
            return this.f9445bb.getString(this.end, size());
        }

        @Override // com.google.flatbuffers.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append('\"');
            sb2.append(this.f9445bb.getString(this.end, size()));
            sb2.append('\"');
            return sb2;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        public Key(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        public static Key empty() {
            return EMPTY;
        }

        public int compareTo(byte[] bArr) {
            byte b10;
            byte b11;
            int i10 = this.end;
            int i11 = 0;
            do {
                b10 = this.f9445bb.get(i10);
                b11 = bArr[i11];
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
                if (i11 == bArr.length) {
                    int i12 = b10 - b11;
                    if (i12 != 0 || this.f9445bb.get(i10) == 0) {
                        return i12;
                    }
                    return 1;
                }
            } while (b10 == b11);
            return b10 - b11;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.end == this.end && key.byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.byteWidth ^ this.end;
        }

        @Override // com.google.flatbuffers.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        @Override // com.google.flatbuffers.FlexBuffers.Object
        public String toString() {
            int i10 = this.end;
            while (this.f9445bb.get(i10) != 0) {
                i10++;
            }
            int i11 = this.end;
            return this.f9445bb.getString(i11, i10 - i11);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        public KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i10) {
            if (i10 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            int i11 = typedVector.end + (i10 * typedVector.byteWidth);
            TypedVector typedVector2 = this.vec;
            ReadBuf readBuf = typedVector2.f9445bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, i11, typedVector2.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i10 = 0; i10 < this.vec.size(); i10++) {
                this.vec.get(i10).toString(sb2);
                if (i10 != this.vec.size() - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static abstract class Object {

        /* renamed from: bb */
        ReadBuf f9445bb;
        int byteWidth;
        int end;

        public Object(ReadBuf readBuf, int i10, int i11) {
            this.f9445bb = readBuf;
            this.end = i10;
            this.byteWidth = i11;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb2);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);

        /* renamed from: bb */
        private ReadBuf f9446bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        public Reference(ReadBuf readBuf, int i10, int i11, int i12) {
            this(readBuf, i10, i11, 1 << (i12 & 3), i12 >> 2);
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.f9446bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            return isBoolean() ? this.f9446bb.get(this.end) != 0 : asUInt() != 0;
        }

        public double asFloat() {
            int i10 = this.type;
            if (i10 == 3) {
                return FlexBuffers.readDouble(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 1) {
                return FlexBuffers.readInt(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 != 2) {
                if (i10 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i10 == 6) {
                    ReadBuf readBuf = this.f9446bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 == 7) {
                    ReadBuf readBuf2 = this.f9446bb;
                    return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 == 8) {
                    ReadBuf readBuf3 = this.f9446bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 == 10) {
                    return asVector().size();
                }
                if (i10 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.readUInt(this.f9446bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int i10 = this.type;
            if (i10 == 1) {
                return FlexBuffers.readInt(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 2) {
                return (int) FlexBuffers.readUInt(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (int) FlexBuffers.readDouble(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                return Integer.parseInt(asString());
            }
            if (i10 == 6) {
                ReadBuf readBuf = this.f9446bb;
                return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 7) {
                ReadBuf readBuf2 = this.f9446bb;
                return (int) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i10 == 8) {
                ReadBuf readBuf3 = this.f9446bb;
                return (int) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 10) {
                return asVector().size();
            }
            if (i10 != 26) {
                return 0;
            }
            return FlexBuffers.readInt(this.f9446bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            ReadBuf readBuf = this.f9446bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public long asLong() {
            int i10 = this.type;
            if (i10 == 1) {
                return FlexBuffers.readLong(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 2) {
                return FlexBuffers.readUInt(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.readDouble(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i10 == 6) {
                ReadBuf readBuf = this.f9446bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 7) {
                ReadBuf readBuf2 = this.f9446bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i10 == 8) {
                ReadBuf readBuf3 = this.f9446bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 10) {
                return asVector().size();
            }
            if (i10 != 26) {
                return 0L;
            }
            return FlexBuffers.readInt(this.f9446bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            ReadBuf readBuf = this.f9446bb;
            return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int iIndirect = FlexBuffers.indirect(this.f9446bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.f9446bb;
                int i10 = this.byteWidth;
                return this.f9446bb.getString(iIndirect, (int) FlexBuffers.readUInt(readBuf, iIndirect - i10, i10));
            }
            if (!isKey()) {
                return "";
            }
            int iIndirect2 = FlexBuffers.indirect(this.f9446bb, this.end, this.byteWidth);
            int i11 = iIndirect2;
            while (this.f9446bb.get(i11) != 0) {
                i11++;
            }
            return this.f9446bb.getString(iIndirect2, i11 - iIndirect2);
        }

        public long asUInt() {
            int i10 = this.type;
            if (i10 == 2) {
                return FlexBuffers.readUInt(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 1) {
                return FlexBuffers.readLong(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.readDouble(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 10) {
                return asVector().size();
            }
            if (i10 == 26) {
                return FlexBuffers.readInt(this.f9446bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                return Long.parseLong(asString());
            }
            if (i10 == 6) {
                ReadBuf readBuf = this.f9446bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 7) {
                ReadBuf readBuf2 = this.f9446bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 != 8) {
                return 0L;
            }
            ReadBuf readBuf3 = this.f9446bb;
            return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.f9446bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i10 = this.type;
            if (i10 == 15) {
                ReadBuf readBuf2 = this.f9446bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (!FlexBuffers.isTypedVector(i10)) {
                return Vector.empty();
            }
            ReadBuf readBuf3 = this.f9446bb;
            return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            int i10 = this.type;
            return i10 == 3 || i10 == 8;
        }

        public boolean isInt() {
            int i10 = this.type;
            return i10 == 1 || i10 == 6;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i10 = this.type;
            return i10 == 2 || i10 == 7;
        }

        public boolean isVector() {
            int i10 = this.type;
            return i10 == 10 || i10 == 9;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf readBuf, int i10, int i11, int i12, int i13) {
            this.f9446bb = readBuf;
            this.end = i10;
            this.parentWidth = i11;
            this.byteWidth = i12;
            this.type = i13;
        }

        public StringBuilder toString(StringBuilder sb2) {
            int i10 = this.type;
            if (i10 != 36) {
                switch (i10) {
                    case 0:
                        sb2.append("null");
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(asLong());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(asUInt());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(asFloat());
                        return sb2;
                    case 4:
                        Key keyAsKey = asKey();
                        sb2.append('\"');
                        StringBuilder string = keyAsKey.toString(sb2);
                        string.append('\"');
                        return string;
                    case 5:
                        sb2.append('\"');
                        sb2.append(asString());
                        sb2.append('\"');
                        return sb2;
                    case 9:
                        return asMap().toString(sb2);
                    case 10:
                        return asVector().toString(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb2);
                    case 26:
                        sb2.append(asBoolean());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(asVector());
            return sb2;
        }
    }

    public static abstract class Sized extends Object {
        protected final int size;

        public Sized(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
            this.size = (int) FlexBuffers.readUInt(this.f9445bb, i10 - i11, i11);
        }

        public int size() {
            return this.size;
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        public TypedVector(ReadBuf readBuf, int i10, int i11, int i12) {
            super(readBuf, i10, i11);
            this.elemType = i12;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // com.google.flatbuffers.FlexBuffers.Vector
        public Reference get(int i10) {
            if (i10 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f9445bb, this.end + (i10 * this.byteWidth), this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }
    }

    public static class Unsigned {
        public static int byteToUnsignedInt(byte b10) {
            return b10 & 255;
        }

        public static long intToUnsignedLong(int i10) {
            return i10 & 4294967295L;
        }

        public static int shortToUnsignedInt(short s10) {
            return s10 & 65535;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        public Vector(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i10) {
            long size = size();
            long j10 = i10;
            if (j10 >= size) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f9445bb, this.end + (i10 * this.byteWidth), this.byteWidth, Unsigned.byteToUnsignedInt(this.f9445bb.get((int) (this.end + (size * this.byteWidth) + j10))));
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // com.google.flatbuffers.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // com.google.flatbuffers.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // com.google.flatbuffers.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("[ ");
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                get(i10).toString(sb2);
                if (i10 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" ]");
            return sb2;
        }
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indirect(ReadBuf readBuf, int i10, int i11) {
        return (int) (i10 - readUInt(readBuf, i10, i11));
    }

    public static boolean isTypeInline(int i10) {
        return i10 <= 3 || i10 == 26;
    }

    public static boolean isTypedVector(int i10) {
        return (i10 >= 11 && i10 <= 15) || i10 == 36;
    }

    public static boolean isTypedVectorElementType(int i10) {
        return (i10 >= 1 && i10 <= 4) || i10 == 26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double readDouble(ReadBuf readBuf, int i10, int i11) {
        if (i11 == 4) {
            return readBuf.getFloat(i10);
        }
        if (i11 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readInt(ReadBuf readBuf, int i10, int i11) {
        return (int) readLong(readBuf, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readLong(ReadBuf readBuf, int i10, int i11) {
        int i12;
        if (i11 == 1) {
            i12 = readBuf.get(i10);
        } else if (i11 == 2) {
            i12 = readBuf.getShort(i10);
        } else {
            if (i11 != 4) {
                if (i11 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i10);
            }
            i12 = readBuf.getInt(i10);
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readUInt(ReadBuf readBuf, int i10, int i11) {
        if (i11 == 1) {
            return Unsigned.byteToUnsignedInt(readBuf.get(i10));
        }
        if (i11 == 2) {
            return Unsigned.shortToUnsignedInt(readBuf.getShort(i10));
        }
        if (i11 == 4) {
            return Unsigned.intToUnsignedLong(readBuf.getInt(i10));
        }
        if (i11 != 8) {
            return -1L;
        }
        return readBuf.getLong(i10);
    }

    public static int toTypedVector(int i10, int i11) {
        if (i11 == 0) {
            return i10 + 10;
        }
        if (i11 == 2) {
            return i10 + 15;
        }
        if (i11 == 3) {
            return i10 + 18;
        }
        if (i11 != 4) {
            return 0;
        }
        return i10 + 21;
    }

    public static int toTypedVectorElementType(int i10) {
        return i10 - 10;
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int iLimit = readBuf.limit();
        byte b10 = readBuf.get(iLimit - 1);
        int i10 = iLimit - 2;
        return new Reference(readBuf, i10 - b10, b10, Unsigned.byteToUnsignedInt(readBuf.get(i10)));
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);
        private final byte[] comparisonBuffer;

        public Map(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
            this.comparisonBuffer = new byte[4];
        }

        private int binarySearch(CharSequence charSequence) {
            int i10 = this.size - 1;
            int i11 = this.end;
            int i12 = this.byteWidth;
            int i13 = i11 - (i12 * 3);
            int iIndirect = FlexBuffers.indirect(this.f9445bb, i13, i12);
            ReadBuf readBuf = this.f9445bb;
            int i14 = this.byteWidth;
            int i15 = FlexBuffers.readInt(readBuf, i13 + i14, i14);
            int i16 = 0;
            while (i16 <= i10) {
                int i17 = (i16 + i10) >>> 1;
                int iCompareCharSequence = compareCharSequence(FlexBuffers.indirect(this.f9445bb, (i17 * i15) + iIndirect, i15), charSequence);
                if (iCompareCharSequence < 0) {
                    i16 = i17 + 1;
                } else {
                    if (iCompareCharSequence <= 0) {
                        return i17;
                    }
                    i10 = i17 - 1;
                }
            }
            return -(i16 + 1);
        }

        private int compareBytes(ReadBuf readBuf, int i10, byte[] bArr) {
            byte b10;
            byte b11;
            int i11 = 0;
            do {
                b10 = readBuf.get(i10);
                b11 = bArr[i11];
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
                if (i11 == bArr.length) {
                    int i12 = b10 - b11;
                    if (i12 != 0 || readBuf.get(i10) == 0) {
                        return i12;
                    }
                    return 1;
                }
            } while (b10 == b11);
            return b10 - b11;
        }

        private int compareCharSequence(int i10, CharSequence charSequence) {
            int iLimit = this.f9445bb.limit();
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                byte bCharAt = charSequence.charAt(i11);
                if (bCharAt >= 128) {
                    break;
                }
                byte b10 = this.f9445bb.get(i10);
                if (b10 == 0) {
                    return -bCharAt;
                }
                if (b10 < 0) {
                    break;
                }
                if (((char) b10) != bCharAt) {
                    return b10 - bCharAt;
                }
                i10++;
                i11++;
            }
            while (i10 < iLimit) {
                int iEncodeUtf8CodePoint = Utf8.encodeUtf8CodePoint(charSequence, i11, this.comparisonBuffer);
                if (iEncodeUtf8CodePoint == 0) {
                    return this.f9445bb.get(i10);
                }
                int i12 = 0;
                while (i12 < iEncodeUtf8CodePoint) {
                    int i13 = i10 + 1;
                    byte b11 = this.f9445bb.get(i10);
                    byte b12 = this.comparisonBuffer[i12];
                    if (b11 == 0) {
                        return -b12;
                    }
                    if (b11 != b12) {
                        return b11 - b12;
                    }
                    i12++;
                    i10 = i13;
                }
                i11 += iEncodeUtf8CodePoint == 4 ? 2 : 1;
            }
            return 0;
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            int iBinarySearch = binarySearch(str);
            return (iBinarySearch < 0 || iBinarySearch >= this.size) ? Reference.NULL_REFERENCE : get(iBinarySearch);
        }

        public KeyVector keys() {
            int i10 = this.end - (this.byteWidth * 3);
            ReadBuf readBuf = this.f9445bb;
            int iIndirect = FlexBuffers.indirect(readBuf, i10, this.byteWidth);
            ReadBuf readBuf2 = this.f9445bb;
            int i11 = this.byteWidth;
            return new KeyVector(new TypedVector(readBuf, iIndirect, FlexBuffers.readInt(readBuf2, i10 + i11, i11), 4));
        }

        @Override // com.google.flatbuffers.FlexBuffers.Vector, com.google.flatbuffers.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("{ ");
            KeyVector keyVectorKeys = keys();
            int size = size();
            Vector vectorValues = values();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append('\"');
                sb2.append(keyVectorKeys.get(i10).toString());
                sb2.append("\" : ");
                sb2.append(vectorValues.get(i10).toString());
                if (i10 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public Vector values() {
            return new Vector(this.f9445bb, this.end, this.byteWidth);
        }

        public Reference get(byte[] bArr) {
            int iBinarySearch = binarySearch(bArr);
            if (iBinarySearch >= 0 && iBinarySearch < this.size) {
                return get(iBinarySearch);
            }
            return Reference.NULL_REFERENCE;
        }

        private int binarySearch(byte[] bArr) {
            int i10 = this.size - 1;
            int i11 = this.end;
            int i12 = this.byteWidth;
            int i13 = i11 - (i12 * 3);
            int iIndirect = FlexBuffers.indirect(this.f9445bb, i13, i12);
            ReadBuf readBuf = this.f9445bb;
            int i14 = this.byteWidth;
            int i15 = FlexBuffers.readInt(readBuf, i13 + i14, i14);
            int i16 = 0;
            while (i16 <= i10) {
                int i17 = (i16 + i10) >>> 1;
                int iCompareBytes = compareBytes(this.f9445bb, FlexBuffers.indirect(this.f9445bb, (i17 * i15) + iIndirect, i15), bArr);
                if (iCompareBytes < 0) {
                    i16 = i17 + 1;
                } else {
                    if (iCompareBytes <= 0) {
                        return i17;
                    }
                    i10 = i17 - 1;
                }
            }
            return -(i16 + 1);
        }
    }
}
