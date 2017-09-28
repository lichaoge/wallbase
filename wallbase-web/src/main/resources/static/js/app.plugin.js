+function ($, window) {
    "use strict";
    $(function () {
        var $window = $(window);
        // slim-scroll
        $('.no-touch .slim-scroll').each(function () {
            var $self = $(this), $data = $self.data(), $slimResize;
            $self.slimScroll($data);
            $(window).resize(function (e) {
                clearTimeout($slimResize);
                $slimResize = setTimeout(function () {
                    $self.slimScroll($data);
                }, 500);
            });
            $(document).on('updateNav', function () {
                $self.slimScroll($data);
            });
        });

        $("img").error(function () {
            $(this).attr("src", CC.assets_url + 'assets/images/image20.jpg');
        });
        //chosen
        $(".chosen-select").length && $(".chosen-select").chosen();


        //背景图片
        $('body').vegas({
            timer: false,
            slides: [
                {src: '/images/background1.jpg'}
            ]
        });

        //图片延时加载  //当图片没加载完显示加载图标和默认图片
        $("img[data-provider=lazyload]").lazyload({
            placeholder: "/images/images300x200.jpg",
            container: $("#waterfall")
        });

        //图片自动调节插件
        $("#waterfall").justifiedGallery({
            rowHeight: 200,
            lastRow: 'justify',
            rel: 'gallery', //replace with 'gallery1' the rel attribute of each link
            margins: 3,
            waitThumbnailsLoad: false,
            randomize: true
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
        }).on('jg.resize', function () {
            $('#waterfall').justifiedGallery('norewind');
        });

        //无限滚动后加载页面
        $('#waterfall').infinitescroll({
            navSelector: "#navigation", //导航的选择器，会被隐藏
            nextSelector: "#navigation a", //包含下一页链接的选择器
            itemSelector: ".item", //你将要取回的选项(内容块)
            debug: true, //启用调试信息
            animate: true, //当有新数据加载进来的时候，页面是否有动画效果，默认没有
            extraScrollPx: 150, //滚动条距离底部多少像素的时候开始加载，默认150
            bufferPx: 40, //载入信息的显示时间，时间越大，载入信息显示时间越短
            // maxPage: 10,//公有多少页-->
            errorCallback: function () {
                alert('error');
            }, //当出错的时候，比如404页面的时候执行的函数
            localMode: false, //是否允许载入具有相同函数的页面，默认为false
            dataType: 'html',//可以是json
            loading: {
                msgText: "",
                finishedMsg: '没有新数据了...',
                img: "/images/loading.gif",
                selector: '.loading'
            }
        }, function (newElems) {
            //程序执行完的回调函数
            var $newElements = $(newElems);
            console.log($newElements);
            $('#waterfall').append($newElements);
            $('#waterfall').justifiedGallery('norewind');
        });

    });//"use strict"; function
}(jQuery, window);