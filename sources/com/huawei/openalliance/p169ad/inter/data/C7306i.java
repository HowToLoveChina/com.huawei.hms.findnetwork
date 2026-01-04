package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.InterfaceC7308f;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.inter.data.i */
/* loaded from: classes2.dex */
public class C7306i implements InterfaceC7300c {

    /* renamed from: a */
    private ContentRecord f33929a;

    /* renamed from: b */
    private MetaData f33930b;

    /* renamed from: c */
    private AppInfo f33931c;

    public C7306i(ContentRecord contentRecord) {
        this.f33929a = contentRecord;
        if (contentRecord != null) {
            this.f33930b = contentRecord.m41568i();
        }
    }

    /* renamed from: a */
    public ContentRecord m44977a() {
        return this.f33929a;
    }

    /* renamed from: b */
    public String m44980b() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord != null) {
            return contentRecord.m41515bb();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAbilityDetailInfo() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41466aR();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAdChoiceIcon() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41491am();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAdChoiceUrl() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41490al();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAdSign() {
        MetaData metaData = this.f33930b;
        if (metaData != null) {
            return metaData.m40341u();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public AppInfo getAppInfo() {
        AppInfo appInfo = this.f33931c;
        if (appInfo != null) {
            return appInfo;
        }
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        AppInfo appInfoM41484af = contentRecord.m41484af();
        this.f33931c = appInfoM41484af;
        return appInfoM41484af;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public BiddingInfo getBiddingInfo() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public List<AdvertiserInfo> getCompliance() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41468aT();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getContentId() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41588n();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getCreativeType() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return 0;
        }
        return contentRecord.m41392E();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCta() {
        MetaData metaData = this.f33930b;
        if (metaData != null) {
            return AbstractC7806cz.m48168c(metaData.m40280a());
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCtrlSwitchs() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41427W();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getDspLogo() {
        AdSource adSourceM39547a;
        MetaData metaData = this.f33930b;
        if (metaData == null || (adSourceM39547a = AdSource.m39547a(metaData.m40275L())) == null) {
            return null;
        }
        return adSourceM39547a.m39554b();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getDspName() {
        AdSource adSourceM39547a;
        MetaData metaData = this.f33930b;
        if (metaData == null || (adSourceM39547a = AdSource.m39547a(metaData.m40275L())) == null) {
            return null;
        }
        return AbstractC7806cz.m48168c(adSourceM39547a.m39551a());
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getEndTime() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return 0L;
        }
        return contentRecord.m41600r();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getHwChannelId() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41467aS();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getInterfaceDownloadConfig() {
        return AbstractC7558os.m46457E(getCtrlSwitchs());
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getLabel() {
        MetaData metaData = this.f33930b;
        if (metaData != null) {
            return AbstractC7806cz.m48168c(metaData.m40326l());
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMaxEffectiveShowTime() {
        MetaData metaData = this.f33930b;
        if (metaData != null) {
            return metaData.m40322j();
        }
        return 0L;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getMinEffectiveShowRatio() {
        MetaData metaData = this.f33930b;
        if (metaData != null) {
            return metaData.m40324k();
        }
        return 50;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMinEffectiveShowTime() {
        MetaData metaData = this.f33930b;
        if (metaData != null) {
            return metaData.m40320i();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public PromoteInfo getPromoteInfo() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41485ag();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public RewardVerifyConfig getRewardVerifyConfig() {
        if (this.f33929a == null) {
            return null;
        }
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(this.f33929a.m41450aB());
        builder.setUserId(this.f33929a.m41451aC());
        return builder.build();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getShowId() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41577k();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getStartTime() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return 0L;
        }
        return contentRecord.m41603s();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getTaskId() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41591o();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getTransparencyTplUrl() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41516bc();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getUniqueId() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41478ab();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getWhyThisAd() {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41476aa();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public void gotoWhyThisAdPage(Context context) {
        if (this.f33929a == null) {
            return;
        }
        m44978a(context);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isAdIdInWhiteList() {
        Context contextMo44051d;
        if (AbstractC7558os.m46472k(getCtrlSwitchs())) {
            return true;
        }
        InterfaceC7308f interfaceC7308fM44013a = HiAd.m44013a();
        if (interfaceC7308fM44013a == null || (contextMo44051d = interfaceC7308fM44013a.mo44051d()) == null) {
            return false;
        }
        String packageName = contextMo44051d.getPackageName();
        return WhiteListPkgList.inWhiteList(packageName, C7830i.m48435e(contextMo44051d, packageName));
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isExpired() {
        ContentRecord contentRecord = this.f33929a;
        return contentRecord == null || contentRecord.m41600r() < System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isShowAppElement() {
        Integer numM40278O;
        MetaData metaData = this.f33930b;
        return (metaData == null || (numM40278O = metaData.m40278O()) == null || numM40278O.intValue() != 1) ? false : true;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isTransparencyOpen() {
        ContentRecord contentRecord = this.f33929a;
        return (contentRecord == null || !contentRecord.m41517bd() || TextUtils.isEmpty(this.f33929a.m41516bc())) ? false : true;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        ContentRecord contentRecord;
        if (rewardVerifyConfig == null || (contentRecord = this.f33929a) == null) {
            return;
        }
        contentRecord.m41396G(AbstractC7806cz.m48170d(rewardVerifyConfig.getData()));
        this.f33929a.m41398H(AbstractC7806cz.m48170d(rewardVerifyConfig.getUserId()));
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public void showAppDetailPage(Context context) {
    }

    /* renamed from: a */
    public void m44978a(Context context) {
        if (context == null) {
            AbstractC7185ho.m43823c("UnifyAd", "context is null not call gotoWhyThisAdPage method");
        } else {
            AbstractC7741ao.m47549a(context, this);
        }
    }

    /* renamed from: a */
    public void m44979a(String str) {
        ContentRecord contentRecord = this.f33929a;
        if (contentRecord != null) {
            contentRecord.m41418R(str);
        }
    }
}
