package p703v8;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordsRsp;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p514o9.C11839m;
import p684un.C13227f;
import p709vj.C13452e;

/* renamed from: v8.j */
/* loaded from: classes2.dex */
public class C13373j {

    /* renamed from: d */
    public static final C13373j f60286d = new C13373j();

    /* renamed from: a */
    public List<CBSSyncRecordOperation> f60287a;

    /* renamed from: b */
    public b f60288b = new b();

    /* renamed from: c */
    public Handler f60289c;

    /* renamed from: v8.j$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 0) {
                C13373j.this.m80295f(message);
            }
        }
    }

    /* renamed from: v8.j$b */
    public static class b implements Comparator<CBSSyncRecordOperation>, Serializable {
        private static final long serialVersionUID = 5699171561950138319L;

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(CBSSyncRecordOperation cBSSyncRecordOperation, CBSSyncRecordOperation cBSSyncRecordOperation2) {
            return (int) (((cBSSyncRecordOperation2 != null ? C0209d.m1271k(cBSSyncRecordOperation2.getLastUpdateTime(), "yyyy-MM-dd'T'HH:mm:sszzz") : -1L) - (cBSSyncRecordOperation != null ? C0209d.m1271k(cBSSyncRecordOperation.getLastUpdateTime(), "yyyy-MM-dd'T'HH:mm:sszzz") : -1L)) / 1000);
        }
    }

    /* renamed from: c */
    public static C13373j m80291c() {
        return f60286d;
    }

    /* renamed from: b */
    public int m80292b() {
        if (this.f60287a == null) {
            C11839m.m70687e("MyDeviceManager", "cbsSyncRecordOperations is null");
            return 0;
        }
        C11839m.m70688i("MyDeviceManager", "cbsSyncRecordOperations size: " + this.f60287a.size());
        return this.f60287a.size();
    }

    /* renamed from: d */
    public final void m80293d(List<CBSSyncRecordOperation> list) {
        if (list != null) {
            Iterator<CBSSyncRecordOperation> it = list.iterator();
            while (it.hasNext()) {
                if (m80294e(it.next())) {
                    it.remove();
                }
            }
            Collections.sort(list, this.f60288b);
            this.f60287a = list;
            C11839m.m70688i("MyDeviceManager", "list size: " + list.size());
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("MyDeviceManager", "context is null");
                return;
            }
            ContentResolver contentResolver = contextM1377a.getContentResolver();
            if (contentResolver == null) {
                C11839m.m70687e("MyDeviceManager", "resolver is null");
            } else {
                contentResolver.notifyChange(Uri.parse("content://com.huawei.android.hicloud.provider/query_device_operations"), null);
            }
        }
    }

    /* renamed from: e */
    public final boolean m80294e(CBSSyncRecordOperation cBSSyncRecordOperation) {
        return TextUtils.isEmpty(cBSSyncRecordOperation.getOpDesc()) || (TextUtils.isEmpty(cBSSyncRecordOperation.getAliasName()) && TextUtils.isEmpty(cBSSyncRecordOperation.getDevDisplayName())) || TextUtils.isEmpty(cBSSyncRecordOperation.getDeviceID()) || TextUtils.isEmpty(cBSSyncRecordOperation.getLastUpdateTime());
    }

    /* renamed from: f */
    public final void m80295f(Message message) {
        Object obj = message.obj;
        if (obj instanceof CBSSyncRecordsRsp) {
            List<CBSSyncRecordOperation> opRecordList = ((CBSSyncRecordsRsp) obj).getOpRecordList();
            if (opRecordList == null || opRecordList.size() <= 0) {
                C11839m.m70688i("MyDeviceManager", "no records");
                return;
            }
            C11839m.m70688i("MyDeviceManager", "queryBasicDeviceRecordSuccess size=" + opRecordList.size());
            m80293d(opRecordList);
        }
    }

    /* renamed from: g */
    public void m80296g() {
        C13227f.m79492i1().m79585f0("mecloud_setting_click_mydevice", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29943D("CKC", "mecloud_setting_click_mydevice");
        if (this.f60289c == null) {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("MyDeviceManager", "context is null");
                return;
            }
            this.f60289c = new a(contextM1377a.getMainLooper());
        }
        InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        if (interfaceC9283b != null) {
            interfaceC9283b.mo58488T(this.f60289c);
        }
    }
}
