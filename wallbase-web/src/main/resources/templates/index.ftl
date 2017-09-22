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
</html>
