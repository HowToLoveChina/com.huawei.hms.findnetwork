package p743wk;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: wk.a */
/* loaded from: classes6.dex */
public class C13616a {

    /* renamed from: a */
    public static final HashSet<String> f61270a = new a();

    /* renamed from: b */
    public static final Map<Integer, Integer> f61271b = new b();

    /* renamed from: c */
    public static final Map<Integer, Integer> f61272c = new c();

    /* renamed from: wk.a$a */
    public class a extends HashSet<String> {
        public a() {
            add("campaignNotify_1");
            add("campaignNotify_2");
            add("campaignNotify_3");
            add("campaignNotify_4");
            add("campaignNotify_5");
            add("campaignNotify_6");
            add("campaignNotify_7");
            add("campaignNotify_8");
            add("campaignNotify_9");
        }
    }

    /* renamed from: wk.a$b */
    public class b extends HashMap<Integer, Integer> {
        public b() {
            put(1, 524);
            put(2, 524);
            put(3, 524);
            put(4, 525);
            put(6, 524);
            put(5, 502);
            put(8, 501);
            put(7, 532);
            put(10, 503);
            put(13, 917);
        }
    }

    /* renamed from: wk.a$c */
    public class c extends HashMap<Integer, Integer> {
        public c() {
            put(1, 101);
            put(2, 102);
            put(3, 103);
            put(4, 101);
            put(6, 104);
            put(5, 101);
            put(7, 105);
            put(10, 101);
            put(13, 100);
        }
    }

    /* renamed from: a */
    public static Map<Integer, Integer> m81909a() {
        return Collections.unmodifiableMap(f61272c);
    }

    /* renamed from: b */
    public static Map<Integer, Integer> m81910b() {
        return Collections.unmodifiableMap(f61271b);
    }

    /* renamed from: c */
    public static Set<String> m81911c() {
        return Collections.unmodifiableSet(f61270a);
    }
}
