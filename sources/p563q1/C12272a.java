package p563q1;

import java.util.ArrayList;
import p541p1.C12070b;
import p541p1.C12073e;
import p541p1.InterfaceC12071c;

/* renamed from: q1.a */
/* loaded from: classes.dex */
public class C12272a implements InterfaceC12071c {

    /* renamed from: a */
    public C12273b f56910a;

    /* renamed from: b */
    public ArrayList<C12073e> f56911b;

    @Override // p541p1.InterfaceC12071c
    /* renamed from: a */
    public int mo72223a() {
        return this.f56910a.f56912a;
    }

    @Override // p541p1.InterfaceC12071c
    public int getDuration() {
        try {
            C12070b c12070b = this.f56911b.get(r2.size() - 1).f55891a;
            return "continuous".equals(c12070b.f55883a) ? c12070b.f55884b + c12070b.f55885c : c12070b.f55884b + 48;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
