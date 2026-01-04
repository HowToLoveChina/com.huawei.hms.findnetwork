package com.huawei.openalliance.p169ad;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.utils.InterfaceC7769bp;

/* renamed from: com.huawei.openalliance.ad.cq */
/* loaded from: classes8.dex */
public interface InterfaceC7000cq {
    /* renamed from: a */
    int mo41198a(Context context);

    /* renamed from: a */
    int mo41199a(ApplicationInfo applicationInfo);

    /* renamed from: a */
    Rect mo41200a(WindowInsets windowInsets);

    /* renamed from: a */
    InterfaceC7769bp mo41201a();

    /* renamed from: a */
    void mo41202a(ActionBar actionBar, boolean z10, Drawable drawable, View.OnClickListener onClickListener);

    /* renamed from: a */
    void mo41203a(WindowManager.LayoutParams layoutParams);

    /* renamed from: a */
    boolean mo41204a(Activity activity);

    /* renamed from: b */
    boolean mo41205b();

    /* renamed from: c */
    int mo41206c();

    /* renamed from: d */
    boolean mo41207d();

    /* renamed from: e */
    String mo41208e();

    /* renamed from: f */
    String mo41209f();

    /* renamed from: g */
    boolean mo41210g();
}
