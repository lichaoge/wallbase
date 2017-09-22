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

        //chosen
        $(".chosen-select").length && $(".chosen-select").chosen();

        //添加到收藏夹
        $.fn.addFavorite = function () {
            var _self = this;
            var _photo_id = this.data("photos-id");
            //隐藏添加收藏 显示正在加载
            _self.hide().siblings("span").removeClass("hide");
            $.ajax({
                type: "post",
                url: "member/favorite/add",
                data: {photosId: _photo_id},
                dataType: "json",
                success: function (data) {
                    //成功后显示红星
                    _self.siblings("span").addClass("hide");
                    _self.siblings("a").removeClass("hide");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                }
            });
        };
        //END addFavorite

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
        });

    });//"use strict"; function
}(jQuery, window);