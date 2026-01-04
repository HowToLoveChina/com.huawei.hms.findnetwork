package com.huawei.openalliance.p169ad.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterfaceC7179hi;
import com.huawei.openalliance.p169ad.InterfaceC7181hk;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import com.huawei.openalliance.p169ad.views.dsa.DomesticDsaView;

/* loaded from: classes8.dex */
public class DomesticDsaActivity extends ActivityC6901a {

    /* renamed from: q */
    private final ContentRecord f31642q = new ContentRecord();

    /* renamed from: r */
    private String f31643r;

    /* renamed from: com.huawei.openalliance.ad.activity.DomesticDsaActivity$a */
    public class C6862a implements InterfaceC7179hi {
        private C6862a() {
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7179hi
        /* renamed from: a */
        public void mo38609a() {
            DomesticDsaActivity.this.finish();
        }
    }

    /* renamed from: l */
    private void m38606l() {
        AbstractC8104h abstractC8104h = this.f31797j;
        if (abstractC8104h instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h).setDsaJumpListener(new C6862a());
        }
        AbstractC8104h abstractC8104h2 = this.f31798k;
        if (abstractC8104h2 instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h2).setDsaJumpListener(new C6862a());
        }
    }

    /* renamed from: m */
    private void m38607m() {
        RelativeLayout relativeLayout = this.f31792e;
        if (relativeLayout == null || this.f31797j == null || this.f31798k == null) {
            return;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.DomesticDsaActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DomesticDsaActivity.this.finish();
            }
        });
        this.f31797j.setViewClickListener(new InterfaceC7181hk() { // from class: com.huawei.openalliance.ad.activity.DomesticDsaActivity.2
            @Override // com.huawei.openalliance.p169ad.InterfaceC7181hk
            /* renamed from: a */
            public void mo38605a() {
                DomesticDsaActivity.this.finish();
            }
        });
        this.f31798k.setViewClickListener(new InterfaceC7181hk() { // from class: com.huawei.openalliance.ad.activity.DomesticDsaActivity.3
            @Override // com.huawei.openalliance.p169ad.InterfaceC7181hk
            /* renamed from: a */
            public void mo38605a() {
                DomesticDsaActivity.this.finish();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: c */
    public void mo38601c() {
        this.f31792e = (RelativeLayout) findViewById(C6849R.id.dsa_activity_root);
        this.f31793f = findViewById(C6849R.id.margin_view);
        this.f31794g = findViewById(C6849R.id.dsa_anchor_view);
        this.f31797j = (AbstractC8104h) findViewById(C6849R.id.top_dsa_view);
        this.f31800m = (ImageView) findViewById(C6849R.id.top_dsa_iv);
        this.f31798k = (AbstractC8104h) findViewById(C6849R.id.bottom_dsa_view);
        this.f31801n = (ImageView) findViewById(C6849R.id.bottom_dsa_iv);
        m38606l();
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: d */
    public int mo38602d() {
        return C6849R.layout.hiad_activity_dsa;
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: e */
    public void mo38603e() {
        m38779f();
        this.f31799l.m50256a(this.f31795h, this.f31796i);
        this.f31799l.setAdContent(this.f31642q);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void finish() {
        AbstractC7185ho.m43817a("DomesticDsaActivity", "finish");
        super.finish();
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: g */
    public void mo38608g() {
        int iM47535a = AbstractC7741ao.m47535a(this, 36.0f);
        int i10 = this.f31791d;
        int i11 = (this.f31788a - i10) - iM47535a;
        AbstractC7185ho.m43818a("DomesticDsaActivity", "mAnchorViewLoc: %s, mAnchorViewSize: %s", Integer.valueOf(this.f31795h[0]), Integer.valueOf(this.f31796i[0]));
        int iM47535a2 = ((this.f31795h[0] + this.f31796i[0]) - AbstractC7741ao.m47535a(this, 6.0f)) - (iM47535a / 2);
        if (iM47535a2 >= i10) {
            i10 = iM47535a2;
        }
        if (i10 <= i11) {
            i11 = i10;
        }
        this.f31802o.setX(AbstractC7811dd.m48315c() ? -i11 : i11);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: i */
    public boolean mo38604i() {
        this.f31643r = new SafeIntent(getIntent()).getStringExtra(MapKeyNames.DSA_URL);
        this.f31642q.m41551e(true);
        this.f31642q.m41420S(this.f31643r);
        return super.mo38604i();
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC7185ho.m43817a("DomesticDsaActivity", "onCreate");
        super.onCreate(bundle);
        m38607m();
    }
}
