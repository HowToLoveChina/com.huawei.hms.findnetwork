package fj;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudspace.campaign.bean.CalendarEventBean;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchSuggestDialog;
import com.huawei.hicloud.bean.EntryQuestBean;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.campaign.bean.CampaignActivityConfig;
import com.huawei.hicloud.campaign.bean.CampaignActivityRoot;
import com.huawei.hicloud.campaign.bean.Quest;
import com.huawei.hicloud.campaign.bean.QuestAttributes;
import com.huawei.hicloud.campaign.bean.QuestBean;
import com.huawei.hicloud.campaign.bean.QuestRoot;
import com.huawei.hicloud.campaign.bean.RankingValues;
import com.huawei.hicloud.campaign.bean.quest.AdsActivationAttr;
import com.huawei.hicloud.campaign.bean.quest.CalendarNotifyAttr;
import com.huawei.hicloud.campaign.bean.quest.DownloadAppAttr;
import com.huawei.hicloud.campaign.bean.quest.FutureSwitchAttr;
import com.huawei.hicloud.campaign.bean.quest.KaActivationAttr;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0224k0;
import p015ak.C0229n;
import p015ak.C0241z;
import p020ap.C1010e;
import p054cj.C1442a;
import p292fn.C9733f;
import p514o9.C11839m;
import p672u8.C13133c;
import p709vj.C13452e;
import p778xk.C13821b;
import p778xk.C13823d;
import p778xk.C13826g;

/* renamed from: fj.g */
/* loaded from: classes5.dex */
public class C9718g {

    /* renamed from: a */
    public final String[] f47939a;

    /* renamed from: b */
    public volatile List<EntryQuestBean> f47940b;

    /* renamed from: c */
    public long f47941c;

    /* renamed from: d */
    public long f47942d;

    /* renamed from: e */
    public final boolean f47943e;

    /* renamed from: fj.g$b */
    public static class b {

        /* renamed from: a */
        public static final C9718g f47944a = new C9718g();
    }

    /* renamed from: R */
    public static /* synthetic */ boolean m60591R(EntryQuestBean entryQuestBean) {
        return entryQuestBean.getState() == 3;
    }

    /* renamed from: S */
    public static /* synthetic */ boolean m60592S(EntryQuestBean entryQuestBean) {
        return entryQuestBean.getState() != 3;
    }

    /* renamed from: T */
    public static /* synthetic */ boolean m60593T(String str, EntryQuestBean entryQuestBean) {
        return str.equals(entryQuestBean.getId());
    }

    /* renamed from: U */
    public static /* synthetic */ boolean m60594U(QuestBean questBean, String str) {
        return TextUtils.equals(str, questBean.getId());
    }

    /* renamed from: W */
    public static void m60595W(Context context, int i10) {
        C1442a.m8290i("CampaignManager", "updateCampaignEntryFlag state:" + i10);
        C0212e0.m1368r(context, "hicloud_campaign_activity_entry_sp", "displayEntryFlag", i10);
    }

    /* renamed from: X */
    public static void m60596X(Context context, String str) {
        C0212e0.m1372v(context, "hicloud_campaign_activity_entry_sp", "guideTaskId", str);
    }

    /* renamed from: s */
    public static String m60601s(Context context) {
        return C0212e0.m1363m(context, "hicloud_campaign_activity_entry_sp", "guideTaskId", "");
    }

    /* renamed from: t */
    public static C9718g m60602t() {
        return b.f47944a;
    }

