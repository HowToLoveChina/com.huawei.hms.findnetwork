package p469m4;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import p443l4.InterfaceC11230b;

/* renamed from: m4.l */
/* loaded from: classes.dex */
public class C11411l {

    /* renamed from: a */
    public final InterfaceC11230b f53186a;

    public C11411l(Context context, String str) {
        this.f53186a = !TextUtils.isEmpty(m68357a(context, str)) ? new C11408i(context, str) : new C11407h(context, str);
    }

    /* renamed from: a */
    public final String m68357a(Context context, String str) {
        String strM68360b = C11412m.m68360b(context, str, "agc_plugin_", "crypto");
        if (strM68360b == null) {
            return null;
        }
        try {
            return new String(C11400a.m68316b(strM68360b), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e10) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public String m68358b(String str, String str2) {
        return this.f53186a.mo67438a(str, str2);
    }
}
