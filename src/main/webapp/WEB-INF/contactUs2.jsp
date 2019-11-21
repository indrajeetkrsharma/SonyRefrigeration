<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="desktop portrait" lang="en-us">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<style type="text/css">.gm-style .gm-style-mtc label,.gm-style .gm-style-mtc div{font-weight:400}</style>
<link href="css/css_003.css" rel="stylesheet" type="text/css">
<style type="text/css">.gm-style .gm-style-cc span,.gm-style .gm-style-cc a,.gm-style .gm-style-mtc div{font-size:10px}</style>
<style type="text/css">@media print {  .gm-style .gmnoprint, .gmnoprint {    display:none  }}@media screen {  .gm-style .gmnoscreen, .gmnoscreen {    display:none  }}</style>
<style type="text/css">.gm-style{font-family:Roboto,Arial,sans-serif;font-size:11px;font-weight:400;text-decoration:none}.gm-style img{max-width:none}</style>
<meta name="robots" content="index,follow">
<meta name="viewport" content="width=device-width, minimum-scale=0.25, maximum-scale=1.0, initial-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">	
<link rel="icon" type="image/vnd.microsoft.icon" href="#">
<link rel="shortcut icon" type="image/x-icon" href="#">
<link rel="stylesheet" href="css/global.css" media="all">
<link rel="stylesheet" href="css/highdpi.css" media="all">
<link rel="stylesheet" href="css/responsive-tables.css" media="all">
<link rel="stylesheet" href="css/uniform.css" media="all">
<link rel="stylesheet" href="css/jquery_003.css" media="all">
<link rel="stylesheet" href="css/product_list.css" media="all">
<link rel="stylesheet" href="css/blockcart.css" media="all">
<link rel="stylesheet" href="css/jquery.css" media="all">
<link rel="stylesheet" href="css/blockcategories.css" media="all">
<link rel="stylesheet" href="css/blockcurrencies.css" media="all">
<link rel="stylesheet" href="css/blocklanguages.css" media="all">
<link rel="stylesheet" href="css/blockcontact.css" media="all">
<link rel="stylesheet" href="css/blocknewsletter.css" media="all">
<link rel="stylesheet" href="css/blocktags.css" media="all">
<link rel="stylesheet" href="css/blockviewed.css" media="all">
<link rel="stylesheet" href="css/homeslider.css" media="all">
<link rel="stylesheet" href="css/hooks_002.css" media="all">
<link rel="stylesheet" href="css/blockwishlist.css" media="all">
<link rel="stylesheet" href="css/productcomments.css" media="all">
<link rel="stylesheet" href="css/blockpermanentlinks.css" media="all">
<link rel="stylesheet" href="css/smartblogstyle.css" media="all">
<link rel="stylesheet" href="css/smartbloglatestnews.css" media="all">
<link rel="stylesheet" href="css/smartblogtags.css" media="all">
<link rel="stylesheet" href="css/tmproductvideos.css" media="all">
<link rel="stylesheet" href="css/front.css" media="all">
<link rel="stylesheet" href="css/front_002.css" media="all">
<link rel="stylesheet" href="css/tmmegamenu.css" media="all">
<link rel="stylesheet" href="css/tm-media-parallax-styles.css" media="all">
<link rel="stylesheet" href="css/hooks.css" media="all">
<link rel="stylesheet" href="css/hook_002.css" media="all">
<link rel="stylesheet" href="css/hook.css" media="all">
<link rel="stylesheet" href="css/tmsearch.css" media="all">
<link rel="stylesheet" href="css/jquery_002.css" media="all">
<link rel="stylesheet" href="css/tmnewsletter.css" media="all">
<link rel="stylesheet" href="css/live_configurator.css" media="all">
<link rel="stylesheet" href="css/themeconfiglink.css" media="all">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-78069724-1', 'auto');
  ga('send', 'pageview');

</script>
<script type="text/javascript">
		$(document).ready(function() {
			if(!device.mobile() && !device.tablet()){
				$.srSmoothscroll({
					step: scroll_step,
					speed: scrool_speed
				});
			}
		});
	</script>
