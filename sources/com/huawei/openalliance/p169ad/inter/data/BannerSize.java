package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.ErrorCode;

@OuterVisible
/* loaded from: classes2.dex */
public final class BannerSize {

    @OuterVisible
    public static final String BANNER_STR = "BANNER";

    @OuterVisible
    public static final String LARGE_BANNER_STR = "LARGE_BANNER";

    /* renamed from: a */
    private int f33612a;

    /* renamed from: b */
    private int f33613b;

    @OuterVisible
    public static final BannerSize BANNER = new BannerSize(1080, 170);

    @OuterVisible
    public static final BannerSize LARGE_BANNER = new BannerSize(1080, ErrorCode.ERROR_CODE_NO_PACKAGE);

    private BannerSize(int i10, int i11) {
        this.f33612a = i10;
        this.f33613b = i11;
    }

    /* renamed from: a */
    public int m44447a() {
        return this.f33612a;
    }

    /* renamed from: b */
    public int m44448b() {
        return this.f33613b;
    }
}
