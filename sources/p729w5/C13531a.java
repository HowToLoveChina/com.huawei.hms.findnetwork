package p729w5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p007a6.AbstractC0053b;
import p229di.C9142g;
import p386j6.C10713c;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: w5.a */
/* loaded from: classes.dex */
public class C13531a extends AbstractC0053b {

    /* renamed from: b */
    public static final Uri f60893b;

    /* renamed from: c */
    public static final String f60894c;

    /* renamed from: d */
    public static final String f60895d;

    static {
        f60893b = C13347p.m80079b(C9142g.m57463b() ? "content://com.hihonor.systemmanager.BackupModuleProvider" : "content://com.huawei.systemmanager.BackupModuleProvider");
        f60894c = C9142g.m57463b() ? "content://com.hihonor.systemmanager.HarassmentInterceptionDBProvider" : "content://com.huawei.systemmanager.HarassmentInterceptionDBProvider";
        f60895d = C9142g.m57463b() ? "content://com.hihonor.permissionmanager.provider.PermissionDataProvider" : "content://com.huawei.permissionmanager.provider.PermissionDataProvider";
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        Bundle bundleM12615a;
        ArrayList<String> arrayList = new ArrayList<>(0);
        if (context == null || (bundleM12615a = C2108a.m12615a(context, f60893b, "all_module_provider_uri_query", null, reassembleExtra(null))) == null) {
            return arrayList;
        }
        ArrayList<String> arrayListM65401k = C10713c.m65401k(bundleM12615a, "all_module_provider_uri_list");
        if (arrayListM65401k.size() > 0) {
            arrayListM65401k.remove(f60894c);
        }
        return arrayListM65401k;
    }

    /* renamed from: I */
    public final void m81426I(List<AbstractC0053b.c> list) {
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null) {
                cVar.m368n();
            }
        }
        for (AbstractC0053b.c cVar2 : list) {
            if (cVar2 != null) {
                cVar2.m356h();
            }
        }
    }

    /* renamed from: J */
    public final List<AbstractC0053b.c> m81427J(List<AbstractC0053b.c> list) {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && cVar.mo362k()) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, "restore");
        if (listMo301w.isEmpty()) {
            return 5;
        }
        List<AbstractC0053b.c> listM81427J = m81427J(listMo301w);
        for (AbstractC0053b.c cVar : listM81427J) {
            if (cVar != null) {
                this.subKeyTotalNum += cVar.m325J();
            }
        }
        if (this.subKeyTotalNum != 0) {
            m81426I(listM81427J);
            return 4;
        }
        sendMsg(9, 1, 1, callback, obj);
        sendMsg(5, 1, 1, callback, obj);
        C2111d.m12646b("BackupPhoneManager", "There is no value in back table!");
        return 5;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: w */
    public List<AbstractC0053b.c> mo301w(Context context, AbstractC0048c abstractC0048c, InterfaceC2155n interfaceC2155n, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        ArrayList<String> arrayListMo296C = mo296C(context, str, str2);
        if (C13348q.m80082b(arrayListMo296C)) {
            return arrayList;
        }
        Iterator<String> it = arrayListMo296C.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                int iM13211s = C2157a.m13211s();
                C2111d.m12647c("BackupPhoneManager", "emuiApiLevel = ", Integer.valueOf(iM13211s));
                if (!f60895d.equals(next) || iM13211s > 8) {
                    Uri uriM80079b = C13347p.m80079b(next);
                    arrayList.add(new AbstractC0053b.c(interfaceC2155n, context, abstractC0048c, new C13532b(uriM80079b), str, m297D(uriM80079b)));
                }
            }
        }
        return arrayList;
    }
}
