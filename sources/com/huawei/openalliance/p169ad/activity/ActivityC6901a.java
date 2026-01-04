package com.huawei.openalliance.p169ad.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7335ji;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import com.huawei.openalliance.p169ad.views.InterfaceC8069ad;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.activity.a */
/* loaded from: classes8.dex */
public class ActivityC6901a extends AbstractActivityC6905e implements C7335ji.a {

    /* renamed from: s */
    private static Context f31787s;

    /* renamed from: a */
    protected int f31788a;

    /* renamed from: b */
    protected int f31789b;

    /* renamed from: c */
    protected int f31790c;

    /* renamed from: d */
    protected int f31791d;

    /* renamed from: e */
    protected RelativeLayout f31792e;

    /* renamed from: f */
    protected View f31793f;

    /* renamed from: g */
    protected View f31794g;

    /* renamed from: h */
    protected int[] f31795h;

    /* renamed from: i */
    protected int[] f31796i;

    /* renamed from: j */
    protected AbstractC8104h f31797j;

    /* renamed from: k */
    protected AbstractC8104h f31798k;

    /* renamed from: l */
    protected AbstractC8104h f31799l;

    /* renamed from: m */
    protected ImageView f31800m;

    /* renamed from: n */
    protected ImageView f31801n;

    /* renamed from: o */
    protected ImageView f31802o;

    /* renamed from: q */
    private a f31803q;

    /* renamed from: r */
    private boolean f31804r = false;

