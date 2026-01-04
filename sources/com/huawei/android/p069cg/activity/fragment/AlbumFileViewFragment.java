package com.huawei.android.p069cg.activity.fragment;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadProgress;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.AlbumReportActivity;
import com.huawei.android.p069cg.activity.AppealMainActivity;
import com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.manager.WiseFactoryManager;
import com.huawei.android.p069cg.p071ui.fileviewdrag.FileViewerImageView;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import com.huawei.hms.videokit.player.CreateComponentException;
import com.huawei.hms.videokit.player.InitFactoryCallback;
import com.huawei.hms.videokit.player.WisePlayer;
import com.huawei.hms.videokit.player.WisePlayerFactory;
import com.huawei.hms.videokit.player.WisePlayerFactoryOptionsExt;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1123d;
import p031b7.C1132m;
import p031b7.C1133n;
import p031b7.C1138s;
import p220d8.C9050d;
import p292fn.C9733f;
import p336he.C10159j;
import p471m6.C11417c;
import p471m6.C11421g;
import p486n6.DialogInterfaceOnClickListenerC11644i;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p546p6.C12094g;
import p546p6.C12096i;
import p546p6.C12097j;
import p556pp.C12202a;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p649t6.C12941a;
import p649t6.C12947g;
import p649t6.C12950j;
import p664u0.C13108a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import p818yp.C14034a;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AlbumFileViewFragment extends Fragment implements View.OnClickListener {

    /* renamed from: A */
    public TextView f10752A;

    /* renamed from: B */
    public TextView f10753B;

    /* renamed from: C */
    public LinearLayout f10754C;

    /* renamed from: D */
    public LinearLayout f10755D;

    /* renamed from: E */
    public LinearLayout f10756E;

    /* renamed from: F */
    public LinearLayout f10757F;

    /* renamed from: G */
    public LinearLayout f10758G;

    /* renamed from: H */
    public LinearLayout f10759H;

    /* renamed from: I */
    public View f10760I;

    /* renamed from: J */
    public ImageView f10761J;

    /* renamed from: K */
    public ImageView f10762K;

    /* renamed from: L */
    public ImageView f10763L;

    /* renamed from: M */
    public ImageView f10764M;

    /* renamed from: N */
    public LinearLayout f10765N;

    /* renamed from: O */
    public LinearLayout f10766O;

    /* renamed from: P */
    public LinearLayout f10767P;

    /* renamed from: Q */
    public AlbumFileViewerReceiver f10768Q;

    /* renamed from: T */
    public int f10771T;

    /* renamed from: U */
    public int f10772U;

    /* renamed from: V */
    public ActionBar f10773V;

    /* renamed from: a */
    public View f10778a;

    /* renamed from: a0 */
    public WisePlayerFactory f10779a0;

    /* renamed from: b */
    public View f10780b;

    /* renamed from: b0 */
    public boolean f10781b0;

    /* renamed from: c */
    public View f10782c;

    /* renamed from: d */
    public ViewPager f10784d;

    /* renamed from: e */
    public ViewOnClickListenerC2266j f10786e;

    /* renamed from: f0 */
    public NetWorkChangeReceiver f10789f0;

    /* renamed from: g */
    public String f10790g;

    /* renamed from: g0 */
    public C2267k f10791g0;

    /* renamed from: h */
    public boolean f10792h;

    /* renamed from: i0 */
    public DialogInterfaceOnClickListenerC11644i f10795i0;

    /* renamed from: k */
    public List<MediaFileBean> f10798k;

    /* renamed from: l */
    public LinearLayout f10799l;

    /* renamed from: m */
    public View f10800m;

    /* renamed from: n */
    public RelativeLayout f10801n;

    /* renamed from: o */
    public CheckBox f10802o;

    /* renamed from: p */
    public View f10803p;

    /* renamed from: s */
    public View f10806s;

    /* renamed from: t */
    public ImageView f10807t;

    /* renamed from: u */
    public TextView f10808u;

    /* renamed from: v */
    public TextView f10809v;

    /* renamed from: w */
    public HwProgressBar f10810w;

    /* renamed from: x */
    public TextView f10811x;

    /* renamed from: y */
    public TextView f10812y;

    /* renamed from: z */
    public TextView f10813z;

    /* renamed from: f */
    public int f10788f = 0;

    /* renamed from: i */
    public boolean f10794i = false;

    /* renamed from: j */
    public boolean f10796j = false;

    /* renamed from: q */
    public boolean f10804q = false;

    /* renamed from: r */
    public long f10805r = 0;

    /* renamed from: R */
    public C12947g f10769R = new C12947g();

    /* renamed from: S */
    public boolean f10770S = true;

    /* renamed from: W */
    public boolean f10774W = false;

    /* renamed from: X */
    public boolean f10775X = true;

    /* renamed from: Y */
    public boolean f10776Y = false;

    /* renamed from: Z */
    public boolean f10777Z = true;

    /* renamed from: c0 */
    public Handler.Callback f10783c0 = new C2257a();

    /* renamed from: d0 */
    public Handler f10785d0 = new Handler(this.f10783c0);

    /* renamed from: e0 */
    public Handler.Callback f10787e0 = new C2258b();

    /* renamed from: h0 */
    public Handler f10793h0 = new Handler(this.f10787e0);

    /* renamed from: j0 */
    public String f10797j0 = "";

    public class AlbumFileViewerReceiver extends BroadcastReceiver {
        public AlbumFileViewerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("AlbumFileViewFragment", "intent is null.");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (!"com.huawei.hicloud.checkLCDDownloaded".equals(action)) {
                if ("com.huawei.hicloud.checkVedioButton".equals(action)) {
                    AlbumFileViewFragment.this.m14191t1(AlbumFileViewFragment.this.f10786e.m14230o(AlbumFileViewFragment.this.f10788f));
                    return;
                }
                return;
            }
            if (AlbumFileViewFragment.this.f10786e == null) {
                C1120a.m6676e("AlbumFileViewFragment", "getCurrentData mTabsAdapter is null");
                return;
            }
            if (AlbumFileViewFragment.this.f10786e.f10834i == null) {
                C1120a.m6676e("AlbumFileViewFragment", "getCurrentData mTabsAdapter.mFiles is null");
                return;
            }
            if (AlbumFileViewFragment.this.f10786e.f10834i.isEmpty()) {
                return;
            }
            int intExtra = safeIntent.getIntExtra("param_file_viewer_position", -1);
            ViewOnClickListenerC2266j.d dVarM14230o = AlbumFileViewFragment.this.f10786e.m14230o(AlbumFileViewFragment.this.f10788f);
            MediaFileBean mediaFileBeanM14233r = AlbumFileViewFragment.this.f10786e.m14233r(intExtra);
            if (dVarM14230o == null || mediaFileBeanM14233r == null) {
                return;
            }
            dVarM14230o.f10847E = true;
            if (AlbumFileViewFragment.this.f10788f == intExtra) {
                AlbumFileViewFragment.this.f10810w.setVisibility(8);
            }
        }
    }

    public class NetWorkChangeReceiver extends SafeBroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
        public void onReceiveMsg(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("AlbumFileViewFragment", "intent is null.");
                return;
            }
            C1120a.m6677i("AlbumFileViewFragment", "action: " + intent.getAction());
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || C0209d.m1333z1(AlbumFileViewFragment.this.getActivity()) || AlbumFileViewFragment.this.f10786e == null) {
                return;
            }
            ViewOnClickListenerC2266j.d dVarM14230o = AlbumFileViewFragment.this.f10786e.m14230o(AlbumFileViewFragment.this.f10788f);
            if (dVarM14230o.f10867r == null || !dVarM14230o.f10867r.isPlaying()) {
                return;
            }
            C12097j.m72480b().m72490k(AlbumFileViewFragment.this.getActivity());
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$a */
    public class C2257a implements Handler.Callback {
        public C2257a() {
        }

        /* renamed from: a */
        public final void m14203a(Message message) {
            int i10 = message.what;
            if (i10 == 122) {
                AlbumFileViewFragment.this.m14193u1(AlbumFileViewFragment.this.f10786e.m14232q(message.arg1));
            } else {
                if (i10 != 127) {
                    return;
                }
                AlbumFileViewFragment.this.m14170h1(AlbumFileViewFragment.this.f10786e.m14232q(message.arg1));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 123:
                    int i10 = message.arg1;
                    ViewOnClickListenerC2266j.d dVarM14232q = AlbumFileViewFragment.this.f10786e.m14232q(i10);
                    if (i10 != AlbumFileViewFragment.this.f10788f) {
                        return false;
                    }
                    AlbumFileViewFragment.this.m14145E1(dVarM14232q);
                    AlbumFileViewFragment.this.f10785d0.removeMessages(123);
                    AlbumFileViewFragment.this.f10785d0.sendMessageDelayed(AlbumFileViewFragment.this.m14194v0(123, dVarM14232q), 500L);
                    return false;
                case 124:
                    int i11 = message.arg1;
                    ViewOnClickListenerC2266j.d dVarM14232q2 = AlbumFileViewFragment.this.f10786e.m14232q(i11);
                    if (i11 != AlbumFileViewFragment.this.f10788f) {
                        return false;
                    }
                    AlbumFileViewFragment.this.m14144E0(dVarM14232q2);
                    if (dVarM14232q2.f10875z) {
                        dVarM14232q2.f10867r.start();
                    }
                    dVarM14232q2.f10848F = true;
                    AlbumFileViewFragment.this.f10785d0.removeMessages(123);
                    AlbumFileViewFragment.this.f10785d0.sendMessageDelayed(AlbumFileViewFragment.this.m14194v0(123, dVarM14232q2), 500L);
                    return false;
                case 125:
                    AlbumFileViewFragment.this.m14171i1(AlbumFileViewFragment.this.f10786e.m14232q(message.arg1), message);
                    return false;
                case 126:
                    AlbumFileViewFragment.this.m14165c1(AlbumFileViewFragment.this.f10786e.m14232q(message.arg1));
                    return false;
                default:
                    m14203a(message);
                    return false;
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$b */
    public class C2258b implements Handler.Callback {
        public C2258b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                AlbumFileViewFragment.this.m14147F1(message.arg1);
                return false;
            }
            if (i10 == 1) {
                AlbumFileViewFragment.this.m14179n0();
                return false;
            }
            if (i10 == 2) {
                AlbumFileViewFragment.this.m14183p0();
                return false;
            }
            if (i10 == 3) {
                MediaFileBean mediaFileBean = (MediaFileBean) message.obj;
                Media mediaM14344o = mediaFileBean.m14344o();
                AlbumFileViewFragment.this.m14175l0(mediaM14344o);
                AlbumFileViewFragment.this.m14177m0(mediaFileBean, mediaM14344o);
                return false;
            }
            if (i10 != 101) {
                if (i10 != 102) {
                    return false;
                }
                C1120a.m6677i("AlbumFileViewFragment", "MSG_DOWNLOAD_SINGLE");
                FileDownloadProgress fileDownloadProgress = (FileDownloadProgress) message.obj;
                long progress = fileDownloadProgress.getProgress();
                Activity activity = AlbumFileViewFragment.this.getActivity();
                AlbumFileViewFragment.this.m14201z0((int) progress, activity, Formatter.formatFileSize(activity, fileDownloadProgress.getFileLoadSizeByte()), fileDownloadProgress.getState());
                return false;
            }
            C1120a.m6677i("AlbumFileViewFragment", "MSG_DOWNLOAD_ALL in activity");
            Activity activity2 = AlbumFileViewFragment.this.getActivity();
            int iM68418c = ((C11421g) message.obj).m68418c();
            if (iM68418c == 1000) {
                C1120a.m6677i("AlbumFileViewFragment", "DOWNLOAD_ALL SUCCEED in activity");
                AlbumFileViewFragment albumFileViewFragment = AlbumFileViewFragment.this;
                albumFileViewFragment.m14192u0(albumFileViewFragment.f10786e.m14230o(AlbumFileViewFragment.this.f10788f));
                C12097j.m72480b().m72487h(activity2);
                return false;
            }
            if (iM68418c != 1003) {
                return false;
            }
            C1120a.m6677i("AlbumFileViewFragment", "DOWNLOAD_ALL ERROR_FAILED in activity");
            if (C0209d.m1208S0(AlbumFileViewFragment.this.getActivity())) {
                C12097j.m72480b().m72485f(activity2);
                return false;
            }
            C12097j.m72480b().m72490k(activity2);
            return false;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$c */
    public class C2259c implements WisePlayer.LoadingListener {

        /* renamed from: a */
        public final /* synthetic */ ViewOnClickListenerC2266j.d f10818a;

        public C2259c(ViewOnClickListenerC2266j.d dVar) {
            this.f10818a = dVar;
        }

        @Override // com.huawei.hms.videokit.player.WisePlayer.LoadingListener
        public void onLoadingUpdate(WisePlayer wisePlayer, int i10) {
            C1120a.m6677i("AlbumFileViewFragment", "loading percent: " + i10);
            AlbumFileViewFragment.this.f10785d0.removeMessages(123);
            AlbumFileViewFragment.this.f10785d0.sendMessage(AlbumFileViewFragment.this.m14194v0(122, this.f10818a));
        }

        @Override // com.huawei.hms.videokit.player.WisePlayer.LoadingListener
        public void onStartPlaying(WisePlayer wisePlayer) {
            C1120a.m6677i("AlbumFileViewFragment", "onStartPlaying ");
            AlbumFileViewFragment.this.f10785d0.sendMessage(AlbumFileViewFragment.this.m14194v0(127, this.f10818a));
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$d */
    public class AnimationAnimationListenerC2260d implements Animation.AnimationListener {
        public AnimationAnimationListenerC2260d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AlbumFileViewFragment.this.f10759H == null) {
                return;
            }
            AlbumFileViewFragment.this.f10759H.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$e */
    public static class C2261e extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<MediaFileBean> f10821a;

        /* renamed from: b */
        public WeakReference<Handler> f10822b;

        /* renamed from: c */
        public WeakReference<ViewOnClickListenerC2266j.d> f10823c;

        /* renamed from: d */
        public int f10824d;

        public C2261e(MediaFileBean mediaFileBean, Handler handler, ViewOnClickListenerC2266j.d dVar, int i10) {
            this.f10821a = new WeakReference<>(mediaFileBean);
            this.f10822b = new WeakReference<>(handler);
            this.f10823c = new WeakReference<>(dVar);
            this.f10824d = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Uri uriM14333g;
            MediaFileBean mediaFileBean = this.f10821a.get();
            Handler handler = this.f10822b.get();
            ViewOnClickListenerC2266j.d dVar = this.f10823c.get();
            if (mediaFileBean == null || handler == null || dVar == null) {
                return;
            }
            boolean zM72454X = C12096i.m72418I().m72454X(mediaFileBean.m14344o());
            if (!zM72454X && (uriM14333g = mediaFileBean.m14333g()) != null && new File(uriM14333g.toString()).exists()) {
                zM72454X = true;
            }
            dVar.f10843A = zM72454X;
            Message messageM14132w0 = AlbumFileViewFragment.m14132w0(SyncType.AUTO_SYNC_CALLLOG, dVar, handler);
            messageM14132w0.arg2 = this.f10824d;
            handler.sendMessage(messageM14132w0);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$f */
    public static class C2262f extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<MediaFileBean> f10825a;

        /* renamed from: b */
        public WeakReference<Handler> f10826b;

        public C2262f(MediaFileBean mediaFileBean, Handler handler) {
            this.f10825a = new WeakReference<>(mediaFileBean);
            this.f10826b = new WeakReference<>(handler);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            MediaFileBean mediaFileBean = this.f10825a.get();
            Handler handler = this.f10826b.get();
            if (mediaFileBean == null || handler == null) {
                return;
            }
            C12950j c12950j = new C12950j();
            Media mediaM14344o = mediaFileBean.m14344o();
            if (mediaM14344o == null) {
                C1120a.m6676e("AlbumFileViewFragment", "getItemCurrentUploadStatus media is null");
                return;
            }
            int iM77860p = c12950j.m77860p(mediaM14344o);
            C1120a.m6677i("AlbumFileViewFragment", "new uploadStatus is " + iM77860p);
            if (iM77860p == 0 || iM77860p == mediaFileBean.m14308K()) {
                return;
            }
            C1120a.m6677i("AlbumFileViewFragment", "UploadStatus from " + mediaFileBean.m14308K() + " to " + iM77860p + ", need change");
            mediaFileBean.m14357w0(iM77860p);
            Message message = new Message();
            message.what = 3;
            message.obj = mediaFileBean;
            handler.sendMessage(message);
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$g */
    public static class C2263g extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<MediaFileBean> f10827a;

        /* renamed from: b */
        public WeakReference<Context> f10828b;

        /* renamed from: c */
        public boolean f10829c;

        public /* synthetic */ C2263g(Context context, MediaFileBean mediaFileBean, boolean z10, C2257a c2257a) {
            this(context, mediaFileBean, z10);
        }

        /* renamed from: c */
        public final boolean m14204c(String str) {
            Context context = this.f10828b.get();
            if (context == null) {
                return false;
            }
            File fileM63442h = C10278a.m63442h(str);
            if (fileM63442h.exists()) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(3);
                    intent.setDataAndType(Uri.parse(str), C14034a.m84171h(fileM63442h).m73356b());
                    context.startActivity(intent);
                    return true;
                } catch (Exception e10) {
                    C1120a.m6676e("AlbumFileViewFragment", "OpenLocalVideoRunnable error: " + e10.toString());
                }
            }
            return false;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            MediaFileBean mediaFileBean = this.f10827a.get();
            if (mediaFileBean == null || m14204c(mediaFileBean.m14333g().toString())) {
                return;
            }
            Media mediaM14344o = mediaFileBean.m14344o();
            if (mediaM14344o == null || TextUtils.isEmpty(mediaM14344o.getId())) {
                C1120a.m6676e("AlbumFileViewFragment", "OpenLocalVideoRunnable media is null");
                return;
            }
            if (m14204c(this.f10829c ? mediaFileBean.m14350s() : C12096i.m72418I().m72453W(mediaM14344o))) {
                return;
            }
            C1120a.m6676e("AlbumFileViewFragment", "openLocalVedio failed");
        }

        public C2263g(Context context, MediaFileBean mediaFileBean, boolean z10) {
            this.f10828b = new WeakReference<>(context);
            this.f10827a = new WeakReference<>(mediaFileBean);
            this.f10829c = z10;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$h */
    public static class C2264h extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<ArrayList<Media>> f10830a;

        public C2264h(ArrayList<Media> arrayList) {
            this.f10830a = new WeakReference<>(arrayList);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                ArrayList<Media> arrayList = this.f10830a.get();
                if (arrayList == null) {
                    return;
                }
                C12469b.m74746l().m74753g(arrayList);
            } catch (Exception e10) {
                C1120a.m6677i("AlbumFileViewFragment", "deleteShareMedia exception:" + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$i */
    public static class C2265i extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<MediaFileBean> f10831a;

        /* renamed from: b */
        public WeakReference<Context> f10832b;

        public C2265i(Context context, MediaFileBean mediaFileBean) {
            this.f10832b = new WeakReference<>(context);
            this.f10831a = new WeakReference<>(mediaFileBean);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            MediaFileBean mediaFileBean = this.f10831a.get();
            Context context = this.f10832b.get();
            if (mediaFileBean == null || context == null) {
                return;
            }
            Media mediaM14344o = mediaFileBean.m14344o();
            if (mediaM14344o == null || TextUtils.isEmpty(mediaM14344o.getId())) {
                C1120a.m6676e("AlbumFileViewFragment", "ShareRunnable media is null");
                return;
            }
            String strM72453W = C12096i.m72418I().m72453W(mediaM14344o);
            if (TextUtils.isEmpty(strM72453W)) {
                return;
            }
            File fileM63442h = C10278a.m63442h(strM72453W);
            if (fileM63442h.exists()) {
                try {
                    Intent intent = new Intent();
                    intent.addFlags(3);
                    Uri uriForFile = FileProvider.getUriForFile(context, FeedbackConst.Mail.HIDISK_FILE_PROVIDER, fileM63442h);
                    C12202a c12202aM84171h = C14034a.m84171h(fileM63442h);
                    intent.setAction("android.intent.action.SEND");
                    intent.setType(c12202aM84171h.m73356b());
                    intent.putExtra("android.intent.extra.STREAM", uriForFile);
                    context.startActivity(Intent.createChooser(intent, ""));
                } catch (Exception e10) {
                    C1120a.m6676e("AlbumFileViewFragment", "share error: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j */
    public class ViewOnClickListenerC2266j extends AbstractC0984a implements ViewPager.InterfaceC0980i, View.OnClickListener {

        /* renamed from: h */
        public List<SoftReference<d>> f10833h = new ArrayList();

        /* renamed from: i */
        public List<MediaFileBean> f10834i;

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$a */
        public class a implements SurfaceHolder.Callback {

            /* renamed from: a */
            public final /* synthetic */ d f10836a;

            public a(d dVar) {
                this.f10836a = dVar;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                if (this.f10836a.f10867r != null) {
                    C1120a.m6677i("AlbumFileViewFragment", "surfaceChanged");
                    this.f10836a.f10867r.setSurfaceChange();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                this.f10836a.f10869t = true;
                if (this.f10836a.f10867r != null) {
                    C1120a.m6677i("AlbumFileViewFragment", "surfaceCreated");
                    if (this.f10836a.f10871v) {
                        return;
                    }
                    this.f10836a.f10867r.setView(this.f10836a.f10866q);
                    this.f10836a.f10871v = true;
                    this.f10836a.f10867r.setBookmark(this.f10836a.f10870u);
                    if (AlbumFileViewFragment.this.f10781b0) {
                        C1120a.m6677i("AlbumFileViewFragment", "resume");
                        this.f10836a.f10867r.resume(-1);
                        if (AlbumFileViewFragment.this.f10785d0.hasMessages(123)) {
                            return;
                        }
                        AlbumFileViewFragment.this.f10785d0.sendMessageDelayed(AlbumFileViewFragment.this.m14194v0(123, this.f10836a), 500L);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                this.f10836a.f10869t = false;
                if (this.f10836a.f10867r != null) {
                    C1120a.m6677i("AlbumFileViewFragment", "surfaceDestroyed");
                    this.f10836a.f10871v = false;
                    d dVar = this.f10836a;
                    dVar.f10870u = dVar.f10867r.getCurrentTime();
                    this.f10836a.f10867r.suspend();
                }
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$b */
        public class b implements SeekBar.OnSeekBarChangeListener {

            /* renamed from: a */
            public final /* synthetic */ d f10838a;

            public b(d dVar) {
                this.f10838a = dVar;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
                this.f10838a.f10857h.setText(C1122c.m6715M(i10));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (this.f10838a.f10867r != null) {
                    AlbumFileViewFragment.this.m14193u1(this.f10838a);
                    int progress = seekBar.getProgress();
                    seekBar.setSecondaryProgress(this.f10838a.f10867r.getBufferTime());
                    this.f10838a.f10857h.setText(C1122c.m6715M(progress));
                    this.f10838a.f10867r.seek(progress);
                    if (!this.f10838a.f10867r.isPlaying()) {
                        this.f10838a.f10867r.start();
                    }
                    AlbumFileViewFragment.this.f10785d0.removeMessages(123);
                    AlbumFileViewFragment.this.f10785d0.sendEmptyMessageDelayed(123, 500L);
                }
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$c */
        public class c extends AbstractC12367d {

            /* renamed from: a */
            public final /* synthetic */ d f10840a;

            /* renamed from: b */
            public final /* synthetic */ Media f10841b;

            public c(d dVar, Media media) {
                this.f10840a = dVar;
                this.f10841b = media;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                this.f10840a.f10865p = C9050d.m57079j(AlbumFileViewFragment.this.getActivity(), this.f10841b);
                if (this.f10840a.f10865p != null && !this.f10840a.f10865p.isEmpty()) {
                    this.f10840a.f10845C = true;
                }
                C13108a.m78878b(AlbumFileViewFragment.this.getActivity()).m78881d(new Intent("com.huawei.hicloud.checkVedioButton"));
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$d */
        public class d {

            /* renamed from: a */
            public int f10850a;

            /* renamed from: b */
            public FileViewerImageView f10851b;

            /* renamed from: c */
            public ImageView f10852c;

            /* renamed from: d */
            public ImageView f10853d;

            /* renamed from: e */
            public TextView f10854e;

            /* renamed from: f */
            public NotchFitLinearLayout f10855f;

            /* renamed from: g */
            public ImageView f10856g;

            /* renamed from: h */
            public HwTextView f10857h;

            /* renamed from: i */
            public HwTextView f10858i;

            /* renamed from: j */
            public SeekBar f10859j;

            /* renamed from: k */
            public ImageView f10860k;

            /* renamed from: l */
            public LinearLayout f10861l;

            /* renamed from: m */
            public View f10862m;

            /* renamed from: n */
            public int f10863n;

            /* renamed from: o */
            public LinearLayout f10864o;

            /* renamed from: p */
            public String f10865p;

            /* renamed from: q */
            public SurfaceView f10866q;

            /* renamed from: r */
            public WisePlayer f10867r;

            /* renamed from: s */
            public RelativeLayout f10868s;

            /* renamed from: w */
            public int f10872w;

            /* renamed from: x */
            public int f10873x;

            /* renamed from: y */
            public int f10874y;

            /* renamed from: t */
            public boolean f10869t = false;

            /* renamed from: u */
            public int f10870u = 0;

            /* renamed from: v */
            public boolean f10871v = false;

            /* renamed from: z */
            public boolean f10875z = false;

            /* renamed from: A */
            public boolean f10843A = false;

            /* renamed from: B */
            public boolean f10844B = false;

            /* renamed from: C */
            public boolean f10845C = false;

            /* renamed from: D */
            public boolean f10846D = true;

            /* renamed from: E */
            public boolean f10847E = false;

            /* renamed from: F */
            public boolean f10848F = false;

            public d() {
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$e */
        public class e extends AbstractC12367d {

            /* renamed from: a */
            public WeakReference<MediaFileBean> f10876a;

            /* renamed from: b */
            public WeakReference<Integer> f10877b;

            /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$e$a */
            public class a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ Media f10879a;

                /* renamed from: b */
                public final /* synthetic */ MediaFileBean f10880b;

                public a(Media media, MediaFileBean mediaFileBean) {
                    this.f10879a = media;
                    this.f10880b = mediaFileBean;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (AlbumFileViewFragment.this.isAdded()) {
                        ViewOnClickListenerC2266j.this.m14239x(this.f10879a, this.f10880b);
                    }
                }
            }

            public e(MediaFileBean mediaFileBean, int i10) {
                this.f10876a = new WeakReference<>(mediaFileBean);
                this.f10877b = new WeakReference<>(Integer.valueOf(i10));
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                WeakReference<MediaFileBean> weakReference = this.f10876a;
                if (weakReference == null || this.f10877b == null) {
                    return;
                }
                MediaFileBean mediaFileBean = weakReference.get();
                int iIntValue = this.f10877b.get().intValue();
                if (mediaFileBean == null) {
                    return;
                }
                Media mediaM14344o = mediaFileBean.m14344o();
                if (iIntValue == AlbumFileViewFragment.this.f10788f) {
                    AlbumFileViewFragment.this.f10785d0.post(new a(mediaM14344o, mediaFileBean));
                }
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$f */
        public class f extends AbstractC12367d {

            /* renamed from: a */
            public int f10882a;

            /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$f$a */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (AlbumFileViewFragment.this.isAdded()) {
                        f fVar = f.this;
                        ViewOnClickListenerC2266j.this.m14238w(fVar.f10882a);
                    }
                }
            }

            public f(int i10) {
                this.f10882a = i10;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                Media media = (Media) AlbumFileViewFragment.this.m14172j1(this.f10882a).get(0);
                MediaFileBean mediaFileBean = new MediaFileBean();
                mediaFileBean.m14332f0(C1122c.m6844x(media));
                mediaFileBean.m14354u0(C0069g.m479y().m480A(media));
                mediaFileBean.m14336h0(media.getCreatedTime().m28458c());
                mediaFileBean.m14319V(Uri.parse(media.getLocalRealPath()));
                mediaFileBean.m14318U(media.getFileName());
                mediaFileBean.m14328d0(new C11417c());
                mediaFileBean.m14314Q(true);
                mediaFileBean.m14326c0(this.f10882a);
                mediaFileBean.m14353t0(C10159j.m63325a(C0213f.m1377a(), media.getCreatedTime().m28458c(), C11842p.m70828k()));
                C1122c.m6784g2(media, mediaFileBean);
                AlbumFileViewFragment.this.f10798k.set(this.f10882a, mediaFileBean);
                AlbumFileViewFragment.this.f10785d0.post(new a());
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$g */
        public class g extends AbstractC12367d {

            /* renamed from: a */
            public WeakReference<MediaFileBean> f10885a;

            /* renamed from: b */
            public WeakReference<d> f10886b;

            /* renamed from: c */
            public WeakReference<Integer> f10887c;

            /* renamed from: d */
            public WeakReference<Integer> f10888d;

            /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$g$a */
            public class a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ Media f10890a;

                /* renamed from: b */
                public final /* synthetic */ MediaFileBean f10891b;

                /* renamed from: c */
                public final /* synthetic */ d f10892c;

                /* renamed from: d */
                public final /* synthetic */ int f10893d;

                public a(Media media, MediaFileBean mediaFileBean, d dVar, int i10) {
                    this.f10890a = media;
                    this.f10891b = mediaFileBean;
                    this.f10892c = dVar;
                    this.f10893d = i10;
                }

                @Override // java.lang.Runnable
                public void run() throws IOException {
                    if (AlbumFileViewFragment.this.isAdded()) {
                        ViewOnClickListenerC2266j.this.m14217D(this.f10890a, this.f10891b, this.f10892c, this.f10893d);
                        ViewOnClickListenerC2266j.this.m14215B(this.f10891b, this.f10892c);
                    }
                }
            }

            public g(MediaFileBean mediaFileBean, d dVar, int i10, int i11) {
                this.f10885a = new WeakReference<>(mediaFileBean);
                this.f10886b = new WeakReference<>(dVar);
                this.f10887c = new WeakReference<>(Integer.valueOf(i10));
                this.f10888d = new WeakReference<>(Integer.valueOf(i11));
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                WeakReference<MediaFileBean> weakReference = this.f10885a;
                if (weakReference == null || this.f10886b == null || this.f10887c == null || this.f10888d == null) {
                    return;
                }
                MediaFileBean mediaFileBean = weakReference.get();
                d dVar = this.f10886b.get();
                int iIntValue = this.f10887c.get().intValue();
                int iIntValue2 = this.f10888d.get().intValue();
                if (mediaFileBean == null || dVar == null) {
                    return;
                }
                Media mediaM14344o = mediaFileBean.m14344o();
                if (iIntValue2 == AlbumFileViewFragment.this.f10788f) {
                    AlbumFileViewFragment.this.f10785d0.post(new a(mediaM14344o, mediaFileBean, dVar, iIntValue));
                }
            }
        }

        /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$h */
        public class h extends AbstractC12367d {

            /* renamed from: a */
            public int f10895a;

            /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$h$a */
            public class a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ d f10897a;

                public a(d dVar) {
                    this.f10897a = dVar;
                }

                @Override // java.lang.Runnable
                public void run() throws IOException {
                    if (this.f10897a == null || !AlbumFileViewFragment.this.isAdded()) {
                        return;
                    }
                    h hVar = h.this;
                    ViewOnClickListenerC2266j.this.m14216C(hVar.f10895a, this.f10897a);
                }
            }

            public h(int i10) {
                this.f10895a = i10;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                Media media = (Media) AlbumFileViewFragment.this.m14172j1(this.f10895a).get(0);
                MediaFileBean mediaFileBean = new MediaFileBean();
                mediaFileBean.m14332f0(C1122c.m6844x(media));
                mediaFileBean.m14354u0(C0069g.m479y().m480A(media));
                mediaFileBean.m14336h0(media.getCreatedTime().m28458c());
                mediaFileBean.m14319V(Uri.parse(media.getLocalRealPath()));
                mediaFileBean.m14318U(media.getFileName());
                mediaFileBean.m14328d0(new C11417c());
                mediaFileBean.m14314Q(true);
                mediaFileBean.m14326c0(this.f10895a);
                mediaFileBean.m14353t0(C10159j.m63325a(C0213f.m1377a(), media.getCreatedTime().m28458c(), C11842p.m70828k()));
                C1122c.m6784g2(media, mediaFileBean);
                AlbumFileViewFragment.this.f10798k.set(this.f10895a, mediaFileBean);
                AlbumFileViewFragment.this.f10785d0.post(new a(ViewOnClickListenerC2266j.this.m14230o(this.f10895a)));
            }
        }

        public ViewOnClickListenerC2266j(List<MediaFileBean> list) throws Resources.NotFoundException {
            this.f10834i = list;
            AlbumFileViewFragment.this.f10784d.setAdapter(this);
            AlbumFileViewFragment.this.f10784d.addOnPageChangeListener(this);
        }

        /* renamed from: A */
        public final Bitmap m14214A(Media media, MediaFileBean mediaFileBean, d dVar, Bitmap bitmap) {
            KvDatabaseWrapper kvDatabaseWrapperM72352f0;
            if (C1122c.m6805m(mediaFileBean.m14333g().toString())) {
                bitmap = C1122c.m6719N0(C12094g.m72412d().m72417e(mediaFileBean.m14333g(), mediaFileBean), media.getRotation());
            }
            Bitmap bitmapM7184c = C1138s.m7181d().m7184c(media.getId());
            if (!TextUtils.isEmpty(media.getId()) && bitmapM7184c == null && (kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0()) != null) {
                bitmapM7184c = kvDatabaseWrapperM72352f0.m30071b(media.getId());
            }
            if (bitmapM7184c != null) {
                C1120a.m6677i("AlbumFileViewFragment", "setFileInfoContent video have thumb cache");
                dVar.f10851b.setImageDrawable(new BitmapDrawable(AlbumFileViewFragment.this.getResources(), bitmapM7184c));
            }
            if (bitmap == null) {
                C12091d.m72280a0().m72300D(media, dVar.f10851b, dVar.f10850a);
            }
            dVar.f10863n = 5;
            if (dVar.f10855f.getVisibility() != 0 && dVar.f10845C) {
                dVar.f10852c.setVisibility(0);
                AlbumFileViewFragment.this.f10810w.setVisibility(8);
            }
            try {
                dVar.f10874y = media.getVideoMetaData().getRotation().intValue();
            } catch (Exception e10) {
                C1120a.m6676e("AlbumFileViewFragment", "videoMetaData lack of data: " + e10.toString());
            }
            C12515a.m75110o().m75175e(new c(dVar, media), false);
            return bitmap;
        }

        /* renamed from: B */
        public final void m14215B(MediaFileBean mediaFileBean, d dVar) {
            Uri uriM14333g = mediaFileBean.m14333g();
            if (uriM14333g == null) {
                return;
            }
            String string = uriM14333g.toString();
            int iM14338j = mediaFileBean.m14338j();
            if ((iM14338j == 5 || iM14338j == 3) && !TextUtils.isEmpty(string) && new File(string).exists()) {
                dVar.f10844B = true;
            }
        }

        /* renamed from: C */
        public final void m14216C(int i10, d dVar) throws IOException {
            C1120a.m6677i("AlbumFileViewFragment", "setFileInfo");
            MediaFileBean mediaFileBean = this.f10834i.get(i10);
            if (mediaFileBean == null) {
                C12515a.m75110o().m75175e(new h(i10), false);
            } else if (!C1122c.m6823q1(mediaFileBean.m14352t())) {
                m14217D(mediaFileBean.m14344o(), mediaFileBean, dVar, i10);
                m14215B(mediaFileBean, dVar);
            } else {
                C12515a.m75110o().m75175e(new g(mediaFileBean, dVar, i10, mediaFileBean.m14342m()), false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
        /* renamed from: D */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m14217D(com.huawei.android.hicloud.drive.cloudphoto.model.Media r11, com.huawei.android.p069cg.bean.MediaFileBean r12, com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d r13, int r14) throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r12.m14338j()
                r1 = 8
                r2 = 2
                if (r0 != r2) goto L3b
                p6.g r0 = p546p6.C12094g.m72412d()
                android.net.Uri r3 = r12.m14333g()
                java.lang.String r3 = r3.toString()
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r4 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                int r4 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14103c0(r4)
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r5 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                int r5 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14105d0(r5)
                android.graphics.Bitmap r0 = r0.m72416c(r3, r4, r5)
                com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d.m14290l(r13, r2)
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r2 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar r2 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14107e0(r2)
                r2.setVisibility(r1)
                int r2 = r12.m14349r()
                android.graphics.Bitmap r0 = p031b7.C1122c.m6719N0(r0, r2)
            L39:
                r9 = r0
                goto L88
            L3b:
                int r0 = r12.m14338j()
                r2 = 3
                if (r0 != r2) goto L63
                p6.g r0 = p546p6.C12094g.m72412d()
                android.net.Uri r3 = r12.m14333g()
                android.graphics.Bitmap r0 = r0.m72417e(r3, r12)
                com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d.m14290l(r13, r2)
                android.widget.ImageView r2 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d.m14298s(r13)
                r3 = 0
                r2.setVisibility(r3)
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r2 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar r2 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14107e0(r2)
                r2.setVisibility(r1)
                goto L39
            L63:
                int r0 = r12.m14338j()
                r2 = 5
                r3 = 0
                if (r0 != r2) goto L70
                android.graphics.Bitmap r0 = r10.m14214A(r11, r12, r13, r3)
                goto L39
            L70:
                int r0 = r12.m14338j()
                r2 = 4
                if (r0 != r2) goto L7c
                android.graphics.Bitmap r0 = r10.m14241z(r11, r12, r13, r3)
                goto L39
            L7c:
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                android.widget.TextView r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14087R(r0)
                java.lang.String r2 = ""
                r0.setText(r2)
                r9 = r3
            L88:
                if (r9 == 0) goto L9c
                com.huawei.android.cg.ui.fileviewdrag.FileViewerImageView r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d.m14242A(r13)
                android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r3 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                android.content.res.Resources r3 = r3.getResources()
                r2.<init>(r3, r9)
                r0.setImageDrawable(r2)
            L9c:
                boolean r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d.m14269a0(r13)
                if (r0 == 0) goto Lb7
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                int r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14114i(r0)
                int r2 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.d.m14268a(r13)
                if (r0 != r2) goto Lb7
                com.huawei.android.cg.activity.fragment.AlbumFileViewFragment r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.this
                com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar r0 = com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.m14107e0(r0)
                r0.setVisibility(r1)
            Lb7:
                r4 = r10
                r5 = r11
                r6 = r12
                r7 = r13
                r8 = r14
                r4.m14218E(r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.m14217D(com.huawei.android.hicloud.drive.cloudphoto.model.Media, com.huawei.android.cg.bean.MediaFileBean, com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$j$d, int):void");
        }

        /* renamed from: E */
        public final void m14218E(Media media, MediaFileBean mediaFileBean, d dVar, int i10, Bitmap bitmap) {
            if (media == null) {
                return;
            }
            boolean zEquals = media.containsKey("mediaOwnerId") ? media.getMediaOwnerId().equals(AlbumFileViewFragment.this.f10797j0) : false;
            boolean zEquals2 = media.containsKey("creator") ? media.getCreator().getUserId().equals(AlbumFileViewFragment.this.f10797j0) : false;
            boolean zM14152N0 = AlbumFileViewFragment.this.m14152N0(media);
            boolean zM14151M0 = AlbumFileViewFragment.this.m14151M0(media);
            if (zM14152N0 || zM14151M0) {
                m14222I(mediaFileBean, dVar, i10, bitmap, zEquals, zEquals2, zM14152N0, zM14151M0);
                return;
            }
            if (mediaFileBean.m14338j() != 4 && mediaFileBean.m14338j() != 5) {
                m14220G(bitmap, dVar);
                return;
            }
            C1120a.m6677i("AlbumFileViewFragment", "not processing, and is cloud file");
            if (dVar.f10855f.getVisibility() != 0) {
                dVar.f10851b.setVisibility(0);
            }
        }

        /* renamed from: F */
        public final void m14219F(boolean z10, boolean z11, d dVar) {
            C1120a.m6677i("AlbumFileViewFragment", "setIllegalPic");
            dVar.f10851b.setVisibility(8);
            dVar.f10852c.setVisibility(8);
            dVar.f10853d.setVisibility(0);
            dVar.f10854e.setVisibility(0);
            if (z10) {
                dVar.f10853d.setImageDrawable(AlbumFileViewFragment.this.getActivity().getDrawable(R$drawable.album_content_processing));
                dVar.f10854e.setText(AlbumFileViewFragment.this.getString(R$string.album_sub_title_upload_check));
            } else if (z11) {
                dVar.f10853d.setImageDrawable(AlbumFileViewFragment.this.getActivity().getDrawable(R$drawable.album_content_error));
                dVar.f10854e.setText(AlbumFileViewFragment.this.getString(R$string.album_sub_title_upload_illegal));
            }
        }

        /* renamed from: G */
        public final void m14220G(Bitmap bitmap, d dVar) {
            C1120a.m6677i("AlbumFileViewFragment", "setMainPic");
            Activity activity = AlbumFileViewFragment.this.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (bitmap != null) {
                dVar.f10851b.setImageDrawable(new BitmapDrawable(AlbumFileViewFragment.this.getResources(), bitmap));
                dVar.f10853d.setVisibility(8);
                dVar.f10854e.setVisibility(8);
                return;
            }
            dVar.f10851b.setVisibility(8);
            dVar.f10853d.setVisibility(0);
            dVar.f10852c.setVisibility(8);
            if (AlbumFileViewFragment.this.f10792h) {
                dVar.f10853d.setImageDrawable(activity.getDrawable(R$drawable.ic_album_local_content_error));
                dVar.f10854e.setVisibility(8);
            } else {
                dVar.f10853d.setImageDrawable(activity.getDrawable(R$drawable.album_content_error));
                dVar.f10854e.setVisibility(0);
                dVar.f10854e.setText(AlbumFileViewFragment.this.getString(R$string.album_sub_title_upload_file_not_exist));
            }
        }

        /* renamed from: H */
        public final void m14221H(d dVar, View view) {
            C1120a.m6677i("AlbumFileViewFragment", "setOnlineVideoButton");
            dVar.f10861l = (LinearLayout) C12809f.m76831d(view, R$id.play_video_online_progress_layout);
            dVar.f10855f = (NotchFitLinearLayout) C12809f.m76831d(view, R$id.ll_play_control);
            AlbumFileViewFragment.this.m14184p1(AlbumFileViewFragment.this.getActivity());
            dVar.f10856g = (ImageView) C12809f.m76831d(view, R$id.play_video_online_icon);
            dVar.f10857h = (HwTextView) C12809f.m76831d(view, R$id.current_time_tv);
            dVar.f10858i = (HwTextView) C12809f.m76831d(view, R$id.total_time_tv);
            dVar.f10859j = (SeekBar) C12809f.m76831d(view, R$id.seek_bar);
            dVar.f10860k = (ImageView) C12809f.m76831d(view, R$id.voice_btn);
            dVar.f10856g.setOnClickListener(this);
            dVar.f10860k.setOnClickListener(this);
            dVar.f10862m = C12809f.m76831d(view, R$id.background_bottom);
            dVar.f10859j.setOnSeekBarChangeListener(new b(dVar));
        }

        /* renamed from: I */
        public final void m14222I(MediaFileBean mediaFileBean, d dVar, int i10, Bitmap bitmap, boolean z10, boolean z11, boolean z12, boolean z13) {
            if (!z11) {
                if (!z10) {
                    C1120a.m6677i("AlbumFileViewFragment", "setFileInfo in error branch");
                    return;
                }
                C1120a.m6677i("AlbumFileViewFragment", "setFileInfo isPicUploadByNowUser, position=" + i10);
                m14219F(z12, z13, dVar);
                return;
            }
            C1120a.m6677i("AlbumFileViewFragment", "setFileInfo isPicUploadByNowUser, position=" + i10);
            if (mediaFileBean.m14338j() != 4 && mediaFileBean.m14338j() != 5) {
                m14220G(bitmap, dVar);
                return;
            }
            C1120a.m6677i("AlbumFileViewFragment", "processing, isPicUploadByNowUser and is cloud file");
            if (dVar.f10855f.getVisibility() != 0) {
                dVar.f10851b.setVisibility(0);
            }
        }

        /* renamed from: J */
        public final void m14223J(Media media, d dVar) {
            long jLongValue = media.getSize().longValue();
            String fileSize = Formatter.formatFileSize(AlbumFileViewFragment.this.getActivity(), jLongValue);
            int iM1357g = C0212e0.m1357g(AlbumFileViewFragment.this.getActivity(), "mobile_data_tips_sp", "current_tips_setting_type", 0);
            if (iM1357g == 0) {
                C12097j.m72480b().m72482c(AlbumFileViewFragment.this.getActivity(), fileSize, 1, AlbumFileViewFragment.this.f10793h0);
                return;
            }
            if (iM1357g != 1) {
                if (iM1357g != 2) {
                    return;
                }
                AlbumFileViewFragment.this.m14141C1(dVar);
            } else if (C1122c.f5368v < jLongValue) {
                C12097j.m72480b().m72482c(AlbumFileViewFragment.this.getActivity(), fileSize, 1, AlbumFileViewFragment.this.f10793h0);
            } else {
                AlbumFileViewFragment.this.m14141C1(dVar);
            }
        }

        /* renamed from: K */
        public final void m14224K(d dVar) {
            if (dVar.f10867r != null) {
                C1120a.m6677i("AlbumFileViewFragment", "stopPlaying");
                AlbumFileViewFragment.this.f10785d0.removeMessages(123);
                dVar.f10856g.setImageResource(R$drawable.ic_play_video_start);
                dVar.f10859j.setProgress(0);
                dVar.f10859j.setSecondaryProgress(0);
                dVar.f10867r.seek(0);
                dVar.f10867r.pause();
            }
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, final int i10, Object obj) {
            C1120a.m6677i("AlbumFileViewFragment", "destroyItem, position = " + i10);
            if (viewGroup instanceof ViewPager) {
                if (obj != null) {
                    viewGroup.removeView((View) obj);
                } else {
                    if (i10 < 0 || i10 >= viewGroup.getChildCount()) {
                        C1120a.m6676e("AlbumFileViewFragment", "destroyItem position illgal");
                        return;
                    }
                    viewGroup.removeViewAt(i10);
                }
            }
            if (this.f10834i.isEmpty()) {
                AlbumFileViewFragment.this.onDestroy();
            }
            if (this.f10833h.isEmpty()) {
                return;
            }
            this.f10833h.removeIf(new Predicate() { // from class: l6.h
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    return this.f52834a.m14234s(i10, (SoftReference) obj2);
                }
            });
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            List<MediaFileBean> list = this.f10834i;
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
        public Object instantiateItem(ViewGroup viewGroup, int i10) throws IOException {
            C1120a.m6677i("AlbumFileViewFragment", "instantiateItem, position = " + i10);
            if (i10 < 0 || i10 >= this.f10834i.size()) {
                C1120a.m6677i("AlbumFileViewFragment", "share link instantiateItem--IndexOutOfBoundsException");
                return null;
            }
            View viewM14225j = m14225j(i10);
            viewM14225j.setTag(this.f10834i.get(i10));
            if (viewGroup != null && (viewGroup instanceof ViewPager)) {
                viewGroup.addView(viewM14225j);
            }
            return viewM14225j;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* renamed from: j */
        public final View m14225j(int i10) throws IOException {
            C1120a.m6677i("AlbumFileViewFragment", "addPage, position = " + i10);
            Activity activity = AlbumFileViewFragment.this.getActivity();
            if (activity == null) {
                C1120a.m6676e("AlbumFileViewFragment", "addPage activity is null");
                return null;
            }
            d dVar = new d();
            dVar.f10850a = i10;
            View viewInflate = activity.getLayoutInflater().inflate(R$layout.album_thumbs_detail_viewpager_content, (ViewGroup) null);
            dVar.f10851b = (FileViewerImageView) C12809f.m76831d(viewInflate, R$id.image_view_share_detail);
            dVar.f10852c = (ImageView) C12809f.m76831d(viewInflate, R$id.video_start_button_image);
            dVar.f10853d = (ImageView) C12809f.m76831d(viewInflate, R$id.image_fail_tips_iv);
            dVar.f10854e = (TextView) C12809f.m76831d(viewInflate, R$id.image_fail_tips_tv);
            dVar.f10851b.setOnClickListener(this);
            dVar.f10852c.setOnClickListener(this);
            m14221H(dVar, viewInflate);
            dVar.f10866q = (SurfaceView) C12809f.m76831d(viewInflate, R$id.video_play_surfaceView);
            dVar.f10864o = (LinearLayout) C12809f.m76831d(viewInflate, R$id.viewpager_bg_ll);
            dVar.f10864o.setOnClickListener(this);
            SurfaceHolder holder = dVar.f10866q.getHolder();
            holder.addCallback(new a(dVar));
            holder.setType(3);
            dVar.f10868s = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.online_video_rl);
            m14216C(i10, dVar);
            AlbumFileViewFragment.this.m14192u0(dVar);
            AlbumFileViewFragment.this.mo14190t0(dVar);
            this.f10833h.add(new SoftReference<>(dVar));
            return viewInflate;
        }

        /* renamed from: k */
        public final void m14226k(d dVar) {
            if (AlbumFileViewFragment.this.f10775X) {
                AlbumFileViewFragment.this.f10775X = false;
                AlbumFileViewFragment.this.f10754C.setVisibility(8);
                dVar.f10855f.setVisibility(8);
                dVar.f10862m.setVisibility(8);
                return;
            }
            AlbumFileViewFragment.this.f10775X = true;
            if (AlbumFileViewFragment.this.f10792h) {
                AlbumFileViewFragment.this.f10754C.setVisibility(8);
            } else {
                AlbumFileViewFragment.this.f10754C.setVisibility(0);
            }
            if (dVar.f10867r != null && dVar.f10852c.getVisibility() == 8) {
                dVar.f10855f.setVisibility(0);
            }
            dVar.f10862m.setVisibility(0);
        }

        /* renamed from: l */
        public final boolean m14227l() {
            C1120a.m6677i("AlbumFileViewFragment", "checkIsOnlinePlayAvaliable");
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C1120a.m6676e("AlbumFileViewFragment", "isOnlinePlayAvaliable is null");
                return true;
            }
            boolean zIsOnlinePlayAvaliable = hiCloudSysParamMapM60757p.isOnlinePlayAvaliable();
            C1120a.m6677i("AlbumFileViewFragment", "isOnlinePlayAvaliable from map is: " + zIsOnlinePlayAvaliable);
            return zIsOnlinePlayAvaliable;
        }

        /* renamed from: m */
        public final void m14228m() {
            Iterator<SoftReference<d>> it = this.f10833h.iterator();
            while (it.hasNext()) {
                d dVar = it.next().get();
                if (dVar != null && dVar.f10866q.getVisibility() == 0) {
                    AlbumFileViewFragment.this.m14186q1(dVar);
                }
            }
        }

        /* renamed from: n */
        public <T extends View> T m14229n(View view, Object obj) {
            if (view == null || obj == null) {
                return null;
            }
            return (T) view.findViewWithTag(obj);
        }

        /* renamed from: o */
        public final d m14230o(int i10) {
            List<SoftReference<d>> list = this.f10833h;
            if (list == null) {
                C1120a.m6676e("AlbumFileViewFragment", "getCurrentPageInfo mPages is null");
                return null;
            }
            Iterator<SoftReference<d>> it = list.iterator();
            while (it.hasNext()) {
                d dVar = it.next().get();
                if (dVar != null && dVar.f10850a == i10) {
                    return dVar;
                }
            }
            C1120a.m6676e("AlbumFileViewFragment", "getCurrentPageInfo no data");
            return null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            int id2 = view.getId();
            d dVarM14230o = m14230o(AlbumFileViewFragment.this.f10788f);
            boolean z10 = C1123d.m6855a(AlbumFileViewFragment.this.getActivity()) == 4;
            C1120a.m6677i("AlbumFileViewFragment", "isWifi: " + z10);
            if (id2 == R$id.image_view_share_detail) {
                C1120a.m6677i("AlbumFileViewFragment", "click image_view_share_detail");
                if (!AlbumFileViewFragment.this.f10774W) {
                    m14226k(dVarM14230o);
                    return;
                }
                AlbumFileViewFragment.this.m14200y1();
                AlbumFileViewFragment.this.f10760I.setVisibility(8);
                AlbumFileViewFragment.this.f10806s.setVisibility(0);
                AlbumFileViewFragment.this.f10774W = false;
                return;
            }
            if (id2 == R$id.viewpager_bg_ll) {
                C1120a.m6677i("AlbumFileViewFragment", "click viewpager_bg_ll");
                if (!AlbumFileViewFragment.this.f10774W) {
                    m14226k(dVarM14230o);
                    return;
                }
                AlbumFileViewFragment.this.m14200y1();
                AlbumFileViewFragment.this.f10760I.setVisibility(8);
                AlbumFileViewFragment.this.f10806s.setVisibility(0);
                AlbumFileViewFragment.this.f10774W = false;
                return;
            }
            if (id2 != R$id.video_start_button_image) {
                m14235t(view, dVarM14230o);
                return;
            }
            C1120a.m6677i("AlbumFileViewFragment", "click video_start_button_image");
            if (AlbumFileViewFragment.this.f10774W) {
                AlbumFileViewFragment.this.m14200y1();
                AlbumFileViewFragment.this.f10760I.setVisibility(8);
                AlbumFileViewFragment.this.f10806s.setVisibility(0);
                AlbumFileViewFragment.this.f10774W = false;
            }
            if (dVarM14230o != null && dVarM14230o.f10863n == 3) {
                m14236u(dVarM14230o);
                return;
            }
            if (dVarM14230o == null || dVarM14230o.f10863n != 5) {
                return;
            }
            if (dVarM14230o.f10844B && !dVarM14230o.f10845C) {
                m14236u(dVarM14230o);
                return;
            }
            if (dVarM14230o.f10843A && !dVarM14230o.f10845C) {
                m14236u(dVarM14230o);
                return;
            }
            if (!m14227l()) {
                Toast.makeText(AlbumFileViewFragment.this.getActivity(), AlbumFileViewFragment.this.getString(R$string.online_video_not_support), 0).show();
                return;
            }
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                C12097j.m72480b().m72490k(AlbumFileViewFragment.this.getActivity());
                return;
            }
            if (!dVarM14230o.f10845C) {
                C1120a.m6677i("AlbumFileViewFragment", "VideoUrl Not Ready");
                return;
            }
            if (z10) {
                AlbumFileViewFragment.this.m14141C1(dVarM14230o);
                return;
            }
            MediaFileBean mediaFileBeanM14187r0 = AlbumFileViewFragment.this.m14187r0();
            if (mediaFileBeanM14187r0 == null) {
                C1120a.m6676e("AlbumFileViewFragment", "mediaFileBean is null");
                return;
            }
            Media mediaM14344o = mediaFileBeanM14187r0.m14344o();
            if (mediaM14344o == null) {
                C1120a.m6676e("AlbumFileViewFragment", "media is null");
            } else {
                m14223J(mediaM14344o, dVarM14230o);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) throws Resources.NotFoundException, IOException {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("share link onPageSelected mFiles size: ");
            sb2.append(this.f10834i.size());
            sb2.append(", position: ");
            int i11 = i10 + 1;
            sb2.append(i11);
            C1120a.m6677i("AlbumFileViewFragment", sb2.toString());
            if (i10 < 0 || i10 >= this.f10834i.size()) {
                C1120a.m6676e("AlbumFileViewFragment", "share link onPageSelected position OutOfBounds");
                return;
            }
            d dVarM14230o = m14230o(i10);
            if (dVarM14230o == null) {
                C1120a.m6676e("AlbumFileViewFragment", "share link onPageSelected info is null");
                return;
            }
            AlbumFileViewFragment.this.f10788f = i10;
            AlbumFileViewFragment.this.f10784d.setCurrentItem(AlbumFileViewFragment.this.f10788f);
            m14237v();
            m14238w(i10);
            m14216C(i10, dVarM14230o);
            d dVarM14230o2 = m14230o(i10 - 1);
            d dVarM14230o3 = m14230o(i11);
            if (dVarM14230o2 != null) {
                m14224K(dVarM14230o2);
            }
            if (dVarM14230o3 != null) {
                m14224K(dVarM14230o3);
            }
            AlbumFileViewFragment.this.m14192u0(dVarM14230o);
            AlbumFileViewFragment.this.mo14190t0(dVarM14230o);
            AlbumFileViewFragment.this.m14184p1(AlbumFileViewFragment.this.getActivity());
        }

        /* renamed from: p */
        public Object m14231p(MediaFileBean mediaFileBean) {
            if (mediaFileBean != null) {
                return m14229n(AlbumFileViewFragment.this.f10784d, mediaFileBean);
            }
            C1120a.m6676e("AlbumFileViewFragment", "getItem tagKey is null");
            return null;
        }

        /* renamed from: q */
        public d m14232q(int i10) {
            Iterator<SoftReference<d>> it = this.f10833h.iterator();
            while (it.hasNext()) {
                d dVar = it.next().get();
                if (dVar != null && dVar.f10850a == i10) {
                    return dVar;
                }
            }
            C1120a.m6676e("AlbumFileViewFragment", "getItemByIndex no data");
            return null;
        }

        /* renamed from: r */
        public final MediaFileBean m14233r(int i10) {
            List<MediaFileBean> list = this.f10834i;
            if (list == null) {
                C1120a.m6676e("AlbumFileViewFragment", "getMediaFileBeanByPosition mFiles is null");
                return null;
            }
            if (i10 >= 0 && i10 < list.size()) {
                return this.f10834i.get(i10);
            }
            C1120a.m6676e("AlbumFileViewFragment", "getMediaFileBeanByPosition position error, position = " + AlbumFileViewFragment.this.f10788f + " size =  " + this.f10834i.size());
            return null;
        }

        /* renamed from: s */
        public final /* synthetic */ boolean m14234s(int i10, SoftReference softReference) {
            d dVar;
            if (softReference == null || (dVar = (d) softReference.get()) == null || dVar.f10850a != i10) {
                return false;
            }
            dVar.f10851b = null;
            dVar.f10852c = null;
            dVar.f10866q = null;
            dVar.f10867r = null;
            if (AlbumFileViewFragment.this.f10788f >= this.f10834i.size()) {
                AlbumFileViewFragment.this.f10788f = this.f10834i.size() - 1;
            }
            m14238w(i10);
            return true;
        }

        /* renamed from: t */
        public final void m14235t(View view, d dVar) {
            if (view == null) {
                C1120a.m6676e("AlbumFileViewFragment", "onClickVideoButtons view is null");
                return;
            }
            int id2 = view.getId();
            if (id2 != R$id.play_video_online_icon) {
                if (id2 == R$id.voice_btn) {
                    try {
                        if (dVar.f10846D) {
                            C1120a.m6677i("AlbumFileViewFragment", "player open voice");
                            dVar.f10846D = false;
                            dVar.f10860k.setImageResource(R$drawable.ic_play_video_open_voice);
                            dVar.f10867r.setVolume(1.0f);
                        } else {
                            C1120a.m6677i("AlbumFileViewFragment", "player close voice");
                            dVar.f10846D = true;
                            dVar.f10860k.setImageResource(R$drawable.ic_play_video_close_voice);
                            dVar.f10867r.setVolume(0.0f);
                        }
                        return;
                    } catch (Exception e10) {
                        C1120a.m6676e("AlbumFileViewFragment", e10.getMessage());
                        return;
                    }
                }
                return;
            }
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                C12097j.m72480b().m72490k(AlbumFileViewFragment.this.getActivity());
                return;
            }
            if (dVar.f10867r == null) {
                C1120a.m6677i("AlbumFileViewFragment", "player not ready");
                dVar.f10875z = true;
                AlbumFileViewFragment.this.m14137A1(dVar);
            } else {
                if (dVar.f10867r.isPlaying()) {
                    C1120a.m6677i("AlbumFileViewFragment", "player pause");
                    AlbumFileViewFragment.this.f10785d0.removeMessages(123);
                    dVar.f10856g.setImageResource(R$drawable.ic_play_video_start);
                    dVar.f10867r.pause();
                    return;
                }
                if (!dVar.f10848F) {
                    C1120a.m6677i("AlbumFileViewFragment", "player not ready, wait");
                    return;
                }
                C1120a.m6677i("AlbumFileViewFragment", "player start");
                dVar.f10856g.setImageResource(R$drawable.ic_play_video_stop);
                dVar.f10867r.start();
            }
        }

        /* renamed from: u */
        public final void m14236u(d dVar) {
            C1120a.m6677i("AlbumFileViewFragment", "openVideoActivity");
            if (dVar.f10850a < 0 || dVar.f10850a >= AlbumFileViewFragment.this.f10798k.size()) {
                C1120a.m6677i("AlbumFileViewFragment", "openVideoActivity info.mPosition error");
                return;
            }
            MediaFileBean mediaFileBean = AlbumFileViewFragment.this.f10798k.get(dVar.f10850a);
            if (mediaFileBean != null) {
                C12515a.m75110o().m75175e(new C2263g(AlbumFileViewFragment.this.getActivity(), mediaFileBean, AlbumFileViewFragment.this.f10792h, null), false);
            }
        }

        /* renamed from: v */
        public final void m14237v() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(AlbumFileViewFragment.this.f10790g);
                AlbumFileViewFragment albumFileViewFragment = AlbumFileViewFragment.this;
                sb2.append(albumFileViewFragment.f10794i ? "share_home_picture" : albumFileViewFragment.f10796j ? "share_home_vedio" : "");
                sb2.append(AlbumFileViewFragment.this.f10788f);
                String string = sb2.toString();
                if (C1132m.m6921c().m6924d(string) != null) {
                    MediaFileBean mediaFileBeanM6925e = C1132m.m6921c().m6925e(string);
                    if (mediaFileBeanM6925e.m14308K() != this.f10834i.get(AlbumFileViewFragment.this.f10788f).m14308K()) {
                        AlbumFileViewFragment albumFileViewFragment2 = AlbumFileViewFragment.this;
                        albumFileViewFragment2.f10798k.set(albumFileViewFragment2.f10788f, mediaFileBeanM6925e);
                        this.f10834i.set(AlbumFileViewFragment.this.f10788f, mediaFileBeanM6925e);
                    }
                }
            } catch (Exception e10) {
                C1120a.m6676e("AlbumFileViewFragment", "refreshCurMediaFileBean error: " + e10.getMessage());
            }
        }

        /* renamed from: w */
        public final void m14238w(int i10) {
            C1120a.m6677i("AlbumFileViewFragment", "refreshCurrentFileDetailInfo");
            if (i10 != AlbumFileViewFragment.this.f10788f) {
                C1120a.m6676e("AlbumFileViewFragment", "refreshCurrentFileDetailInfo position != curIndex");
                return;
            }
            if (AlbumFileViewFragment.this.f10788f < 0 || this.f10834i.size() <= AlbumFileViewFragment.this.f10788f) {
                C1120a.m6676e("AlbumFileViewFragment", "refreshCurrentFileDetailInfo curIndex error, curIndex = " + AlbumFileViewFragment.this.f10788f + " size =  " + this.f10834i.size());
                return;
            }
            MediaFileBean mediaFileBean = this.f10834i.get(AlbumFileViewFragment.this.f10788f);
            if (mediaFileBean == null) {
                m14240y();
                C12515a.m75110o().m75175e(new f(AlbumFileViewFragment.this.f10788f), false);
                return;
            }
            String strM14355v = mediaFileBean.m14355v();
            String strM14197x0 = AlbumFileViewFragment.this.m14197x0(mediaFileBean.m14348q());
            if (TextUtils.isEmpty(strM14355v)) {
                mediaFileBean.m14353t0(C10159j.m63325a(C0213f.m1377a(), mediaFileBean.m14348q(), C11842p.m70828k()));
            }
            if (AlbumFileViewFragment.this.f10804q) {
                AlbumFileViewFragment.this.f10808u.setText(strM14197x0);
                AlbumFileViewFragment.this.f10809v.setText(mediaFileBean.m14355v());
                AlbumFileViewFragment.this.f10812y.setText(strM14197x0);
                AlbumFileViewFragment.this.f10809v.setVisibility(0);
                AlbumFileViewFragment.this.f10812y.setVisibility(0);
            } else {
                AlbumFileViewFragment.this.f10808u.setText(mediaFileBean.m14355v());
                AlbumFileViewFragment.this.f10802o.setChecked(mediaFileBean.m14311N());
                AlbumFileViewFragment.this.f10809v.setVisibility(8);
                AlbumFileViewFragment.this.f10812y.setVisibility(8);
            }
            if (!C1122c.m6823q1(mediaFileBean.m14352t())) {
                m14239x(mediaFileBean.m14344o(), mediaFileBean);
            } else {
                m14240y();
                C12515a.m75110o().m75175e(new e(mediaFileBean, mediaFileBean.m14342m()), false);
            }
            try {
                if (AlbumFileViewFragment.this.f10770S) {
                    LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    linkedHashMapM79497A.put("file_viewer_type_is_baby", String.valueOf(AlbumFileViewFragment.this.f10804q));
                    int iM14338j = mediaFileBean.m14338j();
                    linkedHashMapM79497A.put("file_viewer_container_is_vedio", String.valueOf(iM14338j == 3 || iM14338j == 5));
                    C13224c.m79487f1().m79594r0("SHOW_FILE_VIEWER", linkedHashMapM79497A);
                }
            } catch (Exception e10) {
                C1120a.m6676e("AlbumFileViewFragment", e10.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0101  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x00ad -> B:79:0x00c7). Please report as a decompilation issue!!! */
        /* renamed from: x */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m14239x(com.huawei.android.hicloud.drive.cloudphoto.model.Media r7, com.huawei.android.p069cg.bean.MediaFileBean r8) {
            /*
                Method dump skipped, instructions count: 347
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment.ViewOnClickListenerC2266j.m14239x(com.huawei.android.hicloud.drive.cloudphoto.model.Media, com.huawei.android.cg.bean.MediaFileBean):void");
        }

        /* renamed from: y */
        public final void m14240y() {
            AlbumFileViewFragment.this.f10811x.setText("");
            AlbumFileViewFragment.this.f10813z.setText("");
            AlbumFileViewFragment.this.f10752A.setText("");
            AlbumFileViewFragment.this.f10753B.setText("");
        }

        /* renamed from: z */
        public final Bitmap m14241z(Media media, MediaFileBean mediaFileBean, d dVar, Bitmap bitmap) {
            KvDatabaseWrapper kvDatabaseWrapperM72352f0;
            if (C1122c.m6805m(mediaFileBean.m14333g().toString())) {
                bitmap = C1122c.m6719N0(C12094g.m72412d().m72416c(mediaFileBean.m14333g().toString(), AlbumFileViewFragment.this.f10771T, AlbumFileViewFragment.this.f10772U), media.getRotation());
            }
            Bitmap bitmapM7184c = C1138s.m7181d().m7184c(media.getId());
            if (!TextUtils.isEmpty(media.getId()) && bitmapM7184c == null && (kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0()) != null) {
                bitmapM7184c = kvDatabaseWrapperM72352f0.m30071b(media.getId());
            }
            if (bitmapM7184c != null) {
                C1120a.m6677i("AlbumFileViewFragment", "setFileInfoContent pic have thumb cache");
                dVar.f10851b.setImageDrawable(new BitmapDrawable(AlbumFileViewFragment.this.getResources(), bitmapM7184c));
            }
            if (bitmap != null || dVar == null) {
                AlbumFileViewFragment.this.f10810w.setVisibility(8);
            } else {
                C12091d.m72280a0().m72300D(media, dVar.f10851b, dVar.f10850a);
            }
            dVar.f10863n = 4;
            return bitmap;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$k */
    public class C2267k extends BroadcastReceiver {
        public C2267k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ViewOnClickListenerC2266j.d dVarM14230o;
            if (intent == null) {
                C1120a.m6678w("AlbumFileViewFragment", "intent is null.");
                return;
            }
            String action = intent.getAction();
            C1120a.m6677i("AlbumFileViewFragment", "action: " + intent.getAction());
            if (!action.equals(Constants.VOLUME_CHANGED_ACTION) || (dVarM14230o = AlbumFileViewFragment.this.f10786e.m14230o(AlbumFileViewFragment.this.f10788f)) == null) {
                return;
            }
            try {
                int streamVolume = ((AudioManager) AlbumFileViewFragment.this.getActivity().getSystemService("audio")).getStreamVolume(3);
                C1120a.m6677i("AlbumFileViewFragment", "currentMusicVolume: " + streamVolume);
                if (streamVolume == 0) {
                    C1120a.m6677i("AlbumFileViewFragment", "player close voice");
                    dVarM14230o.f10846D = true;
                    dVarM14230o.f10860k.setImageResource(R$drawable.ic_play_video_close_voice);
                    dVarM14230o.f10867r.setVolume(0.0f);
                } else {
                    C1120a.m6677i("AlbumFileViewFragment", "player open voice");
                    dVarM14230o.f10846D = false;
                    dVarM14230o.f10860k.setImageResource(R$drawable.ic_play_video_open_voice);
                    dVarM14230o.f10867r.setVolume(1.0f);
                }
            } catch (Exception e10) {
                C1120a.m6676e("AlbumFileViewFragment", e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.fragment.AlbumFileViewFragment$l */
    public static class C2268l implements InitFactoryCallback {

        /* renamed from: a */
        public WeakReference<AlbumFileViewFragment> f10900a;

        public C2268l(AlbumFileViewFragment albumFileViewFragment) {
            this.f10900a = new WeakReference<>(albumFileViewFragment);
        }

        @Override // com.huawei.hms.videokit.player.InitFactoryCallback
        public void onFailure(int i10, String str) {
            C1120a.m6676e("AlbumFileViewFragment", "initPlayerFactory fail, errorCode: " + i10 + " reason: " + str);
            AlbumFileViewFragment albumFileViewFragment = this.f10900a.get();
            if (albumFileViewFragment == null) {
                return;
            }
            WiseFactoryManager.m14532i(false);
            albumFileViewFragment.f10785d0.sendEmptyMessage(128);
        }

        @Override // com.huawei.hms.videokit.player.InitFactoryCallback
        public void onSuccess(WisePlayerFactory wisePlayerFactory) {
            C1120a.m6677i("AlbumFileViewFragment", "playerFactory init success");
            AlbumFileViewFragment albumFileViewFragment = this.f10900a.get();
            if (albumFileViewFragment == null) {
                return;
            }
            albumFileViewFragment.f10779a0 = wisePlayerFactory;
            WiseFactoryManager.m14532i(true);
            WiseFactoryManager.m14530d(albumFileViewFragment.getActivity()).m14536j(albumFileViewFragment.f10779a0);
            albumFileViewFragment.f10785d0.sendEmptyMessage(128);
        }
    }

    /* renamed from: J0 */
    public static boolean m14077J0(int i10) {
        return 1002 == i10 || 1003 == i10 || 1004 == i10;
    }

    /* renamed from: K0 */
    public static boolean m14079K0(int i10) {
        return 1100 == i10 || 1101 == i10 || 1119 == i10 || 1120 == i10;
    }

    /* renamed from: L0 */
    public static boolean m14081L0(int i10) {
        return 1201 == i10 || 1202 == i10;
    }

    /* renamed from: R0 */
    public static /* synthetic */ boolean m14088R0(WisePlayer wisePlayer, int i10, int i11, Object obj) {
        C1120a.m6677i("AlbumFileViewFragment", "onEvent， msg.what is " + i10 + ", extra is " + i11 + ", msg.obj is " + obj);
        return false;
    }

    /* renamed from: V0 */
    public static /* synthetic */ void m14093V0(WisePlayer wisePlayer) {
        C1120a.m6677i("AlbumFileViewFragment", "onSeekEnd: " + wisePlayer.getCurrentTime());
    }

    /* renamed from: s0 */
    public static int m14127s0(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    /* renamed from: w0 */
    public static Message m14132w0(int i10, ViewOnClickListenerC2266j.d dVar, Handler handler) {
        Message messageObtain = Message.obtain(handler);
        messageObtain.what = i10;
        messageObtain.arg1 = dVar.f10850a;
        return messageObtain;
    }

    /* renamed from: A0 */
    public final void m14136A0(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        dVar.f10861l.setVisibility(8);
    }

    /* renamed from: A1 */
    public final void m14137A1(final ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "startPlayOnlineVideo");
        if (this.f10779a0 == null) {
            C1120a.m6676e("AlbumFileViewFragment", "playerFactory not ready now, error");
            WiseFactoryManager.m14532i(false);
            dVar.f10855f.setVisibility(8);
            if (dVar.f10845C) {
                dVar.f10852c.setVisibility(0);
            }
            dVar.f10861l.setVisibility(8);
            return;
        }
        dVar.f10851b.setVisibility(8);
        try {
            dVar.f10867r = this.f10779a0.createWisePlayer();
        } catch (CreateComponentException e10) {
            C1120a.m6677i("AlbumFileViewFragment", "createWisePlayer failed e " + e10);
        }
        if (dVar.f10867r == null) {
            C1120a.m6677i("AlbumFileViewFragment", "createWisePlayer failed, return");
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "set player property, res = " + dVar.f10867r.setProperties(1, Boolean.TRUE));
        dVar.f10867r.setErrorListener(new WisePlayer.ErrorListener() { // from class: l6.b
            @Override // com.huawei.hms.videokit.player.WisePlayer.ErrorListener
            public final boolean onError(WisePlayer wisePlayer, int i10, int i11) {
                return this.f52826a.m14155Q0(dVar, wisePlayer, i10, i11);
            }
        });
        dVar.f10867r.setEventListener(new WisePlayer.EventListener() { // from class: l6.c
            @Override // com.huawei.hms.videokit.player.WisePlayer.EventListener
            public final boolean onEvent(WisePlayer wisePlayer, int i10, int i11, Object obj) {
                return AlbumFileViewFragment.m14088R0(wisePlayer, i10, i11, obj);
            }
        });
        dVar.f10867r.setResolutionUpdatedListener(new WisePlayer.ResolutionUpdatedListener() { // from class: l6.d
            @Override // com.huawei.hms.videokit.player.WisePlayer.ResolutionUpdatedListener
            public final void onResolutionUpdated(WisePlayer wisePlayer, int i10, int i11) {
                this.f52828a.m14156S0(dVar, wisePlayer, i10, i11);
            }
        });
        dVar.f10867r.setReadyListener(new WisePlayer.ReadyListener() { // from class: l6.e
            @Override // com.huawei.hms.videokit.player.WisePlayer.ReadyListener
            public final void onReady(WisePlayer wisePlayer) {
                this.f52830a.m14157T0(dVar, wisePlayer);
            }
        });
        dVar.f10867r.setLoadingListener(new C2259c(dVar));
        dVar.f10867r.setPlayEndListener(new WisePlayer.PlayEndListener() { // from class: l6.f
            @Override // com.huawei.hms.videokit.player.WisePlayer.PlayEndListener
            public final void onPlayEnd(WisePlayer wisePlayer) {
                this.f52832a.m14158U0(dVar, wisePlayer);
            }
        });
        dVar.f10867r.setSeekEndListener(new WisePlayer.SeekEndListener() { // from class: l6.g
            @Override // com.huawei.hms.videokit.player.WisePlayer.SeekEndListener
            public final void onSeekEnd(WisePlayer wisePlayer) {
                AlbumFileViewFragment.m14093V0(wisePlayer);
            }
        });
        dVar.f10867r.setVideoType(0);
        dVar.f10867r.setCycleMode(0);
        dVar.f10867r.setVolume(0.0f);
        dVar.f10867r.setPlayUrl(dVar.f10865p);
        if (dVar.f10869t) {
            dVar.f10867r.setView(dVar.f10866q);
        } else {
            C1120a.m6677i("AlbumFileViewFragment", "mSurfaceView not ready now, wait");
        }
        dVar.f10867r.setBookmark(dVar.f10870u);
        dVar.f10867r.ready();
    }

    /* renamed from: B0 */
    public void mo14138B0() {
        SafeIntent safeIntent = new SafeIntent(getActivity().getIntent());
        this.f10790g = safeIntent.getStringExtra("param_album_id");
        this.f10798k = new ArrayList();
        this.f10792h = safeIntent.getBooleanExtra("param_is_from_picker", false);
        C1120a.m6677i("AlbumFileViewFragment", "getAlbumFiles start");
        List<MediaFileBean> listM6736T = C1122c.m6736T(this.f10790g);
        C1120a.m6677i("AlbumFileViewFragment", "getAlbumFiles end");
        if (listM6736T == null || listM6736T.isEmpty()) {
            MediaFileBean mediaFileBean = new MediaFileBean();
            mediaFileBean.m14318U("");
            ArrayList arrayList = new ArrayList();
            this.f10798k = arrayList;
            arrayList.add(mediaFileBean);
        } else {
            this.f10798k.addAll(listM6736T);
        }
        C1120a.m6677i("AlbumFileViewFragment", "addAll end");
        m14142D0();
    }

    /* renamed from: B1 */
    public final void m14139B1(MediaFileBean mediaFileBean) {
        C1120a.m6677i("AlbumFileViewFragment", "start startShareCurrentFile");
        Activity activity = getActivity();
        if (activity == null) {
            C1120a.m6676e("AlbumFileViewFragment", "startShareCurrentFile activity is null");
        } else if (mediaFileBean != null) {
            C12515a.m75110o().m75175e(new C2265i(activity, mediaFileBean), false);
        }
    }

    /* renamed from: C0 */
    public final void m14140C0() {
        Resources resources = getActivity().getResources();
        int iM70758Q = C11842p.m70758Q(getActivity());
        ViewGroup.LayoutParams layoutParams = this.f10759H.getLayoutParams();
        layoutParams.width = iM70758Q;
        if (resources.getConfiguration().orientation == 2) {
            int i10 = (int) (resources.getDisplayMetrics().heightPixels * 0.8d);
            if (layoutParams.height > i10) {
                layoutParams.height = i10;
            }
        } else {
            layoutParams.height = -2;
        }
        this.f10759H.setLayoutParams(layoutParams);
    }

    /* renamed from: C1 */
    public final void m14141C1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "startVideoWhenClickMiddleStartButton");
        dVar.f10868s.setVisibility(0);
        dVar.f10852c.setVisibility(8);
        dVar.f10861l.setVisibility(0);
        dVar.f10855f.setVisibility(0);
        if (dVar.f10867r == null) {
            C1120a.m6677i("AlbumFileViewFragment", "player not ready");
            dVar.f10875z = true;
            m14137A1(dVar);
        } else {
            if (dVar.f10869t) {
                if (dVar.f10867r.isPlaying()) {
                    C1120a.m6677i("AlbumFileViewFragment", "player pause");
                    return;
                } else {
                    C1120a.m6677i("AlbumFileViewFragment", "player start");
                    dVar.f10867r.start();
                    return;
                }
            }
            C1120a.m6677i("AlbumFileViewFragment", "player ready, SurfaceView not ready");
            dVar.f10867r.release();
            dVar.f10867r = null;
            dVar.f10875z = true;
            m14137A1(dVar);
        }
    }

    /* renamed from: D0 */
    public final void m14142D0() {
        if (this.f10792h) {
            this.f10754C.setVisibility(8);
            this.f10802o.setVisibility(0);
            this.f10803p.setVisibility(0);
            this.f10803p.setOnClickListener(new View.OnClickListener() { // from class: l6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f52825a.m14154P0(view);
                }
            });
        }
    }

    /* renamed from: D1 */
    public final void m14143D1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.f10867r != null && dVar.f10867r.isPlaying()) {
            dVar.f10856g.setImageResource(R$drawable.ic_play_video_stop);
        }
        m14136A0(dVar);
    }

    /* renamed from: E0 */
    public final void m14144E0(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "initPlayView");
        dVar.f10851b.setVisibility(8);
        dVar.f10861l.setVisibility(8);
        int duration = dVar.f10867r.getDuration();
        C1120a.m6677i("AlbumFileViewFragment", "totalTime: " + duration);
        dVar.f10859j.setMax(duration);
        dVar.f10858i.setText(C1122c.m6715M(duration));
        if (!this.f10776Y) {
            dVar.f10857h.setText(C1122c.m6715M(0));
            dVar.f10859j.setProgress(0);
            dVar.f10859j.setSecondaryProgress(0);
        } else {
            dVar.f10859j.setProgress(dVar.f10870u);
            dVar.f10859j.setSecondaryProgress(dVar.f10870u);
            dVar.f10857h.setText(C1122c.m6715M(dVar.f10870u));
            this.f10776Y = false;
        }
    }

    /* renamed from: E1 */
    public final void m14145E1(ViewOnClickListenerC2266j.d dVar) {
        int currentTime;
        int bufferTime;
        if (dVar == null) {
            return;
        }
        m14143D1(dVar);
        if (dVar.f10867r != null) {
            currentTime = dVar.f10867r.getCurrentTime();
            bufferTime = dVar.f10867r.getBufferTime();
        } else {
            currentTime = 0;
            bufferTime = 0;
        }
        if (!this.f10776Y) {
            dVar.f10859j.setProgress(currentTime);
            dVar.f10859j.setSecondaryProgress(bufferTime);
            dVar.f10857h.setText(C1122c.m6715M(currentTime));
        } else {
            dVar.f10859j.setProgress(dVar.f10870u);
            dVar.f10859j.setSecondaryProgress(dVar.f10870u);
            dVar.f10857h.setText(C1122c.m6715M(dVar.f10870u));
            this.f10776Y = false;
        }
    }

    /* renamed from: F0 */
    public final void m14146F0() {
        if (WiseFactoryManager.m14529c()) {
            WisePlayerFactory wisePlayerFactoryM14533e = WiseFactoryManager.m14530d(getActivity()).m14533e();
            this.f10779a0 = wisePlayerFactoryM14533e;
            if (wisePlayerFactoryM14533e != null) {
                C1120a.m6677i("AlbumFileViewFragment", "playerFactory already init success");
                return;
            }
            C1120a.m6676e("AlbumFileViewFragment", "playerFactory default init error, init again");
        }
        String strM80954p = C13452e.m80781L().m80954p();
        WisePlayerFactory.initFactory(getActivity(), new WisePlayerFactoryOptionsExt.Builder().setDeviceId(strM80954p).setServeCountry(C13452e.m80781L().m80942m()).build(), new C2268l(this));
    }

    /* renamed from: F1 */
    public final void m14147F1(int i10) {
        C1120a.m6677i("AlbumFileViewFragment", "userAgreeDownloadWithMobileData");
        MediaFileBean mediaFileBeanM14187r0 = m14187r0();
        if (i10 == 1) {
            ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
            if (viewOnClickListenerC2266j == null) {
                return;
            }
            m14141C1(viewOnClickListenerC2266j.m14232q(this.f10788f));
            return;
        }
        if (i10 == 2) {
            m14160X0(mediaFileBeanM14187r0);
        } else {
            if (i10 != 3) {
                return;
            }
            m14198x1(mediaFileBeanM14187r0);
        }
    }

    /* renamed from: G0 */
    public final void m14148G0() {
        this.f10768Q = new AlbumFileViewerReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.checkLCDDownloaded");
        intentFilter.addAction("com.huawei.hicloud.checkVedioButton");
        C13108a c13108aM78878b = C13108a.m78878b(getActivity());
        if (c13108aM78878b != null) {
            c13108aM78878b.m78880c(this.f10768Q, intentFilter);
        }
    }

    /* renamed from: H0 */
    public final void m14149H0(View view) throws Resources.NotFoundException {
        this.f10780b = C12809f.m76831d(view, R$id.actionbar_top);
        this.f10782c = C12809f.m76831d(view, R$id.detail_bottom);
        ViewPager viewPager = (ViewPager) C12809f.m76831d(view, R$id.file_view_pager);
        this.f10784d = viewPager;
        viewPager.setOffscreenPageLimit(3);
        this.f10806s = C12809f.m76831d(view, R$id.actionbar_lv);
        this.f10807t = (ImageView) C12809f.m76831d(view, R$id.close_button);
        this.f10808u = (TextView) C12809f.m76831d(view, R$id.thumbs_title);
        this.f10809v = (TextView) C12809f.m76831d(view, R$id.thumbs_sub_title);
        this.f10810w = (HwProgressBar) C12809f.m76831d(view, R$id.default_loading_progressbar);
        this.f10811x = (TextView) C12809f.m76831d(view, R$id.detail_info_time_title);
        this.f10812y = (TextView) C12809f.m76831d(view, R$id.detail_info_time_subtitle);
        this.f10813z = (TextView) C12809f.m76831d(view, R$id.detail_info_pic_name);
        this.f10752A = (TextView) C12809f.m76831d(view, R$id.detail_info_pic_sub_info);
        this.f10753B = (TextView) C12809f.m76831d(view, R$id.detail_info_owner_name);
        this.f10754C = (LinearLayout) C12809f.m76831d(view, R$id.menu_lv);
        this.f10755D = (LinearLayout) C12809f.m76831d(view, R$id.share_menu_ll);
        this.f10756E = (LinearLayout) C12809f.m76831d(view, R$id.download_menu_ll);
        this.f10757F = (LinearLayout) C12809f.m76831d(view, R$id.more_menu_ll);
        this.f10758G = (LinearLayout) C12809f.m76831d(view, R$id.delete_menu_ll);
        this.f10761J = (ImageView) C12809f.m76831d(view, R$id.share_button);
        this.f10762K = (ImageView) C12809f.m76831d(view, R$id.download_button);
        this.f10763L = (ImageView) C12809f.m76831d(view, R$id.more_button);
        this.f10764M = (ImageView) C12809f.m76831d(view, R$id.delete_menu_button);
        this.f10759H = (LinearLayout) C12809f.m76831d(view, R$id.detail_lv);
        this.f10760I = C12809f.m76831d(view, R$id.view_detail_mask);
        this.f10766O = (LinearLayout) C12809f.m76831d(view, R$id.appeal_button_lv);
        this.f10765N = (LinearLayout) C12809f.m76831d(view, R$id.delete_button_lv);
        this.f10767P = (LinearLayout) C12809f.m76831d(view, R$id.report_button_lv);
        this.f10799l = (LinearLayout) C12809f.m76831d(view, R$id.detail_button_lv);
        this.f10800m = C12809f.m76831d(view, R$id.line2);
        this.f10801n = (RelativeLayout) C12809f.m76831d(view, R$id.detail_info_owner_rl);
        this.f10802o = (CheckBox) C12809f.m76831d(view, R$id.chk_img);
        this.f10803p = C12809f.m76831d(view, R$id.v_check);
        this.f10807t.setOnClickListener(this);
        this.f10761J.setOnClickListener(this);
        this.f10762K.setOnClickListener(this);
        this.f10764M.setOnClickListener(this);
        this.f10763L.setOnClickListener(this);
        this.f10766O.setOnClickListener(this);
        this.f10765N.setOnClickListener(this);
        this.f10767P.setOnClickListener(this);
    }

    /* renamed from: I0 */
    public void m14150I0(boolean z10) throws Resources.NotFoundException {
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = new ViewOnClickListenerC2266j(this.f10798k);
        this.f10786e = viewOnClickListenerC2266j;
        viewOnClickListenerC2266j.notifyDataSetChanged();
        SafeIntent safeIntent = new SafeIntent(getActivity().getIntent());
        boolean booleanExtra = safeIntent.getBooleanExtra("param_is_share_cloud_album", true);
        this.f10770S = booleanExtra;
        if (booleanExtra) {
            this.f10755D.setVisibility(8);
        } else {
            this.f10755D.setVisibility(0);
        }
        int intExtra = safeIntent.getIntExtra("param_media_index", 0);
        if (intExtra != -1) {
            if (z10) {
                this.f10788f = intExtra;
                if (this.f10798k.size() == 1) {
                    this.f10788f = 0;
                }
            }
            this.f10784d.setCurrentItem(this.f10788f);
            this.f10786e.m14238w(this.f10788f);
        }
    }

    /* renamed from: M0 */
    public final boolean m14151M0(Media media) {
        C1120a.m6677i("AlbumFileViewFragment", "start isMediaIllegal");
        int scaRank = media.getScaRank();
        C1120a.m6675d("AlbumFileViewFragment", "isMediaIllegal scaRank " + scaRank);
        return (scaRank == 1 || scaRank == 0) ? false : true;
    }

    /* renamed from: N0 */
    public final boolean m14152N0(Media media) {
        C1120a.m6677i("AlbumFileViewFragment", "start isMediaProcessing");
        int scaState = media.getScaState();
        C1120a.m6675d("AlbumFileViewFragment", "isMediaProcessing scaState " + scaState);
        return (scaState == 2 || scaState == 1) ? false : true;
    }

    /* renamed from: O0 */
    public final boolean m14153O0(MediaFileBean mediaFileBean) {
        try {
            boolean zEquals = mediaFileBean.m14344o().getMediaOwnerId().equals(this.f10797j0);
            C1120a.m6675d("AlbumFileViewFragment", "isAlbumCreatedByNowUser " + zEquals);
            if (zEquals) {
                return true;
            }
            List<Permission> permissions = new C12941a().m77726A(this.f10790g, false).getPermissions();
            if (permissions != null && permissions.size() != 0) {
                String privilege = HNConstants.DataType.f22634NA;
                for (Permission permission : permissions) {
                    if (this.f10797j0.equals(permission.getUserId())) {
                        privilege = permission.getPrivilege();
                    }
                }
                boolean zContains = privilege.contains("download");
                C1120a.m6675d("AlbumFileViewFragment", "haveDownloadPermission " + zContains);
                return zContains;
            }
            C1120a.m6676e("AlbumFileViewFragment", "permissions is null");
            return false;
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "e " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: P0 */
    public final /* synthetic */ void m14154P0(View view) {
        MediaFileBean mediaFileBeanM14187r0 = m14187r0();
        C1133n c1133nM6927e = C1133n.m6927e();
        C1133n.c cVarM6933g = c1133nM6927e.m6933g(this.f10790g);
        if (mediaFileBeanM14187r0 == null || cVarM6933g == null) {
            return;
        }
        if (mediaFileBeanM14187r0.m14311N()) {
            c1133nM6927e.m6936j(this.f10790g, mediaFileBeanM14187r0);
            mediaFileBeanM14187r0.m14313P(false);
            this.f10802o.setChecked(false);
            return;
        }
        int iM6929b = c1133nM6927e.m6929b(this.f10790g, mediaFileBeanM14187r0, cVarM6933g);
        if (iM6929b == 0) {
            mediaFileBeanM14187r0.m14313P(true);
            this.f10802o.setChecked(true);
        } else {
            String strM6932f = c1133nM6927e.m6932f(getActivity(), iM6929b, cVarM6933g);
            if (!TextUtils.isEmpty(strM6932f)) {
                C11841o.m70706b(getActivity(), strM6932f, 0);
            }
            this.f10802o.setChecked(false);
        }
    }

    /* renamed from: Q0 */
    public final /* synthetic */ boolean m14155Q0(ViewOnClickListenerC2266j.d dVar, WisePlayer wisePlayer, int i10, int i11) {
        C1120a.m6677i("AlbumFileViewFragment", "play error, errorCode = " + i10 + ", second errorCode is " + i11);
        Message messageM14194v0 = m14194v0(125, dVar);
        messageM14194v0.obj = Integer.valueOf(i10);
        messageM14194v0.arg2 = i11;
        this.f10785d0.sendMessage(messageM14194v0);
        return false;
    }

    /* renamed from: S0 */
    public final /* synthetic */ void m14156S0(ViewOnClickListenerC2266j.d dVar, WisePlayer wisePlayer, int i10, int i11) {
        C1120a.m6677i("AlbumFileViewFragment", "onResolutionUpdated, width: " + i10 + ", height: " + i11);
        dVar.f10872w = i11;
        dVar.f10873x = i10;
        m14186q1(dVar);
    }

    /* renamed from: T0 */
    public final /* synthetic */ void m14157T0(ViewOnClickListenerC2266j.d dVar, WisePlayer wisePlayer) {
        C1120a.m6677i("AlbumFileViewFragment", "onReady");
        Message message = new Message();
        message.what = 124;
        message.arg1 = dVar.f10850a;
        this.f10785d0.sendMessage(message);
    }

    /* renamed from: U0 */
    public final /* synthetic */ void m14158U0(ViewOnClickListenerC2266j.d dVar, WisePlayer wisePlayer) {
        C1120a.m6677i("AlbumFileViewFragment", "onPlayEnd");
        this.f10785d0.sendMessage(m14194v0(126, dVar));
    }

    /* renamed from: W0 */
    public final void m14159W0() {
        Activity activity;
        if (this.f10780b == null || this.f10782c == null || (activity = getActivity()) == null) {
            return;
        }
        int iM70789a0 = C11842p.m70789a0(activity);
        ViewGroup.LayoutParams layoutParams = this.f10780b.getLayoutParams();
        layoutParams.height = iM70789a0;
        this.f10780b.setLayoutParams(layoutParams);
        int iM76835h = C1122c.m6834t1(activity) ? C12809f.m76835h(activity) : 0;
        ViewGroup.LayoutParams layoutParams2 = this.f10782c.getLayoutParams();
        layoutParams2.height = iM76835h;
        this.f10782c.setLayoutParams(layoutParams2);
    }

    /* renamed from: X0 */
    public final void m14160X0(MediaFileBean mediaFileBean) {
        C1120a.m6677i("AlbumFileViewFragment", "start multipleFileDownload");
        C12097j.m72480b().m72486g(getActivity());
        C12096i.m72418I().m72433B(mediaFileBean.m14344o());
    }

    /* renamed from: Y0 */
    public final void m14161Y0() {
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null) {
            C1120a.m6676e("AlbumFileViewFragment", "click report mTabsAdapter is null");
            return;
        }
        List<MediaFileBean> list = viewOnClickListenerC2266j.f10834i;
        if (list == null) {
            C1120a.m6676e("AlbumFileViewFragment", "click report mTabsAdapter.mFiles is null");
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        MediaFileBean mediaFileBeanM14233r = this.f10786e.m14233r(this.f10788f);
        if (mediaFileBeanM14233r == null) {
            C1120a.m6676e("AlbumFileViewFragment", "click report mediaFileBean is null");
            return;
        }
        Media mediaM14344o = mediaFileBeanM14233r.m14344o();
        Activity activity = getActivity();
        if (activity == null) {
            C1120a.m6676e("AlbumFileViewFragment", "appeal_button_lv activity is null ");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, AppealMainActivity.class);
        intent.putExtra("appeal_type", CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        intent.putExtra("fileId", mediaM14344o.getId());
        intent.putExtra("ownerId", mediaM14344o.getMediaOwnerId());
        C0224k0.m1542L(activity, intent);
    }

    /* renamed from: Z0 */
    public void m14162Z0(View view) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.more_button) {
            if (this.f10774W) {
                return;
            }
            m14202z1();
            this.f10760I.setVisibility(0);
            this.f10806s.setVisibility(8);
            this.f10774W = true;
            return;
        }
        if (id2 == R$id.close_button) {
            getActivity().onBackPressed();
            return;
        }
        if (id2 == R$id.delete_button_lv || id2 == R$id.delete_menu_button) {
            m14163a1();
        } else if (id2 == R$id.report_button_lv) {
            m14166d1();
        } else if (id2 == R$id.appeal_button_lv) {
            m14161Y0();
        }
    }

    /* renamed from: a1 */
    public final void m14163a1() {
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null || viewOnClickListenerC2266j.f10834i == null) {
            return;
        }
        DialogInterfaceOnClickListenerC11644i dialogInterfaceOnClickListenerC11644i = new DialogInterfaceOnClickListenerC11644i(getActivity(), this.f10793h0);
        this.f10795i0 = dialogInterfaceOnClickListenerC11644i;
        dialogInterfaceOnClickListenerC11644i.show();
        this.f10795i0.getButton(-1).setTextColor(-65536);
    }

    /* renamed from: b1 */
    public final void m14164b1(boolean z10) {
        MediaFileBean mediaFileBeanM14187r0;
        Media mediaM14344o;
        if (this.f10770S) {
            C13224c.m79487f1().m79593q0("CLICK_FILE_VIEWER_DOWNLOAD");
        }
        ViewOnClickListenerC2266j.d dVarM14230o = this.f10786e.m14230o(this.f10788f);
        if (dVarM14230o == null || (mediaFileBeanM14187r0 = m14187r0()) == null || (mediaM14344o = mediaFileBeanM14187r0.m14344o()) == null) {
            return;
        }
        if (dVarM14230o.f10843A) {
            C12097j.m72480b().m72488i(getActivity());
            return;
        }
        if (!m14153O0(mediaFileBeanM14187r0)) {
            C11841o.m70706b(getActivity(), getString(R$string.member_no_download_permission), 0);
            return;
        }
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C12097j.m72480b().m72490k(getActivity());
        } else if (z10) {
            m14160X0(mediaFileBeanM14187r0);
        } else {
            m14185q0(mediaM14344o, mediaFileBeanM14187r0);
        }
    }

    /* renamed from: c1 */
    public final void m14165c1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "onPlayEnd");
        this.f10785d0.removeMessages(123);
        dVar.f10856g.setImageResource(R$drawable.ic_play_video_start);
        dVar.f10859j.setProgress(0);
        dVar.f10859j.setSecondaryProgress(0);
    }

    /* renamed from: d1 */
    public final void m14166d1() {
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null) {
            C1120a.m6676e("AlbumFileViewFragment", "click report mTabsAdapter is null");
            return;
        }
        List<MediaFileBean> list = viewOnClickListenerC2266j.f10834i;
        if (list == null) {
            C1120a.m6676e("AlbumFileViewFragment", "click report mTabsAdapter.mFiles is null");
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        MediaFileBean mediaFileBeanM14233r = this.f10786e.m14233r(this.f10788f);
        if (mediaFileBeanM14233r == null) {
            C1120a.m6676e("AlbumFileViewFragment", "click report mediaFileBean is null");
            return;
        }
        Media mediaM14344o = mediaFileBeanM14233r.m14344o();
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.setClass(activity, AlbumReportActivity.class);
        intent.putExtra("fileId", mediaM14344o.getId());
        intent.putExtra("ownerId", mediaM14344o.getMediaOwnerId());
        startActivity(intent);
    }

    /* renamed from: e1 */
    public final void m14167e1(boolean z10) {
        MediaFileBean mediaFileBeanM14187r0;
        Media mediaM14344o;
        ViewOnClickListenerC2266j.d dVarM14230o = this.f10786e.m14230o(this.f10788f);
        if (dVarM14230o == null || (mediaFileBeanM14187r0 = m14187r0()) == null || (mediaM14344o = mediaFileBeanM14187r0.m14344o()) == null) {
            return;
        }
        if (dVarM14230o.f10843A) {
            m14139B1(m14187r0());
            return;
        }
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C12097j.m72480b().m72490k(getActivity());
        } else if (z10) {
            m14198x1(mediaFileBeanM14187r0);
        } else {
            m14188r1(mediaFileBeanM14187r0, mediaM14344o);
        }
    }

    /* renamed from: f1 */
    public final void m14168f1() {
        try {
            if (this.f10770S) {
                this.f10755D.setVisibility(8);
            } else {
                this.f10755D.setVisibility(0);
            }
            this.f10756E.setVisibility(0);
            this.f10757F.setVisibility(0);
            this.f10758G.setVisibility(8);
            this.f10761J.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_share_button));
            this.f10762K.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_download_button_disable));
            this.f10763L.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_more_button_disable));
            this.f10761J.setClickable(true);
            this.f10762K.setClickable(false);
            this.f10763L.setClickable(false);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "onlyShareCilckable error=" + e10.toString());
        }
    }

    /* renamed from: g1 */
    public final void m14169g1() {
        try {
            this.f10755D.setVisibility(8);
            this.f10756E.setVisibility(8);
            this.f10757F.setVisibility(8);
            this.f10758G.setVisibility(0);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "onlyShowDeleteMenuButton error=" + e10.toString());
        }
    }

    /* renamed from: h1 */
    public final void m14170h1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "processLoadingEnd");
        m14143D1(dVar);
        this.f10785d0.removeMessages(123);
        this.f10785d0.sendMessageDelayed(m14194v0(123, dVar), 500L);
    }

    /* renamed from: i1 */
    public final void m14171i1(ViewOnClickListenerC2266j.d dVar, Message message) {
        C1120a.m6677i("AlbumFileViewFragment", "processPlayError");
        dVar.f10856g.setImageResource(R$drawable.ic_play_video_start);
        this.f10785d0.removeMessages(123);
        m14136A0(dVar);
        int iIntValue = ((Integer) message.obj).intValue();
        C1120a.m6676e("AlbumFileViewFragment", "processPlayError, errorCode is: " + iIntValue);
        m14189s1(getActivity(), iIntValue);
        m14180n1(dVar);
    }

    /* renamed from: j1 */
    public final ArrayList<Media> m14172j1(int i10) {
        String str = this.f10790g;
        if (str == null || str.isEmpty()) {
            return this.f10769R.m77795H(i10, 1L);
        }
        String str2 = this.f10790g;
        str2.hashCode();
        switch (str2) {
            case "album_id_collection":
                return this.f10769R.m77794G(i10, 1L);
            case "album_id_screenshot":
                return this.f10769R.m77798K("default-album-2", i10, 1L);
            case "album_id_camera":
                return this.f10769R.m77798K("default-album-1", i10, 1L);
            case "album_id_video":
                return this.f10769R.m77797J(i10, 1L);
            default:
                return this.f10769R.m77798K(this.f10790g, i10, 1L);
        }
    }

    /* renamed from: k0 */
    public final void m14173k0() {
        try {
            if (this.f10770S) {
                this.f10755D.setVisibility(8);
            } else {
                this.f10755D.setVisibility(0);
            }
            this.f10756E.setVisibility(0);
            this.f10757F.setVisibility(0);
            this.f10758G.setVisibility(8);
            this.f10761J.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_share_button_disable));
            this.f10762K.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_download_button_disable));
            this.f10763L.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_more_button_disable));
            this.f10761J.setClickable(false);
            this.f10762K.setClickable(false);
            this.f10763L.setClickable(false);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "allUnClickable error=" + e10.toString());
        }
    }

    /* renamed from: k1 */
    public final void m14174k1() {
        Activity activity;
        if (this.f10780b == null || this.f10782c == null || (activity = getActivity()) == null) {
            return;
        }
        if (C12806c.m76816g(activity) && C1122c.m6840v1(activity)) {
            this.f10780b.setVisibility(0);
        } else {
            this.f10780b.setVisibility(8);
        }
        if (!C1122c.m6834t1(activity) || C11842p.m70753O0(activity)) {
            this.f10782c.setVisibility(8);
        } else {
            this.f10782c.setVisibility(0);
        }
        m14184p1(activity);
    }

    /* renamed from: l0 */
    public final void m14175l0(Media media) {
        C1120a.m6677i("AlbumFileViewFragment", "checkAndChangeDetailMenu start");
        try {
            if (this.f10770S) {
                boolean zEquals = media.getMediaOwnerId().equals(this.f10797j0);
                if (media.getCreator().getUserId().equals(this.f10797j0)) {
                    this.f10765N.setVisibility(0);
                    this.f10767P.setVisibility(8);
                } else if (zEquals) {
                    this.f10765N.setVisibility(0);
                    this.f10767P.setVisibility(0);
                } else {
                    this.f10765N.setVisibility(8);
                    this.f10767P.setVisibility(0);
                }
            } else {
                this.f10799l.setVisibility(8);
                this.f10800m.setVisibility(8);
                this.f10801n.setVisibility(8);
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "checkAndChangeDetailMenu error=" + e10.toString());
        }
    }

    /* renamed from: l1 */
    public void m14176l1() {
        if (this.f10789f0 == null) {
            this.f10789f0 = new NetWorkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getActivity().registerReceiver(this.f10789f0, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: m0 */
    public final void m14177m0(MediaFileBean mediaFileBean, Media media) {
        C1120a.m6677i("AlbumFileViewFragment", "checkAndChangeMenuButton start");
        try {
            m14181o0();
            boolean zEquals = media.containsKey("creator") ? media.getCreator().getUserId().equals(this.f10797j0) : true;
            int iM14308K = mediaFileBean.m14308K();
            C1120a.m6677i("AlbumFileViewFragment", "checkAndChangeMenuButton fileCheckType=" + iM14308K);
            if (zEquals) {
                m14199y0(media, iM14308K);
                return;
            }
            if (media.getMediaOwnerId().equals(this.f10797j0)) {
                boolean zM14152N0 = m14152N0(media);
                boolean zM14151M0 = m14151M0(media);
                if (iM14308K != 6) {
                    return;
                }
                if (zM14152N0) {
                    m14173k0();
                } else if (zM14151M0) {
                    m14169g1();
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "checkAndChangeMenuButton error=" + e10.toString());
        }
    }

    /* renamed from: m1 */
    public void m14178m1() {
        if (this.f10791g0 == null) {
            this.f10791g0 = new C2267k();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constants.VOLUME_CHANGED_ACTION);
            getActivity().registerReceiver(this.f10791g0, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: n0 */
    public final void m14179n0() {
        C1120a.m6677i("AlbumFileViewFragment", "clickCancelWhenDownload");
        C1120a.m6677i("AlbumFileViewFragment", C1122c.m6818p0(m14187r0().m14331f()));
        C12096i.m72418I().m72468r();
    }

    /* renamed from: n1 */
    public void m14180n1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "releasePlayer");
        if (dVar.f10867r != null) {
            C1120a.m6677i("AlbumFileViewFragment", "releasePlayer");
            dVar.f10867r.stop();
            dVar.f10867r.release();
            dVar.f10867r = null;
        }
        Handler handler = this.f10785d0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: o0 */
    public final void m14181o0() {
        try {
            if (this.f10770S) {
                this.f10755D.setVisibility(8);
            } else {
                this.f10755D.setVisibility(0);
            }
            this.f10756E.setVisibility(0);
            this.f10757F.setVisibility(0);
            this.f10758G.setVisibility(8);
            this.f10766O.setVisibility(8);
            this.f10761J.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_share_button));
            this.f10762K.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_download_button));
            this.f10763L.setImageDrawable(getActivity().getDrawable(R$drawable.album_media_viewer_more_button));
            this.f10761J.setClickable(true);
            this.f10762K.setClickable(true);
            this.f10763L.setClickable(true);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "defaultClickMenuShow error=" + e10.toString());
        }
    }

    /* renamed from: o1 */
    public final void m14182o1(Media media) {
        C1120a.m6677i("AlbumFileViewFragment", "sendDeleteCloudFileMessage");
        ArrayList arrayList = new ArrayList();
        arrayList.add(media);
        C12515a.m75110o().m75175e(new C2264h(arrayList), false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (C0209d.m1226Y0()) {
            C1120a.m6678w("AlbumFileViewFragment", "do not fast click");
            return;
        }
        boolean z10 = C1123d.m6855a(getActivity()) == 4;
        C1120a.m6677i("AlbumFileViewFragment", "isWifi: " + z10);
        if (id2 == R$id.share_button) {
            m14167e1(z10);
        } else if (id2 == R$id.download_button) {
            m14164b1(z10);
        } else {
            m14162Z0(view);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            C1120a.m6677i("AlbumFileViewFragment", "onConfigurationChanged start");
            super.onConfigurationChanged(configuration);
            if (isVisible()) {
                C1120a.m6677i("AlbumFileViewFragment", "isVisible()");
                this.f10786e.m14228m();
            }
            m14140C0();
            m14174k1();
            C1120a.m6677i("AlbumFileViewFragment", "onConfigurationChanged end");
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", e10.getMessage());
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m14146F0();
        m14148G0();
        this.f10771T = C11842p.m70749N(getActivity());
        this.f10772U = C11842p.m70746M(getActivity());
        ActionBar actionBar = getActivity().getActionBar();
        this.f10773V = actionBar;
        actionBar.hide();
        C12096i.m72418I().m72455Y(this.f10793h0);
        this.f10797j0 = C13452e.m80781L().m80971t0();
        m14178m1();
        m14176l1();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_album_thumbs_detail, viewGroup, false);
        this.f10778a = viewInflate;
        m14149H0(viewInflate);
        m14159W0();
        m14174k1();
        SafeIntent safeIntent = new SafeIntent(getActivity().getIntent());
        this.f10804q = safeIntent.getBooleanExtra("param_is_baby_mode", false);
        this.f10805r = safeIntent.getLongExtra("param_is_baby_birthday_mills", 0L);
        mo14138B0();
        m14150I0(true);
        m14140C0();
        return this.f10778a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f10792h) {
            C1122c.m6723O1(this.f10790g);
        }
        C12096i.m72418I().m72461f0(this.f10793h0);
        C13108a.m78878b(getActivity()).m78883f(this.f10768Q);
        if (this.f10789f0 != null) {
            getActivity().unregisterReceiver(this.f10789f0);
            this.f10789f0 = null;
        }
        if (this.f10791g0 != null) {
            getActivity().unregisterReceiver(this.f10791g0);
            this.f10791g0 = null;
        }
        getActivity().finish();
    }

    @Override // android.app.Fragment
    public void onPause() {
        this.f10781b0 = true;
        if (this.f10776Y) {
            this.f10776Y = false;
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10777Z) {
            this.f10777Z = false;
        } else {
            this.f10776Y = true;
        }
    }

    /* renamed from: p0 */
    public final void m14183p0() {
        if (this.f10770S) {
            C13224c.m79487f1().m79593q0("CLICK_FILE_VIEWER_DELETE");
        }
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null) {
            C1120a.m6676e("AlbumFileViewFragment", "deleteCurrentMedia mTabsAdapter is null");
            return;
        }
        List<MediaFileBean> list = viewOnClickListenerC2266j.f10834i;
        if (list == null) {
            C1120a.m6676e("AlbumFileViewFragment", "deleteCurrentMedia mTabsAdapter.mFiles is null");
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        MediaFileBean mediaFileBeanM14233r = this.f10786e.m14233r(this.f10788f);
        if (mediaFileBeanM14233r == null) {
            C1120a.m6676e("AlbumFileViewFragment", "deleteCurrentMedia mediaFileBean is null");
            return;
        }
        m14182o1(mediaFileBeanM14233r.m14344o());
        getActivity().setResult(305);
        this.f10786e.destroyItem((ViewGroup) this.f10784d, this.f10788f, this.f10786e.m14231p(mediaFileBeanM14233r));
        try {
            this.f10786e.f10834i.remove(this.f10788f);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "mFiles.remove error: " + e10.toString());
        }
        this.f10786e.notifyDataSetChanged();
    }

    /* renamed from: p1 */
    public final void m14184p1(Activity activity) {
        ViewOnClickListenerC2266j.d dVarM14232q;
        int[] iArrM76812c;
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null || (dVarM14232q = viewOnClickListenerC2266j.m14232q(this.f10788f)) == null) {
            return;
        }
        if (!C11842p.m70753O0(activity) || C0209d.m1170F1() || C11842p.m70747M0(activity)) {
            if (dVarM14232q.f10855f.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dVarM14232q.f10855f.getLayoutParams();
                layoutParams.setMarginEnd((int) C11842p.m70844o(activity, 16));
                dVarM14232q.f10855f.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        int iM76835h = (!C12806c.m76816g(activity) || m14127s0(activity) != 3 || (iArrM76812c = C12806c.m76812c(activity)) == null || iArrM76812c.length <= 1) ? 0 : iArrM76812c[1];
        if (C1122c.m6834t1(activity)) {
            iM76835h += C12809f.m76835h(activity);
        }
        if (dVarM14232q.f10855f.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) dVarM14232q.f10855f.getLayoutParams();
            layoutParams2.setMarginEnd(iM76835h);
            dVarM14232q.f10855f.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: q0 */
    public final void m14185q0(Media media, MediaFileBean mediaFileBean) {
        long jLongValue = media.getSize().longValue();
        String fileSize = Formatter.formatFileSize(getActivity(), jLongValue);
        int iM1357g = C0212e0.m1357g(getActivity(), "mobile_data_tips_sp", "current_tips_setting_type", 0);
        if (iM1357g == 0) {
            C12097j.m72480b().m72482c(getActivity(), fileSize, 2, this.f10793h0);
            return;
        }
        if (iM1357g != 1) {
            if (iM1357g != 2) {
                return;
            }
            m14160X0(mediaFileBean);
        } else if (C1122c.f5368v < jLongValue) {
            C12097j.m72480b().m72482c(getActivity(), fileSize, 2, this.f10793h0);
        } else {
            m14160X0(mediaFileBean);
        }
    }

    /* renamed from: q1 */
    public final void m14186q1(ViewOnClickListenerC2266j.d dVar) {
        RelativeLayout.LayoutParams layoutParams;
        C1120a.m6677i("AlbumFileViewFragment", "setSurfaceViewSize");
        if (dVar == null || dVar.f10873x <= 0 || dVar.f10872w <= 0) {
            C1120a.m6676e("AlbumFileViewFragment", "videoWidth or videoHeight invalid");
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "videoRotation is: " + dVar.f10874y);
        C1120a.m6677i("AlbumFileViewFragment", "videoWidth is: " + dVar.f10873x);
        C1120a.m6677i("AlbumFileViewFragment", "videoHeight is: " + dVar.f10872w);
        if (C11842p.m70753O0(getActivity())) {
            float fMax = Math.max(dVar.f10873x / this.f10772U, dVar.f10872w / this.f10771T);
            layoutParams = new RelativeLayout.LayoutParams((int) Math.ceil(dVar.f10873x / fMax), (int) Math.ceil(dVar.f10872w / fMax));
        } else {
            float fMax2 = Math.max(dVar.f10873x / this.f10771T, dVar.f10872w / this.f10772U);
            layoutParams = new RelativeLayout.LayoutParams((int) Math.ceil(dVar.f10873x / fMax2), (int) Math.ceil(dVar.f10872w / fMax2));
        }
        layoutParams.addRule(13, -1);
        dVar.f10866q.setLayoutParams(layoutParams);
    }

    /* renamed from: r0 */
    public final MediaFileBean m14187r0() {
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null) {
            C1120a.m6676e("AlbumFileViewFragment", "getCurrentData mTabsAdapter is null");
            return null;
        }
        List<MediaFileBean> list = viewOnClickListenerC2266j.f10834i;
        if (list == null) {
            C1120a.m6676e("AlbumFileViewFragment", "getCurrentData mTabsAdapter.mFiles is null");
            return null;
        }
        if (!list.isEmpty()) {
            return this.f10786e.m14233r(this.f10788f);
        }
        C1120a.m6676e("AlbumFileViewFragment", "getCurrentData no data");
        return null;
    }

    /* renamed from: r1 */
    public final void m14188r1(MediaFileBean mediaFileBean, Media media) {
        long jLongValue = media.getSize().longValue();
        String fileSize = Formatter.formatFileSize(getActivity(), jLongValue);
        int iM1357g = C0212e0.m1357g(getActivity(), "mobile_data_tips_sp", "current_tips_setting_type", 0);
        if (iM1357g == 0) {
            C12097j.m72480b().m72482c(getActivity(), fileSize, 3, this.f10793h0);
            return;
        }
        if (iM1357g != 1) {
            if (iM1357g != 2) {
                return;
            }
            m14198x1(mediaFileBean);
        } else if (C1122c.f5368v < jLongValue) {
            C12097j.m72480b().m72482c(getActivity(), fileSize, 3, this.f10793h0);
        } else {
            m14198x1(mediaFileBean);
        }
    }

    /* renamed from: s1 */
    public void m14189s1(Context context, int i10) {
        if (context == null) {
            C1120a.m6677i("AlbumFileViewFragment", "mContext is null");
            return;
        }
        if (1203 == i10) {
            m14196w1(R$string.cloudpay_server_error_later_try_again);
            return;
        }
        if (1001 == i10) {
            return;
        }
        if (m14077J0(i10)) {
            m14196w1(R$string.video_format_not_support_play_online);
            return;
        }
        if (1099 == i10) {
            m14196w1(R$string.play_video_error);
        } else if (m14079K0(i10)) {
            m14196w1(R$string.play_video_error);
        } else if (m14081L0(i10)) {
            m14196w1(R$string.invite_family_member_failed_net_disable);
        }
    }

    /* renamed from: t0 */
    public void mo14190t0(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "start getItemCurrentUploadStatus");
        if (this.f10786e == null) {
            C1120a.m6676e("AlbumFileViewFragment", "getItemCurrentUploadStatus mTabsAdapter is null");
            return;
        }
        C12515a.m75110o().m75175e(new C2262f(this.f10786e.m14233r(dVar.f10850a), this.f10793h0), false);
    }

    /* renamed from: t1 */
    public void m14191t1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        if ((dVar.f10863n == 3 || dVar.f10863n == 5) && this.f10788f == dVar.f10850a) {
            if (dVar.f10855f.getVisibility() != 0) {
                dVar.f10852c.setVisibility(0);
            }
            this.f10810w.setVisibility(8);
        }
    }

    /* renamed from: u0 */
    public final void m14192u0(ViewOnClickListenerC2266j.d dVar) {
        C1120a.m6677i("AlbumFileViewFragment", "start getItemIsDownload");
        if (dVar == null) {
            C1120a.m6676e("AlbumFileViewFragment", "getItemIsDownload info is null");
            return;
        }
        ViewOnClickListenerC2266j viewOnClickListenerC2266j = this.f10786e;
        if (viewOnClickListenerC2266j == null) {
            C1120a.m6676e("AlbumFileViewFragment", "getItemIsDownload mTabsAdapter is null");
            return;
        }
        if (viewOnClickListenerC2266j.f10834i == null) {
            C1120a.m6676e("AlbumFileViewFragment", "getItemIsDownload mTabsAdapter.mFiles is null");
            return;
        }
        int i10 = dVar.f10850a;
        MediaFileBean mediaFileBeanM14233r = this.f10786e.m14233r(i10);
        if (mediaFileBeanM14233r == null || dVar.f10843A) {
            return;
        }
        C12515a.m75110o().m75175e(new C2261e(mediaFileBeanM14233r, this.f10785d0, dVar, i10), false);
    }

    /* renamed from: u1 */
    public final void m14193u1(ViewOnClickListenerC2266j.d dVar) {
        if (dVar == null) {
            return;
        }
        C1120a.m6677i("AlbumFileViewFragment", "showLoading");
        if (dVar.f10850a == this.f10788f) {
            dVar.f10861l.setVisibility(0);
        }
    }

    /* renamed from: v0 */
    public final Message m14194v0(int i10, ViewOnClickListenerC2266j.d dVar) {
        Message messageObtain = Message.obtain(this.f10785d0);
        messageObtain.what = i10;
        messageObtain.arg1 = dVar.f10850a;
        return messageObtain;
    }

    /* renamed from: v1 */
    public final void m14195v1() {
        LinearLayout linearLayout;
        C1120a.m6677i("AlbumFileViewFragment", "showSingleFilAppealEntrance");
        if (this.f10766O == null || (linearLayout = this.f10757F) == null || this.f10765N == null) {
            C1120a.m6676e("AlbumFileViewFragment", "showSingleFilAppealEntrance is null");
            return;
        }
        linearLayout.setVisibility(0);
        this.f10765N.setVisibility(8);
        this.f10766O.setVisibility(0);
    }

    /* renamed from: w1 */
    public void m14196w1(int i10) {
        Toast.makeText(getActivity(), i10, 0).show();
    }

    /* renamed from: x0 */
    public String m14197x0(long j10) {
        try {
            return C12091d.m72280a0().m72332U(C0213f.m1377a(), j10, this.f10805r);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumFileViewFragment", "getWordsTitle error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: x1 */
    public final void m14198x1(MediaFileBean mediaFileBean) {
        C1120a.m6677i("AlbumFileViewFragment", "start singleFileDownload");
        Media mediaM14344o = mediaFileBean.m14344o();
        long jLongValue = mediaM14344o.getSize().longValue();
        Activity activity = getActivity();
        C12097j.m72480b().m72483d(activity, Formatter.formatFileSize(activity, jLongValue), this.f10793h0);
        C12096i.m72418I().m72434C(mediaM14344o);
    }

    /* renamed from: y0 */
    public final void m14199y0(Media media, int i10) {
        if (i10 == 1) {
            this.f10809v.setVisibility(0);
            this.f10809v.setText(R$string.album_sub_title_upload_wait);
            m14168f1();
            return;
        }
        if (i10 == 2) {
            this.f10809v.setVisibility(0);
            this.f10809v.setText(R$string.album_sub_title_uploading);
            m14168f1();
            return;
        }
        if (i10 == 3) {
            this.f10809v.setVisibility(0);
            this.f10809v.setText(R$string.album_sub_title_upload_pause);
            m14168f1();
            return;
        }
        if (i10 == 4) {
            this.f10809v.setVisibility(0);
            this.f10809v.setText(R$string.album_sub_title_upload_file_not_exist);
            m14173k0();
            return;
        }
        if (i10 != 6) {
            return;
        }
        boolean zM14152N0 = m14152N0(media);
        boolean zM14151M0 = m14151M0(media);
        if (zM14152N0) {
            this.f10809v.setVisibility(0);
            this.f10809v.setText(R$string.album_sub_title_upload_check);
            m14168f1();
        } else if (zM14151M0) {
            this.f10809v.setVisibility(0);
            this.f10809v.setText(R$string.album_sub_title_upload_illegal);
            m14169g1();
            m14195v1();
        }
    }

    /* renamed from: y1 */
    public void m14200y1() {
        if (this.f10759H == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new AnimationAnimationListenerC2260d());
        this.f10759H.startAnimation(translateAnimation);
    }

    /* renamed from: z0 */
    public final void m14201z0(int i10, Activity activity, String str, int i11) {
        switch (i11) {
            case 1000:
                C1120a.m6677i("AlbumFileViewFragment", "single download SUCCEED");
                C12097j.m72480b().m72481a();
                m14139B1(m14187r0());
                m14192u0(this.f10786e.m14230o(this.f10788f));
                break;
            case 1001:
                C1120a.m6677i("AlbumFileViewFragment", "single download ERROR_PAUSE");
                break;
            case 1002:
                C1120a.m6677i("AlbumFileViewFragment", "single download ERROR_CANCEL");
                C12097j.m72480b().m72481a();
                break;
            case 1003:
                C1120a.m6677i("AlbumFileViewFragment", "single download ERROR_FAILED");
                C12097j.m72480b().m72481a();
                if (!C0209d.m1208S0(activity)) {
                    C12097j.m72480b().m72490k(activity);
                    break;
                } else {
                    C12097j.m72480b().m72485f(activity);
                    break;
                }
            default:
                C1120a.m6677i("AlbumFileViewFragment", "single download default");
                C12097j.m72480b().m72484e(str, i10);
                break;
        }
    }

    /* renamed from: z1 */
    public void m14202z1() {
        LinearLayout linearLayout = this.f10759H;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        this.f10759H.startAnimation(translateAnimation);
    }
}
