package p800y6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.android.hicloud.album.service.C2414a;
import com.huawei.android.hicloud.album.service.logic.callable.ReportAlbumTask;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.album.service.report.LocalDataReport;
import com.huawei.android.p069cg.activity.AlbumManageActivity;
import com.huawei.android.p069cg.activity.GalleryMainActivity;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.notification.GalleryShelveNotification;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.router.data.AppInfo;
import com.huawei.hicloud.router.data.ShareAlbumInfo;
import com.huawei.hicloud.router.data.SwitchInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import p009a8.C0064b;
import p009a8.C0074l;
import p015ak.C0213f;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p031b7.C1137r;
import p232dp.InterfaceC9282a;
import p251e8.C9423b;
import p281f8.C9665b;
import p281f8.C9672i;
import p431ko.C11079e;
import p489n9.C11654a;
import p511o6.C11820b;
import p512o7.C11824a;
import p546p6.C12091d;
import p569q7.C12290a;
import p572qb.C12331w;
import p604r7.C12470c;
import p604r7.C12473f;
import p616rk.C12515a;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;
import p850zo.InterfaceC14352c;
import p850zo.InterfaceC14353d;

/* renamed from: y6.b */
/* loaded from: classes2.dex */
public class C13912b implements InterfaceC9282a {

    /* renamed from: a */
    public SwitchInfo f62270a;

