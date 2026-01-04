package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.ParamMetaDbBean;
import com.huawei.hicloud.notification.p106db.script.HiCloudParamMetaScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class HiCloudParamMetaConfigOperator extends AbstractC0315c<ParamMetaDbBean> {
    private static final String TAG = "HiCloudParamMetaConfigOperator";

    private void insertContent(List<String[]> list) {
        try {
            execSQL4Batch(HiCloudParamMetaScript.INSERT_STRING, list);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public void clear() throws SQLException {
        try {
            execSQL(HiCloudParamMetaScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear spacenotify error." + e10.getMessage());
        }
    }

    public List<ParamMetaDbBean> queryParamMetaDbBeanList() throws Throwable {
        List<ParamMetaDbBean> listQueryResult4Vo;
        NotifyLogger.m29913d(TAG, "queryParamMetaDbBeanList start");
        try {
            listQueryResult4Vo = queryResult4Vo(HiCloudParamMetaScript.QUERY_FULL_DATA_VALUE, null);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryContent error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo;
    }

    public List<ParamMetaDbBean> queryParamMetaNameTypeList() throws Throwable {
        List<ParamMetaDbBean> listQueryResult4Vo;
        NotifyLogger.m29913d(TAG, "queryParamMetaNameTypeList start");
        try {
            listQueryResult4Vo = queryResult4Vo(HiCloudParamMetaScript.QUERY_FULL_DATA_VALUE, null);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryContent error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo;
    }

    public int queryParamMetaTypeByKey(String str) throws Throwable {
        List<ParamMetaDbBean> listQueryResult4Vo;
        NotifyLogger.m29913d(TAG, "queryParamMetaDbBeanList start");
        try {
            listQueryResult4Vo = queryResult4Vo(HiCloudParamMetaScript.QUERY_FULL_DATA_VALUE_BY_KEY, new String[]{str});
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryContent error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return -1;
        }
        return listQueryResult4Vo.get(0).getType();
    }

    public void saveConfigs(List<ParamMetaDbBean> list) {
        ArrayList arrayList = new ArrayList();
        for (ParamMetaDbBean paramMetaDbBean : list) {
            arrayList.add(new String[]{paramMetaDbBean.getName(), String.valueOf(paramMetaDbBean.getType()), paramMetaDbBean.getProvider(), paramMetaDbBean.getEndpoint(), String.valueOf(paramMetaDbBean.getAuthType())});
        }
        insertContent(arrayList);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public ParamMetaDbBean getVo(Cursor cursor) {
        ParamMetaDbBean paramMetaDbBean = new ParamMetaDbBean();
        paramMetaDbBean.setName(cursor.getString(0));
        paramMetaDbBean.setType(Integer.parseInt(cursor.getString(1)));
        paramMetaDbBean.setProvider(cursor.getString(2));
        paramMetaDbBean.setEndpoint(cursor.getString(3));
        paramMetaDbBean.setAuthType(cursor.getInt(4));
        return paramMetaDbBean;
    }
}
