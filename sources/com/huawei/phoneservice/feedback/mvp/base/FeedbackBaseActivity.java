package com.huawei.phoneservice.feedback.mvp.base;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.IntentCheckUtils;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.entity.FeedbackBean;
import com.huawei.phoneservice.feedback.media.impl.utils.C8475a;
import com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f;
import com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity;
import com.huawei.phoneservice.feedbackcommon.photolibrary.MimeType;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.BitmapUtils;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class FeedbackBaseActivity<P extends InterfaceC8497f> extends FeedBaseActivity {

    /* renamed from: C */
    public P f39604C;

    /* renamed from: A0 */
    public void m52741A0(FeedbackBean feedbackBean) {
        if (feedbackBean == null || feedbackBean.getMedias() == null) {
            return;
        }
        Iterator<MediaItem> it = feedbackBean.getMedias().iterator();
        while (it.hasNext()) {
            String filePath = it.next().getFilePath();
            if (filePath != null) {
                File file = new File(filePath);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: B0 */
    public void m52742B0(FeedbackBean feedbackBean, int i10) {
        MediaItem mediaItem;
        String filePath;
        if (feedbackBean == null || feedbackBean.getMedias() == null) {
            return;
        }
        List<MediaItem> medias = feedbackBean.getMedias();
        if (i10 < 0 || i10 >= medias.size() || (mediaItem = medias.get(i10)) == null || (filePath = mediaItem.getFilePath()) == null) {
            return;
        }
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: C0 */
    public void m52743C0(MediaItem mediaItem) throws Throwable {
        Uri uriForFile;
        if (mediaItem == null || mediaItem.getFilePath() == null) {
            return;
        }
        File file = new File(mediaItem.getFilePath());
        String fileProviderAuthorities = SdkProblemManager.getFileProviderAuthorities();
        try {
            if (TextUtils.isEmpty(fileProviderAuthorities)) {
                fileProviderAuthorities = getPackageName() + ".fileprovider";
            }
            uriForFile = FileProvider.getUriForFile(this, fileProviderAuthorities, file);
        } catch (IllegalArgumentException e10) {
            FaqLogger.m51840e("FeedbackBaseActivity", e10.getMessage());
            uriForFile = null;
        }
        if (uriForFile == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(uriForFile, MimeType.isVideo(mediaItem.getMimeType()) ? "video/*" : "image/*");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e11) {
            FaqLogger.m51840e("FeedbackBaseActivity", e11.getMessage());
        }
    }

    /* renamed from: D0 */
    public void m52744D0() {
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: E0 */
    public int m52745E0() {
        int totalColumnCount = new HwColumnSystem(this).getTotalColumnCount();
        if (!C8475a.m52649a()) {
            if (totalColumnCount < 4) {
                return 4;
            }
            return totalColumnCount;
        }
        if (totalColumnCount <= 4) {
            totalColumnCount = 6;
        }
        int i10 = getResources().getConfiguration().orientation;
        if (i10 == 1 && totalColumnCount >= 8) {
            totalColumnCount = 6;
        }
        if (i10 != 2 || totalColumnCount < 12) {
            return totalColumnCount;
        }
        return 10;
    }

    /* renamed from: F0 */
    public abstract P mo52746F0();

    /* renamed from: G0 */
    public void m52747G0() throws Throwable {
        Intent intentCreateGalleryIntent = IntentCheckUtils.createGalleryIntent(getApplicationContext());
        if (intentCreateGalleryIntent == null) {
            FaqLogger.m51840e("FeedbackBaseActivity", "GalleryIntent is null");
            m52966e0("onShowFileChooserFail");
        }
        try {
            startActivityForResult(intentCreateGalleryIntent, 100);
        } catch (ActivityNotFoundException e10) {
            FaqLogger.m51840e("FeedbackBaseActivity", e10.getMessage());
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (this.f39604C == null) {
            this.f39604C = (P) mo52746F0();
        }
        this.f39604C.mo52765a();
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws Throwable {
        super.onDestroy();
        P p10 = this.f39604C;
        if (p10 != null) {
            p10.mo52766b();
        }
    }

    /* renamed from: z0 */
    public List<MediaItem> m52748z0(SafeIntent safeIntent, FeedbackBean feedbackBean) throws Throwable {
        boolean z10;
        String string;
        if (safeIntent == null || safeIntent.getData() == null || feedbackBean == null) {
            return null;
        }
        Uri data = safeIntent.getData();
        List<MediaItem> medias = feedbackBean.getMedias();
        if (medias == null) {
            medias = new ArrayList<>();
        }
        Iterator<MediaItem> it = medias.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (MimeType.isVideo(it.next().getMimeType())) {
                z10 = true;
                break;
            }
        }
        File fileFromUri = BitmapUtils.getFileFromUri(this, data, String.valueOf(System.currentTimeMillis()));
        if (!fileFromUri.exists()) {
            return null;
        }
        String path = fileFromUri.getPath();
        String mimeType = MimeType.getMimeType(path);
        long length = fileFromUri.length();
        if (MimeType.isVideo(mimeType)) {
            if (z10) {
                string = getString(R$string.feedback_sdk_upload_video_count_remind);
            } else if (length > SdkProblemManager.getMaxFileSize() * 1048576) {
                string = getString(R$string.feedback_sdk_upload_video_remind, Integer.valueOf(SdkProblemManager.getMaxFileSize()));
            }
            FaqToastUtils.makeText(this, string);
            fileFromUri.delete();
            return null;
        }
        medias.add(new MediaItem(data.toString(), path, mimeType, length));
        return medias;
    }
}
