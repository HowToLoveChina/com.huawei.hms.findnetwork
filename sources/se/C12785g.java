package se;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import com.huawei.airlink.IFinderTagCallback;
import com.huawei.android.remotecontrol.alarm.AlarmDialogActivity;
import com.huawei.android.remotecontrol.notification.PhoneFinderNotificationMgr;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0224k0;
import p015ak.C0238w;
import p514o9.C11829c;
import p521og.C11873f;
import p521og.C11874g;
import p521og.C11877j;
import p521og.C11881n;
import p664u0.C13108a;
import p709vj.C13452e;
import p809yg.C13981a;
import tj.C13019a;

/* renamed from: se.g */
/* loaded from: classes4.dex */
public class C12785g {

    /* renamed from: r */
    public static volatile C12785g f58435r;

    /* renamed from: s */
    public static AudioManager.OnAudioFocusChangeListener f58436s = new AudioManager.OnAudioFocusChangeListener() { // from class: se.e
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i10) {
            C13981a.m83989i("AlarmManager", "onAudioFocusChange");
        }
    };

    /* renamed from: t */
    public static boolean f58437t = false;

    /* renamed from: a */
    public Vibrator f58438a;

    /* renamed from: b */
    public boolean f58439b;

    /* renamed from: d */
    public boolean f58441d;

    /* renamed from: e */
    public MediaPlayer f58442e;

    /* renamed from: f */
    public AudioManager f58443f;

    /* renamed from: i */
    public d f58446i;

    /* renamed from: j */
    public b f58447j;

    /* renamed from: k */
    public c f58448k;

    /* renamed from: c */
    public IFinderTagCallback f58440c = null;

    /* renamed from: g */
    public int f58444g = 40;

    /* renamed from: h */
    public int f58445h = -1;

    /* renamed from: l */
    public boolean f58449l = false;

    /* renamed from: m */
    public boolean f58450m = false;

    /* renamed from: n */
    public Timer f58451n = null;

    /* renamed from: p */
    public Context f58453p = C11873f.m71178f().m71181c();

    /* renamed from: q */
    public boolean f58454q = true;

    /* renamed from: o */
    public Handler f58452o = new Handler(new Handler.Callback() { // from class: se.f
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f58434a.m76742v(message);
        }
    });

    /* renamed from: se.g$a */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IllegalStateException {
            C13981a.m83989i("AlarmManager", "startTimer run");
            C12785g.m76715s().m76738p(null);
        }
    }

    /* renamed from: se.g$b */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = new SafeIntent(intent).getAction();
            C13981a.m83989i("AlarmManager", "onReceive : " + action);
            if ("action_alarm_dialog_on_destroy".equals(action)) {
                C12785g.this.m76739q();
            }
        }

        public /* synthetic */ b(C12785g c12785g, a aVar) {
            this();
        }
    }

    /* renamed from: se.g$c */
    public class c extends PhoneStateListener {
        public c() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i10, String str) throws IllegalStateException {
            super.onCallStateChanged(i10, str);
            C13981a.m83987d("AlarmManager", "onCallStateChanged : " + i10);
            if (i10 == 0) {
                C12785g.this.m76731i();
            } else if (i10 == 2) {
                C12785g.this.m76730h();
            }
        }

        public /* synthetic */ c(C12785g c12785g, a aVar) {
            this();
        }
    }

    /* renamed from: se.g$d */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C13981a.m83989i("AlarmManager", "onReceive : " + action);
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C12785g.this.f58454q = false;
                C12785g.this.m76745z();
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                C12785g.this.m76718A();
                C12785g.this.f58454q = true;
            } else if (Constants.VOLUME_CHANGED_ACTION.equals(action)) {
                C13981a.m83987d("AlarmManager", "volume : " + safeIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1));
                C12785g.this.m76734l();
            }
        }

        public /* synthetic */ d(C12785g c12785g, a aVar) {
            this();
        }
    }

    public C12785g() {
        a aVar = null;
        this.f58446i = new d(this, aVar);
        this.f58447j = new b(this, aVar);
    }

    /* renamed from: E */
    public static void m76707E(Context context) {
        C13981a.m83989i("AlarmManager", "sendFinishAlarmDialog");
        C13108a.m78878b(context).m78881d(new Intent("action_finish_alarm_dialog"));
    }

    /* renamed from: s */
    public static C12785g m76715s() {
        if (f58435r == null) {
            synchronized (C12785g.class) {
                try {
                    if (f58435r == null) {
                        f58435r = new C12785g();
                    }
                } finally {
                }
            }
        }
        return f58435r;
    }

    /* renamed from: u */
    public static boolean m76716u() {
        return f58437t;
    }

    /* renamed from: A */
    public final void m76718A() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        boolean zM76744y = m76744y();
        if (zM76744y) {
            C11881n.m71348K(activityOptionsMakeBasic, 1, this.f58453p);
        }
        Intent intent = new Intent(this.f58453p, (Class<?>) AlarmDialogActivity.class);
        intent.putExtra("hw_frp_token", C11881n.m71363m(this.f58453p));
        intent.putExtra("full_screen", zM76744y);
        C0224k0.m1543M(this.f58453p, intent, activityOptionsMakeBasic.toBundle(), C0224k0.f833a);
    }

    /* renamed from: B */
    public final void m76719B() throws IllegalStateException {
        C13981a.m83989i("AlarmManager", "playAlarmRing");
        this.f58442e.start();
        f58437t = true;
    }

    /* renamed from: C */
    public final void m76720C() {
        if (-1 == this.f58445h) {
            this.f58445h = this.f58443f.getStreamVolume(4);
            C13981a.m83989i("AlarmManager", "currentVolume:" + this.f58445h);
        }
        this.f58443f.requestAudioFocus(f58436s, 4, 1);
        int streamMaxVolume = this.f58443f.getStreamMaxVolume(4);
        C13981a.m83989i("AlarmManager", "maxVolume is:" + streamMaxVolume);
        this.f58443f.setStreamVolume(4, streamMaxVolume, 0);
        this.f58442e.setLooping(true);
    }

    /* renamed from: D */
    public final void m76721D() {
        if (this.f58449l || this.f58446i == null || this.f58447j == null) {
            return;
        }
        C13981a.m83989i("AlarmManager", "registerScreenListener");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction(Constants.VOLUME_CHANGED_ACTION);
        this.f58453p.registerReceiver(this.f58446i, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("action_alarm_dialog_on_destroy");
        this.f58453p.registerReceiver(this.f58447j, intentFilter2, "com.huawei.remotocontrol.permission.REMOTECALL", null);
        this.f58449l = true;
    }

    /* renamed from: F */
    public final void m76722F() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zM71236U = C11877j.m71236U(this.f58453p);
        if (!C4452n.m27030j(this.f58453p) || zM71236U) {
            C13981a.m83989i("AlarmManager", "screen not lock");
        } else {
            m76735m();
            C13981a.m83989i("AlarmManager", "screen lock, create AlarmNotification");
        }
    }

    /* renamed from: G */
    public void m76723G(boolean z10, boolean z11, IFinderTagCallback iFinderTagCallback) {
        this.f58439b = z10;
        this.f58441d = z11;
        this.f58440c = iFinderTagCallback;
        C13981a.m83989i("AlarmManager", "startAlarm");
        m76727K(false, null);
        m76728L();
        m76737o();
        m76732j();
        if (C11877j.m71236U(this.f58453p) || C0224k0.m1552g() == 0) {
            return;
        }
        C13981a.m83987d("AlarmManager", "send to sub user");
        m76718A();
    }

    /* renamed from: H */
    public void m76724H() {
        if (C0224k0.m1532B(this.f58453p)) {
            return;
        }
        C13981a.m83989i("AlarmManager", "startAlarm In SubUser");
        m76728L();
        m76732j();
        m76725I();
        m76722F();
    }

    /* renamed from: I */
    public final void m76725I() {
        C13981a.m83989i("AlarmManager", "startTimer");
        if (this.f58451n == null) {
            this.f58451n = new Timer();
        }
        this.f58451n.schedule(new a(), 150000L);
    }

    /* renamed from: J */
    public final void m76726J() {
        long[] jArr = {1000, RippleView.SINGLE_RIPPLE_TIME, 1000, 3000, 1000, 5000, 1000, 10000};
        Vibrator vibrator = this.f58438a;
        if (vibrator != null) {
            vibrator.cancel();
            this.f58438a = null;
        }
        Vibrator vibrator2 = (Vibrator) this.f58453p.getSystemService("vibrator");
        this.f58438a = vibrator2;
        vibrator2.vibrate(jArr, -1);
    }

    /* renamed from: K */
    public void m76727K(boolean z10, IFinderTagCallback iFinderTagCallback) throws IllegalStateException {
        C13981a.m83989i("AlarmManager", "stopAlarm, flag: " + z10);
        MediaPlayer mediaPlayer = this.f58442e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f58442e.reset();
            this.f58442e.release();
            this.f58442e = null;
            f58437t = false;
        }
        Vibrator vibrator = this.f58438a;
        if (vibrator != null) {
            vibrator.cancel();
            this.f58438a = null;
        }
        if (-1 != this.f58445h) {
            if (this.f58443f == null) {
                this.f58443f = (AudioManager) this.f58453p.getSystemService("audio");
            }
            this.f58443f.abandonAudioFocus(f58436s);
            this.f58443f.setStreamVolume(4, this.f58445h, 0);
            this.f58445h = -1;
        }
        this.f58443f = null;
        if (z10 && this.f58440c != null) {
            try {
                try {
                    C13981a.m83989i("AlarmManager", "stopAlarm callback");
                    this.f58440c.onTagBindResult(C13452e.m80781L().m80950o(), 2);
                } catch (Exception e10) {
                    C13981a.m83988e("AlarmManager", "stopAlarm e: " + e10.getMessage());
                }
            } finally {
                this.f58440c = null;
            }
        }
        if (!z10 || iFinderTagCallback == null) {
            return;
        }
        try {
            C13981a.m83989i("AlarmManager", "stopAlarm stopCallback");
            iFinderTagCallback.onTagBindResult(C13452e.m80781L().m80950o(), 0);
        } catch (Exception e11) {
            C13981a.m83988e("AlarmManager", "stopAlarm stopCallback e: " + e11.getMessage());
        }
    }

    /* renamed from: L */
    public final void m76728L() {
        C13981a.m83989i("AlarmManager", "stopTimer");
        Timer timer = this.f58451n;
        if (timer != null) {
            timer.cancel();
            this.f58451n = null;
        }
    }

    /* renamed from: M */
    public final void m76729M() {
        d dVar;
        C13981a.m83989i("AlarmManager", "unregisterScreenListener");
        if (!this.f58449l || (dVar = this.f58446i) == null || this.f58447j == null) {
            return;
        }
        this.f58453p.unregisterReceiver(dVar);
        this.f58453p.unregisterReceiver(this.f58447j);
        this.f58449l = false;
    }

    /* renamed from: h */
    public final void m76730h() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.f58442e;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    /* renamed from: i */
    public final void m76731i() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.f58442e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    /* renamed from: j */
    public final void m76732j() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("AlarmManager", "beginScreenListen");
        m76721D();
        m76743x();
        m76741t();
    }

    /* renamed from: k */
    public final void m76733k() {
        new PhoneFinderNotificationMgr(this.f58453p).m26376a(564);
    }

    /* renamed from: l */
    public void m76734l() {
        C13981a.m83989i("AlarmManager", "checkAlarmVolumeChanged");
        AudioManager audioManager = this.f58443f;
        if (audioManager == null || this.f58442e == null) {
            return;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(4);
        if (!this.f58442e.isPlaying() || this.f58443f.getStreamVolume(4) == streamMaxVolume) {
            return;
        }
        this.f58443f.setStreamVolume(4, streamMaxVolume, 0);
    }

    /* renamed from: m */
    public final void m76735m() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String string = this.f58453p.getString(R$string.start_finder_phone_new);
        String string2 = this.f58453p.getString(R$string.alarm_msg_default_new);
        String string3 = this.f58453p.getString(R$string.hicloud_service_location_change_10);
        Intent intent = new Intent(this.f58453p, (Class<?>) AlarmDialogActivity.class);
        C0209d.m1302r2(intent, this.f58453p.getPackageName());
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        boolean zM76744y = m76744y();
        intent.putExtra("full_screen", zM76744y);
        if (zM76744y) {
            C11881n.m71348K(activityOptionsMakeBasic, 1, this.f58453p);
        }
        C0216g0.m1402e(this.f58453p).m1408F(intent, "SOURCE_ID_ALARM_NOTIFY");
        PendingIntent pendingIntentM1252f0 = C0209d.m1252f0(this.f58453p, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK, activityOptionsMakeBasic.toBundle());
        NotificationCompat.Builder builderM1666g = C0238w.m1663f().m1666g(this.f58453p, string);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", string);
        bundle.putBoolean("hw_enable_small_icon", true);
        builderM1666g.m3824y(R$drawable.ic_findmyphone_new).m3811l(string2).m3810k(string3).m3821v(-1).m3823x(false).m3825z(new NotificationCompat.C0605b()).m3817r("com.huawei.android.findphone").m3807h(true).m3809j(pendingIntentM1252f0).m3803c(bundle);
        new PhoneFinderNotificationMgr(this.f58453p).m26378c(564, builderM1666g.m3804d());
    }

    /* renamed from: n */
    public final void m76736n() {
        C13981a.m83989i("AlarmManager", "endListenPhoneState ");
        if (!this.f58450m || this.f58448k == null) {
            return;
        }
        ((TelephonyManager) this.f58453p.getSystemService("phone")).listen(this.f58448k, 0);
        this.f58450m = false;
    }

    /* renamed from: o */
    public final void m76737o() throws IllegalStateException {
        C13981a.m83989i("AlarmManager", "executeAlarm");
        if (this.f58439b) {
            if (this.f58442e == null) {
                if (this.f58443f == null) {
                    this.f58443f = (AudioManager) this.f58453p.getSystemService("audio");
                }
                try {
                    Context context = this.f58453p;
                    this.f58442e = MediaPlayer.create(context, C11874g.m71188a(context, "phonefinder_alarm"), new AudioAttributes.Builder().setLegacyStreamType(4).build(), this.f58443f.generateAudioSessionId());
                } catch (Exception e10) {
                    C13981a.m83988e("AlarmManager", "executeAlarm" + e10.getMessage());
                }
            }
            if (this.f58442e != null) {
                this.f58444g = 40;
                m76720C();
                m76719B();
                m76725I();
            }
        }
        if (this.f58441d) {
            m76726J();
        }
        C13981a.m83989i("AlarmManager", "executeAlarm end");
    }

    /* renamed from: p */
    public void m76738p(IFinderTagCallback iFinderTagCallback) throws IllegalStateException {
        C13981a.m83989i("AlarmManager", "finishAlarm");
        m76729M();
        m76733k();
        m76707E(this.f58453p);
        m76727K(true, iFinderTagCallback);
        m76728L();
        m76736n();
    }

    /* renamed from: q */
    public void m76739q() {
        C13981a.m83989i("AlarmManager", "finishAlarmOnDialogDestroy");
        m76729M();
        m76733k();
        m76727K(true, null);
        m76728L();
        m76736n();
    }

    /* renamed from: r */
    public boolean m76740r() {
        return this.f58454q;
    }

    /* renamed from: t */
    public final void m76741t() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("AlarmManager", "getScreenState");
        boolean zM71236U = C11877j.m71236U(this.f58453p);
        boolean zM27030j = C4452n.m27030j(this.f58453p);
        if (zM71236U) {
            return;
        }
        if (!zM27030j) {
            m76718A();
        } else {
            this.f58454q = false;
            m76745z();
        }
    }

    /* renamed from: v */
    public final /* synthetic */ boolean m76742v(Message message) throws IllegalStateException {
        if (message.what != 0) {
            return false;
        }
        m76738p(null);
        return false;
    }

    /* renamed from: x */
    public final void m76743x() {
        C13981a.m83989i("AlarmManager", "listenPhoneState ");
        if (this.f58450m) {
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f58453p.getSystemService("phone");
        if (this.f58448k == null) {
            this.f58448k = new c(this, null);
        }
        telephonyManager.listen(this.f58448k, 32);
        this.f58450m = true;
    }

    /* renamed from: y */
    public final boolean m76744y() {
        if (!C0209d.m1170F1()) {
            C13981a.m83989i("AlarmManager", "not pad");
            return true;
        }
        if (!C0209d.m1245d1(C0213f.m1377a(), WapFindPhoneActivity.class.getName())) {
            C13981a.m83989i("AlarmManager", "not foreground");
            return true;
        }
        if (C11829c.m70502B0(C13019a.m78347n().m78351m())) {
            C13981a.m83989i("AlarmManager", "not HwSplit");
            return true;
        }
        C13981a.m83989i("AlarmManager", "needFullScreen = false");
        return false;
    }

    /* renamed from: z */
    public final void m76745z() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m76722F();
    }
}
