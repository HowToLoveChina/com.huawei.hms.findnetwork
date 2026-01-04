package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class DelSyncedAppDataReq {
    private List<String> appCollections;
    private List<String> appInstallDatas;
    private String callerPkg;

    /* renamed from: a */
    public void m40948a(String str) {
        this.callerPkg = str;
    }

    /* renamed from: b */
    public void m40950b(List<String> list) {
        this.appInstallDatas = list;
    }

    /* renamed from: a */
    public void m40949a(List<String> list) {
        this.appCollections = list;
    }
}
