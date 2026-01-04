package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7162gs;
import com.huawei.openalliance.p169ad.C7174hd;
import com.huawei.openalliance.p169ad.InterfaceC7163gt;
import com.huawei.openalliance.p169ad.InterfaceC7175he;
import com.huawei.openalliance.p169ad.InterfaceC7176hf;
import com.huawei.openalliance.p169ad.activity.PPSActivity;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.views.PPSWebView;
import com.huawei.openalliance.p169ad.views.VideoView;
import com.huawei.openalliance.p169ad.views.ViewOnClickListenerC8081d;
import com.huawei.openalliance.p169ad.views.linkscroll.LinkScrollView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.linked.view.c */
/* loaded from: classes2.dex */
public class C7398c extends RelativeLayout implements InterfaceC7175he {

    /* renamed from: a */
    private C7162gs f34396a;

    /* renamed from: b */
    private InterfaceC7176hf f34397b;

    /* renamed from: c */
    private List<View> f34398c;

    /* renamed from: d */
    private LinkedAppDetailView f34399d;

    /* renamed from: e */
    private LinkScrollView f34400e;

    /* renamed from: f */
    private ViewOnClickListenerC8081d f34401f;

    /* renamed from: g */
    private int f34402g;

    /* renamed from: h */
    private final View.OnClickListener f34403h;

    /* renamed from: i */
    private a f34404i;

    /* renamed from: j */
    private final MediaErrorListener f34405j;

    /* renamed from: com.huawei.openalliance.ad.linked.view.c$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.c$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd linkedVideoControlBridge = C7398c.this.f34397b.getLinkedVideoControlBridge();
            if (linkedVideoControlBridge != null) {
                linkedVideoControlBridge.m43787y();
                linkedVideoControlBridge.m43785w();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.c$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7398c c7398c = C7398c.this;
            c7398c.f34402g = c7398c.f34401f.getHeight();
            if (C7398c.this.f34402g > 0) {
                C7398c.this.f34400e.setPaddingRelative(0, C7398c.this.f34402g, 0, 0);
                C7398c.this.f34400e.setBarHeight(C7398c.this.f34402g);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.c$4 */
    public class AnonymousClass4 implements a {
        public AnonymousClass4() {
        }

