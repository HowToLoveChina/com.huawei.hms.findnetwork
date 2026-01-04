package p341hj;

import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.logic.threadpool.TaskHandle;
import com.huawei.android.hicloud.logic.threadpool.TaskObject;
import com.huawei.android.hicloud.logic.threadpool.TaskQueue;
import fk.C9721b;
import p054cj.C1442a;

/* renamed from: hj.e */
/* loaded from: classes5.dex */
public abstract class AbstractC10222e implements TaskObject {

    /* renamed from: a */
    public static TaskQueue f49568a;

    public AbstractC10222e() {
        synchronized (AbstractC10222e.class) {
            try {
                if (f49568a == null) {
                    f49568a = new TaskQueue(1, 8);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: c */
    public void mo16408c() {
        if (Thread.interrupted()) {
            C1442a.m8288d("BaseTask", "the current thread has been interrupted");
        }
    }

    /* renamed from: e */
    public void m63379e(Handler handler, int i10, C9721b c9721b) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = c9721b.m60659c();
        messageObtainMessage.obj = c9721b.getMessage();
        handler.sendMessage(messageObtainMessage);
    }

    /* renamed from: f */
    public void m63380f(Handler handler, int i10, Object obj) {
        if (handler == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = 0;
        messageObtainMessage.obj = obj;
        handler.sendMessage(messageObtainMessage);
    }

    /* renamed from: g */
    public TaskHandle m63381g() {
        TaskQueue taskQueue = f49568a;
        if (taskQueue != null) {
            return taskQueue.m16409a(this);
        }
        return null;
    }
}
