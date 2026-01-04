package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.phoneservice.faq.base.network.FaqNewCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.feedbackcommon.entity.C8616c0;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackMediaData;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.l */
/* loaded from: classes5.dex */
public class C8672l extends AbstractC8662d {

    /* renamed from: h */
    public MediaEntity f40401h;

    /* renamed from: i */
    public Context f40402i;

    /* renamed from: j */
    public WeakReference<NotifyUploadFileListener> f40403j;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.l$a */
    public class a extends FaqNewCallback<C8616c0> {

        /* renamed from: c */
        public final /* synthetic */ MediaEntity f40404c;

        /* renamed from: d */
        public final /* synthetic */ boolean f40405d;

        /* renamed from: e */
        public final /* synthetic */ File f40406e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Activity activity, MediaEntity mediaEntity, boolean z10, File file) {
            super(cls, activity);
            this.f40404c = mediaEntity;
            this.f40405d = z10;
            this.f40406e = file;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqNewCallback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8616c0 c8616c0) {
            C8672l c8672l;
            int i10;
            if (th2 != null || c8616c0 == null) {
                boolean z10 = th2 instanceof FaqWebServiceException;
                if (z10 && ((FaqWebServiceException) th2).errorCode == 401 && FaqSdk.getISdk().haveSdkErr("accessToken")) {
                    C8672l.this.m53495d(this.f40404c);
                } else {
                    if ((th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException)) {
                        c8672l = C8672l.this;
                        i10 = 1;
                    } else if (z10 && ((FaqWebServiceException) th2).errorCode == 408) {
                        c8672l = C8672l.this;
                        i10 = 2;
                    } else {
                        c8672l = C8672l.this;
                        if (c8672l.f40343b != null) {
                            i10 = 3;
                        }
                    }
                    c8672l.m53490c(5, i10, null);
                }
            } else {
                String strM53223a = c8616c0.m53223a();
                MediaEntity mediaEntity = this.f40404c;
                mediaEntity.attach = strM53223a;
                mediaEntity.updateTime = Long.valueOf(System.currentTimeMillis());
                FeedbackMediaData.getInstance(C8672l.this.f40402i).saveMediaEntity(this.f40404c);
                C8672l.this.m53490c(4, -1, strM53223a);
            }
            C8672l.this.m53498j(this.f40405d, this.f40406e);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.l$b */
    public class b extends BaseSdkUpdateRequest<MediaEntity> {
        public b(MediaEntity mediaEntity) {
            super(mediaEntity);
        }

        @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onCallback(String str, String str2, String str3, MediaEntity mediaEntity) {
            if ("accessToken".equals(str)) {
                FaqSdk.getISdk().unregisterUpdateListener(this);
                WeakReference<BaseSdkUpdateRequest> weakReference = C8672l.this.f40344c;
                if (weakReference != null) {
                    weakReference.clear();
                    C8672l.this.f40344c = null;
                }
                C8672l.this.m53500l(mediaEntity);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.l$c */
    public class c extends FaqNewCallback<C8616c0> {

        /* renamed from: c */
        public final /* synthetic */ MediaEntity f40409c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Class cls, Activity activity, MediaEntity mediaEntity) {
            super(cls, activity);
            this.f40409c = mediaEntity;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqNewCallback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8616c0 c8616c0) {
            C8672l c8672l;
            int i10;
            if (th2 == null && c8616c0 != null) {
                String strM53223a = c8616c0.m53223a();
                MediaEntity mediaEntity = this.f40409c;
                mediaEntity.attach = strM53223a;
                mediaEntity.updateTime = Long.valueOf(System.currentTimeMillis());
                FeedbackMediaData.getInstance(C8672l.this.f40402i).saveMediaEntity(this.f40409c);
                C8672l.this.m53490c(4, -1, strM53223a);
                return;
            }
            if ((th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException)) {
                c8672l = C8672l.this;
                i10 = 1;
            } else {
                c8672l = C8672l.this;
                i10 = 3;
            }
            c8672l.m53490c(5, i10, null);
        }
    }

    public C8672l(Context context, MediaEntity mediaEntity) {
        this.f40401h = mediaEntity;
        this.f40402i = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m53490c(int i10, int i11, String str) {
        NotifyUploadFileListener notifyUploadFileListenerM53499k = m53499k();
        if (notifyUploadFileListenerM53499k != null) {
            notifyUploadFileListenerM53499k.uploadNotify(i10, i11, str);
        }
    }

    /* renamed from: d */
    public final void m53495d(MediaEntity mediaEntity) {
        b bVar = new b(mediaEntity);
        WeakReference<BaseSdkUpdateRequest> weakReference = this.f40344c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40344c = new WeakReference<>(bVar);
        FaqSdk.getISdk().registerUpdateListener(bVar);
        FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
    }

    /* renamed from: e */
    public final void m53496e(MediaEntity mediaEntity, File file, boolean z10) {
        Submit<ResponseBody> submitUploadFile = FeedbackCommonManager.INSTANCE.uploadFile(this.f40402i, file, mediaEntity.type, SdkProblemManager.getSdk().getSdk("accessToken"), new a(C8616c0.class, null, mediaEntity, z10, file));
        WeakReference<Submit<ResponseBody>> weakReference = this.f40343b;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40343b = new WeakReference<>(submitUploadFile);
    }

    /* renamed from: f */
    public void m53497f(NotifyUploadFileListener notifyUploadFileListener) {
        boolean z10;
        if (notifyUploadFileListener != null) {
            this.f40403j = new WeakReference<>(notifyUploadFileListener);
        }
        if (FaqStringUtil.isEmpty(this.f40401h.cache)) {
            return;
        }
        File file = new File(this.f40401h.cache);
        if (file.canRead()) {
            z10 = false;
        } else {
            String str = this.f40401h.cache;
            z10 = true;
            file = BitmapUtils.getFileFromUri(this.f40402i, Uri.parse(this.f40401h.strUri), str.substring(str.lastIndexOf("/") + 1));
        }
        m53496e(this.f40401h, file, z10);
    }

    /* renamed from: j */
    public final void m53498j(boolean z10, File file) {
        if (z10 && file.exists()) {
            file.delete();
        }
    }

    /* renamed from: k */
    public final NotifyUploadFileListener m53499k() {
        WeakReference<NotifyUploadFileListener> weakReference = this.f40403j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: l */
    public final void m53500l(MediaEntity mediaEntity) {
        Submit<ResponseBody> submitUploadFile = FeedbackCommonManager.INSTANCE.uploadFile(this.f40402i, new File(mediaEntity.cache), mediaEntity.type, SdkProblemManager.getSdk().getSdk("accessToken"), new c(C8616c0.class, null, mediaEntity));
        if (submitUploadFile == null) {
            return;
        }
        WeakReference<Submit<ResponseBody>> weakReference = this.f40343b;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40343b = new WeakReference<>(submitUploadFile);
    }
}
