package p354i1;

import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import p244e1.C9380d;
import p244e1.C9381e;
import p274f1.InterfaceC9643d;
import p323h1.AbstractC10080d;
import p323h1.C10077a;
import p323h1.C10084h;
import p323h1.C10085i;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;
import p481n1.C11592d;
import p481n1.C11597i;
import p481n1.C11603o;

/* renamed from: i1.o */
/* loaded from: classes.dex */
public class C10403o implements InterfaceC10408t {

    /* renamed from: a */
    public final AbstractC10400l[] f50201a;

    /* renamed from: b */
    public final AbstractC10400l[] f50202b;

    /* renamed from: c */
    public final Class<?> f50203c;

    /* renamed from: d */
    public final C11597i f50204d;

    /* renamed from: e */
    public ConcurrentMap<String, Object> f50205e;

    /* renamed from: f */
    public final Map<String, AbstractC10400l> f50206f;

    /* renamed from: g */
    public Map<String, AbstractC10400l> f50207g;

    /* renamed from: h */
    public transient long[] f50208h;

    /* renamed from: i */
    public transient short[] f50209i;

    /* renamed from: j */
    public final C10085i.c f50210j;

    public C10403o(C10085i c10085i, Class<?> cls, Type type) {
        this(c10085i, C11597i.m69224c(cls, type, c10085i.f49245f, c10085i.f49252m, c10085i.f49254o, c10085i.m62870v()));
    }

    /* renamed from: m */
    public static C10403o m63915m(C10085i c10085i, C11597i c11597i, String str) {
        InterfaceC9643d interfaceC9643d = c11597i.f53824k;
        if (interfaceC9643d == null) {
            return null;
        }
        for (Class<?> cls : interfaceC9643d.seeAlso()) {
            InterfaceC10408t interfaceC10408tM62867p = c10085i.m62867p(cls);
            if (interfaceC10408tM62867p instanceof C10403o) {
                C10403o c10403o = (C10403o) interfaceC10408tM62867p;
                C11597i c11597i2 = c10403o.f50204d;
                if (c11597i2.f53825l.equals(str)) {
                    return c10403o;
                }
                C10403o c10403oM63915m = m63915m(c10085i, c11597i2, str);
                if (c10403oM63915m != null) {
                    return c10403oM63915m;
                }
            }
        }
        return null;
    }

