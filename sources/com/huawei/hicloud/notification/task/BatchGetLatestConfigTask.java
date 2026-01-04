package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.bean.Configs;
import com.huawei.hicloud.bean.GetLatestConfigResp;
import com.huawei.hicloud.bean.Keys;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Service;
import com.huawei.hicloud.service.C5004c;
import com.huawei.hicloud.service.C5011f0;
import com.huawei.hicloud.service.C5016j;
import com.huawei.hicloud.service.C5017k;
import com.huawei.hicloud.service.C5022p;
import com.huawei.hicloud.service.C5028v;
import fk.C9721b;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0241z;
import p459lp.C11327e;
import p581qk.AbstractC12367d;
import p684un.C13227f;
import p846zj.C14303a;

/* loaded from: classes6.dex */
public class BatchGetLatestConfigTask extends AbstractC12367d {
    private static final String TAG = "BatchGetLatestConfigTask";

    private void downloadOmFile(Configs configs) {
        NotifyLogger.m29915i(TAG, "downloadOmFile " + configs.getKey());
        String key = configs.getKey();
        key.hashCode();
        switch (key) {
            case "HiCloudBackupSpaceInsuffNoticeV5":
                new BackupSpaceInsuffNoticeV5Service(null).downloadOmFile(configs, configs.getKey(), configs.getVersion());
                break;
            case "HiCloudMsgNoticeConfig":
                new C5022p(null).downloadOmFile(configs, configs.getKey(), configs.getVersion());
                break;
            case "HiCloudSceneHomePageBanner":
                new C5028v(null).downloadOmFile(configs, configs.getKey(), configs.getVersion());
                break;
            case "HiCloudBrandHomePageBanner":
                new C5017k(null).downloadOmFile(configs, configs.getKey(), configs.getVersion());
                break;
            case "HiCloudBrandBuyBanner":
                new C5016j(null).downloadOmFile(configs, configs.getKey(), configs.getVersion());
                break;
            case "HiCloudTextLink":
                new C5011f0(null).downloadOmFile(configs, configs.getKey(), configs.getVersion());
                break;
        }
    }

    private void reportReqSuccess(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("config_point", str);
        linkedHashMap.put("version", str2);
        C13227f.m79492i1().m79573U("version_upgrade_om_update", linkedHashMap);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        GetLatestConfigResp getLatestConfigRespM30031a = C5004c.m30030c().m30031a(new Keys[]{new Keys("HiCloudBrandHomePageBanner", C11327e.m68061d("HiCloudBrandHomePageBanner")), new Keys("HiCloudBrandBuyBanner", C11327e.m68061d("HiCloudBrandBuyBanner")), new Keys("HiCloudSceneHomePageBanner", C11327e.m68061d("HiCloudSceneHomePageBanner")), new Keys("HiCloudTextLink", C11327e.m68061d("HiCloudTextLink")), new Keys("HiCloudMsgNoticeConfig", C11327e.m68061d("HiCloudMsgNoticeConfig")), new Keys("HiCloudBackupSpaceInsuffNoticeV5", C11327e.m68061d("HiCloudBackupSpaceInsuffNoticeV5"))});
        if (getLatestConfigRespM30031a != null) {
            List<Configs> configs = getLatestConfigRespM30031a.getConfigs();
            if (configs != null || configs.isEmpty()) {
                for (Configs configs2 : configs) {
                    if (configs2 == null || configs2.getConfig() == null) {
                        NotifyLogger.m29915i(TAG, "config is null, No download");
                    } else {
                        C11327e.m68059b(configs2.getKey());
                        downloadOmFile(configs2);
                        reportReqSuccess(configs2.getKey(), String.valueOf(configs2.getVersion()));
                    }
                }
                C14303a.m85185a().m85198n(C0241z.m1688f("160000300"));
            }
        }
    }
}
