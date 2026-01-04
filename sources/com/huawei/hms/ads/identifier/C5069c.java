package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.identifier.AbstractC5074h;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;

/* renamed from: com.huawei.hms.ads.identifier.c */
/* loaded from: classes8.dex */
public class C5069c {

    /* renamed from: a */
    private static final Uri f23184a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();

    /* renamed from: b */
    private static final Uri f23185b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    /* renamed from: c */
    private static final Uri f23186c = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/sync").build();

    /* renamed from: a */
    public static AdvertisingIdClient.Info m30251a(final Context context) {
        if (!m30253a(context, f23184a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        final AbstractC5074h.a aVarM30300a = AbstractC5074h.a.m30300a(context);
        String strM30301a = aVarM30300a.m30301a();
        if (!TextUtils.isEmpty(strM30301a)) {
            String strM30270a = AbstractC5074h.m30270a(string, strM30301a);
            if (!TextUtils.isEmpty(strM30270a)) {
                return new AdvertisingIdClient.Info(strM30270a, Constants.NIL_UUID.equalsIgnoreCase(strM30270a));
            }
            Log.d("InfoProviderUtil", "decrypt oaid failed.");
            AbstractC5076j.f23213a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.c.2
                @Override // java.lang.Runnable
                public void run() {
                    aVarM30300a.m30303a(C5069c.m30259g(context));
                }
            });
            return null;
        }
        Log.d("InfoProviderUtil", "scp is empty");
        AbstractC5076j.f23213a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!aVarM30300a.m30311f() && aVarM30300a.m30307c()) {
                    Log.d("InfoProviderUtil", "within key update interval.");
                    return;
                }
                aVarM30300a.m30304b();
                aVarM30300a.m30303a(C5069c.m30259g(context));
            }
        });
        if (!aVarM30300a.m30311f()) {
            return new AdvertisingIdClient.Info(Constants.NIL_UUID, true);
        }
        Log.d("InfoProviderUtil", "update exemption record");
        aVarM30300a.m30310e();
        return null;
    }

    /* renamed from: b */
    public static void m30254b(Context context) {
        if (m30257e(context)) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = context.getContentResolver().query(f23186c, null, null, new String[]{context.getApplicationContext().getPackageName(), String.valueOf(30478300)}, null);
            } finally {
                try {
                } finally {
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                Log.i("InfoProviderUtil", "sync sdk version result: " + cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("sync_result")));
            }
        }
    }

    /* renamed from: c */
    public static AdvertisingIdClient.Info m30255c(Context context) {
        if (!m30256d(context)) {
            return new AdvertisingIdClient.Info(Constants.NIL_UUID, true);
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(f23185b, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
                String string = cursorQuery.getString(columnIndexOrThrow);
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info(string, Constants.NIL_UUID.equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
                AbstractC5076j.m30317a(cursorQuery);
                return info;
            }
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info(Constants.NIL_UUID, true);
            AbstractC5076j.m30317a(cursorQuery);
            return info2;
        } catch (Throwable th2) {
            try {
                Log.w("InfoProviderUtil", "query oaid via provider ex: " + th2.getClass().getSimpleName());
                AbstractC5076j.m30317a((Closeable) null);
                return new AdvertisingIdClient.Info(Constants.NIL_UUID, true);
            } catch (Throwable th3) {
                AbstractC5076j.m30317a((Closeable) null);
                throw th3;
            }
        }
    }

    /* renamed from: d */
    public static boolean m30256d(Context context) {
        return m30253a(context, f23185b);
    }

    /* renamed from: e */
    public static boolean m30257e(Context context) {
        return m30253a(context, f23186c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static String m30259g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            Uri uri = f23184a;
            if (!m30253a(context, uri)) {
                Log.w("InfoProviderUtil", "uri is invalid");
                return "";
            }
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("op_wk");
                int columnIndex = cursorQuery.getColumnIndex("exem_cnt");
                String string = cursorQuery.getString(columnIndexOrThrow);
                if (columnIndex >= 0) {
                    int i10 = cursorQuery.getInt(columnIndex);
                    AbstractC5074h.a aVarM30300a = AbstractC5074h.a.m30300a(context);
                    aVarM30300a.m30302a(i10);
                    if (!TextUtils.isEmpty(string)) {
                        Log.d("InfoProviderUtil", "reset exemption record");
                        aVarM30300a.m30308d();
                    }
                }
                AbstractC5076j.m30317a(cursorQuery);
                return string;
            }
            AbstractC5076j.m30317a(cursorQuery);
            return "";
        } catch (Throwable th2) {
            try {
                Log.w("InfoProviderUtil", "get remote key ex: " + th2.getClass().getSimpleName());
                return "";
            } finally {
                AbstractC5076j.m30317a((Closeable) null);
            }
        }
    }

    /* renamed from: a */
    public static void m30252a(final Context context, final InterfaceC5071e interfaceC5071e) {
        if (context == null) {
            return;
        }
        Log.d("InfoProviderUtil", "refresh scp");
        final AbstractC5074h.a aVarM30300a = AbstractC5074h.a.m30300a(context);
        if (TextUtils.isEmpty(aVarM30300a.m30301a())) {
            AbstractC5076j.f23213a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.c.3
                @Override // java.lang.Runnable
                public void run() {
                    String strM30259g = C5069c.m30259g(context);
                    Log.d("InfoProviderUtil", "get scp result:" + TextUtils.isEmpty(strM30259g));
                    aVarM30300a.m30303a(strM30259g);
                    InterfaceC5071e interfaceC5071e2 = interfaceC5071e;
                    if (interfaceC5071e2 != null) {
                        interfaceC5071e2.mo30262a();
                    }
                }
            });
        } else if (interfaceC5071e != null) {
            interfaceC5071e.mo30262a();
        }
    }

    /* renamed from: a */
    private static boolean m30253a(Context context, Uri uri) {
        Integer numM30320b;
        if (context == null || uri == null || (numM30320b = AbstractC5076j.m30320b(context)) == null || 30462100 > numM30320b.intValue()) {
            return false;
        }
        return AbstractC5076j.m30319a(context, uri);
    }
}
