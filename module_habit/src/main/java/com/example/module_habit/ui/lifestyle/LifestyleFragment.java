package com.example.module_habit.ui.lifestyle;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lib_common.base.fragment.BaseFragment;
import com.example.lib_common.common.Constant;
import com.example.lib_common.db.entity.Alarm;
import com.example.lib_common.util.DateUtil;
import com.example.module_habit.BuildConfig;
import com.example.module_habit.R;
import com.example.module_habit.ui.prepare.PrepareActivity;
import com.example.module_habit.ui.sleep.SleepActivity;
import com.example.module_habit.view.AlarmCardView;

import java.util.List;

/**
 * author: tianhuaye
 * date:   2018/11/23 11:09
 * description:
 */
public class LifestyleFragment extends BaseFragment<LifestyleContract.View, LifestylePresenter<LifestyleContract.View>> implements LifestyleContract.View {

    private AlarmCardView mPrepareAv;
    private AlarmCardView mRemindAv;
    private FloatingActionButton mSleepFb;
    private Alarm mSleepAlarm;
    private List<Alarm> mPrepareList;
    private int[] images = {R.drawable.habit_prepare_tip_1, R.drawable.habit_prepare_tip_2, R.drawable.habit_prepare_tip_3, R.drawable.habit_prepare_tip_4, R.drawable.habit_prepare_tip_5};
    private String[] titles;

    @Override
    protected LifestylePresenter<LifestyleContract.View> createPresenter() {
        return new LifestylePresenter<>();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.RequestAndResultCode.FRAGMENT_PREPARE_REQUEST) {
            switch (resultCode) {
                case Constant.RequestAndResultCode.ACTIVITY_PREAPRE_RESULT_OK:
                    mPresenter.getPrepareAlarm();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_lifestyle, container, false);
        mPrepareAv = view.findViewById(R.id.av_sleep_prepare);
        mRemindAv = view.findViewById(R.id.av_sleep_remind);
        mSleepFb = view.findViewById(R.id.fb_sleep);

        return view;
    }

    @Override
    public void initListener() {
        mPrepareAv.addEditClickListener(new AlarmCardView.OnEditClickListener() {
            @Override
            public void onEditClick() {
                Intent intent = new Intent(getContext(), PrepareActivity.class);
                startActivityForResult(intent, Constant.RequestAndResultCode.FRAGMENT_PREPARE_REQUEST);
            }
        });

        mSleepFb.setOnClickListener(this);

        mRemindAv.setSwitchButtonClickListener(new AlarmCardView.OnToggleChangeListener() {
            @Override
            public void toggleChange(boolean open) {
                if (mSleepAlarm != null) {
                    if (mSleepAlarm.getOpen() != open) {
                        mSleepAlarm.setOpen(open);
                        mPresenter.updateSleepAlarm(mSleepAlarm);
                    }
                }
            }
        });
    }

    @Override
    public void initData() {
        titles = getResources().getStringArray(R.array.titles);
        mPresenter.getPrepareAlarm();
        mPresenter.getSleepAlarm();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fb_sleep) {
            startActivity(new Intent(getContext(), SleepActivity.class));
        }
    }

    @Override
    public void setSleepAlarm(Alarm alarm) {
        this.mSleepAlarm = alarm;
        if (mRemindAv != null && alarm != null) {
            mRemindAv.setLeftBottomText(DateUtil.timeToStr(alarm.getHour() == null ? 0 : alarm.getHour(), alarm.getMinute() == null ? 0 : alarm.getMinute()));
            mRemindAv.setSwitchButtonOpen(alarm.getOpen());
        }
    }

    @Override
    public void setPrepareAlarm(List<Alarm> alarmList) {

        boolean open = true;
        this.mPrepareList = alarmList;

        if (alarmList != null) {
            int[] src = new int[alarmList.size()];
            for (int i = 0; i < alarmList.size(); i++) {
                if (alarmList.get(i) != null) {
                    open = open && alarmList.get(i).getOpen();
                    for (int j = 0; j < titles.length; j++) {
                        if (alarmList.get(i).getMsg().equals(titles[j])) {
                            src[i] = images[j];
                            if (BuildConfig.DEBUG){
                                Log.d("LifestyleFragment", "PrepareAlarm: "+alarmList.get(i).toString());
                            }
                            break;
                        }
                    }
                }
            }
            mPrepareAv.setLeftBottomImages(src);
        }
        mPrepareAv.setSwitchButtonOpen(open);
    }
}
