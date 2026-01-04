package com.huawei.hms.common.parcel;

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
public class ParcelWrite {

    /* renamed from: b */
    public static final int f23530b = 65262;

    /* renamed from: a */
    public Parcel f23531a;

    public ParcelWrite(Parcel parcel) {
        this.f23531a = parcel;
    }

    /* renamed from: a */
    private int m30715a(int i10) {
        this.f23531a.writeInt(i10 | (-65536));
        this.f23531a.writeInt(0);
        return this.f23531a.dataPosition();
    }

    /* renamed from: b */
    private void m30718b(int i10) {
        int iDataPosition = this.f23531a.dataPosition();
        this.f23531a.setDataPosition(i10 - 4);
        this.f23531a.writeInt(iDataPosition - i10);
        this.f23531a.setDataPosition(iDataPosition);
    }

    public int beginObjectHeader() {
        return m30715a(65262);
    }

    public void finishObjectHeader(int i10) {
        m30718b(i10);
    }

    public void writeBigDecimal(int i10, BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.f23531a.writeInt(bigDecimal.scale());
            m30718b(iM30715a);
        }
    }

    public void writeBigDecimalArray(int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int length = bigDecimalArr.length;
        this.f23531a.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            this.f23531a.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
            this.f23531a.writeInt(bigDecimalArr[i11].scale());
        }
        m30718b(iM30715a);
    }

    public void writeBigInteger(int i10, BigInteger bigInteger, boolean z10) {
        if (bigInteger == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeByteArray(bigInteger.toByteArray());
            m30718b(iM30715a);
        }
    }

    public void writeBigIntegerArray(int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        this.f23531a.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            this.f23531a.writeByteArray(bigInteger.toByteArray());
        }
        m30718b(iM30715a);
    }

    public void writeBoolean(int i10, boolean z10) {
        m30716a(i10, 4);
        this.f23531a.writeInt(z10 ? 1 : 0);
    }

    public void writeBooleanArray(int i10, boolean[] zArr, boolean z10) {
        if (zArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeBooleanArray(zArr);
            m30718b(iM30715a);
        }
    }

    public void writeBooleanList(int i10, List<Boolean> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(list.get(i11).booleanValue() ? 1 : 0);
        }
        m30718b(iM30715a);
    }

    public void writeBooleanObject(int i10, Boolean bool) {
        writeBooleanObject(i10, bool, false);
    }

    public void writeBundle(int i10, Bundle bundle, boolean z10) {
        if (bundle == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeBundle(bundle);
            m30718b(iM30715a);
        }
    }

    public void writeByte(int i10, byte b10) {
        m30716a(i10, 4);
        this.f23531a.writeInt(b10);
    }

    public void writeByteArray(int i10, byte[] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeByteArray(bArr);
            m30718b(iM30715a);
        }
    }

    public void writeByteArrayArray(int i10, byte[][] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        this.f23531a.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            this.f23531a.writeByteArray(bArr2);
        }
        m30718b(iM30715a);
    }

    public void writeByteArraySparseArray(int i10, SparseArray<byte[]> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            this.f23531a.writeByteArray(sparseArray.valueAt(i11));
        }
        m30718b(iM30715a);
    }

    public void writeChar(int i10, char c10) {
        m30716a(i10, 4);
        this.f23531a.writeInt(c10);
    }

    public void writeCharArray(int i10, char[] cArr, boolean z10) {
        if (cArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeCharArray(cArr);
            m30718b(iM30715a);
        }
    }

    public void writeDouble(int i10, double d10) {
        m30716a(i10, 8);
        this.f23531a.writeDouble(d10);
    }

    public void writeDoubleArray(int i10, double[] dArr, boolean z10) {
        if (dArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeDoubleArray(dArr);
            m30718b(iM30715a);
        }
    }

    public void writeDoubleList(int i10, List<Double> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeDouble(list.get(i11).doubleValue());
        }
        m30718b(iM30715a);
    }

    public void writeDoubleObject(int i10, Double d10, boolean z10) {
        if (d10 != null) {
            m30716a(i10, 8);
            this.f23531a.writeDouble(d10.doubleValue());
        } else if (z10) {
            m30716a(i10, 0);
        }
    }

    public void writeDoubleSparseArray(int i10, SparseArray<Double> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            this.f23531a.writeDouble(sparseArray.valueAt(i11).doubleValue());
        }
        m30718b(iM30715a);
    }

    public void writeFloat(int i10, float f10) {
        m30716a(i10, 4);
        this.f23531a.writeFloat(f10);
    }

    public void writeFloatArray(int i10, float[] fArr, boolean z10) {
        if (fArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeFloatArray(fArr);
            m30718b(iM30715a);
        }
    }

    public void writeFloatList(int i10, List<Float> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeFloat(list.get(i11).floatValue());
        }
        m30718b(iM30715a);
    }

    public void writeFloatObject(int i10, Float f10, boolean z10) {
        if (f10 != null) {
            m30716a(i10, 4);
            this.f23531a.writeFloat(f10.floatValue());
        } else if (z10) {
            m30716a(i10, 0);
        }
    }

    public void writeFloatSparseArray(int i10, SparseArray<Float> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            this.f23531a.writeFloat(sparseArray.valueAt(i11).floatValue());
        }
        m30718b(iM30715a);
    }

    public void writeIBinder(int i10, IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeStrongBinder(iBinder);
            m30718b(iM30715a);
        }
    }

    public void writeIBinderArray(int i10, IBinder[] iBinderArr, boolean z10) {
        if (iBinderArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeBinderArray(iBinderArr);
            m30718b(iM30715a);
        }
    }

    public void writeIBinderList(int i10, List<IBinder> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeBinderList(list);
            m30718b(iM30715a);
        }
    }

    public void writeIBinderSparseArray(int i10, SparseArray<IBinder> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            this.f23531a.writeStrongBinder(sparseArray.valueAt(i11));
        }
        m30718b(iM30715a);
    }

    public void writeInt(int i10, int i11) {
        m30716a(i10, 4);
        this.f23531a.writeInt(i11);
    }

    public void writeIntArray(int i10, int[] iArr, boolean z10) {
        if (iArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeIntArray(iArr);
            m30718b(iM30715a);
        }
    }

    public void writeIntegerList(int i10, List<Integer> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(list.get(i11).intValue());
        }
        m30718b(iM30715a);
    }

    public void writeIntegerObject(int i10, Integer num, boolean z10) {
        if (num != null) {
            m30716a(i10, 4);
            this.f23531a.writeInt(num.intValue());
        } else if (z10) {
            m30716a(i10, 0);
        }
    }

    public void writeList(int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeList(list);
            m30718b(iM30715a);
        }
    }

    public void writeLong(int i10, long j10) {
        m30716a(i10, 8);
        this.f23531a.writeLong(j10);
    }

    public void writeLongArray(int i10, long[] jArr, boolean z10) {
        if (jArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeLongArray(jArr);
            m30718b(iM30715a);
        }
    }

    public void writeLongList(int i10, List<Long> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeLong(list.get(i11).longValue());
        }
        m30718b(iM30715a);
    }

    public void writeLongObject(int i10, Long l10, boolean z10) {
        if (l10 != null) {
            m30716a(i10, 8);
            this.f23531a.writeLong(l10.longValue());
        } else if (z10) {
            m30716a(i10, 0);
        }
    }

    public void writeParcel(int i10, Parcel parcel, boolean z10) {
        if (parcel == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.appendFrom(parcel, 0, parcel.dataSize());
            m30718b(iM30715a);
        }
    }

    public void writeParcelArray(int i10, Parcel[] parcelArr, boolean z10) {
        if (parcelArr == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        this.f23531a.writeInt(parcelArr.length);
        for (Parcel parcel : parcelArr) {
            if (parcel != null) {
                this.f23531a.writeInt(parcel.dataSize());
                this.f23531a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f23531a.writeInt(0);
            }
        }
        m30718b(iM30715a);
    }

    public void writeParcelList(int i10, List<Parcel> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcel parcel = list.get(i11);
            if (parcel != null) {
                this.f23531a.writeInt(parcel.dataSize());
                this.f23531a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f23531a.writeInt(0);
            }
        }
        m30718b(iM30715a);
    }

    public void writeParcelSparseArray(int i10, SparseArray<Parcel> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            Parcel parcelValueAt = sparseArray.valueAt(i11);
            if (parcelValueAt != null) {
                this.f23531a.writeInt(parcelValueAt.dataSize());
                this.f23531a.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            } else {
                this.f23531a.writeInt(0);
            }
        }
        m30718b(iM30715a);
    }

    public void writeParcelable(int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            parcelable.writeToParcel(this.f23531a, i11);
            m30718b(iM30715a);
        }
    }

    public void writeShort(int i10, short s10) {
        m30716a(i10, 4);
        this.f23531a.writeInt(s10);
    }

    public void writeSparseBooleanArray(int i10, SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (sparseBooleanArray == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeSparseBooleanArray(sparseBooleanArray);
            m30718b(iM30715a);
        }
    }

    public void writeSparseIntArray(int i10, SparseIntArray sparseIntArray, boolean z10) {
        if (sparseIntArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseIntArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseIntArray.keyAt(i11));
            this.f23531a.writeInt(sparseIntArray.valueAt(i11));
        }
        m30718b(iM30715a);
    }

    public void writeSparseLongArray(int i10, SparseLongArray sparseLongArray, boolean z10) {
        if (sparseLongArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseLongArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseLongArray.keyAt(i11));
            this.f23531a.writeLong(sparseLongArray.valueAt(i11));
        }
        m30718b(iM30715a);
    }

    public void writeString(int i10, String str, boolean z10) {
        if (str == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeString(str);
            m30718b(iM30715a);
        }
    }

    public void writeStringArray(int i10, String[] strArr, boolean z10) {
        if (strArr == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeStringArray(strArr);
            m30718b(iM30715a);
        }
    }

    public void writeStringList(int i10, List<String> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
            }
        } else {
            int iM30715a = m30715a(i10);
            this.f23531a.writeStringList(list);
            m30718b(iM30715a);
        }
    }

    public void writeStringSparseArray(int i10, SparseArray<String> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            this.f23531a.writeString(sparseArray.valueAt(i11));
        }
        m30718b(iM30715a);
    }

    public <T extends Parcelable> void writeTypedArray(int i10, T[] tArr, int i11, boolean z10) {
        if (tArr == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        this.f23531a.writeInt(tArr.length);
        for (T t10 : tArr) {
            if (t10 == null) {
                this.f23531a.writeInt(0);
            } else {
                m30717a((ParcelWrite) t10, i11);
            }
        }
        m30718b(iM30715a);
    }

    public <T extends Parcelable> void writeTypedList(int i10, List<T> list, boolean z10) {
        if (list == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = list.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = list.get(i11);
            if (t10 == null) {
                this.f23531a.writeInt(0);
            } else {
                m30717a((ParcelWrite) t10, 0);
            }
        }
        m30718b(iM30715a);
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i10, SparseArray<T> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                m30716a(i10, 0);
                return;
            }
            return;
        }
        int iM30715a = m30715a(i10);
        int size = sparseArray.size();
        this.f23531a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f23531a.writeInt(sparseArray.keyAt(i11));
            T tValueAt = sparseArray.valueAt(i11);
            if (tValueAt == null) {
                this.f23531a.writeInt(0);
            } else {
                m30717a((ParcelWrite) tValueAt, 0);
            }
        }
        m30718b(iM30715a);
    }

    /* renamed from: a */
    private void m30716a(int i10, int i11) {
        if (i11 < 65535) {
            this.f23531a.writeInt(i10 | (i11 << 16));
        } else {
            this.f23531a.writeInt(i10 | (-65536));
            this.f23531a.writeInt(i11);
        }
    }

    public void writeBooleanObject(int i10, Boolean bool, boolean z10) {
        if (bool != null) {
            m30716a(i10, 4);
            this.f23531a.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            m30716a(i10, 0);
        }
    }

    /* renamed from: a */
    private <T extends Parcelable> void m30717a(T t10, int i10) {
        int iDataPosition = this.f23531a.dataPosition();
        this.f23531a.writeInt(1);
        int iDataPosition2 = this.f23531a.dataPosition();
        t10.writeToParcel(this.f23531a, i10);
        int iDataPosition3 = this.f23531a.dataPosition();
        this.f23531a.setDataPosition(iDataPosition);
        this.f23531a.writeInt(iDataPosition3 - iDataPosition2);
        this.f23531a.setDataPosition(iDataPosition3);
    }
}
