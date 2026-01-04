package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class QueryAppMarketDataUtil {
    private static final String APPMARKET_AUTHORITY = "content://com.huawei.appmarket.commondata/item/11";
    private static final String TAG = "QueryAppMarketDataUtil";

    public static String getPkgChannelId(Context context, String str) {
        String string = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = query(context, str, 0);
                if (cursorQuery != null && cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID));
                }
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "getPkgChannelId exception" + e10.toString());
                if (cursorQuery != null) {
                }
            }
            C11839m.m70686d(TAG, "pkgChannelId:" + string);
            return string;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private static Cursor query(Context context, String str, int i10) {
        try {
            return C0209d.m1286n2(context, Uri.parse(APPMARKET_AUTHORITY), null, str, null, null);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "query pkgChannelId exception" + e10.toString());
            int i11 = i10 + 1;
            if (i11 < 3) {
                query(context, str, i11);
            }
            return null;
        }
    }
}
