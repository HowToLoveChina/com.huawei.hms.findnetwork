package p007a6;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import p006a5.AbstractC0048c;
import p386j6.C10713c;
import p699v4.C13348q;

/* renamed from: a6.a */
/* loaded from: classes.dex */
public class C0052a {

    /* renamed from: a */
    public Uri f130a;

    /* renamed from: b */
    public Bundle f131b;

    /* renamed from: a6.a$a */
    public static class a {

        /* renamed from: a */
        public int f132a;

        /* renamed from: b */
        public ArrayList<String> f133b;

        /* renamed from: c */
        public long f134c;

        /* renamed from: d */
        public ArrayList<String> f135d;

        /* renamed from: e */
        public ArrayList<String> f136e;

        /* renamed from: f */
        public ArrayList<String> f137f;

        /* renamed from: g */
        public ArrayList<String> f138g;

        /* renamed from: h */
        public ArrayList<String> f139h;

        /* renamed from: i */
        public String f140i;

        /* renamed from: j */
        public ArrayList<String> f141j;

        /* renamed from: A */
        public void m239A(ArrayList<String> arrayList) {
            this.f135d = arrayList;
        }

        /* renamed from: n */
        public ArrayList<String> m240n() {
            return this.f137f;
        }

        /* renamed from: o */
        public int m241o() {
            return this.f132a;
        }

        /* renamed from: p */
        public ArrayList<String> m242p() {
            return this.f139h;
        }

        /* renamed from: q */
        public String m243q() {
            return this.f140i;
        }

        /* renamed from: r */
        public ArrayList<String> m244r() {
            return this.f138g;
        }

        /* renamed from: s */
        public long m245s() {
            return this.f134c;
        }

        /* renamed from: t */
        public ArrayList<String> m246t() {
            return this.f136e;
        }

        /* renamed from: u */
        public ArrayList<String> m247u() {
            return this.f141j;
        }

        /* renamed from: v */
        public ArrayList<String> m248v() {
            return this.f133b;
        }

        /* renamed from: w */
        public ArrayList<String> m249w() {
            return this.f135d;
        }

        /* renamed from: x */
        public void m250x(int i10) {
            this.f132a = i10;
        }

        /* renamed from: y */
        public void m251y(ArrayList<String> arrayList) {
            this.f141j = arrayList;
        }

        /* renamed from: z */
        public void m252z(ArrayList<String> arrayList) {
            this.f133b = arrayList;
        }
    }

    /* renamed from: a6.a$b */
    public static class b {

        /* renamed from: a */
        public int f142a;

        /* renamed from: b */
        public int f143b;

        /* renamed from: a */
        public int m253a() {
            return this.f143b;
        }

        /* renamed from: b */
        public int m254b() {
            return this.f142a;
        }

        /* renamed from: c */
        public void m255c(int i10) {
            this.f143b = i10;
        }

        /* renamed from: d */
        public void m256d(int i10) {
            this.f142a = i10;
        }
    }

    /* renamed from: a6.a$c */
    public static class c {

        /* renamed from: a */
        public boolean f144a;

        /* renamed from: b */
        public ArrayList<String> f145b;

        /* renamed from: c */
        public ArrayList<String> f146c;

        /* renamed from: d */
        public ArrayList<String> f147d;

        /* renamed from: e */
        public ArrayList<String> f148e;

        /* renamed from: f */
        public Bundle f149f;

        /* renamed from: g */
        public Bundle f150g;

        /* renamed from: a */
        public Bundle m257a() {
            return this.f150g;
        }

        /* renamed from: b */
        public Bundle m258b() {
            return this.f149f;
        }

        /* renamed from: c */
        public ArrayList<String> m259c() {
            return this.f148e;
        }

        /* renamed from: d */
        public ArrayList<String> m260d() {
            return this.f145b;
        }

        /* renamed from: e */
        public ArrayList<String> m261e() {
            return this.f146c;
        }

        /* renamed from: f */
        public ArrayList<String> m262f() {
            return this.f147d;
        }

        /* renamed from: g */
        public boolean m263g() {
            return this.f144a;
        }

        /* renamed from: h */
        public void m264h(Bundle bundle) {
            this.f150g = bundle;
        }

        /* renamed from: i */
        public void m265i(Bundle bundle) {
            this.f149f = bundle;
        }

