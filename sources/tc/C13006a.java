package tc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0214f0;

/* renamed from: tc.a */
/* loaded from: classes3.dex */
public final class C13006a {

    /* renamed from: a */
    public final SharedPreferences f59254a;

    /* renamed from: tc.a$a */
    public class a extends LinkedHashMap<String, Integer> {
        public a() {
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
            return size() > 500;
        }
    }

    /* renamed from: tc.a$b */
    public static class b {

        /* renamed from: a */
        public static final C13006a f59256a = new C13006a(null);
    }

    public /* synthetic */ C13006a(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C13006a m78193e() {
        return b.f59256a;
    }

    /* renamed from: a */
    public void m78194a() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    /* renamed from: b */
    public void m78195b() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("memoryTimeStamp").apply();
        }
    }

    /* renamed from: c */
    public void m78196c() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("pathList").apply();
        }
    }

    /* renamed from: d */
    public void m78197d() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("spTimeStamp").apply();
        }
    }

    /* renamed from: f */
    public long m78198f() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("memoryTimeStamp", 0L);
    }

    /* renamed from: g */
    public Map<String, Integer> m78199g() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences == null) {
            return new LinkedHashMap();
        }
        String string = sharedPreferences.getString("pathList", "");
        if (TextUtils.isEmpty(string)) {
            return new LinkedHashMap();
        }
        String[] strArrSplit = string.split(",");
        a aVar = new a();
        for (String str : strArrSplit) {
            aVar.put(str, 1);
        }
        return aVar;
    }

    /* renamed from: h */
    public long m78200h() {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("spTimeStamp", 0L);
    }

    /* renamed from: i */
    public void m78201i(long j10) {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("memoryTimeStamp", j10).apply();
        }
    }

    /* renamed from: j */
    public void m78202j(Map<String, Integer> map) {
        if (map == null || map.isEmpty() || this.f59254a == null) {
            return;
        }
        this.f59254a.edit().putString("pathList", String.join(",", map.keySet())).apply();
    }

    /* renamed from: k */
    public void m78203k(long j10) {
        SharedPreferences sharedPreferences = this.f59254a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("spTimeStamp", j10).apply();
        }
    }

    public C13006a() {
        this.f59254a = C0214f0.m1382b(C0213f.m1377a(), "SyncNotFindFilesSp", 0);
    }
}
