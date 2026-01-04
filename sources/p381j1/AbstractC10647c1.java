package p381j1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p244e1.AbstractC9377a;

/* renamed from: j1.c1 */
/* loaded from: classes.dex */
public abstract class AbstractC10647c1 {

    /* renamed from: a */
    public List<AbstractC10667k> f51174a = null;

    /* renamed from: b */
    public List<AbstractC10645c> f51175b = null;

    /* renamed from: c */
    public List<InterfaceC10690v0> f51176c = null;

    /* renamed from: d */
    public List<InterfaceC10662h1> f51177d = null;

    /* renamed from: e */
    public List<InterfaceC10682r0> f51178e = null;

    /* renamed from: f */
    public List<InterfaceC10692w0> f51179f = null;

    /* renamed from: g */
    public List<InterfaceC10670l0> f51180g = null;

    /* renamed from: h */
    public List<InterfaceC10689v> f51181h = null;

    /* renamed from: i */
    public boolean f51182i = true;

    /* renamed from: b */
    public void m65195b(InterfaceC10644b1 interfaceC10644b1) {
        if (interfaceC10644b1 == null) {
            return;
        }
        if (interfaceC10644b1 instanceof InterfaceC10692w0) {
            m65204m().add((InterfaceC10692w0) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof InterfaceC10682r0) {
            m65202k().add((InterfaceC10682r0) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof InterfaceC10662h1) {
            m65205n().add((InterfaceC10662h1) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof InterfaceC10689v) {
            m65200i().add((InterfaceC10689v) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof InterfaceC10690v0) {
            m65203l().add((InterfaceC10690v0) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof AbstractC10667k) {
            m65199h().add((AbstractC10667k) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof AbstractC10645c) {
            m65198g().add((AbstractC10645c) interfaceC10644b1);
        }
        if (interfaceC10644b1 instanceof InterfaceC10670l0) {
            m65201j().add((InterfaceC10670l0) interfaceC10644b1);
        }
    }

    /* renamed from: c */
    public boolean m65196c(C10664i0 c10664i0, Object obj, String str, Object obj2) {
        List<InterfaceC10690v0> list = c10664i0.f51176c;
        if (list != null) {
            Iterator<InterfaceC10690v0> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().m65317e(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<InterfaceC10690v0> list2 = this.f51176c;
        if (list2 == null) {
            return true;
        }
        Iterator<InterfaceC10690v0> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().m65317e(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean m65197f(C10664i0 c10664i0, Object obj, String str) {
        List<InterfaceC10692w0> list = c10664i0.f51179f;
        if (list != null) {
            Iterator<InterfaceC10692w0> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().m65318d(c10664i0, obj, str)) {
                    return false;
                }
            }
        }
        List<InterfaceC10692w0> list2 = this.f51179f;
        if (list2 == null) {
            return true;
        }
        Iterator<InterfaceC10692w0> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().m65318d(c10664i0, obj, str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public List<AbstractC10645c> m65198g() {
        if (this.f51175b == null) {
            this.f51175b = new ArrayList();
            this.f51182i = false;
        }
        return this.f51175b;
    }

    /* renamed from: h */
    public List<AbstractC10667k> m65199h() {
        if (this.f51174a == null) {
            this.f51174a = new ArrayList();
            this.f51182i = false;
        }
        return this.f51174a;
    }

    /* renamed from: i */
    public List<InterfaceC10689v> m65200i() {
        if (this.f51181h == null) {
            this.f51181h = new ArrayList();
            this.f51182i = false;
        }
        return this.f51181h;
    }

    /* renamed from: j */
    public List<InterfaceC10670l0> m65201j() {
        if (this.f51180g == null) {
            this.f51180g = new ArrayList();
            this.f51182i = false;
        }
        return this.f51180g;
    }

    /* renamed from: k */
    public List<InterfaceC10682r0> m65202k() {
        if (this.f51178e == null) {
            this.f51178e = new ArrayList();
            this.f51182i = false;
        }
        return this.f51178e;
    }

    /* renamed from: l */
    public List<InterfaceC10690v0> m65203l() {
        if (this.f51176c == null) {
            this.f51176c = new ArrayList();
            this.f51182i = false;
        }
        return this.f51176c;
    }

    /* renamed from: m */
    public List<InterfaceC10692w0> m65204m() {
        if (this.f51179f == null) {
            this.f51179f = new ArrayList();
            this.f51182i = false;
        }
        return this.f51179f;
    }

    /* renamed from: n */
    public List<InterfaceC10662h1> m65205n() {
        if (this.f51177d == null) {
            this.f51177d = new ArrayList();
            this.f51182i = false;
        }
        return this.f51177d;
    }

    /* renamed from: o */
    public String m65206o(C10664i0 c10664i0, Object obj, String str, Object obj2) {
        List<InterfaceC10682r0> list = c10664i0.f51178e;
        if (list != null) {
            Iterator<InterfaceC10682r0> it = list.iterator();
            while (it.hasNext()) {
                str = it.next().m65314a(obj, str, obj2);
            }
        }
        List<InterfaceC10682r0> list2 = this.f51178e;
        if (list2 != null) {
            Iterator<InterfaceC10682r0> it2 = list2.iterator();
            while (it2.hasNext()) {
                str = it2.next().m65314a(obj, str, obj2);
            }
        }
        return str;
    }

    /* renamed from: p */
    public Object m65207p(C10664i0 c10664i0, C10665j c10665j, Object obj, String str, Object obj2, int i10) {
        boolean z10;
        if (obj2 != null) {
            int i11 = c10664i0.f51258k.f51197c;
            EnumC10653e1 enumC10653e1 = EnumC10653e1.WriteNonStringValueAsString;
            if ((EnumC10653e1.m65241e(i11, i10, enumC10653e1) || !(c10665j == null || (c10665j.m65279a() & enumC10653e1.f51248a) == 0)) && (((z10 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String strM65280b = (!z10 || c10665j == null) ? null : c10665j.m65280b();
                obj2 = strM65280b != null ? new DecimalFormat(strM65280b).format(obj2) : obj2.toString();
            } else if (c10665j != null && c10665j.m65281c()) {
                obj2 = AbstractC9377a.m58762g((String) obj2);
            }
        }
        List<InterfaceC10662h1> list = c10664i0.f51177d;
        if (list != null) {
            Iterator<InterfaceC10662h1> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().m65248a(obj, str, obj2);
            }
        }
        List<InterfaceC10662h1> list2 = this.f51177d;
        if (list2 != null) {
            Iterator<InterfaceC10662h1> it2 = list2.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().m65248a(obj, str, obj2);
            }
        }
        List<InterfaceC10689v> list3 = c10664i0.f51181h;
        if (list3 != null) {
            Iterator<InterfaceC10689v> it3 = list3.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().m65316c(c10665j, obj, str, obj2);
            }
        }
        List<InterfaceC10689v> list4 = this.f51181h;
        if (list4 != null) {
            Iterator<InterfaceC10689v> it4 = list4.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().m65316c(c10665j, obj, str, obj2);
            }
        }
        return obj2;
    }
}
