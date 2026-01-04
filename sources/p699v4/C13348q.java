package p699v4;

import android.os.Bundle;
import java.util.Collection;
import java.util.Map;

/* renamed from: v4.q */
/* loaded from: classes.dex */
public final class C13348q {
    /* renamed from: a */
    public static boolean m80081a(Bundle bundle) {
        return bundle == null || bundle.isEmpty();
    }

    /* renamed from: b */
    public static boolean m80082b(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: c */
    public static boolean m80083c(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /* renamed from: d */
    public static boolean m80084d(Collection<?> collection) {
        return !m80082b(collection);
    }
}
