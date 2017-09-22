+function ($) {
    $(function () {
        //添加到收藏夹
        $(document).on("click", ".addFavorite", function () {
            $(this).addFavorite();
            return false;//阻止链接跳转
        });



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