package com.huawei.uikit.phone.hwsubtab.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer;
import com.huawei.uikit.phone.hwsubtab.C8768R;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes9.dex */
public class HwSubTabViewContainer extends com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer {

    /* renamed from: j */
    private static final int f45020j = 8;

    /* renamed from: k */
    private static final int f45021k = 28;

    /* renamed from: l */
    private static final int f45022l = 32;

    /* renamed from: a */
    private int f45023a;

    /* renamed from: b */
    private HwColumnSystem f45024b;

    /* renamed from: c */
    private boolean f45025c;

    /* renamed from: d */
    private int f45026d;

    /* renamed from: e */
    private int f45027e;

    /* renamed from: f */
    private float f45028f;

    /* renamed from: g */
    private Context f45029g;

    /* renamed from: h */
    private int f45030h;

    /* renamed from: i */
    private int f45031i;

    public class ChildPaddingPhoneClient extends HwSubTabViewContainer.ChildPaddingClient {
        public ChildPaddingPhoneClient() {
            super();
        }

        @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer.ChildPaddingClient
        public void setHeadlinePadding(View view) {
            int startOriginPadding = HwSubTabViewContainer.this.getStartOriginPadding() - HwSubTabViewContainer.this.getSubTabItemMargin();
            view.setPadding(startOriginPadding, 0, startOriginPadding, 0);
        }

        @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer.ChildPaddingClient
        public void setPadding(View view, boolean z10) throws Resources.NotFoundException {
            if (HwSubTabViewContainer.this.getResources() != null) {
                int dimensionPixelSize = HwSubTabViewContainer.this.getResources().getDimensionPixelSize(C8768R.dimen.hwsubtab_padding_default);
                view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }

    public HwSubTabViewContainer(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m55998a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f45029g = context;
        HwColumnSystem hwColumnSystem = new HwColumnSystem(this.f45029g);
        this.f45024b = hwColumnSystem;
        this.f45025c = false;
        hwColumnSystem.setColumnType(this.f45023a);
        this.f45024b.updateConfigation(this.f45029g);
        this.f45030h = getResources().getDimensionPixelOffset(C8768R.dimen.hwsubtab_padding_start);
        this.f45031i = getResources().getDimensionPixelOffset(C8768R.dimen.hwsubtab_padding_start_pad);
        m55997a();
    }

    /* renamed from: b */
    private void m55999b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f45024b.setColumnType(-1);
        this.f45024b.updateConfigation(this.f45029g);
    }

    /* renamed from: c */
    private void m56000c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f45024b.setColumnType(-1);
        this.f45024b.updateConfigation(this.f45029g, this.f45026d, this.f45027e, this.f45028f);
    }

    public void configureColumn(int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 > 0 && i11 > 0 && f10 > 0.0f) {
            this.f45026d = i10;
            this.f45027e = i11;
            this.f45028f = f10;
            this.f45025c = true;
            m56000c();
        } else {
            if (!this.f45025c) {
                return;
            }
            this.f45025c = false;
            m55999b();
        }
        m55997a();
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer
    public void initChildPaddingClient() {
        setChildPaddingClient(new ChildPaddingPhoneClient());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        if (this.f45025c) {
            m56000c();
        } else {
            m55999b();
        }
        m55997a();
    }

    public HwSubTabViewContainer(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.f45023a = -1;
        m55998a(context);
    }

    public HwSubTabViewContainer(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i10);
        this.f45023a = -1;
        m55998a(context);
    }

    /* renamed from: a */
    private void m55997a() {
        if (this.f45024b.getTotalColumnCount() >= 8) {
            setStartOriginPadding(this.f45031i);
            setStartScrollPadding(32);
        } else {
            setStartOriginPadding(this.f45030h);
            setStartScrollPadding(28);
        }
    }
}
