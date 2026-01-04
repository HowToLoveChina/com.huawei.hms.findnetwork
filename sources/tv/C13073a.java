package tv;

import mv.C11533f;
import p535ov.InterfaceC12038e;
import p559pv.InterfaceC12231a;

/* renamed from: tv.a */
/* loaded from: classes9.dex */
public class C13073a implements InterfaceC12231a<InterfaceC12038e, Integer> {

    /* renamed from: a */
    public String f59485a;

    /* renamed from: b */
    public long f59486b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f59485a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12038e interfaceC12038e) {
        this.f59485a = C11533f.m68824b(interfaceC12038e, str);
        this.f59486b = interfaceC12038e.value();
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Integer num) {
        if (num == null || this.f59486b >= 2147483647L) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f59486b);
        sb2.append("");
        return num.compareTo(Integer.valueOf(Integer.parseInt(sb2.toString()))) <= 0;
    }
}
