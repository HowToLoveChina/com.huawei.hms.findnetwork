package com.huawei.uikit.phone.hwrecyclerview.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.huawei.uikit.hwrecyclerview.C8721R;
import com.huawei.uikit.phone.hwrecyclerview.C8764R;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwCompoundEventDetector;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwGenericEventDetector;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwKeyEventDetector;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes9.dex */
public class HwRecyclerView extends com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView {

    /* renamed from: f */
    private static final String f44994f = "HwRecyclerView";

    /* renamed from: g */
    private static final String f44995g = "com.huawei.intent.action.CLICK_STATUSBAR";

    /* renamed from: h */
    private static final String f44996h = "huawei.permission.CLICK_STATUSBAR_BROADCAST";

    /* renamed from: a */
    private boolean f44997a;

    /* renamed from: b */
    private IntentFilter f44998b;

    /* renamed from: c */
    private boolean f44999c;

    /* renamed from: d */
    private Context f45000d;

    /* renamed from: e */
    private BroadcastReceiver f45001e;

    public class bzrwd extends BroadcastReceiver {
        public bzrwd() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && HwRecyclerView.f44995g.equals(intent.getAction())) {
                HwRecyclerView.this.handleScrollToTop();
            }
        }
    }

    public HwRecyclerView(Context context) {
        super(context);
        this.f45001e = new bzrwd();
        init(super.getContext(), null, C8721R.attr.hwRecyclerViewStyle);
    }

    /* renamed from: b */
    private void m55996b() {
        Context context;
        if (!this.f44999c || (context = this.f45000d) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f45001e);
            this.f44999c = false;
        } catch (IllegalArgumentException unused) {
            Log.w(f44994f, "Receiver not registered");
        }
    }

    private void init(Context context, AttributeSet attributeSet, int i10) {
        if (context.getApplicationContext() != null) {
            this.f45000d = context.getApplicationContext();
        } else {
            this.f45000d = context;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8764R.styleable.HwRecyclerView, i10, C8764R.style.Widget_Emui_HwRecyclerView);
        this.f44997a = typedArrayObtainStyledAttributes.getBoolean(C8764R.styleable.HwRecyclerView_hwScrollTopEnable, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onAttachedToWindow();
        m55994a();
        if (this.f44999c) {
            this.mRollbackRuleDetectorProxy.start(this);
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onDetachedFromWindow();
        m55996b();
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView
    public void setScrollTopEnable(boolean z10) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (z10 != this.f44997a) {
            this.f44997a = z10;
            if (!z10) {
                m55996b();
                this.mRollbackRuleDetectorProxy.stop();
            } else {
                m55994a();
                if (this.f44999c) {
                    this.mRollbackRuleDetectorProxy.start(this);
                }
            }
        }
    }

    /* renamed from: a */
    private void m55994a() {
        if (!this.f44997a || this.f44999c || this.f45000d == null) {
            return;
        }
        if (this.f44998b == null) {
            this.f44998b = new IntentFilter(f44995g);
        }
        try {
            this.f45000d.registerReceiver(this.f45001e, this.f44998b, f44996h, null);
            this.f44999c = true;
        } catch (ReceiverCallNotAllowedException unused) {
            Log.w(f44994f, "There is a problem with the APP application scenario:BroadcastReceiver components are not allowed to register to receive intents");
            this.f44999c = false;
        } catch (IllegalStateException unused2) {
            Log.w(f44994f, "registerReceiver IllegalStateException");
            this.f44999c = false;
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView
    public HwCompoundEventDetector createCompoundEventDetector() {
        return new HwCompoundEventDetector(getContext());
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView
    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView
    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    public HwRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45001e = new bzrwd();
        init(super.getContext(), attributeSet, C8721R.attr.hwRecyclerViewStyle);
    }

    public HwRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f45001e = new bzrwd();
        init(super.getContext(), attributeSet, i10);
    }
}
