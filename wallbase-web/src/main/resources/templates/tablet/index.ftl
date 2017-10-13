<!DOCTYPE html>
<html class="app">
<head>
    <meta charset="utf-8"/>
    <title>王坤&刘念</title>
<#include "../includes/head.ftl"/>
</head>
<body>
<#include "../includes/header.ftl"/>
<section class="vbox">
    <section class="w-f-md">
        <section id="waterfall-home" class="scrollable">
        <#list pages.content as wallpaper>
            <div class="item">
                <a href="//img.wallbase.tv/${wallpaper.thumbUrl}">
                    <img src="//img.wallbase.tv/${wallpaper.thumbUrl}?x-oss-process=style/thumb"/>
                </a>
            </div>
        </#list>
        </section>
    </section>
    <footer class="footer bg-black dker">
    <#--<#include "../includes/footer.ftl"/>-->
    </footer>
</section>
</body>
<script>
    $(document).ready(function () {
        $("#waterfall-home").justifiedGallery({
            rowHeight: 180,
            lastRow: 'justify',
            rel: 'gallery', //replace with 'gallery1' the rel attribute of each link
            margins: 3,
            cssAnimation: true,
            waitThumbnailsLoad: false,
            randomize: true
        }).on('jg.complete', function () {
            $(this).find('.item>a').colorbox({
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
        }).on('jg.resize', function () {
            $('#waterfall-home').justifiedGallery('norewind');
        });
    });
</script>
</html>
