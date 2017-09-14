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
        <section id="waterfall" class="container scrollable padder-lg m-t-xl">
            <h4 class="font-thin m-b m-t text-white">欢迎进入高清壁纸基地!</h4>
            <div class="row row-sm">
            <#list content as wallpaper>
                    <div class="col-xs-6 col-sm-4 col-md-3">
                        <div class="item">
                            <div class="pos-rlt">
                                <div class="item-overlay opacity r r-2x">
                                    <div class="center text-center m-t-n">
                                        <a href="/wallpaper/${wallpaper.id}"><i class="icon-control-play i-2x"></i></a>
                                    </div>
                                </div>
                                <a href="/wallpaper/${wallpaper.id}">
                                    <img src="/images/images300x200.jpg" data-original="//imgs1.lockbur.com/${wallpaper.thumbUrl}" data-provider="lazyload" class="r img-full">
                                </a>
                            </div>
                            <div class="wrapper-sm" ></div>
                        </div>
                    </div>
            </#list>
            </div>
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
<script src="/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- App -->
<script src="/js/app.plugin.js"></script>
<script src="/js/app.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //图片延时加载  //当图片没加载完显示加载图标和默认图片
        $("img[data-provider=lazyload]").lazyload({
            placeholder: "/images/images300x200.jpg",
            container: $("#waterfall")
        });

    });
</script>
</html>
