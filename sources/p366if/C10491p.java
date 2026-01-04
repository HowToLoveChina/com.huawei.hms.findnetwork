package p366if;

import android.location.Location;
import p366if.C10487l;
import p809yg.C13981a;

/* renamed from: if.p */
/* loaded from: classes4.dex */
public class C10491p implements C10487l.b {

    /* renamed from: a */
    public C10477b f50633a;

    /* renamed from: b */
    public boolean f50634b = false;

    public C10491p(C10477b c10477b) {
        this.f50633a = c10477b;
    }

    @Override // p366if.C10487l.b
    /* renamed from: a */
    public void mo26992a(Location location) {
        C13981a.m83989i("MyBaiduLocationListener", "location success");
        C13981a.m83987d("MyBaiduLocationListener", "provider:" + location.getProvider() + ", utc:" + location.getTime());
        this.f50633a.m64409Y0(location);
        this.f50633a.m64411a1(location);
    }

    @Override // p366if.C10487l.b
    /* renamed from: b */
    public void mo26993b() {
        if (this.f50634b) {
            C13981a.m83989i("MyBaiduLocationListener", "location == null");
            this.f50633a.m64408X0(8);
            this.f50633a.m64411a1(null);
        } else {
            this.f50634b = true;
            C13981a.m83989i("MyBaiduLocationListener", "location failed,retry");
            this.f50633a.m64410Z0();
        }
    }
}
