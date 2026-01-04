package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ba.C1159m;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiextend.V5FrontAppLayout;
import com.huawei.android.hicloud.p088ui.uiextend.V5FrontEntranceLayout;
import com.huawei.android.hicloud.p088ui.uiextend.V5PackageAreaLayout;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.p088ui.uiextend.bean.SecondaryRetentionContent;
import com.huawei.android.hicloud.p088ui.uiextend.bean.V5DailogActivityAreaNeedData;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.hicloud.bean.AppHistoryBean;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.DataItems;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.FrontAppText;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import gp.C10028c;
import hk.C10278a;
import hu.C10342a;
import id.C10470d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import je.C10802p;
import je.C10811y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010a9.C0079a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p258ei.C9494c;
import p292fn.C9733f;
import p336he.C10152c;
import p341hj.C10219d;
import p371ik.C10527a;
import p450le.C11272a;
import p514o9.C11835i;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import p684un.C13225d;
import p709vj.C13452e;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupSpaceInsufficientV5Dialog extends AlertDialogC13154a implements ConfirmRenewAgreementDialog.AgreementDlgCallback {
    private static final int FIRST_BUTTON_INDEX = 0;
    private static final int SECOND_BUTTON_INDEX = 1;
    private static final String TAG = "BackupSpaceInsufficientV5Dialog";
    private static final int THIRD_BUTTON_INDEX = 2;
    private final Activity activity;
    private RelativeLayout activityArea;
    private RelativeLayout appLayout;
    private BackupSpaceInsufficientV5SettingDialog backupSpaceInsufficientV5SettingDialog;
    private Map<String, Bitmap> bitmapMap;
    JSONArray buttonReport;
    private LinearLayout descLayout;
    private TextView dialogTv1;
    LinkedHashMap<String, String> extendReportMap;
    private TextView firstButton;
    private boolean frontAppClickStart;
    private V5FrontAppLayout frontAppLayout;
    private V5FrontEntranceLayout frontEntranceLayout;
    private FrameLayout iconOverlayLayout;
    private int iconSize;
    private boolean isContainDownAppOrCampaginButton;
    private int marginStart;
    private NotEnoughDialogDataV5 notEnoughDialogDataV5;
    private V5PackageAreaLayout packageAreaLayout;
    private String reminderId;
    private RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback;
    private TextView secondButton;
    private SecondaryRetentionDialog secondaryRetentionDialog;
    private TextView thirdButton;
    private TextView title;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog$1 */
    public class C41821 extends AbstractC12367d {
        final /* synthetic */ NotEnoughDialogDataV5.DialogMainShowContentV5 val$dialogMainShowContentV5;

        public C41821(NotEnoughDialogDataV5.DialogMainShowContentV5 dialogMainShowContentV5) {
            this.val$dialogMainShowContentV5 = dialogMainShowContentV5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$call$0(DataItems dataItems) {
            return !TextUtils.isEmpty(dataItems.getDesc());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$1(int i10, String str, DataItems dataItems) {
            BackupSpaceInsufficientV5Dialog.this.initIcon(i10, str);
            BackupSpaceInsufficientV5Dialog.this.initDesc(dataItems.getDesc());
            if (BackupSpaceInsufficientV5Dialog.this.appLayout != null) {
                BackupSpaceInsufficientV5Dialog.this.appLayout.setVisibility(0);
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Bitmap bitmapM1311u;
            List<DataItems> dataItemsList = this.val$dialogMainShowContentV5.getDataItemsList();
            BackupSpaceInsufficientV5Dialog.this.extendReportMap.put("isShwowDataItem", String.valueOf(false));
            if (dataItemsList == null || dataItemsList.isEmpty()) {
                return;
            }
            BackupSpaceInsufficientV5Dialog.this.reportDataItemNotDesc(dataItemsList);
            ArrayList arrayList = new ArrayList();
            List list = (List) dataItemsList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.h
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupSpaceInsufficientV5Dialog.C41821.lambda$call$0((DataItems) obj);
                }
            }).collect(Collectors.toList());
            for (int i10 = 0; i10 < list.size(); i10++) {
                final DataItems dataItems = (DataItems) list.get(i10);
                if (dataItems != null && !TextUtils.isEmpty(dataItems.getDesc())) {
                    CommonPicture icon = dataItems.getIcon();
                    if (icon == null) {
                        BackupSpaceInsufficientV5Dialog.this.extendReportMap.put("dataItemAppsErrorDesc" + i10, dataItems.getBundleName() + " : CommonPicture is null");
                    } else {
                        final String bundleName = dataItems.getBundleName();
                        if (C14333b.m85483r().containsKey(bundleName)) {
                            Context context = BackupSpaceInsufficientV5Dialog.this.getContext();
                            if (context != null) {
                                try {
                                    bitmapM1311u = BitmapFactory.decodeResource(context.getResources(), C14333b.m85483r().get(bundleName).intValue());
                                } catch (Exception e10) {
                                    C11839m.m70687e(BackupSpaceInsufficientV5Dialog.TAG, "initAppLayout BitmapFactory.decodeResource err： " + e10.getMessage());
                                    bitmapM1311u = null;
                                }
                            }
                        } else {
                            String url = icon.getUrl();
                            String iconPath = TextUtils.isEmpty(url) ? BackupSpaceInsuffNoticeV5Manager.getInstance().getIconPath(bundleName) : BackupSpaceInsuffNoticeV5Manager.getInstance().getIconPath(url);
                            if (C11835i.m70650n(C10278a.m63442h(iconPath))) {
                                bitmapM1311u = C0209d.m1311u(iconPath);
                            } else {
                                bitmapM1311u = C0209d.m1311u(BackupSpaceInsuffNoticeV5Manager.getInstance().getPicturePath(icon.getUrl()));
                                C11839m.m70688i(BackupSpaceInsufficientV5Dialog.TAG, "bitmap " + bitmapM1311u + " bundleName ");
                            }
                        }
                        if (bitmapM1311u == null) {
                            C11839m.m70688i(BackupSpaceInsufficientV5Dialog.TAG, "bitmap  is null");
                            BackupSpaceInsufficientV5Dialog.this.extendReportMap.put("dataItemAppsErrorDesc" + i10, dataItems.getBundleName() + " : bitmap is null");
                        } else {
                            BackupSpaceInsufficientV5Dialog.this.bitmapMap.put(bundleName, bitmapM1311u);
                            arrayList.add(bundleName);
                            final int size = (BackupSpaceInsufficientV5Dialog.this.bitmapMap.size() - 1) * BackupSpaceInsufficientV5Dialog.this.marginStart;
                            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f19220a.lambda$call$1(size, bundleName, dataItems);
                                }
                            });
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            BackupSpaceInsufficientV5Dialog.this.extendReportMap.put("isShwowDataItem", String.valueOf(true));
            BackupSpaceInsufficientV5Dialog.this.extendReportMap.put("dataItemApps", arrayList.toString());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog$2 */
    public class C41832 extends AbstractC12367d {
        public C41832() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            BackupSpaceInsufficientV5Dialog.super.show();
            String str = BackupSpaceInsufficientV5Dialog.this.reminderId;
            BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog = BackupSpaceInsufficientV5Dialog.this;
            C10811y.m65824h(true, str, backupSpaceInsufficientV5Dialog.buttonReport, backupSpaceInsufficientV5Dialog.extendReportMap);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            int iInitActivityArea = BackupSpaceInsufficientV5Dialog.this.initActivityArea();
            if (iInitActivityArea != 3) {
                BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog = BackupSpaceInsufficientV5Dialog.this;
                backupSpaceInsufficientV5Dialog.initButton(backupSpaceInsufficientV5Dialog.firstButton, BackupSpaceInsufficientV5Dialog.this.notEnoughDialogDataV5.getV5DialogMainShowContent().getButton(0));
            } else {
                BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog2 = BackupSpaceInsufficientV5Dialog.this;
                backupSpaceInsufficientV5Dialog2.initFirstButtonForPay(backupSpaceInsufficientV5Dialog2.firstButton);
            }
            BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog3 = BackupSpaceInsufficientV5Dialog.this;
            backupSpaceInsufficientV5Dialog3.initButton(backupSpaceInsufficientV5Dialog3.secondButton, BackupSpaceInsufficientV5Dialog.this.notEnoughDialogDataV5.getV5DialogMainShowContent().getButton(1));
            BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog4 = BackupSpaceInsufficientV5Dialog.this;
            backupSpaceInsufficientV5Dialog4.initButton(backupSpaceInsufficientV5Dialog4.thirdButton, BackupSpaceInsufficientV5Dialog.this.notEnoughDialogDataV5.getV5DialogMainShowContent().getButton(2));
            BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog5 = BackupSpaceInsufficientV5Dialog.this;
            backupSpaceInsufficientV5Dialog5.checkIsContainDownAppOrCampaginButton(backupSpaceInsufficientV5Dialog5.notEnoughDialogDataV5.getV5DialogMainShowContent(), iInitActivityArea);
            C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19225a.lambda$call$0();
                }
            });
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BackupSpaceInsufficientV5Dialog.this.onDialogCancel();
        }
    }

    public BackupSpaceInsufficientV5Dialog(Activity activity, NotEnoughDialogDataV5 notEnoughDialogDataV5, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        super(activity);
        this.frontAppClickStart = false;
        this.isContainDownAppOrCampaginButton = false;
        this.bitmapMap = new HashMap();
        this.buttonReport = new JSONArray();
        this.extendReportMap = new LinkedHashMap<>();
        this.activity = activity;
        this.notEnoughDialogDataV5 = notEnoughDialogDataV5;
        this.renewAgreementTVCallback = renewAgreementTVCallback;
        this.iconSize = C11842p.m70840n(getContext(), 40);
        this.marginStart = C11842p.m70840n(getContext(), 24);
        setCanceledOnTouchOutside(false);
        initView();
        initData();
    }

    private void afterClick() {
        clearBackupNotification();
        processRemoveTask();
        if (isShowing()) {
            dismiss();
        }
    }

    private RecommendNeedData buildNewData(RecommendNeedData recommendNeedData) {
        RecommendNeedData recommendNeedData2 = new RecommendNeedData();
        recommendNeedData2.setV5BackupNotEnoughDialog(recommendNeedData.isV5BackupNotEnoughDialog());
        recommendNeedData2.setBackupNeedSpace(recommendNeedData.getBackupNeedSpace());
        recommendNeedData2.setActivityType(recommendNeedData.getActivityType());
        recommendNeedData2.setId(recommendNeedData.getId());
        recommendNeedData2.setRecommendType(recommendNeedData.getRecommendType());
        recommendNeedData2.setEnterType(1);
        recommendNeedData2.setTotalNeedSpace(recommendNeedData.getTotalNeedSpace());
        recommendNeedData2.setNotUsedSpace(recommendNeedData.getNotUsedSpace());
        recommendNeedData2.setGalleryNum(recommendNeedData.getGalleryNum());
        recommendNeedData2.setActivityWithTaskCenter(recommendNeedData.isActivityWithTaskCenter());
        recommendNeedData2.setDetailGotoBeanList(recommendNeedData.getDetailGotoBeanList());
        recommendNeedData2.setTitle(recommendNeedData.getTitle());
        recommendNeedData2.setMainText(recommendNeedData.getMainText());
        recommendNeedData2.setSubTitle(recommendNeedData.getSubTitle());
        recommendNeedData2.setSecondMainText(recommendNeedData.getSecondMainText());
        return recommendNeedData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buttonClick, reason: merged with bridge method [inline-methods] */
    public void lambda$initButton$1(View view, NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5, RecommendNeedData recommendNeedData) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (view.getId() == R$id.space_not_enough_treble_dialog_button_1) {
            jumpPage(dialogButtonV5, "1", 0, recommendNeedData);
        }
        if (view.getId() == R$id.space_not_enough_treble_dialog_button_2) {
            jumpPage(dialogButtonV5, "2", 1, recommendNeedData);
        }
        if (view.getId() == R$id.space_not_enough_treble_dialog_button_3) {
            jumpPage(dialogButtonV5, "4", 2, recommendNeedData);
        }
        afterClick();
    }

    private int checkFrontAppStyle(V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData, long j10) {
        C1159m c1159mM59428x = C9494c.m59390r().m59428x(j10);
        if (c1159mM59428x.m7242g() == 7017) {
            ActivityEntry activityEntry = v5DailogActivityAreaNeedData.getActivityEntry();
            if (activityEntry != null) {
                activityEntry.setResource(c1159mM59428x.m7241f());
            }
            C11839m.m70688i(TAG, "checkFrontAppStyle SHOW_FRONT_APP.");
            return 1;
        }
        if (c1159mM59428x.m7242g() == 7018) {
            C11839m.m70688i(TAG, "checkFrontAppStyle SHOW_FRONT_ENTRANCE.");
            return 2;
        }
        if (v5DailogActivityAreaNeedData.getEnableRecomPackages() == 1) {
            C11839m.m70688i(TAG, "checkFrontAppStyle SHOW_PACKAGE_AREA.");
            return 3;
        }
        C11839m.m70688i(TAG, "checkFrontAppStyle TYPE_NONE.");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsContainDownAppOrCampaginButton(NotEnoughDialogDataV5.DialogMainShowContentV5 dialogMainShowContentV5, int i10) throws JSONException {
        List<NotEnoughDialogDataV5.DialogButtonV5> buttonList = dialogMainShowContentV5.getButtonList();
        if (buttonList == null || buttonList.size() == 0) {
            return;
        }
        for (int i11 = 0; i11 < buttonList.size(); i11++) {
            try {
                NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5 = buttonList.get(i11);
                if (NotifyConstants.TYPE_DLAPP_AND_ACYIVE.equals(dialogButtonV5.getButtonType())) {
                    if (i11 == 0 && i10 == 3) {
                        this.isContainDownAppOrCampaginButton = false;
                    } else {
                        this.isContainDownAppOrCampaginButton = true;
                    }
                }
                NotEnoughDialogDataV5.DialogGoto buttonGoto = dialogButtonV5.getButtonGoto();
                if (buttonGoto != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (i11 == 0 && i10 == 3) {
                        jSONObject.put("index", String.valueOf(i11));
                        jSONObject.put("popupType", "dialogBuyButton");
                        jSONObject.put("popupUri", buttonGoto.getPopupUri());
                    } else {
                        jSONObject.put("index", String.valueOf(i11));
                        jSONObject.put("popupType", buttonGoto.getPopupType());
                        jSONObject.put("popupUri", buttonGoto.getPopupUri());
                    }
                    this.buttonReport.put(jSONObject);
                }
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "checkIsContainDownAppOrCampaginButton error " + e10.toString());
                return;
            }
        }
    }

    private boolean checkRetentionContentInvalid(SecondaryRetentionContent secondaryRetentionContent) {
        return secondaryRetentionContent == null || TextUtils.isEmpty(secondaryRetentionContent.getMessage()) || TextUtils.isEmpty(secondaryRetentionContent.getTitle()) || TextUtils.isEmpty(secondaryRetentionContent.getNegativeText()) || TextUtils.isEmpty(secondaryRetentionContent.getPositiveText());
    }

    private void clearBackupNotification() {
        new BackupNotificationManager(C0213f.m1377a()).cancelNotify(775);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickPayBtn() {
        V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData;
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, CloudSpaceUpgradeActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        intent.putExtra("from_where", 21);
        NotEnoughDialogDataV5 notEnoughDialogDataV5 = this.notEnoughDialogDataV5;
        if (notEnoughDialogDataV5 != null && (v5DailogActivityAreaNeedData = notEnoughDialogDataV5.getV5DailogActivityAreaNeedData()) != null) {
            intent.putExtra("backup_dialog_recommend_info", v5DailogActivityAreaNeedData.getRecommendPackageInfo());
        }
        C0216g0.m1402e(context).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG_V5");
        context.startActivity(intent);
        dismiss();
        finish();
        C10152c.m63217a();
    }

    private String getButtonReport(int i10) {
        try {
            return i10 >= this.buttonReport.length() ? "" : this.buttonReport.getString(i10);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getButtonReport error: " + e10.toString());
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getShowType(com.huawei.android.hicloud.p088ui.uiextend.bean.V5DailogActivityAreaNeedData r8, long r9) {
        /*
            r7 = this;
            com.huawei.android.hicloud.ui.uiextend.bean.NotEnoughDialogDataV5 r0 = r7.notEnoughDialogDataV5
            int r0 = r0.getActivityType()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getShowType activityType = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "BackupSpaceInsufficientV5Dialog"
            p514o9.C11839m.m70688i(r2, r1)
            r1 = 3
            java.lang.String r3 = "getShowType SHOW_PACKAGE_AREA"
            r4 = 2
            r5 = 0
            r6 = 1
            if (r0 != r6) goto L55
            int r0 = r8.getEnableFrontApp()
            if (r0 != r6) goto L4b
            java.lang.String r0 = r8.getFrontAppStyle()
            java.lang.String r1 = "entry"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L3d
            java.lang.String r7 = "getShowType SHOW_FRONT_ENTRANCE"
            p514o9.C11839m.m70688i(r2, r7)
            r1 = r4
            goto L6c
        L3d:
            java.lang.String r1 = "app"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            int r7 = r7.checkFrontAppStyle(r8, r9)
            r1 = r7
            goto L6c
        L4b:
            int r7 = r8.getEnableRecomPackages()
            if (r7 != r6) goto L6b
            p514o9.C11839m.m70688i(r2, r3)
            goto L6c
        L55:
            if (r0 == 0) goto L61
            if (r0 != r4) goto L5a
            goto L61
        L5a:
            java.lang.String r7 = "getShowType INVALID"
            p514o9.C11839m.m70688i(r2, r7)
            r1 = -1
            goto L6c
        L61:
            int r7 = r8.getEnableRecomPackages()
            if (r7 != r6) goto L6b
            p514o9.C11839m.m70688i(r2, r3)
            goto L6c
        L6b:
            r1 = r5
        L6c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getShowType showType = "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            p514o9.C11839m.m70688i(r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog.getShowType(com.huawei.android.hicloud.ui.uiextend.bean.V5DailogActivityAreaNeedData, long):int");
    }

    private String getTextFromDB(String str) {
        if (!TextUtils.isEmpty(str)) {
            return BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(str);
        }
        C11839m.m70687e(TAG, "getTextFromDB id is null.");
        return "";
    }

    private String getUpdateBtnText(boolean z10) {
        Context context = getContext();
        return context == null ? "" : C13452e.m80781L().m80887a1() ? z10 ? context.getString(R$string.change_plan) : context.getString(R$string.cloudpay_subscribe_now) : context.getString(R$string.upgrade_now);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int initActivityArea() {
        C11839m.m70688i(TAG, "initActivityArea");
        NotEnoughDialogDataV5 notEnoughDialogDataV5 = this.notEnoughDialogDataV5;
        if (notEnoughDialogDataV5 == null) {
            C11839m.m70687e(TAG, "initActivityArea, notEnoughDialogDataV5 is null.");
            this.extendReportMap.put("activity_show_type", String.valueOf(0));
            return 0;
        }
        BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData = notEnoughDialogDataV5.getBackupSpaceNotEnoughNeedData();
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "initActivityArea, backupSpaceNotEnoughNeedData is null.");
            this.extendReportMap.put("activity_show_type", String.valueOf(0));
            return 0;
        }
        V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData = this.notEnoughDialogDataV5.getV5DailogActivityAreaNeedData();
        if (v5DailogActivityAreaNeedData == null) {
            C11839m.m70687e(TAG, "initActivityArea v5DailogActivityAreaNeedData is null.");
            this.extendReportMap.put("activity_show_type", String.valueOf(0));
            return 0;
        }
        int showType = getShowType(v5DailogActivityAreaNeedData, backupSpaceNotEnoughNeedData.getTotalNeedSpace());
        this.extendReportMap.put("activity_show_type", String.valueOf(showType));
        if (showType == 0) {
            this.activityArea.setVisibility(8);
            return showType;
        }
        if (showType == 1) {
            C9494c.m59390r().m59412Z(true);
            return showFrontApp(v5DailogActivityAreaNeedData);
        }
        if (showType == 2) {
            C9494c.m59390r().m59412Z(true);
            return showFrontEntrance(v5DailogActivityAreaNeedData);
        }
        if (showType == 3) {
            return showPackageArea(v5DailogActivityAreaNeedData);
        }
        C11839m.m70687e(TAG, "invalid showType = " + showType);
        finish();
        return showType;
    }

    private void initAppLayout(NotEnoughDialogDataV5.DialogMainShowContentV5 dialogMainShowContentV5) {
        C12515a.m75110o().m75172d(new C41821(dialogMainShowContentV5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initButton(TextView textView, final NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5) {
        if (textView == null) {
            C11839m.m70689w(TAG, "initButton button is null");
            return;
        }
        if (dialogButtonV5 == null) {
            C11839m.m70689w(TAG, "initButton button data is null");
            textView.setVisibility(8);
            return;
        }
        V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData = this.notEnoughDialogDataV5.getV5DailogActivityAreaNeedData();
        String popupType = dialogButtonV5.getButtonGoto().getPopupType();
        RecommendNeedData recommendNeedDataBuildDetailText = BackupNotificationV5Util.buildDetailText(v5DailogActivityAreaNeedData.getRecommendNeedData(), popupType, v5DailogActivityAreaNeedData.getDetailPage());
        textView.setText(dialogButtonV5.getButtonContent());
        if (recommendNeedDataBuildDetailText == null) {
            textView.setVisibility(8);
            C11839m.m70687e(TAG, "initButton recommendNeedData is null.");
            return;
        }
        final RecommendNeedData recommendNeedDataBuildNewData = buildNewData(recommendNeedDataBuildDetailText);
        if ("close".equals(popupType)) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19214a.lambda$initButton$0(view);
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19216a.lambda$initButton$1(dialogButtonV5, recommendNeedDataBuildNewData, view);
                }
            });
        }
    }

    private void initData() {
        C11839m.m70688i(TAG, "initData");
        NotEnoughDialogDataV5.DialogMainShowContentV5 v5DialogMainShowContent = this.notEnoughDialogDataV5.getV5DialogMainShowContent();
        this.extendReportMap.put("v5_dialog_version_key", InterfaceC5323b.f24693t);
        this.extendReportMap.put("dialog_user_type", String.valueOf(this.notEnoughDialogDataV5.getActivityType()));
        this.title.setText(v5DialogMainShowContent.getTitle());
        this.dialogTv1.setText(v5DialogMainShowContent.getContent());
        this.reminderId = v5DialogMainShowContent.getReminderId();
        if (v5DialogMainShowContent.isEnableDataItem()) {
            initAppLayout(v5DialogMainShowContent);
        } else {
            this.extendReportMap.put("isShwowDataItem", String.valueOf(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDesc(String str) {
        TextView textView = new TextView(getContext());
        textView.setTypeface(Typeface.create("HwChinese-regular", 0));
        textView.setTextColor(getContext().getColor(R$color.emui_color_text_primary));
        if (C0209d.m1195O(getContext()) >= 1.75f) {
            textView.setTextSize(0, C11842p.m70840n(getContext(), 28));
        } else {
            textView.setTextSize(2, 14.0f);
        }
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setText(str);
        LinearLayout linearLayout = this.descLayout;
        if (linearLayout != null) {
            linearLayout.addView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFirstButtonForPay(TextView textView) {
        NotEnoughDialogDataV5 notEnoughDialogDataV5 = this.notEnoughDialogDataV5;
        if (notEnoughDialogDataV5 == null) {
            C11839m.m70687e(TAG, "initFirstButtonForPay notEnoughDialogDataV5 is null.");
            return;
        }
        final V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData = notEnoughDialogDataV5.getV5DailogActivityAreaNeedData();
        if (v5DailogActivityAreaNeedData == null) {
            C11839m.m70687e(TAG, "initFirstButtonForPay v5DailogActivityAreaNeedData is null.");
            return;
        }
        GetPackagesBySpaceRuleResp recommendPackageInfo = v5DailogActivityAreaNeedData.getRecommendPackageInfo();
        if (recommendPackageInfo == null) {
            C11839m.m70687e(TAG, "initFirstButtonForPay getPackagesBySpaceRuleResp is null.");
            return;
        }
        List<CloudPackage> spacePackages = recommendPackageInfo.getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            C11839m.m70687e(TAG, "initFirstButtonForPay getPackagesBySpaceRuleResp is null.");
            return;
        }
        HashMap<String, String> extendTagMap = spacePackages.get(0).getExtendTagMap();
        if (extendTagMap != null) {
            String str = extendTagMap.get("backupPop_buttonName");
            if (TextUtils.isEmpty(str)) {
                textView.setText(getUpdateBtnText(v5DailogActivityAreaNeedData.isAutoPay()));
            } else {
                textView.setText(str);
            }
        } else {
            textView.setText(getUpdateBtnText(v5DailogActivityAreaNeedData.isAutoPay()));
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BackupSpaceInsufficientV5Dialog.this.packageAreaLayout == null) {
                    C11839m.m70687e(BackupSpaceInsufficientV5Dialog.TAG, "PackageBtnClickListener, packageAreaLayout is null.");
                    return;
                }
                if (!BackupSpaceInsufficientV5Dialog.this.packageAreaLayout.isShowRenewAgreementArea() || BackupSpaceInsufficientV5Dialog.this.packageAreaLayout.isV5CheckStatus()) {
                    BackupSpaceInsufficientV5Dialog.this.clickPayBtn();
                    return;
                }
                C0079a c0079a = new C0079a();
                c0079a.m651h(BackupSpaceInsufficientV5Dialog.this);
                c0079a.m652i(v5DailogActivityAreaNeedData.getClientUIConfigResp().getCheckDialogRenewAgreement());
                c0079a.m654k(BackupSpaceInsufficientV5Dialog.this.renewAgreementTVCallback);
                ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(BackupSpaceInsufficientV5Dialog.this.activity, c0079a);
                confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
                confirmRenewAgreementDialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initIcon(int i10, String str) {
        ImageView imageView = new ImageView(getContext());
        int i11 = this.iconSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i11);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(this.bitmapMap.get(str));
        layoutParams.setMarginStart(i10);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout frameLayout = this.iconOverlayLayout;
        if (frameLayout != null) {
            frameLayout.addView(imageView);
        }
    }

    private void initView() {
        setOnCancelListener(new DialogOnCancelListener());
        float fM1195O = C0209d.m1195O(C0213f.m1377a());
        View viewInflate = fM1195O > 1.75f ? LayoutInflater.from(this.activity).inflate(R$layout.space_not_enough_v5_dialog_big, (ViewGroup) null) : fM1195O > 1.0f ? LayoutInflater.from(this.activity).inflate(R$layout.space_not_enough_v5_dialog_2, (ViewGroup) null) : LayoutInflater.from(this.activity).inflate(R$layout.space_not_enough_v5_dialog, (ViewGroup) null);
        this.title = (TextView) C12809f.m76831d(viewInflate, R$id.title);
        this.dialogTv1 = (TextView) C12809f.m76831d(viewInflate, R$id.space_not_enough_dialog_text_1);
        this.activityArea = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.v5_activity_area);
        this.frontAppLayout = (V5FrontAppLayout) C12809f.m76831d(viewInflate, R$id.v5_front_app_area);
        this.frontEntranceLayout = (V5FrontEntranceLayout) C12809f.m76831d(viewInflate, R$id.v5_front_entrance_area);
        this.packageAreaLayout = (V5PackageAreaLayout) C12809f.m76831d(viewInflate, R$id.v5_package_area);
        this.firstButton = (TextView) C12809f.m76831d(viewInflate, R$id.space_not_enough_treble_dialog_button_1);
        this.secondButton = (TextView) C12809f.m76831d(viewInflate, R$id.space_not_enough_treble_dialog_button_2);
        this.thirdButton = (TextView) C12809f.m76831d(viewInflate, R$id.space_not_enough_treble_dialog_button_3);
        this.appLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.app_layout);
        this.iconOverlayLayout = (FrameLayout) C12809f.m76831d(viewInflate, R$id.app_icon_layout);
        this.descLayout = (LinearLayout) C12809f.m76831d(viewInflate, R$id.desc_layout);
        setView(viewInflate);
    }

    private void jumpPage(NotEnoughDialogDataV5.DialogButtonV5 dialogButtonV5, String str, int i10, RecommendNeedData recommendNeedData) {
        C11839m.m70688i(TAG, "jumpPage buttoun Click, isButtonFirst: " + str);
        if (dialogButtonV5 == null) {
            C11839m.m70689w(TAG, "jumpPage click dialogButtonV5 is null");
            return;
        }
        NotEnoughDialogDataV5.DialogGoto buttonGoto = dialogButtonV5.getButtonGoto();
        if (buttonGoto == null) {
            C11839m.m70689w(TAG, "jumpPage click buttonGoto is null");
            return;
        }
        C10811y.m65823g(str, buttonGoto.getPopupUri(), "1", getButtonReport(i10), this.buttonReport.length(), this.extendReportMap);
        if (buttonGoto.getPopupType().equals("application") && buttonGoto.getPopupUri().equals(NotifyConstants.CLOSE_BACKUP_REMIND)) {
            showNoRemindDialog();
            return;
        }
        C11839m.m70688i(TAG, "begin jumpPage, PopupType: " + buttonGoto.getPopupType() + "PopupUri:" + buttonGoto.getPopupUri());
        Intent intentM65746a = C10802p.m65746a(this.activity, buttonGoto.getPopupType(), buttonGoto.getPopupUri());
        String popupType = buttonGoto.getPopupType();
        if (this.notEnoughDialogDataV5 == null || !("detail".equals(popupType) || NotifyConstants.DETAIL2.equals(popupType) || NotifyConstants.DETAIL3.equals(popupType))) {
            if (buttonGoto.getPopupType().equals("application") && buttonGoto.getPopupUri().equals(NotifyConstants.BUY_MORE)) {
                intentM65746a.putExtra("is_total_space_scene", true);
                intentM65746a.putExtra("total_space_needed", recommendNeedData.getTotalNeedSpace());
            }
        } else if (this.notEnoughDialogDataV5.getV5DailogActivityAreaNeedData() != null) {
            intentM65746a.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        }
        C0216g0.m1402e(getContext()).m1407E(intentM65746a, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG_V5");
        C10342a.m63676b(this.activity, intentM65746a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initButton$0(View view) {
        onDialogCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFrontApp$2(AppStatus appStatus) {
        AppStatus appStatus2 = AppStatus.DOWNLOADING;
        if (appStatus2.equals(this.frontAppLayout.getAppStatus()) || !appStatus2.equals(appStatus)) {
            return;
        }
        C11839m.m70686d(TAG, "start download");
        this.frontAppClickStart = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFrontApp$3(AppInfo appInfo) {
        this.frontAppClickStart = false;
    }

    private void processRemoveTask() {
        ScreenListener.m18023c(this.activity).m18028g();
        C10470d.m64355p(this.activity).m64349m(true);
        C10470d.m64355p(this.activity).cancel();
        C12515a.m75110o().m75165a1(C10470d.m64355p(this.activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDataItemNotDesc(List<DataItems> list) {
        LinkedHashMap<String, String> linkedHashMap;
        if (list == null) {
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            DataItems dataItems = list.get(i10);
            if (dataItems != null && TextUtils.isEmpty(dataItems.getDesc()) && !TextUtils.isEmpty(dataItems.getErrorDesc()) && (linkedHashMap = this.extendReportMap) != null) {
                linkedHashMap.put("dataItemAppsErrorDesc" + i10, dataItems.getBundleName() + " : " + dataItems.getErrorDesc());
            }
        }
    }

    private int showFrontApp(V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData) {
        FrontAppText frontAppText = v5DailogActivityAreaNeedData.getFrontAppText();
        if (frontAppText == null) {
            C11839m.m70687e(TAG, "showFrontApp frontAppText is null");
            return 0;
        }
        String frontappSingleTitle = frontAppText.getFrontappSingleTitle();
        if (TextUtils.isEmpty(frontappSingleTitle)) {
            C11839m.m70687e(TAG, "showFrontApp stringId is null");
            return 0;
        }
        String stringFromDB = BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(frontappSingleTitle);
        if (TextUtils.isEmpty(stringFromDB)) {
            C11839m.m70687e(TAG, "showFrontApp title is null");
            return 0;
        }
        if (!this.frontAppLayout.init(C9494c.m59390r().m59424t(), stringFromDB)) {
            return 0;
        }
        this.activityArea.setVisibility(0);
        C9494c.m59390r().m59397J();
        this.frontAppLayout.setVisibility(0);
        this.frontAppLayout.setV5StatusChangeListener(new V5FrontAppLayout.StatusChangeListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.d
            @Override // com.huawei.android.hicloud.ui.uiextend.V5FrontAppLayout.StatusChangeListener
            public final void onStatusChanged(AppStatus appStatus) {
                this.f19210a.lambda$showFrontApp$2(appStatus);
            }
        });
        this.frontAppLayout.setV5UserCancelListener(new V5FrontAppLayout.UserCancelListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.e
            @Override // com.huawei.android.hicloud.ui.uiextend.V5FrontAppLayout.UserCancelListener
            public final void onUserCancel(AppInfo appInfo) {
                this.f19212a.lambda$showFrontApp$3(appInfo);
            }
        });
        upToAppCenter();
        return 2;
    }

    private int showFrontEntrance(final V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData) {
        FrontAppText frontAppText = v5DailogActivityAreaNeedData.getFrontAppText();
        if (frontAppText == null) {
            C11839m.m70687e(TAG, "showFrontEntrance frontAppText is null");
            return 0;
        }
        String textFromDB = getTextFromDB(frontAppText.getFrontappEntranceTitle());
        String textFromDB2 = getTextFromDB(frontAppText.getFrontappEntranceText());
        String textFromDB3 = getTextFromDB(frontAppText.getFrontappEntranceTextSecond());
        String textFromDB4 = getTextFromDB(frontAppText.getFrontappEntranceButton());
        if (TextUtils.isEmpty(textFromDB)) {
            C11839m.m70687e(TAG, "showFrontEntrance frontEntrancePrizeText is null");
            return 0;
        }
        if (TextUtils.isEmpty(textFromDB2)) {
            C11839m.m70687e(TAG, "showFrontEntrance frontEntranceText is null");
            return 0;
        }
        if (TextUtils.isEmpty(textFromDB3)) {
            C11839m.m70687e(TAG, "showFrontEntrance frontEntranceDescText is null");
            return 0;
        }
        if (TextUtils.isEmpty(textFromDB4)) {
            C11839m.m70687e(TAG, "showFrontEntrance frontEntranceBtnText is null");
            return 0;
        }
        this.frontEntranceLayout.showView(textFromDB, textFromDB2, textFromDB3, textFromDB4, new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent dlappIntent = BackupSpaceInsufficientV5Dialog.this.getDlappIntent(v5DailogActivityAreaNeedData);
                if (dlappIntent == null || BackupSpaceInsufficientV5Dialog.this.getContext() == null) {
                    C11839m.m70687e(BackupSpaceInsufficientV5Dialog.TAG, "intent is null or mContext is null.");
                    return;
                }
                C9494c.m59390r().m59401O();
                C0216g0.m1402e(BackupSpaceInsufficientV5Dialog.this.getContext()).m1407E(dlappIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                try {
                    BackupSpaceInsufficientV5Dialog.this.getContext().startActivity(dlappIntent);
                } catch (Exception e10) {
                    C11839m.m70687e(BackupSpaceInsufficientV5Dialog.TAG, "click front entrance button exception: " + e10.toString());
                }
                C10152c.m63217a();
            }
        });
        this.frontEntranceLayout.setVisibility(0);
        this.activityArea.setVisibility(0);
        return 2;
    }

    private void showNoRemindDialog() {
        if (this.notEnoughDialogDataV5.getV5DialogNoRemindShowContent() == null) {
            C11839m.m70689w(TAG, "showNoRemindDialog v5DialogNoRemindShowContent is invalid");
            finish();
            return;
        }
        BackupSpaceInsufficientV5SettingDialog backupSpaceInsufficientV5SettingDialog = new BackupSpaceInsufficientV5SettingDialog(this.activity, this.notEnoughDialogDataV5, this.buttonReport.length(), this.isContainDownAppOrCampaginButton);
        this.backupSpaceInsufficientV5SettingDialog = backupSpaceInsufficientV5SettingDialog;
        backupSpaceInsufficientV5SettingDialog.showDialog();
        if (isShowing()) {
            dismiss();
        }
    }

    private int showPackageArea(V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData) {
        String string;
        String packageTitle;
        if (this.packageAreaLayout == null) {
            C11839m.m70687e(TAG, "showPackageArea packageAreaLayout is null.");
            return 0;
        }
        GetPackagesBySpaceRuleResp recommendPackageInfo = v5DailogActivityAreaNeedData.getRecommendPackageInfo();
        if (recommendPackageInfo == null) {
            C11839m.m70687e(TAG, "showPackageArea getPackagesBySpaceRuleResp is null.");
            return 0;
        }
        List<CloudPackage> spacePackages = recommendPackageInfo.getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            C11839m.m70687e(TAG, "showPackageArea getPackagesBySpaceRuleResp is null.");
            return 0;
        }
        CloudPackage cloudPackage = spacePackages.get(0);
        HashMap<String, String> extendTagMap = cloudPackage.getExtendTagMap();
        if (extendTagMap != null) {
            string = extendTagMap.get("backupPop_PromName");
            packageTitle = extendTagMap.get("backupPop_PromDesc");
        } else {
            string = "";
            packageTitle = "";
        }
        if (TextUtils.isEmpty(string)) {
            string = getContext().getString(R$string.v5_package_default_title, C0223k.m1524g(getContext(), cloudPackage.getCapacity()));
        }
        GetClientUIConfigResp clientUIConfigResp = v5DailogActivityAreaNeedData.getClientUIConfigResp();
        if (TextUtils.isEmpty(packageTitle)) {
            int productType = cloudPackage.getProductType();
            if (productType == 8 || productType == 7 || productType == 12) {
                packageTitle = cloudPackage.getPackageTitle();
                if (productType == 12) {
                    packageTitle = cloudPackage.getRemark3();
                }
            } else if (productType == 6 && clientUIConfigResp != null) {
                packageTitle = clientUIConfigResp.getRecommendBasicPackageRemarak(cloudPackage.getDurationMonth());
            }
        }
        this.packageAreaLayout.showView(string, packageTitle);
        if (clientUIConfigResp != null) {
            this.packageAreaLayout.setV5PackageCardRenewAgreementText(clientUIConfigResp.getPackageCardAgreement());
            this.packageAreaLayout.setV5CheckDialogRenewAgreementText(clientUIConfigResp.getCheckDialogRenewAgreement());
        }
        showRenewAgreement(cloudPackage);
        this.packageAreaLayout.setVisibility(0);
        this.activityArea.setVisibility(0);
        return 3;
    }

    private void showRenewAgreement(CloudPackage cloudPackage) {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                C11839m.m70688i(TAG, "showRenewAgreement, switch is close.");
                return;
            }
            if (cloudPackage == null) {
                C11839m.m70688i(TAG, "showRenewAgreement, recommendPackage is null.");
                return;
            }
            int productType = cloudPackage.getProductType();
            if (productType == 6 || productType == 8 || productType == 12) {
                V5PackageAreaLayout v5PackageAreaLayout = this.packageAreaLayout;
                if (v5PackageAreaLayout != null) {
                    v5PackageAreaLayout.showRenewAgreement(this.activity, this.renewAgreementTVCallback);
                } else {
                    C11839m.m70687e(TAG, "showRenewAgreement, packageAreaLayout is null.");
                }
            }
        }
    }

    private void showSecondaryRetentionDialog() {
        C11839m.m70688i(TAG, "showSecondaryRetentionDialog ");
        SecondaryRetentionContent secondaryRetentionContent = this.notEnoughDialogDataV5.getSecondaryRetentionContent();
        if (checkRetentionContentInvalid(secondaryRetentionContent)) {
            finish();
            C10811y.m65823g("3", "", "2", "", this.buttonReport.length(), this.extendReportMap);
            return;
        }
        String name = SecondaryRetentionDialog.class.getName();
        SecondaryRetentionDialog secondaryRetentionDialog = new SecondaryRetentionDialog(this.activity, secondaryRetentionContent);
        this.secondaryRetentionDialog = secondaryRetentionDialog;
        secondaryRetentionDialog.show();
        if (secondaryRetentionContent.getPositiveGoto() != null) {
            C10811y.m65830n(secondaryRetentionContent.getPositiveGoto().getPopupUri(), secondaryRetentionContent.getDialogType(), this.buttonReport.length(), this.extendReportMap);
        }
        C10811y.m65823g("3", name, "2", "", this.buttonReport.length(), this.extendReportMap);
        if (isShowing()) {
            dismiss();
        }
    }

    private void upToAppCenter() {
        AppInfo appInfo;
        INativeAd iNativeAdM59424t = C9494c.m59390r().m59424t();
        if (iNativeAdM59424t == null || (appInfo = iNativeAdM59424t.getAppInfo()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        AppHistoryBean appHistoryBean = new AppHistoryBean();
        appHistoryBean.setAppId(appInfo.getPackageName());
        appHistoryBean.setStatus(1);
        appHistoryBean.setTime(System.currentTimeMillis());
        arrayList.add(appHistoryBean);
        String strM64633k = C10527a.m64633k(arrayList);
        C11839m.m70688i(TAG, "saveToAppCenter history: " + strM64633k);
        new C10219d(strM64633k).m63381g();
    }

    public void finish() {
        C11839m.m70688i(TAG, "finish");
        onDestroy();
        Activity activity = this.activity;
        if (activity == null || activity.isDestroyed() || this.activity.isFinishing()) {
            return;
        }
        if (!this.frontAppClickStart) {
            C9494c.m59390r().m59408V(true);
        }
        this.activity.finish();
    }

    public Intent getDlappIntent(V5DailogActivityAreaNeedData v5DailogActivityAreaNeedData) {
        ActivityEntry activityEntry = v5DailogActivityAreaNeedData.getActivityEntry();
        Intent dlAppWebViewIntent = null;
        if (activityEntry == null) {
            C11839m.m70687e(TAG, "getDlappIntent activityEntry is null");
            return null;
        }
        try {
            dlAppWebViewIntent = NotifyUtil.getDlAppWebViewIntent(getContext(), activityEntry.getUrl());
            dlAppWebViewIntent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            C11272a.m67641a(dlAppWebViewIntent, activityEntry);
            return dlAppWebViewIntent;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getDlappIntent e:" + e10.toString());
            return dlAppWebViewIntent;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C9494c.m59390r().m59410X(true);
    }

    public void onDestroy() {
        C11839m.m70688i(TAG, "onDestroy");
        if (isShowing()) {
            dismiss();
        }
        Map<String, Bitmap> map = this.bitmapMap;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                Bitmap bitmap = this.bitmapMap.get(it.next());
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        }
        BackupSpaceInsufficientV5SettingDialog backupSpaceInsufficientV5SettingDialog = this.backupSpaceInsufficientV5SettingDialog;
        if (backupSpaceInsufficientV5SettingDialog != null) {
            backupSpaceInsufficientV5SettingDialog.onDestory();
        }
        SecondaryRetentionDialog secondaryRetentionDialog = this.secondaryRetentionDialog;
        if (secondaryRetentionDialog != null) {
            secondaryRetentionDialog.onDestroy();
        }
    }

    public void onDialogCancel() {
        C11839m.m70688i(TAG, "onDialogCancel " + this.isContainDownAppOrCampaginButton);
        clearBackupNotification();
        if (this.isContainDownAppOrCampaginButton) {
            finish();
        } else {
            showSecondaryRetentionDialog();
        }
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        C9494c.m59390r().m59410X(false);
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void refreshCheckboxStatus(boolean z10) {
        V5PackageAreaLayout v5PackageAreaLayout = this.packageAreaLayout;
        if (v5PackageAreaLayout == null) {
            C11839m.m70687e(TAG, "refreshCheckboxStatus, mRecommendPackageLayout is null.");
        } else {
            v5PackageAreaLayout.refreshCheckboxStatus(z10);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("way_of_purchase", "backup_dialog_purchase_v5");
        C13225d.m79490f1().m79591l0(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMap);
    }

    @Override // android.app.Dialog
    public void show() {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceNotEnoughDialog account is not login.");
            C10811y.m65822f("SpaceNotEnoughV5Error", "7", "showSpaceNotEnoughDialog account is not login.");
            finish();
        } else if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog function item switch off");
            C10811y.m65822f("SpaceNotEnoughV5Error", "6", "showSpaceNotEnoughDialog function item switch off");
            finish();
        } else if (!this.activity.isFinishing() && !this.activity.isDestroyed()) {
            C12515a.m75110o().m75172d(new C41832());
        } else {
            C11839m.m70688i(TAG, "BackupNotificationActivity is finished");
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void startPaymentProcess(C0079a c0079a) {
        C11839m.m70688i(TAG, "startPaymentProcess");
        clickPayBtn();
    }
}
