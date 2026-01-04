package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudSpaceShareUsageBaseAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.InviteMemberErrorTipDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.StopShareCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.StopShareDialog;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.FailedFamilyMemberInfo;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import com.huawei.hicloud.base.bean.FamilyDetailInfoRetBody;
import com.huawei.hicloud.base.bean.InviteFamilyMemberResult;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p254eb.C9441b;
import p284fb.C9681b;
import p364ib.C10465b;
import p514o9.C11839m;
import p572qb.C12331w;
import p616rk.C12515a;
import p664u0.C13108a;
import p709vj.C13452e;
import p732w8.AsyncTaskC13554e;
import p732w8.C13552c;
import p732w8.C13561l;
import p732w8.C13573x;
import p732w8.C13574y;
import p737wd.ViewOnClickListenerC13589b;
import p778xk.C13823d;

/* loaded from: classes3.dex */
public class CloudSpaceShareBaseActivity extends UIActivity {

    /* renamed from: A */
    public TextView f14596A;

    /* renamed from: B */
    public int f14597B;

    /* renamed from: C */
    public int f14598C;

    /* renamed from: E */
    public int f14600E;

    /* renamed from: G */
    public long f14602G;

    /* renamed from: H */
    public String f14603H;

    /* renamed from: J */
    public CloudSpaceShareUsageBaseAdapter f14605J;

    /* renamed from: M */
    public int f14608M;

    /* renamed from: N */
    public AlertDialog f14609N;

    /* renamed from: O */
    public StopShareDialog f14610O;

    /* renamed from: P */
    public InviteMemberErrorTipDialog f14611P;

    /* renamed from: Q */
    public Toast f14612Q;

    /* renamed from: p */
    public RelativeLayout f14614p;

    /* renamed from: q */
    public NotchFitLinearLayout f14615q;

    /* renamed from: r */
    public AutoSizeButton f14616r;

    /* renamed from: s */
    public AutoSizeButton f14617s;

    /* renamed from: t */
    public HwProgressBar f14618t;

    /* renamed from: u */
    public NotchFitLinearLayout f14619u;

    /* renamed from: v */
    public NotchFitLinearLayout f14620v;

    /* renamed from: w */
    public NotchFitLinearLayout f14621w;

    /* renamed from: x */
    public ScrollDisabledListView f14622x;

    /* renamed from: y */
    public TextView f14623y;

    /* renamed from: z */
    public TextView f14624z;

    /* renamed from: D */
    public int f14599D = 0;

    /* renamed from: F */
    public int f14601F = 0;

    /* renamed from: I */
    public String f14604I = "";

    /* renamed from: K */
    public boolean f14606K = false;

    /* renamed from: L */
    public int f14607L = 1;

