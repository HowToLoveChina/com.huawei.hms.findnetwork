package com.huawei.phoneservice.feedback.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b;
import com.huawei.phoneservice.feedback.utils.EnumC8594a;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackZipBean;
import com.huawei.phoneservice.feedbackcommon.utils.CancelInterface;
import com.huawei.phoneservice.feedbackcommon.utils.FeedbackCommonManager;
import com.huawei.phoneservice.feedbackcommon.utils.NotifyUploadFileListener;
import com.huawei.phoneservice.feedbackcommon.utils.NotifyUploadZipListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.phoneservice.feedbackcommon.utils.SubmitListener;
import com.huawei.phoneservice.feedbackcommon.utils.ZipCompressListener;
import com.huawei.phoneservice.feedbackcommon.utils.ZipUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.mvp.base.c */
/* loaded from: classes5.dex */
public abstract class AbstractC8494c<V extends InterfaceC8493b> extends AbstractC8492a implements ZipCompressListener, NotifyUploadZipListener, NotifyUploadFileListener, SubmitListener {

    /* renamed from: b */
    public String f39637b;

    /* renamed from: c */
    public long f39638c;

    /* renamed from: d */
    public int f39639d;

    /* renamed from: e */
    public boolean f39640e;

    /* renamed from: f */
    public boolean f39641f;

    /* renamed from: g */
    public int f39642g;

    /* renamed from: h */
    public int f39643h;

    /* renamed from: i */
    public Handler f39644i;

    /* renamed from: j */
    public Context f39645j;

    /* renamed from: k */
    public Activity f39646k;

    /* renamed from: l */
    public volatile int f39647l;

    /* renamed from: m */
    public String f39648m;

    /* renamed from: n */
    public List<FeedbackZipBean> f39649n;

    /* renamed from: o */
    public boolean f39650o;

    /* renamed from: p */
    public V f39651p;

    /* renamed from: q */
    public CancelInterface f39652q;

    public AbstractC8494c(V v10) {
        super(v10);
        this.f39638c = 0L;
        this.f39640e = false;
        this.f39641f = false;
        this.f39642g = 0;
        this.f39643h = 0;
        this.f39647l = 0;
        this.f39649n = new ArrayList(20);
        this.f39650o = false;
        this.f39651p = v10;
    }

    /* renamed from: a */
    public final String m52759a(int i10, String str) {
        Context context;
        int i11;
        if (i10 == -1) {
            return str;
        }
        if (i10 == 401) {
            context = this.f39645j;
            i11 = R$string.feedback_sdk_longtime;
        } else if (i10 == 405) {
            context = this.f39645j;
            i11 = R$string.feedback_sdk_submit_repeated;
        } else if (i10 == 1) {
            context = this.f39645j;
            i11 = R$string.feedback_sdk_common_server_disconnected_toast;
        } else if (i10 == 2) {
            context = this.f39645j;
            i11 = R$string.feedback_sdk_image_type_error_tip;
        } else {
            if (i10 != 3) {
                return null;
            }
            context = this.f39645j;
            i11 = R$string.feedback_sdk_feedback_failed;
        }
        return context.getString(i11);
    }

    /* renamed from: b */
    public void m52760b(Context context, String str, Callback callback) {
        FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
        String sdk = FaqSdk.getSdk().getSdk("country");
        String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LANGUAGE);
        String sdk3 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE);
        if (TextUtils.isEmpty(str)) {
            str = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL);
        }
        feedbackCommonManager.callService(context, sdk, sdk2, sdk3, str, callback);
    }

    /* renamed from: c */
    public void m52761c(String str, long j10, String str2) {
        this.f39652q = SdkProblemManager.getManager().uploadZipWithCancel(this.f39645j, str, j10, str2, this);
    }

    /* renamed from: d */
    public void m52762d(List<String> list) {
        FeedbackInfo feedbackInfoMo52755b;
        if (this.f39647l != 0) {
            if (this.f39647l == 1) {
                this.f39647l = 2;
            }
        } else {
            if (this.f39641f || (feedbackInfoMo52755b = this.f39651p.mo52755b()) == null) {
                return;
            }
            this.f39652q = SdkProblemManager.getManager().submitWithCancel(this.f39645j, this.f39650o, list, this.f39649n, feedbackInfoMo52755b, this);
        }
    }

    /* renamed from: e */
    public abstract void mo52763e(boolean z10);

    @Override // com.huawei.phoneservice.feedbackcommon.utils.NotifyUploadZipListener
    public void notifyUpload(List<FeedbackZipBean> list, boolean z10) {
        this.f39649n = list;
        mo52763e(z10);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.NotifyUploadZipListener
    public void notifyUploadAgain(long j10) {
        SdkProblemManager.getManager().zipCompressAgain(this.f39645j, j10, this);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.SubmitListener
    public void submitNotify(int i10, int i11, String str) {
        String strM52759a = m52759a(i11, str);
        Handler handler = this.f39644i;
        if (handler == null || strM52759a == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(i10, strM52759a));
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.NotifyUploadFileListener
    public void uploadNotify(int i10, int i11, String str) {
        String strM52759a = m52759a(i11, str);
        Handler handler = this.f39644i;
        if (handler == null || strM52759a == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(i10, strM52759a));
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.ZipCompressListener
    public void zipCompressFinished(int i10, String str, String str2) {
        V v10;
        EnumC8594a enumC8594a;
        this.f39639d = i10;
        this.f39651p.mo52755b().setFlag(this.f39639d);
        if (i10 == 2) {
            ZipUtil.setSize(0L);
            ZipUtil.getSize(new File(str).listFiles());
            this.f39651p.mo52755b().setLogsSize(ZipUtil.getSize());
            this.f39651p.mo52755b().setZipFileName(str2);
            if (0 != this.f39638c) {
                Handler handler = this.f39644i;
                if (handler != null) {
                    handler.sendEmptyMessage(100);
                    return;
                }
                return;
            }
            v10 = this.f39651p;
            enumC8594a = EnumC8594a.ZIP_COMPRESS_SUCCESS;
        } else {
            this.f39651p.mo52755b().setLogsSize(0L);
            if (0 != this.f39638c) {
                mo52763e(false);
                return;
            } else {
                v10 = this.f39651p;
                enumC8594a = EnumC8594a.ZIP_COMPRESS_FAILED;
            }
        }
        v10.mo52758z(enumC8594a);
    }
}
