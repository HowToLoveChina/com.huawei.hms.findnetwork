package p235ds;

import android.text.TextUtils;
import as.C1016d;
import eu.C9560a;

/* renamed from: ds.f */
/* loaded from: classes8.dex */
public final class C9305f implements InterfaceC9303d {
    @Override // p235ds.InterfaceC9303d
    /* renamed from: a */
    public final String mo38472a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            C1016d.m6183c("AesSecurityCipher", "decrypt alias or content is null");
            return "";
        }
        try {
            return C9560a.m59677f(str2, str);
        } catch (Exception unused) {
            C1016d.m6185e("AesSecurityCipher", "AesGcmKS decrypt failed", true);
            return "";
        }
    }

    @Override // p235ds.InterfaceC9303d
    /* renamed from: b */
    public final String mo38473b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            C1016d.m6183c("AesSecurityCipher", "encrypt alias or content is null");
            return "";
        }
        try {
            return C9560a.m59680i(str2, str);
        } catch (Exception unused) {
            C1016d.m6185e("AesSecurityCipher", "AesGcmKS encrypt failed", true);
            return "";
        }
    }
}
