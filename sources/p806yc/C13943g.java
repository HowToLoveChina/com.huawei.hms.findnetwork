package p806yc;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.LocalId;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.support.sms.common.ReadSmsConstant;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import je.C10800n;
import p015ak.C0214f0;
import p514o9.C11839m;
import p675uc.C13153a;
import p709vj.C13452e;
import p770xc.AbstractC13752o;
import tc.C13006a;
import tc.C13007b;

@CBServiceTask(request = 55000026, response = 66000026)
/* renamed from: yc.g */
/* loaded from: classes3.dex */
public class C13943g extends AbstractC13752o {

    /* renamed from: C */
    public SharedPreferences f62519C;

    /* renamed from: E */
    public ArrayList<CtagInfoCompatible> f62521E;

    /* renamed from: y */
    public String f62522y = null;

    /* renamed from: z */
    public List<LocalId> f62523z = null;

    /* renamed from: A */
    public int f62517A = 0;

    /* renamed from: B */
    public int f62518B = 0;

    /* renamed from: D */
    public String f62520D = null;

    /* renamed from: E */
    private int m83719E(int i10) {
        C11839m.m70688i("GenStartSyncTask", "getErrorCode : deleteState = " + i10);
        int i11 = i10 != -3 ? i10 != -2 ? i10 != 0 ? FamilyShareConstants.MessageCode.GO_TO_STORAGE_MANAGE : 0 : ReadSmsConstant.FAIL : 2023;
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70688i("GenStartSyncTask", "Local ST invalid flag is true");
            i11 = 2001;
        }
        if (!C13452e.m80781L().m80927i1()) {
            return i11;
        }
        C11839m.m70688i("GenStartSyncTask", "Sync Risk");
        return FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
    }

    /* renamed from: F */
    private void m83720F(Context context, String str) {
        C2973b.m17813a(context, str);
    }

    /* renamed from: G */
    private void m83721G() {
        String str = this.f61834s;
        if (str == null) {
            C11839m.m70687e("GenStartSyncTask", "notifyUISyncStart syncType is null");
            return;
        }
        C2786g.m16220i(str, this.f62519C, this.f61838w);
        this.f62519C.edit().putInt(this.f61834s + "sync_retcode", 4).commit();
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START", this.f61834s);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    /* renamed from: C */
    public final int m83723C() throws Throwable {
        int iM79133s;
        C11839m.m70688i("GenStartSyncTask", "clear tag");
        try {
            iM79133s = C13153a.m79133s(this.f61834s, this.f53282a);
        } catch (SQLException unused) {
            C11839m.m70687e("GenStartSyncTask", "deleteTag SQLException");
            iM79133s = -2;
        } catch (Exception e10) {
            C11839m.m70687e("GenStartSyncTask", "deleteTag Exception = " + e10.toString());
            iM79133s = -1;
        }
        C13153a.m79132r(this.f53282a, this.f61834s, 2, "local_on_data_sync_clear");
        return iM79133s;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean mo66490d() throws java.lang.Exception {
        /*
            r14 = this;
            java.lang.String r0 = "Begin doWork"
            java.lang.String r1 = "GenStartSyncTask"
            p514o9.C11839m.m70688i(r1, r0)
            wc.f r0 = new wc.f
            android.content.Context r3 = r14.f53282a
            java.lang.String r4 = r14.f61834s
            java.lang.String r5 = r14.f61835t
            java.util.List<com.huawei.android.hicloud.sync.service.aidl.LocalId> r6 = r14.f62523z
            int r7 = r14.f62518B
            java.lang.String r8 = r14.f61832q
            java.lang.String r9 = r14.f61833r
            java.lang.String r10 = r14.f61836u
            java.lang.String r11 = r14.f62520D
            java.util.ArrayList<com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible> r12 = r14.f62521E
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r13 = r14.f61838w
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.String r2 = r14.f62522y
            r0.m81626n(r2)
            int r2 = r14.f62518B
            r3 = 1
            if (r2 != r3) goto L46
            com.huawei.android.hicloud.complexutil.CloudSyncUtil.m15999c1()
            android.content.Context r2 = r14.f53282a
            java.lang.String r3 = r14.f61834s
            r14.m83720F(r2, r3)
            android.content.Context r2 = r14.f53282a
            java.lang.String r3 = r14.f61834s
            boolean r2 = com.huawei.android.hicloud.complexutil.CloudSyncUtil.m15955I(r2, r3)
            if (r2 == 0) goto L46
            int r2 = r14.m83723C()
            goto L47
        L46:
            r2 = 0
        L47:
            java.lang.String r3 = r14.f61834s
            md.b<Result>$a r4 = r14.f53297m
            com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo r5 = r14.f61839x
            r0.setConfig(r3, r4, r5)
            int r2 = r14.m83719E(r2)
            if (r2 != 0) goto L5d
            int r0 = r0.m81627o()
            r14.f62517A = r0
            goto L7e
        L5d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "deleteTag : syncType = "
            r3.append(r4)
            java.lang.String r14 = r14.f61834s
            r3.append(r14)
            java.lang.String r14 = ", errorCode = "
            r3.append(r14)
            r3.append(r2)
            java.lang.String r14 = r3.toString()
            p514o9.C11839m.m70687e(r1, r14)
            r0.m81623d(r2)
        L7e:
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p806yc.C13943g.mo66490d():java.lang.Boolean");
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        super.mo66489c();
        C11839m.m70688i("GenStartSyncTask", "beforeWorkStart, syncType = " + this.f61834s + " and dataType = " + this.f61835t);
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f62523z = (List) c10800nM68549a.m65737b("localid");
        this.f62518B = ((Integer) c10800nM68549a.m65739d(NotifyConstants.NotificationReport.KEY_ORDER)).intValue();
        Object objM65739d = c10800nM68549a.m65739d("sync_mode_info");
        if (objM65739d instanceof String) {
            this.f62522y = (String) objM65739d;
        }
        this.f62520D = c10800nM68549a.m65740e("data_type_local_ctag_value", "");
        this.f62521E = (ArrayList) c10800nM68549a.m65737b("data_type_local_ctag_info");
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f53282a);
        this.f62519C = C0214f0.m1382b(this.f53282a, "sync_contact_spfile", 0);
        if (this.f62518B == 1) {
            c13007bM78205Y.m78270l(this.f61834s, this.f61836u);
            c13007bM78205Y.m78280q(this.f61835t);
            c13007bM78205Y.m78272m(this.f61834s);
            m83721G();
            this.f62519C.edit().remove(this.f61834s + "notAllSucess").commit();
            this.f62519C.edit().remove(this.f61834s + "reportFileNotAllSucess").commit();
            C2973b.m17821i(this.f53282a, this.f61834s);
            CloudSyncUtil.m16002d1(this.f53282a, this.f61834s);
            CloudSyncUtil.m15999c1();
            CloudSyncUtil.m16005e1();
            CloudSyncUtil.m16008f1();
            C13006a.m78193e().m78195b();
        }
    }
}
