package com.huawei.android.p069cg.activity;

import android.accounts.OperationCanceledException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.BabyInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Message;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$menu;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.dialog.UpgradeAlbumSpaceDialog;
import com.huawei.android.p069cg.dialog.UploadInsufficientSpace;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.android.p069cg.p071ui.RecyclerMediaArtBlockAdapter;
import com.huawei.android.p069cg.p071ui.ShareAlbumTitleView;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwprogressbutton.widget.HwProgressButton;
import hu.C10343b;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1136q;
import p031b7.C1140u;
import p050c8.C1395a;
import p336he.C10159j;
import p471m6.C11415a;
import p486n6.DialogC11650o;
import p496nn.C11737b;
import p496nn.InterfaceC11736a;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p604r7.C12473f;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p742wj.C13612b;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumHomePageActivity extends UIActivity implements View.OnClickListener, DialogC11650o.a, InterfaceC13449b, PopupMenu.OnMenuItemClickListener {

    /* renamed from: A */
    public Animation f10364A;

    /* renamed from: A0 */
    public List<DayModeGroup> f10365A0;

    /* renamed from: B */
    public long f10366B;

    /* renamed from: B0 */
    public List<DayModeGroup> f10367B0;

    /* renamed from: C */
    public ImageView f10368C;

    /* renamed from: C0 */
    public Handler f10369C0;

    /* renamed from: D */
    public RelativeLayout f10370D;

    /* renamed from: D0 */
    public int f10371D0;

    /* renamed from: E */
    public RelativeLayout f10372E;

    /* renamed from: E0 */
    public ViewOnClickListenerC2256a f10373E0;

    /* renamed from: F */
    public RelativeLayout f10374F;

    /* renamed from: F0 */
    public boolean f10375F0;

    /* renamed from: G */
    public RelativeLayout f10376G;

    /* renamed from: G0 */
    public boolean f10377G0;

    /* renamed from: H */
    public C11415a f10378H;

    /* renamed from: I */
    public HwProgressButton f10380I;

    /* renamed from: I0 */
    public long f10381I0;

    /* renamed from: J */
    public HwProgressButton f10382J;

    /* renamed from: J0 */
    public UpgradeAlbumSpaceDialog f10383J0;

    /* renamed from: K */
    public HwProgressButton f10384K;

    /* renamed from: K0 */
    public Handler f10385K0;

    /* renamed from: L */
    public RelativeLayout f10386L;

    /* renamed from: L0 */
    public UploadInsufficientSpace f10387L0;

    /* renamed from: M */
    public TextView f10388M;

    /* renamed from: N */
    public CoordinatorLayout f10390N;

    /* renamed from: O */
    public ImageView f10392O;

    /* renamed from: O0 */
    public HandlerC2235o f10393O0;

    /* renamed from: P */
    public ImageView f10394P;

    /* renamed from: Q */
    public List<C11415a> f10396Q;

    /* renamed from: R */
    public GridLayoutManager f10397R;

    /* renamed from: S */
    public C2232l f10398S;

    /* renamed from: T */
    public String f10399T;

    /* renamed from: U */
    public String f10400U;

    /* renamed from: V */
    public String f10401V;

    /* renamed from: W */
    public ViewPager f10402W;

    /* renamed from: X */
    public TextView f10403X;

    /* renamed from: Y */
    public ImageView f10404Y;

    /* renamed from: Z */
    public ImageView f10405Z;

    /* renamed from: a0 */
    public RelativeLayout f10406a0;

    /* renamed from: b0 */
    public RelativeLayout f10407b0;

    /* renamed from: c0 */
    public RelativeLayout f10408c0;

    /* renamed from: d0 */
    public TextView f10409d0;

    /* renamed from: e0 */
    public TextView f10410e0;

    /* renamed from: f0 */
    public TextView f10411f0;

    /* renamed from: g0 */
    public TextView f10412g0;

    /* renamed from: h0 */
    public TextView f10413h0;

    /* renamed from: i0 */
    public ImageView f10414i0;

    /* renamed from: j0 */
    public ImageView f10415j0;

    /* renamed from: k0 */
    public ImageView f10416k0;

    /* renamed from: l0 */
    public ImageView f10417l0;

    /* renamed from: m0 */
    public int f10418m0;

    /* renamed from: n0 */
    public int f10419n0;

    /* renamed from: o0 */
    public Album f10420o0;

    /* renamed from: p */
    public RecyclerView f10421p;

    /* renamed from: p0 */
    public int f10422p0;

    /* renamed from: q */
    public RecyclerView f10423q;

    /* renamed from: q0 */
    public LocalReceiver f10424q0;

    /* renamed from: r */
    public C2230j f10425r;

    /* renamed from: r0 */
    public DialogC11650o f10426r0;

    /* renamed from: s */
    public RelativeLayout f10427s;

    /* renamed from: t */
    public RunnableC2229i f10429t;

    /* renamed from: t0 */
    public int f10430t0;

    /* renamed from: u */
    public PopupMenu f10431u;

    /* renamed from: u0 */
    public HashMap<String, Message> f10432u0;

    /* renamed from: v */
    public NotchFitRelativeLayout f10433v;

    /* renamed from: v0 */
    public boolean f10434v0;

    /* renamed from: w */
    public ImageView f10435w;

    /* renamed from: x */
    public RecyclerMediaArtBlockAdapter f10437x;

    /* renamed from: x0 */
    public boolean f10438x0;

    /* renamed from: y */
    public LinearLayout f10439y;

    /* renamed from: y0 */
    public boolean f10440y0;

    /* renamed from: z */
    public Animation f10441z;

    /* renamed from: z0 */
    public List<DayModeGroup> f10442z0;

    /* renamed from: s0 */
    public InterfaceC11736a f10428s0 = new C2221a();

    /* renamed from: w0 */
    public boolean f10436w0 = false;

    /* renamed from: H0 */
    public boolean f10379H0 = true;

    /* renamed from: M0 */
    public boolean f10389M0 = true;

    /* renamed from: N0 */
    public Handler f10391N0 = new HandlerC2222b();

    /* renamed from: P0 */
    public RecyclerMediaAdapter.InterfaceC2353e f10395P0 = new C2223c();

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C1120a.m6675d("ShareAlbumHomePageActivity", "onReceive: " + action);
            if ("album_status_change_action".equals(action)) {
                ShareAlbumHomePageActivity.this.m13830e3();
                return;
            }
            if ("album_background_change_action".equals(action)) {
                String stringExtra = safeIntent.getStringExtra("param_album_id");
                if (stringExtra == null || !stringExtra.equals(ShareAlbumHomePageActivity.this.f10399T)) {
                    return;
                }
                ShareAlbumHomePageActivity.this.m13763R2();
                return;
            }
            if ("com.huawei.hicloud.getShareAlbumList".equals(action)) {
                ShareAlbumHomePageActivity.this.m13826b3(C12091d.m72280a0().m72387t0());
            } else if ("com.huawei.hicloud.approveApplicant".equals(action)) {
                C12091d.m72280a0().m72384s0();
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$a */
    public class C2221a implements InterfaceC11736a {
        public C2221a() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: a */
        public void mo13316a() {
            C1120a.m6677i("ShareAlbumHomePageActivity", "onAlbumChanged");
            C12091d.m72280a0().m72384s0();
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: b */
        public void mo13317b() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: c */
        public void mo13318c() {
            C1120a.m6677i("ShareAlbumHomePageActivity", "onMediaChanged");
            C12091d c12091dM72280a0 = C12091d.m72280a0();
            ShareAlbumHomePageActivity shareAlbumHomePageActivity = ShareAlbumHomePageActivity.this;
            c12091dM72280a0.m72322P(shareAlbumHomePageActivity, shareAlbumHomePageActivity.f10399T, ShareAlbumHomePageActivity.this.f10371D0, ShareAlbumHomePageActivity.this.f10391N0);
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: d */
        public void mo13319d() {
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$b */
    public class HandlerC2222b extends Handler {
        public HandlerC2222b() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(android.os.Message message) {
            C1120a.m6677i("ShareAlbumHomePageActivity", "handleMessage " + message.what);
            int i10 = message.what;
            if (i10 == 1004) {
                String str = (String) message.obj;
                if (!str.equals(ShareAlbumHomePageActivity.this.f10399T)) {
                    C1120a.m6675d("ShareAlbumHomePageActivity", "MSG_ALBUM_SHARE_PHOTOS albumId= " + str + ", not equals orginId= " + ShareAlbumHomePageActivity.this.f10399T);
                    C12091d c12091dM72280a0 = C12091d.m72280a0();
                    ShareAlbumHomePageActivity shareAlbumHomePageActivity = ShareAlbumHomePageActivity.this;
                    c12091dM72280a0.m72322P(shareAlbumHomePageActivity, shareAlbumHomePageActivity.f10399T, ShareAlbumHomePageActivity.this.f10371D0, ShareAlbumHomePageActivity.this.f10391N0);
                    return;
                }
                ShareAlbumHomePageActivity.this.f10442z0 = C12091d.m72280a0().m72401z0(ShareAlbumHomePageActivity.this.f10399T);
                ShareAlbumHomePageActivity.this.f10365A0 = C12091d.m72280a0().m72401z0(ShareAlbumHomePageActivity.this.f10399T + "share_home_picture");
                ShareAlbumHomePageActivity.this.f10367B0 = C12091d.m72280a0().m72401z0(ShareAlbumHomePageActivity.this.f10399T + "share_home_vedio");
                if (message.arg1 == 0) {
                    ShareAlbumHomePageActivity.this.f10421p.setVisibility(8);
                    ShareAlbumHomePageActivity.this.f10427s.setVisibility(8);
                    ShareAlbumHomePageActivity.this.f10423q.setVisibility(0);
                    ShareAlbumHomePageActivity.this.m13841o3();
                    return;
                }
                ShareAlbumHomePageActivity.this.f10421p.setVisibility(0);
                ShareAlbumHomePageActivity.this.f10427s.setVisibility(0);
                ShareAlbumHomePageActivity.this.f10423q.setVisibility(8);
                ShareAlbumHomePageActivity.this.m13852x3("", false);
                return;
            }
            if (i10 == 1030) {
                ShareAlbumHomePageActivity.this.f10432u0 = (HashMap) message.obj;
                ShareAlbumHomePageActivity.this.f10438x0 = true;
                ShareAlbumHomePageActivity.this.m13812O2();
                return;
            }
            if (i10 == 1024) {
                List list = (List) message.obj;
                if (list == null || list.size() == 0) {
                    ShareAlbumHomePageActivity.this.f10386L.setVisibility(8);
                    return;
                }
                if (list.size() > 0) {
                    if (!TextUtils.equals(ShareAlbumHomePageActivity.this.f10399T, ((MediaFileBean) list.get(0)).m14322a().getId())) {
                        C1120a.m6676e("ShareAlbumHomePageActivity", "not  current album");
                        return;
                    }
                }
                C1395a c1395aM484E = C0069g.m479y().m484E(ShareAlbumHomePageActivity.this.f10399T);
                if (c1395aM484E != null) {
                    ShareAlbumHomePageActivity.this.f10418m0 = c1395aM484E.m7976i();
                    ShareAlbumHomePageActivity.this.f10419n0 = c1395aM484E.m7975h();
                }
                ShareAlbumHomePageActivity.this.m13828d3();
                ShareAlbumHomePageActivity.this.m13830e3();
                return;
            }
            if (i10 == 1027) {
                ShareAlbumHomePageActivity.this.m13811N2(((Integer) message.obj).intValue());
                return;
            }
            if (i10 == 1035) {
                C1120a.m6675d("ShareAlbumHomePageActivity", "MSG_ADD_UPLOAD_TASK_FINISH result=" + message.arg1);
                if (message.arg1 == 1) {
                    return;
                }
                C12091d c12091dM72280a02 = C12091d.m72280a0();
                ShareAlbumHomePageActivity shareAlbumHomePageActivity2 = ShareAlbumHomePageActivity.this;
                c12091dM72280a02.m72322P(shareAlbumHomePageActivity2, shareAlbumHomePageActivity2.f10399T, ShareAlbumHomePageActivity.this.f10371D0, ShareAlbumHomePageActivity.this.f10391N0);
                return;
            }
            if (i10 == 1046) {
                ShareAlbumHomePageActivity.this.m13825a3((Album) message.obj);
                return;
            }
            if (i10 == 1047) {
                String str2 = (String) message.obj;
                if (TextUtils.equals("4041", str2) || TextUtils.equals("4036", str2)) {
                    ShareAlbumHomePageActivity shareAlbumHomePageActivity3 = ShareAlbumHomePageActivity.this;
                    C11841o.m70706b(shareAlbumHomePageActivity3, shareAlbumHomePageActivity3.getString(R$string.file_load_failed), 0);
                    C12473f.m74865c().m74868e();
                    ShareAlbumHomePageActivity.this.finish();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$c */
    public class C2223c implements RecyclerMediaAdapter.InterfaceC2353e {
        public C2223c() {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: a */
        public void mo13635a(View view, int i10) {
            BabyInfo babyInfo;
            C4644l birthday;
            if (C0209d.m1226Y0()) {
                return;
            }
            boolean z10 = false;
            if (ShareAlbumHomePageActivity.this.f10378H != null && ShareAlbumHomePageActivity.this.f10378H.m68362a().getShareType().intValue() == 1) {
                z10 = true;
            }
            long jM28458c = (!z10 || ShareAlbumHomePageActivity.this.f10420o0 == null || (babyInfo = ShareAlbumHomePageActivity.this.f10420o0.getBabyInfo()) == null || (birthday = babyInfo.getBirthday()) == null) ? 0L : birthday.m28458c();
            if (ShareAlbumHomePageActivity.this.f10379H0) {
                MediaFileBean mediaFileBean = ShareAlbumHomePageActivity.this.f10437x.m14759L().get(Integer.valueOf(i10));
                Intent intent = new Intent(ShareAlbumHomePageActivity.this, (Class<?>) PicTabAlbumFileViewActivity.class);
                intent.putExtra("param_media_index", i10);
                intent.putExtra("param_is_viewer_sum_number", ShareAlbumHomePageActivity.this.f10437x.m14687A0());
                intent.putExtra("param_is_only_pic", ShareAlbumHomePageActivity.this.f10375F0);
                intent.putExtra("param_is_only_video", ShareAlbumHomePageActivity.this.f10377G0);
                intent.putExtra("param_is_baby_mode", z10);
                intent.putExtra("param_is_baby_birthday_mills", jM28458c);
                intent.putExtra("param_album_id", ShareAlbumHomePageActivity.this.f10399T);
                ShareAlbumHomePageActivity.this.startActivityForResult(intent, 306);
                ShareAlbumHomePageActivity shareAlbumHomePageActivity = ShareAlbumHomePageActivity.this;
                shareAlbumHomePageActivity.m13834i3(shareAlbumHomePageActivity.m13804H2(mediaFileBean));
                return;
            }
            Object objM14761R = ShareAlbumHomePageActivity.this.f10437x.m14761R(i10);
            if (objM14761R instanceof RecyclerMediaAdapter.C2356h) {
                RecyclerMediaAdapter.C2356h c2356h = (RecyclerMediaAdapter.C2356h) objM14761R;
                if (c2356h.m14792a() == null) {
                    C1120a.m6676e("ShareAlbumHomePageActivity", "data not ready");
                    return;
                }
                Intent intent2 = new Intent(ShareAlbumHomePageActivity.this, (Class<?>) PicTabAlbumFileViewActivity.class);
                intent2.putExtra("param_media_index", c2356h.m14794c());
                intent2.putExtra("param_is_viewer_sum_number", ShareAlbumHomePageActivity.this.f10437x.m14687A0());
                intent2.putExtra("param_is_only_pic", ShareAlbumHomePageActivity.this.f10375F0);
                intent2.putExtra("param_is_only_video", ShareAlbumHomePageActivity.this.f10377G0);
                intent2.putExtra("param_is_baby_mode", z10);
                intent2.putExtra("param_is_baby_birthday_mills", jM28458c);
                intent2.putExtra("param_album_id", ShareAlbumHomePageActivity.this.f10399T);
                ShareAlbumHomePageActivity.this.startActivityForResult(intent2, 306);
                ShareAlbumHomePageActivity shareAlbumHomePageActivity2 = ShareAlbumHomePageActivity.this;
                shareAlbumHomePageActivity2.m13834i3(shareAlbumHomePageActivity2.m13804H2(c2356h.m14792a()));
            }
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: b */
        public void mo13636b(View view, int i10) {
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$d */
    public class C2224d extends RecyclerView.AbstractC0850t {
        public C2224d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            if (i11 < 0) {
                ShareAlbumHomePageActivity.this.f10437x.m14698K0(false);
                ShareAlbumHomePageActivity.this.m13851w3();
            } else if (i11 > 0) {
                ShareAlbumHomePageActivity.this.f10437x.m14698K0(true);
                ShareAlbumHomePageActivity.this.m13813P2();
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$e */
    public class AnimationAnimationListenerC2225e implements Animation.AnimationListener {
        public AnimationAnimationListenerC2225e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ShareAlbumHomePageActivity.this.f10427s.setAlpha(0.0f);
            ShareAlbumHomePageActivity.this.f10427s.setVisibility(8);
            ShareAlbumHomePageActivity.this.f10427s.setClickable(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$f */
    public class AnimationAnimationListenerC2226f implements Animation.AnimationListener {
        public AnimationAnimationListenerC2226f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ShareAlbumHomePageActivity.this.f10427s.setAlpha(1.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$g */
    public class C2227g implements ViewOnClickListenerC2256a.d {
        public C2227g() {
        }

        @Override // com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.d
        /* renamed from: a */
        public void mo13855a(long j10, boolean z10, boolean z11) {
            C1120a.m6675d("ShareAlbumHomePageActivity", "onSelectDate mills " + j10);
            String strM63325a = C10159j.m63325a(C0213f.m1377a(), j10, C11842p.m70828k());
            C1120a.m6675d("ShareAlbumHomePageActivity", "onSelectDate selectMillsStr " + strM63325a);
            ShareAlbumHomePageActivity.this.f10375F0 = z10;
            ShareAlbumHomePageActivity.this.f10377G0 = z11;
            ShareAlbumHomePageActivity.this.f10437x.m14824e1(ShareAlbumHomePageActivity.this.f10375F0);
            ShareAlbumHomePageActivity.this.f10437x.m14825f1(ShareAlbumHomePageActivity.this.f10377G0);
            ShareAlbumHomePageActivity.this.m13852x3(strM63325a, true);
        }

        @Override // com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.d
        /* renamed from: b */
        public void mo13856b(boolean z10) {
            ShareAlbumHomePageActivity.this.f10379H0 = z10;
            ShareAlbumHomePageActivity.this.m13852x3("", false);
        }

        @Override // com.huawei.android.p069cg.activity.ViewOnClickListenerC2256a.d
        /* renamed from: c */
        public void mo13857c(boolean z10, boolean z11) {
            ShareAlbumHomePageActivity.this.f10435w.setSelected(true);
            ShareAlbumHomePageActivity.this.f10375F0 = z10;
            ShareAlbumHomePageActivity.this.f10377G0 = z11;
            ShareAlbumHomePageActivity.this.f10437x.m14824e1(ShareAlbumHomePageActivity.this.f10375F0);
            ShareAlbumHomePageActivity.this.f10437x.m14825f1(ShareAlbumHomePageActivity.this.f10377G0);
            ShareAlbumHomePageActivity.this.m13852x3("", false);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$h */
    public static class C2228h implements ViewPager.InterfaceC0980i {

        /* renamed from: a */
        public ViewPager f10451a;

        /* renamed from: b */
        public ShareAlbumHomePageActivity f10452b;

        /* renamed from: c */
        public int f10453c = -1;

        /* renamed from: d */
        public int f10454d = -1;

        public C2228h(ShareAlbumHomePageActivity shareAlbumHomePageActivity, ViewPager viewPager) {
            this.f10451a = viewPager;
            this.f10452b = shareAlbumHomePageActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 2) {
                C1120a.m6677i("ShareAlbumHomePageActivity", "childcount：" + this.f10451a.getChildCount());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 == 0.0f) {
                this.f10452b.m13815Q2();
                this.f10453c = -1;
                this.f10454d = -1;
                return;
            }
            if (this.f10453c == -1) {
                this.f10453c = i11;
                this.f10454d = i10;
            }
            if (i10 < 0 || i10 >= this.f10451a.getAdapter().getCount()) {
                return;
            }
            this.f10452b.m13839m3(i11, this.f10453c, this.f10454d);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            C1120a.m6677i("ShareAlbumHomePageActivity", "onPageSelected：" + i10);
            C13224c.m79487f1().m79593q0("SCROLL_SHARE_ALBUM_VIEPAGER");
            this.f10452b.m13832g3();
            this.f10452b.m13837l3(i10);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$i */
    public static class RunnableC2229i implements Runnable {

        /* renamed from: a */
        public WeakReference<Handler> f10455a;

        /* renamed from: b */
        public WeakReference<TextView> f10456b;

        /* renamed from: c */
        public boolean f10457c;

        public /* synthetic */ RunnableC2229i(Handler handler, TextView textView, C2221a c2221a) {
            this(handler, textView);
        }

        /* renamed from: a */
        public void m13858a() {
            Handler handler = this.f10455a.get();
            if (handler == null || this.f10457c) {
                return;
            }
            this.f10457c = true;
            handler.removeCallbacks(this);
            handler.postDelayed(this, 5000L);
            C1120a.m6675d("ShareAlbumHomePageActivity", "Begin To AutoRoll");
        }

        /* renamed from: c */
        public void m13859c() {
            Handler handler = this.f10455a.get();
            if (handler == null || !this.f10457c) {
                return;
            }
            handler.removeCallbacks(this);
            this.f10457c = false;
            C1120a.m6675d("ShareAlbumHomePageActivity", "Stop To AutoRoll");
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.f10456b.get();
            Handler handler = this.f10455a.get();
            if (textView == null || handler == null) {
                return;
            }
            if (this.f10457c) {
                textView.setVisibility(8);
            }
            handler.postDelayed(this, 5000L);
        }

        public RunnableC2229i(Handler handler, TextView textView) {
            this.f10457c = false;
            this.f10455a = new WeakReference<>(handler);
            this.f10456b = new WeakReference<>(textView);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$j */
    public static class C2230j extends RecyclerView.AbstractC0838h {

        /* renamed from: d */
        public Context f10458d;

        /* renamed from: e */
        public LayoutInflater f10459e;

        /* renamed from: f */
        public String f10460f;

        /* renamed from: g */
        public String f10461g;

        /* renamed from: h */
        public View.OnClickListener f10462h;

        public C2230j(Context context, View.OnClickListener onClickListener) {
            this.f10459e = LayoutInflater.from(context);
            this.f10458d = context;
            this.f10462h = onClickListener;
        }

        /* renamed from: D */
        public void m13860D(String str) {
            this.f10460f = str;
        }

        /* renamed from: E */
        public void m13861E(String str) {
            this.f10461g = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: e */
        public int mo721e() {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: s */
        public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
            if (abstractC0833c0 instanceof C2231k) {
                C2231k c2231k = (C2231k) abstractC0833c0;
                c2231k.f10463u.setOnClickListener(this.f10462h);
                c2231k.f10465w.setText(this.f10460f);
                c2231k.f10464v.setText(this.f10461g);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: u */
        public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
            return new C2231k(this.f10459e.inflate(R$layout.album_no_photo_layout, viewGroup, false), this.f10458d);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$k */
    public static class C2231k extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public Button f10463u;

        /* renamed from: v */
        public TextView f10464v;

        /* renamed from: w */
        public TextView f10465w;

        public C2231k(View view, Context context) {
            super(view);
            this.f10463u = (Button) C12809f.m76831d(view, R$id.album_upload_button);
            this.f10464v = (TextView) C12809f.m76831d(view, R$id.tv_upload_now);
            this.f10465w = (TextView) C12809f.m76831d(view, R$id.tv_create_finish);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$l */
    public static class C2232l extends AbstractC0984a {

        /* renamed from: h */
        public List<C11415a> f10466h;

        /* renamed from: i */
        public View.OnClickListener f10467i;

        /* renamed from: j */
        public Context f10468j;

        public C2232l(Context context, List<C11415a> list, View.OnClickListener onClickListener) {
            this.f10468j = context;
            this.f10466h = list;
            this.f10467i = onClickListener;
        }

        /* renamed from: a */
        public void m13862a(List<C11415a> list) {
            this.f10466h = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj == null || !(obj instanceof ShareAlbumTitleView)) {
                return;
            }
            viewGroup.removeView((ShareAlbumTitleView) obj);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            List<C11415a> list = this.f10466h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            List<C11415a> list = this.f10466h;
            if (list == null || list.isEmpty() || this.f10466h.size() <= i10) {
                return new ShareAlbumTitleView(this.f10468j, this.f10466h.get(i10), this.f10467i);
            }
            ShareAlbumTitleView shareAlbumTitleView = new ShareAlbumTitleView(this.f10468j, this.f10466h.get(i10), this.f10467i);
            shareAlbumTitleView.setTag(Integer.valueOf(i10));
            viewGroup.addView(shareAlbumTitleView);
            return shareAlbumTitleView;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$m */
    public static class C2233m extends GridLayoutManager {
        public C2233m(Activity activity) {
            super(activity, 3);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$n */
    public class HandlerC2234n extends Handler {

        /* renamed from: a */
        public WeakReference<RecyclerMediaArtBlockAdapter> f10469a;

        public /* synthetic */ HandlerC2234n(ShareAlbumHomePageActivity shareAlbumHomePageActivity, RecyclerMediaArtBlockAdapter recyclerMediaArtBlockAdapter, C2221a c2221a) {
            this(recyclerMediaArtBlockAdapter);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            RecyclerMediaArtBlockAdapter recyclerMediaArtBlockAdapter;
            if (message.what != 1042 || (recyclerMediaArtBlockAdapter = this.f10469a.get()) == null) {
                return;
            }
            int iFindFirstVisibleItemPosition = ShareAlbumHomePageActivity.this.f10397R.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = ShareAlbumHomePageActivity.this.f10397R.findLastVisibleItemPosition();
            C1120a.m6675d("ShareAlbumHomePageActivity", "set pic, firstVisible = " + iFindFirstVisibleItemPosition + ", lastVisible = " + iFindLastVisibleItemPosition);
            while (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                recyclerMediaArtBlockAdapter.mo723s(ShareAlbumHomePageActivity.this.f10421p.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition), iFindFirstVisibleItemPosition);
                iFindFirstVisibleItemPosition++;
            }
        }

        public HandlerC2234n(RecyclerMediaArtBlockAdapter recyclerMediaArtBlockAdapter) {
            super(ShareAlbumHomePageActivity.this.getMainLooper());
            this.f10469a = new WeakReference<>(recyclerMediaArtBlockAdapter);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumHomePageActivity$o */
    public class HandlerC2235o extends C0069g.c {
        public HandlerC2235o() {
        }

        @Override // p009a8.C0069g.c
        /* renamed from: a */
        public boolean mo519a() {
            return false;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i10 = message.what;
            if (i10 == 100) {
                MediaFileBean mediaFileBean = (MediaFileBean) message.obj;
                int i11 = message.arg2;
                if (i11 == 1003) {
                    ShareAlbumHomePageActivity.this.m13799B3();
                } else if (i11 == 1007) {
                    ShareAlbumHomePageActivity shareAlbumHomePageActivity = ShareAlbumHomePageActivity.this;
                    C11841o.m70706b(shareAlbumHomePageActivity, shareAlbumHomePageActivity.getString(R$string.album_no_upload_permission), 0);
                }
                if (mediaFileBean != null) {
                    C1120a.m6675d("ShareAlbumHomePageActivity", "MSG_UPLOAD_TASK_CHANGED fileName=" + mediaFileBean.m14331f());
                    int iFindFirstVisibleItemPosition = ShareAlbumHomePageActivity.this.f10397R.findFirstVisibleItemPosition();
                    int iFindLastVisibleItemPosition = ShareAlbumHomePageActivity.this.f10397R.findLastVisibleItemPosition();
                    C1120a.m6675d("ShareAlbumHomePageActivity", "refresh pic, firstVisible = " + iFindFirstVisibleItemPosition + ", lastVisible = " + iFindLastVisibleItemPosition);
                    while (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && !ShareAlbumHomePageActivity.this.f10437x.mo14690D0(iFindFirstVisibleItemPosition)) {
                        iFindFirstVisibleItemPosition++;
                    }
                    return;
                }
                return;
            }
            if (i10 == 101) {
                C1395a c1395a = (C1395a) message.obj;
                if (!TextUtils.equals(ShareAlbumHomePageActivity.this.f10399T, c1395a.m7972e())) {
                    C1120a.m6676e("ShareAlbumHomePageActivity", "not  current album");
                    ShareAlbumHomePageActivity.this.f10386L.setVisibility(8);
                    return;
                }
                C1120a.m6675d("ShareAlbumHomePageActivity", "MSG_ALBUM_UPLOAD_TASK_CHANGED totalNum=" + c1395a.m7976i() + ", succeedNum=" + c1395a.m7975h() + ", failedNum=" + c1395a.m7973f() + ", pausedNum=" + c1395a.m7974g());
                ShareAlbumHomePageActivity.this.f10418m0 = c1395a.m7976i();
                ShareAlbumHomePageActivity.this.f10419n0 = c1395a.m7975h();
                if (ShareAlbumHomePageActivity.this.f10419n0 == ShareAlbumHomePageActivity.this.f10418m0) {
                    C1120a.m6677i("ShareAlbumHomePageActivity", "upload finish");
                    C12091d.m72280a0().m72384s0();
                }
                ShareAlbumHomePageActivity.this.f10381I0 = c1395a.m7977j();
                ShareAlbumHomePageActivity.this.m13830e3();
            }
        }

        public /* synthetic */ HandlerC2235o(ShareAlbumHomePageActivity shareAlbumHomePageActivity, C2221a c2221a) {
            this();
        }
    }

    /* renamed from: R2 */
    public void m13763R2() {
        C12091d.m72280a0().m72384s0();
        C12091d.m72280a0().m72322P(this, this.f10399T, this.f10371D0, this.f10391N0);
        C12091d.m72280a0().m72295A0(this.f10391N0);
        C13612b.m81829B().m81847J(this);
    }

    /* renamed from: A3 */
    public final void m13798A3() {
        List<DayModeGroup> list = this.f10442z0;
        if (list == null || list.size() == 0) {
            C1120a.m6676e("ShareAlbumHomePageActivity", "showFilterDialog no photo data");
            return;
        }
        if (this.f10378H == null) {
            C1120a.m6676e("ShareAlbumHomePageActivity", "showFilterDialog albumBean is null");
            return;
        }
        C13224c.m79487f1().m79593q0("CLICK_SHARE_ALBUM_FILTER");
        List<Long> listM13803G2 = m13803G2();
        Collections.sort(listM13803G2);
        Collections.reverse(listM13803G2);
        this.f10373E0.m14045Q(this.f10378H.m68362a(), listM13803G2, this.f10375F0, this.f10377G0, this.f10379H0, new C2227g());
        this.f10373E0.m14056b0();
    }

    /* renamed from: B3 */
    public final void m13799B3() {
        if (isFinishing() || isDestroyed()) {
            C1120a.m6678w("ShareAlbumHomePageActivity", "showSpaceNotEnoughDialog activity is finishing or destroyed");
            return;
        }
        boolean zEquals = this.f10400U.equals(C13452e.m80781L().m80971t0());
        C1120a.m6677i("ShareAlbumHomePageActivity", "showSpaceNotEnoughDialog isOwner=" + zEquals);
        if (zEquals) {
            if (this.f10383J0 == null) {
                this.f10383J0 = new UpgradeAlbumSpaceDialog(this);
            }
            if (this.f10383J0.isShowing()) {
                return;
            }
            this.f10383J0.show();
            C13224c.m79487f1().m79593q0("SHOW_SPACE_NOT_ENOUGH_DIALOG");
            return;
        }
        if (this.f10387L0 == null) {
            this.f10387L0 = new UploadInsufficientSpace(this);
        }
        if (this.f10387L0.isShowing()) {
            return;
        }
        C13224c.m79487f1().m79593q0("SHOW_SPACE_NOT_ENOUGH_DIALOG");
        this.f10387L0.show();
    }

    /* renamed from: C3 */
    public final void m13800C3() {
        PermissionUpdateRequest permissionUpdateRequest = new PermissionUpdateRequest();
        HashMap map = new HashMap();
        map.put("last_vist_time", new C4644l(System.currentTimeMillis()).toString());
        permissionUpdateRequest.setProperties(map);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0)) {
            return;
        }
        C12091d.m72280a0().m72370n1(this.f10399T, this.f10378H.m68362a().getAlbumOwnerId(), strM80971t0, permissionUpdateRequest, this.f10391N0);
    }

    /* renamed from: E2 */
    public final void m13801E2() {
        Intent intent = new Intent(this, (Class<?>) ShareAlbumManageActivity.class);
        intent.putExtra("param_album_id", this.f10399T);
        startActivity(intent);
    }

    /* renamed from: F2 */
    public final void m13802F2(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view, 8388613);
        this.f10431u = popupMenu;
        popupMenu.getMenuInflater().inflate(R$menu.album_home_menu, this.f10431u.getMenu());
        MenuItem menuItemFindItem = this.f10431u.getMenu().findItem(R$id.top_album);
        if (this.f10399T.equals(C1136q.d.m7155s())) {
            menuItemFindItem.setTitle(R$string.cancel_topping);
        } else {
            menuItemFindItem.setTitle(R$string.top_album);
        }
        this.f10431u.setOnMenuItemClickListener(this);
        this.f10431u.show();
    }

    /* renamed from: G2 */
    public final List<Long> m13803G2() {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<DayModeGroup> list = this.f10375F0 ? this.f10365A0 : this.f10377G0 ? this.f10367B0 : this.f10442z0;
        if (list == null || list.size() == 0) {
            C1120a.m6676e("ShareAlbumHomePageActivity", "gatherFilterMillsData tempBeans is null");
            return arrayList;
        }
        for (DayModeGroup dayModeGroup : list) {
            C1120a.m6675d("ShareAlbumHomePageActivity", "showFilterDialog DayMode: " + dayModeGroup.getDayMode());
            try {
                String str = simpleDateFormat.format(new Date(new SimpleDateFormat(C1529a.f6579e).parse(dayModeGroup.getDayMode()).getTime()));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(str));
                long timeInMillis = calendar.getTimeInMillis();
                C1120a.m6675d("ShareAlbumHomePageActivity", "showFilterDialog transMills: " + timeInMillis);
                arrayList.add(Long.valueOf(timeInMillis));
            } catch (Exception e10) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "showFilterDialog: " + e10.getMessage());
            }
        }
        return arrayList;
    }

    /* renamed from: H2 */
    public final String m13804H2(MediaFileBean mediaFileBean) {
        return mediaFileBean == null ? "" : mediaFileBean.m14338j() == 4 ? "0" : mediaFileBean.m14338j() == 5 ? "1" : "2";
    }

    /* renamed from: I2 */
    public final int m13805I2() {
        Map<Integer, Integer> mapM14819Y0;
        int iFindFirstVisibleItemPosition = this.f10397R.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.f10397R.findLastVisibleItemPosition();
        C1120a.m6675d("ShareAlbumHomePageActivity", "set pic, firstVisible = " + iFindFirstVisibleItemPosition + ", lastVisible = " + iFindLastVisibleItemPosition);
        int i10 = iFindFirstVisibleItemPosition;
        while (true) {
            if (i10 < 0 || i10 > iFindLastVisibleItemPosition || i10 > iFindFirstVisibleItemPosition + 1) {
                break;
            }
            if (this.f10437x.m14764Y(i10)) {
                iFindFirstVisibleItemPosition = i10;
                break;
            }
            i10++;
        }
        return (!this.f10379H0 || (mapM14819Y0 = this.f10437x.m14819Y0()) == null) ? iFindFirstVisibleItemPosition : m13806J2(mapM14819Y0, iFindFirstVisibleItemPosition);
    }

    /* renamed from: J2 */
    public final int m13806J2(Map<Integer, Integer> map, int i10) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == i10) {
                return entry.getKey().intValue();
            }
        }
        return i10;
    }

    /* renamed from: K2 */
    public final boolean m13807K2(List<DayModeGroup> list) {
        if (list.size() >= 3) {
            return true;
        }
        Iterator<DayModeGroup> it = list.iterator();
        int count = 0;
        while (it.hasNext()) {
            count += it.next().getCount();
        }
        if (list.size() != 2 || (list.get(0).getCount() < 4 && list.get(1).getCount() < 4)) {
            return list.size() == 1 && count > 7;
        }
        return true;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        this.f10434v0 = true;
    }

    /* renamed from: L2 */
    public final String m13809L2() {
        return this.f10420o0.getShareType().intValue() == 1 ? "1" : "0";
    }

    /* renamed from: M2 */
    public final void m13810M2(boolean z10, List<DayModeGroup> list) {
        if (z10) {
            if (list.size() > 0) {
                this.f10437x.m14753D(getString(R$string.album_bottom_content, getString(R$string.album_bottom)));
                return;
            } else {
                this.f10437x.m14767b0();
                return;
            }
        }
        if (m13807K2(list)) {
            this.f10437x.m14753D(getString(R$string.album_bottom_content, getString(R$string.album_bottom)));
        } else {
            this.f10437x.m14767b0();
        }
    }

    /* renamed from: N2 */
    public final void m13811N2(int i10) {
        if (i10 > 0) {
            this.f10414i0.setVisibility(0);
            this.f10415j0.setVisibility(0);
        } else {
            this.f10414i0.setVisibility(8);
            this.f10415j0.setVisibility(8);
        }
    }

    /* renamed from: O2 */
    public final void m13812O2() {
        if (this.f10438x0 && this.f10440y0 && this.f10434v0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jM6961b = C1136q.m6961b("jion_close_time" + this.f10378H.m68362a().getId());
            if (this.f10432u0.get(this.f10399T) != null && jCurrentTimeMillis >= jM6961b) {
                Message message = this.f10432u0.get(this.f10399T);
                C12091d.m72280a0().m72296B(message.getSenderId(), this.f10417l0);
                this.f10372E.setVisibility(0);
                this.f10374F.setVisibility(8);
                this.f10412g0.setText(R$string.album_new_member_join);
                this.f10413h0.setText(getString(R$string.album_welcome_jion_album, message.getSenderName()));
                this.f10374F.setVisibility(8);
                this.f10408c0.setVisibility(8);
                C12091d.m72280a0().m72347c1(message.getMessageId());
                return;
            }
            this.f10372E.setVisibility(8);
            long jM6961b2 = C1136q.m6961b("invite_close_time" + this.f10378H.m68362a().getId());
            if (jCurrentTimeMillis > jM6961b2 && this.f10378H.m68365d() == 1) {
                this.f10374F.setVisibility(0);
                this.f10408c0.setVisibility(8);
                return;
            }
            if (jCurrentTimeMillis > jM6961b2) {
                this.f10374F.setVisibility(8);
            }
            if (jCurrentTimeMillis > C1136q.m6961b("upload_close_time") && this.f10436w0) {
                this.f10408c0.setVisibility(0);
            } else if (jCurrentTimeMillis > jM6961b2) {
                this.f10408c0.setVisibility(8);
            }
        }
    }

    /* renamed from: P2 */
    public final void m13813P2() {
        if ((!this.f10441z.hasStarted() || this.f10441z.hasEnded()) && this.f10427s.getAlpha() >= 1.0f) {
            this.f10441z.setAnimationListener(new AnimationAnimationListenerC2225e());
            this.f10427s.startAnimation(this.f10441z);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    /* renamed from: Q2 */
    public final void m13815Q2() {
        this.f10392O.setAlpha(1.0f);
        this.f10394P.setImageResource(R$color.transparent);
    }

    /* renamed from: S2 */
    public final void m13816S2() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getColor(R$color.color_F1DDDF));
        gradientDrawable.setCornerRadius(getResources().getDimension(R$dimen.cs_12_dp));
        this.f10384K.setProgressButtonBackgroundDrawable(new ClipDrawable(gradientDrawable, 8388611, 1));
    }

    /* renamed from: T2 */
    public final void m13817T2() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f10441z = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.f10441z.setFillAfter(true);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f10364A = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f10364A.setFillAfter(true);
    }

    /* renamed from: U2 */
    public final void m13818U2() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getColor(R$color.color_D3E6F5));
        gradientDrawable.setCornerRadius(getResources().getDimension(R$dimen.cs_12_dp));
        this.f10380I.setProgressButtonBackgroundDrawable(new ClipDrawable(gradientDrawable, 8388611, 1));
    }

    /* renamed from: V2 */
    public final void m13819V2() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getColor(R$color.color_F2E8DC));
        gradientDrawable.setCornerRadius(getResources().getDimension(R$dimen.cs_12_dp));
        this.f10382J.setProgressButtonBackgroundDrawable(new ClipDrawable(gradientDrawable, 8388611, 1));
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
    }

    /* renamed from: W2 */
    public final boolean m13821W2(String str, DayModeGroup dayModeGroup) {
        BabyInfo babyInfo;
        String dayMode = dayModeGroup.getDayMode();
        if (str.equals(this.f10437x.m14700z0(dayMode))) {
            return true;
        }
        Album album = this.f10420o0;
        return str.equals(this.f10437x.m14688B0(dayMode, (album == null || (babyInfo = album.getBabyInfo()) == null) ? null : babyInfo.getBirthday()));
    }

    /* renamed from: X2 */
    public final void m13822X2() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        if (!CloudAlbumSettings.m14363h().m14384t()) {
            C12091d.m72280a0().m72303E0(this, 100);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) UploadShareAlbumActivity.class);
        intent.putExtra("param_album_id", this.f10399T);
        intent.putExtra("is_from_create_entry", false);
        startActivity(intent);
        finish();
    }

    /* renamed from: Y2 */
    public final void m13823Y2(Intent intent) {
        C1120a.m6677i("ShareAlbumHomePageActivity", "reFreshBabyCover");
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("param_media_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.f10378H.m68362a().setCoverImage(stringExtra);
                View viewFindViewWithTag = this.f10402W.findViewWithTag(Integer.valueOf(this.f10430t0));
                if (viewFindViewWithTag instanceof ShareAlbumTitleView) {
                    ((ShareAlbumTitleView) viewFindViewWithTag).m14860b();
                }
            } catch (Exception e10) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "reFreshBabyCover exception: " + e10.toString());
            }
        }
    }

    /* renamed from: Z2 */
    public final void m13824Z2(C11415a c11415a) {
        if (c11415a == null) {
            return;
        }
        C1120a.m6675d("ShareAlbumHomePageActivity", "refreshAlbumBean coverImage: " + c11415a.m68362a().getCoverImage());
        m13812O2();
        this.f10378H = c11415a;
        this.f10400U = c11415a.m68362a().getAlbumOwnerId();
        C12091d.m72280a0().m72343Z0(c11415a.m68362a().getPermissions());
        C12091d.m72280a0();
        C12091d.m72281a1(c11415a);
        if (C12091d.m72280a0().m72311I0(c11415a.m68362a())) {
            C12091d.m72280a0().m72398y(c11415a.m68362a().getBackgroundImage(), this.f10392O);
        } else {
            try {
                if (c11415a.m68362a().getShareType().intValue() == 1) {
                    this.f10392O.setImageDrawable(getDrawable(R$drawable.baby_album_bg));
                } else {
                    this.f10392O.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
                }
            } catch (Exception e10) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "key-value key is null:" + e10.getMessage());
                this.f10392O.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
            }
        }
        this.f10403X.setText(c11415a.m68363b());
        boolean z10 = c11415a.m68362a().getShareType().intValue() == 1;
        this.f10437x.m14769d0(z10);
        m13842p3(z10);
        m13812O2();
        m13800C3();
        m13825a3(c11415a.m68362a());
        C12091d.m72280a0().m72308H(c11415a.m68362a().getId(), c11415a.m68362a().getAlbumOwnerId(), this.f10391N0);
    }

    /* renamed from: a3 */
    public final void m13825a3(Album album) {
        this.f10389M0 = true;
        if (album == null) {
            C1120a.m6678w("ShareAlbumHomePageActivity", "refreshCanUpload album is null");
            return;
        }
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (!strM80971t0.equals(album.getAlbumOwnerId())) {
            if (album.getPrivilege().intValue() == 0) {
                Iterator<Permission> it = album.getPermissions().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Permission next = it.next();
                    if (next.getUserId().equals(strM80971t0)) {
                        this.f10389M0 = next.canUpload();
                        break;
                    }
                }
            } else {
                this.f10389M0 = false;
            }
        }
        C1120a.m6675d("ShareAlbumHomePageActivity", "refreshCanUpload:" + this.f10389M0);
    }

    /* renamed from: b3 */
    public final void m13826b3(List<C11415a> list) throws Resources.NotFoundException {
        m13827c3(list);
        this.f10396Q = list;
        if (list == null) {
            C1120a.m6677i("ShareAlbumHomePageActivity", "albumList null");
            return;
        }
        if (list.size() == 0) {
            C1120a.m6677i("ShareAlbumHomePageActivity", "albumList size invalid");
            return;
        }
        Iterator<C11415a> it = this.f10396Q.iterator();
        int i10 = 0;
        while (it.hasNext() && !TextUtils.equals(it.next().m68362a().getId(), this.f10399T)) {
            i10++;
        }
        if (i10 == list.size()) {
            i10 = 0;
        }
        this.f10430t0 = i10;
        this.f10378H = this.f10396Q.get(i10);
        for (C11415a c11415a : this.f10396Q) {
            if (TextUtils.equals(c11415a.m68362a().getId(), this.f10399T)) {
                c11415a.m68375n(true);
            } else {
                c11415a.m68375n(false);
            }
        }
        C1120a.m6677i("ShareAlbumHomePageActivity", "viewPagerIndex: " + this.f10430t0);
        this.f10398S.m13862a(this.f10396Q);
        this.f10402W.setCurrentItem(i10);
        m13832g3();
        this.f10440y0 = true;
        m13824Z2(this.f10378H);
        this.f10420o0 = this.f10378H.m68362a();
        m13841o3();
        C12091d.m72280a0().m72297B0(this.f10399T, this.f10391N0);
        C12091d.m72280a0().m72358i0(this.f10391N0);
    }

    /* renamed from: c3 */
    public final void m13827c3(List<C11415a> list) {
        if (list == null) {
            return;
        }
        for (C11415a c11415a : list) {
            Album albumM68362a = c11415a.m68362a();
            if (albumM68362a != null && albumM68362a.getId() != null) {
                C12091d.m72280a0().m72353f1(albumM68362a.getId(), c11415a);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10433v);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m13828d3() {
        int i10 = this.f10418m0;
        if (i10 == 0) {
            this.f10386L.setVisibility(8);
            return;
        }
        if (this.f10419n0 == i10) {
            this.f10386L.setVisibility(8);
            m13824Z2(this.f10378H);
            return;
        }
        this.f10386L.setVisibility(0);
        int i11 = (this.f10419n0 * 100) / this.f10418m0;
        C1120a.m6677i("ShareAlbumHomePageActivity", "refreshUploadNum progress=" + i11);
        this.f10380I.setProgress(i11);
        this.f10382J.setProgress(i11);
        this.f10384K.setProgress(i11);
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        this.f10434v0 = true;
    }

    /* renamed from: e3 */
    public final void m13830e3() {
        int iM485F = C0069g.m479y().m485F(this.f10399T);
        this.f10422p0 = iM485F;
        if (iM485F == 3) {
            m13849v3();
        } else if (iM485F == 2) {
            m13848u3();
        } else if (iM485F == 4) {
            m13847t3();
        }
        m13828d3();
    }

    /* renamed from: f3 */
    public final void m13831f3() {
        if (this.f10424q0 == null) {
            this.f10424q0 = new LocalReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("album_status_change_action");
            intentFilter.addAction("album_background_change_action");
            intentFilter.addAction("com.huawei.hicloud.getShareAlbumList");
            intentFilter.addAction("com.huawei.hicloud.approveApplicant");
            C13108a.m78878b(this).m78880c(this.f10424q0, intentFilter);
        }
    }

    /* renamed from: g3 */
    public final void m13832g3() {
        C11415a c11415a = this.f10378H;
        if (c11415a == null || c11415a.m68362a() == null || isFinishing() || isDestroyed() || !C0209d.m1245d1(getApplicationContext(), getLocalClassName())) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("album_type", String.valueOf(this.f10378H.m68362a().getType()));
        linkedHashMapM79497A.put("album_member_num", String.valueOf(this.f10378H.m68362a().getPermissions().size() - 1));
        linkedHashMapM79497A.put("album_pic_num", String.valueOf(this.f10378H.m68362a().getPicCount()));
        linkedHashMapM79497A.put("album_video_num", String.valueOf(this.f10378H.m68362a().getVideoCount()));
        C13224c.m79487f1().m79594r0("SHOW_SHARE_ALBUM_HOME_PAGE", linkedHashMapM79497A);
    }

    /* renamed from: h3 */
    public final void m13833h3() {
        C11415a c11415a = this.f10378H;
        if (c11415a == null || c11415a.m68362a() == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("album_use_time", String.valueOf(System.currentTimeMillis() - this.f10366B));
        linkedHashMapM79497A.put("album_type", String.valueOf(this.f10378H.m68362a().getType()));
        C13224c.m79487f1().m79594r0("CLICK_SHARE_ALBUM_HOME_BACK", linkedHashMapM79497A);
    }

    /* renamed from: i3 */
    public void m13834i3(String str) {
        JSONObject jSONObjectM72336W = C12091d.m72280a0().m72336W("share_photo_click", m13809L2(), str);
        C13224c.m79487f1().m79602z(jSONObjectM72336W);
        UBAAnalyze.m29963X("PVC", "share_photo_click", "1", "79", jSONObjectM72336W);
    }

    /* renamed from: j3 */
    public final void m13835j3(int i10) {
        if (i10 == R$id.icon_upload || i10 == R$id.icon_upload_transparent) {
            C13224c.m79487f1().m79593q0("CLICK_SHARE_UPLOAD_ICON");
        } else {
            C13224c.m79487f1().m79593q0("CLICK_SHARE_UPLOAD_BUTTON");
        }
    }

    /* renamed from: k3 */
    public final void m13836k3(String str, List<DayModeGroup> list) {
        if (list == null || list.size() == 0) {
            C1120a.m6676e("ShareAlbumHomePageActivity", "scrollToFilterPosition filterPicList is null");
            return;
        }
        int count = 0;
        for (DayModeGroup dayModeGroup : list) {
            if (m13821W2(str, dayModeGroup)) {
                int i10 = count + 1;
                if (i10 > m13805I2()) {
                    count = i10;
                } else if (count > 0) {
                    count--;
                }
                C1120a.m6675d("ShareAlbumHomePageActivity", "onSelectDate index " + count);
                if (!this.f10379H0) {
                    this.f10421p.scrollToPosition(count);
                    return;
                }
                Map<Integer, Integer> mapM14819Y0 = this.f10437x.m14819Y0();
                if (mapM14819Y0 != null) {
                    this.f10421p.scrollToPosition(mapM14819Y0.getOrDefault(Integer.valueOf(count), Integer.valueOf(count)).intValue());
                    return;
                } else {
                    this.f10421p.scrollToPosition(count);
                    return;
                }
            }
            count = count + 1 + dayModeGroup.getCount();
        }
    }

    /* renamed from: l3 */
    public final void m13837l3(int i10) {
        this.f10430t0 = i10;
        this.f10429t.m13858a();
        this.f10398S.notifyDataSetChanged();
        this.f10410e0.setText(getString(R$string.album_index, String.valueOf(this.f10430t0 + 1), String.valueOf(this.f10396Q.size())));
        C1120a.m6677i("ShareAlbumHomePageActivity", "selectAlbum：" + i10);
        C11415a c11415a = this.f10396Q.get(i10);
        String id2 = c11415a.m68362a().getId();
        this.f10399T = id2;
        this.f10371D0 = c11415a.m68362a().getShareType().intValue();
        this.f10437x.m14767b0();
        C12091d.m72280a0().m72322P(this, id2, this.f10371D0, this.f10391N0);
        C12091d.m72280a0().m72297B0(this.f10399T, this.f10391N0);
        this.f10386L.setVisibility(8);
        m13824Z2(c11415a);
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
        this.f10434v0 = true;
        if (TextUtils.isEmpty(bundle.getString("photoUrl"))) {
            this.f10436w0 = true;
        }
        m13812O2();
    }

    /* renamed from: m3 */
    public final void m13839m3(int i10, int i11, int i12) {
        this.f10410e0.setVisibility(0);
        this.f10410e0.setText(getString(R$string.album_index, String.valueOf(this.f10430t0 + 1), String.valueOf(this.f10396Q.size())));
        this.f10429t.m13859c();
        this.f10378H.m68362a().getShareType().intValue();
        float f10 = 0.0f;
        if (i10 > i11 && i12 < this.f10398S.getCount() - 1) {
            C11415a c11415a = this.f10396Q.get(i12 + 1);
            if (C12091d.m72280a0().m72311I0(c11415a.m68362a())) {
                C12091d.m72280a0().m72398y(c11415a.m68362a().getBackgroundImage(), this.f10394P);
            } else if (c11415a.m68362a().getShareType().intValue() == 1) {
                this.f10394P.setImageDrawable(getDrawable(R$drawable.baby_album_bg));
            } else {
                this.f10394P.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
            }
            float f11 = 1.0f - ((i10 - i11) / 600.0f);
            if (f11 >= 1.0f) {
                f11 = 1.0f;
            } else if (f11 <= 0.0f) {
                f11 = 0.0f;
            }
            this.f10392O.setAlpha(f11);
        }
        if (i10 >= i11 || i12 < 0) {
            return;
        }
        C11415a c11415a2 = this.f10396Q.get(i12);
        if (C12091d.m72280a0().m72311I0(c11415a2.m68362a())) {
            C12091d.m72280a0().m72398y(c11415a2.m68362a().getBackgroundImage(), this.f10394P);
        } else if (c11415a2.m68362a().getShareType().intValue() == 1) {
            this.f10394P.setImageDrawable(getDrawable(R$drawable.baby_album_bg));
        } else {
            this.f10394P.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
        }
        float f12 = 1.0f - ((i11 - i10) / 600.0f);
        if (f12 >= 1.0f) {
            f10 = 1.0f;
        } else if (f12 > 0.0f) {
            f10 = f12;
        }
        this.f10392O.setAlpha(f10);
    }

    /* renamed from: n3 */
    public final void m13840n3() {
        m13844r3();
        this.f10442z0 = C12091d.m72280a0().m72401z0(this.f10399T);
        this.f10365A0 = C12091d.m72280a0().m72401z0(this.f10399T + "share_home_picture");
        this.f10367B0 = C12091d.m72280a0().m72401z0(this.f10399T + "share_home_vedio");
        if (this.f10442z0 == null) {
            return;
        }
        this.f10421p.setVisibility(0);
        this.f10427s.setVisibility(0);
        this.f10423q.setVisibility(8);
        m13852x3("", false);
    }

    /* renamed from: o3 */
    public final void m13841o3() {
        if (this.f10442z0 == null || this.f10378H == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f10401V) || !TextUtils.equals(this.f10399T, this.f10401V)) {
            this.f10425r.m13860D(getString(R$string.album_empty));
        } else {
            this.f10425r.m13860D(getString(R$string.album_create_finish));
        }
        if (this.f10371D0 == 1) {
            this.f10425r.m13861E(getString(R$string.baby_upload_tips));
        } else {
            this.f10425r.m13861E(getString(R$string.album_upload_tips));
        }
        this.f10425r.m5213j();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C1120a.m6675d("ShareAlbumHomePageActivity", "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 100) {
            if (intent == null) {
                return;
            }
            try {
                List<Uri> list = (List) intent.getExtras().get("select-item-list");
                if (list != null && list.size() != 0) {
                    C1120a.m6677i("ShareAlbumHomePageActivity", "select file size: " + list.size());
                    C12091d.m72280a0().m72374p(C12091d.m72280a0().m72310I(this.f10399T), C12091d.m72280a0().m72340Y(this, list), this.f10391N0, this);
                    return;
                }
                return;
            } catch (Exception e10) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "onActivityResult exception: " + e10.toString());
                return;
            }
        }
        if (i10 == 306 && i11 == 305) {
            if (this.f10437x != null) {
                C12091d.m72280a0().m72322P(this, this.f10399T, this.f10371D0, this.f10391N0);
            }
            C12091d.m72280a0().m72384s0();
            return;
        }
        if (i10 == 102 && i11 == 102) {
            setResult(102);
            finish();
            return;
        }
        if (i10 != 105) {
            if (i10 == 102 && i11 == 101) {
                m13763R2();
                m13823Y2(intent);
                return;
            } else {
                if (i10 == 103) {
                    m13823Y2(intent);
                    return;
                }
                return;
            }
        }
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("param_media_id");
                C1120a.m6677i("ShareAlbumHomePageActivity", "onActivityResult BackgroundImage mediaId: " + stringExtra);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.f10378H.m68362a().setBackgroundImage(stringExtra);
                C12091d.m72280a0().m72398y(this.f10378H.m68362a().getBackgroundImage(), this.f10392O);
            } catch (Exception e11) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "onActivityResult exception: " + e11.toString());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.ll_head || id2 == R$id.album_title_layout || id2 == R$id.share_member_head_item || id2 == R$id.baby_cover_layout) {
            Intent intent = new Intent(this, (Class<?>) ShareAlbumManageActivity.class);
            intent.putExtra("param_album_id", this.f10399T);
            intent.putExtra("param_album_type", this.f10371D0);
            C0224k0.m1544N(this, intent, 102);
            return;
        }
        if (id2 == R$id.icon_upload || id2 == R$id.icon_upload_transparent || id2 == R$id.album_upload_button) {
            if (this.f10389M0) {
                m13822X2();
                m13835j3(id2);
                return;
            } else {
                C1120a.m6677i("ShareAlbumHomePageActivity", "click upload button, no permission");
                C11841o.m70706b(this, getString(R$string.album_no_upload_permission), 0);
                return;
            }
        }
        if (id2 == R$id.close_button || id2 == R$id.close_button_pic) {
            super.onBackPressed();
            m13833h3();
            return;
        }
        if (id2 == R$id.share_invite_button) {
            m13801E2();
            return;
        }
        if (id2 == R$id.rl_alarm_white || id2 == R$id.rl_alarm) {
            m13811N2(0);
            startActivity(new Intent(this, (Class<?>) ShareAlbumAllMsgActivity.class));
            return;
        }
        if (id2 == R$id.upload_progress_button || id2 == R$id.upload_progress_button_paused || id2 == R$id.upload_progress_button_failed) {
            Intent intent2 = new Intent(this, (Class<?>) SharePhotoUploadListActivity.class);
            intent2.putExtra("param_album_id", this.f10399T);
            C0224k0.m1544N(this, intent2, 306);
            C13224c.m79487f1().m79593q0("CLICK_SHARE_UPLOAD_PROGRESS");
            return;
        }
        if (id2 == R$id.ll_album_name) {
            if (this.f10439y.getAlpha() == 0.0f) {
                C1120a.m6677i("ShareAlbumHomePageActivity", "invisible return");
                return;
            }
            DialogC11650o dialogC11650o = new DialogC11650o(this, this.f10399T, this.f10396Q);
            this.f10426r0 = dialogC11650o;
            dialogC11650o.show();
            return;
        }
        if (id2 == R$id.album_filter) {
            m13798A3();
            return;
        }
        if (id2 == R$id.ic_msg_close) {
            this.f10372E.setVisibility(8);
            C1136q.m6981v("jion_close_time" + this.f10378H.m68362a().getId(), C10159j.m63332h() + 86400000);
            return;
        }
        if (id2 == R$id.ic_invite_close) {
            this.f10374F.setVisibility(8);
            C1136q.m6981v("invite_close_time" + this.f10378H.m68362a().getId(), C10159j.m63332h() + 86400000);
            return;
        }
        if (id2 == R$id.album_head_picture || id2 == R$id.ll_album_title) {
            if (this.f10378H == null) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "albumBean null");
                return;
            } else {
                if (!TextUtils.equals(C13452e.m80781L().m80971t0(), this.f10378H.m68362a().getAlbumOwnerId())) {
                    C1120a.m6677i("ShareAlbumHomePageActivity", "not owner return");
                    return;
                }
                Intent intent3 = new Intent(this, (Class<?>) ShareAlbumBackGroundViewActivity.class);
                intent3.putExtra("param_album_id", this.f10378H.m68362a().getId());
                C0224k0.m1544N(this, intent3, 105);
                return;
            }
        }
        if (id2 != R$id.share_upload_head_button) {
            if (id2 == R$id.ic_upload_head_close) {
                this.f10408c0.setVisibility(8);
                C1136q.m6981v("upload_close_time", C10159j.m63332h() + 86400000);
                return;
            } else {
                if (id2 == R$id.icon_more || id2 == R$id.icon_more_transparent) {
                    m13802F2(view);
                    return;
                }
                return;
            }
        }
        try {
            Intent intentM79271I = C13195l.m79271I(this, "hwid://com.huawei.hwid/AccountDetail");
            if (intentM79271I == null) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "hmsPackage is invalid!");
            } else {
                startActivityForResult(intentM79271I, 1001);
            }
        } catch (Exception e10) {
            C1120a.m6676e("ShareAlbumHomePageActivity", "go hwid error" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m13846s3();
        m13852x3("", false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        C10343b c10343b = new C10343b(safeIntent.getExtras());
        this.f10399T = c10343b.m63694p("param_album_id");
        this.f10400U = c10343b.m63695q("param_owner_id", "");
        this.f10401V = c10343b.m63694p("param_created_album_id");
        this.f10371D0 = c10343b.m63687i("param_album_type", -1);
        this.f10420o0 = C12091d.m72280a0().m72310I(this.f10399T);
        setContentView(R$layout.activity_share_album_home);
        this.f10421p = (RecyclerView) C12809f.m76829b(this, R$id.album_list);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.album_no_photo);
        this.f10423q = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        C2230j c2230j = new C2230j(this, this);
        this.f10425r = c2230j;
        this.f10423q.setAdapter(c2230j);
        this.f10433v = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.center_activity);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.album_filter);
        this.f10427s = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f10435w = (ImageView) C12809f.m76829b(this, R$id.iv_filter);
        this.f10376G = (RelativeLayout) C12809f.m76829b(this, R$id.rl_no_photo);
        this.f10390N = (CoordinatorLayout) C12809f.m76829b(this, R$id.album_share_home_app_bar);
        this.f10370D = (RelativeLayout) C12809f.m76829b(this, R$id.rl_album_item);
        this.f10380I = (HwProgressButton) C12809f.m76829b(this, R$id.upload_progress_button);
        this.f10382J = (HwProgressButton) C12809f.m76829b(this, R$id.upload_progress_button_paused);
        this.f10384K = (HwProgressButton) C12809f.m76829b(this, R$id.upload_progress_button_failed);
        m13818U2();
        m13819V2();
        m13816S2();
        this.f10386L = (RelativeLayout) C12809f.m76829b(this, R$id.upload_progress);
        this.f10368C = (ImageView) C12809f.m76829b(this, R$id.ic_uploading);
        this.f10380I.setOnClickListener(this);
        this.f10382J.setOnClickListener(this);
        this.f10384K.setOnClickListener(this);
        int i10 = R$id.album_head_picture;
        ImageView imageView = (ImageView) C12809f.m76829b(this, i10);
        this.f10392O = imageView;
        imageView.setTag(i10, this);
        this.f10392O.setOnClickListener(this);
        this.f10394P = (ImageView) C12809f.m76829b(this, R$id.next_head_picture);
        this.f10366B = System.currentTimeMillis();
        this.f10388M = (TextView) C12809f.m76829b(this, R$id.tv_upload_progress);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.ll_album_name);
        this.f10403X = (TextView) C12809f.m76829b(this, R$id.tv_album_name);
        relativeLayout2.setOnClickListener(this);
        m13846s3();
        ImageView imageView2 = (ImageView) C12809f.m76829b(this, R$id.close_button);
        this.f10404Y = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) C12809f.m76829b(this, R$id.close_button_pic);
        this.f10405Z = imageView3;
        imageView3.setOnClickListener(this);
        ((RelativeLayout) C12809f.m76829b(this, R$id.rl_alarm_white)).setOnClickListener(this);
        this.f10414i0 = (ImageView) C12809f.m76829b(this, R$id.icon_alarm_dot_dark);
        this.f10415j0 = (ImageView) C12809f.m76829b(this, R$id.icon_alarm_dot);
        this.f10417l0 = (ImageView) C12809f.m76829b(this, R$id.new_member_head);
        ((RelativeLayout) C12809f.m76829b(this, R$id.rl_alarm)).setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76829b(this, R$id.share_invite_button);
        this.f10406a0 = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        this.f10374F = (RelativeLayout) C12809f.m76829b(this, R$id.member_invite);
        this.f10439y = (LinearLayout) C12809f.m76829b(this, R$id.rl_title);
        this.f10372E = (RelativeLayout) C12809f.m76829b(this, R$id.new_member_msg);
        ((ImageView) C12809f.m76829b(this, R$id.ic_invite_close)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.ic_msg_close)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.ic_upload_head_close)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.icon_more)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.icon_more_transparent)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.icon_upload_transparent)).setOnClickListener(this);
        ImageView imageView4 = (ImageView) C12809f.m76829b(this, R$id.icon_upload);
        this.f10416k0 = imageView4;
        imageView4.setOnClickListener(this);
        this.f10412g0 = (TextView) C12809f.m76829b(this, R$id.new_member_title);
        this.f10413h0 = (TextView) C12809f.m76829b(this, R$id.new_member_ifo);
        this.f10409d0 = (TextView) C12809f.m76829b(this, R$id.tv_invite_title);
        this.f10410e0 = (TextView) C12809f.m76829b(this, R$id.tv_album_index);
        this.f10411f0 = (TextView) C12809f.m76829b(this, R$id.tv_invite_info);
        this.f10402W = (ViewPager) C12809f.m76829b(this, R$id.vp_album_home);
        this.f10408c0 = (RelativeLayout) C12809f.m76829b(this, R$id.upload_head_layout);
        RelativeLayout relativeLayout4 = (RelativeLayout) C12809f.m76829b(this, R$id.share_upload_head_button);
        this.f10407b0 = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        C2232l c2232l = new C2232l(this, new ArrayList(), this);
        this.f10398S = c2232l;
        this.f10402W.setAdapter(c2232l);
        ViewPager viewPager = this.f10402W;
        viewPager.addOnPageChangeListener(new C2228h(this, viewPager));
        this.f10402W.setOffscreenPageLimit(3);
        C11737b.m70035b().m70036a(this.f10428s0);
        Handler handler = new Handler(getMainLooper());
        this.f10385K0 = handler;
        this.f10429t = new RunnableC2229i(handler, this.f10410e0, null);
        C2233m c2233m = new C2233m(this);
        this.f10397R = c2233m;
        this.f10421p.setLayoutManager(c2233m);
        this.f10437x = new RecyclerMediaArtBlockAdapter(this);
        this.f10437x.m14769d0(this.f10420o0.getShareType().intValue() == 1);
        this.f10437x.m14772i0(this.f10395P0);
        this.f10437x.m14768c0(true);
        this.f10437x.m14767b0();
        HandlerC2234n handlerC2234n = new HandlerC2234n(this, this.f10437x, null);
        this.f10369C0 = handlerC2234n;
        this.f10437x.m14699L0(handlerC2234n);
        this.f10421p.setAdapter(this.f10437x);
        m13817T2();
        this.f10421p.addOnScrollListener(new C2224d());
        m13843q3();
        m13831f3();
        m13840n3();
        m13763R2();
        mo19005p1();
        this.f10373E0 = new ViewOnClickListenerC2256a(this, this);
        this.f10393O0 = new HandlerC2235o(this, null);
        C0069g.m479y().m503j(this.f10393O0);
        if (!CloudAlbumSettings.m14363h().m14384t() && safeIntent.getBooleanExtra("is_from_create_entry", false)) {
            C12091d.m72280a0().m72303E0(this, 100);
        }
        C1120a.m6677i("ShareAlbumHomePageActivity", "onCreate end");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DialogC11650o dialogC11650o = this.f10426r0;
        if (dialogC11650o != null && dialogC11650o.isShowing()) {
            this.f10426r0.dismiss();
        }
        if (this.f10424q0 != null) {
            C13108a.m78878b(this).m78883f(this.f10424q0);
            this.f10424q0 = null;
        }
        C0069g.m479y().m496Q(this.f10393O0);
        C11737b.m70035b().m70041g(this.f10428s0);
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId == R$id.top_album) {
            if (this.f10399T.equals(C1136q.d.m7155s())) {
                C11841o.m70706b(this, getString(R$string.album_cancel_top_msg), 0);
                str = "";
            } else {
                C13224c.m79487f1().m79593q0("CLICK_SHARE_HOME_TOP_MENU");
                String str2 = this.f10399T;
                C11841o.m70706b(this, getString(R$string.album_top_msg), 0);
                str = str2;
            }
            C1136q.d.m7134K(str);
        } else if (itemId == R$id.manage_album) {
            Intent intent = new Intent(this, (Class<?>) ShareAlbumManageActivity.class);
            intent.putExtra("param_album_id", this.f10399T);
            intent.putExtra("param_album_type", this.f10371D0);
            C0224k0.m1544N(this, intent, 102);
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C1395a c1395aM484E = C0069g.m479y().m484E(this.f10399T);
        if (c1395aM484E != null) {
            this.f10418m0 = c1395aM484E.m7976i();
            this.f10419n0 = c1395aM484E.m7975h();
        }
        C2232l c2232l = this.f10398S;
        if (c2232l != null) {
            c2232l.notifyDataSetChanged();
        }
    }

    /* renamed from: p3 */
    public final void m13842p3(boolean z10) {
        if (z10) {
            this.f10409d0.setText(R$string.album_baby_invite_title);
            this.f10411f0.setText(R$string.album_baby_invite_sub_title);
        } else {
            this.f10409d0.setText(R$string.album_share_invite_title);
            this.f10411f0.setText(R$string.album_share_invite_sub_title);
        }
    }

    /* renamed from: q3 */
    public final void m13843q3() {
        try {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility((C11842p.m70732H0(this) ? systemUiVisibility & 8192 : systemUiVisibility | 8192) | 1280);
            getWindow().setStatusBarColor(0);
        } catch (Exception e10) {
            C1120a.m6678w("ShareAlbumHomePageActivity", "setEMUI6Bar error " + e10.getMessage());
        }
    }

    /* renamed from: r3 */
    public final void m13844r3() {
        KvDatabaseWrapper kvDatabaseWrapperM72352f0;
        Bitmap bitmapM30071b;
        C11415a c11415aM72381r0 = C12091d.m72280a0().m72381r0(this.f10399T);
        if (c11415aM72381r0 != null) {
            if (C12091d.m72280a0().m72311I0(c11415aM72381r0.m68362a())) {
                String backgroundImage = c11415aM72381r0.m68362a().getBackgroundImage();
                if (TextUtils.isEmpty(backgroundImage) || (kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0()) == null || (bitmapM30071b = kvDatabaseWrapperM72352f0.m30071b(backgroundImage)) == null) {
                    C1120a.m6675d("ShareAlbumHomePageActivity", "setTitleBackgroundCache get bitMapCache fail, get data but no cache");
                    return;
                } else {
                    this.f10392O.setImageBitmap(bitmapM30071b);
                    C1120a.m6675d("ShareAlbumHomePageActivity", "setTitleBackgroundCache get bitMapCache success");
                    return;
                }
            }
            try {
                C1120a.m6675d("ShareAlbumHomePageActivity", "setTitleBackgroundCache set default");
                if (c11415aM72381r0.m68362a().getShareType().intValue() == 1) {
                    this.f10392O.setImageDrawable(getDrawable(R$drawable.baby_album_bg));
                } else {
                    this.f10392O.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
                }
            } catch (Exception e10) {
                C1120a.m6676e("ShareAlbumHomePageActivity", "key-value key is null:" + e10.getMessage());
                this.f10392O.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
            }
        }
    }

    @Override // p486n6.DialogC11650o.a
    /* renamed from: s0 */
    public void mo13845s0() {
        C0224k0.m1542L(this, new Intent(this, (Class<?>) CreateOrJoinAlbumActivity.class));
        C13224c.m79487f1().m79593q0("CLICK_SHARE_SWITH_CREATE");
    }

    /* renamed from: s3 */
    public final void m13846s3() {
        int iM70752O = C11842p.m70753O0(this) ? C11842p.m70752O(this) : C11842p.m70758Q(this);
        Resources resources = getResources();
        int i10 = R$dimen.cloud_space_24_dp;
        this.f10403X.setMaxWidth(((iM70752O - (resources.getDimensionPixelSize(i10) * 2)) - (getResources().getDimensionPixelSize(R$dimen.cloud_space_16_dp) * 3)) - (getResources().getDimensionPixelSize(i10) * 6));
    }

    /* renamed from: t3 */
    public final void m13847t3() {
        this.f10368C.setImageDrawable(getDrawable(R$drawable.album_upload_failed_progress));
        this.f10388M.setText(getString(R$string.album_upload_failed, Integer.valueOf(this.f10419n0), Integer.valueOf(this.f10418m0)));
        this.f10388M.setTextColor(getColor(R$color.color_FB374E));
        this.f10382J.setVisibility(8);
        this.f10380I.setVisibility(8);
        this.f10384K.setVisibility(0);
    }

    /* renamed from: u3 */
    public final void m13848u3() {
        int i10 = this.f10422p0;
        if (i10 == 4) {
            this.f10388M.setText(getString(R$string.album_upload_failed, Integer.valueOf(this.f10419n0), Integer.valueOf(this.f10418m0)));
            return;
        }
        if (i10 == 3) {
            this.f10388M.setText(getString(R$string.album_uploading_interrupted, Integer.valueOf(this.f10419n0), Integer.valueOf(this.f10418m0)));
            return;
        }
        this.f10388M.setText(getString(R$string.album_uploading, Integer.valueOf(this.f10419n0), Integer.valueOf(this.f10418m0), getString(R$string.album_upload_speed, C0223k.m1520c(this, this.f10381I0))));
        this.f10368C.setImageDrawable(getDrawable(R$drawable.ic_album_uploading));
        this.f10388M.setTextColor(getColor(R$color.color_0091ff));
        this.f10382J.setVisibility(8);
        this.f10384K.setVisibility(8);
        this.f10380I.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m13833h3();
        return super.mo13429v1(i10, keyEvent);
    }

    /* renamed from: v3 */
    public final void m13849v3() {
        this.f10368C.setImageDrawable(getDrawable(R$drawable.album_upload_pause_progress));
        this.f10388M.setText(getString(R$string.album_uploading_interrupted, Integer.valueOf(this.f10419n0), Integer.valueOf(this.f10418m0)));
        this.f10388M.setTextColor(getColor(R$color.color_F29B22));
        this.f10380I.setVisibility(8);
        this.f10384K.setVisibility(8);
        this.f10382J.setVisibility(0);
    }

    @Override // p486n6.DialogC11650o.a
    /* renamed from: w */
    public void mo13850w(String str, int i10) {
        this.f10399T = str;
        this.f10371D0 = i10;
        m13763R2();
        C13224c.m79487f1().m79593q0("CLICK_SHARE_ALBUM_SWITCH");
    }

    /* renamed from: w3 */
    public final void m13851w3() {
        if ((!this.f10364A.hasStarted() || this.f10364A.hasEnded()) && this.f10427s.getAlpha() <= 0.0f) {
            this.f10364A.setAnimationListener(new AnimationAnimationListenerC2226f());
            this.f10427s.startAnimation(this.f10364A);
            this.f10427s.setVisibility(0);
            this.f10427s.setClickable(true);
        }
    }

    /* renamed from: x3 */
    public final void m13852x3(String str, boolean z10) {
        this.f10437x.m14696I0(this.f10399T);
        this.f10437x.m14695H0();
        if (this.f10379H0) {
            m13853y3(str, z10);
        } else {
            m13854z3(str, z10);
        }
    }

    /* renamed from: y3 */
    public final void m13853y3(String str, boolean z10) {
        BabyInfo babyInfo;
        Album album = this.f10420o0;
        C4644l birthday = (album == null || (babyInfo = album.getBabyInfo()) == null) ? null : babyInfo.getBirthday();
        if (this.f10375F0) {
            this.f10437x.m14821a1(this.f10365A0, 2, birthday);
            if (z10) {
                m13836k3(str, this.f10365A0);
            }
            m13810M2(true, this.f10365A0);
        }
        if (this.f10377G0) {
            this.f10437x.m14821a1(this.f10367B0, 2, birthday);
            if (z10) {
                m13836k3(str, this.f10367B0);
            }
            m13810M2(true, this.f10367B0);
        }
        if (this.f10375F0 || this.f10377G0) {
            return;
        }
        this.f10437x.m14821a1(this.f10442z0, 2, birthday);
        if (z10) {
            m13836k3(str, this.f10442z0);
        }
        m13810M2(true, this.f10442z0);
    }

    /* renamed from: z3 */
    public final void m13854z3(String str, boolean z10) {
        BabyInfo babyInfo;
        Album album = this.f10420o0;
        C4644l birthday = (album == null || (babyInfo = album.getBabyInfo()) == null) ? null : babyInfo.getBirthday();
        if (this.f10375F0) {
            this.f10437x.m14693F0(this.f10365A0, 2, birthday);
            if (z10) {
                m13836k3(str, this.f10365A0);
            }
            m13810M2(false, this.f10365A0);
        }
        if (this.f10377G0) {
            this.f10437x.m14693F0(this.f10367B0, 2, birthday);
            if (z10) {
                m13836k3(str, this.f10367B0);
            }
            m13810M2(false, this.f10367B0);
        }
        if (this.f10375F0 || this.f10377G0) {
            return;
        }
        this.f10437x.m14693F0(this.f10442z0, 2, birthday);
        if (z10) {
            m13836k3(str, this.f10442z0);
        }
        m13810M2(false, this.f10442z0);
    }
}
