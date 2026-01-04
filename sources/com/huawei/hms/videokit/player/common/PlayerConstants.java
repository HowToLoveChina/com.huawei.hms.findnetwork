package com.huawei.hms.videokit.player.common;

/* loaded from: classes8.dex */
public class PlayerConstants {

    public static class BandwidthSwitchMode {
        public static final int AUTO_SWITCH_MODE = 0;
        public static final int MANUAL_SWITCH_MODE = 1;
    }

    public static class CycleMode {
        public static final int MODE_CYCLE = 1;
        public static final int MODE_NORMAL = 0;
    }

    public static class DeviceType {
        public static final int MOBILE = 0;

        /* renamed from: TV */
        public static final int f30361TV = 1;
    }

    public static class ErrorCode {
        public static final int DEFAULT_ERROR = 1199;
        public static final int DRM_FAILED = 1300;
        public static final int GET_URL_FAILED = 1119;
        public static final int INPUT_PARAM_ILLEGAL_ERROR = 1130;
        public static final int INVALID_SERVER = 1205;
        public static final int IO_FAILED = 1201;
        public static final int IO_TIMEOUT = 1202;
        public static final int LOAD_LIBRARY_FAILED = 1001;
        public static final int MEDIA_ERROR_SERVER_DIED = 1000;
        public static final int MEDIA_NOT_FOUND = 1100;
        public static final int MEDIA_SEEK_NO_AVAILABLE_SEGMENT = 1021;
        public static final int NO_SSL_CERTIFICATE = 1204;
        public static final int PARSE_FAILED = 1004;
        public static final int PLAYLIST_NOT_UPDATED = 1005;
        public static final int PLAYPARAM_PARSE_FAILED = 1101;
        public static final int PROTOCOL_SPEC = 1203;
        public static final int RENDER_INIT_FAILED = 1029;
        public static final int SERVER_ERROR = 1131;
        public static final int SWITCH_AUDIO_FAILED = 1025;
        public static final int SWITCH_BITRATE_FAILED = 1024;
        public static final int SWITCH_PLAYMODE_AUDIO_FAILED = 1022;
        public static final int SWITCH_PLAYMODE_NORMAL_FAILED = 1023;
        public static final int SWITCH_SPEED_FAILED = 1027;
        public static final int SWITCH_SUBTITLE_FAILED = 1026;
        public static final int UNKNOWN = 1099;
        public static final int UNSUPPORTED_BANDWIDTH = 1028;
        public static final int UNSUPPORTED_CODEC = 1002;
        public static final int UNSUPPORTED_FORMAT = 1003;
        public static final int URL_ARRAY_LENGTH_ERROR = 1121;
        public static final int URL_ERROR = 1120;
    }

    public static class EventCode {
        public static final int BANDWIDTH_UPDATE = 214;
        public static final int BITRATE_SWITCH_COMPLETE = 216;
        public static final int CAN_NOT_SUPPORT_PROXY = 217;
        public static final int CDN_SWITCH = 213;
        public static final int LAYOUT_NOT_SUPPORT_SUBTITLE = 218;
        public static final int MEDIA_INFO_AUDIO_NOT_PLAYING = 201;
        public static final int MEDIA_INFO_BAD_INTERLEAVING = 203;
        public static final int MEDIA_INFO_METADATA_UPDATE = 209;
        public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 211;
        public static final int MEDIA_INFO_UNKNOWN = 212;
        public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 210;
        public static final int MEDIA_INFO_VIDEO_NOT_PLAYING = 202;
        public static final int UNSEEKABLE = 206;
        public static final int VIDEO_DECODE_LAGGING = 208;
        public static final int VIDEO_FIRST_FRAME = 207;
        public static final int VIDEO_MATCH_PRELOAD = 215;
    }

    public static class InitErrorCode {
        public static final int INIT_ERROR_DMP_OPEN_FAILED = 9904;
        public static final int INIT_ERROR_DYNAMICLOADER_FAILED = 9903;
        public static final int INIT_ERROR_DYNAMICLOADER_MODULE_NONE = 9902;
        public static final int INIT_ERROR_PARAM_ILLEGAL = 9901;
        public static final int INIT_ERROR_UNKNOWN = 9999;
    }

    public static class PlayMode {
        public static final int PLAY_MODE_AUDIO_ONLY = 1;
        public static final int PLAY_MODE_NORMAL = 0;
    }

    public static class Properties {
        public static final int DEVICE_TYPE = 4;
        public static final int RESUME_START_FRAME_MODE = 3;
        public static final int SET_CLOSE_IPV6 = 2;
        public static final int SINGLE_LINK_DOWNLOAD = 1;
    }

    public static class ResumeType {
        public static final int KEEP = -1;
        public static final int PAUSE = 1;
        public static final int PLAY = 0;
    }

    public static class ScenarioType {
        public static final int ONLINE = 0;
    }

    public static class SeekMode {
        public static final int CLOSEST = 1;
        public static final int PREVIOUS_SYNC = 0;
    }

    public static class VideoFormat {
        public static final int H264 = 1;
        public static final int H265 = 2;
    }
}
