<nav id="header" class="navbar navbar-inverse navbar-fixed-top">
    <div class="vbox">
        <#--<section class="w-f-md">-->
        <section>
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">导航隐藏</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">
                        <img src="/images/logo.png">
                        <strong class="text-white">LockBur</strong>
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <div>
                        <ul class="nav navbar-nav">
                            <li>
                                <a class="discover" href="/top" title="发现">
                                    <i class="icon icon-disc"></i>
                                    <span> 发现</span>
                                </a>
                            </li>
                            <li>
                                <a class="latest" href="/latest">
                                    <i class="fa fa-lg fa-clock-o"></i>
                                    <span> 最新</span>
                                </a>
                            </li>
                            <li>
                                <a class="random" href="/random">
                                    <i class="fa fa-lg fa-random"></i>
                                    <span> 随机</span>
                                </a>
                            </li>
                        <#--<li>-->
                        <#--<a class="upload" href="http://alpha.wallhaven.cc/upload">-->
                        <#--<i class="fa fa-lg fa-upload"></i>-->
                        <#--<span> 上传</span>-->
                        <#--</a>-->
                        <#--</li>-->
                            <li>
                                <a href="javascript:void(0);" class="upload" data-toggle="class:hide"
                                   data-target="#search">
                                    <i class="icon icon-equalizer"></i>
                                    <span> 更多</span>
                                </a>
                            </li>
                            <li>
                                <a href="/search" class="search">
                                    <i class="fa fa-lg fa-search"></i>
                                    <span> 搜索</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div><!--/.navbar-collapse -->
            </div>
        </section>
        <#--<footer class="header navbar text-center bg-black dker animated fadeInUp" id="search">-->
            <#--<form class="navbar-form hidden-xs" role="search">-->
                <#--<div class="btn-group" data-toggle="buttons">-->
                    <#--<label class="btn btn-dark">-->
                        <#--<input type="radio" name="options"><i class="fa fa-check text-active"></i> General-->
                    <#--</label>-->
                    <#--<label class="btn btn-dark">-->
                        <#--<input type="radio" name="options"><i class="fa fa-check text-active"></i> Anime-->
                    <#--</label>-->
                    <#--<label class="btn btn-dark active">-->
                        <#--<input type="radio" name="options"><i class="fa fa-check text-active"></i> People-->
                    <#--</label>-->
                <#--</div>-->
                <#--<div class="btn-group" data-toggle="buttons">-->
                    <#--<label class="btn btn-success">-->
                        <#--<input type="radio" name="options"><i class="fa fa-check text-active"></i> SFW-->
                    <#--</label>-->
                    <#--<label class="btn btn-warning">-->
                        <#--<input type="radio" name="options"><i class="fa fa-check text-active"></i> Sketchy-->
                    <#--</label>-->
                    <#--<label class="btn btn-danger active">-->
                        <#--<input type="radio" name="options"><i class="fa fa-check text-active"></i> NSFW-->
                    <#--</label>-->
                <#--</div>-->
                <#--<!-- Split button &ndash;&gt;-->
                <#--<div class="btn-group">-->
                    <#--<button type="button" class="btn btn-dark">Action</button>-->
                    <#--<button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown"-->
                            <#--aria-haspopup="true" aria-expanded="false">-->
                        <#--<span class="caret"></span>-->
                        <#--<span class="sr-only">Toggle Dropdown</span>-->
                    <#--</button>-->
                    <#--<ul class="dropdown-menu">-->
                        <#--<li>-->
                            <#--<span class="arrow top"></span>-->
                            <#--<a href="#">Action</a>-->
                        <#--</li>-->
                        <#--<li><a href="#">Another action</a></li>-->
                        <#--<li><a href="#">Something else here</a></li>-->
                        <#--<li role="separator" class="divider"></li>-->
                        <#--<li><a href="#">Separated link</a></li>-->
                    <#--</ul>-->
                <#--</div>-->
            <#--</form>-->
        <#--</footer>-->
    </div>
</nav>
