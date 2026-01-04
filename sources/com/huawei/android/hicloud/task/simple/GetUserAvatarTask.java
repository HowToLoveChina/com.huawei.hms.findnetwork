package com.huawei.android.hicloud.task.simple;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import je.C10809w;
import p054cj.C1442a;
import p581qk.AbstractC12367d;

/* loaded from: classes3.dex */
public class GetUserAvatarTask extends AbstractC12367d {

    /* renamed from: a */
    public String f13096a;

    /* renamed from: b */
    public boolean f13097b;

    /* renamed from: c */
    public Handler f13098c;

    /* renamed from: d */
    public CallBack f13099d;

    public interface CallBack {
        /* renamed from: a */
        void mo18099a(Bitmap bitmap);
    }

    public GetUserAvatarTask(Handler handler, String str, boolean z10) {
        this.f13096a = str;
        this.f13097b = z10;
        this.f13098c = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        Bitmap bitmapM65801e;
        C1442a.m8290i("GetUserAvatarTask", "GetUserAvatarTask start");
        if (!this.f13097b || TextUtils.isEmpty(this.f13096a)) {
            bitmapM65801e = C10809w.m65801e();
            if (bitmapM65801e == null && !TextUtils.isEmpty(this.f13096a)) {
                bitmapM65801e = C10809w.m65800d(this.f13096a);
            }
        } else {
            bitmapM65801e = C10809w.m65800d(this.f13096a);
        }
        if (this.f13098c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 108;
            messageObtain.obj = bitmapM65801e;
            this.f13098c.sendMessage(messageObtain);
        }
        CallBack callBack = this.f13099d;
        if (callBack != null) {
            callBack.mo18099a(bitmapM65801e);
        }
    }

    public GetUserAvatarTask(CallBack callBack, String str, boolean z10) {
        this.f13096a = str;
        this.f13097b = z10;
        this.f13099d = callBack;
    }
}