    /* renamed from: R */
    public Handler f14613R = new HandlerC3252a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceShareBaseActivity$a */
    public class HandlerC3252a extends Handler {
        public HandlerC3252a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2018) {
                CloudSpaceShareBaseActivity.this.f14605J.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceShareBaseActivity$b */
    public class DialogInterfaceOnClickListenerC3253b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Handler f14626a;

        public DialogInterfaceOnClickListenerC3253b(Handler handler) {
            this.f14626a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                CloudSpaceShareBaseActivity.this.m20226d2(this.f14626a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceShareBaseActivity$c */
    public class DialogInterfaceOnClickListenerC3254c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3254c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CloudSpaceShareBaseActivity.this.f14609N.dismiss();
        }
    }

    /* renamed from: L1 */
    public void m20208L1() {
        if (this.f14599D == 1) {
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_CANCEL_DISABLE_DIALOG_BUTTON);
        } else {
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_CANCEL_QUIT_DIALOG_BUTTON);
        }
    }

    /* renamed from: M1 */
    public boolean m20209M1(String str) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (zIsEmpty) {
            mo20203x2();
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.SET_VIEW_STRING, FamilyShareConstants.Report.SET_VIEW_STRING_RESULT, -1);
        }
        return zIsEmpty;
    }

    /* renamed from: N1 */
    public void m20210N1(Handler handler) {
        m20238q2(false);
        if (this.f14599D == 1) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "owner disable space share");
            m20218V1(handler);
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_DISABLE_DIALOG_BUTTON);
        } else {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "member quit space share");
            m20224b2(handler);
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_QUIT_DIALOG_BUTTON);
        }
    }

    /* renamed from: O1 */
    public void m20211O1(Message message, String str, Handler handler) {
        int i10 = message.what;
        if (i10 != 2004 && i10 != 2006) {
            m20238q2(true);
            m20234l2();
            C11839m.m70688i("CloudSpaceShareBaseActivity", "disable or quit space share failed " + i10);
            m20227e2(this.f14607L, this.f14608M, str, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            return;
        }
        RetResult retResult = (RetResult) message.obj;
        if (retResult == null) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "disable or quit space share failed,response null");
            return;
        }
        int retCode = retResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareBaseActivity", "disable or quit space share,retcode:" + retCode);
        m20227e2(this.f14607L, this.f14608M, str, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, retCode);
        if (retCode == 0) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "disable or quit space share success " + retCode);
            if (this.f14599D != 1) {
                m20226d2(handler);
                return;
            } else {
                setResult(-1);
                finish();
                return;
            }
        }
        if (retCode == 1012) {
            setResult(102);
            finish();
        } else if (retCode != 1016) {
            m20238q2(true);
            m20234l2();
        } else {
            m20238q2(true);
            if (str == FamilyShareConstants.Report.DISABLE_FAMILY_SHARE) {
                m20234l2();
            }
            m20226d2(handler);
        }
    }

    /* renamed from: P1 */
    public void m20212P1(Message message, Handler handler) {
        if (message == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "dealInviteFamilyShare, msg is null");
            return;
        }
        if (message.what != 2016) {
            m20213Q1(message.arg1);
            return;
        }
        InviteFamilyMemberResult inviteFamilyMemberResult = (InviteFamilyMemberResult) message.obj;
        if (inviteFamilyMemberResult == null) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "invite member failed, response null");
            m20244w2(getText(R$string.invite_family_member_failed_server_error));
            return;
        }
        int retCode = inviteFamilyMemberResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareBaseActivity", "invite member, retCode = " + retCode);
        if (retCode == 0) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "invite member success");
            m20244w2(getText(R$string.invite_family_member_success));
            return;
        }
        if (retCode == -1) {
            m20214R1(message.getData(), inviteFamilyMemberResult, handler);
            return;
        }
        if (retCode != 1012 && retCode != 1016) {
            if (retCode == 1019) {
                Toast.makeText(this, R$string.famliy_share_invitation_not_enough, 1).show();
                return;
            } else {
                m20234l2();
                return;
            }
        }
        C11839m.m70686d("CloudSpaceShareBaseActivity", "retcode:" + retCode);
        m20244w2(getText(R$string.space_share_not_open));
    }

    /* renamed from: Q1 */
    public final void m20213Q1(int i10) {
        C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, error code: " + i10);
        if (i10 == 503) {
            m20244w2(getText(R$string.invite_family_member_failed_flow_control));
        } else if (i10 == 1105) {
            m20244w2(getText(R$string.invite_family_member_failed_net_disable));
        } else {
            m20244w2(getText(R$string.invite_family_member_failed_server_error));
        }
    }

    /* renamed from: R1 */
    public final void m20214R1(Bundle bundle, InviteFamilyMemberResult inviteFamilyMemberResult, Handler handler) {
        if (bundle == null || inviteFamilyMemberResult == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, request uid list is null");
            m20244w2(getText(R$string.invite_family_member_failed_server_error));
            return;
        }
        long[] longArray = bundle.getLongArray(FamilyShareConstants.INVITE_FAMILY_MEMBER_REQUEST_UID_KEY);
        if (longArray == null || longArray.length != 1) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, request uid list size not 1");
            m20244w2(getText(R$string.invite_family_member_failed_server_error));
            return;
        }
        long j10 = longArray[0];
        List<FailedFamilyMemberInfo> failedFamilyMembers = inviteFamilyMemberResult.getFailedFamilyMembers();
        if (failedFamilyMembers == null || failedFamilyMembers.size() != 1) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, failed list is null");
            m20244w2(getText(R$string.invite_family_member_failed_server_error));
            return;
        }
        FailedFamilyMemberInfo failedFamilyMemberInfo = failedFamilyMembers.get(0);
        if (failedFamilyMemberInfo == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, member info is null");
            m20244w2(getText(R$string.invite_family_member_failed_server_error));
            return;
        }
        if (j10 == failedFamilyMemberInfo.getFailedUserId().longValue()) {
            int retCode = failedFamilyMemberInfo.getRetCode();
            if (retCode == 1010) {
                C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, FAMILY_SHARE_NOT_OPEN");
                m20237o2(handler);
                return;
            }
            if (retCode == 1015) {
                C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, USER_HAS_JOINED_SHARE_SPACE");
                m20244w2(getText(R$string.invite_family_member_failed_joined));
                m20226d2(handler);
            } else if (retCode == 1014) {
                C11839m.m70687e("CloudSpaceShareBaseActivity", "invite member failed, SHARE_UNUSED_SPACE_NOT_ENOUGH");
                ViewOnClickListenerC13589b viewOnClickListenerC13589b = new ViewOnClickListenerC13589b(this, handler, FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS);
                viewOnClickListenerC13589b.setCancelable(false);
                viewOnClickListenerC13589b.show();
            }
        }
    }

    /* renamed from: S1 */
    public void mo20215S1(Message message, Handler handler) {
        int i10 = message.what;
        if (i10 != 2000) {
            mo20222Z1(i10);
            m20239r2(true);
            if (i10 == 2020) {
                m20240s2();
            } else {
                m20234l2();
            }
            C11839m.m70688i("CloudSpaceShareBaseActivity", "join space share failed " + i10);
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.JOIN_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            return;
        }
        RetResult retResult = (RetResult) message.obj;
        if (retResult == null) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "join space share failed,response null");
            return;
        }
        int retCode = retResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareBaseActivity", "join space share,retcode:" + retCode);
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.JOIN_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, retCode);
        if (retCode == 0) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "join space share success " + retCode);
            mo20223a2(handler);
            return;
        }
        if (retCode == 1012) {
            mo20222Z1(retCode);
            setResult(102);
            finish();
            return;
        }
        if (retCode == 1014) {
            mo20222Z1(retCode);
            m20239r2(true);
            m20242u2();
            return;
        }
        if (retCode == 1015) {
            mo20222Z1(retCode);
            m20238q2(true);
            m20226d2(handler);
        } else if (retCode == 1019) {
            Toast.makeText(this, R$string.famliy_share_join_not_enough, 1).show();
            m20239r2(true);
        } else if (retCode == 1027) {
            m20241t2();
            m20239r2(true);
        } else {
            mo20222Z1(retCode);
            m20239r2(true);
            m20234l2();
        }
    }

    /* renamed from: T1 */
    public void m20216T1(Message message, String str, Handler handler) {
        m20211O1(message, str, handler);
    }

    /* renamed from: U1 */
    public boolean m20217U1() {
        if (this.f14598C != 0) {
            m20231i2();
        } else if (this.f14602G != -1) {
            if (this.f14616r == null) {
                C11839m.m70687e("CloudSpaceShareBaseActivity", "mUseBtn is null");
                return true;
            }
            m20232j2();
        }
        m20233k2();
        return false;
    }

    /* renamed from: V1 */
    public void m20218V1(Handler handler) {
        if (handler == null) {
            return;
        }
        C12515a.m75110o().m75172d(new C13552c(handler));
    }

    /* renamed from: W1 */
    public List<FamilyDetailInfo> m20219W1(List<FamilyDetailInfo> list) throws Resources.NotFoundException {
        String strM64293c;
        FamilyDetailInfo familyDetailInfo = new FamilyDetailInfo();
        Resources resources = getResources();
        for (int i10 = 0; i10 < list.size(); i10++) {
            FamilyDetailInfo familyDetailInfo2 = list.get(i10);
            if (familyDetailInfo2 != null && familyDetailInfo2.getOwner()) {
                familyDetailInfo = familyDetailInfo2;
            }
        }
        if (resources != null) {
            this.f14604I = familyDetailInfo.getName();
            if (TextUtils.equals(C13452e.m80781L().m80971t0(), String.valueOf(familyDetailInfo.getUid()))) {
                C11839m.m70688i("CloudSpaceShareBaseActivity", "owner is current user");
                strM64293c = resources.getString(R$string.space_share_come_from_sharer);
            } else {
                strM64293c = C10465b.m64293c(resources.getString(R$string.space_share_come_from), this.f14604I);
            }
            this.f14596A.setText(strM64293c);
        }
        return list;
    }

    /* renamed from: X1 */
    public final void m20220X1(List<FamilyDetailInfo> list) {
        if (list == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "familydetailinfo is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            FamilyDetailInfo familyDetailInfo = list.get(i10);
            String imageURL = familyDetailInfo != null ? familyDetailInfo.getImageURL() : "";
            if (!TextUtils.isEmpty(imageURL) && !m20221Y1(imageURL)) {
                arrayList.add(imageURL);
            }
        }
        if (arrayList.size() > 0) {
            C12515a.m75110o().m75172d(new C13561l(this, this.f14613R, arrayList));
        }
    }

    /* renamed from: Y1 */
    public final boolean m20221Y1(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "context is null");
            return false;
        }
        return new File(contextM1377a.getFilesDir() + FamilyShareConstants.FAMILY_IMAGE_FILE_PATH + str.hashCode()).exists();
    }

    /* renamed from: Z1 */
    public void mo20222Z1(int i10) {
    }

    /* renamed from: a2 */
    public void mo20223a2(Handler handler) {
        m20238q2(true);
        m20231i2();
        m20226d2(handler);
        m20230h2();
        C13823d.m82901N();
        C11839m.m70688i("CloudSpaceShareBaseActivity", "join space share success, and notify gallery.");
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58389Q0();
        }
        C12515a.m75110o().m75172d(new C12331w(true, true, 27));
        C11839m.m70688i("CloudSpaceShareBaseActivity", "joinSpaceShareSuccess");
        m20229g2();
    }

    /* renamed from: b2 */
    public void m20224b2(Handler handler) {
        if (handler == null) {
            return;
        }
        C12515a.m75110o().m75172d(new C13574y(handler));
    }

    /* renamed from: c2 */
    public void m20225c2(FamilyDetailInfoRetBody familyDetailInfoRetBody, Handler handler) {
        QuotaInfo quotaInfo = familyDetailInfoRetBody.getQuotaInfo();
        List<FamilyDetailInfo> usedSpaceInfoList = familyDetailInfoRetBody.getUsedSpaceInfoList();
        if (quotaInfo == null || usedSpaceInfoList == null) {
            mo20203x2();
            return;
        }
        mo20205y2();
        QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
        C11839m.m70686d("CloudSpaceShareBaseActivity", "total:" + quotaSpaceInfo.getTotal() + " used:" + quotaSpaceInfo.getUsed() + " available:" + quotaSpaceInfo.getAvailable());
        m20236n2(quotaSpaceInfo);
        if (usedSpaceInfoList.size() > 0) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "family members:" + usedSpaceInfoList.size());
            m20235m2(usedSpaceInfoList);
            m20220X1(usedSpaceInfoList);
            CloudSpaceShareUsageBaseAdapter cloudSpaceShareUsageBaseAdapter = this.f14605J;
            if (cloudSpaceShareUsageBaseAdapter != null) {
                cloudSpaceShareUsageBaseAdapter.mo989a(m20219W1(usedSpaceInfoList));
            }
        } else {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "family members error");
        }
        if (this.f14606K) {
            this.f14606K = false;
            m20239r2(false);
            m20245z2(handler);
        }
    }

    /* renamed from: d2 */
    public void m20226d2(Handler handler) {
        C11839m.m70688i("CloudSpaceShareBaseActivity", "refreshFamilyShareInfoAndDetail");
        if (!C0209d.m1333z1(this)) {
            mo20194p2();
            return;
        }
        AsyncTaskC13554e asyncTaskC13554eM81494d = AsyncTaskC13554e.m81494d(handler);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC13554eM81494d.getStatus())) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "refreshFamilyShareInfoAndDetail task is running.");
        } else {
            asyncTaskC13554eM81494d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: e2 */
    public void m20227e2(int i10, int i11, String str, String str2, int i12) {
        C9681b.m60470l().m60478H(String.valueOf(i10), String.valueOf(i11), str, str2, String.valueOf(i12));
    }

    /* renamed from: f2 */
    public void m20228f2(int i10, int i11, String str, String str2, int i12, int i13) {
        C9681b.m60470l().m60479I(String.valueOf(i10), String.valueOf(i11), str, str2, String.valueOf(i12), String.valueOf(i13));
    }

    /* renamed from: g2 */
    public final void m20229g2() {
        C11839m.m70688i("CloudSpaceShareBaseActivity", FamilyShareConstants.Report.JOIN_FAMILY_SHARE);
        Intent intent = new Intent();
        intent.setAction(FamilyShareConstants.Report.CLICK_JOIN_BUTTON);
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: h2 */
    public final void m20230h2() {
        if (new SafeIntent(getIntent()).getBooleanExtra("right_to_join_family", false)) {
            Intent intent = new Intent();
            intent.putExtra("right_to_join_family_for_result", true);
            setResult(-1, intent);
        }
    }

    /* renamed from: i2 */
    public void m20231i2() {
        AutoSizeButton autoSizeButton = this.f14617s;
        if (autoSizeButton == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "mUseBtn is null");
        } else if (this.f14599D == 1) {
            autoSizeButton.setText(getString(R$string.stop_share_with_family));
        } else {
            autoSizeButton.setText(getString(R$string.stop_use_family_cloud_space));
        }
    }

    /* renamed from: j2 */
    public void m20232j2() {
        this.f14616r.setText(getString(R$string.use_family_cloud_space));
    }

    /* renamed from: k2 */
    public final void m20233k2() {
        if (this.f14598C == 0) {
            m20239r2(true);
        } else {
            m20238q2(true);
        }
    }

    /* renamed from: l2 */
    public void m20234l2() {
        Toast.makeText(this, getString(R$string.server_error_retry), 0).show();
    }

    /* renamed from: m2 */
    public final void m20235m2(List<FamilyDetailInfo> list) throws Resources.NotFoundException {
        Resources resources = getResources();
        if (resources != null) {
            int size = list.size();
            this.f14624z.setText(C2783d.m16095M(resources.getQuantityString(R$plurals.family_member, size, Integer.valueOf(size)), Integer.valueOf(size)));
        }
    }

    /* renamed from: n2 */
    public final void m20236n2(QuotaSpaceInfo quotaSpaceInfo) {
        String strM1524g = C0223k.m1524g(this, quotaSpaceInfo.getUsed());
        String strM1524g2 = C0223k.m1524g(this, quotaSpaceInfo.getTotal());
        this.f14603H = strM1524g2;
        this.f14623y.setText(getString(R$string.cloudbackup_backupmedia_tip, strM1524g, strM1524g2));
    }

    /* renamed from: o2 */
    public void m20237o2(Handler handler) {
        if (this.f14611P == null) {
            this.f14611P = new InviteMemberErrorTipDialog(this, new DialogInterfaceOnClickListenerC3253b(handler));
        }
        this.f14611P.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C11839m.m70688i("CloudSpaceShareBaseActivity", "onCreate");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InviteMemberErrorTipDialog inviteMemberErrorTipDialog = this.f14611P;
        if (inviteMemberErrorTipDialog != null) {
            inviteMemberErrorTipDialog.dismiss();
            this.f14611P = null;
        }
    }

    /* renamed from: p2 */
    public void mo20194p2() {
    }

    /* renamed from: q2 */
    public void m20238q2(boolean z10) {
        AutoSizeButton autoSizeButton = this.f14617s;
        if (autoSizeButton == null || this.f14618t == null || this.f14616r == null) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "stopbtn or continueProgress or userbtn is null");
            return;
        }
        if (z10) {
            autoSizeButton.setVisibility(0);
            this.f14616r.setVisibility(8);
            this.f14618t.setVisibility(8);
        } else {
            autoSizeButton.setVisibility(8);
            this.f14616r.setVisibility(8);
            this.f14618t.setVisibility(0);
        }
    }

    /* renamed from: r2 */
    public void m20239r2(boolean z10) {
        AutoSizeButton autoSizeButton = this.f14616r;
        if (autoSizeButton == null || this.f14618t == null || this.f14617s == null) {
            C11839m.m70688i("CloudSpaceShareBaseActivity", "continueBtn or continueProgress or stopbtn is null");
            return;
        }
        if (z10) {
            autoSizeButton.setVisibility(0);
            this.f14617s.setVisibility(8);
            this.f14618t.setVisibility(8);
        } else {
            autoSizeButton.setVisibility(8);
            this.f14618t.setVisibility(0);
            this.f14617s.setVisibility(8);
        }
    }

    /* renamed from: s2 */
    public void m20240s2() {
        Toast.makeText(this, getString(R$string.join_family_not_support_petal), 1).show();
    }

    /* renamed from: t2 */
    public void m20241t2() {
        Toast.makeText(this, getString(R$string.join_family_support_petal_sec), 1).show();
    }

    /* renamed from: u2 */
    public final void m20242u2() {
        C9441b c9441bM60500u = C9681b.m60470l().m60500u(2);
        if (c9441bM60500u == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "shareSpaceDialogDetail is null");
            return;
        }
        String strM59224d = c9441bM60500u.m59224d();
        String strM64293c = C10465b.m64293c(c9441bM60500u.m59223c(), this.f14604I);
        String strM59222b = c9441bM60500u.m59222b();
        C11839m.m70686d("CloudSpaceShareBaseActivity", "showSpaceNotEnough, title: " + strM59224d + " ,content: " + strM64293c + " ,confirmText:" + strM59222b);
        if (m20209M1(strM59224d) || m20209M1(strM64293c) || m20209M1(strM59222b)) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "showSpaceNotEnough,title or content or confirmtext is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(strM59222b, new DialogInterfaceOnClickListenerC3254c());
        AlertDialog alertDialog = this.f14609N;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14609N = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f14609N = alertDialogCreate;
        alertDialogCreate.setMessage(strM64293c);
        this.f14609N.setTitle(strM59224d);
        this.f14609N.show();
    }

    /* renamed from: v2 */
    public void m20243v2(StopShareCallback stopShareCallback) {
        int i10 = this.f14599D;
        int i11 = 1;
        if (i10 == 1) {
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_DISABLE_BUTTON);
        } else if (i10 != 2) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "spaceShareRole error");
            return;
        } else {
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_QUIT_BUTTON);
            i11 = 3;
        }
        C9441b c9441bM60500u = C9681b.m60470l().m60500u(i11);
        if (c9441bM60500u == null) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "shareSpaceDialogDetail is null");
            return;
        }
        String strM59224d = c9441bM60500u.m59224d();
        String strM59223c = c9441bM60500u.m59223c();
        if (this.f14599D == 2) {
            strM59223c = C10465b.m64293c(strM59223c, this.f14604I, this.f14603H);
        }
        String strM59222b = c9441bM60500u.m59222b();
        String strM59221a = c9441bM60500u.m59221a();
        C11839m.m70686d("CloudSpaceShareBaseActivity", "showStopSpaceShare, title: " + strM59224d + " ,content: " + strM59223c + " ,confirmText:" + strM59222b + " ,cancelText:" + strM59221a);
        if (m20209M1(strM59224d) || m20209M1(strM59223c) || m20209M1(strM59222b) || m20209M1(strM59221a)) {
            C11839m.m70687e("CloudSpaceShareBaseActivity", "showStopSpaceShare,title or content or confirmtext or cancelText is null");
            return;
        }
        StopShareDialog stopShareDialog = this.f14610O;
        if (stopShareDialog != null) {
            stopShareDialog.dismiss();
            this.f14610O = null;
        }
        StopShareDialog stopShareDialog2 = new StopShareDialog(this, stopShareCallback, strM59222b, strM59221a);
        this.f14610O = stopShareDialog2;
        stopShareDialog2.showDialog(strM59223c, strM59224d);
    }

    /* renamed from: w2 */
    public final void m20244w2(CharSequence charSequence) {
        C11839m.m70686d("CloudSpaceShareBaseActivity", "show toast, text: " + ((Object) charSequence));
        if (this.f14612Q != null) {
            C11839m.m70686d("CloudSpaceShareBaseActivity", "mToast is not null, text: " + ((Object) charSequence));
            this.f14612Q.cancel();
        }
        Toast toastMakeText = Toast.makeText(this, charSequence, 0);
        this.f14612Q = toastMakeText;
        toastMakeText.show();
    }

    /* renamed from: x2 */
    public void mo20203x2() {
    }

    /* renamed from: y2 */
    public void mo20205y2() {
    }

    /* renamed from: z2 */
    public void m20245z2(Handler handler) {
        if (handler == null) {
            return;
        }
        C12515a.m75110o().m75172d(new C13573x(handler));
    }
}
