package p492nh;

import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.InstallerNetTransmission;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;

/* renamed from: nh.a */
/* loaded from: classes4.dex */
public class C11705a extends ResponseBean {

    @InstallerNetTransmission
    private MarketInfo hiAppInfo = null;

    public MarketInfo getHiAppInfo() {
        return this.hiAppInfo;
    }

    public void setHiAppInfo(MarketInfo marketInfo) {
        this.hiAppInfo = marketInfo;
    }
}
