package p279f6;

import android.content.ContentValues;
import p006a5.AbstractC0048c;

/* renamed from: f6.d */
/* loaded from: classes.dex */
public class C9661d {
    /* renamed from: a */
    public static int m60330a(AbstractC0048c abstractC0048c) {
        if (abstractC0048c == null) {
            return 2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateTime", (Long) 0L);
        contentValues.put("version", (Integer) 1);
        contentValues.put("miniVersion", (Integer) 1);
        return abstractC0048c.m185A("HeaderInfo", contentValues);
    }
}
