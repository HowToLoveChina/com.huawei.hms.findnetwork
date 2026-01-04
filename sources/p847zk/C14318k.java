package p847zk;

import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: zk.k */
/* loaded from: classes6.dex */
public class C14318k implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public long f63586a;

    /* renamed from: b */
    public CopyOnWriteArrayList<AppDetailsInfo> f63587b;

    /* renamed from: c */
    public List<CBSSyncRecordDeviceInfo> f63588c;

    /* renamed from: d */
    public List<AppDetailsInfo> f63589d;

    /* renamed from: e */
    public List<String> f63590e;

    public C14318k() {
        this.f63587b = new CopyOnWriteArrayList<>();
    }

    /* renamed from: b */
    public CopyOnWriteArrayList<AppDetailsInfo> m85325b() {
        return this.f63587b;
    }

    /* renamed from: c */
    public List<CBSSyncRecordDeviceInfo> m85326c() {
        return this.f63588c;
    }

    /* renamed from: d */
    public List<String> m85327d() {
        return (List) Optional.ofNullable(this.f63590e).orElse(new ArrayList());
    }

    /* renamed from: e */
    public long m85328e() {
        return this.f63586a;
    }

    /* renamed from: f */
    public List<AppDetailsInfo> m85329f() {
        return (List) Optional.ofNullable(this.f63589d).orElse(new ArrayList());
    }

    /* renamed from: g */
    public void m85330g(List<CBSSyncRecordDeviceInfo> list) {
        this.f63588c = list;
    }

    /* renamed from: h */
    public void m85331h() {
        if (this.f63586a == 0) {
            this.f63586a = System.currentTimeMillis();
        }
    }

    /* renamed from: j */
    public void m85332j(List<AppDetailsInfo> list) {
        this.f63589d = list;
    }

    public C14318k(List<String> list, CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList, List<CBSSyncRecordDeviceInfo> list2) {
        new CopyOnWriteArrayList();
        this.f63587b = copyOnWriteArrayList;
        this.f63588c = list2;
        this.f63590e = list;
    }
}