<script type="text/javascript">
	function addVideoParallax(selector, path, filename)
	{
		var selector = $(selector);

		selector.addClass('parallax_section');
		selector.attr('data-type-media', 'video_html');
		selector.attr('data-mp4', 'true');
		selector.attr('data-webm', 'true');
		selector.attr('data-ogv', 'true');
		selector.attr('data-poster', 'true');
		selector.wrapInner('<div class="container parallax_content"></div>');
		selector.append('<div class="parallax_inner"><video class="parallax_media" width="100%" height="100%" autoplay loop poster="/b2c/'+path+filename+'.jpg"><source src="/b2c/'+path+filename+'.mp4" type="video/mp4"><source src="/b2c/'+path+filename+'.webdm" type="video/webm"><source src="/b2c/'+path+filename+'.ogv" type="video/ogg"></video></div>');

		selector.tmMediaParallax();
	}
	
	function addImageParallax(selector, path, filename, width, height)
	{
		var selector = $(selector);

		selector.addClass('parallax_section');
		selector.attr('data-type-media', 'image');
		selector.wrapInner('<div class="container parallax_content"></div>');
		selector.append('<div class="parallax_inner"><img class="parallax_media" src="/b2c/'+path+filename+'" data-base-width="'+width+'" data-base-height="'+height+'"/></div>');

		selector.tmMediaParallax();
	}

	$(window).load(function(){
	
									addImageParallax('#tmhtmlcontent_topColumn','images/','home_parallax.jpg','2050','1296');
									addImageParallax('#homepage-blog','images/','home_02.jpg','2050','1423');
									});
</script>

<script type="text/javascript">
var CUSTOMIZE_TEXTFIELD = 1;
var FancyboxI18nClose = 'Close';
var FancyboxI18nNext = 'Next';
var FancyboxI18nPrev = 'Previous';
var added_to_wishlist = 'The product was successfully added to your wishlist.';
var ajax_allowed = true;
var ajaxsearch = true;
var baseDir = 'b2c/';
var baseUri = 'b2c/';
var blocking_popup = '1';
var comparator_max_item = 2;
var comparedProductsIds = [];
var contentOnly = false;
var currency = {"id":1,"name":"Dollar","iso_code":"USD","iso_code_num":"840","sign":"$","blank":"0","conversion_rate":"1.000000","deleted":"0","format":"1","decimals":"1","active":"1","prefix":"$ ","suffix":"","id_shop_list":null,"force_id":false};
var currencyBlank = 0;
var currencyFormat = 1;
var currencyRate = 1;
var currencySign = '$';
var customizationIdMessage = 'Customization #';
var defaultLat = 25.948969;
var defaultLong = -80.226439;
var delete_txt = 'Delete';
var displayList = false;
var freeProductTranslation = 'Free!';
var freeShippingTranslation = 'Free shipping!';
var generated_date = 1457462854;
var hasDeliveryAddress = false;
var hasStoreIcon = true;
var homeslider_loop = 1;
var homeslider_pause = 3000;
var homeslider_speed = 500;
var homeslider_width = 10000;
var id_lang = 1;
var img_dir = 'http://localhost:8089/b2c/images/';
var img_ps_dir = 'http://localhost:8089/b2c/';
var img_store_dir = 'http://localhost:8089/b2c/st/';
var infoWindow = '';
var instantsearch = true;
var isGuest = 0;
var isLogged = 0;
var isMobile = false;
var is_logged = false;
var l_code = 'en_US';
var loggin_required = 'You must be logged in to manage your wishlist.';
var logo_store = 'new-store-logo_stores-1444042568.gif';
var map = '';
var map_scroll_zoom = 0;
var map_street_view = 1;
var map_type = 'roadmap';
var map_type_control = 1;
var map_zoom = 10;
var markers = [];
var max_item = 'You cannot add more than 2 product(s) to the product comparison';
var min_item = 'Please select at least one product';
var module_url = 'index.jsp?fc=module&amp;module=tmnewsletter&amp;controller=default&amp;id_lang=1';
var mywishlist_url = 'index.jsp?fc=module&module=blockwishlist&controller=mywishlist&id_lang=1';
var nbItemsPerLine = 4;
var nbItemsPerLineMobile = 2;
var nbItemsPerLineTablet = 3;
var page_name = 'index';
var placeholder_blocknewsletter = 'Enter your e-mail';
var popup_status = true;
var priceDisplayMethod = 1;
var priceDisplayPrecision = 2;
var quickView = true;
var removingLinkText = 'remove this product from my cart';
var roundMode = 2;
var scroll_step = 150;
var scrool_speed = 800;
var searchUrl = 'index.jsp?controller=stores';
var search_url = 'index.jsp?controller=search';
var search_url_local = 'index.jsp?fc=module&module=tmsearch&controller=search&id_lang=1';
var static_token = '0f43ced266f746f375ee50a66e36976b';
var text_close = 'Close';
var text_description = '<p>Subscribe to the Fresh Air mailing list to receive updates on new arrivals, special offers and other discount information</p>';
var text_email = 'Your E-Mail';
var text_heading = 'Newsletter';
var text_heading_2 = 'Success';
var text_heading_3 = 'Error';
var text_placeholder = 'Enter your e-mail';
var text_remove = 'Do not show again';
var text_sign = 'Subscribe';
var tmnewsletter_status = '2';
var tmolarkchat_status = '2';
var tmsearch_description = true;
var tmsearch_height = 180;
var tmsearch_image = true;
var tmsearch_limit = true;
var tmsearch_limit_num = 3;
var tmsearch_manufacturer = true;
var tmsearch_price = true;
var tmsearch_reference = true;
var tmsearch_scroll = false;
var toBeDetermined = 'To be determined';
var token = 'c7b7a3f054a35496399e89ff73b2bd13';
var translation_1 = 'Phone:';
var translation_2 = 'Get directions';
var user_newsletter_status = 0;
var usingSecureMode = false;
var wishlistProductsIds = false;
</script><style type="text/css">.cf-hidden { display: none; } .cf-invisible { visibility: hidden; }</style>


