Vitamio
===============
通过51cache的SDK， 调用静态方法，来获取新的资源URL，新的URL通过IP访问CDN上的资源，从而因为运营商劫持造成的“慢、卡、不能播放”的问题。

1、修改了 demo里边的 VideoView 示例，添加了两个按钮：“Open Video1”和“Open Video2”
2、点击“Open Video1”，用直接给播放器set 原URL
3、点击“Open Video2”，用SDK提供的方法处理原URL， 产生新的URL，set 给播放器。




Vitamio is an open multimedia framework for Android and iOS, with full and real hardware accelerated decoder and renderer.


New features
------------

Only few important features are listed here, we have fix many bugs and may introduce some new bugs.

1. The latest FFmpeg 2.0 git version, which should fix most playback issues, or bring some issues.
2. Support most FFmpeg AVOptions, which enables custom HTTP headers support.
3. Support more hardwares, e.g. X86 or MIPS.
4. Improve streaming, especially support adaptive bitrate streaming, you need open manually.
5. OpenSSL included, so some SSL related protocols, such as https, tls, rtmps, rtmpts, are supported.
6. Playback speed control from 0.5x to 2.0x.
7. Audio amplify to 2x volume.
8. Improved subtitle support, including external bitmap subtitles.
9. Cache online video to local storage and can be reused until you delete the cache file.
10. More MediaPlayer API, e.g. `getMetadata`, `getVideoTrack`.
11. The full Java code is open to all developers, modify and contribute is welcome.
12. Support RGBA\_8888 rendering, spport switching RGB\_565 or RGBA\_8888 to video rendering.
13. Enhance the hardware decoding in Android 16+.
14. Support ARMV6 CPU, may have some bugs.

How to use
----------

please see [the website](https://github.com/yixia/VitamioBundle/wiki)

License
-------

Please see [License](http://www.vitamio.org/en/License)


## Google+
Vitamio Developers Community on Google+ [http://goo.gl/fhCDTD](http://goo.gl/fhCDTD)
