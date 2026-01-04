package p572qb;

import android.app.KeyguardManager;
import android.content.Intent;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.DestopPopupPolicy;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.messagecenter.operator.MessageDeskPopupDbOperator;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p020ap.C1009d;
import p335hd.C10142e;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;

/* renamed from: qb.h */
/* loaded from: classes3.dex */
public class C12311h {

    /* renamed from: qb.h$a */
    public static class a {

        /* renamed from: a */
        public static final C12311h f57020a = new C12311h();
    }

    /* renamed from: qb.h$b */
    public static class b implements ScreenListener.ScreenStateListener {
        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOff() {
            C11839m.m70688i("DesktopDialogManager", "DesktopScreenStateListener onScreenOff");
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOn() {
            C11839m.m70688i("DesktopDialogManager", "DesktopScreenStateListener  screenOn");
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onUserPresent() {
            C11839m.m70688i("DesktopDialogManager", "DesktopScreenStateListener onUserPresent");
            if (!C13612b.m81829B().isLogin()) {
                C11839m.m70688i("DesktopDialogManager", "onUserPresent now not login.");
                return;
            }
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("event", "screen unlock");
            C12311h.m74013c().m74021i("desktopCheckTimer", linkedHashMapM79497A);
            DestopPopupPolicy desktopUnlockFrequency = NotifyUtil.getDesktopUnlockFrequency();
            C10142e.m63197d().m63203j(true);
            C10142e.m63197d().setPeriod(desktopUnlockFrequency.getScreenUnlockCheckInteval());
            C12311h.m74013c().m74024l();
            ScreenListener.m18023c(C0213f.m1377a()).m18028g();
        }
    }

    /* renamed from: c */
    public static C12311h m74013c() {
        return a.f57020a;
    }

    /* renamed from: a */
    public void m74014a(LinkedHashMap<String, String> linkedHashMap, DeskPopupMsgObj deskPopupMsgObj) {
        if (linkedHashMap == null || deskPopupMsgObj == null) {
            return;
        }
        linkedHashMap.put("aciton", String.valueOf(deskPopupMsgObj.getDeskPopupAction()));
        linkedHashMap.put("messageId", String.valueOf(deskPopupMsgObj.getMessageId()));
        linkedHashMap.put(ContentRecord.UNIQUE_ID, String.valueOf(deskPopupMsgObj.getUniqueId()));
        linkedHashMap.put("resourceInfo", String.valueOf(deskPopupMsgObj.getResourceInfo()));
    }

    /* renamed from: b */
    public void m74015b(String str) {
        try {
            new MessageDeskPopupDbOperator().deletePopupById(str);
        } catch (Exception e10) {
            NotifyLogger.m29914e("DesktopDialogManager", "deletePopupById exception, e: " + e10.toString());
        }
    }

    /* renamed from: d */
    public String m74016d(DeskPopupMsgObj deskPopupMsgObj) {
        if (deskPopupMsgObj != null) {
            return deskPopupMsgObj.getDeskPopupAction() == 3 ? "SOURCE_ID_BEFOR_MEMBER_EXPIRE_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 9 ? "SOURCE_ID_NEW_BEFOR_MEMBER_EXPIRE_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 8 ? "SOURCE_ID_BEFOR_DELETE_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 18 ? "SOURCE_ID_SILENCE_DEVICE_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 12 ? "SOURCE_ID_DATA_PERIOD1_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 13 ? "SOURCE_ID_DATA_PERIOD2_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 14 ? "SOURCE_ID_DATA_PERIOD3_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 19 ? "SOURCE_ID_INTERIM_BEFOR_DELETE_DIALOG" : deskPopupMsgObj.getDeskPopupAction() == 2 ? "SOURCE_ID_ACTION_OTHER_OPERATION_DIALOG" : "";
        }
        C11839m.m70689w("DesktopDialogManager", "getSourceId deskPopupMsgObj is null");
        return "";
    }

    /* renamed from: e */
    public void m74017e() {
        C11839m.m70688i("DesktopDialogManager", "initScene start.");
        if (!C13612b.m81829B().isLogin()) {
            C11839m.m70688i("DesktopDialogManager", "initScene now not login.");
            return;
        }
        List<DeskPopupMsgObj> listM74020h = m74020h();
        if (listM74020h == null || listM74020h.isEmpty()) {
            C11839m.m70688i("DesktopDialogManager", "initScene deskPopupMsgObjList is null or empty.");
            return;
        }
        if (!((KeyguardManager) C0213f.m1377a().getSystemService("keyguard")).isKeyguardLocked()) {
            m74024l();
            return;
        }
        C11839m.m70688i("DesktopDialogManager", "initScene now isLocked.");
        ScreenListener.m18023c(C0213f.m1377a()).m18025b(new b());
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        m74014a(linkedHashMapM79497A, listM74020h.get(0));
        m74021i("initScene now isLocked.", linkedHashMapM79497A);
    }

    /* renamed from: f */
    public boolean m74018f(DeskPopupMsgObj deskPopupMsgObj) {
        if (deskPopupMsgObj == null) {
            C11839m.m70687e("DesktopDialogManager", "isParamSatisfy deskPopupMsgObj is null.");
            return false;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("unique_id", deskPopupMsgObj.getUniqueId());
        linkedHashMap.put("message_id", deskPopupMsgObj.getMessageId());
        return C1009d.m6109e().m6119k(new ArrayList(), new ArrayList(), deskPopupMsgObj.getTrigger(), deskPopupMsgObj.getSupportTrigger(), linkedHashMap);
    }

    /* renamed from: g */
    public void m74019g() {
        C11839m.m70688i("DesktopDialogManager", "pushScene start.");
        C10142e.m63197d().setPeriod(10L);
        C12515a.m75110o().m75166b(C10142e.class.getName());
        m74024l();
    }

    /* renamed from: h */
    public List<DeskPopupMsgObj> m74020h() {
        try {
            return new MessageDeskPopupDbOperator().queryUnShowPopup();
        } catch (Exception e10) {
            NotifyLogger.m29914e("DesktopDialogManager", "queryUnShowPopup exception, e: " + e10.toString());
            return null;
        }
    }

    /* renamed from: i */
    public void m74021i(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null) {
            try {
                C13230i.m79504I().m79567R(str, linkedHashMap);
                UBAAnalyze.m29958S("CKC", str, "2", "31", linkedHashMap);
                m74022j(str, linkedHashMap);
            } catch (Exception e10) {
                C11839m.m70687e("DesktopDialogManager", "reportActivityBaseEvent occur:" + e10.getMessage());
            }
        }
    }

    /* renamed from: j */
    public void m74022j(String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06028"), "06028", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: k */
    public void m74023k(DeskPopupMsgObj deskPopupMsgObj) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        hiCloudSafeIntent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        C0209d.m1302r2(hiCloudSafeIntent, C0213f.m1377a().getPackageName());
        hiCloudSafeIntent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 16);
        hiCloudSafeIntent.putExtra("desktop_pop_data", deskPopupMsgObj);
        C0216g0.m1402e(C0213f.m1377a()).m1407E(hiCloudSafeIntent, m74016d(deskPopupMsgObj));
        hiCloudSafeIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C0213f.m1377a().startActivity(hiCloudSafeIntent);
    }

    /* renamed from: l */
    public void m74024l() {
        C12515a.m75110o().m75175e(C10142e.m63197d(), true);
    }
}
