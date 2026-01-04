package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.linked.view.C7396a;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.AutoScaleSizeRelativeLayout;

/* loaded from: classes2.dex */
public class LinkedNativeViewControlPanel extends AutoScaleSizeRelativeLayout {

    /* renamed from: a */
    private ImageView f34339a;

    /* renamed from: b */
    private ImageView f34340b;

    /* renamed from: c */
    private ImageView f34341c;

    /* renamed from: d */
    private SeekBar f34342d;

    /* renamed from: e */
    private ImageView f34343e;

    /* renamed from: f */
    private TextView f34344f;

    /* renamed from: g */
    private TextView f34345g;

    /* renamed from: h */
    private View f34346h;

    /* renamed from: i */
    private ImageView f34347i;

    /* renamed from: j */
    private View f34348j;

    /* renamed from: k */
    private View f34349k;

    /* renamed from: l */
    private LinkedWifiAlertPlayButton f34350l;

    /* renamed from: m */
    private TextView f34351m;

    public LinkedNativeViewControlPanel(Context context) {
        super(context);
        m45503a(context);
    }

    /* renamed from: a */
    public static int m45502a() {
        return C6849R.drawable.hiad_linked_video_play;
    }

    /* renamed from: b */
    public static int m45504b() {
        return C6849R.drawable.hiad_linked_video_pause;
    }

    /* renamed from: c */
    public static int m45505c() {
        return C6849R.drawable.hiad_linked_video_refresh;
    }

    /* renamed from: d */
    public void m45506d() {
        C7396a.a aVarM45520a = this.f34350l.getStyle().m45520a();
        this.f34350l.setTextColor(aVarM45520a.f34357b);
        this.f34350l.setProgressDrawable(aVarM45520a.f34356a);
    }

    /* renamed from: e */
    public ImageView m45507e() {
        return this.f34339a;
    }

    /* renamed from: f */
    public ImageView m45508f() {
        return this.f34340b;
    }

    /* renamed from: g */
    public ImageView m45509g() {
        return this.f34341c;
    }

    /* renamed from: h */
    public SeekBar m45510h() {
        return this.f34342d;
    }

    /* renamed from: i */
    public ImageView m45511i() {
        return this.f34343e;
    }

    /* renamed from: j */
    public TextView m45512j() {
        return this.f34344f;
    }

    /* renamed from: k */
    public TextView m45513k() {
        return this.f34345g;
    }

    /* renamed from: l */
    public View m45514l() {
        return this.f34346h;
    }

    /* renamed from: m */
    public ImageView m45515m() {
        return this.f34347i;
    }

    /* renamed from: n */
    public View m45516n() {
        return this.f34349k;
    }

    /* renamed from: o */
    public LinkedWifiAlertPlayButton m45517o() {
        return this.f34350l;
    }

    public void setNonWifiAlertMsg(int i10) {
        TextView textView = this.f34351m;
        if (textView != null) {
            textView.setText(i10);
        }
    }

    public LinkedNativeViewControlPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m45503a(context);
    }

    /* renamed from: a */
    private void m45503a(Context context) {
        try {
            LayoutInflater.from(context).inflate(C6849R.layout.hiad_linked_native_video_control_panel, this);
            this.f34348j = findViewById(C6849R.id.hiad_linked_native_video_control_panel);
            this.f34340b = (ImageView) findViewById(C6849R.id.hiad_linked_cb_sound);
            this.f34341c = (ImageView) findViewById(C6849R.id.hiad_linked_cb_fullcreen);
            this.f34343e = (ImageView) findViewById(C6849R.id.hiad_linked_restart);
            this.f34344f = (TextView) findViewById(C6849R.id.hiad_linked_video_now_time);
            this.f34345g = (TextView) findViewById(C6849R.id.hiad_linked_video_total_time);
            this.f34340b.setImageResource(AbstractC7811dd.m48287a(true, false));
            AbstractC7811dd.m48296a(this.f34340b);
            this.f34346h = findViewById(C6849R.id.hiad_linked_pb_buffering);
            this.f34339a = (ImageView) findViewById(C6849R.id.hiad_linked_btn_play_or_pause);
            this.f34347i = (ImageView) findViewById(C6849R.id.hiad_linked_preview_video);
            this.f34349k = findViewById(C6849R.id.hiad_linked_non_wifi_alert);
            this.f34350l = (LinkedWifiAlertPlayButton) findViewById(C6849R.id.hiad_linked_btn_non_wifi_play);
            m45506d();
            this.f34351m = (TextView) findViewById(C6849R.id.hiad_linked_non_wifi_alert_msg);
            this.f34342d = C6982bz.m41148a(context).mo41178g() ? (SeekBar) findViewById(C6849R.id.hiad_linked_native_video_progress_hm) : (SeekBar) findViewById(C6849R.id.hiad_linked_native_video_progress);
            this.f34342d.setVisibility(0);
        } catch (RuntimeException unused) {
            AbstractC7185ho.m43823c("LinkedNativeViewControlPanel", "init RuntimeException");
        } catch (Exception e10) {
            AbstractC7185ho.m43826d("LinkedNativeViewControlPanel", "init " + e10.getClass().getSimpleName());
        }
    }

    public void setNonWifiAlertMsg(String str) {
        TextView textView = this.f34351m;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public LinkedNativeViewControlPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m45503a(context);
    }
}
