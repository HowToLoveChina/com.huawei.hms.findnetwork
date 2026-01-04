package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.DriveConfigServiceResource;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.DriveConfigVo;
import com.huawei.hicloud.notification.p106db.script.DriveConfigScript;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class DriveConfigOperator extends AbstractC0315c<DriveConfigService> {
    private static final String TAG = "DriveConfigOperator";

    private Object[] getBatchInsertArgs(DriveConfigVo driveConfigVo) {
        return new Object[]{driveConfigVo.getId(), driveConfigVo.getAppId(), driveConfigVo.getPkgNames(), driveConfigVo.getSignHash(), driveConfigVo.getIcon(), driveConfigVo.getStyle(), driveConfigVo.getName(), driveConfigVo.getSubPageIcon(), driveConfigVo.getSubDesc(), driveConfigVo.getSubSwitchDesc(), Integer.valueOf(driveConfigVo.getMinSyncVersion()), driveConfigVo.getRecord(), Integer.valueOf(driveConfigVo.getRecordIndex()), driveConfigVo.getVersion(), driveConfigVo.getIconPath(), driveConfigVo.getSubPageIconPath(), driveConfigVo.isSubUser()};
    }

    public void batchInsert(List<DriveConfigVo> list) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        Iterator<DriveConfigVo> it = list.iterator();
        while (it.hasNext()) {
            execSQL(DriveConfigScript.SQL_INSERT, getBatchInsertArgs(it.next()));
        }
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(DriveConfigScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public List<DriveConfigService> getAllServices() {
        try {
            return Collections.emptyList();
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getAllServices exception:" + e10.toString());
            return Collections.emptyList();
        }
    }

    public DriveConfigService getServiceById(String str) throws Throwable {
        try {
            List<DriveConfigService> listQueryResult4Vo = queryResult4Vo(DriveConfigScript.SQL_GET_SERVICE_BY_ID, new String[]{str});
            if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
                return null;
            }
            return listQueryResult4Vo.get(0);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getServiceById exception:" + e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public DriveConfigService getVo(Cursor cursor) {
        DriveConfigService driveConfigService = new DriveConfigService();
        DriveConfigServiceResource driveConfigServiceResource = new DriveConfigServiceResource();
        driveConfigService.setId(cursor.getString(0));
        driveConfigService.setAppId(cursor.getString(1).split(","));
        driveConfigService.setPkgNames(cursor.getString(2).split(","));
        driveConfigService.setSignHash(cursor.getString(3).split(","));
        driveConfigService.setIcon(cursor.getString(4));
        driveConfigService.setStyle(cursor.getString(5));
        driveConfigService.setName(cursor.getString(6));
        driveConfigServiceResource.setSubPageIcon(cursor.getString(7));
        driveConfigServiceResource.setSubDesc(cursor.getString(8));
        driveConfigServiceResource.setSubSwitchDesc(cursor.getString(9));
        driveConfigService.setDriveConfigServiceResource(driveConfigServiceResource);
        driveConfigService.setMinSyncVersion(cursor.getInt(10));
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(11))) {
            driveConfigService.setRecord(true);
        } else {
            driveConfigService.setRecord(false);
        }
        driveConfigService.setRecordIndex(cursor.getInt(12));
        driveConfigService.setVersion(cursor.getString(13));
        driveConfigService.setIconPath(cursor.getString(14));
        driveConfigService.setSubPageIconPath(cursor.getString(15));
        if (FaqConstants.DISABLE_HA_REPORT.equals(cursor.getString(16))) {
            driveConfigService.setSubUser(true);
        } else {
            driveConfigService.setSubUser(false);
        }
        return driveConfigService;
    }
}
