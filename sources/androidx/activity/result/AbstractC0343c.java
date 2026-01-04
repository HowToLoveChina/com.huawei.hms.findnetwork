package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import p041c.AbstractC1365a;

/* renamed from: androidx.activity.result.c */
/* loaded from: classes.dex */
public abstract class AbstractC0343c {

    /* renamed from: a */
    public Random f1128a = new Random();

    /* renamed from: b */
    public final Map<Integer, String> f1129b = new HashMap();

    /* renamed from: c */
    public final Map<String, Integer> f1130c = new HashMap();

    /* renamed from: d */
    public final Map<String, c> f1131d = new HashMap();

    /* renamed from: e */
    public ArrayList<String> f1132e = new ArrayList<>();

    /* renamed from: f */
    public final transient Map<String, b<?>> f1133f = new HashMap();

    /* renamed from: g */
    public final Map<String, Object> f1134g = new HashMap();

    /* renamed from: h */
    public final Bundle f1135h = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: androidx.activity.result.c$a */
    public class a<I> extends AbstractC0342b<I> {

        /* renamed from: a */
        public final /* synthetic */ String f1136a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC1365a f1137b;

        public a(String str, AbstractC1365a abstractC1365a) {
            this.f1136a = str;
            this.f1137b = abstractC1365a;
        }

        @Override // androidx.activity.result.AbstractC0342b
        /* renamed from: a */
        public void mo1963a() {
            AbstractC0343c.this.m1972i(this.f1136a);
        }
    }

    /* renamed from: androidx.activity.result.c$b */
    public static class b<O> {

        /* renamed from: a */
        public final InterfaceC0341a<O> f1139a;

        /* renamed from: b */
        public final AbstractC1365a<?, O> f1140b;

        public b(InterfaceC0341a<O> interfaceC0341a, AbstractC1365a<?, O> abstractC1365a) {
            this.f1139a = interfaceC0341a;
            this.f1140b = abstractC1365a;
        }
    }

    /* renamed from: androidx.activity.result.c$c */
    public static class c {

        /* renamed from: a */
        public final AbstractC0791h f1141a;

        /* renamed from: b */
        public final ArrayList<InterfaceC0794j> f1142b;

        /* renamed from: a */
        public void m1973a() {
            Iterator<InterfaceC0794j> it = this.f1142b.iterator();
            while (it.hasNext()) {
                this.f1141a.mo4950c(it.next());
            }
            this.f1142b.clear();
        }
    }

    /* renamed from: a */
    public final void m1964a(int i10, String str) {
        this.f1129b.put(Integer.valueOf(i10), str);
        this.f1130c.put(str, Integer.valueOf(i10));
    }

    /* renamed from: b */
    public final boolean m1965b(int i10, int i11, Intent intent) {
        String str = this.f1129b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        m1966c(str, i11, intent, this.f1133f.get(str));
        return true;
    }

    /* renamed from: c */
    public final <O> void m1966c(String str, int i10, Intent intent, b<O> bVar) {
        if (bVar == null || bVar.f1139a == null || !this.f1132e.contains(str)) {
            this.f1134g.remove(str);
            this.f1135h.putParcelable(str, new ActivityResult(i10, intent));
        } else {
            bVar.f1139a.mo1962a(bVar.f1140b.mo4627a(i10, intent));
            this.f1132e.remove(str);
        }
    }

    /* renamed from: d */
    public final int m1967d() {
        int iNextInt = this.f1128a.nextInt(2147418112);
        while (true) {
            int i10 = iNextInt + 65536;
            if (!this.f1129b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            iNextInt = this.f1128a.nextInt(2147418112);
        }
    }

    /* renamed from: e */
    public final void m1968e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f1132e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f1128a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f1135h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f1130c.containsKey(str)) {
                Integer numRemove = this.f1130c.remove(str);
                if (!this.f1135h.containsKey(str)) {
                    this.f1129b.remove(numRemove);
                }
            }
            m1964a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    /* renamed from: f */
    public final void m1969f(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f1130c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f1130c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f1132e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f1135h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f1128a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final <I, O> AbstractC0342b<I> m1970g(String str, AbstractC1365a<I, O> abstractC1365a, InterfaceC0341a<O> interfaceC0341a) {
        m1971h(str);
        this.f1133f.put(str, new b<>(interfaceC0341a, abstractC1365a));
        if (this.f1134g.containsKey(str)) {
            Object obj = this.f1134g.get(str);
            this.f1134g.remove(str);
            interfaceC0341a.mo1962a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f1135h.getParcelable(str);
        if (activityResult != null) {
            this.f1135h.remove(str);
            interfaceC0341a.mo1962a(abstractC1365a.mo4627a(activityResult.m1957c(), activityResult.m1956a()));
        }
        return new a(str, abstractC1365a);
    }

    /* renamed from: h */
    public final void m1971h(String str) {
        if (this.f1130c.get(str) != null) {
            return;
        }
        m1964a(m1967d(), str);
    }

    /* renamed from: i */
    public final void m1972i(String str) {
        Integer numRemove;
        if (!this.f1132e.contains(str) && (numRemove = this.f1130c.remove(str)) != null) {
            this.f1129b.remove(numRemove);
        }
        this.f1133f.remove(str);
        if (this.f1134g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f1134g.get(str));
            this.f1134g.remove(str);
        }
        if (this.f1135h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f1135h.getParcelable(str));
            this.f1135h.remove(str);
        }
        c cVar = this.f1131d.get(str);
        if (cVar != null) {
            cVar.m1973a();
            this.f1131d.remove(str);
        }
    }
}
