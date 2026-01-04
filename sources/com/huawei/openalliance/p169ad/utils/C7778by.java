package com.huawei.openalliance.p169ad.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.security.interfaces.RSAPublicKey;

/* renamed from: com.huawei.openalliance.ad.utils.by */
/* loaded from: classes2.dex */
public class C7778by {

    /* renamed from: a */
    private static final Uri f35961a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_pub_store/get").build();

    /* renamed from: b */
    private static final Uri f35962b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_pub_store_ks/get").build();

    /* renamed from: c */
    private static final byte[] f35963c = new byte[0];

    /* renamed from: d */
    private static SoftReference<RSAPublicKey> f35964d;

    /* renamed from: e */
    private static SoftReference<RSAPublicKey> f35965e;

    /* renamed from: a */
    public static Pair<String, Boolean> m47846a(Context context) {
        String string;
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("OaidSettingsUtil", "exception happen: " + th2.getClass().getSimpleName());
        }
        if (!TextUtils.isEmpty(string)) {
            AbstractC7185ho.m43817a("OaidSettingsUtil", "read and decrypt oaid.");
            return C7777bx.m47841a(context, string);
        }
        ContentResolver contentResolver = context.getContentResolver();
        String string2 = Settings.Global.getString(contentResolver, "pps_oaid");
        String string3 = Settings.Global.getString(contentResolver, "pps_track_limit");
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            RSAPublicKey rSAPublicKeyM47849d = m47849d(context);
            String strM48126a = AbstractC7801cu.m48126a(string2 + string3);
            boolean zM48037a = C7788ch.m48037a(context, strM48126a, Settings.Global.getString(contentResolver, "pps_oaid_digest_pss"), rSAPublicKeyM47849d);
            AbstractC7185ho.m43818a("OaidSettingsUtil", "verifySignPss result: %s", Boolean.valueOf(zM48037a));
            if (!zM48037a) {
                f35964d = null;
                zM48037a = C7788ch.m48038a(strM48126a, Settings.Global.getString(contentResolver, "pps_oaid_digest"), m47850e(context));
                AbstractC7185ho.m43818a("OaidSettingsUtil", "verifySign result: %s", Boolean.valueOf(zM48037a));
            }
            if (!zM48037a) {
                f35965e = null;
                return null;
            }
            Boolean boolValueOf = Boolean.valueOf(string3);
            boolValueOf.booleanValue();
            return new Pair<>(string2, boolValueOf);
        }
        return null;
    }

    /* renamed from: b */
    public static String m47847b(Context context) {
        String str;
        Uri uri;
        Cursor cursorQuery = null;
        try {
            try {
                uri = f35961a;
            } catch (IllegalArgumentException e10) {
                str = "remote pub " + e10.getClass().getSimpleName();
                AbstractC7185ho.m43823c("OaidSettingsUtil", str);
                AbstractC7805cy.m48142a(cursorQuery);
                return "";
            } catch (Throwable th2) {
                str = "remote pub " + th2.getClass().getSimpleName();
                AbstractC7185ho.m43823c("OaidSettingsUtil", str);
                AbstractC7805cy.m48142a(cursorQuery);
                return "";
            }
            if (!AbstractC7741ao.m47563b(context, uri)) {
                AbstractC7805cy.m48142a((Closeable) null);
                return "";
            }
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("pub_store"));
                AbstractC7805cy.m48142a(cursorQuery);
                return string;
            }
            AbstractC7805cy.m48142a(cursorQuery);
            return "";
        } catch (Throwable th3) {
            AbstractC7805cy.m48142a(cursorQuery);
            throw th3;
        }
    }

    /* renamed from: c */
    public static String m47848c(Context context) {
        String str;
        Uri uri;
        Cursor cursorQuery = null;
        try {
            try {
                uri = f35962b;
            } catch (IllegalArgumentException e10) {
                str = "remote pub " + e10.getClass().getSimpleName();
                AbstractC7185ho.m43823c("OaidSettingsUtil", str);
                AbstractC7805cy.m48142a(cursorQuery);
                return "";
            } catch (Throwable th2) {
                str = "remote pub " + th2.getClass().getSimpleName();
                AbstractC7185ho.m43823c("OaidSettingsUtil", str);
                AbstractC7805cy.m48142a(cursorQuery);
                return "";
            }
            if (!AbstractC7741ao.m47563b(context, uri)) {
                AbstractC7805cy.m48142a((Closeable) null);
                return "";
            }
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("pub_store_ks"));
                AbstractC7805cy.m48142a(cursorQuery);
                return string;
            }
            AbstractC7805cy.m48142a(cursorQuery);
            return "";
        } catch (Throwable th3) {
            AbstractC7805cy.m48142a(cursorQuery);
            throw th3;
        }
    }

    /* renamed from: d */
    private static RSAPublicKey m47849d(Context context) {
        RSAPublicKey rSAPublicKey;
        synchronized (f35963c) {
            try {
                SoftReference<RSAPublicKey> softReference = f35964d;
                rSAPublicKey = softReference != null ? softReference.get() : null;
                if (rSAPublicKey == null) {
                    final Context applicationContext = context.getApplicationContext();
                    final AbstractC7796cp.a aVarM48096a = AbstractC7796cp.a.m48096a(applicationContext);
                    RSAPublicKey rSAPublicKeyM48036a = C7788ch.m48036a(aVarM48096a.m48105e());
                    if (rSAPublicKeyM48036a != null) {
                        f35964d = new SoftReference<>(rSAPublicKeyM48036a);
                    }
                    AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.by.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String strM47848c = C7778by.m47848c(applicationContext);
                            AbstractC7185ho.m43818a("OaidSettingsUtil", "##### remote pub store KS: %s", strM47848c);
                            aVarM48096a.m48106e(strM47848c);
                        }
                    });
                    rSAPublicKey = rSAPublicKeyM48036a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return rSAPublicKey;
    }

    /* renamed from: e */
    private static RSAPublicKey m47850e(Context context) {
        RSAPublicKey rSAPublicKey;
        synchronized (f35963c) {
            try {
                SoftReference<RSAPublicKey> softReference = f35965e;
                rSAPublicKey = softReference != null ? softReference.get() : null;
                if (rSAPublicKey == null) {
                    final Context applicationContext = context.getApplicationContext();
                    final AbstractC7796cp.a aVarM48096a = AbstractC7796cp.a.m48096a(applicationContext);
                    RSAPublicKey rSAPublicKeyM48036a = C7788ch.m48036a(aVarM48096a.m48101c());
                    if (rSAPublicKeyM48036a != null) {
                        f35965e = new SoftReference<>(rSAPublicKeyM48036a);
                    }
                    AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.by.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String strM47847b = C7778by.m47847b(applicationContext);
                            AbstractC7185ho.m43818a("OaidSettingsUtil", "##### remote pub store: %s", strM47847b);
                            aVarM48096a.m48102c(strM47847b);
                        }
                    });
                    rSAPublicKey = rSAPublicKeyM48036a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return rSAPublicKey;
    }
}
