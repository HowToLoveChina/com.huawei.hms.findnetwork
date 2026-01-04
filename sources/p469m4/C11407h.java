package p469m4;

import android.content.Context;
import android.util.Log;
import p443l4.InterfaceC11230b;
import p443l4.InterfaceC11232d;

/* renamed from: m4.h */
/* loaded from: classes.dex */
public class C11407h implements InterfaceC11230b {

    /* renamed from: a */
    public final Context f53179a;

    /* renamed from: b */
    public final String f53180b;

    /* renamed from: c */
    public InterfaceC11232d f53181c;

    public C11407h(Context context, String str) {
        Log.d("AGC_FixedDecrypt", "init");
        this.f53179a = context;
        this.f53180b = str;
    }

    @Override // p443l4.InterfaceC11230b
    /* renamed from: a */
    public String mo67438a(String str, String str2) {
        if (this.f53181c == null) {
            this.f53181c = m68346b();
        }
        return this.f53181c.mo67439a(C11412m.m68360b(this.f53179a, this.f53180b, "agc_", str), str2);
    }

    /* renamed from: b */
    public InterfaceC11232d m68346b() {
        return new C11406g(new C11404e(C11412m.m68360b(this.f53179a, this.f53180b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), C11412m.m68360b(this.f53179a, this.f53180b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), C11412m.m68360b(this.f53179a, this.f53180b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), C11412m.m68360b(this.f53179a, this.f53180b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", 5000));
    }
}
