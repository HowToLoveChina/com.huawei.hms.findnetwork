package com.huawei.android.hicloud.cloudbackup.process;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.Vector;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12365b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p779xl.InterfaceC13828a;
import pm.InterfaceC12198y;

/* loaded from: classes2.dex */
public abstract class CacheTask extends AbstractC12365b {
    private static final String TAG = "CacheTask";
    protected String errMsg;
    protected InterfaceC12198y loadController;
    private static final Object MODULE_LOCK = new Object();
    private static final Object WAIT_LOCK = new Object();
    private final Object lockCode = new Object();
    public Vector<String> modules = new Vector<>();
    private boolean pause = false;
    private boolean abort = false;
    private State state = State.NOT_STARTED;
    private int errCode = -1;
    protected C9721b exception = null;
    private ReadWriteLock pauseWDLock = new ReentrantReadWriteLock();
    private ReadWriteLock abortWDLock = new ReentrantReadWriteLock();
    private ReadWriteLock stateWDLock = new ReentrantReadWriteLock();

    public static class AsyncTask extends AbstractC12367d {
        IAsyncTask async;

        public AsyncTask(IAsyncTask iAsyncTask) {
            this.async = iAsyncTask;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            IAsyncTask iAsyncTask = this.async;
            if (iAsyncTask != null) {
                iAsyncTask.run();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    public interface IAsyncTask {
        void run();
    }

    public enum State {
        NOT_STARTED,
        PREPARE,
        RUN,
        CANCEL,
        CREATED,
        UPDATED,
        DONE
    }

    public CacheTask() {
        InterfaceC13828a interfaceC13828a = (InterfaceC13828a) getClass().getAnnotation(InterfaceC13828a.class);
        if (interfaceC13828a == null) {
            C11839m.m70688i(TAG, "loadControllerAnnotation is null");
            return;
        }
        try {
            this.loadController = interfaceC13828a.controller().newInstance();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "get loadController occurred Exception:" + e10.getMessage());
        }
    }

    public static Context getContext() {
        return C0213f.m1377a();
    }

    public static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    @Override // p581qk.AbstractC12365b
    public void abort() {
        setAbort(true);
        setState(State.CANCEL);
    }

    public void addModule(String str) {
        synchronized (MODULE_LOCK) {
            this.modules.add(str);
        }
    }

    public void callback(Message message, long j10) {
        CBCallBack.getInstance().sendMessageDelayed(message, j10);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        setAbort(true);
        setState(State.CANCEL);
        return super.cancel();
    }

    public abstract boolean condition();

    public void executeAsyncTask(AsyncTask asyncTask) {
        C12515a.m75110o().m75172d(asyncTask);
    }

    public boolean extraCondition() {
        return false;
    }

    public int getErrCode() {
        int i10;
        synchronized (this.lockCode) {
            i10 = this.errCode;
        }
        return i10;
    }

    public C9721b getException() {
        C9721b c9721b;
        synchronized (this.lockCode) {
            c9721b = this.exception;
        }
        return c9721b;
    }

    public Vector<String> getModules() {
        Vector<String> vector;
        synchronized (MODULE_LOCK) {
            vector = this.modules;
        }
        return vector;
    }

    public State getState() {
        this.stateWDLock.readLock().lock();
        try {
            return this.state;
        } finally {
            this.stateWDLock.readLock().unlock();
        }
    }

    public boolean hasModules() {
        boolean z10;
        synchronized (MODULE_LOCK) {
            z10 = !this.modules.isEmpty();
        }
        return z10;
    }

    public boolean isAbort() {
        this.abortWDLock.readLock().lock();
        try {
            return this.abort;
        } finally {
            this.abortWDLock.readLock().unlock();
        }
    }

    public void isCancel() throws InterruptedException, C9721b {
        InterfaceC12198y interfaceC12198y = this.loadController;
        if (interfaceC12198y != null) {
            interfaceC12198y.loadControl(this);
        }
        if (isPause()) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e10) {
                C11839m.m70687e(TAG, "pause task error." + e10.toString());
            }
            setPause(false);
        }
        if (!extraCondition() && !condition()) {
            C11839m.m70688i(TAG, "net disable.");
            setState(State.CANCEL);
            throw new C9721b(1002, "net disable.", "isCancel");
        }
        if (isAbort()) {
            C11839m.m70688i(TAG, "process abort.");
            throw new C9721b(1001, "process abort", "isCancel");
        }
        if (State.DONE.equals(getState())) {
            C11839m.m70688i(TAG, "process already released.");
            throw new C9721b(1001, "process already released.", "isCancel");
        }
        if (this.exception == null) {
            return;
        }
        C11839m.m70688i(TAG, "throw exception");
        throw this.exception;
    }

