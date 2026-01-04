package p561q;

import java.util.ArrayList;
import p479n.C11573c;

/* renamed from: q.n */
/* loaded from: classes.dex */
public class C12267n extends C12258e {

    /* renamed from: V0 */
    public ArrayList<C12258e> f56904V0 = new ArrayList<>();

    /* renamed from: a */
    public void m73794a(C12258e c12258e) {
        this.f56904V0.add(c12258e);
        if (c12258e.m73570M() != null) {
            ((C12267n) c12258e.m73570M()).m73796y1(c12258e);
        }
        c12258e.m73616h1(this);
    }

    @Override // p561q.C12258e
    /* renamed from: v0 */
    public void mo73654v0() {
        this.f56904V0.clear();
        super.mo73654v0();
    }

    /* renamed from: w1 */
    public ArrayList<C12258e> m73795w1() {
        return this.f56904V0;
    }

    /* renamed from: x1 */
    public void mo73698x1() {
        ArrayList<C12258e> arrayList = this.f56904V0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C12258e c12258e = this.f56904V0.get(i10);
            if (c12258e instanceof C12267n) {
                ((C12267n) c12258e).mo73698x1();
            }
        }
    }

    /* renamed from: y1 */
    public void m73796y1(C12258e c12258e) {
        this.f56904V0.remove(c12258e);
        c12258e.mo73654v0();
    }

    @Override // p561q.C12258e
    /* renamed from: z0 */
    public void mo73663z0(C11573c c11573c) {
        super.mo73663z0(c11573c);
        int size = this.f56904V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f56904V0.get(i10).mo73663z0(c11573c);
        }
    }

    /* renamed from: z1 */
    public void m73797z1() {
        this.f56904V0.clear();
    }
}
