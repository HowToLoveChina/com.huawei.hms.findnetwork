package p592qv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mv.C11533f;
import p535ov.InterfaceC12035b;
import p559pv.InterfaceC12231a;

/* renamed from: qv.b */
/* loaded from: classes9.dex */
public class C12418b implements InterfaceC12231a<InterfaceC12035b, Long> {

    /* renamed from: a */
    public List<Long> f57253a;

    /* renamed from: b */
    public String f57254b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f57254b;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12035b interfaceC12035b) {
        this.f57253a = new ArrayList();
        int length = interfaceC12035b.intArr().length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f57253a.add(Long.valueOf(r0[i10]));
        }
        this.f57254b = C11533f.m68823a(interfaceC12035b.message(), str + " must in intArr:" + Arrays.toString(interfaceC12035b.intArr()));
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Long l10) {
        if (l10 == null) {
            return true;
        }
        return this.f57253a.contains(l10);
    }
}
