package com.huawei.openalliance.p169ad.utils;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.da */
/* loaded from: classes2.dex */
public abstract class AbstractC7808da {
    /* renamed from: a */
    public static Integer m48265a(String str, int i10) {
        StringBuilder sb2;
        String str2;
        if (!TextUtils.isEmpty(str) && str.length() > i10) {
            try {
                return Integer.valueOf(Integer.parseInt(str.substring(i10, i10 + 1)));
            } catch (RuntimeException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str2 = "getSwitch RuntimeException:";
                sb2.append(str2);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("SwitchUtil", sb2.toString());
                return null;
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                str2 = "getSwitch Exception:";
                sb2.append(str2);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("SwitchUtil", sb2.toString());
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Integer m48266a(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str) || i11 < 0) {
            return null;
        }
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length < i11 + 1) {
            return null;
        }
        return m48265a(strArrSplit[i11], i10);
    }
}
