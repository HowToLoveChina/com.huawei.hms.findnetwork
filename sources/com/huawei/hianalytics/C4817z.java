package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.C4813x;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.media.controller.FavoriteStateData;
import com.huawei.media.controller.MediaControlCenter;
import com.huawei.media.controller.MediaEvent;
import com.huawei.media.controller.MediaEventFilter;
import com.huawei.media.controller.MediaEventObserver;
import com.huawei.media.controller.MediaMetadata;
import com.huawei.media.controller.MediaPlayerInfo;
import com.huawei.media.controller.MediaPlayerInfoData;
import com.huawei.media.controller.PlaybackStateData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.huawei.hianalytics.z */
/* loaded from: classes5.dex */
public class C4817z {

    /* renamed from: a */
    public C4727a0 f22002a;

    /* renamed from: a */
    public final Map<String, String> f22006a = new HashMap();

    /* renamed from: a */
    public boolean f22007a = false;

    /* renamed from: a */
    public String f22005a = "";

    /* renamed from: b */
    public boolean f22008b = false;

    /* renamed from: a */
    public final MediaControlCenter f22003a = MediaControlCenter.getInstance();

    /* renamed from: a */
    public final MediaEventObserver f22004a = new b();

    /* renamed from: com.huawei.hianalytics.z$b */
    public class b implements MediaEventObserver {
        public b() {
        }

        public void onEvent(MediaEvent mediaEvent) {
            C4813x c4813x;
            MediaPlayerInfoData data;
            List mediaPlayerInfos;
            if (mediaEvent == null || mediaEvent.getData() == null) {
                return;
            }
            C4817z c4817z = C4817z.this;
            c4817z.getClass();
            if ((mediaEvent.getData() instanceof MediaPlayerInfoData) && (data = mediaEvent.getData()) != null && (mediaPlayerInfos = data.getMediaPlayerInfos()) != null && !mediaPlayerInfos.isEmpty()) {
                c4817z.f22006a.clear();
                for (MediaPlayerInfo mediaPlayerInfo : data.getMediaPlayerInfos()) {
                    c4817z.f22006a.put(mediaPlayerInfo.getPlayerId(), mediaPlayerInfo.getPackageName());
                }
                c4817z.m29063c();
            }
            if (c4817z.m29061a(mediaEvent)) {
                if (mediaEvent.getData() instanceof FavoriteStateData) {
                    c4817z.f22002a.f21618a.f21974a = mediaEvent.getData().getState();
                    return;
                }
                if (!(mediaEvent.getData() instanceof MediaMetadata)) {
                    if (mediaEvent.getData() instanceof PlaybackStateData) {
                        boolean z10 = mediaEvent.getData().getState() == 1;
                        c4817z.f22008b = z10;
                        c4817z.f22002a.f21618a.f21977a.add(new C4813x.a(z10, System.currentTimeMillis()));
                        return;
                    }
                    return;
                }
                MediaMetadata data2 = mediaEvent.getData();
                if (data2 == null) {
                    return;
                }
                String string = data2.getString("media.metadata.title") != null ? data2.getString("media.metadata.title") : "";
                String string2 = data2.getString("media.metadata.artist") != null ? data2.getString("media.metadata.artist") : "";
                String string3 = data2.getString("media.metadata.album") != null ? data2.getString("media.metadata.album") : "";
                String string4 = "";
                try {
                    string4 = Long.toString(data2.getLong("media.metadata.duration"));
                } catch (Exception unused) {
                }
                C4811w c4811wM29047a = C4811w.m29047a();
                c4811wM29047a.getClass();
                if (TextUtils.isEmpty(string) || string.length() >= c4811wM29047a.f21970f || TextUtils.isEmpty(string2) || string2.length() >= c4811wM29047a.f21971g) {
                    return;
                }
                if (TextUtils.isEmpty(string3) || string3.length() < c4811wM29047a.f21972h) {
                    C4727a0 c4727a0 = c4817z.f22002a;
                    String str = c4817z.f22005a;
                    if (TextUtils.equals(string, c4727a0.f21618a.f21981c) && TextUtils.equals(string2, c4727a0.f21618a.f21982d) && TextUtils.equals(str, c4727a0.f21618a.f21985g)) {
                        C4813x c4813x2 = c4727a0.f21618a;
                        c4813x2.f21983e = string4;
                        c4813x2.f21984f = string3;
                        return;
                    }
                    c4727a0.f21618a.f21977a.add(new C4813x.a(true, System.currentTimeMillis()));
                    C4813x c4813x3 = c4727a0.f21618a;
                    c4813x3.getClass();
                    C4811w c4811wM29047a2 = C4811w.m29047a();
                    String str2 = c4813x3.f21985g;
                    if (c4811wM29047a2.f21968d.isEmpty() || (!c4811wM29047a2.f21968d.contains(str2))) {
                        long j10 = 0;
                        if (c4813x3.f21977a.size() > 1) {
                            for (int i10 = 0; i10 < c4813x3.f21977a.size() - 1; i10++) {
                                if (c4813x3.f21977a.get(i10).f21987a) {
                                    j10 += c4813x3.f21977a.get(i10 + 1).f21986a - c4813x3.f21977a.get(i10).f21986a;
                                }
                            }
                        }
                        c4813x3.f21978b = j10;
                        c4813x3.f21977a.clear();
                        if (c4813x3.f21978b >= C4811w.m29047a().f21969e) {
                        }
                        c4813x = c4727a0.f21618a;
                        c4813x.f21981c = string;
                        c4813x.f21982d = string2;
                        c4813x.f21983e = string4;
                        c4813x.f21984f = string3;
                        c4813x.f21985g = str;
                        c4813x.f21975a = System.currentTimeMillis();
                        if (!TextUtils.isEmpty(c4813x.f21981c) || TextUtils.isEmpty(c4813x.f21982d)) {
                        }
                        try {
                            c4813x.f21979b = Integer.toString(c4813x.f21981c.hashCode() + c4813x.f21982d.hashCode());
                            return;
                        } catch (Exception unused2) {
                            HiLog.m28812w("McInfo", "Integer Exception");
                            return;
                        }
                    }
                    c4813x3.f21977a.clear();
                    synchronized (c4727a0) {
                        if (!TextUtils.isEmpty(c4727a0.f21618a.f21981c) && !TextUtils.isEmpty(c4727a0.f21618a.f21982d)) {
                            try {
                                HiLog.m28807d("MPL", "cache");
                                C4794n.m28969a(EnvUtils.getAppContext()).insertMcInfo(c4727a0.f21618a.m29055a().toString());
                            } catch (JSONException unused3) {
                                HiLog.m28812w("MPL", "cache JSONException");
                            }
                        }
                    }
                    c4813x = c4727a0.f21618a;
                    c4813x.f21981c = string;
                    c4813x.f21982d = string2;
                    c4813x.f21983e = string4;
                    c4813x.f21984f = string3;
                    c4813x.f21985g = str;
                    c4813x.f21975a = System.currentTimeMillis();
                    if (TextUtils.isEmpty(c4813x.f21981c)) {
                    }
                }
            }
        }

