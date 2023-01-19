<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<meta name="format-detection" content="telephone=no"/>
<head>
<title>대기몇명</title>
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Pretendard&display=swap" rel="stylesheet" />
<script async src="https://www.googletagmanager.com/gtag/js?id=G-TH0S518PP1"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag(){dataLayer.push(arguments);}
	gtag('js', new Date());

	gtag('config', 'G-TH0S518PP1');
	
	function callFunction(terms){
		var url = "";
		switch(terms){
			case 'use':
					url = "${urlMain}/termsofservice/use.do";
					break;
			case 'privacy': 
					url = "${urlMain}/termsofservice/privacy.do";
					break;
			case 'location':
					url = "${urlMain}/termsofservice/location.do";
					break;
			}
			window.open(url);
	}
</script>
</head>
<body>
	<div class="v2999_43392">
		<div class="v2999_43393"></div>
		<div class="v2999_43394"></div>
		<span class="v2999_43403">이제 대기몇명에서 쉽게,<br> 음식점 대기 현황을 미리 확인하여 줄서지 말자!</span>
		<span class="v2999_43404">APP 다운로드</span>
		<div class="v2999_43405">
			<img src="/assets/images/v2955_42159.png" style="width: 353px;">
		</div>
		<div class="v2999_43417">
			<div class="v2999_43420"></div>
		</div>
		<div class="v2999_43421">
 			<div class="v2999_43424"></div>
		</div>
		<div class="v2999_43425"></div>
		<div class="v2999_43426"></div>
		<div class="v2999_43427">
			<a href="${iosUrl}">
				<img src="/assets/images/v2999_43455.png" style="width:152px">
			</a>
		</div>
		<div class="v2999_43454">
			<a href="${aosUrl}">
				<img src="/assets/images/v2999_43454.png" style="width:176px">
			</a>
		</div>
		<span class="v2999_43468">구글 플레이이 스토어 다운로드</span>
		<span class="v2999_43469">앱 스토어 다운로드</span>
		<div class="v2999_43395"></div>
		<div class="v2999_43396"><img src="/assets/images/v2626_39658.png" style="width: 160px;"></div>
		
		
		<div style="width:100%;height: 13%;position: absolute; bottom: 0;left: 0; background: #242424;">
			<div style="width: 100%; margin-top: 2rem; margin-left: 1rem; float: left;">
					<p style=" color: rgba(255,255,255,0.4); line-height: 20px; font-size: 13px; margin-left: 0.5rem;  margin-right: 5rem; text-align: left;">
						<b style="font-weight: bold">(주)인포바인</b><br>
						대표:권성준<br>
						주소:서울특별시 영등포구 여의대로 24, 40층 (여의도동,전국경제인연합회회관)<br>
						사업자등록번호:106-81-86362<br>
						개인정보담당:dkmm_cs@infovine.co.kr
					</p>
			</div>
			 <div style="width: 100%; margin-top: 11rem; margin-left: 0.5rem;">
				<a href="javascript:callFunction('use');" style="font-size: 11px; color: rgba(255,255,255,80); margin-left: 1rem;">서비스 이용약관</a>
				<a href="javascript:callFunction('privacy');" style="font-size: 11px; color: rgba(255,255,255,80); margin-left: 0.3rem;">개인정보 처리방침</a>
				<a href="javascript:callFunction('location');" style="font-size: 11px; color: rgba(255,255,255,80); margin-left: 0.3rem;">위치기반 서비스 이용약관</a>
			</div> 
		</div>
	</div>
</body>
</html>
<style>
* {
	box-sizing: border-box;
	margin:0px;
}

body {
	font-size: 14px;
}

