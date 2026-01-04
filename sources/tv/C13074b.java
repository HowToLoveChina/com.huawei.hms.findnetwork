package tv;

import mv.C11533f;
import p535ov.InterfaceC12038e;
import p559pv.InterfaceC12231a;

/* renamed from: tv.b */
/* loaded from: classes9.dex */
public class C13074b implements InterfaceC12231a<InterfaceC12038e, Long> {

    /* renamed from: a */
    public String f59487a;

    /* renamed from: b */
    public long f59488b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f59487a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12038e interfaceC12038e) {
        this.f59487a = C11533f.m68824b(interfaceC12038e, str);
        this.f59488b = interfaceC12038e.value();
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Long l10) {
        return l10 == null || l10.compareTo(Long.valueOf(this.f59488b)) <= 0;
    }
}
