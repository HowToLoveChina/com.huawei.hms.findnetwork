package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import ae.C0105b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.C1159m;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupClearActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiextend.DialogMarketLayout;
import com.huawei.android.hicloud.p088ui.uiextend.FrontDoubleAppLayout;
import com.huawei.android.hicloud.p088ui.uiextend.PPSAdLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.banner.manager.FrontAppDownloadManager;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.bean.AppHistoryBean;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.BackupNotEnoughDisplayInfo;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.NotifyActivityEntry;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipInfo;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import gp.C10028c;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10798l;
import p010a9.C0079a;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p258ei.C9494c;
import p292fn.C9733f;
import p336he.C10152c;
import p336he.C10155f;
import p341hj.C10219d;
import p371ik.C10527a;
import p450le.C11273b;
import p454lj.C11290m;
import p454lj.C11296s;
import p514o9.C11839m;
import p514o9.C11842p;
import p571q9.C12295b;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import sk.C12809f;
import tl.C13026e;
import vn.C13471c;

/* loaded from: classes3.dex */
public class BackupDoubleBtnAlertDialog extends BackupNotificationDoubleBtnDialog implements ConfirmRenewAgreementDialog.AgreementDlgCallback {
    private static final int BUTTON_DEMAND_NUMBER = 3;
    private static final int BUTTON_DEMAND_NUMBER_PURCHASE = 2;
    private static final long CAPACITY_SIZE_200G = 214748364800L;
    private static final long CAPACITY_SIZE_2T = 2199023255552L;
    private static final long CAPACITY_SIZE_50G = 53687091200L;
    private static final int DIALOG_TEXT_PADDING = 8;
    private static final int DISPLAY_FRONT_ENTRANCE_MAX_NUM = 2;
    private static final int ONE_MONTH = 1;
    private static final int PROM_DURATION_LIMIT = 1;
    private static final int SIX_MONTH = 6;
    private static final String TAG = "BackupDoubleBtnAlertDialog";
    private static final int THREE_BUTTON_POPUP_OPEN = 1;
    private static final int TWELVE_MONTH = 12;
    private List<BackupOptionItem> backupOptionItemList;
    private String dlgRenewAgreementText;
    private boolean frontAppClickStart;
    private boolean haveRecommendSubscribeTwoButtonFull;
    private boolean haveThreeButtonFull;
    private boolean isCouponFrequence;
    private NotifyActivityEntry mActivityEntry;
    private ImageView mActivityEntryImg;
    private String mDefaultMainText;
    private int mDestroyType;
    private String mFrontAdPackageName;
    private String mFrontAdPackageNameSec;
    private String mFrontAppDescText;
    private String mFrontAppPrizeText;
    private String mFrontAppSutitleText;
    private FrontDoubleAppLayout mFrontDoubleAppLayout;
    private String mFrontEntranceBtnText;
    private String mFrontEntranceDescText;
    private DialogMarketLayout mFrontEntranceLayout;
    private String mFrontEntrancePrizeText;
    private ImageView mIconImageView;
    private int mMarketRegionStyle;
    private NoticeDetail mNoticeDetail;
    private String mNoticeType;
    private PPSAdLayout mPPSAdLayout;
    private DialogMarketLayout mRecommendPackageLayout;
    private RecommendTipInfo mRecommendTipInfo;
    private String packageButtonFirst;
    private String packageFrontEntranceText;
    private String packageMainTextFirstMonth;
    private String packageMainTextUnFirstMonth;
    private String packageRecommendText;
    private String packageTitle;
    private GetPackagesBySpaceRuleResp recommendInfo;
    private RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$1 */
    public class ViewOnClickListenerC41681 implements View.OnClickListener {
        final /* synthetic */ LinkedHashMap val$extraKeyValues;

        public ViewOnClickListenerC41681(LinkedHashMap linkedHashMap) {
            linkedHashMap = linkedHashMap;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context;
            Intent intentM28136i = FrontAppDownloadManager.m28136i();
            if (intentM28136i == null || (context = BackupDoubleBtnAlertDialog.this.mContext) == null) {
                return;
            }
            C0216g0.m1402e(context).m1407E(intentM28136i, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
            try {
                BackupDoubleBtnAlertDialog.this.mContext.startActivity(intentM28136i);
            } catch (Exception e10) {
                C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "click front double app button exception: " + e10.toString());
            }
            C10152c.m63217a();
            C13225d.m79490f1().m79591l0("mecloud_two_app_install_click", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "mecloud_two_app_install_click", "4", "9", linkedHashMap);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$2 */
    public class ViewOnClickListenerC41692 implements View.OnClickListener {
        public ViewOnClickListenerC41692() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent dlappIntent = BackupDoubleBtnAlertDialog.this.getDlappIntent();
            if (dlappIntent == null || BackupDoubleBtnAlertDialog.this.mContext == null) {
                C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "intent is null or mContext is null.");
                return;
            }
            C9494c.m59390r().m59401O();
            C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(dlappIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
            try {
                BackupDoubleBtnAlertDialog.this.mContext.startActivity(dlappIntent);
            } catch (Exception e10) {
                C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "click front entrance button exception: " + e10.toString());
            }
            C10152c.m63217a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$3 */
    public class ViewOnClickListenerC41703 implements View.OnClickListener {
        final /* synthetic */ String val$defaultMainText;
        final /* synthetic */ String val$gotoType;
        final /* synthetic */ String val$gotoUri;
        final /* synthetic */ boolean val$isWithActivity;
        final /* synthetic */ NoticeDetail val$noticeDetail;
        final /* synthetic */ String val$noticeType;
        final /* synthetic */ RecommendTipInfo val$recommendTipInfo;

        public ViewOnClickListenerC41703(String str, String str2, String str3, NoticeDetail noticeDetail, String str4, boolean z10, RecommendTipInfo recommendTipInfo) {
            str = str;
            str = str2;
            str = str3;
            noticeDetail = noticeDetail;
            str = str4;
            z = z10;
            recommendTipInfo = recommendTipInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BackupDoubleBtnAlertDialog.this.processActivityEntryBiUbaReport(str, str);
            BackupDoubleBtnAlertDialog.this.mContext.startActivity(BackupDoubleBtnAlertDialog.this.getActivityEntryIntent(str, str, str, noticeDetail, str, z, recommendTipInfo));
            BackupDoubleBtnAlertDialog.this.dismiss();
            BackupDoubleBtnAlertDialog.this.finish();
            BackupDoubleBtnAlertDialog.this.processRemoveTask();
            ScreenListener.m18023c(BackupDoubleBtnAlertDialog.this.mContext).m18028g();
            new BackupNotificationManager(BackupDoubleBtnAlertDialog.this.mContext).cancelSpaceNotEnoughNotify();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$4 */
    public class ViewOnClickListenerC41714 implements View.OnClickListener {
        public ViewOnClickListenerC41714() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_backup_data");
            Intent intent = new Intent();
            intent.putExtra("source", 2);
            intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, BackupOptionsActivity.class);
            C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
            Context context = BackupDoubleBtnAlertDialog.this.mContext;
            if (context != null) {
                context.startActivity(intent);
            } else {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                    BackupDoubleBtnAlertDialog.this.finish();
                } else {
                    contextM1377a.startActivity(intent);
                }
            }
            C10152c.m63217a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$5 */
    public class ViewOnClickListenerC41725 implements View.OnClickListener {
        public ViewOnClickListenerC41725() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_backup_clear");
            Intent intent = new Intent();
            intent.putExtra("source", 2);
            intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, CloudBackupClearActivity.class);
            C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
            Context context = BackupDoubleBtnAlertDialog.this.mContext;
            if (context != null) {
                context.startActivity(intent);
            } else {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                    BackupDoubleBtnAlertDialog.this.finish();
                } else {
                    contextM1377a.startActivity(intent);
                }
            }
            C10152c.m63217a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$6 */
    public class ViewOnClickListenerC41736 implements View.OnClickListener {
        public ViewOnClickListenerC41736() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_manage_backup_space");
            Intent intent = new Intent();
            intent.putExtra("source", 2);
            intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, HisyncSpaceDetailActivity.class);
            C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
            Context context = BackupDoubleBtnAlertDialog.this.mContext;
            if (context != null) {
                context.startActivity(intent);
            } else {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                    BackupDoubleBtnAlertDialog.this.finish();
                } else {
                    contextM1377a.startActivity(intent);
                }
            }
            C10152c.m63217a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$7 */
    public class ViewOnClickListenerC41747 implements View.OnClickListener {
        public ViewOnClickListenerC41747() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_manage_backup_size");
            Intent intent = new Intent();
            intent.putExtra("source", 2);
            intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, CloudSpaceBackupActivity.class);
            C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
            Context context = BackupDoubleBtnAlertDialog.this.mContext;
            if (context != null) {
                context.startActivity(intent);
            } else {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                    BackupDoubleBtnAlertDialog.this.finish();
                } else {
                    contextM1377a.startActivity(intent);
                }
            }
            C10152c.m63217a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog$8 */
    public class RunnableC41758 implements Runnable {
        final /* synthetic */ View val$parentView;

        public RunnableC41758(View view) {
            view = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iM70840n;
            int width = view.getWidth();
            LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(view, R$id.backup_data_right_area);
            TextView textView = (TextView) C12809f.m76831d(view, R$id.backup_data_tv);
            if (linearLayout == null || textView == null || (iM70840n = (width / 2) - C11842p.m70840n(BackupDoubleBtnAlertDialog.this.mContext, 8)) <= 0) {
                return;
            }
            textView.setMaxWidth(iM70840n);
        }
    }

    public class PackageBtnClickListener implements View.OnClickListener {
        private Context mContext;

