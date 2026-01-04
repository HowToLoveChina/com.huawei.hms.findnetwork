package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardViewData;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.p088ui.uiextend.BackupDeviceView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import p015ak.C0213f;
import p514o9.C11839m;
import p618rm.C12590s0;
import p684un.C13225d;
import p848zl.C14337f;
import p851zp.InterfaceC14359f;

/* loaded from: classes2.dex */
public class BackupCardInfoTransferUtil {
    private static final int ONE = 1;
    private static final String TAG = "BackupCardInfoTransferUtil";
    private static final int TWO = 2;
    private static final Map<Integer, InterfaceC14359f<BackupCardInfo, BackupCardViewData, Context>> SHOW_CARD_STATUS_FUN = Collections.unmodifiableMap(new C27061());
    private static final BiConsumer<Context, Boolean> FULL_ITEM_CLICK = new BiConsumer() { // from class: com.huawei.android.hicloud.cloudbackup.util.a
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            BackupCardInfoTransferUtil.lambda$static$0((Context) obj, (Boolean) obj2);
        }
    };

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.BackupCardInfoTransferUtil$1 */
    public class C27061 extends HashMap<Integer, InterfaceC14359f<BackupCardInfo, BackupCardViewData, Context>> {
        public C27061() {
            put(1, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.b
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) throws Resources.NotFoundException {
                    BackupCardInfoTransferUtil.access$800((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(2, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.c
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) throws Resources.NotFoundException {
                    BackupCardInfoTransferUtil.access$700((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(3, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.d
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) throws Resources.NotFoundException {
                    BackupCardInfoTransferUtil.access$600((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(4, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.e
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) throws Resources.NotFoundException {
                    BackupCardInfoTransferUtil.showBackupOverDay((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(5, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.f
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) throws Resources.NotFoundException {
                    BackupCardInfoTransferUtil.access$400((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(6, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.g
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) {
                    BackupCardInfoTransferUtil.access$300((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(7, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.h
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) {
                    BackupCardInfoTransferUtil.access$200((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(8, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.i
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) {
                    BackupCardInfoTransferUtil.access$100((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
            put(9, new InterfaceC14359f() { // from class: com.huawei.android.hicloud.cloudbackup.util.j
                @Override // p851zp.InterfaceC14359f
                /* renamed from: a */
                public final void mo15453a(Object obj, Object obj2, Object obj3) {
                    BackupCardInfoTransferUtil.access$000((BackupCardInfo) obj, (BackupCardViewData) obj2, (Context) obj3);
                }
            });
        }
    }

    public static /* synthetic */ void access$000(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        showRestoreFailed(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$100(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        showRestoreAllFailed(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$200(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        showRestorePause(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$300(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        showRestoring(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$400(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        showBackupPause(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$600(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        showBacking(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$700(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        showBackupDone(backupCardInfo, backupCardViewData, context);
    }

    public static /* synthetic */ void access$800(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        showBackupClose(backupCardInfo, backupCardViewData, context);
    }

    public static BackupCardViewData cardInfoToViewData(BackupCardInfo backupCardInfo) {
        BackupCardViewData backupCardViewData = new BackupCardViewData();
        Context contextM1377a = C0213f.m1377a();
        backupCardViewData.setSwitchStatus(backupCardInfo.isBackupOpen());
        backupCardViewData.setMainItemClick(FULL_ITEM_CLICK);
        backupCardViewData.setMainItemEnableClick(true);
        backupCardViewData.setShowBackupDevice(false);
        backupCardViewData.setShowArrow(true);
        backupCardViewData.setTitle(contextM1377a.getString(R$string.backup_item_title));
        backupCardViewData.setShowSwitch(false);
        backupCardViewData.setShowContent(false);
        backupCardViewData.setShowBasicBusinessTip(false);
        if (backupCardInfo.getState() == 1) {
            backupCardViewData.setShowContent(true);
        }
        InterfaceC14359f<BackupCardInfo, BackupCardViewData, Context> interfaceC14359f = SHOW_CARD_STATUS_FUN.get(Integer.valueOf(backupCardInfo.getState()));
        if (interfaceC14359f != null) {
            interfaceC14359f.mo15453a(backupCardInfo, backupCardViewData, contextM1377a);
        } else {
            C11839m.m70688i(TAG, "cardInfoToViewData fun is null state: " + backupCardInfo.getState());
        }
        return backupCardViewData;
    }

    private static String getAppName(Context context, String str) {
        String strM75774N = C12590s0.m75774N(context, str, str);
        if (!SplitAppUtil.hasSplitAppSuffix(str)) {
            return strM75774N;
        }
        String splitOriAppId = SplitAppUtil.getSplitOriAppId(str);
        return context.getResources().getString(R$string.refurbish_twin_app, C12590s0.m75774N(context, splitOriAppId, splitOriAppId));
    }

    private static String getRestoreDes(Context context, BackupCardInfo backupCardInfo) {
        int errorCode = backupCardInfo.getErrorCode();
        if (errorCode == 1) {
            return context.getString(R$string.restore_low_power, RestoreUtil.getPauseBattery());
        }
        if (errorCode == 2) {
            return context.getString(R$string.restore_pause_resume_subtitle_new);
        }
        if (errorCode != 3) {
            return null;
        }
        return context.getString(R$string.home_restore_net_disconnet);
    }

    private static void getShowModuleCountContent(BackupCardViewData backupCardViewData, Context context, BackupCardInfo backupCardInfo) throws Resources.NotFoundException {
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setLoadingModule(backupCardInfo.isLoadingModule());
        if (backupCardInfo.isLoadingModule()) {
            return;
        }
        int fullModuleCount = backupCardInfo.getFullModuleCount();
        String fullFirstAppId = backupCardInfo.getFullFirstAppId();
        String fullSecondAppId = backupCardInfo.getFullSecondAppId();
        if (backupCardInfo.isBasicData()) {
            fullModuleCount = backupCardInfo.getBaseModuleCount();
            fullFirstAppId = backupCardInfo.getBaseFirstAppId();
            fullSecondAppId = backupCardInfo.getBaseSecondAppId();
        }
        String quantityString = context.getResources().getQuantityString(R$plurals.backup_card_content_module_data, fullModuleCount, Integer.valueOf(fullModuleCount));
        backupCardViewData.setContent(fullModuleCount > 2 ? context.getString(R$string.backup_card_content_module2, getAppName(context, fullFirstAppId), getAppName(context, fullSecondAppId), quantityString) : fullModuleCount == 2 ? context.getString(R$string.backup_card_content_module1, getAppName(context, fullFirstAppId), getAppName(context, fullSecondAppId), quantityString) : fullModuleCount == 1 ? context.getResources().getQuantityString(R$plurals.sync_and_backup_service_text1, fullModuleCount, getAppName(context, fullFirstAppId), Integer.valueOf(fullModuleCount)) : context.getString(R$string.basic_data_other_backup_content));
    }

    private static boolean isHideOverDayContent(BackupCardInfo backupCardInfo) {
        boolean z10 = backupCardInfo.isBasicData() || backupCardInfo.getFullModuleCount() <= 0 || backupCardInfo.getWaitBackupSize() <= 0;
        if (backupCardInfo.getErrorCode() == 1001 || backupCardInfo.getErrorCode() == 0 || C14337f.f63677c.contains(Integer.valueOf(backupCardInfo.getErrorCode()))) {
            return z10;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Context context, Boolean bool) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C13225d.m79490f1().m79591l0("mecloud_main_click_full_backup", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_main_click_full_backup", linkedHashMap);
        BackupDeviceView.processBackupItemClick(context, false, bool.booleanValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showBacking(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        getShowModuleCountContent(backupCardViewData, context, backupCardInfo);
        backupCardViewData.setSubtitleCarousel(false);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setSubTitle(context.getString(R$string.backing_up));
        backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_complete_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void showBackupClose(com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo r5, com.huawei.android.hicloud.cloudbackup.bean.BackupCardViewData r6, android.content.Context r7) throws android.content.res.Resources.NotFoundException {
        /*
            r0 = 0
            r6.setShowSubTitle(r0)
            boolean r0 = r5.isBasicData()
            if (r0 == 0) goto L26
            android.content.res.Resources r7 = r7.getResources()
            int r0 = com.huawei.android.p073ds.R$plurals.base_backup_close_tip_content
            int r1 = r5.getBaseModuleCount()
            int r5 = r5.getBaseModuleCount()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            java.lang.String r5 = r7.getQuantityString(r0, r1, r5)
            goto Lb4
        L26:
            int r0 = r5.getFullModuleCount()
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.huawei.android.p073ds.R$plurals.backup_card_content_module_data
            int r3 = r5.getFullModuleCount()
            int r4 = r5.getFullModuleCount()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r1 = r1.getQuantityString(r2, r3, r4)
            r2 = 2
            r3 = 0
            if (r0 <= r2) goto L65
            int r0 = com.huawei.android.p073ds.R$string.backup_card_content_module2
            java.lang.String r2 = r5.getFullFirstAppId()
            java.lang.String r2 = getAppName(r7, r2)
            java.lang.String r5 = r5.getFullSecondAppId()
            java.lang.String r5 = getAppName(r7, r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r2, r5, r1}
            java.lang.String r5 = r7.getString(r0, r5)
        L62:
            r0 = r5
            r5 = r3
            goto La8
        L65:
            if (r0 != r2) goto L82
            int r0 = com.huawei.android.p073ds.R$string.backup_card_content_module1
            java.lang.String r2 = r5.getFullFirstAppId()
            java.lang.String r2 = getAppName(r7, r2)
            java.lang.String r5 = r5.getFullSecondAppId()
            java.lang.String r5 = getAppName(r7, r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r2, r5, r1}
            java.lang.String r5 = r7.getString(r0, r5)
            goto L62
        L82:
            r1 = 1
            if (r0 != r1) goto La0
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.huawei.android.p073ds.R$plurals.sync_and_backup_service_text1
            java.lang.String r5 = r5.getFullFirstAppId()
            java.lang.String r5 = getAppName(r7, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r4}
            java.lang.String r5 = r1.getQuantityString(r2, r0, r5)
            goto L62
        La0:
            int r5 = com.huawei.android.p073ds.R$string.open_full_backup_default_tip
            java.lang.String r5 = r7.getString(r5)
            java.lang.String r0 = ""
        La8:
            if (r5 != 0) goto Lb4
            int r5 = com.huawei.android.p073ds.R$string.full_backup_close_all_tip_content
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r5 = r7.getString(r5, r0)
        Lb4:
            r6.setContent(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.util.BackupCardInfoTransferUtil.showBackupClose(com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo, com.huawei.android.hicloud.cloudbackup.bean.BackupCardViewData, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showBackupDone(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        getShowModuleCountContent(backupCardViewData, context, backupCardInfo);
        if (backupCardInfo.getLastSuccessTime() > 0) {
            backupCardViewData.setSubtitleCarousel(true);
            backupCardViewData.setSubTitle(context.getString(R$string.backup_complete));
            backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_complete_text));
            backupCardViewData.setSubTitle2(context.getString(R$string.next_backup_time_item_tip, C12590s0.m75876m0(backupCardInfo.getNextBackupTime(), context)));
            backupCardViewData.setSubTitle2Color(context.getColor(R$color.backup_banner_text));
            return;
        }
        backupCardViewData.setSubtitleCarousel(false);
        if (backupCardInfo.getNextBackupTime() <= 0) {
            backupCardViewData.setShowSubTitle(false);
        } else {
            backupCardViewData.setSubTitle(context.getString(R$string.next_backup_time_item_tip, C12590s0.m75876m0(backupCardInfo.getNextBackupTime(), context)));
            backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_banner_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showBackupOverDay(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        String quantityString;
        backupCardViewData.setSubtitleCarousel(false);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setShowContent(false);
        if (C12590s0.m75881n1(backupCardInfo.getLastSuccessTime())) {
            quantityString = context.getString(R$string.not_backup_morethan_six_months, 6);
        } else {
            int iM75836c0 = C12590s0.m75836c0(backupCardInfo.getLastSuccessTime());
            C11839m.m70688i(TAG, "initOverDays() get days:" + iM75836c0);
            quantityString = context.getResources().getQuantityString(R$plurals.no_backup_for_time, iM75836c0, Integer.valueOf(iM75836c0));
        }
        if (isHideOverDayContent(backupCardInfo)) {
            backupCardViewData.setShowContent(false);
        } else {
            backupCardViewData.setContent(C12590s0.m75888p0(backupCardInfo.getWaitBackupSize(), context, backupCardInfo.getErrorCode()));
        }
        backupCardViewData.setSubTitle(quantityString);
        backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_pause_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showBackupPause(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) throws Resources.NotFoundException {
        backupCardViewData.setSubtitleCarousel(false);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setSubTitle(context.getString(R$string.backup_paused));
        backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_pause_text));
        String strM75802U = C12590s0.m75802U(context, backupCardInfo.getErrorCode());
        if (TextUtils.isEmpty(strM75802U)) {
            getShowModuleCountContent(backupCardViewData, context, backupCardInfo);
        } else {
            backupCardViewData.setContent(strM75802U);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showRestoreAllFailed(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        backupCardViewData.setMainItemEnableClick(true);
        backupCardViewData.setShowContent(false);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setSubtitleCarousel(false);
        backupCardViewData.setSubTitle(context.getString(R$string.restore_failed));
        backupCardViewData.setSubTitleColor(context.getColor(R$color.emui_functional_red));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showRestoreFailed(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        backupCardViewData.setMainItemEnableClick(true);
        backupCardViewData.setShowContent(false);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setSubtitleCarousel(false);
        backupCardViewData.setSubTitle(context.getString(R$string.restore_partial_completed));
        backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_pause_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showRestorePause(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        backupCardViewData.setShowContent(false);
        backupCardViewData.setMainItemEnableClick(true);
        backupCardViewData.setSubtitleCarousel(false);
        String restoreDes = getRestoreDes(context, backupCardInfo);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setSubTitle(context.getString(R$string.restore_new_pause));
        backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_pause_text));
        if (TextUtils.isEmpty(restoreDes)) {
            backupCardViewData.setShowContent(false);
        } else {
            backupCardViewData.setShowContent(false);
            backupCardViewData.setContent(restoreDes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showRestoring(BackupCardInfo backupCardInfo, BackupCardViewData backupCardViewData, Context context) {
        backupCardViewData.setShowContent(false);
        backupCardViewData.setContent(context.getString(R$string.see_details));
        backupCardViewData.setMainItemEnableClick(true);
        backupCardViewData.setSubtitleCarousel(false);
        backupCardViewData.setShowSubTitle(true);
        backupCardViewData.setSubTitle(context.getString(R$string.main_cloudrestoring));
        backupCardViewData.setSubTitleColor(context.getColor(R$color.backup_complete_text));
    }
}
