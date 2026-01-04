package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC6998co;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.RunnableC8189vk;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8111d;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.views.s */
/* loaded from: classes2.dex */
public class C8149s extends RelativeLayout {

    /* renamed from: a */
    private Context f38094a;

    /* renamed from: b */
    private InterfaceC7146gc f38095b;

    /* renamed from: c */
    private AdLandingPageData f38096c;

    /* renamed from: d */
    private AppInfo f38097d;

    /* renamed from: e */
    private String f38098e;

    /* renamed from: f */
    private MetaData f38099f;

    /* renamed from: g */
    private View f38100g;

    /* renamed from: h */
    private AppDownloadButton f38101h;

    /* renamed from: i */
    private INonwifiActionListener f38102i;

    /* renamed from: j */
    private ImageView f38103j;

    /* renamed from: k */
    private TextView f38104k;

    /* renamed from: l */
    private TextView f38105l;

    /* renamed from: m */
    private boolean f38106m;

    /* renamed from: n */
    private String f38107n;

    /* renamed from: o */
    private InterfaceC8111d f38108o;

    /* renamed from: p */
    private InterfaceC6998co f38109p;

    /* renamed from: q */
    private int f38110q;

    /* renamed from: r */
    private boolean f38111r;

    /* renamed from: s */
    private SixElementsView f38112s;

    /* renamed from: t */
    private ContentRecord f38113t;

    /* renamed from: u */
    private boolean f38114u;

    /* renamed from: v */
    private boolean f38115v;

    /* renamed from: w */
    private View.OnTouchListener f38116w;

