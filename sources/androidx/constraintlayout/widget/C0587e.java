package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: androidx.constraintlayout.widget.e */
/* loaded from: classes.dex */
public class C0587e {

    /* renamed from: a */
    public SparseIntArray f3230a = new SparseIntArray();

    /* renamed from: b */
    public HashMap<Integer, HashSet<WeakReference<a>>> f3231b = new HashMap<>();

    /* renamed from: androidx.constraintlayout.widget.e$a */
    public interface a {
    }

    /* renamed from: a */
    public void m3670a(int i10, a aVar) {
        HashSet<WeakReference<a>> hashSet = this.f3231b.get(Integer.valueOf(i10));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f3231b.put(Integer.valueOf(i10), hashSet);
        }
        hashSet.add(new WeakReference<>(aVar));
    }

    /* renamed from: b */
    public void m3671b(int i10, a aVar) {
        HashSet<WeakReference<a>> hashSet = this.f3231b.get(Integer.valueOf(i10));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<a>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            a aVar2 = next.get();
            if (aVar2 == null || aVar2 == aVar) {
                arrayList.add(next);
            }
        }
        hashSet.removeAll(arrayList);
    }
}
