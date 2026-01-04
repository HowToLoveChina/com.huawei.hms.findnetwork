package p836z8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;
import co.AbstractHandlerC1512a;
import com.huawei.android.hicloud.agreement.oobe.OOBEAgreementHelper;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.provider.QueryAppRestoreFromProvider;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.complexutil.C2784e;
import com.huawei.android.hicloud.p088ui.activity.AuthPrivacyAlertActivity;
import com.huawei.android.hicloud.p088ui.activity.AuthorizationAlertActitivty;
import com.huawei.android.hicloud.p088ui.activity.DataMigrationAuthActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.activity.SecondCenterAuthorizationActivity;
import com.huawei.android.hicloud.p088ui.activity.SiteChangeTipActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiadapter.PermissionsItemAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RestoreFailedDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RestoreLauncherDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.StopRecoveryDialog;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil.C4279a;
import com.huawei.android.hicloud.task.schedule.UnloginOOBETaskChecker;
import com.huawei.android.hicloud.task.simple.C3091v1;
import com.huawei.android.hicloud.task.simple.C3097x1;
import com.huawei.android.os.BuildEx;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mn.C11500d;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p020ap.C1006a;
import p020ap.C1008c;
import p020ap.C1010e;
import p037bp.C1270a;
import p224dc.C9064b;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9285d;
import p232dp.InterfaceC9287f;
import p335hd.C10140c;
import p335hd.C10145h;
import p336he.C10155f;
import p422k9.AbstractC11020c;
import p422k9.C11019b;
import p446l7.C11253a;
import p446l7.C11257e;
import p472m7.C11429d;
import p514o9.C11829c;
import p514o9.C11839m;
import p550pb.C12126b;
import p552pd.C12131c;
import p572qb.C12300b0;
import p616rk.C12515a;
import p618rm.C12590s0;
import p684un.C13222a;
import p684un.C13223b;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p711vl.C13466f;
import p742wj.C13612b;
import p744wl.C13619c;
import p783xp.C13843a;
import p846zj.C14306d;

/* renamed from: z8.a */
/* loaded from: classes3.dex */
public class C14152a implements IHiSyncHelper {

    /* renamed from: c */
    public static final C14152a f63298c = new C14152a();

    /* renamed from: a */
    public C2784e f63299a = new C2784e();

    /* renamed from: b */
    public C3091v1 f63300b;

    /* renamed from: z8.a$a */
    public class a implements DeleteOneDeviceBackupRecordDialog.ClickCallback {

        /* renamed from: a */
        public final /* synthetic */ DialogInterface.OnClickListener f63301a;

        /* renamed from: b */
        public final /* synthetic */ DialogInterface.OnClickListener f63302b;

        public a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
            this.f63301a = onClickListener;
            this.f63302b = onClickListener2;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onCancelDelete() {
            this.f63302b.onClick(null, 0);
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onDeleteConfirmed() {
            this.f63301a.onClick(null, 0);
        }
    }

    /* renamed from: z8.a$b */
    public static class b extends AbstractHandlerC1512a {

        /* renamed from: b */
        public AbstractC11020c f63304b;

