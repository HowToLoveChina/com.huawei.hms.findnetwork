package p771xd;

import android.animation.TypeEvaluator;
import java.util.ArrayList;

/* renamed from: xd.o */
/* loaded from: classes3.dex */
public class C13771o implements TypeEvaluator {

    /* renamed from: a */
    public C13772p f61872a = new C13772p(4);

    /* renamed from: a */
    public final boolean m82682a(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, ArrayList<Integer> arrayList4) {
        return arrayList == null || arrayList.size() != 4 || arrayList2 == null || arrayList2.size() != 4 || arrayList3 == null || arrayList3.size() != 4 || arrayList4 == null || arrayList4.size() != 4;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f10, Object obj, Object obj2) {
        this.f61872a.m82683a();
        if (obj == null || obj2 == null) {
            return this.f61872a;
        }
        C13772p c13772p = (C13772p) obj;
        C13772p c13772p2 = (C13772p) obj2;
        ArrayList<Integer> arrayListM82684b = c13772p.m82684b();
        ArrayList<Integer> arrayListM82685c = c13772p.m82685c();
        ArrayList<Integer> arrayListM82684b2 = c13772p2.m82684b();
        ArrayList<Integer> arrayListM82685c2 = c13772p2.m82685c();
        if (m82682a(arrayListM82684b, arrayListM82685c, arrayListM82684b2, arrayListM82685c2)) {
            return this.f61872a;
        }
        ArrayList<Integer> arrayListM82684b3 = this.f61872a.m82684b();
        ArrayList<Integer> arrayListM82685c3 = this.f61872a.m82685c();
        if (arrayListM82684b3 == null || arrayListM82684b3.size() != 4 || arrayListM82685c3 == null || arrayListM82685c3.size() != 4) {
            return this.f61872a;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            if (arrayListM82684b.get(i10) == null || arrayListM82684b2.get(i10) == null || arrayListM82685c.get(i10) == null || arrayListM82685c2.get(i10) == null || arrayListM82684b3.get(i10) == null || arrayListM82685c3.get(i10) == null) {
                this.f61872a.m82683a();
                return this.f61872a;
            }
            arrayListM82684b3.set(i10, Integer.valueOf(Math.round(arrayListM82684b.get(i10).intValue() + ((arrayListM82684b2.get(i10).intValue() - arrayListM82684b.get(i10).intValue()) * f10))));
            arrayListM82685c3.set(i10, Integer.valueOf(Math.round(arrayListM82685c.get(i10).intValue() + ((arrayListM82685c2.get(i10).intValue() - arrayListM82685c.get(i10).intValue()) * f10))));
        }
        return this.f61872a;
    }
}
