package p805yb;

import android.text.TextUtils;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.service.C5023q;
import java.util.Map;
import p514o9.C11839m;

/* renamed from: yb.f */
/* loaded from: classes3.dex */
public class C13936f extends BaseMsgProcessor {

    /* renamed from: a */
    public C5023q f62493a;

    /* renamed from: b */
    public boolean f62494b = false;

    /* renamed from: c */
    public boolean f62495c = false;

    /* renamed from: a */
    public final boolean m83698a() {
        if (this.f62494b) {
            NotifyLogger.m29915i("NpsMsgProcessor", "queryConfigVersion has query");
            return true;
        }
        this.f62494b = true;
        if (this.f62493a == null) {
            this.f62493a = new C5023q(null);
        }
        return C13933c.m83668n().m83688v(this.f62493a);
    }

    /* renamed from: b */
    public final void m83699b(ClientMessageBody clientMessageBody) {
        if (this.f62495c) {
            NotifyLogger.m29913d("NpsMsgProcessor", "recordPushParam has record.");
            return;
        }
        if (clientMessageBody == null) {
            NotifyLogger.m29913d("NpsMsgProcessor", "recordPushParam message is null.");
            return;
        }
        Map<String, String> params = clientMessageBody.getParams();
        if (params == null) {
            NotifyLogger.m29913d("NpsMsgProcessor", "recordPushParam map is null.");
            return;
        }
        try {
            NotifyLogger.m29913d("NpsMsgProcessor", "recordPushParam start.");
            C13933c.m83668n().m83692z(params);
            this.f62495c = true;
        } catch (Exception e10) {
            this.f62495c = false;
            NotifyLogger.m29915i("NpsMsgProcessor", "recordPushParam error: " + e10.toString());
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean checkNotifyTypeAllowList(ClientMessageBody clientMessageBody) {
        String notifyType = clientMessageBody.getNotifyType();
        if (!TextUtils.isEmpty(notifyType)) {
            return C13935e.m83697a().contains(notifyType);
        }
        C11839m.m70687e("NpsMsgProcessor", "notifyType is null");
        return false;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean isMsgValid(ClientMessageBody clientMessageBody) {
        if (clientMessageBody == null) {
            NotifyLogger.m29914e("NpsMsgProcessor", "isMsgValid, message is null");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long remainValidityTime = clientMessageBody.getRemainValidityTime();
        NotifyLogger.m29915i("NpsMsgProcessor", "isMsgValid, msg id: " + clientMessageBody.getCfgResourceId() + ", current time: " + jCurrentTimeMillis + ", remain time: " + remainValidityTime);
        return remainValidityTime == 0 || remainValidityTime >= jCurrentTimeMillis;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void process(ClientMessageBody clientMessageBody) {
        super.process(clientMessageBody);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processBannerNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws Throwable {
        NotifyLogger.m29915i("NpsMsgProcessor", "processBannerNotifyWay start");
        m83698a();
        m83699b(clientMessageBody);
        C13933c.m83668n().m83677i(clientMessageBody);
        NotifyLogger.m29915i("NpsMsgProcessor", "processBannerNotifyWay end");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processDeskPopup(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("NpsMsgProcessor", "operation type can't process desk popup message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processH5Dialog(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("NpsMsgProcessor", "operation type can't process H5 message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processImgMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("NpsMsgProcessor", "operation type can't process img message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMenuNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws Throwable {
        NotifyLogger.m29915i("NpsMsgProcessor", "processMenuNotifyWay start");
        m83698a();
        m83699b(clientMessageBody);
        C13933c.m83668n().m83678j(clientMessageBody);
        NotifyLogger.m29915i("NpsMsgProcessor", "processMenuNotifyWay end");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processNotification(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws Throwable {
        NotifyLogger.m29915i("NpsMsgProcessor", "processNotification start");
        m83698a();
        m83699b(clientMessageBody);
        C13933c.m83668n().m83674f(clientMessageBody);
        NotifyLogger.m29915i("NpsMsgProcessor", "processNotification end");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processRichMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("NpsMsgProcessor", "operation type can't process rich message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processTextMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("NpsMsgProcessor", "operation type can't process text message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void sendNotification(NotifyNeedData notifyNeedData, ClientMessageBody clientMessageBody) {
    }
}
