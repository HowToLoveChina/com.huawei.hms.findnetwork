package p313g9;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Formatter;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import p015ak.C0209d;
import p292fn.C9733f;
import p514o9.C11839m;

/* renamed from: g9.a */
/* loaded from: classes3.dex */
public class C9895a extends ContentObserver {

    /* renamed from: a */
    public Handler f48540a;

    /* renamed from: b */
    public Context f48541b;

    /* renamed from: c */
    public boolean f48542c;

    public C9895a(Context context, Handler handler) {
        super(handler);
        this.f48542c = false;
        this.f48541b = context;
        this.f48540a = handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        C11839m.m70686d("CloudAlbumCheckSizeContentObserver", "selfChange:" + z10);
        Context context = this.f48541b;
        if (context == null) {
            C11839m.m70687e("CloudAlbumCheckSizeContentObserver", "checksize,context is null");
            return;
        }
        if (!C0209d.m1227Y1(context, Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI))) {
            C11839m.m70687e("CloudAlbumCheckSizeContentObserver", "is not Target App or System App");
            return;
        }
        Message messageObtain = Message.obtain();
        try {
            Bundle bundleCall = this.f48541b.getContentResolver().call(Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI), NotifyConstants.CloudAlbumReleaseSpace.METHOD_GET_FILE_SIZE, (String) null, (Bundle) null);
            long j10 = bundleCall != null ? bundleCall.getLong(NotifyConstants.CloudAlbumReleaseSpace.KEY_CLEAN_FILE_SIZE, -1L) : 0L;
            if (this.f48542c) {
                C11839m.m70688i("CloudAlbumCheckSizeContentObserver", "from recomend card");
                messageObtain.obj = Long.valueOf(j10);
                messageObtain.what = 102;
                this.f48540a.sendMessage(messageObtain);
                return;
            }
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C11839m.m70687e("CloudAlbumCheckSizeContentObserver", "hiCloudSysParamMap is null");
                return;
            }
            float releaseSpaceSize = hiCloudSysParamMapM60757p.getReleaseSpaceSize();
            float f10 = j10 / 1.0737418E9f;
            String shortFileSize = Formatter.formatShortFileSize(this.f48541b, j10);
            C11839m.m70686d("CloudAlbumCheckSizeContentObserver", "fileSize:" + j10 + " fileSizeForGB:" + f10 + " releaseSpaceSize:" + releaseSpaceSize);
            if (f10 >= releaseSpaceSize) {
                C11839m.m70688i("CloudAlbumCheckSizeContentObserver", "filesize enough");
                messageObtain.obj = shortFileSize;
                messageObtain.what = 100;
            } else {
                messageObtain.what = 101;
                C11839m.m70688i("CloudAlbumCheckSizeContentObserver", "filesize not enough");
            }
            this.f48540a.sendMessage(messageObtain);
        } catch (Exception e10) {
            C11839m.m70688i("CloudAlbumCheckSizeContentObserver", "cloudalbumchecksizecontentobserver exception:" + e10.getMessage());
            messageObtain.what = 101;
            this.f48540a.sendMessage(messageObtain);
        }
    }

    public C9895a(Context context, Handler handler, boolean z10) {
        super(handler);
        this.f48541b = context;
        this.f48540a = handler;
        this.f48542c = z10;
    }
}
