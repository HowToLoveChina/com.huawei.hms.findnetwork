package com.huawei.hiar;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.huawei.hiar.annotations.UsedByNative;
import java.io.IOException;

@UsedByNative("huawei_arengine_interface.cpp")
/* loaded from: classes5.dex */
public class ARVideoSource {
    private static final String TAG = "ARVideoSource";
    private MediaMetadataRetriever mediaMetadataRetriever;
    private MediaPlayer player;
    private Surface surface;
    private String videoPath;

    /* renamed from: com.huawei.hiar.ARVideoSource$a */
    public class C4831a implements MediaPlayer.OnPreparedListener {
        public C4831a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            ARVideoSource.this.player.setLooping(true);
            ARVideoSource.this.player.start();
        }
    }

    public ARVideoSource() {
    }

    public int getVideoHeight() {
        try {
            return Integer.parseInt(this.mediaMetadataRetriever.extractMetadata(19));
        } catch (NumberFormatException e10) {
            Log.e(TAG, "get video height failed!" + e10.getClass());
            return 0;
        }
    }

    public int getVideoWidth() {
        try {
            return Integer.parseInt(this.mediaMetadataRetriever.extractMetadata(18));
        } catch (NumberFormatException e10) {
            Log.e(TAG, "get video width failed!" + e10.getClass());
            return 0;
        }
    }

    public void initPlayer() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.player.reset();
        try {
            Log.d(TAG, "VideoPath is " + this.videoPath);
            this.player.setDataSource(this.videoPath);
            this.player.setSurface(this.surface);
            this.mediaMetadataRetriever.setDataSource(this.videoPath);
            this.player.setOnPreparedListener(new C4831a());
        } catch (IOException unused) {
            Log.w(TAG, "init Player fail!");
        }
    }

    public void pauseVideoPlay() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void releasePlayer() throws IOException {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        MediaMetadataRetriever mediaMetadataRetriever = this.mediaMetadataRetriever;
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
    }

    public void resumeVideoPlay() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
        this.player.setSurface(surface);
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    @UsedByNative("huawei_arengine_interface.cpp")
    public void startPlayVideo() throws IllegalStateException, IOException {
        try {
            this.player.prepare();
        } catch (IOException unused) {
            Log.w(TAG, "start Player video fail!");
        }
    }

    public void stopVideoPlay() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @UsedByNative("huawei_arengine_interface.cpp")
    public ARVideoSource(Surface surface, String str) {
        this.surface = surface;
        this.videoPath = str;
        this.player = new MediaPlayer();
        this.mediaMetadataRetriever = new MediaMetadataRetriever();
    }
}
