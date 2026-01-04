package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.UrgencyNoticeInfo;
import com.huawei.hicloud.notification.p106db.script.UrgencyNoticeInfoScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class UrgencyNoticeInfoOperator extends AbstractC0315c<UrgencyNoticeInfo> {
    private static final String TAG = "UrgencyNoticeInfoOperator";

    private String[] getBatchInsertArgs(UrgencyNoticeInfo urgencyNoticeInfo) {
        return new String[]{urgencyNoticeInfo.getKey(), urgencyNoticeInfo.getValue()};
    }

    public void batchInsert(ArrayList<UrgencyNoticeInfo> arrayList) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<UrgencyNoticeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(UrgencyNoticeInfoScript.SQL_INSERT, arrayList2);
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(UrgencyNoticeInfoScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(UrgencyNoticeInfoScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public List<UrgencyNoticeInfo> query(String str) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(UrgencyNoticeInfoScript.SQL_QUERY_VALUE, new String[]{str});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public UrgencyNoticeInfo getVo(Cursor cursor) {
        UrgencyNoticeInfo urgencyNoticeInfo = new UrgencyNoticeInfo();
        urgencyNoticeInfo.setKey(cursor.getString(0));
        urgencyNoticeInfo.setValue(cursor.getString(1));
        return urgencyNoticeInfo;
    }
}
