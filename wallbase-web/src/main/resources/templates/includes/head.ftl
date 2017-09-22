<#import "/spring.ftl" as s />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
<meta name="description" content="Lockbur旨在为设计人员提供更高质量壁纸或者桌面壁纸,同时也提供原画设计作品分享!"/>
<meta name="keywords"
      content="高清壁纸,壁纸,高清背景,背景,原画,桌面壁纸,最靠谱的图片分享网站,lockbur,lockbur.com,www.lockbur.com,wallbase,wallhaven,best wallpapers,best wallpaper site,iphone wallpaper,android wallpaper,mobile wallpaper,free wallpaper hd,backgrounds,desktop wallpaper,widescreen"/>
<#if appBean.developMode>
    <link rel="stylesheet" href="<@s.url '/css/bootstrap.min.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/plugins/vegas/vegas.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/plugins/justifiedGallery/css/justifiedGallery.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/plugins/colorbox/colorbox.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/css/animate.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/css/font-awesome.min.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/css/simple-line-icons.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/css/font.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<@s.url '/css/app.css'/>" type="text/css"/>
<#else>
<!--生产模式 使用css和常用js直接走nginx-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${appBean.assetsUrl}/plugins/vegas/vegas.css" type="text/css"/>
    <link rel="stylesheet" href="${appBean.assetsUrl}/css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="${appBean.assetsUrl}/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="${appBean.assetsUrl}/css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="${appBean.assetsUrl}/css/font.css" type="text/css"/>

    <link rel="stylesheet" href="<@s.url '/'/>build-${appBean.gruntVersion}/css/app.min.css" type="text/css"/>
</#if>

<!--[if lt IE 9]>
<script src="${appBean.assetsUrl}/plugins/ie/html5shiv.js"></script>
<script src="${appBean.assetsUrl}/plugins/ie/respond.min.js"></script>
<script src="${appBean.assetsUrl}/plugins/ie/excanvas.js"></script>
<![endif]-->
<link rel="icon" type="image/x-icon" href="/favicon.ico">
<link rel="shortcut icon" href="/favicon.ico"/>
<script>
    var CC = {};
    CC.assets_url = "${appBean.assetsUrl}/";
</script>
