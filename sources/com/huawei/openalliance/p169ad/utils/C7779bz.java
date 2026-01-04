package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.io.Closeable;

/* renamed from: com.huawei.openalliance.ad.utils.bz */
/* loaded from: classes2.dex */
public class C7779bz {

    /* renamed from: a */
    private static final UriMatcher f35970a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f35970a = uriMatcher;
        uriMatcher.addURI("com.huawei.hms.ads.brain.open", "/insapp/query", 1);
        uriMatcher.addURI("com.huawei.hms.ads.brain.open", "/dd/sync", 14);
        uriMatcher.addURI("com.huawei.hms.ads.brain.open", "/adid/sync", 19);
    }

    /* renamed from: a */
    public static Pair<Integer, String> m47851a(Context context, String str, String str2) {
        Cursor cursor;
        Uri uri;
        if (context == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            uri = Uri.parse("content://com.huawei.hms.ads.brain.open" + str);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (!AbstractC7741ao.m47563b(context, uri)) {
            AbstractC7185ho.m43823c("OpenDcUtil", "provider uri invalid.");
            AbstractC7805cy.m48142a((Closeable) null);
            return null;
        }
        AbstractC7185ho.m43820b("OpenDcUtil", "call open dc provider");
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, new String[]{String.valueOf(f35970a.match(uri)), str2}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    Pair<Integer, String> pair = new Pair<>(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("code"))), cursorQuery.getString(cursorQuery.getColumnIndex("result")));
                    AbstractC7805cy.m48142a(cursorQuery);
                    return pair;
                }
            } catch (Throwable th3) {
                cursor = cursorQuery;
                th = th3;
                try {
                    AbstractC7185ho.m43823c("OpenDcUtil", "sendCommandToDc " + th.getClass().getSimpleName());
                    return null;
                } finally {
                    AbstractC7805cy.m48142a(cursor);
                }
            }
        }
        AbstractC7805cy.m48142a(cursorQuery);
        return null;
    }
}
