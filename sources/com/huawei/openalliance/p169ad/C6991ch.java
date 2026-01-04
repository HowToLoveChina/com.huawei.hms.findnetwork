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
import com.hihonor.android.app.ActivityManagerEx;
import com.hihonor.android.app.HwMultiWindowEx;
import com.hihonor.android.app.PackageManagerEx;
import com.hihonor.android.content.pm.ApplicationInfoEx;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.hihonor.android.provider.SettingsEx;
import com.hihonor.android.view.DisplaySideRegionEx;
import com.hihonor.android.view.WindowManagerEx;
import com.hihonor.android.widget.ActionBarEx;
import com.huawei.openalliance.p169ad.utils.C7771br;
import com.huawei.openalliance.p169ad.utils.InterfaceC7769bp;

/* renamed from: com.huawei.openalliance.ad.ch */
/* loaded from: classes8.dex */
public class C6991ch extends C6988ce {

    /* renamed from: a */
    private static InterfaceC7000cq f32121a;

    /* renamed from: b */
    private static final byte[] f32122b = new byte[0];

    private C6991ch(Context context) {
    }

    /* renamed from: b */
    public static InterfaceC7000cq m41215b(Context context) {
        return m41216c(context);
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public int mo41198a(Context context) {
        return SettingsEx.getIntForUser(context.getContentResolver(), "accessibility_screenreader_enabled", -1, ActivityManagerEx.getCurrentUser());
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: c */
    public int mo41206c() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: d */
    public boolean mo41207d() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: e */
    public String mo41208e() {
        return "com.hihonor.android.os.Build$VERSION";
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: f */
    public String mo41209f() {
        return "com.hihonor.android.os.Build";
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: g */
    public boolean mo41210g() {
        return PackageManagerEx.hasHwSystemFeature("com.huawei.hardware.screen.type.eink");
    }

    /* renamed from: c */
    private static InterfaceC7000cq m41216c(Context context) {
        InterfaceC7000cq interfaceC7000cq;
        synchronized (f32122b) {
            try {
                if (f32121a == null) {
                    f32121a = new C6991ch(context);
                }
                interfaceC7000cq = f32121a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7000cq;
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public int mo41199a(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: b */
    public boolean mo41205b() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public Rect mo41200a(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public InterfaceC7769bp mo41201a() {
        return new C7771br();
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public void mo41202a(ActionBar actionBar, boolean z10, Drawable drawable, View.OnClickListener onClickListener) {
        ActionBarEx.setStartIcon(actionBar, true, (Drawable) null, onClickListener);
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public void mo41203a(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.openalliance.p169ad.C6988ce, com.huawei.openalliance.p169ad.InterfaceC7000cq
    /* renamed from: a */
    public boolean mo41204a(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HnSysApiImpl", "isFreedomWindowMode error");
            return false;
        }
    }
}
