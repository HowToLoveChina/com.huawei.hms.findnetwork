package p390ja;

import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput;
import com.huawei.hms.utils.IOUtils;
import java.io.IOException;
import java.util.function.Consumer;

/* renamed from: ja.p */
/* loaded from: classes3.dex */
public final /* synthetic */ class C10762p implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws IOException {
        IOUtils.closeQuietly((SeekableInput) obj);
    }
}
