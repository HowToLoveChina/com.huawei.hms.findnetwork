package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import java.util.ArrayList;
import p031b7.C1122c;

/* loaded from: classes2.dex */
public class CallableBuilder {

    public static class CallableBuilderHolder {
        private static CallableBuilder instance = new CallableBuilder();

        private CallableBuilderHolder() {
        }
    }

    public static CallableBuilder getInstance() {
        return CallableBuilderHolder.instance;
    }

    public AbstractCallableC2320a<Object> buildDownloadCallable(Context context, CallbackHandler callbackHandler, String str, String str2, boolean z10, Object obj, String str3, boolean z11, int i10, String str4, int i11, int i12, boolean z12, String str5, boolean z13) {
        return CloudAlbumSettings.m14363h().m14378n() ? ((FileInfo) obj).isLostData() ? new EuropeSDKFileProxyDownloadTaskCallable(context, callbackHandler, str, str2, obj, str3, z11, i10, str4, i11, i12, z12, str5, z13) : new EuropeSDKDownloadTaskCallable(context, callbackHandler, str, str2, true, obj, str3, z11, i10, str4, i11, i12, z12, str5, z13) : new SDKDownloadTaskCallable(context, callbackHandler, str, str2, obj, str3, z11, i10, str4, i11, i12, z12, str5, z13);
    }

    public AbstractCallableC2320a buildDownloadCheckCallable(Context context, CallbackHandler callbackHandler, ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11, boolean z12, boolean z13, int i11, boolean z14, String str, boolean z15) {
        String strM6755Z0 = TextUtils.isEmpty(str) ? C1122c.m6755Z0("04004") : str;
        return CloudAlbumSettings.m14363h().m14378n() ? new EuropeSDKDownloadCheckCallable(context, callbackHandler, null, true, arrayList, i10, z10, z11, z12, z13, i11, z14, strM6755Z0) : new SDKDownloadCheckCallable(context, callbackHandler, null, z15, arrayList, i10, z10, z11, z12, z13, i11, z14, strM6755Z0);
    }

    public AbstractCallableC2320a buildShareUploadCallable(Context context, Object obj, String str, CallbackHandler callbackHandler) {
        return new SDKUploadShareAsyncCallable(context, obj, str, callbackHandler);
    }

    public AbstractCallableC2320a buildUploadCallable(Context context, Object obj, String str, String str2, CallbackHandler callbackHandler) {
        return CloudAlbumSettings.m14363h().m14378n() ? new EuropeSDKUploadAsyncCallable(context, obj, str, str2, callbackHandler) : new SDKUploadAsyncCallable(context, obj, str, str2, callbackHandler);
    }
}
