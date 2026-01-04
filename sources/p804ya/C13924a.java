package p804ya;

import android.content.Context;
import com.huawei.android.hicloud.drive.cloudphoto.request.Abouts;
import com.huawei.android.hicloud.drive.cloudphoto.request.AlbumAssets;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.Applicants;
import com.huawei.android.hicloud.drive.cloudphoto.request.Assets;
import com.huawei.android.hicloud.drive.cloudphoto.request.Changes;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotos;
import com.huawei.android.hicloud.drive.cloudphoto.request.Inviters;
import com.huawei.android.hicloud.drive.cloudphoto.request.Locks;
import com.huawei.android.hicloud.drive.cloudphoto.request.Losts;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.android.hicloud.drive.cloudphoto.request.Messages;
import com.huawei.android.hicloud.drive.cloudphoto.request.Permissions;
import com.huawei.android.hicloud.drive.cloudphoto.request.Quotas;
import com.huawei.android.hicloud.drive.cloudphoto.request.Risks;
import com.huawei.android.hicloud.drive.cloudphoto.request.Status;
import com.huawei.android.hicloud.drive.cloudphoto.request.Tasks;
import com.huawei.cloud.services.drive.Drive;
import p340hi.C10209a;

/* renamed from: ya.a */
/* loaded from: classes3.dex */
public class C13924a extends Drive {

    /* renamed from: ya.a$a */
    public static final class a extends Drive.Builder {
        public a(C10209a c10209a, Context context) {
            super(c10209a, context);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        /* renamed from: a */
        public C13924a build() {
            return new C13924a(this);
        }
    }

    public C13924a(a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    public Abouts m83544a() {
        return new Abouts(this);
    }

    /* renamed from: b */
    public AlbumAssets m83545b() {
        return new AlbumAssets(this);
    }

    /* renamed from: c */
    public Changes m83546c() {
        return new Changes(this);
    }

    /* renamed from: d */
    public Albums m83547d() {
        return new Albums(this);
    }

    /* renamed from: e */
    public Applicants m83548e() {
        return new Applicants(this);
    }

    /* renamed from: f */
    public Assets m83549f() {
        return new Assets(this);
    }

    /* renamed from: g */
    public Permissions m83550g() {
        return new Permissions(this);
    }

    /* renamed from: h */
    public CloudPhotoBatch m83551h() {
        return new CloudPhotoBatch(this);
    }

    /* renamed from: i */
    public CloudPhotos m83552i() {
        return new CloudPhotos(this);
    }

    /* renamed from: j */
    public Inviters m83553j() {
        return new Inviters(this);
    }

    /* renamed from: k */
    public Locks m83554k() {
        return new Locks(this);
    }

    /* renamed from: l */
    public Losts m83555l() {
        return new Losts(this);
    }

    /* renamed from: m */
    public Medias m83556m() {
        return new Medias(this);
    }

    /* renamed from: n */
    public Messages m83557n() {
        return new Messages(this);
    }

    /* renamed from: o */
    public Quotas m83558o() {
        return new Quotas(this);
    }

    /* renamed from: p */
    public Risks m83559p() {
        return new Risks(this);
    }

    /* renamed from: q */
    public Status m83560q() {
        return new Status(this);
    }

    /* renamed from: r */
    public Tasks m83561r() {
        return new Tasks(this);
    }
}
