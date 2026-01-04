package p694v;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: v.l */
/* loaded from: classes.dex */
public final class C13310l {

    /* renamed from: v.l$a */
    public static class a {
        /* renamed from: a */
        public static void m79804a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        /* renamed from: b */
        public static RemoteInput m79805b(C13310l c13310l) {
            throw null;
        }

        /* renamed from: c */
        public static Bundle m79806c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* renamed from: a */
    public static RemoteInput m79802a(C13310l c13310l) {
        return a.m79805b(c13310l);
    }

    /* renamed from: b */
    public static RemoteInput[] m79803b(C13310l[] c13310lArr) {
        if (c13310lArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c13310lArr.length];
        for (int i10 = 0; i10 < c13310lArr.length; i10++) {
            C13310l c13310l = c13310lArr[i10];
            remoteInputArr[i10] = m79802a(null);
        }
        return remoteInputArr;
    }
}
