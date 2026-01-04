package com.huawei.appgallery.agd.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.appgallery.agd.internal.support.log.AgdLog;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;
import com.huawei.appmarket.service.externalservice.distribution.adsview.request.GenerateAdsViewIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.adsview.response.GenerateAdsViewIPCResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.request.CancelTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.GetRecommendCardReq;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.QueryTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.RegisterDownloadCallbackIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.UnregisterDownloadCallbackIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.response.GetRecommendCardResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.response.QueryTaskResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.response.TaskOperationResponse;
import com.huawei.appmarket.service.externalservice.distribution.referrer.request.QueryReferrerIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.referrer.response.QueryReferrerResponse;
import com.huawei.appmarket.service.externalservice.distribution.reserve.request.ReserveAppIPCRequest;

/* loaded from: classes4.dex */
public abstract class AgdApi {
    public static PendingResult<CancelTaskIPCRequest, TaskOperationResponse> cancelTask(AgdApiClient agdApiClient, CancelTaskIPCRequest cancelTaskIPCRequest) {
        return new PendingResult<>(agdApiClient, cancelTaskIPCRequest);
    }

    public static PendingResult<GenerateAdsViewIPCRequest, GenerateAdsViewIPCResponse> generateAdsView(AgdApiClient agdApiClient, GenerateAdsViewIPCRequest generateAdsViewIPCRequest) {
        return new PendingResult<>(agdApiClient, generateAdsViewIPCRequest);
    }

    public static String getAppGalleryPkg(Context context) {
        return CoreServiceApi.getAppGalleryPkg(context);
    }

    public static ConnectionResult getGuideInstallPendingIntent(Context context) {
        return new ConnectionResult(CoreServiceApi.getGuideInstallPendingIntent(context));
    }

    public static PendingResult<QueryReferrerIPCRequest, QueryReferrerResponse> getInstallReferrer(AgdApiClient agdApiClient, QueryReferrerIPCRequest queryReferrerIPCRequest) {
        return new PendingResult<>(agdApiClient, queryReferrerIPCRequest);
    }

    public static MarketInfo getMarketInfo(Context context) throws PackageManager.NameNotFoundException {
        AgdLog agdLog;
        StringBuilder sb2;
        String str;
        String appGalleryPkg = CoreServiceApi.getAppGalleryPkg(context);
        if (TextUtils.isEmpty(appGalleryPkg)) {
            AgdLog.LOG.m28033w("AgdApi", "getMarketInfo AppGallery pkgName is empty");
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(appGalleryPkg, 128);
            if (packageInfo != null) {
                return new MarketInfo(packageInfo.versionName, packageInfo.versionCode);
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e = e10;
            agdLog = AgdLog.LOG;
            sb2 = new StringBuilder();
            str = "getPackageInfo NameNotFoundException: ";
            sb2.append(str);
            sb2.append(e.getMessage());
            agdLog.m28029e("AgdApi", sb2.toString());
            return null;
        } catch (RuntimeException e11) {
            e = e11;
            agdLog = AgdLog.LOG;
            sb2 = new StringBuilder();
            str = "getPackageInfo RuntimeException: ";
            sb2.append(str);
            sb2.append(e.getMessage());
            agdLog.m28029e("AgdApi", sb2.toString());
            return null;
        }
        return null;
    }

    public static PendingResult<GetRecommendCardReq, GetRecommendCardResponse> getRecommendCardRequest(AgdApiClient agdApiClient, GetRecommendCardReq getRecommendCardReq) {
        return new PendingResult<>(agdApiClient, getRecommendCardReq);
    }

    public static String getVersion() {
        return "3.2.1.300_normal".replace('_', '.');
    }

    public static int getVersionCode() {
        return 30201300;
    }

    public static PendingResult<PauseTaskIPCRequest, TaskOperationResponse> pauseTask(AgdApiClient agdApiClient, PauseTaskIPCRequest pauseTaskIPCRequest) {
        return new PendingResult<>(agdApiClient, pauseTaskIPCRequest);
    }

    public static PendingResult<QueryTaskIPCRequest, QueryTaskResponse> queryTasks(AgdApiClient agdApiClient, QueryTaskIPCRequest queryTaskIPCRequest) {
        if (queryTaskIPCRequest == null) {
            queryTaskIPCRequest = new QueryTaskIPCRequest();
        }
        return new PendingResult<>(agdApiClient, queryTaskIPCRequest);
    }

    public static PendingResult<RegisterDownloadCallbackIPCRequest, TaskOperationResponse> registerDownloadCallback(AgdApiClient agdApiClient, RegisterDownloadCallbackIPCRequest registerDownloadCallbackIPCRequest) {
        return new PendingResult<>(agdApiClient, registerDownloadCallbackIPCRequest);
    }

    public static PendingResult<ReserveAppIPCRequest, TaskOperationResponse> reserveApp(AgdApiClient agdApiClient, ReserveAppIPCRequest reserveAppIPCRequest) {
        return new PendingResult<>(agdApiClient, reserveAppIPCRequest);
    }

    public static PendingResult<ResumeTaskIPCRequest, TaskOperationResponse> resumeTask(AgdApiClient agdApiClient, ResumeTaskIPCRequest resumeTaskIPCRequest) {
        return new PendingResult<>(agdApiClient, resumeTaskIPCRequest);
    }

    @Deprecated
    public static PendingResult<StartDownloadIPCRequest, TaskOperationResponse> startDownloadTask(AgdApiClient agdApiClient, StartDownloadIPCRequest startDownloadIPCRequest) {
        return new PendingResult<>(agdApiClient, startDownloadIPCRequest);
    }

    public static PendingResult<StartDownloadV2IPCRequest, TaskOperationResponse> startDownloadTaskV2(AgdApiClient agdApiClient, StartDownloadV2IPCRequest startDownloadV2IPCRequest) {
        return new PendingResult<>(agdApiClient, startDownloadV2IPCRequest);
    }

    public static PendingResult<UnregisterDownloadCallbackIPCRequest, TaskOperationResponse> unregisterDownloadCallback(AgdApiClient agdApiClient, UnregisterDownloadCallbackIPCRequest unregisterDownloadCallbackIPCRequest) {
        return new PendingResult<>(agdApiClient, unregisterDownloadCallbackIPCRequest);
    }
}