        /* renamed from: j */
        public void m266j(ArrayList<String> arrayList) {
            this.f148e = arrayList;
        }

        /* renamed from: k */
        public void m267k(boolean z10) {
            this.f144a = z10;
        }

        /* renamed from: l */
        public void m268l(ArrayList<String> arrayList) {
            this.f145b = arrayList;
        }

        /* renamed from: m */
        public void m269m(ArrayList<String> arrayList) {
            this.f146c = arrayList;
        }

        /* renamed from: n */
        public void m270n(ArrayList<String> arrayList) {
            this.f147d = arrayList;
        }
    }

    public C0052a(Uri uri) {
        this(uri, null);
    }

    /* renamed from: a */
    public void m220a(Context context) throws Throwable {
        if (context == null || this.f130a == null) {
            return;
        }
        if (BackupConstant.m13133g().get("chatSms").equals(this.f130a.toString())) {
            C2111d.m12653i("SubModuleProtocol", "backupComplete module is rcs");
        } else {
            C2108a.m12615a(context, this.f130a, NotifyConstants.BACKUP_COMPLETE, null, m223d(null));
        }
    }

    /* renamed from: b */
    public a mo221b(Context context, String str) throws Throwable {
        a aVar = null;
        if (context == null) {
            return null;
        }
        Bundle bundleM12615a = C2108a.m12615a(context, this.f130a, "backup_query", str, m223d(null));
        if (bundleM12615a != null) {
            aVar = new a();
            aVar.f132a = C10713c.m65394d(bundleM12615a, "version");
            aVar.f140i = C10713c.m65400j(bundleM12615a, "extra_data");
            try {
                aVar.f133b = C10713c.m65401k(bundleM12615a, "uri_list");
                aVar.f135d = C10713c.m65401k(bundleM12615a, "uri_list_need_count");
                aVar.f136e = C10713c.m65401k(bundleM12615a, "openfile_uri_list");
                aVar.f137f = C10713c.m65401k(bundleM12615a, "data_tar_file_path_list");
                aVar.f138g = C10713c.m65401k(bundleM12615a, "copyfile_path_list");
                aVar.f139h = C10713c.m65401k(bundleM12615a, "default_restore_sd_path_list");
                aVar.f141j = C10713c.m65401k(bundleM12615a, "tar_file_path_list");
                aVar.f134c = C10713c.m65396f(bundleM12615a, "module_size");
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                C2111d.m12648d("SubModuleProtocol", "wrong bundle data.");
            }
        }
        return aVar;
    }

