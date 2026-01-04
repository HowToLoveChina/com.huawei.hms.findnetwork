package com.huawei.phoneservice.feedback.mvp.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.util.FaqHandler;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.mvp.base.AbstractC8495d;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8504f;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.phoneservice.feedbackcommon.utils.CancelInterface;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.io.File;

/* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.d */
/* loaded from: classes5.dex */
public class C8508d extends AbstractC8495d<InterfaceC8504f> implements FaqHandler.CallBack {
    public C8508d(InterfaceC8504f interfaceC8504f, Context context) {
        super(interfaceC8504f);
        this.f39645j = context;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f
    /* renamed from: a */
    public void mo52765a() {
        this.f39644i = new FaqHandler(this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f
    /* renamed from: b */
    public void mo52766b() {
        Handler handler = this.f39644i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f39644i = null;
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.AbstractC8494c
    /* renamed from: e */
    public void mo52763e(boolean z10) {
        this.f39650o = z10;
        if (z10) {
            m52762d(null);
            return;
        }
        Handler handler = this.f39644i;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(7, this.f39645j.getString(R$string.feedback_sdk_feedback_failed)));
        }
    }

    /* renamed from: f */
    public void m52854f(int i10, int i11) {
        this.f39642g = i10;
        this.f39643h = i11;
    }

    /* renamed from: g */
    public void m52855g(Context context, boolean z10) {
        ((InterfaceC8504f) this.f39653r).mo52757e();
        this.f39640e = true;
        this.f39641f = false;
        this.f39647l = 0;
        this.f39639d = ((InterfaceC8504f) this.f39653r).mo52764c().getFlag();
        this.f39637b = FeedbackWebConstants.getZipFilePath(context);
        if (!z10 || this.f39639d != 2) {
            m52762d(null);
            return;
        }
        File file = new File(this.f39637b + File.separator + ((InterfaceC8504f) this.f39653r).mo52764c().getZipFileName() + FeedbackWebConstants.SUFFIX);
        m52761c(this.f39637b, file.length(), file.getName());
    }

    /* renamed from: h */
    public boolean m52856h() {
        return !this.f39640e;
    }

    @Override // com.huawei.phoneservice.faq.base.util.FaqHandler.CallBack
    public void handleMessage(int i10, Message message) {
        if (i10 == 6) {
            this.f39647l = 0;
            this.f39648m = null;
            String str = (String) message.obj;
            ((InterfaceC8504f) this.f39653r).mo52754a();
            ((InterfaceC8504f) this.f39653r).mo52779a(str);
            this.f39640e = false;
            return;
        }
        if (i10 != 7) {
            if (i10 != 100) {
                return;
            }
            this.f39652q = SdkProblemManager.getManager().reUploadZipWithCancel(this.f39645j, this.f39637b, ((InterfaceC8504f) this.f39653r).mo52764c().getLogsSize(), ((InterfaceC8504f) this.f39653r).mo52764c().getZipFileName(), this);
            return;
        }
        String str2 = (String) message.obj;
        if (this.f39647l != 0) {
            this.f39647l = 3;
            this.f39648m = str2;
            return;
        }
        this.f39647l = 0;
        this.f39648m = null;
        ((InterfaceC8504f) this.f39653r).mo52754a();
        ((InterfaceC8504f) this.f39653r).mo52756c(str2);
        this.f39640e = false;
        if (SdkProblemManager.getManager().getSdkListener() != null) {
            SdkProblemManager.getManager().getSdkListener().onSubmitResult(-1, null, ((InterfaceC8504f) this.f39653r).mo52764c().getProblemId(), ((InterfaceC8504f) this.f39653r).mo52764c().getSrCode(), str2);
        }
    }

    /* renamed from: i */
    public void m52857i() {
        if (this.f39647l == 0) {
            this.f39647l = 1;
        }
    }

    /* renamed from: j */
    public void m52858j() {
        if (this.f39647l == 1) {
            this.f39647l = 0;
            return;
        }
        if (this.f39647l == 2) {
            this.f39647l = 0;
            m52762d(null);
        } else {
            if (this.f39647l != 3 || TextUtils.isEmpty(this.f39648m)) {
                return;
            }
            this.f39647l = 0;
            Handler handler = this.f39644i;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(7, this.f39648m));
            }
        }
    }

    /* renamed from: k */
    public void m52859k() {
        Handler handler = this.f39644i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        CancelInterface cancelInterface = this.f39652q;
        if (cancelInterface != null) {
            cancelInterface.isCancel(true);
        }
        this.f39640e = false;
        this.f39641f = true;
        ((InterfaceC8504f) this.f39653r).mo52754a();
        if (SdkProblemManager.getManager().getSdkListener() != null) {
            SdkProblemManager.getManager().getSdkListener().onSubmitResult(-1, null, ((InterfaceC8504f) this.f39653r).mo52764c().getProblemId(), ((InterfaceC8504f) this.f39653r).mo52764c().getSrCode(), "");
        }
        this.f39647l = 0;
        CancelInterface cancelInterface2 = this.f39652q;
        if (cancelInterface2 != null) {
            cancelInterface2.isCancel(false);
        }
    }

    /* renamed from: l */
    public void m52860l() {
        SdkProblemManager.getManager().zipCompress(this.f39645j, this);
    }
}
