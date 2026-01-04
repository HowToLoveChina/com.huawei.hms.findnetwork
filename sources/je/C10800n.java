package je;

import java.util.HashMap;
import p514o9.C11839m;

/* renamed from: je.n */
/* loaded from: classes3.dex */
public class C10800n {

    /* renamed from: a */
    public HashMap<String, Object> f51564a;

    /* renamed from: a */
    public boolean m65736a(String str, boolean z10) {
        Object objM65739d = m65739d(str);
        return objM65739d == null ? z10 : ((Boolean) objM65739d).booleanValue();
    }

    /* renamed from: b */
    public <T> T m65737b(String str) {
        try {
            HashMap<String, Object> map = this.f51564a;
            if (map != null) {
                return (T) map.get(str);
            }
            return null;
        } catch (Exception unused) {
            C11839m.m70687e("IPCParams", "getGenericParameter exception");
            return null;
        }
    }

    /* renamed from: c */
    public int m65738c(String str, int i10) {
        Object objM65739d = m65739d(str);
        return (objM65739d == null || !(objM65739d instanceof Integer)) ? i10 : ((Integer) objM65739d).intValue();
    }

    /* renamed from: d */
    public Object m65739d(String str) {
        HashMap<String, Object> map = this.f51564a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: e */
    public String m65740e(String str, String str2) {
        Object objM65739d = m65739d(str);
        return (objM65739d == null || !(objM65739d instanceof String)) ? str2 : (String) objM65739d;
    }

    /* renamed from: f */
    public C10800n m65741f(String str, boolean z10) {
        m65743h(str, Boolean.valueOf(z10));
        return this;
    }

    /* renamed from: g */
    public C10800n m65742g(String str, int i10) {
        m65743h(str, Integer.valueOf(i10));
        return this;
    }

    /* renamed from: h */
    public C10800n m65743h(String str, Object obj) {
        if (this.f51564a == null) {
            this.f51564a = new HashMap<>();
        }
        this.f51564a.put(str, obj);
        return this;
    }
}
