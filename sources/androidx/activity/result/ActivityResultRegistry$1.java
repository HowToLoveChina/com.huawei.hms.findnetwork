package androidx.activity.result;

import androidx.activity.result.AbstractC0343c;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import p041c.AbstractC1365a;

/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements InterfaceC0794j {

    /* renamed from: a */
    public final /* synthetic */ String f1120a;

    /* renamed from: b */
    public final /* synthetic */ InterfaceC0341a f1121b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC1365a f1122c;

    /* renamed from: d */
    public final /* synthetic */ AbstractC0343c f1123d;

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        if (!AbstractC0791h.b.ON_START.equals(bVar)) {
            if (AbstractC0791h.b.ON_STOP.equals(bVar)) {
                this.f1123d.f1133f.remove(this.f1120a);
                return;
            } else {
                if (AbstractC0791h.b.ON_DESTROY.equals(bVar)) {
                    this.f1123d.m1972i(this.f1120a);
                    return;
                }
                return;
            }
        }
        this.f1123d.f1133f.put(this.f1120a, new AbstractC0343c.b<>(this.f1121b, this.f1122c));
        if (this.f1123d.f1134g.containsKey(this.f1120a)) {
            Object obj = this.f1123d.f1134g.get(this.f1120a);
            this.f1123d.f1134g.remove(this.f1120a);
            this.f1121b.mo1962a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f1123d.f1135h.getParcelable(this.f1120a);
        if (activityResult != null) {
            this.f1123d.f1135h.remove(this.f1120a);
            this.f1121b.mo1962a(this.f1122c.mo4627a(activityResult.m1957c(), activityResult.m1956a()));
        }
    }
}
