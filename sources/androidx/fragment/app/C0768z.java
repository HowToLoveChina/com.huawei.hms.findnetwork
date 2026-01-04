package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.fragment.app.z */
/* loaded from: classes.dex */
public class C0768z {

    /* renamed from: a */
    public final ArrayList<Fragment> f4098a = new ArrayList<>();

    /* renamed from: b */
    public final HashMap<String, C0766x> f4099b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, FragmentState> f4100c = new HashMap<>();

    /* renamed from: d */
    public C0763u f4101d;

    /* renamed from: A */
    public void m4852A(C0763u c0763u) {
        this.f4101d = c0763u;
    }

    /* renamed from: B */
    public FragmentState m4853B(String str, FragmentState fragmentState) {
        return fragmentState != null ? this.f4100c.put(str, fragmentState) : this.f4100c.remove(str);
    }

    /* renamed from: a */
    public void m4854a(Fragment fragment) {
        if (this.f4098a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f4098a) {
            this.f4098a.add(fragment);
        }
        fragment.f3734l = true;
    }

    /* renamed from: b */
    public void m4855b() {
        this.f4099b.values().removeAll(Collections.singleton(null));
    }

    /* renamed from: c */
    public boolean m4856c(String str) {
        return this.f4099b.get(str) != null;
    }

