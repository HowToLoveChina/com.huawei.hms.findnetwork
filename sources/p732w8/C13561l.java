package p732w8;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: w8.l */
/* loaded from: classes2.dex */
public class C13561l extends AbstractC12367d {

    /* renamed from: a */
    public Context f60984a;

    /* renamed from: b */
    public Handler f60985b;

    /* renamed from: c */
    public List<String> f60986c;

    public C13561l(Context context, Handler handler, List<String> list) {
        new ArrayList();
        this.f60984a = context;
        this.f60985b = handler;
        this.f60986c = list;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (this.f60984a == null) {
            C11839m.m70687e("GetFamilyImageTask", "context is null");
            return;
        }
        ArrayList<C13555f> arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f60986c.size(); i10++) {
            String str = this.f60986c.get(i10);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new C13555f(this.f60984a.getFilesDir() + FamilyShareConstants.FAMILY_IMAGE_FILE_PATH + str.hashCode(), str));
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        for (C13555f c13555f : arrayList) {
            c13555f.setCount(countDownLatch);
            C12515a.m75110o().m75175e(c13555f, false);
        }
        try {
            if (!countDownLatch.await(20000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70687e("GetFamilyImageTask", "picture download threads time out, total: " + arrayList.size() + " tasks. " + countDownLatch.getCount() + " task(s) time out");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("GetFamilyImageTask", e10.toString());
        }
        Message messageObtain = Message.obtain(this.f60985b);
        messageObtain.what = FamilyShareConstants.MessageCode.GET_FAMILY_IMAGE;
        this.f60985b.sendMessage(messageObtain);
    }
}
