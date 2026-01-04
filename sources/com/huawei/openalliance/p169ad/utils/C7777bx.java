package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.IntervalMethods;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;

/* renamed from: com.huawei.openalliance.ad.utils.bx */
/* loaded from: classes2.dex */
public class C7777bx {

    /* renamed from: a */
    private static final Uri f35957a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    /* renamed from: b */
    private static final Uri f35958b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();

    /* renamed from: a */
    public static Pair<String, Boolean> m47840a(Context context) {
        Cursor cursorM47538a;
        if (context != null) {
            Uri uri = f35957a;
            if (m47842a(context, uri)) {
                try {
                    cursorM47538a = AbstractC7741ao.m47538a(context, uri);
                    if (cursorM47538a != null) {
                        try {
                            if (cursorM47538a.moveToFirst()) {
                                int columnIndexOrThrow = cursorM47538a.getColumnIndexOrThrow("oaid");
                                int columnIndexOrThrow2 = cursorM47538a.getColumnIndexOrThrow("limit_track");
                                String string = cursorM47538a.getString(columnIndexOrThrow);
                                return new Pair<>(string, Boolean.valueOf(AbstractC7806cz.m48173e(string, Constants.NIL_UUID) ? true : Boolean.valueOf(cursorM47538a.getString(columnIndexOrThrow2)).booleanValue()));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                AbstractC7185ho.m43824c("OaidProviderUtil", "query oaid via provider ex: %s", th.getClass().getSimpleName());
                                AbstractC7805cy.m48142a(cursorM47538a);
                                return new Pair<>(Constants.NIL_UUID, Boolean.TRUE);
                            } finally {
                                AbstractC7805cy.m48142a(cursorM47538a);
                            }
                        }
                    }
                    return new Pair<>(Constants.NIL_UUID, Boolean.TRUE);
                } catch (Throwable th3) {
                    th = th3;
                    cursorM47538a = null;
                }
            }
        }
        return new Pair<>(Constants.NIL_UUID, Boolean.TRUE);
    }

    /* renamed from: b */
    public static boolean m47843b(Context context) {
        return m47842a(context, f35957a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m47845d(Context context) {
        Object th2;
        Cursor cursorM47538a;
        if (context == null) {
            return "";
        }
        try {
            C7124fh.m43316b(context).mo43485s(IntervalMethods.REQ_OAID_DECRYPT_KEY);
            cursorM47538a = AbstractC7741ao.m47538a(context, f35958b);
            if (cursorM47538a != null) {
                try {
                    if (cursorM47538a.moveToFirst()) {
                        return cursorM47538a.getString(cursorM47538a.getColumnIndexOrThrow("op_wk"));
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        AbstractC7185ho.m43824c("OaidProviderUtil", "get remote key ex: %s", th2.getClass().getSimpleName());
                        return "";
                    } finally {
                        AbstractC7805cy.m48142a(cursorM47538a);
                    }
                }
            }
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            cursorM47538a = null;
        }
    }

    /* renamed from: a */
    public static Pair<String, Boolean> m47841a(final Context context, String str) {
        if (context == null || !m47842a(context, f35958b) || TextUtils.isEmpty(str)) {
            return null;
        }
        final AbstractC7796cp.a aVarM48096a = AbstractC7796cp.a.m48096a(context);
        String strM48103d = aVarM48096a.m48103d();
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.bx.1
            @Override // java.lang.Runnable
            public void run() {
                if (C7124fh.m43316b(context).mo43071b(IntervalMethods.REQ_OAID_DECRYPT_KEY)) {
                    AbstractC7185ho.m43817a("OaidProviderUtil", "within oaid key time interval.");
                    return;
                }
                String strM47845d = C7777bx.m47845d(context);
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("OaidProviderUtil", "async get remote key: %s", AbstractC7806cz.m48176g(strM47845d));
                }
                aVarM48096a.m48104d(strM47845d);
            }
        });
        if (TextUtils.isEmpty(strM48103d)) {
            AbstractC7185ho.m43817a("OaidProviderUtil", "scp is empty");
            return null;
        }
        String strM48078a = AbstractC7796cp.m48078a(str, strM48103d);
        if (!TextUtils.isEmpty(strM48078a)) {
            return new Pair<>(strM48078a, Boolean.valueOf(Constants.NIL_UUID.equalsIgnoreCase(strM48078a)));
        }
        AbstractC7185ho.m43817a("OaidProviderUtil", "decrypt oaid failed.");
        return null;
    }

    /* renamed from: a */
    public static boolean m47842a(Context context, Uri uri) {
        Integer numM48428b;
        if (context == null || uri == null || (numM48428b = C7830i.m48428b(context)) == null || 30462100 > numM48428b.intValue()) {
            return false;
        }
        return AbstractC7741ao.m47563b(context, uri);
    }
}
