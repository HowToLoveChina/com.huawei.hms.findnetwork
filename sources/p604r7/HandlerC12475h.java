package p604r7;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.p069cg.activity.PhotoPickerActivity;
import com.huawei.android.p069cg.bean.MediaFileBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p031b7.C1120a;

/* renamed from: r7.h */
/* loaded from: classes2.dex */
public class HandlerC12475h extends Handler {

    /* renamed from: a */
    public final WeakReference<PhotoPickerActivity> f57438a;

    public HandlerC12475h(PhotoPickerActivity photoPickerActivity) {
        this.f57438a = new WeakReference<>(photoPickerActivity);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        PhotoPickerActivity photoPickerActivity = this.f57438a.get();
        if (photoPickerActivity == null || photoPickerActivity.isFinishing()) {
            C1120a.m6677i("PhotoPickerHandler", "PhotoPickerActivity check invalid");
            return;
        }
        Bundle data = message.getData();
        ArrayList<MediaFileBean> parcelableArrayList = data != null ? data.getParcelableArrayList("extra_query_local_data") : null;
        int i10 = message.what;
        if (i10 == 10000) {
            photoPickerActivity.m13616R1(parcelableArrayList, false);
        } else {
            if (i10 != 10001) {
                return;
            }
            photoPickerActivity.m13616R1(parcelableArrayList, true);
        }
    }
}
