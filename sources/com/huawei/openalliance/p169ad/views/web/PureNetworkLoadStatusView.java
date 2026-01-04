package com.huawei.openalliance.p169ad.views.web;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.C7845x;

/* loaded from: classes2.dex */
public class PureNetworkLoadStatusView extends RelativeLayout {

    /* renamed from: a */
    String f38307a;

    /* renamed from: b */
    public View.OnClickListener f38308b;

    /* renamed from: c */
    private int f38309c;

    /* renamed from: d */
    private InterfaceC8172b f38310d;

    /* renamed from: e */
    private ImageView f38311e;

    /* renamed from: f */
    private TextView f38312f;

    /* renamed from: g */
    private Button f38313g;

    /* renamed from: h */
    private boolean f38314h;

    /* renamed from: i */
    private boolean f38315i;

    /* renamed from: j */
    private InterfaceC8171a f38316j;

    /* renamed from: k */
    private Integer f38317k;

    /* renamed from: l */
    private Integer f38318l;

    /* renamed from: com.huawei.openalliance.ad.views.web.PureNetworkLoadStatusView$a */
    public interface InterfaceC8171a {
        /* renamed from: a */
        void mo50652a(PureNetworkLoadStatusView pureNetworkLoadStatusView);
    }

    /* renamed from: com.huawei.openalliance.ad.views.web.PureNetworkLoadStatusView$b */
    public interface InterfaceC8172b {
        /* renamed from: a */
        void mo50653a(View view);
    }

