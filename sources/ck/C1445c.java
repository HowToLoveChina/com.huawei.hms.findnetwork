package ck;

import android.content.Context;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import p399jk.AbstractC10896a;

/* renamed from: ck.c */
/* loaded from: classes6.dex */
public class C1445c {

    /* renamed from: a */
    public static Properties f6218a = new Properties();

    /* renamed from: a */
    public static int m8321a(String str) {
        try {
            return Integer.parseInt(m8322b(str));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static String m8322b(String str) {
        return f6218a.getProperty(str, "");
    }

    /* renamed from: c */
    public static void m8323c(Context context) throws IOException {
        StringBuilder sb2;
        if (context == null) {
            AbstractC10896a.m65888w("Properties", "load assets properties fail, context is null.");
            return;
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                if (C1443a.f6214b.booleanValue()) {
                    File fileM63441g = C10278a.m63441g(context.getExternalFilesDir(""), "config.properties");
                    if (fileM63441g.exists()) {
                        AbstractC10896a.m65887i("Properties", "load external properties.");
                        inputStreamOpen = C10278a.m63444j(fileM63441g);
                    }
                }
                if (inputStreamOpen == null) {
                    AbstractC10896a.m65887i("Properties", "load assets properties.");
                    inputStreamOpen = context.getAssets().open("config.properties");
                }
                f6218a.load(inputStreamOpen);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e10) {
                        e = e10;
                        sb2 = new StringBuilder();
                        sb2.append("load properties close error.");
                        sb2.append(e);
                        AbstractC10896a.m65888w("Properties", sb2.toString());
                    }
                }
            } catch (IOException e11) {
                AbstractC10896a.m65886e("Properties", "load properties error." + e11);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e12) {
                        e = e12;
                        sb2 = new StringBuilder();
                        sb2.append("load properties close error.");
                        sb2.append(e);
                        AbstractC10896a.m65888w("Properties", sb2.toString());
                    }
                }
            }
        } catch (Throwable th2) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e13) {
                    AbstractC10896a.m65888w("Properties", "load properties close error." + e13);
                }
            }
            throw th2;
        }
    }
}
