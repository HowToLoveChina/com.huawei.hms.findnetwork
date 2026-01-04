package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.GalleryDisableDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.GalleryShelveDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.GalleryShelveRequestResultTip;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.GalleryShelveSuccessDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.UnShelveSpaceNotEnoughDialog;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.NewBusinessModelConfigBean;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0234s;
import p015ak.C0240y;
import p020ap.C1006a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p336he.C10155f;
import p371ik.C10527a;
import p431ko.C11079e;
import p450le.C11273b;
import p454lj.C11290m;
import p472m7.C11427b;
import p496nn.C11737b;
import p496nn.InterfaceC11736a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p572qb.C12312h0;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p783xp.C13843a;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;
import p850zo.InterfaceC14352c;
import p850zo.InterfaceC14353d;

/* loaded from: classes3.dex */
public class GalleryDetailActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public GalleryShelveDialog f14819N0;

    /* renamed from: O0 */
    public AlertDialog f14820O0;

    /* renamed from: P0 */
    public AlertDialog f14821P0;

    /* renamed from: Q0 */
    public AlertDialog f14822Q0;

    /* renamed from: R0 */
    public AlertDialog f14823R0;

    /* renamed from: S0 */
    public AlertDialog f14824S0;

    /* renamed from: T0 */
    public GalleryShelveSuccessDialog f14825T0;

    /* renamed from: W0 */
    public UnShelveSpaceNotEnoughDialog f14828W0;

    /* renamed from: X0 */
    public GalleryDisableDialog f14829X0;

    /* renamed from: Z0 */
    public int f14831Z0;

    /* renamed from: a1 */
    public boolean f14832a1;

    /* renamed from: c1 */
    public ProgressDialog f14834c1;

    /* renamed from: d1 */
    public ProgressDialog f14835d1;

    /* renamed from: g1 */
    public int f14838g1;

    /* renamed from: h1 */
    public int f14839h1;

    /* renamed from: i1 */
    public long f14840i1;

    /* renamed from: j1 */
    public String f14841j1;

    /* renamed from: k1 */
    public String f14842k1;

    /* renamed from: l1 */
    public StorageReceiver f14843l1;

    /* renamed from: m1 */
    public GalleryShelveRequestResultTip f14844m1;

    /* renamed from: n1 */
    public boolean f14845n1;

    /* renamed from: r1 */
    public boolean f14849r1;

    /* renamed from: U0 */
    public boolean f14826U0 = false;

    /* renamed from: V0 */
    public boolean f14827V0 = false;

    /* renamed from: Y0 */
    public int f14830Y0 = 3;

    /* renamed from: b1 */
    public boolean f14833b1 = false;

    /* renamed from: e1 */
    public int f14836e1 = -2;

    /* renamed from: f1 */
    public int f14837f1 = 0;

    /* renamed from: o1 */
    public boolean f14846o1 = false;

    /* renamed from: p1 */
    public boolean f14847p1 = false;

    /* renamed from: q1 */
    public boolean f14848q1 = false;

    /* renamed from: s1 */
    public boolean f14850s1 = true;

    /* renamed from: t1 */
    public boolean f14851t1 = false;

    /* renamed from: u1 */
    public boolean f14852u1 = false;

    /* renamed from: v1 */
    public boolean f14853v1 = false;

    /* renamed from: w1 */
    public C3306v f14854w1 = new C3306v();

    /* renamed from: x1 */
    @SuppressLint({"HandlerLeak"})
    public Handler f14855x1 = new HandlerC3295k();

    /* renamed from: y1 */
    public InterfaceC11736a f14856y1 = new C3298n();

    /* renamed from: z1 */
    @SuppressLint({"HandlerLeak"})
    public Handler f14857z1 = new HandlerC3299o();

    public class StorageReceiver extends BroadcastReceiver {
        public StorageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            Bundle extras = safeIntent.getExtras();
            if (!"com.huawei.hicloud.QUERY_STORAGE_FINISHED".equals(safeIntent.getAction())) {
                if ("com.huawei.cg.action.SPACE_DELETED_CHANGED".equals(safeIntent.getAction())) {
                    C11839m.m70688i("GalleryDetailActivity", "deleted size update");
                    C13368e.m80184F().m80253r0();
                    C13368e.m80184F().m80250o0();
                    return;
                } else {
                    if ("com.huawei.hicloud.getCloudPhotoTotalSize".equals(safeIntent.getAction())) {
                        String stringExtra = safeIntent.getStringExtra("param_pic_and_video_content");
                        C11839m.m70686d("GalleryDetailActivity", "picAndViedoStr " + stringExtra);
                        GalleryDetailActivity.this.f16222k0.setText(stringExtra);
                        return;
                    }
                    return;
                }
            }
            C11839m.m70688i("GalleryDetailActivity", "receive STORAGE_QUERY_FINISHED_ACTION");
            if (extras != null) {
                if (extras.getInt("result") != 1) {
                    C11839m.m70687e("GalleryDetailActivity", "Query gallery info failed");
                    return;
                }
                StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
                long galleryUsedSize = storageInfoM80226P.getGalleryUsedSize();
                long galleryDeleteSize = storageInfoM80226P.getGalleryDeleteSize();
                long j10 = galleryUsedSize + galleryDeleteSize;
                C11839m.m70688i("GalleryDetailActivity", "Query gallery info success, size:" + j10);
                GalleryDetailActivity galleryDetailActivity = GalleryDetailActivity.this;
                galleryDetailActivity.f14841j1 = C0223k.m1524g(galleryDetailActivity.getApplicationContext(), j10);
                GalleryDetailActivity galleryDetailActivity2 = GalleryDetailActivity.this;
                galleryDetailActivity2.f14842k1 = C0223k.m1524g(galleryDetailActivity2.getApplicationContext(), galleryDeleteSize);
                C11839m.m70688i("GalleryDetailActivity", "StorageReceiver totalSize:" + GalleryDetailActivity.this.f14841j1 + " deleteSizeStr:" + GalleryDetailActivity.this.f14842k1);
                GalleryDetailActivity.this.m20538W4();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$a */
    public class DialogInterfaceOnClickListenerC3285a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3285a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14821P0 != null) {
                GalleryDetailActivity.this.m20508A4(false);
                GalleryDetailActivity.this.f14821P0.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$b */
    public class C3286b implements InterfaceC14350a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9282a f14860a;

        public C3286b(InterfaceC9282a interfaceC9282a) {
            this.f14860a = interfaceC9282a;
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: a */
        public void mo13562a() {
            this.f14860a.mo58439l(GalleryDetailActivity.this, 0, 0L);
            GalleryDetailActivity.this.f14836e1 = 0;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: b */
        public void mo13563b() {
            GalleryDetailActivity.this.f14836e1 = -2;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: c */
        public void mo13564c() {
            this.f14860a.mo58439l(GalleryDetailActivity.this, -1, 0L);
            GalleryDetailActivity.this.f14836e1 = -1;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: d */
        public void mo13565d(int i10, int i11, long j10, int i12) {
            this.f14860a.mo58439l(GalleryDetailActivity.this, 1, j10);
            GalleryDetailActivity.this.f14836e1 = 1;
            GalleryDetailActivity.this.f14837f1 = i10;
            GalleryDetailActivity.this.f14839h1 = i11;
            GalleryDetailActivity galleryDetailActivity = GalleryDetailActivity.this;
            galleryDetailActivity.f14838g1 = C2783d.m16192z(galleryDetailActivity);
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$c */
    public class C3287c implements InterfaceC14352c {
        public C3287c() {
        }

        @Override // p850zo.InterfaceC14352c
        /* renamed from: a */
        public void mo13561a(int i10, long j10) {
            GalleryDetailActivity.this.f14839h1 = i10;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(0);
            C11839m.m70688i("GalleryDetailActivity", "cached saveOriginalFileStatus:" + GalleryDetailActivity.this.f14837f1 + ",query downloadNums:" + GalleryDetailActivity.this.f14839h1);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$d */
    public class C3288d implements SpanClickText.ISpanClickListener {

        /* renamed from: a */
        public final /* synthetic */ SpanClickText f14863a;

        public C3288d(SpanClickText spanClickText) {
            this.f14863a = spanClickText;
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
        public void onClick() throws IllegalAccessException, IllegalArgumentException {
            if (this.f14863a != null) {
                GalleryDetailActivity.this.m20539X3();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$e */
    public class C3289e implements InterfaceC14351b {
        public C3289e() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            boolean z10 = bundle.getBoolean("isSupportDisableAndResume");
            C11839m.m70688i("GalleryDetailActivity", "isSupportDisableAndResume:" + z10);
            if (z10) {
                GalleryDetailActivity.this.m20502v4();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$f */
    public class DialogInterfaceOnClickListenerC3290f implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f14866a;

        public DialogInterfaceOnClickListenerC3290f(boolean z10) {
            this.f14866a = z10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14823R0 != null) {
                GalleryDetailActivity.this.f14823R0.dismiss();
            }
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c != null) {
                interfaceC9284c.mo17155v0(GalleryDetailActivity.this.getApplication());
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", true);
            bundle.putBoolean("ShareAlbum", true);
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58396U(GalleryDetailActivity.this, bundle, 11);
            } else {
                C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
            }
            if (interfaceC9284c != null) {
                interfaceC9284c.mo17109X(GalleryDetailActivity.this, false);
            }
            GalleryDetailActivity.this.m20530R3(this.f14866a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$g */
    public class DialogInterfaceOnClickListenerC3291g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3291g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14823R0 != null) {
                GalleryDetailActivity.this.f14823R0.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$h */
    public class C3292h implements InterfaceC14353d {
        public C3292h() {
        }

        @Override // p850zo.InterfaceC14353d
        /* renamed from: a */
        public void mo20563a() {
            GalleryDetailActivity.this.f14830Y0 = 3;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(3);
        }

        @Override // p850zo.InterfaceC14353d
        /* renamed from: b */
        public void mo20564b(int i10, int i11) {
            GalleryDetailActivity.this.f14830Y0 = 2;
            GalleryDetailActivity.this.f14839h1 = i11;
            GalleryDetailActivity.this.f14831Z0 = i10;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(3);
        }

        @Override // p850zo.InterfaceC14353d
        /* renamed from: c */
        public void mo20565c(int i10) {
            GalleryDetailActivity.this.f14830Y0 = 1;
            GalleryDetailActivity.this.f14831Z0 = i10;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(3);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$i */
    public class C3293i implements InterfaceC14351b {
        public C3293i() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            Message messageObtainMessage = GalleryDetailActivity.this.f14857z1.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = bundle;
            GalleryDetailActivity.this.f14857z1.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$j */
    public class C3294j implements InterfaceC14351b {
        public C3294j() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            Message messageObtainMessage = GalleryDetailActivity.this.f14857z1.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.obj = bundle;
            GalleryDetailActivity.this.f14857z1.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$k */
    public class HandlerC3295k extends Handler {
        public HandlerC3295k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            Object obj = message.obj;
            if (obj == null) {
                return;
            }
            GalleryDetailActivity.this.m20533T4(message.what, (Bundle) obj);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$l */
    public class DialogInterfaceOnClickListenerC3296l implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3296l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14824S0 != null) {
                GalleryDetailActivity.this.f14824S0.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$m */
    public class DialogInterfaceOnClickListenerC3297m implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3297m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException {
            if (GalleryDetailActivity.this.f14824S0 != null) {
                GalleryDetailActivity.this.f14824S0.dismiss();
            }
            if (GalleryDetailActivity.this.m20549j4()) {
                return;
            }
            GalleryDetailActivity.this.m20559u4(true);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$n */
    public class C3298n implements InterfaceC11736a {
        public C3298n() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: a */
        public void mo13316a() {
            C11839m.m70688i("GalleryDetailActivity", "onAlbumChanged");
            GalleryDetailActivity.this.m20466S3();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: b */
        public void mo13317b() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: c */
        public void mo13318c() {
            C11839m.m70688i("GalleryDetailActivity", "onMediaChanged");
            GalleryDetailActivity.this.m20466S3();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: d */
        public void mo13319d() {
            C11839m.m70688i("GalleryDetailActivity", "onDownloadSyncCompleted");
            GalleryDetailActivity.this.m20466S3();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$o */
    public class HandlerC3299o extends Handler {
        public HandlerC3299o() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
            if (GalleryDetailActivity.this.isFinishing()) {
                C11839m.m70687e("GalleryDetailActivity", "GalleryDetailActivity is finishing");
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                GalleryDetailActivity.this.f16176B0.setEnabled(true);
                GalleryDetailActivity.this.m20470V4();
                GalleryDetailActivity.this.f14833b1 = false;
            } else {
                if (i10 == 1) {
                    GalleryDetailActivity.this.m20540Y3(message);
                    return;
                }
                if (i10 == 2) {
                    GalleryDetailActivity.this.m20537W3(message);
                    return;
                }
                if (i10 == 3) {
                    GalleryDetailActivity.this.m20528Q3();
                    GalleryDetailActivity.this.m20514G4();
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    GalleryDetailActivity.this.m20536V3();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$p */
    public class DialogInterfaceOnClickListenerC3300p implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3300p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14820O0 != null) {
                GalleryDetailActivity.this.f14820O0.dismiss();
                C2783d.m16149i1(GalleryDetailActivity.this.getApplicationContext());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$q */
    public class DialogInterfaceOnClickListenerC3301q implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3301q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14820O0 != null) {
                GalleryDetailActivity.this.f14820O0.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$r */
    public class C3302r implements InterfaceC14352c {
        public C3302r() {
        }

        @Override // p850zo.InterfaceC14352c
        /* renamed from: a */
        public void mo13561a(int i10, long j10) {
            GalleryDetailActivity.this.f14840i1 = j10;
            GalleryDetailActivity.this.f14857z1.sendEmptyMessage(4);
            C11839m.m70688i("GalleryDetailActivity", "query downloadSize:" + GalleryDetailActivity.this.f14840i1);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$s */
    public class DialogInterfaceOnClickListenerC3303s implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3303s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
            if (GalleryDetailActivity.this.f14822Q0 != null) {
                GalleryDetailActivity.this.f14822Q0.dismiss();
            }
            C1006a.m5936k().m5942F(GalleryDetailActivity.this.getApplicationContext(), GalleryDetailActivity.this.f14831Z0);
            GalleryDetailActivity.this.m20535U4(5);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$t */
    public class DialogInterfaceOnClickListenerC3304t implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3304t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (GalleryDetailActivity.this.f14822Q0 != null) {
                GalleryDetailActivity.this.f14822Q0.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$u */
    public class DialogInterfaceOnClickListenerC3305u implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3305u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
            if (GalleryDetailActivity.this.f14821P0 != null) {
                GalleryDetailActivity.this.m20508A4(false);
                GalleryDetailActivity.this.f14821P0.dismiss();
            }
            C1006a.m5936k().m5942F(GalleryDetailActivity.this.getApplicationContext(), GalleryDetailActivity.this.f14831Z0);
            GalleryDetailActivity.this.m20535U4(0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryDetailActivity$v */
    public class C3306v implements InterfaceC13450c {
        public C3306v() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            if (errorStatus != null) {
                C11839m.m70687e("GalleryDetailActivity", "CloudAccount check pwd error:" + errorStatus.getErrorCode());
            }
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            GalleryDetailActivity.this.m20562z4();
        }
    }

    /* renamed from: N3 */
    private void m20461N3() {
        if (this.f14825T0 != null) {
            try {
                m20510C4(false);
                this.f14825T0.dismiss();
                this.f14825T0 = null;
            } catch (Exception unused) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        AlertDialog alertDialog = this.f14820O0;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
                this.f14820O0 = null;
            } catch (Exception unused2) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        if (this.f14821P0 != null) {
            try {
                m20508A4(false);
                this.f14821P0.dismiss();
                this.f14821P0 = null;
            } catch (Exception unused3) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        AlertDialog alertDialog2 = this.f14822Q0;
        if (alertDialog2 != null) {
            try {
                alertDialog2.dismiss();
                this.f14822Q0 = null;
            } catch (Exception unused4) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        AlertDialog alertDialog3 = this.f14823R0;
        if (alertDialog3 != null) {
            try {
                alertDialog3.dismiss();
                this.f14823R0 = null;
            } catch (Exception unused5) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
    }

    /* renamed from: N4 */
    private void m20462N4() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58465y(this, true, this.f14838g1);
        }
    }

    /* renamed from: O3 */
    private void m20463O3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58459v(this);
        }
    }

    /* renamed from: R4 */
    private void m20464R4() {
        if (this.f14843l1 != null) {
            C13108a.m78878b(this).m78883f(this.f14843l1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S3 */
    public void m20466S3() {
        if (!C10155f.m63299w()) {
            C11839m.m70686d("GalleryDetailActivity", "getCloudPhotosNum not show cloud photo manager");
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58460v0(this, "", false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V4 */
    public void m20470V4() throws Resources.NotFoundException {
        C11839m.m70688i("GalleryDetailActivity", "updateShelveTips disuseStates:" + this.f14836e1);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (this.f14853v1) {
            m20522L4();
            this.f14853v1 = false;
        }
        int i10 = this.f14836e1;
        if (i10 == -2) {
            this.f16246y0.setVisibility(8);
            this.f16248z0.setVisibility(8);
            this.f16202Q.setVisibility(0);
            this.f16203R.setVisibility(0);
            m20509B4();
            this.f16238u0.setVisibility(8);
            this.f16230q0.setVisibility(4);
            return;
        }
        if (i10 == -1) {
            this.f16246y0.setVisibility(8);
            this.f16248z0.setVisibility(8);
            this.f16202Q.setVisibility(0);
            this.f16203R.setVisibility(0);
            m20509B4();
            this.f16238u0.setVisibility(8);
            this.f16230q0.setVisibility(4);
            m20538W4();
            m20463O3();
            return;
        }
        if (i10 == 0) {
            this.f16246y0.setVisibility(0);
            this.f16248z0.setVisibility(8);
            this.f16202Q.setVisibility(0);
            this.f16203R.setVisibility(0);
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f16195L.setVisibility(8);
            this.f16238u0.setVisibility(8);
            this.f16230q0.setVisibility(8);
            m20538W4();
            m20463O3();
            return;
        }
        if (i10 != 1) {
            return;
        }
        if (interfaceC9282a != null) {
            if (interfaceC9282a.mo58398V()) {
                this.f16176B0.setVisibility(0);
                this.f16180D0.setVisibility(8);
            } else {
                this.f16182E0.setVisibility(8);
                this.f16176B0.setVisibility(8);
                this.f16180D0.setVisibility(0);
            }
        }
        this.f16246y0.setVisibility(8);
        this.f16248z0.setVisibility(0);
        this.f16202Q.setVisibility(8);
        this.f16203R.setVisibility(8);
        m20509B4();
        this.f16238u0.setVisibility(8);
        this.f16230q0.setVisibility(4);
        Resources resources = getResources();
        int i11 = R$plurals.gallery_shelve_left_days;
        int i12 = this.f14838g1;
        String quantityString = resources.getQuantityString(i11, i12, Integer.valueOf(i12));
        this.f16174A0.setText(getString(R$string.gallery_shelve_deactived_global_text, quantityString, quantityString));
        m20531S4();
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
        } else {
            if (interfaceC9282a.mo58378L(this)) {
                return;
            }
            m20462N4();
        }
    }

    /* renamed from: X4 */
    private void m20473X4() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
            this.f14836e1 = -2;
            return;
        }
        int iMo58394T = interfaceC9282a.mo58394T(this);
        this.f14836e1 = iMo58394T;
        if (iMo58394T == -1 || iMo58394T == -2) {
            return;
        }
        this.f14838g1 = C2783d.m16192z(this);
        interfaceC9282a.mo58360C(getApplicationContext(), this.f14836e1, this.f14838g1);
        if (this.f14836e1 != 1 || this.f14838g1 >= 0) {
            int iMo58377K0 = interfaceC9282a.mo58377K0(this);
            this.f14837f1 = iMo58377K0;
            if (iMo58377K0 == 0 || iMo58377K0 == 4 || iMo58377K0 == 5 || iMo58377K0 == 7) {
                interfaceC9282a.mo58457u(getApplicationContext(), new C3287c());
                return;
            }
            C11839m.m70688i("GalleryDetailActivity", "cached saveOriginalFileStatus:" + this.f14837f1);
            this.f14857z1.sendEmptyMessage(0);
        }
    }

    /* renamed from: a4 */
    private void m20477a4() {
        if (this.f14843l1 == null) {
            this.f14843l1 = new StorageReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.QUERY_STORAGE_FINISHED");
            intentFilter.addAction("com.huawei.cg.action.SPACE_DELETED_CHANGED");
            intentFilter.addAction("com.huawei.hicloud.getCloudPhotoTotalSize");
            C13108a.m78878b(this).m78880c(this.f14843l1, intentFilter);
        }
    }

    /* renamed from: c4 */
    private void m20480c4() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "initData cloudAlbumRouterImpl is null");
            return;
        }
        if (this.f14846o1) {
            try {
                Intent intent = getIntent();
                if (intent == null) {
                    return;
                }
                long longExtra = intent.getLongExtra("gallery_size", 0L);
                long longExtra2 = intent.getLongExtra("gallery_delete_size", 0L);
                this.f14841j1 = C0223k.m1524g(this, longExtra);
                this.f14842k1 = C0223k.m1524g(this, longExtra2);
                C11839m.m70688i("GalleryDetailActivity", "initData totalSize:" + longExtra + " totalSizeStr:" + this.f14841j1);
                if (longExtra != 0) {
                    m20515H4();
                }
                m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(R$string.gallery_item_title)));
            } catch (Exception unused) {
                C11839m.m70687e("GalleryDetailActivity", "intent Serializable error.");
            }
        } else {
            C11839m.m70688i("GalleryDetailActivity", "queryStorageInfoWithMultiTask");
            if (TextUtils.isEmpty(this.f14841j1) || interfaceC9282a.mo58357A0()) {
                C13368e.m80184F().m80253r0();
                C13368e.m80184F().m80250o0();
            }
        }
        interfaceC9282a.mo58435j(new C3289e());
        m20543b4();
    }

    /* renamed from: f4 */
    private void m20484f4() throws Resources.NotFoundException {
        int i10 = R$string.gallery_item_title;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_cloud_album_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_cloud_album_detail));
        }
        String strM83054F = C13843a.m83054F(this);
        m22420G2(this, C0240y.m1681c(this, strM83054F));
        this.f16244x0.setOnClickListener(this);
        this.f16242w0.setOnClickListener(this);
        this.f16176B0.setOnClickListener(this);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(i10)));
        m22418E2(R$id.enter_hyperlink, strM83054F, "", getString(i10), 0);
        this.f16193K.setText(R$string.gallery_edution_tip);
        this.f16193K.setVisibility(0);
        C11842p.m70874v1(this, this.f16244x0);
        C11842p.m70874v1(this, this.f16242w0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p4 */
    public /* synthetic */ void m20495p4(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C11839m.m70688i("GalleryDetailActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C11839m.m70688i("GalleryDetailActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C11839m.m70688i("GalleryDetailActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            if (interfaceC9282a != null) {
                C11839m.m70688i("GalleryDetailActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58399V0(System.currentTimeMillis());
            }
            if (C13452e.m80781L().m80791C0()) {
                runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.g5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17618a.m20554o4();
                    }
                });
            } else {
                runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.h5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17627a.m20532T3();
                    }
                });
            }
        }
        m20526P3(userDataStateInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4 */
    public void m20502v4() {
        if (!this.f14833b1 && C0209d.m1333z1(this)) {
            this.f14833b1 = true;
            this.f16176B0.setEnabled(false);
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
            } else {
                interfaceC9282a.mo58426g(new C3286b(interfaceC9282a));
            }
        }
    }

    /* renamed from: w4 */
    private void m20504w4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        arrayList.add("bs.userdata.expired.time");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.ui.activity.f5
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
                this.f17609a.m20495p4(userDataStateInfo);
            }
        }, true, arrayList, "GalleryDetail"), false);
    }

    /* renamed from: A4 */
    public void m20508A4(boolean z10) {
        this.f14827V0 = z10;
    }

    /* renamed from: B4 */
    public final void m20509B4() {
        if (!C0209d.m1293p1() && !m20555q4()) {
            if (this.f16207V != null) {
                if (this.f16199N.getVisibility() == 8 && this.f16203R.getVisibility() == 8) {
                    this.f16207V.setVisibility(8);
                } else {
                    this.f16207V.setVisibility(0);
                }
            }
            this.f16195L.setVisibility(0);
            return;
        }
        View view = this.f16207V;
        if (view != null) {
            view.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f16195L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* renamed from: C4 */
    public void m20510C4(boolean z10) {
        this.f14826U0 = z10;
    }

    /* renamed from: D4 */
    public void m20511D4(boolean z10) {
        this.f14851t1 = z10;
    }

    /* renamed from: E4 */
    public void m20512E4(boolean z10) {
        this.f14852u1 = z10;
    }

    /* renamed from: F4 */
    public final void m20513F4(SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2.substring(str.length()), new C3288d(spanClickText));
        spanClickText.m15934g(str2, false);
    }

    /* renamed from: G4 */
    public final void m20514G4() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        int i10 = this.f14830Y0;
        if (i10 == 0) {
            m20518J4();
            return;
        }
        if (i10 == 1) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
            this.f14822Q0 = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
            this.f14822Q0.setCanceledOnTouchOutside(false);
            this.f14822Q0.setMessage(getString(R$string.gallery_shelve_sync_uncompleted_tip));
            this.f14822Q0.setButton(-1, getString(R$string.gallery_shelve_confirm), new DialogInterfaceOnClickListenerC3303s());
            this.f14822Q0.setButton(-2, getString(R$string.gallery_shelve_cancel), new DialogInterfaceOnClickListenerC3304t());
            this.f14822Q0.show();
            return;
        }
        if (i10 != 2) {
            return;
        }
        if (this.f14839h1 <= 0) {
            this.f14837f1 = 3;
            m20531S4();
            C1006a.m5936k().m5942F(getApplicationContext(), 3);
            return;
        }
        if (this.f14827V0) {
            C11839m.m70688i("GalleryDetailActivity", "addShelveDownloadTaskDialog has show");
            return;
        }
        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this).create();
        this.f14821P0 = alertDialogCreate2;
        C11829c.m70594l1(this, alertDialogCreate2);
        this.f14821P0.setCanceledOnTouchOutside(false);
        AlertDialog alertDialog = this.f14821P0;
        Resources resources = getResources();
        int i11 = R$plurals.gallery_shelve_addto_download_list;
        int i12 = this.f14839h1;
        alertDialog.setMessage(resources.getQuantityString(i11, i12, Integer.valueOf(i12)));
        this.f14821P0.setButton(-1, getString(R$string.gallery_shelve_confirm), new DialogInterfaceOnClickListenerC3305u());
        this.f14821P0.setButton(-2, getString(R$string.gallery_shelve_cancel), new DialogInterfaceOnClickListenerC3285a());
        m20508A4(true);
        this.f14821P0.show();
    }

    /* renamed from: H4 */
    public final void m20515H4() {
        this.f16199N.setVisibility(0);
        this.f16200O.setText(R$string.disk_app_detail_title);
        this.f16201P.setText(this.f14841j1);
        this.f16202Q.setVisibility(0);
        this.f16203R.setVisibility(0);
        this.f16204S.setText(R$string.gallery_detail_title_delete);
        this.f16205T.setText(this.f14842k1);
        m20509B4();
    }

    /* renamed from: I4 */
    public final void m20516I4() {
        this.f16199N.setVisibility(0);
        this.f16200O.setText(R$string.disk_app_detail_title);
        this.f16200O.setVisibility(0);
        this.f16201P.setText(this.f14841j1);
        this.f16201P.setVisibility(0);
        this.f16202Q.setVisibility(0);
        this.f16205T.setText(this.f14842k1);
        this.f16203R.setVisibility(0);
        this.f16204S.setVisibility(0);
        this.f16204S.setText(R$string.gallery_detail_title_delete);
        m20509B4();
    }

    /* renamed from: J3 */
    public final void m20517J3() {
        Intent intent = new Intent("com.huawei.gallery.app.photoshare.download.list");
        C0209d.m1302r2(intent, C13843a.m83054F(this));
        intent.setFlags(337641472);
        try {
            startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("GalleryDetailActivity", "checkDownloadList exception");
        }
    }

    /* renamed from: J4 */
    public final void m20518J4() throws IllegalAccessException, IllegalArgumentException {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f14820O0 = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14820O0.setCanceledOnTouchOutside(false);
        this.f14820O0.setMessage(C0209d.m1262h2() ? getString(R$string.gallery_shelve_wlan_invalid) : getString(R$string.gallery_shelve_wifi_invalid));
        this.f14820O0.setButton(-1, getString(R$string.set_wlan), new DialogInterfaceOnClickListenerC3300p());
        this.f14820O0.setButton(-2, getString(R$string.gallery_shelve_cancel), new DialogInterfaceOnClickListenerC3301q());
        this.f14820O0.show();
    }

    /* renamed from: K3 */
    public final void m20519K3() throws IllegalAccessException, IllegalArgumentException {
        if (m20521L3()) {
            m20523M3();
        } else if (!C0209d.m1333z1(this)) {
            m20518J4();
        } else {
            if (m20549j4()) {
                return;
            }
            m20559u4(false);
        }
    }

    /* renamed from: K4 */
    public void m20520K4(Resources resources) throws Resources.NotFoundException {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
            this.f16213b0.setVisibility(8);
            return;
        }
        int iMo58370H = interfaceC9282a.mo58370H();
        C11839m.m70688i("GalleryDetailActivity", "userDataStatus:" + iMo58370H);
        if (iMo58370H == 0) {
            this.f16213b0.setVisibility(0);
            String string = resources.getString(R$string.user_agreement_tips);
            String string2 = resources.getString(R$string.gallery_basic_service_tips2, string, resources.getString(R$string.after_data_expiration));
            this.f16213b0.m15931c(string, new C11427b(this, C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement"));
            this.f16213b0.m15934g(resources.getString(R$string.gallery_basic_service_fixing_tips, string2), false);
            return;
        }
        if (iMo58370H != 1) {
            this.f16213b0.setVisibility(8);
        } else {
            this.f16213b0.setVisibility(0);
            this.f16213b0.setText(resources.getString(R$string.gallery_basic_service_fixing_tips, ""));
        }
    }

    /* renamed from: L3 */
    public final boolean m20521L3() {
        return C0209d.m1150A1(getApplicationContext());
    }

    /* renamed from: L4 */
    public final void m20522L4() {
        this.f16176B0.setVisibility(8);
        this.f16180D0.setVisibility(0);
        if (m20548i4() && this.f14819N0 != null) {
            m20512E4(false);
            this.f14819N0.dismiss();
        }
        m20511D4(true);
        GalleryDisableDialog galleryDisableDialog = new GalleryDisableDialog(this);
        this.f14829X0 = galleryDisableDialog;
        galleryDisableDialog.showDialog();
    }

    /* renamed from: M3 */
    public final void m20523M3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58468z0(getApplicationContext(), new C3302r());
        }
    }

    /* renamed from: M4 */
    public final void m20524M4() throws Resources.NotFoundException {
        if (m22434i2()) {
            return;
        }
        if (m20547h4()) {
            m20542Z3();
        }
        if (this.f14819N0 == null) {
            this.f14819N0 = new GalleryShelveDialog(this);
        }
        m20512E4(true);
        this.f14819N0.showDialog(this);
    }

    /* renamed from: O4 */
    public final void m20525O4(int i10) {
        ProgressDialog progressDialog = this.f14834c1;
        if (progressDialog == null) {
            this.f14834c1 = new ProgressDialog(this);
        } else if (progressDialog.isShowing()) {
            try {
                this.f14834c1.dismiss();
            } catch (Exception unused) {
                C11839m.m70687e("GalleryDetailActivity", "shelveProgressDialog dismiss error.");
            }
        }
        this.f14834c1.setMessage(getString(i10));
        this.f14834c1.setCanceledOnTouchOutside(false);
        this.f14834c1.setCancelable(false);
        try {
            this.f14834c1.show();
        } catch (Exception unused2) {
            C11839m.m70687e("GalleryDetailActivity", "shelveProgressDialog show error.");
        }
    }

    /* renamed from: P3 */
    public void m20526P3(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        if (isDestroyed() || isFinishing()) {
            C11839m.m70687e("GalleryDetailActivity", "activity is finishing.");
            return;
        }
        if (m20555q4()) {
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.f16195L;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        if (this.f16213b0 == null) {
            C11839m.m70687e("GalleryDetailActivity", "text view is null");
            return;
        }
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70688i("GalleryDetailActivity", "resources is null.");
            this.f16213b0.setVisibility(8);
            return;
        }
        if (!C13452e.m80781L().m80791C0()) {
            C11839m.m70688i("GalleryDetailActivity", "user is not base date service.");
            this.f16213b0.setVisibility(8);
            return;
        }
        this.f16213b0.setVisibility(0);
        long userdataExpiredTime = userDataStateInfo.getUserdataExpiredTime();
        if (userdataExpiredTime == 0) {
            m20520K4(resources);
            C11839m.m70689w("GalleryDetailActivity", "getParams from service fail");
        } else if (userdataExpiredTime - C12312h0.m74027b().m74028c() < 0) {
            C11839m.m70688i("GalleryDetailActivity", "The data has expired.");
            this.f16213b0.setText(resources.getString(R$string.gallery_basic_service_fixing_tips, ""));
        } else {
            String string = resources.getString(R$string.user_agreement_tips);
            String string2 = resources.getString(R$string.gallery_basic_service_tips2, string, C11290m.m67753n(resources, userdataExpiredTime, userDataStateInfo.getRemainDwnldDays()));
            this.f16213b0.m15931c(string, new C11427b(this, C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement"));
            this.f16213b0.m15934g(resources.getString(R$string.gallery_basic_service_fixing_tips, string2), false);
        }
    }

    /* renamed from: P4 */
    public final void m20527P4() {
        if (m20546g4()) {
            C11839m.m70688i("GalleryDetailActivity", "GalleryShelveSuccessDialogHasShow");
            return;
        }
        if (this.f14825T0 == null) {
            this.f14825T0 = new GalleryShelveSuccessDialog(this);
        }
        m20510C4(true);
        this.f14825T0.showDialog();
    }

    /* renamed from: Q3 */
    public final void m20528Q3() {
        ProgressDialog progressDialog = this.f14834c1;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
            } catch (Exception unused) {
                C11839m.m70687e("GalleryDetailActivity", "shelveProgressDialog dismiss error.");
            }
        }
    }

    /* renamed from: Q4 */
    public final void m20529Q4(String str) {
        if (this.f14828W0 == null) {
            this.f14828W0 = new UnShelveSpaceNotEnoughDialog(this, str);
        }
        this.f14828W0.showDialog();
    }

    /* renamed from: R3 */
    public final void m20530R3(boolean z10) {
        m20525O4(R$string.cloudbackup_loading);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58359B0(getApplicationContext(), z10, new C3292h());
        }
    }

    /* renamed from: S4 */
    public final void m20531S4() throws Resources.NotFoundException {
        C11839m.m70688i("GalleryDetailActivity", "updateDownloadStatus saveOriginalFileStatus:" + this.f14837f1 + ",downloadNums:" + this.f14839h1);
        int i10 = this.f14837f1;
        if (i10 == 0) {
            m20535U4(3);
            return;
        }
        if (i10 == 1) {
            m20535U4(5);
            return;
        }
        if (i10 == 2) {
            m20535U4(0);
            return;
        }
        if (i10 == 3) {
            m20535U4(2);
            return;
        }
        if (i10 == 4) {
            m20535U4(6);
        } else if (i10 == 5 || i10 == 7) {
            m20535U4(1);
        } else {
            m20535U4(3);
        }
    }

    /* renamed from: T3 */
    public final void m20532T3() {
        if (getResources() == null) {
            return;
        }
        if (!"zh".equals(C0234s.m1636n())) {
            C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, language code is not zh");
            return;
        }
        String newBusinessModelConfig = HiCloudSysParamMapCache.getNewBusinessModelConfig();
        if (newBusinessModelConfig == null || TextUtils.isEmpty(newBusinessModelConfig)) {
            C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, configString is null or empty");
            return;
        }
        final NewBusinessModelConfigBean newBusinessModelConfigBean = (NewBusinessModelConfigBean) C10527a.m64629g(newBusinessModelConfig, NewBusinessModelConfigBean.class);
        if (newBusinessModelConfigBean == null) {
            C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, configBean is null");
            return;
        }
        if (!TextUtils.isEmpty(newBusinessModelConfigBean.getGalleryFaqDeleteCloudOnly())) {
            C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, getGalleryFaqDeleteCloudOnly exist");
            this.f16215d0.setVisibility(0);
            this.f16218g0.setVisibility(0);
            this.f16216e0.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.i5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f17636a.m20552m4(newBusinessModelConfigBean, view);
                }
            });
            C13227f.m79492i1().m79585f0("mecloud_switch_to_delete_could_album_only_info", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_switch_to_delete_could_album_only_info", "1", "94");
        }
        if (TextUtils.isEmpty(newBusinessModelConfigBean.getGalleryFaqDeleteLocalOnly())) {
            return;
        }
        C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, getGalleryFaqDeleteLocalOnly exist");
        this.f16215d0.setVisibility(0);
        this.f16219h0.setVisibility(0);
        this.f16217f0.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.j5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17647a.m20553n4(newBusinessModelConfigBean, view);
            }
        });
        C13227f.m79492i1().m79585f0("mecloud_switch_to_delete_local__album_only_info", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_switch_to_delete_local__album_only_info", "1", "95");
    }

    /* renamed from: T4 */
    public final void m20533T4(int i10, Bundle bundle) throws Resources.NotFoundException {
        if (bundle == null) {
            return;
        }
        C11839m.m70688i("GalleryDetailActivity", "updateShelveDownloadCallback:" + i10);
        if (i10 != 10000) {
            return;
        }
        this.f14837f1 = bundle.getInt("SaveOriginalStatus");
        this.f14839h1 = bundle.getInt("HaveAnotherNum");
        C11839m.m70688i("GalleryDetailActivity", "updateShelveDownloadCallback saveOriginalFileStatus:" + this.f14837f1 + ",downloadNums:" + this.f14839h1);
        m20531S4();
    }

    /* renamed from: U3 */
    public final void m20534U3() {
        Intent intent = new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class);
        intent.putExtra("data_cached_refresh", this.f14845n1);
        C13230i.m79525e1(intent, "1", "14");
        setResult(0, intent);
    }

    /* renamed from: U4 */
    public final void m20535U4(int i10) throws Resources.NotFoundException {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null && !interfaceC9282a.mo58398V()) {
            this.f16176B0.setVisibility(8);
            this.f16180D0.setVisibility(0);
            this.f16178C0.setVisibility(8);
            this.f16182E0.setVisibility(8);
            return;
        }
        if (i10 == 0) {
            this.f14832a1 = false;
            String string = getString(R$string.gallery_shelve_downloading_tip_global);
            if (this.f14849r1) {
                this.f16176B0.setVisibility(8);
                this.f16178C0.setVisibility(8);
                this.f16182E0.setVisibility(0);
                m20513F4(this.f16182E0, string, getString(R$string.gallery_shelve_download_check_global, string));
                return;
            }
            this.f16176B0.setVisibility(8);
            this.f16182E0.setVisibility(8);
            this.f16178C0.setVisibility(0);
            this.f16178C0.setText(getString(R$string.gallery_shelve_download_check_tip_global, string));
            return;
        }
        if (i10 == 1) {
            this.f14832a1 = false;
            Resources resources = getResources();
            int i11 = R$plurals.general_download_pause_tip_global;
            int i12 = this.f14839h1;
            String quantityString = resources.getQuantityString(i11, i12, Integer.valueOf(i12));
            if (this.f14849r1) {
                this.f16176B0.setVisibility(8);
                this.f16178C0.setVisibility(8);
                this.f16182E0.setVisibility(0);
                m20513F4(this.f16182E0, quantityString, getString(R$string.gallery_shelve_download_check_global, quantityString));
                return;
            }
            this.f16176B0.setVisibility(8);
            this.f16182E0.setVisibility(8);
            this.f16178C0.setVisibility(0);
            this.f16178C0.setText(getString(R$string.gallery_shelve_download_check_tip_global, quantityString));
            return;
        }
        if (i10 == 2) {
            this.f16178C0.setVisibility(0);
            this.f16178C0.setText(getString(R$string.general_download_completed_tip));
            this.f16182E0.setVisibility(8);
            this.f16176B0.setVisibility(8);
            return;
        }
        if (i10 == 3) {
            m20544d4();
            this.f16178C0.setVisibility(8);
            this.f16176B0.setEnabled(true);
            this.f16176B0.setAlpha(1.0f);
            this.f16182E0.setVisibility(8);
            return;
        }
        if (i10 == 5) {
            this.f16176B0.setVisibility(8);
            this.f16178C0.setVisibility(0);
            this.f16182E0.setVisibility(8);
            this.f16178C0.setText(getString(R$string.gallery_shelve_sync_completed_add_task));
            return;
        }
        if (i10 != 6) {
            return;
        }
        Resources resources2 = getResources();
        int i13 = R$plurals.general_download_pause_tip_global;
        int i14 = this.f14839h1;
        String quantityString2 = resources2.getQuantityString(i13, i14, Integer.valueOf(i14));
        this.f16176B0.setVisibility(8);
        this.f16178C0.setVisibility(8);
        this.f16182E0.setVisibility(0);
        m20513F4(this.f16182E0, quantityString2, getString(R$string.gallery_shelve_download_continue_global, quantityString2));
        this.f14832a1 = true;
    }

    /* renamed from: V3 */
    public final void m20536V3() throws IllegalAccessException, IllegalArgumentException {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f14824S0 = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14824S0.setCanceledOnTouchOutside(false);
        this.f14824S0.setTitle(getString(R$string.gallery_shelve_use_mobile_network));
        m20545e4(C0223k.m1524g(getApplicationContext(), this.f14840i1));
        this.f14824S0.setButton(-2, getString(R$string.gallery_shelve_cancel), new DialogInterfaceOnClickListenerC3296l());
        this.f14824S0.setButton(-1, getString(R$string.gallery_shelve_use_mobile_network_confirm), new DialogInterfaceOnClickListenerC3297m());
        this.f14824S0.show();
    }

    /* renamed from: W3 */
    public final void m20537W3(Message message) throws Resources.NotFoundException {
        this.f16242w0.setEnabled(true);
        this.f16242w0.setAlpha(1.0f);
        Object obj = message.obj;
        if (obj == null) {
            this.f14850s1 = true;
            return;
        }
        Bundle bundle = (Bundle) obj;
        long j10 = bundle.getLong("photoTotalSize");
        long j11 = bundle.getLong("recycleTotalSize");
        int i10 = bundle.getInt(C5963j.f27041j);
        if (i10 == 0) {
            this.f14836e1 = 0;
            this.f14837f1 = 0;
            this.f14842k1 = C0223k.m1524g(this, j11);
            long j12 = j10 + j11;
            this.f14841j1 = C0223k.m1524g(this, j12);
            C11839m.m70688i("GalleryDetailActivity", "SHELVE_CANCEL totalSize:" + j12 + " totalSizeStr:" + this.f14841j1);
            m20470V4();
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
            C13368e.m80184F().m80208B0(j10, j11);
            C1006a.m5936k().m5954R(this, 0, 0L);
            this.f14845n1 = true;
        } else if (4 == i10) {
            C11839m.m70688i("GalleryDetailActivity", "SHELVE_CANCEL Dialog  photoSize:" + j10 + " deleteSize:" + j11);
            m20529Q4(C0223k.m1524g(this, j10 + j11));
        } else {
            C11839m.m70687e("GalleryDetailActivity", "Cloud gallery cancel shelve failed:" + i10);
        }
        this.f14850s1 = true;
    }

    /* renamed from: W4 */
    public final void m20538W4() throws Resources.NotFoundException {
        if (TextUtils.isEmpty(this.f14841j1)) {
            C11839m.m70687e("GalleryDetailActivity", "Cloud gallery totalSize is null");
            return;
        }
        if (this.f14836e1 == 0) {
            this.f16240v0.setText(getResources().getString(R$string.gallery_shelve_explain, getResources().getQuantityString(R$plurals.gallery_shelve_left_days, C2783d.m16162n(), Integer.valueOf(C2783d.m16162n()))));
            m20516I4();
            this.f16240v0.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(this.f14842k1)) {
            C11839m.m70687e("GalleryDetailActivity", "Cloud gallery deleteSize is null");
            return;
        }
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(R$string.gallery_item_title)));
        if (this.f14836e1 == 1) {
            this.f16199N.setVisibility(8);
            this.f16200O.setVisibility(8);
            this.f16201P.setVisibility(8);
        }
        this.f16201P.setText(this.f14841j1);
        this.f16205T.setText(this.f14842k1);
    }

    /* renamed from: X3 */
    public final void m20539X3() throws IllegalAccessException, IllegalArgumentException {
        if (this.f14850s1) {
            C13227f.m79492i1().m79585f0("mecloud_gallery_mng_click_canceldownload", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_gallery_mng_click_canceldownload", "1", "3");
            if (!this.f14832a1) {
                if (this.f14849r1) {
                    m20517J3();
                }
            } else if (m20521L3()) {
                m20523M3();
            } else if (!C0209d.m1333z1(this)) {
                m20518J4();
            } else {
                if (m20549j4()) {
                    return;
                }
                C1006a.m5936k().m5942F(getApplicationContext(), 3);
            }
        }
    }

    /* renamed from: Y3 */
    public final void m20540Y3(Message message) throws Resources.NotFoundException {
        m20528Q3();
        Object obj = message.obj;
        if (obj == null) {
            return;
        }
        int i10 = ((Bundle) obj).getInt(C5963j.f27041j);
        if (i10 != 0 && 30 != i10) {
            C11839m.m70687e("GalleryDetailActivity", "Cloud gallery shelve failed:" + i10);
            return;
        }
        this.f14836e1 = 1;
        this.f14837f1 = 0;
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (i10 == 0) {
            this.f14838g1 = C2783d.m16162n();
            m20470V4();
            C1006a.m5936k().m5954R(this, this.f14836e1, System.currentTimeMillis() + 2592000000L);
            m20462N4();
        }
        if (interfaceC9282a != null) {
            if (interfaceC9282a.mo58398V()) {
                m20527P4();
            } else if (30 == i10) {
                this.f14853v1 = true;
            } else {
                m20522L4();
            }
        }
        C13368e.m80184F().m80253r0();
        C13368e.m80184F().m80250o0();
        C13368e.m80184F().m80208B0(0L, 0L);
        this.f14845n1 = true;
        m20502v4();
    }

    /* renamed from: Y4 */
    public final void m20541Y4() {
        C13195l.m79272J().m79324o(this, C13452e.m80781L().m80905e(), 8907, this.f14854w1);
    }

    /* renamed from: Z3 */
    public void m20542Z3() {
        if (this.f14829X0 != null) {
            m20511D4(false);
            this.f14829X0.dismiss();
            this.f16180D0.setVisibility(0);
            this.f16176B0.setVisibility(8);
        }
    }

    /* renamed from: b4 */
    public final void m20543b4() {
        Intent intent = new Intent("com.huawei.gallery.app.photoshare.download.list");
        C0209d.m1302r2(intent, C13843a.m83054F(this));
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            this.f14849r1 = false;
        } else {
            this.f14849r1 = true;
        }
    }

    /* renamed from: d4 */
    public final void m20544d4() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            if (interfaceC9282a.mo58398V()) {
                this.f16176B0.setVisibility(0);
                this.f16180D0.setVisibility(8);
            } else {
                this.f16176B0.setVisibility(8);
                this.f16180D0.setVisibility(0);
            }
        }
    }

    /* renamed from: e4 */
    public final void m20545e4(String str) {
        boolean zM5978y = C1006a.m5936k().m5978y();
        AlertDialog alertDialog = this.f14824S0;
        if (alertDialog == null) {
            C11839m.m70687e("GalleryDetailActivity", "mobileNetworkDialog is null");
        } else if (zM5978y) {
            alertDialog.setMessage(getString(C0209d.m1167E2(R$string.gallery_shelve_use_mobile_network_wlan_dialog_msg, R$string.gallery_shelve_use_mobile_network_wifi_dialog_msg), str));
        } else {
            alertDialog.setMessage(getString(C0209d.m1167E2(R$string.gallery_shelve_use_mobile_network_mobileswitchon_wlan_dialog_msg, R$string.gallery_shelve_use_mobile_network_mobileswitchon_wifi_dialog_msg), str));
        }
    }

    /* renamed from: g4 */
    public boolean m20546g4() {
        return this.f14826U0;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C1006a.m5936k().m5975v(this);
    }

    /* renamed from: h4 */
    public boolean m20547h4() {
        return this.f14851t1;
    }

    /* renamed from: i4 */
    public boolean m20548i4() {
        return this.f14852u1;
    }

    /* renamed from: j4 */
    public final boolean m20549j4() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
            return false;
        }
        if (!interfaceC9282a.mo58456t0(getApplicationContext())) {
            return false;
        }
        C11841o.m70706b(this, getString(R$string.gallery_shelve_battery_low, C2783d.m16144h(10)), 0);
        return true;
    }

    /* renamed from: k4 */
    public final void m20550k4(String str) {
        Intent intent = new Intent();
        intent.putExtra("useMargin", true);
        C11273b.m67657l(this, str, new SafeIntent(intent), getPackageName());
        C13227f.m79492i1().m79585f0("mecloud_gallery_delete_cloud_only_info", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("CKC", "mecloud_gallery_delete_cloud_only_info", "1", "94");
    }

    /* renamed from: l4 */
    public final void m20551l4(String str) {
        Intent intent = new Intent();
        intent.putExtra("useMargin", true);
        C11273b.m67657l(this, str, new SafeIntent(intent), getPackageName());
        C13227f.m79492i1().m79585f0("mecloud_gallery_delete_local_only_info", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("CKC", "mecloud_gallery_delete_local_only_info", "1", "95");
    }

    /* renamed from: m4 */
    public final /* synthetic */ void m20552m4(NewBusinessModelConfigBean newBusinessModelConfigBean, View view) {
        m20550k4(newBusinessModelConfigBean.getGalleryFaqDeleteCloudOnly());
        C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, getGalleryFaqDeleteCloudOnly success");
    }

    /* renamed from: n4 */
    public final /* synthetic */ void m20553n4(NewBusinessModelConfigBean newBusinessModelConfigBean, View view) {
        m20551l4(newBusinessModelConfigBean.getGalleryFaqDeleteLocalOnly());
        C11839m.m70688i("GalleryDetailActivity", "getDelAlbumDataInfo, getGalleryFaqDeleteLocalOnly success");
    }

    /* renamed from: o4 */
    public final /* synthetic */ void m20554o4() {
        this.f16216e0.setVisibility(8);
        this.f16217f0.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8907) {
            C13195l.m79272J().m79297M(this, this.f14854w1, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m20534U3();
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        int id2 = view.getId();
        int i10 = R$id.general_shelve_btn;
        if (id2 != i10 && id2 != R$id.general_cancel_shelve_btn && id2 != R$id.general_download_textview) {
            super.onClick(view);
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("GalleryDetailActivity", "fast click");
            return;
        }
        if (i10 == id2) {
            C11839m.m70688i("GalleryDetailActivity", "shelve button onclick");
            C13227f.m79492i1().m79585f0("mecloud_gallery_mng_click_stop", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_gallery_mng_click_stop", "1", "15");
            m20524M4();
            return;
        }
        if (R$id.general_cancel_shelve_btn == id2) {
            C11839m.m70688i("GalleryDetailActivity", "cancleShelve button onclick");
            C13227f.m79492i1().m79585f0("mecloud_gallery_mng_click_cancelstop", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_gallery_mng_click_cancelstop", "1", "15");
            m20561y4();
            return;
        }
        if (R$id.general_download_textview == id2 && this.f14850s1) {
            C13227f.m79492i1().m79585f0("mecloud_gallery_mng_click_download", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_gallery_mng_click_download", "1", "15");
            m20519K3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f16244x0);
        C11842p.m70874v1(this, this.f16242w0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C11839m.m70688i("GalleryDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(true);
        m20484f4();
        m20473X4();
        m20477a4();
        boolean booleanExtra = new HiCloudSafeIntent(getIntent()).getBooleanExtra("gallery_from_hisync", false);
        this.f14847p1 = booleanExtra;
        this.f14846o1 = booleanExtra;
        this.f14848q1 = C10155f.m63299w();
        C11839m.m70686d("GalleryDetailActivity", "isCloudphotoManagerEnable isEnable " + this.f14848q1);
        this.f16221j0.setVisibility(this.f14848q1 ? 0 : 8);
        this.f16224m0.setVisibility(this.f14848q1 ? 0 : 8);
        if (this.f14848q1) {
            C11737b.m70035b().m70036a(this.f14856y1);
        }
        m20504w4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("GalleryDetailActivity", "onDestroy");
        this.f14857z1.removeCallbacksAndMessages(null);
        m20464R4();
        m20560x4();
        if (this.f14848q1) {
            C11737b.m70035b().m70041g(this.f14856y1);
        }
        this.f14855x1 = null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m20534U3();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58361C0(this);
        } else {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m20480c4();
        this.f14846o1 = false;
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58374J(this, this.f14855x1);
        } else {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
        }
        m20466S3();
    }

    /* renamed from: q4 */
    public final boolean m20555q4() {
        InterfaceC9282a interfaceC9282a;
        if (C13452e.m80781L().m80791C0() && (interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)) != null) {
            return (interfaceC9282a.mo58370H() == 0 && interfaceC9282a.mo58409a0() == 0) ? false : true;
        }
        return false;
    }

    /* renamed from: r4 */
    public void m20556r4() throws IllegalAccessException, IllegalArgumentException {
        C13227f.m79492i1().m79585f0("mecloud_gallery_mng_click_download", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_gallery_mng_click_download", "1", "3");
        m20519K3();
    }

    /* renamed from: s4 */
    public void m20557s4() {
        m20541Y4();
        C13227f.m79492i1().m79585f0("mecloud_gallery_mng_click_stop_deletephotos", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_gallery_mng_click_stop_deletephotos", "4", "15");
    }

    /* renamed from: t4 */
    public void m20558t4() {
        Bundle bundle = new Bundle();
        C13230i.m79522d1(bundle, "1", "14");
        C12126b.m72707c(C13222a.m79465g(this), bundle);
    }

    /* renamed from: u4 */
    public final void m20559u4(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        if (C1006a.m5936k().m5975v(this)) {
            m20530R3(z10);
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f14823R0 = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14823R0.setCanceledOnTouchOutside(false);
        this.f14823R0.setMessage(getString(R$string.gallery_shelve_cg_switch_open_tip));
        this.f14823R0.setButton(-1, getString(R$string.gallery_shelve_cg_switch_open), new DialogInterfaceOnClickListenerC3290f(z10));
        this.f14823R0.setButton(-2, getString(R$string.gallery_shelve_cancel), new DialogInterfaceOnClickListenerC3291g());
        this.f14823R0.show();
    }

    /* renamed from: x4 */
    public final void m20560x4() {
        if (this.f14819N0 != null) {
            try {
                m20512E4(false);
                this.f14819N0.dismiss();
                this.f14819N0 = null;
            } catch (Exception unused) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        ProgressDialog progressDialog = this.f14834c1;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
                this.f14834c1 = null;
            } catch (Exception unused2) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        ProgressDialog progressDialog2 = this.f14835d1;
        if (progressDialog2 != null) {
            try {
                progressDialog2.dismiss();
                this.f14835d1 = null;
            } catch (Exception unused3) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        UnShelveSpaceNotEnoughDialog unShelveSpaceNotEnoughDialog = this.f14828W0;
        if (unShelveSpaceNotEnoughDialog != null) {
            try {
                unShelveSpaceNotEnoughDialog.dismiss();
                this.f14828W0 = null;
            } catch (Exception unused4) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        GalleryShelveRequestResultTip galleryShelveRequestResultTip = this.f14844m1;
        if (galleryShelveRequestResultTip != null) {
            try {
                galleryShelveRequestResultTip.dismiss();
                this.f14844m1 = null;
            } catch (Exception unused5) {
                C11839m.m70687e("GalleryDetailActivity", "Dialog release error");
            }
        }
        m20461N3();
    }

    /* renamed from: y4 */
    public final void m20561y4() {
        if (m22434i2()) {
            return;
        }
        this.f16242w0.setAlpha(0.62f);
        this.f16242w0.setEnabled(false);
        this.f14850s1 = false;
        C1006a.m5936k().m5950N(new C3294j(), getApplicationContext());
    }

    /* renamed from: z4 */
    public final void m20562z4() {
        if (!C0209d.m1333z1(this)) {
            this.f16192J0.m23919i();
            return;
        }
        this.f16192J0.m23914a();
        m20525O4(R$string.gallery_shelve_handling);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryDetailActivity", "cloudAlbumRouterImpl is null");
        } else {
            C11839m.m70688i("GalleryDetailActivity", "requestShelve");
            interfaceC9282a.mo58403X0(new C3293i());
        }
    }
}
