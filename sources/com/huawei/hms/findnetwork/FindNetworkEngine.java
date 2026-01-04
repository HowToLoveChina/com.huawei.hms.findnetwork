package com.huawei.hms.findnetwork;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.findnetwork.bean.BtMeasureResult;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.callback.PairingCallback;
import com.huawei.hms.findnetwork.comm.client.FindClientBuilder;
import com.huawei.hms.findnetwork.comm.client.FindOptions;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.request.OfflineLocationCipher;
import com.huawei.hms.findnetwork.comm.request.ResultTApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.AccessoryDetectResult;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.DecryptLocationCipherBean;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceOtaProgress;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceOtaTargetVersion;
import com.huawei.hms.findnetwork.comm.request.bean.DevicePeriodRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.DisConnectLocation;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectMode;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotificationParams;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotifyStatusBean;
import com.huawei.hms.findnetwork.comm.request.bean.FindNetworkRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.GetAntiStalkingRecordRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.GetFidRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.LocationRecordBean;
import com.huawei.hms.findnetwork.comm.request.bean.LostFindNotifyBean;
import com.huawei.hms.findnetwork.comm.request.bean.MultiTerminalDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.bean.PairingResultBean;
import com.huawei.hms.findnetwork.comm.request.bean.PassiveLocationRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.QueryTagDerivedKeyBean;
import com.huawei.hms.findnetwork.comm.request.bean.QueryTagDerivedRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SendHeartBeatRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SetDevicePublicKeysRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SetFindeeModeRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SetPublicKeysRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SetTrustTagRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.StartFindConfigRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagDerivedKey;
import com.huawei.hms.findnetwork.comm.request.bean.TagStatus;
import com.huawei.hms.findnetwork.comm.request.bean.UserOperationBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.BindDeviceRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.DeviceBindStatusResponse;
import com.huawei.hms.findnetwork.comm.request.bean.wear.EnableFoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidBatchRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.OfflineLocationBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.PairRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.PairResponseBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.PhoneResponseMessage;
import com.huawei.hms.findnetwork.comm.request.bean.wear.ShareDeviceRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener;
import com.huawei.hms.findnetwork.comm.request.callback.NearLinkNavigationCallback;
import com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkOfflineLocation;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult;
import com.huawei.hms.findnetwork.comm.util.CollectionUtil;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.comm.util.RomUtil;
import com.huawei.hms.findnetwork.comm.util.VerifyUtil;
import com.huawei.hms.findnetwork.exception.FindNetworkUnsupportedException;
import com.huawei.hms.findnetwork.exception.FindNetworkVerifyException;
import com.huawei.hms.findnetwork.sdk.C5343a0;
import com.huawei.hms.findnetwork.sdk.C5344a1;
import com.huawei.hms.findnetwork.sdk.C5345b;
import com.huawei.hms.findnetwork.sdk.C5347b1;
import com.huawei.hms.findnetwork.sdk.C5348c;
import com.huawei.hms.findnetwork.sdk.C5349c0;
import com.huawei.hms.findnetwork.sdk.C5350c1;
import com.huawei.hms.findnetwork.sdk.C5351d;
import com.huawei.hms.findnetwork.sdk.C5352d0;
import com.huawei.hms.findnetwork.sdk.C5353d1;
import com.huawei.hms.findnetwork.sdk.C5354e;
import com.huawei.hms.findnetwork.sdk.C5355e0;
import com.huawei.hms.findnetwork.sdk.C5357f;
import com.huawei.hms.findnetwork.sdk.C5358f0;
import com.huawei.hms.findnetwork.sdk.C5360g;
import com.huawei.hms.findnetwork.sdk.C5361g0;
import com.huawei.hms.findnetwork.sdk.C5362g1;
import com.huawei.hms.findnetwork.sdk.C5363h;
import com.huawei.hms.findnetwork.sdk.C5364h0;
import com.huawei.hms.findnetwork.sdk.C5365h1;
import com.huawei.hms.findnetwork.sdk.C5366i;
import com.huawei.hms.findnetwork.sdk.C5367i0;
import com.huawei.hms.findnetwork.sdk.C5368i1;
import com.huawei.hms.findnetwork.sdk.C5369j;
import com.huawei.hms.findnetwork.sdk.C5370j0;
import com.huawei.hms.findnetwork.sdk.C5371j1;
import com.huawei.hms.findnetwork.sdk.C5372k;
import com.huawei.hms.findnetwork.sdk.C5373k0;
import com.huawei.hms.findnetwork.sdk.C5375l;
import com.huawei.hms.findnetwork.sdk.C5376l0;
import com.huawei.hms.findnetwork.sdk.C5377l1;
import com.huawei.hms.findnetwork.sdk.C5378m;
import com.huawei.hms.findnetwork.sdk.C5379m0;
import com.huawei.hms.findnetwork.sdk.C5380m1;
import com.huawei.hms.findnetwork.sdk.C5381n;
import com.huawei.hms.findnetwork.sdk.C5384o;
import com.huawei.hms.findnetwork.sdk.C5387p;
import com.huawei.hms.findnetwork.sdk.C5388p0;
import com.huawei.hms.findnetwork.sdk.C5390q;
import com.huawei.hms.findnetwork.sdk.C5391q0;
import com.huawei.hms.findnetwork.sdk.C5392q1;
import com.huawei.hms.findnetwork.sdk.C5393r;
import com.huawei.hms.findnetwork.sdk.C5394r0;
import com.huawei.hms.findnetwork.sdk.C5395r1;
import com.huawei.hms.findnetwork.sdk.C5396s;
import com.huawei.hms.findnetwork.sdk.C5397s0;
import com.huawei.hms.findnetwork.sdk.C5398s1;
import com.huawei.hms.findnetwork.sdk.C5399t;
import com.huawei.hms.findnetwork.sdk.C5401t1;
import com.huawei.hms.findnetwork.sdk.C5402u;
import com.huawei.hms.findnetwork.sdk.C5403u0;
import com.huawei.hms.findnetwork.sdk.C5404v;
import com.huawei.hms.findnetwork.sdk.C5405v0;
import com.huawei.hms.findnetwork.sdk.C5406w;
import com.huawei.hms.findnetwork.sdk.C5407w0;
import com.huawei.hms.findnetwork.sdk.C5408x;
import com.huawei.hms.findnetwork.sdk.C5409x0;
import com.huawei.hms.findnetwork.sdk.C5410y;
import com.huawei.hms.findnetwork.sdk.C5413z0;
import com.huawei.hms.findnetwork.util.AgcParseUtil;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p208cq.C8941i;
import p208cq.C8943k;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class FindNetworkEngine extends HuaweiApi<Api.ApiOptions> {
    private static final String API_NAME = "nearby.findnetwork.API";
    private static final String META_API_LEVEL_KEY = "com.huawei.hms.min_api_level:findnetworksdk:findnetwork";
    private static final String TAG = "FindNetworkEngine";
    private String appId;
    private boolean isEMUI;
    private int mApiLevel;
    private int mUid;
    private String packageName;
    private String region;

    /* renamed from: com.huawei.hms.findnetwork.FindNetworkEngine$a */
    public static class C5336a extends ResultTApiCall<FindNetworkResult<List<FindNetworkOfflineLocation>>> {
        public C5336a(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.ResultTApiCall
        public boolean handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<List<FindNetworkOfflineLocation>>> c8941i) {
            c8941i.m56658d(new FindNetworkResult<>(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (List) JsonUtils.json2Object(str, new C5337b().getType())));
            return true;
        }
    }

    /* renamed from: com.huawei.hms.findnetwork.FindNetworkEngine$b */
    public static class C5337b extends TypeToken<List<FindNetworkOfflineLocation>> {
    }

    public FindNetworkEngine(Activity activity) {
        super(activity, (Api<FindOptions>) new Api(API_NAME), new FindOptions(), (AbstractClientBuilder) new FindClientBuilder(), 61502320);
        this.mApiLevel = 1;
        this.region = "";
        this.appId = "";
        this.packageName = "";
        initParam(activity);
    }

    private void checkThirdPartySupport(String str) throws FindNetworkException {
        if (this.isEMUI) {
            return;
        }
        HmsFindSDKLog.m32126e(TAG, "Unsupported function call, func:" + str);
        throw new FindNetworkUnsupportedException(ErrorCode.CODE_FUNCTION_UNSUPPORTED);
    }

    private Task<FindNetworkResult> disable() {
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5363h(baseRequestBean));
    }

    private void doDisconnectNotifyModeCall(String str, @DisconnectMode int i10, DisconnectNotificationParams disconnectNotificationParams, FindNetworkCallback<Void> findNetworkCallback) {
        if (disconnectNotificationParams == null) {
            disconnectNotificationParams = new DisconnectNotificationParams();
        }
        disconnectNotificationParams.setConnectTagSn(str);
        disconnectNotificationParams.setMode(i10);
        fillRequestBase(disconnectNotificationParams);
        doWrite(new C5366i(disconnectNotificationParams, findNetworkCallback));
    }

    private Task<FindNetworkResult> enable() {
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5375l(baseRequestBean));
    }

    private void initParam(Context context) {
        this.packageName = AgcParseUtil.getPackageName(context);
        this.appId = AgcParseUtil.getAppId(context);
        this.isEMUI = RomUtil.isEMUI();
        try {
            this.mApiLevel = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(META_API_LEVEL_KEY);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            HmsFindSDKLog.m32128w(TAG, "Not Found apiLevel, use default value.");
        }
        try {
            this.mUid = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).uid;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused2) {
            HmsFindSDKLog.m32128w(TAG, "get uid failed");
        }
    }

    public /* synthetic */ void lambda$setDisconnectNotification$0(String str, int i10, DisconnectNotificationParams disconnectNotificationParams, FindNetworkCallback findNetworkCallback, Void r52) {
        doDisconnectNotifyModeCall(str, i10, disconnectNotificationParams, findNetworkCallback);
    }

    public /* synthetic */ void lambda$setDisconnectNotification$1(String str, int i10, DisconnectNotificationParams disconnectNotificationParams, FindNetworkCallback findNetworkCallback, Exception exc) {
        doDisconnectNotifyModeCall(str, i10, disconnectNotificationParams, findNetworkCallback);
    }

    private void verifyFid(String str) throws FindNetworkException {
        if (VerifyUtil.verifySn(str)) {
            return;
        }
        HmsFindSDKLog.m32126e(TAG, "verifyFid failed: " + MaskUtil.maskSn(str));
        throw new FindNetworkVerifyException(ErrorCode.CODE_SN_INVALID);
    }

    private void verifyFids(List<String> list) throws FindNetworkException {
        if (CollectionUtil.isEmpty(list)) {
            HmsFindSDKLog.m32126e(TAG, "verifyFids failed: empty fid list.");
            throw new FindNetworkVerifyException(ErrorCode.CODE_SN_INVALID);
        }
        for (String str : list) {
            if (!VerifyUtil.verifySn(str)) {
                HmsFindSDKLog.m32126e(TAG, "verifyFids failed: " + MaskUtil.maskSn(str));
                throw new FindNetworkVerifyException(ErrorCode.CODE_SN_INVALID);
            }
        }
    }

    private void verifyMac(String str) throws FindNetworkException {
        if (VerifyUtil.verifyMAC(str)) {
            return;
        }
        HmsFindSDKLog.m32126e(TAG, "verifyMac format is error mac: " + MaskUtil.maskMac(str));
        throw new FindNetworkVerifyException(ErrorCode.CODE_MAC_INVALID);
    }

    public Task<FindNetworkResult<List<FindNetworkOfflineLocation>>> batchDecryptLocationCipher(List<OfflineLocationCipher> list) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "batchDecryptLocationCipher");
        checkThirdPartySupport("findnetwork.decrypt_location_batch");
        String strCreateTransactionId = createTransactionId();
        ArrayList arrayList = new ArrayList();
        for (OfflineLocationCipher offlineLocationCipher : list) {
            if (VerifyUtil.verifySn(offlineLocationCipher.getSn()) && !TextUtils.isEmpty(offlineLocationCipher.getPubKeyHash()) && !TextUtils.isEmpty(offlineLocationCipher.getCipherText())) {
                arrayList.add(offlineLocationCipher);
            }
        }
        if (arrayList.isEmpty()) {
            return C8943k.m56663c(new FindNetworkVerifyException(ErrorCode.CODE_PARAMETER_INVALID));
        }
        FindNetworkRequestBean findNetworkRequestBean = new FindNetworkRequestBean(arrayList);
        fillRequestBase(findNetworkRequestBean);
        return doWrite(new C5336a("findnetwork.decrypt_location_batch", JsonUtils.object2Json(findNetworkRequestBean), strCreateTransactionId));
    }

    public Task<Void> calibrateDevicePeriod(String str, String str2, FindNetworkCallback<String> findNetworkCallback) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "calibrateDevicePeriod fid: " + MaskUtil.maskSn(str));
        verifyFid(str);
        verifyMac(str2);
        return doWrite(new C5348c(new DevicePeriodRequestBean(str, str2), findNetworkCallback));
    }

    public Task<FindNetworkResult<DeviceBindStatusResponse>> checkDeviceStatus(String str) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "checkDeviceStatus fid: " + MaskUtil.maskSn(str));
        FidRequestBean fidRequestBean = new FidRequestBean();
        fidRequestBean.setFid(str);
        return doWrite(new C5351d(fidRequestBean));
    }

    public Task<Void> checkOtaVersion(String str, FindNetworkCallback<DeviceOtaTargetVersion> findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "checkOtaVersion fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.startCheckOta");
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5362g1(snRequestBean, findNetworkCallback));
    }

    public Task<Void> checkTagStatus(String str, FindNetworkCallback<TagStatus> findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "checkTagStatus fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.query_tag_derived_status");
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5354e(snRequestBean, findNetworkCallback));
    }

    public Task<Void> createLongConnection(String str, FindNetworkCallback findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "createLongConnection fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.tag_createLongConnection");
        C5399t.m32099a().m32105c(str, 17);
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5357f(snRequestBean, findNetworkCallback));
    }

    public String createTransactionId() {
        return TransactionIdCreater.getId(getAppID(), Integer.toString(this.mUid));
    }

    public Task<FindNetworkResult<String>> decryptLocationCipher(String str, String str2, String str3) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "decryptLocationCipher fid: " + MaskUtil.maskSn(str));
        if (!VerifyUtil.verifySn(str)) {
            return C8943k.m56663c(new FindNetworkVerifyException(ErrorCode.CODE_SN_INVALID));
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return C8943k.m56663c(new FindNetworkVerifyException(ErrorCode.CODE_PARAMETER_INVALID));
        }
        checkThirdPartySupport("findnetwork.decrypt_location_chiper");
        DecryptLocationCipherBean decryptLocationCipherBean = new DecryptLocationCipherBean();
        fillRequestBase(decryptLocationCipherBean);
        decryptLocationCipherBean.setConnectTagSn(str);
        decryptLocationCipherBean.setPubKeyHash(str2);
        decryptLocationCipherBean.setCipherText(str3);
        return doWrite(new C5360g(decryptLocationCipherBean));
    }

    public Task<Void> enableDisconnectNotification(String str, boolean z10) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "enableDisconnectNotification fid: " + MaskUtil.maskSn(str) + ", status: " + z10);
        checkThirdPartySupport("findnetwork.enableDisconnectNotification");
        DisconnectNotifyStatusBean disconnectNotifyStatusBean = new DisconnectNotifyStatusBean();
        disconnectNotifyStatusBean.setConnectTagSn(str);
        disconnectNotifyStatusBean.setStatus(z10);
        fillRequestBase(disconnectNotifyStatusBean);
        return doWrite(new C5369j(disconnectNotifyStatusBean));
    }

    public Task<FindNetworkResult> enableFindNetwork(boolean z10) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "enableFindNetwork status: " + z10);
        checkThirdPartySupport("findnetwork.enable");
        return z10 ? enable() : disable();
    }

    public Task<FindNetworkResult<String>> enableFoundNotification(String str, String str2) {
        return enableFoundNotification(str, str2, true);
    }

    public Task<Void> enableReFoundNotification(String str, boolean z10) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "enableReFoundNotification fid: " + MaskUtil.maskSn(str) + ", status: " + z10);
        checkThirdPartySupport("findnetwork.wear_enableFoundNotification");
        verifyFid(str);
        LostFindNotifyBean lostFindNotifyBean = new LostFindNotifyBean();
        fillRequestBase(lostFindNotifyBean);
        lostFindNotifyBean.setStatus(z10);
        lostFindNotifyBean.setConnectTagSn(str);
        return doWrite(new C5406w(lostFindNotifyBean));
    }

    public void fillRequestBase(BaseRequestBean baseRequestBean) {
        baseRequestBean.setUid(this.mUid);
        baseRequestBean.setAppId(this.appId);
        baseRequestBean.setPkgName(this.packageName);
        baseRequestBean.setRegion(this.region);
    }

    public Task<FindNetworkResult> getAntiStalkingRecords(String str) throws FindNetworkException {
        verifyMac(str);
        HmsFindSDKLog.m32127i(TAG, "getAntiStalkingRecords macAddress: " + MaskUtil.maskMac(str));
        checkThirdPartySupport("findnetwork.getAntiStalkingRecord");
        GetAntiStalkingRecordRequestBean getAntiStalkingRecordRequestBean = new GetAntiStalkingRecordRequestBean();
        fillRequestBase(getAntiStalkingRecordRequestBean);
        getAntiStalkingRecordRequestBean.setMacAddress(str);
        return doWrite(new C5384o(getAntiStalkingRecordRequestBean));
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return this.mApiLevel;
    }

    public Task<Void> getDeviceFid(String str, FindNetworkCallback<AccessoryDetectResult> findNetworkCallback) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "getDeviceFid macAddress: " + MaskUtil.maskMac(str));
        verifyMac(str);
        return doWrite(new C5387p(new GetFidRequestBean(str), findNetworkCallback));
    }

    public Task<FindNetworkResult> getSuspectStalkingTags() throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "getSuspectStalkingTags");
        checkThirdPartySupport("findnetwork.getSuspectStalkingTag");
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5390q(baseRequestBean));
    }

    public Task<FindNetworkResult> getTrustTags() throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "getTrustTags");
        checkThirdPartySupport("findnetwork.getTrustTag");
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5393r(baseRequestBean));
    }

    public Task<FindNetworkResult> grabDeviceLog(String str, GrabTagLogListener grabTagLogListener) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "grabDeviceLog fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.grab_tag_log");
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5396s(snRequestBean, grabTagLogListener));
    }

    public Task<FindNetworkResult<String>> initPairSession(String str) {
        HmsFindSDKLog.m32127i(TAG, "initPairSession: " + str);
        return doWrite(new C5404v(new BaseRequestBean()));
    }

    public Task<FindNetworkResult<PhoneResponseMessage>> processPairRequestMsg(String str, String str2, String str3) {
        HmsFindSDKLog.m32127i(TAG, "processPairRequestMsg");
        PairRequestBean pairRequestBean = new PairRequestBean();
        pairRequestBean.setMsg(str2);
        pairRequestBean.setVersion(str3);
        pairRequestBean.setSrcTranId(str);
        return doWrite(new C5349c0(pairRequestBean));
    }

    public Task<FindNetworkResult<String>> processPairResponseMsg(String str, String str2) {
        HmsFindSDKLog.m32127i(TAG, "processPairResponseMsg");
        PairResponseBean pairResponseBean = new PairResponseBean();
        pairResponseBean.setMsg(str2);
        pairResponseBean.setSrcTranId(str);
        return doWrite(new C5352d0(pairResponseBean));
    }

    public Task<FindNetworkResult<DeviceDetail>> queryDeviceDetail(String str) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "queryDeviceDetail fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.queryDeviceDetail");
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5355e0(snRequestBean));
    }

    public Task<FindNetworkResult<List<MultiTerminalDeviceInfo>>> queryDeviceListByAccount(String str) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "queryDeviceListByAccount fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.multiTerminalDeviceInfo");
        verifyFid(str);
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5410y(snRequestBean));
    }

    public Task<FindNetworkResult<TagDerivedKey>> queryDevicePublicKey(String str, long j10, long j11) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "queryDevicePublicKey fid: " + MaskUtil.maskSn(str) + ", beginTime: " + j10 + ", endTime: " + j11);
        checkThirdPartySupport("findnetwork.queryDevicePublicKey");
        QueryTagDerivedRequestBean queryTagDerivedRequestBean = new QueryTagDerivedRequestBean();
        queryTagDerivedRequestBean.setConnectTagSn(str);
        queryTagDerivedRequestBean.setBeginTime(j10);
        queryTagDerivedRequestBean.setEndTime(j11);
        fillRequestBase(queryTagDerivedRequestBean);
        return doWrite(new C5358f0(queryTagDerivedRequestBean));
    }

    public Task<FindNetworkResult<DisConnectLocation>> queryDisconnectLocation(String str, FindNetworkCallback<DisConnectLocation> findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "queryDisconnectLocation fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.queryDisconnectLocation");
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5361g0(snRequestBean, findNetworkCallback));
    }

    public Task<FindNetworkStatusResult> queryFindNetworkStatus() throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "queryFindNetworkStatus");
        checkThirdPartySupport("findnetwork.queryFindNetworkStatus");
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5364h0(baseRequestBean));
    }

    public Task<FindNetworkResult<List<LocationRecordBean>>> queryLocationRecord(long j10, long j11, int i10) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "queryLocationRecord startTime: " + j10 + ", endTime: " + j11 + ", locationSourceType: " + i10);
        checkThirdPartySupport("findnetwork.queryLocationRecord");
        PassiveLocationRequestBean passiveLocationRequestBean = new PassiveLocationRequestBean();
        passiveLocationRequestBean.setStartTime(j10);
        passiveLocationRequestBean.setEndTime(j11);
        passiveLocationRequestBean.setLocationSourceType(i10);
        fillRequestBase(passiveLocationRequestBean);
        return doWrite(new C5367i0(passiveLocationRequestBean));
    }

    public Task<FindNetworkResult<OfflineLocationBean>> queryOfflineLocation(String str) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "queryOfflineLocation fid: " + MaskUtil.maskSn(str));
        FidRequestBean fidRequestBean = new FidRequestBean();
        fidRequestBean.setFid(str);
        return doWrite(new C5370j0(fidRequestBean));
    }

    public Task<FindNetworkResult<List<PairedDeviceInfo>>> queryPairedDevices() throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "queryPairedDevices");
        checkThirdPartySupport("findnetwork.queryPairedDevices");
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5376l0(baseRequestBean));
    }

    public Task<FindNetworkResult<TagDerivedKey>> queryTagDerivedKey(String str, int i10) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "queryTagDerivedKey fid: " + MaskUtil.maskSn(str) + ", days: " + i10);
        checkThirdPartySupport("findnetwork.query_tag_derived_Key");
        QueryTagDerivedKeyBean queryTagDerivedKeyBean = new QueryTagDerivedKeyBean();
        fillRequestBase(queryTagDerivedKeyBean);
        queryTagDerivedKeyBean.setDays(i10);
        queryTagDerivedKeyBean.setConnectTagSn(str);
        return doWrite(new C5379m0(queryTagDerivedKeyBean));
    }

    public Task<FindNetworkResult<String>> requestBindDevice(String str, String str2, String str3) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "requestBindDevice fid: " + MaskUtil.maskSn(str));
        BindDeviceRequestBean bindDeviceRequestBean = new BindDeviceRequestBean();
        bindDeviceRequestBean.setFid(str);
        bindDeviceRequestBean.setSecondaryPublicKey(str2);
        bindDeviceRequestBean.setSrcTranId(str3);
        return doWrite(new C5388p0(bindDeviceRequestBean));
    }

    public Task<FindNetworkResult<String>> requestSharingDevice(String str, String str2, String str3) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "requestSharingDevice fid: " + MaskUtil.maskSn(str));
        ShareDeviceRequestBean shareDeviceRequestBean = new ShareDeviceRequestBean();
        shareDeviceRequestBean.setFid(str);
        shareDeviceRequestBean.setPublicKey(str2);
        shareDeviceRequestBean.setSrcTranId(str3);
        return doWrite(new C5391q0(shareDeviceRequestBean));
    }

    public Task<FindNetworkResult<String>> requestSharingPublicKey(String str) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "requestSharingPublicKey fid: " + MaskUtil.maskSn(str));
        FidRequestBean fidRequestBean = new FidRequestBean();
        fidRequestBean.setFid(str);
        return doWrite(new C5394r0(fidRequestBean));
    }

    public Task<FindNetworkResult> sendHeartBeat(String str, int i10, boolean z10) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "sendHeartBeat fid: " + MaskUtil.maskSn(str) + ", businessId: " + i10 + ", isStop: " + z10);
        checkThirdPartySupport("findnetwork.sendHeartBeat");
        SendHeartBeatRequestBean sendHeartBeatRequestBean = new SendHeartBeatRequestBean();
        sendHeartBeatRequestBean.setConnectTagSn(str);
        sendHeartBeatRequestBean.setBusinessId(i10);
        sendHeartBeatRequestBean.setStop(z10);
        fillRequestBase(sendHeartBeatRequestBean);
        return doWrite(new C5397s0(sendHeartBeatRequestBean));
    }

    public Task<Void> setDevicePublicKeys(Map<String, List<OfflineBroadcastParam>> map) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "setDevicePublicKeys");
        checkThirdPartySupport("findnetwork.setDevicePublicKeys");
        if (CollectionUtil.isEmpty(map)) {
            HmsFindSDKLog.m32126e(TAG, "setDevicePublicKeys: params invalid");
            return null;
        }
        SetDevicePublicKeysRequestBean setDevicePublicKeysRequestBean = new SetDevicePublicKeysRequestBean(map);
        fillRequestBase(setDevicePublicKeysRequestBean);
        return doWrite(new C5403u0(setDevicePublicKeysRequestBean));
    }

    public Task<Void> setDisconnectNotification(final String str, @DisconnectMode final int i10, final DisconnectNotificationParams disconnectNotificationParams, final FindNetworkCallback<Void> findNetworkCallback) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "setDisconnectNotification fid: " + MaskUtil.maskSn(str) + ", mode: " + i10);
        return enableDisconnectNotification(str, i10 != 0).addOnSuccessListener(new InterfaceC8939g() { // from class: eq.a
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f47378a.lambda$setDisconnectNotification$0(str, i10, disconnectNotificationParams, findNetworkCallback, (Void) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: eq.b
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f47383a.lambda$setDisconnectNotification$1(str, i10, disconnectNotificationParams, findNetworkCallback, exc);
            }
        });
    }

    public Task<Void> setFindeeMode(int i10) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "setFindeeMode duration: " + i10);
        checkThirdPartySupport("findnetwork.setFindeeMode");
        SetFindeeModeRequestBean setFindeeModeRequestBean = new SetFindeeModeRequestBean();
        fillRequestBase(setFindeeModeRequestBean);
        setFindeeModeRequestBean.setFindeeModeTime(i10);
        return doWrite(new C5405v0(setFindeeModeRequestBean));
    }

    public Task<Void> setPublicKeys(List<OfflineBroadcastParam> list, String str) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "setPublicKeys");
        checkThirdPartySupport("findnetwork.setPublicKeys");
        if (CollectionUtil.isEmpty(list)) {
            HmsFindSDKLog.m32126e(TAG, "publicKeys cannot be empty.");
            return null;
        }
        SetPublicKeysRequestBean setPublicKeysRequestBean = new SetPublicKeysRequestBean(list);
        fillRequestBase(setPublicKeysRequestBean);
        setPublicKeysRequestBean.setCountryCode(str);
        return doWrite(new C5407w0(setPublicKeysRequestBean));
    }

    public Task<Void> setTrustTag(String str, boolean z10) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "setTrustTag fid: " + MaskUtil.maskSn(str) + ", isTrust: " + z10);
        checkThirdPartySupport("findnetwork.setTrustTag");
        SetTrustTagRequestBean setTrustTagRequestBean = new SetTrustTagRequestBean(str, z10);
        fillRequestBase(setTrustTagRequestBean);
        return doWrite(new C5409x0(setTrustTagRequestBean));
    }

    public Task<FindNetworkResult<String>> silentUnPair(String str) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "silentUnPair fid: " + MaskUtil.maskSn(str));
        FidRequestBean fidRequestBean = new FidRequestBean();
        fidRequestBean.setFid(str);
        return doWrite(new C5401t1(fidRequestBean));
    }

    public Task<Void> startAccessoryDetect(FindNetworkCallback<AccessoryDetectResult> findNetworkCallback) {
        return doWrite(new C5413z0(new BaseRequestBean(), findNetworkCallback));
    }

    public Task<Void> startBTMeasure(String str, FindNetworkCallback<BtMeasureResult> findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "startBTMeasure fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.startBTMeasure");
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5344a1(snRequestBean, findNetworkCallback));
    }

    public Task<FindNetworkResult<Void>> startFastPair() throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "startFastPair");
        checkThirdPartySupport("findnetwork.startFastPair");
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5347b1(baseRequestBean));
    }

    public Task<Void> startFastScan(FindNetworkCallback<FindNetworkScanResult> findNetworkCallback) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "startFastScan");
        checkThirdPartySupport("findnetwork.startFastScan");
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        fillRequestBase(baseRequestBean);
        return doWrite(new C5350c1(findNetworkCallback, baseRequestBean));
    }

    public Task<FindNetworkConfigResult<PairingResultBean>> startFindNetworkConfiguration(String str, String str2, int i10, String str3, PairingCallback pairingCallback) throws FindNetworkException {
        verifyMac(str);
        HmsFindSDKLog.m32127i(TAG, "startFindNetworkConfiguration mac: " + MaskUtil.maskMac(str) + ", deviceName: " + str2 + ", goodsType: " + i10 + ", electricity: " + str3);
        checkThirdPartySupport("findnetwork.start_findnetwork_config");
        if (TextUtils.isEmpty(str3)) {
            throw new FindNetworkVerifyException(ErrorCode.CODE_PARAMETER_INVALID);
        }
        StartFindConfigRequestBean startFindConfigRequestBean = new StartFindConfigRequestBean(str);
        fillRequestBase(startFindConfigRequestBean);
        startFindConfigRequestBean.setDeviceName(str2);
        startFindConfigRequestBean.setElectricity(str3);
        startFindConfigRequestBean.setGoodsType(i10);
        return doWrite(new C5353d1(startFindConfigRequestBean, pairingCallback));
    }

    public Task<Void> startNavigate(Context context, String str, FindNetworkCallback findNetworkCallback) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "startNavigate");
        checkThirdPartySupport("findnetwork.start_navigate");
        verifyFid(str);
        C5381n.m32000a().m32021a(this, context, str, findNetworkCallback);
        return doWrite(new C5402u());
    }

    public Task<Void> startNearLinkNavigation(Context context, String str, NearLinkNavigationCallback nearLinkNavigationCallback) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "startNearLinkNavigation deviceId: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.startNearLinkNavigation");
        if (context == null || TextUtils.isEmpty(str) || nearLinkNavigationCallback == null) {
            throw new FindNetworkException("context, callback or deviceId null", ErrorCode.CODE_PARAMETER_INVALID);
        }
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        new C5343a0(this, snRequestBean, nearLinkNavigationCallback).m31966a(context);
        return doWrite(new C5402u());
    }

    public Task<Void> startOta(String str, FindNetworkCallback<DeviceOtaProgress> findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "startOta fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.manualOta");
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5408x(snRequestBean, findNetworkCallback));
    }

    public Task<Void> startSound(String str, boolean z10, FindNetworkSoundCallback findNetworkSoundCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "startSound fid: " + MaskUtil.maskSn(str) + ", isOwner: " + z10);
        checkThirdPartySupport("findnetwork.tag_start_sound");
        SoundRequestBean soundRequestBean = new SoundRequestBean();
        fillRequestBase(soundRequestBean);
        soundRequestBean.setConnectTagSn(str);
        soundRequestBean.setOwner(z10);
        return doWrite(new C5365h1(soundRequestBean, findNetworkSoundCallback));
    }

    public Task<Void> stopBTMeasure(String str, FindNetworkCallback findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "stopBTMeasure fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.stopBTMeasure");
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5368i1(snRequestBean, findNetworkCallback));
    }

    public Task<Void> stopNavigate(String str, FindNetworkCallback findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "stopNavigate fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.stop_navigate");
        C5381n.m32000a().m32026b();
        C5399t.m32099a().m32106d(str, 16);
        C5345b.m31985b().m31997f();
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5371j1(snRequestBean, findNetworkCallback));
    }

    public Task<Void> stopNearLinkNavigation(String str) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "stopNearLinkNavigation deviceId: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.stopNearLinkNavigation");
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return new C5343a0(this, snRequestBean, null).m31972f();
    }

    public Task<Void> stopSound(String str, boolean z10, FindNetworkSoundCallback findNetworkSoundCallback) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "stopSound fid: " + MaskUtil.maskSn(str) + ", isOwner: " + z10);
        checkThirdPartySupport("findnetwork.tag_stop_sound");
        SoundRequestBean soundRequestBean = new SoundRequestBean();
        fillRequestBase(soundRequestBean);
        soundRequestBean.setConnectTagSn(str);
        soundRequestBean.setOwner(z10);
        return doWrite(new C5377l1(soundRequestBean, findNetworkSoundCallback));
    }

    public Task<FindNetworkResult<List<PairedDeviceInfo>>> syncCloudDeviceData(String str) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "syncCloudDeviceData fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.syncTagInfo");
        verifyFid(str);
        SnRequestBean snRequestBean = new SnRequestBean();
        snRequestBean.setConnectTagSn(str);
        fillRequestBase(snRequestBean);
        return doWrite(new C5380m1(snRequestBean));
    }

    public Task<FindNetworkResult<Void>> unPair(String str, FindNetworkCallback findNetworkCallback) throws FindNetworkException {
        verifyFid(str);
        checkThirdPartySupport("findnetwork.tag_unpair");
        HmsFindSDKLog.m32127i(TAG, "unPair fid: " + MaskUtil.maskSn(str));
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5392q1(snRequestBean, findNetworkCallback));
    }

    public Task<Void> updateLongConnectionParams(String str) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "updateLongConnectionParams fid: " + MaskUtil.maskSn(str));
        checkThirdPartySupport("findnetwork.tag_updateLongConnectionParams");
        C5399t.m32099a().m32106d(str, 17);
        SnRequestBean snRequestBean = new SnRequestBean();
        fillRequestBase(snRequestBean);
        snRequestBean.setConnectTagSn(str);
        return doWrite(new C5372k(snRequestBean));
    }

    public Task<Void> userOperation(int i10, String str) throws FindNetworkException {
        HmsFindSDKLog.m32127i(TAG, "userOperation: code = " + i10);
        return doWrite(new C5395r1(new UserOperationBean(i10, str)));
    }

    public Task<Void> verifyDevicePeriod(String str, String str2, int i10, FindNetworkCallback<String> findNetworkCallback) {
        return doWrite(new C5398s1(new DevicePeriodRequestBean(str, str2, i10), findNetworkCallback));
    }

    public FindNetworkEngine(Context context) {
        super(context, (Api<FindOptions>) new Api(API_NAME), new FindOptions(), new FindClientBuilder(), 61502320);
        this.mApiLevel = 1;
        this.region = "";
        this.appId = "";
        this.packageName = "";
        initParam(context);
    }

    public Task<FindNetworkResult<List<FindNetworkOfflineLocation>>> batchDecryptLocationCipher(OfflineLocationCipher... offlineLocationCipherArr) throws FindNetworkException {
        return batchDecryptLocationCipher(Arrays.asList(offlineLocationCipherArr));
    }

    public Task<FindNetworkResult<String>> enableFoundNotification(String str, String str2, boolean z10) {
        HmsFindSDKLog.m32127i(TAG, "enableFoundNotification fid: " + MaskUtil.maskSn(str));
        EnableFoundRequestBean enableFoundRequestBean = new EnableFoundRequestBean();
        enableFoundRequestBean.setFid(str);
        enableFoundRequestBean.setSwitchOn(z10);
        enableFoundRequestBean.setAdditional(str2);
        return doWrite(new C5378m(enableFoundRequestBean));
    }

    public void queryOfflineLocation(List<String> list, FindNetworkCallback<List<OfflineLocationBean>> findNetworkCallback) throws FindNetworkException {
        verifyFids(list);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MaskUtil.maskSn(it.next()));
        }
        HmsFindSDKLog.m32127i(TAG, "queryOfflineLocation fids: " + JsonUtils.object2Json(arrayList));
        FidBatchRequestBean fidBatchRequestBean = new FidBatchRequestBean();
        fidBatchRequestBean.setFids(list);
        doWrite(new C5373k0(fidBatchRequestBean, findNetworkCallback));
    }

    public Task<FindNetworkResult> sendHeartBeat(String str, String str2, int[] iArr, boolean z10, String str3) throws FindNetworkException {
        verifyFid(str);
        HmsFindSDKLog.m32127i(TAG, "sendHeartBeat fid: " + MaskUtil.maskSn(str) + ", businessId: " + iArr + ", isStop: " + z10);
        checkThirdPartySupport("findnetwork.sendHeartBeat");
        SendHeartBeatRequestBean sendHeartBeatRequestBean = new SendHeartBeatRequestBean();
        sendHeartBeatRequestBean.setConnectTagSn(str);
        sendHeartBeatRequestBean.setBusinessIds(iArr);
        sendHeartBeatRequestBean.setSrcTranId(str2);
        sendHeartBeatRequestBean.setExtData(str3);
        sendHeartBeatRequestBean.setStop(z10);
        fillRequestBase(sendHeartBeatRequestBean);
        return doWrite(new C5397s0(sendHeartBeatRequestBean));
    }
}
