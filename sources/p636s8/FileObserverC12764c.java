package p636s8;

import android.content.Context;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import md.C11440c;
import p514o9.C11839m;

/* renamed from: s8.c */
/* loaded from: classes2.dex */
public class FileObserverC12764c extends FileObserver {

    /* renamed from: a */
    public final Object f58411a;

    /* renamed from: b */
    public Handler f58412b;

    /* renamed from: c */
    public volatile boolean f58413c;

    /* renamed from: d */
    public Context f58414d;

    public FileObserverC12764c(String str, Handler handler, Context context) {
        super(str, 4095);
        this.f58411a = new Object();
        this.f58412b = null;
        this.f58413c = false;
        this.f58412b = handler;
        this.f58414d = context;
    }

    /* renamed from: a */
    public final void m76602a() {
        synchronized (this.f58411a) {
            try {
                if (this.f58413c) {
                    C11839m.m70686d("RecordingChangeListener", "remove message");
                    this.f58412b.removeMessages(SyncType.AUTO_SYNC_RECORD);
                } else {
                    C11839m.m70686d("RecordingChangeListener", "set isChange true");
                    this.f58413c = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m76603b();
    }

    /* renamed from: b */
    public void m76603b() {
        synchronized (this.f58411a) {
            try {
                boolean zM68531i = C11440c.m68531i("autorecordingkey");
                C11839m.m70686d("RecordingChangeListener", "isChange = " + this.f58413c + ", isBacking = " + zM68531i);
                if (this.f58413c && !zM68531i) {
                    Message message = new Message();
                    message.what = SyncType.AUTO_SYNC_RECORD;
                    this.f58412b.sendMessageDelayed(message, 10000L);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i10, String str) {
        if (i10 != 2 && i10 != 8 && i10 != 64 && i10 != 128 && i10 != 256) {
            if (i10 == 1024 || i10 == 2048) {
                C12763b.m76596g().m76601k();
                C12763b.m76596g().m76598e();
                return;
            }
            return;
        }
        C11839m.m70686d("RecordingChangeListener", RewardMethods.ON_EVENT);
        if (!CloudSyncUtil.m16052u0(this.f58414d, "autorecordingkey") || C11440c.m68531i("autorecordingkey") || CloudSyncUtil.m15939A(this.f58414d) < 10) {
            return;
        }
        m76602a();
    }
}
