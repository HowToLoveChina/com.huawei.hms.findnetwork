package p618rm;

import com.huawei.android.hicloud.cloudbackup.process.util.FileCategoryUtil;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p556pp.C12202a;
import p818yp.C14034a;

/* renamed from: rm.b */
/* loaded from: classes6.dex */
public class C12538b {

    /* renamed from: a */
    public static final HashMap<String, C12202a> f57882a = new HashMap<>();

    /* renamed from: b */
    public static final HashMap<String, C12202a> f57883b = new HashMap<>();

    /* renamed from: c */
    public static final Map<Integer, List<String>> f57884c = new HashMap();

    static {
        m75481d();
        m75482e();
    }

    /* renamed from: a */
    public static void m75478a(String str, int i10, int i11, int i12, String str2) {
        C12202a c12202a = new C12202a(i10, i11, i12, str2);
        f57882a.put(str, c12202a);
        f57883b.put(str2, c12202a);
    }

    /* renamed from: b */
    public static C12202a m75479b(File file) {
        return (file == null || !file.exists() || file.isDirectory()) ? C14034a.f62798b : C14034a.m84167d(C10279b.m63452a(file), false, f57882a);
    }

    /* renamed from: c */
    public static List<String> m75480c(int i10) {
        return f57884c.get(Integer.valueOf(i10));
    }

    /* renamed from: d */
    public static void m75481d() {
        f57882a.putAll(C14034a.m84168e());
        f57883b.putAll(C14034a.m84170g());
        m75478a("EPUB", 2, 299, -1, "application/epub");
        m75478a("EPUB", 2, 299, -1, "application/epub+zip");
    }

    /* renamed from: e */
    public static void m75482e() {
        for (Map.Entry<String, C12202a> entry : f57883b.entrySet()) {
            String key = entry.getKey();
            int fileCategory = FileCategoryUtil.getFileCategory(entry.getValue().m73355a());
            Map<Integer, List<String>> map = f57884c;
            List<String> arrayList = map.get(Integer.valueOf(fileCategory));
            if (arrayList == null || arrayList.isEmpty()) {
                arrayList = new ArrayList<>();
                map.put(Integer.valueOf(fileCategory), arrayList);
            }
            arrayList.add(key);
        }
    }
}
