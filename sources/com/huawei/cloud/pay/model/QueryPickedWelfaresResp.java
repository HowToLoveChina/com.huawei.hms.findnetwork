package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class QueryPickedWelfaresResp extends Response {
    private List<Welfare> unusefulWelfares;
    private List<Welfare> usedWelfares;
    private List<Welfare> usefulWelfares;

    public List<Welfare> getUnusefulWelfares() {
        return this.unusefulWelfares;
    }

    public List<Welfare> getUsedWelfares() {
        return this.usedWelfares;
    }

    public List<Welfare> getUsefulWelfares() {
        return this.usefulWelfares;
    }
}
