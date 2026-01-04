package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class HwRollbackRuleDetector {
    public static final String ROLLBACK_EVENT = "com.huawei.control.intent.action.RollBackEvent";
    public static final String ROLLBACK_USED_EVENT = "com.huawei.control.intent.action.RollBackUsedEvent";

    /* renamed from: l */
    private static final String f43897l = "HwRollbackRuleDetector";

    /* renamed from: m */
    private static final int f43898m = 1000;

    /* renamed from: n */
    private static final int f43899n = 3;

    /* renamed from: o */
    private static final int f43900o = 1;

    /* renamed from: p */
    private static final int f43901p = 1;

    /* renamed from: q */
    private static final int f43902q = 3;

    /* renamed from: r */
    private static final boolean f43903r = false;

    /* renamed from: a */
    private View f43904a;

    /* renamed from: b */
    private int f43905b;

    /* renamed from: c */
    private GestureDetector f43906c;

    /* renamed from: d */
    private int f43907d;

    /* renamed from: e */
    private RollBackScrollListener f43908e;

    /* renamed from: f */
    private boolean f43909f;

    /* renamed from: g */
    private Object f43910g;

    /* renamed from: h */
    private Class<?> f43911h;

    /* renamed from: i */
    private Context f43912i;

    /* renamed from: j */
    private Handler f43913j = new bzrwd();

    /* renamed from: k */
    private GestureDetector.OnGestureListener f43914k = new aauaf();

    public interface RollBackScrollListener {
        int getScrollYDistance();
    }

    public class aauaf implements GestureDetector.OnGestureListener {
        public aauaf() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            HwRollbackRuleDetector.this.f43913j.removeMessages(1);
            if (motionEvent == null || motionEvent2 == null || motionEvent.getY() >= motionEvent2.getY() || Math.abs(f11) <= Math.abs(f10)) {
                HwRollbackRuleDetector.this.f43907d = 0;
            } else {
                HwRollbackRuleDetector.m55333a(HwRollbackRuleDetector.this);
                HwRollbackRuleDetector.this.m55335a();
                if (HwRollbackRuleDetector.this.m55338b() && HwRollbackRuleDetector.this.m55340c()) {
                    HwRollbackRuleDetector.this.f43907d = 0;
                    HwRollbackRuleDetector.this.postEvent(HwRollbackRuleDetector.ROLLBACK_EVENT);
                }
                HwRollbackRuleDetector.this.f43913j.sendEmptyMessageDelayed(1, 1000L);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public class bzrwd extends Handler {
        public bzrwd() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            HwRollbackRuleDetector.this.f43907d = 0;
        }
    }

    public HwRollbackRuleDetector(RollBackScrollListener rollBackScrollListener) {
        this.f43908e = rollBackScrollListener;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        if (this.f43909f && (gestureDetector = this.f43906c) != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void postEvent(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = this.f43911h;
        if (cls == null || this.f43910g == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("executeEvent", String.class).invoke(this.f43910g, str);
        } catch (IllegalAccessException unused) {
            Log.w(f43897l, "com.huawei.decision.DecisionHelper.executeEvent() IllegalAccessException!");
        } catch (NoSuchMethodException unused2) {
            Log.w(f43897l, "com.huawei.decision.DecisionHelper no function executeEvent()!");
        } catch (InvocationTargetException unused3) {
            Log.w(f43897l, "com.huawei.decision.DecisionHelper.executeEvent() InvocationTargetException!");
        }
    }

    public void start(View view) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (view == null) {
            Log.w(f43897l, "view is null!");
            return;
        }
        if (this.f43909f) {
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            Log.w(f43897l, "context is null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f43912i = context;
        if (m55336a(context)) {
            try {
                Class<?> cls = Class.forName("com.huawei.decision.DecisionHelper");
                Object objNewInstance = cls.newInstance();
                cls.getDeclaredMethod("bindService", Context.class).invoke(objNewInstance, this.f43912i);
                this.f43906c = new GestureDetector(this.f43912i, this.f43914k);
                this.f43911h = cls;
                this.f43910g = objNewInstance;
                this.f43904a = view;
                this.f43909f = true;
            } catch (ReceiverCallNotAllowedException unused) {
                Log.w(f43897l, "There is a problem with the APP application scenario:BroadcastReceiver components are not allowed to register to receive intents");
            } catch (ClassNotFoundException unused2) {
                Log.w(f43897l, "com.huawei.decision.DecisionHelper not found!");
            } catch (IllegalAccessException unused3) {
                Log.w(f43897l, "com.huawei.decision.DecisionHelper.bindService() Illegal Access");
            } catch (InstantiationException unused4) {
                Log.w(f43897l, "com.huawei.decision.DecisionHelper.bindService() InstantiationException!");
            } catch (NoSuchMethodException unused5) {
                Log.w(f43897l, "com.huawei.decision.DecisionHelper no function bindService()");
            } catch (InvocationTargetException unused6) {
                Log.w(f43897l, "com.huawei.decision.DecisionHelper.bindService() Invocation Target");
            }
        }
    }

    public void stop() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f43909f) {
            if (this.f43912i == null) {
                Log.w(f43897l, "mServiceContext is null");
                return;
            }
            Class<?> cls = this.f43911h;
            if (cls != null && this.f43910g != null) {
                try {
                    cls.getDeclaredMethod("unbindService", Context.class).invoke(this.f43910g, this.f43912i);
                } catch (IllegalAccessException unused) {
                    Log.w(f43897l, "com.huawei.decision.DecisionHelper.unbindService() Illegal Access");
                } catch (NoSuchMethodException unused2) {
                    Log.w(f43897l, "com.huawei.decision.DecisionHelper no function unbindService()");
                } catch (InvocationTargetException unused3) {
                    Log.w(f43897l, "com.huawei.decision.DecisionHelper.unbindService() Invocation Target");
                }
                this.f43911h = null;
            }
            this.f43904a = null;
            this.f43906c = null;
            this.f43909f = false;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ int m55333a(HwRollbackRuleDetector hwRollbackRuleDetector) {
        int i10 = hwRollbackRuleDetector.f43907d;
        hwRollbackRuleDetector.f43907d = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m55338b() {
        return this.f43907d > 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m55340c() {
        RollBackScrollListener rollBackScrollListener = this.f43908e;
        return rollBackScrollListener != null && rollBackScrollListener.getScrollYDistance() > this.f43905b;
    }

    /* renamed from: a */
    private boolean m55336a(Context context) {
        if (context != null) {
            return (Settings.Secure.getInt(context.getContentResolver(), "com.huawei.recsys.LMT_FeatureRecStatus", 0) & 1) != 1;
        }
        Log.w(f43897l, "isRollbackUnused context is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55335a() {
        View view = this.f43904a;
        if (view != null) {
            this.f43905b = view.getHeight() * 3;
        }
    }
}
