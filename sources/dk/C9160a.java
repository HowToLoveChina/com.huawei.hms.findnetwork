package dk;

import com.huawei.hms.android.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0224k0;
import p015ak.C0241z;

/* renamed from: dk.a */
/* loaded from: classes6.dex */
public final class C9160a {

    /* renamed from: a */
    public static final List<Integer> f45948a = new a();

    /* renamed from: b */
    public static final String f45949b = C0224k0.a.m1572a("ro.product.model");

    /* renamed from: c */
    public static final String f45950c = C0224k0.a.m1572a(SystemUtils.PRODUCT_BRAND);

    /* renamed from: d */
    public static final int f45951d = C0241z.m1685c(C0224k0.a.m1572a("ro.build.version.sdk"));

    /* renamed from: e */
    public static final Map<String, String> f45952e = new b();

    /* renamed from: f */
    public static final List<String> f45953f = new c();

    /* renamed from: dk.a$a */
    public class a extends ArrayList<Integer> {
        public a() {
            add(1004);
            add(11);
            add(67);
        }
    }

    /* renamed from: dk.a$b */
    public class b extends HashMap<String, String> {
        public b() {
            put("/Sync", "sync");
            put("/CloudDrive", "clouddrive");
            put("/recording", "record");
            put("/notepad.db", "notepad");
            put("/notepadRes.zip", "notepad");
            put("/phonemanager.db", "phonemanager");
        }
    }

    /* renamed from: dk.a$c */
    public class c extends ArrayList<String> {
        public c() {
            add("record");
            add("notepad");
            add("phonemanager");
            add("sync");
        }
    }

    /* renamed from: a */
    public static List<Integer> m57577a() {
        return f45948a;
    }

    /* renamed from: b */
    public static Map<String, String> m57578b() {
        return f45952e;
    }

    /* renamed from: c */
    public static List<String> m57579c() {
        return f45953f;
    }
}
