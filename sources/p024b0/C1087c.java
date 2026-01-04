package p024b0;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import p692uw.C13267j;

/* renamed from: b0.c */
/* loaded from: classes.dex */
public final class C1087c {

    /* renamed from: a */
    public static final C1087c f5204a = new C1087c();

    /* renamed from: a */
    public static final void m6465a(Bundle bundle, String str, Size size) {
        C13267j.m79677e(bundle, "bundle");
        C13267j.m79677e(str, "key");
        bundle.putSize(str, size);
    }

    /* renamed from: b */
    public static final void m6466b(Bundle bundle, String str, SizeF sizeF) {
        C13267j.m79677e(bundle, "bundle");
        C13267j.m79677e(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}