<script type="text/javascript" src="js/jquery-1.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.js"></script>
<script type="text/javascript" src="js/jquery_004.js"></script>
<script type="text/javascript" src="js/tools.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/10-bootstrap.js"></script>
<script type="text/javascript" src="js/14-device.js"></script>
<script type="text/javascript" src="js/15-jquery.js"></script>
<script type="text/javascript" src="js/15-jquery_002.js"></script>
<script type="text/javascript" src="js/16-jquery.js"></script>
<script type="text/javascript" src="js/17-jquery.js"></script>
<script type="text/javascript" src="js/18-TimelineMax.js"></script>
<script type="text/javascript" src="js/19-TweenMax.js"></script>
<script type="text/javascript" src="js/jquery_005.js"></script>
<script type="text/javascript" src="js/products-comparison.js"></script>
<script type="text/javascript" src="js/ajax-cart.js"></script>
<script type="text/javascript" src="js/jquery_006.js"></script>
<script type="text/javascript" src="js/jquery_003.js"></script>
<script type="text/javascript" src="js/jquery_007.js"></script>
<script type="text/javascript" src="js/treeManagement.js"></script>
<script type="text/javascript" src="js/blocknewsletter.js"></script>
<script type="text/javascript" src="js/homeslider.js"></script>
<script type="text/javascript" src="js/ajax-wishlist.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/front.js"></script>
<script type="text/javascript" src="js/hoverIntent.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/tmmegamenu.js"></script>
<script type="text/javascript" src="js/js"></script>
<script type="text/javascript" src="js/device.js"></script>
<script type="text/javascript" src="js/jquery_002.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/tm-media-parallax.js"></script>
<script type="text/javascript" src="js/apple_maps-esque.js"></script>
<script type="text/javascript" src="js/stores.js"></script>
<script type="text/javascript" src="js/tmsocialfeeds.js"></script>
<script type="text/javascript" src="js/jquery_008.js"></script>
<script type="text/javascript" src="js/tmsearch.js"></script>
<script type="text/javascript" src="js/tmnewsletter.js"></script>
<script type="text/javascript" src="js/themeconfiglink.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>

