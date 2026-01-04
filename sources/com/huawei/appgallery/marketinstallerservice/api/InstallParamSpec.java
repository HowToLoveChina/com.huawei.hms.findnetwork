package com.huawei.appgallery.marketinstallerservice.api;

/* loaded from: classes4.dex */
public class InstallParamSpec extends BaseParamSpec {
    public static final int FAIL_RESULT_DIALOG = 2;
    public static final int FAIL_RESULT_NOTHING = 1;
    public static final int FAIL_RESULT_TOAST = 0;

    /* renamed from: e */
    public MarketInfo f21006e;

    /* renamed from: f */
    public boolean f21007f = false;

    /* renamed from: g */
    public int f21008g = 0;

    public int getFailResultPromptType() {
        return this.f21008g;
    }

    public MarketInfo getMarketInfo() {
        return this.f21006e;
    }

    public boolean isSilentDownload() {
        return this.f21007f;
    }

    public void setFailResultPromptType(int i10) {
        this.f21008g = i10;
    }

    public void setMarketInfo(MarketInfo marketInfo) {
        this.f21006e = marketInfo;
    }

    public void setSilentDownload(boolean z10) {
        this.f21007f = z10;
    }
}
