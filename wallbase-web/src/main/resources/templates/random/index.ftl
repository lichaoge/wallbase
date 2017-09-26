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
                    <img src="//img2.lockbur.com/${wallpaper.thumbUrl}?x-oss-process=style/thumb"/>
                </a>
            </div>
        </#list>
        </section>
        <div>
            <div class="loading text-center"></div>
            <div id="navigation">
                <a href="/random/next?page=1"></a>
            </div>
        </div>
    </section>
    <footer class="footer bg-black dker">
    <#include "../includes/footer.ftl"/>
    </footer>
</section>
</body>
<script src="/plugins/infinite-scroll/jquery.infinitescroll.js"></script>
<script>
    $(document).ready(function () {
        $('#waterfall').infinitescroll({
            navSelector: "#navigation", //导航的选择器，会被隐藏
            nextSelector: "#navigation a", //包含下一页链接的选择器
            itemSelector: ".item", //你将要取回的选项(内容块)
            debug: true, //启用调试信息
            animate: true, //当有新数据加载进来的时候，页面是否有动画效果，默认没有
            extraScrollPx: 150, //滚动条距离底部多少像素的时候开始加载，默认150
            bufferPx: 40, //载入信息的显示时间，时间越大，载入信息显示时间越短
        <#--maxPage: ${pages.totalPages},//公有多少页-->
            errorCallback: function () {
                alert('error');
            }, //当出错的时候，比如404页面的时候执行的函数
            localMode: true, //是否允许载入具有相同函数的页面，默认为false
            dataType: 'html'//可以是json
//            loading: {
//                msgText: "",
//                finishedMsg: '没有新数据了...',
//                img: "/images/loading.gif",
//                selector: '.loading'
//            }
        }, function (newElems) {
            //程序执行完的回调函数
            var $newElements = $(newElems);
            $('#waterfall').append($newElements);
            $('#waterfall').justifiedGallery('norewind');
        });
    });
</script>
</html>
