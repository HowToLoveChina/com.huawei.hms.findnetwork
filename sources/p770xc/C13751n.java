package p770xc;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.LocalId;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteContactLocalDataTask;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.support.sms.common.ReadSmsConstant;
import java.util.ArrayList;
import java.util.List;
import je.C10800n;
import p015ak.C0209d;
import p015ak.C0214f0;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p664u0.C13108a;
import p709vj.C13452e;
import tc.C13006a;
import tc.C13007b;
import vc.C13403g;

@CBServiceTask(request = 55000007, response = 66000007)
/* renamed from: xc.n */
/* loaded from: classes3.dex */
public class C13751n extends AbstractC13752o {

    /* renamed from: C */
    public ArrayList<CtagInfoCompatible> f61828C;

    /* renamed from: y */
    public List<LocalId> f61829y = null;

    /* renamed from: z */
    public int f61830z = 0;

    /* renamed from: A */
    public int f61826A = 0;

    /* renamed from: B */
    public String f61827B = null;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    /* renamed from: C */
    public final int m82610C() {
        Context context = this.f53282a;
        if (context == null) {
            C11839m.m70688i("StartSyncTask", "checkCalendar mContext is null.");
            return 0;
        }
        if (C0209d.m1304s0(context, "com.android.providers.calendar") < 100 || !C13007b.m78205Y(this.f53282a).m78286t()) {
            return 0;
        }
        C11839m.m70688i("StartSyncTask", "syncV2 calendar first upgrade need full sync.");
        return DriveSyncUtil.m18004n(this.f53282a, this.f61834s);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("StartSyncTask", "Begin doWork");
        C13403g c13403g = new C13403g(this.f53282a, this.f61834s, this.f61835t, this.f61829y, this.f61826A, this.f61832q, this.f61833r, this.f61836u, this.f61827B, this.f61828C, this.f61838w);
        int iM82610C = 0;
        if (this.f61826A == 1) {
            if ("addressbook".equals(this.f61834s)) {
                DeleteContactLocalDataTask.deleteContactTag();
                if (this.f53282a != null) {
                    if (C11829c.m70611r0()) {
                        SyncObserverServiceInvoker.getInstance().startService(this.f53282a, "com.huawei.android.hicloud.sync.unRegisterContactChangeObserver");
                    } else {
                        C12338d.m74195s().m74247r0();
                    }
                }
            }
            CloudSyncUtil.m15999c1();
            CloudSyncUtil.m16005e1();
            CloudSyncUtil.m16008f1();
            m82613F(this.f53282a, this.f61834s);
            if (CloudSyncUtil.m15955I(this.f53282a, this.f61834s)) {
                int iM18004n = DriveSyncUtil.m18004n(this.f53282a, this.f61834s);
                if ("calendar".equals(this.f61834s) && iM18004n == 0) {
                    C13007b.m78205Y(this.f53282a).m78263h0(false);
                }
                iM82610C = iM18004n;
            } else if ("calendar".equals(this.f61834s)) {
                iM82610C = m82610C();
            }
        }
        c13403g.setConfig(this.f61834s, this.f53297m, this.f61839x);
        int iM82612E = m82612E(iM82610C);
        if (iM82612E == 0) {
            this.f61830z = c13403g.m80563Q();
        } else {
            C11839m.m70687e("StartSyncTask", "deleteTag : syncType = " + this.f61834s + ", errorCode = " + iM82612E);
            c13403g.m80573j(iM82612E);
        }
        return Boolean.FALSE;
    }

    /* renamed from: E */
    public final int m82612E(int i10) {
        C11839m.m70688i("StartSyncTask", "getErrorCode : deleteState = " + i10);
        int i11 = i10 != -3 ? i10 != -2 ? i10 != 0 ? FamilyShareConstants.MessageCode.GO_TO_STORAGE_MANAGE : 0 : ReadSmsConstant.FAIL : 2023;
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70688i("StartSyncTask", "Local ST invalid flag is true");
            i11 = 2001;
        }
        if (!C13452e.m80781L().m80927i1()) {
            return i11;
        }
        C11839m.m70688i("StartSyncTask", "Sync Risk");
        return FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
    }

    /* renamed from: F */
    public final void m82613F(Context context, String str) {
        C2973b.m17813a(context, str);
    }

    /* renamed from: G */
    public final void m82614G() {
        C11839m.m70688i("StartSyncTask", "notifyUISyncStart syncType " + this.f61834s);
        String str = this.f61834s;
        if (str == null) {
            C11839m.m70687e("StartSyncTask", "notifyUISyncStart syncType is null");
            return;
        }
        C2786g.m16220i(str, this.f61831p, this.f61838w);
        if ("notepad".equals(this.f61834s)) {
            C13108a.m78878b(this.f53282a).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        }
        this.f61831p.edit().putInt(this.f61834s + "sync_retcode", 4).commit();
        CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START", this.f61834s);
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        super.mo66489c();
        C11839m.m70688i("StartSyncTask", "beforeWorkStart, syncType = " + this.f61834s + " and dataType = " + this.f61835t);
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61829y = (List) c10800nM68549a.m65737b("localid");
        this.f61826A = ((Integer) c10800nM68549a.m65739d(NotifyConstants.NotificationReport.KEY_ORDER)).intValue();
        this.f61827B = c10800nM68549a.m65740e("data_type_local_ctag_value", "");
        this.f61828C = (ArrayList) c10800nM68549a.m65737b("data_type_local_ctag_info");
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f53282a);
        this.f61831p = C0214f0.m1382b(this.f53282a, "sync_contact_spfile", 0);
        if (this.f61826A == 1) {
            c13007bM78205Y.m78270l(this.f61834s, this.f61836u);
            c13007bM78205Y.m78280q(this.f61835t);
            c13007bM78205Y.m78272m(this.f61834s);
            m82614G();
            this.f61831p.edit().remove(this.f61834s + "notAllSucess").commit();
            this.f61831p.edit().remove(this.f61834s + "reportFileNotAllSucess").commit();
            C2973b.m17821i(this.f53282a, this.f61834s);
            CloudSyncUtil.m16002d1(this.f53282a, this.f61834s);
            CloudSyncUtil.m15999c1();
            CloudSyncUtil.m16005e1();
            CloudSyncUtil.m16008f1();
            C13006a.m78193e().m78195b();
        }
    }
}
