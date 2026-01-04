package com.tencent.p204mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p204mm.opensdk.modelbase.BaseReq;
import com.tencent.p204mm.opensdk.modelbase.BaseResp;
import com.tencent.p204mm.opensdk.utils.C8931d;
import com.tencent.p204mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class WXInvoiceAuthInsert {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXInvoiceAuthInsert.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            if (C8931d.m56649b(this.url)) {
                Log.m56640i(TAG, "url should not be empty");
                return false;
            }
            if (this.url.length() <= URL_LENGTH_LIMIT) {
                return true;
            }
            Log.m56639e(TAG, "url must be in 10k");
            return false;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_invoice_auth_insert_req_url");
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 20;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_invoice_auth_insert_req_url", this.url);
        }
    }

    public static final class Resp extends BaseResp {
        public String wxOrderId;

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_invoice_auth_insert_order_id");
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 20;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
        }
    }
}
