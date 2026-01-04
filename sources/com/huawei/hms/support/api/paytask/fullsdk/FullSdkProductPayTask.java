package com.huawei.hms.support.api.paytask.fullsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.iapfull.bean.PayRequest;
import com.huawei.hms.iapfull.bean.WebProductPayRequest;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;

/* loaded from: classes8.dex */
public class FullSdkProductPayTask extends BaseFullSdkTask<ProductPayRequest> {
    public FullSdkProductPayTask(Context context, ProductPayRequest productPayRequest) {
        super(context, productPayRequest);
    }

    /* renamed from: a */
    private WebProductPayRequest m36682a() {
        if (this.mRequest == 0) {
            return null;
        }
        WebProductPayRequest webProductPayRequest = new WebProductPayRequest();
        webProductPayRequest.setProductNo(((ProductPayRequest) this.mRequest).getProductNo());
        webProductPayRequest.setReservedInfor(((ProductPayRequest) this.mRequest).getReservedInfor());
        webProductPayRequest.setMerchantId(((ProductPayRequest) this.mRequest).merchantId);
        webProductPayRequest.setApplicationID(((ProductPayRequest) this.mRequest).applicationID);
        webProductPayRequest.setRequestId(((ProductPayRequest) this.mRequest).requestId);
        webProductPayRequest.setUrl(((ProductPayRequest) this.mRequest).url);
        webProductPayRequest.setSdkChannel(((ProductPayRequest) this.mRequest).sdkChannel);
        webProductPayRequest.setUrlVer(((ProductPayRequest) this.mRequest).urlVer);
        webProductPayRequest.setSign(((ProductPayRequest) this.mRequest).sign);
        webProductPayRequest.setMerchantName(((ProductPayRequest) this.mRequest).merchantName);
        webProductPayRequest.setServiceCatalog(((ProductPayRequest) this.mRequest).serviceCatalog);
        webProductPayRequest.setExtReserved(((ProductPayRequest) this.mRequest).extReserved);
        webProductPayRequest.setExpireTime(((ProductPayRequest) this.mRequest).expireTime);
        webProductPayRequest.setValidTime(((ProductPayRequest) this.mRequest).validTime);
        String str = ((ProductPayRequest) this.mRequest).signatureAlgorithm;
        if (!TextUtils.isEmpty(str) && checkFieldExist(webProductPayRequest, "signatureAlgorithm")) {
            webProductPayRequest.setSignatureAlgorithm(str);
        }
        return webProductPayRequest;
    }

    @Override // com.huawei.hms.support.api.paytask.fullsdk.BaseFullSdkTask
    public PayRequest createRequestParams() {
        return null;
    }

    @Override // com.huawei.hms.support.api.paytask.fullsdk.BaseFullSdkTask
    public Intent getFullSdkIntent() {
        WebProductPayRequest webProductPayRequestM36682a;
        if (this.mContext == null || (webProductPayRequestM36682a = m36682a()) == null) {
            return null;
        }
        return IapFullAPIFactory.createIapFullAPI(this.mContext).getProductPayIntent(this.mContext, webProductPayRequestM36682a);
    }
}
