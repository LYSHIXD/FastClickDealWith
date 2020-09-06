# FastClickDealWith
处理快速多次点击的情况，防止功能多次执行或界面多次显示

## [![JitPack](https://jitpack.io/v/LYSHIXD/DellWithFastClick.svg)](https://jitpack.io/#LYSHIXD/DellWithFastClick)

## 如何使用 


#### 注意：普通点击处理间隔为500ms,Activity跳转处理间隔为800ms,足以应付绝大多数情况

### 1.gradle中添加依赖
   
在项目的root build.gradle中添加如下配置：
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
	
```
添加依赖

```
implementation 'com.github.LYSHIXD:DellWithFastClick:1.0.0'

```

### 1.设置view的点击事件，传入

```
textView.setOnClickListener(new GeneralClickListener() {
			@Override
			protected void onExecuteClick(View view) {
				// 此处已屏蔽快速多次点击
			}
		});
```

#### 当点击事件中有跳转其他Activity的逻辑时，传入对应的simpleName

```
textView.setOnClickListener(new GeneralClickListener(MainActivity.class.getSimpleName()) {
			@Override
			protected void onExecuteClick(View view) {
				// 此处已屏蔽快速多次点击
			}
		});
```

### 2.在代码中直接判断
```
// 不需要处理跳转Activity的情况
if (!FastClickUtil.isFastClick()) {

}

// 需要处理跳转Activity的情况，传入对应的simpleName
if (!FastClickUtil.isFastClick(MainActivity.class.getSimpleName())) {

}
```
