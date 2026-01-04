package com.huawei.android.hicloud.commonlib.helper;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import fk.C9721b;
import gp.C10028c;
import java.io.Serializable;
import java.util.LinkedHashMap;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;
import to.C13049a;

/* loaded from: classes3.dex */
public class HisyncProxyService extends Service {

    /* renamed from: a */
    public IHisyncProxyCallBack f12022a;

    /* renamed from: c */
    public HandlerC2767c f12024c;

    /* renamed from: d */
    public IsHwIdLoginCallBack f12025d;

    /* renamed from: e */
    public CheckUpgradeCallBack f12026e;

    /* renamed from: b */
    public HandlerThread f12023b = null;

    /* renamed from: f */
    public Binder f12027f = new BinderC2765a();

    /* renamed from: g */
    public CheckUpdateCallBack f12028g = new C2766b();

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.HisyncProxyService$a */
    public class BinderC2765a extends IHisyncProxyService.AbstractBinderC2770a {

        /* renamed from: com.huawei.android.hicloud.commonlib.helper.HisyncProxyService$a$a */
        public class a implements InterfaceC13456i {
            public a() {
            }

            @Override // p709vj.InterfaceC13456i
            public void loginResult(boolean z10) {
                try {
                    C11839m.m70686d("HisyncProxyService", "loginResult: " + z10);
                    HisyncProxyService.this.f12025d.loginResult(z10);
                } catch (RemoteException e10) {
                    C11839m.m70687e("HisyncProxyService", "isHwIdLogin Exception" + e10.toString());
                }
            }
        }

