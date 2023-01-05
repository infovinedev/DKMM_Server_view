<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	String inflow_channel = request.getParameter("inflow_channel");
	String url = null;
	if(inflow_channel!=null){
		switch(inflow_channel){
		case "RkFDRUJPT0tfUA==":		//페이스북 프로모션
			url = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
			break;
		case "TkFWRVJfUA==":		//네이버 프로모션
			url = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
			break;
		case "S0FLQU9fUA==":		//카카오 프로모션
			url = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
			break;
		case "R09PR0xFX1A=":		//구글 프로모션
			url = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
			break;
		case "RkFDRUJPT0s=":		//페이스북
			url = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
			break;
		case "TkFWRVI=":		//네이버
			url = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
			break;
		case "S0FLQU8=":		//카카오
			url = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
			break;
		case "T0ZGTElORTAwMQ==":		//오프라인001
			url = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
			break;
		case "R09PR0xF":		//구글
			url = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
			break;
		default:				//일반유입
			url = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflow_channel;
			break;
		}
	}
	else{
		//inflow_channel 없을경우(일반유입)
		url = "https://appdkmm.page.link/6R7o";
	}
	boolean flag = true;
	String userAgent = request.getHeader("User-Agent").toUpperCase();
	String IS_MOBILE = "MOBI";
	if(userAgent.indexOf(IS_MOBILE) > -1) {
		flag = false;
	}
	if(!flag){
	    if(inflow_channel!=null){
			response.sendRedirect("index.jsp?inflow_channel="+inflow_channel);
	    }
		else {
			response.sendRedirect("index.jsp");
	    }
	}
%>
<html>
<head>
<link rel="icon" href="https://dkmm.infovine.co.kr:9124/upload/doc/favicon.png">
<link href="https://fonts.googleapis.com/css?family=Pretendard&amp;display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans+KR&amp;display=swap" rel="stylesheet">
</head>
<body>
	<div class="v2626_39599">
		<div class="v2626_39600"></div>
		<div class="v2626_39601"></div>
		<div class="v2955_42157">
			<a href="<%=url%>">
				<img src="images/v2955_42157.png">
			</a>
		</div>

		<div class="v2955_42158">
			<a href="<%=url%>">
				<img src="images/v2955_42158.png">
			</a>
		</div>
		
		<span class="v2626_39645">구글 플레이이 스토어 다운로드</span>
		<span class="v2626_39646">앱 스토어 다운로드</span>
		<span class="v2626_39647">이제,대기몇명에서 쉽게,<br> 음식점 대기 현황을 미리 확인하여 줄서지 말자!</span>
		<span class="v2626_39648">APP 다운로드</span>
		<div class="v2626_39681">
			<div class="v2626_39649">
				<div class="v2626_39650"></div>
				<div class="v2626_39652"></div>
			</div>
			<div class="v2626_39653">
				<div class="v2626_39654"></div>
				<!-- <div class="v2626_39655"></div> -->
				<div class="v2626_39656"></div>
			</div>
		</div>
		<div class="v2626_39657"></div>
		<div class="v2626_39658"><img src="images/v2626_39658.png" style="width: 186px;"></div>
		<div class="v2955_42159">
		</div>
	</div>
