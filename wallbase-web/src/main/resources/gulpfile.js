//导入工具包 require('node_modules里对应模块')
var gulp = require('gulp');//本地安装gulp所用到的地方
var pkg = require('./package.json')

var browserSync = require('browser-sync').create();
var less = require('gulp-less');
var minifycss = require('gulp-minify-css');   //css压缩
var copy = require('gulp-copy');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var clean = require('gulp-clean');

//定义一个lessTask任务（自定义任务名称）
gulp.task('lessTask', function () {
    gulp.src('static/less/app.less') //该任务针对的文件
        .pipe(less()) //该任务调用的模块
        .pipe(gulp.dest('assets/css'))
        .pipe(browsersync.stream()); //将会在src/css下生成app.css
});

gulp.task('serve', function () {
    browserSync.init({
        port: 8080,
        server: {
            baseDir: ['./']
        }
    });
    gulp.watch('static/**/*.less', ['lessTask']);

    gulp.watch("./static/css/*.css").on('change', browserSync.reload);
    gulp.watch("./*.html").on('change', browserSync.reload);
    gulp.watch("./static/js/*.js").on('change', browserSync.reload);
});

//css 合并压缩处理
gulp.task('minifycss', function () {
    gulp.src([
        './static/css/app.css',
        "./static/css/animate.css",
        "./static/css/font-awesome.min.css",
        "./static/css/simple-line-icons.css",
        "./static/css/font.css",
        "./static/plugins/vegas/vegas.css",
        "./static/plugins/colorbox/colorbox.css",
        "./static/plugins/justifiedGallery/css/justifiedGallery.css",
    ]).pipe(concat('app.min.css'))      //合并css文件到"order_query"
        .pipe(minifycss())                //压缩文件
        .pipe(gulp.dest('./static/build-' + pkg.version + '/css'));//输出文件目录
});

//js 合并压缩处理
gulp.task("uglify", function () {
    gulp.src(
        [
            './static/js/app.js',
            './static/js/app.plugin.js',
            './static/plugins/vegas/vegas.js',
            './static/plugins/lazyload/jquery.lazyload.min.js',
            './static/plugins/colorbox/jquery.colorbox-min.js',
            './static/plugins/slimscroll/jquery.slimscroll.min.js',
            './static/plugins/justifiedGallery/js/jquery.justifiedGallery.js',
            './static/plugins/infinite-scroll/jquery.infinitescroll.js',
        ]).pipe(concat('app.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('./static/build-' + pkg.version + '/js'));
});

//复制静态资源
gulp.task("copy", function () {
    gulp.src('./static/fonts/**/*').pipe(gulp.dest('./static/build-' + pkg.version + '/fonts'));
    gulp.src('./static/images/**/*').pipe(gulp.dest('./static/build-' + pkg.version + '/images'));
    gulp.src('./static/plugins/colorbox/images/**/*').pipe(gulp.dest('./static/build-' + pkg.version + '/css/images'));
});


//删除编译后的目录
gulp.task('clean', function () {
    gulp.src('./static/build-' + pkg.version)
        .pipe(clean());
});

gulp.task('build', function () {
    gulp.start('clean', 'minifycss', 'uglify', 'copy');
});

gulp.task('default', ['serve']); //定义默认任务

//gulp.task(name[, deps], fn) 定义任务  name：任务名称 deps：依赖任务名称 fn：回调函数
//gulp.src(globs[, options]) 执行任务处理的文件  globs：处理的文件路径(字符串或者字符串数组) 
//gulp.dest(path[, options]) 处理完后文件生成路径
