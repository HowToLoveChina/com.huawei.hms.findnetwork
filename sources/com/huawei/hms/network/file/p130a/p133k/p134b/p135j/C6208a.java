package com.huawei.hms.network.file.p130a.p133k.p134b.p135j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.SecurityBase64Utils;
import com.huawei.hms.network.embedded.C6134w1;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.p130a.p133k.p134b.p135j.C6209b;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import gu.C10048b;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.hms.network.file.a.k.b.j.a */
/* loaded from: classes8.dex */
final class C6208a {

    /* renamed from: a */
    private static byte[] f29338a;

    /* renamed from: a */
    private static byte[] m36130a(PLSharedPreferences pLSharedPreferences, boolean z10) throws NoSuchAlgorithmException, C6209b.b, UnsupportedEncodingException {
        byte[] bArrDecode;
        String string = pLSharedPreferences.getString("animal", "");
        String strM62482d = C6210c.m36135a().m62482d();
        if (!TextUtils.isEmpty(string)) {
            bArrDecode = SecurityBase64Utils.decode(AesGcm.decrypt(string, strM62482d), 0);
        } else {
            if (!z10) {
                FLogger.m36351e(C6134w1.f28828a, "getKeyImpl KeyNotFoundException");
                throw new C6209b.b("The workKey does not exist");
            }
            bArrDecode = C10048b.m62472d(16);
            String strEncrypt = AesGcm.encrypt(SecurityBase64Utils.encodeToString(bArrDecode, 0), strM62482d);
            SharedPreferences.Editor editorEdit = pLSharedPreferences.edit();
            editorEdit.putString("animal", strEncrypt);
            editorEdit.apply();
            FLogger.m36353i(C6134w1.f28828a, "generate work key success", new Object[0]);
        }
        if (bArrDecode != null && bArrDecode.length != 0) {
            return bArrDecode;
        }
        if (!z10) {
            throw new C6209b.b("WorkKey is invalid");
        }
        FLogger.m36355w(C6134w1.f28828a, "WorkKey is Empty!", new Object[0]);
        SharedPreferences.Editor editorEdit2 = pLSharedPreferences.edit();
        editorEdit2.putString("animal", "");
        editorEdit2.apply();
        return m36130a(pLSharedPreferences, true);
    }

    /* renamed from: a */
    public static byte[] m36131a(boolean z10) {
        byte[] bArr;
        synchronized (C6208a.class) {
            try {
                byte[] bArr2 = f29338a;
                if (bArr2 == null || bArr2.length == 0) {
                    f29338a = m36130a(new PLSharedPreferences(ContextHolder.getAppContext(), "fmfruit"), z10);
                }
                bArr = f29338a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArr;
    }
}
