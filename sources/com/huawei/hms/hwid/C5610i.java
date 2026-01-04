package com.huawei.hms.hwid;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AccountIcon;
import com.huawei.hms.support.account.result.GetChannelResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.i */
/* loaded from: classes8.dex */
public class C5610i extends TaskApiCall<C5604c, AccountIcon> {

    /* renamed from: a */
    private Context f25360a;

    public C5610i(String str, String str2, String str3, Context context) {
        super(str, str2, str3);
        this.f25360a = context;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5604c c5604c, ResponseErrorCode responseErrorCode, String str, C8941i<AccountIcon> c8941i) {
        if (responseErrorCode == null) {
            C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode != 0 && CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
            C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "apk version is low or is not exist.", true);
            Status status = new Status(errorCode, responseErrorCode.getErrorReason());
            C5598ao.m32897a(responseErrorCode, status);
            c8941i.m56657c(new ResolvableApiException(status));
            return;
        }
        C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "ResponseErrorCode.status:" + responseErrorCode.getErrorCode(), true);
        AccountIcon accountIcon = new AccountIcon();
        if (TextUtils.isEmpty(str)) {
            C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, response is null, failed", true);
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
            return;
        }
        if ("{}".equals(str)) {
            C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, body is null", true);
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        try {
            GetChannelResult getChannelResultFromJson = new GetChannelResult().fromJson(str);
            if (getChannelResultFromJson.isSuccess()) {
                C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel success", true);
                accountIcon.setDescription(getChannelResultFromJson.getDescription());
                accountIcon.setIcon(m32932a(getChannelResultFromJson.getIcon()));
                c8941i.m56658d(accountIcon);
                long jM32895a = C5598ao.m32895a();
                SharedPreferences.Editor editorEdit = this.f25360a.getSharedPreferences("ACCOUNT_CHANNEL_CACHE", 0).edit();
                editorEdit.putLong("cache_time", jM32895a);
                editorEdit.putString("desc", getChannelResultFromJson.getDescription());
                editorEdit.putString("icon", getChannelResultFromJson.getIcon());
                editorEdit.apply();
            } else {
                C5602as.m32910b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel failed", true);
                c8941i.m56657c(new ApiException(getChannelResultFromJson.getStatus()));
            }
        } catch (JSONException unused) {
            C5602as.m32911c("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, but parser json exception", true);
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 10;
    }

    /* renamed from: a */
    private Bitmap m32932a(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e10) {
            C5602as.m32912d("[AccountSDK]AccountGetChannelTaskApiCall", "stringToBitmap Exception is " + e10.getClass().getSimpleName(), true);
            return null;
        } catch (OutOfMemoryError unused) {
            C5602as.m32912d("[AccountSDK]AccountGetChannelTaskApiCall", "out of memory error ", true);
            return null;
        }
    }
}
