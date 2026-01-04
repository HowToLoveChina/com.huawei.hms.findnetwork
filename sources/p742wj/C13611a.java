package p742wj;

import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import p399jk.AbstractC10896a;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;

/* renamed from: wj.a */
/* loaded from: classes5.dex */
public class C13611a implements InterfaceC13449b {

    /* renamed from: a */
    public Handler f61236a;

    public C13611a(Handler handler) {
        this.f61236a = handler;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        AbstractC10896a.m65887i("CloudSpaceUserInfoHandler", "authFailed");
        Handler handler = this.f61236a;
        if (handler != null) {
            handler.sendEmptyMessage(20000);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        AbstractC10896a.m65887i("CloudSpaceUserInfoHandler", "authTokenSuccess");
        m81828a(bundle);
    }

    /* renamed from: a */
    public final void m81828a(Bundle bundle) {
        AbstractC10896a.m65887i("CloudSpaceUserInfoHandler", "processLoginSuccess");
        if (this.f61236a == null) {
            AbstractC10896a.m65888w("CloudSpaceUserInfoHandler", "onFinish mCallbackHandler is null");
            return;
        }
        if (bundle == null) {
            AbstractC10896a.m65886e("CloudSpaceUserInfoHandler", "bundle is null.");
            this.f61236a.sendEmptyMessage(20000);
            return;
        }
        String string = bundle.getString(CommonConstant.KEY_SERVICE_COUNTRY_CODE);
        if (TextUtils.isEmpty(string)) {
            String strM80921h0 = C13452e.m80781L().m80921h0();
            if (TextUtils.isEmpty(strM80921h0)) {
                this.f61236a.sendEmptyMessage(20000);
            } else {
                string = strM80921h0;
            }
        }
        C13452e.m80781L().m80821J2(string);
        C13452e.m80781L().m80825K2(System.currentTimeMillis());
        String string2 = bundle.getString("photoUrl");
        String string3 = bundle.getString(CommonConstant.KEY_DISPLAY_NAME);
        Bundle bundle2 = new Bundle();
        bundle2.putString("account_head_pic_url", string2);
        bundle2.putString("account_nick_name", string3);
        C13452e.m80781L().m80949n2(string3);
        C13452e.m80781L().m80913f2(string2);
        Message messageObtainMessage = this.f61236a.obtainMessage();
        messageObtainMessage.what = 20001;
        messageObtainMessage.setData(bundle2);
        this.f61236a.sendMessage(messageObtainMessage);
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        AbstractC10896a.m65888w("CloudSpaceUserInfoHandler", "authCanceled");
        Handler handler = this.f61236a;
        if (handler != null) {
            handler.sendEmptyMessage(20000);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
        AbstractC10896a.m65887i("CloudSpaceUserInfoHandler", "getUserInfoSuccess");
        m81828a(bundle);
    }
}
