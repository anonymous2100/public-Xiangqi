package com.sojourners.chess;

import javafx.application.Application;

/**
 * 注意，不能直接启动App，会出现“错误: 缺少 JavaFX 运行时组件, 需要使用该组件来运行此应用程序”错误。
 */
public class Main
{
	public static void main(String[] args)
	{
		Application.launch(App.class);
	}
}
