package androidx.core.content;

import android.content.ContentValues;
import p408jw.C10944j;
import p692uw.C13267j;

/* loaded from: classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(C10944j<String, ? extends Object>... c10944jArr) {
        C13267j.m79677e(c10944jArr, "pairs");
        ContentValues contentValues = new ContentValues(c10944jArr.length);
        for (C10944j<String, ? extends Object> c10944j : c10944jArr) {
            String strM66066b = c10944j.m66066b();
            Object objM66067c = c10944j.m66067c();
            if (objM66067c == null) {
                contentValues.putNull(strM66066b);
            } else if (objM66067c instanceof String) {
                contentValues.put(strM66066b, (String) objM66067c);
            } else if (objM66067c instanceof Integer) {
                contentValues.put(strM66066b, (Integer) objM66067c);
            } else if (objM66067c instanceof Long) {
                contentValues.put(strM66066b, (Long) objM66067c);
            } else if (objM66067c instanceof Boolean) {
                contentValues.put(strM66066b, (Boolean) objM66067c);
            } else if (objM66067c instanceof Float) {
                contentValues.put(strM66066b, (Float) objM66067c);
            } else if (objM66067c instanceof Double) {
                contentValues.put(strM66066b, (Double) objM66067c);
            } else if (objM66067c instanceof byte[]) {
                contentValues.put(strM66066b, (byte[]) objM66067c);
            } else if (objM66067c instanceof Byte) {
                contentValues.put(strM66066b, (Byte) objM66067c);
            } else {
                if (!(objM66067c instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objM66067c.getClass().getCanonicalName() + " for key \"" + strM66066b + '\"');
                }
                contentValues.put(strM66066b, (Short) objM66067c);
            }
        }
        return contentValues;
    }
}
