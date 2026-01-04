package p354i1;

import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.lang.reflect.Type;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.C10083g;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;

/* renamed from: i1.a0 */
/* loaded from: classes.dex */
public class C10387a0 implements InterfaceC10408t {

    /* renamed from: a */
    public static final C10387a0 f50185a = new C10387a0();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 8) {
            interfaceC10079c.mo62790z();
            return null;
        }
        if (interfaceC10079c.mo62768a0() != 12 && interfaceC10079c.mo62768a0() != 16) {
            throw new C9380d("syntax error: " + C10083g.m62844a(interfaceC10079c.mo62768a0()));
        }
        int iMo62753B = 0;
        String strMo62763J = null;
        String strMo62763J2 = null;
        String strMo62763J3 = null;
        while (true) {
            String strMo62772i0 = interfaceC10079c.mo62772i0(c10077a.m62709D());
            if (strMo62772i0 == null) {
                if (interfaceC10079c.mo62768a0() == 13) {
                    interfaceC10079c.mo62756D(16);
                    break;
                }
                if (interfaceC10079c.mo62768a0() != 16 || !interfaceC10079c.mo62788x0(EnumC10078b.AllowArbitraryCommas)) {
                }
            }
            interfaceC10079c.mo62762I(4);
            if ("className".equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() == 8) {
                    strMo62763J = null;
                } else {
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("syntax error");
                    }
                    strMo62763J = interfaceC10079c.mo62763J();
                }
            } else if ("methodName".equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() == 8) {
                    strMo62763J2 = null;
                } else {
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("syntax error");
                    }
                    strMo62763J2 = interfaceC10079c.mo62763J();
                }
            } else if (ContentResource.FILE_NAME.equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() == 8) {
                    strMo62763J3 = null;
                } else {
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("syntax error");
                    }
                    strMo62763J3 = interfaceC10079c.mo62763J();
                }
            } else if ("lineNumber".equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() == 8) {
                    iMo62753B = 0;
                } else {
                    if (interfaceC10079c.mo62768a0() != 2) {
                        throw new C9380d("syntax error");
                    }
                    iMo62753B = interfaceC10079c.mo62753B();
                }
            } else if ("nativeMethod".equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() != 8 && interfaceC10079c.mo62768a0() != 6 && interfaceC10079c.mo62768a0() != 7) {
                    throw new C9380d("syntax error");
                }
                interfaceC10079c.mo62756D(16);
            } else if (strMo62772i0 == AbstractC9377a.f46780c) {
                if (interfaceC10079c.mo62768a0() == 4) {
                    String strMo62763J4 = interfaceC10079c.mo62763J();
                    if (!strMo62763J4.equals("java.lang.StackTraceElement")) {
                        throw new C9380d("syntax error : " + strMo62763J4);
                    }
                } else if (interfaceC10079c.mo62768a0() != 8) {
                    throw new C9380d("syntax error");
                }
            } else if ("moduleName".equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() != 8) {
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("syntax error");
                    }
                    interfaceC10079c.mo62763J();
                }
            } else if ("moduleVersion".equals(strMo62772i0)) {
                if (interfaceC10079c.mo62768a0() != 8) {
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("syntax error");
                    }
                    interfaceC10079c.mo62763J();
                }
            } else {
                if (!"classLoaderName".equals(strMo62772i0)) {
                    throw new C9380d("syntax error : " + strMo62772i0);
                }
                if (interfaceC10079c.mo62768a0() != 8) {
                    if (interfaceC10079c.mo62768a0() != 4) {
                        throw new C9380d("syntax error");
                    }
                    interfaceC10079c.mo62763J();
                }
            }
            if (interfaceC10079c.mo62768a0() == 13) {
                interfaceC10079c.mo62756D(16);
                break;
            }
        }
        return (T) new StackTraceElement(strMo62763J, strMo62763J2, strMo62763J3, iMo62753B);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }
}
