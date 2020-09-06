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
	public void onClick(View view) {
		if (!FastClickUtil.isFastClick(mActivitySimpleName)) {
			onExecuteClick(view);
		}
	}

	protected abstract void onExecuteClick(View view);
}
