package com.huawei.android.p069cg.logic.manager;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.C2414a;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumThumbClearTask;
import com.huawei.android.hicloud.album.service.logic.callable.GalleryNetworkEnableNotificationTask;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.commonlib.router.ISyncAccountModuleClient;
import com.huawei.android.p069cg.activity.GalleryMainActivity;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.ClearInfo;
import com.huawei.android.p069cg.logic.CommonRequestOperator;
import com.huawei.android.p069cg.manager.CloudAlbumReFoundManager;
import com.huawei.android.p069cg.manager.WiseFactoryManager;
import com.huawei.android.p069cg.notification.GalleryShelveNotification;
import com.huawei.android.p069cg.persistence.p070db.operator.FileInfoOperator;
import com.huawei.android.p069cg.request.ClearRecycleRequest;
import com.huawei.android.p069cg.request.FileCountQueryRequest;
import com.huawei.android.p069cg.request.response.BaseResponse;
import com.huawei.android.p069cg.request.response.FileCountResponse;
import com.huawei.android.p069cg.request.threadpool.AbstractC2328i;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneSpaceMgrBannerTask;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.router.data.AppInfo;
import com.huawei.hicloud.router.data.SwitchInfo;
import com.huawei.hms.network.embedded.C5963j;
import fk.C9721b;
import gp.C10028c;
import io.C10582a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0067e;
import p009a8.C0073k;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1006a;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1136q;
import p031b7.C1138s;
import p037bp.C1270a;
import p220d8.C9049c;
import p232dp.InterfaceC9284c;
import p232dp.InterfaceC9285d;
import p281f8.C9665b;
import p281f8.C9671h;
import p281f8.C9672i;
import p281f8.C9673j;
import p283fa.C9678a;
import p332ha.C10130a;
import p336he.C10155f;
import p429kk.C11058a;
import p431ko.C11079e;
import p511o6.C11819a;
import p512o7.C11824a;
import p546p6.C12091d;
import p546p6.C12096i;
import p546p6.C12106s;
import p547p7.C12115c;
import p569q7.C12290a;
import p581qk.AbstractC12367d;
import p604r7.C12470c;
import p604r7.C12473f;
import p616rk.C12515a;
import p649t6.C12942b;
import p649t6.C12943c;
import p649t6.C12944d;
import p664u0.C13108a;
import p681uj.C13198o;
import p681uj.InterfaceC13189f;
import p709vj.C13452e;
import p764x6.C13715g;
import p850zo.InterfaceC14351b;

/* loaded from: classes2.dex */
public class CloudAlbumManager implements ISyncAccountModuleClient {

    public static class FileInitTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f10986a;

