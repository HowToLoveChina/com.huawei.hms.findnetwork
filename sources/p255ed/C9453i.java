package p255ed;

import android.content.Context;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Abouts;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Assets;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Changes;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Channels;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.CloudSyncBatch;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.DataBaseListRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Locks;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Losts;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Records;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Tasks;
import com.huawei.cloud.services.drive.Drive;
import p340hi.C10209a;

/* renamed from: ed.i */
/* loaded from: classes3.dex */
public class C9453i extends Drive {

    /* renamed from: ed.i$a */
    public static final class a extends Drive.Builder {
        public a(C10209a c10209a, Context context) {
            super(c10209a, context);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        /* renamed from: a */
        public C9453i build() {
            return new C9453i(this);
        }
    }

    public C9453i(a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    public Assets m59242a() {
        return new Assets(this);
    }

    /* renamed from: b */
    public CloudSyncBatch m59243b() {
        return new CloudSyncBatch(this);
    }

    /* renamed from: c */
    public Tasks m59244c() {
        return new Tasks(this);
    }

    /* renamed from: d */
    public Losts m59245d() {
        return new Losts(this);
    }

    /* renamed from: e */
    public Locks m59246e() {
        return new Locks(this);
    }

    /* renamed from: f */
    public Records m59247f() {
        return new Records(this);
    }

    /* renamed from: g */
    public Abouts m59248g() {
        return new Abouts(this);
    }

    /* renamed from: h */
    public Changes m59249h() {
        return new Changes(this);
    }

    /* renamed from: i */
    public Channels m59250i() {
        return new Channels(this);
    }

    /* renamed from: j */
    public DataBaseListRequest m59251j() {
        return new DataBaseListRequest(this);
    }
}
