package p244e1;

import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import p323h1.C10085i;
import p381j1.C10640a0;
import p381j1.C10641a1;
import p381j1.C10666j0;
import p381j1.InterfaceC10686t0;
import p481n1.C11603o;

/* renamed from: e1.g */
/* loaded from: classes.dex */
public class C9383g implements InterfaceC9379c {

    /* renamed from: g */
    public static ConcurrentMap<String, C9383g> f46797g = new ConcurrentHashMap(128, 0.75f, 1);

    /* renamed from: a */
    public final String f46798a;

    /* renamed from: b */
    public b0[] f46799b;

    /* renamed from: c */
    public boolean f46800c;

    /* renamed from: d */
    public C10641a1 f46801d;

    /* renamed from: e */
    public C10085i f46802e;

    /* renamed from: f */
    public boolean f46803f;

    /* renamed from: e1.g$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f46804a;

        static {
            int[] iArr = new int[u.values().length];
            f46804a = iArr;
            try {
                iArr[u.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46804a[u.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46804a[u.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46804a[u.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46804a[u.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46804a[u.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: e1.g$a0 */
    public static class a0 extends v {

        /* renamed from: f */
        public final Pattern f46805f;

        /* renamed from: g */
        public final boolean f46806g;

        public a0(String str, boolean z10, String str2, boolean z11) {
            super(str, z10);
            this.f46805f = Pattern.compile(str2);
            this.f46806g = z11;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null) {
                return false;
            }
            boolean zMatches = this.f46805f.matcher(objM58838b.toString()).matches();
            return this.f46806g ? !zMatches : zMatches;
        }
    }

    /* renamed from: e1.g$b */
    public static class b implements b0 {

        /* renamed from: a */
        public final int f46807a;

        public b(int i10) {
            this.f46807a = i10;
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            return c9383g.m58808i(obj2, this.f46807a);
        }
    }

    /* renamed from: e1.g$b0 */
    public interface b0 {
        /* renamed from: a */
        Object mo58815a(C9383g c9383g, Object obj, Object obj2);
    }

    /* renamed from: e1.g$c */
    public static class c extends v {

        /* renamed from: f */
        public final double f46808f;

        /* renamed from: g */
        public final u f46809g;

        public c(String str, boolean z10, double d10, u uVar) {
            super(str, z10);
            this.f46808f = d10;
            this.f46809g = uVar;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null || !(objM58838b instanceof Number)) {
                return false;
            }
            double dDoubleValue = ((Number) objM58838b).doubleValue();
            switch (a.f46804a[this.f46809g.ordinal()]) {
                case 1:
                    if (dDoubleValue == this.f46808f) {
                        break;
                    }
                    break;
                case 2:
                    if (dDoubleValue != this.f46808f) {
                        break;
                    }
                    break;
                case 3:
                    if (dDoubleValue >= this.f46808f) {
                        break;
                    }
                    break;
                case 4:
                    if (dDoubleValue > this.f46808f) {
                        break;
                    }
                    break;
                case 5:
                    if (dDoubleValue <= this.f46808f) {
                        break;
                    }
                    break;
                case 6:
                    if (dDoubleValue < this.f46808f) {
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    /* renamed from: e1.g$c0 */
    public static class c0 implements b0 {

        /* renamed from: a */
        public static final c0 f46810a = new c0();

        @Override // p244e1.C9383g.b0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer mo58815a(C9383g c9383g, Object obj, Object obj2) {
            return Integer.valueOf(c9383g.m58807h(obj2));
        }
    }

    /* renamed from: e1.g$d */
    public interface d {
        /* renamed from: a */
        boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3);
    }

    /* renamed from: e1.g$d0 */
    public static class d0 extends v {

        /* renamed from: f */
        public final String[] f46811f;

        /* renamed from: g */
        public final boolean f46812g;

        public d0(String str, boolean z10, String[] strArr, boolean z11) {
            super(str, z10);
            this.f46811f = strArr;
            this.f46812g = z11;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            for (String str : this.f46811f) {
                if (str == objM58838b) {
                    return !this.f46812g;
                }
                if (str != null && str.equals(objM58838b)) {
                    return !this.f46812g;
                }
            }
            return this.f46812g;
        }
    }

    /* renamed from: e1.g$e */
    public static class e implements d {

        /* renamed from: a */
        public boolean f46813a;

        /* renamed from: b */
        public List<d> f46814b;

        public e(d dVar, d dVar2, boolean z10) {
            ArrayList arrayList = new ArrayList(2);
            this.f46814b = arrayList;
            arrayList.add(dVar);
            this.f46814b.add(dVar2);
            this.f46813a = z10;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            if (this.f46813a) {
                Iterator<d> it = this.f46814b.iterator();
                while (it.hasNext()) {
                    if (!it.next().mo58814a(c9383g, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<d> it2 = this.f46814b.iterator();
            while (it2.hasNext()) {
                if (it2.next().mo58814a(c9383g, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: e1.g$e0 */
    public static class e0 extends v {

        /* renamed from: f */
        public final String f46815f;

        /* renamed from: g */
        public final u f46816g;

        public e0(String str, boolean z10, String str2, u uVar) {
            super(str, z10);
            this.f46815f = str2;
            this.f46816g = uVar;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            u uVar = this.f46816g;
            if (uVar == u.EQ) {
                return this.f46815f.equals(objM58838b);
            }
            if (uVar == u.NE) {
                return !this.f46815f.equals(objM58838b);
            }
            if (objM58838b == null) {
                return false;
            }
            int iCompareTo = this.f46815f.compareTo(objM58838b.toString());
            u uVar2 = this.f46816g;
            return uVar2 == u.GE ? iCompareTo <= 0 : uVar2 == u.GT ? iCompareTo < 0 : uVar2 == u.LE ? iCompareTo >= 0 : uVar2 == u.LT && iCompareTo > 0;
        }
    }

    /* renamed from: e1.g$f */
    public static class f implements b0 {

        /* renamed from: a */
        public final d f46817a;

        public f(d dVar) {
            this.f46817a = dVar;
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            C9378b c9378b = new C9378b();
            if (!(obj2 instanceof Iterable)) {
                if (this.f46817a.mo58814a(c9383g, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.f46817a.mo58814a(c9383g, obj, obj2, obj3)) {
                    c9378b.add(obj3);
                }
            }
            return c9378b;
        }
    }

    /* renamed from: e1.g$f0 */
    public static class f0 implements b0 {

        /* renamed from: a */
        public static final f0 f46818a = new f0();

        @Override // p244e1.C9383g.b0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String mo58815a(C9383g c9383g, Object obj, Object obj2) {
            return obj2 == null ? "null" : obj2 instanceof Collection ? "array" : obj2 instanceof Number ? "number" : obj2 instanceof Boolean ? "boolean" : ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) ? ExtractOWiFiHelper.STING_NODE : "object";
        }
    }

    /* renamed from: e1.g$g */
    public static class g implements b0 {

        /* renamed from: a */
        public static final g f46819a = new g();

        /* renamed from: b */
        public static Object m58818b(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                return Double.valueOf(Math.floor(((Float) obj).floatValue()));
            }
            if (obj instanceof Double) {
                return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
            }
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            if (!(obj2 instanceof C9378b)) {
                return m58818b(obj2);
            }
            C9378b c9378b = (C9378b) ((C9378b) obj2).clone();
            for (int i10 = 0; i10 < c9378b.size(); i10++) {
                Object obj3 = c9378b.get(i10);
                Object objM58818b = m58818b(obj3);
                if (objM58818b != obj3) {
                    c9378b.set(i10, objM58818b);
                }
            }
            return c9378b;
        }
    }

    /* renamed from: e1.g$g0 */
    public static class g0 extends v {

        /* renamed from: f */
        public final Object f46820f;

        /* renamed from: g */
        public boolean f46821g;

        public g0(String str, boolean z10, Object obj, boolean z11) {
            super(str, z10);
            this.f46821g = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.f46820f = obj;
            this.f46821g = z11;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            boolean zEquals = this.f46820f.equals(m58838b(c9383g, obj, obj3));
            return !this.f46821g ? !zEquals : zEquals;
        }
    }

    /* renamed from: e1.g$h */
    public static class h extends v {

        /* renamed from: f */
        public final long f46822f;

        /* renamed from: g */
        public final long f46823g;

        /* renamed from: h */
        public final boolean f46824h;

        public h(String str, boolean z10, long j10, long j11, boolean z11) {
            super(str, z10);
            this.f46822f = j10;
            this.f46823g = j11;
            this.f46824h = z11;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null) {
                return false;
            }
            if (objM58838b instanceof Number) {
                long jM69246C0 = C11603o.m69246C0((Number) objM58838b);
                if (jM69246C0 >= this.f46822f && jM69246C0 <= this.f46823g) {
                    return !this.f46824h;
                }
            }
            return this.f46824h;
        }
    }

    /* renamed from: e1.g$h0 */
    public static class h0 implements b0 {

        /* renamed from: c */
        public static final h0 f46825c = new h0(false, false);

        /* renamed from: d */
        public static final h0 f46826d = new h0(true, false);

        /* renamed from: e */
        public static final h0 f46827e = new h0(true, true);

        /* renamed from: a */
        public boolean f46828a;

        /* renamed from: b */
        public boolean f46829b;

        public h0(boolean z10, boolean z11) {
            this.f46828a = z10;
            this.f46829b = z11;
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            if (!this.f46828a) {
                return c9383g.m58811l(obj2);
            }
            ArrayList arrayList = new ArrayList();
            c9383g.m58803d(obj2, arrayList);
            return arrayList;
        }
    }

    /* renamed from: e1.g$i */
    public static class i extends v {

        /* renamed from: f */
        public final long[] f46830f;

        /* renamed from: g */
        public final boolean f46831g;

        public i(String str, boolean z10, long[] jArr, boolean z11) {
            super(str, z10);
            this.f46830f = jArr;
            this.f46831g = z11;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null) {
                return false;
            }
            if (objM58838b instanceof Number) {
                long jM69246C0 = C11603o.m69246C0((Number) objM58838b);
                for (long j10 : this.f46830f) {
                    if (j10 == jM69246C0) {
                        return !this.f46831g;
                    }
                }
            }
            return this.f46831g;
        }
    }

    /* renamed from: e1.g$j */
    public static class j extends v {

        /* renamed from: f */
        public final Long[] f46832f;

        /* renamed from: g */
        public final boolean f46833g;

        public j(String str, boolean z10, Long[] lArr, boolean z11) {
            super(str, z10);
            this.f46832f = lArr;
            this.f46833g = z11;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            int i10 = 0;
            if (objM58838b == null) {
                Long[] lArr = this.f46832f;
                int length = lArr.length;
                while (i10 < length) {
                    if (lArr[i10] == null) {
                        return !this.f46833g;
                    }
                    i10++;
                }
                return this.f46833g;
            }
            if (objM58838b instanceof Number) {
                long jM69246C0 = C11603o.m69246C0((Number) objM58838b);
                Long[] lArr2 = this.f46832f;
                int length2 = lArr2.length;
                while (i10 < length2) {
                    Long l10 = lArr2[i10];
                    if (l10 != null && l10.longValue() == jM69246C0) {
                        return !this.f46833g;
                    }
                    i10++;
                }
            }
            return this.f46833g;
        }
    }

    /* renamed from: e1.g$k */
    public static class k extends v {

        /* renamed from: f */
        public final long f46834f;

        /* renamed from: g */
        public final u f46835g;

        /* renamed from: h */
        public BigDecimal f46836h;

        /* renamed from: i */
        public Float f46837i;

        /* renamed from: j */
        public Double f46838j;

        public k(String str, boolean z10, long j10, u uVar) {
            super(str, z10);
            this.f46834f = j10;
            this.f46835g = uVar;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null || !(objM58838b instanceof Number)) {
                return false;
            }
            if (objM58838b instanceof BigDecimal) {
                if (this.f46836h == null) {
                    this.f46836h = BigDecimal.valueOf(this.f46834f);
                }
                int iCompareTo = this.f46836h.compareTo((BigDecimal) objM58838b);
                switch (a.f46804a[this.f46835g.ordinal()]) {
                    case 1:
                        if (iCompareTo == 0) {
                            break;
                        }
                        break;
                    case 2:
                        if (iCompareTo != 0) {
                            break;
                        }
                        break;
                    case 3:
                        if (iCompareTo <= 0) {
                            break;
                        }
                        break;
                    case 4:
                        if (iCompareTo < 0) {
                            break;
                        }
                        break;
                    case 5:
                        if (iCompareTo >= 0) {
                            break;
                        }
                        break;
                    case 6:
                        if (iCompareTo > 0) {
                            break;
                        }
                        break;
                }
                return false;
            }
            if (objM58838b instanceof Float) {
                if (this.f46837i == null) {
                    this.f46837i = Float.valueOf(this.f46834f);
                }
                int iCompareTo2 = this.f46837i.compareTo((Float) objM58838b);
                switch (a.f46804a[this.f46835g.ordinal()]) {
                    case 1:
                        if (iCompareTo2 == 0) {
                            break;
                        }
                        break;
                    case 2:
                        if (iCompareTo2 != 0) {
                            break;
                        }
                        break;
                    case 3:
                        if (iCompareTo2 <= 0) {
                            break;
                        }
                        break;
                    case 4:
                        if (iCompareTo2 < 0) {
                            break;
                        }
                        break;
                    case 5:
                        if (iCompareTo2 >= 0) {
                            break;
                        }
                        break;
                    case 6:
                        if (iCompareTo2 > 0) {
                            break;
                        }
                        break;
                }
                return false;
            }
            if (!(objM58838b instanceof Double)) {
                long jM69246C0 = C11603o.m69246C0((Number) objM58838b);
                switch (a.f46804a[this.f46835g.ordinal()]) {
                    case 1:
                        if (jM69246C0 == this.f46834f) {
                            break;
                        }
                        break;
                    case 2:
                        if (jM69246C0 != this.f46834f) {
                            break;
                        }
                        break;
                    case 3:
                        if (jM69246C0 >= this.f46834f) {
                            break;
                        }
                        break;
                    case 4:
                        if (jM69246C0 > this.f46834f) {
                            break;
                        }
                        break;
                    case 5:
                        if (jM69246C0 <= this.f46834f) {
                            break;
                        }
                        break;
                    case 6:
                        if (jM69246C0 < this.f46834f) {
                            break;
                        }
                        break;
                }
                return false;
            }
            if (this.f46838j == null) {
                this.f46838j = Double.valueOf(this.f46834f);
            }
            int iCompareTo3 = this.f46838j.compareTo((Double) objM58838b);
            switch (a.f46804a[this.f46835g.ordinal()]) {
                case 1:
                    if (iCompareTo3 == 0) {
                        break;
                    }
                    break;
                case 2:
                    if (iCompareTo3 != 0) {
                        break;
                    }
                    break;
                case 3:
                    if (iCompareTo3 <= 0) {
                        break;
                    }
                    break;
                case 4:
                    if (iCompareTo3 < 0) {
                        break;
                    }
                    break;
                case 5:
                    if (iCompareTo3 >= 0) {
                        break;
                    }
                    break;
                case 6:
                    if (iCompareTo3 > 0) {
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    /* renamed from: e1.g$l */
    public static class l {

        /* renamed from: f */
        public static final Pattern f46839f = Pattern.compile("'\\s*,\\s*'");

        /* renamed from: a */
        public final String f46840a;

        /* renamed from: b */
        public int f46841b;

        /* renamed from: c */
        public char f46842c;

        /* renamed from: d */
        public int f46843d;

        /* renamed from: e */
        public boolean f46844e;

        public l(String str) {
            this.f46840a = str;
            m58827i();
        }

        /* renamed from: g */
        public static boolean m58820g(char c10) {
            return c10 == '-' || c10 == '+' || (c10 >= '0' && c10 <= '9');
        }

        /* renamed from: a */
        public void m58821a(char c10) {
            if (this.f46842c == ' ') {
                m58827i();
            }
            if (this.f46842c == c10) {
                if (m58826h()) {
                    return;
                }
                m58827i();
            } else {
                throw new C9384h("expect '" + c10 + ", but '" + this.f46842c + "'");
            }
        }

        /* renamed from: c */
        public b0 m58822c(String str) {
            int length = str.length();
            char cCharAt = str.charAt(0);
            int i10 = length - 1;
            char cCharAt2 = str.charAt(i10);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                String strSubstring = str.substring(1, i10);
                return (iIndexOf == -1 || !f46839f.matcher(str).find()) ? new w(strSubstring, false) : new r(strSubstring.split("'\\s*,\\s*'"));
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                if (C11603o.m69323u0(str)) {
                    try {
                        return new b(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new w(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new w(str, false);
            }
            if (iIndexOf != -1) {
                String[] strArrSplit = str.split(",");
                int[] iArr = new int[strArrSplit.length];
                for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                    iArr[i11] = Integer.parseInt(strArrSplit[i11]);
                }
                return new q(iArr);
            }
            if (iIndexOf2 == -1) {
                throw new UnsupportedOperationException();
            }
            String[] strArrSplit2 = str.split(":");
            int length2 = strArrSplit2.length;
            int[] iArr2 = new int[length2];
            for (int i12 = 0; i12 < strArrSplit2.length; i12++) {
                String str2 = strArrSplit2[i12];
                if (str2.length() != 0) {
                    iArr2[i12] = Integer.parseInt(str2);
                } else {
                    if (i12 != 0) {
                        throw new UnsupportedOperationException();
                    }
                    iArr2[i12] = 0;
                }
            }
            int i13 = iArr2[0];
            int i14 = length2 > 1 ? iArr2[1] : -1;
            int i15 = length2 == 3 ? iArr2[2] : 1;
            if (i14 < 0 || i14 >= i13) {
                if (i15 > 0) {
                    return new x(i13, i14, i15);
                }
                throw new UnsupportedOperationException("step must greater than zero : " + i15);
            }
            throw new UnsupportedOperationException("end must greater than or equals start. start " + i13 + ",  end " + i14);
        }

        /* renamed from: d */
        public b0[] m58823d() {
            String str = this.f46840a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            b0[] b0VarArr = new b0[8];
            while (true) {
                b0 b0VarM58834p = m58834p();
                if (b0VarM58834p == null) {
                    break;
                }
                if (b0VarM58834p instanceof w) {
                    w wVar = (w) b0VarM58834p;
                    if (wVar.f46881c || !wVar.f46879a.equals("*")) {
                    }
                }
                int i10 = this.f46843d;
                if (i10 == b0VarArr.length) {
                    b0[] b0VarArr2 = new b0[(i10 * 3) / 2];
                    System.arraycopy(b0VarArr, 0, b0VarArr2, 0, i10);
                    b0VarArr = b0VarArr2;
                }
                int i11 = this.f46843d;
                this.f46843d = i11 + 1;
                b0VarArr[i11] = b0VarM58834p;
            }
            int i12 = this.f46843d;
            if (i12 == b0VarArr.length) {
                return b0VarArr;
            }
            b0[] b0VarArr3 = new b0[i12];
            System.arraycopy(b0VarArr, 0, b0VarArr3, 0, i12);
            return b0VarArr3;
        }

        /* renamed from: e */
        public d m58824e(d dVar) {
            char c10 = this.f46842c;
            boolean z10 = true;
            boolean z11 = c10 == '&';
            if ((c10 != '&' || m58825f() != '&') && (this.f46842c != '|' || m58825f() != '|')) {
                return dVar;
            }
            m58827i();
            m58827i();
            if (this.f46842c == '(') {
                m58827i();
            } else {
                z10 = false;
            }
            while (this.f46842c == ' ') {
                m58827i();
            }
            e eVar = new e(dVar, (d) m58829k(false), z11);
            if (z10 && this.f46842c == ')') {
                m58827i();
            }
            return eVar;
        }

        /* renamed from: f */
        public char m58825f() {
            return this.f46840a.charAt(this.f46841b);
        }

        /* renamed from: h */
        public boolean m58826h() {
            return this.f46841b >= this.f46840a.length();
        }

        /* renamed from: i */
        public void m58827i() {
            String str = this.f46840a;
            int i10 = this.f46841b;
            this.f46841b = i10 + 1;
            this.f46842c = str.charAt(i10);
        }

        /* renamed from: j */
        public b0 m58828j(boolean z10) {
            Object objM58829k = m58829k(z10);
            return objM58829k instanceof b0 ? (b0) objM58829k : new f((d) objM58829k);
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0119  */
        /* renamed from: k */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object m58829k(boolean r27) {
            /*
                Method dump skipped, instructions count: 1834
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p244e1.C9383g.l.m58829k(boolean):java.lang.Object");
        }

        /* renamed from: l */
        public double m58830l(long j10) {
            int i10 = this.f46841b - 1;
            m58827i();
            while (true) {
                char c10 = this.f46842c;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                m58827i();
            }
            return Double.parseDouble(this.f46840a.substring(i10, this.f46841b - 1)) + j10;
        }

        /* renamed from: m */
        public long m58831m() {
            int i10 = this.f46841b - 1;
            char c10 = this.f46842c;
            if (c10 == '+' || c10 == '-') {
                m58827i();
            }
            while (true) {
                char c11 = this.f46842c;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                m58827i();
            }
            return Long.parseLong(this.f46840a.substring(i10, this.f46841b - 1));
        }

        /* renamed from: n */
        public String m58832n() {
            m58837s();
            char c10 = this.f46842c;
            if (c10 != '\\' && !Character.isJavaIdentifierStart(c10)) {
                throw new C9384h("illeal jsonpath syntax. " + this.f46840a);
            }
            StringBuilder sb2 = new StringBuilder();
            while (!m58826h()) {
                char c11 = this.f46842c;
                if (c11 == '\\') {
                    m58827i();
                    sb2.append(this.f46842c);
                    if (m58826h()) {
                        return sb2.toString();
                    }
                    m58827i();
                } else {
                    if (!Character.isJavaIdentifierPart(c11)) {
                        break;
                    }
                    sb2.append(this.f46842c);
                    m58827i();
                }
            }
            if (m58826h() && Character.isJavaIdentifierPart(this.f46842c)) {
                sb2.append(this.f46842c);
            }
            return sb2.toString();
        }

        /* renamed from: o */
        public u m58833o() {
            u uVar;
            char c10 = this.f46842c;
            if (c10 == '=') {
                m58827i();
                char c11 = this.f46842c;
                if (c11 == '~') {
                    m58827i();
                    uVar = u.REG_MATCH;
                } else if (c11 == '=') {
                    m58827i();
                    uVar = u.EQ;
                } else {
                    uVar = u.EQ;
                }
            } else if (c10 == '!') {
                m58827i();
                m58821a('=');
                uVar = u.NE;
            } else if (c10 == '<') {
                m58827i();
                if (this.f46842c == '=') {
                    m58827i();
                    uVar = u.LE;
                } else {
                    uVar = u.LT;
                }
            } else if (c10 == '>') {
                m58827i();
                if (this.f46842c == '=') {
                    m58827i();
                    uVar = u.GE;
                } else {
                    uVar = u.GT;
                }
            } else {
                uVar = null;
            }
            if (uVar != null) {
                return uVar;
            }
            String strM58832n = m58832n();
            if ("not".equalsIgnoreCase(strM58832n)) {
                m58837s();
                String strM58832n2 = m58832n();
                if ("like".equalsIgnoreCase(strM58832n2)) {
                    return u.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(strM58832n2)) {
                    return u.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(strM58832n2)) {
                    return u.NOT_IN;
                }
                if ("between".equalsIgnoreCase(strM58832n2)) {
                    return u.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(strM58832n)) {
                return u.NOT_IN;
            }
            if ("like".equalsIgnoreCase(strM58832n)) {
                return u.LIKE;
            }
            if ("rlike".equalsIgnoreCase(strM58832n)) {
                return u.RLIKE;
            }
            if ("in".equalsIgnoreCase(strM58832n)) {
                return u.IN;
            }
            if ("between".equalsIgnoreCase(strM58832n)) {
                return u.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        /* renamed from: p */
        public b0 m58834p() {
            boolean z10;
            if (this.f46843d == 0 && this.f46840a.length() == 1) {
                if (m58820g(this.f46842c)) {
                    return new b(this.f46842c - '0');
                }
                char c10 = this.f46842c;
                if ((c10 >= 'a' && c10 <= 'z') || (c10 >= 'A' && c10 <= 'Z')) {
                    return new w(Character.toString(c10), false);
                }
            }
            while (!m58826h()) {
                m58837s();
                char c11 = this.f46842c;
                if (c11 != '$') {
                    if (c11 != '.' && c11 != '/') {
                        if (c11 == '[') {
                            return m58828j(true);
                        }
                        if (this.f46843d == 0) {
                            return new w(m58832n(), false);
                        }
                        if (c11 == '?') {
                            return new f((d) m58829k(false));
                        }
                        throw new C9384h("not support jsonpath : " + this.f46840a);
                    }
                    m58827i();
                    if (c11 == '.' && this.f46842c == '.') {
                        m58827i();
                        int length = this.f46840a.length();
                        int i10 = this.f46841b;
                        if (length > i10 + 3 && this.f46842c == '[' && this.f46840a.charAt(i10) == '*' && this.f46840a.charAt(this.f46841b + 1) == ']' && this.f46840a.charAt(this.f46841b + 2) == '.') {
                            m58827i();
                            m58827i();
                            m58827i();
                            m58827i();
                        }
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    char c12 = this.f46842c;
                    if (c12 == '*' || (z10 && c12 == '[')) {
                        boolean z11 = c12 == '[';
                        if (!m58826h()) {
                            m58827i();
                        }
                        return z10 ? z11 ? h0.f46827e : h0.f46826d : h0.f46825c;
                    }
                    if (m58820g(c12)) {
                        return m58828j(false);
                    }
                    String strM58832n = m58832n();
                    if (this.f46842c != '(') {
                        return new w(strM58832n, z10);
                    }
                    m58827i();
                    if (this.f46842c != ')') {
                        throw new C9384h("not support jsonpath : " + this.f46840a);
                    }
                    if (!m58826h()) {
                        m58827i();
                    }
                    if ("size".equals(strM58832n) || "length".equals(strM58832n)) {
                        return c0.f46810a;
                    }
                    if ("max".equals(strM58832n)) {
                        return o.f46851a;
                    }
                    if ("min".equals(strM58832n)) {
                        return p.f46852a;
                    }
                    if ("keySet".equals(strM58832n)) {
                        return m.f46845a;
                    }
                    if ("type".equals(strM58832n)) {
                        return f0.f46818a;
                    }
                    if ("floor".equals(strM58832n)) {
                        return g.f46819a;
                    }
                    throw new C9384h("not support jsonpath : " + this.f46840a);
                }
                m58827i();
                m58837s();
                if (this.f46842c == '?') {
                    return new f((d) m58829k(false));
                }
            }
            return null;
        }

        /* renamed from: q */
        public String m58835q() {
            char c10 = this.f46842c;
            m58827i();
            int i10 = this.f46841b - 1;
            while (this.f46842c != c10 && !m58826h()) {
                m58827i();
            }
            String strSubstring = this.f46840a.substring(i10, m58826h() ? this.f46841b : this.f46841b - 1);
            m58821a(c10);
            return strSubstring;
        }

        /* renamed from: r */
        public Object m58836r() {
            m58837s();
            if (m58820g(this.f46842c)) {
                return Long.valueOf(m58831m());
            }
            char c10 = this.f46842c;
            if (c10 == '\"' || c10 == '\'') {
                return m58835q();
            }
            if (c10 != 'n') {
                throw new UnsupportedOperationException();
            }
            if ("null".equals(m58832n())) {
                return null;
            }
            throw new C9384h(this.f46840a);
        }

        /* renamed from: s */
        public final void m58837s() {
            while (true) {
                char c10 = this.f46842c;
                if (c10 > ' ') {
                    return;
                }
                if (c10 != ' ' && c10 != '\r' && c10 != '\n' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                    return;
                } else {
                    m58827i();
                }
            }
        }
    }

    /* renamed from: e1.g$m */
    public static class m implements b0 {

        /* renamed from: a */
        public static final m f46845a = new m();

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            return c9383g.m58806g(obj2);
        }
    }

    /* renamed from: e1.g$n */
    public static class n extends v {

        /* renamed from: f */
        public final String f46846f;

        /* renamed from: g */
        public final String f46847g;

        /* renamed from: h */
        public final String[] f46848h;

        /* renamed from: i */
        public final int f46849i;

        /* renamed from: j */
        public final boolean f46850j;

        public n(String str, boolean z10, String str2, String str3, String[] strArr, boolean z11) {
            super(str, z10);
            this.f46846f = str2;
            this.f46847g = str3;
            this.f46848h = strArr;
            this.f46850j = z11;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.f46849i = length;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            int length;
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null) {
                return false;
            }
            String string = objM58838b.toString();
            if (string.length() < this.f46849i) {
                return this.f46850j;
            }
            String str = this.f46846f;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.f46850j;
                }
                length = this.f46846f.length();
            }
            String[] strArr = this.f46848h;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.f46850j;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            String str3 = this.f46847g;
            return (str3 == null || string.endsWith(str3)) ? !this.f46850j : this.f46850j;
        }
    }

    /* renamed from: e1.g$o */
    public static class o implements b0 {

        /* renamed from: a */
        public static final o f46851a = new o();

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || C9383g.m58800a(obj3, obj4) < 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    /* renamed from: e1.g$p */
    public static class p implements b0 {

        /* renamed from: a */
        public static final p f46852a = new p();

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || C9383g.m58800a(obj3, obj4) > 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    /* renamed from: e1.g$q */
    public static class q implements b0 {

        /* renamed from: a */
        public final int[] f46853a;

        public q(int[] iArr) {
            this.f46853a = iArr;
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            C9378b c9378b = new C9378b(this.f46853a.length);
            int i10 = 0;
            while (true) {
                int[] iArr = this.f46853a;
                if (i10 >= iArr.length) {
                    return c9378b;
                }
                c9378b.add(c9383g.m58808i(obj2, iArr[i10]));
                i10++;
            }
        }
    }

    /* renamed from: e1.g$r */
    public static class r implements b0 {

        /* renamed from: a */
        public final String[] f46854a;

        /* renamed from: b */
        public final long[] f46855b;

        public r(String[] strArr) {
            this.f46854a = strArr;
            this.f46855b = new long[strArr.length];
            int i10 = 0;
            while (true) {
                long[] jArr = this.f46855b;
                if (i10 >= jArr.length) {
                    return;
                }
                jArr[i10] = C11603o.m69257I(strArr[i10]);
                i10++;
            }
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f46854a.length);
            int i10 = 0;
            while (true) {
                String[] strArr = this.f46854a;
                if (i10 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(c9383g.m58810k(obj2, strArr[i10], this.f46855b[i10]));
                i10++;
            }
        }
    }

    /* renamed from: e1.g$s */
    public static class s extends v {
        public s(String str, boolean z10) {
            super(str, z10);
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            return c9383g.m58810k(obj3, this.f46875a, this.f46876b) != null;
        }
    }

    /* renamed from: e1.g$t */
    public static class t extends v {
        public t(String str, boolean z10) {
            super(str, z10);
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            return m58838b(c9383g, obj, obj3) == null;
        }
    }

    /* renamed from: e1.g$u */
    public enum u {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    /* renamed from: e1.g$v */
    public static abstract class v implements d {

        /* renamed from: e */
        public static long f46874e = C11603o.m69257I("type");

        /* renamed from: a */
        public final String f46875a;

        /* renamed from: b */
        public final long f46876b;

        /* renamed from: c */
        public final boolean f46877c;

        /* renamed from: d */
        public b0 f46878d;

        public v(String str, boolean z10) {
            this.f46875a = str;
            long jM69257I = C11603o.m69257I(str);
            this.f46876b = jM69257I;
            this.f46877c = z10;
            if (z10) {
                if (jM69257I == f46874e) {
                    this.f46878d = f0.f46818a;
                } else {
                    if (jM69257I == 5614464919154503228L) {
                        this.f46878d = c0.f46810a;
                        return;
                    }
                    throw new C9384h("unsupported funciton : " + str);
                }
            }
        }

        /* renamed from: b */
        public Object m58838b(C9383g c9383g, Object obj, Object obj2) {
            b0 b0Var = this.f46878d;
            return b0Var != null ? b0Var.mo58815a(c9383g, obj, obj2) : c9383g.m58810k(obj2, this.f46875a, this.f46876b);
        }
    }

    /* renamed from: e1.g$w */
    public static class w implements b0 {

        /* renamed from: a */
        public final String f46879a;

        /* renamed from: b */
        public final long f46880b;

        /* renamed from: c */
        public final boolean f46881c;

        public w(String str, boolean z10) {
            this.f46879a = str;
            this.f46880b = C11603o.m69257I(str);
            this.f46881c = z10;
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            if (!this.f46881c) {
                return c9383g.m58810k(obj2, this.f46879a, this.f46880b);
            }
            ArrayList arrayList = new ArrayList();
            c9383g.m58804e(obj2, this.f46879a, arrayList);
            return arrayList;
        }
    }

    /* renamed from: e1.g$x */
    public static class x implements b0 {

        /* renamed from: a */
        public final int f46882a;

        /* renamed from: b */
        public final int f46883b;

        /* renamed from: c */
        public final int f46884c;

        public x(int i10, int i11, int i12) {
            this.f46882a = i10;
            this.f46883b = i11;
            this.f46884c = i12;
        }

        @Override // p244e1.C9383g.b0
        /* renamed from: a */
        public Object mo58815a(C9383g c9383g, Object obj, Object obj2) {
            int iIntValue = c0.f46810a.mo58815a(c9383g, obj, obj2).intValue();
            int i10 = this.f46882a;
            if (i10 < 0) {
                i10 += iIntValue;
            }
            int i11 = this.f46883b;
            if (i11 < 0) {
                i11 += iIntValue;
            }
            int i12 = ((i11 - i10) / this.f46884c) + 1;
            if (i12 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i12);
            while (i10 <= i11 && i10 < iIntValue) {
                arrayList.add(c9383g.m58808i(obj2, i10));
                i10 += this.f46884c;
            }
            return arrayList;
        }
    }

    /* renamed from: e1.g$y */
    public static class y extends v {

        /* renamed from: f */
        public final b0 f46885f;

        /* renamed from: g */
        public final u f46886g;

        public y(String str, boolean z10, b0 b0Var, u uVar) {
            super(str, z10);
            this.f46885f = b0Var;
            this.f46886g = uVar;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null || !(objM58838b instanceof Number)) {
                return false;
            }
            Object objMo58815a = this.f46885f.mo58815a(c9383g, obj, obj);
            if ((objMo58815a instanceof Integer) || (objMo58815a instanceof Long) || (objMo58815a instanceof Short) || (objMo58815a instanceof Byte)) {
                long jM69246C0 = C11603o.m69246C0((Number) objMo58815a);
                if ((objM58838b instanceof Integer) || (objM58838b instanceof Long) || (objM58838b instanceof Short) || (objM58838b instanceof Byte)) {
                    long jM69246C02 = C11603o.m69246C0((Number) objM58838b);
                    switch (a.f46804a[this.f46886g.ordinal()]) {
                        case 1:
                            return jM69246C02 == jM69246C0;
                        case 2:
                            return jM69246C02 != jM69246C0;
                        case 3:
                            return jM69246C02 >= jM69246C0;
                        case 4:
                            return jM69246C02 > jM69246C0;
                        case 5:
                            return jM69246C02 <= jM69246C0;
                        case 6:
                            return jM69246C02 < jM69246C0;
                    }
                }
                if (objM58838b instanceof BigDecimal) {
                    int iCompareTo = BigDecimal.valueOf(jM69246C0).compareTo((BigDecimal) objM58838b);
                    switch (a.f46804a[this.f46886g.ordinal()]) {
                        case 1:
                            return iCompareTo == 0;
                        case 2:
                            return iCompareTo != 0;
                        case 3:
                            return iCompareTo <= 0;
                        case 4:
                            return iCompareTo < 0;
                        case 5:
                            return iCompareTo >= 0;
                        case 6:
                            return iCompareTo > 0;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: e1.g$z */
    public static class z extends v {

        /* renamed from: f */
        public final Pattern f46887f;

        /* renamed from: g */
        public final u f46888g;

        public z(String str, boolean z10, Pattern pattern, u uVar) {
            super(str, z10);
            this.f46887f = pattern;
            this.f46888g = uVar;
        }

        @Override // p244e1.C9383g.d
        /* renamed from: a */
        public boolean mo58814a(C9383g c9383g, Object obj, Object obj2, Object obj3) {
            Object objM58838b = m58838b(c9383g, obj, obj3);
            if (objM58838b == null) {
                return false;
            }
            return this.f46887f.matcher(objM58838b.toString()).matches();
        }
    }

    public C9383g(String str) {
        this(str, C10641a1.m65181g(), C10085i.m62849t(), true);
    }

    /* renamed from: a */
    public static int m58800a(Object obj, Object obj2) {
        Object d10;
        Object f10;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls == BigDecimal.class) {
            if (cls2 == Integer.class) {
                f10 = new BigDecimal(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f10 = new BigDecimal(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f10 = new BigDecimal(((Float) obj2).floatValue());
            } else if (cls2 == Double.class) {
                f10 = new BigDecimal(((Double) obj2).doubleValue());
            }
            obj2 = f10;
        } else if (cls == Long.class) {
            if (cls2 == Integer.class) {
                f10 = new Long(((Integer) obj2).intValue());
                obj2 = f10;
            } else {
                if (cls2 == BigDecimal.class) {
                    d10 = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    d10 = new Float(((Long) obj).longValue());
                } else if (cls2 == Double.class) {
                    d10 = new Double(((Long) obj).longValue());
                }
                obj = d10;
            }
        } else if (cls == Integer.class) {
            if (cls2 == Long.class) {
                d10 = new Long(((Integer) obj).intValue());
            } else if (cls2 == BigDecimal.class) {
                d10 = new BigDecimal(((Integer) obj).intValue());
            } else if (cls2 == Float.class) {
                d10 = new Float(((Integer) obj).intValue());
            } else if (cls2 == Double.class) {
                d10 = new Double(((Integer) obj).intValue());
            }
            obj = d10;
        } else if (cls == Double.class) {
            if (cls2 == Integer.class) {
                f10 = new Double(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f10 = new Double(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f10 = new Double(((Float) obj2).floatValue());
            }
            obj2 = f10;
        } else if (cls == Float.class) {
            if (cls2 == Integer.class) {
                f10 = new Float(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f10 = new Float(((Long) obj2).longValue());
            } else if (cls2 == Double.class) {
                d10 = new Double(((Float) obj).floatValue());
                obj = d10;
            }
            obj2 = f10;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* renamed from: b */
    public static C9383g m58801b(String str) {
        if (str == null) {
            throw new C9384h("jsonpath can not be null");
        }
        C9383g c9383g = f46797g.get(str);
        if (c9383g != null) {
            return c9383g;
        }
        C9383g c9383g2 = new C9383g(str);
        if (f46797g.size() >= 1024) {
            return c9383g2;
        }
        f46797g.putIfAbsent(str, c9383g2);
        return f46797g.get(str);
    }

    /* renamed from: n */
    public static boolean m58802n(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    @Override // p244e1.InterfaceC9379c
    /* renamed from: c */
    public String mo58779c() {
        return AbstractC9377a.m58774x(this.f46798a);
    }

    /* renamed from: d */
    public void m58803d(Object obj, List<Object> list) {
        Collection collectionM65293v;
        Class<?> cls = obj.getClass();
        C10666j0 c10666j0M58809j = m58809j(cls);
        if (c10666j0M58809j != null) {
            try {
                collectionM65293v = c10666j0M58809j.m65293v(obj);
            } catch (Exception e10) {
                throw new C9384h("jsonpath error, path " + this.f46798a, e10);
            }
        } else {
            collectionM65293v = obj instanceof Map ? ((Map) obj).values() : obj instanceof Collection ? (Collection) obj : null;
        }
        if (collectionM65293v == null) {
            throw new UnsupportedOperationException(cls.getName());
        }
        for (Object obj2 : collectionM65293v) {
            if (obj2 == null || C10085i.m62850w(obj2.getClass())) {
                list.add(obj2);
            } else {
                m58803d(obj2, list);
            }
        }
    }

    /* renamed from: e */
    public void m58804e(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !C10085i.m62850w(value.getClass())) {
                    m58804e(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!C10085i.m62850w(obj2.getClass())) {
                    m58804e(obj2, str, list);
                }
            }
            return;
        }
        C10666j0 c10666j0M58809j = m58809j(obj.getClass());
        if (c10666j0M58809j == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i10 = 0; i10 < list2.size(); i10++) {
                    m58804e(list2.get(i10), str, list);
                }
                return;
            }
            return;
        }
        try {
            C10640a0 c10640a0M65291t = c10666j0M58809j.m65291t(str);
            if (c10640a0M65291t == null) {
                Iterator<Object> it = c10666j0M58809j.m65293v(obj).iterator();
                while (it.hasNext()) {
                    m58804e(it.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(c10640a0M65291t.m65177e(obj));
                } catch (InvocationTargetException e10) {
                    throw new C9380d("getFieldValue error." + str, e10);
                }
            } catch (IllegalAccessException e11) {
                throw new C9380d("getFieldValue error." + str, e11);
            }
        } catch (Exception e12) {
            throw new C9384h("jsonpath error, path " + this.f46798a + ", segement " + str, e12);
        }
    }

    /* renamed from: f */
    public Object m58805f(Object obj) {
        if (obj == null) {
            return null;
        }
        m58812m();
        int i10 = 0;
        Object objMo58815a = obj;
        while (true) {
            b0[] b0VarArr = this.f46799b;
            if (i10 >= b0VarArr.length) {
                return objMo58815a;
            }
            objMo58815a = b0VarArr[i10].mo58815a(this, obj, objMo58815a);
            i10++;
        }
    }

    /* renamed from: g */
    public Set<?> m58806g(Object obj) {
        C10666j0 c10666j0M58809j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (c10666j0M58809j = m58809j(obj.getClass())) == null) {
            return null;
        }
        try {
            return c10666j0M58809j.m65289r(obj);
        } catch (Exception e10) {
            throw new C9384h("evalKeySet error : " + this.f46798a, e10);
        }
    }

    /* renamed from: h */
    public int m58807h(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i10++;
                }
            }
            return i10;
        }
        C10666j0 c10666j0M58809j = m58809j(obj.getClass());
        if (c10666j0M58809j == null) {
            return -1;
        }
        try {
            return c10666j0M58809j.m65296y(obj);
        } catch (Exception e10) {
            throw new C9384h("evalSize error : " + this.f46798a, e10);
        }
    }

    /* renamed from: i */
    public Object m58808i(Object obj, int i10) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i10 >= 0) {
                if (i10 < list.size()) {
                    return list.get(i10);
                }
                return null;
            }
            if (Math.abs(i10) <= list.size()) {
                return list.get(list.size() + i10);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i10 >= 0) {
                if (i10 < length) {
                    return Array.get(obj, i10);
                }
                return null;
            }
            if (Math.abs(i10) <= length) {
                return Array.get(obj, length + i10);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i10));
            return obj2 == null ? map.get(Integer.toString(i10)) : obj2;
        }
        if (!(obj instanceof Collection)) {
            if (i10 == 0) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }
        int i11 = 0;
        for (Object obj3 : (Collection) obj) {
            if (i11 == i10) {
                return obj3;
            }
            i11++;
        }
        return null;
    }

    /* renamed from: j */
    public C10666j0 m58809j(Class<?> cls) {
        InterfaceC10686t0 interfaceC10686t0M65187h = this.f46801d.m65187h(cls);
        if (interfaceC10686t0M65187h instanceof C10666j0) {
            return (C10666j0) interfaceC10686t0M65187h;
        }
        return null;
    }

    /* renamed from: k */
    public Object m58810k(Object obj, String str, long j10) {
        Object obj2;
        C9378b c9378b = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj2 = (C9381e) AbstractC9377a.m58764k((String) obj, this.f46802e);
            } catch (Exception unused) {
            }
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(str);
            return obj3 == null ? (5614464919154503228L == j10 || -1580386065683472715L == j10) ? Integer.valueOf(map.size()) : obj3 : obj3;
        }
        C10666j0 c10666j0M58809j = m58809j(obj2.getClass());
        if (c10666j0M58809j != null) {
            try {
                return c10666j0M58809j.m65292u(obj2, str, j10, false);
            } catch (Exception e10) {
                throw new C9384h("jsonpath error, path " + this.f46798a + ", segement " + str, e10);
            }
        }
        int i10 = 0;
        if (obj2 instanceof List) {
            List list = (List) obj2;
            if (5614464919154503228L == j10 || -1580386065683472715L == j10) {
                return Integer.valueOf(list.size());
            }
            while (i10 < list.size()) {
                Object obj4 = list.get(i10);
                if (obj4 == list) {
                    if (c9378b == null) {
                        c9378b = new C9378b(list.size());
                    }
                    c9378b.add(obj4);
                } else {
                    Object objM58810k = m58810k(obj4, str, j10);
                    if (objM58810k instanceof Collection) {
                        Collection collection = (Collection) objM58810k;
                        if (c9378b == null) {
                            c9378b = new C9378b(list.size());
                        }
                        c9378b.addAll(collection);
                    } else if (objM58810k != null || !this.f46803f) {
                        if (c9378b == null) {
                            c9378b = new C9378b(list.size());
                        }
                        c9378b.add(objM58810k);
                    }
                }
                i10++;
            }
            return c9378b == null ? Collections.emptyList() : c9378b;
        }
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (5614464919154503228L == j10 || -1580386065683472715L == j10) {
                return Integer.valueOf(objArr.length);
            }
            C9378b c9378b2 = new C9378b(objArr.length);
            while (i10 < objArr.length) {
                Object[] objArr2 = objArr[i10];
                if (objArr2 == objArr) {
                    c9378b2.add(objArr2);
                } else {
                    Object objM58810k2 = m58810k(objArr2, str, j10);
                    if (objM58810k2 instanceof Collection) {
                        c9378b2.addAll((Collection) objM58810k2);
                    } else if (objM58810k2 != null || !this.f46803f) {
                        c9378b2.add(objM58810k2);
                    }
                }
                i10++;
            }
            return c9378b2;
        }
        if (obj2 instanceof Enum) {
            Enum r82 = (Enum) obj2;
            if (-4270347329889690746L == j10) {
                return r82.name();
            }
            if (-1014497654951707614L == j10) {
                return Integer.valueOf(r82.ordinal());
            }
        }
        if (obj2 instanceof Calendar) {
            Calendar calendar = (Calendar) obj2;
            if (8963398325558730460L == j10) {
                return Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j10) {
                return Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j10) {
                return Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j10) {
                return Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j10) {
                return Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j10) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    /* renamed from: l */
    public Collection<Object> m58811l(Object obj) {
        if (obj == null) {
            return null;
        }
        C10666j0 c10666j0M58809j = m58809j(obj.getClass());
        if (c10666j0M58809j == null) {
            if (obj instanceof Map) {
                return ((Map) obj).values();
            }
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
        try {
            return c10666j0M58809j.m65293v(obj);
        } catch (Exception e10) {
            throw new C9384h("jsonpath error, path " + this.f46798a, e10);
        }
    }

    /* renamed from: m */
    public void m58812m() {
        if (this.f46799b != null) {
            return;
        }
        if ("*".equals(this.f46798a)) {
            this.f46799b = new b0[]{h0.f46825c};
            return;
        }
        l lVar = new l(this.f46798a);
        this.f46799b = lVar.m58823d();
        this.f46800c = lVar.f46844e;
    }

    /* renamed from: o */
    public boolean m58813o() {
        try {
            m58812m();
            int i10 = 0;
            while (true) {
                b0[] b0VarArr = this.f46799b;
                if (i10 >= b0VarArr.length) {
                    return true;
                }
                Class<?> cls = b0VarArr[i10].getClass();
                if (cls != b.class && cls != w.class) {
                    return false;
                }
                i10++;
            }
        } catch (C9384h unused) {
            return false;
        }
    }

    public C9383g(String str, C10641a1 c10641a1, C10085i c10085i, boolean z10) {
        if (str == null || str.length() == 0) {
            throw new C9384h("json-path can not be null or empty");
        }
        this.f46798a = str;
        this.f46801d = c10641a1;
        this.f46802e = c10085i;
        this.f46803f = z10;
    }
}