    /* renamed from: A */
    public void m60603A(List<QuestBean> list, List<EntryQuestBean> list2, String str, CampaignActivityRoot campaignActivityRoot) throws IOException {
        boolean z10;
        QuestBean questBeanM60633m;
        C11839m.m70688i("CampaignManager", "getUnfinishedTaskList");
        QuestRoot questRootM82963k = C13826g.m82950l().m82963k();
        final String strM60601s = m60601s(C0213f.m1377a());
        if (TextUtils.isEmpty(strM60601s) || !list2.stream().anyMatch(new Predicate() { // from class: fj.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9718g.m60593T(strM60601s, (EntryQuestBean) obj);
            }
        }) || (questBeanM60633m = m60633m(strM60601s, questRootM82963k)) == null) {
            z10 = false;
        } else {
            list.add(questBeanM60633m);
            z10 = true;
        }
        for (EntryQuestBean entryQuestBean : list2) {
            if (entryQuestBean == null || TextUtils.isEmpty(entryQuestBean.getId())) {
                C11839m.m70688i("CampaignManager", "entryTask is empty");
            } else {
                String id2 = entryQuestBean.getId();
                if (z10 && id2.equals(strM60601s)) {
                    C11839m.m70688i("CampaignManager", "hasGuideTask");
                } else {
                    QuestBean questBeanM60633m2 = m60633m(id2, questRootM82963k);
                    if (questBeanM60633m2 == null) {
                        C11839m.m70687e("CampaignManager", "questBean is null");
                    } else {
                        String type = questBeanM60633m2.getType();
                        if (TextUtils.isEmpty(type)) {
                            C11839m.m70687e("CampaignManager", "questType is empty");
                        } else if (!m60619Q(questBeanM60633m2, null)) {
                            C11839m.m70687e("CampaignManager", "not support quest");
                        } else if (!m60624b0(questBeanM60633m2, str, campaignActivityRoot)) {
                            C11839m.m70687e("CampaignManager", "quest quota null");
                        } else if ("download_app".equals(type) || "motivating_video".equals(type) || "app_activation".equals(type)) {
                            C11839m.m70688i("CampaignManager", "DOWNLOAD_APP not show");
                        } else if (!"upload_file".equals(type) && !"create_drive_file".equals(type) && !"create_drive_folder".equals(type)) {
                            if ("feature_switch".equals(type)) {
                                QuestAttributes attributes = questBeanM60633m2.getAttributes();
                                if (attributes == null) {
                                    C1442a.m8289e("CampaignManager", "getAttributes is null");
                                } else {
                                    FutureSwitchAttr futureSwitch = attributes.getFutureSwitch();
                                    if (futureSwitch == null || SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY.equals(futureSwitch.getFutureTag())) {
                                        C1442a.m8289e("CampaignManager", "FutureTag null");
                                    } else if (!m60628h(questBeanM60633m2)) {
                                        C1442a.m8290i("CampaignManager", "checkFeatureSwitch is open");
                                    }
                                }
                            }
                            list.add(questBeanM60633m2);
                        } else if (m60609G(questBeanM60633m2)) {
                            list.add(questBeanM60633m2);
                        } else {
                            C1442a.m8290i("CampaignManager", "checkFileManagerSupport false");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: B */
    public final long m60604B() {
        return this.f47941c;
    }

    /* renamed from: C */
    public final void m60605C() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            return;
        }
        long taskActivityValidity = hiCloudSysParamMapM60757p.getTaskActivityValidity();
        if (taskActivityValidity <= 0) {
            return;
        }
        this.f47941c = taskActivityValidity;
        C1442a.m8288d("CampaignManager", "updateInterval: " + this.f47941c);
    }

    /* renamed from: D */
    public boolean m60606D(Context context) {
        String strM60636p = m60636p(context);
        if (TextUtils.isEmpty(strM60636p) || !C13821b.m82867w().m82873F(strM60636p)) {
            return false;
        }
        C1442a.m8291w("CampaignManager", "isActivityFinished is true");
        return true;
    }

    /* renamed from: E */
    public boolean m60607E(Context context, boolean z10) {
        if (m60606D(context)) {
            return false;
        }
        C1442a.m8290i("CampaignManager", "isCampaignValid homepage: " + z10);
        return !z10 && System.currentTimeMillis() - C0212e0.m1359i(context, "hicloud_campaign_activity_entry_sp", "updateTime", 0L) <= m60604B();
    }

    /* renamed from: F */
    public boolean m60608F(Context context) {
        return C0212e0.m1354d(context, "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e A[RETURN] */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m60609G(com.huawei.hicloud.campaign.bean.QuestBean r8) {
        /*
            r7 = this;
            boolean r7 = r7.m60614L()
            java.lang.String r0 = "CampaignManager"
            r1 = 0
            if (r7 == 0) goto Lf
            java.lang.String r7 = "checkFileManagerSupport false , due to the user is silenceUser!"
            p054cj.C1442a.m8289e(r0, r7)
            return r1
        Lf:
            android.content.Context r7 = p015ak.C0213f.m1377a()
            java.lang.String r2 = "com.huawei.filemanager"
            java.lang.String r3 = "campaignTask"
            java.lang.String r7 = p015ak.C0240y.m1679a(r7, r2, r3)
            int r7 = p015ak.C0241z.m1685c(r7)
            java.lang.String r2 = r8.getType()
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 1
            r6 = -1
            switch(r3) {
                case -566570202: goto L47;
                case 754711092: goto L3c;
                case 1064581370: goto L31;
                default: goto L30;
            }
        L30:
            goto L51
        L31:
            java.lang.String r3 = "upload_file"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3a
            goto L51
        L3a:
            r6 = r4
            goto L51
        L3c:
            java.lang.String r3 = "create_drive_file"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L45
            goto L51
        L45:
            r6 = r5
            goto L51
        L47:
            java.lang.String r3 = "create_drive_folder"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L50
            goto L51
        L50:
            r6 = r1
        L51:
            switch(r6) {
                case 0: goto L69;
                case 1: goto L65;
                case 2: goto L55;
                default: goto L54;
            }
        L54:
            goto L6e
        L55:
            com.huawei.hicloud.campaign.bean.QuestAttributes r8 = r8.getAttributes()
            if (r8 != 0) goto L61
            java.lang.String r7 = "checkFileManagerSupport getAttributes is null"
            p054cj.C1442a.m8289e(r0, r7)
            return r1
        L61:
            r7 = r7 & r5
            if (r7 == 0) goto L6e
            return r5
        L65:
            r7 = r7 & r4
            if (r7 == 0) goto L6e
            return r5
        L69:
            r7 = r7 & 4
            if (r7 == 0) goto L6e
            return r5
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fj.C9718g.m60609G(com.huawei.hicloud.campaign.bean.QuestBean):boolean");
    }

    /* renamed from: H */
    public final boolean m60610H(Context context, String str, int i10, String str2) throws PackageManager.NameNotFoundException {
        boolean zM60630j = true;
        if (TextUtils.isEmpty(str)) {
            C1442a.m8291w("CampaignManager", "packageName is null");
            return true;
        }
        boolean z10 = false;
        if (context == null) {
            C1442a.m8291w("CampaignManager", "context is null");
            return false;
        }
        int iM1685c = C0241z.m1685c(str2);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            if (packageInfo != null) {
                int i11 = packageInfo.versionCode;
                C1442a.m8290i("CampaignManager", str + " localVersion: " + i11);
                if (!TextUtils.isEmpty(str2)) {
                    zM60630j = m60630j(i10, iM1685c, i11);
                }
            } else {
                zM60630j = false;
            }
            z10 = zM60630j;
        } catch (Exception e10) {
            C1442a.m8289e("CampaignManager", "checkKaVersion exception." + e10.getMessage());
        }
        C1442a.m8288d("CampaignManager", "checkKaVersion result:" + z10);
        return z10;
    }

    /* renamed from: I */
    public boolean m60611I(Context context) {
        return !C13452e.m80781L().m80795D0() && 1 == C0212e0.m1357g(context, "hicloud_campaign_activity_entry_sp", "showSettingFlag", 0);
    }

    /* renamed from: J */
    public boolean m60612J(Context context) {
        return !C13452e.m80781L().m80795D0() && 1 == C0212e0.m1357g(context, "hicloud_campaign_activity_entry_sp", "displayEntryFlag", 0) && m60613K(context);
    }

    /* renamed from: K */
    public boolean m60613K(Context context) {
        return 1 == C0212e0.m1357g(context, "hicloud_campaign_activity_entry_sp", "settingStatus", 0);
    }

    /* renamed from: L */
    public final boolean m60614L() {
        String strM80906e0 = C13452e.m80781L().m80906e0();
        return StringUtil.equals("I", strM80906e0) || StringUtil.equals("W", strM80906e0);
    }

    /* renamed from: M */
    public final boolean m60615M(String str) {
        if (C10028c.m62183d0(C0213f.m1377a()) != null) {
            return !r1.m62388s(str);
        }
        C1442a.m8289e("CampaignManager", "settingMgr is null");
        return true;
    }

    /* renamed from: N */
    public final boolean m60616N(String str, String str2) {
        if (C0214f0.m1382b(C0213f.m1377a(), str, 0) != null) {
            return !r1.getBoolean(str2, false);
        }
        C1442a.m8289e("CampaignManager", "CloudSwitch sp is null");
        return true;
    }

    /* renamed from: O */
    public final boolean m60617O(String str) {
        return "findDevice".equals(str) ? C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe") : "photo".equals(str) || CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str) || HNConstants.DataType.CONTACT.equals(str) || "notepad".equals(str) || "browser".equals(str) || "wlan".equals(str) || SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY.equals(str);
    }

    /* renamed from: P */
    public final boolean m60618P() {
        if (C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe")) {
            return !C1010e.m6125b().m6138d(C0213f.m1377a());
        }
        C1442a.m8291w("CampaignManager", "not support phoneFinder");
        return false;
    }

    /* renamed from: Q */
    public boolean m60619Q(final QuestBean questBean, String[] strArr) {
        KaActivationAttr kaActivation;
        QuestAttributes attributes;
        FutureSwitchAttr futureSwitch;
        String type = questBean.getType();
        if ("calendar_notify".equals(type)) {
            C11839m.m70686d("CampaignManager", "support calendar");
            return true;
        }
        if ("feature_switch".equals(type)) {
            if (!this.f47943e || (attributes = questBean.getAttributes()) == null || (futureSwitch = attributes.getFutureSwitch()) == null) {
                return false;
            }
            String futureTag = futureSwitch.getFutureTag();
            if (strArr == null || !Arrays.stream(strArr).anyMatch(new Predicate() { // from class: fj.c
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C9718g.m60594U(questBean, (String) obj);
                }
            })) {
                return m60602t().m60628h(questBean);
            }
            C11839m.m70686d("CampaignManager", "not need filter" + Arrays.toString(strArr));
            return m60617O(futureTag);
        }
        if ("upload_file".equals(type)) {
            QuestAttributes attributes2 = questBean.getAttributes();
            if (attributes2 == null || attributes2.getUploadFile() == null) {
                return false;
            }
            return m60609G(questBean);
        }
        if ("create_drive_file".equals(type) || "create_drive_folder".equals(type)) {
            C11839m.m70686d("CampaignManager", "support create drive");
            return m60609G(questBean);
        }
        if ("download_app".equals(type)) {
            C11839m.m70686d("CampaignManager", "support download app");
            return true;
        }
        if ("ka_activation".equals(type)) {
            QuestAttributes attributes3 = questBean.getAttributes();
            if (attributes3 == null || (kaActivation = attributes3.getKaActivation()) == null || !m60610H(C0213f.m1377a(), kaActivation.getAppPackage(), kaActivation.getOperator(), kaActivation.getVersion())) {
                return false;
            }
            C11839m.m70686d("CampaignManager", "support ka");
            return true;
        }
        if ("business_pay".equals(type)) {
            C11839m.m70686d("CampaignManager", "support pay");
            return true;
        }
        if ("business_upgrade".equals(type)) {
            C11839m.m70686d("CampaignManager", "support upgrade");
            return true;
        }
        if ("business_sign".equals(type)) {
            C11839m.m70686d("CampaignManager", "support sign");
            return true;
        }
        if ("use_space_optimization".equals(type)) {
            C11839m.m70686d("CampaignManager", "support space optimization");
            return true;
        }
        if ("motivating_video".equals(type)) {
            C11839m.m70686d("CampaignManager", "support video");
            return true;
        }
        if (!"app_activation".equals(type)) {
            return false;
        }
        C11839m.m70686d("CampaignManager", "support app_activation");
        return true;
    }

    /* renamed from: V */
    public void m60620V(Context context, GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        if (getCampaignActivityEntryResp == null || getCampaignActivityEntryResp.getResultCode() != 0) {
            C1442a.m8289e("CampaignManager", "saveCampaignConfig resultCode: " + getCampaignActivityEntryResp.getResultCode());
            return;
        }
        C0212e0.m1368r(context, "hicloud_campaign_activity_entry_sp", "displayEntryFlag", getCampaignActivityEntryResp.getDisplayEntryFlag());
        C0212e0.m1368r(context, "hicloud_campaign_activity_entry_sp", "showSettingFlag", getCampaignActivityEntryResp.getShowSettingFlag());
        C0212e0.m1368r(context, "hicloud_campaign_activity_entry_sp", "settingStatus", getCampaignActivityEntryResp.getSettingStatus());
        C0212e0.m1372v(context, "hicloud_campaign_activity_entry_sp", "activityId", getCampaignActivityEntryResp.getActivityId());
        C0212e0.m1367q(context, "hicloud_campaign_activity_entry_sp", "channels", getCampaignActivityEntryResp.getChannels());
        C0212e0.m1367q(context, "hicloud_campaign_activity_entry_sp", "quests", getCampaignActivityEntryResp.getQuests());
        C0212e0.m1370t(context, "hicloud_campaign_activity_entry_sp", "updateTime", System.currentTimeMillis());
        C0212e0.m1368r(context, "hicloud_campaign_activity_entry_sp", "counter", getCampaignActivityEntryResp.getCounter());
        C0212e0.m1368r(context, "hicloud_campaign_activity_entry_sp", "awardsLimit", getCampaignActivityEntryResp.getAwardsLimit());
        C0212e0.m1365o(context, "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", getCampaignActivityEntryResp.isExceedRedemptionLimit());
    }

    /* renamed from: Y */
    public void m60621Y(List<EntryQuestBean> list) {
        this.f47940b = list;
    }

    /* renamed from: Z */
    public void m60622Z(GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        if (getCampaignActivityEntryResp == null) {
            C11839m.m70688i("CampaignManager", "doActivityEntryUpdate error");
            C13823d.m82904y().m82920d(C0213f.m1377a());
            m60621Y(new ArrayList());
            return;
        }
        if (getCampaignActivityEntryResp.getResultCode() == 0) {
            m60621Y(getCampaignActivityEntryResp.getQuests());
            C11839m.m70688i("CampaignManager", "doActivityEntryUpdate success");
            m60602t().m60620V(C0213f.m1377a(), getCampaignActivityEntryResp);
            if (getCampaignActivityEntryResp.isExceedRedemptionLimit()) {
                C13823d.m82904y().m82919b(C0213f.m1377a());
                return;
            }
            return;
        }
        C11839m.m70688i("CampaignManager", "doActivityEntryUpdate error=" + getCampaignActivityEntryResp.getErrorCode());
        if ("31015040".equals(getCampaignActivityEntryResp.getErrorCode())) {
            C13823d.m82904y().m82919b(C0213f.m1377a());
        } else {
            C13823d.m82904y().m82920d(C0213f.m1377a());
        }
        m60621Y(new ArrayList());
    }

    /* renamed from: a0 */
    public final boolean m60623a0(QuestBean questBean, Quest quest) {
        String id2 = questBean.getId();
        String id3 = quest.getId();
        if (id2 == null || !id2.equals(id3)) {
            return false;
        }
        int defaultValue = quest.getDefaultValue();
        List<RankingValues> rankingValues = quest.getRankingValues();
        if (rankingValues == null || rankingValues.size() <= 0) {
            questBean.setQuotas(new Integer[]{Integer.valueOf(defaultValue)});
            return true;
        }
        LinkedList linkedList = new LinkedList();
        for (int i10 = 0; i10 < rankingValues.size(); i10++) {
            linkedList.add(Integer.valueOf(rankingValues.get(i10).getValue()));
        }
        questBean.setQuotas((Integer[]) linkedList.toArray(new Integer[0]));
        return true;
    }

    /* renamed from: b0 */
    public boolean m60624b0(QuestBean questBean, String str, CampaignActivityRoot campaignActivityRoot) {
        CampaignActivityConfig[] config;
        Quest[] quests;
        if (campaignActivityRoot == null || campaignActivityRoot.getConfig() == null || (config = campaignActivityRoot.getConfig()) == null) {
            return false;
        }
        for (CampaignActivityConfig campaignActivityConfig : config) {
            if (campaignActivityConfig != null && str != null && str.equals(campaignActivityConfig.getId()) && (quests = campaignActivityConfig.getQuests()) != null) {
                for (Quest quest : quests) {
                    if (m60623a0(questBean, quest)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m60625e(QuestBean questBean) {
        try {
            QuestAttributes attributes = questBean.getAttributes();
            if (attributes == null) {
                C1442a.m8289e("CampaignManager", "getAttributes is null");
                return false;
            }
            AdsActivationAttr adsActivation = attributes.getAdsActivation();
            if (adsActivation == null) {
                C1442a.m8289e("CampaignManager", "getDownloadApp is null");
                return false;
            }
            if (!TextUtils.isEmpty(adsActivation.getAdSlotId())) {
                return true;
            }
            C1442a.m8289e("CampaignManager", "checkAdsActivation adSlotId is null");
            return false;
        } catch (Exception e10) {
            C1442a.m8289e("CampaignManager", "checkAdsActivation error:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public final boolean m60626f(QuestBean questBean) {
        if (!C0229n.m1608g(this.f47939a)) {
            C1442a.m8289e("CampaignManager", "checkCalendarNotify no READ_CALENDAR permission");
            return false;
        }
        QuestAttributes attributes = questBean.getAttributes();
        if (attributes == null) {
            C1442a.m8289e("CampaignManager", "getAttributes is null");
            return false;
        }
        CalendarNotifyAttr calendarNotify = attributes.getCalendarNotify();
        if (calendarNotify == null) {
            C1442a.m8289e("CampaignManager", "calendarNotify is null");
            return false;
        }
        CalendarEventBean calendarEventBean = new CalendarEventBean();
        String remDetail = calendarNotify.getRemDetail();
        String strM82966q = C13826g.m82950l().m82966q(remDetail);
        if (TextUtils.isEmpty(strM82966q)) {
            calendarEventBean.setTitle(remDetail);
        } else {
            calendarEventBean.setTitle(strM82966q);
        }
        calendarEventBean.setDescription("");
        return !C13133c.m79000k(C0213f.m1377a(), calendarEventBean);
    }

    /* renamed from: g */
    public final boolean m60627g(QuestBean questBean) {
        try {
            QuestAttributes attributes = questBean.getAttributes();
            if (attributes == null) {
                C1442a.m8289e("CampaignManager", "getAttributes is null");
                return false;
            }
            if (attributes.getDownloadApp() == null) {
                C1442a.m8289e("CampaignManager", "getDownloadApp is null");
                return false;
            }
            DownloadAppAttr downloadApp = attributes.getDownloadApp();
            String adSlotId = downloadApp.getAdSlotId();
            String appSource = downloadApp.getAppSource();
            if (!TextUtils.isEmpty(adSlotId) && !TextUtils.isEmpty(appSource)) {
                return true;
            }
            C1442a.m8289e("CampaignManager", "checkDownloadApp adSlotId or appSource is null");
            return false;
        } catch (Exception e10) {
            C1442a.m8289e("CampaignManager", "checkDownloadApp error:" + e10.getMessage());
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m60628h(com.huawei.hicloud.campaign.bean.QuestBean r8) {
        /*
            r7 = this;
            boolean r0 = p015ak.C0209d.m1166E1()
            java.lang.String r1 = "CampaignManager"
            r2 = 0
            if (r0 != 0) goto Lf
            java.lang.String r7 = "not owner user"
            p054cj.C1442a.m8291w(r1, r7)
            return r2
        Lf:
            com.huawei.hicloud.campaign.bean.QuestAttributes r8 = r8.getAttributes()     // Catch: java.lang.Exception -> L1b
            if (r8 != 0) goto L1e
            java.lang.String r7 = "getAttributes is null"
            p054cj.C1442a.m8289e(r1, r7)     // Catch: java.lang.Exception -> L1b
            return r2
        L1b:
            r7 = move-exception
            goto Lbe
        L1e:
            com.huawei.hicloud.campaign.bean.quest.FutureSwitchAttr r0 = r8.getFutureSwitch()     // Catch: java.lang.Exception -> L1b
            if (r0 != 0) goto L2a
            java.lang.String r7 = "getFutureSwitch is null"
            p054cj.C1442a.m8289e(r1, r7)     // Catch: java.lang.Exception -> L1b
            return r2
        L2a:
            com.huawei.hicloud.campaign.bean.quest.FutureSwitchAttr r8 = r8.getFutureSwitch()     // Catch: java.lang.Exception -> L1b
            java.lang.String r8 = r8.getFutureTag()     // Catch: java.lang.Exception -> L1b
            int r0 = r8.hashCode()     // Catch: java.lang.Exception -> L1b
            java.lang.String r3 = "wlan"
            r4 = 1
            java.lang.String r5 = "browser"
            java.lang.String r6 = "notepad"
            switch(r0) {
                case -1396673086: goto L81;
                case -1039689911: goto L77;
                case -338357905: goto L6d;
                case 3652034: goto L65;
                case 106642994: goto L5b;
                case 150940456: goto L53;
                case 951526432: goto L49;
                case 2129240929: goto L41;
                default: goto L40;
            }
        L40:
            goto L8b
        L41:
            boolean r8 = r8.equals(r6)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = 4
            goto L8c
        L49:
            java.lang.String r0 = "contact"
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = 3
            goto L8c
        L53:
            boolean r8 = r8.equals(r5)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = 2
            goto L8c
        L5b:
            java.lang.String r0 = "photo"
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = r4
            goto L8c
        L65:
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = 5
            goto L8c
        L6d:
            java.lang.String r0 = "findDevice"
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = 6
            goto L8c
        L77:
            java.lang.String r0 = "notify"
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = 7
            goto L8c
        L81:
            java.lang.String r0 = "backup"
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L8b
            r8 = r2
            goto L8c
        L8b:
            r8 = -1
        L8c:
            switch(r8) {
                case 0: goto Lb5;
                case 1: goto Lac;
                case 2: goto La7;
                case 3: goto La0;
                case 4: goto L9b;
                case 5: goto L96;
                case 6: goto L91;
                case 7: goto L90;
                default: goto L8f;
            }     // Catch: java.lang.Exception -> L1b
        L8f:
            return r2
        L90:
            return r4
        L91:
            boolean r7 = r7.m60618P()     // Catch: java.lang.Exception -> L1b
            return r7
        L96:
            boolean r7 = r7.m60615M(r3)     // Catch: java.lang.Exception -> L1b
            return r7
        L9b:
            boolean r7 = r7.m60615M(r6)     // Catch: java.lang.Exception -> L1b
            return r7
        La0:
            java.lang.String r8 = "addressbook"
            boolean r7 = r7.m60615M(r8)     // Catch: java.lang.Exception -> L1b
            return r7
        La7:
            boolean r7 = r7.m60615M(r5)     // Catch: java.lang.Exception -> L1b
            return r7
        Lac:
            java.lang.String r8 = "com.huawei.android.cg.fileshare.SETTING"
            java.lang.String r0 = "SwitchHelperUtilisCloudAlbumOn"
            boolean r7 = r7.m60616N(r8, r0)     // Catch: java.lang.Exception -> L1b
            return r7
        Lb5:
            java.lang.String r8 = "cloudbacksettings"
            java.lang.String r0 = "backup_key"
            boolean r7 = r7.m60616N(r8, r0)     // Catch: java.lang.Exception -> L1b
            return r7
        Lbe:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "checkFeatureSwitch error:"
            r8.append(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            p054cj.C1442a.m8289e(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fj.C9718g.m60628h(com.huawei.hicloud.campaign.bean.QuestBean):boolean");
    }

    /* renamed from: i */
    public final boolean m60629i(QuestBean questBean) {
        try {
            QuestAttributes attributes = questBean.getAttributes();
            if (attributes == null) {
                C1442a.m8289e("CampaignManager", "getAttributes is null");
                return false;
            }
            if (attributes.getKaActivation() == null) {
                C1442a.m8289e("CampaignManager", "getKaActivation is null");
                return false;
            }
            KaActivationAttr kaActivation = attributes.getKaActivation();
            return m60610H(C0213f.m1377a(), kaActivation.getAppPackage(), kaActivation.getOperator(), kaActivation.getVersion());
        } catch (Exception e10) {
            C1442a.m8289e("CampaignManager", "checkFeatureSwitch error:" + e10.getMessage());
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0017 A[ORIG_RETURN, RETURN] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m60630j(int r1, int r2, int r3) {
        /*
            r0 = this;
            r0 = 1
            switch(r1) {
                case 1: goto L14;
                case 2: goto L11;
                case 3: goto Le;
                case 4: goto Lb;
                case 5: goto L8;
                case 6: goto L5;
                default: goto L4;
            }
        L4:
            goto L17
        L5:
            if (r3 == r2) goto L17
            goto L18
        L8:
            if (r3 > r2) goto L17
            goto L18
        Lb:
            if (r3 >= r2) goto L17
            goto L18
        Le:
            if (r3 < r2) goto L17
            goto L18
        L11:
            if (r3 <= r2) goto L17
            goto L18
        L14:
            if (r3 != r2) goto L17
            goto L18
        L17:
            r0 = 0
        L18:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fj.C9718g.m60630j(int, int, int):boolean");
    }

    /* renamed from: k */
    public void m60631k() {
        C11839m.m70688i("CampaignManager", "checkTaskTimeValidity");
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        long taskTimeValidity = hiCloudSysParamMapM60757p != null ? hiCloudSysParamMapM60757p.getTaskTimeValidity() : 0L;
        if (taskTimeValidity > 0) {
            this.f47942d = taskTimeValidity;
        } else {
            this.f47942d = 600000L;
        }
    }

    /* renamed from: l */
    public QuestBean m60632l(String str) {
        return m60633m(str, C13826g.m82950l().m82963k());
    }

    /* renamed from: m */
    public QuestBean m60633m(String str, QuestRoot questRoot) {
        QuestBean[] config;
        if (TextUtils.isEmpty(str) || questRoot == null || questRoot.getConfig() == null || (config = questRoot.getConfig()) == null) {
            return null;
        }
        for (QuestBean questBean : config) {
            if (questBean != null && str.equals(questBean.getId())) {
                return questBean;
            }
        }
        return null;
    }

    /* renamed from: n */
    public String m60634n(int i10) throws IOException {
        JsonArray jsonArray = new JsonArray();
        QuestBean[] questBeanArrM82965p = C13826g.m82950l().m82965p();
        if (questBeanArrM82965p == null) {
            C1442a.m8291w("CampaignManager", "getQuestConfig is null");
            return "";
        }
        C1442a.m8288d("CampaignManager", "getAvailableQuests length: " + questBeanArrM82965p.length);
        for (QuestBean questBean : questBeanArrM82965p) {
            if (questBean == null) {
                C1442a.m8291w("CampaignManager", "questBean is null");
            } else if ("calendar_notify".equals(questBean.getType())) {
                if (m60626f(questBean)) {
                    jsonArray.add(questBean.getId());
                    C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
                }
            } else if ("feature_switch".equals(questBean.getType())) {
                if (m60628h(questBean)) {
                    jsonArray.add(questBean.getId());
                    C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
                }
            } else if ("download_app".equals(questBean.getType())) {
                if (m60627g(questBean)) {
                    jsonArray.add(questBean.getId());
                    C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
                }
            } else if ("ka_activation".equals(questBean.getType())) {
                if (m60629i(questBean)) {
                    jsonArray.add(questBean.getId());
                    C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
                }
            } else if ("upload_file".equals(questBean.getType()) || "create_drive_file".equals(questBean.getType()) || "create_drive_folder".equals(questBean.getType())) {
                if (m60609G(questBean)) {
                    jsonArray.add(questBean.getId());
                    C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
                }
            } else if ("business_pay".equals(questBean.getType()) || "business_upgrade".equals(questBean.getType()) || "business_sign".equals(questBean.getType())) {
                jsonArray.add(questBean.getId());
                C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
            } else if ("use_space_optimization".equals(questBean.getType())) {
                jsonArray.add(questBean.getId());
                C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
            } else if ("motivating_video".equals(questBean.getType())) {
                if (m60625e(questBean)) {
                    jsonArray.add(questBean.getId());
                    C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
                }
            } else if ("app_activation".equals(questBean.getType()) && m60625e(questBean)) {
                jsonArray.add(questBean.getId());
                C1442a.m8288d("CampaignManager", "add: " + questBean.getId());
            }
        }
        if (jsonArray.size() == 0) {
            C1442a.m8291w("CampaignManager", "questListRes is empty");
            return "";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("quests", jsonArray);
        if (i10 > 0) {
            jsonObject.addProperty("purpose", Integer.valueOf(i10));
        }
        return jsonObject.toString();
    }

    /* renamed from: o */
    public List<EntryQuestBean> m60635o() {
        return this.f47940b;
    }

    /* renamed from: p */
    public String m60636p(Context context) {
        return C0212e0.m1363m(context, "hicloud_campaign_activity_entry_sp", "activityId", "");
    }

    /* renamed from: q */
    public int m60637q(Context context, List<EntryQuestBean> list) {
        int iM60642x = 0;
        if (list == null) {
            return 0;
        }
        Iterator<EntryQuestBean> it = list.iterator();
        while (it.hasNext()) {
            iM60642x += m60642x(context, it.next().getId());
        }
        return iM60642x;
    }

    /* renamed from: r */
    public List<EntryQuestBean> m60638r(Context context) {
        List<EntryQuestBean> listM82926j = C13823d.m82904y().m82926j(context);
        if (listM82926j.isEmpty()) {
            return null;
        }
        return (List) listM82926j.stream().filter(new Predicate() { // from class: fj.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9718g.m60591R((EntryQuestBean) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: u */
    public final int m60639u(Quest quest) {
        int defaultValue = quest.getDefaultValue();
        List<RankingValues> rankingValues = quest.getRankingValues();
        if (rankingValues == null || rankingValues.size() <= 0) {
            return defaultValue;
        }
        LinkedList linkedList = new LinkedList();
        for (int i10 = 0; i10 < rankingValues.size(); i10++) {
            linkedList.add(Integer.valueOf(rankingValues.get(i10).getValue()));
        }
        return linkedList.size() > 0 ? ((Integer) linkedList.get(0)).intValue() : defaultValue;
    }

    /* renamed from: v */
    public final int m60640v(String str, String str2, CampaignActivityRoot campaignActivityRoot) {
        CampaignActivityConfig[] config;
        Quest[] quests;
        Quest questM60641w;
        if (str2 == null || campaignActivityRoot == null || campaignActivityRoot.getConfig() == null || (config = campaignActivityRoot.getConfig()) == null) {
            return 0;
        }
        for (CampaignActivityConfig campaignActivityConfig : config) {
            if (campaignActivityConfig != null && str2.equals(campaignActivityConfig.getId()) && (quests = campaignActivityConfig.getQuests()) != null && (questM60641w = m60641w(quests, str)) != null) {
                return m60639u(questM60641w);
            }
        }
        return 0;
    }

    /* renamed from: w */
    public final Quest m60641w(Quest[] questArr, String str) {
        for (Quest quest : questArr) {
            if (str != null && quest != null && str.equals(quest.getId())) {
                return quest;
            }
        }
        return null;
    }

    /* renamed from: x */
    public int m60642x(Context context, String str) throws IOException {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70686d("CampaignManager", "getTaskFragmentNumber error: taskId = " + str);
            return 0;
        }
        Quest[] questArrM82887n = C13821b.m82867w().m82887n(C13823d.m82904y().m82922f(context));
        if (questArrM82887n == null) {
            return 0;
        }
        for (Quest quest : questArrM82887n) {
            if (str.equalsIgnoreCase(quest.getId())) {
                if (quest.getDefaultValue() != 0) {
                    C11839m.m70686d("CampaignManager", "getTaskFragmentNumber taskId : " + str + " ,defaultValue : " + quest.getDefaultValue());
                    return quest.getDefaultValue();
                }
                List<RankingValues> rankingValues = quest.getRankingValues();
                if (quest.getRankingValues() == null || rankingValues.isEmpty()) {
                    C11839m.m70686d("CampaignManager", "getTaskFragmentNumber taskId : " + str + " ,rankingValues is null!");
                    return 0;
                }
                int value = rankingValues.get(0) != null ? rankingValues.get(0).getValue() : 0;
                C11839m.m70686d("CampaignManager", "getTaskFragmentNumber taskId : " + str + " ,taskFragmentNumber ：" + value);
                return value;
            }
        }
        return 0;
    }

    /* renamed from: y */
    public long m60643y() {
        long j10 = this.f47942d;
        if (j10 > 0) {
            return j10;
        }
        return 600000L;
    }

    /* renamed from: z */
    public List<QuestBean> m60644z(Context context, List<EntryQuestBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            list = C13823d.m82904y().m82926j(context);
            C11839m.m70688i("CampaignManager", "getUnfinishedTaskList spQuestList:" + list.size());
        } else {
            C11839m.m70688i("CampaignManager", "getUnfinishedTaskList cacheQuestList:" + list.size());
        }
        if (list.isEmpty()) {
            C11839m.m70688i("CampaignManager", "getUnfinishedTaskList quests is empty");
            return arrayList;
        }
        List<EntryQuestBean> list2 = (List) list.stream().filter(new Predicate() { // from class: fj.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9718g.m60592S((EntryQuestBean) obj);
            }
        }).collect(Collectors.toList());
        if (list2.isEmpty()) {
            C11839m.m70688i("CampaignManager", "getUnfinishedTaskList unfinishedTaskList is empty");
            return arrayList;
        }
        String strM1363m = C0212e0.m1363m(context, "hicloud_campaign_activity_entry_sp", "activityId", "");
        if (TextUtils.isEmpty(strM1363m)) {
            C11839m.m70688i("CampaignManager", "getUnfinishedTaskList activityId is empty");
            return arrayList;
        }
        CampaignActivityRoot campaignActivityRootM82894u = C13821b.m82867w().m82894u();
        if (campaignActivityRootM82894u == null) {
            C11839m.m70688i("CampaignManager", "getUnfinishedTaskList activityRoot is empty");
            return arrayList;
        }
        int iM1357g = C0212e0.m1357g(context, "hicloud_campaign_activity_entry_sp", "awardsLimit", 0);
        int iM1357g2 = C0212e0.m1357g(context, "hicloud_campaign_activity_entry_sp", "counter", 0);
        if (iM1357g <= 0) {
            m60603A(arrayList, list2, strM1363m, campaignActivityRootM82894u);
            return arrayList;
        }
        C11839m.m70688i("CampaignManager", "check awardsLimit");
        ArrayList arrayList2 = new ArrayList();
        int iM60640v = 0;
        for (int i10 = 0; i10 < list2.size(); i10++) {
            EntryQuestBean entryQuestBean = list2.get(i10);
            arrayList2.add(entryQuestBean);
            iM60640v += m60640v(entryQuestBean.getId(), strM1363m, campaignActivityRootM82894u);
            if (iM1357g2 + iM60640v >= iM1357g) {
                break;
            }
        }
        m60603A(arrayList, arrayList2, strM1363m, campaignActivityRootM82894u);
        return arrayList;
    }

    public C9718g() {
        this.f47939a = new String[]{"android.permission.READ_CALENDAR"};
        this.f47940b = new ArrayList();
        this.f47941c = 43200000L;
        m60605C();
        boolean zM1532B = C0224k0.m1532B(C0213f.m1377a());
        this.f47943e = zM1532B;
        C11839m.m70688i("CampaignManager", "isUserOwner: " + zM1532B);
    }
}
