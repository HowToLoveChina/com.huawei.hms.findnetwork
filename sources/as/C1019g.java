package as;

import android.util.Log;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: as.g */
/* loaded from: classes8.dex */
public final class C1019g {

    /* renamed from: a */
    public final StringBuilder f5055a = new StringBuilder();

    /* renamed from: b */
    public String f5056b;

    /* renamed from: c */
    public int f5057c;

    /* renamed from: d */
    public long f5058d;

    /* renamed from: e */
    public boolean f5059e;

    public C1019g(int i10, String str) {
        this.f5056b = ActivityRecognitionConstants.LOCATION_MODULE;
        this.f5058d = 0L;
        this.f5057c = i10;
        if (str != null) {
            this.f5056b = str;
        }
        this.f5058d = System.currentTimeMillis();
        this.f5059e = true;
    }

    /* renamed from: a */
    public final String m6193a() {
        StringBuilder sb2 = new StringBuilder();
        m6196d(sb2);
        return sb2.toString();
    }

    /* renamed from: b */
    public final String m6194b() {
        return " " + this.f5055a.toString();
    }

    /* renamed from: c */
    public final void m6195c(Object obj) {
        this.f5055a.append(obj);
    }

    /* renamed from: d */
    public final void m6196d(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.f5058d)));
        sb2.append(' ');
        int i10 = this.f5057c;
        sb2.append(i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? String.valueOf(i10) : "E" : "W" : "I" : "D");
        sb2.append(C5929g4.f26852n);
        sb2.append(this.f5056b);
        sb2.append(']');
        if (this.f5059e) {
            return;
        }
        sb2.append("[m]");
    }

    /* renamed from: e */
    public final void m6197e(Throwable th2) {
        this.f5055a.append((Object) '\n');
        this.f5055a.append((Object) Log.getStackTraceString(th2));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        m6196d(sb2);
        sb2.append(' ');
        sb2.append(this.f5055a.toString());
        return sb2.toString();
    }
}
