package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;

@OuterVisible
/* loaded from: classes2.dex */
public final class Size {

    /* renamed from: a */
    private final int f35793a;

    /* renamed from: b */
    private final int f35794b;

    @OuterVisible
    public Size(int i10, int i11) {
        this.f35793a = i10;
        this.f35794b = i11;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f35793a == size.f35793a && this.f35794b == size.f35794b;
    }

    @OuterVisible
    public int getHeight() {
        return this.f35794b;
    }

    @OuterVisible
    public int getWidth() {
        return this.f35793a;
    }

    public int hashCode() {
        int i10 = this.f35794b;
        int i11 = this.f35793a;
        return ((i11 >>> 16) | (i11 << 16)) ^ i10;
    }

    public String toString() {
        return this.f35793a + Constants.MULTIPLE_SIGN + this.f35794b;
    }
}
