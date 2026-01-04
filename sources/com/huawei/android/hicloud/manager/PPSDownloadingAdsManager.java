package com.huawei.android.hicloud.manager;

import com.huawei.android.hicloud.manager.PPSDownloadingAdsManager;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public class PPSDownloadingAdsManager {

    /* renamed from: b */
    public static PPSDownloadingAdsManager f12270b = new PPSDownloadingAdsManager();

    /* renamed from: a */
    public Map<String, Set<String>> f12271a = new LinkedHashMap();

    public @interface Scene {
    }

    /* renamed from: e */
    public static PPSDownloadingAdsManager m16469e() {
        return f12270b;
    }

    /* renamed from: g */
    public static /* synthetic */ void m16470g(String str, Set set, String str2, Set set2) {
        if (str2.equals(str)) {
            return;
        }
        set.addAll(set2);
    }

    /* renamed from: b */
    public synchronized void m16471b(@Scene String str, String str2) {
        if (this.f12271a.containsKey(str) && Objects.nonNull(this.f12271a.get(str))) {
            Set<String> set = this.f12271a.get(str);
            Objects.requireNonNull(set);
            set.add(str2);
        } else {
            HashSet hashSet = new HashSet();
            hashSet.add(str2);
            this.f12271a.put(str, hashSet);
        }
    }

    /* renamed from: c */
    public synchronized void m16472c(@Scene String str) {
        this.f12271a.remove(str);
    }

    /* renamed from: d */
    public synchronized Set<String> m16473d(@Scene final String str) {
        final HashSet hashSet = new HashSet();
        if (this.f12271a.isEmpty()) {
            return hashSet;
        }
        this.f12271a.forEach(new BiConsumer() { // from class: qb.a0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                PPSDownloadingAdsManager.m16470g(str, hashSet, (String) obj, (Set) obj2);
            }
        });
        return hashSet;
    }

    /* renamed from: f */
    public synchronized boolean m16474f(@Scene String str, String str2) {
        return m16473d(str).contains(str2);
    }

    /* renamed from: h */
    public synchronized void m16475h(@Scene String str, String str2) {
        if (this.f12271a.containsKey(str) && Objects.nonNull(this.f12271a.get(str))) {
            Set<String> set = this.f12271a.get(str);
            Objects.requireNonNull(set);
            set.remove(str2);
        }
    }
}