    /* renamed from: com.huawei.openalliance.ad.activity.a$a */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                AbstractC7185ho.m43820b("BaseDialogActivity", "intent is empty");
                return;
            }
            String action = intent.getAction();
            AbstractC7185ho.m43821b("BaseDialogActivity", "FeedbackEventReceiver action = %s", action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) || "com.huawei.intent.action.CLICK_STATUSBAR".equals(action)) {
                ActivityC6901a.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.a$b */
    public static class b implements InterfaceC8069ad {

        /* renamed from: a */
        WeakReference<ActivityC6901a> f31807a;

        public b(ActivityC6901a activityC6901a) {
            this.f31807a = new WeakReference<>(activityC6901a);
        }

        @Override // com.huawei.openalliance.p169ad.views.InterfaceC8069ad
        /* renamed from: a */
        public void mo38783a(int i10) {
            ActivityC6901a activityC6901a = this.f31807a.get();
            if (activityC6901a == null || activityC6901a.f31804r) {
                return;
            }
            AbstractC7185ho.m43821b("BaseDialogActivity", "got safePadding: %s", Integer.valueOf(i10));
            activityC6901a.m38771a(i10);
        }
    }

    /* renamed from: l */
    private void m38775l() {
        int i10;
        if (this.f31795h[1] + (this.f31796i[1] >> 1) > (this.f31789b >> 1)) {
            this.f31798k.setVisibility(8);
            this.f31800m.setVisibility(0);
            this.f31801n.setVisibility(8);
            this.f31799l = this.f31797j;
            this.f31802o = this.f31800m;
            int iM47583h = AbstractC7741ao.m47583h(this);
            if (C6982bz.m41148a(this).mo41171a(this)) {
                iM47583h = Math.max(iM47583h, C6982bz.m41148a(this).mo41169a(this.f31792e));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31799l.getLayoutParams();
            layoutParams.setMargins(0, iM47583h, 0, 0);
            this.f31799l.setLayoutParams(layoutParams);
            return;
        }
        this.f31797j.setVisibility(8);
        this.f31800m.setVisibility(8);
        this.f31801n.setVisibility(0);
        this.f31799l = this.f31798k;
        this.f31802o = this.f31801n;
        boolean zM48587n = C7845x.m48587n(this);
        boolean z10 = C7845x.m48590o(this) && (1 == (i10 = this.f31790c) || 9 == i10);
        boolean z11 = C7845x.m48595q(this) && C7845x.m48599r(this);
        if (zM48587n || z10 || z11) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f31799l.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, Math.max(AbstractC7741ao.m47535a(this, 40.0f), AbstractC7811dd.m48329g(this)));
            this.f31799l.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: m */
    private void m38776m() {
        ViewGroup.LayoutParams layoutParams = this.f31793f.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] iArr = this.f31795h;
            layoutParams2.width = iArr[0];
            layoutParams2.height = iArr[1];
            this.f31793f.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.f31794g.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            int[] iArr2 = this.f31796i;
            layoutParams4.width = iArr2[0];
            layoutParams4.height = iArr2[1];
            this.f31794g.setLayoutParams(layoutParams4);
        }
    }

    /* renamed from: n */
    private void m38777n() {
        this.f31792e.setForceDarkAllowed(false);
    }

    /* renamed from: o */
    private void m38778o() {
        try {
            this.f31803q = new a();
            registerReceiver(this.f31803q, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), "android.permission.WRITE_SECURE_SETTINGS", null);
            AbstractC7741ao.m47537a(getBaseContext(), this.f31803q, new IntentFilter("com.huawei.intent.action.CLICK_STATUSBAR"), "huawei.permission.CLICK_STATUSBAR_BROADCAST", null);
            C7335ji.m45308a().m45310a(NotifyMessageNames.FEEDBACK_RECEIVE, this);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BaseDialogActivity", "registerReceiver error: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
    }

    /* renamed from: b */
    public void mo38622b() {
    }

    /* renamed from: c */
    public void mo38601c() {
    }

    /* renamed from: d */
    public int mo38602d() {
        return 0;
    }

    /* renamed from: e */
    public void mo38603e() {
    }

    /* renamed from: f */
    public void m38779f() {
        int viewWith;
        int viewWith2;
        AbstractC7185ho.m43821b("BaseDialogActivity", "getRealOrientation orientation %s", Integer.valueOf(this.f31790c));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31799l.getLayoutParams();
        int iAbs = Math.abs((int) this.f31802o.getX());
        int iM47535a = AbstractC7741ao.m47535a(this, 36.0f);
        int i10 = (iM47535a >> 1) + iAbs;
        double d10 = iM47535a * 0.5d;
        int viewWidthPercent = (int) ((this.f31788a * (1.0f - this.f31799l.getViewWidthPercent()) * 0.5d) + AbstractC7741ao.m47535a(this, 16.0f) + d10);
        int viewWidthPercent2 = (int) (((this.f31788a * ((this.f31799l.getViewWidthPercent() * 0.5d) + 0.5d)) - AbstractC7741ao.m47535a(this, 16.0f)) - d10);
        AbstractC7185ho.m43818a("BaseDialogActivity", "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        AbstractC7185ho.m43818a("BaseDialogActivity", "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(iAbs), Integer.valueOf(iM47535a), Integer.valueOf(i10));
        int i11 = this.f31790c;
        if (1 != i11 && 9 != i11) {
            layoutParams.removeRule(14);
            this.f31799l.setLayoutParams(layoutParams);
            int i12 = this.f31788a;
            if (i10 < i12 / 3) {
                viewWith = AbstractC7741ao.m47535a(this, 16.0f);
            } else {
                if (i10 < (i12 * 2) / 3) {
                    viewWith2 = i10 - (this.f31799l.getViewWith() >> 1);
                    this.f31799l.setPaddingStart(viewWith2);
                    AbstractC7811dd.m48292a(this, new b(this));
                }
                iAbs = iAbs + iM47535a + AbstractC7741ao.m47535a(this, 16.0f);
                viewWith = this.f31799l.getViewWith();
            }
        } else if (i10 < viewWidthPercent) {
            AbstractC7185ho.m43817a("BaseDialogActivity", "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.f31799l.setLayoutParams(layoutParams);
            viewWith = AbstractC7741ao.m47535a(this, 16.0f);
        } else {
            if (i10 <= viewWidthPercent2) {
                AbstractC7185ho.m43817a("BaseDialogActivity", "locationX =< curImgCenter =< locationX2");
                layoutParams.addRule(14);
                this.f31799l.setLayoutParams(layoutParams);
                AbstractC7811dd.m48292a(this, new b(this));
            }
            AbstractC7185ho.m43817a("BaseDialogActivity", "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            this.f31799l.setLayoutParams(layoutParams);
            iAbs = iAbs + iM47535a + AbstractC7741ao.m47535a(this, 16.0f);
            viewWith = this.f31799l.getViewWith();
        }
        viewWith2 = iAbs - viewWith;
        this.f31799l.setPaddingStart(viewWith2);
        AbstractC7811dd.m48292a(this, new b(this));
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        AbstractC7185ho.m43820b("BaseDialogActivity", "finish");
        RelativeLayout relativeLayout = this.f31792e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    /* renamed from: g */
    public void mo38608g() {
        int iM47535a = AbstractC7741ao.m47535a(this, 36.0f);
        int i10 = this.f31791d;
        int i11 = (this.f31788a - i10) - iM47535a;
        int i12 = (this.f31795h[0] + (this.f31796i[0] >> 1)) - (iM47535a >> 1);
        if (i12 >= i10) {
            i10 = i12;
        }
        if (i10 <= i11) {
            i11 = i10;
        }
        this.f31802o.setX(AbstractC7811dd.m48315c() ? -i11 : i11);
    }

    /* renamed from: h */
    public void m38780h() {
        int iHeight;
        if (Build.VERSION.SDK_INT >= 30) {
            this.f31788a = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            iHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        } else {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getSize(point);
            this.f31788a = point.x;
            iHeight = point.y;
        }
        this.f31789b = iHeight;
        AbstractC7185ho.m43818a("BaseDialogActivity", "initDevicesInfo screenWidth: %s, screenHeight: %s", Integer.valueOf(this.f31788a), Integer.valueOf(this.f31789b));
        this.f31790c = AbstractC7811dd.m48335k(this);
        this.f31791d = AbstractC7741ao.m47535a(this, 22.0f);
    }

    /* renamed from: i */
    public boolean mo38604i() {
        try {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            this.f31795h = safeIntent.getIntArrayExtra(MapKeyNames.ANCHOR_LOCATION);
            this.f31796i = safeIntent.getIntArrayExtra(MapKeyNames.ANCHOR_SIZE);
            if (!m38774a(this.f31795h) && !m38774a(this.f31796i)) {
                if (AbstractC7811dd.m48315c()) {
                    int[] iArr = this.f31795h;
                    int i10 = (this.f31788a - iArr[0]) - this.f31796i[0];
                    iArr[0] = i10;
                    AbstractC7185ho.m43821b("BaseDialogActivity", "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(i10), Integer.valueOf(this.f31795h[1]));
                }
                if (AbstractC7811dd.m48309b((Activity) this)) {
                    int iM48349y = AbstractC7811dd.m48349y(this);
                    int[] iArr2 = this.f31795h;
                    iArr2[1] = iArr2[1] - iM48349y;
                    AbstractC7185ho.m43817a("BaseDialogActivity", "windowing mode is freeform");
                    AbstractC7185ho.m43818a("BaseDialogActivity", "initDevicesInfo dragBarHeight: %s", Integer.valueOf(iM48349y));
                }
                return true;
            }
            AbstractC7185ho.m43823c("BaseDialogActivity", "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BaseDialogActivity", "getIntentExtra error: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    @TargetApi(19)
    /* renamed from: j */
    public void m38781j() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    /* renamed from: k */
    public void m38782k() {
        try {
            a aVar = this.f31803q;
            if (aVar != null) {
                unregisterReceiver(aVar);
            }
            C7335ji.m45308a().m45311b(NotifyMessageNames.FEEDBACK_RECEIVE, this);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BaseDialogActivity", "unRegisterReceiver: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setBackgroundDrawableResource(C6849R.color.hiad_transparent);
            getWindow().setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK, HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            setContentView(mo38602d());
            f31787s = getApplicationContext();
            m38780h();
            if (!mo38604i()) {
                AbstractC7185ho.m43823c("BaseDialogActivity", "getIntentExtra return false");
                mo38622b();
                finish();
                return;
            }
            m38781j();
            getWindow().addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            mo38601c();
            m38777n();
            m38775l();
            m38776m();
            mo38608g();
            m38778o();
            mo38603e();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BaseDialogActivity", "onCreate ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m38782k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m38771a(int i10) {
        AbstractC8104h abstractC8104h = this.f31799l;
        if (abstractC8104h != null) {
            abstractC8104h.m50255a(i10);
        }
        if (this.f31802o != null) {
            this.f31791d += i10;
            mo38608g();
        }
        this.f31804r = true;
    }

    @Override // com.huawei.openalliance.p169ad.C7335ji.a
    /* renamed from: a */
    public void mo38588a(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            AbstractC7185ho.m43820b("BaseDialogActivity", "msgName or msgData is empty!");
            return;
        }
        AbstractC7185ho.m43818a("BaseDialogActivity", "onMessageNotify msgName:%s", str);
        try {
            String action = intent.getAction();
            AbstractC7185ho.m43821b("BaseDialogActivity", "FeedbackEventReceiver action = %s", action);
            if (!"com.huawei.ads.feedback.action.ANCHOR_LOCATION_CHANGE".equals(action) && !"com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY".equals(action)) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.a.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43820b("BaseDialogActivity", "anchor point changed, do finish.");
                    ActivityC6901a.this.finish();
                }
            });
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("BaseDialogActivity", "error: " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private boolean m38774a(int[] iArr) {
        return iArr == null || iArr.length != 2;
    }
}
