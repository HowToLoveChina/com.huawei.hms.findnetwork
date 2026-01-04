package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ohos.ohos.ohos.ohos.ohos.y */
/* loaded from: classes9.dex */
public class C11901y implements Parcelable {
    public static final Parcelable.Creator<C11901y> CREATOR = new a();

    /* renamed from: a */
    public Map<String, Object> f55118a;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.y$a */
    public static class a implements Parcelable.Creator<C11901y> {
        @Override // android.os.Parcelable.Creator
        public C11901y createFromParcel(Parcel parcel) {
            return new C11901y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11901y[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11901y[i10];
            }
            return null;
        }
    }

    public C11901y() {
        this(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <E> void m71434a(Parcel parcel, E e10) {
        int iIntValue;
        if (e10 == 0) {
            iIntValue = -1;
        } else if (e10 instanceof Boolean) {
            parcel.writeInt(1);
            iIntValue = ((Boolean) e10).booleanValue();
        } else {
            if (e10 instanceof Byte) {
                parcel.writeInt(2);
                parcel.writeByte(((Byte) e10).byteValue());
                return;
            }
            if (e10 instanceof Character) {
                parcel.writeInt(3);
                iIntValue = ((Character) e10).charValue();
            } else if (e10 instanceof Short) {
                parcel.writeInt(4);
                iIntValue = ((Short) e10).shortValue();
            } else {
                if (!(e10 instanceof Integer)) {
                    if (e10 instanceof Long) {
                        parcel.writeInt(6);
                        parcel.writeLong(((Long) e10).longValue());
                        return;
                    }
                    if (e10 instanceof Float) {
                        parcel.writeInt(7);
                        parcel.writeFloat(((Float) e10).floatValue());
                        return;
                    }
                    if (e10 instanceof Double) {
                        parcel.writeInt(8);
                        parcel.writeDouble(((Double) e10).doubleValue());
                        return;
                    }
                    if (e10 instanceof String) {
                        parcel.writeInt(9);
                        parcel.writeString((String) e10);
                        return;
                    }
                    if (e10 instanceof CharSequence) {
                        parcel.writeInt(10);
                        parcel.writeString(e10.toString());
                        return;
                    }
                    boolean z10 = e10 instanceof List;
                    if (z10) {
                        parcel.writeInt(50);
                        Parcel parcelObtain = Parcel.obtain();
                        if (!z10) {
                            throw new IllegalArgumentException("write IntentParams: unsupported type " + e10.getClass());
                        }
                        List list = (List) e10;
                        parcelObtain.writeInt(list.size());
                        Iterator<E> it = list.iterator();
                        while (it.hasNext()) {
                            m71434a(parcelObtain, it.next());
                        }
                        byte[] bArrMarshall = parcelObtain.marshall();
                        parcel.writeInt(bArrMarshall.length);
                        parcel.writeByteArray(bArrMarshall);
                        return;
                    }
                    if (e10 instanceof boolean[]) {
                        parcel.writeInt(11);
                        parcel.writeBooleanArray((boolean[]) e10);
                        return;
                    }
                    if (e10 instanceof byte[]) {
                        parcel.writeInt(12);
                        parcel.writeByteArray((byte[]) e10);
                        return;
                    }
                    if (e10 instanceof char[]) {
                        parcel.writeInt(13);
                        parcel.writeCharArray((char[]) e10);
                        return;
                    }
                    int i10 = 0;
                    if (e10 instanceof short[]) {
                        parcel.writeInt(14);
                        short[] sArr = (short[]) e10;
                        int[] iArr = new int[sArr.length];
                        while (i10 < sArr.length) {
                            iArr[i10] = sArr[i10];
                            i10++;
                        }
                        parcel.writeIntArray(iArr);
                        return;
                    }
                    if (e10 instanceof int[]) {
                        parcel.writeInt(15);
                        parcel.writeIntArray((int[]) e10);
                        return;
                    }
                    if (e10 instanceof long[]) {
                        parcel.writeInt(16);
                        parcel.writeLongArray((long[]) e10);
                        return;
                    }
                    if (e10 instanceof float[]) {
                        parcel.writeInt(17);
                        parcel.writeFloatArray((float[]) e10);
                        return;
                    }
                    if (e10 instanceof double[]) {
                        parcel.writeInt(18);
                        parcel.writeDoubleArray((double[]) e10);
                        return;
                    }
                    if (e10 instanceof String[]) {
                        parcel.writeInt(19);
                        parcel.writeStringArray((String[]) e10);
                        return;
                    }
                    if (!(e10 instanceof CharSequence[])) {
                        throw new IllegalArgumentException("the type or contained type is not support to transport when acquireohos : " + e10.getClass());
                    }
                    parcel.writeInt(20);
                    CharSequence[] charSequenceArr = (CharSequence[]) e10;
                    String[] strArr = new String[charSequenceArr.length];
                    while (i10 < charSequenceArr.length) {
                        strArr[i10] = charSequenceArr[i10].toString();
                        i10++;
                    }
                    parcel.writeStringArray(strArr);
                    return;
                }
                parcel.writeInt(5);
                iIntValue = ((Integer) e10).intValue();
            }
        }
        parcel.writeInt(iIntValue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInt(this.f55118a.size());
        for (Map.Entry<String, Object> entry : this.f55118a.entrySet()) {
            parcelObtain.writeString(entry.getKey());
            m71434a(parcelObtain, entry.getValue());
        }
        byte[] bArrMarshall = parcelObtain.marshall();
        parcel.writeInt(bArrMarshall.length);
        parcel.writeByteArray(bArrMarshall);
    }

    public C11901y(Parcel parcel) {
        Object objValueOf;
        HashMap map = new HashMap();
        this.f55118a = map;
        map.clear();
        if (parcel == null) {
            return;
        }
        int i10 = parcel.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            String string = parcel.readString();
            int i12 = parcel.readInt();
            switch (i12) {
                case -1:
                    objValueOf = null;
                    break;
                case 0:
                default:
                    throw new IllegalArgumentException("read IntentParams: unsupported value type " + i12);
                case 1:
                    objValueOf = Boolean.valueOf(parcel.readInt() != 0);
                    break;
                case 2:
                    objValueOf = Byte.valueOf(parcel.readByte());
                    break;
                case 3:
                    objValueOf = Character.valueOf((char) parcel.readInt());
                    break;
                case 4:
                    objValueOf = Short.valueOf((short) parcel.readInt());
                    break;
                case 5:
                    objValueOf = Integer.valueOf(parcel.readInt());
                    break;
                case 6:
                    objValueOf = Long.valueOf(parcel.readLong());
                    break;
                case 7:
                    objValueOf = Float.valueOf(parcel.readFloat());
                    break;
                case 8:
                    objValueOf = Double.valueOf(parcel.readDouble());
                    break;
                case 9:
                    objValueOf = parcel.readString();
                    break;
            }
            this.f55118a.put(string, objValueOf);
        }
    }
}
