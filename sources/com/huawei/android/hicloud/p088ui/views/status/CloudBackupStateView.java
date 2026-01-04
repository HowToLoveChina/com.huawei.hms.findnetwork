package com.huawei.android.hicloud.p088ui.views.status;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.LocalSpaceNotEnoughAlertDialog;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.p088ui.views.status.CloudBackupStateView;
import com.huawei.android.p073ds.R$string;
import com.huawei.feedback.FeedbackSdkProcessor;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p292fn.C9733f;
import p422k9.C11018a;
import p495nm.C11731l;
import p514o9.C11839m;
import p514o9.C11841o;
import p550pb.C12126b;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import p847zk.C14317j;
import p848zl.C14339h;
import sk.C12809f;
import tl.C13029h;

/* loaded from: classes3.dex */
public class CloudBackupStateView extends RelativeLayout {

    /* renamed from: a */
    public LocalSpaceNotEnoughAlertDialog f19593a;

    /* renamed from: b */
    public Context f19594b;

    /* renamed from: c */
    public String f19595c;

    /* renamed from: d */
    public View.OnClickListener f19596d;

    /* renamed from: e */
    public View.OnClickListener f19597e;

    /* renamed from: com.huawei.android.hicloud.ui.views.status.CloudBackupStateView$a */
    public class C4293a extends ClickableSpan {
        public C4293a() {
        }

