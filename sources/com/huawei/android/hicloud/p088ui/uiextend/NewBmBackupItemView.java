package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardViewData;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.constant.BackupCardTaskOperation;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.task.GetBackupCardInfoTask;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.TextBannerView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MobileNetTipDialog;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.sync.R$dimen;
import gp.C10028c;
import java.util.EnumSet;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0226l0;
import p292fn.C9733f;
import p336he.C10155f;
import p422k9.C11019b;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12526j;
import p676ud.C13164k;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import p847zk.C14315h;
import p847zk.C14317j;
import sk.C12809f;

/* loaded from: classes3.dex */
public class NewBmBackupItemView extends FrameLayout {
    private static final EnumSet<BackupCardTaskOperation> DEFAULT_OPERATIONS = EnumSet.of(BackupCardTaskOperation.QUERY_BACKUP_RESTORE_STATE, BackupCardTaskOperation.QUERY_MODULE_INFO);
    private static final String TAG = "NewBmBackupItemView";
    private boolean backFromDeviceManager;
    private final Handler.Callback callback;
    private CloudBackupState cloudBackupState;
    private View contentLoading;
    private Context context;
    private View iVPopNotify;
    private View icon;
    View inflateView;
    private boolean isTaskIntercept;
    private View itemMainLayout;
    private ImageView ivClickArrow;
    private View ivClickRecord;
    private View ivClickRecordLy;
    private View loadingView;
    private Activity mActivity;
    private BackupCardInfo mainBackupItemData;
    private LinearLayout mainItemLyClick;
    MobileNetTipDialog.MobileNetTipClickListener mobileNetTipClickListener;
    private MobileNetTipDialog mobileNetTipDialog;
    private final EnumSet<BackupCardTaskOperation> operations;
    private boolean showDataInterceptByDialog;
    private View subTitleLayout;
    private UnionSwitch switchBt;
    private TextBannerView textBannerView;
    private C13164k tipBubbleView;
    private TextView tvItemContent;
    private TextView tvItemSubTitle;
    private TextView tvItemTip;
    private TextView tvItemTitle;
    private BackupCardViewData viewData;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.NewBmBackupItemView$1 */
    public class C41211 extends AbstractC12367d {
        public C41211() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            int iM75431z = new C12526j().m75431z();
            long jQuerylastsuccesstime = new SettingOperator().querylastsuccesstime();
            C11839m.m70688i(NewBmBackupItemView.TAG, "checkBackup lastSuccessTime: " + jQuerylastsuccesstime + " ,bmBaseDataBackupCycle: " + iM75431z);
            if (System.currentTimeMillis() - jQuerylastsuccesstime > iM75431z * 86400000) {
                C11839m.m70688i(NewBmBackupItemView.TAG, "manualBaseBackup result: " + CloudBackupService.getInstance().manualBaseBackup(false));
            }
        }
    }

    public NewBmBackupItemView(Context context) {
        super(context);
        this.operations = EnumSet.of(BackupCardTaskOperation.QUERY_BACKUP_DEVICE_SHOW);
        this.showDataInterceptByDialog = false;
        this.mobileNetTipClickListener = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.k
            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                NewBmBackupItemView.lambda$new$0(dialogInterface, i10);
            }
        };
        this.callback = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.uiextend.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f19274a.lambda$new$3(message);
            }
        };
        this.context = context;
        initView();
    }

    private boolean backupConditionCheck() {
        if (!C13452e.m80781L().m80791C0()) {
            C11839m.m70688i(TAG, "backupIfNeeded is not base business");
            return true;
        }
        if (!C10028c.m62182c0().m62413x() || !C10155f.m63301y() || C0209d.m1293p1()) {
            C11839m.m70688i(TAG, "backupIfNeeded not support backup");
            return true;
        }
        if (!CBAccess.inBackup() && !CBAccess.inRestoreWithRetryClearCheck(true) && !CBAccess.hasValidTempBackup()) {
            return false;
        }
        C11839m.m70688i(TAG, "backupIfNeeded in backup or restore");
        return true;
    }

    private void cancelClose() {
        if (this.showDataInterceptByDialog) {
            refreshState();
        }
    }

    private void closeMobileNetTipDialog() {
        MobileNetTipDialog mobileNetTipDialog = this.mobileNetTipDialog;
        if (mobileNetTipDialog != null) {
            mobileNetTipDialog.dismiss();
        }
    }

    private EnumSet<BackupCardTaskOperation> getOperationsByData() {
        if (this.cloudBackupState == null || this.mainBackupItemData == null) {
            return DEFAULT_OPERATIONS.clone();
        }
        EnumSet enumSetClone = DEFAULT_OPERATIONS.clone();
        enumSetClone.addAll(this.operations);
        return enumSetClone;
    }

    private void handleDeleteDeviceResult(Message message) {
        int i10 = message.arg1;
        boolean z10 = message.arg2 == 0 && 33045 == message.what;
        Integer numM66437p = C11019b.m66371t().m66437p(i10);
        if (numM66437p == null) {
            refreshDeviceQuery();
            return;
        }
        if (z10) {
            C11841o.m70707c(this.context, numM66437p.intValue(), 0);
        }
        cancelClose();
    }

    private void initLoadingView() {
        if (this.loadingView == null) {
            this.loadingView = C11842p.m70848p(this.inflateView, R$id.backup_item_loading_progress).inflate();
        }
        this.loadingView.setVisibility(0);
    }

    private void initView() {
        C11839m.m70688i(TAG, "initView");
        if (C0209d.m1195O(this.context) >= 1.75f) {
            this.inflateView = View.inflate(this.context, R$layout.home_page_backup_new_bm_item_scale, this);
        } else {
            this.inflateView = View.inflate(this.context, R$layout.home_page_backup_new_bm_item, this);
        }
        this.itemMainLayout = C12809f.m76831d(this.inflateView, R$id.item_layout);
        this.tvItemTitle = (TextView) C12809f.m76831d(this.inflateView, R$id.backup_item_title);
        View viewM76831d = C12809f.m76831d(this.inflateView, R$id.iv_pop_notify);
        this.iVPopNotify = viewM76831d;
        viewM76831d.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f19272a.lambda$initView$1(view);
            }
        });
        this.tvItemTip = (TextView) C12809f.m76831d(this.inflateView, R$id.backup_item_tip);
        this.subTitleLayout = C12809f.m76831d(this.inflateView, R$id.sub_title_layout);
        this.icon = C12809f.m76831d(this.inflateView, R$id.current_item_icon);
        this.tvItemSubTitle = (TextView) C12809f.m76831d(this.inflateView, R$id.backup_item_subtitle);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76831d(this.inflateView, R$id.backup_item_switch_btn);
        this.switchBt = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(null);
        this.switchBt.setEnabled(true);
        this.switchBt.setRestoreCheckStatus(false);
        this.ivClickArrow = (ImageView) C12809f.m76831d(this.inflateView, R$id.backup_item_click_arrow);
        this.textBannerView = (TextBannerView) C12809f.m76831d(this.inflateView, R$id.backup_item_bannerView);
        this.mainItemLyClick = (LinearLayout) C12809f.m76831d(this.inflateView, R$id.current_backup_item);
        this.tvItemContent = (TextView) C12809f.m76831d(this.inflateView, R$id.backup_item_content);
        this.contentLoading = C12809f.m76831d(this.inflateView, R$id.content_loading_bar);
        this.ivClickRecord = C12809f.m76831d(this.inflateView, R$id.backup_item_click_record);
        this.ivClickRecordLy = C12809f.m76831d(this.inflateView, R$id.backup_item_click_record_ly);
        initLoadingView();
        if (!C0209d.m1166E1()) {
            disable();
        }
        registerListener();
        BackupCardInfo cacheBackupCardInfo = GetBackupCardInfoTask.getCacheBackupCardInfo();
        this.mainBackupItemData = cacheBackupCardInfo;
        setViewData(cacheBackupCardInfo.dataTransfer());
        showByData();
        C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
    }

    public /* synthetic */ void lambda$initView$1(View view) throws Resources.NotFoundException {
        if (this.tipBubbleView == null) {
            this.tipBubbleView = new C13164k(this.mActivity);
        }
        C13164k c13164k = this.tipBubbleView;
        View view2 = this.iVPopNotify;
        String string = this.mActivity.getString(R$string.backup_base_data_tips);
        Resources resources = getContext().getResources();
        int i10 = R$dimen.hiad_8_dp;
        c13164k.m79173x(view2, string, -resources.getDimensionPixelOffset(i10), getContext().getResources().getDimensionPixelOffset(i10));
    }

    public static /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i10) {
        if (i10 == -2) {
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportNetworkBackup("1");
        } else {
            if (i10 != -1) {
                return;
            }
            C11839m.m70688i(TAG, "MobileNetTipClick OK start manualBaseBackup :" + CloudBackupService.getInstance().manualBaseBackup(true));
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportNetworkBackup("0");
        }
    }

    public /* synthetic */ boolean lambda$new$3(Message message) {
        int i10 = message.what;
        if (32309 == i10 || 33045 == i10) {
            C11839m.m70686d(TAG, "CALLBACK_DELETE_DEVICERECORDS");
            handleDeleteDeviceResult(message);
            return false;
        }
        if (i10 == 34571) {
            BackupCardInfo backupCardInfo = (BackupCardInfo) message.obj;
            this.mainBackupItemData = backupCardInfo;
            EnumSet<BackupCardTaskOperation> operations = backupCardInfo.getOperations();
            if (!AbstractC14026a.m84159a(operations)) {
                this.operations.addAll(operations);
            }
            C11839m.m70688i(TAG, "dataTransfer: " + operations);
            setViewData(this.mainBackupItemData.dataTransfer());
            showByData();
            return false;
        }
        if (i10 == 34572) {
            getOperations().add((BackupCardTaskOperation) message.obj);
            return false;
        }
        if (i10 == 32999) {
            if (message.arg1 != 3) {
                return false;
            }
            refreshDeviceQuery();
            return false;
        }
        if (i10 != 34573) {
            return false;
        }
        BackupCardInfo backupCardInfo2 = this.mainBackupItemData;
        if (backupCardInfo2 == null) {
            C11839m.m70688i(TAG, "mainBackupItemData is null");
            return false;
        }
        backupCardInfo2.setHasSuccessDevice((Boolean) message.obj);
        C11839m.m70688i(TAG, "refresh device result");
        setViewData(this.mainBackupItemData.dataTransfer());
        showByData();
        return false;
    }

    public /* synthetic */ void lambda$showByData$2(View view) {
        if (this.viewData.getMainItemClick() == null) {
            C11839m.m70688i(TAG, "viewData.getMainItemClick() is null");
        } else {
            this.viewData.getMainItemClick().accept(this.context, Boolean.valueOf(this.backFromDeviceManager));
        }
    }

    public /* synthetic */ void lambda$taskExecute$4() {
        if (this.isTaskIntercept) {
            taskExecute();
        }
    }

    public /* synthetic */ void lambda$taskExecute$5() {
        C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f19273a.lambda$taskExecute$4();
            }
        });
    }

    private void loadingEnd() {
        this.loadingView.setVisibility(8);
        this.itemMainLayout.setVisibility(0);
    }

    private void refreshDeviceQuery() {
        getOperations().add(BackupCardTaskOperation.QUERY_BACKUP_DEVICE_SHOW);
        refreshState();
    }

    private void refreshState() {
        CloudBackupState cloudBackupState = this.cloudBackupState;
        if (cloudBackupState == null) {
            C14317j.m85300d().m85319t();
        } else {
            show(cloudBackupState);
        }
    }

    private void registerListener() {
        CloudBackupService.getInstance().register(this.callback);
    }

    private void showByData() {
        if (CloudBackupService.getInstance().isDeletingDeviceRecord()) {
            C11839m.m70688i(TAG, "showByData background is deleting device");
            return;
        }
        loadingEnd();
        this.tvItemTitle.setText(this.viewData.getTitle());
        boolean z10 = false;
        this.iVPopNotify.setVisibility(this.viewData.isShowSwitch() ? 0 : 8);
        this.subTitleLayout.setVisibility(this.viewData.isShowSubTitle() ? 0 : 8);
        if (this.viewData.isShowSubTitle()) {
            if (this.viewData.isSubtitleCarousel()) {
                this.textBannerView.setVisibility(8);
                this.tvItemSubTitle.setVisibility(8);
                this.textBannerView.setVisibility(0);
                this.textBannerView.setData(this.viewData.getSubTitleProperties());
            } else {
                this.textBannerView.setVisibility(8);
                this.tvItemSubTitle.setVisibility(0);
                this.tvItemSubTitle.setText(this.viewData.getSubTitle());
                this.tvItemSubTitle.setTextColor(this.viewData.getSubTitleColor());
            }
        }
        this.tvItemContent.setVisibility((!this.viewData.isShowContent() || this.viewData.isLoadingModule()) ? 8 : 0);
        String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_backup_card_basic_server_tips");
        if (TextUtils.isEmpty(spaceMultLanguage)) {
            this.tvItemTip.setText(R$string.backup_tip);
        } else {
            this.tvItemTip.setText(spaceMultLanguage);
        }
        this.tvItemTip.setVisibility(C13452e.m80781L().m80791C0() ? 0 : 8);
        this.contentLoading.setVisibility((this.viewData.isShowContent() && this.viewData.isLoadingModule()) ? 0 : 8);
        if (this.tvItemContent.getVisibility() == 0) {
            this.tvItemContent.setText(this.viewData.getContent());
        }
        this.switchBt.setVisibility(this.viewData.isShowSwitch() ? 0 : 8);
        BackupCardInfo backupCardInfo = this.mainBackupItemData;
        if (backupCardInfo == null || !backupCardInfo.isBasicData()) {
            this.mainItemLyClick.setMinimumHeight(getResources().getDimensionPixelSize(com.huawei.android.p073ds.R$dimen.cloud_space_72_dp));
        } else {
            this.mainItemLyClick.setMinimumHeight(getResources().getDimensionPixelSize(com.huawei.android.p073ds.R$dimen.cloud_space_80_dp));
        }
        this.ivClickRecordLy.setVisibility(this.viewData.isShowArrow() ? 8 : 0);
        this.ivClickArrow.setVisibility(this.viewData.isShowArrow() ? 0 : 8);
        this.ivClickRecord.setVisibility(this.viewData.isShowBackupDevice() ? 0 : 8);
        LinearLayout linearLayout = this.mainItemLyClick;
        if (this.itemMainLayout.isEnabled() && this.viewData.isMainItemEnableClick()) {
            z10 = true;
        }
        linearLayout.setEnabled(z10);
        this.mainItemLyClick.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19275a.lambda$showByData$2(view);
            }
        });
    }

    private void taskExecute() {
        if (C12515a.m75110o().m75158X0(GetBackupCardInfoTask.class.getName())) {
            C11839m.m70688i(TAG, "GetBackupCardInfoTask is executing");
            this.isTaskIntercept = true;
            return;
        }
        EnumSet<BackupCardTaskOperation> operationsByData = getOperationsByData();
        if (AbstractC14026a.m84159a(operationsByData)) {
            C11839m.m70688i(TAG, "operationEnumSet is empty");
            return;
        }
        this.operations.clear();
        this.showDataInterceptByDialog = false;
        this.isTaskIntercept = false;
        C12515a.m75110o().m75175e(new GetBackupCardInfoTask(this.cloudBackupState, operationsByData, this.mainBackupItemData, new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f19271a.lambda$taskExecute$5();
            }
        }), true);
    }

    public void backupIfNeeded() {
        if (backupConditionCheck()) {
            return;
        }
        if (!C0209d.m1254f2(this.context)) {
            C11839m.m70688i(TAG, "backupIfNeeded wifi not ok");
            return;
        }
        C14315h.m85262p().m85281r(C13452e.m80781L().m80887a1(), C13452e.m80781L().m80790C());
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            C11839m.m70688i(TAG, "backupIfNeeded base backup off");
        } else if (C0209d.m1166E1()) {
            C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.ui.uiextend.NewBmBackupItemView.1
                public C41211() {
                }

                @Override // p616rk.AbstractRunnableC12516b
                public void call() {
                    int iM75431z = new C12526j().m75431z();
                    long jQuerylastsuccesstime = new SettingOperator().querylastsuccesstime();
                    C11839m.m70688i(NewBmBackupItemView.TAG, "checkBackup lastSuccessTime: " + jQuerylastsuccesstime + " ,bmBaseDataBackupCycle: " + iM75431z);
                    if (System.currentTimeMillis() - jQuerylastsuccesstime > iM75431z * 86400000) {
                        C11839m.m70688i(NewBmBackupItemView.TAG, "manualBaseBackup result: " + CloudBackupService.getInstance().manualBaseBackup(false));
                    }
                }
            });
        } else {
            C11839m.m70688i(TAG, "backupIfNeeded not ownerUser");
        }
    }

    public void disable() {
        setEnabled(false);
        this.tvItemTitle.setAlpha(0.62f);
        this.icon.setAlpha(0.62f);
        this.ivClickArrow.setAlpha(0.62f);
        this.tvItemContent.setAlpha(0.62f);
        this.tvItemTip.setAlpha(0.62f);
        this.itemMainLayout.setEnabled(false);
        this.subTitleLayout.setEnabled(false);
        this.subTitleLayout.setAlpha(0.62f);
        this.switchBt.setEnabled(false);
        this.ivClickRecord.setEnabled(false);
        this.ivClickRecord.setAlpha(0.62f);
        this.iVPopNotify.setAlpha(0.62f);
        this.iVPopNotify.setEnabled(false);
    }

    public EnumSet<BackupCardTaskOperation> getOperations() {
        return this.operations;
    }

    public boolean gradeChangeCheck() {
        if (this.mainBackupItemData != null) {
            return !Boolean.valueOf(r1.isBasicData()).equals(Boolean.valueOf(C13452e.m80781L().m80791C0()));
        }
        C11839m.m70688i(TAG, "gradeChangeCheck mainBackupItemData is null");
        return false;
    }

    public void onDestroy() {
        C11839m.m70688i(TAG, "onDestroy");
        CloudBackupService.getInstance().unregister(this.callback);
        closeMobileNetTipDialog();
        C13164k c13164k = this.tipBubbleView;
        if (c13164k != null) {
            c13164k.m79155f();
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setBackFromDeviceManager(boolean z10) {
        this.backFromDeviceManager = z10;
    }

    public void setViewData(BackupCardViewData backupCardViewData) {
        this.viewData = backupCardViewData;
    }

    public void show(CloudBackupState cloudBackupState) {
        this.cloudBackupState = cloudBackupState.copy();
        taskExecute();
    }

    public NewBmBackupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.operations = EnumSet.of(BackupCardTaskOperation.QUERY_BACKUP_DEVICE_SHOW);
        this.showDataInterceptByDialog = false;
        this.mobileNetTipClickListener = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.k
            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                NewBmBackupItemView.lambda$new$0(dialogInterface, i10);
            }
        };
        this.callback = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.uiextend.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f19274a.lambda$new$3(message);
            }
        };
        this.context = context;
        initView();
    }
}
