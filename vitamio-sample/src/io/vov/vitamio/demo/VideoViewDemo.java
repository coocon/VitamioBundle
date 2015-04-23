/*
 * Copyright (C) 2013 yixia.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.vov.vitamio.demo;



import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


import com.sophnep.sdk.DNS;
import android.os.Handler;  
public class VideoViewDemo extends Activity {

	/**
	 * TODO: Set the path variable to a streaming video URL or a local media file
	 * path.
	 */
	private String path = "http://aliv.weipai.cn/201503/28/16/42481BC8-46B1-46E8-A7C8-5B263AF0DF53.m3u8";
	private String path2 = path;

	private VideoView mVideoView;

	private String finalUrl = null;
	private static final int AZIMUTHCHANGE = 0xff04;
	
	private Handler m_handler = new Handler()
	{
		public void handleMessage(android.os.Message msg) {
			String url = (String) msg.obj;
			mVideoView.setVideoPath(url);
			
		};
	};
	
	@Override
	public void onCreate(Bundle icicle) {
		
	    
		super.onCreate(icicle);
		if (!LibsChecker.checkVitamioLibs(this))
			return;
		setContentView(R.layout.videoview);
		mVideoView = (VideoView) findViewById(R.id.surface_view);
		 //创建属于主线程的handler  
		if (path == "") {
			// Tell the user to provide a media file URL/path.
			Toast.makeText(VideoViewDemo.this, "Please edit VideoViewDemo Activity, and set path" + " variable to your media file URL/path", Toast.LENGTH_LONG).show();
			return;
		} else {
			/*
			 * Alternatively,for streaming media you can use
			 * mVideoView.setVideoURI(Uri.parse(URLstring));
			 */
			mVideoView.setVideoPath(path);
			mVideoView.setMediaController(new MediaController(this));
			mVideoView.requestFocus();

			mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mediaPlayer) {
					// optional need Vitamio 4.0
					mediaPlayer.setPlaybackSpeed(1.0f);
				}
			});
		}

	}
	
	
	
	public void openVideo(View View) {
	    
	    mVideoView.setVideoPath(path);
	};
	
	
   
	/**
	 * 采用sdk提供的方法 替换url
	 * @param view
	 */
	public void openVideo2(View view) {
		//如果设置了安卓的UI异步策略，可以直接获取URL
		//String[] url = DNS.getCDNUrls(path2);
	    //mVideoView.setVideoPath(url[0]);
		
		//如果采用异步的 网络请求，所以新线程处理
		new Thread(new Runnable(){	
			
			 public void run() {
				 
				String[] url = DNS.getCDNUrls(path2);
				Message msg = new Message();
		        msg.obj = url[0];

		        m_handler.sendMessage(msg); 				
               				 
			 }
		}).start();	
	  
	}
}
