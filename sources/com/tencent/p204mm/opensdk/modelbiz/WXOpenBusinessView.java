package com.tencent.p204mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p204mm.opensdk.modelbase.BaseReq;
import com.tencent.p204mm.opensdk.modelbase.BaseResp;
import com.tencent.p204mm.opensdk.utils.C8931d;
import com.tencent.p204mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class WXOpenBusinessView {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXOpenBusinessView.Req";
        public String businessType;
        public String extInfo;
        public String query;

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            if (!C8931d.m56649b(this.businessType)) {
                return true;
            }
            Log.m56639e(TAG, "businessType is null");
            return false;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.businessType = bundle.getString("_openbusinessview_businessType");
            this.query = bundle.getString("_openbusinessview__query_info");
            this.extInfo = bundle.getString("_openbusinessview_extInfo");
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 26;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_openbusinessview_businessType", this.businessType);
            bundle.putString("_openbusinessview__query_info", this.query);
            bundle.putString("_openbusinessview_extInfo", this.extInfo);
        }
    }

    public static final class Resp extends BaseResp {
        public String businessType;
        public String extMsg;

        public Resp() {
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_openbusinessview_ext_msg");
            this.businessType = bundle.getString("_openbusinessview_business_type");
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 26;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_openbusinessview_ext_msg", this.extMsg);
            bundle.putString("_openbusinessview_business_type", this.businessType);
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
