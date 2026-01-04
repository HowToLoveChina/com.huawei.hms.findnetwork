package il;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.bean.OverdueBackupRecordsPolicy;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.constant.backup.Constant;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.hicloud.task.simple.C3016b2;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.android.hicloud.task.simple.C3097x1;
import com.huawei.android.hicloud.task.simple.InitCloudBackupDataTask;
import com.huawei.android.hicloud.task.simple.StorageSpaceUsingTrackTask;
import com.huawei.appgallery.agd.api.AgdConstant;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.bean.GraySwitch;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hicloud.router.data.CloudSpaceUsageItemColor;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.FamilySharePageConfig;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import je.C10780c;
import mk.C11476b;
import mk.C11477c;
import ni.C11707b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0241z;
import p232dp.InterfaceC9283b;
import p252e9.C9426c;
import p284fb.C9681b;
import p292fn.C9733f;
import p336he.C10153d;
import p342hl.C10281a;
import p362i9.C10457d;
import p362i9.C10458e;
import p364ib.C10465b;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p450le.C11273b;
import p458lo.C11322a;
import p478mj.C11474b;
import p514o9.C11839m;
import p514o9.C11842p;
import p518od.C11849a;
import p523oi.C11903a;
import p550pb.C12126b;
import p572qb.C12299b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p618rm.C12598v;
import p651t8.C12997e;
import p651t8.C12998f;
import p652t9.EnumC12999a;
import p674ub.C13148e;
import p703v8.C13381r;
import p709vj.C13452e;
import p711vl.C13466f;
import p711vl.C13467g;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p847zk.C14311d;
import p848zl.C14333b;
import pm.C12176c;
import tl.C13026e;
import tl.C13036o;
import to.C13049a;

/* renamed from: il.o */
/* loaded from: classes6.dex */
public class C10542o implements InterfaceC9283b {

    /* renamed from: b */
    public C11474b f50720b;

    /* renamed from: a */
    public final Object f50719a = new Object();

    /* renamed from: c */
    public C12526j f50721c = new C12526j();

    /* renamed from: J0 */
    public static long m64635J0(Bak bak, long j10) {
        C4644l endTime = bak.getEndTime();
        if (endTime == null || bak.isRefurbishment()) {
            return j10;
        }
        long jM28458c = endTime.m28458c();
        return jM28458c > j10 ? jM28458c : j10;
    }

    /* renamed from: V0 */
    public static /* synthetic */ boolean m64636V0(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        return true;
    }

    /* renamed from: W0 */
    public static /* synthetic */ boolean m64637W0(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (userDeviceInfo.isTempBackUp()) {
            return userDeviceInfo.isTempBackUp() && userDeviceInfo.getOccupySpaceType().intValue() == 1;
        }
        return true;
    }

    /* renamed from: X0 */
    public static /* synthetic */ boolean m64638X0(Bak bak) {
        return "V4".equals(bak.getBackupVersion());
    }

    /* renamed from: Y0 */
    public static /* synthetic */ boolean m64639Y0(Bak bak) {
        return bak.isRefurbishment() && bak.getBackupStatus().intValue() == 0;
    }

    /* renamed from: Z0 */
    public static /* synthetic */ boolean m64640Z0(Bak bak) {
        return !bak.isRefurbishment() && (bak.getBackupStatus().intValue() == 0 || bak.getBackupStatus().intValue() == 1);
    }

    /* renamed from: a1 */
    public static /* synthetic */ boolean m64641a1(Bak bak) {
        return (bak.isRefurbishment() || bak.isTempBackup() || bak.getBackupStatus().intValue() != 1) ? false : true;
    }

    /* renamed from: b1 */
    public static /* synthetic */ boolean m64642b1(Bak bak) {
        return (bak.isRefurbishment() || bak.isTempBackup() || bak.getBackupStatus().intValue() != 0) ? false : true;
    }

    /* renamed from: c1 */
    public static /* synthetic */ boolean m64643c1(Bak bak) {
        return bak.isRefurbishment() && bak.getBackupStatus().intValue() == 0;
    }

    /* renamed from: d1 */
    public static /* synthetic */ boolean m64644d1(Bak bak) {
        return bak.getEndTime() != null;
    }

    /* renamed from: e1 */
    public static /* synthetic */ void m64645e1(UserBackupInfo.UserDeviceInfo userDeviceInfo, Bak bak) {
        userDeviceInfo.setLastbackupTime(bak.getEndTime().m28458c());
        C11839m.m70688i("CloudBackupRouterImpl", "onlyRefurbish, end time is :" + bak.getEndTime().m28458c());
    }

