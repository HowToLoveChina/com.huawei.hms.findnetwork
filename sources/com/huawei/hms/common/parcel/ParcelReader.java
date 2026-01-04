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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class ParcelReader {

    /* renamed from: c */
    public static final int f23524c = 0;

    /* renamed from: d */
    public static final int f23525d = 1;

    /* renamed from: e */
    public static final int f23526e = 65262;

    /* renamed from: a */
    public HashMap<Integer, Integer[]> f23527a = new HashMap<>();

    /* renamed from: b */
    public Parcel f23528b;

    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.f23528b = parcel;
        m30711a();
    }

    /* renamed from: a */
    private int m30710a(int i10) {
        if (i10 < 0) {
            return 0;
        }
        if (i10 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i10;
    }

    /* renamed from: b */
    private int m30713b(int i10) {
        Integer[] numArr = this.f23527a.get(Integer.valueOf(i10));
        if (numArr != null) {
            this.f23528b.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:" + numArr, this.f23528b);
    }

    public BigDecimal createBigDecimal(int i10, BigDecimal bigDecimal) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bigDecimal;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        byte[] bArrCreateByteArray = this.f23528b.createByteArray();
        int i11 = this.f23528b.readInt();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i11);
    }

    public BigDecimal[] createBigDecimalArray(int i10, BigDecimal[] bigDecimalArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bigDecimalArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[iM30710a];
        for (int i11 = 0; i11 < iM30710a; i11++) {
            byte[] bArrCreateByteArray = this.f23528b.createByteArray();
            bigDecimalArr2[i11] = new BigDecimal(new BigInteger(bArrCreateByteArray), this.f23528b.readInt());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i10, BigInteger bigInteger) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bigInteger;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        byte[] bArrCreateByteArray = this.f23528b.createByteArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return new BigInteger(bArrCreateByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i10, BigInteger[] bigIntegerArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bigIntegerArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[iM30710a];
        for (int i11 = 0; i11 < iM30710a; i11++) {
            bigIntegerArr2[i11] = new BigInteger(this.f23528b.createByteArray());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i10, boolean[] zArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return zArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        boolean[] zArrCreateBooleanArray = this.f23528b.createBooleanArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return zArrCreateBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i10, ArrayList<Boolean> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            arrayList2.add(Boolean.valueOf(this.f23528b.readInt() != 0));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayList2;
    }

    public byte[] createByteArray(int i10, byte[] bArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        byte[] bArrCreateByteArray = this.f23528b.createByteArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return bArrCreateByteArray;
    }

    public byte[][] createByteArrayArray(int i10, byte[][] bArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        byte[][] bArr2 = new byte[iM30710a][];
        for (int i11 = 0; i11 < iM30710a; i11++) {
            bArr2[i11] = this.f23528b.createByteArray();
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i10, SparseArray<byte[]> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(iM30710a);
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseArray2.append(this.f23528b.readInt(), this.f23528b.createByteArray());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public char[] createCharArray(int i10, char[] cArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return cArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        char[] cArrCreateCharArray = this.f23528b.createCharArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return cArrCreateCharArray;
    }

    public double[] createDoubleArray(int i10, double[] dArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return dArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        double[] dArrCreateDoubleArray = this.f23528b.createDoubleArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return dArrCreateDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i10, ArrayList<Double> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            arrayList2.add(Double.valueOf(this.f23528b.readDouble()));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i10, SparseArray<Double> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseArray2.append(this.f23528b.readInt(), Double.valueOf(this.f23528b.readDouble()));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public float[] createFloatArray(int i10, float[] fArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return fArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        float[] fArrCreateFloatArray = this.f23528b.createFloatArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return fArrCreateFloatArray;
    }

    public ArrayList<Float> createFloatList(int i10, ArrayList<Float> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            arrayList2.add(Float.valueOf(this.f23528b.readFloat()));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i10, SparseArray<Float> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseArray2.append(this.f23528b.readInt(), Float.valueOf(this.f23528b.readFloat()));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i10, IBinder[] iBinderArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return iBinderArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        IBinder[] iBinderArrCreateBinderArray = this.f23528b.createBinderArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return iBinderArrCreateBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i10, ArrayList<IBinder> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<IBinder> arrayListCreateBinderArrayList = this.f23528b.createBinderArrayList();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayListCreateBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i10, SparseArray<IBinder> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(iM30710a);
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseArray2.append(this.f23528b.readInt(), this.f23528b.readStrongBinder());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public int[] createIntArray(int i10, int[] iArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return iArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int[] iArrCreateIntArray = this.f23528b.createIntArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return iArrCreateIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i10, ArrayList<Integer> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            arrayList2.add(Integer.valueOf(this.f23528b.readInt()));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayList2;
    }

    public long[] createLongArray(int i10, long[] jArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return jArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        long[] jArrCreateLongArray = this.f23528b.createLongArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return jArrCreateLongArray;
    }

    public ArrayList<Long> createLongList(int i10, ArrayList<Long> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            arrayList2.add(Long.valueOf(this.f23528b.readLong()));
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayList2;
    }

    public Parcel createParcel(int i10, Parcel parcel) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return parcel;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(this.f23528b, iDataPosition, iM30713b);
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return parcelObtain;
    }

    public Parcel[] createParcelArray(int i10, Parcel[] parcelArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return parcelArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        Parcel[] parcelArr2 = new Parcel[iM30710a];
        for (int i11 = 0; i11 < iM30710a; i11++) {
            int i12 = this.f23528b.readInt();
            if (i12 != 0) {
                int iDataPosition2 = this.f23528b.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.f23528b, iDataPosition2, i12);
                parcelArr2[i11] = parcelObtain;
                this.f23528b.setDataPosition(iDataPosition2 + i12);
            } else {
                parcelArr2[i11] = null;
            }
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i10, ArrayList<Parcel> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i11 = 0; i11 < iM30710a; i11++) {
            int i12 = this.f23528b.readInt();
            if (i12 != 0) {
                int iDataPosition2 = this.f23528b.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.f23528b, iDataPosition2, i12);
                arrayList2.add(parcelObtain);
                this.f23528b.setDataPosition(iDataPosition2 + i12);
            } else {
                arrayList2.add(null);
            }
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i10, SparseArray<Parcel> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i11 = 0; i11 < iM30710a; i11++) {
            int i12 = this.f23528b.readInt();
            int i13 = this.f23528b.readInt();
            if (i13 != 0) {
                int iDataPosition2 = this.f23528b.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.f23528b, iDataPosition2, i13);
                sparseArray2.append(i12, parcelObtain);
                this.f23528b.setDataPosition(iDataPosition2 + i13);
            } else {
                sparseArray2.append(i12, null);
            }
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i10, SparseBooleanArray sparseBooleanArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseBooleanArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        SparseBooleanArray sparseBooleanArray2 = this.f23528b.readSparseBooleanArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseBooleanArray2;
    }

    public SparseIntArray createSparseIntArray(int i10, SparseIntArray sparseIntArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseIntArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseIntArray2.append(this.f23528b.readInt(), this.f23528b.readInt());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i10, SparseLongArray sparseLongArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseLongArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseLongArray2.append(this.f23528b.readInt(), this.f23528b.readLong());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseLongArray2;
    }

    public String createString(int i10, String str) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return str;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        String string = this.f23528b.readString();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return string;
    }

    public String[] createStringArray(int i10, String[] strArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return strArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        String[] strArrCreateStringArray = this.f23528b.createStringArray();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return strArrCreateStringArray;
    }

    public ArrayList<String> createStringList(int i10, ArrayList<String> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<String> arrayListCreateStringArrayList = this.f23528b.createStringArrayList();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayListCreateStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i10, SparseArray<String> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int iM30710a = m30710a(this.f23528b.readInt());
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseArray2.append(this.f23528b.readInt(), this.f23528b.readString());
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i10, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return tArr;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        T[] tArr2 = (T[]) this.f23528b.createTypedArray(creator);
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return tArr2;
    }

    public <T> ArrayList<T> createTypedList(int i10, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        ArrayList<T> arrayListCreateTypedArrayList = this.f23528b.createTypedArrayList(creator);
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return arrayListCreateTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i10, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        int iM30710a = m30710a(this.f23528b.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i11 = 0; i11 < iM30710a; i11++) {
            sparseArray2.append(this.f23528b.readInt(), this.f23528b.readInt() != 0 ? creator.createFromParcel(this.f23528b) : null);
        }
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return sparseArray2;
    }

    public boolean readBoolean(int i10, boolean z10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return z10;
        }
        m30714b(i10, 4);
        return this.f23528b.readInt() != 0;
    }

    public Boolean readBooleanObject(int i10, Boolean bool) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bool;
        }
        if (m30713b(i10) == 0) {
            return null;
        }
        m30712a(i10, 4);
        int i11 = this.f23528b.readInt();
        if (i11 == 0) {
            return Boolean.FALSE;
        }
        if (i11 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i10, Bundle bundle) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return bundle;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        Bundle bundle2 = this.f23528b.readBundle();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return bundle2;
    }

    public byte readByte(int i10, byte b10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return b10;
        }
        m30714b(i10, 4);
        return (byte) this.f23528b.readInt();
    }

    public char readChar(int i10, char c10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return c10;
        }
        m30714b(i10, 4);
        return (char) this.f23528b.readInt();
    }

    public double readDouble(int i10, double d10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return d10;
        }
        m30714b(i10, 8);
        return this.f23528b.readDouble();
    }

    public Double readDoubleObject(int i10, Double d10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return d10;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        m30712a(iM30713b, 8);
        return Double.valueOf(this.f23528b.readDouble());
    }

    public float readFloat(int i10, float f10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return f10;
        }
        m30714b(i10, 4);
        return this.f23528b.readFloat();
    }

    public Float readFloatObject(int i10, Float f10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return f10;
        }
        if (m30713b(i10) == 0) {
            return null;
        }
        m30712a(i10, 4);
        return Float.valueOf(this.f23528b.readFloat());
    }

    public IBinder readIBinder(int i10, IBinder iBinder) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return iBinder;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        IBinder strongBinder = this.f23528b.readStrongBinder();
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return strongBinder;
    }

    public int readInt(int i10, int i11) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return i11;
        }
        m30714b(i10, 4);
        return this.f23528b.readInt();
    }

    public Integer readIntegerObject(int i10, Integer num) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return num;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        m30712a(iM30713b, 4);
        return Integer.valueOf(this.f23528b.readInt());
    }

    public void readList(int i10, List list, ClassLoader classLoader) {
        if (this.f23527a.containsKey(Integer.valueOf(i10))) {
            int iM30713b = m30713b(i10);
            int iDataPosition = this.f23528b.dataPosition();
            if (iM30713b != 0) {
                this.f23528b.readList(list, classLoader);
                this.f23528b.setDataPosition(iDataPosition + iM30713b);
            }
        }
    }

    public long readLong(int i10, long j10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return j10;
        }
        m30714b(i10, 8);
        return this.f23528b.readLong();
    }

    public Long readLongObject(int i10, Long l10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return l10;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        m30712a(iM30713b, 8);
        return Long.valueOf(this.f23528b.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i10, Parcelable.Creator<T> creator, T t10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return t10;
        }
        int iM30713b = m30713b(i10);
        if (iM30713b == 0) {
            return null;
        }
        int iDataPosition = this.f23528b.dataPosition();
        T tCreateFromParcel = creator.createFromParcel(this.f23528b);
        this.f23528b.setDataPosition(iDataPosition + iM30713b);
        return tCreateFromParcel;
    }

    public short readShort(int i10, short s10) {
        if (!this.f23527a.containsKey(Integer.valueOf(i10))) {
            return s10;
        }
        m30714b(i10, 4);
        return (short) this.f23528b.readInt();
    }

    /* renamed from: a */
    private void m30711a() {
        int i10 = this.f23528b.readInt();
        int i11 = i10 & 65535;
        int i12 = (i10 & (-65536)) != -65536 ? (i10 >> 16) & 65535 : this.f23528b.readInt();
        if (i11 != 65262) {
            throw new ParseException("Parse header error, not 65262. Got 0x" + Integer.toHexString(i11), this.f23528b);
        }
        int iDataPosition = this.f23528b.dataPosition();
        int i13 = i12 + iDataPosition;
        if (i13 < iDataPosition || i13 > this.f23528b.dataSize()) {
            throw new ParseException("invalid size, start=" + iDataPosition + " end=" + i13, this.f23528b);
        }
        while (this.f23528b.dataPosition() < i13) {
            int i14 = this.f23528b.readInt();
            int i15 = i14 & 65535;
            int i16 = (i14 & (-65536)) != -65536 ? (i14 >> 16) & 65535 : this.f23528b.readInt();
            int iDataPosition2 = this.f23528b.dataPosition();
            this.f23527a.put(Integer.valueOf(i15), new Integer[]{Integer.valueOf(iDataPosition2), Integer.valueOf(i16)});
            this.f23528b.setDataPosition(iDataPosition2 + i16);
        }
        if (this.f23528b.dataPosition() == i13) {
            return;
        }
        throw new ParseException("the dataPosition is not" + i13, this.f23528b);
    }

    /* renamed from: b */
    private int m30714b(int i10, int i11) {
        Integer[] numArr = this.f23527a.get(Integer.valueOf(i10));
        if (numArr != null) {
            this.f23528b.setDataPosition(numArr[0].intValue());
            m30712a(i10, i11);
            return i11;
        }
        throw new ParseException("Field is null:" + numArr, this.f23528b);
    }

    /* renamed from: a */
    private void m30712a(int i10, int i11) {
        Integer[] numArr = this.f23527a.get(Integer.valueOf(i10));
        if (numArr == null) {
            throw new ParseException("Field is null:" + numArr, this.f23528b);
        }
        int iIntValue = numArr[1].intValue();
        if (iIntValue == i11) {
            return;
        }
        throw new ParseException("the field size is not " + i11 + " got " + iIntValue + " (0x" + Integer.toHexString(iIntValue) + ")", this.f23528b);
    }
}