    public C8149s(Context context, int i10, ContentRecord contentRecord) {
        super(context);
        this.f38106m = true;
        this.f38111r = true;
        this.f38114u = true;
        this.f38115v = false;
        this.f38116w = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.s.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43818a("PPSRewardEndCardView", "action:%s", Integer.valueOf(motionEvent.getAction()));
                if (C8149s.this.f38101h != null && motionEvent.getAction() == 1) {
                    if (C8149s.this.f38106m) {
                        C8149s.this.f38108o.mo48626a(C8149s.this.f38106m, true, AppStatus.INSTALLED == C8149s.this.f38101h.getStatus() ? "app" : "", false);
                    } else if (C8149s.this.f38108o != null) {
                        C8149s.this.f38108o.mo48626a(false, false, "web", false);
                    }
                }
                return true;
            }
        };
        m50481a(context, i10, contentRecord);
    }

    /* renamed from: f */
    private boolean m50490f() {
        int iM41388C = this.f38113t.m41388C();
        AppInfo appInfoM41484af = this.f38113t.m41484af();
        if (iM41388C == 0 || iM41388C == 1 || iM41388C == 2) {
            return false;
        }
        if ((iM41388C == 3 || iM41388C == 5) && appInfoM41484af != null && !C7830i.m48419a(getContext(), appInfoM41484af.getPackageName())) {
            return false;
        }
        this.f38115v = true;
        return true;
    }

    private String getImageUrl() {
        ImageInfo imageInfo;
        MetaData metaData = this.f38099f;
        if (metaData == null) {
            return null;
        }
        List<ImageInfo> listM40315g = metaData.m40315g();
        if (AbstractC7760bg.m47767a(listM40315g) || TextUtils.isEmpty(listM40315g.get(0).m40180c())) {
            List<ImageInfo> listM40334p = this.f38099f.m40334p();
            if (AbstractC7760bg.m47767a(listM40334p)) {
                return null;
            }
            imageInfo = listM40334p.get(0);
        } else {
            imageInfo = listM40315g.get(0);
        }
        return imageInfo.m40180c();
    }

    /* renamed from: a */
    public void m50496a() {
        m50482a(this.f38103j, this.f38098e);
        View view = this.f38100g;
        if (view != null) {
            view.setVisibility(0);
        }
        SixElementsView sixElementsView = this.f38112s;
        if (sixElementsView != null) {
            sixElementsView.m49942a(this.f38115v);
        }
    }

    public void setAdLandingPageData(AdLandingPageData adLandingPageData) {
        String str;
        if (adLandingPageData == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("PPSRewardEndCardView", "set ad landing data.");
            this.f38096c = adLandingPageData;
            this.f38097d = adLandingPageData.getAppInfo();
            MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.f38096c.m44319t(), MetaData.class, new Class[0]);
            this.f38099f = metaData;
            if (metaData != null) {
                this.f38107n = AbstractC7806cz.m48168c(metaData.m40280a());
            }
            this.f38111r = adLandingPageData.m44252A();
            m50489e();
        } catch (RuntimeException unused) {
            str = "setAdLandingPageData RuntimeException.";
            AbstractC7185ho.m43823c("PPSRewardEndCardView", str);
        } catch (Exception unused2) {
            str = "setAdLandingPageDate error.";
            AbstractC7185ho.m43823c("PPSRewardEndCardView", str);
        }
    }

    public void setAppRelated(boolean z10) {
        this.f38106m = z10;
        m50500c();
    }

    public void setButtonAndSixElementsClickInfo(MaterialClickInfo materialClickInfo) {
        AppDownloadButton appDownloadButton = this.f38101h;
        if (appDownloadButton != null) {
            appDownloadButton.m48702a(materialClickInfo);
        }
        SixElementsView sixElementsView = this.f38112s;
        if (sixElementsView != null) {
            sixElementsView.setOrgClickInfo(materialClickInfo);
        }
    }

    public void setEndCardClickListener(InterfaceC8111d interfaceC8111d) {
        this.f38108o = interfaceC8111d;
    }

    public void setInterType(int i10) {
        this.f38110q = i10;
    }

    public void setOnNonWifiDownloadListener(INonwifiActionListener iNonwifiActionListener) {
        this.f38102i = iNonwifiActionListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0092  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m50489e() {
        /*
            r3 = this;
            boolean r0 = r3.f38106m
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "PPSRewardEndCardView"
            java.lang.String r2 = "refresh UI, isAppRelated: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r1, r2, r0)
            boolean r0 = r3.f38106m
            if (r0 == 0) goto L40
            android.widget.TextView r0 = r3.f38104k
            com.huawei.openalliance.ad.inter.data.AppInfo r1 = r3.f38097d
            java.lang.String r1 = r1.getAppName()
            r3.m50483a(r0, r1)
            android.widget.TextView r0 = r3.f38105l
            com.huawei.openalliance.ad.inter.data.AppInfo r1 = r3.f38097d
            java.lang.String r1 = r1.getAppDesc()
            r3.m50483a(r0, r1)
            com.huawei.openalliance.ad.inter.data.AppInfo r0 = r3.f38097d
            java.lang.String r0 = r0.getIconUrl()
            r3.f38098e = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L61
        L39:
            java.lang.String r0 = r3.getImageUrl()
            r3.f38098e = r0
            goto L61
        L40:
            com.huawei.openalliance.ad.beans.metadata.MetaData r0 = r3.f38099f
            if (r0 == 0) goto L39
            android.widget.TextView r1 = r3.f38104k
            java.lang.String r0 = r0.m40309e()
            java.lang.String r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48168c(r0)
            r3.m50483a(r1, r0)
            android.widget.TextView r0 = r3.f38105l
            com.huawei.openalliance.ad.beans.metadata.MetaData r1 = r3.f38099f
            java.lang.String r1 = r1.m40312f()
            java.lang.String r1 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48168c(r1)
            r3.m50483a(r0, r1)
            goto L39
        L61:
            com.huawei.openalliance.ad.views.SixElementsView r0 = r3.f38112s
            r1 = 8
            r0.setTitleTextVisibility(r1)
            com.huawei.openalliance.ad.views.SixElementsView r0 = r3.f38112s
            com.huawei.openalliance.ad.inter.data.AdLandingPageData r1 = r3.f38096c
            r0.mo49855a(r1)
            android.view.View r0 = r3.f38100g
            android.view.View$OnTouchListener r1 = r3.f38116w
            r0.setOnTouchListener(r1)
            com.huawei.openalliance.ad.views.AppDownloadButton r0 = r3.f38101h
            com.huawei.openalliance.ad.inter.data.AdLandingPageData r1 = r3.f38096c
            r0.setAdLandingPageData(r1)
            com.huawei.openalliance.ad.co r0 = r3.f38109p
            boolean r0 = r0.mo41178g()
            if (r0 == 0) goto L92
            com.huawei.openalliance.ad.views.AppDownloadButton r0 = r3.f38101h
            com.huawei.openalliance.ad.views.ExtandAppDownloadButtonStyleHm r1 = new com.huawei.openalliance.ad.views.ExtandAppDownloadButtonStyleHm
            android.content.Context r2 = r3.f38094a
            r1.<init>(r2)
        L8e:
            r0.setAppDownloadButtonStyle(r1)
            goto L9c
        L92:
            com.huawei.openalliance.ad.views.AppDownloadButton r0 = r3.f38101h
            com.huawei.openalliance.ad.views.ExtandAppDownloadButtonStyle r1 = new com.huawei.openalliance.ad.views.ExtandAppDownloadButtonStyle
            android.content.Context r2 = r3.f38094a
            r1.<init>(r2)
            goto L8e
        L9c:
            com.huawei.openalliance.ad.views.AppDownloadButton r0 = r3.f38101h
            com.huawei.openalliance.ad.views.s$1 r1 = new com.huawei.openalliance.ad.views.s$1
            r1.<init>()
            r0.setButtonTextWatcherInner(r1)
            com.huawei.openalliance.ad.views.AppDownloadButton r0 = r3.f38101h
            com.huawei.openalliance.ad.views.s$2 r1 = new com.huawei.openalliance.ad.views.s$2
            r1.<init>()
            r0.setOnNonWifiDownloadListener(r1)
            com.huawei.openalliance.ad.views.AppDownloadButton r0 = r3.f38101h
            r1 = 5
            r0.setSource(r1)
            r3.m50493g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.C8149s.m50489e():void");
    }

    /* renamed from: g */
    private void m50493g() {
        if (this.f38106m) {
            this.f38101h.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.openalliance.ad.views.s.4
                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                /* renamed from: a */
                public void mo30555a(AppDownloadButton appDownloadButton) {
                    if (C8149s.this.f38108o != null) {
                        String str = C8149s.this.f38110q == 9 ? ClickDestination.HARMONY_SERVICE : "web";
                        if (AppStatus.INSTALLED == appDownloadButton.getStatus()) {
                            str = "app";
                        }
                        C8149s.this.f38108o.mo48626a(C8149s.this.f38106m, false, str, true);
                    }
                }

                @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
                /* renamed from: b */
                public void mo30556b(AppDownloadButton appDownloadButton) {
                    if (C8149s.this.f38108o != null) {
                        C8149s.this.f38108o.mo48626a(C8149s.this.f38106m, true, AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : "", true);
                    }
                }
            });
        } else {
            this.f38101h.m49965a(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.s.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C8149s.this.f38108o != null) {
                        C8149s.this.f38108o.mo48626a(false, false, C8149s.this.f38110q == 9 ? ClickDestination.HARMONY_SERVICE : "web", false);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m50497a(long j10) {
        AppDownloadButton appDownloadButton = this.f38101h;
        if (appDownloadButton != null) {
            appDownloadButton.updateStartShowTime(j10);
        }
    }

    /* renamed from: b */
    public void m50499b() {
        View view = this.f38100g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: c */
    public void m50500c() {
        AppDownloadButton appDownloadButton = this.f38101h;
        if (appDownloadButton != null) {
            appDownloadButton.setClickable(false);
        }
    }

    /* renamed from: d */
    public void m50501d() {
        AppDownloadButton appDownloadButton = this.f38101h;
        if (appDownloadButton != null) {
            appDownloadButton.performClick();
        }
    }

    /* renamed from: a */
    private void m50481a(Context context, int i10, ContentRecord contentRecord) {
        View view;
        int i11;
        this.f38094a = context;
        this.f38113t = contentRecord;
        this.f38095b = C7124fh.m43316b(context);
        boolean zMo41175d = C6982bz.m41148a(context).mo41175d();
        this.f38114u = zMo41175d;
        if (zMo41175d && m50490f()) {
            this.f38100g = View.inflate(context, 1 == i10 ? C6849R.layout.hiad_reward_endcard : C6849R.layout.hiad_reward_land_endcard, this);
            view = this.f38100g;
            i11 = C6849R.id.reward_end_card_six_elements_with_jump;
        } else {
            this.f38100g = View.inflate(context, 1 == i10 ? C6849R.layout.hiad_reward_six_elements_endcard : C6849R.layout.hiad_reward_six_elements_land_endcard, this);
            view = this.f38100g;
            i11 = C6849R.id.reward_end_card_six_elements;
        }
        this.f38112s = (SixElementsView) view.findViewById(i11);
        this.f38103j = (ImageView) this.f38100g.findViewById(C6849R.id.endcard_icon);
        this.f38104k = (TextView) this.f38100g.findViewById(C6849R.id.endcard_title);
        this.f38105l = (TextView) this.f38100g.findViewById(C6849R.id.endcard_desc);
        this.f38101h = (AppDownloadButton) this.f38100g.findViewById(C6849R.id.endcard_download_btn);
        if (AbstractC7741ao.m47592n(context)) {
            this.f38104k.setTextSize(1, 36.0f);
            this.f38105l.setTextSize(1, 28.0f);
        }
        this.f38109p = C6982bz.m41148a(this.f38094a.getApplicationContext());
    }

    /* renamed from: a */
    private void m50482a(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        AbstractC7185ho.m43821b("PPSRewardEndCardView", "load app icon: %s", AbstractC7806cz.m48174f(str));
        AbstractC7834m.m48484d(new RunnableC8189vk(this.f38094a, str, imageView, Boolean.valueOf(this.f38106m)));
    }

    /* renamed from: a */
    private void m50483a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    /* renamed from: a */
    public void m50498a(String str) {
        AppDownloadButton appDownloadButton = this.f38101h;
        if (appDownloadButton != null) {
            appDownloadButton.updateContent(str);
        }
    }
}
