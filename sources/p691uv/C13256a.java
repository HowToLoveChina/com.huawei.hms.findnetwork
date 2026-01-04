package p691uv;

import mv.C11533f;
import p535ov.InterfaceC12039f;
import p559pv.InterfaceC12231a;

/* renamed from: uv.a */
/* loaded from: classes9.dex */
public class C13256a implements InterfaceC12231a<InterfaceC12039f, Integer> {

    /* renamed from: a */
    public String f59953a;

    /* renamed from: b */
    public long f59954b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f59953a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12039f interfaceC12039f) {
        this.f59953a = C11533f.m68825c(interfaceC12039f, str);
        this.f59954b = interfaceC12039f.value();
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Integer num) {
        if (num == null) {
            return true;
        }
        if (this.f59954b >= 2147483647L) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f59954b);
        sb2.append("");
        return num.compareTo(Integer.valueOf(Integer.parseInt(sb2.toString()))) >= 0;
    }
}
