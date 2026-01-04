package p748wp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import p399jk.AbstractC10896a;

/* renamed from: wp.a */
/* loaded from: classes8.dex */
public final class C13624a {

    /* renamed from: c */
    public static volatile C13624a f61290c;

    /* renamed from: b */
    public final Timer f61292b = new Timer();

    /* renamed from: a */
    public final List<TimerTask> f61291a = Collections.synchronizedList(new ArrayList());

    /* renamed from: wp.a$a */
    public class a extends TimerTask {

        /* renamed from: a */
        public final /* synthetic */ TimerTask f61293a;

        public a(TimerTask timerTask) {
            this.f61293a = timerTask;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (C13624a.this.f61291a.contains(this.f61293a)) {
                this.f61293a.run();
                C13624a.this.f61291a.remove(this.f61293a);
            }
        }
    }

    /* renamed from: b */
    public static C13624a m81979b() {
        if (f61290c == null) {
            synchronized (C13624a.class) {
                try {
                    if (f61290c == null) {
                        f61290c = new C13624a();
                    }
                } finally {
                }
            }
        }
        return f61290c;
    }

    /* renamed from: c */
    public void m81980c(TimerTask timerTask, Date date) {
        this.f61292b.schedule(new a(timerTask), date);
        this.f61291a.add(timerTask);
        AbstractC10896a.m65885d("CommonTimer", "set timer task in date time:" + date.getTime() + ", tasks count:" + this.f61291a.size());
    }
}
