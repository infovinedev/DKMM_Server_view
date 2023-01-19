<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="proSdate" value="20210510"/>
<c:set var="proEdate" value="20210510"/>
<c:if test="${not empty start_date}">
	<c:set var="proSdate" value="${start_date}" />
	<c:set var="proEdate" value="${close_date}" />
</c:if>

<c:set var="isPro" value="true"/><%-- true로 설정. 기존과 동일. false로 할 경우 프로모션이 없을 경우, 휴대폰번호 인증할 수 없음. --%>
<c:if test="${today >= proSdate && today <= proEdate}">
	<c:set var="isPro" value="true"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta property="og:type" content="website" />
<meta property="og:title" content="참여하고 경품받자!"/>
<meta property="og:description" content="대기몇명 런칭 프로모션 참여"/>
<meta property="og:image" content="https://ssproxy2.ucloudbiz.olleh.com/v1/AUTH_c8a2303fd1ce4f3a8168b5f12f021c86/MCP/dkmm/promotion/2301/p_2301_thum.png" />
<meta property="og:url" content="https://dkmm.infovine.co.kr/promotion.do"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=yes" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta charset="utf-8">

<link href="https://fonts.googleapis.com/css?family=Pretendard&amp;display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans+KR&amp;display=swap" rel="stylesheet">
<link href="/assets/css/terms_dkmm.css" rel="stylesheet" type="text/css">
<script async src="https://www.googletagmanager.com/gtag/js?id=G-TH0S518PP1"></script>

<script  src="/assets/js/jquery-3.3.1.js"></script>
<script src="/assets/lib/jquery-ui/jquery-ui.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.js" type="text/javascript"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag(){dataLayer.push(arguments);}
	gtag('js', new Date());

	gtag('config', 'G-TH0S518PP1');
	Kakao.init('49e2d17db8e7f3ab248258375fe3c629');
	var mobileCheck ="${mobileCheck}";
	var inflowChannel ="${inflow_channel}";
	function fun_btn_share(){
		$("#div_share").show();
	}
	function fun_close(){
		$("#div_share").hide();
	}
	//카카오톡 공유
	function kakaoShare() {
	var  thumbnailUrl  = $( 'meta[property="og:url"]' ).attr( 'content' );
		if(inflowChannel != ""){
			thumbnailUrl += '?inflow_channel='+inflowChannel+'&share=KATALK';
		}else{
			thumbnailUrl += '?share=KATALK'
		}
		
		Kakao.Link.sendDefault({
			objectType: 'feed',
			content: {
					title: '참여하고 경품받자!',
					description: '대기몇명 런칭 프로모션 참여',
					imageUrl: 'https://dkmm.infovine.co.kr/upload/doc/sns_thumbnail.png',
					link: {
						mobileWebUrl: thumbnailUrl,
						webUrl: thumbnailUrl,
					},
		},
		buttons: [
			{
				title: '확인하기',
				link: {
					mobileWebUrl: thumbnailUrl,
					webUrl: thumbnailUrl,
				},
			},
		],
		// 카카오톡 미설치 시 카카오톡 설치 경로이동
		installTalk: true,
		})
	}
	//카카오스토리
	function shareKakaoStory() {
		var  thumbnailDescription  = $( 'meta[property="og:description"]' ).attr( 'content' );
		var  thumbnailUrl  = $( 'meta[property="og:url"]' ).attr( 'content' );
		if(inflowChannel != ""){
			thumbnailUrl += '?inflow_channel='+inflowChannel+'&share=KASTORY';
		}else{
			thumbnailUrl += '?share=KASTORY'
		}

		Kakao.Story.share({
			url: thumbnailUrl,
			text: thumbnailDescription,
		});
	}
	
	function kakaoLogin(callback){
		Kakao.Auth.login({
			success : function(authObj) {
				callback();
			},
			fail : function(errorObj) {//로그인 실패(호출되지 않음)
				alert("카카오 로그인에 실패하였습니다.");
			}
		});
	}
	
	function fun_shareBane(){
		var  thumbnailUrl  = $( 'meta[property="og:url"]' ).attr( 'content' );
		if(inflowChannel != ""){
			thumbnailUrl += '?inflow_channel='+inflowChannel+'&share=BAND';
		}else{
			thumbnailUrl += '?share=BAND'
		}
		
		var  thumbnailTitle  = $( 'meta[property="og:title"]' ).attr( 'content' );
		var  thumbnailImage  = $( 'meta[property="og:image"]' ).attr( 'content' );
		var url = "http://band.us/plugin/share?body="+encodeURIComponent(thumbnailTitle)+encodeURIComponent('\r\n')+encodeURIComponent(thumbnailUrl)+"&route="+encodeURIComponent(thumbnailUrl);
		window.open(url);
	}
	
	//facebook
	function shareFacebook(){
		var  thumbnailUrl  = $( 'meta[property="og:url"]' ).attr( 'content' );
		if(inflowChannel != ""){
			thumbnailUrl += '?inflow_channel='+inflowChannel+'&share=FACEBOOK';
		}else{
			thumbnailUrl += '?share=FACEBOOK'
		}
		var url = "http://www.facebook.com/sharer.php?u="+thumbnailUrl;
		window.open(url);
	}
	
	function link_email(type) {
		var  thumbnailUrl  = $( 'meta[property="og:url"]' ).attr( 'content' );
		if(inflowChannel != ""){
			thumbnailUrl += '?inflow_channel='+inflowChannel+'&share=MAIL';
		}else{
			thumbnailUrl += '?share=MAIL'
		}
		var  thumbnailTitle  = $( 'meta[property="og:title"]' ).attr( 'content' );
		var  thumbnailDescription  = $( 'meta[property="og:description"]' ).attr( 'content' ); 
		$(location).attr('href', "mailto:?subject="+thumbnailTitle+"&body="+thumbnailDescription + thumbnailUrl);
	}
	//링크 복사하기
	function fun_copyTheLink(){
		var url = '';
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = window.document.location.href;
		url += "&share=URL";
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("URL이 복사되었습니다.")
	}