    /* renamed from: k1 */
    public static /* synthetic */ void m83346k1(UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null || userDataStateInfo.getBmType() == -1) {
            return;
        }
        if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
            C1120a.m6677i("CloudAlbumRouterImpl", "bs grade:" + userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
        }
        if (userDataStateInfo.getBmType() == 1) {
            C13452e.m80781L().m80985w2(true);
            C1120a.m6677i("CloudAlbumRouterImpl", "new bm type:true");
        } else if (userDataStateInfo.getBmType() == 0) {
            C1120a.m6677i("CloudAlbumRouterImpl", "new bm type:false");
            C13452e.m80781L().m80985w2(false);
        }
        C1120a.m6677i("CloudAlbumRouterImpl", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
        C1136q.m6954L(userDataStateInfo.getBmGradeState());
        C1136q.m6953K(userDataStateInfo.getDataPeriod());
        C1136q.m6955M(System.currentTimeMillis());
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: A */
    public void mo58356A(Context context, String str) {
        CloudAlbumManager.m14456v().m14471Q(context, str);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: A0 */
    public boolean mo58357A0() {
        return SyncSessionManager.m15153t().m15156C() || C0074l.m603c().m607e();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: B */
    public boolean mo58358B(Context context) {
        return C1136q.e.m7169g(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: B0 */
    public void mo58359B0(Context context, boolean z10, InterfaceC14353d interfaceC14353d) {
        C0064b.m422c().m431j(context, z10, interfaceC14353d);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: C */
    public void mo58360C(Context context, int i10, int i11) {
        C9423b.m59095b(context, i10, i11);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: C0 */
    public void mo58361C0(Object obj) {
        C2414a.m15051l().m15062r(obj);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: D */
    public void mo58362D() {
        C9665b.m60346c();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: D0 */
    public int mo58363D0(Context context) {
        return C1136q.e.m7165c(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: E */
    public boolean mo58364E(Context context) {
        return CloudAlbumManager.m14456v().m14463G(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: E0 */
    public void mo58365E0(Context context, Map<String, Boolean> map) {
        SwitchInfo switchInfoM14504w = CloudAlbumManager.m14456v().m14504w(context);
        this.f62270a = switchInfoM14504w;
        map.put("GeneralAblum", Boolean.valueOf(switchInfoM14504w.isGeneralAlbumOn()));
        map.put("ShareAlbum", Boolean.valueOf(this.f62270a.isGeneralAlbumOn()));
        map.put("SmartAlbum", Boolean.valueOf(this.f62270a.isSmartAlbumOn()));
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: F */
    public void mo58366F(Context context, String str) {
        CloudAlbumManager.m14456v().m14472R(context, str);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: F0 */
    public void mo58367F0(Activity activity, Bundle bundle, int i10) {
        Intent intent = new Intent(activity, (Class<?>) GalleryMainActivity.class);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        C13230i.m79525e1(intent, "1", "2");
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: G */
    public boolean mo58368G() {
        return CloudAlbumSettings.m14363h().m14376l();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: G0 */
    public void mo58369G0(Context context, String str) {
        CloudAlbumManager.m14456v().m14468M(context, str);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: H */
    public int mo58370H() {
        return C1136q.m6977r();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: H0 */
    public void mo58371H0(String str) {
        C1136q.d.m7132I(str);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: I */
    public int mo58372I(Context context) {
        return C1136q.b.m7005I(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: I0 */
    public boolean mo58373I0() {
        return C1137r.m7180a();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: J */
    public void mo58374J(Object obj, Handler handler) {
        C2414a.m15051l().m15059o(obj, handler);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: J0 */
    public void mo58375J0(Context context) {
        CloudAlbumManager.m14456v().m14503u(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: K */
    public boolean mo58376K(Context context, long j10) {
        return C1122c.m6807m1(context) && j10 > C1136q.b.m7089q(context, "userCapacityTotal");
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: K0 */
    public int mo58377K0(Context context) {
        return C1136q.b.m7021Q(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: L */
    public boolean mo58378L(Context context) {
        return C1136q.b.m7051d0(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: L0 */
    public void mo58379L0(InterfaceC14351b interfaceC14351b, Context context) {
        C0064b.m422c().m430i(interfaceC14351b, context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: M */
    public void mo58380M() {
        C12515a.m75110o().m75175e(new ReportAlbumTask(), true);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: M0 */
    public ArrayList<AppInfo> mo58381M0(Context context) {
        return CloudAlbumManager.m14456v().m14501s(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: N */
    public void mo58382N(Context context, boolean z10) {
        C0064b.m422c().m425d(context, z10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: N0 */
    public boolean mo58383N0() {
        return C12473f.m74865c().m74867d();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: O */
    public boolean mo58384O(Context context) {
        return C1136q.e.m7167e(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: O0 */
    public boolean mo58385O0() {
        return CloudAlbumSettings.m14363h().m14380p();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: P */
    public void mo58386P(Activity activity, int i10, boolean z10) {
        C1120a.m6677i("CloudAlbumRouterImpl", "startGalleryMainActivityForResult requestCode: " + i10 + ", isRelease: " + z10);
        Intent intent = new Intent(activity, (Class<?>) GalleryMainActivity.class);
        if (i10 == 10053) {
            intent.putExtra("gallery_start_to_open_cloud_album", true);
            intent.putExtra("file_to_release_space", z10);
            intent.putExtra("start_to_open_cloud_album_source", 2);
        }
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        C13230i.m79525e1(intent, "1", "2");
        activity.startActivityForResult(intent, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: P0 */
    public void mo58387P0(Context context, int i10, int i11, int i12, int i13) {
        CloudAlbumManager.m14456v().m14481b0(context, i10, i11, i12, i13);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: Q */
    public void mo58388Q(Context context) throws SQLException {
        CloudAlbumManager.m14454e(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: Q0 */
    public void mo58389Q0() {
        CloudAlbumManager.m14456v().m14473S();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: R */
    public boolean mo58390R(Context context) {
        return C1136q.a.m6988c(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: R0 */
    public void mo58391R0() {
        C1120a.m6677i("CloudAlbumRouterImpl", "cleanUserDataCache");
        C1136q.m6955M(0L);
        C1136q.b.m7075l0(C0213f.m1377a(), "");
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: S */
    public boolean mo58392S(Context context) {
        return C1122c.m6687C1(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: S0 */
    public void mo58393S0(Context context) {
        Intent intent = new Intent(context, (Class<?>) GalleryMainActivity.class);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        C13230i.m79525e1(intent, "1", "2");
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: T */
    public int mo58394T(Context context) {
        return C1136q.b.m7029U(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: T0 */
    public void mo58395T0(String str, ImageView imageView) {
        C12091d.m72280a0().m72398y(str, imageView);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: U */
    public void mo58396U(Context context, Bundle bundle, int i10) throws SQLException {
        CloudAlbumManager.m14456v().m14470O(context, bundle, i10);
        if (bundle == null || !bundle.containsKey("GeneralAblum")) {
            return;
        }
        C1122c.m6764b2(i10, bundle.getBoolean("GeneralAblum", false));
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: U0 */
    public void mo58397U0(Handler handler) {
        C12091d.m72280a0().m72346c0(handler);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: V */
    public boolean mo58398V() {
        return CloudAlbumSettings.m14363h().m14385u();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: V0 */
    public void mo58399V0(long j10) {
        C1136q.m6955M(j10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: W */
    public void mo58400W(Context context, InterfaceC14351b interfaceC14351b) {
        CloudAlbumManager.m14456v().m14493j(context, interfaceC14351b);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: W0 */
    public void mo58401W0(Context context, boolean z10) {
        C1120a.m6677i("CloudAlbumRouterImpl", "startGalleryMainActivity ");
        Intent intent = new Intent(context, (Class<?>) GalleryMainActivity.class);
        intent.putExtra("gallery_start_to_open_cloud_album", z10);
        C13230i.m79525e1(intent, "1", "2");
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: X */
    public void mo58402X(boolean z10, Context context) {
        C1122c.m6792i2(z10, context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: X0 */
    public void mo58403X0(InterfaceC14351b interfaceC14351b) {
        C0064b.m422c().m424b(interfaceC14351b);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: Y */
    public boolean mo58404Y(Context context) {
        return CloudAlbumManager.m14456v().m14469N(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: Y0 */
    public long mo58405Y0(Context context) {
        return C1136q.b.m7009K(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: Z */
    public void mo58406Z(Context context) {
        C12515a.m75110o().m75172d(new LocalDataReport.LocalDataDailyTask(context));
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: Z0 */
    public void mo58407Z0(Context context, int i10) throws SQLException {
        CloudAlbumManager.m14455q(context, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: a */
    public long mo58408a(Context context) throws Throwable {
        if (context == null) {
            return 0L;
        }
        try {
            Bundle bundleM6789i = C1122c.m6789i(context, Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI), NotifyConstants.CloudAlbumReleaseSpace.METHOD_GET_FILE_SIZE, null, null);
            if (bundleM6789i != null) {
                return bundleM6789i.getLong(NotifyConstants.CloudAlbumReleaseSpace.KEY_CLEAN_FILE_SIZE, -1L);
            }
            return 0L;
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumRouterImpl", "getReleaseSpace exception: " + e10.getMessage());
            return 0L;
        }
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: a0 */
    public int mo58409a0() {
        return C1136q.m6976q();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: a1 */
    public void mo58410a1(int i10, int i11) {
        C1136q.m6954L(i10);
        C1136q.m6953K(i11);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: b */
    public void mo58411b(Context context, ResultReceiver resultReceiver, boolean z10, boolean z11, int i10, boolean z12, boolean z13, String str) {
        Intent intent = new Intent(context, (Class<?>) GalleryMainActivity.class);
        intent.putExtra("gallery_finisher", resultReceiver);
        if (z11) {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        } else {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 0);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("sceneCode", str);
        }
        intent.putExtra("start_to_open_cloud_album_source", i10);
        intent.putExtra("gallery_start_to_open_cloud_album", z12);
        intent.putExtra("gallery_start_to_close_cloud_album", z13);
        intent.putExtra("need_root_alert", z10);
        C13230i.m79525e1(intent, "1", "3");
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: b0 */
    public Bitmap mo58412b0(Bitmap bitmap, int i10) {
        return C1122c.m6719N0(bitmap, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: b1 */
    public boolean mo58413b1() {
        return C12470c.m74770d().m74781l();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: c */
    public void mo58414c(Context context, int i10) throws SQLException {
        CloudAlbumManager.m14448P(context, i10);
    }

    @Override // p232dp.InterfaceC9282a
    @Deprecated
    /* renamed from: c0 */
    public void mo58415c0(Context context, boolean z10) {
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: c1 */
    public void mo58416c1() {
        C12470c.m74770d().m74771a();
        C11824a.m70444a();
        C12473f.m74865c().m74866b(2);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: d */
    public boolean mo58417d(Context context) {
        return C1122c.m6807m1(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: d0 */
    public void mo58418d0() {
        C11654a.m69600a(CloudAlbumManager.m14456v());
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: d1 */
    public long mo58419d1(Context context) {
        return C1136q.b.m7007J(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: e */
    public void mo58420e(boolean z10, Context context) {
        C1136q.e.m7175m(z10, context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: e0 */
    public void mo58421e0(Context context) {
        CloudAlbumManager.m14456v().m14497n(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: e1 */
    public boolean mo58422e1() {
        return C1136q.m6978s();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: f */
    public long mo58423f(Context context) {
        return C1136q.b.m7025S(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: f0 */
    public void mo58424f0(Context context, long j10) {
        C1136q.b.m7061g1(context, j10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: f1 */
    public void mo58425f1(Handler handler, ShareAlbumInfo shareAlbumInfo) {
        C12091d.m72280a0().m72362k0(handler, shareAlbumInfo);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: g */
    public void mo58426g(InterfaceC14350a interfaceC14350a) {
        C0064b.m422c().m427f(interfaceC14350a);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: g0 */
    public void mo58427g0(Context context, int i10) {
        Intent intent = new Intent(context, (Class<?>) AlbumManageActivity.class);
        intent.putExtra("show_tab_id", i10);
        if (i10 == 2) {
            intent.putExtra("from_cloud_main_page", true);
        }
        C0224k0.m1542L(context, intent);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: g1 */
    public void mo58428g1(Context context, InterfaceC14351b interfaceC14351b) throws ExecutionException, InterruptedException, TimeoutException {
        CloudAlbumManager.m14456v().m14461E(context, interfaceC14351b);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: h */
    public void mo58429h(Context context, int i10) {
        Intent intent = new Intent(context, (Class<?>) AlbumManageActivity.class);
        intent.putExtra("show_tab_id", i10);
        C0224k0.m1542L(context, intent);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: h0 */
    public Bundle mo58430h0(Context context) {
        return CloudAlbumManager.m14456v().m14505x(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: h1 */
    public int mo58431h1(Context context) {
        return C1122c.m6680A0(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: i */
    public void mo58432i(Context context, InterfaceC14351b interfaceC14351b) {
        CloudAlbumManager.m14456v().m14502t(context, interfaceC14351b);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: i0 */
    public void mo58433i0(Context context) {
        CloudAlbumManager.m14456v().m14488g0(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: i1 */
    public void mo58434i1() {
        C1120a.m6677i("CloudAlbumRouterImpl", "notifyGalleryUpgradeSpace");
        C13368e.m80184F().m80253r0();
        C13368e.m80184F().m80250o0();
        C12515a.m75110o().m75172d(new C12331w(false, false, 31));
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: y6.a
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                C13912b.m83346k1(userDataStateInfo);
            }
        }, false, arrayList, "SpaceUpgrade"), false);
    }

    @Override // p232dp.InterfaceC9282a
    public boolean isGallerySupportSetting() {
        return C1122c.m6803l1();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: j */
    public void mo58435j(InterfaceC14351b interfaceC14351b) {
        CloudAlbumSettings.m14363h().m14364A(interfaceC14351b);
    }

    @Override // p232dp.InterfaceC9282a
    @Deprecated
    /* renamed from: j0 */
    public void mo58436j0(Context context) {
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: k */
    public void mo58437k(boolean z10, Context context) {
        C1136q.e.m7177o(z10, context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: k0 */
    public void mo58438k0(Context context, InterfaceC14351b interfaceC14351b) {
        CloudAlbumManager.m14456v().m14506y(context, interfaceC14351b);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: l */
    public void mo58439l(Context context, int i10, long j10) {
        C1136q.b.m7097s1(context, i10, j10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: l0 */
    public void mo58440l0(String str, ImageView imageView) {
        C12091d.m72280a0().m72296B(str, imageView);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: m */
    public boolean mo58441m() {
        return true;
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: m0 */
    public boolean mo58442m0() {
        return Version.isSupportMobileData() && CloudAlbumSettings.m14363h().m14380p();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: n */
    public void mo58443n(Context context, boolean z10) {
        C1136q.b.m7058f1(context, z10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: n0 */
    public void mo58444n0(Context context) {
        CloudAlbumManager.m14456v().m14496m(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: o */
    public long mo58445o(String str) {
        return C1122c.m6698G0(str);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: o0 */
    public void mo58446o0(Handler handler) {
        C12091d.m72280a0().m72390u0(handler);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: p */
    public Class mo58447p() {
        return GalleryMainActivity.class;
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: p0 */
    public void mo58448p0(Context context, Bundle bundle) {
        C1120a.m6677i("CloudAlbumRouterImpl", "success notifyLoginSuccess ");
        CloudAlbumManager.m14456v().m14467L(context, bundle);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: q */
    public boolean mo58449q(Context context) {
        return context instanceof GalleryMainActivity;
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: q0 */
    public void mo58450q0(Context context) {
        CloudAlbumSettings.m14363h().m14369d(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: r */
    public SwitchInfo mo58451r(Context context) {
        return CloudAlbumManager.m14456v().m14504w(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: r0 */
    public void mo58452r0(Context context, int i10) {
        C0064b.m422c().m426e(context, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: s */
    public void mo58453s(Context context) throws SQLException {
        CloudAlbumManager.m14456v().m14466K(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: s0 */
    public void mo58454s0(Context context, ResultReceiver resultReceiver, boolean z10, boolean z11) {
        Intent intent = new Intent(context, (Class<?>) GalleryMainActivity.class);
        intent.putExtra("gallery_finisher", resultReceiver);
        if (z11) {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        } else {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 0);
        }
        intent.putExtra("need_root_alert", z10);
        C13230i.m79525e1(intent, "1", "3");
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: t */
    public void mo58455t(Context context, boolean z10) {
        C1122c.m6800k2(context, z10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: t0 */
    public boolean mo58456t0(Context context) {
        return C11820b.m70402g(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: u */
    public void mo58457u(Context context, InterfaceC14352c interfaceC14352c) {
        C0064b.m422c().m428g(context, interfaceC14352c);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: u0 */
    public void mo58458u0(Context context, InterfaceC14351b interfaceC14351b, int i10) {
        CloudAlbumManager.m14456v().m14507z(context, interfaceC14351b, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: v */
    public void mo58459v(Context context) {
        new GalleryShelveNotification(context).m14542f();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: v0 */
    public void mo58460v0(Context context, String str, boolean z10, boolean z11) {
        C12091d.m72280a0().m72393v0(context, str, z10, z11);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: w */
    public void mo58461w() throws SQLException {
        CloudAlbumManager.m14456v().m14499p();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: w0 */
    public void mo58462w0(Context context) {
        C1120a.m6677i("CloudAlbumRouterImpl", "notifyAfterSignAgreement");
        CloudAlbumManager.m14456v().m14485f(false);
        CloudAlbumManager.m14456v().m14473S();
        C9672i.m60386f(context, 1001, false);
        C12470c.m74770d().m74771a();
        C11824a.m70444a();
        C12290a.m73843a();
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: x */
    public void mo58463x() {
        C9665b.m60347d(2, 121);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: x0 */
    public void mo58464x0(Handler handler, List<ShareAlbumInfo> list) {
        C12091d.m72280a0().m72395w0(handler, list);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: y */
    public void mo58465y(Context context, boolean z10, int i10) throws Resources.NotFoundException {
        new GalleryShelveNotification(context).m14547k(z10, i10);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: y0 */
    public boolean mo58466y0(Context context) {
        return CloudAlbumManager.m14456v().m14462F(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: z */
    public void mo58467z(Context context) {
        CloudAlbumManager.m14456v().m14500r(context);
    }

    @Override // p232dp.InterfaceC9282a
    /* renamed from: z0 */
    public void mo58468z0(Context context, InterfaceC14352c interfaceC14352c) {
        C0064b.m422c().m429h(context, interfaceC14352c);
    }
}
