package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v;

/* loaded from: classes2.dex */
public class NativeVideoControlPanel extends AutoScaleSizeRelativeLayout implements InterfaceC8129v {

    /* renamed from: a */
    private ImageView f36441a;

    /* renamed from: b */
    private ImageView f36442b;

    /* renamed from: c */
    private View f36443c;

    /* renamed from: d */
    private ImageView f36444d;

    /* renamed from: e */
    private View f36445e;

    /* renamed from: f */
    private View f36446f;

    /* renamed from: g */
    private View f36447g;

    /* renamed from: h */
    private TextView f36448h;

    public NativeVideoControlPanel(Context context) {
        super(context);
        m48836a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: a */
    public ImageView mo48837a() {
        return this.f36441a;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: b */
    public int mo48839b() {
        return C6849R.drawable.hiad_play;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: c */
    public int mo48840c() {
        return C6849R.drawable.hiad_pause;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: d */
    public ImageView mo48841d() {
        return this.f36442b;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: e */
    public View mo48842e() {
        return this.f36443c;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: f */
    public ImageView mo48843f() {
        return this.f36444d;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: g */
    public View mo48844g() {
        return this.f36446f;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: h */
    public View mo48845h() {
        return this.f36447g;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: i */
    public View mo48846i() {
        return this.f36445e;
    }

    public void setNonWifiAlertMsg(String str) {
        this.f36448h.setText(str);
    }

    public NativeVideoControlPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m48836a(context);
    }

    /* renamed from: a */
    private void m48836a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_native_video_control_panel, this);
        this.f36445e = findViewById(C6849R.id.hiad_native_video_control_panel);
        ImageView imageView = (ImageView) findViewById(C6849R.id.hiad_cb_sound);
        this.f36442b = imageView;
        imageView.setImageResource(C6849R.drawable.hiad_selector_ic_sound_check);
        AbstractC7811dd.m48296a(this.f36442b);
        this.f36443c = findViewById(C6849R.id.hiad_pb_buffering);
        this.f36441a = (ImageView) findViewById(C6849R.id.hiad_btn_play_or_pause);
        this.f36444d = (ImageView) findViewById(C6849R.id.hiad_iv_preview_video);
        this.f36446f = findViewById(C6849R.id.hiad_rl_non_wifi_alert);
        this.f36447g = findViewById(C6849R.id.hiad_btn_non_wifi_play);
        this.f36448h = (TextView) findViewById(C6849R.id.hiad_non_wifi_alert_msg);
    }

    public NativeVideoControlPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m48836a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v
    /* renamed from: a */
    public void mo48838a(boolean z10) {
        this.f36442b.setVisibility(z10 ? 0 : 8);
    }
}
