package com.huawei.openalliance.p169ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterfaceC7181hk;
import com.huawei.openalliance.p169ad.ViewTreeObserverOnGlobalLayoutListenerC7177hg;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;

/* loaded from: classes8.dex */
public class ComplianceActivity extends ActivityC6901a {

    /* renamed from: q */
    private static InterfaceC6904d f31636q;

    /* renamed from: r */
    private final ContentRecord f31637r = new ContentRecord();

    /* renamed from: s */
    private boolean f31638s;

    /* renamed from: a */
    public static void m38595a(Context context, View view, ContentRecord contentRecord, boolean z10) {
        if (view == null) {
            return;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            AbstractC7185ho.m43821b("ComplianceActivity", "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC7177hg(view, context, iArr2));
            m38596a(context, iArr, new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()}, contentRecord, z10);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ComplianceActivity", "start Activity error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: l */
    public static void m38599l() {
        f31636q = null;
    }

    /* renamed from: m */
    private void m38600m() {
        RelativeLayout relativeLayout = this.f31792e;
        if (relativeLayout == null || this.f31797j == null || this.f31798k == null) {
            return;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ComplianceActivity.this.finish();
            }
        });
        this.f31797j.setViewClickListener(new InterfaceC7181hk() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.2
            @Override // com.huawei.openalliance.p169ad.InterfaceC7181hk
            /* renamed from: a */
            public void mo38605a() {
                ComplianceActivity.this.finish();
            }
        });
        this.f31798k.setViewClickListener(new InterfaceC7181hk() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.3
            @Override // com.huawei.openalliance.p169ad.InterfaceC7181hk
            /* renamed from: a */
            public void mo38605a() {
                ComplianceActivity.this.finish();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: c */
    public void mo38601c() {
        this.f31792e = (RelativeLayout) findViewById(C6849R.id.compliance_activity_root);
        this.f31793f = findViewById(C6849R.id.margin_view);
        this.f31794g = findViewById(C6849R.id.compliance_anchor_view);
        this.f31797j = (AbstractC8104h) findViewById(C6849R.id.top_compliance_view);
        this.f31800m = (ImageView) findViewById(C6849R.id.top_compliance_iv);
        this.f31798k = (AbstractC8104h) findViewById(C6849R.id.bottom_compliance_view);
        this.f31801n = (ImageView) findViewById(C6849R.id.bottom_compliance_iv);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: d */
    public int mo38602d() {
        return C6849R.layout.hiad_activity_compliance;
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: e */
    public void mo38603e() {
        m38779f();
        this.f31799l.m50256a(this.f31795h, this.f31796i);
        this.f31799l.setShowWhyThisAd(this.f31638s);
        this.f31799l.setAdContent(this.f31637r);
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void finish() {
        super.finish();
        InterfaceC6904d interfaceC6904d = f31636q;
        if (interfaceC6904d != null) {
            interfaceC6904d.mo38576b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a
    /* renamed from: i */
    public boolean mo38604i() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra(MapKeyNames.WHY_THIS_AD_URL);
        String stringExtra2 = safeIntent.getStringExtra(MapKeyNames.COMPLIANCE);
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f31637r.m41580k((List<AdvertiserInfo>) AbstractC7758be.m47739b(stringExtra2, List.class, AdvertiserInfo.class));
        }
        this.f31638s = safeIntent.getBooleanExtra(MapKeyNames.SHOW_WHY_THIS_AD, false);
        String stringExtra3 = safeIntent.getStringExtra(MapKeyNames.DSA_URL);
        boolean booleanExtra = safeIntent.getBooleanExtra(MapKeyNames.DSA_SWITCH, false);
        this.f31637r.m41610u(stringExtra);
        this.f31637r.m41551e(booleanExtra);
        this.f31637r.m41420S(stringExtra3);
        return super.mo38604i();
    }

    @Override // com.huawei.openalliance.p169ad.activity.ActivityC6901a, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m38600m();
        InterfaceC6904d interfaceC6904d = f31636q;
        if (interfaceC6904d != null) {
            interfaceC6904d.mo38575a();
        }
    }

    /* renamed from: a */
    public static void m38596a(Context context, int[] iArr, int[] iArr2, ContentRecord contentRecord, boolean z10) {
        if (m38598a(contentRecord)) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) ComplianceActivity.class);
            intent.putExtra(MapKeyNames.ANCHOR_LOCATION, iArr);
            intent.putExtra(MapKeyNames.ANCHOR_SIZE, iArr2);
            intent.setFlags(65536);
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            String strM41490al = contentRecord.m41490al();
            if (TextUtils.isEmpty(strM41490al)) {
                strM41490al = contentRecord.m41476aa();
            }
            intent.putExtra(MapKeyNames.WHY_THIS_AD_URL, strM41490al);
            intent.putExtra(MapKeyNames.COMPLIANCE, AbstractC7758be.m47742b(contentRecord.m41468aT()));
            intent.putExtra(MapKeyNames.SHOW_WHY_THIS_AD, z10);
            intent.putExtra(MapKeyNames.DSA_URL, contentRecord.m41516bc());
            intent.putExtra(MapKeyNames.DSA_SWITCH, contentRecord.m41517bd());
            intent.setClipData(Constants.CLIP_DATA);
            AbstractC7811dd.m48294a(context, intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ComplianceActivity", "start Activity error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m38597a(InterfaceC6904d interfaceC6904d) {
        f31636q = interfaceC6904d;
    }

    /* renamed from: a */
    private static boolean m38598a(ContentRecord contentRecord) {
        if (!C7730ad.m47434a()) {
            return contentRecord == null;
        }
        AbstractC7185ho.m43820b("ComplianceActivity", "repeat click too fast");
        return true;
    }
}
