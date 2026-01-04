package p257eh;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ApiCode;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Arrays;

/* renamed from: eh.b */
/* loaded from: classes4.dex */
public class C9480b implements IConnectionResult {

    /* renamed from: a */
    public final int f47252a;

    /* renamed from: b */
    public final PendingIntent f47253b;

    /* renamed from: c */
    public final String f47254c;

    public C9480b(int i10) {
        this(i10, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C9480b)) {
            return false;
        }
        C9480b c9480b = (C9480b) obj;
        if (this.f47252a == c9480b.f47252a && this.f47253b == null) {
            if (c9480b.f47253b == null) {
                return true;
            }
        } else if (this.f47253b.equals(c9480b.f47253b) && TextUtils.equals(this.f47254c, c9480b.f47254c)) {
            return true;
        }
        return false;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public String getErrorMessage() {
        return this.f47254c;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public PendingIntent getResolution() {
        return this.f47253b;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public int getStatusCode() {
        return this.f47252a;
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public boolean hasResolution() {
        return (this.f47252a == 0 || this.f47253b == null) ? false : true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f47252a), this.f47253b, this.f47254c});
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f47253b.getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    public C9480b(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, ApiCode.getStatusCodeString(i10));
    }

    public C9480b(int i10, PendingIntent pendingIntent, String str) {
        this.f47252a = i10;
        this.f47253b = pendingIntent;
        this.f47254c = str;
    }
}