        public BinderC2765a() {
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void HAEventWithInfo(String str, String str2, String str3, String str4) throws RemoteException {
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put(str3, str4);
            C13230i.m79504I().m79591l0(str, linkedHashMapM79499C);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void HAonPause(String str) throws RemoteException {
            C13230i.m79504I().m79580Z(str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void HAonResume(String str) throws RemoteException {
            C13230i.m79504I().m79584d0(str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void HApageActionEvent(String str, String str2) throws RemoteException {
            C13230i.m79504I().m79585f0(str, str2);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void HAreportOpenCloudSpace(String str) throws RemoteException {
            C13230i.m79504I().m79561L0(str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void UBAEvent(String str, String str2, String str3, String str4) throws RemoteException {
            UBAAnalyze.m29954O(str, str2, str3, str4);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void UBAEventWithInfo(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException {
            UBAAnalyze.m29957R(str, str2, str3, str4, str5, str6);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void UBAonEventOnePair(String str, String str2, String str3, String str4) throws RemoteException {
            UBAAnalyze.m29949J(str, str2, str3, str4);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void UBAonPageEvent(String str, String str2, String str3, String str4) throws RemoteException {
            UBAAnalyze.m29954O(str, str2, str3, str4);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void UBAonPause(String str, String str2, String str3, String str4, int i10) throws RemoteException {
            UBAAnalyze.m29964Y(str, str2, str3, str4, i10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void UBAonResume(String str, String str2, String str3, String str4) throws RemoteException {
            UBAAnalyze.m29967a0(str, str2, str3, str4);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void albumNotifySwitchChanged(Bundle bundle) throws RemoteException {
            if (HisyncProxyService.this.getApplicationContext() != null) {
                C11019b.m66371t().m66411c(HisyncProxyService.this.getApplicationContext(), bundle);
            }
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void cancelSpaceUsedNotifyTimer() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void checkPushNotifications() throws RemoteException {
            C11019b.m66371t().m66419g(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void checkUpgrade(String str) throws RemoteException {
            AbstractC10896a.m65887i("HisyncProxyService", "checkUpgrade");
            UpdateSdkAPI.checkTargetAppUpdate(HisyncProxyService.this.getApplicationContext(), str, HisyncProxyService.this.f12028g);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void clearAllConfig() throws RemoteException {
            C10028c.m62182c0().m62343j();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void cloudbackupOpr(boolean z10) throws RemoteException {
            C11019b.m66371t().m66425j(z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void collectEvent(String str, String str2) throws RemoteException {
            C11019b.m66371t().m66427k(HisyncProxyService.this.getApplicationContext(), str, str2);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void collectOOBEMigrate(int i10, String str) throws RemoteException {
            C11019b.m66371t().m66429l(HisyncProxyService.this.getApplicationContext(), i10, str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void executeQueryBasicTask(IHisyncProxyCallBack iHisyncProxyCallBack, int i10, boolean z10) throws RemoteException {
            C11019b.m66371t().m66435o(HisyncProxyService.this.getApplicationContext(), HisyncProxyService.this.f12024c, i10, z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean getAutoListBackupOn(String str) throws RemoteException {
            return C10028c.m62182c0().m62388s(str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public String getHiSyncClass(String str) throws RemoteException {
            return C11019b.m66371t().m66441r(str).getName();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public String getOOBEAgreement(String str) throws RemoteException {
            return C11019b.m66371t().m66446u(HisyncProxyService.this.getApplicationContext(), str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean getPhonefinderSwitch() throws RemoteException {
            return C11019b.m66371t().m66448v(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean getSwitchDefaultValue(String str, boolean z10) throws RemoteException {
            return C11019b.m66371t().m66372A(HisyncProxyService.this.getApplicationContext(), str, z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void ifHidePhoneFinderSettingSugg() throws RemoteException {
            C11019b.m66371t().m66374B(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void ifShowPhoneFinderSettingSugg() throws RemoteException {
            C11019b.m66371t().m66376C(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean inBackup() throws RemoteException {
            C11839m.m70687e("HisyncProxyService", "inBackup");
            return C11019b.m66371t().m66378D();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean inRestore() throws RemoteException {
            C11839m.m70687e("HisyncProxyService", "inRestore");
            return C11019b.m66371t().m66380E();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean inRestoreFirst() throws RemoteException {
            return C11019b.m66371t().m66382F();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void initHiAnalyticsUtil(String str) throws RemoteException {
            C13230i.m79504I().m79560L(HisyncProxyService.this.getApplicationContext(), str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void initUnloginOOBETaskChecker() throws RemoteException {
            C11019b.m66371t().m66390J(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isBrowserSupportSyncAbility() throws RemoteException {
            return C11019b.m66371t().m66391K(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isEuropeAccount() throws RemoteException {
            return C11829c.m70620u0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isHiCloudLogin() throws RemoteException {
            return C11019b.m66371t().m66397Q(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void isHwIdLogin() throws RemoteException {
            C13612b.m81829B().mo80999a(HisyncProxyService.this.getApplicationContext(), new a());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isModuleEnable(String str) throws RemoteException {
            return C10028c.m62182c0().m62395t1(str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isSendPhoneFinderOning() throws RemoteException {
            return C11019b.m66371t().m66398R();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isShowGalleryItemView() throws RemoteException {
            return C11019b.m66371t().m66399S();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isSupportAntiTheft() throws RemoteException {
            return C11019b.m66371t().m66400T();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean isSupportPhoneFinder() throws RemoteException {
            return C11829c.m70536O0();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void normalBIReport() throws RemoteException {
            C11019b.m66371t().m66416e0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void oobeBIReport() throws RemoteException {
            C11019b.m66371t().m66420g0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void openPhoneFinderInBack() throws RemoteException {
            C11019b.m66371t().m66422h0();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void processSignAgreement(boolean z10, boolean z11, boolean z12, boolean z13) throws RemoteException {
            C11019b.m66371t().m66424i0(HisyncProxyService.this.getApplicationContext(), z10, z11, z12, z13);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void regLoginCallback(IsHwIdLoginCallBack isHwIdLoginCallBack) throws RemoteException {
            AbstractC10896a.m65887i("HisyncProxyService", "regLoginCallback");
            HisyncProxyService.this.f12025d = isHwIdLoginCallBack;
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void regUpgradeCallback(CheckUpgradeCallBack checkUpgradeCallBack) throws RemoteException {
            AbstractC10896a.m65887i("HisyncProxyService", "regUpgradeCallback");
            HisyncProxyService.this.f12026e = checkUpgradeCallBack;
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean registerCallBack(IHisyncProxyCallBack iHisyncProxyCallBack) throws RemoteException {
            C11839m.m70688i("HisyncProxyService", "registerCallBack");
            if (iHisyncProxyCallBack == null) {
                return false;
            }
            HisyncProxyService.this.f12022a = iHisyncProxyCallBack;
            return true;
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void report(String str, boolean z10) throws RemoteException {
            C11019b.m66371t().m66436o0(HisyncProxyService.this.getApplicationContext(), str, z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void reportAppEvent(String str) throws RemoteException {
            C11019b.m66371t().m66438p0(HisyncProxyService.this.getApplicationContext(), str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void reportCloseCloudBackup() throws RemoteException {
            try {
                C13230i.m79504I().m79601y0(C11019b.m66371t().m66443s().longValue(), new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78754r());
            } catch (C9721b e10) {
                C11839m.m70688i("HisyncProxyService", "reportCloseCloudBackup error: " + e10.toString());
            }
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void saveBooleanSp(String str, String str2, boolean z10) throws RemoteException {
            C0214f0.m1382b(HisyncProxyService.this.getApplicationContext(), str, 0).edit().putBoolean(str2, z10).commit();
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void saveSwitchStatusAndSync(String str) throws RemoteException {
            C11829c.m70582h1(HisyncProxyService.this.getApplicationContext(), str);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void scheduleGetConfigJob() throws RemoteException {
            C11019b.m66371t().m66442r0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void setAllModuleDisable() throws RemoteException {
            C11019b.m66371t().m66444s0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean setAutoListBackupOn(String str, boolean z10) throws RemoteException {
            return C10028c.m62182c0().m62336h2(str, z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void setGalleryDefaultValue() throws RemoteException {
            C11019b.m66371t().m66445t0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void setModuleEnable(String str, boolean z10) throws RemoteException {
            C10028c.m62182c0().m62377p3(str, z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void setMrGuide(boolean z10) throws RemoteException {
            C11019b.m66371t().m66447u0(z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void setSpaceUsedNotifyTimer(boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void startRestoreMainActivity() throws RemoteException {
            C11019b.m66371t().m66373A0(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void unRegLoginCallback() throws RemoteException {
            HisyncProxyService.this.f12025d = null;
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void unRegUpgradeCallback() throws RemoteException {
            HisyncProxyService.this.f12026e = null;
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public boolean unregisterCallBack(IHisyncProxyCallBack iHisyncProxyCallBack) throws RemoteException {
            C11839m.m70688i("HisyncProxyService", "unregisterCallBack");
            if (HisyncProxyService.this.f12022a == null) {
                return false;
            }
            HisyncProxyService.this.f12022a = null;
            return true;
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void updateBackupForSetting() throws RemoteException {
            C11019b.m66371t().m66419g(HisyncProxyService.this.getApplicationContext());
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void urlsVerifyProcess(IHisyncProxyCallBack iHisyncProxyCallBack) throws RemoteException {
            C11839m.m70686d("HisyncProxyService", "urlsVerifyProcess");
            C11019b.m66371t().m66385G0(HisyncProxyService.this.getApplicationContext(), HisyncProxyService.this.f12024c);
            HisyncProxyService.this.f12022a.getGrsCallBack(8);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void writeLastlocSwitchStatusToFile(boolean z10) throws RemoteException {
            C11019b.m66371t().m66387H0(HisyncProxyService.this.getApplicationContext(), z10);
        }

        @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService
        public void writeUISwitchToFile() throws RemoteException {
            C11019b.m66371t().m66389I0();
        }
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.HisyncProxyService$b */
    public class C2766b implements CheckUpdateCallBack {
        public C2766b() {
        }

        /* renamed from: a */
        public final void m15823a(boolean z10, Bundle bundle) {
            try {
                C11839m.m70686d("HisyncProxyService", "onUpdateInfo needUpdate: " + z10);
                if (bundle == null) {
                    HisyncProxyService.this.f12026e.onUpdateInfo(z10, "", "", "", "");
                } else {
                    HisyncProxyService.this.f12026e.onUpdateInfo(z10, bundle.getString("name"), bundle.getString("downUrl"), bundle.getString("sha256"), bundle.getString("version"));
                }
            } catch (RemoteException e10) {
                C11839m.m70687e("HisyncProxyService", "onUpdateInfo Exception" + e10.toString());
            }
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketInstallInfo(Intent intent) {
            C11839m.m70688i("HisyncProxyService", "onMarketInstallInfo ");
            m15823a(false, null);
            UpdateSdkAPI.releaseCallBack();
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketStoreError(int i10) {
            C11839m.m70688i("HisyncProxyService", "onMarketStoreError ");
            m15823a(false, null);
            UpdateSdkAPI.releaseCallBack();
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateInfo(Intent intent) {
            Serializable serializableExtra;
            if (intent != null) {
                SafeIntent safeIntent = new SafeIntent(intent);
                Bundle bundle = new Bundle();
                int intExtra = safeIntent.getIntExtra("status", -99);
                try {
                    serializableExtra = safeIntent.getSerializableExtra(UpdateKey.INFO);
                } catch (Exception e10) {
                    C11839m.m70688i("HisyncProxyService", "onUpdateInfo error: " + e10.getMessage());
                    serializableExtra = null;
                }
                C11839m.m70688i("HisyncProxyService", "updateCheck status: " + intExtra);
                if (intExtra == 7 && serializableExtra != null && (serializableExtra instanceof ApkUpgradeInfo)) {
                    C11839m.m70688i("HisyncProxyService", "has new version apk");
                    ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) serializableExtra;
                    bundle.putString("name", apkUpgradeInfo.getName_());
                    bundle.putString("downUrl", apkUpgradeInfo.getDownurl_());
                    bundle.putString("sha256", apkUpgradeInfo.getSha256_());
                    bundle.putString("version", apkUpgradeInfo.getVersion_());
                    m15823a(true, bundle);
                } else {
                    m15823a(false, null);
                }
                UpdateSdkAPI.releaseCallBack();
            }
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateStoreError(int i10) {
            C11839m.m70688i("HisyncProxyService", "onUpdateStoreError ");
            m15823a(false, null);
            UpdateSdkAPI.releaseCallBack();
        }
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.HisyncProxyService$c */
    public final class HandlerC2767c extends Handler {
        public HandlerC2767c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (HisyncProxyService.this.m15822j(message)) {
                try {
                    C11839m.m70686d("HisyncProxyService", "getGrsCallBack" + message.what);
                    HisyncProxyService.this.f12022a.getGrsCallBack(message.what);
                } catch (RemoteException e10) {
                    C11839m.m70687e("HisyncProxyService", "CheckGrsMsg Exception" + e10.toString());
                }
            } else {
                try {
                    HisyncProxyService.this.f12022a.queryHandle(message);
                } catch (RemoteException e11) {
                    C11839m.m70687e("HisyncProxyService", "queryHandle Exception" + e11.toString());
                }
            }
            HisyncProxyService.this.stopSelf(message.arg1);
        }
    }

    /* renamed from: j */
    public final boolean m15822j(Message message) {
        int i10 = message.what;
        return i10 == 12 || i10 == 11 || i10 == 8 || i10 == 9 || i10 == 10;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12027f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11839m.m70688i("HisyncProxyService", "onCreate");
        HandlerThread handlerThread = new HandlerThread("HisyncProxyServiceHandlerThread");
        this.f12023b = handlerThread;
        handlerThread.start();
        this.f12024c = new HandlerC2767c(this.f12023b.getLooper());
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f12023b.quitSafely();
        this.f12024c = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        C11839m.m70688i("HisyncProxyService", "onStartCommand");
        return super.onStartCommand(intent, i10, i11);
    }
}
