package p354i1;

import java.lang.reflect.Type;
import p244e1.C9380d;
import p244e1.C9382f;
import p323h1.AbstractC10080d;
import p323h1.C10077a;

/* renamed from: i1.n */
/* loaded from: classes.dex */
public class C10402n implements InterfaceC10408t {

    /* renamed from: a */
    public static final C10402n f50200a = new C10402n();

    /* JADX WARN: Type inference failed for: r0v1, types: [T, e1.f] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        int iMo62768a0;
        AbstractC10080d abstractC10080d = (AbstractC10080d) c10077a.m62706A();
        String strMo62780s0 = abstractC10080d.mo62780s0(c10077a.m62709D());
        abstractC10080d.mo62790z();
        int iMo62768a02 = abstractC10080d.mo62768a0();
        if (iMo62768a02 == 25) {
            String str = strMo62780s0 + ".";
            strMo62780s0 = str + abstractC10080d.mo62780s0(c10077a.m62709D());
            abstractC10080d.mo62790z();
            iMo62768a02 = abstractC10080d.mo62768a0();
        }
        ?? r02 = (T) new C9382f(strMo62780s0);
        if (iMo62768a02 != 10) {
            throw new C9380d("illegal jsonp : " + abstractC10080d.mo62781t());
        }
        abstractC10080d.mo62790z();
        while (true) {
            r02.m58799b(c10077a.m62712G());
            iMo62768a0 = abstractC10080d.mo62768a0();
            if (iMo62768a0 != 16) {
                break;
            }
            abstractC10080d.mo62790z();
        }
        if (iMo62768a0 == 11) {
            abstractC10080d.mo62790z();
            if (abstractC10080d.mo62768a0() == 24) {
                abstractC10080d.mo62790z();
            }
            return r02;
        }
        throw new C9380d("illegal jsonp : " + abstractC10080d.mo62781t());
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 0;
    }
}
