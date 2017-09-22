<!DOCTYPE html>
<html class="app">
<head>
    <meta charset="utf-8"/>
    <title>Lockbur - 更多壁纸，更多分享</title>
    <meta property="qc:admins" content="001022565332526375"/>
    <meta property="wb:webmaster" content="b4ce7bb18f09c6bc"/>
    <meta name="baidu-site-verification" content="bB5uKKGWVi"/>
    <meta name="msvalidate.01" content="1E5396A70FFDF1DD629CEAAD96CCEE15"/>
    <meta name="alexaVerifyID" content="wdV1JUI4A1-05aTdniAVHICFPMI"/>
<#include "includes/head.ftl"/>

    <!--百度统计-->
<#--<script>-->
<#--var _hmt = _hmt || [];-->
<#--(function () {-->
<#--var hm = document.createElement("script");-->
<#--hm.src = "//hm.baidu.com/hm.js?15dcd777f63423d27dbca739598638ed";-->
<#--var s = document.getElementsByTagName("script")[0];-->
<#--s.parentNode.insertBefore(hm, s);-->
<#--})();-->
<#--</script>-->
</head>
<body>
<#include "includes/header.ftl"/>
<section class="vbox">
    <section class="w-f-md">
        <section id="waterfall" class="scrollable">
        <#list content as wallpaper>
            <a href="//img2.lockbur.com/${wallpaper.thumbUrl}">
                <img data-provider="lazyload"
                     src="//img2.lockbur.com/${wallpaper.thumbUrl}?x-oss-process=style/thumb"
                     alt="${wallpaper.id}"/>
            </a>
        </#list>
        </section>
    </section>
    <footer class="footer bg-black dker">
    <#include "includes/footer.ftl"/>
    </footer>
</section>
</body>
<script src="/plugins/jquery/jquery-2.2.4.min.js"></script>
<script src="/plugins/bootstrap/bootstrap.js"></script>
<script src="/plugins/vegas/vegas.js"></script>
<script src="/plugins/lazyload/jquery.lazyload.min.js"></script>
<script src="/plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="/plugins/justifiedGallery/js/jquery.justifiedGallery.js"></script>

<script src="/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- App -->
<script src="/js/app.plugin.js"></script>
<#--<script src="/js/app.js"></script>-->
<script type="text/javascript">
    $(document).ready(function () {
        //图片延时加载  //当图片没加载完显示加载图标和默认图片
        $("img[data-provider=lazyload]").lazyload({
            placeholder: "/images/images300x200.jpg",
            container: $("#waterfall")
        });

        $("#waterfall").justifiedGallery({
            rowHeight: 200,
            lastRow: 'justify',
            rel: 'gallery', //replace with 'gallery1' the rel attribute of each link
            margins: 3
        }).on('jg.complete', function () {
            $(this).find('a').colorbox({
                rel: 'gallery',
                maxWidth: '80%',
                maxHeight: '80%',
                opacity: 0.8,
                transition: 'elastic',
                current: "当前图像 {current} 总共 {total}",
                previous: "前一页",
                next: "后一页",
                close: "关闭",
                xhrError: "此内容无法加载",
                imgError: "此图片无法加载",
                slideshowStart: "开始播放幻灯片",
                slideshowStop: "停止播放幻灯片"
            });
        });

    });
</script>
</html>
