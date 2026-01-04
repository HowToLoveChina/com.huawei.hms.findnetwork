package p024b0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import p408jw.C10944j;
import p692uw.C13267j;

/* renamed from: b0.d */
/* loaded from: classes.dex */
public final class C1088d {
    /* renamed from: a */
    public static final Bundle m6467a(C10944j<String, ? extends Object>... c10944jArr) {
        C13267j.m79677e(c10944jArr, "pairs");
        Bundle bundle = new Bundle(c10944jArr.length);
        for (C10944j<String, ? extends Object> c10944j : c10944jArr) {
            String strM66066b = c10944j.m66066b();
            Object objM66067c = c10944j.m66067c();
            if (objM66067c == null) {
                bundle.putString(strM66066b, null);
            } else if (objM66067c instanceof Boolean) {
                bundle.putBoolean(strM66066b, ((Boolean) objM66067c).booleanValue());
            } else if (objM66067c instanceof Byte) {
                bundle.putByte(strM66066b, ((Number) objM66067c).byteValue());
            } else if (objM66067c instanceof Character) {
                bundle.putChar(strM66066b, ((Character) objM66067c).charValue());
            } else if (objM66067c instanceof Double) {
                bundle.putDouble(strM66066b, ((Number) objM66067c).doubleValue());
            } else if (objM66067c instanceof Float) {
                bundle.putFloat(strM66066b, ((Number) objM66067c).floatValue());
            } else if (objM66067c instanceof Integer) {
                bundle.putInt(strM66066b, ((Number) objM66067c).intValue());
            } else if (objM66067c instanceof Long) {
                bundle.putLong(strM66066b, ((Number) objM66067c).longValue());
            } else if (objM66067c instanceof Short) {
                bundle.putShort(strM66066b, ((Number) objM66067c).shortValue());
            } else if (objM66067c instanceof Bundle) {
                bundle.putBundle(strM66066b, (Bundle) objM66067c);
            } else if (objM66067c instanceof CharSequence) {
                bundle.putCharSequence(strM66066b, (CharSequence) objM66067c);
            } else if (objM66067c instanceof Parcelable) {
                bundle.putParcelable(strM66066b, (Parcelable) objM66067c);
            } else if (objM66067c instanceof boolean[]) {
                bundle.putBooleanArray(strM66066b, (boolean[]) objM66067c);
            } else if (objM66067c instanceof byte[]) {
                bundle.putByteArray(strM66066b, (byte[]) objM66067c);
            } else if (objM66067c instanceof char[]) {
                bundle.putCharArray(strM66066b, (char[]) objM66067c);
            } else if (objM66067c instanceof double[]) {
                bundle.putDoubleArray(strM66066b, (double[]) objM66067c);
            } else if (objM66067c instanceof float[]) {
                bundle.putFloatArray(strM66066b, (float[]) objM66067c);
            } else if (objM66067c instanceof int[]) {
                bundle.putIntArray(strM66066b, (int[]) objM66067c);
            } else if (objM66067c instanceof long[]) {
                bundle.putLongArray(strM66066b, (long[]) objM66067c);
            } else if (objM66067c instanceof short[]) {
                bundle.putShortArray(strM66066b, (short[]) objM66067c);
            } else if (objM66067c instanceof Object[]) {
                Class<?> componentType = objM66067c.getClass().getComponentType();
                C13267j.m79674b(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    C13267j.m79675c(objM66067c, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(strM66066b, (Parcelable[]) objM66067c);
                } else if (String.class.isAssignableFrom(componentType)) {
                    C13267j.m79675c(objM66067c, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(strM66066b, (String[]) objM66067c);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    C13267j.m79675c(objM66067c, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(strM66066b, (CharSequence[]) objM66067c);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + strM66066b + '\"');
                    }
                    bundle.putSerializable(strM66066b, (Serializable) objM66067c);
                }
            } else if (objM66067c instanceof Serializable) {
                bundle.putSerializable(strM66066b, (Serializable) objM66067c);
            } else if (objM66067c instanceof IBinder) {
                C1086b.m6464a(bundle, strM66066b, (IBinder) objM66067c);
            } else if (objM66067c instanceof Size) {
                C1087c.m6465a(bundle, strM66066b, (Size) objM66067c);
            } else {
                if (!(objM66067c instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + objM66067c.getClass().getCanonicalName() + " for key \"" + strM66066b + '\"');
                }
                C1087c.m6466b(bundle, strM66066b, (SizeF) objM66067c);
            }
        }
        return bundle;
    }
}
