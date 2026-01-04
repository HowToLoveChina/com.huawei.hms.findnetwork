package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p694v.C13310l;
import p694v.InterfaceC13303e;

/* renamed from: androidx.core.app.a */
/* loaded from: classes.dex */
public class C0609a implements InterfaceC13303e {

    /* renamed from: a */
    public final Context f3386a;

    /* renamed from: b */
    public final Notification.Builder f3387b;

    /* renamed from: c */
    public final NotificationCompat.Builder f3388c;

    /* renamed from: d */
    public RemoteViews f3389d;

    /* renamed from: e */
    public RemoteViews f3390e;

    /* renamed from: f */
    public final List<Bundle> f3391f = new ArrayList();

    /* renamed from: g */
    public final Bundle f3392g = new Bundle();

    /* renamed from: h */
    public int f3393h;

    /* renamed from: i */
    public RemoteViews f3394i;

    public C0609a(NotificationCompat.Builder builder) {
        int i10;
        this.f3388c = builder;
        this.f3386a = builder.f3335a;
        Notification.Builder builder2 = new Notification.Builder(builder.f3335a, builder.f3323K);
        this.f3387b = builder2;
        Notification notification = builder.f3331S;
        builder2.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f3343i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f3339e).setContentText(builder.f3340f).setContentInfo(builder.f3345k).setContentIntent(builder.f3341g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.f3342h, (notification.flags & 128) != 0).setLargeIcon(builder.f3344j).setNumber(builder.f3346l).setProgress(builder.f3354t, builder.f3355u, builder.f3356v);
        builder2.setSubText(builder.f3351q).setUsesChronometer(builder.f3349o).setPriority(builder.f3347m);
        Iterator<NotificationCompat.C0604a> it = builder.f3336b.iterator();
        while (it.hasNext()) {
            m3847b(it.next());
        }
        Bundle bundle = builder.f3316D;
        if (bundle != null) {
            this.f3392g.putAll(bundle);
        }
        this.f3389d = builder.f3320H;
        this.f3390e = builder.f3321I;
        this.f3387b.setShowWhen(builder.f3348n);
        this.f3387b.setLocalOnly(builder.f3360z).setGroup(builder.f3357w).setGroupSummary(builder.f3358x).setSortKey(builder.f3359y);
        this.f3393h = builder.f3328P;
        this.f3387b.setCategory(builder.f3315C).setColor(builder.f3317E).setVisibility(builder.f3318F).setPublicVersion(builder.f3319G).setSound(notification.sound, notification.audioAttributes);
        ArrayList<String> arrayList = builder.f3334V;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f3387b.addPerson(it2.next());
            }
        }
        this.f3394i = builder.f3322J;
        if (builder.f3338d.size() > 0) {
            Bundle bundle2 = builder.m3806f().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i11 = 0; i11 < builder.f3338d.size(); i11++) {
                bundle4.putBundle(Integer.toString(i11), C0610b.m3850a(builder.f3338d.get(i11)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.m3806f().putBundle("android.car.EXTENSIONS", bundle2);
            this.f3392g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        Icon icon = builder.f3333U;
        if (icon != null) {
            this.f3387b.setSmallIcon(icon);
        }
        this.f3387b.setExtras(builder.f3316D).setRemoteInputHistory(builder.f3353s);
        RemoteViews remoteViews = builder.f3320H;
        if (remoteViews != null) {
            this.f3387b.setCustomContentView(remoteViews);
        }
        RemoteViews remoteViews2 = builder.f3321I;
        if (remoteViews2 != null) {
            this.f3387b.setCustomBigContentView(remoteViews2);
        }
        RemoteViews remoteViews3 = builder.f3322J;
        if (remoteViews3 != null) {
            this.f3387b.setCustomHeadsUpContentView(remoteViews3);
        }
        this.f3387b.setBadgeIconType(builder.f3324L).setSettingsText(builder.f3352r).setShortcutId(builder.f3325M).setTimeoutAfter(builder.f3327O).setGroupAlertBehavior(builder.f3328P);
        if (builder.f3314B) {
            this.f3387b.setColorized(builder.f3313A);
        }
        if (!TextUtils.isEmpty(builder.f3323K)) {
            this.f3387b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator<C0611c> it3 = builder.f3337c.iterator();
        while (it3.hasNext()) {
            this.f3387b.addPerson(it3.next().m3860h());
        }
        int i12 = Build.VERSION.SDK_INT;
        this.f3387b.setAllowSystemGeneratedContextualActions(builder.f3330R);
        this.f3387b.setBubbleMetadata(NotificationCompat.C0606c.m3841a(null));
        LocusIdCompat locusIdCompat = builder.f3326N;
        if (locusIdCompat != null) {
            this.f3387b.setLocusId(locusIdCompat.toLocusId());
        }
        if (i12 >= 31 && (i10 = builder.f3329Q) != 0) {
            this.f3387b.setForegroundServiceBehavior(i10);
        }
        if (builder.f3332T) {
            if (this.f3388c.f3358x) {
                this.f3393h = 2;
            } else {
                this.f3393h = 1;
            }
            this.f3387b.setVibrate(null);
            this.f3387b.setSound(null);
            int i13 = notification.defaults & (-4);
            notification.defaults = i13;
            this.f3387b.setDefaults(i13);
            if (TextUtils.isEmpty(this.f3388c.f3357w)) {
                this.f3387b.setGroup("silent");
            }
            this.f3387b.setGroupAlertBehavior(this.f3393h);
        }
    }

    @Override // p694v.InterfaceC13303e
    /* renamed from: a */
    public Notification.Builder mo3846a() {
        return this.f3387b;
    }

    /* renamed from: b */
    public final void m3847b(NotificationCompat.C0604a c0604a) {
        IconCompat iconCompatM3829d = c0604a.m3829d();
        Notification.Action.Builder builder = new Notification.Action.Builder(iconCompatM3829d != null ? iconCompatM3829d.m3920t() : null, c0604a.m3833h(), c0604a.m3826a());
        if (c0604a.m3830e() != null) {
            for (RemoteInput remoteInput : C13310l.m79803b(c0604a.m3830e())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = c0604a.m3828c() != null ? new Bundle(c0604a.m3828c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", c0604a.m3827b());
        int i10 = Build.VERSION.SDK_INT;
        builder.setAllowGeneratedReplies(c0604a.m3827b());
        bundle.putInt("android.support.action.semanticAction", c0604a.m3831f());
        builder.setSemanticAction(c0604a.m3831f());
        builder.setContextual(c0604a.m3835j());
        if (i10 >= 31) {
            builder.setAuthenticationRequired(c0604a.m3834i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", c0604a.m3832g());
        builder.addExtras(bundle);
        this.f3387b.addAction(builder.build());
    }

    /* renamed from: c */
    public Notification m3848c() {
        Bundle bundleM3796a;
        RemoteViews remoteViewsMo3844f;
        RemoteViews remoteViewsMo3842d;
        NotificationCompat.AbstractC0608e abstractC0608e = this.f3388c.f3350p;
        if (abstractC0608e != null) {
            abstractC0608e.mo3837b(this);
        }
        RemoteViews remoteViewsMo3843e = abstractC0608e != null ? abstractC0608e.mo3843e(this) : null;
        Notification notificationM3849d = m3849d();
        if (remoteViewsMo3843e != null) {
            notificationM3849d.contentView = remoteViewsMo3843e;
        } else {
            RemoteViews remoteViews = this.f3388c.f3320H;
            if (remoteViews != null) {
                notificationM3849d.contentView = remoteViews;
            }
        }
        if (abstractC0608e != null && (remoteViewsMo3842d = abstractC0608e.mo3842d(this)) != null) {
            notificationM3849d.bigContentView = remoteViewsMo3842d;
        }
        if (abstractC0608e != null && (remoteViewsMo3844f = this.f3388c.f3350p.mo3844f(this)) != null) {
            notificationM3849d.headsUpContentView = remoteViewsMo3844f;
        }
        if (abstractC0608e != null && (bundleM3796a = NotificationCompat.m3796a(notificationM3849d)) != null) {
            abstractC0608e.mo3836a(bundleM3796a);
        }
        return notificationM3849d;
    }

    /* renamed from: d */
    public Notification m3849d() {
        return this.f3387b.build();
    }
}
