package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import p243e0.InterfaceC9375j;

/* loaded from: classes.dex */
public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    public static InterfaceC9375j<Uri> asPredicate(final UriMatcher uriMatcher) {
        return new InterfaceC9375j() { // from class: androidx.core.content.x
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return UriMatcherCompat.lambda$asPredicate$0(uriMatcher, (Uri) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher uriMatcher, Uri uri) {
        return uriMatcher.match(uri) != -1;
    }
}
