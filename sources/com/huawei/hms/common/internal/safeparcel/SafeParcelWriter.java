package com.huawei.hms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes8.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    /* renamed from: a */
    private static void m30707a(Parcel parcel, int i10, int i11) {
        if (parcel == null) {
            return;
        }
        if (i11 < 65535) {
            parcel.writeInt(i10 | (i11 << 16));
        } else {
            parcel.writeInt(i10 | (-65536));
            parcel.writeInt(i11);
        }
    }

    /* renamed from: b */
    private static void m30709b(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    public static int beginObjectHeader(Parcel parcel) {
        return m30706a(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i10) {
        m30709b(parcel, i10);
    }

    public static void writeBigDecimal(Parcel parcel, int i10, BigDecimal bigDecimal, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigDecimal == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
            }
        } else {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            m30709b(parcel, iM30706a);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigDecimalArr == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            parcel.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i11].scale());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeBigInteger(Parcel parcel, int i10, BigInteger bigInteger, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigInteger != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeByteArray(bigInteger.toByteArray());
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigIntegerArr == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeBoolean(Parcel parcel, int i10, boolean z10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 4);
        if (z10) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i10, boolean[] zArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (zArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeBooleanArray(zArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i10, List<Boolean> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(list.get(i11).booleanValue() ? 1 : 0);
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeBooleanObject(Parcel parcel, int i10, Boolean bool, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bool != null) {
            m30707a(parcel, i10, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i10, Bundle bundle, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bundle != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeBundle(bundle);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i10, byte b10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 4);
        parcel.writeInt(b10);
    }

    public static void writeByteArray(Parcel parcel, int i10, byte[] bArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeByteArray(bArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i10, byte[][] bArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bArr == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i10, SparseArray<byte[]> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeByteArray(sparseArray.valueAt(i11));
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeChar(Parcel parcel, int i10, char c10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 4);
        parcel.writeInt(c10);
    }

    public static void writeCharArray(Parcel parcel, int i10, char[] cArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (cArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeCharArray(cArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i10, double d10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void writeDoubleArray(Parcel parcel, int i10, double[] dArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (dArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeDoubleArray(dArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i10, List<Double> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeDouble(list.get(i11).doubleValue());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeDoubleObject(Parcel parcel, int i10, Double d10, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (d10 != null) {
            m30707a(parcel, i10, 8);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i10, SparseArray<Double> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeDouble(sparseArray.valueAt(i11).doubleValue());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeFloat(Parcel parcel, int i10, float f10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void writeFloatArray(Parcel parcel, int i10, float[] fArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (fArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeFloatArray(fArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i10, List<Float> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeFloat(list.get(i11).floatValue());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeFloatObject(Parcel parcel, int i10, Float f10, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (f10 != null) {
            m30707a(parcel, i10, 4);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i10, SparseArray<Float> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeFloat(sparseArray.valueAt(i11).floatValue());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeIBinder(Parcel parcel, int i10, IBinder iBinder, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (iBinder != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i10, IBinder[] iBinderArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (iBinderArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeBinderArray(iBinderArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i10, List<IBinder> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeBinderList(list);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i10, SparseArray<IBinder> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeStrongBinder(sparseArray.valueAt(i11));
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeInt(Parcel parcel, int i10, int i11) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void writeIntArray(Parcel parcel, int i10, int[] iArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (iArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeIntArray(iArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i10, List<Integer> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(list.get(i11).intValue());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeIntegerObject(Parcel parcel, int i10, Integer num, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (num != null) {
            m30707a(parcel, i10, 4);
            parcel.writeInt(num.intValue());
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeList(Parcel parcel, int i10, List list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeList(list);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i10, long j10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void writeLongArray(Parcel parcel, int i10, long[] jArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (jArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeLongArray(jArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i10, List<Long> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeLong(list.get(i11).longValue());
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeLongObject(Parcel parcel, int i10, Long l10, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (l10 != null) {
            m30707a(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i10, Parcel parcel2, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (parcel2 != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i10, Parcel[] parcelArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (parcelArr == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int length = parcelArr.length;
        parcel.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            Parcel parcel2 = parcelArr[i11];
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                Parcel parcel3 = parcelArr[i11];
                parcel.appendFrom(parcel3, 0, parcel3.dataSize());
            }
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeParcelList(Parcel parcel, int i10, List<Parcel> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcel parcel2 = list.get(i11);
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            }
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i10, SparseArray<Parcel> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            Parcel parcelValueAt = sparseArray.valueAt(i11);
            if (parcelValueAt == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcelValueAt.dataSize());
                parcel.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            }
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeParcelable(Parcel parcel, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (parcelable != null) {
            int iM30706a = m30706a(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i10, short s10) {
        if (parcel == null) {
            return;
        }
        m30707a(parcel, i10, 4);
        parcel.writeInt(s10);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i10, SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseBooleanArray != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i10, SparseIntArray sparseIntArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseIntArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseIntArray.keyAt(i11));
            parcel.writeInt(sparseIntArray.valueAt(i11));
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeSparseLongArray(Parcel parcel, int i10, SparseLongArray sparseLongArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseLongArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseLongArray.keyAt(i11));
            parcel.writeLong(sparseLongArray.valueAt(i11));
        }
        m30709b(parcel, iM30706a);
    }

    public static void writeString(Parcel parcel, int i10, String str, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (str != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeString(str);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i10, String[] strArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (strArr != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeStringArray(strArr);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i10, List<String> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int iM30706a = m30706a(parcel, i10);
            parcel.writeStringList(list);
            m30709b(parcel, iM30706a);
        } else if (z10) {
            m30707a(parcel, i10, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i10, SparseArray<String> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeString(sparseArray.valueAt(i11));
        }
        m30709b(parcel, iM30706a);
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel parcel, int i10, P[] pArr, int i11, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (pArr == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        parcel.writeInt(iM30706a);
        for (P p10 : pArr) {
            if (p10 != null) {
                m30708a(parcel, p10, i11);
            } else {
                parcel.writeInt(0);
            }
        }
        m30709b(parcel, iM30706a);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i10, List<T> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = list.get(i11);
            if (t10 != null) {
                m30708a(parcel, t10, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        m30709b(parcel, iM30706a);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i10, SparseArray<T> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                m30707a(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM30706a = m30706a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            T tValueAt = sparseArray.valueAt(i11);
            if (tValueAt != null) {
                m30708a(parcel, tValueAt, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        m30709b(parcel, iM30706a);
    }

    /* renamed from: a */
    private static int m30706a(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: a */
    private static <P extends Parcelable> void m30708a(Parcel parcel, P p10, int i10) {
        if (parcel == null) {
            return;
        }
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        p10.writeToParcel(parcel, i10);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
