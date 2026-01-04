package com.huawei.openalliance.p169ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.huawei.android.widget.ToastEx;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ads.AdFeedbackExtraListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.InterfaceC7004cu;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.ViewTreeObserverOnGlobalLayoutListenerC7178hh;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import com.huawei.openalliance.p169ad.views.feedback.C8093c;
import com.huawei.openalliance.p169ad.views.feedback.FeedbackView;
import com.huawei.openalliance.p169ad.views.feedback.InterfaceC8092b;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p208cq.InterfaceC8936d;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class FeedbackActivity extends ActivityC6901a implements InterfaceC8092b, AbstractC8104h.a {

    /* renamed from: w */
    private static WeakReference<Context> f31652w;

    /* renamed from: q */
    private ContentRecord f31655q;

    /* renamed from: r */
    private C7302e f31656r;

    /* renamed from: s */
    private InterfaceC7615qq f31657s;

    /* renamed from: v */
    private InterfaceC7004cu f31658v;

    /* renamed from: y */
    private int f31659y;

    /* renamed from: t */
    private static Map<Integer, AdFeedbackListener> f31650t = new HashMap();

    /* renamed from: u */
    private static Map<Integer, AdFeedbackListener> f31651u = new HashMap();

    /* renamed from: x */
    private static SecureRandom f31653x = new SecureRandom();

    /* renamed from: A */
    private static WeakReference<View> f31648A = null;

    /* renamed from: B */
    private static int[] f31649B = null;

    /* renamed from: z */
    private boolean f31660z = false;

    /* renamed from: C */
    private ViewTreeObserverOnGlobalLayoutListenerC7178hh f31654C = null;

    /* renamed from: com.huawei.openalliance.ad.activity.FeedbackActivity$1 */
    public class ViewOnClickListenerC68631 implements View.OnClickListener {
        public ViewOnClickListenerC68631() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedbackActivity.this.f31658v != null) {
                FeedbackActivity.this.f31658v.mo39222f(FeedbackActivity.this.f31655q, "3");
            }
            FeedbackActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.FeedbackActivity$a */
    public static class C6864a implements InterfaceC8936d {
        private C6864a() {
        }

        public /* synthetic */ C6864a(ViewOnClickListenerC68631 viewOnClickListenerC68631) {
            this();
        }

        @Override // p208cq.InterfaceC8936d
        public void onCanceled() {
            AbstractC7185ho.m43823c("FeedbackActivity", "unlock screen canceled.");
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.FeedbackActivity$b */
    public static class C6865b implements InterfaceC8938f {
        private C6865b() {
        }

        public /* synthetic */ C6865b(ViewOnClickListenerC68631 viewOnClickListenerC68631) {
            this();
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            AbstractC7185ho.m43824c("FeedbackActivity", "unlock fail, exception is %s.", exc.getMessage());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.FeedbackActivity$c */
    public static class C6866c implements InterfaceC8939g<Boolean> {

        /* renamed from: a */
        private WeakReference<FeedbackActivity> f31662a;

        /* renamed from: b */
        private WeakReference<AbstractC8104h> f31663b;

        public C6866c(FeedbackActivity feedbackActivity, AbstractC8104h abstractC8104h) {
            this.f31662a = new WeakReference<>(feedbackActivity);
            this.f31663b = new WeakReference<>(abstractC8104h);
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            AbstractC7185ho.m43821b("FeedbackActivity", "unlock result is %s.", bool);
            FeedbackActivity feedbackActivity = this.f31662a.get();
            AbstractC8104h abstractC8104h = this.f31663b.get();
            if (bool.booleanValue()) {
                if (abstractC8104h != null) {
                    abstractC8104h.mo50132e();
                    return;
                } else {
                    AbstractC7185ho.m43823c("FeedbackActivity", "weak reference PPSBaseDialogContentView is null");
                    return;
                }
            }
            if (feedbackActivity == null) {
                AbstractC7185ho.m43823c("FeedbackActivity", "weak reference feedback activity is null.");
            } else {
                feedbackActivity.finish();
            }
        }
    }

    /* renamed from: m */
    private void m38620m() {
        this.f31792e.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.FeedbackActivity.1
            public ViewOnClickListenerC68631() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FeedbackActivity.this.f31658v != null) {
                    FeedbackActivity.this.f31658v.mo39222f(FeedbackActivity.this.f31655q, "3");
                }
                FeedbackActivity.this.finish();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: c */
    public void mo38601c() {
        this.f31792e = (RelativeLayout) findViewById(C6849R.id.feedback_activity_root);
        this.f31793f = findViewById(C6849R.id.margin_view);
        this.f31794g = findViewById(C6849R.id.feedback_anchor_view);
        this.f31797j = (FeedbackView) findViewById(C6849R.id.top_feedback_view);
        this.f31800m = (ImageView) findViewById(C6849R.id.top_feedback_iv);
        this.f31798k = (FeedbackView) findViewById(C6849R.id.bottom_feedback_view);
        this.f31801n = (ImageView) findViewById(C6849R.id.bottom_feedback_iv);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: d */
    public int mo38602d() {
        return C6849R.layout.hiad_activity_feedback;
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: e */
    public void mo38603e() {
        m38779f();
        this.f31799l.m50256a(this.f31795h, this.f31796i);
        this.f31799l.setAdContent(this.f31655q);
        this.f31799l.setFeedbackListener(this);
        this.f31799l.setScreenLockCallBack(this);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: i */
    public boolean mo38604i() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f31656r = (C7302e) safeIntent.getSerializableExtra(MapKeyNames.NATIVE_AD);
        this.f31659y = safeIntent.getIntExtra(MapKeyNames.INSTANCE_ID, 0);
        C7302e c7302e = this.f31656r;
        this.f31655q = c7302e == null ? AbstractC7014dc.m41890m() : C7570pd.m46698a(c7302e);
        if (this.f31655q == null) {
            return false;
        }
        return super.mo38604i();
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h.a
    /* renamed from: l */
    public void mo38623l() {
        AbstractC7185ho.m43820b("FeedbackActivity", "onLockScreenOpen.");
        try {
            Task<Boolean> taskM45027a = HiAd.getInstance(this).getAskForUnlockScreen().m45027a(this);
            AbstractC7185ho.m43820b("FeedbackActivity", "task is set.");
            C6866c c6866c = new C6866c(this, this.f31799l);
            C6864a c6864a = new C6864a();
            C6865b c6865b = new C6865b();
            taskM45027a.addOnSuccessListener(c6866c);
            taskM45027a.addOnCanceledListener(c6864a);
            taskM45027a.addOnFailureListener(c6865b);
        } catch (NullPointerException unused) {
            AbstractC7185ho.m43823c("FeedbackActivity", "get task err, NullPointerException");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FeedbackActivity", "listen task err: %s.", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        View view;
        try {
            super.onCreate(bundle);
            WeakReference<View> weakReference = f31648A;
            if (weakReference != null && (view = weakReference.get()) != null) {
                this.f31654C = new ViewTreeObserverOnGlobalLayoutListenerC7178hh(this, view, f31649B);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.f31654C);
            }
            if (Constants.MAGEZINE_PKG_NAME.equalsIgnoreCase(getApplicationContext().getPackageName())) {
                setShowWhenLocked(true);
            }
            if (AbstractC7811dd.m48310b((Context) this)) {
                this.f31660z = true;
            }
            m38620m();
            C6928i c6928i = new C6928i(this);
            this.f31658v = c6928i;
            c6928i.mo39222f(this.f31655q, "0");
            C7560ou c7560ou = new C7560ou(this, C7662sk.m47225a(this, this.f31655q.m41552f()));
            this.f31657s = c7560ou;
            c7560ou.mo46590a(this.f31655q);
            WeakReference<Context> weakReference2 = f31652w;
            if (weakReference2 != null) {
                AbstractC7811dd.m48291a(this, weakReference2.get());
            }
            try {
                getWindow().clearFlags(ARImageMetadata.SHADING_MODE);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("FeedbackActivity", "clear flag err: %s.", th2.getClass().getSimpleName());
            }
            m38619b(f31651u.get(Integer.valueOf(this.f31659y)));
            AbstractC7185ho.m43821b("FeedbackActivity", "onCreate: %s, instance: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.f31659y));
        } catch (Throwable th3) {
            AbstractC7185ho.m43824c("FeedbackActivity", "init error: %s", th3.getClass().getSimpleName());
            m38615a(f31651u.get(Integer.valueOf(this.f31659y)));
            finish();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        View view;
        super.onDestroy();
        AbstractC7014dc.m41871a((C7302e) null);
        AbstractC7185ho.m43821b("FeedbackActivity", "onDestroy %s, instance: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.f31659y));
        m38611a(this.f31659y);
        AbstractC8104h abstractC8104h = this.f31799l;
        if (abstractC8104h != null) {
            abstractC8104h.setScreenLockCallBack(null);
        }
        WeakReference<View> weakReference = f31648A;
        if (weakReference == null || (view = weakReference.get()) == null || this.f31654C == null) {
            return;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f31654C);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: b */
    public void mo38622b() {
        m38615a(f31651u.get(Integer.valueOf(this.f31659y)));
    }

    /* renamed from: a */
    private static void m38611a(int i10) {
        f31650t.remove(Integer.valueOf(i10));
        f31651u.remove(Integer.valueOf(i10));
    }

    /* renamed from: b */
    private static void m38619b(AdFeedbackListener adFeedbackListener) {
        if (adFeedbackListener instanceof AdFeedbackExtraListener) {
            ((AdFeedbackExtraListener) adFeedbackListener).onAdFeedBackExtra(1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x001f A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {all -> 0x0019, blocks: (B:24:0x0002, B:30:0x0013, B:33:0x001b, B:34:0x001f), top: B:40:0x0002 }] */
    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8092b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo38621a(int r3, com.huawei.openalliance.p169ad.inter.data.FeedbackInfo r4) {
        /*
            r2 = this;
            java.lang.String r0 = "FeedbackActivity"
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L19
            r1.<init>()     // Catch: java.lang.Throwable -> L19
            r1.add(r4)     // Catch: java.lang.Throwable -> L19
            r4 = 1
            if (r3 == r4) goto L1f
            r4 = 2
            if (r3 == r4) goto L1b
            r4 = 3
            if (r3 == r4) goto L1f
            java.lang.String r3 = "invalid feedback type"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r0, r3)     // Catch: java.lang.Throwable -> L19
            goto L34
        L19:
            r3 = move-exception
            goto L23
        L1b:
            r2.m38617a(r1)     // Catch: java.lang.Throwable -> L19
            goto L34
        L1f:
            r2.m38612a(r3, r1)     // Catch: java.lang.Throwable -> L19
            goto L34
        L23:
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getSimpleName()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "itemClickAction error: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r4, r3)
        L34:
            r2.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.activity.FeedbackActivity.mo38621a(int, com.huawei.openalliance.ad.inter.data.FeedbackInfo):void");
    }

    /* renamed from: a */
    private void m38612a(int i10, List<FeedbackInfo> list) throws Resources.NotFoundException {
        Toast toastMakeText = Toast.makeText(getApplicationContext(), C6849R.string.hiad_feedback_reduce_such_content, 0);
        if (this.f31660z) {
            m38614a(toastMakeText);
        } else {
            toastMakeText.show();
        }
        InterfaceC7615qq interfaceC7615qq = this.f31657s;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46614b(list);
        }
        InterfaceC7004cu interfaceC7004cu = this.f31658v;
        if (interfaceC7004cu != null) {
            interfaceC7004cu.mo39222f(this.f31655q, 1 == i10 ? "2" : "4");
        }
        AdFeedbackListener adFeedbackListener = f31650t.get(Integer.valueOf(this.f31659y));
        AdFeedbackListener adFeedbackListener2 = f31651u.get(Integer.valueOf(this.f31659y));
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(adFeedbackListener != null);
        objArr[1] = Boolean.valueOf(adFeedbackListener2 != null);
        AbstractC7185ho.m43821b("FeedbackActivity", "neg, innerListener: %s, listener: %s", objArr);
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdDisliked();
        }
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdDisliked();
        }
    }

    /* renamed from: a */
    public static void m38613a(Context context, C8093c c8093c) {
        if (c8093c == null) {
            return;
        }
        if (C7730ad.m47434a()) {
            AbstractC7185ho.m43820b("FeedbackActivity", "fast click");
            return;
        }
        AdFeedbackListener adFeedbackListenerM50149c = c8093c.m50149c();
        C7302e c7302eM41889l = AbstractC7014dc.m41889l();
        if (c7302eM41889l == null || c8093c.m50143a() == null || !C7730ad.m47435a(c7302eM41889l.getFeedbackInfoList())) {
            AbstractC7185ho.m43826d("FeedbackActivity", "startFeedbackActivity fail: invalid parameter.");
            m38615a(adFeedbackListenerM50149c);
            return;
        }
        int iNextInt = f31653x.nextInt(Integer.MAX_VALUE);
        f31650t.put(Integer.valueOf(iNextInt), c8093c.m50147b());
        f31651u.put(Integer.valueOf(iNextInt), adFeedbackListenerM50149c);
        try {
            View viewM50143a = c8093c.m50143a();
            f31648A = new WeakReference<>(viewM50143a);
            int[] iArr = new int[2];
            m38616a(c8093c, viewM50143a);
            viewM50143a.getLocationInWindow(iArr);
            AbstractC7185ho.m43821b("FeedbackActivity", "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            viewM50143a.getLocationOnScreen(iArr2);
            f31649B = iArr2;
            int[] iArr3 = {viewM50143a.getMeasuredWidth(), viewM50143a.getMeasuredHeight()};
            Intent intent = new Intent(context, (Class<?>) FeedbackActivity.class);
            intent.putExtra(MapKeyNames.ANCHOR_LOCATION, iArr);
            intent.putExtra(MapKeyNames.ANCHOR_SIZE, iArr3);
            intent.setFlags(65536);
            intent.putExtra(MapKeyNames.NATIVE_AD, c7302eM41889l);
            intent.putExtra(MapKeyNames.INSTANCE_ID, iNextInt);
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FeedbackActivity", "startFeedbackActivity error: %s", th2.getClass().getSimpleName());
            m38615a(adFeedbackListenerM50149c);
            m38611a(iNextInt);
        }
    }

    /* renamed from: a */
    private void m38614a(Toast toast) {
        try {
            if (toast == null) {
                AbstractC7185ho.m43820b("FeedbackActivity", "toast is null.");
                return;
            }
            WindowManager.LayoutParams windowParams = ToastEx.getWindowParams(toast);
            if (windowParams == null) {
                AbstractC7185ho.m43820b("FeedbackActivity", "params is null.");
            } else {
                windowParams.flags |= ARImageMetadata.LENS_APERTURE;
                toast.show();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("FeedbackActivity", "show toast err: %s.", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private static void m38615a(AdFeedbackListener adFeedbackListener) {
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdFeedbackShowFailed();
        }
    }

    /* renamed from: a */
    private static void m38616a(C8093c c8093c, View view) {
        if (c8093c.m50150d() != null) {
            f31652w = new WeakReference<>(c8093c.m50150d());
        } else {
            f31652w = new WeakReference<>(view.getContext());
        }
    }

    /* renamed from: a */
    private void m38617a(List<FeedbackInfo> list) throws Resources.NotFoundException {
        Toast toastMakeText = Toast.makeText(getApplicationContext(), C6849R.string.hiad_feedback_had_feedback, 0);
        if (this.f31660z) {
            m38614a(toastMakeText);
        } else {
            toastMakeText.show();
        }
        InterfaceC7615qq interfaceC7615qq = this.f31657s;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46604a(list);
        }
        InterfaceC7004cu interfaceC7004cu = this.f31658v;
        if (interfaceC7004cu != null) {
            interfaceC7004cu.mo39222f(this.f31655q, "1");
        }
        AdFeedbackListener adFeedbackListener = f31650t.get(Integer.valueOf(this.f31659y));
        AdFeedbackListener adFeedbackListener2 = f31651u.get(Integer.valueOf(this.f31659y));
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(adFeedbackListener != null);
        objArr[1] = Boolean.valueOf(adFeedbackListener2 != null);
        AbstractC7185ho.m43821b("FeedbackActivity", "pos, innerListener: %s, listener: %s", objArr);
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdLiked();
        }
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdLiked();
        }
    }
}
