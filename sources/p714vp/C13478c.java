package p714vp;

import p620rp.AbstractC12613a;
import p686up.InterfaceC13234b;

/* renamed from: vp.c */
/* loaded from: classes8.dex */
public class C13478c implements InterfaceC13234b {

    /* renamed from: a */
    public final a f60698a;

    /* renamed from: vp.c$a */
    public static class a extends AbstractC12613a {
        public a(String str) {
            super(str, true);
        }
    }

    public C13478c(String str) {
        this.f60698a = new a(str);
    }

    @Override // p686up.InterfaceC13234b
    /* renamed from: a */
    public void mo79605a(String str) {
        this.f60698a.m76115d(str);
    }

    @Override // p686up.InterfaceC13234b
    /* renamed from: b */
    public void mo79606b(String str, String str2) {
        this.f60698a.m76114c(str, str2);
    }

    @Override // p686up.InterfaceC13234b
    /* renamed from: c */
    public String mo79607c(String str, String str2) {
        return this.f60698a.m76113b(str, str2);
    }

    @Override // p686up.InterfaceC13234b
    public void clearAll() {
        this.f60698a.m76112a();
    }
}
