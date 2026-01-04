package p341hj;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.base.bean.LastMemberInfo;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import p015ak.C0213f;
import p020ap.C1007b;
import p054cj.C1442a;
import p399jk.AbstractC10896a;
import p429kk.C11060c;
import p454lj.C11282e;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11839m;
import p618rm.C12540b1;
import p664u0.C13108a;
import p709vj.C13452e;
import p778xk.C13823d;
import p836z8.C14157f;

/* renamed from: hj.n0 */
/* loaded from: classes5.dex */
public class C10250n0 extends AbstractC10222e {

    /* renamed from: b */
    public final Handler f49661b;

    /* renamed from: c */
    public final C11060c f49662c;

    /* renamed from: d */
    public int f49663d;

    /* renamed from: e */
    public final boolean f49664e;

    /* renamed from: f */
    public boolean f49665f;

    /* renamed from: g */
    public String f49666g;

    public C10250n0(Handler handler, C11060c c11060c, boolean z10, String str) {
        this.f49661b = handler;
        this.f49662c = c11060c;
        this.f49664e = z10;
        this.f49666g = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0100  */
    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo16407a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p341hj.C10250n0.mo16407a():void");
    }

    /* renamed from: i */
    public final void m63405i(UserPackage userPackage) throws Throwable {
        m63410n(userPackage);
        C14157f.m84942g().m84958u("bs.dsu.cloud.total");
        m63412p(userPackage);
        m63413q(userPackage);
        m63411o(userPackage);
        m63409m(userPackage);
        this.f49662c.m66665u(String.valueOf(0));
        this.f49662c.m66635A("success");
        int i10 = this.f49663d;
        if (i10 == 2) {
            m63380f(this.f49661b, 2131, userPackage);
        } else if (i10 == 3) {
            m63380f(this.f49661b, 7038, userPackage);
        } else {
            m63380f(this.f49661b, 2001, userPackage);
        }
    }

    /* renamed from: j */
    public final /* synthetic */ void m63406j(String str, String str2) throws Throwable {
        if (str2.equals(str)) {
            return;
        }
        m63407k(str2);
        C11839m.m70688i("GetUserPackageTask", "onProcessGradeCode notifyParamsValueExpires ");
        C14157f.m84942g().m84958u("bs.grade");
        C14157f.m84942g().m84958u("bs.bm.type");
        C13823d.m82903c();
    }

    /* renamed from: k */
    public final void m63407k(String str) {
        Intent intent = new Intent("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_CHANGE");
        intent.putExtra("gradeCode", str);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: l */
    public final void m63408l(UserPackage userPackage) {
        UserPackage userPackage2;
        String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_user_package_cache_key");
        if (TextUtils.isEmpty(strM67711c)) {
            userPackage2 = null;
        } else {
            try {
                userPackage2 = (UserPackage) new Gson().fromJson(strM67711c, UserPackage.class);
            } catch (Exception unused) {
                C1442a.m8289e("GetUserPackageTask", "onProcessGradeCode parse fail ");
            }
        }
        final String str = (String) Optional.ofNullable(userPackage2).map(new Function() { // from class: hj.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((UserPackage) obj).getGradeRights();
            }
        }).map(new Function() { // from class: hj.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MemGradeRights) obj).getGradeCode();
            }
        }).orElse(null);
        Optional.ofNullable((String) Optional.of(userPackage).map(new Function() { // from class: hj.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((UserPackage) obj).getGradeRights();
            }
        }).map(new Function() { // from class: hj.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MemGradeRights) obj).getGradeCode();
            }
        }).orElse(null)).ifPresent(new Consumer() { // from class: hj.m0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f49655a.m63406j(str, (String) obj);
            }
        });
    }

    /* renamed from: m */
    public final void m63409m(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8291w("GetUserPackageTask", "refreshDataPeriod, cloud space is null");
            return;
        }
        int dataPeriod = userPackage.getDataPeriod();
        AbstractC10896a.m65887i("GetUserPackageTask", "refreshDataPeriod Cache, dataPeriod is: " + dataPeriod);
        C13452e.m80781L().m80839O1(dataPeriod);
    }

    /* renamed from: n */
    public final void m63410n(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8291w("GetUserPackageTask", "refreshGradeCodeCache, cloud space is null");
            return;
        }
        MemGradeRights gradeRights = userPackage.getGradeRights();
        if (gradeRights == null) {
            C1442a.m8291w("GetUserPackageTask", "refreshGradeCodeCache, rights is null");
            return;
        }
        String gradeCode = gradeRights.getGradeCode();
        if (TextUtils.isEmpty(gradeCode)) {
            C1442a.m8291w("GetUserPackageTask", "refreshGradeCodeCache, gradeCode is empty");
            return;
        }
        C13452e.m80781L().m80940l1(gradeCode);
        C13452e.m80781L().m80898c2(gradeRights.getGradeType());
        C13452e.m80781L().m80816I1(userPackage.isPackagesAutoPay());
        C13452e.m80781L().m80817I2(userPackage.getServerTime());
        long memberRemainDays = userPackage.getMemberRemainDays();
        long memberCountDownsVisible = userPackage.getMemberCountDownsVisible();
        if (memberRemainDays < 0 || memberCountDownsVisible < 0 || memberRemainDays > memberCountDownsVisible) {
            C13452e.m80781L().m80961q2(-1L);
        } else {
            C13452e.m80781L().m80961q2(memberRemainDays);
        }
        boolean z10 = userPackage.getBmType() == 1;
        if (z10 != C13452e.m80781L().m80887a1()) {
            C11839m.m70688i("GetUserPackageTask", "business mode from package is different from sp.");
            C13452e.m80781L().m80985w2(z10);
        }
        C1007b.m5980s().m5982B(gradeCode, true);
    }

    /* renamed from: o */
    public final void m63411o(UserPackage userPackage) {
        C13452e.m80781L().m80908e2(C11293p.m67771o(userPackage));
        C13452e.m80781L().m80797D2(C11293p.m67769m(userPackage));
    }

    /* renamed from: p */
    public final void m63412p(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8291w("GetUserPackageTask", "refreshMemGradeRightListCache, cloud space is null");
        } else {
            C11296s.m67808c0(userPackage.getGradeRights());
        }
    }

    /* renamed from: q */
    public final void m63413q(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8291w("GetUserPackageTask", "refreshGradeCodeCache, cloud space is null");
            return;
        }
        C13452e.m80781L().m80893b2(userPackage.getGradeState());
        C1442a.m8290i("GetUserPackageTask", "cloudSpace.getGradeState() " + userPackage.getGradeState());
        LastMemberInfo lastMemberInfo = userPackage.getLastMemberInfo();
        if (lastMemberInfo != null) {
            C13452e.m80781L().m80941l2(C12540b1.m75485c(lastMemberInfo));
        } else {
            C13452e.m80781L().m80941l2("");
        }
    }

    public C10250n0(Handler handler, C11060c c11060c, boolean z10, boolean z11, String str) {
        this.f49661b = handler;
        this.f49662c = c11060c;
        this.f49664e = z10;
        this.f49665f = z11;
        this.f49666g = str;
    }

    public C10250n0(Handler handler, int i10, C11060c c11060c, boolean z10, boolean z11, String str) {
        this(handler, c11060c, z10, str);
        this.f49663d = i10;
        this.f49665f = z11;
    }
}
