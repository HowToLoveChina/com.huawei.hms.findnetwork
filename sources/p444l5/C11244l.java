package p444l5;

import android.content.ContentValues;
import android.os.Handler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* renamed from: l5.l */
/* loaded from: classes.dex */
public class C11244l {

    /* renamed from: a */
    public Iterator<Map.Entry<Long, LinkedHashSet<ContentValues>>> f52816a;

    /* renamed from: b */
    public HashSet<Integer> f52817b;

    /* renamed from: c */
    public HashMap<Long, ContentValues> f52818c;

    /* renamed from: d */
    public int f52819d;

    /* renamed from: e */
    public Long f52820e;

    /* renamed from: f */
    public Handler.Callback f52821f;

    /* renamed from: g */
    public Object f52822g;

    /* renamed from: h */
    public HashMap<Integer, Long> f52823h;

    /* renamed from: i */
    public HashMap<Long, Long> f52824i;

    public C11244l(HashSet<Integer> hashSet, HashMap<Long, ContentValues> map, Handler.Callback callback, Object obj, HashMap<Integer, Long> map2, HashMap<Long, Long> map3) {
        this.f52817b = hashSet;
        this.f52818c = map;
        this.f52821f = callback;
        this.f52822g = obj;
        this.f52823h = map2;
        this.f52824i = map3;
    }

    /* renamed from: a */
    public boolean m67576a() {
        HashSet<Integer> hashSet = this.f52817b;
        return hashSet != null && hashSet.contains(Integer.valueOf(this.f52819d));
    }

    /* renamed from: b */
    public Handler.Callback m67577b() {
        return this.f52821f;
    }

    /* renamed from: c */
    public Object m67578c() {
        return this.f52822g;
    }

    /* renamed from: d */
    public void m67579d() {
        Iterator<Map.Entry<Long, LinkedHashSet<ContentValues>>> it = this.f52816a;
        if (it != null) {
            it.remove();
        }
    }

    /* renamed from: e */
    public void m67580e() {
        HashMap<Long, ContentValues> map = this.f52818c;
        if (map != null && map.containsKey(this.f52820e)) {
            this.f52818c.remove(this.f52820e);
        }
        HashMap<Integer, Long> map2 = this.f52823h;
        if (map2 == null || !map2.containsKey(Integer.valueOf(this.f52819d))) {
            return;
        }
        this.f52824i.put(this.f52820e, this.f52823h.get(Integer.valueOf(this.f52819d)));
    }

    /* renamed from: f */
    public void m67581f(int i10, Long l10, Iterator<Map.Entry<Long, LinkedHashSet<ContentValues>>> it) {
        this.f52816a = it;
        this.f52819d = i10;
        this.f52820e = l10;
    }
}
