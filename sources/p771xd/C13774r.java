package p771xd;

import android.animation.TypeEvaluator;
import java.util.ArrayList;

/* renamed from: xd.r */
/* loaded from: classes3.dex */
public class C13774r implements TypeEvaluator {

    /* renamed from: a */
    public C13772p f61880a;

    /* renamed from: b */
    public int f61881b;

    public C13774r(int i10) {
        this.f61880a = new C13772p(i10);
        this.f61881b = i10;
    }

    /* renamed from: a */
    public final boolean m82692a(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, ArrayList<Integer> arrayList4) {
        return arrayList == null || arrayList.size() != this.f61881b || arrayList2 == null || arrayList2.size() != this.f61881b || arrayList3 == null || arrayList3.size() != this.f61881b || arrayList4 == null || arrayList4.size() != this.f61881b;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f10, Object obj, Object obj2) {
        this.f61880a.m82683a();
        if (obj == null || obj2 == null) {
            return this.f61880a;
        }
        C13772p c13772p = (C13772p) obj;
        C13772p c13772p2 = (C13772p) obj2;
        ArrayList<Integer> arrayListM82684b = c13772p.m82684b();
        ArrayList<Integer> arrayListM82685c = c13772p.m82685c();
        ArrayList<Integer> arrayListM82684b2 = c13772p2.m82684b();
        ArrayList<Integer> arrayListM82685c2 = c13772p2.m82685c();
        if (m82692a(arrayListM82684b, arrayListM82685c, arrayListM82684b2, arrayListM82685c2)) {
            return this.f61880a;
        }
        ArrayList<Integer> arrayListM82684b3 = this.f61880a.m82684b();
        ArrayList<Integer> arrayListM82685c3 = this.f61880a.m82685c();
        if (arrayListM82684b3 == null || arrayListM82684b3.size() != this.f61881b || arrayListM82685c3 == null || arrayListM82685c3.size() != this.f61881b) {
            return this.f61880a;
        }
        for (int i10 = 0; i10 < this.f61881b; i10++) {
            if (arrayListM82684b.get(i10) == null || arrayListM82684b2.get(i10) == null || arrayListM82685c.get(i10) == null || arrayListM82685c2.get(i10) == null || arrayListM82684b3.get(i10) == null || arrayListM82685c3.get(i10) == null) {
                this.f61880a.m82683a();
                return this.f61880a;
            }
            arrayListM82684b3.set(i10, Integer.valueOf(Math.round(arrayListM82684b.get(i10).intValue() + ((arrayListM82684b2.get(i10).intValue() - arrayListM82684b.get(i10).intValue()) * f10))));
            arrayListM82685c3.set(i10, Integer.valueOf(Math.round(arrayListM82685c.get(i10).intValue() + ((arrayListM82685c2.get(i10).intValue() - arrayListM82685c.get(i10).intValue()) * f10))));
        }
        return this.f61880a;
    }
}
