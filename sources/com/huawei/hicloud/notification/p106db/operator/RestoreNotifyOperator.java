package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.script.RestoreNotifyScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class RestoreNotifyOperator extends AbstractC0315c<RestoreNotifyConfig> {
    private static final String TAG = "RestoreNotifyOperator";

    public void batchInsert(List<RestoreNotifyConfig> list) {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList = new ArrayList();
        Iterator<RestoreNotifyConfig> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getBatchInsertArgs(it.next()));
        }
        try {
            execSQL4Batch(RestoreNotifyScript.SQL_RESTORE_NOTIFY_INSERT, arrayList);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "batchInsert exception:" + e10.toString());
        }
    }

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(RestoreNotifyScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public String[] getBatchInsertArgs(RestoreNotifyConfig restoreNotifyConfig) {
        String[] strArr = new String[9];
        strArr[0] = restoreNotifyConfig.getId();
        strArr[1] = restoreNotifyConfig.getHoursAfterOOBE();
        strArr[2] = restoreNotifyConfig.getTimesInHours();
        strArr[3] = restoreNotifyConfig.getFirstTrigAfter() == null ? "0" : restoreNotifyConfig.getFirstTrigAfter();
        strArr[4] = restoreNotifyConfig.getStartTimeOfDruation();
        strArr[5] = restoreNotifyConfig.getEndTimeOfDruation();
        strArr[6] = restoreNotifyConfig.getLoginState();
        strArr[7] = restoreNotifyConfig.getNoticeType();
        strArr[8] = restoreNotifyConfig.getPriority();
        return strArr;
    }

    public RestoreNotifyConfig getRestoreNotifyConfig(String str) throws Throwable {
        try {
            List<RestoreNotifyConfig> listQueryResult4Vo = queryResult4Vo(RestoreNotifyScript.SQL_GET_RESTORE_NOTIFY_CONFIG, new String[]{str});
            if (listQueryResult4Vo == null) {
                NotifyLogger.m29916w(TAG, "configs is null, return empty list");
                return null;
            }
            NotifyLogger.m29913d(TAG, "configs.size():" + listQueryResult4Vo.size());
            return listQueryResult4Vo.get(0);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getRestoreNotifyConfig exception:" + e10.toString());
            return null;
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(RestoreNotifyScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public RestoreNotifyConfig getVo(Cursor cursor) {
        RestoreNotifyConfig restoreNotifyConfig = new RestoreNotifyConfig();
        restoreNotifyConfig.setId(cursor.getString(0));
        restoreNotifyConfig.setHoursAfterOOBE(cursor.getString(1));
        restoreNotifyConfig.setTimesInHours(cursor.getString(2));
        restoreNotifyConfig.setFirstTrigAfter(cursor.getString(3));
        restoreNotifyConfig.setStartTime(cursor.getString(4));
        restoreNotifyConfig.setEndTime(cursor.getString(5));
        restoreNotifyConfig.setState(cursor.getString(6));
        restoreNotifyConfig.setNoticeType(cursor.getString(7));
        restoreNotifyConfig.setPriority(cursor.getString(8));
        return restoreNotifyConfig;
    }
}
