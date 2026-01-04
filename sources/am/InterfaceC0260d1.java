package am;

import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p495nm.C11725f;
import tl.C13026e;

/* renamed from: am.d1 */
/* loaded from: classes6.dex */
public interface InterfaceC0260d1 {

    /* renamed from: a */
    public static final Map<String, InterfaceC0260d1> f931a = new a();

    /* renamed from: am.d1$a */
    public class a extends HashMap<String, InterfaceC0260d1> {
        public a() {
            put("interim", new C0284l1());
            put("auto", new C0297s());
            put(CBSbkFlowHead.BKMODE_MANUAL, new C0297s());
            put("Refurbishment", new C0281k1());
        }
    }

    /* renamed from: f */
    static InterfaceC0260d1 m1755f(String str) {
        return f931a.get(str);
    }

    /* renamed from: a */
    Boolean mo1756a(String str);

    /* renamed from: b */
    C11725f mo1757b();

    /* renamed from: c */
    void mo1758c();

    /* renamed from: d */
    C13026e mo1759d();

    /* renamed from: e */
    void mo1760e(String str);

    /* renamed from: g */
    long mo1761g();

    /* renamed from: h */
    void mo1762h();

    /* renamed from: i */
    void mo1763i(List<String> list);

    /* renamed from: j */
    void mo1764j();
}
