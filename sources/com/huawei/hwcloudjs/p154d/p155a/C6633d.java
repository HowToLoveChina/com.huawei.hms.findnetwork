package com.huawei.hwcloudjs.p154d.p155a;

import android.text.TextUtils;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hwcloudjs.d.a.d */
/* loaded from: classes8.dex */
public class C6633d {

    /* renamed from: a */
    private static final String f30835a = "AuthUtils";

    /* renamed from: a */
    private static boolean m37800a(String str, String str2) {
        boolean z10;
        boolean z11;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith("*")) {
            if (str2.length() > 1) {
                str2 = str2.substring(1);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (str2.endsWith("*")) {
            str2 = str2.substring(0, str2.length() - 1);
            z11 = true;
        } else {
            z11 = false;
        }
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return false;
        }
        if (iIndexOf > 0 && !z10) {
            return false;
        }
        if ((str2.length() + iIndexOf) - 1 < str.length() - 1 && !z11) {
            return false;
        }
        int iIndexOf2 = str.indexOf("/", str.startsWith("http://") ? 7 : str.startsWith("https://") ? 8 : 0);
        return iIndexOf2 == -1 || iIndexOf2 > iIndexOf;
    }

    /* renamed from: a */
    public static boolean m37801a(String str, List<String> list, AuthBean authBean) {
        C6659d.m37882c(f30835a, "checkH5App begin", true);
        C6659d.m37882c(f30835a, "checkH5App url：" + str, false);
        C6659d.m37882c(f30835a, "checkH5App permissionList：" + list, false);
        if (m37802a(authBean.getUrlList(), str)) {
            return list.isEmpty() || (authBean.getPermissionList() != null && authBean.getPermissionList().containsAll(list));
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m37802a(List<String> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            C6659d.m37881b(f30835a, "isUrlValid error!", true);
            return false;
        }
        synchronized (list) {
            try {
                if (list.size() == 0) {
                    C6659d.m37880a(f30835a, "urlList is empty", true);
                    return false;
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (m37800a(str, it.next())) {
                        C6659d.m37882c(f30835a, "isUrlValid patternStr OK", true);
                        return true;
                    }
                }
                C6659d.m37881b(f30835a, "isUrlValid patternStr fail!", true);
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
