package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.C6849R;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.views.ah */
/* loaded from: classes2.dex */
public class C8073ah extends RelativeLayout {

    /* renamed from: a */
    private CornerImageView f37503a;

    /* renamed from: b */
    private CornerImageView f37504b;

    /* renamed from: com.huawei.openalliance.ad.views.ah$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private WeakReference<Context> f37505a;

        /* renamed from: b */
        private WeakReference<CornerImageView> f37506b;

        public a(Context context, CornerImageView cornerImageView) {
            this.f37505a = new WeakReference<>(context);
            this.f37506b = new WeakReference<>(cornerImageView);
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f37505a.get();
            CornerImageView cornerImageView = this.f37506b.get();
            if (context == null || cornerImageView == null) {
                return;
            }
            cornerImageView.setRectCornerRadius((context.getResources().getDisplayMetrics().widthPixels / 64) * 6);
        }
    }

    public C8073ah(Context context) {
        super(context);
        m49996a(context);
    }

    /* renamed from: a */
    private void m49996a(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(C6849R.layout.hiad_splash_icon_view, this)).setBackgroundColor(0);
        this.f37503a = (CornerImageView) findViewById(C6849R.id.hiad_splash_snapshot);
        int i10 = context.getResources().getDisplayMetrics().widthPixels;
        this.f37504b = (CornerImageView) findViewById(C6849R.id.hiad_splash_icon_view);
        this.f37503a.setRectCornerRadius((context.getResources().getDisplayMetrics().widthPixels / 64) * 8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37504b.getLayoutParams();
        layoutParams.height = i10;
        layoutParams.width = i10;
        this.f37504b.setLayoutParams(layoutParams);
        CornerImageView cornerImageView = this.f37504b;
        cornerImageView.post(new a(context, cornerImageView));
    }

    public CornerImageView getIcon() {
        return this.f37504b;
    }

    public CornerImageView getSplash() {
        return this.f37503a;
    }
}