        @Override // com.huawei.openalliance.p169ad.linked.view.C7398c.a
        /* renamed from: a */
        public void mo45592a() {
            AbstractC7185ho.m43817a("LinkedLandView", "onVideoComplete");
            if (C7398c.this.f34396a != null) {
                if ((C7398c.this.f34396a.mo43628j() == 1 || C7398c.this.f34396a.mo43628j() == 18) && C7398c.this.f34397b != null) {
                    C7398c.this.f34397b.mo43798i();
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.linked.view.C7398c.a
        /* renamed from: a */
        public void mo45593a(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
            AbstractC7185ho.m43824c("LinkedLandView", "onError, code: %s", Integer.valueOf(i11));
            if (C7398c.this.f34400e != null) {
                C7398c.this.f34400e.scrollTo(0, 0);
            }
            if (C7398c.this.f34397b != null) {
                C7398c.this.f34397b.mo43798i();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.c$5 */
    public class AnonymousClass5 implements MediaErrorListener {
        public AnonymousClass5() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
        public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
            if (C7398c.this.f34397b != null) {
                C7398c.this.f34397b.mo43798i();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.linked.view.c$a */
    public interface a {
        /* renamed from: a */
        void mo45592a();

        /* renamed from: a */
        void mo45593a(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12);
    }

    public C7398c(Context context) {
        super(context);
        this.f34403h = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.linked.view.c.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.f34404i = new a() { // from class: com.huawei.openalliance.ad.linked.view.c.4
            public AnonymousClass4() {
            }

            @Override // com.huawei.openalliance.p169ad.linked.view.C7398c.a
            /* renamed from: a */
            public void mo45592a() {
                AbstractC7185ho.m43817a("LinkedLandView", "onVideoComplete");
                if (C7398c.this.f34396a != null) {
                    if ((C7398c.this.f34396a.mo43628j() == 1 || C7398c.this.f34396a.mo43628j() == 18) && C7398c.this.f34397b != null) {
                        C7398c.this.f34397b.mo43798i();
                    }
                }
            }

            @Override // com.huawei.openalliance.p169ad.linked.view.C7398c.a
            /* renamed from: a */
            public void mo45593a(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                AbstractC7185ho.m43824c("LinkedLandView", "onError, code: %s", Integer.valueOf(i11));
                if (C7398c.this.f34400e != null) {
                    C7398c.this.f34400e.scrollTo(0, 0);
                }
                if (C7398c.this.f34397b != null) {
                    C7398c.this.f34397b.mo43798i();
                }
            }
        };
        this.f34405j = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.linked.view.c.5
            public AnonymousClass5() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                if (C7398c.this.f34397b != null) {
                    C7398c.this.f34397b.mo43798i();
                }
            }
        };
        m45578b(context);
    }

    /* renamed from: f */
    private void m45583f() {
        List<View> list = this.f34398c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.f34398c) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    /* renamed from: g */
    private void m45584g() {
        ArrayList arrayList = new ArrayList();
        InterfaceC7176hf interfaceC7176hf = this.f34397b;
        if (interfaceC7176hf instanceof C7397b) {
            arrayList.add((C7397b) interfaceC7176hf);
        }
        this.f34398c = arrayList;
        m45576a(arrayList);
    }

    private void setNativeVideoViewClickable(InterfaceC7176hf interfaceC7176hf) {
        if (interfaceC7176hf instanceof C7397b) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((C7397b) interfaceC7176hf);
            m45576a(arrayList);
        }
    }

    private void setviewGroupclickListener(ViewGroup viewGroup) {
        AbstractC7185ho.m43820b("LinkedLandView", "setviewGroupclickListener");
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.linked.view.c.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C7174hd linkedVideoControlBridge = C7398c.this.f34397b.getLinkedVideoControlBridge();
                if (linkedVideoControlBridge != null) {
                    linkedVideoControlBridge.m43787y();
                    linkedVideoControlBridge.m43785w();
                }
            }
        });
    }

    public InterfaceC7176hf getLinkedNativeVideoView() {
        return this.f34397b;
    }

    public C7162gs getNativeAd() {
        return this.f34396a;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
    }

    public void setPlayModeChangeListener(PPSActivity.InterfaceC6882b interfaceC6882b) {
        InterfaceC7176hf interfaceC7176hf = this.f34397b;
        if (interfaceC7176hf instanceof C7397b) {
            ((C7397b) interfaceC7176hf).setPlayModeChangeListener(interfaceC6882b);
        }
    }

    /* renamed from: e */
    private void m45582e() {
        InterfaceC7176hf interfaceC7176hf = this.f34397b;
        if (interfaceC7176hf != null) {
            interfaceC7176hf.mo43796g();
        }
        m45583f();
    }

    /* renamed from: b */
    public void m45589b() {
        InterfaceC7176hf interfaceC7176hf = this.f34397b;
        if (interfaceC7176hf instanceof C7397b) {
            ((C7397b) interfaceC7176hf).m45565f();
        }
    }

    /* renamed from: c */
    public void m45590c() {
        InterfaceC7176hf interfaceC7176hf = this.f34397b;
        if (interfaceC7176hf != null) {
            ((C7397b) interfaceC7176hf).m45564e();
        }
    }

    /* renamed from: d */
    public void m45591d() {
        LinkScrollView linkScrollView = this.f34400e;
        if (linkScrollView != null) {
            linkScrollView.m50344a();
            this.f34400e = null;
        }
    }

    /* renamed from: b */
    private void m45578b(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_linked_land_view, this);
        this.f34400e = (LinkScrollView) findViewById(C6849R.id.hiad_landpage_scroll_view);
    }

    /* renamed from: a */
    public void m45585a() {
        m45582e();
    }

