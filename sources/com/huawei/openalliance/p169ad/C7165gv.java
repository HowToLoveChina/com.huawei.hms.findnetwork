package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7752az;

/* renamed from: com.huawei.openalliance.ad.gv */
/* loaded from: classes8.dex */
public class C7165gv extends AbstractC7493na<InterfaceC7176hf> implements InterfaceC7166gw<InterfaceC7176hf> {

    /* renamed from: h */
    private boolean f32983h;

    /* renamed from: com.huawei.openalliance.ad.gv$1 */
    public class AnonymousClass1 implements C7752az.a {

        /* renamed from: a */
        final /* synthetic */ ImageInfo f32984a;

        /* renamed from: com.huawei.openalliance.ad.gv$1$1 */
        public class RunnableC144601 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Drawable f32986a;

            public RunnableC144601(Drawable drawable) {
                drawable = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((InterfaceC7176hf) C7165gv.this.mo45320d()).mo43793a(imageInfo, drawable);
            }
        }

        public AnonymousClass1(ImageInfo imageInfo) {
            imageInfo = imageInfo;
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30231a() {
            AbstractC7185ho.m43823c("NativeVideoP", "preview image load failed");
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30232a(Drawable drawable) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.gv.1.1

                /* renamed from: a */
                final /* synthetic */ Drawable f32986a;

                public RunnableC144601(Drawable drawable2) {
                    drawable = drawable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((InterfaceC7176hf) C7165gv.this.mo45320d()).mo43793a(imageInfo, drawable);
                }
            });
        }
    }

    public C7165gv(Context context, InterfaceC7176hf interfaceC7176hf) {
        super(context);
        this.f32983h = false;
        mo45316a((C7165gv) interfaceC7176hf);
        this.f34190b = new C7560ou(context, C7164gu.m43632a(context, interfaceC7176hf.getLinkedNativeAd()));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43634a() {
        InterfaceC7615qq interfaceC7615qq;
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null || (interfaceC7615qq = this.f34190b) == null) {
            return;
        }
        interfaceC7615qq.mo46585a(((AbstractC7493na) this).f34758d, contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: b */
    public void mo43641b() {
        InterfaceC7615qq interfaceC7615qq = this.f34190b;
        if (interfaceC7615qq == null) {
            return;
        }
        interfaceC7615qq.mo46620d();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: c */
    public void mo43642c() {
        InterfaceC7615qq interfaceC7615qq = this.f34190b;
        if (interfaceC7615qq == null) {
            return;
        }
        interfaceC7615qq.mo46622e();
    }

    /* renamed from: b */
    private void m43633b(ImageInfo imageInfo) {
        if (imageInfo == null) {
            AbstractC7185ho.m43820b("NativeVideoP", "image info null");
        } else {
            C7752az.m47690a(((AbstractC7493na) this).f34758d, imageInfo.getUrl(), new C7752az.a() { // from class: com.huawei.openalliance.ad.gv.1

                /* renamed from: a */
                final /* synthetic */ ImageInfo f32984a;

                /* renamed from: com.huawei.openalliance.ad.gv$1$1 */
                public class RunnableC144601 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Drawable f32986a;

                    public RunnableC144601(Drawable drawable2) {
                        drawable = drawable2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ((InterfaceC7176hf) C7165gv.this.mo45320d()).mo43793a(imageInfo, drawable);
                    }
                }

                public AnonymousClass1(ImageInfo imageInfo2) {
                    imageInfo = imageInfo2;
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30231a() {
                    AbstractC7185ho.m43823c("NativeVideoP", "preview image load failed");
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30232a(Drawable drawable2) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.gv.1.1

                        /* renamed from: a */
                        final /* synthetic */ Drawable f32986a;

                        public RunnableC144601(Drawable drawable22) {
                            drawable = drawable22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ((InterfaceC7176hf) C7165gv.this.mo45320d()).mo43793a(imageInfo, drawable);
                        }
                    });
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43635a(int i10, int i11) {
        if (this.f32983h) {
            return;
        }
        this.f32983h = true;
        new C6922c(((AbstractC7493na) this).f34758d).m39073a(this.f34189a, i10, i11);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43636a(long j10, long j11, long j12, long j13) {
        this.f34190b.mo46583a(j10, j11, (int) j12, (int) j13);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43637a(C7162gs c7162gs) {
        if (c7162gs == null) {
            this.f34189a = null;
            return;
        }
        ContentRecord contentRecordM43619a = c7162gs.m43619a();
        this.f34189a = contentRecordM43619a;
        if (contentRecordM43619a != null) {
            this.f34190b.mo46590a(contentRecordM43619a);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43638a(ImageInfo imageInfo) {
        AbstractC7185ho.m43823c("NativeVideoP", "checkPreviewImageHashAndLoad " + imageInfo);
        if (imageInfo == null) {
            return;
        }
        boolean zM44477b = imageInfo.m44477b(((AbstractC7493na) this).f34758d);
        AbstractC7185ho.m43821b("NativeVideoP", "imageInfo checkHash result %s", Boolean.valueOf(zM44477b));
        if (zM44477b) {
            m43633b(imageInfo);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43639a(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        ((InterfaceC7176hf) mo45320d()).mo43794a(videoInfo, videoInfo.m44570b(((AbstractC7493na) this).f34758d));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7166gw
    /* renamed from: a */
    public void mo43640a(boolean z10) {
        InterfaceC7615qq interfaceC7615qq = this.f34190b;
        if (interfaceC7615qq == null) {
            return;
        }
        interfaceC7615qq.mo46615b(z10);
    }
}
