package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.TextBannerView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Calendar;
import ne.C11667a;
import p015ak.C0209d;
import p015ak.C0223k;
import p336he.C10155f;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p618rm.C12591s1;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13467g;
import p742wj.C13612b;
import p744wl.C13619c;
import p847zk.C14317j;
import p848zl.C14339h;
import p848zl.C14342k;
import sk.C12809f;
import tl.C13029h;
import tl.C13030i;
import tl.C13033l;

/* loaded from: classes3.dex */
public class BackupItemView extends LinearLayout implements View.OnClickListener {
    private static final float DISABLE_ALPHA = 0.6f;
    private static final String TAG = "BackupItemView";
    private static final int YEAR_DAY = 365;
    private ProgressButton backupingPauseBtn;
    private View backupingStateView;
    private CloudBackupState cloudBackupState;
    private View defaultBackupNowBtn;
    private HwProgressBar defaultBackupNowLoading;
    private AutoSizeButton defaultOpenNowBtn;
    private View defaultStateView;
    private View doneBackupNowBtn;
    private HwProgressBar doneBackupNowLoading;
    private TextBannerView doneBannerView;
    private View doneStateView;
    private AutoSizeButton doneViewRestoreBtn;
    private View inflateView;
    private boolean isRefurbishing;
    private View loadingView;
    private Context mContext;
    private View overdaysOpenNowBtn;
    private HwProgressBar overdaysOpenNowLoading;
    private View overdaysStateView;
    private ProgressButton pauseContinueBtn;
    private AutoSizeButton pauseDetailsBtn;
    private View pauseStateView;
    private AutoSizeButton restorePauseBtn;
    private View restorePauseStateView;
    private ProgressButton restoringDetailsBtn;
    private View restoringStateView;

    public BackupItemView(Context context) {
        super(context);
        this.isRefurbishing = false;
        this.mContext = context;
        boolean zM75941k = C12591s1.m75931a().m75941k();
        C14317j.m85300d().m85316q(zM75941k);
        this.isRefurbishing = zM75941k;
        initView(context);
    }

    private ViewStub findViewStubById(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    private int getDifferenceDays(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j10 > jCurrentTimeMillis) {
            jCurrentTimeMillis = j10;
        }
        long j11 = (jCurrentTimeMillis - j10) / 86400000;
        if (j11 == 0) {
            j11++;
        }
        return (int) j11;
    }