    @OuterVisible
    public PureNetworkLoadStatusView(Context context) {
        super(context);
        this.f38309c = 1;
        this.f38308b = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.web.PureNetworkLoadStatusView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PureNetworkLoadStatusView.this.f38310d == null) {
                    return;
                }
                PureNetworkLoadStatusView.this.f38310d.mo50653a(view);
            }
        };
        m50644a();
    }

    /* renamed from: a */
    private int m50642a(View view, float f10) {
        int i10 = getContext().getResources().getDisplayMetrics().heightPixels;
        int height = ((((int) (i10 * f10)) - i10) + view.getHeight()) - (this.f38311e.getLayoutParams().height / 2);
        AbstractC7185ho.m43818a("PureNetworkLoadStatusView", "topMargin:%s", Integer.valueOf(height));
        return height;
    }

    /* renamed from: b */
    private int m50648b(View view) {
        if (this.f38317k == null) {
            this.f38317k = Integer.valueOf(m50642a(view, 0.4f));
        }
        return this.f38317k.intValue();
    }

    /* renamed from: c */
    private int m50650c(View view) {
        if (this.f38318l == null) {
            this.f38318l = Integer.valueOf(m50642a(view, 0.5f));
        }
        return this.f38318l.intValue();
    }

    private void setButtonOnDeviceReDraw(boolean z10) {
        float f10;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f38313g.getLayoutParams();
        if (this.f38315i && z10) {
            f10 = 0.5f;
        } else {
            if (this.f38314h) {
                layoutParams.width = -2;
                this.f38313g.setLayoutParams(layoutParams);
            }
            f10 = 0.33f;
        }
        layoutParams.weight = f10;
        layoutParams.width = 0;
        this.f38313g.setLayoutParams(layoutParams);
    }

    private void setChildViewVisibility(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getId() == C6849R.id.status_layout_main) {
                childAt.setVisibility(i10 == 0 ? 8 : 0);
            } else {
                childAt.setVisibility(i10);
            }
        }
    }

    private void setIconRes(boolean z10) {
        if (this.f38314h) {
            this.f38311e.setImageResource(C6849R.drawable.hiad_network_error_tv);
        } else {
            this.f38311e.setImageResource(C7845x.m48547c() ? z10 ? C6849R.drawable.opendevice_ic_search_network_emui10 : C6849R.drawable.opendevice_ic_loading_failed_emui10 : z10 ? C6849R.drawable.opendevice_ic_search_network : C6849R.drawable.opendevice_ic_loading_failed);
        }
    }

    public int getCurrentState() {
        return this.f38309c;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        AbstractC7185ho.m43817a("PureNetworkLoadStatusView", "onConfigurationChanged");
        if (this.f38309c == 0) {
            return;
        }
        removeAllViews();
        m50644a();
        InterfaceC8171a interfaceC8171a = this.f38316j;
        if (interfaceC8171a != null) {
            interfaceC8171a.mo50652a(this);
        }
        setState(this.f38309c);
    }

    public void setErrorText(String str) {
        this.f38307a = str;
    }

    public void setOnConfigurationChangedListener(InterfaceC8171a interfaceC8171a) {
        this.f38316j = interfaceC8171a;
    }

    public void setOnEmptyClickListener(InterfaceC8172b interfaceC8172b) {
        this.f38310d = interfaceC8172b;
    }

    public void setState(int i10) {
        AbstractC7185ho.m43818a("PureNetworkLoadStatusView", "setState:%s", Integer.valueOf(i10));
        this.f38309c = i10;
        if (i10 == -2) {
            m50651c();
        } else {
            if (i10 != -1) {
                if (i10 == 0 || i10 == 1) {
                    setChildViewVisibility(0);
                    return;
                }
                return;
            }
            m50649b();
        }
        setChildViewVisibility(8);
    }

    @OuterVisible
    public PureNetworkLoadStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38309c = 1;
        this.f38308b = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.web.PureNetworkLoadStatusView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PureNetworkLoadStatusView.this.f38310d == null) {
                    return;
                }
                PureNetworkLoadStatusView.this.f38310d.mo50653a(view);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.LoadStatementView);
        try {
            this.f38307a = typedArrayObtainStyledAttributes.getString(C6849R.styleable.LoadStatementView_nonNetworkText);
            typedArrayObtainStyledAttributes.recycle();
            m50644a();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* renamed from: b */
    private void m50649b() {
        AbstractC7185ho.m43817a("PureNetworkLoadStatusView", "displayError");
        this.f38309c = -1;
        setIconRes(false);
        this.f38311e.setVisibility(0);
        this.f38312f.setText(getResources().getString(this.f38314h ? C6849R.string.hiad_net_error : C6849R.string.hiad_page_load_failed));
        this.f38312f.setVisibility(0);
        this.f38313g.setVisibility(8);
    }

    /* renamed from: c */
    private void m50651c() {
        AbstractC7185ho.m43817a("PureNetworkLoadStatusView", "displayNotNetwork");
        this.f38309c = -2;
        setIconRes(true);
        this.f38311e.setVisibility(0);
        this.f38312f.setText(this.f38307a);
        this.f38312f.setVisibility(0);
        if (this.f38314h) {
            this.f38313g.setVisibility(8);
            return;
        }
        this.f38313g.setOnClickListener(this.f38308b);
        this.f38313g.requestFocus();
        this.f38313g.setVisibility(0);
    }

    /* renamed from: a */
    private void m50644a() {
        AbstractC7185ho.m43817a("PureNetworkLoadStatusView", "initView");
        if (getChildCount() > 1) {
            throw new IllegalStateException("StatusView can host only one direct child");
        }
        Context context = getContext();
        boolean zM48590o = C7845x.m48590o(context);
        this.f38315i = zM48590o;
        this.f38314h = !zM48590o && C7845x.m48576j(context);
        final View viewInflate = LayoutInflater.from(context).inflate(C6849R.layout.pure_webview_status_view, this);
        this.f38311e = (ImageView) viewInflate.findViewById(C6849R.id.error_icon);
        this.f38312f = (TextView) viewInflate.findViewById(C6849R.id.error_msg);
        this.f38313g = (Button) viewInflate.findViewById(C6849R.id.privacy_set_network);
        viewInflate.setOnClickListener(this.f38308b);
        viewInflate.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.web.PureNetworkLoadStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                PureNetworkLoadStatusView.this.m50645a(viewInflate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d A[PHI: r1
  0x000d: PHI (r1v3 boolean) = (r1v0 boolean), (r1v1 boolean) binds: [B:3:0x000b, B:7:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m50645a(android.view.View r3) {
        /*
            r2 = this;
            android.content.res.Resources r0 = r2.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            r1 = 1
            if (r0 != r1) goto L14
        Ld:
            r2.m50646a(r3, r1)
        L10:
            r2.setButtonOnDeviceReDraw(r1)
            goto L1a
        L14:
            boolean r0 = r2.f38315i
            r1 = 0
            if (r0 != 0) goto L10
            goto Ld
        L1a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.web.PureNetworkLoadStatusView.m50645a(android.view.View):void");
    }

    /* renamed from: a */
    private void m50646a(View view, boolean z10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38311e.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = z10 ? m50648b(view) : m50650c(view);
        this.f38311e.setLayoutParams(layoutParams);
    }
}
