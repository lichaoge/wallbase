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
            <a href="//img2.lockbur.com/${wallpaper.thumbUrl}">
                <img src="http://img2.lockbur.com/wallbase-10013958.jpg?x-oss-process=style/thumb"/>
            </a>
        </#list>
        </section>
    </section>
    <div class="scroller-status">
        <a class="pagination__next" href="page2.html">Next page</a>
    </div>
    <footer class="footer bg-black dker">
    <#include "../includes/footer.ftl"/>
    </footer>
</section>
</body>
<script>
    $(document).ready(function () {
        $("#waterfall").infiniteScroll({
            path: '.pagination__next',
            hideNav: '.pagination',
            append: '#waterfall'
            status: '.scroller-status',
            debug: true,
        });
    });
</script>
</html>
