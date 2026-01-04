package p784xq;

import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.callback.ARCallback;
import java.util.List;

/* renamed from: xq.d */
/* loaded from: classes8.dex */
public final class C13848d {

    /* renamed from: a */
    public List<DetectedActivity> f62109a;

    /* renamed from: b */
    public int f62110b = -2;

    /* renamed from: c */
    public int f62111c = -2;

    /* renamed from: d */
    public int f62112d = -2;

    /* renamed from: e */
    public int f62113e = 0;

    /* renamed from: f */
    public int f62114f = 0;

    /* renamed from: g */
    public int f62115g = 0;

    /* renamed from: h */
    public int f62116h = 0;

    /* renamed from: i */
    public a f62117i = new a(this, 0);

    /* renamed from: xq.d$a */
    public class a implements ARCallback {
        public a() {
        }

        @Override // com.huawei.location.base.activity.callback.ARCallback
        public final void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) {
            C13848d.this.f62109a = activityRecognitionResult.getProbableActivities();
            C13848d c13848d = C13848d.this;
            List<DetectedActivity> list = c13848d.f62109a;
            if (list == null) {
                C1016d.m6183c("ATProvider", "detectedActivities is null.");
                return;
            }
            int type = -1;
            int confidence = -1;
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10).getType() != 2 && list.get(i10).getConfidence() > confidence) {
                    type = list.get(i10).getType();
                    confidence = list.get(i10).getConfidence();
                }
            }
            C13848d.m83117c(c13848d, type);
        }

        public /* synthetic */ a(C13848d c13848d, int i10) {
            this();
        }
    }

    /* renamed from: c */
    public static void m83117c(C13848d c13848d, int i10) {
        c13848d.getClass();
        StringBuilder sb2 = new StringBuilder(" GET NEW RESULT : ");
        sb2.append(i10);
        sb2.append(" currentStatus is : ");
        C13850f.m83120a(sb2, c13848d.f62110b, "ATProvider");
        c13848d.f62111c = i10;
        int i11 = c13848d.f62110b;
        if (i11 == -2) {
            c13848d.f62110b = i10;
            C1016d.m6186f("ATProvider", "report ！  statu is : " + c13848d.f62110b + " inOrOut is : 1");
            RiemannSoftArService.getInstance().onStatusChanged(i10, 1);
            return;
        }
        if (i10 == i11) {
            if (c13848d.f62113e == 0) {
                return;
            }
            int i12 = c13848d.f62116h + 1;
            c13848d.f62116h = i12;
            if (i12 >= 10) {
                c13848d.f62113e = 0;
                c13848d.f62114f = 0;
                c13848d.f62115g = 0;
                c13848d.f62116h = 0;
                return;
            }
            return;
        }
        int i13 = c13848d.f62114f + 1;
        c13848d.f62114f = i13;
        c13848d.f62113e = 1;
        int i14 = c13848d.f62112d;
        if (i14 == -2 || i14 == -1) {
            c13848d.f62112d = i10;
            return;
        }
        if (i13 == 10 && i11 != -1) {
            C1016d.m6186f("ATProvider", "report ！  statu is : " + c13848d.f62110b + " inOrOut is : 2");
            RiemannSoftArService.getInstance().onStatusChanged(i11, 2);
            c13848d.f62110b = -1;
        }
        int i15 = c13848d.f62111c;
        if (i15 == c13848d.f62112d) {
            c13848d.f62115g++;
        } else {
            c13848d.f62112d = i15;
            c13848d.f62115g = 1;
        }
        if (c13848d.f62115g >= 10) {
            c13848d.f62113e = 0;
            c13848d.f62114f = 0;
            c13848d.f62115g = 0;
            c13848d.f62116h = 0;
            int i16 = c13848d.f62112d;
            c13848d.f62110b = i16;
            c13848d.f62112d = -1;
            C1016d.m6186f("ATProvider", "report ！  statu is : " + c13848d.f62110b + " inOrOut is : 1");
            RiemannSoftArService.getInstance().onStatusChanged(i16, 1);
        }
    }

    /* renamed from: a */
    public final void m83118a() {
        this.f62110b = -2;
        this.f62111c = -2;
        this.f62112d = -2;
        this.f62113e = 0;
        this.f62114f = 0;
        this.f62115g = 0;
        this.f62116h = 0;
    }

    /* renamed from: b */
    public final a m83119b() {
        return this.f62117i;
    }
}
