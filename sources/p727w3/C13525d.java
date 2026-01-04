package p727w3;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.shaded.protobuf.C1944q;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import p005a4.C0035o;
import p631s3.InterfaceC12688k;
import p831z3.C14094c0;
import p831z3.C14120t;

/* renamed from: w3.d */
/* loaded from: classes.dex */
public final class C13525d implements InterfaceC12688k {

    /* renamed from: a */
    public final SharedPreferences f60886a;

    /* renamed from: b */
    public final String f60887b;

    public C13525d(Context context, String str, String str2) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.f60887b = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.f60886a = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        } else {
            this.f60886a = applicationContext.getSharedPreferences(str2, 0);
        }
    }

    @Override // p631s3.InterfaceC12688k
    /* renamed from: a */
    public C14120t mo76351a() throws IOException {
        return C14120t.m84712R(m81400b(), C1944q.m12103b());
    }

    /* renamed from: b */
    public final byte[] m81400b() throws IOException {
        try {
            String string = this.f60886a.getString(this.f60887b, null);
            if (string != null) {
                return C0035o.m143a(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.f60887b));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.f60887b));
        }
    }

    @Override // p631s3.InterfaceC12688k
    public C14094c0 read() throws IOException {
        return C14094c0.m84475W(m81400b(), C1944q.m12103b());
    }
}
