package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import androidx.annotation.Keep;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.nio.charset.StandardCharsets;
import p507o2.InterfaceC11792e;
import p542p2.AbstractC12080g;
import p542p2.InterfaceC12082i;
import p564q2.InterfaceC12275b;
import p759x1.EnumC13676a;
import p829z1.C14078q;

/* loaded from: classes5.dex */
public class CompressTask implements Runnable {

    /* renamed from: a */
    public Context f40275a;

    /* renamed from: b */
    public TaskCallBack f40276b;

    /* renamed from: c */
    public String f40277c;

    /* renamed from: d */
    public String f40278d;

    @Keep
    public interface TaskCallBack {
        void compressDone(Throwable th2, String str);
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.CompressTask$a */
    public class C8649a extends AbstractC12080g<Bitmap> {
        public C8649a() {
        }

        @Override // p542p2.InterfaceC12082i
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void mo53348c(Bitmap bitmap, InterfaceC12275b<? super Bitmap> interfaceC12275b) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.CompressTask$b */
    public class C8650b implements InterfaceC11792e<Bitmap> {

        /* renamed from: a */
        public final String f40280a;

        /* renamed from: b */
        public final String f40281b;

        public C8650b(String str, String str2) {
            this.f40280a = str;
            this.f40281b = str2;
        }

        @Override // p507o2.InterfaceC11792e
        /* renamed from: a */
        public boolean mo51694a(C14078q c14078q, Object obj, InterfaceC12082i<Bitmap> interfaceC12082i, boolean z10) {
            CompressTask.this.f40276b.compressDone(new Throwable("onLoadFailed:" + c14078q), this.f40280a);
            return false;
        }

        @Override // p507o2.InterfaceC11792e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean mo51695b(Bitmap bitmap, Object obj, InterfaceC12082i<Bitmap> interfaceC12082i, EnumC13676a enumC13676a, boolean z10) throws Throwable {
            TaskCallBack taskCallBack;
            Throwable th2;
            String str;
            if (bitmap != null) {
                FaqLogger.m51836d("CompressTask", "after compress ,picture size：" + (BitmapUtils.m53345a(bitmap, this.f40281b).length() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "KB, width: " + bitmap.getWidth() + " height:" + bitmap.getHeight());
                taskCallBack = CompressTask.this.f40276b;
                str = this.f40281b;
                th2 = null;
            } else {
                taskCallBack = CompressTask.this.f40276b;
                th2 = new Throwable("can't find file by path:" + this.f40280a);
                str = this.f40280a;
            }
            taskCallBack.compressDone(th2, str);
            return false;
        }
    }

    @Keep
    public CompressTask(Context context, String str, String str2, TaskCallBack taskCallBack) {
        this.f40275a = context;
        this.f40277c = str;
        this.f40278d = str2;
        this.f40276b = taskCallBack;
    }

    /* renamed from: c */
    public final void m53347c(String str, String str2) {
        ComponentCallbacks2C1546b.m8904t(this.f40275a).m8976j().m8971t(str).m8967p(new C8650b(str, str2)).m8962k(new C8649a());
    }

    @Override // java.lang.Runnable
    public void run() {
        new File(this.f40278d).mkdirs();
        String strValueOf = this.f40277c;
        if (strValueOf == null) {
            strValueOf = String.valueOf(System.currentTimeMillis());
        }
        String str = this.f40278d + File.separator + (Base64.encodeToString(strValueOf.getBytes(StandardCharsets.UTF_8), 8) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT);
        if (new File(str).exists()) {
            this.f40276b.compressDone(null, str);
        } else {
            m53347c(this.f40277c, str);
        }
    }
}
