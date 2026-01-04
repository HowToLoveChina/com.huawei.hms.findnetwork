package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import p024b0.C1089e;
import p024b0.C1093i;

/* loaded from: classes.dex */
public final class ContentResolverCompat {

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, C1089e c1089e) throws Exception {
        Object objM6469b;
        if (c1089e != null) {
            try {
                objM6469b = c1089e.m6469b();
            } catch (Exception e10) {
                if (e10 instanceof OperationCanceledException) {
                    throw new C1093i();
                }
                throw e10;
            }
        } else {
            objM6469b = null;
        }
        return Api16Impl.query(contentResolver, uri, strArr, str, strArr2, str2, (CancellationSignal) objM6469b);
    }
}