        public PackageBtnClickListener(Context context) {
            this.mContext = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i(BackupDoubleBtnAlertDialog.TAG, "PackageBtnClickListener, click");
            BackupDoubleBtnAlertDialog.this.reportClickRecommendPackage();
            if (BackupDoubleBtnAlertDialog.this.mRecommendPackageLayout == null) {
                C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "PackageBtnClickListener, mRecommendPackageLayout is null.");
                return;
            }
            if (!BackupDoubleBtnAlertDialog.this.mRecommendPackageLayout.isShowRenewAgreementArea() || BackupDoubleBtnAlertDialog.this.mRecommendPackageLayout.isCheckStatus()) {
                BackupDoubleBtnAlertDialog.this.clickPayBtn();
                return;
            }
            C0079a c0079a = new C0079a();
            c0079a.m651h(BackupDoubleBtnAlertDialog.this);
            c0079a.m652i(BackupDoubleBtnAlertDialog.this.dlgRenewAgreementText);
            c0079a.m654k(BackupDoubleBtnAlertDialog.this.renewAgreementTVCallback);
            ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(this.mContext, c0079a);
            confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
            confirmRenewAgreementDialog.show();
        }
    }

    public BackupDoubleBtnAlertDialog(Context context) {
        super(context);
        this.packageButtonFirst = "";
        this.packageTitle = "";
        this.packageMainTextFirstMonth = "";
        this.packageMainTextUnFirstMonth = "";
        this.packageRecommendText = "";
        this.packageFrontEntranceText = "";
        this.frontAppClickStart = false;
        this.haveThreeButtonFull = false;
        this.haveRecommendSubscribeTwoButtonFull = false;
    }

    private void adaptLayoutWidth(View view) {
        if (view == null) {
            C11839m.m70687e(TAG, "adaptLayoutWidth parentView is null");
        } else {
            view.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.8
                final /* synthetic */ View val$parentView;

                public RunnableC41758(View view2) {
                    view = view2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int iM70840n;
                    int width = view.getWidth();
                    LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(view, R$id.backup_data_right_area);
                    TextView textView = (TextView) C12809f.m76831d(view, R$id.backup_data_tv);
                    if (linearLayout == null || textView == null || (iM70840n = (width / 2) - C11842p.m70840n(BackupDoubleBtnAlertDialog.this.mContext, 8)) <= 0) {
                        return;
                    }
                    textView.setMaxWidth(iM70840n);
                }
            });
        }
    }

    private int checkFrontAppStyle(int i10) {
        C1159m c1159mM59428x = C9494c.m59390r().m59428x(this.totalNeedSpace);
        if (c1159mM59428x.m7242g() != 7017) {
            if (c1159mM59428x.m7242g() == 7018) {
                return 3;
            }
            return i10 == 1 ? 4 : 0;
        }
        this.mFrontAppDescText = NoticeWithActivityUtil.getStrFromDBByResource(c1159mM59428x.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_SINGLE_TEXT);
        this.mFrontAppSutitleText = NoticeWithActivityUtil.getStrFromDBByResource(c1159mM59428x.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_SINGLE_TEXT_SECOND);
        this.mFrontAppPrizeText = C0209d.m1303s(NoticeWithActivityUtil.getStrFromDBByResource(c1159mM59428x.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_SINGLE_TITLE), c1159mM59428x.m7240e());
        this.mFrontAdPackageName = c1159mM59428x.m7238c();
        this.mFrontAdPackageNameSec = c1159mM59428x.m7239d();
        ActivityEntry activityEntryM73874b = this.backupNoticeNeedInfo.m73874b();
        if (activityEntryM73874b != null) {
            activityEntryM73874b.setResource(c1159mM59428x.m7241f());
        }
        return 1;
    }

    private void checkShowViewDetails(boolean z10) {
        RelativeLayout relativeLayout;
        checkShowView(z10);
        if (z10 || (relativeLayout = this.viewDetailsArea) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    public void clickPayBtn() {
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudSpaceUpgradeActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        intent.putExtra("from_where", 3);
        intent.putExtra("backup_dialog_recommend_info", this.recommendInfo);
        C0216g0.m1402e(this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
        Context context = this.mContext;
        if (context != null) {
            context.startActivity(intent);
            dismiss();
            finish();
        } else {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e(TAG, "initView() context is null.");
                finish();
            } else {
                contextM1377a.startActivity(intent);
            }
        }
        C10152c.m63217a();
    }

    private String getActivityEntryGotoInfo(NotifyActivityEntry notifyActivityEntry, boolean z10) {
        if (notifyActivityEntry == null) {
            C11839m.m70688i(TAG, "getActivityEntryGotoInfo activityEntry is null ");
            return null;
        }
        NotifyActivityEntry.EntryGoto entryGoto = notifyActivityEntry.getEntryGoto();
        if (entryGoto != null) {
            return z10 ? entryGoto.getType() : entryGoto.getUri();
        }
        C11839m.m70688i(TAG, "getActivityEntryGotoInfo entryGoto is null ");
        return null;
    }

    private String getActivityEntryImgUrl(NotifyActivityEntry notifyActivityEntry, boolean z10) {
        if (notifyActivityEntry == null) {
            C11839m.m70688i(TAG, "getActivityEntryImgUrl activityEntry is null ");
            return null;
        }
        NotifyActivityEntry.EntryPicture picturePad = z10 ? notifyActivityEntry.getPicturePad() : notifyActivityEntry.getPicture();
        if (picturePad != null) {
            return picturePad.getUrl();
        }
        C11839m.m70688i(TAG, "getActivityEntryImgUrl entryPicture is null ");
        return null;
    }

    private String getDefaultMainText(NoticeDetail noticeDetail) {
        return noticeDetail != null ? noticeDetail.getMainText() : "";
    }

    private String getEveryTimeStr(int i10, String str) {
        if (i10 == 1) {
            return this.mContext.getString(R$string.every_month_price, str);
        }
        if (i10 == 6) {
            return this.mContext.getString(R$string.every_half_year_price, str);
        }
        if (i10 == 12) {
            return this.mContext.getString(R$string.every_year_price, str);
        }
        if (i10 % 12 != 0) {
            return this.mContext.getResources().getQuantityString(R$plurals.every_x_month_price, i10, NumberFormat.getNumberInstance().format(i10), str);
        }
        int i11 = i10 / 12;
        return this.mContext.getResources().getQuantityString(R$plurals.every_x_year_price, i11, NumberFormat.getNumberInstance().format(i11), str);
    }

    private String getFirstMonthSpecialTimeStr(int i10, int i11) {
        if (i10 == 1) {
            if (i11 <= 1) {
                return this.mContext.getString(R$string.first_month);
            }
            int i12 = i10 * i11;
            return this.mContext.getResources().getQuantityString(R$plurals.first_several_months, i12, Integer.valueOf(i12));
        }
        if (i10 == 6) {
            return this.mContext.getString(R$string.first_half_year);
        }
        if (i10 == 12) {
            if (i11 <= 1) {
                return this.mContext.getString(R$string.first_year);
            }
            int i13 = (i10 / 12) * i11;
            return this.mContext.getResources().getQuantityString(R$plurals.first_several_years, i13, Integer.valueOf(i13));
        }
        if (i10 % 12 != 0) {
            return this.mContext.getResources().getQuantityString(R$plurals.first_several_months, i10, Integer.valueOf(i10));
        }
        int i14 = i10 / 12;
        return this.mContext.getResources().getQuantityString(R$plurals.first_several_years, i14, Integer.valueOf(i14));
    }

    private String getFirstMonthSpecialTimeStrForTitle(int i10) {
        Resources resources = this.mContext.getResources();
        if (resources == null) {
            return "";
        }
        if (i10 == 1) {
            return this.mContext.getString(R$string.first_month);
        }
        if (i10 == 6) {
            return this.mContext.getString(R$string.first_half_year);
        }
        if (i10 == 12) {
            return this.mContext.getString(R$string.first_year);
        }
        if (i10 % 12 != 0) {
            return this.mContext.getResources().getQuantityString(R$plurals.first_several_months, i10, Integer.valueOf(i10));
        }
        int i11 = i10 / 12;
        return resources.getQuantityString(R$plurals.first_several_years, i11, Integer.valueOf(i11));
    }

    private void getNotificationWithActivityRecommendTipInfo(NotificationWithActivity notificationWithActivity, String str) {
        if (notificationWithActivity == null) {
            C11839m.m70687e(TAG, "getNotificationWithActivityRecommendTipInfo fail, notification is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "getNotificationWithActivityRecommendTipInfo fail, gotoType is null");
            return;
        }
        if (NotifyConstants.DETAIL2.equals(str)) {
            this.mRecommendTipInfo = notificationWithActivity.getRecommendDetail2();
        }
        if ("detail".equals(str)) {
            this.mRecommendTipInfo = notificationWithActivity.getRecommendDetail();
        }
    }

    private String getPackageInfoStr(String str, String str2, CloudPackage cloudPackage, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        int promType = cloudPackage.getPromType();
        int productType = cloudPackage.getProductType();
        if (promType == 1) {
            return getRemark(str, cloudPackage, bigDecimal2, cloudPackage.getPrice());
        }
        if ((productType != 6 && productType != 8 && productType != 12) || bigDecimal2.compareTo(bigDecimal) >= 0) {
            str = str2;
        }
        return getRemark(str, cloudPackage, bigDecimal2, C11296s.m67838v(cloudPackage));
    }

    private String getPackageTitleStr(CloudPackage cloudPackage, BigDecimal bigDecimal) {
        String strM1524g = C0223k.m1524g(this.mContext, cloudPackage.getCapacity());
        String strM67747h = C11290m.m67747h(this.mContext, bigDecimal, cloudPackage.getCurrency(), cloudPackage.getCurrencySymbol());
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        int durationMonth = cloudPackage.getDurationMonth();
        int promDuration = cloudPackage.getPromDuration();
        int promType = cloudPackage.getPromType();
        if (TextUtils.isEmpty(this.packageTitle) && promType == 1 && promDuration > 1) {
            return durationMonth == 1 ? this.mContext.getResources().getQuantityString(R$plurals.first_month_for_promtype, promDuration, strM1524g, strM67747h, Integer.valueOf(promDuration)) : durationMonth == 12 ? this.mContext.getResources().getQuantityString(R$plurals.first_year_for_promtype, promDuration, strM1524g, strM67747h, Integer.valueOf(promDuration)) : this.mContext.getResources().getQuantityString(R$plurals.first_promduration_for_promtype, promDuration, strM1524g, strM67747h, Integer.valueOf(promDuration));
        }
        String timeUnitForTitle = getTimeUnitForTitle(promType, durationMonth, promDuration, cloudPackage.getProductType(), bigDecimalM67838v, bigDecimal);
        VoucherNotiDisplayInfo voucherNotiDisplayInfo = new VoucherNotiDisplayInfo();
        voucherNotiDisplayInfo.setPackageCapacityStr(strM1524g);
        voucherNotiDisplayInfo.setPackagePrice(strM67747h);
        voucherNotiDisplayInfo.setPacageDuration(timeUnitForTitle);
        return new HiCloudNotificationManager(this.mContext).replaceVoucherPlaceholder(this.packageTitle, voucherNotiDisplayInfo);
    }

    private CloudPackage getRecommendPackage() {
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.recommendInfo;
        if (getPackagesBySpaceRuleResp == null) {
            C11839m.m70687e(TAG, "showRecommendPackage recommendInfo is null.");
            return null;
        }
        List<CloudPackage> spacePackages = getPackagesBySpaceRuleResp.getSpacePackages();
        if (spacePackages != null && !spacePackages.isEmpty()) {
            return spacePackages.get(0);
        }
        C11839m.m70687e(TAG, "showRecommendPackage spacePackages is null.");
        return null;
    }

    private String getRemark(String str, CloudPackage cloudPackage, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        String strM67747h = C11290m.m67747h(this.mContext, bigDecimal2, cloudPackage.getCurrency(), cloudPackage.getCurrencySymbol());
        String strM67747h2 = C11290m.m67747h(this.mContext, bigDecimal, cloudPackage.getCurrency(), cloudPackage.getCurrencySymbol());
        int durationMonth = cloudPackage.getDurationMonth();
        VoucherNotiDisplayInfo voucherNotiDisplayInfo = new VoucherNotiDisplayInfo();
        voucherNotiDisplayInfo.setFirstMonthPackagePrice(strM67747h2);
        voucherNotiDisplayInfo.setPackagePrice(strM67747h);
        voucherNotiDisplayInfo.setPacageDuration(getUniversalSpecialTimeStr(durationMonth));
        voucherNotiDisplayInfo.setFirstMonthPackageDuration(getFirstMonthSpecialTimeStr(durationMonth, cloudPackage.getPromDuration()));
        voucherNotiDisplayInfo.setEveryMonthPackagePrice(getEveryTimeStr(durationMonth, strM67747h));
        return new HiCloudNotificationManager(this.mContext).replaceVoucherPlaceholder(str, voucherNotiDisplayInfo);
    }

    private void getSpaceNotificationRecommendTipInfo(SpaceNotification spaceNotification, String str) {
        if (spaceNotification == null) {
            C11839m.m70687e(TAG, "getRecommendTipInfo fail, spaceNotification is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "getRecommendTipInfo fail, gotoType is null");
            return;
        }
        if (NotifyConstants.DETAIL2.equals(str)) {
            this.mRecommendTipInfo = spaceNotification.getRecommendDetail2();
        }
        if ("detail".equals(str)) {
            this.mRecommendTipInfo = spaceNotification.getRecommendDetail();
        }
    }

    private String getTimeUnitForTitle(int i10, int i11, int i12, int i13, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (this.mContext != null) {
            return ((i10 == 1 && i12 == 1) || ((i13 == 6 || i13 == 8 || i13 == 12) && ((i11 == 1 || i11 == 12) && bigDecimal2.compareTo(bigDecimal) == -1))) ? getFirstMonthSpecialTimeStrForTitle(i11) : getUniversalSpecialTimeStr(i11);
        }
        C11839m.m70687e(TAG, "getTimeUnit mContext is null.");
        return "";
    }

    private String getUniversalSpecialTimeStr(int i10) {
        if (i10 == 1) {
            return this.mContext.getString(R$string.per_month);
        }
        if (i10 == 6) {
            return this.mContext.getString(R$string.per_half_year);
        }
        if (i10 == 12) {
            return this.mContext.getString(R$string.per_year);
        }
        if (i10 % 12 != 0) {
            return this.mContext.getResources().getQuantityString(R$plurals.per_x_month, i10, NumberFormat.getNumberInstance().format(i10));
        }
        int i11 = i10 / 12;
        return this.mContext.getResources().getQuantityString(R$plurals.per_x_year, i11, NumberFormat.getNumberInstance().format(i11));
    }

    private boolean isCanShowCoupon(int i10) {
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.recommendInfo;
        if (getPackagesBySpaceRuleResp == null) {
            return false;
        }
        List<Voucher> voucherList = getPackagesBySpaceRuleResp.getVoucherList();
        return this.isCouponFrequence && C11296s.m67787K() && C11296s.m67789M(this.mContext) && voucherList != null && !voucherList.isEmpty() && i10 == 1;
    }

    private boolean isPriceUseVoucher() {
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.recommendInfo;
        if (getPackagesBySpaceRuleResp == null) {
            return false;
        }
        List<Voucher> voucherList = getPackagesBySpaceRuleResp.getVoucherList();
        return C11296s.m67787K() && C11296s.m67789M(this.mContext) && voucherList != null && !voucherList.isEmpty();
    }

    private boolean isShowThreeButtonNewStyleForFrontEntranceByApp() {
        boolean z10 = this.mMarketRegionStyle == 3 && this.isThreeButtonPopup == 1;
        boolean z11 = (TextUtils.isEmpty(this.standByButtonFirstText) || TextUtils.isEmpty(this.standByButtonSecondText) || TextUtils.isEmpty(this.standByButtonThirdText)) ? false : true;
        C11839m.m70688i(TAG, "isShowThreeButtonNewStyleForFrontEntranceByApp isConfigSatisfy = " + z10 + " isValueSatisfy = " + z11 + " haveThreeButtonFull = " + this.haveThreeButtonFull);
        return z10 && z11 && this.haveThreeButtonFull;
    }

    public /* synthetic */ void lambda$showFrontApp$0(AppStatus appStatus) {
        AppStatus appStatus2 = AppStatus.DOWNLOADING;
        if (appStatus2.equals(this.mPPSAdLayout.getAppStatus()) || !appStatus2.equals(appStatus)) {
            return;
        }
        C11839m.m70686d(TAG, "start download");
        this.frontAppClickStart = true;
    }

    public /* synthetic */ void lambda$showFrontApp$1(AppInfo appInfo) {
        this.frontAppClickStart = false;
    }

    private int marketRegionDisplayStyle(NotificationWithActivity notificationWithActivity) {
        int enableFrontApp = notificationWithActivity.getEnableFrontApp();
        String frontAppStyle = notificationWithActivity.getFrontAppStyle();
        int enableActivityEntry = notificationWithActivity.getEnableActivityEntry();
        int enableRecomPackages = notificationWithActivity.getEnableRecomPackages();
        C11839m.m70688i(TAG, "marketRegionDisplayStyle, frontAppEnable: " + enableFrontApp + ", frontAppStyle: " + frontAppStyle + ", activityEntry: " + enableActivityEntry + ", recommendPackageEnable: " + enableRecomPackages);
        if (enableFrontApp != 1) {
            if (enableActivityEntry == 1) {
                return 5;
            }
            return enableRecomPackages == 1 ? 6 : 0;
        }
        if (NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE.equals(frontAppStyle)) {
            return 2;
        }
        if ("app".equals(frontAppStyle)) {
            return checkFrontAppStyle(enableRecomPackages);
        }
        return 4;
    }

    private int marketRegionDisplayStyleForOversea(NotificationWithActivity notificationWithActivity) {
        int enableActivityEntry = notificationWithActivity.getEnableActivityEntry();
        int enableRecomPackages = notificationWithActivity.getEnableRecomPackages();
        C11839m.m70688i(TAG, "marketRegionDisplayStyleForOversea, activityEntry: " + enableActivityEntry + ", recommendPackageEnable: " + enableRecomPackages);
        if (enableActivityEntry == 1) {
            return 5;
        }
        return enableRecomPackages == 1 ? 6 : 0;
    }

    private void onDialogDestroy() {
        if (this.mMarketRegionStyle == 1) {
            C11839m.m70688i(TAG, "front app download, destroy type is: " + this.mDestroyType);
            int i10 = this.mDestroyType;
            if (i10 == 7 || i10 == 8) {
                C9494c.m59390r().m59394F();
            } else {
                C9494c.m59390r().m59393E();
            }
        }
    }

    private String parsePackageInfo(boolean z10, CloudPackage cloudPackage, LinkedHashMap linkedHashMap) {
        BigDecimal bigDecimalM67833q;
        BigDecimal bigDecimalM67833q2;
        int promDuration = cloudPackage.getPromDuration();
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        linkedHashMap.put("is_dialog_has_voucher", Boolean.FALSE);
        int promType = cloudPackage.getPromType();
        if (isPriceUseVoucher()) {
            RecommendVouchers recommendVouchersM67840x = C11296s.m67840x(this.recommendInfo);
            if (recommendVouchersM67840x != null) {
                List<Voucher> voucherList = recommendVouchersM67840x.getVoucherList();
                bigDecimalM67833q2 = (promType != 1 || promDuration <= 1) ? C11296s.m67833q(cloudPackage, voucherList, this.recommendInfo.getDeductAmount(), recommendVouchersM67840x.getDiscountAmount()) : bigDecimalM67838v;
                if (voucherList != null && !voucherList.isEmpty()) {
                    linkedHashMap.put("is_dialog_has_voucher", Boolean.TRUE);
                    linkedHashMap.put("recommend_voucher_id_list", C11296s.m67801Y(voucherList));
                }
            } else {
                bigDecimalM67833q2 = bigDecimalM67838v;
            }
            bigDecimalM67833q = bigDecimalM67833q2;
        } else {
            bigDecimalM67833q = (promType != 1 || promDuration <= 1) ? C11296s.m67833q(cloudPackage, new ArrayList(), this.recommendInfo.getDeductAmount(), BigDecimal.ZERO) : bigDecimalM67838v;
        }
        return z10 ? getPackageTitleStr(cloudPackage, bigDecimalM67833q) : getPackageInfoStr(this.packageMainTextFirstMonth, this.packageMainTextUnFirstMonth, cloudPackage, bigDecimalM67838v, bigDecimalM67833q);
    }

    private void preparePackageInfo(NoticeContent noticeContent) {
        if (!C13452e.m80781L().m80897c1()) {
            C11839m.m70688i(TAG, "preparePackageInfo isSubscribeUser");
            this.packageSubscribeDialogTitle = getStringUseLock(noticeContent.getPurchasePackageMainText());
            this.packageSubscribeDialogDesc = getStringUseLock(noticeContent.getPurchasePackageMainTextSecond());
            this.packageSubscribeTitle = getStringUseLock(noticeContent.getPurchasePackageDescription());
            this.packageSubscribeDesc = getStringUseLock(noticeContent.getPurchasePackageDescriptionSecond());
            this.packageSubscribeButtonFirst = getStringUseLock(noticeContent.getPurchasePackageButtonFirst());
            this.packageSubscribeButtonSecond = getStringUseLock(noticeContent.getPurchasePackageButtonSecond());
        }
        CloudPackage recommendPackage = getRecommendPackage();
        if (recommendPackage == null) {
            C11839m.m70687e(TAG, "preparePackageInfo recommendPackage is null.");
            return;
        }
        int productType = recommendPackage.getProductType();
        long capacity = recommendPackage.getCapacity();
        C11839m.m70686d(TAG, "productType is: " + productType + ", recommendCapability is " + capacity);
        if (productType == 12) {
            C11839m.m70688i(TAG, "preparePackageInfo 2T");
            this.packageTitle = getStringUseLock(noticeContent.getPackage2tTitle());
            this.packageButtonFirst = getStringUseLock(noticeContent.getPackage2TButtonFirst());
            this.packageMainTextFirstMonth = getStringUseLock(noticeContent.getPackage2tFirstMonthText());
            this.packageMainTextUnFirstMonth = getStringUseLock(noticeContent.getPackage2tUnFirstMonthText());
            return;
        }
        this.packageTitle = getStringUseLock(noticeContent.getPackageUn2tTitle());
        this.packageButtonFirst = getStringUseLock(noticeContent.getPackageButtonFirst());
        if (capacity == CAPACITY_SIZE_2T && this.totalSpace >= CAPACITY_SIZE_2T) {
            C11839m.m70688i(TAG, "preparePackageInfo recommendPackage 2T and totalSpace is greater than 2T");
            this.packageMainTextFirstMonth = getStringUseLock(noticeContent.getPackage2tFirstMonthText());
            this.packageMainTextUnFirstMonth = getStringUseLock(noticeContent.getPackage2tUnFirstMonthText());
            this.packageRecommendText = getStringUseLock(noticeContent.getPackageV3MainTextSecond());
            return;
        }
        C11839m.m70688i(TAG, "preparePackageInfo un2T");
        this.packageMainTextFirstMonth = getStringUseLock(noticeContent.getPackageUn2tFirstMonthText());
        this.packageMainTextUnFirstMonth = getStringUseLock(noticeContent.getPackageUn2tUnfirstMonthText());
        if (capacity >= CAPACITY_SIZE_2T) {
            this.packageRecommendText = getStringUseLock(noticeContent.getPackageV3MainTextSecond());
            C11839m.m70686d(TAG, "packageRecommendText bigger than 2t is: " + this.packageRecommendText);
            return;
        }
        if (capacity >= 214748364800L) {
            this.packageRecommendText = getStringUseLock(noticeContent.getPackageV2MainTextSecond());
            C11839m.m70686d(TAG, "packageRecommendText bigger than 200g is: " + this.packageRecommendText);
            return;
        }
        this.packageRecommendText = getStringUseLock(noticeContent.getPackageV1MainTextSecond());
        C11839m.m70686d(TAG, "packageRecommendText small than 200g is: " + this.packageRecommendText);
    }

    private boolean prepareTitleAndMainText(NoticeContent noticeContent) {
        boolean zM80897c1 = C13452e.m80781L().m80897c1();
        this.title = NotifyUtil.filterNoticeTitle(noticeContent, zM80897c1, this.autoBackup, NotifyUtil.TITLE_V4, this.f19203id);
        String strFilterNoticeMainText = NotifyUtil.filterNoticeMainText(noticeContent, zM80897c1, this.autoBackup, NotifyUtil.MAIN_TEXT_V4, this.f19203id);
        this.mainText = strFilterNoticeMainText;
        if (TextUtils.isEmpty(strFilterNoticeMainText) || TextUtils.isEmpty(this.title)) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog mainText = " + this.mainText + " or title = " + this.title + " is null.");
            return false;
        }
        if (checkMultiLanguage(this.f19203id, noticeContent.getButtonFirst(), noticeContent.getButtonSecond())) {
            this.buttonFirst = getStringUseLock(noticeContent.getButtonFirst());
            this.buttonSecond = getStringUseLock(noticeContent.getButtonSecond());
            return true;
        }
        C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog button checkMultiLanguage fail");
        this.buttonFirst = getStringUseLock(noticeContent.getButtonFirst());
        this.buttonSecond = getStringUseLock(noticeContent.getButtonSecond());
        if (TextUtils.isEmpty(this.buttonFirst) || TextUtils.isEmpty(this.buttonSecond)) {
            return false;
        }
        C11839m.m70687e(TAG, "prepareBtnAndDescription get defaul language");
        return true;
    }

    private void prepareWaitBackupData() {
        this.backupOptionItemList = TransferedUtil.queryWaitBackupOptions();
    }

    public void processActivityEntryBiUbaReport(String str, String str2) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("deviceId", C13471c.m81129b());
        linkedHashMapM79499C.put("gotoType", str);
        linkedHashMapM79499C.put("gotoUri", str2);
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_activity_entry", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_notenough_activity_entry", "4", "9", linkedHashMapM79499C);
    }

    public void reportClickBackupData(String str) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(this.autoBackup));
        linkedHashMapM79499C.put("click_text", str);
        C13225d.m79490f1().m79591l0(str, linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMapM79499C);
    }

    public void reportClickRecommendPackage() {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        addExtraRecommendReportInfo(linkedHashMapM79499C);
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_click_recommend_package", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_notenough_click_recommend_package", "4", "9", linkedHashMapM79499C);
    }

    private void saveToAppCenter() {
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

    private boolean setDialogMainText() {
        long jM16190y = C2783d.m16190y();
        Resources resources = this.mContext.getResources();
        if (resources == null) {
            C11839m.m70687e(TAG, "setDialogMainText resources is null.");
            return false;
        }
        BackupNotEnoughDisplayInfo backupNotEnoughDisplayInfo = new BackupNotEnoughDisplayInfo();
        int i10 = (int) jM16190y;
        backupNotEnoughDisplayInfo.setUnBackupDays(resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10)));
        if (this.backupNeedSpace <= 0) {
            this.backupNeedSpace = 0L;
        }
        if (this.notUsedSpace <= 0) {
            this.notUsedSpace = 0L;
        }
        Context context = this.mContext;
        long j10 = this.backupNeedSpace;
        long j11 = this.notUsedSpace;
        if (j10 < j11) {
            j10 = j11;
        }
        backupNotEnoughDisplayInfo.setBackupDataSize(C0223k.m1524g(context, j10));
        backupNotEnoughDisplayInfo.setRemainSpace(C0223k.m1524g(this.mContext, this.notUsedSpace));
        String strReplacePlaceForBackup = new HiCloudNotificationManager(this.mContext).replacePlaceForBackup(this.mainText, backupNotEnoughDisplayInfo);
        this.mainText = strReplacePlaceForBackup;
        if (!TextUtils.isEmpty(strReplacePlaceForBackup)) {
            return true;
        }
        C11839m.m70687e(TAG, "setDialogMainText mainTextStr is null.");
        return false;
    }

    private void setMarketRegionText(String str) {
        this.mFrontEntranceDescText = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_ENTRANCE_V2_TEXT);
        this.mFrontEntrancePrizeText = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_UNMATCH_V2_TEXT);
        this.mFrontEntranceBtnText = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_ENTRANCE_V2_BUTTON);
        this.packageFrontEntranceText = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_ENTRANCE_TEXT_SECOND);
    }

    private LinkedHashMap showActivityEntry() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_dialog_show_activity_entry", Boolean.TRUE);
        try {
            showActivityEntry(this.mActivityEntry, this.mDefaultMainText, this.mNoticeDetail, true, this.mNoticeType, this.mRecommendTipInfo, linkedHashMap);
            return linkedHashMap;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "showActivityEntry exception: " + e10.toString());
            linkedHashMap.put("is_dialog_show_activity_entry", Boolean.FALSE);
            return linkedHashMap;
        }
    }

    private void showBackupClearLayout() {
        ViewStub viewStub;
        if (!this.isDisplayBackUpData) {
            C11839m.m70687e(TAG, "showBackupClearLayout no need show backup data");
            return;
        }
        if (this.fontScale > 1.0f) {
            viewStub = (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area_1dot75);
            viewStub.setLayoutResource(R$layout.space_not_enough_dialog_backup_clear_1dot75);
        } else {
            viewStub = (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area);
            viewStub.setLayoutResource(R$layout.space_not_enough_dialog_backup_clear);
        }
        viewStub.inflate();
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this.view, R$id.backup_data_area_backup_clear);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.5
            public ViewOnClickListenerC41725() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_backup_clear");
                Intent intent = new Intent();
                intent.putExtra("source", 2);
                intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, CloudBackupClearActivity.class);
                C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                Context context = BackupDoubleBtnAlertDialog.this.mContext;
                if (context != null) {
                    context.startActivity(intent);
                } else {
                    Context contextM1377a = C0213f.m1377a();
                    if (contextM1377a == null) {
                        C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                        BackupDoubleBtnAlertDialog.this.finish();
                    } else {
                        contextM1377a.startActivity(intent);
                    }
                }
                C10152c.m63217a();
            }
        });
        showWaitAndBackupClearData(relativeLayout, C13368e.m80184F().m80221J(CloudBackupConstant.Command.PMS_CMD_BACKUP).getUsed());
    }

    private void showBackupData() {
        String str = this.dialogBtnGoto;
        str.hashCode();
        switch (str) {
            case "manage":
                showManageBackupLayout();
                break;
            case "hicloud_backup_clear":
                showBackupClearLayout();
                break;
            case "manage_backup_size":
                showManageBackupSizeLayout();
                break;
            default:
                showWaitBackupLayout();
                break;
        }
    }

    private LinkedHashMap showFrontApp() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_dialog_show_front_app", Boolean.TRUE);
        linkedHashMap.put("dialog_front_app_package_name", this.mFrontAdPackageName);
        if (this.mPPSAdLayout.init(C9494c.m59390r().m59424t(), this.mFrontAppPrizeText)) {
            C9494c.m59390r().m59397J();
            this.mPPSAdLayout.setVisibility(0);
            this.mPPSAdLayout.setStatusChangeListener(new PPSAdLayout.StatusChangeListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.a
                @Override // com.huawei.android.hicloud.ui.uiextend.PPSAdLayout.StatusChangeListener
                public final void onStatusChanged(AppStatus appStatus) {
                    this.f19205a.lambda$showFrontApp$0(appStatus);
                }
            });
            this.mPPSAdLayout.setUserCancelListener(new PPSAdLayout.UserCancelListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.b
                @Override // com.huawei.android.hicloud.ui.uiextend.PPSAdLayout.UserCancelListener
                public final void onUserCancel(AppInfo appInfo) {
                    this.f19206a.lambda$showFrontApp$1(appInfo);
                }
            });
            saveToAppCenter();
        }
        return linkedHashMap;
    }

    private LinkedHashMap showFrontDoubleApp() {
        C1159m c1159mM59391A = C9494c.m59390r().m59391A();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_dialog_show_front_double_app", Boolean.TRUE);
        linkedHashMap.put("dialog_front_first_app_package_name", this.mFrontAdPackageName);
        linkedHashMap.put("dialog_front_second_app_package_name", c1159mM59391A.m7239d());
        if (this.mFrontDoubleAppLayout.fullInitDoubleLayout(c1159mM59391A, new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.1
            final /* synthetic */ LinkedHashMap val$extraKeyValues;

            public ViewOnClickListenerC41681(LinkedHashMap linkedHashMap2) {
                linkedHashMap = linkedHashMap2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Context context;
                Intent intentM28136i = FrontAppDownloadManager.m28136i();
                if (intentM28136i == null || (context = BackupDoubleBtnAlertDialog.this.mContext) == null) {
                    return;
                }
                C0216g0.m1402e(context).m1407E(intentM28136i, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                try {
                    BackupDoubleBtnAlertDialog.this.mContext.startActivity(intentM28136i);
                } catch (Exception e10) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "click front double app button exception: " + e10.toString());
                }
                C10152c.m63217a();
                C13225d.m79490f1().m79591l0("mecloud_two_app_install_click", linkedHashMap);
                UBAAnalyze.m29958S("PVC", "mecloud_two_app_install_click", "4", "9", linkedHashMap);
            }
        }, this.mContext, this.handler)) {
            FrontAppDownloadManager.m28137j().m28145l();
            this.mFrontDoubleAppLayout.setVisibility(0);
        }
        return linkedHashMap2;
    }

    private LinkedHashMap showFrontEntrance(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.isEmpty(this.mFrontEntrancePrizeText)) {
            C11839m.m70687e(TAG, "showFrontEntrance mFrontEntrancePrizeText is empty.");
            return linkedHashMap;
        }
        if (TextUtils.isEmpty(this.mFrontEntranceBtnText)) {
            C11839m.m70687e(TAG, "showFrontEntrance mFrontEntranceBtnText is empty.");
            return linkedHashMap;
        }
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put("is_dialog_show_front_entry", bool);
        if (i10 == 3) {
            linkedHashMap.put("is_dialog_show_front_entry_by_app", bool);
        }
        if (TextUtils.isEmpty(this.mFrontEntranceDescText)) {
            this.mFrontEntranceDescText = "";
        }
        this.mFrontEntranceLayout.fullInitLayout(this.mFrontEntrancePrizeText, this.packageFrontEntranceText, this.mFrontEntranceDescText, this.mFrontEntranceBtnText, new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.2
            public ViewOnClickListenerC41692() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent dlappIntent = BackupDoubleBtnAlertDialog.this.getDlappIntent();
                if (dlappIntent == null || BackupDoubleBtnAlertDialog.this.mContext == null) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "intent is null or mContext is null.");
                    return;
                }
                C9494c.m59390r().m59401O();
                C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(dlappIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                try {
                    BackupDoubleBtnAlertDialog.this.mContext.startActivity(dlappIntent);
                } catch (Exception e10) {
                    C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "click front entrance button exception: " + e10.toString());
                }
                C10152c.m63217a();
            }
        });
        this.mFrontEntranceLayout.setVisibility(0);
        return linkedHashMap;
    }

    private LinkedHashMap showFrontEntranceByApp(int i10) {
        if (!isShowThreeButtonNewStyleForFrontEntranceByApp()) {
            return showFrontEntrance(i10);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put("is_dialog_show_front_entry", bool);
        linkedHashMap.put("is_dialog_show_front_entry_by_app_new_style", bool);
        showThreeButton();
        return linkedHashMap;
    }

    private void showManageBackupLayout() {
        ViewStub viewStub;
        if (!this.isDisplayBackUpData) {
            C11839m.m70687e(TAG, "showWaitBackupLayout no need show backup data");
            return;
        }
        if (this.fontScale > 1.0f) {
            viewStub = (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area_1dot75);
            viewStub.setLayoutResource(R$layout.space_not_enough_dialog_manage_1dot75);
        } else {
            viewStub = (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area);
            viewStub.setLayoutResource(R$layout.space_not_enough_dialog_manage);
        }
        viewStub.inflate();
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this.view, R$id.backup_data_area_manage);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.6
            public ViewOnClickListenerC41736() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_manage_backup_space");
                Intent intent = new Intent();
                intent.putExtra("source", 2);
                intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, HisyncSpaceDetailActivity.class);
                C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                Context context = BackupDoubleBtnAlertDialog.this.mContext;
                if (context != null) {
                    context.startActivity(intent);
                } else {
                    Context contextM1377a = C0213f.m1377a();
                    if (contextM1377a == null) {
                        C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                        BackupDoubleBtnAlertDialog.this.finish();
                    } else {
                        contextM1377a.startActivity(intent);
                    }
                }
                C10152c.m63217a();
            }
        });
        showManageData(relativeLayout, this.usedSpace);
    }

    private void showManageBackupSizeLayout() {
        ViewStub viewStub;
        if (!this.isDisplayBackUpData) {
            C11839m.m70687e(TAG, "showWaitBackupLayout no need show backup data");
            return;
        }
        if (this.fontScale > 1.0f) {
            viewStub = (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area_1dot75);
            viewStub.setLayoutResource(R$layout.space_not_enough_dialog_manage_backup_size_1dot75);
        } else {
            viewStub = (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area);
            viewStub.setLayoutResource(R$layout.space_not_enough_dialog_manage_backup_size);
        }
        viewStub.inflate();
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this.view, R$id.backup_data_area_manage_backup_size);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.7
            public ViewOnClickListenerC41747() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_manage_backup_size");
                Intent intent = new Intent();
                intent.putExtra("source", 2);
                intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, CloudSpaceBackupActivity.class);
                C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                Context context = BackupDoubleBtnAlertDialog.this.mContext;
                if (context != null) {
                    context.startActivity(intent);
                } else {
                    Context contextM1377a = C0213f.m1377a();
                    if (contextM1377a == null) {
                        C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                        BackupDoubleBtnAlertDialog.this.finish();
                    } else {
                        contextM1377a.startActivity(intent);
                    }
                }
                C10152c.m63217a();
            }
        });
        showManageData(relativeLayout, C13368e.m80184F().m80221J(CloudBackupConstant.Command.PMS_CMD_BACKUP).getUsed());
    }

    private void showManageData(RelativeLayout relativeLayout, long j10) {
        adaptLayoutWidth(relativeLayout);
        C12809f.m76841n((TextView) C12809f.m76831d(this.view, R$id.used_data_size_tv), this.mContext.getString(R$string.frag_cloud_storage_value, C0223k.m1524g(this.mContext, j10), C0223k.m1524g(this.mContext, this.totalSpace)));
    }

    private LinkedHashMap showMarketArea(int i10) {
        C11839m.m70688i(TAG, "showMarketArea, style: " + i10);
        switch (i10) {
            case 1:
                return showFrontApp();
            case 2:
                return showFrontEntrance(i10);
            case 3:
                return showFrontEntranceByApp(i10);
            case 4:
            case 6:
                return showRecommendPackage(i10);
            case 5:
                return showActivityEntry();
            case 7:
                return showFrontDoubleApp();
            default:
                return showNothing();
        }
    }

    private LinkedHashMap showNothing() {
        C11839m.m70687e(TAG, "market region showNothing");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Boolean bool = Boolean.FALSE;
        linkedHashMap.put("is_dialog_show_package", bool);
        linkedHashMap.put("is_dialog_show_activity_entry", bool);
        linkedHashMap.put("is_dialog_show_front_app", bool);
        linkedHashMap.put("is_dialog_show_front_entry", bool);
        return linkedHashMap;
    }

    private boolean showPackageArea(String str, float f10, LinkedHashMap linkedHashMap, CloudPackage cloudPackage) {
        if (this.mRecommendPackageLayout != null) {
            if (cloudPackage.getPromType() == 1) {
                int promDuration = cloudPackage.getPromDuration();
                int durationMonth = cloudPackage.getDurationMonth();
                if (promDuration > 1 && durationMonth != 1 && durationMonth != 12) {
                    C11839m.m70688i(TAG, "showPackageArea promDuration and packageDurationMonth not right.");
                    this.mRecommendPackageLayout.setVisibility(8);
                    return false;
                }
            }
            String packageInfo = parsePackageInfo(true, cloudPackage, linkedHashMap);
            if (TextUtils.isEmpty(packageInfo)) {
                C11839m.m70687e(TAG, "showPackageArea title is empty.");
                this.mRecommendPackageLayout.setVisibility(8);
                linkedHashMap.put("is_dialog_show_package", Boolean.FALSE);
                return true;
            }
            this.mRecommendPackageLayout.fullInitLayout(packageInfo, this.packageRecommendText, parsePackageInfo(false, cloudPackage, linkedHashMap), str, new PackageBtnClickListener(this.mContext));
            this.mRecommendPackageLayout.setVisibility(0);
            showRenewAgreement(cloudPackage);
            linkedHashMap.put("is_dialog_show_package", Boolean.TRUE);
            linkedHashMap.put(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, cloudPackage.getId());
            linkedHashMap.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(f10));
        }
        return false;
    }

    private LinkedHashMap showRecommendPackage(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put("is_dialog_show_package", bool);
        if (i10 == 4) {
            linkedHashMap.put("is_dialog_show_package_by_app", bool);
        }
        try {
            CloudPackage recommendPackage = getRecommendPackage();
            if (!isShowRecommendPackageWithSubscribeUser()) {
                if (recommendPackage != null) {
                    showPackageArea(this.packageButtonFirst, this.percentage, linkedHashMap, recommendPackage);
                    return linkedHashMap;
                }
                C11839m.m70687e(TAG, "showRecommendPackage recommendPackage is null.");
                linkedHashMap.put("is_dialog_show_package", Boolean.FALSE);
                return linkedHashMap;
            }
            C11839m.m70688i(TAG, "showPackageArea isSubscribeUser.");
            this.mRecommendPackageLayout.fullInitLayout(this.packageSubscribeTitle, "", this.packageSubscribeDesc, "", null);
            this.mRecommendPackageLayout.setVisibility(0);
            linkedHashMap.put("is_dialog_show_package_subscribe_show", bool);
            linkedHashMap.put("is_dialog_show_package", bool);
            if (recommendPackage != null) {
                linkedHashMap.put(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, recommendPackage.getId());
            }
            linkedHashMap.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(this.percentage));
            return linkedHashMap;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "showRecommendPackage exception: " + e10.toString());
            linkedHashMap.put("is_dialog_show_package", Boolean.FALSE);
            return linkedHashMap;
        }
    }

    private void showRenewAgreement(CloudPackage cloudPackage) {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                C11839m.m70688i(TAG, "showRenewAgreement, switch is close.");
                return;
            }
            if (cloudPackage == null) {
                C11839m.m70688i(TAG, "dealShowRenewAgreement, recommendPackage is null.");
                return;
            }
            int productType = cloudPackage.getProductType();
            if (productType == 6 || productType == 8 || productType == 12) {
                this.mRecommendPackageLayout.showRenewAgreement(this.mContext, this.renewAgreementTVCallback);
            }
        }
    }

    private LinkedHashMap showThreeButton() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.threeButtonArea.setVisibility(0);
        this.viewDetailsArea.setVisibility(8);
        this.backupManageArea.setVisibility(8);
        return linkedHashMap;
    }

    private void showWaitAndBackupClearData(RelativeLayout relativeLayout, long j10) {
        adaptLayoutWidth(relativeLayout);
        C12809f.m76841n((TextView) C12809f.m76831d(this.view, R$id.backup_data_size_tv), C0223k.m1524g(this.mContext, j10));
        RecyclerView recyclerView = (RecyclerView) C12809f.m76831d(this.view, R$id.backup_data_item_icon_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        recyclerView.setAdapter(new C0105b(this.mContext, this.backupOptionItemList));
    }

    private void showWaitBackupLayout() {
        if (!this.isDisplayBackUpData) {
            C11839m.m70687e(TAG, "showWaitBackupLayout no need show backup data");
            return;
        }
        (this.fontScale > 1.0f ? (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area_1dot75) : (ViewStub) C12809f.m76831d(this.view, R$id.vs_backup_data_area)).inflate();
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this.view, R$id.backup_data_area);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.4
            public ViewOnClickListenerC41714() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BackupDoubleBtnAlertDialog.this.reportClickBackupData("mecloud_cloudspacedialog_notenough_click_backup_data");
                Intent intent = new Intent();
                intent.putExtra("source", 2);
                intent.setClass(BackupDoubleBtnAlertDialog.this.mContext, BackupOptionsActivity.class);
                C0216g0.m1402e(BackupDoubleBtnAlertDialog.this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                Context context = BackupDoubleBtnAlertDialog.this.mContext;
                if (context != null) {
                    context.startActivity(intent);
                } else {
                    Context contextM1377a = C0213f.m1377a();
                    if (contextM1377a == null) {
                        C11839m.m70687e(BackupDoubleBtnAlertDialog.TAG, "initView() context is null.");
                        BackupDoubleBtnAlertDialog.this.finish();
                    } else {
                        contextM1377a.startActivity(intent);
                    }
                }
                C10152c.m63217a();
            }
        });
        showWaitAndBackupClearData(relativeLayout, this.backupNeedSpace);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void addExtraRecommendReportInfo(LinkedHashMap linkedHashMap) {
        List<CloudPackage> spacePackages;
        CloudPackage cloudPackage;
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.recommendInfo;
        if (getPackagesBySpaceRuleResp != null && (spacePackages = getPackagesBySpaceRuleResp.getSpacePackages()) != null && !spacePackages.isEmpty() && (cloudPackage = spacePackages.get(0)) != null) {
            linkedHashMap.put(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, cloudPackage.getId());
            linkedHashMap.put("recommend_package_capacity", Long.valueOf(cloudPackage.getCapacity()));
        }
        linkedHashMap.put("recommend_space_needed", Long.valueOf(this.totalNeedSpace));
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void addExtraShowReportInfo(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        linkedHashMap.put("is_new_dialog", Boolean.TRUE);
        linkedHashMap.put("recommend_space_needed", Long.valueOf(this.totalNeedSpace));
        if (linkedHashMap2 != null) {
            linkedHashMap.putAll(linkedHashMap2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void addRecommendInfo(Intent intent) {
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.recommendInfo;
        if (getPackagesBySpaceRuleResp == null) {
            intent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, false);
            return;
        }
        List<CloudPackage> spacePackages = getPackagesBySpaceRuleResp.getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            intent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, false);
            return;
        }
        CloudPackage cloudPackage = spacePackages.get(0);
        List<PackageGrades> packageGrades = this.recommendInfo.getPackageGrades();
        if (packageGrades == null || packageGrades.isEmpty()) {
            intent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, false);
            return;
        }
        PackageGrades packageGrades2 = packageGrades.get(0);
        intent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, true);
        intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, packageGrades2.getGradeCode());
        intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, packageGrades2.getCapacity());
        intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, cloudPackage.getId());
    }

    public boolean checkIsThreeButton(NotificationWithActivity notificationWithActivity) {
        List<PopUpWithActivityGoto> popupGoto3;
        return (notificationWithActivity == null || (popupGoto3 = notificationWithActivity.getPopupGoto3()) == null || popupGoto3.size() != 3) ? false : true;
    }

    public boolean checkRecommendSubscribeNotificationTwoButton(SpaceNotification spaceNotification) {
        List<PopUpWithActivityGoto> purchasePackageGoto;
        return (spaceNotification == null || (purchasePackageGoto = spaceNotification.getPurchasePackageGoto()) == null || purchasePackageGoto.size() != 2) ? false : true;
    }

    public boolean checkRecommendSubscribeTwoButton(NotificationWithActivity notificationWithActivity) {
        List<PopUpWithActivityGoto> purchasePackageGoto;
        return (notificationWithActivity == null || (purchasePackageGoto = notificationWithActivity.getPurchasePackageGoto()) == null || purchasePackageGoto.size() != 2) ? false : true;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void finish() {
        if (!this.frontAppClickStart) {
            C9494c.m59390r().m59408V(true);
        }
        super.finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void initView() {
        super.initView();
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.space_not_enough_alert_dialog_message, (ViewGroup) null);
        this.view = viewInflate;
        this.mIconImageView = (ImageView) C12809f.m76831d(viewInflate, R$id.iv_backup_fail);
        this.mActivityEntryImg = (ImageView) C12809f.m76831d(this.view, R$id.iv_activity_entry);
        this.viewDetailsArea = (RelativeLayout) C12809f.m76831d(this.view, R$id.view_details_area);
        this.noticeImage = (ImageView) C12809f.m76831d(this.view, R$id.view_details_image);
        this.noticeTextView = (TextView) C12809f.m76831d(this.view, R$id.view_details_text);
        this.mPPSAdLayout = (PPSAdLayout) C12809f.m76831d(this.view, R$id.pps_ad_layout);
        this.mFrontDoubleAppLayout = (FrontDoubleAppLayout) C12809f.m76831d(this.view, R$id.space_dialog_front_double_app);
        this.mFrontEntranceLayout = (DialogMarketLayout) C12809f.m76831d(this.view, R$id.space_dialog_front_entrance);
        this.mRecommendPackageLayout = (DialogMarketLayout) C12809f.m76831d(this.view, R$id.space_dialog_recommend_package);
        this.standByButtonFirstTv = (TextView) C12809f.m76831d(this.view, R$id.three_button_scene_button_1);
        this.standByButtonSecondTv = (TextView) C12809f.m76831d(this.view, R$id.three_button_scene_button_2);
        this.standByButtonThirdTv = (TextView) C12809f.m76831d(this.view, R$id.three_button_scene_button_3);
        this.backupManageArea = (FrameLayout) C12809f.m76831d(this.view, R$id.backup_data_area_layout);
        this.threeButtonArea = (LinearLayout) C12809f.m76831d(this.view, R$id.three_button_area);
        this.standByButtonFirstTv.setOnClickListener(this);
        this.standByButtonSecondTv.setOnClickListener(this);
        this.standByButtonThirdTv.setOnClickListener(this);
        initDialogTextFirst(this.view);
        initDialogTextSecond(this.view);
        setView(this.view);
        if (C0209d.m1194N1(this.mContext)) {
            C10798l.m65720e(this.mIconImageView);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public boolean isShowRecommendPackageWithSubscribeUser() {
        int i10 = this.mMarketRegionStyle;
        boolean z10 = i10 == 4 || i10 == 6;
        boolean z11 = (TextUtils.isEmpty(this.packageSubscribeDialogTitle) || TextUtils.isEmpty(this.packageSubscribeDialogDesc) || TextUtils.isEmpty(this.packageSubscribeTitle) || TextUtils.isEmpty(this.packageSubscribeDesc) || TextUtils.isEmpty(this.packageSubscribeButtonFirst) || TextUtils.isEmpty(this.packageSubscribeButtonSecond)) ? false : true;
        boolean z12 = !C13452e.m80781L().m80897c1();
        C11839m.m70688i(TAG, "isShowRecommendPackageWithSubscribeUser isStatusSatisfy = " + z10 + " isValueSatisfy = " + z11 + " haveRecommendSuscribeTwoButtonFull = " + this.haveRecommendSubscribeTwoButtonFull + " isSubscribe = " + z12);
        return z10 && z11 && this.haveRecommendSubscribeTwoButtonFull && z12;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        C11839m.m70686d(TAG, "onContentChanged---");
        if (this.mMarketRegionStyle == 5) {
            String activityEntryImgUrl = getActivityEntryImgUrl(this.mActivityEntry, C11842p.m70753O0(C0213f.m1377a()));
            if (TextUtils.isEmpty(activityEntryImgUrl)) {
                C11839m.m70687e(TAG, "onContentChanged activityEntryUrl is empty.");
                this.mActivityEntryImg.setVisibility(8);
            }
            Bitmap activityEntryBitmapByUrl = SpaceNoticeV3Manager.getInstance().getActivityEntryBitmapByUrl(activityEntryImgUrl);
            if (activityEntryBitmapByUrl == null) {
                C11839m.m70687e(TAG, "onContentChanged entryBmp is null.");
                this.mActivityEntryImg.setVisibility(8);
            }
            this.mActivityEntryImg.setImageBitmap(activityEntryBitmapByUrl);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C9494c.m59390r().m59410X(true);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        onDialogDestroy();
        C9494c.m59390r().m59410X(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public NotificationWithActivity prepareSpaceActivityNotEnoughDialog(NotificationWithActivity notificationWithActivity) {
        NoticeContent noticeContentQueryBackupNotifiCouponContent;
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog account is not login.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0029");
            return null;
        }
        if (this.backupNoticeNeedInfo == null) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog backupNoticeNeedInfo is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0030");
            return null;
        }
        if (notificationWithActivity == null) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog notification is null");
            return null;
        }
        this.f19203id = notificationWithActivity.getId();
        this.percentage = notificationWithActivity.getPercentage();
        this.isThreeButtonPopup = notificationWithActivity.getIsThreeButtonPopup();
        this.isDisplayBackUpData = notificationWithActivity.getIsDisplayBackUpData() == 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(notificationWithActivity);
        boolean zIsCanShowCoupon = isCanShowCoupon(notificationWithActivity.getEnableShowCoupon());
        boolean zM63287k = C10155f.m63287k(arrayList);
        if (this.backupNoticeNeedInfo.m73881j() == 1 && zM63287k) {
            ActivityEntry activityEntryM73874b = this.backupNoticeNeedInfo.m73874b();
            if (activityEntryM73874b == null) {
                C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog activityEntry is null.");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
                return null;
            }
            H5Resource h5ResourceById = HicloudH5ConfigManager.getInstance().getH5ResourceById(activityEntryM73874b.getResource());
            if (h5ResourceById != null) {
                this.frontAppNumber = h5ResourceById.getFrontAppNumber();
            }
            this.mMarketRegionStyle = marketRegionDisplayStyle(notificationWithActivity);
            String resource = activityEntryM73874b.getResource();
            setMarketRegionText(resource);
            C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog id = " + this.f19203id + " reSourceId = " + resource);
            if (zIsCanShowCoupon) {
                noticeContentQueryBackupNotifiCouponContent = NoticeWithActivityUtil.queryBackupNotifiCouponContent(notificationWithActivity, false);
                String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_V4_POPUP_TITLE);
                this.title = strFromDBByResource;
                if (TextUtils.isEmpty(strFromDBByResource)) {
                    this.title = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_POPUP_TITLE);
                }
                String strFromDBByResource2 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_V4_MAIN_TEXT);
                this.mainText = strFromDBByResource2;
                if (TextUtils.isEmpty(strFromDBByResource2)) {
                    this.mainText = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_V3_MAIN_TEXT);
                }
                this.buttonFirst = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_POPUP_BUTTON2_FIRST);
                this.buttonSecond = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_POPUP_BUTTON2_SECOND);
            } else {
                noticeContentQueryBackupNotifiCouponContent = NoticeWithActivityUtil.queryPopupNotificationContent(notificationWithActivity, false);
                String strFromDBByResource3 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V4_POP_TITLE);
                this.title = strFromDBByResource3;
                if (TextUtils.isEmpty(strFromDBByResource3)) {
                    this.title = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_TITLE);
                }
                String strFromDBByResource4 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V4_MAIN_TEXT);
                this.mainText = strFromDBByResource4;
                if (TextUtils.isEmpty(strFromDBByResource4)) {
                    this.mainText = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V3_MAIN_TEXT);
                }
                this.buttonFirst = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON2_FIRST);
                this.buttonSecond = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON2_SECOND);
            }
            this.standByButtonFirstText = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_STANDBY_BUTTON3_FIRST);
            this.standByButtonSecondText = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_STANDBY_BUTTON3_SECOND);
            this.standByButtonThirdText = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_STANDBY_BUTTON3_THIRD);
        } else {
            this.mMarketRegionStyle = marketRegionDisplayStyleForOversea(notificationWithActivity);
            C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog id = " + this.f19203id + " mActivityType = " + this.mActivityType);
            NoticeContent noticeContentQueryPopupNotificationContent = !zIsCanShowCoupon ? NoticeWithActivityUtil.queryPopupNotificationContent(notificationWithActivity, false) : NoticeWithActivityUtil.queryBackupNotifiCouponContent(notificationWithActivity, false);
            if (this.backupNoticeNeedInfo.m73881j() == 2 && zIsCanShowCoupon) {
                C0212e0.m1370t(this.mContext, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.BACKUP_COUPON_SHOW_TIME, System.currentTimeMillis());
            }
            this.title = getStringUseLock(noticeContentQueryPopupNotificationContent.getV4Title());
            this.mainText = getStringUseLock(noticeContentQueryPopupNotificationContent.getV4MainText());
            this.buttonFirst = getStringUseLock(noticeContentQueryPopupNotificationContent.getButtonFirst());
            this.buttonSecond = getStringUseLock(noticeContentQueryPopupNotificationContent.getButtonSecond());
            if (TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.mainText) || TextUtils.isEmpty(this.buttonFirst) || TextUtils.isEmpty(this.buttonSecond)) {
                C11839m.m70687e(TAG, "prepareBtnAndDescription get defaul language");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", "0033");
                return null;
            }
            noticeContentQueryBackupNotifiCouponContent = noticeContentQueryPopupNotificationContent;
        }
        C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog, mMarketRegionStyle: " + this.mMarketRegionStyle);
        if (noticeContentQueryBackupNotifiCouponContent == null) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog noticePopContent is null");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
            return null;
        }
        if (!setDialogMainText()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
            return null;
        }
        this.mActivityEntry = notificationWithActivity.getActivityEntry();
        this.mNoticeType = notificationWithActivity.getNoticeType();
        String activityEntryGotoInfo = getActivityEntryGotoInfo(notificationWithActivity.getActivityEntry(), true);
        this.mDefaultMainText = getDefaultMainText(NoticeWithActivityUtil.queryBackupDetailNoticeContent(notificationWithActivity, true, activityEntryGotoInfo));
        this.mNoticeDetail = NoticeWithActivityUtil.queryBackupDetailNoticeContent(notificationWithActivity, false, activityEntryGotoInfo);
        getNotificationWithActivityRecommendTipInfo(notificationWithActivity, activityEntryGotoInfo);
        prepareWaitBackupData();
        boolean zM63235s = C10152c.m63235s(notificationWithActivity, this.mContext, this.isFamilyShareMember);
        this.isShowViewDetails = zM63235s;
        prepareActivityViewDetail(zM63235s, notificationWithActivity);
        preparePackageInfo(noticeContentQueryBackupNotifiCouponContent);
        return notificationWithActivity;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public SpaceNotification prepareSpaceNotEnoughDialog(SpaceNotification spaceNotification) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog account is not login.");
            return null;
        }
        if (spaceNotification == null) {
            C11839m.m70688i(TAG, "prepareSpaceNotEnoughDialog show spaceNotification is null");
            return null;
        }
        this.f19203id = spaceNotification.getId();
        C11839m.m70688i(TAG, "prepareSpaceNotEnoughDialog id = " + this.f19203id);
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        this.gotoButtonWhich = noticeGoto.getGotoButtonWhich();
        this.isShowViewDetails = C10152c.m63234r(this.mContext, spaceNotification, this.isFamilyShareMember);
        int iM63219c = C10152c.m63219c(this.mContext);
        if (this.isShowViewDetails) {
            iM63219c++;
        }
        Intent cloudSpaceIntent = getCloudSpaceIntent(spaceNotification);
        this.cloudSpaceIntent = cloudSpaceIntent;
        this.cloudSpaceIntent = C10152c.m63229m(cloudSpaceIntent, spaceNotification, noticeGoto, iM63219c, true);
        NoticeContent noticeContentPopup = !isCanShowCoupon(spaceNotification.getEnableShowCoupon()) ? CloudSpaceNotifyUtil.getInstance().getNoticeContentPopup(spaceNotification) : CloudSpaceNotifyUtil.getInstance().getNoticeCouponContent(spaceNotification);
        if (noticeContentPopup == null) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog popupContent null");
            return null;
        }
        if (!prepareTitleAndMainText(noticeContentPopup) || !setDialogMainText()) {
            return null;
        }
        this.isDisplayBackUpData = spaceNotification.getIsDisplayBackUpData() == 1;
        this.mMarketRegionStyle = C11273b.m67656k(spaceNotification);
        this.mActivityEntry = spaceNotification.getActivityEntry();
        this.mNoticeType = spaceNotification.getNoticeType();
        String activityEntryGotoInfo = getActivityEntryGotoInfo(this.mActivityEntry, true);
        this.mNoticeDetail = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailByType(spaceNotification, activityEntryGotoInfo);
        this.mDefaultMainText = getDefaultMainText(CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailDefault(spaceNotification, activityEntryGotoInfo));
        getSpaceNotificationRecommendTipInfo(spaceNotification, activityEntryGotoInfo);
        this.percentage = spaceNotification.getPercentage();
        preparePackageInfo(noticeContentPopup);
        prepareWaitBackupData();
        prepareViewDetail(this.isShowViewDetails, spaceNotification);
        return spaceNotification;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void processButtonClick(int i10) {
        this.mDestroyType = i10;
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void refreshCheckboxStatus(boolean z10) {
        DialogMarketLayout dialogMarketLayout = this.mRecommendPackageLayout;
        if (dialogMarketLayout == null) {
            C11839m.m70687e(TAG, "refreshCheckboxStatus, mRecommendPackageLayout is null.");
        } else {
            dialogMarketLayout.refreshCheckboxStatus(z10);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("way_of_purchase", "backup_dialog_purchase");
        addExtraRecommendReportInfo(linkedHashMap);
        C13225d.m79490f1().m79591l0(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMap);
    }

    public void show(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "show double alert backupSpaceNotEnoughNeedData is null.");
            finish();
            return;
        }
        int iM73881j = c12295b.m73881j();
        if (iM73881j == 2 && backupSpaceNotEnoughNeedData.isFamilyShareMember()) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0021", "0012");
            finish();
            return;
        }
        if (iM73881j == 1) {
            this.mNotificationWithActivityOrTaskCenter = c12295b.m73882k();
        }
        if (iM73881j == 2) {
            this.mNotificationWithActivityOrTaskCenter = c12295b.m73883l();
        }
        SpaceNotification spaceNotificationM73886o = c12295b.m73886o();
        this.mNotification = spaceNotificationM73886o;
        if (this.mNotificationWithActivityOrTaskCenter == null && spaceNotificationM73886o == null) {
            C11839m.m70687e(TAG, "show double alert notification is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            finish();
            return;
        }
        this.totalNeedSpace = backupSpaceNotEnoughNeedData.getTotalNeedSpace();
        this.backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
        this.notUsedSpace = backupSpaceNotEnoughNeedData.getNotUsedSpace();
        this.totalSpace = backupSpaceNotEnoughNeedData.getTotalSpace();
        this.usedSpace = backupSpaceNotEnoughNeedData.getUsedSpace();
        this.isFamilyShareMember = backupSpaceNotEnoughNeedData.isFamilyShareMember();
        this.galleryNum = backupSpaceNotEnoughNeedData.getGalleryNum();
        this.backupNoticeNeedInfo = c12295b;
        this.recommendInfo = c12295b.m73885n();
        this.isCouponFrequence = c12295b.m73889r();
        this.dialogBtnGoto = c12295b.m73877e();
        this.autoBackup = c12295b.m73875c();
        this.isThirdAppSwitchOpen = new C13026e().m78395p();
        this.haveThreeButtonFull = checkIsThreeButton(this.mNotificationWithActivityOrTaskCenter);
        if (iM73881j == 0) {
            this.haveRecommendSubscribeTwoButtonFull = checkRecommendSubscribeNotificationTwoButton(this.mNotification);
        } else {
            this.haveRecommendSubscribeTwoButtonFull = checkRecommendSubscribeTwoButton(this.mNotificationWithActivityOrTaskCenter);
        }
        this.mRecommendPackageLayout.setPackageCardRenewAgreementText(c12295b.m73884m());
        this.mRecommendPackageLayout.setCheckDialogRenewAgreementText(c12295b.m73876d());
        this.renewAgreementTVCallback = renewAgreementTVCallback;
        this.dlgRenewAgreementText = c12295b.m73876d();
        processSpaceNotEnough(iM73881j);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void showSpaceActivityNotEnoughDialog(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog notification is null");
            finish();
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceActivityNotEnoughDialog account is not login.");
            finish();
            return;
        }
        C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog id = " + this.f19203id);
        if (isShowRecommendPackageWithSubscribeUser()) {
            this.dialogTextFirst.setText(this.packageSubscribeDialogTitle);
            this.dialogTextSecond.setText(this.packageSubscribeDialogDesc);
        } else {
            this.dialogTextFirst.setText(this.title);
            this.dialogTextSecond.setText(this.mainText);
        }
        boolean zM63235s = C10152c.m63235s(notificationWithActivity, this.mContext, this.isFamilyShareMember);
        int iM63219c = C10152c.m63219c(this.mContext);
        if (zM63235s) {
            iM63219c++;
        }
        if (isShowThreeButtonNewStyleForFrontEntranceByApp()) {
            processNoticeAcitvityPopGotoIntentForThreeButton(notificationWithActivity, iM63219c);
        } else if (isShowRecommendPackageWithSubscribeUser()) {
            this.buttonFirst = this.packageSubscribeButtonFirst;
            this.buttonSecond = this.packageSubscribeButtonSecond;
            processNoticeAcitvityPopGotoIntentForSubscribe(notificationWithActivity, iM63219c);
        } else {
            processNoticeAcitvityPopGotoIntent(notificationWithActivity, iM63219c);
            showWaitBackupLayout();
            checkShowViewDetails(zM63235s);
        }
        float percentage = notificationWithActivity.getPercentage();
        LinkedHashMap linkedHashMapShowMarketArea = showMarketArea(this.mMarketRegionStyle);
        if (((BackupNotificationActivity) this.mContext).isFinishing()) {
            C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog is finished");
            finish();
        } else if (!checkBtnStrValid()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
        } else if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog function item switch off");
        } else {
            doSpaceNotEnoughReport(linkedHashMapShowMarketArea, percentage);
            show();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog
    public void showSpaceNotEnoughDialog(SpaceNotification spaceNotification) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceNotEnoughDialog account is not login.");
            finish();
            return;
        }
        C11839m.m70688i(TAG, "showSpaceNotEnoughDialog id = " + this.f19203id);
        if (isShowRecommendPackageWithSubscribeUser()) {
            this.dialogTextFirst.setText(this.packageSubscribeDialogTitle);
            this.dialogTextSecond.setText(this.packageSubscribeDialogDesc);
        } else {
            this.dialogTextFirst.setText(this.title);
            this.dialogTextSecond.setText(this.mainText);
        }
        if (isShowRecommendPackageWithSubscribeUser()) {
            int iM63219c = C10152c.m63219c(this.mContext);
            this.buttonFirst = this.packageSubscribeButtonFirst;
            this.buttonSecond = this.packageSubscribeButtonSecond;
            setDialogButtonForRecommendPackageWithSubscribe(spaceNotification, iM63219c);
        } else {
            setDialogButton();
        }
        LinkedHashMap linkedHashMapShowMarketArea = showMarketArea(this.mMarketRegionStyle);
        if (((BackupNotificationActivity) this.mContext).isFinishing()) {
            C11839m.m70688i(TAG, "BackupNotificationActivity is finished");
            finish();
            return;
        }
        showBackupData();
        checkShowViewDetails(this.isShowViewDetails);
        if (!checkBtnStrValid()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
        } else if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog function item switch off");
        } else {
            doSpaceNotEnoughReport(linkedHashMapShowMarketArea, this.percentage);
            show();
        }
    }

    public void startFrameAnimation() {
        ImageView imageView = this.mIconImageView;
        if (imageView != null) {
            C10798l.m65719d(imageView);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void startPaymentProcess(C0079a c0079a) {
        C11839m.m70688i(TAG, "startPaymentProcess");
        clickPayBtn();
    }

    public void stopFrameAnimation() {
        ImageView imageView = this.mIconImageView;
        if (imageView != null) {
            C10798l.m65721f(imageView);
        }
    }

    private boolean showActivityEntry(NotifyActivityEntry notifyActivityEntry, String str, NoticeDetail noticeDetail, boolean z10, String str2, RecommendTipInfo recommendTipInfo, LinkedHashMap linkedHashMap) {
        ImageView imageView = this.mActivityEntryImg;
        if (imageView != null) {
            imageView.setVisibility(0);
            String activityEntryImgUrl = getActivityEntryImgUrl(notifyActivityEntry, C11842p.m70753O0(C0213f.m1377a()));
            if (TextUtils.isEmpty(activityEntryImgUrl)) {
                C11839m.m70687e(TAG, "showActivityEntry activityEntryUrl is empty.");
                this.mActivityEntryImg.setVisibility(8);
                linkedHashMap.put("is_dialog_show_activity_entry", Boolean.FALSE);
                return true;
            }
            Bitmap activityEntryBitmapByUrl = SpaceNoticeV3Manager.getInstance().getActivityEntryBitmapByUrl(activityEntryImgUrl);
            if (activityEntryBitmapByUrl == null) {
                C11839m.m70687e(TAG, "showActivityEntry entryBmp is null.");
                this.mActivityEntryImg.setVisibility(8);
                linkedHashMap.put("is_dialog_show_activity_entry", Boolean.FALSE);
                return true;
            }
            this.mActivityEntryImg.setImageBitmap(activityEntryBitmapByUrl);
            String activityEntryGotoInfo = getActivityEntryGotoInfo(notifyActivityEntry, true);
            String activityEntryGotoInfo2 = getActivityEntryGotoInfo(notifyActivityEntry, false);
            if (TextUtils.isEmpty(activityEntryGotoInfo)) {
                C11839m.m70688i(TAG, "showActivityEntry gotoType or gotoUri is null");
                this.mActivityEntryImg.setVisibility(8);
                linkedHashMap.put("is_dialog_show_activity_entry", Boolean.FALSE);
                return true;
            }
            this.mActivityEntryImg.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupDoubleBtnAlertDialog.3
                final /* synthetic */ String val$defaultMainText;
                final /* synthetic */ String val$gotoType;
                final /* synthetic */ String val$gotoUri;
                final /* synthetic */ boolean val$isWithActivity;
                final /* synthetic */ NoticeDetail val$noticeDetail;
                final /* synthetic */ String val$noticeType;
                final /* synthetic */ RecommendTipInfo val$recommendTipInfo;

                public ViewOnClickListenerC41703(String activityEntryGotoInfo3, String activityEntryGotoInfo22, String str3, NoticeDetail noticeDetail2, String str22, boolean z102, RecommendTipInfo recommendTipInfo2) {
                    str = activityEntryGotoInfo3;
                    str = activityEntryGotoInfo22;
                    str = str3;
                    noticeDetail = noticeDetail2;
                    str = str22;
                    z = z102;
                    recommendTipInfo = recommendTipInfo2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BackupDoubleBtnAlertDialog.this.processActivityEntryBiUbaReport(str, str);
                    BackupDoubleBtnAlertDialog.this.mContext.startActivity(BackupDoubleBtnAlertDialog.this.getActivityEntryIntent(str, str, str, noticeDetail, str, z, recommendTipInfo));
                    BackupDoubleBtnAlertDialog.this.dismiss();
                    BackupDoubleBtnAlertDialog.this.finish();
                    BackupDoubleBtnAlertDialog.this.processRemoveTask();
                    ScreenListener.m18023c(BackupDoubleBtnAlertDialog.this.mContext).m18028g();
                    new BackupNotificationManager(BackupDoubleBtnAlertDialog.this.mContext).cancelSpaceNotEnoughNotify();
                }
            });
        }
        return false;
    }
}
