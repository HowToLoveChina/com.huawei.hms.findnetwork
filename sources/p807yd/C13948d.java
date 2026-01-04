package p807yd;

import android.os.HandlerThread;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* renamed from: yd.d */
/* loaded from: classes3.dex */
public class C13948d {

    /* renamed from: o */
    public static final C13948d f62545o = new C13948d();

    /* renamed from: a */
    public volatile HandlerThread f62546a;

    /* renamed from: b */
    public GetUserRegisterResp f62547b;

    /* renamed from: c */
    public GetClientUIConfigResp f62548c;

    /* renamed from: d */
    public UserPackage f62549d;

    /* renamed from: e */
    public ArrayList<FilterAvailabalGradePackage> f62550e;

    /* renamed from: f */
    public List<Voucher> f62551f;

    /* renamed from: g */
    public String f62552g;

    /* renamed from: h */
    public String f62553h;

    /* renamed from: i */
    public int f62554i;

    /* renamed from: j */
    public int f62555j;

    /* renamed from: k */
    public String f62556k;

    /* renamed from: l */
    public boolean f62557l = false;

    /* renamed from: m */
    public String f62558m;

    /* renamed from: n */
    public boolean f62559n;

    /* renamed from: f */
    public static C13948d m83788f() {
        return f62545o;
    }

    /* renamed from: a */
    public boolean m83789a() {
        return this.f62559n;
    }

    /* renamed from: b */
    public final void m83790b() {
        if (this.f62546a != null) {
            C11839m.m70688i("DeviceSpaceRecommendHelper", "destroyWorkerThread");
            this.f62546a.quit();
            this.f62546a = null;
        }
    }

    /* renamed from: c */
    public String m83791c() {
        return this.f62556k;
    }

    /* renamed from: d */
    public ArrayList<FilterAvailabalGradePackage> m83792d() {
        return this.f62550e;
    }

    /* renamed from: e */
    public String m83793e() {
        return this.f62553h;
    }

    /* renamed from: g */
    public int m83794g() {
        return this.f62555j;
    }

    /* renamed from: h */
    public String m83795h() {
        return this.f62558m;
    }

    /* renamed from: i */
    public int m83796i() {
        return this.f62554i;
    }

    /* renamed from: j */
    public GetClientUIConfigResp m83797j() {
        return this.f62548c;
    }

    /* renamed from: k */
    public GetUserRegisterResp m83798k() {
        return this.f62547b;
    }

    /* renamed from: l */
    public String m83799l() {
        return this.f62552g;
    }

    /* renamed from: m */
    public UserPackage m83800m() {
        return this.f62549d;
    }

    /* renamed from: n */
    public List<Voucher> m83801n() {
        return this.f62551f;
    }

    /* renamed from: o */
    public void m83802o() {
        C11839m.m70688i("DeviceSpaceRecommendHelper", "release");
        m83790b();
        m83803p();
    }

    /* renamed from: p */
    public final void m83803p() {
        C11839m.m70688i("DeviceSpaceRecommendHelper", "unregisterBroadcastReceiver");
    }
}