<div class="top_menu" style="position: relative"><div style="position: absolute; top: 0px;" class="stickUpTop">
<div class="stickUpTop isStuck" style="top: 0px; position: fixed;"><div class="stickUpHolder container">
<div class="menu-title">Menu</div>
<ul class="menu clearfix sf-js-enabled">
	<li class="">
		<a href="index.jsp?id_category=18&amp;controller=category&amp;id_lang=1">Home</a>
	</li>
	<li class="">
		<a href="#" class="">Services</a>
		<div class="is-megamenu" style="display: none;">
			<div class="megamenu-row row megamenu-row-1" id="megamenu-row-1-1">
				<div class="megamenu-col megamenu-col-1-1 col-sm-3 " id="column-1-1-1">
				<ul class="content"><li class="category">
				<a title="In-Wall Air Conditioners " href="#" class="">In-Wall Air Conditioners </a>
				<ul style="display: none;"><li class="category">
					<a title="Frigidaire" href="#">Frigidaire</a></li>
					<li class="category"><a title="LG" href="#">LG</a></li>
					<li class="category"><a title="Keystone" href="#">Keystone</a></li>
					<li class="category"><a title="Koldfront" href="#">Koldfront</a></li>
					<li class="category"><a title="Amana" href="#">Amana</a></li>
					<li class="category"><a title="Soleus" href="#">Soleus</a></li>
					</ul></li><li class="category">
					<a title="Window Air Conditioners" href="#" class="">Window Air Conditioners</a>
					<ul style="display: none;"><li class="category"><a title="Sharp" href="#">Sharp</a></li>
					<li class="category"><a title="Danby" href="#">Danby</a></li>
					<li class="category"><a title="RCA" href="#">RCA</a></li>
					<li class="category"><a title="Amana" href="#">Amana</a></li>
					<li class="category"><a title="Arctic King" href="#">Arctic King</a></li>
					<li class="category"><a title="SPT " href="#">SPT </a></li></ul></li></ul></div>
					<div class="megamenu-col megamenu-col-1-2 col-sm-3 " id="column-1-1-2">
						<ul class="content"><li class="category">
							<a title="Portable Air Conditioners" href="#" class="">Portable Air Conditioners</a>
							<ul style="display: none;"><li class="category"><a title="Honeywell" href="#">Honeywell</a></li>
							<li class="category"><a title="Holmes" href="#">Holmes</a></li><li class="category">
							<a title="NewAir" href="#">NewAir</a></li><li class="category">
							<a title="Keystone" href="#">Keystone</a></li><li class="category">
							<a title="Haier" href="#">Haier</a></li><li class="category">
							<a title="Whynter" href="#">Whynter</a></li></ul></li><li class="category">
							<a title="Air Conditioner Accessories" href="#" class="">Air Conditioner Accessories</a>
							<ul style="display: none;"><li class="category">
							<a title="Frigidaire" href="#">Frigidaire</a></li><li class="category">
							<a title="HQRP" href="#">HQRP</a></li><li class="category">
							<a title="SPT" href="#">SPT</a></li><li class="category">
							<a title="Two Dogs Designs" href="#">Two Dogs Designs</a></li><li class="category">
							<a title="AC-Safe" href="#">AC-Safe</a></li><li class="category">
							<a title="First America" href="#">First America</a></li></ul></li></ul></div>
							<div class="megamenu-col megamenu-col-1-3 col-sm-3  first-in-line-sm" id="column-1-1-3">
							<ul class="content"><li class="category">
							<a title="Mini-Split Air Conditioners" href="#" class="">Mini-Split Air Conditioners</a>
							<ul style="display: none;"><li class="category"><a title="Klimaire" href="#">Klimaire</a></li><li class="category">
							<a title="MRCOOL" href="#">MRCOOL</a></li><li class="category">
							<a title="Westinghouse" href="#">Westinghouse</a></li>
							<li class="category"><a title="Frigidaire" href="#">Frigidaire</a></li>
							<li class="category"><a title="DuctlessAire" href="#">DuctlessAire</a></li><li class="category">
							<a title="GREE" href="#">GREE</a></li></ul></li><li class="all-manufacturers">
							<a title="All manufacturers" href="index.jsp?controller=manufacturer" class="">All manufacturers</a>
