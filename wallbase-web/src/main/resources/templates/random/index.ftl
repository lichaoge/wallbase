<!DOCTYPE html>
<html class="app">
<head>
    <meta charset="utf-8"/>
    <title>随机显示 - 更多壁纸，更多分享</title>
<#include "../includes/head.ftl"/>
</head>
<body>
<#include "../includes/header.ftl"/>
<section class="vbox">
    <section class="w-f-md">
        <section id="waterfall" class="scrollable">
        <#list list as wallpaper>
            <div class="item">
                <a href="//img2.lockbur.com/${wallpaper.thumbUrl}">
                    <img src="http://img2.lockbur.com/wallbase-10013958.jpg?x-oss-process=style/thumb"/>
                </a>
            </div>
        </#list>
        </section>
        <div class="scroller-status">
            <div class="text-center">
                <img src="/images/loading.gif">
            </div>
        </div>
    </section>
    <footer class="footer bg-black dker">
    <#include "../includes/footer.ftl"/>
    </footer>
</section>
</body>
<script src="/plugins/infinite-scroll/infinite-scroll.pkgd.js"></script>
<script>
    $(document).ready(function () {
        $("waterfall").infiniteScroll({
            path: '/random/next?page={{#}}',
            append: '.item',
            status: '.scroller-status',
            debug: true
        });
    });
</script>
</html>