</script>
<style>
	html, body {
		width: 100%; height: 100%;
	}
</style>
</head>
<body style="margin: 0px!important;">
	<div style="width:100%">
		<!-- Mobile ,Web 스타일 구분하기 위한 -->
		<c:choose>
			<c:when test="${mobileCheck != false}">
				<div style="display: inline-block; width:30%;">
				</div>
				<div style="display: inline-block; width:40%; position: relative;">
			</c:when>
			
			<c:otherwise>
				<div style="position: relative;">
			</c:otherwise>
		</c:choose>
		
			<c:choose>
				<%-- <c:when test="${today>=proSdate and not empty promotion_image}"> --%>
				<c:when test="${today>=proSdate and not empty promotion_image}">
					<%--여기가 새롭게 적용될 이미지 주소 --%>
						<img src="${promotion_image}" alt="${promotion_image_alt}" style="width:100%;" />
						<div style="position: absolute; top: 23%; left: 50%; transform: translate(-50%, -50%);">
							<a href="${aosUrl}">
								<img src="/assets/images/promotion/google.png" style="width:100%;"/>
							</a>
						</div>
						<div style="position: absolute; top: 26%; left: 50%; transform: translate(-50%, -50%);">
							<a href="${iosUrl}">
								<img src="/assets/images/promotion/appStore.png" style="width:100%;"/>
							</a>
						</div>
						<div style="position: absolute; top: 29%; left: 50%; transform: translate(-50%, -50%);">
							<img src="/assets/images/promotion/share.png" style="width:100%;" onClick="fun_btn_share()"/>
						</div>
						<!--  style="display: none;" -->
						<div id="div_share" style="display: none;">
							<div style="opacity: 0.8; position: fixed; inset: 0px; z-index: 9000; background: #000; width: 100%; height: 100%;"></div>
							
							<div class="ui_modal ui_modal_container js_bgTransparent" style="z-index: 9001;position: fixed; outline: none;background-clip: padding-box;top: 50%;left: 51%;border-radius: 3px;margin-left: -90px;margin-top: -154px;width: 195px;height: 294px;-webkit-tap-highlight-color: transparent;" tabindex="0">
								<c:choose>
									<c:when test="${mobileCheck != true}">
									<!-- 카카오톡 -->
									<a id="kakao-link-btn" href="javascript:kakaoShare()">
										<img style="width: 70px; margin-right: 1rem;" src="/assets/images/promotion/btn_Katalk.png" alt="카카오톡 공유하기 버튼"/>
									</a>
									<!-- 카카오스토리 -->
									<a id="share-kakaostory-button" href="javascript:shareKakaoStory()">
										<img style="width: 70px;margin-left: 3rem;" src="/assets/images/promotion/btn_Kastory.png" alt="카카오스토리 공유하기 버튼"/>
									</a>
									<!-- 밴드 -->
									<a href="javascript:fun_shareBane()"><img style="width: 70px; margin-right: 1rem;margin-top: 2rem;"  src="/assets/images/promotion/btn_band.png" alt="밴드공유"/></a>
									<!-- facebook -->
									<a href="javascript:shareFacebook()" class="btn btn-default">
										<img style="width: 70px; margin-left: 3rem; margin-top: 2rem;" src="/assets/images/promotion/btn_Facebook.png" alt="페이스북 공유하기 버튼"/>
									</a>
									</c:when>
								</c:choose>	
									<!-- mail -->
									<a href="javascript:link_email()" class="btn btn-default">
										<img style="width: 70px; margin-right: 1rem;margin-top: 2rem;" src="/assets/images/promotion/btn_mail.png" alt="메일 공유하기 버튼"/>
									</a>
									<!-- <a href="mailto:?">웹메일테스트</a> -->
									<!-- <a href="mailto:someone@yoursite.com" target="_blank" rel="noopener noreferrer">웹메일테스트</a> -->
									<!-- 링크복사 -->
									<span class="button gray medium">
										<a href="#" onclick="fun_copyTheLink(); return false;">
											<img style="width: 70px; margin-left: 3rem; margin-top: 2rem;" src="/assets/images/promotion/btn_copy.png" alt="페이스북 공유하기 버튼"/>
										</a>
									</span>
									<!-- 닫기버튼 -->
									<a href="javascript:fun_close()">
										<img style="width: 56px; margin-top: 1rem; margin-left: 6.2rem;" src="/assets/images/promotion/btn_close.png" alt="닫기버튼"/>
									</a>
							</div>
						</div>
				</c:when>
			<c:otherwise>
				<!-- 종료되었을때 이미지 -->
				<img src="/assets/images/promotion/theend.jpg" style="width:100%;" />
				<div style="position: absolute; top: 24%; left: 50%; transform: translate(-50%, -50%);">
				<img src="/assets/images/promotion/google.png" style="width:100%;" />
				</div>
				<div style="position: absolute; top: 27%; left: 50%; transform: translate(-50%, -50%);">
				<img src="/assets/images/promotion/appStore.png" style="width:100%;" />
				</div>
				<div style="position: absolute; top: 30%; left: 50%; transform: translate(-50%, -50%);">
				<img src="/assets/images/promotion/share.png" style="width:100%;" />
				</div>
			</c:otherwise>
			</c:choose>

		</div>
		
		<div style="<c:if test='${mobileCheck}'>display: inline-block; width:30%;</c:if>">
		</div>
		
		
	</div>
</body>
</html>