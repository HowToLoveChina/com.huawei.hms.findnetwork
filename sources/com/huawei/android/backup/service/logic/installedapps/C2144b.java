package com.huawei.android.backup.service.logic.installedapps;

import android.content.ContentValues;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p006a5.AbstractC0048c;
import p248e5.C9408a;
import p248e5.C9413f;
import p699v4.C13334c;
import p699v4.C13348q;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.b */
/* loaded from: classes.dex */
public class C2144b {
    /* renamed from: a */
    public static String m12901a(String str, String str2) {
        C2111d.m12653i("AppSecurityUtils", "Create clone security info.");
        C9408a c9408aM59012f = C9408a.m59012f();
        String strM59015d = c9408aM59012f.m59015d();
        String strM59014c = c9408aM59012f.m59014c(strM59015d, str);
        String strM59014c2 = c9408aM59012f.m59014c(strM59015d, str2);
        if (strM59014c2 != null || strM59014c != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strM59014c2);
            stringBuffer.append("_");
            stringBuffer.append(strM59014c);
            c9408aM59012f.m59018h(stringBuffer.toString());
            return c9408aM59012f.m59013a();
        }
        C2111d.m12648d("AppSecurityUtils", "Create clone security fail. datapath:" + str + " apkFilePath:" + str2);
        return null;
    }

    /* renamed from: b */
    public static Map<String, String> m12902b(AbstractC0048c abstractC0048c) {
        if (!abstractC0048c.mo172d(abstractC0048c.m196n())) {
            C2111d.m12648d("AppSecurityUtils", "getAppValidMessage open db error");
            return Collections.emptyMap();
        }
        ContentValues[] contentValuesArrM199r = abstractC0048c.m199r("valid_info");
        if (contentValuesArrM199r == null || contentValuesArrM199r.length == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(contentValuesArrM199r.length);
        for (ContentValues contentValues : contentValuesArrM199r) {
            map.put(contentValues.getAsString(ContentResource.FILE_NAME), contentValues.getAsString("hash_value"));
        }
        return map;
    }

    /* renamed from: c */
    public static void m12903c(String str, ArrayList<String> arrayList, AbstractC0048c abstractC0048c) {
        if (TextUtils.isEmpty(str) || C13348q.m80082b(arrayList) || abstractC0048c == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String str2 = arrayList.get(i10);
            ContentValues contentValues = new ContentValues();
            contentValues.put("packageName", str);
            contentValues.put(ContentResource.FILE_NAME, new File(str2).getName());
            contentValues.put("hash_value", C9413f.m59034b(str2));
            contentValuesArr[i10] = contentValues;
        }
        if (abstractC0048c.mo186B("valid_info", contentValuesArr, null, null) == 2) {
            C2111d.m12648d("AppSecurityUtils", "saveAppValidMessage fail");
        }
        C2111d.m12654j("AppSecurityUtils", "Performance saveAppValidMessage cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), " ms, size ", Long.valueOf(new File(arrayList.get(0)).length()));
    }

    /* renamed from: d */
    public static boolean m12904d(AbstractC0048c abstractC0048c, ArrayList<String> arrayList) {
        if (abstractC0048c == null || arrayList == null) {
            return false;
        }
        Map<String, String> mapM12902b = m12902b(abstractC0048c);
        if (mapM12902b.isEmpty()) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!C9413f.m59034b(next).equals(mapM12902b.get(!BackupObject.isSupportBundleApp() ? "base.apk" : new File(next).getName()))) {
                C2111d.m12648d("AppSecurityUtils", "validApkHashValues fail");
                return false;
            }
        }
        C2111d.m12654j("AppSecurityUtils", "Performance validApkHashValues cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), " ms");
        return true;
    }

    /* renamed from: e */
    public static boolean m12905e(String str, String str2, String str3) {
        if (str == null || str3 == null || str2 == null) {
            C2111d.m12648d("AppSecurityUtils", "validateCloneSecurityInfo param is null");
            return false;
        }
        C9408a c9408aM59012f = C9408a.m59012f();
        if (c9408aM59012f == null) {
            C2111d.m12648d("AppSecurityUtils", "cs is null");
            return false;
        }
        if (!c9408aM59012f.m59017g(str2)) {
            C2111d.m12648d("AppSecurityUtils", "parseSecurityMsg fail");
            return false;
        }
        String strM59015d = c9408aM59012f.m59015d();
        String strM59016e = c9408aM59012f.m59016e();
        if (strM59016e == null) {
            C2111d.m12648d("AppSecurityUtils", "fileHash is null");
            return false;
        }
        String[] strArrSplit = strM59016e.split("_");
        if (strArrSplit.length < 1 || strArrSplit.length > 2) {
            C2111d.m12648d("AppSecurityUtils", "checkMsg length is error ");
            return false;
        }
        String str4 = new File(str).getParent() + File.separator + str3 + C13334c.m79984q();
        if (strArrSplit[0] != null && new File(str4).exists() && !c9408aM59012f.m59019i(strM59015d, str4, strArrSplit[0])) {
            C2111d.m12648d("AppSecurityUtils", "validateFile apk fail");
            return false;
        }
        if (strArrSplit[1] == null || !new File(str).exists() || c9408aM59012f.m59019i(strM59015d, str, strArrSplit[1])) {
            return true;
        }
        C2111d.m12648d("AppSecurityUtils", "validateFile apk data fail");
        return false;
    }
}
