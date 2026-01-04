package p485n5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import java.util.ArrayList;
import p007a6.C0052a;
import p386j6.C10713c;
import p699v4.C13348q;

/* renamed from: n5.b */
/* loaded from: classes.dex */
public class C11635b extends C0052a {
    public C11635b(Uri uri) {
        super(uri);
    }

    @Override // p007a6.C0052a
    /* renamed from: b */
    public C0052a.a mo221b(Context context, String str) {
        Bundle bundleM12615a;
        if (context == null || (bundleM12615a = C2108a.m12615a(context, this.f130a, "backup_query", null, m223d(null))) == null) {
            return null;
        }
        C0052a.a aVar = new C0052a.a();
        aVar.m250x(C10713c.m65395e(bundleM12615a, "version", 0));
        aVar.m252z(C10713c.m65401k(bundleM12615a, "uri_list"));
        aVar.m239A(C10713c.m65401k(bundleM12615a, "uri_list_need_count"));
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (C13348q.m80084d(aVar.m248v())) {
            int size = aVar.m248v().size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(aVar.m248v().get(i10));
            }
        }
        if (C13348q.m80084d(aVar.m249w())) {
            int size2 = aVar.m249w().size();
            for (int i11 = 0; i11 < size2; i11++) {
                arrayList2.add(aVar.m249w().get(i11));
            }
        }
        aVar.m252z(arrayList);
        aVar.m239A(arrayList2);
        return aVar;
    }
}
