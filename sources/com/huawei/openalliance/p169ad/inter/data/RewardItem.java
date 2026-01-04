package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.Serializable;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class RewardItem implements Serializable {
    private static final long serialVersionUID = 30414300;
    private int amount;
    private String type;

    /* renamed from: a */
    public void m44554a(int i10) {
        this.amount = i10;
    }

    @OuterVisible
    public int getAmount() {
        return this.amount;
    }

    @OuterVisible
    public String getType() {
        return AbstractC7806cz.m48168c(this.type);
    }

    /* renamed from: a */
    public void m44555a(String str) {
        this.type = str;
    }
}
