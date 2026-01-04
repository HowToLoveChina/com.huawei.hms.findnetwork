package com.huawei.android.remotecontrol.p093ui.activation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import hu.C10343b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0209d;
import p520of.C11860j;
import p520of.C11866p;
import p575qe.C12347f;
import p664u0.C13108a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public class RemoteActivationUtil {

    /* renamed from: i */
    public static final String f20758i = "RemoteActivationUtil";

    /* renamed from: a */
    public ArrayList<InterfaceC4526d> f20759a;

    /* renamed from: b */
    public ArrayList<InterfaceC4525c> f20760b;

    /* renamed from: c */
    public ArrayList<InterfaceC4524b> f20761c;

    /* renamed from: d */
    public ActivationStatusReceiver f20762d;

    /* renamed from: e */
    public UnbandCodeReceiver f20763e;

    /* renamed from: f */
    public UnbandReceiver f20764f;

    /* renamed from: g */
    public InactiveReceiver f20765g;

    /* renamed from: h */
    public HandlerC4528f f20766h;

    public static class ActivationStatusReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20767a = false;

        /* renamed from: a */
        public void m27668a(Context context) {
            if (this.f20767a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_SUCCESS");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_APPEAL_SUCCESS");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_AUTH_FAILE");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f20767a = true;
        }

        /* renamed from: b */
        public void m27669b(Context context) {
            if (this.f20767a) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20767a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RemoteActivationUtil.m27647r().m27667z();
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C13981a.m83987d(RemoteActivationUtil.f20758i, "ActivationStatusReceiver--action=" + action);
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_SUCCESS".equals(action)) {
                Bundle extras = hiCloudSafeIntent.getExtras();
                if (extras == null) {
                    C13981a.m83988e(RemoteActivationUtil.f20758i, "ACTION_PHONEFINDER_REMOTEBINDREPORT_SUCCESS--bundle==null");
                    RemoteActivationUtil.m27647r().m27662u();
                    return;
                }
                String strM63695q = new C10343b(extras).m63695q("unbandingCode", "");
                if (!TextUtils.isEmpty(strM63695q)) {
                    RemoteActivationUtil.m27647r().m27666y(strM63695q);
                    return;
                } else {
                    C13981a.m83988e(RemoteActivationUtil.f20758i, "ACTION_PHONEFINDER_REMOTEBINDREPORT_SUCCESS--code is empty");
                    RemoteActivationUtil.m27647r().m27662u();
                    return;
                }
            }
            if (!"com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_APPEAL_SUCCESS".equals(action)) {
                if ("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL".equals(action)) {
                    RemoteActivationUtil.m27647r().m27663v();
                    return;
                }
                return;
            }
            Bundle extras2 = hiCloudSafeIntent.getExtras();
            if (extras2 != null) {
                String strM63695q2 = new C10343b(extras2).m63695q("unbandingCode", "");
                if (TextUtils.isEmpty(strM63695q2)) {
                    C13981a.m83988e(RemoteActivationUtil.f20758i, "ACTION_PHONEFINDER_REMOTEBINDREPORT_SUCCESS--code is empty");
                    RemoteActivationUtil.m27647r().m27662u();
                } else {
                    RemoteActivationUtil.m27647r().m27666y(strM63695q2);
                }
            } else {
                C13981a.m83988e(RemoteActivationUtil.f20758i, "ACTION_PHONEFINDER_REMOTEBINDREPORT_SUCCESS--bundle==null");
                RemoteActivationUtil.m27647r().m27662u();
            }
            RemoteActivationUtil.m27647r().m27654G();
        }
    }

    public static class InactiveReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20768a = false;

        /* renamed from: a */
        public void m27670a(Context context) {
            if (this.f20768a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f20768a = true;
        }

        /* renamed from: b */
        public void m27671b(Context context) {
            if (this.f20768a) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20768a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RemoteActivationUtil.m27647r().m27658p();
        }
    }

    public static class UnbandCodeReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20769a = false;

        /* renamed from: a */
        public void m27672a(Context context) {
            if (this.f20769a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_SUCCESS");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_FAIL");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f20769a = true;
        }

        /* renamed from: b */
        public void m27673b(Context context) {
            if (this.f20769a) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20769a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RemoteActivationUtil.m27647r().m27665x();
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C13981a.m83987d(RemoteActivationUtil.f20758i, "UnbandCodeReceiver--action=" + action);
            if (!"com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_SUCCESS".equals(action)) {
                if ("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_FAIL".equals(action)) {
                    RemoteActivationUtil.m27647r().m27664w(2);
                    return;
                }
                return;
            }
            Bundle extras = hiCloudSafeIntent.getExtras();
            if (extras == null) {
                C13981a.m83988e(RemoteActivationUtil.f20758i, "ACTION_PHONEFINDER_REMOTEBINDREPORT_SUCCESS--bundle==null");
                RemoteActivationUtil.m27647r().m27664w(2);
                return;
            }
            String strM63695q = new C10343b(extras).m63695q("unbandingCode", "");
            if (!TextUtils.isEmpty(strM63695q)) {
                RemoteActivationUtil.m27647r().m27666y(strM63695q);
            } else {
                C13981a.m83988e(RemoteActivationUtil.f20758i, "ACTION_PHONEFINDER_REMOTEBINDREPORT_SUCCESS--code is empty");
                RemoteActivationUtil.m27647r().m27664w(2);
            }
        }
    }

    public static class UnbandReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20770a = false;

        /* renamed from: a */
        public void m27674a(Context context) {
            if (this.f20770a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBIND_SUCCESS");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBIND_FAIL");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f20770a = true;
        }

        /* renamed from: b */
        public void m27675b(Context context) {
            if (this.f20770a) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20770a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            RemoteActivationUtil.m27647r().m27648A();
            String action = new HiCloudSafeIntent(intent).getAction();
            C13981a.m83987d(RemoteActivationUtil.f20758i, "UnbandReceiver--action=" + action);
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBIND_SUCCESS".equals(action)) {
                RemoteActivationUtil.m27647r().m27659q();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.RemoteActivationUtil$b */
    public interface InterfaceC4524b {
        /* renamed from: a */
        void mo27247a(boolean z10);
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.RemoteActivationUtil$c */
    public interface InterfaceC4525c {
        void onFinish();
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.RemoteActivationUtil$d */
    public interface InterfaceC4526d {
        /* renamed from: a */
        void mo27245a(int i10);

        /* renamed from: b */
        void mo27246b(String str);
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.RemoteActivationUtil$e */
    public static class C4527e {

        /* renamed from: a */
        public static RemoteActivationUtil f20771a = new RemoteActivationUtil();
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.RemoteActivationUtil$f */
    public static class HandlerC4528f extends Handler {
        public HandlerC4528f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                RemoteActivationUtil.m27647r().m27664w(2);
                RemoteActivationUtil.m27647r().m27667z();
            } else if (i10 == 2) {
                RemoteActivationUtil.m27647r().m27664w(2);
                RemoteActivationUtil.m27647r().m27665x();
            } else if (i10 == 3) {
                RemoteActivationUtil.m27647r().m27648A();
            } else {
                if (i10 != 4) {
                    return;
                }
                RemoteActivationUtil.m27647r().m27658p();
            }
        }
    }

    /* renamed from: r */
    public static RemoteActivationUtil m27647r() {
        return C4527e.f20771a;
    }

    /* renamed from: A */
    public final void m27648A() {
        C13981a.m83989i(f20758i, "onUnbandFinish");
        this.f20766h.removeMessages(3);
        this.f20764f.m27675b(C12347f.m74285n().m74301m());
    }

    /* renamed from: B */
    public void m27649B(InterfaceC4524b interfaceC4524b) {
        ArrayList<InterfaceC4524b> arrayList = this.f20761c;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC4524b);
    }

    /* renamed from: C */
    public void m27650C(InterfaceC4525c interfaceC4525c) {
        ArrayList<InterfaceC4525c> arrayList = this.f20760b;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC4525c);
    }

    /* renamed from: D */
    public void m27651D(InterfaceC4526d interfaceC4526d) {
        ArrayList<InterfaceC4526d> arrayList = this.f20759a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC4526d);
    }

    /* renamed from: E */
    public void m27652E() {
        C13981a.m83989i(f20758i, "startGetUnbindCode");
        if (!C0209d.m1333z1(C12347f.m74285n().m74301m())) {
            this.f20766h.postDelayed(new Runnable() { // from class: hg.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49508a.m27660s();
                }
            }, RippleView.SINGLE_RIPPLE_TIME);
            return;
        }
        this.f20763e.m27672a(C12347f.m74285n().m74301m());
        C11860j.m71026V0();
        this.f20766h.removeMessages(2);
        this.f20766h.sendEmptyMessageDelayed(2, 50000L);
    }

    /* renamed from: F */
    public void m27653F(String str) {
        C13981a.m83989i(f20758i, "startQueryActivationStatus");
        if (!C0209d.m1333z1(C12347f.m74285n().m74301m())) {
            this.f20766h.postDelayed(new Runnable() { // from class: hg.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49510a.m27661t();
                }
            }, RippleView.SINGLE_RIPPLE_TIME);
            return;
        }
        this.f20762d.m27668a(C12347f.m74285n().m74301m());
        C11866p.m71115n(false, str, 3).m75045o();
        this.f20766h.removeMessages(1);
        this.f20766h.sendEmptyMessageDelayed(1, 50000L);
    }

    /* renamed from: G */
    public void m27654G() {
        C13981a.m83989i(f20758i, "startUnband--isUnband=");
        this.f20764f.m27674a(C12347f.m74285n().m74301m());
        C11860j.m71028W0();
        this.f20766h.removeMessages(3);
        this.f20766h.sendEmptyMessageDelayed(3, 50000L);
    }

    /* renamed from: m */
    public void m27655m(InterfaceC4524b interfaceC4524b) {
        if (this.f20761c == null) {
            this.f20761c = new ArrayList<>();
        }
        if (this.f20761c.contains(interfaceC4524b)) {
            return;
        }
        this.f20761c.add(interfaceC4524b);
    }

    /* renamed from: n */
    public void m27656n(InterfaceC4525c interfaceC4525c) {
        if (this.f20760b == null) {
            this.f20760b = new ArrayList<>();
        }
        if (this.f20760b.contains(interfaceC4525c)) {
            return;
        }
        this.f20760b.add(interfaceC4525c);
    }

    /* renamed from: o */
    public void m27657o(InterfaceC4526d interfaceC4526d) {
        if (this.f20759a == null) {
            this.f20759a = new ArrayList<>();
        }
        if (this.f20759a.contains(interfaceC4526d)) {
            return;
        }
        this.f20759a.add(interfaceC4526d);
    }

    /* renamed from: p */
    public final void m27658p() {
        C13981a.m83989i(f20758i, "exitPhoneFinderFinish");
        this.f20766h.removeMessages(4);
        this.f20765g.m27671b(C12347f.m74285n().m74301m());
        AbstractC12139d.m72764c(C12347f.m74285n().m74301m());
        m27663v();
    }

    /* renamed from: q */
    public final void m27659q() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(f20758i, "startExitPhoneFinder--isInactive=");
        this.f20765g.m27670a(C12347f.m74285n().m74301m());
        C11860j.m71016Q0(C12347f.m74285n().m74301m());
        this.f20766h.removeMessages(4);
        this.f20766h.sendEmptyMessageDelayed(4, 50000L);
    }

    /* renamed from: s */
    public final /* synthetic */ void m27660s() {
        m27664w(1);
    }

    /* renamed from: t */
    public final /* synthetic */ void m27661t() {
        m27664w(1);
    }

    /* renamed from: u */
    public final void m27662u() {
        C13981a.m83989i(f20758i, "onActivationStatusNoCode");
        ArrayList<InterfaceC4524b> arrayList = this.f20761c;
        if (arrayList == null) {
            return;
        }
        Iterator<InterfaceC4524b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().mo27247a(false);
        }
    }

    /* renamed from: v */
    public final void m27663v() {
        C13981a.m83989i(f20758i, "onFinish");
        ArrayList<InterfaceC4525c> arrayList = this.f20760b;
        if (arrayList == null) {
            return;
        }
        Iterator<InterfaceC4525c> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    /* renamed from: w */
    public final void m27664w(int i10) {
        C13981a.m83988e(f20758i, "onGetUnbandCodeFailued--errorCode=" + i10);
        ArrayList<InterfaceC4526d> arrayList = this.f20759a;
        if (arrayList == null) {
            return;
        }
        Iterator<InterfaceC4526d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().mo27245a(i10);
        }
    }

    /* renamed from: x */
    public final void m27665x() {
        C13981a.m83989i(f20758i, "onGetUnbindCodeFinish");
        this.f20766h.removeMessages(2);
        this.f20763e.m27673b(C12347f.m74285n().m74301m());
    }

    /* renamed from: y */
    public final void m27666y(String str) {
        C13981a.m83989i(f20758i, "onGetUnbandCodeSuccess");
        ArrayList<InterfaceC4526d> arrayList = this.f20759a;
        if (arrayList == null) {
            return;
        }
        Iterator<InterfaceC4526d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().mo27246b(str);
        }
    }

    /* renamed from: z */
    public final void m27667z() {
        C13981a.m83989i(f20758i, "onQueryStatusFinish");
        this.f20766h.removeMessages(1);
        this.f20762d.m27669b(C12347f.m74285n().m74301m());
    }

    public RemoteActivationUtil() {
        this.f20762d = new ActivationStatusReceiver();
        this.f20763e = new UnbandCodeReceiver();
        this.f20764f = new UnbandReceiver();
        this.f20765g = new InactiveReceiver();
        this.f20766h = new HandlerC4528f();
    }
}