    private String getLastBackupTime() throws IllegalAccessException, InstantiationException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.cloudBackupState.getLastSuccessTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(6);
        int i11 = calendar2.get(6);
        if (i10 == i11) {
            return this.mContext.getString(R$string.temp_backup_today, C11667a.m69661c(this.mContext, this.cloudBackupState.getLastSuccessTime(), 68097));
        }
        if (i11 - i10 != 1) {
            return C11667a.m69661c(this.mContext, this.cloudBackupState.getLastSuccessTime(), C11842p.m70824j());
        }
        return this.mContext.getString(R$string.temp_backup_yesterday, C11667a.m69661c(this.mContext, this.cloudBackupState.getLastSuccessTime(), 68097));
    }

    private long getNextBackupTime(int i10, long j10) {
        long j11 = (i10 * 86400000) + j10;
        return (j10 == 0 || j11 < System.currentTimeMillis()) ? System.currentTimeMillis() : j11;
    }

    private String getNextStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.cloudBackupState.getNextStartTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(6);
        int i11 = calendar2.get(6);
        return i10 == i11 ? this.mContext.getString(R$string.main_today) : i10 - i11 == 1 ? this.mContext.getString(R$string.tomorrow) : C11667a.m69661c(this.mContext, this.cloudBackupState.getNextStartTime(), 65556);
    }

    private void inflateViewByFontScale(Context context) {
        float fM1195O = C0209d.m1195O(context);
        if (fM1195O >= 3.2f) {
            this.inflateView = View.inflate(context, R$layout.cloudbackup_state_font_scale_3dot2, this);
        } else if (fM1195O < 1.75f || fM1195O >= 3.2f) {
            this.inflateView = View.inflate(context, R$layout.cloudbackup_state, this);
        } else {
            this.inflateView = View.inflate(context, R$layout.cloudbackup_state_font_scale_2, this);
        }
    }

    private void initBackupState(int i10) throws IllegalAccessException, InstantiationException {
        if (i10 == 0) {
            initDefaultState();
            return;
        }
        if (C14342k.m85520a(i10)) {
            initBackupingState();
            return;
        }
        if (i10 == 2) {
            initPauseState();
        } else if (i10 == 3) {
            initDoneState();
        } else if (i10 == 4) {
            initOverDays();
        }
    }

    private void initBackupingState() {
        if (this.backupingStateView == null) {
            this.backupingStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_backuping).inflate();
        }
        setViewShow(this.defaultStateView, 8);
        setViewShow(this.pauseStateView, 8);
        setViewShow(this.backupingStateView, 0);
        setViewShow(this.doneStateView, 8);
        setViewShow(this.restoringStateView, 8);
        setViewShow(this.overdaysStateView, 8);
        setViewShow(this.restorePauseStateView, 8);
        setViewShow(this.loadingView, 8);
        ProgressButton progressButton = (ProgressButton) C12809f.m76831d(this.backupingStateView, R$id.state_backuping_pause_btn);
        this.backupingPauseBtn = progressButton;
        progressButton.requestFocus();
        this.backupingPauseBtn.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76831d(this.backupingStateView, R$id.backup_state_backuping_text);
        this.backupingPauseBtn.setProgress(this.cloudBackupState.getIntProgress(), true);
        this.backupingPauseBtn.setText(this.mContext.getString(R$string.pause_btn));
        if (this.cloudBackupState.getState().intValue() == 1 || this.cloudBackupState.getState().intValue() == 5) {
            textView.setText(this.mContext.getString(R$string.cloudbackup_prepare_data));
            return;
        }
        if (this.cloudBackupState.getState().intValue() == 9) {
            textView.setText(this.mContext.getString(R$string.creating_backup_record));
            return;
        }
        String displayModule = this.cloudBackupState.getDisplayModule();
        if (TextUtils.isEmpty(displayModule)) {
            C11839m.m70688i(TAG, "moudleName is null");
        } else {
            textView.setText(this.mContext.getString(R$string.module_progress_tips_no_num_new, C2783d.m16142g0(displayModule) ? C2783d.m16153k(this.mContext, displayModule) : C2783d.m16079E(this.mContext, displayModule)));
        }
    }

    private void initDefaultState() {
        if (this.defaultStateView == null) {
            this.defaultStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_default).inflate();
        }
        setViewShow(this.defaultStateView, 0);
        setViewShow(this.pauseStateView, 8);
        setViewShow(this.backupingStateView, 8);
        setViewShow(this.doneStateView, 8);
        setViewShow(this.restoringStateView, 8);
        setViewShow(this.overdaysStateView, 8);
        setViewShow(this.restorePauseStateView, 8);
        setViewShow(this.loadingView, 8);
        if (this.defaultOpenNowBtn == null) {
            AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.defaultStateView, R$id.state_default_open_now_btn);
            this.defaultOpenNowBtn = autoSizeButton;
            autoSizeButton.setOnClickListener(this);
            this.defaultOpenNowBtn.setVisibility(0);
            this.defaultOpenNowBtn.setText(this.mContext.getString(R$string.backup_open_now));
        }
        if (this.defaultBackupNowBtn == null) {
            View viewM76831d = C12809f.m76831d(this.defaultStateView, R$id.state_default_backup_now_btn);
            this.defaultBackupNowBtn = viewM76831d;
            viewM76831d.setOnClickListener(this);
        }
        this.defaultBackupNowLoading = (HwProgressBar) C12809f.m76831d(this.defaultStateView, R$id.state_default_backup_now_btn_loading);
        ((TextView) C12809f.m76831d(this.defaultStateView, R$id.backup_state_default_text)).setVisibility(0);
    }

    private void initDoneState() throws IllegalAccessException, InstantiationException {
        if (this.doneStateView == null) {
            this.doneStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_done).inflate();
        }
        setViewShow(this.defaultStateView, 8);
        setViewShow(this.pauseStateView, 8);
        setViewShow(this.backupingStateView, 8);
        setViewShow(this.doneStateView, 0);
        setViewShow(this.restoringStateView, 8);
        setViewShow(this.overdaysStateView, 8);
        setViewShow(this.restorePauseStateView, 8);
        setViewShow(this.loadingView, 8);
        TextBannerView textBannerView = (TextBannerView) C12809f.m76831d(this.doneStateView, R$id.backup_state_done_bannerView);
        this.doneBannerView = textBannerView;
        textBannerView.m24045m("", 0);
        this.doneBannerView.m24045m("", 1);
        TextView textView = (TextView) C12809f.m76831d(this.doneStateView, R$id.backup_state_done_title);
        TextView textView2 = (TextView) C12809f.m76831d(this.doneStateView, R$id.backup_state_done_text);
        if (this.doneViewRestoreBtn == null) {
            AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.doneStateView, R$id.state_done_view_and_restore_btn);
            this.doneViewRestoreBtn = autoSizeButton;
            autoSizeButton.setOnClickListener(this);
        }
        if (this.doneBackupNowBtn == null) {
            View viewM76831d = C12809f.m76831d(this.doneStateView, R$id.state_done_backup_now_btn);
            this.doneBackupNowBtn = viewM76831d;
            viewM76831d.setOnClickListener(this);
        }
        this.doneBackupNowLoading = (HwProgressBar) C12809f.m76831d(this.doneStateView, R$id.state_default_backup_now_btn_loading);
        String nextStartTime = getNextStartTime();
        String lastBackupTime = getLastBackupTime();
        if (this.cloudBackupState.getLastSuccessTime() == 0) {
            textView.setVisibility(8);
            this.doneViewRestoreBtn.setVisibility(8);
            this.doneBackupNowBtn.setVisibility(0);
            textView2.setText(this.mContext.getString(R$string.next_backup_time, nextStartTime));
            textView2.setVisibility(0);
            this.doneBannerView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        this.doneViewRestoreBtn.setVisibility(0);
        this.doneBackupNowBtn.setVisibility(8);
        textView2.setVisibility(8);
        this.doneBannerView.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mContext.getString(R$string.next_backup_time, nextStartTime));
        arrayList.add(lastBackupTime);
        this.doneBannerView.setDatas(arrayList);
    }

    private void initOverDays() {
        if (this.overdaysStateView == null) {
            this.overdaysStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_backup_overdays).inflate();
        }
        setViewShow(this.defaultStateView, 8);
        setViewShow(this.pauseStateView, 8);
        setViewShow(this.backupingStateView, 8);
        setViewShow(this.doneStateView, 8);
        setViewShow(this.restoringStateView, 8);
        setViewShow(this.overdaysStateView, 0);
        setViewShow(this.restorePauseStateView, 8);
        setViewShow(this.loadingView, 8);
        if (this.overdaysOpenNowBtn == null) {
            View viewM76831d = C12809f.m76831d(this.overdaysStateView, R$id.state_overdays_backup_btn);
            this.overdaysOpenNowBtn = viewM76831d;
            viewM76831d.setOnClickListener(this);
        }
        this.overdaysOpenNowLoading = (HwProgressBar) C12809f.m76831d(this.overdaysStateView, R$id.state_overdays_backup_loading);
        setOverDaysTitle((TextView) C12809f.m76831d(this.overdaysStateView, R$id.state_backup_overdays_title));
        TextView textView = (TextView) C12809f.m76831d(this.overdaysStateView, R$id.state_backup_overdays_text);
        if (this.cloudBackupState.getReturnCode() != 0 && !this.cloudBackupState.isOverDayErrTipDismiss() && (this.cloudBackupState.getReturnCode() != 3001 || !this.cloudBackupState.isCloudSpaceNotEnoughDismiss())) {
            setOverDaysText(textView);
        } else {
            Context context = this.mContext;
            textView.setText(context.getString(R$string.backup_size, C0223k.m1524g(context, this.cloudBackupState.getWaitBackupSize())));
        }
    }

    private void initPauseState() throws IllegalAccessException, InstantiationException {
        int returnCode = this.cloudBackupState.getReturnCode();
        if (returnCode == 3001 && this.cloudBackupState.isCloudSpaceNotEnoughDismiss()) {
            initDoneState();
            C11839m.m70688i(TAG, "initPauseState errorCode is 3001 ,show spacialstatus");
            return;
        }
        if (returnCode == 3113) {
            this.cloudBackupState.setLastSuccessTime(0L);
            initDoneState();
            return;
        }
        if (this.pauseStateView == null) {
            this.pauseStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_backup_pause).inflate();
        }
        setViewShow(this.defaultStateView, 8);
        setViewShow(this.pauseStateView, 0);
        setViewShow(this.backupingStateView, 8);
        setViewShow(this.doneStateView, 8);
        setViewShow(this.restoringStateView, 8);
        setViewShow(this.overdaysStateView, 8);
        setViewShow(this.restorePauseStateView, 8);
        setViewShow(this.loadingView, 8);
        TextView textView = (TextView) C12809f.m76831d(this.pauseStateView, R$id.backup_state_pause_text);
        if (this.pauseContinueBtn == null) {
            ProgressButton progressButton = (ProgressButton) C12809f.m76831d(this.pauseStateView, R$id.state_pause_continue_btn);
            this.pauseContinueBtn = progressButton;
            progressButton.setOnClickListener(this);
        }
        this.pauseContinueBtn.requestFocus();
        this.pauseContinueBtn.setText(this.mContext.getString(R$string.continue_btn));
        this.pauseContinueBtn.setProgress(this.cloudBackupState.getIntProgress(), false);
        this.pauseContinueBtn.setFlickerEnable(false);
        if (this.pauseDetailsBtn == null) {
            AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.pauseStateView, R$id.state_pause_details);
            this.pauseDetailsBtn = autoSizeButton;
            autoSizeButton.setOnClickListener(this);
        }
        this.pauseContinueBtn.setVisibility(0);
        this.pauseDetailsBtn.setVisibility(8);
        textView.setVisibility(0);
        C11839m.m70688i(TAG, "errorCode " + returnCode);
        if (returnCode == 3001) {
            textView.setText(this.mContext.getString(R$string.cloud_space_insufficient));
            return;
        }
        if (C14339h.m85514m().contains(Integer.valueOf(returnCode))) {
            textView.setText(this.mContext.getString(R$string.backup_failed_network_tip));
            return;
        }
        if (returnCode == 1006) {
            textView.setText(this.mContext.getString(R$string.auto_bright_screen_tips));
            return;
        }
        if (returnCode == 1001 || returnCode == 0) {
            textView.setVisibility(8);
        } else {
            if (returnCode == 1030) {
                textView.setText(this.mContext.getString(R$string.backup_battery_temperature_high));
                return;
            }
            textView.setText(this.mContext.getString(R$string.backup_conditions_not_met));
            this.pauseDetailsBtn.setVisibility(0);
            this.pauseContinueBtn.setVisibility(8);
        }
    }

    private void initRestorePause() {
        if (this.restorePauseStateView == null) {
            this.restorePauseStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_restore_pause).inflate();
        }
        setViewShow(this.defaultStateView, 8);
        setViewShow(this.pauseStateView, 8);
        setViewShow(this.backupingStateView, 8);
        setViewShow(this.doneStateView, 8);
        setViewShow(this.restoringStateView, 8);
        setViewShow(this.overdaysStateView, 8);
        setViewShow(this.restorePauseStateView, 0);
        setViewShow(this.loadingView, 8);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.restorePauseStateView, R$id.restore_pause_see_details);
        this.restorePauseBtn = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76831d(this.restorePauseStateView, R$id.restore_state_pause_text);
        if (C14339h.m85514m().contains(Integer.valueOf(this.cloudBackupState.getReturnCode()))) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    private void initRestoreState(int i10) {
        if (i10 == 1 || i10 == 5) {
            initRestoringState();
        } else if (i10 == 2) {
            initRestorePause();
        }
    }

    private void initRestoringState() {
        if (this.restoringStateView == null) {
            this.restoringStateView = findViewStubById(this.inflateView, R$id.cloudbackup_state_restoring).inflate();
        }
        setViewShow(this.defaultStateView, 8);
        setViewShow(this.pauseStateView, 8);
        setViewShow(this.backupingStateView, 8);
        setViewShow(this.doneStateView, 8);
        setViewShow(this.restoringStateView, 0);
        setViewShow(this.overdaysStateView, 8);
        setViewShow(this.restorePauseStateView, 8);
        setViewShow(this.loadingView, 8);
        if (this.restoringDetailsBtn == null) {
            ProgressButton progressButton = (ProgressButton) C12809f.m76831d(this.restoringStateView, R$id.state_restoring_pause_btn);
            this.restoringDetailsBtn = progressButton;
            progressButton.setOnClickListener(this);
        }
        this.restoringDetailsBtn.setText(this.mContext.getString(R$string.cloudbackup_Cancel));
        this.restoringDetailsBtn.setProgress(this.cloudBackupState.getIntProgress(), true);
        ((TextView) C12809f.m76831d(this.restoringStateView, R$id.backup_state_restoring_text)).setText(this.mContext.getString(R$string.see_details));
        ((TextView) C12809f.m76831d(this.restoringStateView, R$id.backup_state_restoring_title)).setText(this.mContext.getString(R$string.main_cloudrestoring));
    }

    private void initView(Context context) {
        inflateViewByFontScale(context);
        View viewInflate = findViewStubById(this.inflateView, R$id.cloudbackup_state_loading).inflate();
        this.loadingView = viewInflate;
        viewInflate.setVisibility(0);
        if (!C0209d.m1166E1()) {
            setEnabled(false);
            setAlpha(0.6f);
        }
        if (C10155f.m63301y()) {
            return;
        }
        setVisibility(8);
    }

    public static boolean isOverDays(long j10) {
        return System.currentTimeMillis() - j10 >= 15552000000L;
    }

    private void reportClickEvent(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "reportClickEvent eventId or eventXChl is empty");
        } else {
            C13225d.m79490f1().m79585f0(str, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", str, "1", str2);
        }
    }

    private void setOverDaysText(TextView textView) {
        int returnCode = this.cloudBackupState.getReturnCode();
        if (returnCode == 3001) {
            textView.setText(this.mContext.getString(R$string.cloud_space_insufficient));
            return;
        }
        if (C14339h.m85514m().contains(Integer.valueOf(returnCode))) {
            textView.setText(this.mContext.getString(R$string.backup_failed_network_tip));
            return;
        }
        if (returnCode == 1006) {
            textView.setText(this.mContext.getString(R$string.auto_bright_screen_tips));
            return;
        }
        if (returnCode == 1001) {
            Context context = this.mContext;
            textView.setText(context.getString(R$string.backup_size, C0223k.m1524g(context, this.cloudBackupState.getWaitBackupSize())));
        } else if (returnCode == 1030) {
            textView.setText(this.mContext.getString(R$string.backup_battery_temperature_high));
        } else {
            textView.setText(this.mContext.getString(R$string.backup_conditions_not_met));
        }
    }

    private void setOverDaysTitle(TextView textView) {
        if (isOverDays(this.cloudBackupState.getLastSuccessTime())) {
            textView.setText(this.mContext.getString(R$string.not_backup_morethan_six_months, 6));
        } else {
            int differenceDays = getDifferenceDays(this.cloudBackupState.getLastSuccessTime());
            textView.setText(this.mContext.getResources().getQuantityString(R$plurals.no_backup_for_time, differenceDays, Integer.valueOf(differenceDays)));
        }
    }

    private void setViewShow(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    private void viewAndRestore(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "openCloudBackupSwitch context is null");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) CloudBackupRecordsActivity.class);
        C13225d.m79490f1().m79585f0("mecloud_backupmain_click_backup_restore", C13452e.m80781L().m80971t0());
        C13230i.m79525e1(intent, "1", "39");
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_backup_restore", "1", "39");
        intent.putExtra("entrance_of_restore", "5");
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        context.startActivity(intent);
    }

    public void backupDetails(Context context) {
        Intent intent = new Intent(context, (Class<?>) BackupMainActivity.class);
        intent.putExtra("scene_of_manual_backup", "1");
        C13230i.m79525e1(intent, "1", "2");
        context.startActivity(intent);
    }

    public void hideBackupLoading() {
        ProgressButton progressButton = this.pauseContinueBtn;
        if (progressButton != null) {
            progressButton.setLoadingVisibility(8);
        }
        if (this.defaultBackupNowBtn != null) {
            this.defaultBackupNowLoading.setVisibility(8);
        }
        if (this.overdaysOpenNowBtn != null) {
            this.overdaysOpenNowLoading.setVisibility(8);
        }
        if (this.doneBackupNowBtn != null) {
            this.doneBackupNowLoading.setVisibility(8);
        }
    }

    public boolean isRefurbishing() {
        return this.isRefurbishing;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        if (C0209d.m1226Y0()) {
            C11839m.m70687e(TAG, "fast click");
            return;
        }
        if (C13612b.m81829B().m81886t((Activity) this.mContext)) {
            C11839m.m70687e(TAG, "ST is invalid,click disable");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.state_default_open_now_btn) {
            C11839m.m70688i(TAG, "state_default_open_now_btn click");
            Context context = this.mContext;
            if ((context instanceof MainActivity) && !((MainActivity) context).m21168G4()) {
                C11839m.m70688i(TAG, "go auth  check");
                return;
            } else {
                openCloudBackupSwitch(this.mContext);
                str = "action_code_backupitem_open";
                str2 = "67";
            }
        } else if (id2 == R$id.state_default_backup_now_btn) {
            C11839m.m70688i(TAG, "state_default_backup_now_btn click");
            resume(this.mContext, 1);
            str = "action_code_backupitem_default_backup";
            str2 = "76";
        } else if (id2 == R$id.state_overdays_backup_btn) {
            C11839m.m70688i(TAG, "state_overdays_backup_btn click");
            resume(this.mContext, 1);
            str = "action_code_backupitem_incomplete_backup";
            str2 = "70";
        } else if (id2 == R$id.state_pause_continue_btn) {
            C11839m.m70688i(TAG, "state_pause_continue_btn click");
            resume(this.mContext, 1);
            str = "action_code_backupitem_continue_backup";
            str2 = "75";
        } else if (id2 == R$id.state_backuping_pause_btn) {
            C11839m.m70688i(TAG, "state_backuping_pause_btn click");
            CloudBackupService.getInstance().abort();
            str = "action_code_backupitem_backuping_pause";
            str2 = "68";
        } else if (id2 == R$id.state_done_view_and_restore_btn) {
            C11839m.m70688i(TAG, "state_done_view_and_restore_btn click");
            viewAndRestore(this.mContext);
            str = "action_code_backupitem_view_restore";
            str2 = "69";
        } else if (id2 == R$id.state_done_backup_now_btn) {
            C11839m.m70688i(TAG, "state_done_backup_now_btn click");
            if (this.isRefurbishing) {
                Context context2 = this.mContext;
                if (context2 instanceof MainActivity) {
                    ((MainActivity) context2).m21251Q4();
                } else {
                    C11841o.m70708d(context2, context2.getString(R$string.cloudbackup_refurbishing_backup_tips), 0);
                }
                str = null;
                str2 = null;
            } else {
                resume(this.mContext, 1);
                str = "action_code_backupitem_complete_backup";
                str2 = "74";
            }
        } else if (id2 == R$id.state_restoring_pause_btn) {
            C11839m.m70688i(TAG, "state_restoring_pause_btn click");
            CloudBackupService.getInstance().abort();
            C13452e.m80781L().m80890b();
            str = "action_code_backupitem_restoring_cancel";
            str2 = "73";
        } else if (id2 == R$id.state_pause_details) {
            C11839m.m70688i(TAG, "state_pause_details click");
            backupDetails(this.mContext);
            str = "action_code_backupitem_view_backupfail_detail";
            str2 = "71";
        } else if (id2 == R$id.restore_pause_see_details) {
            restoreDetails(this.mContext);
            str = "action_code_backupitem_restore_detail";
            str2 = "72";
        } else {
            str = null;
            str2 = null;
        }
        reportClickEvent(str, str2);
    }

    public void openCloudBackupSwitch(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "openCloudBackupSwitch context is null");
            return;
        }
        CloudBackupService.getInstance().cloudbackupOpr(true);
        C10155f.m63262O(context, true);
        C13225d.m79490f1().m79558J0("11");
    }

    public void restoreDetails(Context context) {
        Intent intent = new Intent(context, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", 2);
        bundle.putInt("restore_status", C13452e.m80781L().m80916g0());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void resume(Context context, int i10) {
        C13029h c13029hM78495f;
        if (i10 == 1) {
            if (C0209d.m1254f2(context)) {
                CloudBackupService.getInstance().backup(false, false);
                new C13033l().m78548f(1, 0);
                return;
            } else if (C0209d.m1262h2()) {
                C11841o.m70708d(context, context.getString(R$string.backup_homepage_wlan_tips), 0);
                return;
            } else {
                C11841o.m70708d(context, context.getString(R$string.backup_homepage_wifi_tips), 0);
                return;
            }
        }
        if (i10 != 2) {
            return;
        }
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b unused) {
            C11839m.m70687e(TAG, "resume tags is null");
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null || !C13619c.m81952h(c13029hM78495f.m78480t())) {
            C11839m.m70688i(TAG, "restore retry v2 process");
            CloudBackupService.getInstance().restoreRetry(false, true, false);
        } else {
            C11839m.m70688i(TAG, "restore retry v3 process");
            CloudBackupService.getInstance().restoreRetryV3(false, true);
        }
    }

    public void setButtonEnabled() {
        ProgressButton progressButton = this.backupingPauseBtn;
        if (progressButton != null) {
            progressButton.setEnabled(false);
        }
        AutoSizeButton autoSizeButton = this.defaultOpenNowBtn;
        if (autoSizeButton != null) {
            autoSizeButton.setEnabled(false);
        }
        View view = this.defaultBackupNowBtn;
        if (view != null) {
            view.setEnabled(false);
        }
        ProgressButton progressButton2 = this.pauseContinueBtn;
        if (progressButton2 != null) {
            progressButton2.setEnabled(false);
        }
        AutoSizeButton autoSizeButton2 = this.pauseDetailsBtn;
        if (autoSizeButton2 != null) {
            autoSizeButton2.setEnabled(false);
        }
        AutoSizeButton autoSizeButton3 = this.doneViewRestoreBtn;
        if (autoSizeButton3 != null) {
            autoSizeButton3.setEnabled(false);
        }
        View view2 = this.doneBackupNowBtn;
        if (view2 != null) {
            view2.setEnabled(false);
        }
        View view3 = this.overdaysOpenNowBtn;
        if (view3 != null) {
            view3.setEnabled(false);
        }
        ProgressButton progressButton3 = this.restoringDetailsBtn;
        if (progressButton3 != null) {
            progressButton3.setEnabled(false);
        }
    }

    public void setRefurbishing(boolean z10) {
        this.isRefurbishing = z10;
    }

    public void show(CloudBackupState cloudBackupState) throws IllegalAccessException, InstantiationException {
        this.cloudBackupState = cloudBackupState;
        int iIntValue = cloudBackupState.getState().intValue();
        if (C14317j.m85300d().m85309j()) {
            C11839m.m70689w(TAG, "backup isRefurbishing ");
            long nextBackupTime = getNextBackupTime(C13467g.m81086c().m81091f(), new SettingOperator().querylastsuccesstime());
            this.cloudBackupState.setLastSuccessTime(0L);
            this.cloudBackupState.setNextStartTime(nextBackupTime);
            initDoneState();
            this.doneBackupNowLoading.setVisibility(8);
        } else if (cloudBackupState.getId() == 1) {
            C11839m.m70689w(TAG, "backup state ");
            initBackupState(iIntValue);
            showBackupLoading();
        } else if (cloudBackupState.getId() == 2) {
            C11839m.m70689w(TAG, "restore state ");
            initRestoreState(iIntValue);
        } else {
            C11839m.m70689w(TAG, "unknown state " + iIntValue);
        }
        if (C0209d.m1166E1()) {
            return;
        }
        setEnabled(false);
        setAlpha(0.6f);
        setButtonEnabled();
    }

    public void showBackupLoading() {
        boolean zIsBackupAbout = CBAccess.isBackupAbout();
        ProgressButton progressButton = this.pauseContinueBtn;
        if (progressButton != null) {
            progressButton.setLoadingVisibility(zIsBackupAbout ? 0 : 8);
        }
        if (this.defaultBackupNowBtn != null) {
            this.defaultBackupNowLoading.setVisibility(zIsBackupAbout ? 0 : 8);
        }
        if (this.overdaysOpenNowBtn != null) {
            this.overdaysOpenNowLoading.setVisibility(zIsBackupAbout ? 0 : 8);
        }
        if (this.doneBackupNowBtn != null) {
            this.doneBackupNowLoading.setVisibility(zIsBackupAbout ? 0 : 8);
        }
    }

    public BackupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isRefurbishing = false;
        this.mContext = context;
        boolean zM75941k = C12591s1.m75931a().m75941k();
        C14317j.m85300d().m85316q(zM75941k);
        this.isRefurbishing = zM75941k;
        initView(context);
    }
}