    /* renamed from: r1 */
    public static void m64649r1(UserBackupInfo userBackupInfo, List<UserBackupInfo.UserDeviceInfo> list, Predicate<? super UserBackupInfo.UserDeviceInfo> predicate) {
        long jSum = list.stream().filter(predicate).filter(new Predicate() { // from class: il.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10542o.m64637W0((UserBackupInfo.UserDeviceInfo) obj);
            }
        }).mapToLong(new ToLongFunction() { // from class: il.e
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((UserBackupInfo.UserDeviceInfo) obj).getSize();
            }
        }).sum();
        userBackupInfo.setUserBackupInfos(list);
        userBackupInfo.setSize(jSum + userBackupInfo.getSize());
    }

    /* renamed from: v1 */
    public static void m64654v1(Bak bak, UserBackupInfo.UserDeviceInfo userDeviceInfo) throws IOException {
        C11707b c11707b = (C11707b) C11903a.m71435l().mo69832e(bak.getDevice()).m69886u(C11707b.class);
        for (String str : c11707b.keySet()) {
            Object obj = c11707b.get(str);
            if (obj != null && !userDeviceInfo.containsValue(obj)) {
                userDeviceInfo.setDeviceType(C0241z.m1685c(str));
                userDeviceInfo.setDeviceID(obj.toString());
                userDeviceInfo.setCurrent(obj.equals(C13452e.m80781L().m80950o()));
                return;
            }
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: A */
    public void mo58469A(Handler.Callback callback) {
        CloudBackupService.getInstance().unregister(callback);
    }

    /* renamed from: A0 */
    public final CloudRecoveryItem m64658A0(Bak bak, String str, String str2) throws C9721b {
        String backupDeviceId = bak.getBackupDeviceId();
        String deviceId = ICBUtil.parseDeviceId(bak);
        C4644l endTime = bak.getEndTime();
        C4644l startTime = bak.getStartTime();
        String id2 = bak.getId();
        String backupVersion = bak.getBackupVersion();
        CloudRecoveryItem cloudRecoveryItem = new CloudRecoveryItem();
        cloudRecoveryItem.setRefurbishment(bak.isRefurbishment());
        cloudRecoveryItem.setDeviceIdd(deviceId + "&" + backupDeviceId + "&" + backupVersion);
        cloudRecoveryItem.setRecordDeviceId(deviceId);
        cloudRecoveryItem.setBackupDeviceId(backupDeviceId);
        cloudRecoveryItem.setCurrent(deviceId.equals(C13452e.m80781L().m80950o()));
        cloudRecoveryItem.setDeviceName(str);
        cloudRecoveryItem.setTerminalType(str);
        cloudRecoveryItem.setDevDisplayName(str);
        cloudRecoveryItem.setTempBackup(bak.isTempBackup());
        cloudRecoveryItem.setSize(bak.getTotalSize());
        cloudRecoveryItem.setBackupCompleted(bak.getBackupStatus().intValue() == 0);
        String str3 = C11842p.m70762R0() ? "pad" : "phone";
        if (cloudRecoveryItem.isCurrent()) {
            str2 = str3;
        }
        cloudRecoveryItem.setDeviceCategory(str2);
        cloudRecoveryItem.setBackupId(id2);
        if (endTime != null) {
            cloudRecoveryItem.setBackupEndTime(endTime.m28458c());
        }
        if (startTime != null) {
            cloudRecoveryItem.setStartTime(startTime.m28458c());
        }
        cloudRecoveryItem.setVersion(backupVersion);
        cloudRecoveryItem.setBackupRecordLabel(m64663E0(backupVersion, bak.getBmDataType().intValue()));
        cloudRecoveryItem.setBmDataType(bak.getBmDataType().intValue());
        cloudRecoveryItem.setNewBmRecord(bak.getBmDataType().intValue() != 0);
        cloudRecoveryItem.setOccupySpaceType(bak.getOccupySpaceType() != null ? bak.getOccupySpaceType().intValue() : 0);
        cloudRecoveryItem.setExpiratoryInDays(bak.getExpiratoryInDays());
        return cloudRecoveryItem;
    }

    /* renamed from: A1 */
    public final void m64659A1(Map<String, Boolean> map) {
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            C10153d.m63237a().put(entry.getKey(), entry.getValue());
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: B */
    public boolean mo58470B() {
        BackupOptionItem backupOptionItemM78401y = new C13026e().m78401y(HNConstants.DataType.MEDIA);
        if (backupOptionItemM78401y != null) {
            return backupOptionItemM78401y.getBackupSwitch();
        }
        AbstractC10896a.m65886e("CloudBackupRouterImpl", "query album backUp switch fail.");
        return false;
    }

    /* renamed from: B0 */
    public final void m64660B0(Map<String, Boolean> map, String str, int i10) {
        Boolean bool = map.get(str);
        if (bool == null) {
            map.put(str, Boolean.valueOf(m64677T0(i10)));
        } else {
            map.put(str, Boolean.valueOf(bool.booleanValue() && m64677T0(i10)));
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: C */
    public boolean mo58471C() {
        return C10780c.m65630b();
    }

    /* renamed from: C0 */
    public final void m64661C0(CloudBackupUserInfo cloudBackupUserInfo, CloudRecoveryItem cloudRecoveryItem) {
        if (cloudRecoveryItem.isRefurbishment()) {
            C11839m.m70688i("CloudBackupRouterImpl", "refurbishment record");
            return;
        }
        if (cloudRecoveryItem.isTempBackup()) {
            C11839m.m70688i("CloudBackupRouterImpl", "tempBackup record");
            return;
        }
        boolean zIsCurrent = cloudRecoveryItem.isCurrent();
        long backupEndTime = cloudRecoveryItem.getBackupEndTime();
        CloudRecoveryItem latestBackupRecord = cloudBackupUserInfo.getLatestBackupRecord();
        if (latestBackupRecord == null || backupEndTime > latestBackupRecord.getBackupEndTime()) {
            cloudBackupUserInfo.setLatestBackupRecord(cloudRecoveryItem);
        }
        CloudRecoveryItem currentLatestBackupRecord = cloudBackupUserInfo.getCurrentLatestBackupRecord();
        if (zIsCurrent) {
            if (currentLatestBackupRecord == null) {
                cloudBackupUserInfo.setCurrentLatestBackupRecord(cloudRecoveryItem);
            } else if (backupEndTime > currentLatestBackupRecord.getBackupEndTime()) {
                cloudBackupUserInfo.setCurrentLatestBackupRecord(cloudRecoveryItem);
            }
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: D */
    public void mo58472D(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClass(context, HisyncSpaceDetailActivity.class);
            context.startActivity(intent);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("CloudBackupRouterImpl", "startActivity error:" + e10.getMessage());
        }
    }

    /* renamed from: D0 */
    public final String m64662D0(BackupOptionItem backupOptionItem) {
        String strM25632b = NewHiSyncUtil.m25632b(backupOptionItem.getAppId());
        if (TextUtils.isEmpty(strM25632b)) {
            String appName = backupOptionItem.getAppName();
            return TextUtils.isEmpty(appName) ? backupOptionItem.getAppId() : appName;
        }
        backupOptionItem.setAppName(strM25632b);
        return strM25632b;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: E */
    public void mo58473E() {
        C12515a.m75110o().m75175e(new C10458e(), true);
        C12515a.m75110o().m75175e(new C10457d(), true);
    }

    /* renamed from: E0 */
    public final int m64663E0(String str, int i10) {
        if ("V4".equals(str)) {
            return 3;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 4;
        }
        return 2;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: F */
    public void mo58474F() {
        CloudBackupService.getInstance().cloudbackupOpr(true);
    }

    /* renamed from: F0 */
    public String m64664F0(C13998b0 c13998b0, String str) throws C9721b {
        String str2 = "1";
        if (!C10028c.m62182c0().m62335h1()) {
            C11839m.m70688i("CloudBackupRouterImpl", "getBakSourceStrategy do not support about request");
            return "1";
        }
        About aboutM84137z = c13998b0.m84137z("bakSourceStrategy", str);
        if (aboutM84137z.getBakSourceStrategy() != null) {
            String strValueOf = "1";
            for (Map.Entry<String, Object> entry : aboutM84137z.getBakSourceStrategy().entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    strValueOf = String.valueOf(entry.getValue());
                    if (strValueOf.equals("1")) {
                        break;
                    }
                }
            }
            str2 = strValueOf;
        }
        new SettingOperator().replace(new Settings[]{new Settings("deviceDeleteStrategy", str2, "2")});
        return str2;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: G */
    public String mo58475G(Throwable th2) {
        return C12590s0.m75731C0(th2);
    }

    /* renamed from: G0 */
    public final String m64665G0(boolean z10, About about) {
        String strM68626h = C11476b.m68626h(C13452e.m80781L().m80950o());
        C11839m.m70688i("CloudBackupRouterImpl", "getBakSourceStrategy " + strM68626h);
        SettingOperator settingOperator = new SettingOperator();
        String str = "1";
        String str2 = "2";
        if (about.getBakSourceStrategy() != null) {
            String str3 = "1";
            String str4 = "2";
            for (Map.Entry<String, Object> entry : about.getBakSourceStrategy().entrySet()) {
                String key = entry.getKey();
                String strValueOf = String.valueOf(entry.getValue());
                if (!TextUtils.isEmpty(key) && key.contains(strM68626h)) {
                    if (!TextUtils.equals(strValueOf, settingOperator.queryBakSourceStrategy())) {
                        settingOperator.replace(new Settings[]{new Settings("bakSourceStrategy", strValueOf, "2")});
                    }
                    str3 = strValueOf;
                }
                if ("1".equals(strValueOf)) {
                    str4 = "1";
                }
            }
            str = str3;
            str2 = str4;
        }
        return z10 ? str : str2;
    }

    /* renamed from: H0 */
    public final void m64666H0(List<String> list, CloudBackupUserInfo cloudBackupUserInfo) throws C9721b {
        QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) C12540b1.m75483a(new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78761z(AgdConstant.INSTALL_TYPE_FULL_MANUAL, m64667I0(list) + " and framework in [0,1]"), QuotaUsedInfoRsp.class);
        if (quotaUsedInfoRsp == null) {
            return;
        }
        QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
        cloudBackupUserInfo.setUseSpace(cloudBackupUserInfo.getUseSpace() + quotaUsedInfoRsp.getUsed());
        if (quotaDetails.length > 0) {
            for (QuotaDetail quotaDetail : quotaDetails) {
                String detailDeviceID = quotaDetail.getDetailDeviceID();
                long assetsQuotadSpace = quotaDetail.getAssetsQuotadSpace() + quotaDetail.getRecordsQuotadSpace();
                CloudBackupDeviceInfo cloudBackupDeviceInfo = cloudBackupUserInfo.getDeviceInfoMap().get(detailDeviceID);
                if (cloudBackupDeviceInfo != null) {
                    cloudBackupDeviceInfo.setDeviceBackupSpace(cloudBackupDeviceInfo.getDeviceBackupSpace() + assetsQuotadSpace);
                }
            }
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: I */
    public void mo58477I() {
        C2783d.m16076C0();
        C2783d.m16101P();
        C2783d.m16072A0();
        C2783d.m16074B0();
    }

    /* renamed from: I0 */
    public final String m64667I0(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("collection=private and deviceId in ");
        if (list != null && !list.isEmpty()) {
            sb2.append(list.toString().replace(" ", ""));
        }
        return sb2.toString();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: J */
    public boolean mo58478J(String str) {
        if (str == null || str.isEmpty() || !CBAccess.inRestoreTask()) {
            return false;
        }
        return m64668K0(str).equals(CBAccess.getCurrent());
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: K */
    public void mo58479K() {
        C12515a.m75110o().m75172d(new C3097x1(C0213f.m1377a(), null));
    }

    /* renamed from: K0 */
    public final String m64668K0(String str) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                return HNConstants.DataType.CONTACT;
            case "calendar":
                return "calendar";
            case "wlan":
                return "setting";
            case "browser":
                return "bookmark";
            case "notepad":
                return "Memo";
            default:
                return str;
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: L */
    public long mo58480L(String str) {
        BackupOptionItem backupOptionItemM78401y = new C13026e().m78401y(str);
        if (backupOptionItemM78401y != null) {
            return backupOptionItemM78401y.getDataBytes();
        }
        return 0L;
    }

    /* renamed from: L0 */
    public final String m64669L0(BackupOptionItem backupOptionItem) {
        String appId = backupOptionItem.getAppId();
        if ("virtualApp".equals(backupOptionItem.getParent())) {
            return CloudBackupLanguageUtil.getVirtualName(appId);
        }
        if (!C14333b.m85483r().containsKey(appId) && !C14333b.f63653e.containsKey(appId)) {
            return m64662D0(backupOptionItem);
        }
        return C2783d.m16079E(C0213f.m1377a(), appId);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: M */
    public Intent mo58481M(Context context) {
        Intent intent = new Intent(context, (Class<?>) CloudSpaceUpgradeActivity.class);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        return intent;
    }

    /* renamed from: M0 */
    public final String m64670M0(String str) {
        if (C10028c.m62182c0().m62420y1()) {
            return "/Backup/Cloudbackup/" + C0227m.m1593f(str);
        }
        return "/CloudBackup/" + C0227m.m1593f(str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: N */
    public int mo58482N(Context context) {
        return C2783d.m16192z(context);
    }

    /* renamed from: N0 */
    public final UserBackupInfo m64671N0(List<String> list, UserBackupInfo userBackupInfo, List<UserBackupInfo.UserDeviceInfo> list2) throws C9721b {
        QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) C12540b1.m75483a(new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78761z(AgdConstant.INSTALL_TYPE_FULL_MANUAL, m64667I0(list) + " and framework in [0,1]"), QuotaUsedInfoRsp.class);
        if (quotaUsedInfoRsp == null) {
            return userBackupInfo;
        }
        if (quotaUsedInfoRsp.getRetCode() != 0) {
            userBackupInfo.setRetCode(quotaUsedInfoRsp.getRetCode());
            return userBackupInfo;
        }
        userBackupInfo.setSize(userBackupInfo.getSize() + quotaUsedInfoRsp.getUsed());
        QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
        HashMap map = new HashMap();
        for (QuotaDetail quotaDetail : quotaDetails) {
            C11839m.m70686d("CloudBackupRouterImpl", "quotaDetail :" + C12540b1.m75485c(quotaDetail));
            String detailDeviceID = quotaDetail.getDetailDeviceID();
            long assetsQuotadSpace = quotaDetail.getAssetsQuotadSpace() + quotaDetail.getRecordsQuotadSpace();
            for (UserBackupInfo.UserDeviceInfo userDeviceInfo : list2) {
                if (detailDeviceID.equals(userDeviceInfo.getBackupDeviceId())) {
                    if (userDeviceInfo.isTempBackUp()) {
                        map.put(detailDeviceID, userDeviceInfo);
                    } else {
                        userDeviceInfo.setSize(userDeviceInfo.getSize() + assetsQuotadSpace);
                    }
                }
            }
        }
        for (UserBackupInfo.UserDeviceInfo userDeviceInfo2 : list2) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo3 = (UserBackupInfo.UserDeviceInfo) map.get(userDeviceInfo2.getBackupDeviceId());
            if (userDeviceInfo3 != null && !userDeviceInfo2.isTempBackUp() && userDeviceInfo3.getOccupySpaceType() != null && userDeviceInfo3.getOccupySpaceType().intValue() == 1) {
                userDeviceInfo2.setSize(userDeviceInfo2.getSize() - userDeviceInfo3.getSize());
            }
        }
        userBackupInfo.setUserBackupInfos(list2);
        return userBackupInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: O */
    public Intent mo58483O(Context context, String str, SafeIntent safeIntent, String str2) {
        String strM67646a = C11273b.m67646a(str, str2);
        Intent intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("url", strM67646a);
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        String stringExtra4 = safeIntent.getStringExtra("sceneId");
        String stringExtra5 = safeIntent.getStringExtra("showToast");
        if (!TextUtils.isEmpty(stringExtra)) {
            intent.putExtra("srcChannel", stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            intent.putExtra("salChannel", stringExtra2);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            intent.putExtra("activityCode", stringExtra3);
        }
        if (!TextUtils.isEmpty(stringExtra4)) {
            intent.putExtra("sceneId", stringExtra4);
        }
        if (!TextUtils.isEmpty(stringExtra5)) {
            intent.putExtra("showToast", stringExtra5);
        }
        intent.putExtra("isEnableJs", true);
        intent.putExtra("action_bar_color_hm_os_bg", true);
        intent.putExtra("is_support_dark_mode", true);
        intent.setFlags(335544320);
        return intent;
    }

    /* renamed from: O0 */
    public UserBackupInfo m64672O0() throws C9721b {
        C11322a c11322a = new C11322a();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        UserBackupInfo userBackupInfo = new UserBackupInfo();
        for (CBSBackupRecord cBSBackupRecord : c11322a.m67997D(true, false)) {
            String deviceId = cBSBackupRecord.getDevice().getDeviceId();
            if (deviceId != null && !deviceId.isEmpty()) {
                String strM64670M0 = m64670M0(deviceId);
                CBSpaceDetail cBSpaceDetail = (CBSpaceDetail) map.get(strM64670M0);
                if (cBSpaceDetail == null) {
                    cBSpaceDetail = new CBSpaceDetail();
                    if (deviceId.equals(C13452e.m80781L().m80950o())) {
                        cBSpaceDetail.setCurrent(true);
                    }
                    cBSpaceDetail.setDeviceID(deviceId);
                    String aliasName = cBSBackupRecord.getDevice().getAliasName();
                    String devDisplayName = cBSBackupRecord.getDevice().getDevDisplayName();
                    if (!TextUtils.isEmpty(devDisplayName)) {
                        aliasName = devDisplayName;
                    } else if (TextUtils.isEmpty(aliasName)) {
                        aliasName = cBSBackupRecord.getDevice().getTerminalType();
                    }
                    cBSpaceDetail.setDeviceName(aliasName);
                    arrayList.add(strM64670M0);
                    String deviceCategory = cBSBackupRecord.getDevice().getDeviceCategory();
                    if (!TextUtils.isEmpty(deviceCategory)) {
                        cBSpaceDetail.setDeviceCategory(deviceCategory);
                    }
                }
                long endTime = cBSBackupRecord.getEndTime();
                if (endTime > cBSpaceDetail.getLastbackupTime()) {
                    cBSpaceDetail.setLastbackupTime(endTime);
                }
                map.put(strM64670M0, cBSpaceDetail);
            }
        }
        if (arrayList.isEmpty()) {
            C11839m.m70686d("CloudBackupRouterImpl", "dirPaths is empty");
            return userBackupInfo;
        }
        Result resultM78709H = new C13049a(EnumC12999a.CLOUD_MORE, null).m78709H((String[]) arrayList.toArray(new String[arrayList.size()]), new String[]{"name", "space"});
        if (resultM78709H.getSuccessList() == null) {
            C11839m.m70686d("CloudBackupRouterImpl", "nsresponse is null");
            return userBackupInfo;
        }
        List<Map<String, Object>> successList = resultM78709H.getSuccessList();
        ArrayList arrayList2 = new ArrayList();
        long j10 = 0;
        for (Map<String, Object> map2 : successList) {
            CBSpaceDetail cBSpaceDetail2 = (CBSpaceDetail) map.get((String) map2.get("name"));
            if (cBSpaceDetail2 != null) {
                long jM1688f = C0241z.m1688f((String) map2.get("space"));
                j10 += jM1688f;
                cBSpaceDetail2.setSize(jM1688f);
                arrayList2.add(cBSpaceDetail2);
            }
        }
        userBackupInfo.setUserBackupInfos(m64673P0(arrayList2));
        userBackupInfo.setSize(j10);
        return userBackupInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: P */
    public boolean mo58484P() {
        return CBAccess.inRestoreTask();
    }

    /* renamed from: P0 */
    public final List<UserBackupInfo.UserDeviceInfo> m64673P0(List<CBSpaceDetail> list) {
        ArrayList arrayList = new ArrayList();
        for (CBSpaceDetail cBSpaceDetail : list) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo = new UserBackupInfo.UserDeviceInfo();
            userDeviceInfo.setDevDisplayName(cBSpaceDetail.getDevDisplayName());
            userDeviceInfo.setSize(cBSpaceDetail.getSize());
            userDeviceInfo.setDeviceType(cBSpaceDetail.getDeviceType());
            userDeviceInfo.setLastbackupTime(cBSpaceDetail.getLastbackupTime());
            userDeviceInfo.setDeviceName(cBSpaceDetail.getDeviceName());
            userDeviceInfo.setDevDisplayName(cBSpaceDetail.getDevDisplayName());
            userDeviceInfo.setTerminalType(cBSpaceDetail.getTerminalType());
            userDeviceInfo.setDeviceID(cBSpaceDetail.getDeviceID());
            userDeviceInfo.setCurrent(cBSpaceDetail.isCurrent());
            userDeviceInfo.setBackupDeviceId(cBSpaceDetail.getBackupDeviceId());
            arrayList.add(userDeviceInfo);
        }
        return arrayList;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: Q */
    public void mo58485Q(Context context, ArrayList<String> arrayList) {
        C12515a.m75110o().m75172d(new C3017c(arrayList));
    }

    /* renamed from: Q0 */
    public final List<UserBackupInfo.UserDeviceInfo> m64674Q0(List<CBSBackupRecord> list, List<String> list2) {
        list2.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        HashMap map = new HashMap();
        for (CBSBackupRecord cBSBackupRecord : list) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo = new UserBackupInfo.UserDeviceInfo();
            String deviceId = cBSBackupRecord.getDevice().getDeviceId();
            String backupDeviceId = cBSBackupRecord.getBackupDeviceId();
            if (!list2.contains(backupDeviceId)) {
                list2.add(backupDeviceId);
            }
            if (!TextUtils.isEmpty(deviceId) && !TextUtils.isEmpty(backupDeviceId)) {
                userDeviceInfo.setDeviceID(deviceId);
                userDeviceInfo.setBackupDeviceId(backupDeviceId);
                userDeviceInfo.setCurrent(deviceId.equals(C13452e.m80781L().m80950o()));
                String aliasName = cBSBackupRecord.getDevice().getAliasName();
                String devDisplayName = cBSBackupRecord.getDevice().getDevDisplayName();
                if (!TextUtils.isEmpty(devDisplayName)) {
                    aliasName = devDisplayName;
                } else if (TextUtils.isEmpty(aliasName)) {
                    aliasName = cBSBackupRecord.getDevice().getTerminalType();
                }
                userDeviceInfo.setDeviceName(aliasName);
                userDeviceInfo.setDeviceCategory(cBSBackupRecord.getDevice().getDeviceCategory());
                userDeviceInfo.setOccupySpaceType(cBSBackupRecord.getOccupySpaceType());
                boolean zM64678U0 = m64678U0(cBSBackupRecord.getBakCategory());
                if (cBSBackupRecord.getStatus() == 0) {
                    userDeviceInfo.setLastbackupTime(cBSBackupRecord.getEndTime());
                    if (userDeviceInfo.isCurrent()) {
                        arrayList2.add(cBSBackupRecord);
                    }
                    if (!cBSBackupRecord.isRefurbishment() && !zM64678U0) {
                        m64660B0(map, backupDeviceId, cBSBackupRecord.getBmDataType());
                    }
                    userDeviceInfo.setTempBackUp(zM64678U0);
                    if (zM64678U0) {
                        userDeviceInfo.setBakId(cBSBackupRecord.getBackupId());
                        userDeviceInfo.setSize(((Long) Optional.ofNullable(cBSBackupRecord.getTotalSize()).orElse(0L)).longValue());
                        C11839m.m70688i("CloudBackupRouterImpl", "init backupRecord canBeReserveForever:" + cBSBackupRecord.isCanBeReserveForever());
                    }
                    m64695x1(userDeviceInfo, cBSBackupRecord);
                } else if (!zM64678U0) {
                    userDeviceInfo.setLastbackupTime(0L);
                }
                userDeviceInfo.setDeviceType(cBSBackupRecord.getDevice().getDeviceType());
                userDeviceInfo.setDevDisplayName(cBSBackupRecord.getDevice().getDevDisplayName());
                if (cBSBackupRecord.isRefurbishment() && cBSBackupRecord.getStatus() == 0) {
                    userDeviceInfo.setHasRefurbish(true);
                    userDeviceInfo.setOnlyRefurbish(true);
                }
                userDeviceInfo.setOnlyHarmonyNext("V4".equals(cBSBackupRecord.getVersion()));
                userDeviceInfo.setTerminalType(cBSBackupRecord.getDevice().getTerminalType());
                userDeviceInfo.setGradeCode(cBSBackupRecord.getGradeCode());
                arrayList.add(userDeviceInfo);
            }
        }
        m64659A1(map);
        map.clear();
        return arrayList;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: R */
    public void mo58486R(Message message) {
        CBCallBack.getInstance().sendMessage(message);
    }

    /* renamed from: R0 */
    public final List<UserBackupInfo.UserDeviceInfo> m64675R0(List<Device> list, List<String> list2) {
        String str;
        ArrayList arrayList;
        Iterator<Device> it;
        ArrayList arrayList2;
        Iterator<Bak> it2;
        String str2;
        String str3;
        String str4;
        List<String> list3 = list2;
        String str5 = "CloudBackupRouterImpl";
        list2.clear();
        ArrayList arrayList3 = new ArrayList();
        if (list != null) {
            try {
            } catch (IOException e10) {
                e = e10;
                str = str5;
            }
            if (!list.isEmpty()) {
                Iterator<Device> it3 = list.iterator();
                while (it3.hasNext()) {
                    Device next = it3.next();
                    List<Bak> baks = next.getBaks();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    if (baks == null || baks.isEmpty()) {
                        str = str5;
                        arrayList = arrayList3;
                        it = it3;
                    } else {
                        UserBackupInfo.UserDeviceInfo userDeviceInfo = new UserBackupInfo.UserDeviceInfo();
                        String deviceDisplayName = next.getDeviceDisplayName();
                        userDeviceInfo.setDevDisplayName(deviceDisplayName);
                        userDeviceInfo.setDeviceName(deviceDisplayName);
                        Long interimSize = next.getInterimSize();
                        Long classicSize = next.getClassicSize();
                        C11839m.m70686d(str5, "device name: " + next.getDeviceDisplayName() + " ,classicSize: " + classicSize + " ,interimSize: " + interimSize);
                        String deviceCategory = next.getDeviceCategory();
                        userDeviceInfo.setDeviceCategory(deviceCategory);
                        String id2 = next.getId();
                        userDeviceInfo.setBackupDeviceId(id2);
                        if (!list3.contains(id2)) {
                            list3.add(id2);
                        }
                        HashMap map = new HashMap();
                        ArrayList<ExtraDeviceInfo> arrayList6 = new ArrayList<>();
                        it = it3;
                        ArrayList<ExtraDeviceInfo> arrayList7 = new ArrayList<>();
                        Iterator<Bak> it4 = baks.iterator();
                        str = str5;
                        UserBackupInfo.UserDeviceInfo userDeviceInfo2 = null;
                        UserBackupInfo.UserDeviceInfo userDeviceInfo3 = null;
                        while (true) {
                            try {
                                arrayList2 = arrayList3;
                                if (!it4.hasNext()) {
                                    break;
                                }
                                try {
                                    Bak next2 = it4.next();
                                    C4644l endTime = next2.getEndTime();
                                    long jM28458c = (endTime == null || next2.isRefurbishment()) ? 0L : endTime.m28458c();
                                    ArrayList arrayList8 = arrayList5;
                                    UserBackupInfo.UserDeviceInfo userDeviceInfo4 = userDeviceInfo;
                                    long j10 = jM28458c;
                                    if (next2.isTempBackup() && next2.getBackupStatus().intValue() == 0) {
                                        if (userDeviceInfo2 == null) {
                                            userDeviceInfo2 = new UserBackupInfo.UserDeviceInfo();
                                            userDeviceInfo2.setDevDisplayName(deviceDisplayName);
                                            userDeviceInfo2.setDeviceName(deviceDisplayName);
                                            userDeviceInfo2.setDeviceCategory(deviceCategory);
                                            userDeviceInfo2.setBackupDeviceId(id2);
                                        }
                                        it2 = it4;
                                        userDeviceInfo2.setOccupySpaceType(next2.getOccupySpaceType());
                                        if (interimSize != null) {
                                            str2 = deviceCategory;
                                            str3 = id2;
                                            userDeviceInfo2.setSize(interimSize.longValue());
                                            userDeviceInfo2.setSizeQueryByCBS(true);
                                        } else {
                                            str2 = deviceCategory;
                                            str3 = id2;
                                            userDeviceInfo2.setSize(next2.getTotalSize());
                                        }
                                        m64654v1(next2, userDeviceInfo2);
                                        m64694w1(next2, arrayList6);
                                        userDeviceInfo2.setTempBackUp(true);
                                        userDeviceInfo2.setBakId(next2.getId());
                                        userDeviceInfo2.setLastbackupTime(Math.max(userDeviceInfo2.getLastbackupTime(), j10));
                                        userDeviceInfo2.setTerminalType(next.getTerminalType());
                                        arrayList4.add(next2);
                                        arrayList5 = arrayList8;
                                    } else {
                                        it2 = it4;
                                        str2 = deviceCategory;
                                        str3 = id2;
                                        if (userDeviceInfo3 == null) {
                                            userDeviceInfo3 = (UserBackupInfo.UserDeviceInfo) userDeviceInfo4.clone();
                                        }
                                        m64654v1(next2, userDeviceInfo3);
                                        m64694w1(next2, arrayList7);
                                        userDeviceInfo3.setTempBackUp(false);
                                        if (!next2.isRefurbishment()) {
                                            userDeviceInfo3.setLastbackupTime(Math.max(userDeviceInfo3.getLastbackupTime(), j10));
                                        }
                                        arrayList5 = arrayList8;
                                        arrayList5.add(next2);
                                    }
                                    if (next2.getBackupStatus().intValue() != 0 || next2.isRefurbishment() || next2.isTempBackup()) {
                                        str4 = str3;
                                    } else {
                                        str4 = str3;
                                        m64660B0(map, str4, next2.getBmDataType().intValue());
                                    }
                                    deviceCategory = str2;
                                    id2 = str4;
                                    arrayList3 = arrayList2;
                                    it4 = it2;
                                    userDeviceInfo = userDeviceInfo4;
                                } catch (IOException e11) {
                                    e = e11;
                                    arrayList = arrayList2;
                                }
                            } catch (IOException e12) {
                                e = e12;
                                arrayList = arrayList3;
                                C11839m.m70688i(str, "getDeviceList error: " + e.getMessage());
                                return arrayList;
                            }
                            C11839m.m70688i(str, "getDeviceList error: " + e.getMessage());
                            return arrayList;
                        }
                        String str6 = id2;
                        if (map.get(str6) != null) {
                            C10153d.m63237a().put(str6, map.get(str6));
                        }
                        map.clear();
                        if (userDeviceInfo2 != null) {
                            userDeviceInfo2.setExtraDeviceInfos(arrayList6);
                            m64696y1(arrayList4, userDeviceInfo2);
                            arrayList = arrayList2;
                            try {
                                arrayList.add(userDeviceInfo2);
                            } catch (IOException e13) {
                                e = e13;
                            }
                        } else {
                            arrayList = arrayList2;
                        }
                        if (userDeviceInfo3 != null) {
                            userDeviceInfo3.setExtraDeviceInfos(arrayList7);
                            if (classicSize != null) {
                                userDeviceInfo3.setSize(classicSize.longValue());
                                userDeviceInfo3.setSizeQueryByCBS(true);
                            }
                            arrayList.add(userDeviceInfo3);
                            m64698z1(arrayList5, userDeviceInfo3);
                            m64696y1(arrayList5, userDeviceInfo3);
                            userDeviceInfo3.setTerminalType(next.getTerminalType());
                        }
                    }
                    it3 = it;
                    arrayList3 = arrayList;
                    str5 = str;
                    list3 = list2;
                }
                return arrayList3;
            }
        }
        return arrayList3;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: S */
    public String mo58487S(String str) {
        return SplitAppUtil.getSplitNotifyShowStatus(str);
    }

    /* renamed from: S0 */
    public boolean m64676S0(boolean z10) {
        try {
            String strM66627b = C11058a.m66627b(z10 ? "02101" : "02102");
            CloudBackupUserInfo cloudBackupUserInfo = new CloudBackupUserInfo();
            m64683j1(cloudBackupUserInfo, z10, false, false, true, false, strM66627b);
            CloudRecoveryItem currentLatestBackupRecord = cloudBackupUserInfo.getCurrentLatestBackupRecord();
            InitCloudBackupDataTask.m18100e(currentLatestBackupRecord == null ? 0L : currentLatestBackupRecord.getBackupEndTime());
            return cloudBackupUserInfo.getDeviceInfoMap().size() > 0;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupRouterImpl", "isHasSuccessBackupDevice error: " + e10.getMessage());
            return false;
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: T */
    public void mo58488T(Handler handler) {
        C12515a.m75110o().m75172d(new C3016b2(handler, true));
    }

    /* renamed from: T0 */
    public final boolean m64677T0(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: U */
    public void mo58489U(Context context) {
        C14311d.m85230g().m85240m(context);
    }

    /* renamed from: U0 */
    public final boolean m64678U0(Integer num) {
        return TextUtils.equals(String.valueOf(num), "3");
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: V */
    public void mo58490V(Context context, int i10, int i11) {
        Intent intent = new Intent(context, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", i10);
        bundle.putInt("restore_status", i11);
        bundle.putBoolean("isNewBmRecord", RestoreUtil.isNewBmRecord());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: W */
    public void mo58491W(Context context) {
        C11474b c11474b = this.f50720b;
        if (c11474b != null) {
            c11474b.m68617j(context);
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: X */
    public boolean mo58492X(Context context, long j10) throws C9721b {
        return new UserSpaceUtil(context).checkUserSpace(j10);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: Y */
    public boolean mo58493Y() {
        return CBAccess.hasManualBackupOrRestore();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: Z */
    public String mo58494Z(String str) {
        HashMap<String, Integer> mapM16244d = Constant.m16244d();
        if (mapM16244d.containsKey(str)) {
            return C0213f.m1377a().getString(mapM16244d.get(str).intValue());
        }
        C11839m.m70687e("CloudBackupRouterImpl", "moduleName is null, key=" + str);
        return null;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: a */
    public void mo58495a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("taskStartChannel", str);
        bundle.putBoolean("isOnlyRefresh", true);
        C12515a.m75110o().m75175e(new C3097x1(C0213f.m1377a(), bundle), false);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: a0 */
    public void mo58496a0() {
        new BackupNotificationManager(C0213f.m1377a()).cancelHonorUpGuideNotification();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: b */
    public void mo58497b(Context context) {
        StorageSpaceUsingTrackTask.m18114y(context);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: b0 */
    public void mo58498b0(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CloudBackupRouterImpl", "gradeRefreshCheckBackupFrequency, gradeCode is empty");
            return;
        }
        synchronized (this.f50719a) {
            try {
                C13466f c13466fM81073d = C13466f.m81073d();
                String strM81079g = c13466fM81073d.m81079g("gradeCode", "");
                int iM81091f = C13467g.m81086c().m81091f();
                C11839m.m70688i("CloudBackupRouterImpl", "gradeRefreshCheckBackupFrequency, currentGradeCode: " + str + ", gradeInSp: " + strM81079g + ", frequencyInSp: " + iM81091f);
                if (CloudBackupUtil.getGradeMinFrequency(str) > iM81091f) {
                    C13467g.m81086c().m81098m(CloudBackupUtil.getGradeMinFrequency(str));
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 33016;
                    CBCallBack.getInstance().sendMessage(messageObtain);
                    if (z10) {
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.what = 33050;
                        CBCallBack.getInstance().sendMessage(messageObtain2);
                    }
                }
                c13466fM81073d.m81084l("gradeCode", str);
                if (!TextUtils.equals(strM81079g, str)) {
                    C12299b.m73932n("CACHED_GRADE_CODE", str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: c */
    public String mo58499c() throws JSONException {
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        if (AbstractC14026a.m84159a(listM78397u)) {
            C11839m.m70688i("CloudBackupRouterImpl", "get bak app list empty.");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (BackupOptionItem backupOptionItem : listM78397u) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appId", backupOptionItem.getAppId());
                jSONObject2.put("status", backupOptionItem.getBackupSwitch() ? 1 : 0);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("apps", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e10) {
            C11839m.m70687e("CloudBackupRouterImpl", "get bak app list exception:" + e10.getMessage());
            return null;
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: c0 */
    public SpannableString mo58500c0(SpannableString spannableString, Context context) {
        return new RenewAgreementTextview(context).m25803t(spannableString, context);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: d */
    public Long mo58501d() {
        return Long.valueOf(new SettingOperator().queryinitopentime());
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: d0 */
    public void mo58502d0(List<UserBackupInfo.UserDeviceInfo> list) {
        List<UserBackupInfo.UserDeviceInfo> listM63241e = C10153d.m63241e(list);
        C13036o c13036o = new C13036o();
        c13036o.clear();
        c13036o.m78573m(listM63241e);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33038;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: e */
    public void mo58503e(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        C13036o c13036o = new C13036o();
        userDeviceInfo.setDeviceName(C11477c.m68636f(userDeviceInfo.getDeviceName()));
        userDeviceInfo.setDevDisplayName(C11477c.m68636f(userDeviceInfo.getDevDisplayName()));
        userDeviceInfo.setDeviceID(C11477c.m68636f(userDeviceInfo.getDeviceID()));
        c13036o.m78574n(userDeviceInfo);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33038;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: e0 */
    public void mo58504e0() {
        C13381r.m80356a().m80360e();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: f */
    public void mo58505f(Context context, String str) {
        C11474b c11474b = new C11474b(str);
        this.f50720b = c11474b;
        c11474b.m68612e(context);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: f0 */
    public UserBackupInfo mo58506f0(boolean z10, int i10) throws C9721b {
        return mo58520m0(z10, false, true, false, i10);
    }

    /* renamed from: f1 */
    public CloudBackupUserInfo m64679f1(boolean z10, boolean z11) throws C9721b {
        String strM66627b = C11058a.m66627b(z10 ? "02101" : "02102");
        CloudBackupUserInfo cloudBackupUserInfo = new CloudBackupUserInfo();
        m64682i1(cloudBackupUserInfo, z10, z11, true, false, strM66627b);
        return cloudBackupUserInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: g */
    public void mo58507g(String str) {
        C10281a.m63463d(str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: g0 */
    public String mo58508g0() {
        return UserSpaceUtil.getGradeCodeUseCache("CloudBackupRouter");
    }

    /* renamed from: g1 */
    public CloudBackupUserInfo m64680g1(boolean z10, boolean z11, boolean z12) throws C9721b {
        String strM66627b = C11058a.m66627b(z10 ? "02101" : "02102");
        CloudBackupUserInfo cloudBackupUserInfo = new CloudBackupUserInfo();
        m64683j1(cloudBackupUserInfo, z10, z11, true, false, z12, strM66627b);
        return cloudBackupUserInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: h */
    public boolean mo58509h() {
        return C10780c.m65629a();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: h0 */
    public int mo58510h0() {
        return C9426c.m59108d().m59112e();
    }

    /* renamed from: h1 */
    public final void m64681h1(UserBackupInfo userBackupInfo, List<UserBackupInfo.UserDeviceInfo> list, List<String> list2, boolean z10) throws C9721b {
        if (z10) {
            m64649r1(userBackupInfo, list, new Predicate() { // from class: il.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10542o.m64636V0((UserBackupInfo.UserDeviceInfo) obj);
                }
            });
            return;
        }
        do {
            if (list2.size() > 25) {
                try {
                    m64671N0(list2.subList(0, 25), userBackupInfo, list);
                    if (list2.size() > 25) {
                        list2.subList(0, 25).clear();
                    }
                } catch (IndexOutOfBoundsException e10) {
                    C11839m.m70688i("CloudBackupRouterImpl", "getDeviceList error " + e10.toString());
                    return;
                }
            } else {
                m64671N0(list2, userBackupInfo, list);
                list2.clear();
            }
        } while (list2.size() != 0);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: i */
    public void mo58511i(Context context) {
        new BackupNotificationManager(context).sendPowerNotify();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: i0 */
    public void mo58512i0(Handler.Callback callback) {
        CBCallBack.getInstance().registerCallback(callback);
    }

    /* renamed from: i1 */
    public final void m64682i1(CloudBackupUserInfo cloudBackupUserInfo, boolean z10, boolean z11, boolean z12, boolean z13, String str) throws C9721b {
        m64683j1(cloudBackupUserInfo, z10, z11, z12, false, z13, str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: j */
    public boolean mo58513j() {
        return C9681b.m60470l().m60483c();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: j0 */
    public void mo58514j0(String str, String str2) {
        new BackupNotificationManager(C0213f.m1377a()).sendHonorUpGuideNotification(str, str2);
    }

    /* renamed from: j1 */
    public void m64683j1(CloudBackupUserInfo cloudBackupUserInfo, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String str) throws C9721b {
        if ("2".equals(m64692t1(z10, z11, str))) {
            m64689p1(cloudBackupUserInfo, z13, z14, str);
        } else {
            m64687n1(cloudBackupUserInfo, z12, z13, z14, str);
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: k */
    public void mo58515k(Context context, String str) throws JSONException {
        String string;
        GraySwitch graySwitchM60764w = C9733f.m60705z().m60764w("newBusinessModelGalleryGuidePage");
        if (graySwitchM60764w == null || graySwitchM60764w.getStatus() == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("nav_source", 19);
            C12126b.m72707c("2", bundle);
            return;
        }
        try {
            string = new JSONObject(graySwitchM60764w.getParameters()).getString("url");
        } catch (JSONException e10) {
            C11839m.m70689w("CloudBackupRouterImpl", "FeatureSwitch parse failed: " + e10.getMessage());
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.putExtra("srcChannel", "0");
        safeIntent.putExtra("salChannel", "0");
        if (str != null) {
            safeIntent.putExtra("sceneId", str);
        }
        C11273b.m67657l(context, string, safeIntent, "");
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: k0 */
    public void mo58516k0(int i10) {
        CloudBackupService.getInstance().getBackupLinkAddress(i10);
    }

    /* renamed from: k1 */
    public CloudBackupUserInfo m64684k1(boolean z10) throws C9721b {
        String strM66627b = C11058a.m66627b("02101");
        String strQueryUploadTargetStrategy = new SettingOperator().queryUploadTargetStrategy();
        CloudBackupUserInfo cloudBackupUserInfo = new CloudBackupUserInfo();
        if (C10028c.m62182c0().m62335h1()) {
            About aboutM84137z = new C13998b0().m84137z("1".equalsIgnoreCase(strQueryUploadTargetStrategy) ? "uploadTargetStrategy,cloudOperationType,bakSourceStrategy" : "cloudOperationType,bakSourceStrategy", strM66627b);
            String strM64665G0 = m64665G0(true, aboutM84137z);
            String strM73270m = C12176c.m73270m(aboutM84137z);
            cloudBackupUserInfo.setBakSourceStrategy(strM64665G0);
            cloudBackupUserInfo.setUploadTargetStrategy(strM73270m);
            if ("2".equals(strM64665G0)) {
                m64688o1(cloudBackupUserInfo, false, strM66627b);
            } else {
                m64686m1(cloudBackupUserInfo, z10, false, strM66627b);
            }
        } else {
            C11839m.m70688i("CloudBackupRouterImpl", "queryBackupUserInfo do not support about");
            cloudBackupUserInfo.setBakSourceStrategy("1");
            cloudBackupUserInfo.setUploadTargetStrategy(strQueryUploadTargetStrategy);
            m64686m1(cloudBackupUserInfo, z10, false, strM66627b);
        }
        return cloudBackupUserInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: l */
    public Pair<Integer, Integer> mo58517l() {
        OverdueBackupRecordsPolicy overdueBackupRecordsPolicyM75420t0 = new C12526j().m75420t0();
        return new Pair<>(Integer.valueOf(overdueBackupRecordsPolicyM75420t0.getDeskPopupInterval()), Integer.valueOf(overdueBackupRecordsPolicyM75420t0.getDeskPopupTimes()));
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: l0 */
    public void mo58518l0(String str) {
        new C11849a(str).m63381g();
    }

    /* renamed from: l1 */
    public CloudBackupUserInfo m64685l1(boolean z10, boolean z11, boolean z12) throws C9721b {
        String strM66627b = C11058a.m66627b(z10 ? "02101" : "02102");
        CloudBackupUserInfo cloudBackupUserInfo = new CloudBackupUserInfo();
        m64682i1(cloudBackupUserInfo, z10, z11, z12, false, strM66627b);
        return cloudBackupUserInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: m */
    public void mo58519m(RecommendCardReport recommendCardReport, String str) {
        C2783d.m16094L0(recommendCardReport, str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: m0 */
    public UserBackupInfo mo58520m0(boolean z10, boolean z11, boolean z12, boolean z13, int i10) throws C9721b {
        List<UserBackupInfo.UserDeviceInfo> listM64675R0;
        UserBackupInfo userBackupInfoM64690q1;
        C13998b0 c13998b0 = new C13998b0();
        String strM66627b = C11058a.m66627b("02016");
        if (!C10028c.m62182c0().m62335h1()) {
            C11839m.m70688i("CloudBackupRouterImpl", "getDeviceList do not support about request");
            return m64672O0();
        }
        String strM64692t1 = m64692t1(false, z13, strM66627b);
        C11839m.m70688i("CloudBackupRouterImpl", "bakSourceStrategy:" + strM64692t1);
        UserBackupInfo userBackupInfo = new UserBackupInfo();
        List<String> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        if ("1".equals(strM64692t1)) {
            listM64675R0 = m64674Q0(new C11322a().m67997D(true, true), listSynchronizedList);
        } else if ("2".equals(strM64692t1)) {
            List<Device> listM84132c0 = c13998b0.m84132c0("nextCursor,devices", strM66627b, z12, true, true, false, null, false, z10);
            if (C1443a.f6214b.booleanValue()) {
                for (int i11 = 0; i11 < listM84132c0.size(); i11++) {
                    C11839m.m70686d("CloudBackupRouterImpl", "deviceList devices:i = " + i11 + C12540b1.m75485c(listM84132c0.get(i11)));
                }
            }
            listM64675R0 = m64675R0(listM84132c0, listSynchronizedList);
        } else {
            C11839m.m70689w("CloudBackupRouterImpl", "bakSourceStrategy invalid");
            listM64675R0 = null;
        }
        if (listM64675R0 == null || listM64675R0.size() == 0) {
            return new UserBackupInfo();
        }
        if (C1443a.f6214b.booleanValue()) {
            for (int i12 = 0; i12 < listM64675R0.size(); i12++) {
                C11839m.m70686d("CloudBackupRouterImpl", "getDeviceList deviceInfoList:i:" + i12 + C12540b1.m75485c(listM64675R0.get(i12)));
            }
        }
        if (!z10) {
            userBackupInfo.setUserBackupInfos(listM64675R0);
            return userBackupInfo;
        }
        boolean zAnyMatch = listM64675R0.stream().anyMatch(new Predicate() { // from class: il.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((UserBackupInfo.UserDeviceInfo) obj).isSizeQueryByCBS();
            }
        });
        if (z11 && (userBackupInfoM64690q1 = m64690q1(userBackupInfo, listM64675R0, zAnyMatch)) != null) {
            return userBackupInfoM64690q1;
        }
        m64681h1(userBackupInfo, listM64675R0, listSynchronizedList, zAnyMatch);
        return userBackupInfo;
    }

    /* renamed from: m1 */
    public void m64686m1(CloudBackupUserInfo cloudBackupUserInfo, boolean z10, boolean z11, String str) throws C9721b {
        m64687n1(cloudBackupUserInfo, z10, false, z11, str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: n */
    public void mo58521n(String str) {
        C12998f.m78034R().m78054F0(str);
        C12998f.m78034R().m78132w(C12997e.m78019l(), str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: n0 */
    public void mo58522n0(Context context) {
        C13148e.m79057f(context);
    }

    /* renamed from: n1 */
    public void m64687n1(CloudBackupUserInfo cloudBackupUserInfo, boolean z10, boolean z11, boolean z12, String str) throws C9721b {
        C11839m.m70688i("CloudBackupRouterImpl", "queryCloudBackupRecordsV2 records start.");
        List<CBSBackupRecord> listM67997D = new C11322a(str).m67997D(true, true);
        CloudRestoreClient cloudRestoreClient = new CloudRestoreClient();
        Map<String, CloudBackupDeviceInfo> deviceInfoMap = cloudBackupUserInfo.getDeviceInfoMap();
        List<CloudRecoveryItem> userRecordItems = cloudBackupUserInfo.getUserRecordItems();
        for (CBSBackupRecord cBSBackupRecord : listM67997D) {
            String deviceId = cBSBackupRecord.getDevice().getDeviceId();
            String backupDeviceId = cBSBackupRecord.getBackupDeviceId();
            if (!TextUtils.isEmpty(deviceId) && !TextUtils.isEmpty(backupDeviceId)) {
                int status = cBSBackupRecord.getStatus();
                if (!z11 || status == 0 || status == 1) {
                    if (Integer.valueOf("3").equals(cBSBackupRecord.getBakCategory()) && status != 0) {
                        C11839m.m70688i("CloudBackupRouterImpl", "temp backup and not success");
                    } else if (z12 || status == 0) {
                        CloudBackupDeviceInfo cloudBackupDeviceInfo = deviceInfoMap.get(backupDeviceId);
                        if (cloudBackupDeviceInfo == null) {
                            cloudBackupDeviceInfo = new CloudBackupDeviceInfo();
                        }
                        String aliasName = cBSBackupRecord.getDevice().getAliasName();
                        String terminalType = cBSBackupRecord.getDevice().getTerminalType();
                        String deviceCategory = cBSBackupRecord.getDevice().getDeviceCategory();
                        if (TextUtils.isEmpty(aliasName)) {
                            aliasName = terminalType;
                        }
                        cloudBackupDeviceInfo.setDeviceCategory(deviceCategory);
                        cloudBackupDeviceInfo.setDeviceId(deviceId);
                        cloudBackupDeviceInfo.setBackupDeviceId(backupDeviceId);
                        cloudBackupDeviceInfo.setDevDisplayName(aliasName);
                        if (z12 || status == 0) {
                            if (cBSBackupRecord.getAppIdInfos() == null) {
                                throw new C9721b(3107, "queryAllBackupRecordReq appInfo is null");
                            }
                            CloudRecoveryItem cloudRecoveryItemM64697z0 = m64697z0(cloudRestoreClient, cBSBackupRecord, z10);
                            List<CloudRecoveryItem> recoveryItems = cloudBackupDeviceInfo.getRecoveryItems();
                            if (recoveryItems == null) {
                                recoveryItems = new ArrayList<>();
                                cloudBackupDeviceInfo.setRecoveryItems(recoveryItems);
                            }
                            if (cloudRecoveryItemM64697z0.isTempBackup()) {
                                cloudBackupDeviceInfo.setTempBackup(true);
                            }
                            recoveryItems.add(cloudRecoveryItemM64697z0);
                            m64661C0(cloudBackupUserInfo, cloudRecoveryItemM64697z0);
                            userRecordItems.add(cloudRecoveryItemM64697z0);
                            long endTime = cBSBackupRecord.getEndTime();
                            if (cBSBackupRecord.isRefurbishment() || endTime <= 0) {
                                endTime = 0;
                            }
                            cloudBackupDeviceInfo.setCurrent(cloudRecoveryItemM64697z0.isCurrent());
                            cloudBackupDeviceInfo.setLastBackupTime(endTime);
                        }
                        deviceInfoMap.put(backupDeviceId, cloudBackupDeviceInfo);
                    }
                }
            }
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: o */
    public void mo58523o() {
        new BackupNotificationManager(C0213f.m1377a()).cancelSpaceNotEnoughNotify();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: o0 */
    public void mo58524o0(Context context) {
        StorageSpaceUsingTrackTask.m18112r(context);
    }

    /* renamed from: o1 */
    public final void m64688o1(CloudBackupUserInfo cloudBackupUserInfo, boolean z10, String str) throws C9721b {
        m64689p1(cloudBackupUserInfo, false, z10, str);
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: p */
    public boolean mo58525p(File file, File file2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1377a().getFilesDir());
        sb2.append("");
        return new BackupRestoreUtil(C0213f.m1377a(), (CacheTask) null, sb2.toString()).backup(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, C10279b.m63452a(file2), C10279b.m63452a(file)) == 0;
    }

    /* renamed from: p1 */
    public final void m64689p1(CloudBackupUserInfo cloudBackupUserInfo, boolean z10, boolean z11, String str) throws C9721b {
        C11839m.m70688i("CloudBackupRouterImpl", "queryCloudBackupRecordsV3 records start.");
        List<Device> listM84132c0 = new C13998b0().m84132c0("nextCursor,devices", str, true, true, true, false, null, false, false);
        Map<String, CloudBackupDeviceInfo> deviceInfoMap = cloudBackupUserInfo.getDeviceInfoMap();
        List<CloudRecoveryItem> userRecordItems = cloudBackupUserInfo.getUserRecordItems();
        if (listM84132c0.isEmpty()) {
            return;
        }
        for (Device device : listM84132c0) {
            String deviceDisplayName = device.getDeviceDisplayName();
            String deviceCategory = device.getDeviceCategory();
            String terminalType = device.getTerminalType();
            List<Bak> baks = device.getBaks();
            if (baks != null && !baks.isEmpty()) {
                for (Bak bak : baks) {
                    String backupDeviceId = bak.getBackupDeviceId();
                    int iIntValue = bak.getBackupStatus().intValue();
                    if (!z10 || iIntValue == 0 || iIntValue == 1) {
                        if (!bak.isTempBackup() || iIntValue == 0) {
                            if (z11 || iIntValue == 0) {
                                if (!TextUtils.isEmpty(backupDeviceId)) {
                                    CloudBackupDeviceInfo cloudBackupDeviceInfo = deviceInfoMap.get(backupDeviceId);
                                    if (cloudBackupDeviceInfo == null) {
                                        cloudBackupDeviceInfo = new CloudBackupDeviceInfo();
                                    }
                                    cloudBackupDeviceInfo.setBackupDeviceId(backupDeviceId);
                                    cloudBackupDeviceInfo.setDevDisplayName(deviceDisplayName);
                                    if (z11 || iIntValue == 0) {
                                        CloudRecoveryItem cloudRecoveryItemM64658A0 = m64658A0(bak, deviceDisplayName, deviceCategory);
                                        List<CloudRecoveryItem> recoveryItems = cloudBackupDeviceInfo.getRecoveryItems();
                                        m64661C0(cloudBackupUserInfo, cloudRecoveryItemM64658A0);
                                        if (recoveryItems == null) {
                                            recoveryItems = new ArrayList<>();
                                            cloudBackupDeviceInfo.setRecoveryItems(recoveryItems);
                                        }
                                        recoveryItems.add(cloudRecoveryItemM64658A0);
                                        userRecordItems.add(cloudRecoveryItemM64658A0);
                                        cloudBackupDeviceInfo.setCurrent(cloudRecoveryItemM64658A0.isCurrent());
                                        if (cloudRecoveryItemM64658A0.isTempBackup()) {
                                            cloudBackupDeviceInfo.setTempBackup(true);
                                        }
                                    }
                                    cloudBackupDeviceInfo.setDeviceCategory(deviceCategory);
                                    cloudBackupDeviceInfo.setTerminalType(terminalType);
                                    cloudBackupDeviceInfo.setLastBackupTime(m64635J0(bak, 0L));
                                    deviceInfoMap.put(backupDeviceId, cloudBackupDeviceInfo);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: q */
    public String mo58526q() throws JSONException {
        List<BackupOptionItem> listQuerySortedBackupDataExcludeSystemApp = TransferedUtil.querySortedBackupDataExcludeSystemApp();
        if (AbstractC14026a.m84159a(listQuerySortedBackupDataExcludeSystemApp)) {
            C11839m.m70688i("CloudBackupRouterImpl", "get bak app list empty.");
            return null;
        }
        List<BackupOptionItem> listSubList = listQuerySortedBackupDataExcludeSystemApp.subList(0, Math.min(4, listQuerySortedBackupDataExcludeSystemApp.size()));
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (BackupOptionItem backupOptionItem : listSubList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appId", backupOptionItem.getAppId());
                jSONObject2.put("packageName", m64669L0(backupOptionItem));
                jSONObject2.put("bakSize", backupOptionItem.getDataBytes());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("bakAppList", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e10) {
            C11839m.m70687e("CloudBackupRouterImpl", "get bak app list exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: q1 */
    public final UserBackupInfo m64690q1(UserBackupInfo userBackupInfo, List<UserBackupInfo.UserDeviceInfo> list, boolean z10) throws C9721b {
        if (z10) {
            m64649r1(userBackupInfo, list, new Predicate() { // from class: il.g
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((UserBackupInfo.UserDeviceInfo) obj).isCurrent();
                }
            });
            return userBackupInfo;
        }
        for (UserBackupInfo.UserDeviceInfo userDeviceInfo : list) {
            if (userDeviceInfo.isCurrent() && !userDeviceInfo.isTempBackUp()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(userDeviceInfo.getBackupDeviceId());
                m64671N0(arrayList, userBackupInfo, list);
                return userBackupInfo;
            }
        }
        return null;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: r */
    public List<CloudSpaceUsageItemColor> mo58527r() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, String> mapM16242b = Constant.m16242b();
        HashMap<String, String> mapM16243c = Constant.m16243c();
        for (Map.Entry<String, String> entry : mapM16242b.entrySet()) {
            String key = entry.getKey();
            arrayList.add(new CloudSpaceUsageItemColor(key, entry.getValue(), mapM16243c.get(key)));
        }
        return arrayList;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: s */
    public void mo58528s(Handler.Callback callback) {
        CBCallBack.getInstance().unregisterCallback(callback);
    }

    /* renamed from: s1 */
    public CloudBackupUserInfo m64691s1() {
        try {
            CloudBackupUserInfo cloudBackupUserInfoM64684k1 = m64684k1(true);
            CloudRecoveryItem currentLatestBackupRecord = cloudBackupUserInfoM64684k1.getCurrentLatestBackupRecord();
            if (currentLatestBackupRecord == null) {
                C11839m.m70688i("CloudBackupRouterImpl", "query last record is null.");
                return null;
            }
            if (CBSBaseReq.CURRENT_API_VERSION.equals(currentLatestBackupRecord.getVersion())) {
                CloudRecoveryItem cloudRecoveryItemQueryV3RecordAppInfosFromServer = CloudBackupService.getInstance().queryV3RecordAppInfosFromServer(currentLatestBackupRecord.getBackupDeviceId(), currentLatestBackupRecord.getBackupId(), false, false, currentLatestBackupRecord.isNewBmRecord(), false);
                if (cloudRecoveryItemQueryV3RecordAppInfosFromServer.getItemList() == null) {
                    C11839m.m70688i("CloudBackupRouterImpl", "query last record item list is null.");
                    return null;
                }
                currentLatestBackupRecord.setItemList(cloudRecoveryItemQueryV3RecordAppInfosFromServer.getItemList());
            }
            return cloudBackupUserInfoM64684k1;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupRouterImpl", "query last record error: " + e10.getMessage());
            return null;
        } catch (Exception e11) {
            C11839m.m70687e("CloudBackupRouterImpl", "query last record exception , error: " + e11.getMessage());
            return null;
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: t */
    public void mo58529t(Context context) {
        new BackupNotificationManager(context).cancelNotification(289);
    }

    /* renamed from: t1 */
    public String m64692t1(boolean z10, boolean z11, String str) throws C9721b {
        if (C10028c.m62182c0().m62335h1()) {
            return z10 ? new SettingOperator().queryBakSourceStrategy() : m64665G0(z11, new C13998b0().m84137z("bakSourceStrategy", str));
        }
        C11839m.m70688i("CloudBackupRouterImpl", "queryAllCloudBackupRecords do not support about");
        return "1";
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: u */
    public void mo58530u(Context context, String str) throws JSONException {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C11839m.m70689w("CloudBackupRouterImpl", "jumpToDataExpiresDownloadPage, sysParamMap is null!");
            mo58515k(context, str);
            return;
        }
        String dataExpiresDownloadPage = hiCloudSysParamMapM60758q.getDataExpiresDownloadPage();
        if (TextUtils.isEmpty(dataExpiresDownloadPage)) {
            C11839m.m70689w("CloudBackupRouterImpl", "jumpToDataExpiresDownloadPage, dataExpiresDownloadPage is empty!");
            mo58515k(context, str);
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.putExtra("srcChannel", "0");
        safeIntent.putExtra("salChannel", "0");
        if (str != null) {
            safeIntent.putExtra("sceneId", str);
        }
        C11273b.m67657l(context, dataExpiresDownloadPage, safeIntent, "");
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: u1 */
    public CloudBackupUserInfo mo58476H(boolean z10, boolean z11, boolean z12) throws C9721b {
        String strM66627b = C11058a.m66627b(z10 ? "02101" : "02102");
        CloudBackupUserInfo cloudBackupUserInfo = new CloudBackupUserInfo();
        long jCurrentTimeMillis = System.currentTimeMillis();
        m64683j1(cloudBackupUserInfo, z10, z11, true, z12, true, strM66627b);
        C11839m.m70688i("CloudBackupRouterImpl", "queryBackupRecords cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        Map<String, CloudBackupDeviceInfo> deviceInfoMap = cloudBackupUserInfo.getDeviceInfoMap();
        if (!deviceInfoMap.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, CloudBackupDeviceInfo>> it = deviceInfoMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey());
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            do {
                if (arrayList.size() > 25) {
                    try {
                        m64666H0(arrayList.subList(0, 25), cloudBackupUserInfo);
                        if (arrayList.size() > 25) {
                            arrayList.subList(0, 25).clear();
                        }
                    } catch (IndexOutOfBoundsException e10) {
                        C11839m.m70688i("CloudBackupRouterImpl", "getDeviceList error " + e10.toString());
                    }
                } else {
                    m64666H0(arrayList, cloudBackupUserInfo);
                    arrayList.clear();
                }
            } while (arrayList.size() != 0);
            C11839m.m70688i("CloudBackupRouterImpl", "getSpace cost time:" + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
        }
        return cloudBackupUserInfo;
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: v */
    public int mo58531v() {
        return this.f50721c.m75325A0().getPauseBattery();
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: w */
    public boolean mo58532w() {
        return C12598v.m76041i();
    }

    /* renamed from: w1 */
    public final void m64694w1(Bak bak, ArrayList<ExtraDeviceInfo> arrayList) {
        if (bak != null) {
            ExtraDeviceInfo extraDeviceInfo = new ExtraDeviceInfo();
            extraDeviceInfo.setId(bak.getId());
            extraDeviceInfo.setOccupySpaceType(bak.getOccupySpaceType());
            extraDeviceInfo.setExpiratoryInDays(bak.getExpiratoryInDays());
            extraDeviceInfo.setCanBeReserveForever(bak.isCanbeReserveForever());
            arrayList.add(extraDeviceInfo);
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: x */
    public String mo58533x(String str) {
        return C10465b.m64294d(str);
    }

    /* renamed from: x1 */
    public final void m64695x1(UserBackupInfo.UserDeviceInfo userDeviceInfo, CBSBackupRecord cBSBackupRecord) {
        if (cBSBackupRecord != null) {
            ArrayList<ExtraDeviceInfo> arrayList = new ArrayList<>();
            ExtraDeviceInfo extraDeviceInfo = new ExtraDeviceInfo();
            extraDeviceInfo.setId(cBSBackupRecord.getBackupId());
            extraDeviceInfo.setOccupySpaceType(cBSBackupRecord.getOccupySpaceType());
            extraDeviceInfo.setExpiratoryInDays(cBSBackupRecord.getExpiratoryInDays());
            extraDeviceInfo.setCanBeReserveForever(cBSBackupRecord.isCanBeReserveForever());
            arrayList.add(extraDeviceInfo);
            userDeviceInfo.setExtraDeviceInfos(arrayList);
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: y */
    public FamilySharePageConfig mo58534y(String str) {
        return C9681b.m60470l().m60488h(FamilyShareConstants.FamilyShareConfig.CLOUD_USAGE);
    }

    /* renamed from: y1 */
    public final void m64696y1(List<Bak> list, UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (AbstractC14026a.m84159a(list)) {
            userDeviceInfo.setOnlyHarmonyNext(false);
        } else {
            userDeviceInfo.setOnlyHarmonyNext(list.stream().filter(new Predicate() { // from class: il.h
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10542o.m64638X0((Bak) obj);
                }
            }).count() == ((long) list.size()));
        }
    }

    @Override // p232dp.InterfaceC9283b
    /* renamed from: z */
    public long mo58535z() {
        return C12590s0.m75794S();
    }

    /* renamed from: z0 */
    public final CloudRecoveryItem m64697z0(CloudRestoreClient cloudRestoreClient, CBSBackupRecord cBSBackupRecord, boolean z10) throws C9721b {
        String deviceId = cBSBackupRecord.getDevice().getDeviceId();
        String backupDeviceId = cBSBackupRecord.getBackupDeviceId();
        String version = cBSBackupRecord.getVersion();
        String aliasName = cBSBackupRecord.getDevice().getAliasName();
        String terminalType = cBSBackupRecord.getDevice().getTerminalType();
        String devDisplayName = cBSBackupRecord.getDevice().getDevDisplayName();
        int deviceType = cBSBackupRecord.getDevice().getDeviceType();
        String deviceCategory = cBSBackupRecord.getDevice().getDeviceCategory();
        boolean zIsRefurbishment = cBSBackupRecord.isRefurbishment();
        boolean zEquals = TextUtils.equals(String.valueOf(cBSBackupRecord.getBakCategory()), "3");
        Integer occupySpaceType = cBSBackupRecord.getOccupySpaceType();
        List<CBSAppInfo> appIdInfos = cBSBackupRecord.getAppIdInfos();
        if (TextUtils.isEmpty(aliasName)) {
            aliasName = terminalType;
        }
        CloudRecoveryItem cloudRecoveryItem = new CloudRecoveryItem();
        cloudRecoveryItem.setDeviceIdd(deviceId + "&" + backupDeviceId + "&" + version);
        cloudRecoveryItem.setRecordDeviceId(deviceId);
        cloudRecoveryItem.setBackupDeviceId(backupDeviceId);
        cloudRecoveryItem.setCurrent(deviceId.equals(C13452e.m80781L().m80950o()));
        cloudRecoveryItem.setDeviceName(aliasName);
        cloudRecoveryItem.setTerminalType(terminalType);
        cloudRecoveryItem.setDevDisplayName(devDisplayName);
        String str = C11842p.m70762R0() ? "pad" : "phone";
        if (cloudRecoveryItem.isCurrent()) {
            deviceCategory = str;
        }
        cloudRecoveryItem.setDeviceCategory(deviceCategory);
        cloudRecoveryItem.setDeviceType(deviceType);
        cloudRecoveryItem.setBackupId(cBSBackupRecord.getBackupId());
        cloudRecoveryItem.setBackupEndTime(cBSBackupRecord.getEndTime());
        cloudRecoveryItem.setStartTime(cBSBackupRecord.getStartTime());
        cloudRecoveryItem.setBackupCompleted(cBSBackupRecord.getStatus() == 0);
        int iM64663E0 = m64663E0(version, cBSBackupRecord.getBmDataType());
        boolean z11 = cBSBackupRecord.getBmDataType() != 0;
        if (z10) {
            ArrayList arrayList = new ArrayList();
            long size = 0;
            for (CBSAppInfo cBSAppInfo : appIdInfos) {
                size += cBSAppInfo.getSize();
                arrayList.add(cloudRestoreClient.buildRestoreStatus(cBSAppInfo, Boolean.valueOf(z11)));
            }
            cloudRecoveryItem.setItemList(RestoreProgress.buildRestoreItems(arrayList, RestoreUtil.isNewBmRecordByRecordLabel(iM64663E0)));
            cloudRecoveryItem.setSize(size);
        }
        if (zEquals) {
            cloudRecoveryItem.setSize(((Long) Optional.ofNullable(cBSBackupRecord.getTotalSize()).orElse(0L)).longValue());
        }
        cloudRecoveryItem.setVersion(version);
        cloudRecoveryItem.setRefurbishment(zIsRefurbishment);
        cloudRecoveryItem.setTempBackup(zEquals);
        cloudRecoveryItem.setBackupRecordLabel(iM64663E0);
        cloudRecoveryItem.setBmDataType(cBSBackupRecord.getBmDataType());
        cloudRecoveryItem.setNewBmRecord(z11);
        cloudRecoveryItem.setOccupySpaceType(occupySpaceType == null ? 0 : occupySpaceType.intValue());
        cloudRecoveryItem.setExpiratoryInDays(cBSBackupRecord.getExpiratoryInDays());
        return cloudRecoveryItem;
    }

    /* renamed from: z1 */
    public final void m64698z1(List<Bak> list, final UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (AbstractC14026a.m84159a(list)) {
            return;
        }
        long jCount = list.stream().filter(new Predicate() { // from class: il.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10542o.m64639Y0((Bak) obj);
            }
        }).count();
        long jCount2 = list.stream().filter(new Predicate() { // from class: il.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10542o.m64640Z0((Bak) obj);
            }
        }).count() - list.stream().filter(new C10537j()).count();
        long jCount3 = list.stream().filter(new Predicate() { // from class: il.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10542o.m64641a1((Bak) obj);
            }
        }).count();
        long jCount4 = list.stream().filter(new Predicate() { // from class: il.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10542o.m64642b1((Bak) obj);
            }
        }).count();
        C11839m.m70686d("CloudBackupRouterImpl", "BackupDeviceId:" + userDeviceInfo.getBackupDeviceId());
        C11839m.m70688i("CloudBackupRouterImpl", "refurbishCount :" + jCount + " commonBakCount:" + jCount2 + ",inBackupCommonBakCount:" + jCount3 + ",completedCount:" + jCount4);
        boolean z10 = false;
        boolean z11 = jCount >= 1;
        if (z11 && jCount2 == 0) {
            z10 = true;
        }
        if (z10) {
            list.stream().filter(new Predicate() { // from class: il.n
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10542o.m64643c1((Bak) obj);
                }
            }).filter(new Predicate() { // from class: il.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10542o.m64644d1((Bak) obj);
                }
            }).findFirst().ifPresent(new Consumer() { // from class: il.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10542o.m64645e1(userDeviceInfo, (Bak) obj);
                }
            });
        }
        userDeviceInfo.setOnlyRefurbish(z10);
        if (jCount4 == 0 && jCount3 >= 1 && z11) {
            userDeviceInfo.setHasOnlyRefurbishAndBackingUp(true);
        }
        userDeviceInfo.setHasRefurbish(z11);
    }
}
