package com.lyshixd.fastclick;

import android.view.View;

public abstract class GeneralClickListener implements View.OnClickListener {

	private String mActivitySimpleName;

	public GeneralClickListener() {

	}

	public GeneralClickListener(String mActivitySimpleName) {
		this.mActivitySimpleName = mActivitySimpleName;
	}

	@Override
	public void onClick(View v) {
		if (!FastClickUtil.isFastClick(mActivitySimpleName)) {
			onClick();
		}
	}

	protected abstract void onClick();
}
