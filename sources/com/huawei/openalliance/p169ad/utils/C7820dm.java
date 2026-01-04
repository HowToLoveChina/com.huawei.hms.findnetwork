package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.dm */
/* loaded from: classes2.dex */
public class C7820dm {
    /* renamed from: a */
    public static String m48376a(Context context) {
        Uri uri;
        String string = "";
        Cursor cursorQuery = null;
        try {
            try {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            } catch (Exception unused) {
                AbstractC7185ho.m43823c("VIdentifierManager", "contentResolver query exception");
                if (0 != 0) {
                }
            }
            if (!AbstractC7741ao.m47563b(context, uri)) {
                Log.w("VIdentifierManager", "invalid provider");
                return "";
            }
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }
}
