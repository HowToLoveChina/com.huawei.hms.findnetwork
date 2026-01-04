package com.huawei.hms.findnetwork.sdk;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.text.TextUtils;
import com.huawei.hms.findnetwork.threadpool.ThreadExec;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.List;

/* renamed from: com.huawei.hms.findnetwork.sdk.b */
/* loaded from: classes8.dex */
public class C5345b {

    /* renamed from: l */
    public static volatile C5345b f24762l;

    /* renamed from: a */
    public volatile boolean f24763a;

    /* renamed from: b */
    public int f24764b;

    /* renamed from: c */
    public AudioRecord f24765c;

    /* renamed from: e */
    public Runnable f24767e;

    /* renamed from: f */
    public Context f24768f;

    /* renamed from: g */
    public int f24769g;

    /* renamed from: h */
    public int f24770h;

    /* renamed from: i */
    public long f24771i;

    /* renamed from: k */
    public InterfaceC5346b0 f24773k;

    /* renamed from: d */
    public final C5385o0 f24766d = new C5385o0(4);

    /* renamed from: j */
    public boolean f24772j = false;

    /* renamed from: b */
    public static C5345b m31985b() {
        if (f24762l == null) {
            synchronized (C5345b.class) {
                try {
                    if (f24762l == null) {
                        f24762l = new C5345b();
                    }
                } finally {
                }
            }
        }
        return f24762l;
    }

    /* renamed from: c */
    public long m31994c() {
        return this.f24771i;
    }

    /* renamed from: d */
    public boolean m31995d() {
        return this.f24772j;
    }

    /* renamed from: e */
    public final void m31996e() {
        try {
            if (this.f24765c != null) {
                HmsFindSDKLog.m32127i("AudioRecordManager", "stop ultrasound measure, audio record release");
                this.f24765c.release();
                this.f24765c = null;
            }
        } catch (IllegalArgumentException unused) {
            HmsFindSDKLog.m32126e("AudioRecordManager", "can not stop audio record");
        }
        this.f24766d.m32043a();
        HmsFindSDKLog.m32127i("AudioRecordManager", "mRecordByteArrayPool is deInit");
        ThreadExec.removeTask(this.f24767e);
        this.f24767e = null;
    }

    /* renamed from: f */
    public void m31997f() {
        HmsFindSDKLog.m32127i("AudioRecordManager", "call stopRecord method");
        this.f24763a = false;
        m31996e();
    }

