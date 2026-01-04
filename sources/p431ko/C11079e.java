package p431ko;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.request.basic.bean.UserGradeInfo;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0226l0;
import p015ak.C0241z;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p836z8.C14157f;

/* renamed from: ko.e */
/* loaded from: classes6.dex */
public class C11079e extends AbstractC12367d {

    /* renamed from: a */
    public ArrayList<String> f52277a;

    /* renamed from: b */
    public final a f52278b;

    /* renamed from: c */
    public boolean f52279c;

    /* renamed from: d */
    public boolean f52280d;

    /* renamed from: e */
    public final String f52281e;

    /* renamed from: f */
    public boolean f52282f;

    /* renamed from: ko.e$a */
    public interface a {
        /* renamed from: a */
        void mo14511a(UserDataStateInfo userDataStateInfo);
    }

    public C11079e(a aVar, boolean z10, ArrayList<String> arrayList, String str) {
        new ArrayList();
        this.f52279c = false;
        this.f52282f = false;
        this.f52278b = aVar;
        this.f52277a = arrayList;
        this.f52280d = z10;
        this.f52281e = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("QueryUserDataStateTask", "cmd " + this.f52281e);
        List<C4987f> listM84949i = this.f52282f ? C14157f.m84942g().m84949i(this.f52277a, null, this.f52281e) : C14157f.m84942g().m84949i(null, this.f52277a, this.f52281e);
        final UserDataStateInfo userDataStateInfo = new UserDataStateInfo();
        if (listM84949i == null || listM84949i.isEmpty()) {
            C11839m.m70689w("QueryUserDataStateTask", "getParams fail");
        } else {
            for (C4987f c4987f : listM84949i) {
                try {
                    if (TextUtils.equals(c4987f.m30026b(), "bs.bm.type")) {
                        userDataStateInfo.setBmType(Integer.parseInt(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.grade")) {
                        userDataStateInfo.setBsGrade(c4987f.m30027c());
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.bm.grade.state")) {
                        userDataStateInfo.setBmGradeState(Integer.parseInt(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.userdata.expired.time")) {
                        userDataStateInfo.setUserdataExpiredTime(Long.parseLong(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.userdata.overdue.days")) {
                        userDataStateInfo.setDataRetentionDays(Integer.parseInt(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), NotifyConstants.MashupKey.BS_REMAIN_DAYS)) {
                        userDataStateInfo.setUserdataRemainDays(Integer.parseInt(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.bm.usergrade.info")) {
                        m66731e(userDataStateInfo, c4987f.m30027c());
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.bm.data.state")) {
                        userDataStateInfo.setDataPeriod(C0241z.m1685c(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), NotifyConstants.MashupKey.BS_USERDATA_REMAIN_DWNLD1DAYS)) {
                        userDataStateInfo.setDwnldPeriod1Days(C0241z.m1685c(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.userdata.remain.dwnldDays")) {
                        userDataStateInfo.setRemainDwnldDays(C0241z.m1685c(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.userdata.remain.regretDays")) {
                        userDataStateInfo.setRemainRegretDays(C0241z.m1685c(c4987f.m30027c()));
                    } else if (TextUtils.equals(c4987f.m30026b(), "bs.dsu.cloud.usage")) {
                        userDataStateInfo.setBsDsuCloudUsage(C0241z.m1685c(c4987f.m30027c()));
                    }
                } catch (NumberFormatException unused) {
                    C11839m.m70689w("QueryUserDataStateTask", c4987f.m30026b() + "--" + c4987f.m30027c());
                }
            }
        }
        if (this.f52280d) {
            C0226l0.m1584d(new Runnable() { // from class: ko.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f52275a.m66730d(userDataStateInfo);
                }
            });
        } else {
            this.f52278b.mo14511a(userDataStateInfo);
        }
        C11839m.m70686d("QueryUserDataStateTask", userDataStateInfo.toString());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        this.f52279c = true;
        return super.cancel();
    }

    /* renamed from: d */
    public final /* synthetic */ void m66730d(UserDataStateInfo userDataStateInfo) {
        this.f52278b.mo14511a(userDataStateInfo);
    }

    /* renamed from: e */
    public final void m66731e(UserDataStateInfo userDataStateInfo, String str) {
        UserGradeInfo userGradeInfo;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("QueryUserDataStateTask", "userGradeInfoStr is empty");
            return;
        }
        try {
            userGradeInfo = (UserGradeInfo) new Gson().fromJson(str, UserGradeInfo.class);
        } catch (Exception unused) {
            C11839m.m70689w("QueryUserDataStateTask", "userGradeInfoStr is invalid");
            userGradeInfo = null;
        }
        if (userGradeInfo == null) {
            C11839m.m70689w("QueryUserDataStateTask", "userGradeInfo is null");
            return;
        }
        userDataStateInfo.setBsGrade(userGradeInfo.getGradeCode());
        userDataStateInfo.setBmGradeState(userGradeInfo.getGradeState());
        userDataStateInfo.setDataPeriod(userGradeInfo.getDataPeriod());
        userDataStateInfo.setRemainRegretDays(userGradeInfo.getRemainRegretDays());
        userDataStateInfo.setRemainDwnldDays(userGradeInfo.getRemainDwnldDays());
        userDataStateInfo.setDwnldPeriodDays(userGradeInfo.getDwnldPeriodDays());
        userDataStateInfo.setDwnldPeriod1Days(userGradeInfo.getDwnldPeriod1Days());
        userDataStateInfo.setDwnldPeriod2Days(userGradeInfo.getDwnldPeriod2Days());
    }

    public C11079e(a aVar, boolean z10, ArrayList<String> arrayList, boolean z11, String str) {
        new ArrayList();
        this.f52279c = false;
        this.f52278b = aVar;
        this.f52277a = arrayList;
        this.f52280d = z10;
        this.f52282f = z11;
        this.f52281e = str;
    }
}
