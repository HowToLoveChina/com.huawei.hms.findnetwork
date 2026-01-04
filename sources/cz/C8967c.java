package cz;

import java.util.Hashtable;
import p271ez.C9577c;

/* renamed from: cz.c */
/* loaded from: classes9.dex */
public class C8967c {

    /* renamed from: a */
    public static final Hashtable f45480a;

    static {
        Hashtable hashtable = new Hashtable();
        f45480a = hashtable;
        hashtable.put("SHA-1", C9577c.m59768a(128));
        hashtable.put("SHA-224", C9577c.m59768a(192));
        hashtable.put("SHA-256", C9577c.m59768a(256));
        hashtable.put("SHA-384", C9577c.m59768a(256));
        hashtable.put("SHA-512", C9577c.m59768a(256));
        hashtable.put("SHA-512/224", C9577c.m59768a(192));
        hashtable.put("SHA-512/256", C9577c.m59768a(256));
    }

    /* renamed from: a */
    public static boolean m56741a(byte[] bArr, int i10) {
        return bArr != null && bArr.length > i10;
    }
}
