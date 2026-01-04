package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes5.dex */
public class HwKeyEventDetector {

    /* renamed from: g */
    private static final String f44561g = "HwKeyEventDetector";

    /* renamed from: h */
    private static final int f44562h = 1;

    /* renamed from: a */
    private View f44563a = null;

    /* renamed from: b */
    private OnEditEventListener f44564b = null;

    /* renamed from: c */
    private OnSearchEventListener f44565c = null;

    /* renamed from: d */
    private OnNextTabEventListener f44566d = null;

    /* renamed from: e */
    private OnGlobalNextTabEventListener f44567e = null;

    /* renamed from: f */
    private View.OnUnhandledKeyEventListener f44568f = null;

    public interface OnEditEventListener {
        boolean onCopy(int i10, KeyEvent keyEvent);

        boolean onCut(int i10, KeyEvent keyEvent);

        boolean onDelete(int i10, KeyEvent keyEvent);

        boolean onPaste(int i10, KeyEvent keyEvent);

        boolean onSelectAll(int i10, KeyEvent keyEvent);

        boolean onUndo(int i10, KeyEvent keyEvent);
    }

    public interface OnGlobalNextTabEventListener {
        boolean onGlobalNextTab(int i10, KeyEvent keyEvent);
    }

    public interface OnNextTabEventListener {
        boolean onNextTab(int i10, KeyEvent keyEvent);
    }

    public interface OnSearchEventListener {
        boolean onSearch(int i10, KeyEvent keyEvent);
    }

    public class bzrwd implements View.OnUnhandledKeyEventListener {
        public bzrwd() {
        }

        @Override // android.view.View.OnUnhandledKeyEventListener
        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            return HwKeyEventDetector.this.m55760a(view, keyEvent);
        }
    }

    public HwKeyEventDetector(Context context) {
    }

    /* renamed from: b */
    private boolean m55762b(int i10, int i11, KeyEvent keyEvent) {
        OnEditEventListener onEditEventListener;
        if (i10 != 112 || (onEditEventListener = this.f44564b) == null) {
            return false;
        }
        return onEditEventListener.onDelete(i11, keyEvent);
    }

    public static HwKeyEventDetector instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwKeyEventDetector.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwKeyEventDetector.class);
        if (objInstantiate instanceof HwKeyEventDetector) {
            return (HwKeyEventDetector) objInstantiate;
        }
        return null;
    }

    public OnEditEventListener getOnEditEventListener() {
        return this.f44564b;
    }

    public OnGlobalNextTabEventListener getOnGlobalNextTabListener() {
        return this.f44567e;
    }

    public OnNextTabEventListener getOnNextTabListener() {
        return this.f44566d;
    }

    public OnSearchEventListener getOnSearchEventListener() {
        return this.f44565c;
    }

    public void onDetachedFromWindow() {
        m55758a(false);
    }

    public boolean onKeyEvent(int i10, KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (!keyEvent.isCtrlPressed()) {
            return m55762b(i10, action, keyEvent);
        }
        if (m55759a(i10, action, keyEvent)) {
            return true;
        }
        OnNextTabEventListener onNextTabEventListener = this.f44566d;
        if (onNextTabEventListener != null && i10 == 61 && onNextTabEventListener.onNextTab(action, keyEvent)) {
            return true;
        }
        OnSearchEventListener onSearchEventListener = this.f44565c;
        return onSearchEventListener != null && i10 == 34 && onSearchEventListener.onSearch(action, keyEvent);
    }

    public void setOnEditEventListener(OnEditEventListener onEditEventListener) {
        this.f44564b = onEditEventListener;
    }

    public void setOnGlobalNextTabListener(View view, OnGlobalNextTabEventListener onGlobalNextTabEventListener) {
        this.f44563a = view;
        this.f44567e = onGlobalNextTabEventListener;
        m55758a(onGlobalNextTabEventListener != null);
    }

    public void setOnNextTabListener(OnNextTabEventListener onNextTabEventListener) {
        this.f44566d = onNextTabEventListener;
    }

    public void setOnSearchEventListener(OnSearchEventListener onSearchEventListener) {
        this.f44565c = onSearchEventListener;
    }

    /* renamed from: a */
    private void m55758a(boolean z10) {
        View view = this.f44563a;
        if (view == null) {
            return;
        }
        if (z10) {
            if (this.f44568f == null) {
                bzrwd bzrwdVar = new bzrwd();
                this.f44568f = bzrwdVar;
                this.f44563a.addOnUnhandledKeyEventListener(bzrwdVar);
                return;
            }
            return;
        }
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = this.f44568f;
        if (onUnhandledKeyEventListener != null) {
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            this.f44568f = null;
        }
    }

    /* renamed from: a */
    private boolean m55759a(int i10, int i11, KeyEvent keyEvent) {
        OnEditEventListener onEditEventListener = this.f44564b;
        if (onEditEventListener == null) {
            return false;
        }
        if (i10 != 29) {
            if (i10 != 31) {
                if (i10 != 50) {
                    if (i10 != 52) {
                        if (i10 == 54 && onEditEventListener.onUndo(i11, keyEvent)) {
                            return true;
                        }
                    } else if (onEditEventListener.onCut(i11, keyEvent)) {
                        return true;
                    }
                } else if (onEditEventListener.onPaste(i11, keyEvent)) {
                    return true;
                }
            } else if (onEditEventListener.onCopy(i11, keyEvent)) {
                return true;
            }
        } else if (onEditEventListener.onSelectAll(i11, keyEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m55760a(View view, KeyEvent keyEvent) {
        return this.f44567e != null && keyEvent.getKeyCode() == 61 && keyEvent.isCtrlPressed() && this.f44567e.onGlobalNextTab(keyEvent.getAction(), keyEvent);
    }
}
