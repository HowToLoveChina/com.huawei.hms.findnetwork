package p592qv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mv.C11533f;
import p535ov.InterfaceC12035b;
import p559pv.InterfaceC12231a;

/* renamed from: qv.a */
/* loaded from: classes9.dex */
public class C12417a implements InterfaceC12231a<InterfaceC12035b, Integer> {

    /* renamed from: a */
    public List<Integer> f57251a;

    /* renamed from: b */
    public String f57252b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f57252b;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12035b interfaceC12035b) {
        this.f57251a = new ArrayList();
        for (int i10 : interfaceC12035b.intArr()) {
            this.f57251a.add(Integer.valueOf(i10));
        }
        this.f57252b = C11533f.m68823a(interfaceC12035b.message(), str + " must in intArr:" + Arrays.toString(interfaceC12035b.intArr()));
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Integer num) {
        if (num == null) {
            return true;
        }
        return this.f57251a.contains(num);
    }
}
