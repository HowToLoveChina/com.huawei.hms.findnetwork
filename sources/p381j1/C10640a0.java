package p381j1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import p244e1.AbstractC9377a;
import p274f1.InterfaceC9641b;
import p274f1.InterfaceC9643d;
import p481n1.C11592d;
import p481n1.C11603o;

/* renamed from: j1.a0 */
/* loaded from: classes.dex */
public class C10640a0 implements Comparable<C10640a0> {

    /* renamed from: a */
    public final C11592d f51134a;

    /* renamed from: b */
    public final boolean f51135b;

    /* renamed from: c */
    public int f51136c;

    /* renamed from: d */
    public final String f51137d;

    /* renamed from: e */
    public String f51138e;

    /* renamed from: f */
    public String f51139f;

    /* renamed from: g */
    public C10665j f51140g;

    /* renamed from: h */
    public String f51141h;

    /* renamed from: i */
    public boolean f51142i;

    /* renamed from: j */
    public boolean f51143j;

    /* renamed from: k */
    public boolean f51144k;

    /* renamed from: l */
    public boolean f51145l = false;

    /* renamed from: m */
    public boolean f51146m;

    /* renamed from: n */
    public boolean f51147n;

    /* renamed from: o */
    public a f51148o;

    /* renamed from: j1.a0$a */
    public static class a {

        /* renamed from: a */
        public final InterfaceC10686t0 f51149a;

        /* renamed from: b */
        public final Class<?> f51150b;

        public a(InterfaceC10686t0 interfaceC10686t0, Class<?> cls) {
            this.f51149a = interfaceC10686t0;
            this.f51150b = cls;
        }
    }

    public C10640a0(Class<?> cls, C11592d c11592d) throws SecurityException {
        boolean z10;
        InterfaceC9643d interfaceC9643d;
        this.f51142i = false;
        this.f51143j = false;
        this.f51144k = false;
        this.f51146m = false;
        this.f51134a = c11592d;
        this.f51140g = new C10665j(cls, c11592d);
        if (cls != null && (interfaceC9643d = (InterfaceC9643d) C11603o.m69265M(cls, InterfaceC9643d.class)) != null) {
            for (EnumC10653e1 enumC10653e1 : interfaceC9643d.serialzeFeatures()) {
                if (enumC10653e1 == EnumC10653e1.WriteEnumUsingToString) {
                    this.f51142i = true;
                } else if (enumC10653e1 == EnumC10653e1.WriteEnumUsingName) {
                    this.f51143j = true;
                } else if (enumC10653e1 == EnumC10653e1.DisableCircularReferenceDetect) {
                    this.f51144k = true;
                } else {
                    EnumC10653e1 enumC10653e12 = EnumC10653e1.BrowserCompatible;
                    if (enumC10653e1 == enumC10653e12) {
                        this.f51136c |= enumC10653e12.f51248a;
                        this.f51147n = true;
                    } else {
                        EnumC10653e1 enumC10653e13 = EnumC10653e1.WriteMapNullValue;
                        if (enumC10653e1 == enumC10653e13) {
                            this.f51136c |= enumC10653e13.f51248a;
                        }
                    }
                }
            }
        }
        c11592d.m69205w();
        this.f51137d = '\"' + c11592d.f53768a + "\":";
        InterfaceC9641b interfaceC9641bM69199f = c11592d.m69199f();
        if (interfaceC9641bM69199f != null) {
            EnumC10653e1[] enumC10653e1ArrSerialzeFeatures = interfaceC9641bM69199f.serialzeFeatures();
            int length = enumC10653e1ArrSerialzeFeatures.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = false;
                    break;
                } else {
                    if ((enumC10653e1ArrSerialzeFeatures[i10].m65244b() & EnumC10653e1.f51221G) != 0) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
            }
            String str = interfaceC9641bM69199f.format();
            this.f51141h = str;
            if (str.trim().length() == 0) {
                this.f51141h = null;
            }
            for (EnumC10653e1 enumC10653e14 : interfaceC9641bM69199f.serialzeFeatures()) {
                if (enumC10653e14 == EnumC10653e1.WriteEnumUsingToString) {
                    this.f51142i = true;
                } else if (enumC10653e14 == EnumC10653e1.WriteEnumUsingName) {
                    this.f51143j = true;
                } else if (enumC10653e14 == EnumC10653e1.DisableCircularReferenceDetect) {
                    this.f51144k = true;
                } else if (enumC10653e14 == EnumC10653e1.BrowserCompatible) {
                    this.f51147n = true;
                }
            }
            this.f51136c = EnumC10653e1.m65243h(interfaceC9641bM69199f.serialzeFeatures()) | this.f51136c;
        } else {
            z10 = false;
        }
        this.f51135b = z10;
        this.f51146m = C11603o.m69307m0(c11592d.f53769b) || C11603o.m69305l0(c11592d.f53769b);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C10640a0 c10640a0) {
        return this.f51134a.compareTo(c10640a0.f51134a);
    }

    /* renamed from: b */
    public Object m65176b(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class<?> cls;
        Object objM69198e = this.f51134a.m69198e(obj);
        if (this.f51141h == null || objM69198e == null || !((cls = this.f51134a.f53772e) == Date.class || cls == java.sql.Date.class)) {
            return objM69198e;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f51141h, AbstractC9377a.f46779b);
        simpleDateFormat.setTimeZone(AbstractC9377a.f46778a);
        return simpleDateFormat.format(objM69198e);
    }

    /* renamed from: e */
    public Object m65177e(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objM69198e = this.f51134a.m69198e(obj);
        if (!this.f51146m || C11603o.m69313p0(objM69198e)) {
            return objM69198e;
        }
        return null;
    }

    /* renamed from: f */
    public void m65178f(C10664i0 c10664i0) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (!c10650d1.f51200f) {
            if (this.f51139f == null) {
                this.f51139f = this.f51134a.f53768a + ":";
            }
            c10650d1.write(this.f51139f);
            return;
        }
        if (!EnumC10653e1.m65241e(c10650d1.f51197c, this.f51134a.f53776i, EnumC10653e1.UseSingleQuotes)) {
            c10650d1.write(this.f51137d);
            return;
        }
        if (this.f51138e == null) {
            this.f51138e = '\'' + this.f51134a.f53768a + "':";
        }
        c10650d1.write(this.f51138e);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m65179h(p381j1.C10664i0 r13, java.lang.Object r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10640a0.m65179h(j1.i0, java.lang.Object):void");
    }
}
