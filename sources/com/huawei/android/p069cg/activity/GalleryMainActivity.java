package com.huawei.android.p069cg.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity;
import com.huawei.android.hicloud.p088ui.common.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.notification.GalleryShelveNotification;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.router.data.SwitchInfo;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import gp.C10028c;
import hk.C10278a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0224k0;
import p020ap.C1006a;
import p020ap.C1007b;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p031b7.C1137r;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9283b;
import p232dp.InterfaceC9284c;
import p232dp.InterfaceC9285d;
import p251e8.C9423b;
import p336he.C10155f;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11079e;
import p454lj.C11290m;
import p472m7.C11427b;
import p486n6.AlertDialogC11640e;
import p486n6.AlertDialogC11641f;
import p486n6.AlertDialogC11642g;
import p486n6.AlertDialogC11649n;
import p486n6.C11647l;
import p496nn.C11737b;
import p496nn.InterfaceC11736a;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p674ub.C13149f;
import p676ud.AbstractC13155b;
import p676ud.AlertDialogC13157d;
import p684un.C13222a;
import p684un.C13224c;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;
import p850zo.InterfaceC14352c;
import sk.C12809f;

/* loaded from: classes2.dex */
public class GalleryMainActivity extends HMSTermsProcessBaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: A */
    public UnionSwitch f10054A;

    /* renamed from: A0 */
    public RelativeLayout f10055A0;

    /* renamed from: B */
    public TextView f10056B;

    /* renamed from: B0 */
    public NotchFitRelativeLayout f10057B0;

    /* renamed from: C */
    public TextView f10058C;

    /* renamed from: C0 */
    public View f10059C0;

    /* renamed from: D */
    public TextView f10060D;

    /* renamed from: D0 */
    public RelativeLayout f10061D0;

    /* renamed from: E */
    public HwProgressBar f10062E;

    /* renamed from: E0 */
    public AlbumShareReceiver f10063E0;

    /* renamed from: F */
    public LinearLayout f10064F;

    /* renamed from: F0 */
    public SpanClickText f10065F0;

    /* renamed from: G */
    public SpanClickText f10066G;

    /* renamed from: G0 */
    public View f10067G0;

    /* renamed from: H */
    public HiCloudExceptionView f10068H;

    /* renamed from: I */
    public AlertDialogC11641f f10070I;

    /* renamed from: J */
    public AlertDialogC11642g f10072J;

    /* renamed from: K */
    public AlertDialogC11640e f10074K;

    /* renamed from: L */
    public AlertDialogC11649n f10076L;

    /* renamed from: N */
    public int f10080N;

    /* renamed from: N0 */
    public String f10081N0;

    /* renamed from: O */
    public boolean f10082O;

    /* renamed from: O0 */
    public C2199q f10083O0;

    /* renamed from: P */
    public View f10084P;

    /* renamed from: P0 */
    public C2198p f10085P0;

    /* renamed from: Q */
    public NotchFitLinearLayout f10086Q;

    /* renamed from: R */
    public AlertDialogC13157d f10088R;

    /* renamed from: R0 */
    public String f10089R0;

    /* renamed from: T */
    public AbstractC13155b f10092T;

    /* renamed from: W */
    public int f10097W;

    /* renamed from: X */
    public int f10098X;

    /* renamed from: Y */
    public boolean f10099Y;

    /* renamed from: Z */
    public RelativeLayout f10100Z;

    /* renamed from: c0 */
    public boolean f10103c0;

    /* renamed from: d0 */
    public RelativeLayout f10104d0;

    /* renamed from: h0 */
    public TextView f10108h0;

    /* renamed from: i0 */
    public TextView f10109i0;

    /* renamed from: j0 */
    public TextView f10110j0;

    /* renamed from: k0 */
    public TextView f10111k0;

    /* renamed from: l0 */
    public TextView f10112l0;

    /* renamed from: m0 */
    public TextView f10113m0;

    /* renamed from: n0 */
    public String f10114n0;

    /* renamed from: o0 */
    public String f10115o0;

    /* renamed from: p0 */
    public String f10117p0;

    /* renamed from: q0 */
    public String f10119q0;

    /* renamed from: r */
    public RelativeLayout f10120r;

    /* renamed from: r0 */
    public String f10121r0;

    /* renamed from: s */
    public LinearLayout f10122s;

    /* renamed from: s0 */
    public String f10123s0;

    /* renamed from: t */
    public DisableSupportedRelativeLayout f10124t;

    /* renamed from: t0 */
    public String f10125t0;

    /* renamed from: u */
    public NotchFitLinearLayout f10126u;

    /* renamed from: u0 */
    public String f10127u0;

    /* renamed from: v */
    public UnionSwitch f10128v;

    /* renamed from: v0 */
    public String f10129v0;

    /* renamed from: w */
    public RelativeLayout f10130w;

    /* renamed from: w0 */
    public DisableSupportedRelativeLayout f10131w0;

    /* renamed from: x */
    public DisableSupportedRelativeLayout f10132x;

    /* renamed from: x0 */
    public boolean f10133x0;

    /* renamed from: y */
    public NotchFitRelativeLayout f10134y;

    /* renamed from: y0 */
    public RelativeLayout f10135y0;

    /* renamed from: z */
    public UnionSwitch f10136z;

    /* renamed from: z0 */
    public HwButton f10137z0;

    /* renamed from: p */
    public final int f10116p = 466;

    /* renamed from: q */
    public final int f10118q = ErrorCode.ERROR_SIGTOOL_FAIL;

    /* renamed from: M */
    public boolean f10078M = false;

    /* renamed from: S */
    public C13149f f10090S = new C13149f();

    /* renamed from: U */
    public RecommendCardReport f10094U = new RecommendCardReport();

    /* renamed from: V */
    public int f10096V = -2;

    /* renamed from: a0 */
    public boolean f10101a0 = true;

    /* renamed from: b0 */
    public boolean f10102b0 = false;

    /* renamed from: e0 */
    public boolean f10105e0 = false;

    /* renamed from: f0 */
    public boolean f10106f0 = false;

    /* renamed from: g0 */
    public boolean f10107g0 = false;

    /* renamed from: H0 */
    public int f10069H0 = 0;

    /* renamed from: I0 */
    public boolean f10071I0 = false;

    /* renamed from: J0 */
    public boolean f10073J0 = false;

    /* renamed from: K0 */
    public boolean f10075K0 = false;

    /* renamed from: L0 */
    public boolean f10077L0 = false;

    /* renamed from: M0 */
    public boolean f10079M0 = false;

    /* renamed from: Q0 */
    public int f10087Q0 = 0;

    /* renamed from: S0 */
    public Handler f10091S0 = new HandlerC2187e();

    /* renamed from: T0 */
    public InterfaceC11736a f10093T0 = new C2188f();

    /* renamed from: U0 */
    public Handler f10095U0 = new HandlerC2192j();

    public class AlbumShareReceiver extends BroadcastReceiver {
        public AlbumShareReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("GalleryMainActivity", "intent is null.");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("com.huawei.hicloud.getCloudPhotoTotalSize".equals(safeIntent.getAction())) {
                String stringExtra = safeIntent.getStringExtra("param_pic_and_video_content");
                C1120a.m6675d("GalleryMainActivity", "picAndViedoStr " + stringExtra);
                GalleryMainActivity.this.f10113m0.setText(stringExtra);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$a */
    public class C2183a implements InterfaceC14351b {
        public C2183a() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            Message messageObtain = Message.obtain();
            messageObtain.setData(bundle);
            messageObtain.what = 1002;
            messageObtain.arg1 = 1;
            GalleryMainActivity.this.f10091S0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$b */
    public class C2184b implements InterfaceC14352c {
        public C2184b() {
        }

        @Override // p850zo.InterfaceC14352c
        /* renamed from: a */
        public void mo13561a(int i10, long j10) {
            GalleryMainActivity.this.f10098X = i10;
            GalleryMainActivity.this.f10095U0.sendEmptyMessage(1);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$c */
    public class C2185c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ boolean f10141a;

        public C2185c(boolean z10) {
            this.f10141a = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1122c.m6816o2(500L);
            Bundle bundle = new Bundle();
            bundle.putBoolean("haveMediaFile", this.f10141a);
            Message messageObtain = Message.obtain();
            messageObtain.setData(bundle);
            messageObtain.what = 1004;
            GalleryMainActivity.this.f10091S0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$d */
    public class C2186d extends AbstractC12367d {
        public C2186d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            GalleryMainActivity.this.m13520W2();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$e */
    public class HandlerC2187e extends Handler {
        public HandlerC2187e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException, SQLException {
            int i10 = message.what;
            if (1002 == i10) {
                GalleryMainActivity.this.m13555u3(message.getData().getBoolean("haveMediaFile"), message.arg1 == 0);
                return;
            }
            if (1004 == i10) {
                boolean z10 = message.getData().getBoolean("haveMediaFile");
                C1120a.m6677i("GalleryMainActivity", "isExistLocalFile check show toast:" + z10);
                if (z10) {
                    GalleryMainActivity galleryMainActivity = GalleryMainActivity.this;
                    C11841o.m70706b(galleryMainActivity, galleryMainActivity.getString(R$string.gallery_switch_open_localdata_toast_msg), 1);
                } else {
                    GalleryMainActivity galleryMainActivity2 = GalleryMainActivity.this;
                    C11841o.m70706b(galleryMainActivity2, galleryMainActivity2.getString(R$string.gallery_switch_open_no_localdata_toast_msg), 0);
                }
                if (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(GalleryMainActivity.this.f10089R0)) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1006;
                    sendMessageDelayed(messageObtain, 3000L);
                    RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, false, false);
                }
                if (GalleryMainActivity.this.f10069H0 == 5) {
                    RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, false, false);
                    return;
                }
                return;
            }
            if (1006 == i10) {
                GalleryMainActivity.this.m13538h4();
                return;
            }
            if (1003 == i10) {
                GalleryMainActivity.this.m13534e4(message.getData());
                return;
            }
            if (1005 == i10) {
                GalleryMainActivity.this.m13480B3();
                return;
            }
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C1120a.m6677i("GalleryMainActivity", "handleMessage cloudAlbumRouter is null");
            }
            Object obj = message.obj;
            Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
            if (bundle == null) {
                C1120a.m6676e("GalleryMainActivity", "handleMessage bundle is null");
                return;
            }
            if (interfaceC9282a == null || !interfaceC9282a.mo58441m()) {
                int i11 = message.what;
                if (i11 != 8003) {
                    GalleryMainActivity.this.m13532d4(i11, bundle);
                    return;
                } else {
                    if (interfaceC9282a == null || !interfaceC9282a.mo58373I0()) {
                        return;
                    }
                    GalleryMainActivity.this.m13542j4(bundle);
                    return;
                }
            }
            int i12 = message.what;
            if (i12 == 9097) {
                C1120a.m6675d("GalleryMainActivity", "handleMessage, SYNC_PROMPT_UPDATE: " + message.what);
                GalleryMainActivity.this.m13532d4(ConnectionResult.NETWORK_ERROR, bundle);
                return;
            }
            if (i12 != 9099 || GalleryMainActivity.this.m13537h3()) {
                return;
            }
            GalleryMainActivity.this.m13488F3();
            GalleryMainActivity.this.m13527a3();
            GalleryMainActivity.this.m13495J2();
            if (GalleryMainActivity.this.f10128v != null) {
                GalleryMainActivity.this.f10128v.setCheckedProgrammatically(false);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$f */
    public class C2188f implements InterfaceC11736a {
        public C2188f() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: a */
        public void mo13316a() {
            C1120a.m6677i("GalleryMainActivity", "onAlbumChanged");
            GalleryMainActivity.this.m13522X2();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: b */
        public void mo13317b() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: c */
        public void mo13318c() {
            C1120a.m6677i("GalleryMainActivity", "onMediaChanged");
            GalleryMainActivity.this.m13522X2();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: d */
        public void mo13319d() {
            C1120a.m6677i("GalleryMainActivity", "onDownloadSyncCompleted");
            GalleryMainActivity.this.m13522X2();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$g */
    public class ViewTreeObserverOnPreDrawListenerC2189g implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC2189g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int measuredHeight = GalleryMainActivity.this.f10100Z.getMeasuredHeight();
            int measuredWidth = GalleryMainActivity.this.f10100Z.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = GalleryMainActivity.this.f10059C0.getLayoutParams();
            layoutParams.width = measuredWidth;
            layoutParams.height = measuredHeight;
            GalleryMainActivity.this.m13495J2();
            GalleryMainActivity.this.f10059C0.setLayoutParams(layoutParams);
            GalleryMainActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
            C1120a.m6677i("GalleryMainActivity", "onPreview width:" + measuredWidth + " height:" + measuredHeight);
            return false;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$h */
    public class DialogInterfaceOnDismissListenerC2190h implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC2190h() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GalleryMainActivity.this.f10102b0 = false;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$i */
    public class C2191i implements InterfaceC14351b {
        public C2191i() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            GalleryMainActivity.this.m13486E3();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$j */
    public class HandlerC2192j extends Handler {
        public HandlerC2192j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            if (GalleryMainActivity.this.isFinishing()) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                GalleryMainActivity.this.m13544k4();
            } else if (i10 == 1) {
                if (GalleryMainActivity.this.f10098X > 0) {
                    GalleryMainActivity.this.m13528a4();
                } else {
                    GalleryMainActivity.this.m13553s3();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$k */
    public class C2193k implements InterfaceC14350a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9282a f10150a;

        public C2193k(InterfaceC9282a interfaceC9282a) {
            this.f10150a = interfaceC9282a;
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: a */
        public void mo13562a() {
            this.f10150a.mo58439l(GalleryMainActivity.this, 0, 0L);
            GalleryMainActivity.this.f10096V = 0;
            GalleryMainActivity.this.f10095U0.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: b */
        public void mo13563b() {
            GalleryMainActivity.this.f10096V = -2;
            GalleryMainActivity.this.f10095U0.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: c */
        public void mo13564c() {
            this.f10150a.mo58439l(GalleryMainActivity.this, -1, 0L);
            GalleryMainActivity.this.f10096V = -1;
            GalleryMainActivity.this.f10095U0.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: d */
        public void mo13565d(int i10, int i11, long j10, int i12) {
            this.f10150a.mo58439l(GalleryMainActivity.this, 1, j10);
            GalleryMainActivity.this.f10099Y = i10 == 3;
            GalleryMainActivity.this.f10096V = 1;
            GalleryMainActivity.this.f10098X = i11;
            GalleryMainActivity galleryMainActivity = GalleryMainActivity.this;
            galleryMainActivity.f10097W = C1122c.m6683B0(galleryMainActivity);
            GalleryMainActivity.this.f10095U0.sendEmptyMessage(0);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$l */
    public class C2194l implements SpanClickText.ISpanClickListener {

        /* renamed from: a */
        public final /* synthetic */ SpanClickText f10152a;

        public C2194l(SpanClickText spanClickText) {
            this.f10152a = spanClickText;
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
        public void onClick() {
            if (this.f10152a != null) {
                GalleryMainActivity.this.m13524Y2();
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$m */
    public class C2195m implements InterfaceC14351b {
        public C2195m() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            Message messageObtain = Message.obtain();
            messageObtain.setData(bundle);
            messageObtain.what = 1002;
            messageObtain.arg1 = 0;
            GalleryMainActivity.this.f10091S0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$n */
    public static class C2196n extends AbstractC12367d {
        public C2196n() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1120a.m6677i("GalleryMainActivity", "CheckFileCacheTask");
            try {
                Context contextM1378b = C0213f.m1378b();
                C1120a.m6677i("GalleryMainActivity", "CheckFileCacheTask externalFileSize = " + C1122c.m6830s0(C10278a.m63441g(contextM1378b.getExternalFilesDir(""), ".core_asset")) + ", fileSize = " + C1122c.m6830s0(C10278a.m63441g(contextM1378b.getFilesDir(), ".core_asset")));
            } catch (Exception e10) {
                C1120a.m6676e("GalleryMainActivity", "CheckFileCacheTask error: " + e10);
            }
        }

        public /* synthetic */ C2196n(HandlerC2187e handlerC2187e) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$o */
    public static class ViewTreeObserverOnPreDrawListenerC2197o implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        public TextView f10155a;

        public ViewTreeObserverOnPreDrawListenerC2197o(TextView textView) {
            this.f10155a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = this.f10155a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            C1120a.m6677i("GalleryMainActivity", "textView.getLineCount() = " + this.f10155a.getLineCount());
            if (this.f10155a.getLineCount() <= 1) {
                this.f10155a.setGravity(1);
                return false;
            }
            this.f10155a.setGravity(8388611);
            return false;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$p */
    public class C2198p extends BroadcastReceiver {
        public C2198p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            C1120a.m6675d("GalleryMainActivity", "onReceive: " + safeIntent.getAction());
            if ("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH".equals(safeIntent.getAction()) && GalleryMainActivity.this.f10075K0) {
                C1120a.m6677i("GalleryMainActivity", "open switch after upgrade");
                if (GalleryMainActivity.this.f10128v != null) {
                    GalleryMainActivity.this.f10128v.setCheckedProgrammatically(true);
                }
                if (GalleryMainActivity.this.f10060D != null) {
                    GalleryMainActivity.this.f10060D.setVisibility(8);
                }
                SpanClickText spanClickText = GalleryMainActivity.this.f10065F0;
                if (spanClickText != null) {
                    spanClickText.setVisibility(8);
                }
                GalleryMainActivity.this.m13560z3();
                C1122c.m6764b2(37, true);
                GalleryMainActivity.this.f10075K0 = false;
            }
        }

        public /* synthetic */ C2198p(GalleryMainActivity galleryMainActivity, HandlerC2187e handlerC2187e) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.GalleryMainActivity$q */
    public class C2199q extends BroadcastReceiver {
        public C2199q() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            C1120a.m6675d("GalleryMainActivity", "onReceive: " + safeIntent.getAction());
            if ("com.huawei.hicloud.intent.action.NOTIFY_OPEN_AND_RELEASE".equals(safeIntent.getAction())) {
                GalleryMainActivity.this.f10071I0 = safeIntent.getBooleanExtra("gallery_start_to_open_cloud_album", false);
                if (!C10155f.m63290n()) {
                    C1120a.m6676e("GalleryMainActivity", "gallery not support sync");
                    GalleryMainActivity.this.f10071I0 = false;
                }
                GalleryMainActivity.this.f10089R0 = safeIntent.getStringExtra("activityType");
                GalleryMainActivity.this.f10069H0 = safeIntent.getIntExtra("start_to_open_cloud_album_source", 0);
                GalleryMainActivity galleryMainActivity = GalleryMainActivity.this;
                galleryMainActivity.f10087Q0 = galleryMainActivity.f10069H0;
                GalleryMainActivity galleryMainActivity2 = GalleryMainActivity.this;
                galleryMainActivity2.f10079M0 = galleryMainActivity2.f10071I0;
                if (GalleryMainActivity.this.f10071I0 && !GalleryMainActivity.this.m13537h3()) {
                    GalleryMainActivity.this.m13505O2();
                    C1122c.m6764b2(34, true);
                }
                C1120a.m6677i("GalleryMainActivity", "onReceive isOpenSwitch:" + GalleryMainActivity.this.f10071I0 + " sourceType:" + GalleryMainActivity.this.f10069H0 + ", activityType: " + GalleryMainActivity.this.f10089R0);
                GalleryMainActivity.this.f10071I0 = false;
                if (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(GalleryMainActivity.this.f10089R0)) {
                    if (GalleryMainActivity.this.m13537h3()) {
                        GalleryMainActivity.this.m13538h4();
                    } else {
                        GalleryMainActivity.this.m13505O2();
                        C1122c.m6764b2(33, true);
                    }
                }
            }
        }

        public /* synthetic */ C2199q(GalleryMainActivity galleryMainActivity, HandlerC2187e handlerC2187e) {
            this();
        }
    }

    public GalleryMainActivity() {
        HandlerC2187e handlerC2187e = null;
        this.f10083O0 = new C2199q(this, handlerC2187e);
        this.f10085P0 = new C2198p(this, handlerC2187e);
    }

    /* renamed from: V2 */
    private void m13443V2() {
        ResultReceiver resultReceiver;
        try {
            resultReceiver = (ResultReceiver) new SafeIntent(getIntent()).getParcelableExtra("gallery_finisher");
        } catch (Exception e10) {
            C1120a.m6677i("GalleryMainActivity", "finishPreActivity:" + e10.toString());
            resultReceiver = null;
        }
        if (resultReceiver != null) {
            C1120a.m6675d(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "finishPreActivity");
            resultReceiver.send(1, null);
        }
    }

    /* renamed from: Z3 */
    private void m13448Z3(boolean z10) {
        if (C11829c.m70532M0()) {
            RelativeLayout relativeLayout = this.f10055A0;
            if (relativeLayout == null || this.f10135y0 == null || this.f10128v == null) {
                C1120a.m6676e("GalleryMainActivity", "view is null");
                return;
            }
            if (z10) {
                relativeLayout.setVisibility(8);
                this.f10135y0.setVisibility(8);
                if (C0209d.m1166E1()) {
                    this.f10128v.setClickable(true);
                    this.f10128v.setEnabled(true);
                }
                m13522X2();
                return;
            }
            AlertDialogC11641f alertDialogC11641f = this.f10070I;
            if (alertDialogC11641f != null && alertDialogC11641f.isShowing()) {
                m13511R2();
            }
            AlertDialogC11640e alertDialogC11640e = this.f10074K;
            if (alertDialogC11640e != null && alertDialogC11640e.isShowing()) {
                m13517U2();
            }
            m13501M2();
            this.f10055A0.setVisibility(0);
            this.f10135y0.setVisibility(0);
            this.f10128v.setClickable(false);
            this.f10128v.setEnabled(false);
            RelativeLayout relativeLayout2 = this.f10061D0;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                m13493I2();
            }
        }
    }

    /* renamed from: b3 */
    private void m13451b3() {
        setContentView(R$layout.gallery_main);
    }

    /* renamed from: c3 */
    private void m13453c3() {
        SwitchInfo switchInfoMo58451r;
        boolean zIsGeneralAlbumOn;
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            switchInfoMo58451r = interfaceC9282a.mo58451r(this);
            C1120a.m6675d("GalleryMainActivity", "mEntryType=" + this.f10080N + "isGeneralAlbumOn=" + switchInfoMo58451r.isGeneralAlbumOn() + ",isShareAlbumOn=" + switchInfoMo58451r.isShareAlbumOn() + ",isSmartAlbumOn=" + switchInfoMo58451r.isSmartAlbumOn());
            zIsGeneralAlbumOn = switchInfoMo58451r.isGeneralAlbumOn();
        } else {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
            switchInfoMo58451r = null;
            zIsGeneralAlbumOn = false;
        }
        boolean z10 = !C11829c.m70532M0() || C10028c.m62182c0().m62413x();
        if (!zIsGeneralAlbumOn && this.f10071I0 && z10) {
            m13505O2();
            C1122c.m6764b2(34, true);
        } else {
            m13498K3(zIsGeneralAlbumOn);
            if (this.f10102b0) {
                this.f10054A.setCheckedProgrammatically(true);
            } else {
                this.f10054A.setCheckedProgrammatically(CloudAlbumSettings.m14363h().m14380p());
            }
        }
        this.f10071I0 = false;
        this.f10075K0 = false;
        this.f10069H0 = 0;
        if (!zIsGeneralAlbumOn) {
            m13511R2();
            m13527a3();
        }
        m13495J2();
        if (m13541j3()) {
            m13530c4(switchInfoMo58451r);
        } else {
            m13512R3();
        }
        CloudAlbumSettings.m14363h().m14364A(new C2191i());
    }

    /* renamed from: f3 */
    private void m13457f3() {
        this.f10063E0 = new AlbumShareReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.getCloudPhotoTotalSize");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (c13108aM78878b != null) {
            c13108aM78878b.m78880c(this.f10063E0, intentFilter);
        }
    }

    /* renamed from: g3 */
    private void m13459g3() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f10120r = (RelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10122s = (LinearLayout) C12809f.m76829b(this, R$id.main_all);
        this.f10104d0 = (RelativeLayout) C12809f.m76829b(this, R$id.illustration_image_frame);
        this.f10126u = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.gallery_main_ll);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.gallery_main_switch_btn);
        this.f10128v = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.gallery_main_others);
        this.f10130w = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f10108h0 = (TextView) C12809f.m76829b(this, R$id.gallery_main_others_title);
        this.f10131w0 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.gallery_use_mobile_network);
        UnionSwitch unionSwitch2 = (UnionSwitch) C12809f.m76829b(this, R$id.gallery_use_mobile_network_btn);
        this.f10054A = unionSwitch2;
        unionSwitch2.setOnCheckedChangeListener(this);
        this.f10109i0 = (TextView) C12809f.m76829b(this, R$id.gallery_use_mobile_network_title);
        this.f10110j0 = (TextView) C12809f.m76829b(this, R$id.gallery_use_mobile_network_sub_title);
        NotchFitRelativeLayout notchFitRelativeLayout = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.release_local_space_all);
        this.f10134y = notchFitRelativeLayout;
        notchFitRelativeLayout.setOnClickListener(this);
        this.f10111k0 = (TextView) C12809f.m76829b(this, R$id.release_local_space);
        this.f10112l0 = (TextView) C12809f.m76829b(this, R$id.relase_laocal_space_intellegent_sub_title);
        this.f10136z = (UnionSwitch) C12809f.m76829b(this, R$id.gallery_main_share_intellegent_btn);
        this.f10056B = (TextView) C12809f.m76829b(this, R$id.gallery_main_uploading);
        this.f10058C = (TextView) C12809f.m76829b(this, R$id.gallery_operate_loading);
        this.f10060D = (TextView) C12809f.m76829b(this, R$id.gallery_operate_deactivation);
        this.f10062E = (HwProgressBar) C12809f.m76829b(this, R$id.gallery_main_share_loading_progress);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.gallery_main_share_intellegent);
        this.f10132x = disableSupportedRelativeLayout;
        disableSupportedRelativeLayout.setIsSetTextViewAlpha(false);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_view_cloud_photos);
        this.f10061D0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.f10113m0 = (TextView) C12809f.m76829b(this, R$id.tv_cloud_photos_num);
        this.f10067G0 = C12809f.m76829b(this, R$id.gallery_main_divider1);
        this.f10068H = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        m13512R3();
        this.f10092T = new C11647l(this.f10056B, this.f10058C);
        this.f10124t = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.gallery_main_switch);
        this.f10072J = new AlertDialogC11642g(this, this);
        this.f10074K = new AlertDialogC11640e(this, this);
        AlertDialogC11649n alertDialogC11649n = new AlertDialogC11649n(this, this);
        this.f10076L = alertDialogC11649n;
        alertDialogC11649n.setOnDismissListener(new DialogInterfaceOnDismissListenerC2190h());
        this.f10084P = C12809f.m76829b(this, R$id.gallery_main_content);
        this.f10086Q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.query_failed_frame);
        if (!C0209d.m1166E1()) {
            this.f10124t.m23909a();
        }
        this.f10064F = (LinearLayout) C12809f.m76829b(this, R$id.gallery_main_shelve);
        this.f10066G = (SpanClickText) C12809f.m76829b(this, R$id.gallery_main_shelve_tip);
        this.f10065F0 = (SpanClickText) C12809f.m76829b(this, R$id.gallery_main_text);
        m13546l4();
        this.f10135y0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_function_item_layout);
        this.f10137z0 = (HwButton) C12809f.m76829b(this, R$id.oepn_service_button);
        this.f10055A0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_function_item_empty_layout);
        this.f10057B0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.hicloud_open_function_item_layout_frame);
        this.f10137z0.setOnClickListener(this);
        m13448Z3(C10028c.m62182c0().m62413x());
        View viewM76829b = C12809f.m76829b(this, R$id.mask_view);
        this.f10059C0 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f10100Z = (RelativeLayout) C12809f.m76829b(this, R$id.other_btn_real);
        if (C11842p.m70771U0()) {
            m13533e3();
        }
        mo13327n1();
    }

    /* renamed from: A3 */
    public final void m13479A3(RecommendCardReport recommendCardReport, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        recommendCardReport.setActivityId(safeIntent.getStringExtra("recommend_card_activity_id"));
        recommendCardReport.setActivityType(safeIntent.getStringExtra("recommend_card_activity_type"));
        recommendCardReport.setEntrance(safeIntent.getStringExtra("recommend_card_entrance"));
    }

    /* renamed from: B3 */
    public final void m13480B3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: k6.i
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                this.f52064a.m13545l3(userDataStateInfo);
            }
        }, true, arrayList, "GalleryBtnOn"), false);
    }

    /* renamed from: C3 */
    public final void m13481C3() {
        List<String> listM69911k = this.f22163b.m69911k("sync_ablum");
        C1120a.m6677i("GalleryMainActivity", "album need permissions size: " + listM69911k.size());
        if (this.f22163b.m69903b(this, listM69911k).size() <= 0) {
            m13480B3();
            C1122c.m6764b2(36, true);
            return;
        }
        UnionSwitch unionSwitch = this.f10128v;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(false);
            if (m13537h3()) {
                m13494I3("gallery_permission_close_gallery", C13230i.m79497A(C13452e.m80781L().m80971t0()));
                m13553s3();
            }
        }
    }

    /* renamed from: D2 */
    public final void m13482D2() {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isAutoOpen", C13222a.m79466h(this.f10071I0));
        linkedHashMapM79499C.put("sourceType", C13222a.m79467i(this.f10069H0));
        linkedHashMapM79499C.put("file_to_release_space", String.valueOf(this.f10077L0));
        if (!TextUtils.isEmpty(this.f10081N0)) {
            linkedHashMapM79499C.put("sceneCode", this.f10081N0);
        }
        linkedHashMapM79499C.put("GeneralAblum", Integer.valueOf(CloudAlbumManager.m14456v().m14504w(this).isGeneralAlbumOn() ? 1 : 0));
        C13224c.m79487f1().m79567R("album_openswitch_data", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "album_openswitch_data", linkedHashMapM79499C);
    }

    /* renamed from: D3 */
    public final void m13483D3() {
        C12515a.m75110o().m75175e(new C2186d(), false);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        C1120a.m6677i("GalleryMainActivity", "finishPermissionSet: " + i10);
        if (i10 == 20003) {
            m13481C3();
        }
    }

    /* renamed from: E2 */
    public final void m13485E2() {
        UnionSwitch unionSwitch = this.f10128v;
        if (unionSwitch == null || !this.f10073J0) {
            C1120a.m6675d("GalleryMainActivity", "autoCloseCloudSwitch end, isCloseSwitch is " + this.f10073J0);
            return;
        }
        unionSwitch.setCheckedProgrammatically(false);
        if (m13537h3()) {
            m13518U3();
        } else {
            C1120a.m6677i("GalleryMainActivity", "autoCloseCloudSwitch, switch is already off");
        }
        this.f10073J0 = false;
    }

    /* renamed from: E3 */
    public final void m13486E3() {
        if (C0209d.m1333z1(this)) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
            } else {
                interfaceC9282a.mo58426g(new C2193k(interfaceC9282a));
            }
        }
    }

    /* renamed from: F2 */
    public void m13487F2() {
        this.f10102b0 = false;
        UnionSwitch unionSwitch = this.f10054A;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(false);
            C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_mobile_network_switch", "1", "2", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_mobile_network_switch", "1", "15", "1", "2");
        }
    }

    /* renamed from: F3 */
    public final void m13488F3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        arrayList.add("bs.userdata.expired.time");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: k6.j
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
                this.f52065a.m13547m3(userDataStateInfo);
            }
        }, true, arrayList, "GalleryMain"), false);
    }

    /* renamed from: G2 */
    public final void m13489G2() {
        if (this.f10068H != null) {
            if (C0209d.m1333z1(this)) {
                this.f10068H.m23914a();
            } else {
                this.f10068H.m23919i();
            }
        }
    }

    /* renamed from: G3 */
    public final void m13490G3() {
        C13224c.m79487f1().m79585f0("CLOUDALBUM_CLICK_MASK_VIEW", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "CLOUDALBUM_CLICK_MASK_VIEW", "1", "80");
        C13224c.m79487f1().m79600y("CLOUDALBUM_CLICK_MASK_VIEW", "1");
    }

    /* renamed from: H2 */
    public final void m13491H2() {
        C12515a.m75110o().m75175e(new C2196n(null), true);
    }

    /* renamed from: H3 */
    public final void m13492H3() {
        C13224c.m79487f1().m79585f0("action_code_jump_cloud_photos", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_jump_cloud_photos", "1", "from_gallery_main_page");
    }

    /* renamed from: I2 */
    public final void m13493I2() {
        if (this.f10061D0.isShown() || this.f10064F.isShown()) {
            this.f10067G0.setVisibility(0);
        } else {
            this.f10067G0.setVisibility(8);
        }
    }

    /* renamed from: I3 */
    public final void m13494I3(String str, LinkedHashMap<String, String> linkedHashMap) {
        C13224c.m79487f1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "1", "74", linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07042"), "07042", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: J2 */
    public final void m13495J2() {
        boolean z10 = (CloudAlbumSettings.m14363h().m14382r() || this.f10082O || this.f10133x0 || m13541j3()) ? false : true;
        boolean zIsGeneralAlbumOn = CloudAlbumManager.m14456v().m14504w(this).isGeneralAlbumOn();
        if (z10) {
            this.f10100Z.setVisibility(8);
            this.f10059C0.setVisibility(8);
            return;
        }
        if (zIsGeneralAlbumOn) {
            m13500L3(true);
            this.f10059C0.setVisibility(8);
            this.f10100Z.setBackground(getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        } else {
            m13500L3(false);
            this.f10100Z.setBackground(null);
            this.f10059C0.setVisibility(0);
        }
        this.f10100Z.setVisibility(0);
    }

    /* renamed from: J3 */
    public final void m13496J3() {
        if (new SafeIntent(getIntent()).getBooleanExtra("need_root_alert", false)) {
            AlertDialogC13157d alertDialogC13157d = new AlertDialogC13157d(this, null, 1);
            this.f10088R = alertDialogC13157d;
            alertDialogC13157d.show();
        }
    }

    /* renamed from: K2 */
    public final boolean m13497K2() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
            return true;
        }
        if (C10155f.m63290n()) {
            return true;
        }
        this.f10086Q.setVisibility(0);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.query_failed_email);
        ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC2197o(textView));
        }
        this.f10084P.setVisibility(8);
        interfaceC9282a.mo58407Z0(this, 4);
        return false;
    }

    /* renamed from: K3 */
    public final void m13498K3(boolean z10) {
        boolean z11 = this.f10103c0 != z10;
        if (this.f10101a0 || z11 || this.f10106f0 || this.f10105e0) {
            if (this.f10105e0) {
                this.f10128v.setCheckedProgrammatically(false);
            } else if (this.f10106f0) {
                this.f10128v.setCheckedProgrammatically(true);
            } else {
                this.f10128v.setCheckedProgrammatically(z10);
            }
            if (z11) {
                this.f10101a0 = true;
            }
        }
    }

    /* renamed from: L2 */
    public final void m13499L2() {
        SwitchInfo switchInfoM14504w = CloudAlbumManager.m14456v().m14504w(this);
        C1120a.m6675d("GalleryMainActivity", "mEntryType=" + this.f10080N + "isGeneralAlbumOn=" + switchInfoM14504w.isGeneralAlbumOn() + ",isShareAlbumOn=" + switchInfoM14504w.isShareAlbumOn() + ",isSmartAlbumOn=" + switchInfoM14504w.isSmartAlbumOn());
        boolean zIsGeneralAlbumOn = switchInfoM14504w.isGeneralAlbumOn();
        if (!zIsGeneralAlbumOn) {
            m13495J2();
        }
        m13498K3(zIsGeneralAlbumOn);
    }

    /* renamed from: L3 */
    public final void m13500L3(boolean z10) {
        this.f10130w.setEnabled(z10);
        this.f10054A.setEnabled(z10);
        this.f10136z.setEnabled(z10);
        this.f10061D0.setEnabled(z10);
        this.f10066G.setEnabled(z10);
    }

    /* renamed from: M2 */
    public void m13501M2() {
        this.f10101a0 = true;
        UnionSwitch unionSwitch = this.f10128v;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(false);
        }
        C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_switch", "1", "2", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_switch", "1", "15", "1", "2");
    }

    /* renamed from: M3 */
    public void m13502M3(boolean z10) {
        this.f10107g0 = z10;
    }

    /* renamed from: N2 */
    public final void m13503N2() {
        if (CloudAlbumSettings.m14363h().m14380p()) {
            C1122c.m6800k2(getApplicationContext(), false);
            C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_mobile_network_switch", "2", "2", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_mobile_network_switch", "1", "15", "2", "2");
        }
    }

    /* renamed from: N3 */
    public void m13504N3(boolean z10) {
        this.f10105e0 = z10;
    }

    /* renamed from: O2 */
    public final void m13505O2() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1005;
        this.f10091S0.sendMessageDelayed(messageObtain, 1000L);
    }

    /* renamed from: O3 */
    public final void m13506O3() {
        this.f10130w.setVisibility(8);
    }

    /* renamed from: P2 */
    public final void m13507P2() {
        if (this.f10128v.isChecked()) {
            return;
        }
        this.f10132x.m23909a();
    }

    /* renamed from: P3 */
    public final void m13508P3() {
        this.f10130w.setVisibility(0);
    }

    /* renamed from: Q2 */
    public final void m13509Q2() {
        new GalleryShelveNotification(this).m14542f();
    }

    /* renamed from: Q3 */
    public final void m13510Q3(SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2, new C2194l(spanClickText));
        spanClickText.m15934g(str, false);
    }

    /* renamed from: R2 */
    public final void m13511R2() {
        if (this.f10070I != null) {
            try {
                m13502M3(false);
                this.f10070I.dismiss();
            } catch (Exception unused) {
                C1120a.m6676e("GalleryMainActivity", "CloseCgSwtichTipDialog dismiss error");
            }
        }
    }

    /* renamed from: R3 */
    public final void m13512R3() {
        this.f10132x.setVisibility(8);
    }

    /* renamed from: S2 */
    public void m13513S2(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        Resources resources = getResources();
        if (resources == null) {
            C1120a.m6677i("GalleryMainActivity", "resources is null.");
            this.f10060D.setVisibility(8);
            this.f10065F0.setVisibility(8);
            return;
        }
        if (!C13452e.m80781L().m80791C0()) {
            C1120a.m6677i("GalleryMainActivity", "user is not base date service.");
            this.f10060D.setVisibility(8);
            this.f10065F0.setVisibility(8);
            return;
        }
        this.f10060D.setVisibility(0);
        this.f10065F0.setVisibility(0);
        long userdataExpiredTime = userDataStateInfo.getUserdataExpiredTime();
        if (userdataExpiredTime == 0) {
            m13525Y3(resources);
            C1120a.m6678w("GalleryMainActivity", "getParams from service fail");
            return;
        }
        if (userdataExpiredTime - C12312h0.m74027b().m74028c() < 0) {
            C1120a.m6677i("GalleryMainActivity", "The data has expired.");
            this.f10065F0.setText(resources.getString(R$string.gallery_basic_service_fixing_tips, ""));
            return;
        }
        StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
        long galleryUsedSize = storageInfoM80226P != null ? storageInfoM80226P.getGalleryUsedSize() + storageInfoM80226P.getGalleryDeleteSize() : -1L;
        C1120a.m6677i("GalleryMainActivity", "album total space:" + galleryUsedSize);
        if (galleryUsedSize <= 0) {
            this.f10065F0.setText(resources.getString(R$string.gallery_basic_service_fixing_tips, ""));
            return;
        }
        String string = resources.getString(R$string.user_agreement_tips);
        String string2 = resources.getString(R$string.gallery_basic_service_tips2, string, C11290m.m67753n(resources, userdataExpiredTime, userDataStateInfo.getRemainDwnldDays()));
        this.f10065F0.m15931c(string, new C11427b(this, C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement"));
        this.f10065F0.m15934g(resources.getString(R$string.gallery_basic_service_fixing_tips, string2), false);
        C13368e.m80184F().m80253r0();
        C13368e.m80184F().m80250o0();
    }

    @Deprecated
    /* renamed from: S3 */
    public final void m13514S3() {
        this.f10132x.setVisibility(4);
    }

    /* renamed from: T2 */
    public final void m13515T2() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
        } else if (this.f10072J != null && interfaceC9282a.mo58373I0()) {
            this.f10072J.dismiss();
        }
        m13511R2();
        m13517U2();
        AlertDialogC13157d alertDialogC13157d = this.f10088R;
        if (alertDialogC13157d != null) {
            try {
                alertDialogC13157d.dismiss();
                this.f10088R = null;
            } catch (IllegalArgumentException unused) {
                C1120a.m6676e("GalleryMainActivity", "RootedAlertDialog dismiss IllegalArgumentException");
            }
        }
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17166C();
        }
    }

    /* renamed from: T3 */
    public final void m13516T3() {
        m13504N3(true);
        this.f10074K.showDialog();
    }

    /* renamed from: U2 */
    public final void m13517U2() {
        m13504N3(false);
        AlertDialogC11640e alertDialogC11640e = this.f10074K;
        if (alertDialogC11640e != null) {
            alertDialogC11640e.dismiss();
        }
    }

    /* renamed from: U3 */
    public final void m13518U3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (!this.f10082O || !CloudAlbumSettings.m14363h().m14385u()) {
            m13516T3();
            return;
        }
        this.f10101a0 = false;
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58457u(getApplicationContext(), new C2184b());
        }
    }

    /* renamed from: V3 */
    public final void m13519V3() throws Resources.NotFoundException {
        String quantityString;
        String string;
        if (CloudAlbumSettings.m14363h().m14385u()) {
            this.f10064F.setVisibility(0);
            m13493I2();
            String string2 = getString(R$string.gallery_main_shelve_setup);
            if (this.f10099Y) {
                string = getString(R$string.gallery_main_shelved_link_tip2, string2);
            } else {
                Resources resources = getResources();
                int i10 = R$plurals.gallery_shelve_left_days;
                int i11 = this.f10097W;
                string = getString(R$string.gallery_main_shelved_link_tip, resources.getQuantityString(i10, i11, Integer.valueOf(i11)), string2);
            }
            m13510Q3(this.f10066G, string, string2);
        } else {
            this.f10064F.setVisibility(0);
            m13493I2();
            if (this.f10099Y) {
                quantityString = getString(R$string.gallery_main_shelved_link_tip2);
            } else {
                Resources resources2 = getResources();
                int i12 = R$plurals.gallery_shelve_main_content;
                int i13 = this.f10097W;
                quantityString = resources2.getQuantityString(i12, i13, Integer.valueOf(i13));
            }
            this.f10066G.m15934g(quantityString, false);
        }
        m13556v3();
    }

    /* renamed from: W2 */
    public final void m13520W2() {
        C1120a.m6677i("GalleryMainActivity", "queryAlbumStatus directly");
        Bundle bundleM5971r = C1006a.m5936k().m5971r(this);
        if (bundleM5971r != null) {
            Message messageObtain = Message.obtain();
            messageObtain.setData(bundleM5971r);
            messageObtain.what = 1003;
            this.f10091S0.sendMessage(messageObtain);
        }
    }

    /* renamed from: W3 */
    public final void m13521W3() {
        m13508P3();
        if (C0224k0.m1534D(this)) {
            this.f10131w0.setVisibility(8);
        } else {
            this.f10131w0.setVisibility(0);
        }
        this.f10134y.setVisibility(0);
    }

    /* renamed from: X2 */
    public final void m13522X2() {
        if (this.f10061D0 != null) {
            if (CloudAlbumSettings.m14363h().m14382r()) {
                this.f10061D0.setVisibility(0);
                this.f10067G0.setVisibility(0);
                C12091d.m72280a0().m72393v0(this, "", false, true);
            } else {
                C1120a.m6675d("GalleryMainActivity", "getCloudPhotosNum isCloudphotoManagerEnable false");
                this.f10061D0.setVisibility(8);
            }
            m13493I2();
        }
    }

    /* renamed from: X3 */
    public final void m13523X3() {
        if (CloudAlbumSettings.m14363h().m14380p()) {
            C1120a.m6675d("GalleryMainActivity", "return, mobile switch already is on!");
            return;
        }
        this.f10076L.m69574c(this.f10115o0, this.f10119q0, this.f10127u0, this.f10129v0);
        this.f10076L.show();
        this.f10102b0 = true;
    }

    /* renamed from: Y2 */
    public final void m13524Y2() {
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.ACTION_GALLERYDETAIL_ACTIVITY);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra("gallery_from_hisync", false);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C13230i.m79525e1(intent, "1", "15");
        startActivityForResult(intent, 1);
    }

    /* renamed from: Y3 */
    public void m13525Y3(Resources resources) throws Resources.NotFoundException {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
            this.f10065F0.setVisibility(8);
            return;
        }
        int iMo58370H = interfaceC9282a.mo58370H();
        C1120a.m6677i("GalleryMainActivity", "userDataStatus:" + iMo58370H);
        if (iMo58370H == 0) {
            this.f10065F0.setVisibility(0);
            String string = resources.getString(R$string.user_agreement_tips);
            String string2 = resources.getString(R$string.gallery_basic_service_tips2, string, resources.getString(R$string.after_data_expiration));
            this.f10065F0.m15931c(string, new C11427b(this, C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement"));
            this.f10065F0.m15934g(resources.getString(R$string.gallery_basic_service_fixing_tips, string2), false);
            return;
        }
        if (iMo58370H != 1) {
            this.f10065F0.setVisibility(8);
        } else {
            this.f10065F0.setVisibility(0);
            this.f10065F0.setText(resources.getString(R$string.gallery_basic_service_fixing_tips, ""));
        }
    }

    /* renamed from: Z2 */
    public final void m13526Z2() {
        m13506O3();
        this.f10131w0.setVisibility(8);
        this.f10134y.setVisibility(8);
    }

    /* renamed from: a3 */
    public final void m13527a3() {
        this.f10056B.setVisibility(8);
        this.f10058C.setVisibility(8);
    }

    /* renamed from: a4 */
    public final void m13528a4() {
        m13502M3(true);
        AlertDialogC11641f alertDialogC11641f = new AlertDialogC11641f(this, this.f10098X);
        this.f10070I = alertDialogC11641f;
        alertDialogC11641f.showDialog();
    }

    /* renamed from: b4 */
    public final void m13529b4() throws Resources.NotFoundException {
        new GalleryShelveNotification(this).m14547k(true, this.f10097W);
    }

    /* renamed from: c4 */
    public final void m13530c4(SwitchInfo switchInfo) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            if (interfaceC9282a.mo58364E(this)) {
                this.f10136z.setVisibility(8);
                this.f10062E.setVisibility(0);
            }
            this.f10136z.setOnCheckedChangeListener(this);
            m13507P2();
        }
        C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
        if (this.f10101a0 && switchInfo != null) {
            this.f10136z.setCheckedProgrammatically(switchInfo.isSmartAlbumOn());
        }
        this.f10136z.setOnCheckedChangeListener(this);
        m13507P2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10120r);
        arrayList.add(this.f10122s);
        arrayList.add(this.f10130w);
        arrayList.add(this.f10086Q);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m13531d3() {
        this.f10133x0 = m13543k3();
        C1120a.m6677i("GalleryMainActivity", "initGallerySetting: isSupportSetting=" + this.f10133x0);
        if (!this.f10133x0) {
            m13526Z2();
            return;
        }
        m13521W3();
        this.f10108h0.setText(this.f10114n0);
        this.f10109i0.setText(this.f10115o0);
        this.f10110j0.setText(this.f10117p0);
        this.f10111k0.setText(this.f10121r0);
        this.f10112l0.setText(this.f10123s0);
        if (this.f10080N == 2) {
            m13538h4();
        }
    }

    /* renamed from: d4 */
    public final void m13532d4(int i10, Bundle bundle) {
        C1120a.m6677i("GalleryMainActivity", "showUploadStatus mEntryType=" + this.f10080N);
        boolean zM13537h3 = m13537h3();
        if (!m13539i3()) {
            m13540i4(zM13537h3);
        }
        if (C13452e.m80781L().m80791C0()) {
            C1120a.m6677i("GalleryMainActivity", "basic hide tips");
            m13527a3();
            return;
        }
        C1120a.m6677i("GalleryMainActivity", "showUploadStatus isSwitchOn:" + zM13537h3);
        if (this.f10056B == null || !zM13537h3) {
            return;
        }
        C1120a.m6677i("GalleryMainActivity", "showUploadStatus showGalleryTips isSwitchOn:" + zM13537h3);
        this.f10092T.mo79143e(this, bundle, i10);
    }

    /* renamed from: e3 */
    public final void m13533e3() {
        LinearLayout linearLayout = this.f10122s;
        if (linearLayout == null) {
            C1120a.m6676e("GalleryMainActivity", "mainAllView is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (C11842p.m70753O0(this)) {
            layoutParams.width = Math.round(C11842p.m70844o(this, ErrorCode.ERROR_SIGTOOL_FAIL));
        } else {
            layoutParams.width = Math.round(C11842p.m70844o(this, 466));
        }
        if (layoutParams.width == 0) {
            C1120a.m6676e("GalleryMainActivity", "width is 0");
        } else {
            this.f10122s.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: e4 */
    public final void m13534e4(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6677i("GalleryMainActivity", "get gallery uploading status failed");
            return;
        }
        int i10 = bundle.getInt("msgID");
        m13532d4(i10, bundle);
        if (i10 == 9000 && C1006a.m5936k().m5975v(this) && bundle.getInt(CommonConstant.ReqAccessTokenParam.STATE_LABEL) == 912) {
            C1006a.m5936k().m5944H();
        }
    }

    /* renamed from: f4 */
    public void m13535f4() {
        this.f10101a0 = true;
        if (this.f10128v != null) {
            C0214f0.m1382b(this, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("SwitchHelperUtilisCloudAlbumOn", true).commit();
            this.f10128v.setCheckedProgrammatically(true);
        }
        C1007b.m5980s().m5992L(this);
        UBAAnalyze.m29971c0("PVC", "mecloud_switch_to_management_cloud_space", "1", "15", "1", "1");
    }

    /* renamed from: g4 */
    public final void m13536g4() {
        try {
            C1120a.m6677i("GalleryMainActivity", "onStartGalleryOtherActivity");
            Intent intent = new Intent();
            C0209d.m1302r2(intent, C13843a.m83054F(this));
            intent.setAction("com.huawei.gallery.action.VIEW_UPLOAD_ALBUM");
            Bundle extras = intent.getExtras();
            Context applicationContext = getApplicationContext();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString("album_data_sync", applicationContext.getString(R$string.mecloud_gallery_data_sync_title));
            extras.putString("sync_data_merge_confirm", applicationContext.getString(R$string.sync_data_merge_confirm_tips, applicationContext.getString(R$string.gallery_item_title)));
            extras.putString("dialog_cancel", applicationContext.getString(R$string.sync_data_merge_btn_confirm));
            extras.putString("dialog_merge", applicationContext.getString(R$string.notepad_switch_open_dialog_merge));
            extras.putString("dialog_close", applicationContext.getString(R$string.dialog_disable));
            extras.putString("close_album_data_sync", applicationContext.getString(R$string.gallery_shelve_close_switch));
            extras.putString("close_album_switch_confirm", applicationContext.getString(R$string.close_switch_dialog_msg));
            extras.putBoolean("key-support-cloud-sync-switch", true);
            intent.putExtras(extras);
            intent.addCategory("android.intent.category.DEFAULT");
            startActivity(intent);
            C13224c.m79487f1().m79585f0("mecloud_gallerymain_click_other_album", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_gallerymain_click_other_album", "1", "15");
        } catch (Exception unused) {
            C1120a.m6676e("GalleryMainActivity", "not found gallery other activity");
        }
    }

    /* renamed from: h3 */
    public final boolean m13537h3() {
        return C1122c.m6807m1(this);
    }

    /* renamed from: h4 */
    public final void m13538h4() {
        if (this.f10082O) {
            C1120a.m6677i("GalleryMainActivity", "cloud album deactivated, release space disabled!");
            return;
        }
        synchronized (GalleryMainActivity.class) {
            if (C11829c.m70632y0()) {
                C1120a.m6677i("GalleryMainActivity", "startGalleryReleaseSpaceActivity isGoingToGallery");
                return;
            }
            try {
                C1120a.m6677i("GalleryMainActivity", "onStartGalleryReleaseSpaceActivity");
                C11829c.m70597m1(true);
                Intent intent = new Intent();
                C0209d.m1302r2(intent, C13843a.m83054F(this));
                intent.setAction("com.huawei.gallery.action.CLEAN_FILE");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivityForResult(intent, 20018);
                LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("recommend_card_activity_id", this.f10094U.getActivityId());
                linkedHashMapM79499C.put("recommend_card_activity_type", this.f10094U.getActivityType());
                linkedHashMapM79499C.put("recommend_card_entrance", this.f10094U.getEntrance());
                C13224c.m79487f1().m79591l0("mecloud_gallerymain_click_release_space", linkedHashMapM79499C);
                UBAAnalyze.m29958S("PVC", "mecloud_gallerymain_click_release_space", "1", "15", linkedHashMapM79499C);
            } catch (Exception unused) {
                C1120a.m6676e("GalleryMainActivity", "not found gallery release space activity");
                C11829c.m70597m1(false);
            }
        }
    }

    /* renamed from: i3 */
    public boolean m13539i3() {
        return this.f10105e0;
    }

    /* renamed from: i4 */
    public final void m13540i4(boolean z10) {
        UnionSwitch unionSwitch = this.f10128v;
        if (unionSwitch == null) {
            C1120a.m6676e("GalleryMainActivity", "mainBtn null");
        } else if (this.f10101a0) {
            unionSwitch.setCheckedProgrammatically(z10);
        }
    }

    /* renamed from: j3 */
    public final boolean m13541j3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        return interfaceC9282a != null && interfaceC9282a.mo58373I0() && !interfaceC9282a.mo58441m() && C10028c.m62182c0().m62420y1();
    }

    /* renamed from: j4 */
    public final void m13542j4(Bundle bundle) {
        if (this.f10128v.isChecked()) {
            this.f10132x.m23910b();
        } else {
            this.f10132x.m23909a();
        }
        this.f10136z.setVisibility(0);
        this.f10062E.setVisibility(8);
        this.f10136z.setCheckedProgrammatically(bundle.getBoolean("SmartAlbum"));
    }

    /* renamed from: k3 */
    public final boolean m13543k3() {
        Bundle bundleM6836u0 = C1122c.m6836u0(getApplicationContext());
        if (bundleM6836u0 == null) {
            return false;
        }
        this.f10114n0 = bundleM6836u0.getString("string_sync_album");
        this.f10115o0 = bundleM6836u0.getString("string_mobile_data");
        this.f10117p0 = bundleM6836u0.getString("string_mobile_data_summary");
        this.f10119q0 = bundleM6836u0.getString("string_mobile_data_msg");
        this.f10121r0 = bundleM6836u0.getString("string_clean_file_title");
        this.f10123s0 = bundleM6836u0.getString("string_clean_file_sub");
        this.f10125t0 = bundleM6836u0.getString("string_clean_file_disabled_sub");
        this.f10127u0 = bundleM6836u0.getString("string_ok");
        this.f10129v0 = bundleM6836u0.getString("string_cancel");
        return (TextUtils.isEmpty(this.f10114n0) || TextUtils.isEmpty(this.f10115o0) || TextUtils.isEmpty(this.f10117p0) || TextUtils.isEmpty(this.f10119q0) || TextUtils.isEmpty(this.f10121r0) || TextUtils.isEmpty(this.f10123s0) || TextUtils.isEmpty(this.f10125t0) || TextUtils.isEmpty(this.f10127u0) || TextUtils.isEmpty(this.f10129v0)) ? false : true;
    }

    /* renamed from: k4 */
    public final void m13544k4() throws Resources.NotFoundException {
        SwitchInfo switchInfoMo58451r;
        this.f10082O = false;
        int i10 = this.f10096V;
        if (i10 == -2) {
            this.f10112l0.setText(this.f10123s0);
            m13495J2();
            this.f10064F.setVisibility(8);
            m13493I2();
            return;
        }
        if (i10 == -1 || i10 == 0) {
            this.f10112l0.setText(this.f10123s0);
            m13495J2();
            this.f10064F.setVisibility(8);
            m13493I2();
            m13509Q2();
            return;
        }
        if (i10 != 1) {
            return;
        }
        this.f10112l0.setText(this.f10125t0);
        m13495J2();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            switchInfoMo58451r = interfaceC9282a.mo58451r(this);
        } else {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
            switchInfoMo58451r = null;
        }
        if (switchInfoMo58451r == null) {
            return;
        }
        m13519V3();
        this.f10082O = true;
        if (interfaceC9282a == null || interfaceC9282a.mo58378L(this)) {
            return;
        }
        m13529b4();
    }

    /* renamed from: l3 */
    public final /* synthetic */ void m13545l3(UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C1120a.m6677i("GalleryMainActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C1120a.m6677i("GalleryMainActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C1120a.m6677i("GalleryMainActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            C1120a.m6677i("GalleryMainActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
            C1136q.m6954L(userDataStateInfo.getBmGradeState());
            C1136q.m6953K(userDataStateInfo.getDataPeriod());
            C1136q.m6955M(System.currentTimeMillis());
        }
        if (C13452e.m80781L().m80791C0() && C1136q.m6977r() == 1) {
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b == null) {
                C1120a.m6676e("GalleryMainActivity", "jumpToCloudSpaceUpgradePage cloudBackupRouter is null");
                return;
            }
            this.f10075K0 = true;
            C1120a.m6677i("GalleryMainActivity", "jump to cloud space upgrade page.");
            interfaceC9283b.mo58515k(this, null);
            UnionSwitch unionSwitch = this.f10128v;
            if (unionSwitch != null) {
                unionSwitch.setCheckedProgrammatically(false);
                return;
            }
            return;
        }
        if (!C1122c.m6708J1()) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58428g1(this, new C2195m());
                return;
            } else {
                C1120a.m6676e("GalleryMainActivity", "checkExistMediaFile cloudAlbumRouter is null");
                return;
            }
        }
        InterfaceC9283b interfaceC9283b2 = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        if (interfaceC9283b2 == null) {
            C1120a.m6676e("GalleryMainActivity", "jumpToDataExpiresDownloadPage cloudBackupRouter is null");
            return;
        }
        this.f10075K0 = true;
        C1120a.m6677i("GalleryMainActivity", "jump to data expire download page.");
        interfaceC9283b2.mo58530u(this, null);
        UnionSwitch unionSwitch2 = this.f10128v;
        if (unionSwitch2 != null) {
            unionSwitch2.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: l4 */
    public final void m13546l4() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            this.f10096V = interfaceC9282a.mo58394T(this);
        } else {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
        }
        int i10 = this.f10096V;
        if (i10 == -1 || i10 == -2) {
            return;
        }
        int iM6683B0 = C1122c.m6683B0(getApplicationContext());
        this.f10097W = iM6683B0;
        int i11 = this.f10096V;
        if (i11 != 1 || iM6683B0 >= 0) {
            C9423b.m59095b(this, i11, iM6683B0);
            this.f10099Y = interfaceC9282a != null && interfaceC9282a.mo58377K0(getApplicationContext()) == 3;
            this.f10095U0.sendEmptyMessage(0);
        }
    }

    /* renamed from: m3 */
    public final /* synthetic */ void m13547m3(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C1120a.m6677i("GalleryMainActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C1120a.m6677i("GalleryMainActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C1120a.m6677i("GalleryMainActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            C1120a.m6677i("GalleryMainActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
            C1136q.m6954L(userDataStateInfo.getBmGradeState());
            C1136q.m6953K(userDataStateInfo.getDataPeriod());
            C1136q.m6955M(System.currentTimeMillis());
        }
        m13513S2(userDataStateInfo);
    }

    /* renamed from: n3 */
    public final void m13548n3(String str, boolean z10) throws SQLException {
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, z10);
        CloudAlbumManager.m14456v().m14470O(this, bundle, 4);
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17109X(this, z10);
        } else {
            C1120a.m6677i("GalleryMainActivity", "CloudSyncRouterImpl is null");
        }
    }

    /* renamed from: o3 */
    public void m13549o3() {
        this.f10101a0 = true;
        this.f10132x.m23909a();
        this.f10136z.setVisibility(8);
        this.f10062E.setVisibility(0);
        m13548n3("SmartAlbum", false);
        C13224c.m79487f1().m79600y("CLOUDBACKUP_CLOUDALBUM_CLOSE_SMARTRECOGNITION", "1");
        UBAAnalyze.m29957R("PVC", "CLOUDBACKUP_CLOUDALBUM_CLOSE_SMARTRECOGNITION", "1", "15", "value", "1");
        C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_intellegent", "2", "2", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_intellegent", "1", "15", "2", "2");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17187t(this, i10, i11, intent);
        }
        C1120a.m6677i("GalleryMainActivity", "onActivityResult: requestCode=" + i10 + ", resultCode=" + i11);
        if (i10 == 20018) {
            C11829c.m70597m1(false);
        }
        if (i10 == 20003) {
            m13481C3();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C1120a.m6677i("GalleryMainActivity", "onBackPressed");
        this.f10091S0.removeMessages(1004);
        this.f10091S0.removeMessages(1006);
        setResult(10500);
        super.onBackPressed();
        m22378l1();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws SQLException {
        if (C13612b.m81829B().m81886t(this)) {
            return;
        }
        if (R$id.gallery_main_switch_btn != compoundButton.getId()) {
            if (R$id.gallery_main_share_intellegent_btn == compoundButton.getId() && C1006a.m5936k().m5939C()) {
                m13554t3(z10);
                return;
            } else {
                if (R$id.gallery_use_mobile_network_btn == compoundButton.getId()) {
                    if (z10) {
                        m13523X3();
                        return;
                    } else {
                        m13503N2();
                        return;
                    }
                }
                return;
            }
        }
        C1120a.m6675d("GalleryMainActivity", "gallery_main_switch_btn=" + z10);
        if (!z10) {
            if (m13537h3()) {
                m13518U3();
            }
        } else if (!m29143z0(HNConstants.DataType.MEDIA)) {
            C1120a.m6677i("GalleryMainActivity", "onCheckedChanged checkOpenSwitchPermission");
        } else {
            m13480B3();
            C1122c.m6764b2(35, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C13612b.m81829B().m81886t(this)) {
            return;
        }
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("GalleryMainActivity", "do not fast click");
            return;
        }
        int id2 = view.getId();
        if (R$id.gallery_main_others == id2) {
            m13536g4();
            return;
        }
        if (R$id.release_local_space_all == id2) {
            m13538h4();
            return;
        }
        if (R$id.oepn_service_button == view.getId()) {
            C13224c.m79487f1().m79585f0("extended_service_click_open_album", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "extended_service_click_open_album", "1", "100");
            C10028c.m62182c0().m62272S1(true);
            m13448Z3(true);
            return;
        }
        if (id2 == R$id.rlay_view_cloud_photos) {
            C0224k0.m1542L(this, new Intent(this, (Class<?>) AlbumManageActivity.class));
            m13492H3();
            C13224c.m79487f1().m79593q0("CLICK_GALLERY_CLOUD_PHOTOS");
        } else if (id2 == R$id.mask_view) {
            if (!C11829c.m70532M0() || C10028c.m62182c0().m62413x()) {
                C11841o.m70706b(this, getString(R$string.gallery_switch_close_click), 0);
                m13490G3();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        m13451b3();
        m13459g3();
        C11841o.m70705a();
        m13531d3();
        mo19005p1();
        m13489G2();
        if (m13497K2()) {
            m13453c3();
            m13488F3();
            m13483D3();
        }
        m13499L2();
        m13495J2();
        if (C11842p.m70771U0()) {
            m13533e3();
        }
        m13556v3();
        m13522X2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29137U0();
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f10080N = safeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, -1);
        this.f10089R0 = safeIntent.getStringExtra("activityType");
        this.f10081N0 = safeIntent.getStringExtra("sceneCode");
        this.f10069H0 = safeIntent.getIntExtra("start_to_open_cloud_album_source", 0);
        this.f10071I0 = safeIntent.getBooleanExtra("gallery_start_to_open_cloud_album", false);
        this.f10073J0 = safeIntent.getBooleanExtra("gallery_start_to_close_cloud_album", false);
        if (!C10155f.m63290n()) {
            C1120a.m6676e("GalleryMainActivity", "gallery not support sync");
            this.f10071I0 = false;
        }
        this.f10077L0 = safeIntent.getBooleanExtra("file_to_release_space", false);
        this.f10079M0 = this.f10071I0;
        this.f10087Q0 = this.f10069H0;
        C1120a.m6677i("GalleryMainActivity", "isOpenSwitch:" + this.f10071I0 + " sourceType:" + this.f10069H0 + ", activityType: " + this.f10089R0 + ", isFileToReleaseSpace: " + this.f10077L0 + ", sceneCode: " + this.f10081N0);
        C13108a.m78878b(this).m78880c(this.f10083O0, new IntentFilter("com.huawei.hicloud.intent.action.NOTIFY_OPEN_AND_RELEASE"));
        C13108a.m78878b(this).m78880c(this.f10085P0, new IntentFilter("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH"));
        if (m13537h3() && this.f10077L0) {
            m13538h4();
        }
        if (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(this.f10089R0)) {
            if (m13537h3()) {
                m13538h4();
            } else {
                m13505O2();
                C1122c.m6764b2(33, true);
            }
        }
        boolean zM13543k3 = m13543k3();
        this.f10133x0 = zM13543k3;
        if (zM13543k3 && m13537h3() && "Gallery_sync".equals(safeIntent.getStringExtra("deeplink_sub_page"))) {
            C1120a.m6677i("GalleryMainActivity", "onCreate: deeplink other album");
            m13536g4();
        }
        m13451b3();
        m13459g3();
        m13531d3();
        mo19005p1();
        m13457f3();
        m13556v3();
        C1120a.m6675d("GalleryMainActivity", "mEntryType:" + this.f10080N);
        if (this.f10080N == 2) {
            C13224c.m79487f1().m79585f0("mecloud_notify_cloudalbum_release_space", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_notify_cloudalbum_release_space", "4", "14");
        }
        m13479A3(this.f10094U, getIntent());
        if (m13497K2()) {
            C13612b.m81829B();
            C13612b.m81830Y(this);
            m13496J3();
            InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
            if (interfaceC9285d != null) {
                interfaceC9285d.mo17181n(this);
            }
            m22365E1(R$string.gallery_main_title_text);
            this.f10090S.m79065c(this, new SafeIntent(getIntent()), C13222a.m79465g(this));
            C13224c.m79487f1().m79598v0(this, new SafeIntent(getIntent()), "GalleryMainActivity");
            m13482D2();
            C13612b.m81829B().m81885s0(false);
            C13612b.m81829B().m81886t(this);
            mo22385x1();
            m13485E2();
            m13499L2();
            if (CloudAlbumSettings.m14363h().m14382r()) {
                C11737b.m70035b().m70036a(this.f10093T0);
            }
            m13491H2();
            m13488F3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C1120a.m6677i("GalleryMainActivity", "onDestroy");
        C11829c.m70597m1(false);
        super.onDestroy();
        C11836j.m70658k().m70672o(this);
        m13515T2();
        C11842p.m70836m(this);
        this.f10095U0.removeCallbacksAndMessages(null);
        if (CloudAlbumSettings.m14363h().m14382r()) {
            C11737b.m70035b().m70041g(this.f10093T0);
        }
        if (this.f10063E0 != null) {
            C13108a.m78878b(this).m78883f(this.f10063E0);
        }
        if (this.f10083O0 != null) {
            C13108a.m78878b(this).m78883f(this.f10083O0);
        }
        if (this.f10085P0 != null) {
            C13108a.m78878b(this).m78883f(this.f10085P0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        C13612b.m81829B().m81885s0(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (menuItem.getItemId() == 16908332) {
            if (getIntent() == null) {
                return true;
            }
            Bundle extras = new SafeIntent(getIntent()).getExtras();
            if (extras != null) {
                boolean z10 = extras.getBoolean("is_activity_need_back_to_main");
                boolean z11 = extras.getBoolean("is_from_webview_filemanager");
                if (z10 && !z11) {
                    Intent intent = new Intent();
                    intent.setAction(NotifyConstants.Action.ACTION_MAIN_ACTIVITY);
                    C0209d.m1302r2(intent, "com.huawei.hidisk");
                    intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    startActivity(intent);
                    new HwAnimationReflection(this).m15927c(2);
                }
            }
            this.f10091S0.removeMessages(1004);
            this.f10091S0.removeMessages(1006);
            C1120a.m6677i("GalleryMainActivity", "onOptionsItemSelected setResult");
            setResult(10500);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C1120a.m6677i("GalleryMainActivity", "cloudAlbumRouterImpl is null");
        } else {
            this.f10103c0 = interfaceC9282a.mo58451r(this).isGeneralAlbumOn();
            interfaceC9282a.mo58361C0(this);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (!C0209d.m1208S0(this)) {
            m13546l4();
        }
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17168a();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m13443V2();
        C11841o.m70705a();
        m13489G2();
        if (!C13452e.m80781L().m80842P0()) {
            finish();
            return;
        }
        m13453c3();
        m13448Z3(C10028c.m62182c0().m62413x());
        C11836j.m70658k().m70659a(this);
        C1006a.m5936k().m5949M(this, this.f10091S0);
        if (C1006a.m5936k().m5975v(this)) {
            if (this.f10133x0) {
                m13521W3();
            }
            if (C1006a.m5936k().m5939C()) {
                this.f10132x.m23910b();
            }
            m13483D3();
            m29143z0(HNConstants.DataType.MEDIA);
        }
        CloudAlbumSettings.m14363h().m14369d(getApplicationContext());
        m13522X2();
    }

    /* renamed from: p3 */
    public void m13550p3() throws SQLException {
        this.f10132x.m23909a();
        this.f10136z.setVisibility(8);
        this.f10062E.setVisibility(0);
        m13548n3("SmartAlbum", true);
        C13224c.m79487f1().m79600y("CLOUDBACKUP_CLOUDALBUM_OPEN_SMARTRECOGNITION", "1");
        UBAAnalyze.m29957R("PVC", "CLOUDBACKUP_CLOUDALBUM_OPEN_SMARTRECOGNITION", "1", "15", "value", "1");
        C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_intellegent", "1", "1", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_intellegent", "1", "15", "1", "1");
    }

    /* renamed from: q3 */
    public void m13551q3() {
        this.f10101a0 = true;
        this.f10128v.setCheckedProgrammatically(true);
    }

    /* renamed from: r3 */
    public void m13552r3() {
        m13553s3();
    }

    /* renamed from: s3 */
    public void m13553s3() {
        this.f10101a0 = true;
        C0214f0.m1382b(this, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("SwitchHelperUtilisCloudAlbumOn", false).commit();
        C1122c.m6792i2(false, this);
        C1136q.e.m7175m(false, this);
        C1120a.m6677i("GalleryMainActivity", "generalAlbumSwitch is off");
        if (C1006a.m5936k().m5939C()) {
            m13507P2();
        }
        m13527a3();
        C13222a.m79463e("CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this), this.f10079M0, this.f10087Q0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isAutoOpen", C13222a.m79466h(this.f10079M0));
        linkedHashMap.put("sourceType", C13222a.m79467i(this.f10087Q0));
        UBAAnalyze.m29958S("PVC", "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1", "15", linkedHashMap);
        C13224c.m79487f1().m79590k0("mecloud_gallerymain_still_click_switch", "2", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_gallerymain_still_click_switch", "1", "15", "2", "2", linkedHashMap);
        m13548n3("GeneralAblum", false);
        C10155f.m63262O(this, false);
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17118d(getApplication());
        }
        m13495J2();
        m13493I2();
        this.f10071I0 = false;
        this.f10075K0 = false;
        this.f10069H0 = 0;
        this.f10087Q0 = 0;
        this.f10079M0 = false;
    }

    /* renamed from: t3 */
    public final void m13554t3(boolean z10) throws SQLException {
        C1120a.m6675d("GalleryMainActivity", "gallery_main_share_intellegent_btn=" + z10);
        if (!C0209d.m1333z1(this)) {
            this.f10068H.m23919i();
            this.f10136z.setChecked(!z10);
            return;
        }
        this.f10068H.m23914a();
        if (z10) {
            this.f10101a0 = true;
            m13550p3();
        } else {
            this.f10101a0 = false;
            this.f10072J.show();
        }
    }

    /* renamed from: u3 */
    public final void m13555u3(boolean z10, boolean z11) throws Resources.NotFoundException, SQLException {
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17155v0(getApplication());
        }
        boolean zM6807m1 = C1122c.m6807m1(this);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", true);
        bundle.putBoolean("ShareAlbum", true);
        C13222a.m79463e("CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this), this.f10079M0, this.f10087Q0);
        UBAAnalyze.m29962W("PVC", "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1", "15", "1", C13222a.m79465g(this), this.f10079M0, this.f10087Q0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isAutoOpen", C13222a.m79466h(this.f10079M0));
        linkedHashMap.put("sourceType", C13222a.m79467i(this.f10087Q0));
        C13224c.m79487f1().m79590k0("mecloud_gallerymain_click_switch", "1", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_gallerymain_click_switch", "1", "15", "1", "1", linkedHashMap);
        C1007b.m5980s().m5996P(this.f10094U, "recommend_card_open_gallery_switch");
        C1122c.m6792i2(true, this);
        C1136q.e.m7175m(true, this);
        C1120a.m6677i("GalleryMainActivity", "generalAlbumSwitch is on");
        CloudAlbumManager.m14456v().m14470O(this, bundle, 4);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17109X(this, true);
        }
        this.f10128v.setCheckedProgrammatically(true);
        if (this.f10133x0) {
            m13521W3();
        }
        if (C1137r.m7180a()) {
            this.f10132x.m23910b();
            m13514S3();
        }
        m13483D3();
        if (this.f10082O) {
            m13519V3();
        } else {
            m13493I2();
        }
        m13495J2();
        C1120a.m6677i("GalleryMainActivity", "onMainSwitchOpen, isGeneralAlbumSwitchOpened=" + zM6807m1 + ", needToast=" + z11);
        if (!zM6807m1 && z11) {
            C12515a.m75110o().m75175e(new C2185c(z10), false);
        }
    }

    /* renamed from: v3 */
    public final void m13556v3() {
        getWindow().getDecorView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC2189g());
    }

    /* renamed from: w3 */
    public void m13557w3() {
        this.f10101a0 = true;
        this.f10136z.setCheckedProgrammatically(true);
    }

    /* renamed from: x3 */
    public void m13558x3() {
        this.f10101a0 = true;
        if (this.f10128v != null) {
            C0214f0.m1382b(this, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("SwitchHelperUtilisCloudAlbumOn", true).commit();
            this.f10128v.setCheckedProgrammatically(true);
        }
        C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_switch", "1", "1", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_switch", "1", "15", "1", "1");
    }

    /* renamed from: y3 */
    public void m13559y3() {
        this.f10102b0 = false;
        C1122c.m6800k2(getApplicationContext(), true);
        UnionSwitch unionSwitch = this.f10054A;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(true);
        }
        C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_mobile_network_switch", "1", "1", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_mobile_network_switch", "1", "15", "1", "1");
    }

    /* renamed from: z3 */
    public final void m13560z3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C1120a.m6676e("GalleryMainActivity", "cloudAlbumRouter is null");
        }
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58428g1(this, new C2183a());
        }
    }
}
