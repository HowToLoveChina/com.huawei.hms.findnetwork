package p592qv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mv.C11533f;
import p535ov.InterfaceC12035b;
import p559pv.InterfaceC12231a;

/* renamed from: qv.c */
/* loaded from: classes9.dex */
public class C12419c implements InterfaceC12231a<InterfaceC12035b, Short> {

    /* renamed from: a */
    public List<Integer> f57255a;

    /* renamed from: b */
    public String f57256b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f57256b;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12035b interfaceC12035b) {
        this.f57255a = new ArrayList();
        for (int i10 : interfaceC12035b.intArr()) {
            this.f57255a.add(Integer.valueOf(i10));
        }
        this.f57256b = C11533f.m68823a(interfaceC12035b.message(), str + " must in intArr:" + Arrays.toString(interfaceC12035b.intArr()));
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Short sh2) {
        if (sh2 == null) {
            return true;
        }
        return this.f57255a.contains(Integer.valueOf(sh2.shortValue()));
    }
}
