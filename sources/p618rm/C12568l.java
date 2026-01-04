package p618rm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserManager;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0221j;
import p229di.C9136a;
import p229di.C9141f;
import p229di.C9150o;
import p229di.C9153r;
import p229di.C9154s;
import p229di.C9155t;
import p229di.C9156u;
import p514o9.C11839m;

/* renamed from: rm.l */
/* loaded from: classes6.dex */
public class C12568l {
    /* renamed from: a */
    public static int m75532a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return -1;
        }
        Object objM57496a = C9155t.m57496a((UserManager) contextM1377a.getSystemService("user"), "CloudBackup", HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK, C9153r.m57494b());
        if (objM57496a == null) {
            C11839m.m70687e("CloudBackupClonedProfileUtil", "create clone user fail");
            return -1;
        }
        int iM57495a = C9154s.m57495a(objM57496a);
        C11839m.m70688i("CloudBackupClonedProfileUtil", "create clone user success, userId is: " + iM57495a);
        return iM57495a;
    }

    /* renamed from: b */
    public static String m75533b(int i10) {
        return C0221j.m1504n(i10);
    }

    /* renamed from: c */
    public static List<String> m75534c(int i10) {
        ArrayList arrayList = new ArrayList();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && m75538g()) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> listM57490d = C9150o.m57490d(contextM1377a.getPackageManager(), intent, 0, i10);
            if (listM57490d == null) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : listM57490d) {
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    arrayList.add(str);
                    C11839m.m70688i("CloudBackupClonedProfileUtil", "clone app is: " + str);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<Integer> m75535d() {
        UserManager userManager;
        List<Object> listM57499d;
        ArrayList arrayList = new ArrayList();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || !m75538g() || (listM57499d = C9155t.m57499d((userManager = (UserManager) contextM1377a.getSystemService("user")))) == null) {
            return arrayList;
        }
        Iterator<Object> it = listM57499d.iterator();
        while (it.hasNext()) {
            int iM57495a = C9154s.m57495a(it.next());
            if (C9141f.m57460a(C9156u.m57500a(userManager, iM57495a))) {
                C11839m.m70688i("CloudBackupClonedProfileUtil", "clone user id: " + iM57495a);
                arrayList.add(Integer.valueOf(iM57495a));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static boolean m75536e(String str, int i10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return false;
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        try {
            if (C9136a.m57448a(i10)) {
                return C9150o.m57489c(packageManager, str, i10);
            }
            return false;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupClonedProfileUtil", "Exception e: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m75537f(String str, int i10) {
        Context contextM1377a = C0213f.m1377a();
        return (contextM1377a == null || C9150o.m57488b(contextM1377a.getPackageManager(), str, 64, i10) == null) ? false : true;
    }

    /* renamed from: g */
    public static boolean m75538g() {
        return true;
    }
}
