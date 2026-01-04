package p292fn;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import cn.C1461a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.bean.BmGuideEnabledInfo;
import com.huawei.hicloud.bean.BmServiceUpdateInfo;
import com.huawei.hicloud.bean.DeeplinkGuidePage;
import com.huawei.hicloud.bean.DeeplinkRoute;
import com.huawei.hicloud.bean.DestopPopupPolicy;
import com.huawei.hicloud.bean.FeatureSwitchReq;
import com.huawei.hicloud.bean.GradeMemberPrivilege;
import com.huawei.hicloud.bean.GraySwitch;
import com.huawei.hicloud.bean.H5SpaceFullDialogInfo;
import com.huawei.hicloud.bean.HiCloudSysParam;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.SpaceInsufficientH5PageInfo;
import com.huawei.hicloud.bean.SyncFlowControlPolicyExtInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.network.embedded.C5863b6;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p016an.C0313a;
import p372ip.C10585c;
import p372ip.C10586d;
import p459lp.C11327e;
import p616rk.C12515a;
import p618rm.C12540b1;
import p681uj.C13191h;
import p681uj.InterfaceC13190g;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import tm.C13040c;

/* renamed from: fn.f */
/* loaded from: classes6.dex */
public class C9733f implements InterfaceC13190g {

    /* renamed from: a */
    public long f47973a;

    /* renamed from: b */
    public boolean f47974b;

    /* renamed from: c */
    public boolean f47975c;

    /* renamed from: d */
    public List<String> f47976d;

    /* renamed from: e */
    public AtomicBoolean f47977e;

    /* renamed from: f */
    public boolean f47978f;

    /* renamed from: g */
    public GradeMemberPrivilege f47979g;

    /* renamed from: h */
    public DestopPopupPolicy f47980h;

    /* renamed from: i */
    public final String[] f47981i;

    /* renamed from: fn.f$a */
    public class a extends TypeToken<List<SyncFlowControlPolicyExtInfo>> {
        public a() {
        }
    }

    /* renamed from: fn.f$b */
    public static class b {

        /* renamed from: a */
        public static C9733f f47983a = new C9733f(null);
    }

