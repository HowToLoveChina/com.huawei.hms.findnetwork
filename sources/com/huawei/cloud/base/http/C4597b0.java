package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4637f0;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4645m;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import p656ti.C13014a;

/* renamed from: com.huawei.cloud.base.http.b0 */
/* loaded from: classes.dex */
public class C4597b0 {

    /* renamed from: a */
    public static final Map<Character, a> f21133a = new HashMap();

    /* renamed from: com.huawei.cloud.base.http.b0$a */
    public enum a {
        PLUS('+', "", ",", false, true),
        HASH('#', "#", ",", false, true),
        DOT('.', ".", ".", false, false),
        FORWARD_SLASH(Character.valueOf(C5929g4.f26852n), "/", "/", false, false),
        SEMI_COLON(';', ";", ";", true, false),
        QUERY('?', Constants.QUESTION_STR, "&", true, false),
        AMP('&', "&", "&", true, false),
        SIMPLE(null, "", ",", false, false);


        /* renamed from: a */
        public final Character f21143a;

        /* renamed from: b */
        public final String f21144b;

        /* renamed from: c */
        public final String f21145c;

        /* renamed from: d */
        public final boolean f21146d;

        /* renamed from: e */
        public final boolean f21147e;

        a(Character ch2, String str, String str2, boolean z10, boolean z11) {
            this.f21143a = ch2;
            this.f21144b = (String) C4627a0.m28391d(str);
            this.f21145c = (String) C4627a0.m28391d(str2);
            this.f21146d = z10;
            this.f21147e = z11;
            if (ch2 != null) {
                C4597b0.f21133a.put(ch2, this);
            }
        }

        /* renamed from: b */
        public String m28173b(String str) {
            return this.f21147e ? C13014a.m78325c(str) : C13014a.m78324b(str);
        }

        /* renamed from: e */
        public String m28174e() {
            return this.f21145c;
        }

        /* renamed from: f */
        public String m28175f() {
            return this.f21144b;
        }

        /* renamed from: h */
        public boolean m28176h() {
            return this.f21147e;
        }

        /* renamed from: k */
        public int m28177k() {
            return this.f21143a == null ? 0 : 1;
        }

        /* renamed from: p */
        public boolean m28178p() {
            return this.f21146d;
        }
    }

    static {
        a.values();
    }

    /* renamed from: a */
    public static String m28166a(String str, Object obj, boolean z10) {
        Map<String, Object> mapM28170e = m28170e(obj);
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int iIndexOf = str.indexOf(123, i10);
            if (iIndexOf != -1) {
                sb2.append(str.substring(i10, iIndexOf));
                int iIndexOf2 = str.indexOf(125, iIndexOf + 2);
                int i11 = iIndexOf2 + 1;
                String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
                a aVarM28168c = m28168c(strSubstring);
                ListIterator listIterator = Arrays.asList(strSubstring.split(",")).listIterator();
                boolean z11 = true;
                while (listIterator.hasNext()) {
                    String strTrim = ((String) listIterator.next()).trim();
                    boolean zEndsWith = strTrim.endsWith("*");
                    int iM28177k = listIterator.nextIndex() == 1 ? aVarM28168c.m28177k() : 0;
                    int length2 = strTrim.length();
                    if (zEndsWith) {
                        length2--;
                    }
                    String strSubstring2 = strTrim.substring(iM28177k, length2);
                    Object objRemove = mapM28170e.remove(strSubstring2);
                    if (objRemove != null) {
                        if (z11) {
                            sb2.append(aVarM28168c.m28175f());
                            z11 = false;
                        } else {
                            sb2.append(aVarM28168c.m28174e());
                        }
                        sb2.append((Object) m28172g(objRemove, strSubstring2, zEndsWith, aVarM28168c));
                    }
                }
                i10 = i11;
            } else {
                if (i10 == 0 && !z10) {
                    return str;
                }
                sb2.append(str.substring(i10));
            }
        }
        if (z10) {
            C4604g.m28191b(mapM28170e.entrySet(), sb2);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m28167b(String str, String str2, Object obj, boolean z10) {
        if (str2.startsWith("/")) {
            C4604g c4604g = new C4604g(str);
            c4604g.m28205x(null);
            str2 = c4604g.m28198p() + str2;
        } else if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            str2 = str + str2;
        }
        return m28166a(str2, obj, z10);
    }

    /* renamed from: c */
    public static a m28168c(String str) {
        a aVar = f21133a.get(Character.valueOf(str.charAt(0)));
        return aVar == null ? a.SIMPLE : aVar;
    }

    /* renamed from: d */
    public static String m28169d(String str, Iterator<?> it, boolean z10, a aVar) {
        String strM28174e;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            strM28174e = aVar.m28174e();
        } else {
            if (aVar.m28178p()) {
                sb2.append(C13014a.m78325c(str));
                sb2.append("=");
            }
            strM28174e = ",";
        }
        while (it.hasNext()) {
            if (z10 && aVar.m28178p()) {
                sb2.append(C13014a.m78325c(str));
                sb2.append("=");
            }
            sb2.append(aVar.m28173b(it.next().toString()));
            if (it.hasNext()) {
                sb2.append(strM28174e);
            }
        }
        return sb2.toString();
    }

    /* renamed from: e */
    public static Map<String, Object> m28170e(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : C4642j.m28444g(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !C4642j.m28441d(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public static String m28171f(String str, Map<String, Object> map, boolean z10, a aVar) {
        String strM28174e;
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        String str2 = "=";
        if (z10) {
            strM28174e = aVar.m28174e();
        } else {
            if (aVar.m28178p()) {
                sb2.append(C13014a.m78325c(str));
                sb2.append("=");
            }
            str2 = ",";
            strM28174e = ",";
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String strM28173b = aVar.m28173b(next.getKey());
            String strM28173b2 = aVar.m28173b(next.getValue().toString());
            sb2.append(strM28173b);
            sb2.append(str2);
            sb2.append(strM28173b2);
            if (it.hasNext()) {
                sb2.append(strM28174e);
            }
        }
        return sb2.toString();
    }

    /* renamed from: g */
    public static String m28172g(Object obj, String str, boolean z10, a aVar) {
        if (obj instanceof Iterator) {
            return m28169d(str, (Iterator) obj, z10, aVar);
        }
        if ((obj instanceof Iterable) || obj.getClass().isArray()) {
            return m28169d(str, C4637f0.m28423l(obj).iterator(), z10, aVar);
        }
        if (obj.getClass().isEnum()) {
            if (C4645m.m28461j((Enum) obj).m28467e() == null) {
                return "";
            }
            if (aVar.m28178p()) {
                obj = String.format("%s=%s", str, obj);
            }
            return C13014a.m78325c(obj.toString());
        }
        if (!C4642j.m28443f(obj)) {
            return m28171f(str, m28170e(obj), z10, aVar);
        }
        if (aVar.m28178p()) {
            obj = String.format("%s=%s", str, obj);
        }
        return aVar.m28176h() ? C13014a.m78326d(obj.toString()) : C13014a.m78325c(obj.toString());
    }
}
