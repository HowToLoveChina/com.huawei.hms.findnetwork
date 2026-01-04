package p381j1;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.n */
/* loaded from: classes.dex */
public class C10673n implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10673n f51306a = new C10673n();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Object obj2;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        try {
            if (interfaceC10079c.mo62768a0() == 6) {
                interfaceC10079c.mo62756D(16);
                obj2 = (T) Boolean.TRUE;
            } else if (interfaceC10079c.mo62768a0() == 7) {
                interfaceC10079c.mo62756D(16);
                obj2 = (T) Boolean.FALSE;
            } else if (interfaceC10079c.mo62768a0() == 2) {
                int iMo62753B = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62756D(16);
                obj2 = iMo62753B == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
            } else {
                Object objM62712G = c10077a.m62712G();
                if (objM62712G == null) {
                    return null;
                }
                obj2 = (T) C11603o.m69302k(objM62712G);
            }
            return type == AtomicBoolean.class ? (T) new AtomicBoolean(((Boolean) obj2).booleanValue()) : (T) obj2;
        } catch (Exception e10) {
            throw new C9380d("parseBoolean error, field : " + obj, e10);
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 6;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            c10650d1.write(FaqConstants.DISABLE_HA_REPORT);
        } else {
            c10650d1.write("false");
        }
    }
}
