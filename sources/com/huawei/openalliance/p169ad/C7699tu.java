package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import com.huawei.openalliance.p169ad.views.dsa.DomesticDsaView;

/* renamed from: com.huawei.openalliance.ad.tu */
/* loaded from: classes8.dex */
public class C7699tu extends AbstractC7696tr {

    /* renamed from: com.huawei.openalliance.ad.tu$a */
    public class a implements InterfaceC7179hi {
        private a() {
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7179hi
        /* renamed from: a */
        public void mo38609a() {
            C7699tu.this.m47299c();
        }

        public /* synthetic */ a(C7699tu c7699tu, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public C7699tu(Context context, int[] iArr, int[] iArr2, int i10) {
        super(context, iArr, iArr2, i10);
    }

    /* renamed from: m */
    private void m47327m() {
        a aVar = new a();
        AbstractC8104h abstractC8104h = this.f35724h;
        if (abstractC8104h instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h).setDsaJumpListener(aVar);
        }
        AbstractC8104h abstractC8104h2 = this.f35723g;
        if (abstractC8104h2 instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h2).setDsaJumpListener(aVar);
        }
    }

    /* renamed from: a */
    public int m47328a(int i10, int i11) {
        int i12 = this.f35726j;
        int i13 = (this.f35717a - i12) - i10;
        if (i11 < i12) {
            i11 = i12;
        }
        return i11 > i13 ? i13 : i11;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7696tr
    /* renamed from: d */
    public void mo47300d() {
        this.f35722f = 16.0f;
        super.mo47300d();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    @Override // com.huawei.openalliance.p169ad.AbstractC7696tr
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo47301e() {
        /*
            r5 = this;
            boolean r0 = r5.m47302f()
            if (r0 != 0) goto La
            r5.m47299c()
            return
        La:
            android.content.Context r0 = r5.f35732p
            r1 = 1108344832(0x42100000, float:36.0)
            int r0 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47535a(r0, r1)
            java.lang.String r1 = r5.getScreenOrientation()
            boolean r2 = com.huawei.openalliance.p169ad.utils.AbstractC7811dd.m48315c()
            r3 = 1086324736(0x40c00000, float:6.0)
            r4 = 0
            if (r2 == 0) goto L86
            java.lang.String r2 = "1"
            boolean r1 = java.util.Objects.equals(r1, r2)
            if (r1 == 0) goto L3f
            int[] r1 = r5.f35720d
            r1 = r1[r4]
            int[] r2 = r5.f35721e
            r2 = r2[r4]
        L2f:
            int r1 = r1 + r2
            android.content.Context r2 = r5.f35732p
            int r2 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47535a(r2, r3)
            int r1 = r1 - r2
            int r2 = r0 / 2
        L39:
            int r1 = r1 - r2
            int r4 = r5.m47328a(r0, r1)
            goto L8f
        L3f:
            android.content.Context r1 = r5.f35732p
            int r1 = com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48255r(r1)
            r2 = 1
            if (r1 != r2) goto L62
            int[] r1 = r5.f35720d
            r1 = r1[r4]
            int[] r2 = r5.f35721e
            r2 = r2[r4]
            int r1 = r1 + r2
            android.content.Context r2 = r5.f35732p
            int r2 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47535a(r2, r3)
            int r1 = r1 - r2
            int r2 = r0 / 2
            int r1 = r1 - r2
            android.content.Context r2 = r5.f35732p
            int r2 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47583h(r2)
            goto L39
        L62:
            android.content.Context r1 = r5.f35732p
            int r1 = com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48255r(r1)
            if (r1 != 0) goto L8f
            int[] r1 = r5.f35720d
            r1 = r1[r4]
            int[] r2 = r5.f35721e
            r2 = r2[r4]
            int r1 = r1 + r2
            android.content.Context r2 = r5.f35732p
            int r2 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47535a(r2, r3)
            int r1 = r1 - r2
            int r2 = r0 / 2
            int r1 = r1 - r2
            android.content.Context r2 = r5.f35732p
            int r2 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47583h(r2)
            int r2 = r2 * 2
            goto L39
        L86:
            int[] r1 = r5.f35720d
            r1 = r1[r4]
            int[] r2 = r5.f35721e
            r2 = r2[r4]
            goto L2f
        L8f:
            boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7811dd.m48315c()
            android.widget.ImageView r5 = r5.f35731o
            if (r0 == 0) goto L9d
            int r0 = -r4
            float r0 = (float) r0
        L99:
            r5.setX(r0)
            goto L9f
        L9d:
            float r0 = (float) r4
            goto L99
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7699tu.mo47301e():void");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7696tr
    public int getLayoutId() {
        return m47303g() ? C6849R.layout.hiad_transparency_dialog_splash : C7845x.m48605t(getContext()) ? C6849R.layout.hiad_transparency_dialog_tv : C6849R.layout.hiad_transparency_dialog;
    }

    public String getScreenOrientation() {
        this.f35717a = AbstractC7807d.m48215b(this.f35732p);
        int iM48202a = AbstractC7807d.m48202a(this.f35732p);
        this.f35718b = iM48202a;
        return this.f35717a > iM48202a ? "2" : "1";
    }

    /* renamed from: k */
    public void m47330k() {
        AbstractC8104h abstractC8104h = this.f35725i;
        if (abstractC8104h instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h).m50107b();
        }
    }

    /* renamed from: l */
    public void m47331l() {
        AbstractC8104h abstractC8104h = this.f35725i;
        if (abstractC8104h instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h).m50105a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("PPSTransparencyDialog", "onDetachedFromWindow");
        m47299c();
    }

    public C7699tu(Context context, int[] iArr, int[] iArr2, Boolean bool) {
        super(context, iArr, iArr2, bool);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7696tr
    /* renamed from: a */
    public void mo47289a() {
        this.f35719c = (RelativeLayout) findViewById(C6849R.id.haid_transparency_dialog_root);
        this.f35727k = findViewById(C6849R.id.margin_view);
        this.f35728l = findViewById(C6849R.id.anchor_view);
        this.f35723g = (AbstractC8104h) findViewById(C6849R.id.top_dsa_view);
        this.f35729m = (ImageView) findViewById(C6849R.id.top_dsa_iv);
        this.f35724h = (AbstractC8104h) findViewById(C6849R.id.bottom_dsa_view);
        this.f35730n = (ImageView) findViewById(C6849R.id.bottom_dsa_iv);
        m47327m();
    }

    /* renamed from: a */
    public void m47329a(boolean z10, Integer num, InterfaceC7328jb interfaceC7328jb) {
        AbstractC8104h abstractC8104h = this.f35725i;
        if (abstractC8104h instanceof DomesticDsaView) {
            ((DomesticDsaView) abstractC8104h).m50106a(z10, num, interfaceC7328jb);
        }
    }
}