    /* renamed from: n */
    public static boolean m63916n(int i10, int[] iArr) {
        int i11;
        if (iArr != null && (i11 = i10 / 32) < iArr.length) {
            return ((1 << (i10 % 32)) & iArr[i11]) != 0;
        }
        return false;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) m63921h(c10077a, type, obj, 0);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }

    /* renamed from: d */
    public void m63917d(InterfaceC10079c interfaceC10079c, int i10) {
        if (interfaceC10079c.mo62768a0() != i10) {
            throw new C9380d("syntax error");
        }
    }

    /* renamed from: e */
    public final Object m63918e(C10085i c10085i, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return this.f50204d.f53818e.invoke(null, obj);
    }

    /* renamed from: f */
    public Object m63919f(C10077a c10077a, Type type) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        if ((type instanceof Class) && this.f50203c.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new C9381e());
        }
        C11597i c11597i = this.f50204d;
        Constructor<?> constructor = c11597i.f53816c;
        Object obj = null;
        if (constructor == null && c11597i.f53818e == null) {
            return null;
        }
        Method method = c11597i.f53818e;
        if (method != null && c11597i.f53820g > 0) {
            return null;
        }
        try {
            if (c11597i.f53820g == 0) {
                objNewInstance = constructor != null ? constructor.newInstance(new Object[0]) : method.invoke(null, new Object[0]);
            } else {
                C10084h c10084hM62739t = c10077a.m62739t();
                if (c10084hM62739t == null || c10084hM62739t.f49222a == null) {
                    throw new C9380d("can't create non-static inner class instance.");
                }
                if (!(type instanceof Class)) {
                    throw new C9380d("can't create non-static inner class instance.");
                }
                String name = ((Class) type).getName();
                String strSubstring = name.substring(0, name.lastIndexOf(36));
                Object obj2 = c10084hM62739t.f49222a;
                String name2 = obj2.getClass().getName();
                if (!name2.equals(strSubstring)) {
                    C10084h c10084h = c10084hM62739t.f49223b;
                    if (c10084h == null || c10084h.f49222a == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                        obj = obj2;
                    } else if (c10084h.f49222a.getClass().getName().equals(strSubstring)) {
                        obj = c10084h.f49222a;
                    }
                    obj2 = obj;
                }
                if (obj2 == null || ((obj2 instanceof Collection) && ((Collection) obj2).isEmpty())) {
                    throw new C9380d("can't create non-static inner class instance.");
                }
                objNewInstance = constructor.newInstance(obj2);
            }
            if (c10077a != null && c10077a.f49153f.mo62788x0(EnumC10078b.InitStringFieldAsEmpty)) {
                for (C11592d c11592d : this.f50204d.f53821h) {
                    if (c11592d.f53772e == String.class) {
                        try {
                            c11592d.m69204v(objNewInstance, "");
                        } catch (Exception e10) {
                            throw new C9380d("create instance error, class " + this.f50203c.getName(), e10);
                        }
                    }
                }
            }
            return objNewInstance;
        } catch (C9380d e11) {
            throw e11;
        } catch (Exception e12) {
            throw new C9380d("create instance error, class " + this.f50203c.getName(), e12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m63920g(java.util.Map<java.lang.String, java.lang.Object> r13, p323h1.C10085i r14) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10403o.m63920g(java.util.Map, h1.i):java.lang.Object");
    }

    /* renamed from: h */
    public <T> T m63921h(C10077a c10077a, Type type, Object obj, int i10) {
        return (T) m63922i(c10077a, type, obj, null, i10, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x01f2, code lost:
    
        if (r7 == (-2)) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0379, code lost:
    
        if (r7 == (-2)) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x03a8, code lost:
    
        r5 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0510, code lost:
    
        if (r2 != null) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0512, code lost:
    
        r1 = r6.m62861j(r0, r1, r11.mo62770c0());
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x051b, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0524, code lost:
    
        r2 = r1;
        r1 = r34.m62737s().m62867p(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x052b, code lost:
    
        r2 = (T) r1.mo63891b(r34, r2, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0531, code lost:
    
        if ((r1 instanceof p354i1.C10403o) == false) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0533, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0535, code lost:
    
        if (r14 == null) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0537, code lost:
    
        r1 = r1.m63924k(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x053b, code lost:
    
        if (r1 == null) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x053d, code lost:
    
        r1.m63912i(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0540, code lost:
    
        if (r3 == null) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0542, code lost:
    
        r3.f49222a = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0546, code lost:
    
        r34.m62738s0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0549, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x055c, code lost:
    
        r29 = r5;
        r7 = r27;
        r13 = r30;
        r37 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0846, code lost:
    
        if (r5[r4].f53772e != r13) goto L635;
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x0848, code lost:
    
        r2 = r2.f53831r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x084a, code lost:
    
        if (r2 == null) goto L635;
     */
    /* JADX WARN: Code restructure failed: missing block: B:615:0x084c, code lost:
    
        r2 = (T) r2.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x0853, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0855, code lost:
    
        if (r4 >= r0.length) goto L758;
     */
    /* JADX WARN: Code restructure failed: missing block: B:619:0x0857, code lost:
    
        r5 = r0[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:620:0x0859, code lost:
    
        if (r5 == null) goto L759;
     */
    /* JADX WARN: Code restructure failed: missing block: B:621:0x085b, code lost:
    
        r6 = r33.f50204d.f53821h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:622:0x085f, code lost:
    
        if (r6 == null) goto L760;
     */
    /* JADX WARN: Code restructure failed: missing block: B:624:0x0862, code lost:
    
        if (r4 >= r6.length) goto L761;
     */
    /* JADX WARN: Code restructure failed: missing block: B:625:0x0864, code lost:
    
        r6[r4].m69204v(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:627:0x086a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:629:0x086d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:631:0x086f, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:632:0x0872, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:645:0x08d2, code lost:
    
        throw new p244e1.C9380d("create instance error, " + r1 + ", " + r33.f50204d.f53817d.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:682:0x0975, code lost:
    
        throw new p244e1.C9380d("syntax error, unexpect token " + p323h1.C10083g.m62844a(r11.mo62768a0()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x05a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:441:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x065c A[Catch: all -> 0x060d, TryCatch #9 {all -> 0x060d, blocks: (B:445:0x05f6, B:450:0x0617, B:475:0x065c, B:477:0x066c, B:453:0x0621, B:455:0x0625, B:457:0x0629, B:459:0x062d, B:461:0x0631, B:463:0x0635, B:466:0x063d, B:468:0x0645, B:470:0x064c, B:472:0x0651, B:473:0x0657, B:483:0x0693), top: B:709:0x05f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x06ed A[Catch: all -> 0x06cb, TryCatch #7 {all -> 0x06cb, blocks: (B:680:0x0946, B:499:0x06e2, B:502:0x06ed, B:504:0x06f3, B:675:0x0931, B:677:0x0939, B:681:0x0957, B:682:0x0975, B:487:0x06bb, B:489:0x06c1, B:491:0x06c7, B:497:0x06da, B:683:0x0976, B:684:0x097d), top: B:706:0x0946 }] */
    /* JADX WARN: Removed duplicated region for block: B:638:0x0884 A[Catch: all -> 0x086a, TRY_ENTER, TryCatch #5 {all -> 0x086a, blocks: (B:617:0x0854, B:619:0x0857, B:621:0x085b, B:623:0x0861, B:625:0x0864, B:638:0x0884, B:639:0x088c, B:641:0x0892, B:643:0x08a4, B:657:0x0903, B:659:0x0908, B:666:0x0917, B:672:0x0926, B:673:0x092d, B:644:0x08ac, B:645:0x08d2), top: B:700:0x0854, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:690:0x0989  */
    /* JADX WARN: Removed duplicated region for block: B:741:0x0673 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v65, types: [i1.t] */
    /* JADX WARN: Type inference failed for: r34v0, types: [h1.a] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T m63922i(p323h1.C10077a r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10403o.m63922i(h1.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    /* renamed from: j */
    public <T> T m63923j(C10077a c10077a, Type type, Object obj, Object obj2) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() != 14) {
            throw new C9380d(VastAttribute.ERROR);
        }
        String strMo62785v = interfaceC10079c.mo62785v(c10077a.f49149b);
        if (strMo62785v != null) {
            InterfaceC10408t interfaceC10408tM63915m = m63915m(c10077a.m62737s(), this.f50204d, strMo62785v);
            if (interfaceC10408tM63915m == null) {
                interfaceC10408tM63915m = c10077a.m62737s().m62867p(c10077a.m62737s().m62861j(strMo62785v, C11603o.m69271P(type), interfaceC10079c.mo62770c0()));
            }
            if (interfaceC10408tM63915m instanceof C10403o) {
                return (T) ((C10403o) interfaceC10408tM63915m).m63923j(c10077a, type, obj, obj2);
            }
        }
        T t10 = (T) m63919f(c10077a, type);
        int length = this.f50202b.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char c10 = i10 == length + (-1) ? ']' : ',';
            AbstractC10400l abstractC10400l = this.f50202b[i10];
            Class<?> cls = abstractC10400l.f50198a.f53772e;
            if (cls == Integer.TYPE) {
                abstractC10400l.m63909f(t10, interfaceC10079c.mo62760G(c10));
            } else if (cls == String.class) {
                abstractC10400l.m63912i(t10, interfaceC10079c.mo62769b0(c10));
            } else if (cls == Long.TYPE) {
                abstractC10400l.m63910g(t10, interfaceC10079c.mo62777q0(c10));
            } else if (cls.isEnum()) {
                char cMo62773j0 = interfaceC10079c.mo62773j0();
                abstractC10400l.mo63911h(t10, (cMo62773j0 == '\"' || cMo62773j0 == 'n') ? interfaceC10079c.mo62758E(cls, c10077a.m62709D(), c10) : (cMo62773j0 < '0' || cMo62773j0 > '9') ? m63927p(interfaceC10079c, c10) : ((C10396h) ((C10394f) abstractC10400l).m63900k(c10077a.m62737s())).m63902e(interfaceC10079c.mo62760G(c10)));
            } else if (cls == Boolean.TYPE) {
                abstractC10400l.m63913j(t10, interfaceC10079c.mo62787x(c10));
            } else if (cls == Float.TYPE) {
                abstractC10400l.mo63911h(t10, Float.valueOf(interfaceC10079c.mo62789y(c10)));
            } else if (cls == Double.TYPE) {
                abstractC10400l.mo63911h(t10, Double.valueOf(interfaceC10079c.mo62771g0(c10)));
            } else if (cls == Date.class && interfaceC10079c.mo62773j0() == '1') {
                abstractC10400l.mo63911h(t10, new Date(interfaceC10079c.mo62777q0(c10)));
            } else if (cls == BigDecimal.class) {
                abstractC10400l.mo63911h(t10, interfaceC10079c.mo62774m0(c10));
            } else {
                interfaceC10079c.mo62756D(14);
                C11592d c11592d = abstractC10400l.f50198a;
                abstractC10400l.mo63911h(t10, c10077a.m62727g0(c11592d.f53773f, c11592d.f53768a));
                if (interfaceC10079c.mo62768a0() == 15) {
                    break;
                }
                m63917d(interfaceC10079c, c10 == ']' ? 15 : 16);
            }
            i10++;
        }
        interfaceC10079c.mo62756D(16);
        return t10;
    }

    /* renamed from: k */
    public AbstractC10400l m63924k(String str) {
        return m63925l(str, null);
    }

    /* renamed from: l */
    public AbstractC10400l m63925l(String str, int[] iArr) {
        AbstractC10400l abstractC10400l;
        if (str == null) {
            return null;
        }
        Map<String, AbstractC10400l> map = this.f50207g;
        if (map != null && (abstractC10400l = map.get(str)) != null) {
            return abstractC10400l;
        }
        int length = this.f50202b.length - 1;
        int i10 = 0;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            int iCompareTo = this.f50202b[i11].f50198a.f53768a.compareTo(str);
            if (iCompareTo < 0) {
                i10 = i11 + 1;
            } else {
                if (iCompareTo <= 0) {
                    if (m63916n(i11, iArr)) {
                        return null;
                    }
                    return this.f50202b[i11];
                }
                length = i11 - 1;
            }
        }
        Map<String, AbstractC10400l> map2 = this.f50206f;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b  */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m63926o(p323h1.C10077a r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10403o.m63926o(h1.a, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    /* renamed from: p */
    public Enum<?> m63927p(InterfaceC10079c interfaceC10079c, char c10) {
        throw new C9380d("illegal enum. " + interfaceC10079c.mo62781t());
    }

    /* renamed from: q */
    public Enum m63928q(AbstractC10080d abstractC10080d, char[] cArr, InterfaceC10408t interfaceC10408t) {
        C10396h c10396h = interfaceC10408t instanceof C10396h ? (C10396h) interfaceC10408t : null;
        if (c10396h == null) {
            abstractC10080d.f49213n = -1;
            return null;
        }
        long jM62803Q0 = abstractC10080d.m62803Q0(cArr);
        if (abstractC10080d.f49213n <= 0) {
            return null;
        }
        Enum enumM63901d = c10396h.m63901d(jM62803Q0);
        if (enumM63901d == null) {
            if (jM62803Q0 == -3750763034362895579L) {
                return null;
            }
            if (abstractC10080d.mo62788x0(EnumC10078b.ErrorOnEnumNotMatch)) {
                throw new C9380d("not match enum value, " + c10396h.f50194a);
            }
        }
        return enumM63901d;
    }

    /* renamed from: r */
    public AbstractC10400l m63929r(String str) {
        return m63930s(str, null);
    }

    /* renamed from: s */
    public AbstractC10400l m63930s(String str, int[] iArr) {
        boolean zStartsWith;
        if (str == null) {
            return null;
        }
        AbstractC10400l abstractC10400lM63925l = m63925l(str, iArr);
        if (abstractC10400lM63925l == null) {
            int i10 = 0;
            if (this.f50208h == null) {
                long[] jArr = new long[this.f50202b.length];
                int i11 = 0;
                while (true) {
                    AbstractC10400l[] abstractC10400lArr = this.f50202b;
                    if (i11 >= abstractC10400lArr.length) {
                        break;
                    }
                    jArr[i11] = abstractC10400lArr[i11].f50198a.f53789v;
                    i11++;
                }
                Arrays.sort(jArr);
                this.f50208h = jArr;
            }
            int iBinarySearch = Arrays.binarySearch(this.f50208h, C11603o.m69261K(str));
            if (iBinarySearch < 0) {
                iBinarySearch = Arrays.binarySearch(this.f50208h, C11603o.m69259J(str));
            }
            if (iBinarySearch < 0) {
                zStartsWith = str.startsWith("is");
                if (zStartsWith) {
                    iBinarySearch = Arrays.binarySearch(this.f50208h, C11603o.m69259J(str.substring(2)));
                }
            } else {
                zStartsWith = false;
            }
            if (iBinarySearch >= 0) {
                if (this.f50209i == null) {
                    short[] sArr = new short[this.f50208h.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        AbstractC10400l[] abstractC10400lArr2 = this.f50202b;
                        if (i10 >= abstractC10400lArr2.length) {
                            break;
                        }
                        int iBinarySearch2 = Arrays.binarySearch(this.f50208h, abstractC10400lArr2[i10].f50198a.f53789v);
                        if (iBinarySearch2 >= 0) {
                            sArr[iBinarySearch2] = (short) i10;
                        }
                        i10++;
                    }
                    this.f50209i = sArr;
                }
                short s10 = this.f50209i[iBinarySearch];
                if (s10 != -1 && !m63916n(s10, iArr)) {
                    abstractC10400lM63925l = this.f50202b[s10];
                }
            }
            if (abstractC10400lM63925l != null) {
                C11592d c11592d = abstractC10400lM63925l.f50198a;
                if ((c11592d.f53777j & EnumC10078b.DisableFieldSmartMatch.f49196a) != 0) {
                    return null;
                }
                Class<?> cls = c11592d.f53772e;
                if (zStartsWith && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return abstractC10400lM63925l;
    }

    public C10403o(C10085i c10085i, C11597i c11597i) throws IllegalAccessException, InstantiationException {
        C10085i.c cVarNewInstance;
        this.f50203c = c11597i.f53814a;
        this.f50204d = c11597i;
        InterfaceC9643d interfaceC9643d = c11597i.f53824k;
        HashMap map = null;
        if (interfaceC9643d == null || interfaceC9643d.autoTypeCheckHandler() == C10085i.c.class) {
            cVarNewInstance = null;
        } else {
            try {
                cVarNewInstance = c11597i.f53824k.autoTypeCheckHandler().newInstance();
            } catch (Exception unused) {
            }
        }
        this.f50210j = cVarNewInstance;
        C11592d[] c11592dArr = c11597i.f53822i;
        this.f50202b = new AbstractC10400l[c11592dArr.length];
        int length = c11592dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            C11592d c11592d = c11597i.f53822i[i10];
            AbstractC10400l abstractC10400lM62862k = c10085i.m62862k(c10085i, c11597i, c11592d);
            this.f50202b[i10] = abstractC10400lM62862k;
            if (length > 128) {
                if (this.f50207g == null) {
                    this.f50207g = new HashMap();
                }
                this.f50207g.put(c11592d.f53768a, abstractC10400lM62862k);
            }
            for (String str : c11592d.f53788u) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, abstractC10400lM62862k);
            }
        }
        this.f50206f = map;
        C11592d[] c11592dArr2 = c11597i.f53821h;
        this.f50201a = new AbstractC10400l[c11592dArr2.length];
        int length2 = c11592dArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.f50201a[i11] = m63924k(c11597i.f53821h[i11].f53768a);
        }
    }
}
