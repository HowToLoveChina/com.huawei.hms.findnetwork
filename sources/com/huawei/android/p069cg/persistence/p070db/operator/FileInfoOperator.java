package com.huawei.android.p069cg.persistence.p070db.operator;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.huawei.android.hicloud.constant.CommonConstants;
import p031b7.C1120a;
import p031b7.C1122c;
import p850zo.InterfaceC14351b;

/* loaded from: classes2.dex */
public class FileInfoOperator {

    /* renamed from: a */
    public Context f11036a;

    public FileInfoOperator(Context context) {
        this.f11036a = context;
    }

    /* renamed from: a */
    public int m14552a() {
        C1120a.m6677i("FileInfoOperator", "queryLocalMediaFile begin");
        ContentResolver contentResolver = this.f11036a.getContentResolver();
        int i10 = -1;
        if (contentResolver == null) {
            C1120a.m6676e("FileInfoOperator", "queryLocalMediaFile resolver is null");
            return -1;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(CommonConstants.GalleryInfo.f12134n, null, null, null, null);
            } catch (SQLiteException unused) {
                C1120a.m6676e("FileInfoOperator", "queryLocalMediaFile SQLiteException");
            } catch (Exception e10) {
                C1120a.m6676e("FileInfoOperator", "queryLocalMediaFile error: " + e10.toString());
            }
            if (cursorQuery == null) {
                C1120a.m6676e("FileInfoOperator", "queryLocalMediaFile cursor is null");
                return -1;
            }
            C1120a.m6675d("FileInfoOperator", "queryLocalMediaFile count is: " + cursorQuery.getCount());
            if (!cursorQuery.moveToFirst()) {
                C1120a.m6675d("FileInfoOperator", "queryLocalMediaFile no record");
                return -1;
            }
            do {
                i10 = cursorQuery.getInt(0);
                C1120a.m6675d("FileInfoOperator", "queryLocalMediaFile pic video counts: " + i10);
            } while (cursorQuery.moveToNext());
            return i10;
        } finally {
            C1122c.m6832t(null);
        }
    }

    /* renamed from: b */
    public void m14553b(InterfaceC14351b interfaceC14351b) {
        int iM14552a = m14552a();
        Bundle bundle = new Bundle();
        C1120a.m6675d("FileInfoOperator", "isExistMediaFile result:" + iM14552a);
        if (iM14552a == 1) {
            bundle.putBoolean("haveMediaFile", true);
            interfaceC14351b.onResult(bundle);
        } else {
            bundle.putBoolean("haveMediaFile", false);
            interfaceC14351b.onResult(bundle);
        }
    }
}
