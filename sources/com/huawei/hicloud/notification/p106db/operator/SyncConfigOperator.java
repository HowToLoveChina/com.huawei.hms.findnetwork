package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SyncConfigVo;
import com.huawei.hicloud.notification.p106db.script.SyncConfigScript;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SyncConfigOperator extends AbstractC0315c<SyncConfigService> {
    private static final String TAG = "SyncConfigOperator";

    private Object[] getBatchInsertArgs(SyncConfigVo syncConfigVo) {
        return new Object[]{syncConfigVo.getId(), syncConfigVo.getName(), syncConfigVo.getIcon(), syncConfigVo.getIconPath(), syncConfigVo.getRecord(), Integer.valueOf(syncConfigVo.getRecordIndex()), Integer.valueOf(syncConfigVo.getSupportServer()), syncConfigVo.getUnstructedPath(), syncConfigVo.getUnstructedPathObs(), Integer.valueOf(syncConfigVo.getMinSyncVersion()), Integer.valueOf(syncConfigVo.getMinSyncVersionObs()), syncConfigVo.getSubUser(), syncConfigVo.getApplications(), syncConfigVo.getNotifyType(), syncConfigVo.getForceDelete(), syncConfigVo.getDatabaseId(), syncConfigVo.getKeyType(), syncConfigVo.getFingerPrints(), syncConfigVo.getIconHash()};
    }

    public void batchInsert(List<SyncConfigVo> list) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        Iterator<SyncConfigVo> it = list.iterator();
        while (it.hasNext()) {
            execSQL(SyncConfigScript.SQL_INSERT, getBatchInsertArgs(it.next()));
        }
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(SyncConfigScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public List<SyncConfigService> getAllServices() throws Throwable {
        try {
            List<SyncConfigService> listQueryResult4Vo = queryResult4Vo(SyncConfigScript.SQL_GET_ALL_SERVICE, null);
            if (listQueryResult4Vo != null) {
                return listQueryResult4Vo;
            }
            NotifyLogger.m29916w(TAG, "services is null, return empty list");
            return Collections.emptyList();
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getAllServices exception:" + e10.toString());
            return Collections.emptyList();
        }
    }

    public List<String> getAllServicesId() throws Throwable {
        List<SyncConfigService> allServices = getAllServices();
        ArrayList arrayList = new ArrayList();
        for (SyncConfigService syncConfigService : allServices) {
            if (syncConfigService != null && !TextUtils.isEmpty(syncConfigService.getId())) {
                arrayList.add(syncConfigService.getId());
            }
        }
        return arrayList;
    }

    public SyncConfigService getServiceByDatabaseId(String str) throws Throwable {
        try {
            List<SyncConfigService> listQueryResult4Vo = queryResult4Vo(SyncConfigScript.SQL_GET_SERVICE_BY_DATABASE_ID, new String[]{str});
            if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
                return null;
            }
            return listQueryResult4Vo.get(0);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getServiceByDatabaseId exception:" + e10.toString());
            return null;
        }
    }

    public SyncConfigService getServiceById(String str) throws Throwable {
        try {
            List<SyncConfigService> listQueryResult4Vo = queryResult4Vo(SyncConfigScript.SQL_GET_SERVICE_BY_ID, new String[]{str});
            if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
                return null;
            }
            return listQueryResult4Vo.get(0);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getServiceById exception:" + e10.toString());
            return null;
        }
    }

    public SyncConfigService getServiceByUntructurePath(String str) throws Throwable {
        try {
            List<SyncConfigService> listQueryResult4Vo = queryResult4Vo(C10028c.m62182c0().m62420y1() ? SyncConfigScript.SQL_GET_SERVICE_BY_UNSTRUCTURE_PATH : SyncConfigScript.SQL_GET_SERVICE_BY_UNSTRUCTUREOBS_PATH, new String[]{str});
            if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
                return null;
            }
            return listQueryResult4Vo.get(0);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getServiceByUntructurePath exception:" + e10.toString());
            return null;
        }
    }

    public void updateIconPath(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            NotifyLogger.m29914e(TAG, "updateIconPath map null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
        if (setEntrySet != null) {
            for (Map.Entry<String, String> entry : setEntrySet) {
                arrayList.add(new String[]{entry.getValue(), entry.getKey()});
            }
        }
        try {
            execSQL4Batch(SyncConfigScript.SQL_UPDATE_ICON_PATH, arrayList);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "updateIconPath exception:" + e10.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public SyncConfigService getVo(Cursor cursor) {
        SyncConfigService syncConfigService = new SyncConfigService();
        syncConfigService.setId(cursor.getString(0));
        syncConfigService.setName(cursor.getString(1));
        syncConfigService.setIcon(cursor.getString(2));
        syncConfigService.setIconPath(cursor.getString(3));
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(4))) {
            syncConfigService.setRecord(true);
        } else {
            syncConfigService.setRecord(false);
        }
        syncConfigService.setRecordIndex(cursor.getInt(5));
        syncConfigService.setSupportServer(cursor.getInt(6));
        syncConfigService.setUnstructedPath(cursor.getString(7));
        syncConfigService.setUnstructedPathObs(cursor.getString(8));
        syncConfigService.setMinSyncVersion(cursor.getInt(9));
        syncConfigService.setMinSyncVersionObs(cursor.getInt(10));
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(11))) {
            syncConfigService.setSubUser(true);
        } else {
            syncConfigService.setSubUser(false);
        }
        syncConfigService.setApplications(cursor.getString(12).split(","));
        syncConfigService.setNotifyType(cursor.getString(13));
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(14))) {
            syncConfigService.setForceDelete(true);
        } else {
            syncConfigService.setForceDelete(false);
        }
        syncConfigService.setDatabaseId(cursor.getString(15));
        syncConfigService.setKeyType(cursor.getString(16));
        String string = cursor.getString(17);
        if (TextUtils.isEmpty(string)) {
            NotifyLogger.m29913d(TAG, "getVo: fingerPrintsStr is empty, id = " + syncConfigService.getId());
        } else {
            syncConfigService.setFingerPrints(string.split(","));
        }
        syncConfigService.setIconHash(cursor.getString(18));
        return syncConfigService;
    }
}