    public C9733f() {
        this.f47973a = 0L;
        this.f47974b = false;
        this.f47975c = false;
        this.f47976d = new ArrayList();
        this.f47977e = new AtomicBoolean(false);
        this.f47978f = false;
        this.f47979g = null;
        this.f47980h = null;
        this.f47981i = new String[]{"pictureCompress", "dialogSilentDelay", "isShowUploadMidPage", "isUseSelfDevPhotoPicker", "backupTwinApp", "backupRefurbish", "isChildCodeOpen", "enableCloudBackupDelayStopOnScreen", "enableCloudBackupFrequencyOnDeviceIdle", "cloudBackupTempAGDCapbility", "backupSupportSplitApp", "backupSplitAppsPublish", "cloudBackupTempPPSCapbility", "cloudBackupAGDCapbility", "cloudBackupRefurbishAGDCapbility", "cloudBackupPPSCapbility", "cloudBackupRefurbishPPSCapbility", "cloudBackupBatchAppBackup", "enableAuthCode", "enableDownloadOMConfigFileCompress", "enableCloudPhotoAssetRefund", "supportNext2HmosRestore", "enableCloudPhotoAssetRefundReplace", "backupDisableApplySysAppsResource", "backupDisableApplySysAppsResourceEx", "enableProvideGalleryDisplayContent", "enableProvideGalleryDisplayContentV2", "cloudAlbumBatchGetSwitch", "cloudPhotoDisablePrepareReport", "cloudPhotoForceDownloadByFileProxy", "backupBundleCitOpt", "enableHiDiskHideLostCloudPhoto", "backupDBDifferential", "backupDBDifferentialCheck", "cloudBackupTarIteration", "cloudBackupTarIterationStatistics", "enableSyncAssetRefund", "appBackupDurationConfigFeature", "spaceCleanupSwitch", "cloudBackupPathMapping", "cloudPhotoObsFlowControl", "clientHwCookieFeature", "cloudBackupSnapshotBloomFilter", "cloudBackupTimeWindowCollect", "cloudBackupTimeWindowCollectEx", "cloudBackupBandwidthCollect", "newBusinessModelBackupGuidePage", "newBusinessModelGalleryGuidePage", "cloudBackupSyncAppExclusive", "cloudBackupSyncSwitchBackup", "cloudBackupTempBackup", "cloudBackupTarCopy", "cloudBackupRefurbishTarCopy", "cloudBackupSoftLinkCopy", "cloudBackupRefurbishSoftLinkCopy", "cloudBackupTempSoftLinkCopy", "cloudBackupHiddenAlbum", "cloudBackupRefurbishHiddenAlbum", "cloudBackupTempHiddenAlbum", "disableCloudBackupTempHiddenAlbum", "backupDataAcptErrPolicy", "enableSpaceFullPrompt", "cloudBackupSupportMobileNetwork", "cloudBackupRetryByBackupPeriod", "downloadOMConfigFileFlowControl", "cloudBackupSwitchDeleteSnapshotHealth", "cloudBackupGlobalFileReuse", "cloudBackupFileNameAnonymization", "cloudBackupWithIntegrityCheck", "cloudBackupSnapshotRecoverBackup", "cloudBackupSnapshotRecoverRestore", "cloudBackupPriorityThermalControl", "deeplinkGuidePage", "deeplinkActionGuidePage", "enableCPULoadReduction", "enableCPULoadReductionForBeta", "backupErrorPopupDefaultOptionIndex", "cloudBackupDeviceNameManagement", "enableCPULoadReductionPlus", "enableCPULoadReductionPlusForBeta", "disableSounderUseLocalUploadCache", "enablePhotoLimitReport", "businessTerminationRetention", "businessTerminationRetentionPopup", "businessJumpGarbleFileId", "userSelectsAutoRenewal", "webViewHierarchicalTrustlist", "backupDisableContactCustomerService", "cloudBackupDisableDirtyClear", "providerStorageLimitQuery", "uploadStatusHeader", "disableDozeOptimization", "disableBatteryOptimizationStatusDotting", "disableRefresh3rdMediaTimestamp", "processFatInvalidFileName", "bmEnabled", "bmNewUserGuidPage", "bmFreeUserGuidPage", "bmPaidUserGuidPage", "cloudBackupModuleInfoReport", "newBusinessModelCommonGuidePage", "newBusinessModelSyncGuidePage", "hideUpgradePackageCard", "syncFlowControlPolicy", "checkAppSignatureOnRestore", "backupRecorderRestoreCompat", "honorAppUpgrade", "cloudBackupTempBackup", "disableCacheClearScanLost", "vfsRefStatistics", "backupCompressionSparse", "backupVfsRefBypass", "disableHomePagePopupFromAccount", "disableBackupDeleteApplicationCacheFiles", "interimBackupDisableThermalControl", "bmGuideEnabled", "disableHistoryData", "bmFreeUserMenuPage", "bmPaidUserMenuPage", "TASKSYSTEM_NEED_NEW_BUSMODE", "showFirstBackupReport", "showRestoreSuccessReport", "disableBackupDeviceListRealTimeQuery", "dataDictLayoutService", "backupContainOhInterimRecords"};
    }

    /* renamed from: z */
    public static C9733f m60705z() {
        return b.f47983a;
    }

