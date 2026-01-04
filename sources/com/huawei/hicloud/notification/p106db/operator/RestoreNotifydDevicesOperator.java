package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.script.RestoreNotifyDevicesScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class RestoreNotifydDevicesOperator extends AbstractC0315c<RestoreNotifyConfig> {
    private static final String TAG = "RestoreNotifydDevicesOperator";

    public void batchInsert(RestoreNotifyConfig restoreNotifyConfig) {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = restoreNotifyConfig.getRelaseDevice().iterator();
        while (it.hasNext()) {
            arrayList.add(getBatchInsertArgs(it.next(), restoreNotifyConfig));
        }
        try {
            execSQL4Batch(RestoreNotifyDevicesScript.SQL_RESTORE_NOTIFY_DEVICES_INSERT, arrayList);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "batchInsert exception:" + e10.toString());
        }
    }

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(RestoreNotifyDevicesScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public String[] getBatchInsertArgs(String str, RestoreNotifyConfig restoreNotifyConfig) {
        return new String[]{restoreNotifyConfig.getId(), restoreNotifyConfig.getLoginState(), str};
    }

    public List<String> getReleaseDevices(String str) {
        try {
            return queryStringList(RestoreNotifyDevicesScript.SQL_GET_RELEASE_DEVICES, new String[]{str});
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getReleaseDevices exception:" + e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public RestoreNotifyConfig getVo(Cursor cursor) {
        return null;
    }

    public boolean hasRecord() {
        try {
            return queryCount(RestoreNotifyDevicesScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }
}