    public void isDiffCancel() throws InterruptedException, C9721b {
        if (isPause()) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e10) {
                C11839m.m70687e(TAG, "pause task error." + e10.toString());
            }
            setPause(false);
        }
        if (this.exception != null) {
            C11839m.m70688i(TAG, "throw exception");
            throw new C9721b(103, this.exception.getMessage(), this.exception.m60658b());
        }
        if (!extraCondition() && !condition()) {
            C11839m.m70688i(TAG, "net disable.");
            setState(State.CANCEL);
            throw new C9721b(103, "net disable.", "isCancel");
        }
        if (isAbort()) {
            C11839m.m70688i(TAG, "process abort.");
            throw new C9721b(103, "process abort", "isCancel");
        }
        if (State.DONE.equals(getState())) {
            C11839m.m70688i(TAG, "process already released.");
            throw new C9721b(103, "process already released.", "isCancel");
        }
    }

    public boolean isPause() {
        this.pauseWDLock.readLock().lock();
        try {
            return this.pause;
        } finally {
            this.pauseWDLock.readLock().unlock();
        }
    }

    public void isRelease() throws C9721b {
        if (State.DONE.equals(getState())) {
            C11839m.m70688i(TAG, "isRelease, process already released.");
            throw new C9721b(1001, "process already released.", "isRelease");
        }
    }

    public void modulesAwait() {
        synchronized (WAIT_LOCK) {
            while (hasModules()) {
                try {
                    WAIT_LOCK.wait(400L);
                } catch (InterruptedException e10) {
                    C11839m.m70686d(TAG, "module sync await error, " + e10.toString());
                }
            }
        }
    }

    @Override // p581qk.AbstractC12365b
    public void pause() {
        setPause(true);
    }

    public void removeModule(String str) {
        Object obj = WAIT_LOCK;
        synchronized (obj) {
            synchronized (MODULE_LOCK) {
                this.modules.remove(str);
            }
            obj.notifyAll();
        }
    }

    public void setAbort(boolean z10) {
        this.abortWDLock.writeLock().lock();
        try {
            this.abort = z10;
        } finally {
            this.abortWDLock.writeLock().unlock();
        }
    }

    public void setErrCode(int i10) {
        setErrCode(i10, null);
    }

    public void setException(Throwable th2) {
        synchronized (this.lockCode) {
            try {
                if (this.exception == null) {
                    if (th2 instanceof C9721b) {
                        this.exception = (C9721b) th2;
                    } else {
                        this.exception = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error." + th2.toString() + ",stackTrace: " + C12590s0.m75731C0(th2));
                    }
                    this.errCode = this.exception.m60659c();
                    C11839m.m70687e(TAG, "task error. " + th2.toString() + ", exception" + this.exception.toString());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void setPause(boolean z10) {
        this.pauseWDLock.writeLock().lock();
        try {
            this.pause = z10;
        } finally {
            this.pauseWDLock.writeLock().unlock();
        }
    }

    public void setState(State state) {
        if (State.DONE.equals(getState())) {
            return;
        }
        this.stateWDLock.writeLock().lock();
        try {
            this.state = state;
        } finally {
            this.stateWDLock.writeLock().unlock();
        }
    }

    @Override // p581qk.AbstractC12365b
    public void callback(Message message) {
        CBCallBack.getInstance().sendMessage(message);
    }

    public void setErrCode(int i10, String str) {
        synchronized (this.lockCode) {
            try {
                this.exception = new C9721b(i10, "task abort. code = " + i10);
                if (!TextUtils.isEmpty(str)) {
                    this.exception = new C9721b(i10, "task abort. code = " + i10, str);
                }
                this.errCode = this.exception.m60659c();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