.v2999_43392 {
	width: 100%;
	height: 1793px;
	background: rgba(33, 107, 243, 1);
	opacity: 1;
	position: relative;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.v2999_43393 {
	width: 545px;
	height: 192px;
	background: rgba(29, 198, 226, 1);
	opacity: 0.8999999761581421;
	position: absolute;
	top: 546px;
	left: -3px;
	border-top-left-radius: 1000px;
	border-top-right-radius: 1000px;
	border-bottom-left-radius: 1000px;
	border-bottom-right-radius: 1000px;
	transform: rotate(-30deg);
	overflow: hidden;
}

.v2999_43394 {
	width: 198px;
	height: 66px;
	background: rgba(47, 230, 191, 1);
	opacity: 1;
	position: absolute;
	top: 553px;
	left: -61px;
	border-top-left-radius: 1000px;
	border-top-right-radius: 1000px;
	border-bottom-left-radius: 1000px;
	border-bottom-right-radius: 1000px;
	transform: rotate(-30deg);
	overflow: hidden;
}

.v2999_43403 {
	width: 269px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
	top: 279px;
	left: 15px;
	font-family: IBM Plex Sans KR;
	font-weight: Light;
	font-size: 20px;
	opacity: 1;
	text-align: left;
}

.v2999_43404 {
	width: 224px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
	top: 215px;
	left: 15px;
	font-family: IBM Plex Sans KR;
	font-weight: Thin;
	font-size: 39px;
	opacity: 1;
	text-align: left;
}

.v2999_43405 {
	width: 386px;
	height: 112px;
	/* background: url("/assets/images/v2955_42159.png"); */
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 392px;
	left: 16px;
	overflow: hidden;
}


.v2999_43417 {
	width: 226px;
	height: 455px;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 672px;
	left: 8px;
	overflow: hidden;
}
.v2999_43420 {
	width: 216px;
	height: 457px;
	background: url("/assets/images/v2626_39652.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 4px;
	left: 7px;
	overflow: hidden;
}

.v2999_43421 {
	width: 226px;
	height: 455px;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 607px;
	left: 138px;
	overflow: hidden;
}
.v2999_43424 {
	width: 216px;
	height: 463px;
	background: url("/assets/images/v2626_39656.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 4px;
	left: 6px;
	overflow: hidden;
}

.v2999_43425 {
	width: 223px;
	height: 74px;
	background: rgba(255, 255, 255, 0.10000000149011612);
	opacity: 1;
	position: absolute;
	top: 1239px;
	left: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid rgba(255, 255, 255, 1);
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	overflow: hidden;
}

.v2999_43426 {
	width: 223px;
	height: 74px;
	background: rgba(255, 255, 255, 0.10000000149011612);
	opacity: 1;
	position: absolute;
	top: 1393px;
	left: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid rgba(255, 255, 255, 1);
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	overflow: hidden;
}

.v2999_43427 {
	width: 152px;
	height: 41px;
	opacity: 1;
	position: absolute;
	top: 1390px;
	left: 50%;
	transform: translate(-55%, -50%);
	overflow: hidden;
}


.v2999_43454 {
	width: 176px;
	height: 41px;
	opacity: 1;
	position: absolute;
	top: 1237px;
	left: 50%;
	transform: translate(-50%, -50%);
	overflow: hidden;
}


.v2999_43468 {
	width: 223px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
	top: 1296px;
	left: 50%;
	transform: translate(-50%, -50%);
	font-family: Pretendard;
	font-weight: SemiBold;
	font-size: 14px;
	opacity: 1;
	text-align: center;
}

.v2999_43469 {
	width: 138px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
	top: 1450px;
	left: 50%;
	transform: translate(-50%, -50%);
	font-family: Pretendard;
	font-weight: SemiBold;
	font-size: 14px;
	opacity: 1;
	text-align: center;
}

.v2999_43395 {
	width: 98px;
	height: 98px;
	background: url("/assets/images/v2626_39657.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 120px;
	left: 5px;
	overflow: hidden;
	z-index: 9999;
}

.v2999_43396 {
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 146px;
	left: 105px;
	overflow: hidden;
	z-index: 9999;
}

</style>