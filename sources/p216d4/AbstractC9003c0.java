package p216d4;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p247e4.C9406b;
import p384j4.AbstractC10706e;
import p384j4.AbstractC10707f;

/* renamed from: d4.c0 */
/* loaded from: classes.dex */
public abstract class AbstractC9003c0 {

    /* renamed from: a */
    public static final LruCache<String, String> f45620a = new LruCache<>(50);

    /* renamed from: a */
    public static Map<String, List<String>> m56870a(C9020l c9020l) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (c9020l != null && !AbstractC10706e.m65374a(c9020l.m56946q())) {
            for (C9031r c9031r : c9020l.m56946q()) {
                if (c9031r != null && !c9031r.m56978s()) {
                    ArrayList arrayList = new ArrayList();
                    for (C9406b c9406b : c9031r.m56974o()) {
                        if (c9406b != null) {
                            arrayList.add(c9406b.m58977j());
                        }
                    }
                    String strM56976q = c9031r.m56976q();
                    if (!AbstractC10707f.m65379d(strM56976q)) {
                        linkedHashMap.put(strM56976q, arrayList);
                    }
                }
            }
        }
        return linkedHashMap;
    }
}