        public /* synthetic */ b(C4817z c4817z, a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.hianalytics.z$c */
    public static class c {

        /* renamed from: a */
        public static final C4817z f22010a = new C4817z();
    }

    /* renamed from: a */
    public final void m29060a() {
        try {
            List<MediaPlayerInfo> playerInfoList = this.f22003a.getPlayerInfoList();
            if (playerInfoList.isEmpty()) {
                playerInfoList = this.f22003a.getHistoryMediaPlayerInfoList();
            }
            this.f22006a.clear();
            for (MediaPlayerInfo mediaPlayerInfo : playerInfoList) {
                this.f22006a.put(mediaPlayerInfo.getPlayerId(), mediaPlayerInfo.getPackageName());
            }
        } catch (Exception unused) {
            HiLog.m28812w("MediaHelper", "RPI Exception");
        }
    }

    /* renamed from: b */
    public synchronized void m29062b() {
        if (this.f22007a) {
            HiLog.m28807d("MediaHelper", "register: hasInit");
            return;
        }
        try {
            m29060a();
        } catch (Throwable th2) {
            HiLog.m28812w("MediaHelper", "register error: " + th2.getMessage());
        }
        if (this.f22006a.isEmpty()) {
            return;
        }
        synchronized (this) {
            HiLog.m28807d("MediaHelper", "unregister");
            if (this.f22007a) {
                this.f22003a.unregisterEventObserver(this.f22004a);
            }
            m29063c();
            this.f22007a = true;
        }
    }

    /* renamed from: c */
    public final void m29063c() {
        if (C4811w.m29047a().f21961a) {
            C4811w c4811wM29047a = C4811w.m29047a();
            c4811wM29047a.getClass();
            if (c4811wM29047a.f21963b.contains(C4785j.m28930b(EnvUtils.getAppContext()))) {
                MediaEventFilter mediaEventFilter = new MediaEventFilter();
                Iterator<String> it = this.f22006a.keySet().iterator();
                while (it.hasNext()) {
                    mediaEventFilter.addPlayerId(it.next());
                }
                mediaEventFilter.addEventType(20);
                mediaEventFilter.addEventType(3);
                mediaEventFilter.addEventType(11);
                mediaEventFilter.addEventType(4);
                this.f22003a.registerEventObserver(this.f22004a, mediaEventFilter);
            }
        }
    }

    /* renamed from: a */
    public final boolean m29061a(MediaEvent mediaEvent) {
        if (this.f22006a.get(mediaEvent.getPlayerId()) != null) {
            this.f22005a = this.f22006a.get(mediaEvent.getPlayerId());
        }
        if (TextUtils.isEmpty(this.f22005a)) {
            return false;
        }
        C4811w c4811wM29047a = C4811w.m29047a();
        String str = this.f22005a;
        if (c4811wM29047a.f21960a.isEmpty()) {
            return true;
        }
        return c4811wM29047a.f21960a.contains(str);
    }
}
