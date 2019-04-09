package com.zust.module_music.contract.before;

import com.example.lib_common.base.BaseView;
import com.example.lib_common.base.bean.MusicItem;

import java.util.List;

/**
 * @author : 叶天华
 * @project: Monkey
 * @date : 2018/12/24
 * @time : 11:23
 * @email : 15869107730@163.com
 * @note :
 */
public interface MusicBeforeContract {

    interface View extends BaseView {

        void setDBData(List<MusicItem> musicItemList);
        void updateMusic(List<MusicItem> musicItemList, int position);

        void addMoreData(List<MusicItem> musicItemList);

        void refreshData(List<MusicItem> musicItemList);

        void updateCurrentPage(int page);

        void noMoreData();

    }

    interface Presenter {
        /**
         * 从数据库获取数据
         *
         * @param currentPage
         */
        void getDataFromDB(int currentPage);

        /**
         * 获取网络数据
         *
         * @param currentPage
         */
        void getSleepBeforeMusicList(int currentPage);

        /**
         * 刷新数据
         */
        void refreshSleepBeforeMusicList();

        /**
         * 更新音乐本地缓存路径
         * @param localFile
         * @param id
         */
        void updateMusicDb(String localFile,MusicItem musicItem);
    }
}