        public FileInitTask(Context context) {
            this.f10986a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1124e.m6877u(this.f10986a);
        }
    }

    public static class SyncStateTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f10987a;

        public SyncStateTask(Context context) {
            this.f10987a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C2414a.m15051l().m15060p(9097, C1122c.m6746W0(this.f10987a));
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$a */
    public class C2291a extends AbstractC12367d {
        public C2291a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C1122c.m6706J(C0213f.m1377a());
                CloudAlbumManager.this.m14484e0();
                CloudAlbumManager.this.m14491i(C0213f.m1377a());
                C1122c.m6825r(C0213f.m1377a(), C1122c.m6755Z0("04016"));
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumManager", "stopAndClearGalleryTagAndState Fail!" + e10.getMessage());
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public String getTag() {
            return "CloudAlbumManager.stopAndClearGalleryTagAndState";
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$b */
    public static class C2292b extends AbstractC12367d {
        public C2292b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e10) {
                C1120a.m6676e("CloudAlbumManager", "BackgroundLoginTask sleep: " + e10.getMessage());
            }
            C1120a.m6677i("CloudAlbumManager", "notifyLoginSuccess, cmdId: 1001");
            Bundle bundle = new Bundle();
            bundle.putBoolean("State", false);
            C2414a.m15051l().invokeEvent(1001, bundle);
            if (C13452e.m80781L().m80927i1()) {
                return;
            }
            CloudAlbumManager.m14456v().m14492i0(C0213f.m1377a(), 1004, false);
            C9665b.m60346c();
        }

        public /* synthetic */ C2292b(C2291a c2291a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$c */
    public static class C2293c extends AbstractC12367d {
        public C2293c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            C1122c.m6825r(C0213f.m1377a(), C1122c.m6755Z0("04016"));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e10) {
                C1120a.m6676e("CloudAlbumManager", "BackgroundClearDataTask sleep: " + e10.getMessage());
            }
            CloudAlbumManager.m14456v().m14492i0(C0213f.m1377a(), 1001, true);
            C10130a.m63052a();
            C1122c.m6697G(C1122c.m6778f0());
            C1122c.m6697G(C1124e.m6868l());
            C1122c.m6697G(C1122c.m6710K0());
        }

        public /* synthetic */ C2293c(C2291a c2291a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$d */
    public static class RunnableC2294d implements Runnable {

        /* renamed from: a */
        public Context f10989a;

        /* renamed from: b */
        public InterfaceC14351b f10990b;

        public RunnableC2294d(Context context, InterfaceC14351b interfaceC14351b) {
            this.f10989a = context;
            this.f10990b = interfaceC14351b;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BaseResponse baseResponseM80113o = new ClearRecycleRequest(this.f10989a).m80113o(BaseResponse.class);
                Bundle bundle = new Bundle();
                bundle.putInt(C5963j.f27041j, baseResponseM80113o.getCode());
                this.f10990b.onResult(bundle);
                C1120a.m6677i("CloudAlbumManager", "clear recycle code: " + baseResponseM80113o.getCode() + ",info: " + baseResponseM80113o.getInfo());
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumManager", "clear recycle err :" + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$e */
    public static class C2295e extends AbstractC12367d {

        /* renamed from: a */
        public final boolean f10991a;

        public C2295e(boolean z10) {
            this.f10991a = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f10991a && C1122c.m6696F1()) {
                return;
            }
            try {
                try {
                    new C13715g("").mo77941d(BaseResponse.class);
                } catch (Exception e10) {
                    C1120a.m6676e("DataVersionCheckTask", "DataVersionCheckExecutor Exception:" + e10.toString());
                }
            } finally {
                C1122c.m6747W1(C0213f.m1377a(), "0:1", "OK", "04001", "DataVersionCheckTask", C1122c.m6755Z0("04001"));
            }
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$f */
    public static class RunnableC2296f implements Runnable {

        /* renamed from: a */
        public Context f10992a;

        /* renamed from: b */
        public InterfaceC14351b f10993b;

        public RunnableC2296f(Context context, InterfaceC14351b interfaceC14351b) {
            this.f10992a = context;
            this.f10993b = interfaceC14351b;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileCountQueryRequest fileCountQueryRequest = new FileCountQueryRequest(this.f10992a);
            try {
                FileCountResponse fileCountResponseM80113o = fileCountQueryRequest.m80113o(FileCountResponse.class);
                if (fileCountResponseM80113o == null) {
                    C1120a.m6678w("CloudAlbumManager", "ret is null");
                    return;
                }
                int code = fileCountResponseM80113o.getCode();
                C1120a.m6677i("CloudAlbumManager", "req.bapi.cloudphoto.getFileNum: " + code + ", info: " + fileCountResponseM80113o.getInfo());
                if (code == 402 && (fileCountResponseM80113o = (FileCountResponse) C11819a.m70394b(fileCountQueryRequest, FileCountResponse.class)) != null) {
                    code = fileCountResponseM80113o.getCode();
                    C1120a.m6677i("CloudAlbumManager", "retry req.bapi.cloudphoto.getFileNum: " + code + ", info: " + fileCountResponseM80113o.getInfo());
                }
                if (code != 0) {
                    C1120a.m6676e("CloudAlbumManager", "getCloudFileCount error: " + code);
                    return;
                }
                FileCountResponse.Result result = fileCountResponseM80113o != null ? fileCountResponseM80113o.getResult() : null;
                if (result != null) {
                    long pictureCount = result.getPictureCount();
                    long videoCount = result.getVideoCount();
                    C1120a.m6675d("CloudAlbumManager", "getCloudFileCount pic video: " + pictureCount + ", " + videoCount);
                    Bundle bundle = new Bundle();
                    bundle.putInt(C5963j.f27041j, 0);
                    bundle.putLong("cloudPicCount", pictureCount);
                    bundle.putLong("cloudVideoCount", videoCount);
                    this.f10993b.onResult(bundle);
                }
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumManager", "getCloudFileCount error:" + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$g */
    public static class C2297g implements InterfaceC13189f {

        /* renamed from: a */
        public Context f10994a;

        public C2297g(Context context) {
            this.f10994a = context;
        }

        @Override // p681uj.InterfaceC13189f
        /* renamed from: a */
        public void mo14508a() {
        }

        @Override // p681uj.InterfaceC13189f
        public void onSuccess(String str) {
            InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
            if (interfaceC9285d == null || TextUtils.isEmpty(str)) {
                return;
            }
            interfaceC9285d.mo17174g(this.f10994a, str, false);
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$h */
    public static class RunnableC2298h implements Runnable {

        /* renamed from: a */
        public Context f10995a;

        /* renamed from: b */
        public InterfaceC14351b f10996b;

        /* renamed from: c */
        public int f10997c = 0;

        public RunnableC2298h(Context context, InterfaceC14351b interfaceC14351b) {
            this.f10995a = context;
            this.f10996b = interfaceC14351b;
        }

        /* renamed from: a */
        public void m14509a(int i10) {
            C1120a.m6677i("CloudAlbumManager", "setRequestId=" + i10);
            this.f10997c = i10;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            long j10;
            long j11;
            long j12;
            int i10;
            long j13;
            String strM14405b;
            long j14;
            if (!C1136q.a.m6988c(this.f10995a)) {
                C1120a.m6676e("CloudAlbumManager", "query user space INTFACE_FAIL_LOGOFF!");
                Bundle bundle = new Bundle();
                bundle.putInt(C5963j.f27041j, 3);
                this.f10996b.onResult(bundle);
                return;
            }
            int i11 = 1;
            try {
                strM14405b = new CommonRequestOperator(this.f10995a).m14405b("1");
            } catch (JSONException unused) {
                j10 = 0;
                j11 = 0;
            } catch (Exception e10) {
                e = e10;
                j10 = 0;
                j11 = 0;
            }
            if (strM14405b != null) {
                JSONObject jSONObject = new JSONObject(strM14405b);
                j11 = jSONObject.getLong("useSpaceSize");
                try {
                    j12 = jSONObject.getLong("totalSpaceSize");
                    try {
                        if (jSONObject.has("cloudPhotoSize")) {
                            j10 = jSONObject.getLong("cloudPhotoSize");
                            try {
                                C1136q.b.m7112x1(this.f10995a, "userCapacityPhotoTotal", j10);
                                i11 = 0;
                            } catch (JSONException unused2) {
                                C1120a.m6676e("CloudAlbumManager", "query userSpace cloudPhotoSize JSONException");
                                i10 = 1;
                                j13 = 0;
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt(C5963j.f27041j, i10);
                                bundle2.putLong("photoTotalSize", j10);
                                bundle2.putLong("recycleTotalSize", j13);
                                bundle2.putLong("useSpaceSize", j11);
                                bundle2.putLong("totalSpaceSize", j12);
                                bundle2.putInt("requestId", this.f10997c);
                                this.f10996b.onResult(bundle2);
                            } catch (Exception e11) {
                                e = e11;
                                C1120a.m6676e("CloudAlbumManager", "query userSpace cloudPhotoSize error: " + e.toString());
                                i10 = 1;
                                j13 = 0;
                                Bundle bundle22 = new Bundle();
                                bundle22.putInt(C5963j.f27041j, i10);
                                bundle22.putLong("photoTotalSize", j10);
                                bundle22.putLong("recycleTotalSize", j13);
                                bundle22.putLong("useSpaceSize", j11);
                                bundle22.putLong("totalSpaceSize", j12);
                                bundle22.putInt("requestId", this.f10997c);
                                this.f10996b.onResult(bundle22);
                            }
                        } else {
                            j10 = 0;
                        }
                        if (jSONObject.has("recyclePhotoSize")) {
                            j14 = jSONObject.getLong("recyclePhotoSize");
                            i11 = 0;
                        }
                        i10 = i11;
                        j13 = j14;
                    } catch (JSONException unused3) {
                        j10 = 0;
                    } catch (Exception e12) {
                        e = e12;
                        j10 = 0;
                    }
                } catch (JSONException unused4) {
                    j10 = 0;
                    j12 = 0;
                    C1120a.m6676e("CloudAlbumManager", "query userSpace cloudPhotoSize JSONException");
                    i10 = 1;
                    j13 = 0;
                    Bundle bundle222 = new Bundle();
                    bundle222.putInt(C5963j.f27041j, i10);
                    bundle222.putLong("photoTotalSize", j10);
                    bundle222.putLong("recycleTotalSize", j13);
                    bundle222.putLong("useSpaceSize", j11);
                    bundle222.putLong("totalSpaceSize", j12);
                    bundle222.putInt("requestId", this.f10997c);
                    this.f10996b.onResult(bundle222);
                } catch (Exception e13) {
                    e = e13;
                    j10 = 0;
                    j12 = 0;
                    C1120a.m6676e("CloudAlbumManager", "query userSpace cloudPhotoSize error: " + e.toString());
                    i10 = 1;
                    j13 = 0;
                    Bundle bundle2222 = new Bundle();
                    bundle2222.putInt(C5963j.f27041j, i10);
                    bundle2222.putLong("photoTotalSize", j10);
                    bundle2222.putLong("recycleTotalSize", j13);
                    bundle2222.putLong("useSpaceSize", j11);
                    bundle2222.putLong("totalSpaceSize", j12);
                    bundle2222.putInt("requestId", this.f10997c);
                    this.f10996b.onResult(bundle2222);
                }
                Bundle bundle22222 = new Bundle();
                bundle22222.putInt(C5963j.f27041j, i10);
                bundle22222.putLong("photoTotalSize", j10);
                bundle22222.putLong("recycleTotalSize", j13);
                bundle22222.putLong("useSpaceSize", j11);
                bundle22222.putLong("totalSpaceSize", j12);
                bundle22222.putInt("requestId", this.f10997c);
                this.f10996b.onResult(bundle22222);
            }
            j10 = 0;
            j11 = 0;
            j12 = 0;
            j14 = 0;
            i10 = i11;
            j13 = j14;
            Bundle bundle222222 = new Bundle();
            bundle222222.putInt(C5963j.f27041j, i10);
            bundle222222.putLong("photoTotalSize", j10);
            bundle222222.putLong("recycleTotalSize", j13);
            bundle222222.putLong("useSpaceSize", j11);
            bundle222222.putLong("totalSpaceSize", j12);
            bundle222222.putInt("requestId", this.f10997c);
            this.f10996b.onResult(bundle222222);
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$i */
    public static class C2299i {

        /* renamed from: a */
        public static CloudAlbumManager f10998a = new CloudAlbumManager(null);
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$j */
    public static class C2300j extends AbstractC2328i {
        public C2300j() {
            super(null);
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
        public Object call() throws Exception {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e10) {
                C1120a.m6676e("NotifyGalleryStartSyncCallable", "NotifyGalleryStartSyncCallable sleep: " + e10.getMessage());
            }
            C9665b.m60347d(2, 7);
            C9665b.m60347d(0, 7);
            return null;
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$k */
    public static class CallableC2301k implements Callable<Object> {

        /* renamed from: a */
        public Context f10999a;

        /* renamed from: b */
        public InterfaceC14351b f11000b;

        public CallableC2301k(Context context, InterfaceC14351b interfaceC14351b) {
            this.f10999a = context;
            this.f11000b = interfaceC14351b;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            new FileInfoOperator(this.f10999a.getApplicationContext()).m14553b(this.f11000b);
            return null;
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$l */
    public static class C2302l implements C10582a.c {

        /* renamed from: a */
        public Context f11001a;

        /* renamed from: b */
        public String f11002b;

        public C2302l(Context context, String str) {
            this.f11001a = context;
            this.f11002b = str;
        }

        @Override // io.C10582a.c
        public void onResult(int i10) {
            if ("syncSwitch".equals(this.f11002b)) {
                C1136q.e.m7179q(this.f11001a, i10 == 0);
            } else {
                C1136q.e.m7176n(this.f11001a, i10 == 0);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$m */
    public static class C2303m extends AbstractC12367d {

        /* renamed from: a */
        public Context f11003a;

        /* renamed from: b */
        public int f11004b;

        /* renamed from: c */
        public boolean f11005c;

        public C2303m(Context context, int i10, boolean z10) {
            this.f11003a = context;
            this.f11004b = i10;
            this.f11005c = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C1122c.m6760a2(this.f11003a, this.f11005c, this.f11004b);
        }
    }

    /* renamed from: com.huawei.android.cg.logic.manager.CloudAlbumManager$n */
    public static class C2304n extends AbstractC12367d {

        /* renamed from: a */
        public Context f11006a;

        /* renamed from: b */
        public boolean f11007b;

        public C2304n(Context context, boolean z10) {
            this.f11006a = context;
            this.f11007b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C0209d.m1151A2(this.f11006a, "hicloud_login", this.f11007b);
        }
    }

    public /* synthetic */ CloudAlbumManager(C2291a c2291a) {
        this();
    }

    /* renamed from: H */
    public static /* synthetic */ void m14447H(UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null || userDataStateInfo.getBmType() == -1) {
            return;
        }
        if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
            C1120a.m6677i("CloudAlbumManager", "bs grade:" + userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
        }
        if (userDataStateInfo.getBmType() == 1) {
            C13452e.m80781L().m80985w2(true);
            C1120a.m6677i("CloudAlbumManager", "new bm type:true");
        } else if (userDataStateInfo.getBmType() == 0) {
            C1120a.m6677i("CloudAlbumManager", "new bm type:false");
            C13452e.m80781L().m80985w2(false);
        }
        C1120a.m6677i("CloudAlbumManager", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
        C1136q.m6954L(userDataStateInfo.getBmGradeState());
        C1136q.m6953K(userDataStateInfo.getDataPeriod());
        C1136q.m6955M(System.currentTimeMillis());
    }

    /* renamed from: P */
    public static void m14448P(Context context, int i10) throws SQLException {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "openCloudGallerySwitch context is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", true);
        m14456v().m14470O(context, bundle, i10);
        C1122c.m6764b2(i10, true);
    }

    /* renamed from: a0 */
    public static void m14450a0(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("userConfirm", i10);
        C2414a.m15051l().sendMessage(9098, bundle);
    }

    /* renamed from: e */
    public static void m14454e(Context context) throws SQLException {
        C1120a.m6677i("CloudAlbumManager", "checkCloudGallerySwitch");
        if (C10155f.m63290n()) {
            return;
        }
        m14455q(context, 3);
    }

    /* renamed from: q */
    public static void m14455q(Context context, int i10) throws SQLException {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "closeCloudGallerySwitch context is null");
            return;
        }
        boolean zM7166d = C1136q.e.m7166d(context);
        C1120a.m6677i("CloudAlbumManager", "closeCloudGallerySwitch isAlbumOpen = " + zM7166d);
        if (zM7166d) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", false);
            m14456v().m14470O(context, bundle, i10);
            C1122c.m6764b2(i10, false);
        }
    }

    /* renamed from: v */
    public static CloudAlbumManager m14456v() {
        return C2299i.f10998a;
    }

    /* renamed from: A */
    public void m14457A(Context context) {
        m14458B(context);
        if (!C0209d.m1309t1(context)) {
            C1120a.m6677i("CloudAlbumManager", "not main process");
            return;
        }
        CloudAlbumSettings.m14363h().m14371f(context);
        WiseFactoryManager.m14530d(context).m14535h();
        if (m14463G(context)) {
            m14494k(context);
        }
        m14490h0(context, C1136q.e.m7166d(context));
        C2414a.m15051l().m15057m(context);
        new GalleryShelveNotification(context).m14543g();
        boolean z10 = C13452e.m80781L().m80842P0() && C10028c.m62183d0(context).m62221H1();
        boolean zM14376l = CloudAlbumSettings.m14363h().m14376l();
        if (z10 && !zM14376l && !C1136q.e.m7166d(context)) {
            C1120a.m6677i("CloudAlbumManager", "init checkDataVersion");
            m14485f(true);
        }
        m14459C();
        if (CloudAlbumSettings.m14363h().m14383s() || CloudAlbumSettings.m14363h().m14382r()) {
            C12515a.m75110o().m75175e(new CloudAlbumThumbClearTask(), true);
        }
        C12515a.m75110o().m75172d(new GalleryNetworkEnableNotificationTask(context));
    }

    /* renamed from: B */
    public final void m14458B(Context context) {
        C12515a.m75110o().m75175e(new FileInitTask(context), false);
    }

    /* renamed from: C */
    public final void m14459C() {
        NotifyConstants.getGotoAppMapping().put(NotifyConstants.HICLOUD_GALLERY, GalleryMainActivity.class);
    }

    /* renamed from: D */
    public final boolean m14460D(int i10, Context context) {
        boolean zM5979z = C1006a.m5936k().m5979z(context);
        if (i10 == 22 || i10 == 21 || i10 == 20 || i10 == 1 || i10 == 2) {
            return false;
        }
        return ((i10 != 7 || !C13452e.m80781L().m80791C0()) && i10 == 10 && C13452e.m80781L().m80791C0() && zM5979z) ? false : true;
    }

    /* renamed from: E */
    public void m14461E(Context context, InterfaceC14351b interfaceC14351b) throws ExecutionException, InterruptedException, TimeoutException {
        C1120a.m6676e("CloudAlbumManager", "isExistMediaFile");
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(1);
        C12515a.m75110o().m75172d(new QueryHiCloudSceneSpaceMgrBannerTask());
        try {
            executorServiceNewFixedThreadPool.submit(new CallableC2301k(context, interfaceC14351b)).get(5000L, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("haveMediaFile", false);
            interfaceC14351b.onResult(bundle);
            C1120a.m6676e("CloudAlbumManager", "QueryLocalMediaFileTask timeout");
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumManager", "future get error: " + e10.toString());
        }
    }

    /* renamed from: F */
    public boolean m14462F(Context context) {
        C1120a.m6676e("CloudAlbumManager", "isExistMediaFile");
        int iM14552a = new FileInfoOperator(context.getApplicationContext()).m14552a();
        C1120a.m6675d("CloudAlbumManager", "isExistMediaFile result=" + iM14552a);
        return iM14552a == 1;
    }

    /* renamed from: G */
    public boolean m14463G(Context context) {
        return C1136q.e.m7171i(context.getApplicationContext());
    }

    /* renamed from: I */
    public void m14464I(Context context, String str) {
        HashMap map = new HashMap();
        map.put("cloudphoto.cellswitch", str);
        new C10582a(C11058a.m66627b("04002")).m64928b0(map, "1", new C2302l(context, "cloudphoto.cellswitch"));
    }

    /* renamed from: J */
    public void m14465J(long j10) {
        C1120a.m6677i("CloudAlbumManager", "notifyLimitingToGallery with http error code 803");
        Bundle bundle = new Bundle();
        bundle.putLong("retryAfterTime", j10);
        bundle.putInt("Code", 165);
        C2414a.m15051l().sendMessage(9079, bundle);
        C2414a.m15051l().invokeEvent(1007, bundle);
    }

    /* renamed from: K */
    public void m14466K(Context context) throws SQLException {
        C1120a.m6677i("CloudAlbumManager", "notifyLoginOff begin");
        C1120a.m6677i("CloudAlbumManager", "begin updateLoginCacheInfo");
        C12515a.m75110o().m75172d(new C2304n(context, false));
        ClearInfo clearInfo = new ClearInfo(context);
        clearInfo.m14403c();
        clearInfo.m14401a();
        clearInfo.m14402b();
        C1120a.m6677i("CloudAlbumManager", "end updateLoginCacheInfo");
        m14478X(context);
        C1136q.b.m7096s0(context, false);
        C1136q.b.m7093r0(context, false);
        C1120a.m6677i("CloudAlbumManager", "close album switch resets the data status.");
        C1136q.m6954L(-1);
        C1136q.m6953K(-1);
        C1136q.m6955M(0L);
        m14491i(context);
        C1122c.m6812n2(context, "hicloud_album_switch_state", 0);
        C1122c.m6706J(context);
        C9678a.m60442e().m60449i();
        m14498o(true);
        C12515a.m75110o().m75172d(new C2293c(null));
        C12470c.m74770d().m74771a();
        C11824a.m70444a();
        C12473f.m74865c().m74866b(1);
        C12096i.m72418I().m72451U();
        C1138s.m7181d().m7183b();
        C12091d.m72280a0().m72386t();
        C12091d.m72280a0().m72383s(context);
        CloudAlbumReFoundManager.m14515b().m14516a(103, "");
        C12290a.m73843a();
        C12115c.m72560h().m72561a();
        C0067e.m443e().m445b();
    }

    /* renamed from: L */
    public void m14467L(Context context, Bundle bundle) {
        C1120a.m6677i("CloudAlbumManager", "notifyLoginSuccess begin");
        C12515a.m75110o().m75172d(new C2304n(context, true));
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "notifyLoginSuccess, context is null");
        } else if (bundle == null) {
            C1120a.m6676e("CloudAlbumManager", "notifyLoginSuccess, loginInfo is null");
        } else {
            C12515a.m75110o().m75172d(new C2292b(null));
        }
    }

    /* renamed from: M */
    public void m14468M(Context context, String str) {
        C1120a.m6677i("CloudAlbumManager", "notifyNicknameChanged");
    }

    /* renamed from: N */
    public boolean m14469N(Context context) throws InterruptedException, SQLException {
        C1120a.m6677i("CloudAlbumManager", "notifyReset");
        ClearInfo clearInfo = new ClearInfo(context);
        m14462F(context);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C1120a.m6676e("CloudAlbumManager", "resetAll sleep：" + e10.getMessage());
        }
        boolean zM14492i0 = m14492i0(context, 1002, true);
        clearInfo.m14402b();
        m14498o(false);
        return zM14492i0 && m14491i(context);
    }

    /* renamed from: O */
    public void m14470O(Context context, Bundle bundle, int i10) throws SQLException {
        C1120a.m6677i("CloudAlbumManager", "notifySwitchChange begin and form is: " + i10);
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumManager", "notifySwitchChange, switchInfo is null");
            return;
        }
        C1120a.m6675d("CloudAlbumManager", "notifySwitchChange switchBundle: " + bundle.toString());
        m14476V(context, bundle, i10);
        C12106s.m72509c().m72521m();
        if (bundle.containsKey("GeneralAblum")) {
            boolean z10 = bundle.getBoolean("GeneralAblum", false);
            C1136q.e.m7174l(Boolean.valueOf(z10), context);
            if (z10) {
                C1120a.m6677i("CloudAlbumManager", "The cloud album switch is changed. The change result is as follows:" + z10 + " from " + i10);
                C1136q.e.m7175m(z10, context);
            } else if (m14460D(i10, context)) {
                C1120a.m6677i("CloudAlbumManager", "The cloud album switch is changed. The change result is as follows:" + z10 + " from " + i10);
                C1136q.e.m7175m(z10, context);
            }
            m14490h0(context, z10);
            if (z10) {
                C1120a.m6675d("CloudAlbumManager", "cloudalbum switch on, get token");
                C13198o.m79385c().m79387d(context.getApplicationContext(), new C2297g(context.getApplicationContext()));
                C9049c.m57054f(context, 104, false);
                m14498o(false);
            } else {
                C1136q.m6955M(0L);
                C1136q.b.m7075l0(context, "");
                C1136q.b.m6990A0(context, "");
                m14478X(context);
                C9673j.m60389a(context);
                C1136q.b.m7096s0(context, false);
                C1136q.b.m7093r0(context, false);
                C1136q.b.m7067i1(context, "");
                m14483d0();
                C1136q.m6946D("");
                C1136q.m6983x("");
                C1136q.m6952J(false);
                CloudAlbumReFoundManager.m14515b().m14516a(104, "");
                C12115c.m72560h().m72561a();
                C0067e.m443e().m445b();
            }
            if (z10) {
                m14456v().m14486f0(context, "AUTO", "1");
            } else {
                m14456v().m14486f0(context, "DISABLED", "1");
            }
            m14492i0(context, 1002, !z10);
        }
    }

    /* renamed from: Q */
    public void m14471Q(Context context, String str) {
        C9671h.m60379i(context, str);
    }

    /* renamed from: R */
    public void m14472R(Context context, String str) {
        C9671h.m60380j(context, str);
    }

    /* renamed from: S */
    public void m14473S() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.cg.logic.manager.a
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                CloudAlbumManager.m14447H(userDataStateInfo);
            }
        }, false, arrayList, "AlbumRefresh"), false);
    }

    /* renamed from: T */
    public void m14474T(Context context) throws InterruptedException, SQLException {
        C1120a.m6677i("CloudAlbumManager", "begin reopenSwitch");
        m14498o(false);
        m14462F(context);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C1120a.m6676e("CloudAlbumManager", "reopenSwitch sleep: " + e10.getMessage());
        }
        m14484e0();
        m14491i(context);
        boolean zM7166d = C1136q.e.m7166d(context);
        m14492i0(context, 1002, true);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e11) {
            C1120a.m6676e("CloudAlbumManager", "reopenSwitch sleep: " + e11.getMessage());
        }
        if (zM7166d) {
            m14492i0(context, 1002, false);
        }
        m14478X(context);
    }

    /* renamed from: U */
    public void m14475U(Context context, boolean z10) {
        C1120a.m6677i("CloudAlbumManager", "reportMobileSwitchStatus");
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "reportSwitchStatus context is null");
        } else if (z10) {
            m14464I(context, "AUTO");
        } else {
            m14464I(context, "DISABLED");
        }
    }

    /* renamed from: V */
    public final void m14476V(Context context, Bundle bundle, int i10) {
        if (bundle.containsKey("GeneralAblum")) {
            C12515a.m75110o().m75175e(new C2303m(context, i10, bundle.getBoolean("GeneralAblum", false)), false);
        }
    }

    /* renamed from: W */
    public void m14477W(Context context, boolean z10) {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "reportSwitchStatus context is null");
        } else if (z10) {
            m14486f0(context, "AUTO", "1");
        } else {
            m14486f0(context, "DISABLED", "1");
        }
    }

    /* renamed from: X */
    public final void m14478X(Context context) {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "resetSaveOriginalStatus context is null");
        } else {
            C1120a.m6675d("CloudAlbumManager", "resetSaveOriginalStatus");
            C1136q.b.m7049c1(context, 0);
        }
    }

    /* renamed from: Y */
    public void m14479Y(Context context) throws InterruptedException, SQLException {
        C1120a.m6677i("CloudAlbumManager", "begin restartSync");
        boolean zM7166d = C1136q.e.m7166d(context);
        m14498o(false);
        m14462F(context);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C1120a.m6676e("CloudAlbumManager", "restartSync sleep：" + e10.getMessage());
        }
        m14484e0();
        m14491i(context);
        m14492i0(context, 1001, true);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e11) {
            C1120a.m6676e("CloudAlbumManager", "restartSync sleep: " + e11.getMessage());
        }
        m14492i0(context, 1001, false);
        if (zM7166d) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e12) {
                C1120a.m6676e("CloudAlbumManager", "notifySync sleep: " + e12.getMessage());
            }
            m14492i0(context, 1002, false);
        }
        m14478X(context);
    }

    /* renamed from: Z */
    public void m14480Z(Context context, String str) throws InterruptedException, SQLException {
        C1120a.m6677i("CloudAlbumManager", "begin restartSyncBySwitchChange: ");
        m14498o(false);
        C1136q.m6955M(0L);
        m14462F(context);
        C1122c.m6816o2(3000L);
        m14484e0();
        m14491i(context);
        boolean zM7166d = C1136q.e.m7166d(context);
        m14492i0(context, 1002, true);
        C1122c.m6816o2(100L);
        if (zM7166d) {
            m14492i0(context, 1002, false);
        }
        m14478X(context);
    }

    /* renamed from: b0 */
    public void m14481b0(Context context, int i10, int i11, int i12, int i13) {
        C1120a.m6677i("CloudAlbumManager", "setSyncLimitConfig begin");
        C1136q.b.m7087p0(context, i10);
        C1136q.b.m7090q0(context, i11 * 1048576);
        C1136q.b.m7084o0(context, i12);
        C1136q.b.m7070j1(context, i13);
    }

    /* renamed from: c0 */
    public void m14482c0(Context context) {
        C1120a.m6677i("CloudAlbumManager", "startUploadScan");
        m14492i0(context, 1004, false);
    }

    /* renamed from: d0 */
    public final void m14483d0() {
        C12515a.m75110o().m75172d(new C2291a());
    }

    /* renamed from: e0 */
    public final void m14484e0() throws InterruptedException {
        C1120a.m6677i("CloudAlbumManager", "stopGallerySync");
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c == null) {
            C1120a.m6676e("CloudAlbumManager", "stopGallerySync cloudSyncRouter is null");
            return;
        }
        interfaceC9284c.mo17102Q("atlas", FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C1120a.m6676e("CloudAlbumManager", "stopGallerySync sleep: " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public void m14485f(boolean z10) {
        C12515a.m75110o().m75175e(new C2295e(z10), false);
    }

    /* renamed from: f0 */
    public void m14486f0(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("syncSwitch", str);
        new C10582a(C11058a.m66627b("04002")).m64928b0(map, str2, new C2302l(context, "syncSwitch"));
    }

    /* renamed from: g */
    public void m14487g(Context context) {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "checkSwitchReportStatus context is null");
            return;
        }
        if (!C10028c.m62182c0().m62221H1()) {
            C1120a.m6678w("CloudAlbumManager", "checkSwitchReportStatus terms is not confirmed");
            return;
        }
        if (!C1136q.e.m7172j(context)) {
            C1120a.m6675d("CloudAlbumManager", "report switch status");
            m14477W(context, C1136q.e.m7166d(context));
        }
        if (C1136q.e.m7168f(context)) {
            return;
        }
        C1120a.m6675d("CloudAlbumManager", "report mobile switch status");
        m14475U(context, C1122c.m6827r1(context));
    }

    /* renamed from: g0 */
    public void m14488g0(Context context) {
        C1120a.m6677i("CloudAlbumManager", "syncCloudAlbum");
        m14450a0(0);
    }

    /* renamed from: h */
    public void m14489h(Context context) throws InterruptedException, SQLException {
        C1120a.m6677i("CloudAlbumManager", "begin clearCloudCache");
        m14498o(false);
        m14462F(context);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            C1120a.m6676e("CloudAlbumManager", "clearCloudCache sleep: " + e10.getMessage());
        }
        if (Version.isSupportClearCloudVersion()) {
            C1122c.m6825r(C0213f.m1377a(), C1122c.m6755Z0("04016"));
            C2333n.m14663f().m14673l(new C2300j(), true);
            return;
        }
        m14484e0();
        m14491i(context);
        boolean zM7166d = C1136q.e.m7166d(context);
        m14492i0(context, 1001, true);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e11) {
            C1120a.m6676e("CloudAlbumManager", "notifyLogin sleep: " + e11.getMessage());
        }
        m14492i0(context, 1001, false);
        if (zM7166d) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e12) {
                C1120a.m6676e("CloudAlbumManager", "notifySync sleep: " + e12.getMessage());
            }
            m14492i0(context, 1002, false);
        }
        m14478X(context);
    }

    /* renamed from: h0 */
    public final void m14490h0(Context context, boolean z10) {
        C1122c.m6812n2(context, "hicloud_album_switch_state", z10 ? 1 : 0);
        C0209d.m1334z2(context, "hicloud_cloudPhoto", z10 ? 1 : 0);
    }

    /* renamed from: i */
    public final boolean m14491i(Context context) {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "clearGalleryTag error, context is null");
            return false;
        }
        C1120a.m6677i("CloudAlbumManager", "clearGalleryTag");
        try {
            context.getContentResolver().delete(new Uri.Builder().authority("com.android.gallery3d.hicloud.deleteTagProvider").scheme("content").appendPath("delete_tag").build(), "", null);
            return true;
        } catch (Exception unused) {
            C1120a.m6676e("CloudAlbumManager", "clearGalleryTag error");
            return false;
        }
    }

    /* renamed from: i0 */
    public final boolean m14492i0(Context context, int i10, boolean z10) {
        C1120a.m6677i("CloudAlbumManager", "updateServiceState, cmdId: " + i10 + ", state: " + z10);
        Bundle bundle = new Bundle();
        bundle.putBoolean("State", z10);
        boolean zInvokeEvent = C2414a.m15051l().invokeEvent(i10, bundle);
        C9672i.m60386f(context, i10, z10);
        return zInvokeEvent;
    }

    /* renamed from: j */
    public void m14493j(Context context, InterfaceC14351b interfaceC14351b) {
        if (interfaceC14351b == null) {
            C1120a.m6676e("CloudAlbumManager", "clearRecycleAlbum error, Listener is null");
        } else {
            C13108a.m78878b(context).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
            new Thread(new RunnableC2294d(context, interfaceC14351b)).start();
        }
    }

    /* renamed from: k */
    public void m14494k(Context context) {
        C1136q.e.m7163a(context.getApplicationContext());
    }

    /* renamed from: l */
    public final void m14495l(Context context, int i10, int i11) {
        m14492i0(context, i10, true);
    }

    /* renamed from: m */
    public void m14496m(Context context) {
        C1120a.m6677i("CloudAlbumManager", "clearTaskAndAuthInfo start!");
        m14495l(context, 1004, 114);
    }

    /* renamed from: n */
    public void m14497n(Context context) {
        C1120a.m6677i("CloudAlbumManager", "clearTaskAndUpgrade start!");
        m14495l(context, 1005, 148);
    }

    /* renamed from: o */
    public final void m14498o(boolean z10) throws SQLException {
        C1120a.m6677i("CloudAlbumManager", "begin clearV2Cache");
        C1136q.d.m7138b(z10);
        new C12943c().m77758i();
        new C12942b().m77752i();
    }

    /* renamed from: p */
    public void m14499p() throws SQLException {
        Context contextM1377a = C0213f.m1377a();
        boolean zM7166d = C1136q.e.m7166d(contextM1377a);
        C1120a.m6677i("CloudAlbumManager", "closeAfterCloudClean isAlbumOpenNow= " + zM7166d);
        if (zM7166d) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", false);
            m14456v().m14470O(contextM1377a, bundle, 22);
            C1122c.m6764b2(22, false);
        }
        C1120a.m6677i("CloudAlbumManager", "service:client,action:dataInit,bus:CloudPhoto,scene:1,result:ok");
        C12515a.m75110o().m75175e(new C0073k.b(C1122c.m6755Z0("04006"), "service:client,action:dataInit,bus:CloudPhoto,scene:1,result:ok"), false);
    }

    /* renamed from: r */
    public void m14500r(Context context) {
        C1120a.m6677i("CloudAlbumManager", "confirmToContinue");
        m14450a0(1);
    }

    /* renamed from: s */
    public ArrayList<AppInfo> m14501s(Context context) {
        return new C12944d().m77768a();
    }

    /* renamed from: t */
    public void m14502t(Context context, InterfaceC14351b interfaceC14351b) {
        if (interfaceC14351b == null) {
            C1120a.m6676e("CloudAlbumManager", "getCloudFileCount error, Listener is null");
        } else {
            new Thread(new RunnableC2296f(context, interfaceC14351b)).start();
        }
    }

    /* renamed from: u */
    public void m14503u(Context context) {
        if (context == null) {
            C1120a.m6676e("CloudAlbumManager", "getCloudPhotoAuth context is null");
        }
    }

    /* renamed from: w */
    public SwitchInfo m14504w(Context context) {
        return C1136q.e.m7173k(context.getApplicationContext());
    }

    /* renamed from: x */
    public Bundle m14505x(Context context) {
        if (CloudAlbumSettings.m14363h().m14381q()) {
            return C9673j.m60390b(context);
        }
        C12515a.m75110o().m75175e(new SyncStateTask(context), false);
        return new Bundle();
    }

    /* renamed from: y */
    public void m14506y(Context context, InterfaceC14351b interfaceC14351b) {
        if (interfaceC14351b == null) {
            C1120a.m6676e("CloudAlbumManager", "getUsedSize error, Listener is null");
        } else {
            new Thread(new RunnableC2298h(context, interfaceC14351b)).start();
        }
    }

    /* renamed from: z */
    public void m14507z(Context context, InterfaceC14351b interfaceC14351b, int i10) {
        if (interfaceC14351b == null) {
            C1120a.m6676e("CloudAlbumManager", "getUsedSize error, Listener is null");
            return;
        }
        RunnableC2298h runnableC2298h = new RunnableC2298h(context, interfaceC14351b);
        runnableC2298h.m14509a(i10);
        new Thread(runnableC2298h).start();
    }

    public CloudAlbumManager() {
    }
}
