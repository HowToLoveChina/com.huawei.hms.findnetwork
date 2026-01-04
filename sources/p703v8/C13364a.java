package p703v8;

import com.huawei.android.hicloud.cloudspace.bean.AlbumSavedInfo;
import sn.C12818a;

/* renamed from: v8.a */
/* loaded from: classes2.dex */
public class C13364a extends C12818a<AlbumSavedInfo> {
    @Override // sn.C12818a
    /* renamed from: a */
    public String mo76960a() {
        return "AlbumStorageReliableRequestor";
    }

    /* renamed from: e */
    public AlbumSavedInfo m80158e() {
        return m76961b();
    }

    /* renamed from: f */
    public void m80159f(long j10, long j11) {
        AlbumSavedInfo albumSavedInfo = new AlbumSavedInfo();
        albumSavedInfo.setGalleryDeleteSize(j11);
        albumSavedInfo.setGalleryUsedSize(j10);
        m76963d(albumSavedInfo);
    }
}
