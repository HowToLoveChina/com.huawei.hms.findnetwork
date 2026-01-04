package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.Serializable;

@DataKeep
@OuterVisible
/* loaded from: classes8.dex */
public class PromoteInfo implements Serializable {
    private static final long serialVersionUID = 9086449717970534300L;
    private String name;
    private int type;

    /* renamed from: a */
    public void m40435a(int i10) {
        this.type = i10;
    }

    @OuterVisible
    public String getName() {
        return AbstractC7806cz.m48168c(this.name);
    }

    @OuterVisible
    public int getType() {
        return this.type;
    }

    /* renamed from: a */
    public void m40436a(String str) {
        this.name = str;
    }
}