        public b(Activity activity, AbstractC11020c abstractC11020c) {
            super(activity);
            this.f63304b = abstractC11020c;
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: d */
        public void mo8607d() {
            C11839m.m70688i("HiSyncHelperImp", "Terms query failed, show error!");
            this.f63304b.mo16883b();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: e */
        public void mo8608e(String str) {
            C11839m.m70688i("HiSyncHelperImp", "hms not signed, Terms no need to show.");
            this.f63304b.mo16882a();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: g */
        public void mo8610g() {
            C11839m.m70688i("HiSyncHelperImp", "hms signed, Terms no need to show.");
            this.f63304b.mo16884c();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: h */
        public void mo8611h(List<SignInfo> list) {
            boolean zIsAgree;
            boolean zIsAgree2;
            boolean zIsAgree3;
            if (list != null) {
                zIsAgree = false;
                zIsAgree2 = false;
                zIsAgree3 = false;
                for (SignInfo signInfo : list) {
                    short agrType = signInfo.getAgrType();
                    if (agrType == 125) {
                        zIsAgree = signInfo.isAgree();
                    } else if (agrType == 10000) {
                        zIsAgree2 = signInfo.isAgree();
                    } else if (agrType == 10013) {
                        zIsAgree3 = signInfo.isAgree();
                    }
                }
            } else {
                zIsAgree = false;
                zIsAgree2 = false;
                zIsAgree3 = false;
            }
            boolean z10 = zIsAgree2 || !"CN".equalsIgnoreCase(C11829c.m70533N());
            C11839m.m70688i("HiSyncHelperImp", "doCheckSigned result:" + zIsAgree + '|' + zIsAgree3 + '|' + z10);
            if (zIsAgree && zIsAgree3 && z10) {
                C11839m.m70688i("HiSyncHelperImp", "All signed, Terms no need to show.");
                this.f63304b.mo16884c();
            } else {
                C11839m.m70688i("HiSyncHelperImp", "doNoSign, Terms need to show now.");
                this.f63304b.mo16882a();
            }
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: i */
        public void mo8612i() {
            C11839m.m70688i("HiSyncHelperImp", "doNoSign, Terms need to show.");
            this.f63304b.mo16882a();
        }
    }

    /* renamed from: r0 */
    public static C14152a m84937r0() {
        return f63298c;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: A */
    public AlertDialog mo15824A(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnKeyListener onKeyListener) {
        DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = new DeleteOneDeviceBackupRecordDialog(context, new a(onClickListener, onClickListener2));
        deleteOneDeviceBackupRecordDialog.setOnKeyListener(onKeyListener);
        return deleteOneDeviceBackupRecordDialog;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: B */
    public void mo15825B(Context context) {
        C2783d.m16149i1(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: C */
    public void mo15826C() {
        if (this.f63300b != null) {
            C11839m.m70688i("HiSyncHelperImp", "cancel queryOOBEBasicTask");
            this.f63300b.setAbort(true);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: D */
    public boolean mo15827D(Context context, String str, boolean z10) {
        return this.f63299a.m16195b(context, str, z10);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: E */
    public void mo15828E(Activity activity, AbstractC11020c abstractC11020c) {
        C11839m.m70686d("HiSyncHelperImp", "queryAgreement");
        if (abstractC11020c == null) {
            C11839m.m70688i("HiSyncHelperImp", "OOBESignStateCallback is null");
        } else if (activity == null) {
            C11839m.m70688i("HiSyncHelperImp", "activity is null");
            abstractC11020c.mo16883b();
        } else {
            C12515a.m75110o().m75172d(new C11253a(activity, new b(activity, abstractC11020c)));
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: F */
    public void mo15829F(Context context, Handler handler, int i10, boolean z10) {
        C11839m.m70688i("HiSyncHelperImp", "executeQueryOOBEBasicTask");
        this.f63300b = new C3091v1(context, handler, i10, z10);
        C12515a.m75110o().m75175e(this.f63300b, false);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: G */
    public void mo15830G(Context context) {
        C2783d.m16131c1(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: H */
    public void mo15831H(Context context) {
        if (context == null) {
            return;
        }
        C11839m.m70686d("HiSyncHelperImp", "start BI report in normal");
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        boolean zM62388s7 = c10028cM62182c0.m62388s("backup_key");
        if (c10028cM62182c0.m62395t1("funcfg_contacts")) {
            mo15865h0(context, "contactNormal", zM62388s);
            UBAAnalyze.m29949J("CKC", "contactNormal", "value", String.valueOf(zM62388s));
        }
        if (c10028cM62182c0.m62395t1("funcfg_calendar")) {
            mo15865h0(context, "calendarNormal", zM62388s2);
            UBAAnalyze.m29949J("CKC", "calendarNormal", "value", String.valueOf(zM62388s2));
        }
        if (c10028cM62182c0.m62395t1("funcfg_wlan")) {
            mo15865h0(context, "wlanNormal", zM62388s5);
            UBAAnalyze.m29949J("CKC", "wlanNormal", "value", String.valueOf(zM62388s5));
        }
        if (c10028cM62182c0.m62395t1("funcfg_browser") && (C13843a.m83078b0(context, Constants.HW_BROWSER_PACKAGE) || C13843a.m83078b0(context, "com.android.browser"))) {
            mo15865h0(context, "browserNormal", zM62388s6);
            UBAAnalyze.m29949J("CKC", "browserNormal", "value", String.valueOf(zM62388s6));
        }
        if (c10028cM62182c0.m62395t1("funcfg_notes")) {
            mo15865h0(context, "noteNormal", zM62388s4);
            UBAAnalyze.m29949J("CKC", "noteNormal", "value", String.valueOf(zM62388s4));
        }
        if (c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
            mo15865h0(context, "cloudBackupNormal", zM62388s7);
            UBAAnalyze.m29949J("CKC", "cloudBackupNormal", "value", String.valueOf(zM62388s7));
        }
        if (c10028cM62182c0.m62395t1("funcfg_gallery")) {
            mo15865h0(context, "galleryNormal", zM62388s3);
            UBAAnalyze.m29949J("CKC", "galleryNormal", "value", String.valueOf(zM62388s3));
        }
        ArrayList<SyncConfigService> arrayListM66456z = C11019b.m66371t().m66456z(context);
        if (arrayListM66456z == null || arrayListM66456z.size() <= 0) {
            return;
        }
        Iterator<SyncConfigService> it = arrayListM66456z.iterator();
        while (it.hasNext()) {
            SyncConfigService next = it.next();
            boolean zM62388s8 = c10028cM62182c0.m62388s(next.getId());
            mo15865h0(context, next.getId() + "Normal", zM62388s8);
            UBAAnalyze.m29949J("CKC", "Normal", "value", String.valueOf(zM62388s8));
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: I */
    public void mo15832I(Context context) {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C11839m.m70688i("HiSyncHelperImp", "restoreStatus = " + iM80916g0);
        Intent intent = new Intent(context, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", 2);
        bundle.putInt("restore_status", iM80916g0);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: J */
    public void mo15833J(Context context) {
        if (UnloginOOBETaskChecker.m18050j()) {
            C11839m.m70688i("HiSyncHelperImp", "Already running");
        } else {
            new UnloginOOBETaskChecker(context).m18052i();
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: K */
    public void mo15834K(Context context, Bundle bundle) {
        C12131c.m72744j().m72746k(context, bundle);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: L */
    public void mo15835L(Context context) {
        context.startActivity(new Intent(context, (Class<?>) MainActivity.class));
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: M */
    public void mo15836M(Context context) {
        C11500d.m68648g().m68660m(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: N */
    public void mo15837N(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        C12515a.m75110o().m75172d(new C11257e(context, z10, z11, z12, z13));
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: O */
    public void mo15838O(Context context, Handler handler) {
        C11839m.m70686d("HiSyncHelperImp", "OOBE urlsVerifyProcess");
        if (handler == null) {
            C11839m.m70688i("HiSyncHelperImp", "OOBE urlsVerifyProcess handler is null");
            return;
        }
        if (context != null) {
            C12515a.m75110o().m75175e(new C10140c(handler), false);
        } else {
            C11839m.m70688i("HiSyncHelperImp", "OOBE urlsVerifyProcess context is null");
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            handler.sendMessage(messageObtain);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: P */
    public boolean mo15839P(int i10) {
        return 32997 == i10;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: Q */
    public void mo15840Q(Context context, boolean z10) {
        C2783d.m16143g1(context, z10);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: R */
    public void mo15841R(AlertDialog alertDialog) {
        String strQueryBakSourceStrategy = new SettingOperator().queryBakSourceStrategy();
        C11839m.m70688i("HiSyncHelperImp", "bakSourceStrategy: " + strQueryBakSourceStrategy);
        if (TextUtils.equals("1", strQueryBakSourceStrategy)) {
            return;
        }
        if (alertDialog instanceof DeleteOneDeviceBackupRecordDialog) {
            ((DeleteOneDeviceBackupRecordDialog) alertDialog).showBasicDeleteAndClose(C12590s0.m75814X());
        } else {
            C11839m.m70687e("HiSyncHelperImp", "mBackupDialog is not belong DeleteOneDeviceBackupRecordDialog");
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: S */
    public boolean mo15842S(int i10) {
        return 32330 == i10;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: T */
    public boolean mo15843T(Context context) {
        boolean zM6138d = C1010e.m6125b().m6138d(context);
        C11839m.m70688i("HiSyncHelperImp", "finderSwitch :" + zM6138d);
        return zM6138d;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: U */
    public boolean mo15844U(int i10) {
        return 32002 == i10;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: V */
    public CommonDialogInterface mo15845V(Context context) {
        return new StopRecoveryDialog(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: W */
    public void mo15846W(Context context) {
        if (C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12) {
            C10028c.m62183d0(context).m62336h2("support_push_notify_control", true);
            C13223b.m79484l(context, 1, 3);
            C12515a.m75110o().m75172d(new C10145h(context.getApplicationContext(), true));
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: X */
    public void mo15847X(Bundle bundle, InterfaceC13449b interfaceC13449b) {
        C13612b.m81829B().m81871l(bundle, interfaceC13449b);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: Y */
    public void mo15848Y(Context context, String str, Switch r42, boolean z10) {
        if (r42 instanceof UnionSwitch) {
            this.f63299a.m16196c(context, str, (UnionSwitch) r42, z10);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: Z */
    public void mo15849Z(Context context) {
        new BackupNotificationManager(context).clearSummaryNotification();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: a */
    public void mo15850a(Context context, String str, boolean z10) {
        C1008c.m6035v().m6047L(context, str, z10);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: a0 */
    public BaseAdapter mo15851a0(Context context) {
        return new PermissionsItemAdapter(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: b */
    public void mo15852b(Context context, String str) {
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f == null) {
            C11839m.m70688i("HiSyncHelperImp", "PhoneFinderRouter is null");
        } else {
            interfaceC9287f.mo58559b(context, str);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: b0 */
    public ArrayList<SyncConfigService> mo15853b0(Context context) {
        return NotifyUtil.getShownSyncServiceItems(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: c */
    public void mo15854c(Context context, boolean z10) {
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f != null) {
            interfaceC9287f.mo58560c(context, z10);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: c0 */
    public void mo15855c0(ListView listView, BaseAdapter baseAdapter) {
        C2783d.m16176r1(listView, baseAdapter);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public void cloudbackupOpr(boolean z10) {
        CloudBackupService.getInstance().cloudbackupOpr(z10);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: d */
    public Long mo15856d() {
        return Long.valueOf(new SettingOperator().queryinitopentime());
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: d0 */
    public boolean mo15857d0() {
        return CBAccess.inRestoreTask();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: e */
    public void mo15858e(Context context, String str, String str2) {
        C13223b.m79473a(context, str, str2);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: e0 */
    public void mo15859e0(Handler.Callback callback) {
        CloudBackupService.getInstance().unregister(callback);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: f */
    public void mo15860f() {
        CloudBackupService.getInstance().deleteAllBaseAppModule(1);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: f0 */
    public boolean mo15861f0(Context context) {
        return QueryAppRestoreFromProvider.checkPrioritRestoreIcon(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: g */
    public void mo15862g(Context context) {
        if (context == null) {
            return;
        }
        C11839m.m70686d("HiSyncHelperImp", "start BI report in oobe");
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        boolean zM62388s7 = c10028cM62182c0.m62388s("backup_key");
        if (c10028cM62182c0.m62395t1("funcfg_contacts")) {
            mo15865h0(context, "contactOOBE", zM62388s);
            UBAAnalyze.m29949J("CKC", "contactOOBE", "value", String.valueOf(zM62388s));
        }
        if (c10028cM62182c0.m62395t1("funcfg_calendar")) {
            mo15865h0(context, "calendarOOBE", zM62388s2);
            UBAAnalyze.m29949J("CKC", "calendarOOBE", "value", String.valueOf(zM62388s2));
        }
        if (c10028cM62182c0.m62395t1("funcfg_wlan")) {
            mo15865h0(context, "wlanOOBE", zM62388s5);
            UBAAnalyze.m29949J("CKC", "wlanOOBE", "value", String.valueOf(zM62388s5));
        }
        if (c10028cM62182c0.m62395t1("funcfg_browser") && (C13843a.m83078b0(context, Constants.HW_BROWSER_PACKAGE) || C13843a.m83078b0(context, "com.android.browser"))) {
            mo15865h0(context, "browserOOBE", zM62388s6);
            UBAAnalyze.m29949J("CKC", "browserOOBE", "value", String.valueOf(zM62388s6));
        }
        if (c10028cM62182c0.m62395t1("funcfg_notes")) {
            mo15865h0(context, "noteOOBE", zM62388s4);
            UBAAnalyze.m29949J("CKC", "noteOOBE", "value", String.valueOf(zM62388s4));
        }
        if (c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
            mo15865h0(context, "cloudBackupOOBE", zM62388s7);
            UBAAnalyze.m29949J("CKC", "cloudBackupOOBE", "value", String.valueOf(zM62388s7));
        }
        if (c10028cM62182c0.m62395t1("funcfg_gallery")) {
            mo15865h0(context, "galleryOOBE", zM62388s3);
            UBAAnalyze.m29949J("CKC", "galleryOOBE", "value", String.valueOf(zM62388s3));
        }
        ArrayList<SyncConfigService> arrayListM66456z = C11019b.m66371t().m66456z(context);
        if (arrayListM66456z == null || arrayListM66456z.size() <= 0) {
            return;
        }
        Iterator<SyncConfigService> it = arrayListM66456z.iterator();
        while (it.hasNext()) {
            SyncConfigService next = it.next();
            boolean zM62388s8 = c10028cM62182c0.m62388s(next.getId());
            mo15865h0(context, next.getId() + "OOBE", zM62388s8);
            UBAAnalyze.m29949J("CKC", "OOBE", "value", String.valueOf(zM62388s8));
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: g0 */
    public LinkMovementMethod mo15863g0() {
        return new C11429d();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: h */
    public boolean mo15864h(Context context) {
        if (((InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class)) == null) {
            C11839m.m70687e("HiSyncHelperImp", "cloudSyncRouter is null in isHiCloudLogin");
            return false;
        }
        boolean zM63291o = C10155f.m63291o(context);
        if (!C13452e.m80781L().m80850R0() || C0209d.m1173G1(context)) {
            return false;
        }
        return zM63291o;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: h0 */
    public void mo15865h0(Context context, String str, boolean z10) {
        C13222a.m79469k(context, str, z10);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: i */
    public void mo15866i(Handler.Callback callback) {
        CloudBackupService.getInstance().register(callback);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: i0 */
    public void mo15867i0(Context context) {
        if (context != null) {
            Bundle bundle = new Bundle();
            bundle.putString("taskStartChannel", "from_hicloud_application");
            bundle.putInt("fromMigration", 1);
            C12515a.m75110o().m75172d(new C3097x1(context.getApplicationContext(), bundle));
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public boolean inBackup() {
        return CBAccess.inBackup();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public boolean inRestore() {
        return CBAccess.inRestore();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public boolean inRestoreFirst() {
        return CBAccess.inRestoreFirst();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public boolean isSendPhoneFinderOning() {
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f != null) {
            return interfaceC9287f.mo58562e();
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public boolean isShowGalleryItemView() {
        return C10155f.m63249B();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public boolean isSupportAntiTheft() {
        return C1010e.m6125b().m6149o();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: j */
    public void mo15868j(Boolean bool, Activity activity) {
        CloudBackupReport.reportCloseSuccess(bool, activity);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: j0 */
    public String mo15869j0(Context context, String str) {
        return C0209d.m1333z1(context) ? new OOBEAgreementHelper(context, str, C11829c.m70533N(), C0234s.m1634l()).getAgreementFromTMS() : "";
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: k */
    public boolean mo15870k(Context context) {
        boolean z10 = context instanceof DataMigrationAuthActivity;
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("HiSyncHelperImp", "cloudAlbumRouterImpl is null");
            return false;
        }
        boolean zMo58449q = interfaceC9282a.mo58449q(context);
        boolean z11 = context instanceof SiteChangeTipActivity;
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        return (z10 || zMo58449q || z11 || (interfaceC9287f != null ? interfaceC9287f.mo58551N(context) : false)) ? false : true;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: k0 */
    public void mo15871k0(String str, String str2, String str3, int i10, String str4, int i11, boolean z10, boolean z11, boolean z12) {
        C13466f.m81073d().m81081i("restore_is_new_bm_record", z12);
        if (C13619c.m81952h(str3)) {
            CloudBackupService.getInstance().restoreV3(str, str2, str4, i11, str3, RestoreUtil.getBakCategory(z10, z11));
        } else {
            CloudBackupService.getInstance().restore(str2, i10, str4, i11);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: l */
    public CommonDialogInterface mo15872l(Context context) {
        return new RestoreLauncherDialog(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: l0 */
    public void mo15873l0(Context context, Activity activity) {
        if (C14306d.m85208i()) {
            C11839m.m70688i("HiSyncHelperImp", "second data center country");
            Intent intent = new Intent();
            intent.setClass(context, SecondCenterAuthorizationActivity.class);
            activity.startActivityForResult(intent, 10001);
            return;
        }
        if (!"CN".equalsIgnoreCase(C13452e.m80781L().m80942m())) {
            C11839m.m70688i("HiSyncHelperImp", "showUserAgreeView, oversea other country");
            Intent intent2 = new Intent();
            intent2.setClass(context, AuthPrivacyAlertActivity.class);
            activity.startActivityForResult(intent2, 10001);
            return;
        }
        C11839m.m70688i("HiSyncHelperImp", "showUserAgreeView, china");
        Intent intent3 = new Intent();
        intent3.setClass(context, AuthorizationAlertActitivty.class);
        intent3.putExtra("startSource", "newhisync");
        activity.startActivityForResult(intent3, 10001);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: m */
    public Integer mo15874m(int i10) {
        if (i10 != 0) {
            return i10 != 1 ? i10 != 2 ? Integer.valueOf(R$string.delete_backup_record_service_failed) : Integer.valueOf(R$string.delete_backup_record_failed) : Integer.valueOf(R$string.delete_lock_conflict_toast);
        }
        C11839m.m70688i("HiSyncHelperImp", "backup record delete success");
        return null;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: m0 */
    public void mo15875m0() {
        CloudBackupService.getInstance().abort();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: n */
    public ClickableSpan mo15876n(Context context, int i10) {
        return new NewHiSyncUtil(context).new C4279a(i10, context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: n0 */
    public void mo15877n0(Context context, Intent intent) {
        C13223b.m79481i(context, intent);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: o */
    public void mo15878o(Context context) {
        C2783d.m16173q1(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: o0 */
    public CommonDialogInterface mo15879o0(Context context) {
        return new RestoreFailedDialog(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public void openPhoneFinderInBack() {
        C12300b0.m73940b().m73943e(12);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: p */
    public boolean mo15880p(int i10) {
        return 32326 == i10;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: p0 */
    public void mo15881p0(Context context, int i10, String str) {
        C13223b.m79480h(context, i10, str);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: q */
    public String mo15882q(Context context, String str) {
        return C2783d.m16081F(context, str);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: q0 */
    public void mo15883q0(Context context, Bundle bundle) {
        C1006a.m5936k().m5943G(context, bundle, 5);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: r */
    public boolean mo15884r(Context context) {
        return C10155f.m63285i(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: s */
    public String mo15885s() {
        return CBAccess.getCurrent();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public void setMrGuide(boolean z10) {
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f == null) {
            C11839m.m70688i("HiSyncHelperImp", "PhoneFinderRouter is null");
            return;
        }
        C11839m.m70688i("HiSyncHelperImp", "setMrGuide: " + z10);
        interfaceC9287f.setMrGuide(z10);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: t */
    public ArrayList<DriveConfigService> mo15886t(Context context) {
        return NotifyUtil.getShownDriveServiceItems(context);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: u */
    public LinkMovementMethod mo15887u() {
        return new NewHiSyncUtil.C4280b();
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: v */
    public void mo15888v(String str, Bundle bundle) {
        C12126b.m72707c("2", bundle);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: w */
    public ClickableSpan mo15889w(Context context, String str) {
        return new C9064b(context, str);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    public void writeUISwitchToFile() {
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f != null) {
            interfaceC9287f.mo58581x(C0213f.m1377a());
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: x */
    public boolean mo15890x(int i10) {
        return 32321 == i10;
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: y */
    public String mo15891y(Context context, String str) {
        return C2783d.m16079E(context, str);
    }

    @Override // com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper
    /* renamed from: z */
    public void mo15892z(Context context) {
        this.f63299a.m16203j(context);
    }
}
