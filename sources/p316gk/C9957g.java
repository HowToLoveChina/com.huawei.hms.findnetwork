package p316gk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import p316gk.C9957g;

/* renamed from: gk.g */
/* loaded from: classes6.dex */
public class C9957g {

    /* renamed from: a */
    public Map<String, b> f48757a;

    /* renamed from: b */
    public a[] f48758b;

    /* renamed from: gk.g$a */
    public static class a {

        /* renamed from: d */
        public static final Comparator<a> f48759d = new Comparator() { // from class: gk.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C9957g.a.m61764c((C9957g.a) obj, (C9957g.a) obj2);
            }
        };

        /* renamed from: a */
        public final String f48760a;

        /* renamed from: b */
        public final int f48761b;

        /* renamed from: c */
        public final int f48762c;

        public a(String str, int i10) {
            this.f48760a = str;
            this.f48761b = i10;
            this.f48762c = str.length();
        }

        /* renamed from: c */
        public static /* synthetic */ int m61764c(a aVar, a aVar2) {
            return Integer.compare(aVar2 != null ? aVar2.f48762c : Integer.MIN_VALUE, aVar != null ? aVar.f48762c : Integer.MIN_VALUE);
        }

        /* renamed from: b */
        public String m61765b() {
            return this.f48760a;
        }

        /* renamed from: d */
        public int m61766d() {
            return this.f48761b;
        }
    }

    /* renamed from: gk.g$b */
    public static class b {

        /* renamed from: a */
        public String f48763a;

        /* renamed from: b */
        public String f48764b;

        public b(String str, String str2) {
            this.f48763a = str;
            this.f48764b = str2;
        }

        /* renamed from: a */
        public String m61767a() {
            return this.f48763a;
        }

        /* renamed from: b */
        public String m61768b() {
            return this.f48764b;
        }
    }

    public C9957g(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        if (strArr4 != null && (strArr4.length & 1) != 0) {
            throw new IllegalArgumentException("quote marks must be pair.");
        }
        ArrayList arrayList = new ArrayList();
        if (!C9951a.m61736a(strArr)) {
            for (String str : strArr) {
                arrayList.add(new a(str, 1));
            }
        }
        if (!C9951a.m61736a(strArr2)) {
            for (String str2 : strArr2) {
                arrayList.add(new a(str2, 2));
            }
        }
        if (!C9951a.m61736a(strArr3)) {
            for (String str3 : strArr3) {
                arrayList.add(new a(str3, 3));
            }
        }
        HashMap map = new HashMap();
        if (!C9951a.m61736a(strArr4)) {
            HashSet hashSet = new HashSet();
            int length = strArr4.length / 2;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                String str4 = strArr4[i11];
                String str5 = strArr4[i11 + 1];
                hashSet.add(str4);
                hashSet.add(str5);
                if (map.put(str4, new b(str4, str5)) != null) {
                    throw new IllegalArgumentException("duplicate quote marks : " + str4);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                arrayList.add(new a((String) it.next(), 4));
            }
        }
        this.f48757a = map;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        Arrays.sort(aVarArr, a.f48759d);
        this.f48758b = aVarArr;
    }

    /* renamed from: a */
    public final String m61757a(LinkedList<c> linkedList) {
        while (!linkedList.isEmpty()) {
            c cVarRemoveFirst = linkedList.removeFirst();
            int iM61769a = cVarRemoveFirst.m61769a();
            if (iM61769a == 1) {
                return cVarRemoveFirst.m61770b();
            }
            if (iM61769a != 2) {
                return iM61769a != 4 ? m61759c(cVarRemoveFirst, linkedList) : m61758b(linkedList, this.f48757a.get(cVarRemoveFirst.m61770b()));
            }
        }
        return null;
    }

    /* renamed from: b */
    public final String m61758b(LinkedList<c> linkedList, b bVar) {
        String strM61768b = bVar.m61768b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bVar.m61767a());
        while (!strM61768b.equals(linkedList.getFirst().m61770b())) {
            sb2.append(linkedList.removeFirst().m61770b());
        }
        sb2.append(linkedList.removeFirst().m61770b());
        return sb2.toString();
    }

    /* renamed from: c */
    public final String m61759c(c cVar, LinkedList<c> linkedList) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.m61770b());
        while (!linkedList.isEmpty()) {
            c first = linkedList.getFirst();
            if ((3 != cVar.m61769a() || (first.m61769a() != 0 && 3 != first.m61769a())) && (cVar.m61769a() != 0 || 3 != first.m61769a())) {
                break;
            }
            linkedList.removeFirst();
            sb2.append(first.m61770b());
            cVar = first;
        }
        return sb2.toString();
    }

    /* renamed from: d */
    public C9959i m61760d(String str) {
        return new C9959i(m61761e(str));
    }

    /* renamed from: e */
    public final Queue<String> m61761e(String str) throws C9952b {
        try {
            LinkedList<c> linkedListM61762f = m61762f(str);
            LinkedList linkedList = new LinkedList();
            while (true) {
                String strM61757a = m61757a(linkedListM61762f);
                if (strM61757a == null) {
                    return linkedList;
                }
                linkedList.add(strM61757a);
            }
        } catch (Exception e10) {
            throw new C9952b(e10);
        }
    }

    /* renamed from: f */
    public final LinkedList<c> m61762f(String str) {
        LinkedList<c> linkedList = new LinkedList<>();
        linkedList.add(new c(str));
        LinkedList<c> linkedList2 = new LinkedList<>();
        a[] aVarArr = this.f48758b;
        int length = aVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            a aVar = aVarArr[i10];
            Iterator<c> it = linkedList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.m61769a() != 0) {
                    linkedList2.add(next);
                } else {
                    String strM61765b = aVar.m61765b();
                    String strM61770b = next.m61770b();
                    int length2 = 0;
                    while (true) {
                        int iIndexOf = strM61770b.indexOf(strM61765b, length2);
                        if (iIndexOf < 0) {
                            break;
                        }
                        if (iIndexOf > 0) {
                            linkedList2.add(new c(strM61770b.substring(length2, iIndexOf)));
                        }
                        linkedList2.add(new c(strM61770b.substring(iIndexOf, strM61765b.length() + iIndexOf), aVar.m61766d()));
                        length2 = strM61765b.length() + iIndexOf;
                    }
                    if (length2 < strM61770b.length()) {
                        linkedList2.add(new c(strM61770b.substring(length2)));
                    }
                }
            }
            i10++;
            linkedList = linkedList2;
            linkedList2 = new LinkedList<>();
        }
        return linkedList;
    }

    /* renamed from: gk.g$c */
    public static class c {

        /* renamed from: a */
        public final String f48765a;

        /* renamed from: b */
        public final int f48766b;

        public c(String str) {
            this(str, 0);
        }

        /* renamed from: a */
        public int m61769a() {
            return this.f48766b;
        }

        /* renamed from: b */
        public String m61770b() {
            return this.f48765a;
        }

        public c(String str, int i10) {
            this.f48765a = str;
            this.f48766b = i10;
        }
    }
}