    /* renamed from: a */
    public final int m31986a(int i10, InterfaceC5346b0 interfaceC5346b0, byte[] bArr, C5382n0 c5382n0) {
        int i11 = (int) (i10 * 7.5f);
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            if (!this.f24763a) {
                HmsFindSDKLog.m32127i("AudioRecordManager", "measure status is not running");
                return -1;
            }
            int i14 = this.f24770h;
            if (i14 != -1) {
                this.f24770h = i14 + 1;
            }
            if (this.f24770h == 23) {
                this.f24771i = m31988a(this.f24768f);
                HmsFindSDKLog.m32127i("AudioRecordManager", "startRecordTime :" + this.f24771i);
                interfaceC5346b0.onStart();
                this.f24770h = -1;
            }
            int i15 = i11 - i12;
            AudioRecord audioRecord = this.f24765c;
            int i16 = i15 >= i10 ? audioRecord.read(bArr, i12, i10) : audioRecord.read(bArr, i12, i15);
            if (i16 < 0) {
                HmsFindSDKLog.m32128w("AudioRecordManager", "audio record read failed code is: " + i16 + ",diff is: " + i15 + ",minBufferSize is: " + i10);
                this.f24766d.m32044a(c5382n0);
                return i16;
            }
            i12 += i16;
            i13 = i16;
        }
        return i13;
    }

    /* renamed from: b */
    public final void m31992b(int i10, InterfaceC5346b0 interfaceC5346b0) {
        HmsFindSDKLog.m32127i("AudioRecordManager", "start circle record thread");
        try {
            this.f24773k = interfaceC5346b0;
            if (this.f24765c == null) {
                HmsFindSDKLog.m32127i("AudioRecordManager", "audioRecord is null");
                if (interfaceC5346b0 != null) {
                    return;
                } else {
                    return;
                }
            }
            this.f24766d.m32046b((int) (i10 * 7.5f));
            HmsFindSDKLog.m32127i("AudioRecordManager", "byteArraySize: " + this.f24766d.m32045b());
            C5382n0 c5382n0M32047c = this.f24766d.m32047c();
            if (c5382n0M32047c == null) {
                HmsFindSDKLog.m32127i("AudioRecordManager", "record byte array pool init failed.");
                HmsFindSDKLog.m32127i("AudioRecordManager", "into finally");
                m31997f();
                if (interfaceC5346b0 != null) {
                    interfaceC5346b0.mo31998a();
                    return;
                }
                return;
            }
            byte[] bArrM32039a = c5382n0M32047c.m32039a();
            if (bArrM32039a.length == 0) {
                HmsFindSDKLog.m32127i("AudioRecordManager", "record byte array is empty");
                HmsFindSDKLog.m32127i("AudioRecordManager", "into finally");
                m31997f();
                if (interfaceC5346b0 != null) {
                    interfaceC5346b0.mo31998a();
                    return;
                }
                return;
            }
            this.f24763a = true;
            this.f24771i = -1L;
            for (int i11 = 0; i11 < 2; i11++) {
                if (!this.f24763a) {
                    HmsFindSDKLog.m32127i("AudioRecordManager", "into finally");
                    m31997f();
                    if (interfaceC5346b0 != null) {
                        interfaceC5346b0.mo31998a();
                        return;
                    }
                    return;
                }
                if (this.f24765c.read(bArrM32039a, 0, i10) < 0) {
                    HmsFindSDKLog.m32127i("AudioRecordManager", "beginning of the record failed");
                    HmsFindSDKLog.m32127i("AudioRecordManager", "into finally");
                    m31997f();
                    if (interfaceC5346b0 != null) {
                        interfaceC5346b0.mo31998a();
                        return;
                    }
                    return;
                }
            }
            this.f24766d.m32044a(c5382n0M32047c);
            m31990a(i10, interfaceC5346b0);
            HmsFindSDKLog.m32127i("AudioRecordManager", "into finally");
            m31997f();
            if (interfaceC5346b0 != null) {
                interfaceC5346b0.mo31998a();
            }
        } finally {
            HmsFindSDKLog.m32127i("AudioRecordManager", "into finally");
            m31997f();
            if (interfaceC5346b0 != null) {
                interfaceC5346b0.mo31998a();
            }
        }
    }

    /* renamed from: a */
    public int m31987a(Context context, int i10) throws IllegalStateException {
        this.f24768f = context;
        HmsFindSDKLog.m32127i("AudioRecordManager", "audio record init ---");
        if (this.f24765c != null) {
            m31996e();
        }
        int minBufferSize = AudioRecord.getMinBufferSize(48000, 12, 2);
        this.f24764b = minBufferSize;
        if (minBufferSize > 1048576 || minBufferSize < 0) {
            HmsFindSDKLog.m32127i("AudioRecordManager", "audio record buffer size is illegal");
            return -1;
        }
        try {
            if (this.f24765c == null) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.setParameters("RECORD_SCENE=off");
                    HmsFindSDKLog.m32127i("AudioRecordManager", "AudioManager set setParameters");
                }
                if (audioManager != null) {
                    int mode = audioManager.getMode();
                    HmsFindSDKLog.m32127i("AudioRecordManager", "AudioManager mode：" + mode);
                    if (mode != 2 && mode != 3) {
                        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
                        if (activeRecordingConfigurations != null && !activeRecordingConfigurations.isEmpty()) {
                            HmsFindSDKLog.m32127i("AudioRecordManager", "the mic is occupied");
                            return -2;
                        }
                    }
                    HmsFindSDKLog.m32127i("AudioRecordManager", "phone is in call, the mic is occupied");
                    return -2;
                }
                AudioRecord audioRecord = new AudioRecord(i10 == 0 ? 1 : 6, 48000, 12, 2, this.f24764b);
                this.f24765c = audioRecord;
                audioRecord.startRecording();
                HmsFindSDKLog.m32127i("AudioRecordManager", "audioParam: " + i10 + " audio record init success---");
                return 0;
            }
        } catch (IllegalArgumentException unused) {
            AudioRecord audioRecord2 = this.f24765c;
            if (audioRecord2 != null) {
                audioRecord2.release();
            }
            HmsFindSDKLog.m32126e("AudioRecordManager", "audio record start failed");
        }
        return -1;
    }

    /* renamed from: b */
    public void m31993b(final InterfaceC5346b0 interfaceC5346b0) {
        if (this.f24767e == null) {
            Runnable runnable = new Runnable() { // from class: fq.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48003a.m31983a(interfaceC5346b0);
                }
            };
            this.f24767e = runnable;
            ThreadExec.execNormalTask("AudioRecordManager", runnable);
        }
    }

    /* renamed from: a */
    public final long m31988a(Context context) throws NumberFormatException {
        Object systemService = context.getSystemService("audio");
        if (!(systemService instanceof AudioManager)) {
            HmsFindSDKLog.m32127i("AudioRecordManager", "can not get audio manager");
            return -1L;
        }
        String parameters = ((AudioManager) systemService).getParameters("nearby_record_time");
        if (TextUtils.isEmpty(parameters)) {
            return -1L;
        }
        String[] strArrSplit = parameters.split(",");
        if (strArrSplit.length != 2) {
            return -1L;
        }
        String str = strArrSplit[0] + "000000";
        String str2 = strArrSplit[1];
        long j10 = Long.parseLong(str);
        long j11 = Long.parseLong(str2);
        HmsFindSDKLog.m32127i("AudioRecordManager", "split[0]=" + strArrSplit[0] + "  split[1]=" + strArrSplit[1]);
        return j10 + j11;
    }

    /* renamed from: a */
    public void m31989a() {
        HmsFindSDKLog.m32127i("AudioRecordManager", "callListenerStart mRecordListener is " + this.f24773k);
        InterfaceC5346b0 interfaceC5346b0 = this.f24773k;
        if (interfaceC5346b0 == null) {
            return;
        }
        interfaceC5346b0.onStart();
    }

    /* renamed from: a */
    public final void m31990a(int i10, InterfaceC5346b0 interfaceC5346b0) {
        this.f24770h = 0;
        this.f24769g = 0;
        while (true) {
            int i11 = 0;
            while (this.f24763a) {
                C5382n0 c5382n0M32047c = this.f24766d.m32047c();
                if (c5382n0M32047c == null) {
                    HmsFindSDKLog.m32127i("AudioRecordManager", "calculate record byte array is null.");
                } else {
                    byte[] bArrM32039a = c5382n0M32047c.m32039a();
                    if (bArrM32039a.length == 0) {
                        HmsFindSDKLog.m32127i("AudioRecordManager", "circle record byte array is empty");
                        return;
                    }
                    int iM31986a = m31986a(i10, interfaceC5346b0, bArrM32039a, c5382n0M32047c);
                    if (iM31986a == -1) {
                        HmsFindSDKLog.m32126e("AudioRecordManager", "audioRecordReadResult is error");
                        return;
                    }
                    if (iM31986a == -2) {
                        i11++;
                        if (i11 == 2) {
                            HmsFindSDKLog.m32127i("AudioRecordManager", "bad value two times");
                            return;
                        }
                    } else {
                        if (iM31986a < 0) {
                            HmsFindSDKLog.m32127i("AudioRecordManager", "audio record failed, code is: " + iM31986a);
                            return;
                        }
                        C5389p1.m32060a().m32085a(this.f24769g, bArrM32039a);
                        this.f24769g++;
                        this.f24766d.m32044a(c5382n0M32047c);
                    }
                }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31983a(InterfaceC5346b0 interfaceC5346b0) {
        m31992b(this.f24764b, interfaceC5346b0);
    }

    /* renamed from: a */
    public void m31991a(boolean z10) {
        this.f24772j = z10;
    }
}
