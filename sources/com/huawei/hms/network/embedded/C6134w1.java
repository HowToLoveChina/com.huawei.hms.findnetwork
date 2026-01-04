package com.huawei.hms.network.embedded;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.SecurityBase64Utils;
import com.huawei.hms.network.embedded.C6160y1;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.w1 */
/* loaded from: classes8.dex */
public final class C6134w1 {

    /* renamed from: a */
    public static final String f28828a = "EncryptKey";

    /* renamed from: b */
    public static byte[] f28829b = null;

    /* renamed from: c */
    public static final String f28830c = "fruit";

    /* renamed from: d */
    public static final String f28831d = "APPLE";

    /* renamed from: a */
    public static byte[] m35714a(PLSharedPreferences pLSharedPreferences, boolean z10) throws IOException {
        byte[] bArrDecode;
        String string = pLSharedPreferences.getString(f28831d, "");
        if (!TextUtils.isEmpty(string)) {
            bArrDecode = SecurityBase64Utils.decode(C6147x1.m35769a(string), 0);
        } else {
            if (!z10) {
                throw new C6160y1.b("The workKey does not exist");
            }
            bArrDecode = C6147x1.m35770a();
            String strM35771b = C6147x1.m35771b(SecurityBase64Utils.encodeToString(bArrDecode, 0));
            SharedPreferences.Editor editorEdit = pLSharedPreferences.edit();
            editorEdit.putString(f28831d, strM35771b);
            editorEdit.apply();
            Logger.m32141i(f28828a, "generate work key success");
        }
        if (bArrDecode != null && bArrDecode.length != 0) {
            return bArrDecode;
        }
        if (!z10) {
            throw new C6160y1.b("WorkKey is invalid");
        }
        Logger.m32145w(f28828a, "WorkKey is Empty!");
        SharedPreferences.Editor editorEdit2 = pLSharedPreferences.edit();
        editorEdit2.putString(f28831d, "");
        editorEdit2.apply();
        return m35714a(pLSharedPreferences, true);
    }

    /* renamed from: a */
    public static byte[] m35715a(boolean z10) throws IOException {
        byte[] bArr;
        synchronized (C6134w1.class) {
            try {
                byte[] bArr2 = f28829b;
                if (bArr2 == null || bArr2.length == 0) {
                    f28829b = m35714a(new PLSharedPreferences(ContextHolder.getAppContext(), f28830c), z10);
                }
                bArr = f28829b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArr;
    }
}
