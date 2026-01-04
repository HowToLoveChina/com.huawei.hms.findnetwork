package p381j1;

import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.C10084h;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;

/* renamed from: j1.i */
/* loaded from: classes.dex */
public class C10663i implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10663i f51256a = new C10663i();

    /* renamed from: k */
    public static boolean m65249k(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        T t10;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 8) {
            interfaceC10079c.mo62756D(16);
            return null;
        }
        if (interfaceC10079c.mo62768a0() != 12 && interfaceC10079c.mo62768a0() != 16) {
            throw new C9380d("syntax error");
        }
        interfaceC10079c.mo62790z();
        if (type == Point.class) {
            t10 = (T) m65252h(c10077a, obj);
        } else if (type == Rectangle.class) {
            t10 = (T) m65253i(c10077a);
        } else if (type == Color.class) {
            t10 = (T) m65250f(c10077a);
        } else {
            if (type != Font.class) {
                throw new C9380d("not support awt class : " + type);
            }
            t10 = (T) m65251g(c10077a);
        }
        C10084h c10084hM62739t = c10077a.m62739t();
        c10077a.m62736r0(t10, obj);
        c10077a.m62738s0(c10084hM62739t);
        return t10;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65222a0();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            c10650d1.m65212E(m65255l(c10650d1, Point.class, '{'), Constants.MULTIPLE_SIGN, point.x);
            c10650d1.m65212E(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            c10650d1.m65214G(m65255l(c10650d1, Font.class, '{'), "name", font.getName());
            c10650d1.m65212E(',', TemplateStyleRecord.STYLE, font.getStyle());
            c10650d1.m65212E(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            c10650d1.m65212E(m65255l(c10650d1, Rectangle.class, '{'), Constants.MULTIPLE_SIGN, rectangle.x);
            c10650d1.m65212E(',', "y", rectangle.y);
            c10650d1.m65212E(',', "width", rectangle.width);
            c10650d1.m65212E(',', "height", rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new C9380d("not support awt class : " + obj.getClass().getName());
            }
            Color color = (Color) obj;
            c10650d1.m65212E(m65255l(c10650d1, Color.class, '{'), "r", color.getRed());
            c10650d1.m65212E(',', "g", color.getGreen());
            c10650d1.m65212E(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                c10650d1.m65212E(',', TopAnimatorConfig.AnimatorType.ALPHA, color.getAlpha());
            }
        }
        c10650d1.write(125);
    }

    /* renamed from: f */
    public Color m65250f(C10077a c10077a) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (interfaceC10079c.mo62768a0() != 13) {
            if (interfaceC10079c.mo62768a0() != 4) {
                throw new C9380d("syntax error");
            }
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62762I(2);
            if (interfaceC10079c.mo62768a0() != 2) {
                throw new C9380d("syntax error");
            }
            int iMo62753B = interfaceC10079c.mo62753B();
            interfaceC10079c.mo62790z();
            if (strMo62763J.equalsIgnoreCase("r")) {
                i10 = iMo62753B;
            } else if (strMo62763J.equalsIgnoreCase("g")) {
                i11 = iMo62753B;
            } else if (strMo62763J.equalsIgnoreCase("b")) {
                i12 = iMo62753B;
            } else {
                if (!strMo62763J.equalsIgnoreCase(TopAnimatorConfig.AnimatorType.ALPHA)) {
                    throw new C9380d("syntax error, " + strMo62763J);
                }
                i13 = iMo62753B;
            }
            if (interfaceC10079c.mo62768a0() == 16) {
                interfaceC10079c.mo62756D(4);
            }
        }
        interfaceC10079c.mo62790z();
        return new Color(i10, i11, i12, i13);
    }

    /* renamed from: g */
    public Font m65251g(C10077a c10077a) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int iMo62753B = 0;
        String strMo62763J = null;
        int iMo62753B2 = 0;
        while (interfaceC10079c.mo62768a0() != 13) {
            if (interfaceC10079c.mo62768a0() != 4) {
                throw new C9380d("syntax error");
            }
            String strMo62763J2 = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62762I(2);
            if (strMo62763J2.equalsIgnoreCase("name")) {
                if (interfaceC10079c.mo62768a0() != 4) {
                    throw new C9380d("syntax error");
                }
                strMo62763J = interfaceC10079c.mo62763J();
                interfaceC10079c.mo62790z();
            } else if (strMo62763J2.equalsIgnoreCase(TemplateStyleRecord.STYLE)) {
                if (interfaceC10079c.mo62768a0() != 2) {
                    throw new C9380d("syntax error");
                }
                iMo62753B = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62790z();
            } else {
                if (!strMo62763J2.equalsIgnoreCase("size")) {
                    throw new C9380d("syntax error, " + strMo62763J2);
                }
                if (interfaceC10079c.mo62768a0() != 2) {
                    throw new C9380d("syntax error");
                }
                iMo62753B2 = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62790z();
            }
            if (interfaceC10079c.mo62768a0() == 16) {
                interfaceC10079c.mo62756D(4);
            }
        }
        interfaceC10079c.mo62790z();
        return new Font(strMo62763J, iMo62753B, iMo62753B2);
    }

    /* renamed from: h */
    public Point m65252h(C10077a c10077a, Object obj) {
        int iMo62766Y;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int i10 = 0;
        int i11 = 0;
        while (interfaceC10079c.mo62768a0() != 13) {
            if (interfaceC10079c.mo62768a0() != 4) {
                throw new C9380d("syntax error");
            }
            String strMo62763J = interfaceC10079c.mo62763J();
            if (AbstractC9377a.f46780c.equals(strMo62763J)) {
                c10077a.m62724e("java.awt.Point");
            } else {
                if ("$ref".equals(strMo62763J)) {
                    return (Point) m65254j(c10077a, obj);
                }
                interfaceC10079c.mo62762I(2);
                int iMo62768a0 = interfaceC10079c.mo62768a0();
                if (iMo62768a0 == 2) {
                    iMo62766Y = interfaceC10079c.mo62753B();
                    interfaceC10079c.mo62790z();
                } else {
                    if (iMo62768a0 != 3) {
                        throw new C9380d("syntax error : " + interfaceC10079c.mo62782t0());
                    }
                    iMo62766Y = (int) interfaceC10079c.mo62766Y();
                    interfaceC10079c.mo62790z();
                }
                if (strMo62763J.equalsIgnoreCase(Constants.MULTIPLE_SIGN)) {
                    i10 = iMo62766Y;
                } else {
                    if (!strMo62763J.equalsIgnoreCase("y")) {
                        throw new C9380d("syntax error, " + strMo62763J);
                    }
                    i11 = iMo62766Y;
                }
                if (interfaceC10079c.mo62768a0() == 16) {
                    interfaceC10079c.mo62756D(4);
                }
            }
        }
        interfaceC10079c.mo62790z();
        return new Point(i10, i11);
    }

    /* renamed from: i */
    public Rectangle m65253i(C10077a c10077a) {
        int iMo62766Y;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (interfaceC10079c.mo62768a0() != 13) {
            if (interfaceC10079c.mo62768a0() != 4) {
                throw new C9380d("syntax error");
            }
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62762I(2);
            int iMo62768a0 = interfaceC10079c.mo62768a0();
            if (iMo62768a0 == 2) {
                iMo62766Y = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62790z();
            } else {
                if (iMo62768a0 != 3) {
                    throw new C9380d("syntax error");
                }
                iMo62766Y = (int) interfaceC10079c.mo62766Y();
                interfaceC10079c.mo62790z();
            }
            if (strMo62763J.equalsIgnoreCase(Constants.MULTIPLE_SIGN)) {
                i10 = iMo62766Y;
            } else if (strMo62763J.equalsIgnoreCase("y")) {
                i11 = iMo62766Y;
            } else if (strMo62763J.equalsIgnoreCase("width")) {
                i12 = iMo62766Y;
            } else {
                if (!strMo62763J.equalsIgnoreCase("height")) {
                    throw new C9380d("syntax error, " + strMo62763J);
                }
                i13 = iMo62766Y;
            }
            if (interfaceC10079c.mo62768a0() == 16) {
                interfaceC10079c.mo62756D(4);
            }
        }
        interfaceC10079c.mo62790z();
        return new Rectangle(i10, i11, i12, i13);
    }

    /* renamed from: j */
    public final Object m65254j(C10077a c10077a, Object obj) {
        InterfaceC10079c interfaceC10079cM62706A = c10077a.m62706A();
        interfaceC10079cM62706A.mo62762I(4);
        String strMo62763J = interfaceC10079cM62706A.mo62763J();
        c10077a.m62736r0(c10077a.m62739t(), obj);
        c10077a.m62726g(new C10077a.a(c10077a.m62739t(), strMo62763J));
        c10077a.m62733n0();
        c10077a.m62746x0(1);
        interfaceC10079cM62706A.mo62756D(13);
        c10077a.m62723d(13);
        return null;
    }

    /* renamed from: l */
    public char m65255l(C10650d1 c10650d1, Class<?> cls, char c10) {
        if (!c10650d1.m65237w(EnumC10653e1.WriteClassName)) {
            return c10;
        }
        c10650d1.write(123);
        c10650d1.m65209B(AbstractC9377a.f46780c);
        c10650d1.m65228g0(cls.getName());
        return ',';
    }
}
