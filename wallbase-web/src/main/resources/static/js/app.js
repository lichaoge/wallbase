+function ($) {
    $(function () {
        //添加到收藏夹
        $(document).on("click", ".addFavorite", function () {
            $(this).addFavorite();
            return false;//阻止链接跳转
        });
        //背景图片
        $('body').vegas({
            timer: false,
            slides: [
                {src: CC.assets_url + 'assets/images/background1.jpg'}
            ]
        });
        $("img").error(function () {
            $(this).attr("src", CC.assets_url + 'assets/images/image20.jpg');
        });

        // class
        $(document).on('click', '[data-toggle^="class"]', function(e){
            e && e.preventDefault();
            var $this = $(e.target), $class , $target, $tmp, $classes, $targets;
            !$this.data('toggle') && ($this = $this.closest('[data-toggle^="class"]'));
            $class = $this.data()['toggle'];
            $target = $this.data('target') || $this.attr('href');
            $class && ($tmp = $class.split(':')[1]) && ($classes = $tmp.split(','));
            $target && ($targets = $target.split(','));
            $classes && $classes.length && $.each($targets, function( index, value ) {
                if ( $classes[index].indexOf( '*' ) !== -1 ) {
                    var patt = new RegExp( '\\s' +
                        $classes[index].
                        replace( /\*/g, '[A-Za-z0-9-_]+' ).
                        split( ' ' ).
                        join( '\\s|\\s' ) +
                        '\\s', 'g' );
                    $($this).each( function ( i, it ) {
                        var cn = ' ' + it.className + ' ';
                        while ( patt.test( cn ) ) {
                            cn = cn.replace( patt, ' ' );
                        }
                        it.className = $.trim( cn );
                    });
                }
                ($targets[index] !='#') && $($targets[index]).toggleClass($classes[index]) || $this.toggleClass($classes[index]);
            });
            $this.toggleClass('active');
        });

    });
}(window.jQuery);