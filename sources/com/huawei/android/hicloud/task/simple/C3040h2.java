package com.huawei.android.hicloud.task.simple;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudspace.bean.UserCloudSpaceUseInfo;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p836z8.C14157f;

/* renamed from: com.huawei.android.hicloud.task.simple.h2 */
/* loaded from: classes3.dex */
public class C3040h2 extends AbstractC12367d {

    /* renamed from: a */
    public final Handler f13282a;

    /* renamed from: b */
    public final ArrayList<String> f13283b;

    /* renamed from: c */
    public boolean f13284c;

    public C3040h2(Handler handler) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f13283b = arrayList;
        this.f13284c = false;
        this.f13282a = handler;
        arrayList.add("bs.dsu.cloud.usage");
        arrayList.add("cp.qty.image");
        arrayList.add("cp.qty.video");
    }

    /* renamed from: c */
    public final void m18333c(UserCloudSpaceUseInfo userCloudSpaceUseInfo) {
        if (this.f13284c || this.f13282a == null) {
            C11839m.m70689w("QueryUserCloudUseInfoTask", "Task is canceled or handler is null");
            return;
        }
        Message message = new Message();
        message.what = 7057;
        message.obj = userCloudSpaceUseInfo;
        this.f13282a.sendMessage(message);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(null, this.f13283b, "QueryUser");
        UserCloudSpaceUseInfo userCloudSpaceUseInfo = new UserCloudSpaceUseInfo();
        if (listM84949i == null || listM84949i.isEmpty()) {
            C11839m.m70689w("QueryUserCloudUseInfoTask", "getParams fail");
        } else {
            for (C4987f c4987f : listM84949i) {
                if (TextUtils.equals(c4987f.m30026b(), "bs.dsu.cloud.usage")) {
                    userCloudSpaceUseInfo.setCloudUsage(c4987f.m30027c());
                } else if (TextUtils.equals(c4987f.m30026b(), "cp.qty.image")) {
                    userCloudSpaceUseInfo.setImageCount(c4987f.m30027c());
                } else if (TextUtils.equals(c4987f.m30026b(), "cp.qty.video")) {
                    userCloudSpaceUseInfo.setVideoCount(c4987f.m30027c());
                }
            }
            m18333c(userCloudSpaceUseInfo);
        }
        C11839m.m70688i("QueryUserCloudUseInfoTask", userCloudSpaceUseInfo.toString());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        this.f13284c = true;
        return super.cancel();
    }
}
