package p469m4;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import p443l4.InterfaceC11232d;

/* renamed from: m4.g */
/* loaded from: classes.dex */
public class C11406g implements InterfaceC11232d {

    /* renamed from: a */
    public SecretKey f53176a;

    /* renamed from: b */
    public final C11404e f53177b;

    /* renamed from: c */
    public boolean f53178c = false;

    public C11406g(C11404e c11404e) {
        this.f53177b = c11404e;
    }

    /* renamed from: b */
    private void m68345b() {
        try {
            this.f53176a = C11410k.m68352a(this.f53177b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e10) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'. error is " + e10.getMessage());
            this.f53176a = null;
        }
        this.f53178c = true;
    }

    @Override // p443l4.InterfaceC11232d
    /* renamed from: a */
    public String mo67439a(String str, String str2) {
        String str3;
        if (!this.f53178c) {
            m68345b();
        }
        if (this.f53176a == null || TextUtils.isEmpty(str)) {
            str3 = "decrypt exception: secretKey = " + this.f53176a + "raw = " + str;
        } else {
            try {
                return new String(C11410k.m68353b(this.f53176a, C11400a.m68316b(str)), Constants.UTF_8);
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e10) {
                str3 = "decrypt exception:" + e10.getMessage();
            }
        }
        Log.e("AGC_LocalResource", str3);
        return str2;
    }
}
