package p572qb;

import com.google.gson.Gson;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import fk.C9721b;
import je.C10792i;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p805yb.C13936f;

/* renamed from: qb.c0 */
/* loaded from: classes3.dex */
public class C12302c0 extends AbstractRunnableC12516b {

    /* renamed from: a */
    public final String f56998a;

    public C12302c0(String str) {
        this.f56998a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        try {
            if (!MessageCenterManager.getInstance().featureSwitch()) {
                C11839m.m70689w("ProcessMessageTask", "feature not support, do not process");
                MessageCenterReportUtil.reportMsgProcInterrupted("feature_switch_closed");
                return;
            }
            C11839m.m70686d("ProcessMessageTask", "mPushData is:" + this.f56998a);
            ClientMessageBody clientMessageBody = (ClientMessageBody) new Gson().fromJson(this.f56998a, ClientMessageBody.class);
            if (clientMessageBody == null) {
                MessageCenterReportUtil.reportMsgProcInterrupted("body_serialization_failed");
                C11839m.m70687e("ProcessMessageTask", "body is null");
                return;
            }
            C10792i.m65670g(clientMessageBody);
            String category = clientMessageBody.getCategory();
            if ("product".equals(category)) {
                new C12304d0().process(clientMessageBody);
                return;
            }
            if ("operation".equals(category)) {
                new C12334z().process(clientMessageBody);
            } else if ("nps".equals(category)) {
                new C13936f().process(clientMessageBody);
            } else if ("common".equals(category)) {
                new C12309g().process(clientMessageBody);
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessMessageTask", "exception e: " + e10.toString());
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.PROCESS_MESSAGE_SINGLE;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