    /* renamed from: d */
    public void m4857d(int i10) {
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null) {
                c0766x.m4849u(i10);
            }
        }
    }

    /* renamed from: e */
    public void m4858e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f4099b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C0766x c0766x : this.f4099b.values()) {
                printWriter.print(str);
                if (c0766x != null) {
                    Fragment fragmentM4839k = c0766x.m4839k();
                    printWriter.println(fragmentM4839k);
                    fragmentM4839k.m4391c(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f4098a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = this.f4098a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    /* renamed from: f */
    public Fragment m4859f(String str) {
        C0766x c0766x = this.f4099b.get(str);
        if (c0766x != null) {
            return c0766x.m4839k();
        }
        return null;
    }

    /* renamed from: g */
    public Fragment m4860g(int i10) {
        for (int size = this.f4098a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f4098a.get(size);
            if (fragment != null && fragment.f3746x == i10) {
                return fragment;
            }
        }
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null) {
                Fragment fragmentM4839k = c0766x.m4839k();
                if (fragmentM4839k.f3746x == i10) {
                    return fragmentM4839k;
                }
            }
        }
        return null;
    }

    /* renamed from: h */
    public Fragment m4861h(String str) {
        if (str != null) {
            for (int size = this.f4098a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f4098a.get(size);
                if (fragment != null && str.equals(fragment.f3748z)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null) {
                Fragment fragmentM4839k = c0766x.m4839k();
                if (str.equals(fragmentM4839k.f3748z)) {
                    return fragmentM4839k;
                }
            }
        }
        return null;
    }

    /* renamed from: i */
    public Fragment m4862i(String str) {
        Fragment fragmentM4397e;
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null && (fragmentM4397e = c0766x.m4839k().m4397e(str)) != null) {
                return fragmentM4397e;
            }
        }
        return null;
    }

    /* renamed from: j */
    public int m4863j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.f3703H;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f4098a.indexOf(fragment);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f4098a.get(i10);
            if (fragment2.f3703H == viewGroup && (view2 = fragment2.f3704I) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f4098a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f4098a.get(iIndexOf);
            if (fragment3.f3703H == viewGroup && (view = fragment3.f3704I) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* renamed from: k */
    public List<C0766x> m4864k() {
        ArrayList arrayList = new ArrayList();
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null) {
                arrayList.add(c0766x);
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public List<Fragment> m4865l() {
        ArrayList arrayList = new ArrayList();
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null) {
                arrayList.add(c0766x.m4839k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    public ArrayList<FragmentState> m4866m() {
        return new ArrayList<>(this.f4100c.values());
    }

    /* renamed from: n */
    public C0766x m4867n(String str) {
        return this.f4099b.get(str);
    }

    /* renamed from: o */
    public List<Fragment> m4868o() {
        ArrayList arrayList;
        if (this.f4098a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f4098a) {
            arrayList = new ArrayList(this.f4098a);
        }
        return arrayList;
    }

    /* renamed from: p */
    public C0763u m4869p() {
        return this.f4101d;
    }

    /* renamed from: q */
    public FragmentState m4870q(String str) {
        return this.f4100c.get(str);
    }

    /* renamed from: r */
    public void m4871r(C0766x c0766x) {
        Fragment fragmentM4839k = c0766x.m4839k();
        if (m4856c(fragmentM4839k.f3728f)) {
            return;
        }
        this.f4099b.put(fragmentM4839k.f3728f, c0766x);
        if (fragmentM4839k.f3699D) {
            if (fragmentM4839k.f3698C) {
                this.f4101d.m4816f(fragmentM4839k);
            } else {
                this.f4101d.m4825p(fragmentM4839k);
            }
            fragmentM4839k.f3699D = false;
        }
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentM4839k);
        }
    }

    /* renamed from: s */
    public void m4872s(C0766x c0766x) {
        Fragment fragmentM4839k = c0766x.m4839k();
        if (fragmentM4839k.f3698C) {
            this.f4101d.m4825p(fragmentM4839k);
        }
        if (this.f4099b.put(fragmentM4839k.f3728f, null) != null && FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentM4839k);
        }
    }

    /* renamed from: t */
    public void m4873t() {
        Iterator<Fragment> it = this.f4098a.iterator();
        while (it.hasNext()) {
            C0766x c0766x = this.f4099b.get(it.next().f3728f);
            if (c0766x != null) {
                c0766x.m4841m();
            }
        }
        for (C0766x c0766x2 : this.f4099b.values()) {
            if (c0766x2 != null) {
                c0766x2.m4841m();
                Fragment fragmentM4839k = c0766x2.m4839k();
                if (fragmentM4839k.f3735m && !fragmentM4839k.m4386a0()) {
                    if (fragmentM4839k.f3736n && !this.f4100c.containsKey(fragmentM4839k.f3728f)) {
                        c0766x2.m4847s();
                    }
                    m4872s(c0766x2);
                }
            }
        }
    }

    /* renamed from: u */
    public void m4874u(Fragment fragment) {
        synchronized (this.f4098a) {
            this.f4098a.remove(fragment);
        }
        fragment.f3734l = false;
    }

    /* renamed from: v */
    public void m4875v() {
        this.f4099b.clear();
    }

    /* renamed from: w */
    public void m4876w(List<String> list) {
        this.f4098a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentM4859f = m4859f(str);
                if (fragmentM4859f == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentM4859f);
                }
                m4854a(fragmentM4859f);
            }
        }
    }

    /* renamed from: x */
    public void m4877x(ArrayList<FragmentState> arrayList) {
        this.f4100c.clear();
        Iterator<FragmentState> it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            this.f4100c.put(next.f3861b, next);
        }
    }

    /* renamed from: y */
    public ArrayList<String> m4878y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f4099b.size());
        for (C0766x c0766x : this.f4099b.values()) {
            if (c0766x != null) {
                Fragment fragmentM4839k = c0766x.m4839k();
                c0766x.m4847s();
                arrayList.add(fragmentM4839k.f3728f);
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentM4839k + ": " + fragmentM4839k.f3724b);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: z */
    public ArrayList<String> m4879z() {
        synchronized (this.f4098a) {
            try {
                if (this.f4098a.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f4098a.size());
                Iterator<Fragment> it = this.f4098a.iterator();
                while (it.hasNext()) {
                    Fragment next = it.next();
                    arrayList.add(next.f3728f);
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f3728f + "): " + next);
                    }
                }
                return arrayList;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
