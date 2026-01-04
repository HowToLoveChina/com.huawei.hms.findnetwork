package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* renamed from: com.google.crypto.tink.shaded.protobuf.u0 */
/* loaded from: classes.dex */
public final class C1957u0 {
    /* renamed from: a */
    public static final String m12252a(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt)) {
                sb2.append("_");
            }
            sb2.append(Character.toLowerCase(cCharAt));
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static boolean m12253b(Object obj) {
        return obj instanceof Boolean ? !((Boolean) obj).booleanValue() : obj instanceof Integer ? ((Integer) obj).intValue() == 0 : obj instanceof Float ? ((Float) obj).floatValue() == 0.0f : obj instanceof Double ? ((Double) obj).doubleValue() == 0.0d : obj instanceof String ? obj.equals("") : obj instanceof AbstractC1920i ? obj.equals(AbstractC1920i.f9147b) : obj instanceof InterfaceC1951s0 ? obj == ((InterfaceC1951s0) obj).mo12208c() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
    }

    /* renamed from: c */
    public static final void m12254c(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m12254c(sb2, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m12254c(sb2, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            sb2.append(' ');
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(C1934m1.m12035c((String) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof AbstractC1920i) {
            sb2.append(": \"");
            sb2.append(C1934m1.m12033a((AbstractC1920i) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof AbstractC1968z) {
            sb2.append(" {");
            m12255d((AbstractC1968z) obj, sb2, i10 + 2);
            sb2.append("\n");
            while (i11 < i10) {
                sb2.append(' ');
                i11++;
            }
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj.toString());
            return;
        }
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i13 = i10 + 2;
        m12254c(sb2, i13, "key", entry.getKey());
        m12254c(sb2, i13, "value", entry.getValue());
        sb2.append("\n");
        while (i11 < i10) {
            sb2.append(' ');
            i11++;
        }
        sb2.append("}");
    }

    /* renamed from: d */
    public static void m12255d(InterfaceC1951s0 interfaceC1951s0, StringBuilder sb2, int i10) throws SecurityException {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : interfaceC1951s0.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String str2 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1, strSubstring.length() - 4);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    m12254c(sb2, i10, m12252a(str2), AbstractC1968z.m12388y(method2, interfaceC1951s0, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String str3 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1, strSubstring.length() - 3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    m12254c(sb2, i10, m12252a(str3), AbstractC1968z.m12388y(method3, interfaceC1951s0, new Object[0]));
                }
            }
            if (((Method) map2.get("set" + strSubstring)) != null) {
                if (strSubstring.endsWith("Bytes")) {
                    if (map.containsKey("get" + strSubstring.substring(0, strSubstring.length() - 5))) {
                    }
                }
                String str4 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1);
                Method method4 = (Method) map.get("get" + strSubstring);
                Method method5 = (Method) map.get("has" + strSubstring);
                if (method4 != null) {
                    Object objM12388y = AbstractC1968z.m12388y(method4, interfaceC1951s0, new Object[0]);
                    if (method5 == null) {
                        if (!m12253b(objM12388y)) {
                            m12254c(sb2, i10, m12252a(str4), objM12388y);
                        }
                    } else if (((Boolean) AbstractC1968z.m12388y(method5, interfaceC1951s0, new Object[0])).booleanValue()) {
                        m12254c(sb2, i10, m12252a(str4), objM12388y);
                    }
                }
            }
        }
        if (interfaceC1951s0 instanceof AbstractC1968z.c) {
            Iterator<Map.Entry<T, Object>> itM12279r = ((AbstractC1968z.c) interfaceC1951s0).extensions.m12279r();
            while (itM12279r.hasNext()) {
                Map.Entry entry = (Map.Entry) itM12279r.next();
                m12254c(sb2, i10, "[" + ((AbstractC1968z.d) entry.getKey()).mo12285a0() + "]", entry.getValue());
            }
        }
        C1943p1 c1943p1 = ((AbstractC1968z) interfaceC1951s0).unknownFields;
        if (c1943p1 != null) {
            c1943p1.m12099m(sb2, i10);
        }
    }

    /* renamed from: e */
    public static String m12256e(InterfaceC1951s0 interfaceC1951s0, String str) throws SecurityException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        m12255d(interfaceC1951s0, sb2, 0);
        return sb2.toString();
    }
}
