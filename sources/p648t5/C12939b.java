package p648t5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import java.util.ArrayList;
import java.util.Iterator;
import p007a6.C0052a;
import p229di.C9142g;
import p386j6.C10713c;

/* renamed from: t5.b */
/* loaded from: classes.dex */
public class C12939b extends C0052a {

    /* renamed from: c */
    public static final String f58984c;

    /* renamed from: d */
    public static final String f58985d;

    /* renamed from: t5.b$b */
    public static class b {

        /* renamed from: a */
        public boolean f58988a;

        /* renamed from: b */
        public ArrayList<String> f58989b;

        /* renamed from: c */
        public String f58990c;

        /* renamed from: a */
        public boolean m77713a() {
            ArrayList<String> arrayList = this.f58989b;
            return !this.f58988a || (arrayList == null || arrayList.isEmpty()) || this.f58989b.get(0) == null;
        }

        /* renamed from: b */
        public String m77714b() {
            ArrayList<String> arrayList = this.f58989b;
            return (arrayList == null || arrayList.isEmpty()) ? "" : this.f58989b.get(0);
        }

        /* renamed from: c */
        public String m77715c() {
            return this.f58990c;
        }

        /* renamed from: d */
        public ArrayList<String> m77716d() {
            return this.f58989b;
        }

        /* renamed from: e */
        public boolean m77717e() {
            return this.f58988a;
        }

        /* renamed from: f */
        public void m77718f(boolean z10) {
            this.f58988a = z10;
        }

        /* renamed from: g */
        public void m77719g(String str) {
            this.f58990c = str;
        }

        /* renamed from: h */
        public void m77720h(ArrayList<String> arrayList) {
            this.f58989b = arrayList;
        }
    }

    /* renamed from: t5.b$c */
    public static class c {

        /* renamed from: a */
        public String f58991a;

        /* renamed from: b */
        public int f58992b;

        public c(String str, int i10) {
            this.f58991a = str;
            this.f58992b = i10;
        }
    }

    static {
        f58984c = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/note_items_all" : "content://com.huawei.provider.NotePad.backup/note_items_all";
        f58985d = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/note_items" : "content://com.huawei.provider.NotePad.backup/note_items";
    }

    public C12939b(Uri uri) {
        super(uri);
    }

    @Override // p007a6.C0052a
    /* renamed from: b */
    public C0052a.a mo221b(Context context, String str) {
        return m77708g(context, str, null);
    }

    @Override // p007a6.C0052a
    /* renamed from: c */
    public C0052a.a mo222c(Context context, String str, Bundle bundle) {
        return m77708g(context, str, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p007a6.C0052a.a m77708g(android.content.Context r8, java.lang.String r9, android.os.Bundle r10) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "uri_list_need_count"
            java.lang.String r1 = "tar_file_path_list"
            java.lang.String r2 = "uri_list"
            java.lang.String r3 = "queryBackupInfo with extras"
            java.lang.String r4 = "MemoModuleProtocol"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r4, r3)
            r3 = 0
            if (r8 != 0) goto L16
            java.lang.String r7 = "queryBackupInfo context is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r4, r7)
            return r3
        L16:
            android.net.Uri r5 = r7.f130a
            java.lang.String r6 = "backup_query"
            android.os.Bundle r7 = r7.m223d(r10)
            android.os.Bundle r7 = com.huawei.android.backup.filelogic.utils.C2108a.m12615a(r8, r5, r6, r9, r7)
            if (r7 != 0) goto L2a
            java.lang.String r7 = "queryBackupInfo infoBundle is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r4, r7)
            return r3
        L2a:
            a6.a$a r8 = new a6.a$a
            r8.<init>()
            java.lang.String r9 = "version"
            boolean r10 = r7.containsKey(r9)
            r5 = 0
            if (r10 == 0) goto L3c
            int r5 = p386j6.C10713c.m65395e(r7, r9, r5)
        L3c:
            r8.m250x(r5)
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            r9.<init>()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            boolean r10 = r7.containsKey(r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            if (r10 == 0) goto L68
            java.util.ArrayList r9 = p386j6.C10713c.m65401k(r7, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            if (r9 == 0) goto L68
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            r10.<init>()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            java.lang.String r2 = "queryBackup BackupInfo memo urlList = "
            r10.append(r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            java.lang.String r2 = r9.toString()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            r10.append(r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            java.lang.String r10 = r10.toString()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r4, r10)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
        L68:
            r8.m252z(r9)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            r9.<init>()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            boolean r10 = r7.containsKey(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            if (r10 == 0) goto L7a
            java.util.ArrayList r9 = p386j6.C10713c.m65401k(r7, r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
        L7a:
            r8.m251y(r9)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            r9.<init>()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8e
            boolean r10 = r7.containsKey(r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d
            if (r10 == 0) goto L94
            java.util.ArrayList r9 = p386j6.C10713c.m65401k(r7, r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d
            goto L94
        L8d:
            r3 = r9
        L8e:
            java.lang.String r7 = "getStringArrayList is error"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r4, r7)
            r9 = r3
        L94:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            boolean r10 = p699v4.C13348q.m80084d(r9)
            if (r10 == 0) goto Lbc
            java.lang.String r10 = p648t5.C12939b.f58984c
            boolean r0 = r9.contains(r10)
            if (r0 == 0) goto Lab
            r7.add(r10)
            goto Lbc
        Lab:
            java.lang.String r10 = p648t5.C12939b.f58985d
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto Lb7
            r7.add(r10)
            goto Lbc
        Lb7:
            java.lang.String r9 = "There is no need count uri."
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r4, r9)
        Lbc:
            r8.m239A(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p648t5.C12939b.m77708g(android.content.Context, java.lang.String, android.os.Bundle):a6.a$a");
    }

    /* renamed from: h */
    public b m77709h(Context context, a aVar) throws Throwable {
        if (context == null || aVar == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (aVar.f58986a != null) {
            Iterator it = aVar.f58986a.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    arrayList.add(cVar.f58991a);
                    arrayList2.add(Integer.valueOf(cVar.f58992b));
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("version", aVar.f58987b);
        bundle.putStringArrayList("uri_list", arrayList);
        bundle.putIntegerArrayList("count_list", arrayList2);
        Bundle bundleM12615a = C2108a.m12615a(context, this.f130a, "backup_recover_start", null, m223d(bundle));
        if (bundleM12615a == null) {
            return null;
        }
        b bVar = new b();
        if (bundleM12615a.containsKey("permit")) {
            bVar.m77718f(C10713c.m65392b(bundleM12615a, "permit", false));
        }
        if (bundleM12615a.containsKey("uri_list")) {
            bVar.m77720h(C10713c.m65401k(bundleM12615a, "uri_list"));
        }
        if (bundleM12615a.containsKey("restore_tar_file_path")) {
            bVar.m77719g(C10713c.m65400j(bundleM12615a, "restore_tar_file_path"));
        }
        return bVar;
    }

    /* renamed from: t5.b$a */
    public static class a {

        /* renamed from: a */
        public ArrayList<c> f58986a;

        /* renamed from: b */
        public int f58987b;

        public a() {
            this.f58986a = new ArrayList<>();
        }

        /* renamed from: c */
        public void m77712c(int i10) {
            this.f58987b = i10;
        }

        public a(int i10, ArrayList<c> arrayList) {
            new ArrayList();
            this.f58986a = arrayList;
            this.f58987b = i10;
        }
    }
}
