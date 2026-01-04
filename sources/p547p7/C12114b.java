package p547p7;

import com.huawei.android.hicloud.drive.cloudphoto.model.Change;

/* renamed from: p7.b */
/* loaded from: classes2.dex */
public class C12114b {

    /* renamed from: a */
    public String f56180a;

    public C12114b() {
    }

    /* renamed from: a */
    public String m72558a() {
        return this.f56180a;
    }

    /* renamed from: b */
    public void m72559b(String str) {
        this.f56180a = str;
    }

    public C12114b(Change change) {
        if (change == null) {
            return;
        }
        this.f56180a = change.getAlbumId();
    }
}
