package p483n3;

import java.util.Collection;
import p468m3.C11397c;

/* renamed from: n3.h */
/* loaded from: classes.dex */
public final class C11617h {
    /* renamed from: a */
    public static boolean m69400a(Collection<?> collection, Object obj) {
        C11397c.m68310g(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
