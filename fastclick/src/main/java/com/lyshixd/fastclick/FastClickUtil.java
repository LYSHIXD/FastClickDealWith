package com.lyshixd.fastclick;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FastClickUtil {

	// 上次点击的时间标记
	private static long mLastClickTime;

	// 上次点击的Activity的className
	private static String mLastClickSimpleName;

	// 点击间隔约定1
	private static final long NORMAL_INTEVAL = 500L;

	// 点击间隔约定2
	private static final long ACTIVITY_INTEVAL = 800L;


	public static boolean isFastClick() {
		return isFastNormalClick();
	}

	public static boolean isFastClick(@Nullable String classSimpleName) {
		if (TextUtils.isEmpty(classSimpleName)) {
			return isFastClick();
		} else {
			return isFastAvtivityClick(classSimpleName);
		}
	}


	private static boolean isFastNormalClick() {
		long nowClickTime = System.currentTimeMillis();
		boolean isFast = (nowClickTime - mLastClickTime) <= NORMAL_INTEVAL;
		mLastClickTime = nowClickTime;
		return isFast;
	}

	/**
	 * fix连续点击弹出多个activity
	 * 1.设置android:launchMode="singleTop"在这个场景下并不管用
	 * 2.部分手机可能因为activity的阻塞耗时不同会导致计算的间隔超出500ms，这里定位800毫秒能处理绝大部分的手机和情况
	 * 3.通过记录activitySimpleName，避免出现用户熟练连续进入多个页面的时候需要等待
	 *
	 * @param classSimpleName Activity.class.getSimpleName()
	 * @return boolean
	 */
	private static boolean isFastAvtivityClick(@NonNull String classSimpleName) {
		long nowClickTime = System.currentTimeMillis();
		boolean isFast = (nowClickTime - mLastClickTime) <= ACTIVITY_INTEVAL;
		mLastClickTime = nowClickTime;
		if (!classSimpleName.equals(mLastClickSimpleName)) {
			isFast = false;
			mLastClickSimpleName = classSimpleName;
		}
		return isFast;
	}

}