        /* renamed from: b */
        public static /* synthetic */ void m25852b(Activity activity) {
            C13225d.m79490f1().m79585f0("mecloud_backup_click_help", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_backup_click_help", "1", "27");
            FeedbackSdkProcessor.getInstance(activity, new C11018a()).jumpToSdkView(activity, 1, true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            C11839m.m70688i("CloudBackupStateView", "setErrorTipReinforcing onClick");
            Optional.ofNullable(C12809f.m76833f(CloudBackupStateView.this)).ifPresent(new Consumer() { // from class: ee.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloudBackupStateView.C4293a.m25852b((Activity) obj);
                }
            });
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.status.CloudBackupStateView$b */
    public class ViewOnClickListenerC4294b implements View.OnClickListener {
        public ViewOnClickListenerC4294b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudBackupStateView.this.f19593a == null) {
                CloudBackupStateView.this.f19593a = new LocalSpaceNotEnoughAlertDialog(CloudBackupStateView.this.f19594b);
            }
            CloudBackupStateView.this.f19593a.show();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.status.CloudBackupStateView$c */
    public class ViewOnClickListenerC4295c implements View.OnClickListener {
        public ViewOnClickListenerC4295c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C13225d.m79490f1().m79585f0("action_code_backupmain_go_to_phone_manager", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backupmain_go_to_phone_manager", "1", "65");
            Intent intent = new Intent();
            intent.setAction("huawei.intent.action.HSM_STORAGE_CLEANER");
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            intent.putExtra("auto_start", true);
            intent.putExtra(MapKeyNames.PACKAGE_NAME, CloudBackupStateView.this.f19594b.getPackageName());
            try {
                C0209d.m1302r2(intent, C13843a.m83103y(CloudBackupStateView.this.f19594b));
                CloudBackupStateView.this.f19594b.startActivity(intent);
                C14317j.m85301e(CloudBackupStateView.this.getBackupAction()).m85323x();
            } catch (ActivityNotFoundException e10) {
                C11839m.m70687e("CloudBackupStateView", "start activity not found: " + e10);
            } catch (Exception e11) {
                C11839m.m70687e("CloudBackupStateView", "start activity error: " + e11);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.status.CloudBackupStateView$d */
    public static class ViewOnClickListenerC4296d implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt("from_where", 10);
            C13230i.m79522d1(bundle, "1", "16");
            C12126b.m72707c("2", bundle);
            C13225d.m79490f1().m79585f0("mecloud_backupmain_click_goto_upgrade", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_goto_upgrade", "1", "30");
        }
    }

    public CloudBackupStateView(Context context) {
        this(context, null);
    }

    /* renamed from: e */
    public static Intent m25838e(String str, String str2) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        hiCloudSafeIntent.setAction("android.intent.action.VIEW");
        hiCloudSafeIntent.addCategory("android.intent.category.DEFAULT");
        hiCloudSafeIntent.setType("filemanager.dir/*");
        hiCloudSafeIntent.putExtra("curr_dir", str);
        hiCloudSafeIntent.setFlags(805306368);
        C0209d.m1302r2(hiCloudSafeIntent, str2);
        return hiCloudSafeIntent;
    }

    /* renamed from: f */
    public String m25839f(int i10) {
        String spaceMultLanguage;
        if (C14339h.m85509h().contains(Integer.valueOf(i10))) {
            return this.f19594b.getString(R$string.cloud_backup_failed_module_dataabnormal);
        }
        if (C14339h.m85510i().contains(Integer.valueOf(i10))) {
            return m25842i(R$string.cloud_backup_failed_module_file_changed, R$string.cloud_backup_failed_app_name);
        }
        if (C14339h.m85511j().contains(Integer.valueOf(i10))) {
            return m25842i(R$string.cloud_backup_failed_foreground_app_exist_2, R$string.cloud_backup_failed_foreground_app);
        }
        if (C14339h.m85506e().contains(Integer.valueOf(i10))) {
            return this.f19594b.getString(R$string.cloud_restore_failed_battery, 5);
        }
        if (C14339h.m85505d().contains(Integer.valueOf(i10))) {
            return this.f19594b.getString(R$string.cloud_backup_failed_battery2, C2783d.m16144h(10));
        }
        if (C14339h.m85504c().contains(Integer.valueOf(i10))) {
            return this.f19594b.getString(R$string.cloud_backup_failed_service_occupied);
        }
        if (C14339h.m85502a().contains(Integer.valueOf(i10))) {
            return this.f19594b.getString(R$string.auto_backup_failed_power);
        }
        if (C14339h.m85503b().contains(Integer.valueOf(i10))) {
            return this.f19594b.getString(R$string.auto_backup_failed_screen);
        }
        if (C14339h.m85507f().contains(Integer.valueOf(i10))) {
            spaceMultLanguage = this.f19594b.getString(R$string.cloud_backup_failed_server_busy);
            if (m25843j()) {
                String string = this.f19594b.getString(R$string.temp_backup_server_busy_tip);
                spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_server_busy_tip");
                if (TextUtils.isEmpty(spaceMultLanguage)) {
                    return string;
                }
            }
        } else if (3911 == i10) {
            String string2 = this.f19594b.getString(R$string.backup_failed_tip_20181025);
            spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("v3_backup_server_error_tip");
            if (TextUtils.isEmpty(spaceMultLanguage)) {
                return string2;
            }
        } else {
            if (3941 != i10) {
                if (C14339h.m85515n().contains(Integer.valueOf(i10))) {
                    return this.f19594b.getString(R$string.cloud_backup_failed_abnormal_server, Integer.valueOf(i10));
                }
                if (!C14339h.m85508g().contains(Integer.valueOf(i10))) {
                    return C14339h.m85516o().contains(Integer.valueOf(i10)) ? this.f19594b.getString(R$string.cloud_backup_failed_network_anomaly, Integer.valueOf(i10)) : C14339h.m85513l().contains(Integer.valueOf(i10)) ? this.f19594b.getString(R$string.toast_tip_in_delete_backup) : C14339h.m85518q().contains(Integer.valueOf(i10)) ? this.f19594b.getString(R$string.cloudbackup_second_refurbish_fail_tip) : (i10 == 0 || i10 == 1001) ? "" : 3942 == i10 ? this.f19594b.getString(R$string.cloud_backup_source_forbidden) : this.f19594b.getString(R$string.backup_failed_tip_20181025);
                }
                Context context = this.f19594b;
                return context.getString(R$string.cloud_backup_failed_abnormal_client_new, context.getString(R$string.contact_customer_service));
            }
            String string3 = this.f19594b.getString(R$string.backup_failed_tip_20181025);
            spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("backup_server_lock_conflict_tip");
            if (TextUtils.isEmpty(spaceMultLanguage)) {
                return string3;
            }
        }
        return spaceMultLanguage;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m25840g(android.widget.TextView r4, com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState r5, tl.C13029h r6) {
        /*
            r3 = this;
            int r0 = r5.getReturnCode()
            java.util.List r1 = p848zl.C14339h.m85517p()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L20
            android.content.Context r5 = r3.f19594b
            int r6 = com.huawei.android.p073ds.R$string.low_space_tip_buy
            java.lang.String r5 = r5.getString(r6)
            android.view.View$OnClickListener r3 = r3.f19597e
            r4.setOnClickListener(r3)
            goto L87
        L20:
            java.util.List r1 = p848zl.C14339h.m85515n()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L3c
            android.content.Context r5 = r3.f19594b
            int r6 = com.huawei.android.p073ds.R$string.cloud_backup_failed_log_report
            java.lang.String r5 = r5.getString(r6)
            android.view.View$OnClickListener r3 = r3.f19596d
            r4.setOnClickListener(r3)
            goto L87
        L3c:
            java.util.List r1 = p848zl.C14339h.m85512k()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L61
            boolean r5 = r5.isLocalSpaceNotEnoughChange()
            if (r5 != 0) goto L85
            android.content.Context r5 = r3.f19594b
            int r6 = com.huawei.android.p073ds.R$string.go_clean_up
            java.lang.String r5 = r5.getString(r6)
            com.huawei.android.hicloud.ui.views.status.CloudBackupStateView$c r6 = new com.huawei.android.hicloud.ui.views.status.CloudBackupStateView$c
            r6.<init>()
            r4.setOnClickListener(r6)
            goto L87
        L61:
            r5 = 1035(0x40b, float:1.45E-42)
            if (r5 != r0) goto L85
            java.lang.String r5 = r6.m78484v()
            nm.l r5 = p495nm.C11731l.m70010h(r5)
            if (r5 == 0) goto L85
            java.lang.String r5 = r5.m70014d()
            android.content.Context r6 = r3.f19594b
            int r0 = com.huawei.android.p073ds.R$string.backup_failed_file_read_goto_handle
            java.lang.String r6 = r6.getString(r0)
            ee.b r0 = new ee.b
            r0.<init>()
            r4.setOnClickListener(r0)
            r5 = r6
            goto L87
        L85:
            java.lang.String r5 = ""
        L87:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto L93
            r3 = 8
            r4.setVisibility(r3)
            goto L9e
        L93:
            r3 = 1
            r4.setAllCaps(r3)
            r3 = 0
            r4.setVisibility(r3)
            r4.setText(r5)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.views.status.CloudBackupStateView.m25840g(android.widget.TextView, com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState, tl.h):void");
    }

    public String getBackupAction() {
        return this.f19595c;
    }

    /* renamed from: h */
    public String m25841h(ImageView imageView, CloudBackupState cloudBackupState, C13029h c13029h) {
        String string;
        if (cloudBackupState == null) {
            C11839m.m70687e("CloudBackupStateView", "getErrCodeDes cloudBackupState is null");
            return "";
        }
        int returnCode = cloudBackupState.getReturnCode();
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (C14339h.m85517p().contains(Integer.valueOf(returnCode))) {
            return this.f19594b.getString(R$string.backup_no_space_tip_2, C0209d.m1157C0(C0223k.m1524g(this.f19594b, c13029h != null ? C0241z.m1689g(c13029h.m78482u(), c13029h.m78439E()) : 0L)));
        }
        if (C14339h.m85512k().contains(Integer.valueOf(returnCode))) {
            String string2 = cloudBackupState.isLocalSpaceNotEnoughChange() ? this.f19594b.getString(R$string.backup_no_space_local_tip_3) : this.f19594b.getString(R$string.backup_no_space_local_tip_2, C0223k.m1525h(C0213f.m1377a(), c13029h != null ? c13029h.m78438D() : 0L, 1000));
            if (imageView == null) {
                return string2;
            }
            imageView.setVisibility(0);
            imageView.setOnClickListener(new ViewOnClickListenerC4294b());
            return string2;
        }
        if (C14339h.m85514m().contains(Integer.valueOf(returnCode))) {
            string = (c13029h == null || c13029h.m78442H() != 2) ? this.f19594b.getString(R$string.backup_failed_network_tip) : this.f19594b.getString(R$string.auto_backup_failed_network_tip);
        } else {
            if (returnCode == 1030) {
                return this.f19594b.getString(R$string.backup_battery_temperature_high);
            }
            if (1034 == returnCode) {
                return this.f19594b.getString(R$string.backup_failed_sdcard_error);
            }
            if (1035 != returnCode) {
                return 1036 == returnCode ? "" : m25839f(returnCode);
            }
            String string3 = this.f19594b.getString(R$string.backup_failed_tip_20181025);
            C11731l c11731lM70010h = C11731l.m70010h(c13029h != null ? c13029h.m78484v() : "");
            if (c11731lM70010h == null) {
                return string3;
            }
            String strM75903t = C12590s0.m75903t(C12590s0.m75770M(this.f19594b, c11731lM70010h.m70012b()));
            String strM70015e = c11731lM70010h.m70015e();
            C11839m.m70686d("CloudBackupStateView", "fileName: " + strM70015e + " ,appid: " + c11731lM70010h.m70012b() + " ,appName: " + strM75903t);
            string = this.f19594b.getString(R$string.backup_failed_file_read_error_page, strM75903t, strM70015e);
        }
        return string;
    }

    /* renamed from: i */
    public final String m25842i(int i10, int i11) {
        String strM25632b;
        C13029h c13029hM75882n2 = C12590s0.m75882n2();
        strM25632b = "";
        if (c13029hM75882n2 != null) {
            String strM78463e = c13029hM75882n2.m78463e();
            if (strM78463e.contains("_")) {
                String[] strArrSplit = strM78463e.split("_");
                strM78463e = strArrSplit.length > 0 ? strArrSplit[0] : "";
            }
            strM25632b = NewHiSyncUtil.m25632b(strM78463e);
        }
        return TextUtils.isEmpty(strM25632b) ? this.f19594b.getString(i10) : this.f19594b.getString(i11, strM25632b);
    }

    /* renamed from: j */
    public boolean m25843j() {
        return TextUtils.equals(this.f19595c, "interim");
    }

    /* renamed from: k */
    public final void m25844k(String str) {
        C11839m.m70688i("CloudBackupStateView", "jumpMarketDetail packageName: " + str);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.appmarket.intent.action.AppDetail"));
        C0209d.m1302r2(hiCloudSafeIntent, C13843a.m83090l());
        hiCloudSafeIntent.putExtra("APP_PACKAGENAME", str);
        C11841o.m70707c(C0213f.m1377a(), R$string.upgrade_filemanager_tip, 0);
        try {
            getContext().startActivity(hiCloudSafeIntent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupStateView", "jumpMarketDetail error: " + e10.getMessage());
        }
    }

    /* renamed from: l */
    public void m25845l(String str) {
        C11839m.m70688i("CloudBackupStateView", "jumpToFileManagerDetail path: " + str);
        if (C0209d.m1269j1()) {
            m25846m(str, "com.hihonor.filemanager");
        } else {
            m25846m(str, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        }
    }

    /* renamed from: m */
    public final void m25846m(String str, String str2) {
        Intent intentM25838e = m25838e(str, str2);
        if (intentM25838e.resolveActivity(C0213f.m1377a().getPackageManager()) != null) {
            try {
                getContext().startActivity(intentM25838e);
            } catch (ActivityNotFoundException unused) {
                C11839m.m70688i("CloudBackupStateView", "jumpToHonorFileManagerDetail error");
            }
        } else if (TextUtils.equals(str2, "com.hihonor.filemanager")) {
            m25846m(str, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        } else if (TextUtils.equals(str2, NextRestoreConstants.PKG_NAME_FILE_MANAGER)) {
            m25844k(NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        }
    }

    /* renamed from: n */
    public final /* synthetic */ void m25847n(String str, View view) {
        m25845l(str);
    }

    /* renamed from: o */
    public final /* synthetic */ void m25848o(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudBackupStateView", "click too fast");
        } else {
            m25849p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        C11839m.m70688i("CloudBackupStateView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        LocalSpaceNotEnoughAlertDialog localSpaceNotEnoughAlertDialog = this.f19593a;
        if (localSpaceNotEnoughAlertDialog != null) {
            localSpaceNotEnoughAlertDialog.dismiss();
            this.f19593a = null;
        }
    }

    /* renamed from: p */
    public final void m25849p() {
        C13225d.m79490f1().m79585f0("mecloud_setting_click_suggestion", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_setting_click_suggestion", "1", "4");
        Context context = this.f19594b;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            FeedbackSdkProcessor.getInstance(activity, new C11018a()).jumpToSdkView(activity, 2, true);
        }
    }

    /* renamed from: q */
    public void mo25825q(String str, boolean z10) {
        this.f19595c = str;
    }

    /* renamed from: r */
    public void m25850r(TextView textView, String str) {
        String string = C0213f.m1377a().getString(R$string.contact_customer_service);
        String string2 = C0213f.m1377a().getString(R$string.cloud_backup_failed_abnormal_client_new, string);
        if (C9733f.m60705z().m60720O("backupDisableContactCustomerService") || !string2.equals(str)) {
            textView.setText(str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        C4293a c4293a = new C4293a();
        int iIndexOf = string2.indexOf(string);
        spannableString.setSpan(c4293a, iIndexOf, string.length() + iIndexOf, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public CloudBackupStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudBackupStateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19596d = new View.OnClickListener() { // from class: ee.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f47203a.m25848o(view);
            }
        };
        this.f19597e = new ViewOnClickListenerC4296d();
        this.f19594b = context;
    }
}