    /* renamed from: a */
    public void m45586a(Context context) {
        this.f34397b = new C7397b(context);
        ViewGroup viewGroup = (ViewGroup) findViewById(C6849R.id.linked_native_view);
        m45575a(context, viewGroup);
        InterfaceC7176hf interfaceC7176hf = this.f34397b;
        if (interfaceC7176hf instanceof C7397b) {
            viewGroup.addView((C7397b) interfaceC7176hf);
            ((C7397b) this.f34397b).setVideoReleaseListener(this.f34404i);
            this.f34397b.setLinkedLandView(this);
            this.f34397b.setLinkedNativeAd(this.f34396a);
            setNativeVideoViewClickable(this.f34397b);
            this.f34399d = this.f34397b.mo43797h();
        }
        m45584g();
    }

    /* renamed from: a */
    private void m45575a(Context context, ViewGroup viewGroup) {
        C7162gs c7162gs = this.f34396a;
        if (c7162gs == null || c7162gs.m43624f() == null || this.f34396a.m43624f().getVideoRatio() == null) {
            return;
        }
        Float videoRatio = this.f34396a.m43624f().getVideoRatio();
        if (videoRatio.floatValue() >= 1.0f) {
            return;
        }
        VideoView videoView = this.f34397b.getVideoView();
        float fM48215b = AbstractC7807d.m48215b(context) / 1.7777778f;
        float fFloatValue = videoRatio.floatValue() * fM48215b;
        ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
        layoutParams.width = (int) fFloatValue;
        layoutParams.height = (int) fM48215b;
        videoView.setLayoutParams(layoutParams);
        this.f34397b.setVideoView(videoView);
        setviewGroupclickListener(viewGroup);
    }

    /* renamed from: a */
    public void m45587a(InterfaceC7163gt interfaceC7163gt) {
        AbstractC7185ho.m43817a("LinkedLandView", "registerLinkedAd");
        if (interfaceC7163gt instanceof C7162gs) {
            this.f34396a = (C7162gs) interfaceC7163gt;
            String strMo43623e = interfaceC7163gt.mo43623e();
            InterfaceC7176hf interfaceC7176hf = this.f34397b;
            if (interfaceC7176hf != null) {
                interfaceC7176hf.mo43795b(strMo43623e);
            }
            LinkedAppDetailView linkedAppDetailView = this.f34399d;
            if (linkedAppDetailView != null) {
                linkedAppDetailView.m45501a(strMo43623e);
            }
        }
        m45586a(getContext());
    }

    /* renamed from: a */
    public void m45588a(PPSWebView pPSWebView) {
        AbstractC7185ho.m43817a("LinkedLandView", "registerPPSWebView");
        FrameLayout frameLayout = (FrameLayout) findViewById(C6849R.id.linked_pps_web_view);
        ViewOnClickListenerC8081d customEmuiActionBar = pPSWebView.getCustomEmuiActionBar();
        this.f34401f = customEmuiActionBar;
        if (customEmuiActionBar != null) {
            try {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10, -1);
                layoutParams.addRule(2, C6849R.id.linked_native_view);
                addView(this.f34401f, layoutParams);
                this.f34401f.post(new Runnable() { // from class: com.huawei.openalliance.ad.linked.view.c.3
                    public AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7398c c7398c = C7398c.this;
                        c7398c.f34402g = c7398c.f34401f.getHeight();
                        if (C7398c.this.f34402g > 0) {
                            C7398c.this.f34400e.setPaddingRelative(0, C7398c.this.f34402g, 0, 0);
                            C7398c.this.f34400e.setBarHeight(C7398c.this.f34402g);
                        }
                    }
                });
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("LinkedLandView", "setCustomeActionBar error: %s", th2.getClass().getSimpleName());
            }
        }
        frameLayout.addView(pPSWebView);
        this.f34400e.setWebView(pPSWebView.findViewById(C6849R.id.hiad_webview));
    }

    /* renamed from: a */
    private void m45576a(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof C7397b) {
                ((C7397b) view).setCoverClickListener(this.f34403h);
            } else if (view != null) {
                view.setOnClickListener(this.f34403h);
            }
        }
    }
}
