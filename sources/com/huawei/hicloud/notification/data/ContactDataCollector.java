package com.huawei.hicloud.notification.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hicloud.notification.log.NotifyLogger;
import p015ak.C0209d;
import p015ak.C0213f;
import p444l5.C11241i;

/* loaded from: classes6.dex */
public class ContactDataCollector extends BaseDataCollector {
    private static final String TAG = "ContactDataCollector";

    private void getContactInfo() {
        Uri uri;
        NotifyLogger.m29915i(TAG, "getContactInfo");
        Context contextM1377a = C0213f.m1377a();
        Cursor cursorQuery = null;
        try {
            try {
                uri = C11241i.d.f52797a;
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "Contact info error: " + e10.toString());
                if (0 == 0) {
                    return;
                }
            }
            if (!C0209d.m1227Y1(contextM1377a, uri)) {
                NotifyLogger.m29914e(TAG, "getContactInfo target app is not system");
                return;
            }
            cursorQuery = contextM1377a.getContentResolver().query(uri, new String[]{"_id"}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                this.mAmount = cursorQuery.getCount();
                NotifyLogger.m29915i(TAG, "get contact count number, result:-1");
            }
            if (cursorQuery == null) {
                return;
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    @Override // com.huawei.hicloud.notification.data.BaseDataCollector
    public void execute() {
        getContactInfo();
    }
}
