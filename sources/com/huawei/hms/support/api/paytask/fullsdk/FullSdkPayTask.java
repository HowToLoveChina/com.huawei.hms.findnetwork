package com.huawei.hms.support.api.paytask.fullsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.iapfull.IapFullAPIFactory;
import com.huawei.hms.iapfull.bean.PayRequest;
import com.huawei.hms.support.api.entity.pay.PayReq;

/* loaded from: classes8.dex */
public class FullSdkPayTask extends BaseFullSdkTask<PayReq> {
    public FullSdkPayTask(Context context, PayReq payReq) {
        super(context, payReq);
    }

    @Override // com.huawei.hms.support.api.paytask.fullsdk.BaseFullSdkTask
    public PayRequest createRequestParams() {
        if (this.mRequest == 0) {
            return null;
        }
        PayRequest payRequest = new PayRequest();
        payRequest.setProductName(((PayReq) this.mRequest).getProductName());
        payRequest.setReservedInfor(((PayReq) this.mRequest).getReservedInfor());
        payRequest.setProductDesc(((PayReq) this.mRequest).productDesc);
        payRequest.setMerchantId(((PayReq) this.mRequest).merchantId);
        payRequest.setApplicationID(((PayReq) this.mRequest).applicationID);
        payRequest.setAmount(((PayReq) this.mRequest).amount);
        payRequest.setRequestId(((PayReq) this.mRequest).requestId);
        payRequest.setUrl(((PayReq) this.mRequest).url);
        payRequest.setSdkChannel(((PayReq) this.mRequest).sdkChannel);
        payRequest.setUrlver(((PayReq) this.mRequest).urlVer);
        payRequest.setCountry(((PayReq) this.mRequest).country);
        payRequest.setCurrency(((PayReq) this.mRequest).currency);
        payRequest.setSign(((PayReq) this.mRequest).sign);
        payRequest.setMerchantName(((PayReq) this.mRequest).merchantName);
        payRequest.setServiceCatalog(((PayReq) this.mRequest).serviceCatalog);
        payRequest.setExtReserved(((PayReq) this.mRequest).extReserved);
        payRequest.setExpireTime(((PayReq) this.mRequest).expireTime);
        String str = ((PayReq) this.mRequest).signatureAlgorithm;
        if (!TextUtils.isEmpty(str) && checkFieldExist(payRequest, "signatureAlgorithm")) {
            payRequest.setSignatureAlgorithm(str);
        }
        return payRequest;
    }

    @Override // com.huawei.hms.support.api.paytask.fullsdk.BaseFullSdkTask
    public Intent getFullSdkIntent() {
        PayRequest payRequestCreateRequestParams;
        if (this.mContext == null || (payRequestCreateRequestParams = createRequestParams()) == null) {
            return null;
        }
        return IapFullAPIFactory.createIapFullAPI(this.mContext).getPayIntent(this.mContext, payRequestCreateRequestParams);
    }
}
