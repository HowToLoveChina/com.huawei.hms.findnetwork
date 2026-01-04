package com.huawei.android.hicloud.p088ui.temporarybackup;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppSettingSingleInstance;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.C3788l4;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupSelectSpaceView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p617rl.C12526j;
import p618rm.C12600v1;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p840zd.C14229k2;
import sk.C12808e;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.temporarybackup.a */
/* loaded from: classes3.dex */
public class C4012a {

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.a$a */
    public class a extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ Button f18446a;

        /* renamed from: b */
        public final /* synthetic */ String f18447b;

        /* renamed from: c */
        public final /* synthetic */ Button f18448c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, long j11, Button button, String str, Button button2) {
            super(j10, j11);
            this.f18446a = button;
            this.f18447b = str;
            this.f18448c = button2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f18446a.setEnabled(true);
            this.f18446a.setAlpha(1.0f);
            Button button = this.f18446a;
            button.setText(button.getContext().getString(R$string.cloud_oobe_agree_and_proceed_text));
            this.f18448c.setEnabled(true);
            this.f18448c.setAlpha(1.0f);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            try {
                this.f18446a.setText(String.format(this.f18447b, Long.valueOf((j10 / 1000) + 1)));
            } catch (Exception e10) {
                onFinish();
                C11839m.m70687e("TempBackUiUtils", "format error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: A */
    public static /* synthetic */ void m24617A(SpanClickText spanClickText, Context context) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUiUtils", "link click to fast");
            return;
        }
        C11839m.m70688i("TempBackUiUtils", "linkSubscribeToMemberServices");
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 13);
        bundle.putString("page_detail", (spanClickText.getContext() instanceof Activity ? spanClickText.getContext().getClass() : TempBackupMainActivity.class).getName());
        m24631O("event_id_jump_to_pay_space", "start jump", context.getClass().getSimpleName());
        C13230i.m79522d1(bundle, "1", "16");
        C12126b.m72707c("2", bundle);
    }

    /* renamed from: B */
    public static /* synthetic */ void m24618B(Context context) throws IllegalAccessException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUiUtils", "link click to fast");
        } else {
            C11839m.m70688i("TempBackUiUtils", "show special instructions bottom sheet");
            m24642Z(context);
        }
    }

    /* renamed from: C */
    public static /* synthetic */ void m24619C(Context context) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUiUtils", "link click to fast");
        } else {
            C11839m.m70688i("TempBackUiUtils", "show special instructions bottom sheet");
            C11829c.m70612r1(context);
        }
    }

    /* renamed from: D */
    public static /* synthetic */ void m24620D(Context context) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUiUtils", "link click to fast");
        } else {
            C11839m.m70688i("TempBackUiUtils", "show special instructions bottom sheet");
            C11829c.m70612r1(context);
        }
    }

    /* renamed from: E */
    public static /* synthetic */ void m24621E(Context context) throws IllegalAccessException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUiUtils", "link click to fast");
        } else {
            C11839m.m70688i("TempBackUiUtils", "show special instructions bottom sheet");
            m24642Z(context);
        }
    }

    /* renamed from: F */
    public static /* synthetic */ void m24622F(AlertDialog alertDialog, Context context, String str, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        if (button != null) {
            button.setTextColor(context.getColor(R$color.emui_functional_blue));
        }
        m24629M("show dialog", str);
    }

    /* renamed from: G */
    public static /* synthetic */ void m24623G(Runnable runnable, String str, DialogInterface dialogInterface, int i10) {
        Optional.ofNullable(runnable).ifPresent(new C3788l4());
        m24629M("cancel temp backup", str);
    }

    /* renamed from: H */
    public static /* synthetic */ void m24624H(Context context, Runnable runnable, String str, DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent(context, (Class<?>) CloudBackupDetailStateActivity.class);
        intent.putExtra("entry_source", "entry_backup_main");
        intent.putExtra("isTempBackup", true);
        context.startActivity(intent);
        Optional.ofNullable(runnable).ifPresent(new C3788l4());
        m24629M("continue backup", str);
    }

    /* renamed from: J */
    public static /* synthetic */ void m24626J(Context context, DialogInterface dialogInterface) {
        m24631O("event_id_special_instructions_dialog", "show dialog", context.getClass().getSimpleName());
    }

    /* renamed from: K */
    public static /* synthetic */ void m24627K(Context context, DialogInterface dialogInterface) {
        m24631O("event_id_special_instructions_dialog", "dismiss dialog", context.getClass().getSimpleName());
    }

    /* renamed from: L */
    public static void m24628L(View view) {
        m24640X((TextView) C12809f.m76831d(view, R$id.tv_title2), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_title2"), 5);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.tv_data_wechat);
        if (SplitAppSettingSingleInstance.getInstance().isSupportSplitBackUp("com.tencent.mm", "3")) {
            textView.setVisibility(8);
        } else {
            m24639W(textView, SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_wechat"));
        }
        TextView textView2 = (TextView) C12809f.m76831d(view, R$id.tv_data_qq);
        if (SplitAppSettingSingleInstance.getInstance().isSupportSplitBackUp("com.tencent.mobileqq", "3")) {
            textView2.setVisibility(8);
        } else {
            m24639W(textView2, SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_QQ"));
        }
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data1), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new1"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data2), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new2"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data3), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new3"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data4), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new4"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data5), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new5"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data6), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new6"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data7), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new7"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data8), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new8"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data9), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new9"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data10), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new10"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data11), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new11"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data12), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new12"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data13), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new13"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data14), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new14"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data15), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new15"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data16), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new16"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data17), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new17"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data18), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new18"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data19), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new19"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data20), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new20"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data21), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new21"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data22), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new22"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data23), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new23"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data24), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new24"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data25), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new25"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data26), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new26"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data27), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new27"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data28), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new28"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data29), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new29"));
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_data30), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_data_new30"));
    }

    /* renamed from: M */
    public static void m24629M(String str, String str2) {
        m24631O("event_id_exit_temp_backup_task", str, str2);
    }

    /* renamed from: N */
    public static void m24630N(String str, String str2, int i10) {
        C11060c c11060cM66626a = C11058a.m66626a(null, "interimBackupChannel", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        c11060cM66626a.m66635A("srcChannel: " + str + " ,activityCode:" + str2 + " ,channel: " + i10);
        c11060cM66626a.m66668x("1");
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("srcChannel", str);
        linkedHashMap.put("activityCode", str2);
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, String.valueOf(i10));
        C13225d.m79490f1().m79567R("interimBackupChannel", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "interimBackupChannel", linkedHashMap);
    }

    /* renamed from: O */
    public static void m24631O(String str, String str2, String str3) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", str2);
        linkedHashMapM79497A.put(RemoteMessageConst.FROM, str3);
        C13225d.m79490f1().m79591l0(str, linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", str, "4", "43", linkedHashMapM79497A);
    }

    /* renamed from: P */
    public static void m24632P() {
        C11839m.m70688i("TempBackUiUtils", "enter resetSwitch");
        C12526j c12526j = new C12526j();
        final List<String> listM75384d0 = c12526j.m75384d0();
        final List<String> listM75387e0 = c12526j.m75387e0();
        final C14229k2 c14229k2 = new C14229k2();
        List<BackupOptionItem> listM78397u = c14229k2.m78397u();
        if (listM78397u != null) {
            listM78397u.forEach(new Consumer() { // from class: zd.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C4012a.m24667x(listM75384d0, listM75387e0, c14229k2, (BackupOptionItem) obj);
                }
            });
        }
        TempBackupDataManager.m24501i().m24506h().forEach(new Consumer() { // from class: zd.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C4012a.m24668y(listM75384d0, listM75387e0, (BackupOptionItem) obj);
            }
        });
        C11839m.m70688i("TempBackUiUtils", "resetSwitch end");
    }

    /* renamed from: Q */
    public static void m24633Q(final SpanClickText spanClickText, TempBackupSelectSpaceView.EnumC4011b enumC4011b) {
        String strM24662s;
        if (spanClickText == null) {
            C11839m.m70689w("TempBackUiUtils", "span click text is null");
            return;
        }
        final Context context = spanClickText.getContext();
        String string = context.getString(R$string.temp_backup_special_instructions);
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: zd.k
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException {
                C4012a.m24669z(context);
            }
        };
        int i10 = C12600v1.f57994d + C12600v1.f57996f;
        if (C13452e.m80781L().m80907e1()) {
            spanClickText.m15931c(string, iSpanClickListener);
            if (enumC4011b == TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_USER_SPACE) {
                strM24662s = context.getString(R$string.temp_backup_entire_system_backup_desc_paid, string);
            } else if (C12600v1.f57996f > 0) {
                Resources resources = context.getResources();
                int i11 = R$plurals.temp_backup_main_vip_msg_for_harmony;
                int i12 = C12600v1.f57994d;
                strM24662s = m24662s("temp_backup_main_vip_msg", resources.getQuantityString(i11, i12, Integer.valueOf(i12), "HarmonyOS 5", Integer.valueOf(i10), string), Integer.valueOf(C12600v1.f57994d), Integer.valueOf(i10), string);
            } else {
                strM24662s = context.getString(R$string.temp_backup_entire_system_backup_desc_paid_extra, Integer.valueOf(i10), string);
            }
        } else {
            String string2 = context.getString(R$string.temp_backup_subscribe_to_member_services);
            spanClickText.m15931c(string2, new SpanClickText.ISpanClickListener() { // from class: zd.l
                @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
                public final void onClick() {
                    C4012a.m24617A(spanClickText, context);
                }
            });
            spanClickText.m15931c(string, iSpanClickListener);
            strM24662s = m24662s("temp_backup_main_free_desc", context.getResources().getQuantityString(R$plurals.temp_backup_main_free_desc, i10, Integer.valueOf(i10), string2, string), Integer.valueOf(i10), Integer.valueOf(i10), string2, string);
        }
        spanClickText.m15934g(strM24662s, false);
    }

    /* renamed from: R */
    public static void m24634R(SpanClickText spanClickText, String str) {
        if (spanClickText == null || TextUtils.isEmpty(str)) {
            C11839m.m70689w("TempBackUiUtils", "span click text is null");
            return;
        }
        final Context context = spanClickText.getContext();
        spanClickText.m15931c(context.getString(R$string.temp_backup_special_instructions), new SpanClickText.ISpanClickListener() { // from class: zd.j
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException {
                C4012a.m24618B(context);
            }
        });
        spanClickText.m15934g(str, false);
    }

    /* renamed from: S */
    public static void m24635S(SpanClickText spanClickText, int i10) {
        final Context context = spanClickText.getContext();
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: zd.q
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                C4012a.m24619C(context);
            }
        };
        String string = context.getString(R$string.temp_backup_network_disable_pause_failed);
        spanClickText.m15931c(string, iSpanClickListener);
        spanClickText.m15934g(context.getString(i10, string), false);
    }

    /* renamed from: T */
    public static void m24636T(SpanClickText spanClickText, String str) {
        if (spanClickText == null || TextUtils.isEmpty(str)) {
            C11839m.m70688i("TempBackUiUtils", "spanClickText is null or text is null.");
            return;
        }
        final Context context = spanClickText.getContext();
        String string = context.getString(R$string.temp_backup_network_disable_pause_failed);
        String strM24662s = m24662s("temp_backup_pause_due_to_network_tip", null, string);
        if (TextUtils.isEmpty(strM24662s)) {
            m24635S(spanClickText, R$string.temp_backup_notification_pause_no_net);
        } else {
            spanClickText.m15931c(string, new SpanClickText.ISpanClickListener() { // from class: zd.b
                @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
                public final void onClick() {
                    C4012a.m24620D(context);
                }
            });
            spanClickText.m15934g(strM24662s, false);
        }
    }

    /* renamed from: U */
    public static void m24637U(SpanClickText spanClickText, int i10) {
        final Context context = spanClickText.getContext();
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: zd.p
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException {
                C4012a.m24621E(context);
            }
        };
        String string = context.getString(R$string.temp_backup_special_instructions);
        spanClickText.m15931c(string, iSpanClickListener);
        spanClickText.m15934g(context.getString(i10, string), false);
    }

    /* renamed from: V */
    public static void m24638V(View view) {
        Context context = view.getContext();
        C11842p.m70721D1((TextView) C12809f.m76831d(view, R$id.tv_title), 1.75f);
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_title1), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_title1"));
        String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_content1");
        boolean zIsEmpty = TextUtils.isEmpty(spaceMultLanguage);
        Double dValueOf = Double.valueOf(9.5d);
        if (!zIsEmpty) {
            m24640X((TextView) C12809f.m76831d(view, R$id.tv_content1), spaceMultLanguage, 1, 35);
            m24640X((TextView) C12809f.m76831d(view, R$id.tv_content2), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_content2"), 2);
            m24640X((TextView) C12809f.m76831d(view, R$id.tv_content3), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_content3"), 3, 100, 100, dValueOf);
            m24640X((TextView) C12809f.m76831d(view, R$id.tv_content4), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_content4"), 4);
            m24640X((TextView) C12809f.m76831d(view, R$id.tv_content5), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_content5"), 5);
            m24640X((TextView) C12809f.m76831d(view, R$id.tv_tips1), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_tips1"), 100, 100, dValueOf);
            m24628L(view);
            m24639W((TextView) C12809f.m76831d(view, R$id.tv_tips2), SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_special_instructions_tips2"));
            return;
        }
        m24639W((TextView) C12809f.m76831d(view, R$id.tv_default_content), context.getString(R$string.temp_backup_special_instructions_content, context.getString(R$string.temp_backup_special_instructions_content_point_one, 1), context.getString(R$string.temp_backup_special_instructions_content_point_two, 2, 35), context.getString(R$string.temp_backup_special_instructions_content_point_three, 3), context.getString(R$string.temp_backup_special_instructions_content_point_four, 4, 24), context.getString(R$string.temp_backup_special_instructions_content_point_five, 5), context.getString(R$string.temp_backup_special_instructions_content_point_six, 6, 100, 100, NumberFormat.getInstance().format(9.5d))));
        C12809f.m76831d(view, R$id.ll_om_des).setVisibility(8);
    }

    /* renamed from: W */
    public static void m24639W(TextView textView, String str) {
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(str);
            }
        }
    }

    /* renamed from: X */
    public static void m24640X(TextView textView, String str, Object... objArr) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = String.format(str, objArr);
            } catch (Exception e10) {
                C11839m.m70689w("TempBackUiUtils", "setTextWithFormat  e " + e10.getMessage());
                str = "";
            }
        }
        m24639W(textView, str);
    }

    /* renamed from: Y */
    public static AlertDialog m24641Y(final AlertDialog alertDialog, final Context context, final String str, final Runnable runnable, final Runnable runnable2, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(context.getString(z10 ? R$string.temp_backup_continue_tips_content_restore : R$string.temp_backup_continue_tips_content)).setNegativeButton(context.getString(R$string.cloud_space_dialog_know), new DialogInterface.OnClickListener() { // from class: zd.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    C4012a.m24623G(runnable, str, dialogInterface, i10);
                }
            }).setPositiveButton(context.getString(R$string.lookat), new DialogInterface.OnClickListener() { // from class: zd.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    C4012a.m24624H(context, runnable2, str, dialogInterface, i10);
                }
            }).setCancelable(false);
            alertDialog = builder.create();
        }
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.o
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C4012a.m24622F(alertDialog, context, str, dialogInterface);
            }
        });
        C11829c.m70594l1(context, alertDialog);
        alertDialog.show();
        return alertDialog;
    }

    /* renamed from: Z */
    public static void m24642Z(final Context context) throws IllegalAccessException, IllegalArgumentException {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_temp_backup_special_instructions, (ViewGroup) null);
        C12809f.m76831d(viewInflate, R$id.img_cancel).setOnClickListener(new View.OnClickListener() { // from class: zd.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        C12808e.m76826e(viewInflate);
        try {
            m24638V(viewInflate);
        } catch (Exception e10) {
            C11839m.m70687e("TempBackUiUtils", "setText error:" + e10.getMessage());
        }
        bottomSheetDialog.setContentView(viewInflate);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.findViewById(R$id.design_bottom_sheet).setBackgroundResource(R.color.transparent);
            if (C0219i.m1463a() >= 17 && C11829c.m70563b0(context)) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                try {
                    attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, 1);
                } catch (Exception e11) {
                    C11839m.m70687e("TempBackUiUtils", "setCutoutMode exception:" + e11.toString());
                }
                window.setAttributes(attributes);
                if (C11842p.m70753O0(context)) {
                    window.addFlags(1024);
                } else {
                    window.clearFlags(1024);
                }
            }
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorM9904s = bottomSheetDialog.m9904s();
        if (C11842p.m70753O0(context)) {
            bottomSheetBehaviorM9904s.m9839C0(C11842p.m70752O(context));
        }
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C4012a.m24626J(context, dialogInterface);
            }
        });
        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: zd.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C4012a.m24627K(context, dialogInterface);
            }
        });
        bottomSheetDialog.show();
    }

    /* renamed from: a0 */
    public static CountDownTimer m24644a0(Button button, Button button2) {
        a aVar = new a(5000L, 1000L, button, SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_not_support_data_range_tips_button"), button2);
        aVar.start();
        return aVar;
    }

    /* renamed from: r */
    public static AlertDialog m24661r(final Context context, DialogInterface.OnClickListener onClickListener) {
        if (context == null) {
            C11839m.m70688i("TempBackUiUtils", "context is null");
            return null;
        }
        String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_not_support_data_range_tips_title");
        String spaceMultLanguage2 = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_not_support_data_range_tips_stage");
        if (TextUtils.isEmpty(spaceMultLanguage)) {
            C11839m.m70688i("TempBackUiUtils", "get multi data failed");
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_temp_backup_not_support_data_range, (ViewGroup) null);
        m24639W((TextView) viewInflate.findViewById(R$id.tv_stage), spaceMultLanguage2);
        m24628L(viewInflate);
        builder.setTitle(spaceMultLanguage).setView(viewInflate).setNegativeButton(context.getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: zd.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                C4012a.m24664u(context, dialogInterface, i10);
            }
        }).setPositiveButton(context.getString(R$string.cloud_oobe_agree_and_proceed_text), onClickListener);
        final AlertDialog alertDialogCreate = builder.create();
        final AtomicReference atomicReference = new AtomicReference();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C4012a.m24665v(context, alertDialogCreate, atomicReference, dialogInterface);
            }
        });
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: zd.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C4012a.m24666w(atomicReference, context, dialogInterface);
            }
        });
        return alertDialogCreate;
    }

    /* renamed from: s */
    public static String m24662s(String str, String str2, Object... objArr) {
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("TempBackUiUtils", "strId is empty");
            return "";
        }
        String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage(str);
        if (TextUtils.isEmpty(spaceMultLanguage)) {
            return str2;
        }
        if (objArr == null) {
            return spaceMultLanguage;
        }
        try {
            str3 = String.format(spaceMultLanguage, objArr);
        } catch (Exception e10) {
            C11839m.m70687e("TempBackUiUtils", "format string error:" + e10.getMessage());
        }
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    /* renamed from: t */
    public static String m24663t(Context context, int i10, boolean z10) {
        String string;
        String str;
        if (context == null) {
            return "";
        }
        if (i10 == 1) {
            string = context.getString(R$string.cancel_backup);
            str = "temp_backup_btn_cancel";
        } else if (i10 == 2) {
            string = context.getString(R$string.pause_backup);
            str = "temp_backup_btn_pause";
        } else {
            if (i10 != 3) {
                return "";
            }
            string = context.getString(R$string.backup_continue_backup);
            str = "temp_backup_btn_resume";
        }
        C11839m.m70689w("TempBackUiUtils", "getTempBackupButtonStr:" + z10 + " ; " + string);
        return !z10 ? string : m24662s(str, string, new Object[0]);
    }

    /* renamed from: u */
    public static /* synthetic */ void m24664u(Context context, DialogInterface dialogInterface, int i10) {
        m24631O("event_id_not_support_data_range_tips", "cancel dialog", context.getClass().getSimpleName());
    }

    /* renamed from: v */
    public static /* synthetic */ void m24665v(Context context, AlertDialog alertDialog, AtomicReference atomicReference, DialogInterface dialogInterface) {
        m24631O("event_id_not_support_data_range_tips", "show dialog", context.getClass().getSimpleName());
        Button button = alertDialog.getButton(-1);
        Button button2 = alertDialog.getButton(-2);
        if (button == null || button2 == null) {
            C11839m.m70689w("TempBackUiUtils", "button is null");
            return;
        }
        button.setEnabled(false);
        button.setAlpha(0.5f);
        button.setAllCaps(false);
        button2.setEnabled(false);
        button2.setAlpha(0.5f);
        atomicReference.set(m24644a0(button, button2));
    }

    /* renamed from: w */
    public static /* synthetic */ void m24666w(AtomicReference atomicReference, Context context, DialogInterface dialogInterface) {
        CountDownTimer countDownTimer = (CountDownTimer) atomicReference.get();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        m24631O("event_id_not_support_data_range_tips", "dismiss dialog", context.getClass().getSimpleName());
    }

    /* renamed from: x */
    public static /* synthetic */ void m24667x(List list, List list2, C14229k2 c14229k2, BackupOptionItem backupOptionItem) {
        c14229k2.m78377L(("thirdAppData".equals(backupOptionItem.getParent()) || "thirdApp".equals(backupOptionItem.getParent())) ? list.contains(backupOptionItem.getAppId()) : ("virtualApp".equals(backupOptionItem.getParent()) || "music".equals(backupOptionItem.getParent()) || HNConstants.DataType.MEDIA.equals(backupOptionItem.getParent())) ? list2.contains(backupOptionItem.getAppId()) : true, backupOptionItem.getAppId(), 0, null);
    }

    /* renamed from: y */
    public static /* synthetic */ void m24668y(List list, List list2, BackupOptionItem backupOptionItem) {
        backupOptionItem.setBackupSwitch(("thirdAppData".equals(backupOptionItem.getParent()) || "thirdApp".equals(backupOptionItem.getParent())) ? list.contains(backupOptionItem.getAppId()) : ("virtualApp".equals(backupOptionItem.getParent()) || "music".equals(backupOptionItem.getParent()) || HNConstants.DataType.MEDIA.equals(backupOptionItem.getParent())) ? list2.contains(backupOptionItem.getAppId()) : true);
        backupOptionItem.setOperateType(0);
        backupOptionItem.setOperateTime(0L);
    }

    /* renamed from: z */
    public static /* synthetic */ void m24669z(Context context) throws IllegalAccessException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUiUtils", "link click to fast");
        } else {
            C11839m.m70688i("TempBackUiUtils", "show special instructions bottom sheet");
            m24642Z(context);
        }
    }
}
