package p030b6;

import android.content.Context;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import java.util.List;
import p218d6.C9042a;
import p218d6.C9043b;
import p218d6.C9044c;
import p229di.C9142g;
import p386j6.C10713c;
import p699v4.C13347p;

/* renamed from: b6.a */
/* loaded from: classes.dex */
public class C1119a {

    /* renamed from: a */
    public static final Uri f5340a;

    static {
        f5340a = C13347p.m80079b(C9142g.m57463b() ? "content://com.hihonor.android.weather" : "content://com.huawei.android.weather");
    }

    /* renamed from: a */
    public static C9042a m6671a(Context context) {
        Bundle bundleM12615a;
        if (context == null || (bundleM12615a = C2108a.m12615a(context, f5340a, "backup_query", null, null)) == null || !bundleM12615a.containsKey("uri_list") || !bundleM12615a.containsKey("uri_list_need_count")) {
            return null;
        }
        try {
            return new C9042a(C10713c.m65394d(bundleM12615a, "version"), C10713c.m65401k(bundleM12615a, "uri_list"), C10713c.m65401k(bundleM12615a, "uri_list_need_count"));
        } catch (BadParcelableException | ArrayIndexOutOfBoundsException unused) {
            C2111d.m12648d("ModuleProtocol", "read info data error.");
            return null;
        }
    }

    /* renamed from: b */
    public static List<String> m6672b(Context context) {
        Bundle bundleM12615a;
        ArrayList arrayList = new ArrayList();
        return (context == null || (bundleM12615a = C2108a.m12615a(context, f5340a, "backup_query", null, null)) == null || !bundleM12615a.containsKey("uri_list")) ? arrayList : C10713c.m65401k(bundleM12615a, "uri_list");
    }

    /* renamed from: c */
    public static C9043b m6673c(Context context) throws Throwable {
        C9043b c9043b = null;
        if (context == null) {
            return null;
        }
        Bundle bundleM12615a = C2108a.m12615a(context, f5340a, "backup_recover_complete", null, null);
        if (bundleM12615a != null) {
            c9043b = new C9043b();
            if (bundleM12615a.containsKey("success_count")) {
                c9043b.m57011d(C10713c.m65395e(bundleM12615a, "success_count", 0));
            }
            if (bundleM12615a.containsKey("fail_count")) {
                c9043b.m57010c(C10713c.m65395e(bundleM12615a, "fail_count", 0));
            }
            if (c9043b.m57008a() > 0) {
                C2111d.m12649e("ModuleProtocol", "restoreComplete, success: ", Integer.valueOf(c9043b.m57009b()), ", failed: ", Integer.valueOf(c9043b.m57008a()));
            }
        }
        return c9043b;
    }

    /* renamed from: d */
    public static C9044c m6674d(Context context, int i10) throws Throwable {
        C9044c c9044c = null;
        if (context == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("version", i10);
        Bundle bundleM12615a = C2108a.m12615a(context, f5340a, "backup_recover_start", null, bundle);
        if (bundleM12615a != null) {
            c9044c = new C9044c();
            if (bundleM12615a.containsKey("permit")) {
                c9044c.m57013b(C10713c.m65392b(bundleM12615a, "permit", false));
            }
        }
        return c9044c;
    }
}
