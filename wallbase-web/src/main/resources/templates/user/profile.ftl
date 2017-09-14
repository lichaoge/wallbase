<!DOCTYPE html>
<html class="app">
<head>
    <meta charset="utf-8"/>
    <title>Lockbur - 更多壁纸，更多分享</title>
<#include "../includes/head.ftl"/>
</head>
<body>
<#include "../includes/header.ftl"/>
<div class="container" style="margin-top: 105px;">
    <section class="hbox stretch">
    <#include "sidebar.ftl"/>
        <section id="content">
            <section class="wrapper">
                <section>
                    <ul class="breadcrumb">
                        <li><a href="#"><i class="fa fa-home"></i> Home</a></li>
                        <li><a href="#"><i class="fa fa-list-ul"></i> Elements</a></li>
                        <li class="active">Components</li>
                    </ul>
                </section>
                <section class="panel panel-default">
                    <header class="panel-heading">
                        GDP per capita average annual growth rate
                    </header>
                    <div class="panel-body">
                        <p class="text-muted">Need support? please fill the fields below.</p>
                        <div class="form-group pull-in clearfix">
                            <div class="col-sm-6">
                                <label>Your name</label>
                                <input type="text" class="form-control parsley-validated" placeholder="Name" data-required="true">
                            </div>
                            <div class="col-sm-6">
                                <label>Email</label>
                                <input type="email" class="form-control parsley-validated" placeholder="Enter email" data-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Your website</label>
                            <input type="text" data-type="url" data-required="true" class="form-control parsley-validated" placeholder="Your website url">
                        </div>
                        <div class="form-group">
                            <label>Message</label>
                            <textarea class="form-control parsley-validated" rows="6" data-minwords="6" data-required="true" placeholder="Type your message"></textarea>
                        </div>
                    </div>
                </section>
            </section>
            <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
        </section>
    </section>
</div>
<#include "../includes/footer.ftl"/>
</body>
<script src="/plugins/jquery/jquery-2.2.4.min.js"></script>
<script src="/plugins/bootstrap/bootstrap.js"></script>
<script src="/plugins/vegas/vegas.js"></script>
<script src="/plugins/lazyload/jquery.lazyload.min.js"></script>
<script src="/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- App -->
<script src="/js/app.plugin.js"></script>
<#--<script src="/js/app.js"></script>-->
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
