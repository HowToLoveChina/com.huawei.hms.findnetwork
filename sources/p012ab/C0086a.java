package p012ab;

import android.content.Context;
import com.huawei.android.hicloud.drive.user.request.Keys;
import com.huawei.android.hicloud.drive.user.request.Risks;
import com.huawei.android.hicloud.drive.user.request.Users;
import com.huawei.cloud.services.drive.Drive;
import p340hi.C10209a;

/* renamed from: ab.a */
/* loaded from: classes3.dex */
public class C0086a extends Drive {

    /* renamed from: ab.a$a */
    public static final class a extends Drive.Builder {
        public a(C10209a c10209a, Context context) {
            super(c10209a, context);
        }

        @Override // com.huawei.cloud.services.drive.Drive.Builder, p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        /* renamed from: a */
        public C0086a build() {
            return new C0086a(this);
        }
    }

    public C0086a(a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    public Keys m674a() {
        return new Keys(this);
    }

    /* renamed from: b */
    public Risks m675b() {
        return new Risks(this);
    }

    /* renamed from: c */
    public Users m676c() {
        return new Users(this);
    }
}