    /* renamed from: c */
    public a mo222c(Context context, String str, Bundle bundle) throws Throwable {
        a aVar = null;
        if (context == null) {
            C2111d.m12648d("SubModuleProtocol", "context is null");
            return null;
        }
        Bundle bundleM12615a = C2108a.m12615a(context, this.f130a, "backup_query", str, m223d(bundle));
        if (bundleM12615a != null) {
            aVar = new a();
            try {
                if (bundleM12615a.containsKey("version")) {
                    aVar.f132a = C10713c.m65395e(bundleM12615a, "version", 0);
                }
                if (bundleM12615a.containsKey("uri_list")) {
                    aVar.f133b = C10713c.m65401k(bundleM12615a, "uri_list");
                }
                if (bundleM12615a.containsKey("uri_list_need_count")) {
                    aVar.f135d = C10713c.m65401k(bundleM12615a, "uri_list_need_count");
                }
                if (bundleM12615a.containsKey("openfile_uri_list")) {
                    aVar.f136e = C10713c.m65401k(bundleM12615a, "openfile_uri_list");
                }
                if (bundleM12615a.containsKey("data_tar_file_path_list")) {
                    aVar.f137f = C10713c.m65401k(bundleM12615a, "data_tar_file_path_list");
                }
                if (bundleM12615a.containsKey("copyfile_path_list")) {
                    aVar.f138g = C10713c.m65401k(bundleM12615a, "copyfile_path_list");
                }
                if (bundleM12615a.containsKey("default_restore_sd_path_list")) {
                    aVar.f139h = C10713c.m65401k(bundleM12615a, "default_restore_sd_path_list");
                }
                if (bundleM12615a.containsKey("extra_data")) {
                    aVar.f140i = C10713c.m65400j(bundleM12615a, "extra_data");
                }
                if (bundleM12615a.containsKey("tar_file_path_list")) {
                    aVar.f141j = C10713c.m65401k(bundleM12615a, "tar_file_path_list");
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                C2111d.m12648d("SubModuleProtocol", "fail to get Bundle message.");
            }
        }
        return aVar;
    }

    /* renamed from: d */
    public Bundle m223d(Bundle bundle) {
        if (this.f131b != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putAll(this.f131b);
        }
        return bundle;
    }

    /* renamed from: e */
    public b m224e(Context context) {
        Uri uri;
        Bundle bundleM12615a;
        b bVar = null;
        if (context != null && (uri = this.f130a) != null && (bundleM12615a = C2108a.m12615a(context, uri, "backup_recover_complete", null, m223d(null))) != null) {
            bVar = new b();
            bVar.m256d(C10713c.m65395e(bundleM12615a, "success_count", 0));
            bVar.m255c(C10713c.m65395e(bundleM12615a, "fail_count", 0));
            if (bVar.m253a() > 0) {
                C2111d.m12648d("SubModuleProtocol", "restoreComplete, success: " + bVar.m254b() + ", failed: " + bVar.m253a());
            }
        }
        return bVar;
    }

    /* renamed from: f */
    public c m225f(Context context, AbstractC0048c abstractC0048c, ContentValues contentValues, long j10, HashMap<String, String> map) throws Throwable {
        c cVar = null;
        if (context == null || abstractC0048c == null || contentValues == null) {
            C2111d.m12648d("SubModuleProtocol", "context or storeHandler or versionDataInfo is null");
            return null;
        }
        Bundle bundle = new Bundle();
        int iIntValue = contentValues.getAsInteger("version").intValue();
        String asString = contentValues.getAsString("extra_data");
        bundle.putInt("version", iIntValue);
        bundle.putString("extra_data", asString);
        bundle.putLong("copy_sd_file_size", j10);
        ArrayList<String> arrayListM13187V = C2157a.m13187V(abstractC0048c, map.get("data_tar_file_path_list"));
        if (!C13348q.m80082b(arrayListM13187V)) {
            bundle.putStringArrayList("data_tar_file_path_list", arrayListM13187V);
        }
        ArrayList<String> arrayListM13187V2 = C2157a.m13187V(abstractC0048c, map.get("copyfile_path_list"));
        if (!C13348q.m80082b(arrayListM13187V2)) {
            bundle.putStringArrayList("copyfile_path_list", arrayListM13187V2);
        }
        a aVarMo221b = mo221b(context, "restore");
        if (aVarMo221b != null) {
            bundle.putStringArrayList("uri_list", aVarMo221b.f133b);
            bundle.putStringArrayList("count_list", aVarMo221b.f135d);
            bundle.putStringArrayList("openfile_uri_list", aVarMo221b.f136e);
        }
        Bundle bundleM12615a = C2108a.m12615a(context, this.f130a, "backup_recover_start", null, m223d(bundle));
        if (bundleM12615a == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                cVar2.m267k(C10713c.m65391a(bundleM12615a, "permit"));
                cVar2.m269m(C10713c.m65401k(bundleM12615a, "support_bulkInsert_uri_list"));
                cVar2.m268l(C10713c.m65401k(bundleM12615a, "restore_sd_path"));
                cVar2.m270n(C10713c.m65401k(bundleM12615a, "uri_list"));
                cVar2.m266j(C10713c.m65401k(bundleM12615a, "openfile_uri_list"));
                cVar2.m265i(C10713c.m65393c(bundleM12615a, "data_tar_file_restore_path"));
                cVar2.m264h(C10713c.m65393c(bundleM12615a, "copyfile_restore_path"));
                return cVar2;
            } catch (ArrayIndexOutOfBoundsException unused) {
                cVar = cVar2;
                C2111d.m12648d("SubModuleProtocol", "restoreStart end ArrayIndexOutOfBoundsException");
                return cVar;
            } catch (IndexOutOfBoundsException unused2) {
                cVar = cVar2;
                C2111d.m12648d("SubModuleProtocol", "restoreStart end IndexOutOfBoundsException");
                return cVar;
            }
        } catch (ArrayIndexOutOfBoundsException unused3) {
        } catch (IndexOutOfBoundsException unused4) {
        }
    }

    public C0052a(Uri uri, Bundle bundle) {
        this.f130a = uri;
        this.f131b = bundle;
    }
}
