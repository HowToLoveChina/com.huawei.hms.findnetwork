package com.huawei.updatesdk.p177a.p186b.p189c.p190c;

import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8785g;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8786h;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.a.b.c.c.c */
/* loaded from: classes9.dex */
public class C8800c {
    public static final String CLIENT_API = "clientApi";
    private static final String END_FLAG = "_";
    private static String url;

    @SDKNetTransmission
    private String method;

    @SDKNetTransmission
    private String ver = "1.1";

    /* renamed from: a */
    public String m56168a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        m56174e();
        Map<String, Field> mapM56172c = m56172c();
        int size = mapM56172c.size();
        String[] strArr = new String[size];
        mapM56172c.keySet().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        do {
            String strM56166a = m56166a(mapM56172c.get(strArr[i10]));
            if (strM56166a != null) {
                String strM56064a = AbstractC8786h.m56064a(strM56166a);
                sb2.append(strArr[i10]);
                sb2.append("=");
                sb2.append(strM56064a);
                sb2.append("&");
            }
            i10++;
        } while (i10 < size);
        int length = sb2.length();
        if (length > 0) {
            int i11 = length - 1;
            if (sb2.charAt(i11) == '&') {
                sb2.deleteCharAt(i11);
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public String m56170b() {
        return this.method;
    }

    /* renamed from: c */
    public Map<String, Field> m56172c() throws SecurityException {
        HashMap map = new HashMap();
        for (Field field : AbstractC8785g.m56063a(getClass())) {
            field.setAccessible(true);
            String name = field.getName();
            if (name.endsWith("_") || field.isAnnotationPresent(SDKNetTransmission.class)) {
                if (name.endsWith("_")) {
                    name = name.substring(0, name.length() - 1);
                }
                map.put(name, field);
            }
        }
        return map;
    }

    /* renamed from: d */
    public String m56173d() {
        return url + CLIENT_API;
    }

    /* renamed from: e */
    public void m56174e() {
    }

    /* renamed from: a */
    private String m56166a(Field field) throws IllegalAccessException, IllegalArgumentException {
        Object obj = field.get(this);
        if (obj instanceof AbstractC8799b) {
            return ((AbstractC8799b) obj).toJson();
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* renamed from: c */
    public static void m56167c(String str) {
        url = str;
    }

    /* renamed from: b */
    public void m56171b(String str) {
        this.ver = str;
    }

    /* renamed from: a */
    public void m56169a(String str) {
        this.method = str;
    }
}