<ul style="display: none;">
<li class="manufacturer">
<a title="Frigidaire" href="index.jsp?id_manufacturer=9&amp;controller=manufacturer&amp;id_lang=1">Frigidaire</a>
</li>
<li class="manufacturer">
<a title="Haier" href="index.jsp?id_manufacturer=6&amp;controller=manufacturer&amp;id_lang=1">Haier</a>
</li>
<li class="manufacturer">
<a title="Honeywell " href="index.jsp?id_manufacturer=4&amp;controller=manufacturer&amp;id_lang=1">Honeywell </a>
</li>
<li class="manufacturer">
<a title="Keystone" href="index.jsp?id_manufacturer=7&amp;controller=manufacturer&amp;id_lang=1">Keystone</a>
</li>
<li class="manufacturer">
<a title="LG Electronics " href="index.jsp?id_manufacturer=8&amp;controller=manufacturer&amp;id_lang=1">LG Electronics </a>
</li>
<li class="manufacturer">
<a title="Sharp" href="index.jsp?id_manufacturer=2&amp;controller=manufacturer&amp;id_lang=1">Sharp</a>
</li>
<li class="manufacturer">
<a title="Sunpentown " href="index.jsp?id_manufacturer=5&amp;controller=manufacturer&amp;id_lang=1">Sunpentown </a>
</li>
<li class="manufacturer">
<a title="Whirlpool " href="index.jsp?id_manufacturer=3&amp;controller=manufacturer&amp;id_lang=1">Whirlpool </a>
</li>
</ul></li></ul></div><div class="megamenu-col megamenu-col-1-4 col-sm-3 " id="column-1-1-4"><ul class="content"> <li class="megamenu_banner banner_1">
<a href="index.jsp?id_category=18&amp;controller=category&amp;id_lang=1">
<img alt="banner_1" src="images/8afb7a9520932815f4e77986eb62a3ff670b9559_home_03.png" class="img-responsive">
<div class="description">
<h2>Frigidaire</h2>
<h4>Window Air Conditioner</h4>
<h3>Save<span>30%</span></h3>
</div>
</a>
</li>
<li class="megamenu_banner banner_2">
<a href="index.jsp?id_category=19&amp;controller=category&amp;id_lang=1">
<img alt="banner_2" src="images/6df291e6dac42920c4d46e7037a6136059c25fae_home_06.png" class="img-responsive">
<div class="description">
<h2>DeLonghi Pinguino</h2>
<h3>Save<span>25%</span></h3>
</div>
</a>
</li>
</ul></div></div></div></li>
			<li class="simple">
				<a href="index.jsp?id_category=19&amp;controller=category&amp;id_lang=1" class="">Compalain<span class="menu_badge">New</span></a>
				<ul class="is-simplemenu submenu-container clearfix" style="display: none;">
					<li class="category">
						<a title="Keystone" href="index.jsp?id_category=33&amp;controller=category&amp;id_lang=1">Keystone</a>
					</li>
					<li class="category">
						<a title="MRCOOL" href="index.jsp?id_category=37&amp;controller=category&amp;id_lang=1">MRCOOL</a>
					</li>
					<li class="category">
						<a title="Sharp" href="index.jsp?id_category=42&amp;controller=category&amp;id_lang=1">Sharp</a>
					</li>
					<li class="category">
						<a title="HQRP" href="index.jsp?id_category=49&amp;controller=category&amp;id_lang=1">HQRP</a>
					</li>
				</ul>
			</li>
			<li class="">
				<a href="index.jsp?id_category=18&amp;controller=category&amp;id_lang=1">About Us</a>
			</li>
			<li class="">
				<a href="index.jsp?id_category=43&amp;controller=category&amp;id_lang=1">Training</a>
			</li>
			<li class="">
				<a href="index.jsp?id_category=33&amp;controller=category&amp;id_lang=1">Career<span class="menu_badge">sale</span></a>
			</li>
			<li class="">
				<a href="/b2c/contactUs.html">Contact Us</a>
			</li>
	</ul>
</div>
</div>
</div>
</div>
<h1>Contact Us</h1>
</body>
</html>