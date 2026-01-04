package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7752az;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.vk */
/* loaded from: classes8.dex */
public class RunnableC8189vk implements Runnable {

    /* renamed from: a */
    private String f38420a;

    /* renamed from: b */
    private WeakReference<ImageView> f38421b;

    /* renamed from: c */
    private C7022dk f38422c;

    /* renamed from: d */
    private Context f38423d;

    /* renamed from: e */
    private Boolean f38424e;

    /* renamed from: f */
    private C7752az.a f38425f;

    public RunnableC8189vk(Context context, String str, ImageView imageView, Boolean bool) {
        this.f38420a = str;
        this.f38421b = new WeakReference<>(imageView);
        context = context != null ? context.getApplicationContext() : context;
        this.f38423d = context;
        this.f38422c = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        this.f38424e = bool;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f38423d == null) {
            return;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47181b(false);
        c7653sb.m47185c(true);
        c7653sb.m47180b("icon");
        c7653sb.m47187d(this.f38420a);
        Boolean bool = this.f38424e;
        if (bool != null && !bool.booleanValue()) {
            c7653sb.m47183c(C7124fh.m43316b(this.f38423d).mo43019e());
        }
        C7654sc c7654scM47158a = new C7650rz(this.f38423d, c7653sb).m47158a();
        if (c7654scM47158a == null) {
            return;
        }
        String strM47207a = c7654scM47158a.m47207a();
        if (TextUtils.isEmpty(strM47207a)) {
            return;
        }
        String strM41968c = this.f38422c.m41968c(strM47207a);
        if (TextUtils.isEmpty(strM41968c)) {
            return;
        }
        C7752az.m47690a(this.f38423d, strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.vk.1
            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30231a() {
                if (RunnableC8189vk.this.f38425f != null) {
                    RunnableC8189vk.this.f38425f.mo30231a();
                }
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30232a(final Drawable drawable) {
                if (drawable == null) {
                    return;
                }
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.vk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageView imageView;
                        if (RunnableC8189vk.this.f38425f != null) {
                            RunnableC8189vk.this.f38425f.mo30232a(drawable);
                        }
                        if (RunnableC8189vk.this.f38421b == null || RunnableC8189vk.this.f38421b.get() == null || (imageView = (ImageView) RunnableC8189vk.this.f38421b.get()) == null) {
                            return;
                        }
                        imageView.setBackground(null);
                        imageView.setImageDrawable(drawable);
                    }
                });
            }
        });
    }
}
