package com.tencent.p204mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p204mm.opensdk.modelbase.BaseReq;
import com.tencent.p204mm.opensdk.modelbase.BaseResp;
import com.tencent.p204mm.opensdk.utils.C8931d;
import com.tencent.p204mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class WXLaunchMiniProgramWithToken {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req";
        public String token;

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            if (!C8931d.m56649b(this.token)) {
                return true;
            }
            Log.m56639e(TAG, "token is null");
            return false;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 29;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_token", this.token);
        }
    }

    public static final class Resp extends BaseResp {
        public static final int ERR_INVALID_TOKEN = -1000;
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
            this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 29;
        }

        @Override // com.tencent.p204mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
