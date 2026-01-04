package com.huawei.android.hicloud.sync.wifi;

import android.content.Context;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteWlanLocalDataTask;
import com.huawei.android.hicloud.sync.syncutil.C2974c;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9722c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p514o9.C11839m;
import p684un.C13226e;
import sc.C12777j;
import tc.C13007b;

/* loaded from: classes3.dex */
public class SyncWlanImp extends WlanLogicProcess {
    private static final String TAG = "SyncWlanImp";

    public SyncWlanImp(Context context, String str, String str2, ReportSyncEndInfo reportSyncEndInfo, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, "wlan", "wlan", str, str2, concurrentHashMap);
        this.mReportEndInfo = reportSyncEndInfo;
    }

    private boolean checkFirstOpenSwitch() {
        if (!CloudSyncUtil.m15955I(this.mContext, "wlan")) {
            return false;
        }
        C11839m.m70688i(TAG, "syncWlan first sync, clear tag");
        try {
            DeleteWlanLocalDataTask.deleteWlanTag();
        } catch (Exception unused) {
            C11839m.m70687e(TAG, "syncWlan deleteTag Exception");
        }
        CloudSyncUtil.m15984W0(this.mContext, "wlan", false);
        return true;
    }

    private String getSyncReportInfo() {
        StringBuilder sb2 = new StringBuilder();
        if (this.lAdd > 0) {
            sb2.append("cloudAdd:");
            sb2.append(this.lAdd);
        }
        if (this.lDel > 0) {
            sb2.append(",cloudMod:");
            sb2.append(this.lMod);
        }
        if (this.lDel > 0) {
            sb2.append(",cloudDel:");
            sb2.append(this.lDel);
        }
        if (this.cAdd > 0) {
            sb2.append(",localAdd:");
            sb2.append(this.cAdd);
        }
        if (this.cMod > 0) {
            sb2.append(",localMod:");
            sb2.append(this.cMod);
        }
        if (this.cDel > 0) {
            sb2.append(",localDel:");
            sb2.append(this.cDel);
        }
        C11839m.m70688i(TAG, "syncWlan syncDetail: " + sb2.toString());
        return sb2.toString();
    }

    private void processGuideSwitchNotify() {
        Map<String, SyncWlanBean> map;
        List<String> list;
        Map<String, SyncWlanBean> map2 = this.lNewItems;
        boolean z10 = false;
        boolean z11 = ((map2 == null || map2.isEmpty()) && ((map = this.lUpdItems) == null || map.isEmpty())) ? false : true;
        Map<String, SyncWlanBean> map3 = this.lDelItems;
        boolean z12 = (map3 == null || map3.isEmpty()) ? false : true;
        List<String> list2 = this.cNewUpdaItems;
        if ((list2 != null && !list2.isEmpty()) || ((list = this.cDelItems) != null && !list.isEmpty())) {
            z10 = true;
        }
        if (z11 || z12 || z10) {
            C11839m.m70688i(TAG, "syncWlan has data changed");
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b != null) {
                interfaceC9283b.mo58522n0(this.mContext);
            }
        }
    }

    private void reportWlanSizeForBI() throws C9722c {
        C11839m.m70688i(TAG, "reportWlanSizeForBI");
        int size = this.f13028wm.prpeData().size();
        int size2 = this.cloudEtagMap.size();
        if (size2 == 0) {
            size2 = new C12777j().m76690j("wlan").size();
        }
        C13226e.m79491f1().m79570S0("wlan", "wlan", size, size2, this.lNewItems.size(), this.lDelItems.size(), 0, 0);
    }

    private void syncWlanV2(boolean z10) throws Exception {
        C11839m.m70686d(TAG, "syncWlan begin prepare get lock mSyncMode: " + this.mSyncMode);
        isCancel();
        syncV2(this.mSyncType);
        C11839m.m70686d(TAG, "syncWlan begin compare ctag");
        isCancel();
        if (isNeedQueryCloudDataV2()) {
            C13007b.m78205Y(this.mContext).m78252c();
            isCancel();
            C11839m.m70686d(TAG, "syncWlan begin get etag");
            getRecordList();
            C2980i.m17883r(this.mReportEndInfo, false);
            boolean zM78298z = C13007b.m78205Y(this.mContext).m78298z(this.mSyncType, this.mDataType);
            if (zM78298z) {
                C11839m.m70688i(TAG, "syncWlan isNeedFullSync dataType: " + this.mDataType);
                C13007b.m78205Y(this.mContext).m78279p0(this.mSyncType, this.mDataType, false);
            }
            reportPropfind("getRecordList", z10 ? "openSwitch" : zM78298z ? "firstMigrate" : "ctagChanges", this.cloudEtagMap.size(), 0);
            C11839m.m70688i(TAG, "syncWlan compare etag");
            isCancel();
            if (compareWlanEtag()) {
                C11839m.m70688i(TAG, "syncWlan process cloud data size: " + this.cloudEtagMap.size());
                long jCurrentTimeMillis = System.currentTimeMillis();
                isCancel();
                processCloudData();
                C2980i.m17877l(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            }
            C11839m.m70688i(TAG, "syncWlan update local ctag");
            updateCtag();
        }
        isCancel();
        reportWlanSizeForBI();
        if (new C2974c(this.mContext, this.mSyncType, "", "wlan", this.lNewItems.size(), this.lDelItems.size(), this.lUpdItems.size(), this.traceId).m17833f()) {
            throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, "risk management effective");
        }
        C11839m.m70688i(TAG, "syncWlan local data to cloud");
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        processLocalData();
        C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis2);
        C11839m.m70686d(TAG, "syncWlan end process local data");
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x016d: MOVE (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:51:0x0169 */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.android.hicloud.sync.service.aidl.ModuleRst doSync(android.os.Handler.Callback r26, int r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.wifi.SyncWlanImp.doSync(android.os.Handler$Callback, int):com.huawei.android.hicloud.sync.service.aidl.ModuleRst");
    }
}
