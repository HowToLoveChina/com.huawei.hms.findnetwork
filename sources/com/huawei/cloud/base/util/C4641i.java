package com.huawei.cloud.base.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.cloud.base.util.i */
/* loaded from: classes.dex */
public class C4641i {

    /* renamed from: a */
    public static final Set<String> f21286a;

    /* renamed from: b */
    public static final Set<String> f21287b;

    /* renamed from: c */
    public static final Map<String, Integer> f21288c;

    static {
        Set<String> setSynchronizedSet = Collections.synchronizedSet(new HashSet());
        f21286a = setSynchronizedSet;
        Set<String> setSynchronizedSet2 = Collections.synchronizedSet(new HashSet());
        f21287b = setSynchronizedSet2;
        f21288c = new ConcurrentHashMap();
        setSynchronizedSet.add("unionid");
        setSynchronizedSet.add("userid");
        setSynchronizedSet.add("authorization");
        setSynchronizedSet.add("x-hw-device-id");
        setSynchronizedSet2.add("userid");
    }

    /* renamed from: a */
    public static void m28436a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            if (!C4633d0.m28404a(str)) {
                f21287b.add(str.toLowerCase(Locale.US));
            }
        }
    }

    /* renamed from: b */
    public static void m28437b(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            if (!C4633d0.m28404a(str)) {
                f21286a.add(str.toLowerCase(Locale.US));
            }
        }
    }
}