</body>
</html>
<style>* {
  box-sizing: border-box;
  margin:0px!important;
}
body {
  font-size: 14px;
}
.v2626_39599 {
  width: 100%;
  height: 1080px;
  background: rgba(33,107,243,1);
  opacity: 1;
  position: relative;
  top: 0px;
  left: 0px;
  overflow: hidden;
}
.v2626_39600 {
  width: 1707px;
  height: 602px;
  background: rgba(29,198,226,1);
  opacity: 0.8999999761581421;
  position: absolute;
  top: 562px;
  left: -44px;
  border-top-left-radius: 1000px;
  border-top-right-radius: 1000px;
  border-bottom-left-radius: 1000px;
  border-bottom-right-radius: 1000px;
  transform: rotate(-30deg);
  overflow: hidden;
}
.v2626_39601 {
  width: 619px;
  height: 208px;
  background: rgba(47,230,191,1);
  opacity: 1;
  position: absolute;
  top: 730px;
  left: -393px;
  border-top-left-radius: 1000px;
  border-top-right-radius: 1000px;
  border-bottom-left-radius: 1000px;
  border-bottom-right-radius: 1000px;
  transform: rotate(-30deg);
  overflow: hidden;
}
.v2955_42157 {
  width: 280px;
  height: 64px;
 /*  background: url("images/v2955_42157.png"); */
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 866px;
  left: 562px;
  overflow: hidden;
}
.v2955_42158 {
  width: 280px;
  height: 64px;
  /* background: url("images/v2955_42158.png"); */
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 867px;
  left: 275px;
  overflow: hidden;
}
.v2626_39645 {
  width: 192px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 941px;
  left: 319px;
  font-family: Pretendard;
  font-weight: SemiBold;
  font-size: 13px;
  opacity: 1;
  text-align: center;
}
.v2626_39646 {
  width: 119px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 941px;
  left: 640px;
  font-family: Pretendard;
  font-weight: SemiBold;
  font-size: 13px;
  opacity: 1;
  text-align: center;
}
.v2626_39647 {
  width: 475px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 386px;
  left: 275px;
  font-family: IBM Plex Sans KR;
  font-weight: Light;
  font-size: 22px;
  opacity: 1;
  text-align: left;
}
.v2626_39648 {
  width: 408px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 282px;
  left: 275px;
  font-family: IBM Plex Sans KR;
  font-weight: Thin;
  font-size: 72px;
  opacity: 1;
  text-align: left;
}
.v2626_39681 {
  width: 713px;
  height: 1047px;
  /* background: url("images/v2626_39681.png"); */
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 167px;
  left: 929px;
  overflow: hidden;
}
.v2626_39649 {
  width: 460px;
  height: 913px;
  /* background: url("images/v2626_39649.png"); */
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 134px;
  left: 0px;
  overflow: hidden;
}
.v2626_39650 {
  width: 460px;
  height: 779px;
  background: rgba(255,255,255,1);
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 0px;
  border-top-left-radius: 24px;
  border-top-right-radius: 24px;
  box-shadow: 0px -3px 40px rgba(0, 0, 0, 0.03999999910593033);
  overflow: hidden;
}
.v2626_39652 {
  width: 440px;
  height: 904px;
  background: url("images/v2626_39652.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 9px;
  left: 10px;
  border: 1px solid rgba(238,238,238,1);
  border-top-left-radius: 16px;
  border-top-right-radius: 16px;
  overflow: hidden;
}
.v2626_39653 {
  width: 460px;
  height: 922px;
  /* background: url("images/v2626_39653.png"); */
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 253px;
  overflow: hidden;
}
.v2626_39654 {
  width: 460px;
  height: 922px;
  background: rgba(255,255,255,1);
  opacity: 1;
  position: relative;
  top: 0px;
  left: 0px;
  border-top-left-radius: 24px;
  border-top-right-radius: 24px;
  box-shadow: 0px -3px 40px rgba(0, 0, 0, 0.03999999910593033);
  overflow: hidden;
}
.v2626_39656 {
  width: 440px;
  height: 904px;
  background: url("images/v2626_39656.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 10px;
  left: 10px;
  border: 1px solid rgba(238,238,238,1);
  border-top-left-radius: 16px;
  border-top-right-radius: 16px;
  overflow: hidden;
}
.v2626_39657 {
  width: 98px;
  height: 98px;
  background: url("images/v2626_39657.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 159px;
  left: 267px;
  overflow: hidden;
}
.v2626_39658 {
  opacity: 1;
  position: absolute;
  top: 181px;
  left: 394px;
  overflow: hidden;
}
.v2955_42159 {
  width: 373px;
  height: 116px;
  background: url("images/v2955_42159.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 541px;
  left: 275px;
  overflow: hidden;
}
</style>