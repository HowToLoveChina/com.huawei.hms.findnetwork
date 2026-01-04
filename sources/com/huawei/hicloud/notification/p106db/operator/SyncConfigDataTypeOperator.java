package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.bean.SyncConfigServiceDataType;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.script.SyncConfigDataTypeScript;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SyncConfigDataTypeOperator extends AbstractC0315c<SyncConfigServiceDataType> {
    private static final String TAG = "SyncConfigDataTypeOperator";

    private String[] getBatchInsertArgs(SyncConfigServiceDataType syncConfigServiceDataType) {
        String[] strArr = new String[5];
        strArr[0] = syncConfigServiceDataType.getServiceId();
        strArr[1] = syncConfigServiceDataType.getTypeId();
        strArr[2] = syncConfigServiceDataType.getTypeName();
        if (syncConfigServiceDataType.isShowNum()) {
            strArr[3] = FaqConstants.DISABLE_HA_REPORT;
        } else {
            strArr[3] = "false";
        }
        if (syncConfigServiceDataType.isRcycSync()) {
            strArr[4] = FaqConstants.DISABLE_HA_REPORT;
        } else {
            strArr[4] = "false";
        }
        return strArr;
    }

    public void batchInsert(String str, SyncConfigServiceDataType[] syncConfigServiceDataTypeArr) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        for (SyncConfigServiceDataType syncConfigServiceDataType : syncConfigServiceDataTypeArr) {
            syncConfigServiceDataType.setServiceId(str);
            execSQL(SyncConfigDataTypeScript.SQL_INSERT, getBatchInsertArgs(syncConfigServiceDataType));
        }
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "deleteAll ");
        try {
            execSQL(SyncConfigDataTypeScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "deleteAllData fail:" + e10.toString());
        }
    }

    public SyncConfigServiceDataType[] getDataTypesByServiceId(String str) throws Throwable {
        try {
            List<SyncConfigServiceDataType> listQueryResult4Vo = queryResult4Vo(SyncConfigDataTypeScript.SQL_GET_DATA_TYPE_BY_SERVICE_ID, new String[]{str});
            if (listQueryResult4Vo != null) {
                return (SyncConfigServiceDataType[]) listQueryResult4Vo.toArray(new SyncConfigServiceDataType[0]);
            }
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getDataTypesByServiceId exception:" + e10.toString());
        }
        return new SyncConfigServiceDataType[0];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public SyncConfigServiceDataType getVo(Cursor cursor) {
        SyncConfigServiceDataType syncConfigServiceDataType = new SyncConfigServiceDataType();
        syncConfigServiceDataType.setServiceId(cursor.getString(0));
        syncConfigServiceDataType.setTypeId(cursor.getString(1));
        syncConfigServiceDataType.setTypeName(cursor.getString(2));
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(3))) {
            syncConfigServiceDataType.setShowNum(true);
        } else {
            syncConfigServiceDataType.setShowNum(false);
        }
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(4))) {
            syncConfigServiceDataType.setRcycSync(true);
        } else {
            syncConfigServiceDataType.setRcycSync(false);
        }
        return syncConfigServiceDataType;
    }
}