    /* renamed from: A */
    public BmServiceUpdateInfo m60706A(String str) {
        try {
            BmServiceUpdateInfo bmServiceUpdateInfo = (BmServiceUpdateInfo) new Gson().fromJson(m60762u(str), BmServiceUpdateInfo.class);
            if (bmServiceUpdateInfo != null) {
                return bmServiceUpdateInfo;
            }
            return null;
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getOhBmFreeUserMenuPage err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: B */
    public String m60707B() {
        try {
            BmGuideEnabledInfo bmGuideEnabledInfo = (BmGuideEnabledInfo) new Gson().fromJson(m60762u("bmGuideEnabled"), BmGuideEnabledInfo.class);
            if (bmGuideEnabledInfo != null) {
                return bmGuideEnabledInfo.getPackageId();
            }
            return null;
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getPackageId err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: C */
    public String m60708C() {
        try {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = m60705z().m60757p();
            return (hiCloudSysParamMapM60757p == null || TextUtils.isEmpty(hiCloudSysParamMapM60757p.getIapPayTypePolicy())) ? "" : new JSONObject(hiCloudSysParamMapM60757p.getIapPayTypePolicy()).getString("payTypePolicy");
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "Exception getPayTypePolicyList :" + e10.toString());
            return "";
        }
    }

    /* renamed from: D */
    public H5SpaceFullDialogInfo m60709D() {
        try {
            return (H5SpaceFullDialogInfo) new Gson().fromJson(m60762u("enableSpaceFullPrompt"), H5SpaceFullDialogInfo.class);
        } catch (JsonSyntaxException e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getSpaceFullDialogInfo err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: E */
    public SpaceInsufficientH5PageInfo m60710E(String str) {
        try {
            return (SpaceInsufficientH5PageInfo) new Gson().fromJson(m60762u(str), SpaceInsufficientH5PageInfo.class);
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getSpaceInsufficientH5PageInfo err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: F */
    public List<SyncFlowControlPolicyExtInfo> m60711F() {
        try {
            return (List) new Gson().fromJson(m60762u("syncFlowControlPolicy"), new a().getType());
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getSyncFlowControlPolicyExtInfo err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: G */
    public boolean m60712G() {
        return m60720O("appBackupDurationConfigFeature");
    }

    /* renamed from: H */
    public boolean m60713H() {
        return m60720O("backupDBDifferentialCheck");
    }

    /* renamed from: I */
    public boolean m60714I() {
        return m60720O("backupDBDifferential");
    }

    /* renamed from: J */
    public boolean m60715J() {
        return m60720O("bmGuideEnabled");
    }

    /* renamed from: K */
    public boolean m60716K() {
        return m60720O("cloudBackupBandwidthCollect");
    }

    /* renamed from: L */
    public boolean m60717L() {
        return m60720O("cloudBackupSupportMobileNetwork");
    }

    /* renamed from: M */
    public boolean m60718M() {
        return m60720O("disableHomePagePopupFromAccount");
    }

    /* renamed from: N */
    public boolean m60719N() {
        if (this.f47977e.compareAndSet(false, true)) {
            C1461a.m8359i("HiCloudSysParamManager", "isFeatureFatInvalidSwitchOpen do get");
            this.f47978f = m60705z().m60763v("processFatInvalidFileName") == 1;
        }
        return this.f47978f;
    }

    /* renamed from: O */
    public boolean m60720O(String str) {
        return m60705z().m60763v(str) == 1;
    }

    /* renamed from: P */
    public boolean m60721P() {
        return m60720O("honorAppUpgrade");
    }

    /* renamed from: Q */
    public boolean m60722Q() {
        return this.f47974b;
    }

    /* renamed from: R */
    public boolean m60723R() {
        return this.f47975c;
    }

    /* renamed from: S */
    public boolean m60724S(int i10) {
        if (m60720O("enablePhotoLimitReport")) {
            return (C0241z.m1685c(m60762u("enablePhotoLimitReport")) & i10) != 0;
        }
        C1461a.m8357d("HiCloudSysParamManager", "isPhotoLimitReportOpened close");
        return false;
    }

    /* renamed from: T */
    public boolean m60725T() {
        return m60720O("spaceCleanupSwitch");
    }

    /* renamed from: U */
    public boolean m60726U() {
        boolean zM60720O = m60720O("clientHwCookieFeature");
        C1461a.m8357d("HiCloudSysParamManager", "isSupportClientHwCookie:" + zM60720O);
        return zM60720O;
    }

    /* renamed from: V */
    public boolean m60727V() {
        return m60705z().m60720O("syncFlowControlPolicy");
    }

    /* renamed from: W */
    public final boolean m60728W() {
        if (m60723R()) {
            C1461a.m8360w("HiCloudSysParamManager", "isObtainedH5FeatureSwitchConfig is true");
            return false;
        }
        if (!m60720O("deeplinkActionGuidePage")) {
            C1461a.m8360w("HiCloudSysParamManager", "DEEPLINK_ACTION_GUIDE_PAGE is false");
            return false;
        }
        DeeplinkGuidePage deeplinkGuidePageM60760s = m60760s();
        if (deeplinkGuidePageM60760s == null) {
            C1461a.m8360w("HiCloudSysParamManager", "deeplinkGuidePage is null");
            return false;
        }
        m60741f(deeplinkGuidePageM60760s.getDeeplinkRoute());
        m60741f(deeplinkGuidePageM60760s.getActionRoute());
        m60741f(deeplinkGuidePageM60760s.getActionPackageRoute());
        return true;
    }

    /* renamed from: X */
    public boolean m60729X(int i10) {
        return m60705z().m60763v("hideUpgradePackageCard") == i10;
    }

    /* renamed from: Y */
    public boolean m60730Y(int i10) {
        if (m60720O("uploadStatusHeader")) {
            return (C0241z.m1685c(m60762u("uploadStatusHeader")) & i10) != 0;
        }
        C1461a.m8357d("HiCloudSysParamManager", "isUploadStatusSwitch close");
        return false;
    }

    /* renamed from: Z */
    public boolean m60731Z() {
        boolean zM60720O = m60720O("webViewHierarchicalTrustlist");
        C1461a.m8359i("HiCloudSysParamManager", "isUseWebViewHierarchicalTrustlist:" + zM60720O);
        return zM60720O;
    }

    @Override // p681uj.InterfaceC13190g
    /* renamed from: a */
    public boolean mo60732a() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = m60758q();
        if (hiCloudSysParamMapM60758q != null) {
            return hiCloudSysParamMapM60758q.isOMUseDefaultGzip();
        }
        return true;
    }

    /* renamed from: a0 */
    public final /* synthetic */ void m60733a0() {
        C1461a.m8359i("HiCloudSysParamManager", "entre new thread");
        m60750j0(false, true);
    }

    @Override // p681uj.InterfaceC13190g
    /* renamed from: b */
    public boolean mo60734b(String str) {
        C1461a.m8359i("HiCloudSysParamManager", "isFreeUser, gradeCode: " + str);
        List<String> normalGradeCodes = m60765x().getNormalGradeCodes();
        if (AbstractC14026a.m84159a(normalGradeCodes)) {
            normalGradeCodes = new ArrayList<>(Arrays.asList("N", CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE));
        }
        for (String str2 : normalGradeCodes) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b0 */
    public final boolean m60735b0() {
        try {
            if (!C13452e.m80781L().m80842P0()) {
                C1461a.m8359i("HiCloudSysParamManager", "processOMConfig user not login.");
                return false;
            }
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                C1461a.m8359i("HiCloudSysParamManager", "startDownloadTask no network");
                return false;
            }
            if (!m60743g()) {
                C1461a.m8357d("HiCloudSysParamManager", "get OM config not exceeding 1 hour");
                return false;
            }
            if (m60753l()) {
                return false;
            }
            C1461a.m8357d("HiCloudSysParamManager", "processOMConfig");
            return true;
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "needProcessOMConfig exception: " + e10.toString());
            return false;
        }
    }

    @Override // p681uj.InterfaceC13190g
    /* renamed from: c */
    public boolean mo60736c() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = m60758q();
        if (hiCloudSysParamMapM60758q != null) {
            return hiCloudSysParamMapM60758q.isOMUseDefaultFlowControl();
        }
        return true;
    }

    /* renamed from: c0 */
    public void m60737c0() {
        m60739d0(null);
    }

    @Override // p681uj.InterfaceC13190g
    /* renamed from: d */
    public boolean mo60738d(String str) {
        return m60705z().m60763v(str) == 1;
    }

    /* renamed from: d0 */
    public void m60739d0(CountDownLatch countDownLatch) {
        boolean zM60735b0 = m60735b0();
        C1461a.m8359i("HiCloudSysParamManager", "needProcessOMConfig:" + zM60735b0);
        if (zM60735b0) {
            C12515a.m75110o().m75175e(new C10586d(countDownLatch), countDownLatch == null);
        } else {
            C0209d.m1275l(countDownLatch);
        }
    }

    /* renamed from: e0 */
    public void m60740e0(FeatureSwitchReq featureSwitchReq) {
        C1461a.m8359i("HiCloudSysParamManager", "registeFeatureGraySwitch isObtainedH5FeatureSwitchConfig : " + this.f47975c);
        if (!m60723R()) {
            for (String str : this.f47981i) {
                featureSwitchReq.getFunctionIds().add(str);
            }
        }
        if (m60723R()) {
            featureSwitchReq.getFunctionIds().addAll(this.f47976d);
            C1461a.m8359i("HiCloudSysParamManager", "deeplinkInnerPage size: " + this.f47976d.size());
        }
    }

    /* renamed from: f */
    public void m60741f(DeeplinkRoute[] deeplinkRouteArr) {
        if (deeplinkRouteArr != null) {
            for (DeeplinkRoute deeplinkRoute : deeplinkRouteArr) {
                if (deeplinkRoute != null) {
                    String params = deeplinkRoute.getParams();
                    if (!TextUtils.isEmpty(params) && !this.f47976d.contains(params)) {
                        this.f47976d.add(params);
                    }
                    String paramsSec = deeplinkRoute.getParamsSec();
                    if (!TextUtils.isEmpty(deeplinkRoute.getParamsSec()) && !this.f47976d.contains(paramsSec)) {
                        this.f47976d.add(paramsSec);
                    }
                }
            }
        }
    }

    /* renamed from: f0 */
    public void m60742f0() {
        this.f47973a = System.currentTimeMillis();
        C1461a.m8359i("HiCloudSysParamManager", "get OM config fail, time = " + this.f47973a);
    }

    /* renamed from: g */
    public boolean m60743g() {
        return System.currentTimeMillis() - this.f47973a > C5863b6.g.f26453g;
    }

    /* renamed from: g0 */
    public void m60744g0(boolean z10) {
        this.f47974b = z10;
    }

    /* renamed from: h */
    public void m60745h() {
        try {
            File file = new File(C0213f.m1378b().getFilesDir() + File.separator + "hicloud_sys_param.json");
            if (file.exists()) {
                boolean zDelete = file.delete();
                if (!zDelete) {
                    C1461a.m8358e("HiCloudSysParamManager", "clearConfigFile deleteResult is:" + zDelete);
                }
            } else {
                C1461a.m8358e("HiCloudSysParamManager", "clearConfigFile file not exist");
            }
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "clearConfigFile exception:" + e10.toString());
        }
    }

    /* renamed from: h0 */
    public void m60746h0(boolean z10) {
        this.f47975c = z10;
    }

    /* renamed from: i */
    public void m60747i() {
        this.f47975c = false;
        new C0313a().clear();
    }

    /* renamed from: i0 */
    public void m60748i0(boolean z10) {
        m60750j0(z10, false);
    }

    /* renamed from: j */
    public void m60749j() {
        this.f47973a = 0L;
        this.f47979g = null;
        m60765x();
        this.f47980h = null;
        m60761t();
    }

    /* renamed from: j0 */
    public void m60750j0(boolean z10, boolean z11) {
        C1461a.m8359i("HiCloudSysParamManager", "updateFeatureSwitchConfig  isAgainUpdate " + z11);
        if (C13452e.m80781L().m80842P0()) {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C1461a.m8358e("HiCloudSysParamManager", "context is null");
                return;
            }
            if (!C0209d.m1333z1(contextM1377a)) {
                C1461a.m8359i("HiCloudSysParamManager", "startDownloadTask no network");
                return;
            }
            C1461a.m8357d("HiCloudSysParamManager", "updateFeatureSwitchConfig");
            if (m60753l()) {
                return;
            }
            if (z10 && !C10028c.m62182c0().m62314d()) {
                C1461a.m8360w("HiCloudSysParamManager", "background and not over 24 hours");
            } else {
                C12515a.m75110o().m75175e(new C10585c(z11), true);
            }
        }
    }

    /* renamed from: k */
    public boolean m60751k() {
        return m60720O("disableBackupDeleteApplicationCacheFiles");
    }

    /* renamed from: k0 */
    public void m60752k0() {
        C1461a.m8359i("HiCloudSysParamManager", "updateSwitchStatusAgain");
        if (m60728W()) {
            C1461a.m8359i("HiCloudSysParamManager", "isUpdateSwitchData is true");
            m60746h0(true);
            new Thread(new Runnable() { // from class: fn.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f47972a.m60733a0();
                }
            }).start();
        }
    }

    /* renamed from: l */
    public final boolean m60753l() {
        try {
            if (!TextUtils.isEmpty(C13040c.m78609F().m78611B())) {
                return false;
            }
            C1461a.m8359i("HiCloudSysParamManager", "url is empty");
            return true;
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "get url exception: " + e10.toString());
            return true;
        }
    }

    /* renamed from: m */
    public String m60754m() throws JSONException {
        String string;
        HiCloudSysParamMap hiCloudSysParamMapM60757p = m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            try {
                string = new JSONObject(hiCloudSysParamMapM60757p.getAgAdItemUrls()).getString("appsUrl");
            } catch (Exception e10) {
                C1461a.m8358e("HiCloudSysParamManager", "getAppCenterUrl error : " + e10.toString());
            }
        } else {
            string = "";
        }
        if (StringUtil.isBlank(string)) {
            string = m60755n();
        }
        if (StringUtil.isBlank(string)) {
            C1461a.m8360w("HiCloudSysParamManager", "getAppCenterUrl is blank!");
            return string;
        }
        Uri.Builder builderBuildUpon = Uri.parse(string).buildUpon();
        builderBuildUpon.appendQueryParameter("mediaPackageName", "com.huawei.hidisk");
        return builderBuildUpon.toString();
    }

    /* renamed from: n */
    public String m60755n() {
        try {
            StringBuffer stringBuffer = new StringBuffer(C13040c.m78609F().m78657l());
            stringBuffer.append("/open/apps");
            return stringBuffer.toString();
        } catch (C9721b e10) {
            C1461a.m8358e("HiCloudSysParamManager", "CException getAppGalleryCenterUrl :" + e10.toString());
            return "";
        }
    }

    /* renamed from: o */
    public boolean m60756o() {
        try {
            BmGuideEnabledInfo bmGuideEnabledInfo = (BmGuideEnabledInfo) new Gson().fromJson(m60762u("bmGuideEnabled"), BmGuideEnabledInfo.class);
            if (bmGuideEnabledInfo != null) {
                return bmGuideEnabledInfo.isCheck();
            }
            return true;
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getPackageId err : " + e10.getMessage());
            return true;
        }
    }

    /* renamed from: p */
    public HiCloudSysParamMap m60757p() {
        File file = new File(C0213f.m1378b().getFilesDir() + File.separator + "hicloud_sys_param.json");
        if (file.exists()) {
            C1461a.m8357d("HiCloudSysParamManager", "getConfigFromFile");
            return m60766y(file);
        }
        C11327e.m68071n("HiCloudSysParam", 0L);
        C11327e.m68067j("HiCloudSysParam", "");
        C1461a.m8358e("HiCloudSysParamManager", "config file is not existed.");
        m60739d0(null);
        return null;
    }

    /* renamed from: q */
    public HiCloudSysParamMap m60758q() {
        return m60759r(C0213f.m1377a());
    }

    /* renamed from: r */
    public HiCloudSysParamMap m60759r(Context context) {
        File file = new File(context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "hicloud_sys_param.json");
        if (file.exists()) {
            C1461a.m8357d("HiCloudSysParamManager", "getConfigFromLocalFile");
            return m60766y(file);
        }
        C1461a.m8358e("HiCloudSysParamManager", "config file is not existed.");
        return null;
    }

    /* renamed from: s */
    public DeeplinkGuidePage m60760s() {
        try {
            return (DeeplinkGuidePage) new Gson().fromJson(m60762u("deeplinkActionGuidePage"), DeeplinkGuidePage.class);
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getDeeplinkActionGuidePage err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: t */
    public DestopPopupPolicy m60761t() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p;
        C1461a.m8359i("HiCloudSysParamManager", "getDestopPopupPolicy enter");
        DestopPopupPolicy destopPopupPolicy = this.f47980h;
        if (destopPopupPolicy != null) {
            return destopPopupPolicy;
        }
        try {
            hiCloudSysParamMapM60757p = m60757p();
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getDestopPopupPolicy error: " + e10.getMessage());
        }
        if (hiCloudSysParamMapM60757p == null) {
            C1461a.m8360w("HiCloudSysParamManager", "configFromFile is null");
            return new DestopPopupPolicy();
        }
        this.f47980h = (DestopPopupPolicy) C12540b1.m75483a(hiCloudSysParamMapM60757p.getDestopPopupPolicy(), DestopPopupPolicy.class);
        C1461a.m8359i("HiCloudSysParamManager", "getDestopPopupPolicy exit");
        DestopPopupPolicy destopPopupPolicy2 = this.f47980h;
        return destopPopupPolicy2 == null ? new DestopPopupPolicy() : destopPopupPolicy2;
    }

    /* renamed from: u */
    public String m60762u(String str) {
        List<GraySwitch> listM1899b = new C0313a().m1899b(str);
        return (listM1899b == null || listM1899b.size() == 0) ? "" : listM1899b.get(0).getParameters();
    }

    /* renamed from: v */
    public int m60763v(String str) {
        List<GraySwitch> listM1899b = new C0313a().m1899b(str);
        if (listM1899b == null || listM1899b.size() == 0) {
            C1461a.m8359i("HiCloudSysParamManager", "getFeatureSwitchStatus null");
            return 0;
        }
        GraySwitch graySwitch = listM1899b.get(0);
        C1461a.m8359i("HiCloudSysParamManager", "graySwitch:" + graySwitch.getStatus());
        return graySwitch.getStatus();
    }

    /* renamed from: w */
    public GraySwitch m60764w(String str) {
        List<GraySwitch> listM1899b = new C0313a().m1899b(str);
        if (listM1899b == null || listM1899b.size() == 0) {
            return null;
        }
        return listM1899b.get(0);
    }

    /* renamed from: x */
    public GradeMemberPrivilege m60765x() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p;
        C1461a.m8359i("HiCloudSysParamManager", "getGradeMemberPrivilege enter");
        GradeMemberPrivilege gradeMemberPrivilege = this.f47979g;
        if (gradeMemberPrivilege != null && !AbstractC14026a.m84159a(gradeMemberPrivilege.getNormalGradeCodes())) {
            return this.f47979g;
        }
        try {
            hiCloudSysParamMapM60757p = m60757p();
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "getBackupMemberPrivilege error: " + e10.getMessage());
        }
        if (hiCloudSysParamMapM60757p == null) {
            C1461a.m8360w("HiCloudSysParamManager", "configFromFile is null");
            return new GradeMemberPrivilege();
        }
        this.f47979g = (GradeMemberPrivilege) C12540b1.m75483a(hiCloudSysParamMapM60757p.getGradeMemberPrivilege(), GradeMemberPrivilege.class);
        C1461a.m8359i("HiCloudSysParamManager", "getGradeMemberPrivilege exit");
        GradeMemberPrivilege gradeMemberPrivilege2 = this.f47979g;
        return gradeMemberPrivilege2 == null ? new GradeMemberPrivilege() : gradeMemberPrivilege2;
    }

    /* renamed from: y */
    public final HiCloudSysParamMap m60766y(File file) throws Throwable {
        HiCloudSysParamMap hiCloudSysParamMap = null;
        try {
            hiCloudSysParamMap = ((HiCloudSysParam) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(file)), HiCloudSysParam.class)).getHiCloudSysParamMap();
            HiCloudSysParamMapCache.refreshSysParamMapCache(hiCloudSysParamMap);
            C13191h.m79248a().m79253f(this);
            return hiCloudSysParamMap;
        } catch (Exception e10) {
            C1461a.m8358e("HiCloudSysParamManager", "cloud config file not exist, msg:" + e10.getMessage());
            return hiCloudSysParamMap;
        }
    }

    public /* synthetic */ C9733f(a aVar) {
        this();
    }
}
