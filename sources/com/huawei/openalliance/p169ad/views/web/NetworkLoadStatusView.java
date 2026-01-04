package com.huawei.openalliance.p169ad.views.web;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.C7845x;

@OuterVisible
/* loaded from: classes2.dex */
public class NetworkLoadStatusView extends RelativeLayout {

    /* renamed from: a */
    String f38299a;

    /* renamed from: b */
    public View.OnClickListener f38300b;

    /* renamed from: c */
    private int f38301c;

    /* renamed from: d */
    private InterfaceC8168a f38302d;

    /* renamed from: e */
    private ImageView f38303e;

    /* renamed from: f */
    private TextView f38304f;

    /* renamed from: g */
    private Button f38305g;

    /* renamed from: com.huawei.openalliance.ad.views.web.NetworkLoadStatusView$a */
    public interface InterfaceC8168a {
        void onClick(View view);
    }

    @OuterVisible
    public NetworkLoadStatusView(Context context) {
        super(context);
        this.f38301c = 1;
        this.f38300b = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.web.NetworkLoadStatusView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NetworkLoadStatusView.this.f38302d == null) {
                    return;
                }
                NetworkLoadStatusView.this.f38302d.onClick(view);
            }
        };
        m50639a();
    }

    /* renamed from: b */
    private void m50640b() {
        AbstractC7185ho.m43817a("NetworkLoadStatusView", "displayError");
        this.f38301c = -1;
        this.f38303e.setVisibility(0);
        this.f38304f.setVisibility(0);
        this.f38304f.setText(this.f38299a);
        this.f38305g.setVisibility(8);
    }

    /* renamed from: c */
    private void m50641c() {
        AbstractC7185ho.m43817a("NetworkLoadStatusView", "displayNotNetwork");
        this.f38301c = -2;
        this.f38303e.setVisibility(0);
        this.f38304f.setVisibility(0);
        this.f38305g.setVisibility(0);
        this.f38305g.setOnClickListener(this.f38300b);
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

    public int getCurrentState() {
        return this.f38301c;
    }

    public void setErrorText(String str) {
        this.f38299a = str;
    }

    public void setOnEmptyClickListener(InterfaceC8168a interfaceC8168a) {
        this.f38302d = interfaceC8168a;
    }

    public void setState(int i10) {
        AbstractC7185ho.m43818a("NetworkLoadStatusView", "setState:%d", Integer.valueOf(i10));
        this.f38301c = i10;
        if (i10 == -2) {
            m50641c();
        } else {
            if (i10 != -1) {
                if (i10 != 0) {
                    return;
                }
                setChildViewVisibility(0);
                return;
            }
            m50640b();
        }
        setChildViewVisibility(8);
    }

    @OuterVisible
    public NetworkLoadStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38301c = 1;
        this.f38300b = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.web.NetworkLoadStatusView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NetworkLoadStatusView.this.f38302d == null) {
                    return;
                }
                NetworkLoadStatusView.this.f38302d.onClick(view);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.LoadStatementView);
        try {
            this.f38299a = typedArrayObtainStyledAttributes.getString(C6849R.styleable.LoadStatementView_nonNetworkText);
            typedArrayObtainStyledAttributes.recycle();
            m50639a();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* renamed from: a */
    private void m50639a() {
        ImageView imageView;
        int i10;
        if (getChildCount() > 1) {
            throw new IllegalStateException("StatusView can host only one direct child");
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(C6849R.layout.webview_status_view, this);
        this.f38303e = (ImageView) viewInflate.findViewById(C6849R.id.nonwifi);
        if (C7845x.m48547c()) {
            imageView = this.f38303e;
            i10 = C6849R.drawable.opendevice_ic_wlan_emui10;
        } else {
            imageView = this.f38303e;
            i10 = C6849R.drawable.opendevice_ic_wlan;
        }
        imageView.setImageResource(i10);
        this.f38304f = (TextView) viewInflate.findViewById(C6849R.id.network_tip);
        this.f38305g = (Button) viewInflate.findViewById(C6849R.id.privacy_set_network);
        viewInflate.setOnClickListener(this.f38300b);
    }
}
