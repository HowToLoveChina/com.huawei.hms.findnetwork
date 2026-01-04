package p602r5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import java.util.Iterator;
import p007a6.C0052a;
import p386j6.C10713c;

/* renamed from: r5.b */
/* loaded from: classes.dex */
public class C12466b extends C0052a {

    /* renamed from: r5.b$a */
    public static class a {

        /* renamed from: a */
        public int f57395a;

        /* renamed from: b */
        public ArrayList<c> f57396b = new ArrayList<>();

        /* renamed from: c */
        public ArrayList<c> m74735c() {
            return this.f57396b;
        }

        /* renamed from: d */
        public void m74736d(int i10) {
            this.f57395a = i10;
        }
    }

    /* renamed from: r5.b$b */
    public static class b {

        /* renamed from: a */
        public boolean f57397a;

        /* renamed from: b */
        public ArrayList<String> f57398b;

        /* renamed from: c */
        public ArrayList<String> m74739c() {
            return this.f57398b;
        }

        /* renamed from: d */
        public boolean m74740d() {
            return this.f57397a;
        }
    }

    /* renamed from: r5.b$c */
    public static class c {

        /* renamed from: a */
        public String f57399a;

        /* renamed from: b */
        public int f57400b;

        public c(String str, int i10) {
            this.f57399a = str;
            this.f57400b = i10;
        }
    }

    public C12466b(Uri uri) {
        super(uri);
    }

    /* renamed from: g */
    public b m74732g(Context context, a aVar) throws Throwable {
        if (context == null || aVar == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (aVar.f57396b != null) {
            Iterator it = aVar.f57396b.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    arrayList.add(cVar.f57399a);
                    arrayList2.add(Integer.valueOf(cVar.f57400b));
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("version", aVar.f57395a);
        bundle.putStringArrayList("uri_list", arrayList);
        bundle.putIntegerArrayList("count_list", arrayList2);
        Bundle bundleM12615a = C2108a.m12615a(context, this.f130a, "backup_recover_start", null, m223d(bundle));
        if (bundleM12615a == null) {
            return null;
        }
        b bVar = new b();
        bVar.f57397a = C10713c.m65392b(bundleM12615a, "permit", false);
        try {
            bVar.f57398b = C10713c.m65401k(bundleM12615a, "uri_list");
        } catch (ArrayIndexOutOfBoundsException unused) {
            C2111d.m12648d("LauncherModuleProtocol", "ArrayIndexOutOfBoundsException");
        }
        return bVar;
    }
}
