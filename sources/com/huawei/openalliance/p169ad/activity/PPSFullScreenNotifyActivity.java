package com.huawei.openalliance.p169ad.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7002cs;
import com.huawei.openalliance.p169ad.activity.AbstractActivityC6902b;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.app.C7058o;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.C8144n;
import com.huawei.openalliance.p169ad.views.C8145o;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8132y;
import com.huawei.openalliance.p169ad.views.viewpager.InterfaceC8159d;
import com.huawei.openalliance.p169ad.views.viewpager.WrapContentHeightGalleryView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class PPSFullScreenNotifyActivity extends AbstractActivityC6902b implements InterfaceC8132y {

    /* renamed from: a */
    private int f31721a;

    /* renamed from: b */
    private int f31722b;

    /* renamed from: c */
    private int f31723c;

    /* renamed from: d */
    private View f31724d;

    /* renamed from: e */
    private View f31725e;

    /* renamed from: f */
    private C8145o f31726f;

    /* renamed from: g */
    private C8144n f31727g;

    /* renamed from: h */
    private ContentRecord f31728h;

    /* renamed from: i */
    private String f31729i;

    /* renamed from: j */
    private WrapContentHeightGalleryView f31730j;

    /* renamed from: l */
    private InterfaceC7002cs f31732l;

    /* renamed from: m */
    private AbstractActivityC6902b.a f31733m;

    /* renamed from: n */
    private Handler f31734n;

    /* renamed from: q */
    private int f31736q;

    /* renamed from: k */
    private List<View> f31731k = new ArrayList();

    /* renamed from: o */
    private boolean f31735o = false;

    /* renamed from: r */
    private InterfaceC8159d f31737r = new InterfaceC8159d() { // from class: com.huawei.openalliance.ad.activity.PPSFullScreenNotifyActivity.2
        @Override // com.huawei.openalliance.p169ad.views.viewpager.InterfaceC8159d
        /* renamed from: a */
        public void mo38721a(int i10) {
        }

        @Override // com.huawei.openalliance.p169ad.views.viewpager.InterfaceC8159d
        /* renamed from: b */
        public void mo38723b(int i10) {
            if (i10 != 0 || PPSFullScreenNotifyActivity.this.f31730j.getCurrentItem() == 1) {
                return;
            }
            AbstractC7185ho.m43820b("PPSFullScreenNotifyActivity", "onPageScrollStateChanged, state = " + i10);
            C6920a c6920a = new C6920a();
            c6920a.m38870b(AbstractC7806cz.m48153a((Object) 1));
            PPSFullScreenNotifyActivity.this.f31732l.mo39078a(PPSFullScreenNotifyActivity.this.f31728h, "3", c6920a);
            PPSFullScreenNotifyActivity.this.mo38720c();
        }

        @Override // com.huawei.openalliance.p169ad.views.viewpager.InterfaceC8159d
        /* renamed from: a */
        public void mo38722a(int i10, float f10, int i11) {
        }
    };

    /* renamed from: e */
    private void m38717e() {
        AbstractC7185ho.m43820b("PPSFullScreenNotifyActivity", "initOptimizeView");
        m38718f();
        C8144n c8144n = new C8144n(this);
        this.f31727g = c8144n;
        c8144n.setOnCloseListener(this);
        this.f31727g.m50439a(this.f31728h, this.f31729i);
        this.f31727g.setDownloadSource(this.f31723c);
        this.f31731k.add(this.f31727g);
        WrapContentHeightGalleryView wrapContentHeightGalleryView = (WrapContentHeightGalleryView) findViewById(C6849R.id.hiad_view_pager);
        this.f31730j = wrapContentHeightGalleryView;
        wrapContentHeightGalleryView.setAdapter(new C7058o(this.f31731k));
        this.f31730j.setCurrentItem(1);
        this.f31727g.m50438a();
    }

    /* renamed from: f */
    private void m38718f() {
        ArrayList arrayList = new ArrayList();
        this.f31731k = arrayList;
        WrapContentHeightGalleryView wrapContentHeightGalleryView = this.f31730j;
        if (wrapContentHeightGalleryView != null) {
            wrapContentHeightGalleryView.setAdapter(new C7058o(arrayList));
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onBackPressed() {
        boolean zMo43044V = C7124fh.m43316b(this).mo43044V();
        AbstractC7185ho.m43821b("PPSFullScreenNotifyActivity", "onBackPressed dialogDismiss: %S", Boolean.valueOf(zMo43044V));
        if (zMo43044V) {
            super.onBackPressed();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6902b, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AbstractC7185ho.m43820b("PPSFullScreenNotifyActivity", "onCreate");
        m38710a(getIntent());
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSFullScreenNotifyActivity", "onDestroy");
        }
        super.onDestroy();
        m38712b((Context) this);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onNewIntent(Intent intent) {
        AbstractC7185ho.m43820b("PPSFullScreenNotifyActivity", "onNewIntent");
        super.onNewIntent(intent);
        this.f31735o = true;
        m38710a(intent);
    }

    /* renamed from: d */
    private void m38716d() {
        AbstractC7185ho.m43820b("PPSFullScreenNotifyActivity", "initView");
        m38718f();
        View view = new View(this);
        this.f31724d = view;
        view.setBackgroundColor(0);
        C8145o c8145o = new C8145o(this);
        this.f31726f = c8145o;
        c8145o.setOnCloseListener(this);
        this.f31726f.m50453a(this.f31728h, this.f31729i);
        this.f31726f.m50452a(this.f31721a, this.f31722b);
        this.f31726f.setDownloadSource(this.f31723c);
        View view2 = new View(this);
        this.f31725e = view2;
        view2.setBackgroundColor(0);
        this.f31731k.add(this.f31724d);
        this.f31731k.add(this.f31726f);
        this.f31731k.add(this.f31725e);
        WrapContentHeightGalleryView wrapContentHeightGalleryView = (WrapContentHeightGalleryView) findViewById(C6849R.id.hiad_view_pager);
        this.f31730j = wrapContentHeightGalleryView;
        wrapContentHeightGalleryView.setAdapter(new C7058o(this.f31731k));
        this.f31730j.setCurrentItem(1);
        this.f31730j.m50588a(this.f31737r);
        this.f31726f.m50451a();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setContentView(C6849R.layout.hiad_activity_full_screen_notify);
        ViewGroup viewGroup = (ViewGroup) findViewById(C6849R.id.hiad_installed_notify_layout);
        this.f31812p = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.PPSFullScreenNotifyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (1 == PPSFullScreenNotifyActivity.this.f31736q) {
                    C6920a c6920a = new C6920a();
                    c6920a.m38870b(AbstractC7806cz.m48153a((Object) 1));
                    PPSFullScreenNotifyActivity.this.f31732l.mo39078a(PPSFullScreenNotifyActivity.this.f31728h, "2", c6920a);
                    PPSFullScreenNotifyActivity.this.mo38720c();
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6902b
    /* renamed from: b */
    public void mo38698b() {
        Handler handler = this.f31734n;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.activity.PPSFullScreenNotifyActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    PPSFullScreenNotifyActivity.this.finish();
                }
            }, 300L);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8132y
    /* renamed from: c */
    public void mo38720c() {
        C8145o c8145o = this.f31726f;
        if (c8145o != null) {
            c8145o.setVisibility(8);
        }
        C8144n c8144n = this.f31727g;
        if (c8144n != null) {
            c8144n.setVisibility(8);
        }
        finish();
    }

    /* renamed from: b */
    private void m38712b(Context context) {
        AbstractActivityC6902b.a aVar = this.f31733m;
        if (aVar != null) {
            context.unregisterReceiver(aVar);
            this.f31733m = null;
        }
    }

    /* renamed from: a */
    public void m38719a(int i10) {
        int iM48233e = AbstractC7807d.m48233e(this);
        int iM48229d = AbstractC7807d.m48229d(this);
        if (i10 == 0 || i10 == 8) {
            this.f31721a = (C7845x.m48587n(this) || (C7845x.m48595q(this) && C7845x.m48599r(this))) ? (iM48233e * 2) / 3 : iM48233e / 2;
            this.f31722b = iM48233e;
            return;
        }
        if (C7845x.m48587n(this) || (C7845x.m48595q(this) && C7845x.m48599r(this))) {
            this.f31721a = (iM48229d * 2) / 3;
        } else {
            this.f31721a = iM48229d;
        }
        this.f31722b = iM48229d;
    }

    /* renamed from: a */
    private void m38709a(Context context) {
        m38712b(context);
        this.f31734n = new Handler(Looper.myLooper());
        this.f31733m = new AbstractActivityC6902b.a();
        AbstractC7741ao.m47537a(context, this.f31733m, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), "android.permission.WRITE_SECURE_SETTINGS", null);
    }

    /* renamed from: b */
    private boolean m38713b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    /* renamed from: a */
    private void m38710a(Intent intent) {
        String str;
        if (intent == null) {
            str = "intent is null";
        } else {
            SafeIntent safeIntent = new SafeIntent(intent);
            String stringExtra = safeIntent.getStringExtra(Constants.CONTENT_KEY);
            this.f31723c = safeIntent.getIntExtra("download_source", 1);
            ContentRecord contentRecord = (ContentRecord) AbstractC7758be.m47739b(stringExtra, ContentRecord.class, new Class[0]);
            this.f31728h = contentRecord;
            if (contentRecord != null && contentRecord.m41484af() != null) {
                AppInfo appInfoM41484af = this.f31728h.m41484af();
                if (safeIntent.hasExtra("unique_id")) {
                    String stringExtra2 = safeIntent.getStringExtra("unique_id");
                    this.f31729i = stringExtra2;
                    this.f31728h.m41612v(stringExtra2);
                }
                int iM48335k = AbstractC7811dd.m48335k(this);
                AbstractC7811dd.m48290a(this, iM48335k);
                m38719a(iM48335k);
                int appActivateStyle = HiAd.getInstance(this).getAppActivateStyle();
                int iM44420p = appInfoM41484af.m44420p();
                if (m38713b(appActivateStyle)) {
                    this.f31736q = appActivateStyle;
                } else if (m38713b(iM44420p)) {
                    this.f31736q = iM44420p;
                } else {
                    this.f31736q = 1;
                }
                int i10 = this.f31736q;
                if (i10 == 1) {
                    m38716d();
                } else if (i10 == 2) {
                    m38717e();
                }
                m38709a((Context) this);
                this.f31732l = new C6922c(this);
                C6920a c6920a = new C6920a();
                c6920a.m38870b(AbstractC7806cz.m48153a(Integer.valueOf(this.f31736q)));
                this.f31732l.mo39078a(this.f31728h, "5", c6920a);
                if (this.f31735o) {
                    this.f31732l.mo39078a(this.f31728h, "4", c6920a);
                    this.f31735o = false;
                    return;
                }
                return;
            }
            str = "contentRecord or appInfo is null";
        }
        AbstractC7185ho.m43820b("PPSFullScreenNotifyActivity", str);
        finish();
    }
}
