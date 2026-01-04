package com.huawei.hicloud.service;

import fk.C9721b;
import p015ak.C0213f;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.c0 */
/* loaded from: classes.dex */
public class C5005c0 extends AbstractC5012g {
    public C5005c0(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 1;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1378b().getFilesDir() + "/HiCloudWebViewAllownlist.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudWebViewAllownlist");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudWebViewAllownlist.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudWebViewAllownlist";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudWebViewAllownlist");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLocalTmpPath() {
        return C0213f.m1378b().getFilesDir() + "/HiCloudWebViewAllownlist.json.tmp";
    }
}
