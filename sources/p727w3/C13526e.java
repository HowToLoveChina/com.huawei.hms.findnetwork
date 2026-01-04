package p727w3;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;
import p005a4.C0035o;
import p631s3.InterfaceC12689l;
import p831z3.C14094c0;
import p831z3.C14120t;

/* renamed from: w3.e */
/* loaded from: classes.dex */
public final class C13526e implements InterfaceC12689l {

    /* renamed from: a */
    public final SharedPreferences.Editor f60888a;

    /* renamed from: b */
    public final String f60889b;

    public C13526e(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.f60889b = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.f60888a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.f60888a = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // p631s3.InterfaceC12689l
    /* renamed from: a */
    public void mo76352a(C14094c0 c14094c0) throws IOException {
        if (!this.f60888a.putString(this.f60889b, C0035o.m144b(c14094c0.mo11460j())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // p631s3.InterfaceC12689l
    /* renamed from: b */
    public void mo76353b(C14120t c14120t) throws IOException {
        if (!this.f60888a.putString(this.f60889b, C0035o.m144b(c14120t.mo11460j())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
