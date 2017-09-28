<!DOCTYPE html>
<html class="app">
<head>
    <meta charset="utf-8"/>
    <title>排行榜 - 更多壁纸，更多分享</title>
<#include "../includes/head.ftl"/>
</head>
<body>
<#include "../includes/header.ftl"/>
<section class="vbox">
    <section class="w-f-md">
        <section id="waterfall" class="scrollable">
        <#list pages.content as wallpaper>
            <div class="item">
                <a href="//img2.lockbur.com/${wallpaper.thumbUrl}">
                    <img src="//img2.lockbur.com/${wallpaper.thumbUrl}?x-oss-process=style/thumb"/>
                    <div class="caption">
                        <div class="m-b"><a href="/wallpaper/${wallpaper.id?c}" class="b-b b-info h4 text-u-c text-lt">沁园春.雪</a></div>
                        <samll class="hidden-xs text-md font-bold">北国风光千里冰封万里雪飘</samll>
                    </div>
                </a>
            </div>
        </#list>
        </section>
        <div>
            <div class="loading text-center"></div>
            <div id="navigation">
                <a href="/top/next?page=1"></a>
            </div>
        </div>
    </section>
    <footer class="footer bg-black dker">
    <#include "../includes/footer.ftl"/>
    </footer>
</section>
</body>
</html>
