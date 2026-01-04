package p381j1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p244e1.EnumC9389m;
import p274f1.InterfaceC9643d;
import p481n1.C11592d;
import p481n1.C11603o;

/* renamed from: j1.j0 */
/* loaded from: classes.dex */
public class C10666j0 extends AbstractC10647c1 implements InterfaceC10686t0 {

    /* renamed from: j */
    public final C10640a0[] f51271j;

    /* renamed from: k */
    public final C10640a0[] f51272k;

    /* renamed from: l */
    public final C10698z0 f51273l;

    /* renamed from: m */
    public volatile transient long[] f51274m;

    /* renamed from: n */
    public volatile transient short[] f51275n;

    public C10666j0(C10698z0 c10698z0) {
        C10640a0[] c10640a0Arr;
        this.f51273l = c10698z0;
        this.f51272k = new C10640a0[c10698z0.f51342f.length];
        int i10 = 0;
        while (true) {
            c10640a0Arr = this.f51272k;
            if (i10 >= c10640a0Arr.length) {
                break;
            }
            c10640a0Arr[i10] = new C10640a0(c10698z0.f51337a, c10698z0.f51342f[i10]);
            i10++;
        }
        C11592d[] c11592dArr = c10698z0.f51341e;
        if (c11592dArr == c10698z0.f51342f) {
            this.f51271j = c10640a0Arr;
        } else {
            this.f51271j = new C10640a0[c11592dArr.length];
            int i11 = 0;
            while (true) {
                if (i11 >= this.f51271j.length) {
                    break;
                }
                C10640a0 c10640a0M65291t = m65291t(c10698z0.f51341e[i11].f53768a);
                if (c10640a0M65291t == null) {
                    C10640a0[] c10640a0Arr2 = this.f51272k;
                    System.arraycopy(c10640a0Arr2, 0, this.f51271j, 0, c10640a0Arr2.length);
                    break;
                } else {
                    this.f51271j[i11] = c10640a0M65291t;
                    i11++;
                }
            }
        }
        InterfaceC9643d interfaceC9643d = c10698z0.f51340d;
        if (interfaceC9643d != null) {
            for (Class<? extends InterfaceC10644b1> cls : interfaceC9643d.serialzeFilters()) {
                try {
                    m65195b(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:504:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:557:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x02c9 A[Catch: all -> 0x01c5, Exception -> 0x01cc, TryCatch #20 {Exception -> 0x01cc, all -> 0x01c5, blocks: (B:568:0x01a7, B:571:0x01af, B:573:0x01bb, B:582:0x01d9, B:584:0x01e3, B:587:0x01ed, B:589:0x01f9, B:591:0x01fd, B:594:0x020b, B:596:0x020f, B:597:0x0213, B:599:0x0218, B:601:0x021b, B:603:0x0221, B:605:0x022d, B:607:0x0231, B:610:0x0237, B:613:0x023e, B:615:0x0243, B:618:0x0247, B:620:0x024f, B:622:0x025b, B:624:0x025f, B:627:0x0265, B:629:0x0269, B:630:0x026e, B:632:0x0273, B:634:0x0276, B:635:0x027b, B:637:0x0283, B:639:0x028f, B:641:0x0293, B:644:0x029a, B:646:0x029e, B:647:0x02a3, B:649:0x02a8, B:651:0x02ab, B:653:0x02b2, B:655:0x02b6, B:657:0x02c0, B:661:0x02c9, B:663:0x02cd, B:665:0x02d6, B:667:0x02dd, B:669:0x02e3, B:671:0x02e7, B:674:0x02f2, B:676:0x02f6, B:678:0x02fa, B:681:0x0305, B:683:0x0309, B:685:0x030d, B:688:0x0318, B:690:0x031c, B:692:0x0320, B:695:0x032f, B:697:0x0333, B:699:0x0337, B:702:0x0345, B:704:0x0349, B:706:0x034d, B:709:0x035c, B:711:0x0360, B:713:0x0364, B:717:0x0371, B:719:0x0375, B:721:0x0379, B:724:0x0384, B:726:0x0391, B:730:0x039b), top: B:895:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:667:0x02dd A[Catch: all -> 0x01c5, Exception -> 0x01cc, TryCatch #20 {Exception -> 0x01cc, all -> 0x01c5, blocks: (B:568:0x01a7, B:571:0x01af, B:573:0x01bb, B:582:0x01d9, B:584:0x01e3, B:587:0x01ed, B:589:0x01f9, B:591:0x01fd, B:594:0x020b, B:596:0x020f, B:597:0x0213, B:599:0x0218, B:601:0x021b, B:603:0x0221, B:605:0x022d, B:607:0x0231, B:610:0x0237, B:613:0x023e, B:615:0x0243, B:618:0x0247, B:620:0x024f, B:622:0x025b, B:624:0x025f, B:627:0x0265, B:629:0x0269, B:630:0x026e, B:632:0x0273, B:634:0x0276, B:635:0x027b, B:637:0x0283, B:639:0x028f, B:641:0x0293, B:644:0x029a, B:646:0x029e, B:647:0x02a3, B:649:0x02a8, B:651:0x02ab, B:653:0x02b2, B:655:0x02b6, B:657:0x02c0, B:661:0x02c9, B:663:0x02cd, B:665:0x02d6, B:667:0x02dd, B:669:0x02e3, B:671:0x02e7, B:674:0x02f2, B:676:0x02f6, B:678:0x02fa, B:681:0x0305, B:683:0x0309, B:685:0x030d, B:688:0x0318, B:690:0x031c, B:692:0x0320, B:695:0x032f, B:697:0x0333, B:699:0x0337, B:702:0x0345, B:704:0x0349, B:706:0x034d, B:709:0x035c, B:711:0x0360, B:713:0x0364, B:717:0x0371, B:719:0x0375, B:721:0x0379, B:724:0x0384, B:726:0x0391, B:730:0x039b), top: B:895:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:716:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:759:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:810:0x049c A[EDGE_INSN: B:810:0x049c->B:793:0x0464 BREAK  A[LOOP:1: B:806:0x0490->B:905:?]] */
    /* JADX WARN: Removed duplicated region for block: B:848:0x053d A[Catch: all -> 0x0550, TRY_ENTER, TryCatch #9 {all -> 0x0550, blocks: (B:845:0x0519, B:848:0x053d, B:858:0x058d, B:860:0x0593, B:861:0x05ab, B:863:0x05af, B:867:0x05b8, B:868:0x05bd, B:852:0x0554, B:854:0x0558, B:856:0x055c, B:857:0x0577), top: B:881:0x0519 }] */
    /* JADX WARN: Removed duplicated region for block: B:851:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:860:0x0593 A[Catch: all -> 0x0550, TryCatch #9 {all -> 0x0550, blocks: (B:845:0x0519, B:848:0x053d, B:858:0x058d, B:860:0x0593, B:861:0x05ab, B:863:0x05af, B:867:0x05b8, B:868:0x05bd, B:852:0x0554, B:854:0x0558, B:856:0x055c, B:857:0x0577), top: B:881:0x0519 }] */
    /* JADX WARN: Removed duplicated region for block: B:863:0x05af A[Catch: all -> 0x0550, TryCatch #9 {all -> 0x0550, blocks: (B:845:0x0519, B:848:0x053d, B:858:0x058d, B:860:0x0593, B:861:0x05ab, B:863:0x05af, B:867:0x05b8, B:868:0x05bd, B:852:0x0554, B:854:0x0558, B:856:0x055c, B:857:0x0577), top: B:881:0x0519 }] */
    /* JADX WARN: Removed duplicated region for block: B:865:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:866:0x05b6  */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m65282A(p381j1.C10664i0 r32, java.lang.Object r33, java.lang.Object r34, java.lang.reflect.Type r35, int r36, boolean r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p381j1.C10666j0.m65282A(j1.i0, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    /* renamed from: B */
    public char m65283B(C10664i0 c10664i0, Object obj, char c10) {
        List<AbstractC10645c> list = c10664i0.f51175b;
        if (list != null) {
            Iterator<AbstractC10645c> it = list.iterator();
            while (it.hasNext()) {
                c10 = it.next().m65193f(c10664i0, obj, c10);
            }
        }
        List<AbstractC10645c> list2 = this.f51175b;
        if (list2 != null) {
            Iterator<AbstractC10645c> it2 = list2.iterator();
            while (it2.hasNext()) {
                c10 = it2.next().m65193f(c10664i0, obj, c10);
            }
        }
        return c10;
    }

    /* renamed from: C */
    public char m65284C(C10664i0 c10664i0, Object obj, char c10) {
        List<AbstractC10667k> list = c10664i0.f51174a;
        if (list != null) {
            Iterator<AbstractC10667k> it = list.iterator();
            while (it.hasNext()) {
                c10 = it.next().m65298f(c10664i0, obj, c10);
            }
        }
        List<AbstractC10667k> list2 = this.f51174a;
        if (list2 != null) {
            Iterator<AbstractC10667k> it2 = list2.iterator();
            while (it2.hasNext()) {
                c10 = it2.next().m65298f(c10664i0, obj, c10);
            }
        }
        return c10;
    }

    /* renamed from: D */
    public void m65285D(C10664i0 c10664i0, String str, Object obj) {
        if (str == null) {
            str = c10664i0.f51257j.f51160c;
        }
        c10664i0.f51258k.m65210C(str, false);
        String name = this.f51273l.f51338b;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (C11603o.m69327w0(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        c10664i0.m65263H(name);
    }

    /* renamed from: E */
    public void m65286E(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws Throwable {
        m65282A(c10664i0, obj, obj2, type, i10, false);
    }

    /* renamed from: F */
    public boolean m65287F(C10664i0 c10664i0, Object obj, int i10) {
        IdentityHashMap<Object, C10696y0> identityHashMap;
        C10696y0 c10696y0 = c10664i0.f51265r;
        int i11 = EnumC10653e1.DisableCircularReferenceDetect.f51248a;
        if (c10696y0 == null || (c10696y0.f51335d & i11) != 0 || (i10 & i11) != 0 || (identityHashMap = c10664i0.f51264q) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        c10664i0.m65265J(obj);
        return true;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws Throwable {
        m65282A(c10664i0, obj, obj2, type, i10, false);
    }

    /* renamed from: q */
    public boolean m65288q(C10664i0 c10664i0, String str) {
        List<InterfaceC10670l0> list = c10664i0.f51180g;
        if (list != null) {
            Iterator<InterfaceC10670l0> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().m65306b(str)) {
                    return false;
                }
            }
        }
        List<InterfaceC10670l0> list2 = this.f51180g;
        if (list2 == null) {
            return true;
        }
        Iterator<InterfaceC10670l0> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().m65306b(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    public Set<String> m65289r(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (C10640a0 c10640a0 : this.f51272k) {
            if (c10640a0.m65177e(obj) != null) {
                hashSet.add(c10640a0.f51134a.f53768a);
            }
        }
        return hashSet;
    }

    /* renamed from: s */
    public C10640a0 m65290s(long j10) {
        EnumC9389m[] enumC9389mArrValues;
        int iBinarySearch;
        if (this.f51274m == null) {
            enumC9389mArrValues = EnumC9389m.values();
            long[] jArr = new long[this.f51272k.length * enumC9389mArrValues.length];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                C10640a0[] c10640a0Arr = this.f51272k;
                if (i10 >= c10640a0Arr.length) {
                    break;
                }
                String str = c10640a0Arr[i10].f51134a.f53768a;
                jArr[i11] = C11603o.m69257I(str);
                i11++;
                for (EnumC9389m enumC9389m : enumC9389mArrValues) {
                    String strM58848b = enumC9389m.m58848b(str);
                    if (!str.equals(strM58848b)) {
                        jArr[i11] = C11603o.m69257I(strM58848b);
                        i11++;
                    }
                }
                i10++;
            }
            Arrays.sort(jArr, 0, i11);
            this.f51274m = new long[i11];
            System.arraycopy(jArr, 0, this.f51274m, 0, i11);
        } else {
            enumC9389mArrValues = null;
        }
        int iBinarySearch2 = Arrays.binarySearch(this.f51274m, j10);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.f51275n == null) {
            if (enumC9389mArrValues == null) {
                enumC9389mArrValues = EnumC9389m.values();
            }
            short[] sArr = new short[this.f51274m.length];
            Arrays.fill(sArr, (short) -1);
            int i12 = 0;
            while (true) {
                C10640a0[] c10640a0Arr2 = this.f51272k;
                if (i12 >= c10640a0Arr2.length) {
                    break;
                }
                String str2 = c10640a0Arr2[i12].f51134a.f53768a;
                int iBinarySearch3 = Arrays.binarySearch(this.f51274m, C11603o.m69257I(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i12;
                }
                for (EnumC9389m enumC9389m2 : enumC9389mArrValues) {
                    String strM58848b2 = enumC9389m2.m58848b(str2);
                    if (!str2.equals(strM58848b2) && (iBinarySearch = Arrays.binarySearch(this.f51274m, C11603o.m69257I(strM58848b2))) >= 0) {
                        sArr[iBinarySearch] = (short) i12;
                    }
                }
                i12++;
            }
            this.f51275n = sArr;
        }
        short s10 = this.f51275n[iBinarySearch2];
        if (s10 != -1) {
            return this.f51272k[s10];
        }
        return null;
    }

    /* renamed from: t */
    public C10640a0 m65291t(String str) {
        if (str == null) {
            return null;
        }
        int length = this.f51272k.length - 1;
        int i10 = 0;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            int iCompareTo = this.f51272k[i11].f51134a.f53768a.compareTo(str);
            if (iCompareTo < 0) {
                i10 = i11 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.f51272k[i11];
                }
                length = i11 - 1;
            }
        }
        return null;
    }

    /* renamed from: u */
    public Object m65292u(Object obj, String str, long j10, boolean z10) {
        C10640a0 c10640a0M65290s = m65290s(j10);
        if (c10640a0M65290s == null) {
            if (!z10) {
                return null;
            }
            throw new C9380d("field not found. " + str);
        }
        try {
            return c10640a0M65290s.m65176b(obj);
        } catch (IllegalAccessException e10) {
            throw new C9380d("getFieldValue error." + str, e10);
        } catch (InvocationTargetException e11) {
            throw new C9380d("getFieldValue error." + str, e11);
        }
    }

    /* renamed from: v */
    public List<Object> m65293v(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.f51272k.length);
        for (C10640a0 c10640a0 : this.f51272k) {
            arrayList.add(c10640a0.m65176b(obj));
        }
        return arrayList;
    }

    /* renamed from: w */
    public Map<String, Object> m65294w(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f51272k.length);
        for (C10640a0 c10640a0 : this.f51272k) {
            boolean zM65242f = EnumC10653e1.m65242f(c10640a0.f51136c, EnumC10653e1.SkipTransientField);
            C11592d c11592d = c10640a0.f51134a;
            if (!zM65242f || c11592d == null || !c11592d.f53782o) {
                if (c11592d.f53786s) {
                    Object objM58772u = AbstractC9377a.m58772u(c10640a0.m65176b(obj));
                    if (objM58772u instanceof Map) {
                        linkedHashMap.putAll((Map) objM58772u);
                    } else {
                        linkedHashMap.put(c10640a0.f51134a.f53768a, c10640a0.m65176b(obj));
                    }
                } else {
                    linkedHashMap.put(c11592d.f53768a, c10640a0.m65176b(obj));
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: x */
    public InterfaceC9643d m65295x() {
        return this.f51273l.f51340d;
    }

    /* renamed from: y */
    public int m65296y(Object obj) throws Exception {
        int i10 = 0;
        for (C10640a0 c10640a0 : this.f51272k) {
            if (c10640a0.m65177e(obj) != null) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: z */
    public boolean m65297z(C10664i0 c10664i0, int i10) {
        int i11 = EnumC10653e1.BeanToArray.f51248a;
        return ((this.f51273l.f51343g & i11) == 0 && !c10664i0.f51258k.f51203i && (i10 & i11) == 0) ? false : true;
    }
}
