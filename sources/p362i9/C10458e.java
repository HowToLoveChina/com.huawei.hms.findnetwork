package p362i9;

import android.content.Context;
import fk.C9721b;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0229n;
import p051c9.C1397b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: i9.e */
/* loaded from: classes3.dex */
public class C10458e extends AbstractC12367d {
    /* renamed from: c */
    public final void m64264c() {
        C11839m.m70688i("QueryCategoryStorageTask", "queryCategorySize start");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryCategoryStorageTask", "context is null");
            return;
        }
        String strM1363m = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_total_size", "");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize lastTotalSize " + strM1363m);
        String strM1606e = C0229n.m1606e();
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize total " + strM1606e);
        long jM1607f = C0229n.m1607f(strM1606e);
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize total " + jM1607f);
        boolean zEquals = strM1363m.equals(String.valueOf(jM1607f)) ^ true;
        C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_total_size", String.valueOf(jM1607f));
        String strM1363m2 = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_used_size", "");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize lastUsedSize " + strM1363m2);
        long jM1605d = jM1607f - C0229n.m1605d("/storage/emulated/0");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize availableSize " + jM1605d);
        if (!strM1363m2.equals(String.valueOf(jM1605d))) {
            zEquals = true;
        }
        C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_used_size", String.valueOf(jM1605d));
        String strM1363m3 = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_image_size", "");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize lastImageSize " + strM1363m3);
        long jM8000d = C1397b.m8000d(contextM1377a, 0, "/storage/emulated/0");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize imageSize " + jM8000d);
        if (!strM1363m3.equals(String.valueOf(jM8000d))) {
            zEquals = true;
        }
        C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_image_size", String.valueOf(jM8000d));
        String strM1363m4 = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_video_size", "");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize lastVideoSize " + strM1363m4);
        long jM8000d2 = C1397b.m8000d(contextM1377a, 2, "/storage/emulated/0");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize videoSize " + jM8000d2);
        if (!strM1363m4.equals(String.valueOf(jM8000d2))) {
            zEquals = true;
        }
        C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_video_size", String.valueOf(jM8000d2));
        String strM1363m5 = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_audio_size", "");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize lastAudioSize " + strM1363m5);
        long jM8000d3 = C1397b.m8000d(contextM1377a, 1, "/storage/emulated/0");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize audioSize " + jM8000d3);
        if (!strM1363m5.equals(String.valueOf(jM8000d3))) {
            zEquals = true;
        }
        C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_audio_size", String.valueOf(jM8000d3));
        String strM1363m6 = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_document_size", "");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize lastDocSize " + strM1363m6);
        long jM8000d4 = C1397b.m8000d(contextM1377a, 3, "/storage/emulated/0");
        C11839m.m70686d("QueryCategoryStorageTask", "queryCategorySize documentSize " + jM8000d4);
        if (!strM1363m6.equals(String.valueOf(jM8000d4))) {
            zEquals = true;
        }
        C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_document_size", String.valueOf(jM8000d4));
        if (zEquals) {
            C0212e0.m1365o(contextM1377a, "sp_device_use_info", "key_has_data_change", true);
        }
        C11839m.m70688i("QueryCategoryStorageTask", "queryCategorySize end " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        m64264c();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.COLLECT_DEVICE_INFO;
    }
}
