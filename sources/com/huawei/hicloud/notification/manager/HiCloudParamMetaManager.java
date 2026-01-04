package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.HiCloudParamMetaBean;
import com.huawei.hicloud.notification.p106db.bean.MetaListBean;
import com.huawei.hicloud.notification.p106db.bean.ParamMetaDbBean;
import com.huawei.hicloud.notification.p106db.bean.ProvidersBean;
import com.huawei.hicloud.notification.p106db.operator.HiCloudParamMetaConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5024r;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9734g;

/* loaded from: classes6.dex */
public class HiCloudParamMetaManager {
    private static final int DEFAULT_AUTH_TYPE = -1;
    public static final String LOACL_CLIENT = "client";
    private static final String TAG = "HiCloudParamMetaManager";
    private C5024r paramMetaConfigService;

    public static class Holder {
        private static final HiCloudParamMetaManager INSTANCE = new HiCloudParamMetaManager();

        private Holder() {
        }
    }

    private void executeParamMetaConfig() throws SQLException {
        NotifyLogger.m29915i(TAG, "requestSpaceUsageNoticeConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudParamMeta")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractAndSaveParamMetaData();
                    return;
                } else {
                    if (!this.paramMetaConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.paramMetaConfigService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                C9734g.m60767a().m60769c("HiCloudParamMeta");
                clearParamMetaDb();
                extractAndSaveParamMetaData();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void extractAndSaveParamMetaData() {
        NotifyLogger.m29915i(TAG, "begin extractAndSaveParamMetaData");
        HiCloudParamMetaBean paramMetaConfigFile = getParamMetaConfigFile();
        if (paramMetaConfigFile == null) {
            NotifyLogger.m29914e(TAG, "extractAndSaveParamMetaData :paramMetaBean is null");
            return;
        }
        List<MetaListBean> metalist = paramMetaConfigFile.getMetalist();
        if (metalist == null || metalist.size() == 0) {
            NotifyLogger.m29914e(TAG, "extractAndSaveParamMetaData :metaListBeanList is null");
            return;
        }
        List<ProvidersBean> providers = paramMetaConfigFile.getProviders();
        if (providers == null || providers.size() == 0) {
            NotifyLogger.m29914e(TAG, "extractAndSaveParamMetaData :providersBeanList is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaListBean metaListBean : metalist) {
            if (metaListBean == null) {
                NotifyLogger.m29915i(TAG, "metaBean is null");
            } else {
                String provider = metaListBean.getProvider();
                if (!TextUtils.isEmpty(provider)) {
                    if (LOACL_CLIENT.equals(provider)) {
                        ParamMetaDbBean paramMetaDbBean = new ParamMetaDbBean();
                        paramMetaDbBean.setName(metaListBean.getName());
                        paramMetaDbBean.setType(metaListBean.getType());
                        paramMetaDbBean.setProvider(provider);
                        paramMetaDbBean.setEndpoint("");
                        paramMetaDbBean.setAuthType(-1);
                        arrayList.add(paramMetaDbBean);
                    } else {
                        for (ProvidersBean providersBean : providers) {
                            if (providersBean != null && provider.equals(providersBean.getName())) {
                                ParamMetaDbBean paramMetaDbBean2 = new ParamMetaDbBean();
                                paramMetaDbBean2.setName(metaListBean.getName());
                                paramMetaDbBean2.setType(metaListBean.getType());
                                paramMetaDbBean2.setProvider(provider);
                                paramMetaDbBean2.setEndpoint(providersBean.getEndpoint());
                                paramMetaDbBean2.setAuthType(providersBean.getAuthType());
                                arrayList.add(paramMetaDbBean2);
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            new HiCloudParamMetaConfigOperator().saveConfigs(arrayList);
        }
    }

    public static HiCloudParamMetaManager getInstance() {
        return Holder.INSTANCE;
    }

    public void clearAllConfig() throws SQLException {
        clearParamMetaDb();
        clearConfigFile();
    }

    public void clearConfigFile() {
        boolean zDelete;
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "clearConfigFile context null");
                return;
            }
            File file = new File(contextM1377a.getFilesDir() + File.separator + "HiCloudParamMeta.json");
            if (!file.exists() || (zDelete = file.delete())) {
                return;
            }
            NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10.toString());
        }
    }

    public void clearParamMetaDb() throws SQLException {
        new HiCloudParamMetaConfigOperator().clear();
    }

    public HiCloudParamMetaBean getConfigRaw(String str) throws IOException {
        HiCloudParamMetaBean hiCloudParamMetaBean;
        Exception e10;
        FileInputStream fileInputStream;
        NotifyLogger.m29915i(TAG, "getConfigRaw");
        try {
            fileInputStream = new FileInputStream(new File(C0213f.m1377a().getFilesDir() + str));
        } catch (Exception e11) {
            hiCloudParamMetaBean = null;
            e10 = e11;
        }
        try {
            hiCloudParamMetaBean = (HiCloudParamMetaBean) new Gson().fromJson(C0209d.m1290o2(fileInputStream), HiCloudParamMetaBean.class);
            try {
                fileInputStream.close();
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
                return hiCloudParamMetaBean;
            }
            return hiCloudParamMetaBean;
        } finally {
        }
    }

    public HiCloudParamMetaBean getParamMetaConfigFile() {
        return getConfigRaw("/HiCloudParamMeta.json");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudParamMeta") >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HiCloudParamMetaManager.TAG, "version updated, query config");
        executeParamMetaConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HiCloudParamMetaManager.TAG, "version not updated, extract sync module config");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestConfig() throws android.database.SQLException {
        /*
            r7 = this;
            java.lang.String r0 = "request notice config version"
            java.lang.String r1 = "HiCloudParamMetaManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.service.r r4 = r7.paramMetaConfigService     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L50
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request notice config version exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.r r5 = r7.paramMetaConfigService
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4d
            if (r2 >= r3) goto L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L4d:
            return r0
        L4e:
            r2 = 0
        L50:
            java.lang.String r4 = "HiCloudParamMeta"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.executeParamMetaConfig()
            r7 = 1
            return r7
        L64:
            java.lang.String r7 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HiCloudParamMetaManager.requestConfig():boolean");
    }

    private HiCloudParamMetaManager() {
        this.paramMetaConfigService = new C5024r(null);
    }
}
