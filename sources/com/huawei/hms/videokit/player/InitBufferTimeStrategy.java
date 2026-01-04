package com.huawei.hms.videokit.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes8.dex */
public class InitBufferTimeStrategy {

    /* renamed from: a */
    private int f30233a;

    /* renamed from: b */
    private List<DownloadMultipleZone> f30234b;

    public static class Builder {

        /* renamed from: a */
        private int f30235a;

        /* renamed from: b */
        private List<DownloadMultipleZone> f30236b = new ArrayList();

        public Builder(int i10) {
            this.f30235a = i10;
        }

        /* renamed from: a */
        private void m37093a() {
            List<DownloadMultipleZone> list = this.f30236b;
            if (list == null) {
                throw new DownloadMultipleZoneException("Build Construction failed.");
            }
            Collections.sort(list, new C6530b());
            int i10 = 0;
            if (this.f30236b.get(0).getMax() != Integer.MAX_VALUE) {
                throw new DownloadMultipleZoneException("Not contains max value");
            }
            while (i10 < this.f30236b.size() - 1) {
                int min = this.f30236b.get(i10).getMin();
                i10++;
                if (min != this.f30236b.get(i10).getMax()) {
                    throw new DownloadMultipleZoneException("Data format error");
                }
            }
        }

        public void append(int i10, int i11, int i12) throws IllegalArgumentException {
            if (i10 < 0 || i11 < 0 || i12 < 0 || i10 == i11) {
                throw new IllegalArgumentException();
            }
            this.f30236b.add(new DownloadMultipleZone(i10, i11, i12));
        }

        public InitBufferTimeStrategy build() throws DownloadMultipleZoneException {
            m37093a();
            return new InitBufferTimeStrategy(this.f30235a, this.f30236b);
        }
    }

    public static class DownloadMultipleZone {

        /* renamed from: a */
        private int f30237a;

        /* renamed from: b */
        private int f30238b;

        /* renamed from: c */
        private int f30239c;

        public DownloadMultipleZone(int i10, int i11, int i12) {
            this.f30237a = i10;
            this.f30238b = i11;
            this.f30239c = i12;
        }

        public int getBufferTime() {
            return this.f30239c;
        }

        public int getMax() {
            return this.f30238b;
        }

        public int getMin() {
            return this.f30237a;
        }
    }

    public static class DownloadMultipleZoneException extends RuntimeException {
        public DownloadMultipleZoneException() {
        }

        public DownloadMultipleZoneException(String str) {
            super(str);
        }

        public DownloadMultipleZoneException(Throwable th2) {
            super(th2);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.InitBufferTimeStrategy$b */
    public static class C6530b implements Comparator<DownloadMultipleZone>, Serializable {
        private C6530b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(DownloadMultipleZone downloadMultipleZone, DownloadMultipleZone downloadMultipleZone2) {
            if (downloadMultipleZone.getMax() < downloadMultipleZone2.getMax()) {
                return 1;
            }
            return (downloadMultipleZone.getMax() != downloadMultipleZone2.getMax() && downloadMultipleZone.getMax() > downloadMultipleZone2.getMax()) ? -1 : 0;
        }
    }

    private InitBufferTimeStrategy() {
    }

    private InitBufferTimeStrategy(int i10, List<DownloadMultipleZone> list) {
        this.f30233a = i10;
        this.f30234b = list;
    }

    public List<DownloadMultipleZone> getDownloadMultipleZones() {
        return this.f30234b;
    }

    public int getMaxBufferTime() {
        return this.f30233a;
    }
}
