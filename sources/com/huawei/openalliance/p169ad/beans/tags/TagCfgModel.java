package com.huawei.openalliance.p169ad.beans.tags;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

@DataKeep
/* loaded from: classes8.dex */
public class TagCfgModel {
    private String qryIntvl;
    private String rptMode;
    private String type;
    private String validT;

    /* renamed from: a */
    public String m40966a() {
        return this.type;
    }

    /* renamed from: b */
    public String m40967b() {
        return AbstractC7806cz.m48165b(this.validT) ? "60" : this.validT;
    }

    /* renamed from: c */
    public String m40968c() {
        return AbstractC7806cz.m48165b(this.qryIntvl) ? "60" : this.qryIntvl;
    }

    /* renamed from: d */
    public String m40969d() {
        return AbstractC7806cz.m48165b(this.rptMode) ? "0" : this.rptMode;
    }
}
