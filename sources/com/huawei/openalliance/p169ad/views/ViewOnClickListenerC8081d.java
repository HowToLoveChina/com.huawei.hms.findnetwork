package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* renamed from: com.huawei.openalliance.ad.views.d */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC8081d extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private TextView f37591a;

    /* renamed from: b */
    private ImageView f37592b;

    /* renamed from: c */
    private ImageView f37593c;

    /* renamed from: d */
    private a f37594d;

    /* renamed from: com.huawei.openalliance.ad.views.d$a */
    public interface a {
        /* renamed from: c */
        void mo38699c();

        void onMenuBtnClick(View view);
    }

    public ViewOnClickListenerC8081d(Context context, boolean z10) throws Resources.NotFoundException {
        super(context);
        setBackgroundColor(Color.rgb(0, 151, 168));
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C6849R.dimen.hiad_8_dp);
        setPadding(dimensionPixelSize, AbstractC7741ao.m47583h(context) + dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        m50096a(context, z10);
        m50095a();
    }

    /* renamed from: a */
    private void m50095a() {
        ImageView imageView = this.f37593c;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.f37592b;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f37594d;
        if (aVar != null) {
            if (view == this.f37593c) {
                aVar.mo38699c();
                return;
            }
            ImageView imageView = this.f37592b;
            if (view == imageView) {
                aVar.onMenuBtnClick(imageView);
            }
        }
    }

    public void setCallBack(a aVar) {
        this.f37594d = aVar;
    }

    public void setTitle(String str) {
        if (this.f37591a == null || AbstractC7806cz.m48165b(str)) {
            return;
        }
        this.f37591a.setText(str);
    }

    /* renamed from: a */
    private void m50096a(Context context, boolean z10) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_custom_emui_action_bar, this);
        this.f37593c = (ImageView) findViewById(C6849R.id.hiad_id_back_btn);
        this.f37591a = (TextView) findViewById(C6849R.id.hiad_id_title_tv);
        ImageView imageView = (ImageView) findViewById(C6849R.id.hiad_id_menu_btn);
        this.f37592b = imageView;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 4);
        }
    }

    /* renamed from: a */
    public void m50097a(boolean z10) {
        TextView textView = this.f37591a;
        if (textView != null) {
            textView.setVisibility(z10 ? 0 : 4);
        }
    }
}
