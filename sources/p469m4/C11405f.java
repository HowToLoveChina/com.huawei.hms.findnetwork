package p469m4;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import p443l4.InterfaceC11231c;
import p443l4.InterfaceC11232d;

/* renamed from: m4.f */
/* loaded from: classes.dex */
public class C11405f implements InterfaceC11232d {

    /* renamed from: a */
    public final InterfaceC11231c f53173a;

    /* renamed from: b */
    public SecretKey f53174b;

    /* renamed from: c */
    public boolean f53175c = false;

    public C11405f(InterfaceC11231c interfaceC11231c) {
        this.f53173a = interfaceC11231c;
    }

    /* renamed from: c */
    public static boolean m68342c(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    @Override // p443l4.InterfaceC11232d
    /* renamed from: a */
    public String mo67439a(String str, String str2) {
        String str3;
        if (!this.f53175c) {
            m68343b();
        }
        if (this.f53174b == null) {
            str3 = "mKey is null, return default value";
        } else {
            if (!m68342c(str)) {
                return str2;
            }
            try {
                return new String(C11410k.m68353b(this.f53174b, C11400a.m68316b(m68344d(str))), Constants.UTF_8);
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        Log.e("AGC_Mark", str3);
        return str2;
    }

    /* renamed from: b */
    public final void m68343b() {
        try {
            this.f53174b = C11410k.m68352a(new C11404e(this.f53173a.getString("/code/code1", null), this.f53173a.getString("/code/code2", null), this.f53173a.getString("/code/code3", null), this.f53173a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_Mark", "Exception when reading the 'K&I' for 'Config'.");
            this.f53174b = null;
        }
        this.f53175c = true;
    }

    /* renamed from: d */
    public final String m68344d(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            Log.e("AGC_Mark", "getRawString exception");
            return "";
        }
    }
}
