package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ReduceDisturbRule extends RspBean {
    private static final String TAG = "ReduceDisturbRule";
    private List<Rule> ruleList;
    private long timeStamp;

    /* renamed from: a */
    public List<Rule> m40437a() {
        return this.ruleList;
    }
}
