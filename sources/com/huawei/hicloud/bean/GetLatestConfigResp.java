package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class GetLatestConfigResp extends GeneralConfigBaseResp {
    private List<Configs> configs;

    public List<Configs> getConfigs() {
        return this.configs;
    }

    public void setConfigs(List<Configs> list) {
        this.configs = list;
    }
}
