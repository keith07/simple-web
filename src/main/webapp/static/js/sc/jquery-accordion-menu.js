(function($, window, document, undefined) {
	$.widget("keith.foldingMenu", {
		_create : function(){
			console.log("_create");
		},
		_init: function() {
			console.log("_init");
			console.log(this.element.attr("id"));
			this.element.addClass("foldingMenu")
			this.__addSubmenuIndicators();
			this.__initEvent();
//			this.openMenu();
//			this.openSubmenu();
		},
		_destory: function(){
			console.log("_destory");
		},
		__initEvent(){
			$("a.hasSub",this.element).on("click",function(){
				$subUl = $(this).next("ul");
				if($(this).hasClass("opened")){
					$(this).removeClass("opened");
					$subUl.hide();
				}else{
					$(this).addClass("opened");
					$subUl.show();
				}
			})
		},
		__addSubmenuIndicators : function(){
			$hasSub = this.element.find("ul.submenu").siblings("a");
			$hasSub.addClass("hasSub");
			$hasSub.append('<span class="submenu-indicator">+</span>');
		}
	});
})(jQuery, window, document);