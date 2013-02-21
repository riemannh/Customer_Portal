package com.res.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午9:32
 * To change this template use File | Settings | File Templates.
 */
public class DishBean extends AbstractBean {
    public static final String SMALL_PICTURE_ADDRESS = "small_pic_addr";
    public static final String BIG_PRICTURE_ADDRESS = "big_pic_addr";
    public static final String VIDEO_ADDRESS = "video_addr";
    public static final String AUDIO_ADDRESS = "audio_addr";

    private String smallPictureAddress;
    private String bigPictureAddress;
    private String videoAddress;
    private String audioAddress;


    public String getSmallPictureAddress() {
        return smallPictureAddress;
    }

    public void setSmallPictureAddress(String smallPictureAddress) {
        this.smallPictureAddress = smallPictureAddress;
    }

    public String getBigPictureAddress() {
        return bigPictureAddress;
    }

    public void setBigPictureAddress(String bigPictureAddress) {
        this.bigPictureAddress = bigPictureAddress;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getAudioAddress() {
        return audioAddress;
    }

    public void setAudioAddress(String audioAddress) {
        this.audioAddress = audioAddress;
    }

    @Override
    public String toString() {
        return "DishBean{" +
                "smallPictureAddress='" + smallPictureAddress + '\'' +
                ", bigPictureAddress='" + bigPictureAddress + '\'' +
                ", videoAddress='" + videoAddress + '\'' +
                ", audioAddress='" + audioAddress + '\'' +
                '}';
    }
}
