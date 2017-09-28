<!DOCTYPE html>
<html class="app">
<head>
    <meta charset="utf-8"/>
    <title>壁纸原图 - 更多壁纸，更多分享</title>
<#include "includes/head.ftl"/>
    <link rel="stylesheet" href="<@s.url '/plugins/guillotine/css/jquery.guillotine.css'/>" type="text/css"/>
</head>
<body>
<#include "includes/header.ftl"/>
<section class="vbox">
    <section class="w-f-md">
        <div class="container">
            <div class="row">
                <div class="thumbnail">
                    <img id="sample_picture"
                         src="//img2.lockbur.com/${wallpaper.thumbUrl}"
                         class="img-full center-block"/>
                </div>
                <div class="btn-group btn-group-justified">
                    <a id='rotate_right' class="btn btn-default">
                        <i class='fa fa-rotate-right fa-3x'></i>
                    </a>
                    <a id='zoom_out' class="btn btn-default">
                        <i class='fa fa-search-minus fa-3x'></i>
                    </a>
                    <a id='fit' class="btn btn-default">
                        <i class='fa fa-arrows-alt fa-3x'></i>
                    </a>
                    <a id='zoom_in' class="btn btn-default">
                        <i class='fa fa-search-plus fa-3x'></i>
                    </a>
                    <a id='rotate_left' class="btn btn-default">
                        <i class='fa fa-rotate-left fa-3x'></i>
                    </a>
                </div>
            </div>
            <div class="row">

            </div>
        </div>
    </section>
    <footer class="footer bg-black dker">
    <#include "includes/footer.ftl"/>
    </footer>
</section>
</body>
<script src="/plugins/guillotine/js/jquery.guillotine.js"></script>
<script>
    $(document).ready(function () {
        var picture;
        $('#sample_picture').click(function () {
            if(!picture){
                picture = $('#sample_picture').guillotine();
                picture.guillotine('fit');

                $('#rotate_left').click(function () {
                    picture.guillotine('rotateLeft');
                });

                $('#rotate_right').click(function () {
                    picture.guillotine('rotateRight');
                });

                $('#fit').click(function () {
                    picture.guillotine('fit');
                });

                $('#zoom_in').click(function () {
                    picture.guillotine('zoomIn');
                });

                $('#zoom_out').click(function () {
                    picture.guillotine('zoomOut');
                });
            }
        });
    });
</script>
</html>
