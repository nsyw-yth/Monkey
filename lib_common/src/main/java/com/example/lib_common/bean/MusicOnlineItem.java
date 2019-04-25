package com.example.lib_common.bean;

import com.example.lib_common.bean.response.MusicBean;
import com.example.lib_common.common.Constant;
import com.example.lib_common.music.MusicSource;

/**
 * @author : 叶天华
 * @project: Monkey
 * @date : 2019/4/22
 * @time : 11:19
 * @email : 15869107730@163.com
 * @note :
 */
public class MusicOnlineItem extends BaseItem {

    public MusicOnlineItem(MusicBean musicBean) {
        if (musicBean != null) {
            if (musicBean.getType() != null && musicBean.getType() == Constant.ServerItemType.MUSIC_BEFORE) {
                itemType = Constant.ItemType.MUSIC_ONLINE;
                musicId = musicBean.getId() == null ? -1 : musicBean.getId();
                name = musicBean.getName() == null ? "" : musicBean.getName();
                author = musicBean.getAuthor() == null ? "" : musicBean.getAuthor();
                cover = musicBean.getCover() == null ? "" : musicBean.getCover();
                duration = musicBean.getDuring() == null ? "00:00" : musicBean.getDuring();
                if (musicBean.getFree() == null) {
                    isNeedPay = false;
                } else {
                    if (musicBean.getFree() == 0) {
                        isNeedPay = false;
                    } else if (musicBean.getFree() == 1) {
                        isNeedPay = true;
                    }
                }
                price = musicBean.getPrice() == null ? "0" : musicBean.getPrice().stripTrailingZeros().toPlainString();
                url = musicBean.getResource() == null ? "" : Constant.BASE_URL + musicBean.getResource();
                playTimes = musicBean.getPlayTimes() == null ? 0 : musicBean.getPlayTimes();
                status = musicBean.getStatus() == null ? 0 : musicBean.getStatus();
            }
        }
    }

    private int progress;

    /**
     * 播放次数
     */
    private long playTimes;
    /**
     * 音频时长
     */
    private String duration;
    /**
     * 播放音频的id
     */
    private long musicId;
    /**
     * 音频名字
     */
    private String name;
    /**
     * 作者
     */
    private String author;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 播放音频的url
     */
    private String url;
    /**
     * 边下载边播放下载的路径
     */
    private String cachedFile;
    /**
     * 本地下载文件路径
     */
    private String localFile;
    /**
     * music来源
     */
    private MusicSource source = MusicSource.NetWork;
    /**
     * 是否正在播放
     */
    private boolean isPlaying;

    /**
     * 是否边下载边播放
     */
    private boolean downloadWhenPlaying = true;

    /**
     * 是否需要付款播放
     */
    private boolean isNeedPay = false;

    /**
     * 是否已经付款
     */
    private boolean isHasPay = false;

    /**
     * 价格
     */
    private String price;

    /**
     * 歌曲状态 0展示 1不展示
     */
    private int status = 0;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(long playTimes) {
        this.playTimes = playTimes;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getMusicId() {
        return musicId;
    }

    public void setMusicId(long musicId) {
        this.musicId = musicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCachedFile() {
        return cachedFile;
    }

    public void setCachedFile(String cachedFile) {
        this.cachedFile = cachedFile;
    }

    public String getLocalFile() {
        return localFile;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public MusicSource getSource() {
        return source;
    }

    public void setSource(MusicSource source) {
        this.source = source;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isDownloadWhenPlaying() {
        return downloadWhenPlaying;
    }

    public void setDownloadWhenPlaying(boolean downloadWhenPlaying) {
        this.downloadWhenPlaying = downloadWhenPlaying;
    }

    public boolean isNeedPay() {
        return isNeedPay;
    }

    public void setNeedPay(boolean needPay) {
        isNeedPay = needPay;
    }

    public boolean isHasPay() {
        return isHasPay;
    }

    public void setHasPay(boolean hasPay) {
        isHasPay = hasPay;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}