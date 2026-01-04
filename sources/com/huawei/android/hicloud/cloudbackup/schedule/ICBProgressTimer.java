package com.huawei.android.hicloud.cloudbackup.schedule;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.bean.ProgressBean;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p616rk.C12515a;

/* loaded from: classes2.dex */
public class ICBProgressTimer {
    private static final String TAG = "ICBProgress";
    private AbstractC12369f timer;
    private static ICBProgressTimer progressTimer = new ICBProgressTimer();
    private static final Object LOCK = new Object();
    private int index = 0;
    private int asize = 0;
    private int cmd = 0;
    private int progress = 0;
    private ProgressBean progressBean = null;
    private Handler.Callback callback = new Handler.Callback() { // from class: com.huawei.android.hicloud.cloudbackup.schedule.ICBProgressTimer.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 32307) {
                ICBProgressTimer.this.cmd = message.arg1;
                ICBProgressTimer.this.index = message.arg2;
                Object obj = message.obj;
                if (obj != null && (obj instanceof ProgressBean)) {
                    synchronized (ICBProgressTimer.LOCK) {
                        ICBProgressTimer.this.progressBean = (ProgressBean) message.obj;
                    }
                }
            } else if (i10 == 32407) {
                synchronized (ICBProgressTimer.LOCK) {
                    ICBProgressTimer.this.sendProgress();
                }
            }
            return false;
        }
    };

    private ICBProgressTimer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callprogess() {
        int i10 = this.cmd;
        if (i10 == 1 || i10 == 15) {
            process(true);
        }
        switch (i10) {
            case 10:
                this.progress = 98;
                break;
            case 11:
                this.progress = 96;
                break;
            case 12:
                this.progress = 99;
                break;
            case 13:
                process(false);
                break;
        }
    }

    private void clear() {
        AbstractC12369f abstractC12369f = this.timer;
        if (abstractC12369f != null) {
            abstractC12369f.cancel();
            this.timer = null;
        }
        synchronized (LOCK) {
            try {
                if (this.progressBean != null) {
                    this.progressBean = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.index = 0;
        this.asize = 0;
        this.progress = 0;
        this.cmd = 0;
        CBCallBack.getInstance().unregisterCallback(this.callback);
    }

    public static ICBProgressTimer getInstance() {
        return progressTimer;
    }

    private void process(boolean z10) {
        double d10;
        double d11;
        double d12;
        double d13;
        int i10 = this.asize;
        if (i10 <= 0) {
            C11839m.m70686d(TAG, "process asize is " + this.asize);
            return;
        }
        float f10 = this.index / i10;
        ProgressBean progressBean = this.progressBean;
        if (progressBean != null) {
            int current = progressBean.getCurrent();
            int count = this.progressBean.getCount();
            if (current > count) {
                current = count;
            }
            int status = this.progressBean.getStatus();
            float f11 = count == 0 ? 0.0f : current / count;
            if (status != 1) {
                if (status == 2) {
                    d10 = f10;
                    d12 = 1.0f / this.asize;
                    d13 = f11 * 0.6d;
                } else if (status == 3) {
                    d10 = f10;
                    d12 = 1.0f / this.asize;
                    d13 = (f11 * 0.3d) + 0.6d;
                } else if (status == 4) {
                    f10 += (1.0f / this.asize) * 1.0f;
                }
                d11 = d12 * d13;
            } else {
                d10 = f10;
                d11 = (1.0f / this.asize) * ((f11 * 0.8d) + 0.2d);
            }
            f10 = (float) (d10 + d11);
        }
        int i11 = (int) (f10 * 100.0f);
        if (i11 > 100) {
            i11 = 100;
        }
        if (z10) {
            i11 = (int) (i11 * 0.96d);
        }
        int i12 = this.progress;
        if (i11 <= i12) {
            i11 = i12;
        }
        this.progress = i11;
    }

    private void putFileSize(Bundle bundle) {
        if (this.progressBean == null) {
            C11839m.m70689w(TAG, "putFileSize progressBean is null");
        } else if (C0213f.m1377a() == null) {
            C11839m.m70689w(TAG, "putFileSize app context is null");
        } else {
            bundle.putString("fileSize", C0223k.m1524g(C0213f.m1377a(), this.progressBean.getFileSize()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendProgress() {
        C11839m.m70688i(TAG, "progress = " + this.progress);
        Bundle bundle = new Bundle();
        bundle.putInt(VastAttribute.PROGRESS, this.progress);
        ProgressBean progressBean = this.progressBean;
        if (progressBean != null) {
            bundle.putString(FaqConstants.FAQ_MODULE, progressBean.getModule());
            bundle.putInt("status", this.progressBean.getStatus());
            bundle.putInt("moduleIndex", this.progressBean.getTypeIndex());
            bundle.putInt("moduleCount", this.progressBean.getTypeCount());
            bundle.putInt("current", this.progressBean.getCurrent());
            bundle.putInt("count", this.progressBean.getCount());
            bundle.putInt("uploadSizeProgress", this.progressBean.getUploadSizeProgress());
        }
        Message message = new Message();
        int i10 = this.cmd;
        if (i10 == 1) {
            message.what = 32325;
        } else if (i10 == 14) {
            message.what = 32400;
        } else if (i10 != 15) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                    message.what = 32300;
                    break;
            }
        } else {
            message.what = 32401;
            putFileSize(bundle);
        }
        message.setData(bundle);
        CBCallBack.getInstance().sendMessage(message);
    }

    public void exit() {
        C11839m.m70688i(TAG, "exit progress.");
        clear();
    }

    public int getProgress() {
        return this.progress;
    }

    public void setAsize(int i10) {
        this.asize = i10;
    }

    public void start(int i10) {
        clear();
        this.asize = i10;
        CBCallBack.getInstance().registerCallback(this.callback);
        this.timer = new AbstractC12369f(0L, 2L) { // from class: com.huawei.android.hicloud.cloudbackup.schedule.ICBProgressTimer.2
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                synchronized (ICBProgressTimer.LOCK) {
                    ICBProgressTimer.this.callprogess();
                    ICBProgressTimer.this.sendProgress();
                }
            }
        };
        C12515a.m75110o().m75172d(this.timer);
    }

    public void start() {
        clear();
        CBCallBack.getInstance().registerCallback(this.callback);
        this.timer = new AbstractC12369f(0L, 2L) { // from class: com.huawei.android.hicloud.cloudbackup.schedule.ICBProgressTimer.3
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                synchronized (ICBProgressTimer.LOCK) {
                    ICBProgressTimer.this.callprogess();
                    ICBProgressTimer.this.sendProgress();
                }
            }
        };
        C12515a.m75110o().m75172d(this.timer);
    }
}
