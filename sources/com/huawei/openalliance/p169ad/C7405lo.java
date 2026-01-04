package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.lo */
/* loaded from: classes8.dex */
public class C7405lo implements InterfaceC7416lz {

    /* renamed from: a */
    private InterfaceC7413lw f34426a;

    /* renamed from: b */
    private InterfaceC7474mi f34427b;

    /* renamed from: c */
    private boolean f34428c;

    /* renamed from: d */
    private boolean f34429d = true;

    /* renamed from: e */
    private boolean f34430e = false;

    /* renamed from: f */
    private boolean f34431f = false;

    /* renamed from: g */
    private boolean f34432g = false;

    /* renamed from: h */
    private boolean f34433h = false;

    @Override // com.huawei.openalliance.p169ad.InterfaceC7416lz
    /* renamed from: a */
    public InterfaceC7474mi mo45604a() {
        return this.f34427b;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7416lz
    /* renamed from: b */
    public void mo45613b() {
        AbstractC7185ho.m43820b("OmPresent", "release");
        if (this.f34432g) {
            this.f34429d = true;
            this.f34430e = false;
            this.f34431f = false;
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw != null) {
                interfaceC7413lw.mo45637b();
            }
            InterfaceC7474mi interfaceC7474mi = this.f34427b;
            if (interfaceC7474mi != null) {
                interfaceC7474mi.mo45617d();
            }
            this.f34432g = false;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: c */
    public void mo45616c() {
        InterfaceC7474mi interfaceC7474mi = this.f34427b;
        if (interfaceC7474mi == null) {
            AbstractC7185ho.m43820b("OmPresent", "AdSessionAgent is null");
        } else {
            interfaceC7474mi.mo45616c();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: d */
    public void mo45617d() {
        InterfaceC7474mi interfaceC7474mi = this.f34427b;
        if (interfaceC7474mi == null) {
            return;
        }
        interfaceC7474mi.mo45617d();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7478mm
    /* renamed from: e */
    public void mo45618e() {
        AbstractC7185ho.m43820b("OmPresent", "impressionOccurred");
        if (this.f34431f) {
            return;
        }
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7408lr) {
            ((C7408lr) interfaceC7413lw).mo45618e();
            this.f34431f = true;
        }
        InterfaceC7413lw interfaceC7413lw2 = this.f34426a;
        if (interfaceC7413lw2 instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw2).m45651f();
            this.f34431f = true;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7478mm
    /* renamed from: f */
    public void mo45619f() {
        AbstractC7185ho.m43820b("OmPresent", "load");
        if (this.f34429d || !this.f34431f) {
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw instanceof C7408lr) {
                ((C7408lr) interfaceC7413lw).mo45619f();
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: g */
    public void mo45620g() {
        AbstractC7185ho.m43820b("OmPresent", "complete");
        if (this.f34429d || !this.f34430e) {
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw instanceof C7415ly) {
                ((C7415ly) interfaceC7413lw).mo45620g();
                this.f34430e = true;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: h */
    public void mo45621h() {
        if (this.f34429d || !this.f34430e) {
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw instanceof C7415ly) {
                ((C7415ly) interfaceC7413lw).mo45621h();
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: i */
    public void mo45622i() {
        if (this.f34429d || !this.f34430e) {
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw instanceof C7415ly) {
                ((C7415ly) interfaceC7413lw).mo45622i();
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: j */
    public void mo45623j() {
        AbstractC7185ho.m43820b("OmPresent", "skipped");
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45623j();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: k */
    public void mo45624k() {
        AbstractC7185ho.m43820b("OmPresent", VastAttribute.PAUSE);
        if (!this.f34429d && this.f34430e) {
            AbstractC7185ho.m43823c("OmPresent", "pause: Video completed");
            return;
        }
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45624k();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: l */
    public void mo45625l() {
        AbstractC7185ho.m43820b("OmPresent", "resume");
        if (!this.f34429d && this.f34430e) {
            AbstractC7185ho.m43823c("OmPresent", "resume: Video completed");
            return;
        }
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45625l();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45605a(float f10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("OmPresent", "onProgress, isAllowRepeat= %s, isVideoComplete= %s", Boolean.valueOf(this.f34429d), Boolean.valueOf(this.f34430e));
        }
        if (this.f34429d || !this.f34430e) {
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw instanceof C7415ly) {
                ((C7415ly) interfaceC7413lw).mo45605a(f10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: b */
    public void mo45614b(float f10) {
        if (!this.f34429d && this.f34430e) {
            AbstractC7185ho.m43823c("OmPresent", "volumeChange: Video completed");
            return;
        }
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45614b(f10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45606a(float f10, boolean z10) {
        AbstractC7185ho.m43820b("OmPresent", "start");
        if (!this.f34429d && this.f34430e) {
            AbstractC7185ho.m43823c("OmPresent", "start: Video completed");
            return;
        }
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45606a(f10, z10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: b */
    public void mo45615b(boolean z10) {
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45615b(z10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7416lz
    /* renamed from: a */
    public void mo45607a(Context context, ContentRecord contentRecord, InterfaceC7403lm interfaceC7403lm, boolean z10) {
        if ((contentRecord != null ? contentRecord.m41506b(context) : null) == null) {
            AbstractC7185ho.m43820b("OmPresent", "om is null, no initialization is required");
            return;
        }
        if (this.f34432g) {
            return;
        }
        AbstractC7185ho.m43820b("OmPresent", "init omPresent");
        this.f34427b = C7407lq.m45634a(context, contentRecord, interfaceC7403lm, z10);
        InterfaceC7413lw interfaceC7413lwM45638a = C7412lv.m45638a(contentRecord);
        this.f34426a = interfaceC7413lwM45638a;
        interfaceC7413lwM45638a.mo45636a(this.f34427b);
        this.f34428c = z10;
        this.f34432g = true;
        this.f34433h = false;
        this.f34431f = false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: a */
    public void mo45608a(View view) {
        if (this.f34428c) {
            return;
        }
        InterfaceC7474mi interfaceC7474mi = this.f34427b;
        if (interfaceC7474mi == null) {
            AbstractC7185ho.m43820b("OmPresent", "AdSessionAgent is null");
        } else {
            interfaceC7474mi.mo45608a(view);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7474mi
    /* renamed from: a */
    public void mo45609a(View view, EnumC7473mh enumC7473mh, String str) {
        InterfaceC7474mi interfaceC7474mi = this.f34427b;
        if (interfaceC7474mi == null) {
            return;
        }
        interfaceC7474mi.mo45609a(view, enumC7473mh, str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45610a(EnumC7480mo enumC7480mo) {
        InterfaceC7413lw interfaceC7413lw = this.f34426a;
        if (interfaceC7413lw instanceof C7415ly) {
            ((C7415ly) interfaceC7413lw).mo45610a(enumC7480mo);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7479mn
    /* renamed from: a */
    public void mo45611a(C7482mq c7482mq) {
        if (!this.f34429d && this.f34430e) {
            AbstractC7185ho.m43823c("OmPresent", "loaded: Video completed");
            return;
        }
        if (this.f34433h) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("OmPresent", "Already loaded");
            }
        } else {
            InterfaceC7413lw interfaceC7413lw = this.f34426a;
            if (interfaceC7413lw instanceof C7415ly) {
                ((C7415ly) interfaceC7413lw).mo45611a(c7482mq);
            }
            this.f34433h = true;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7416lz
    /* renamed from: a */
    public void mo45612a(boolean z10) {
        this.f34429d = z10;
    }
}
