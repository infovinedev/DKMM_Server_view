package kr.co.infovine.dkmm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.infovine.dkmm.db.model.common.TCommonCodeModel;
import kr.co.infovine.dkmm.service.common.CommonService;
import kr.co.infovine.dkmm.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.infovine.dkmm.api.model.base.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Controller
public class BaseController {
	@Autowired
	private CommonService commonService;

	@Autowired
	HttpClient httpClient;
	
	@Value("${url.server.api}")
	String urlServerApi;

	@Value("${url.main}")
	String urlMain;

	@RequestMapping(value="/")
	public void base(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(urlMain + "/index.do");
	}

	@RequestMapping(value="/error.do")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		return model;
	}

	@RequestMapping(value="/index.do")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		String inflowChannel = request.getParameter("inflow_channel");
		if(inflowChannel!=null) {
			if(inflowChannel.equals("")) {
				inflowChannel = (String) request.getAttribute("inflow_channel");
			}
		}
		else {
			inflowChannel = (String) request.getAttribute("inflow_channel");
		}

		String aosUrl = null;
		String iosUrl = null;
		boolean flag = true;
		String userAgent = request.getHeader("User-Agent").toUpperCase();
		String IS_MOBILE = "MOBI";
		if(userAgent.indexOf(IS_MOBILE) > -1) {
			flag = false;
		}
		if(flag){			//웹환경
			model.setViewName("indexWeb");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //페이스북 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //네이버 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //카카오 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //구글 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xFX1A=";
						break;
					case "RkFDRUJPT0s=":        //페이스북
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //네이버
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVI=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //카카오
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU8=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //오프라인001
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //구글
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xF";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xF";
						break;
					default:                //일반유입
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=" + inflowChannel;
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel 없을경우(일반유입)
				aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm";
				iosUrl = "https://apps.apple.com/app/id6443979602";
			}
		}
		else {
			model.setViewName("index");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //페이스북 프로모션
						aosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //네이버 프로모션
						aosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //카카오 프로모션
						aosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //구글 프로모션
						aosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						break;
					case "RkFDRUJPT0s=":        //페이스북
						aosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //네이버
						aosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						iosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //카카오
						aosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						iosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //오프라인001
						aosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //구글
						aosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						iosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						break;
					default:                //일반유입
						aosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						iosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel 없을경우(일반유입)
				aosUrl = "https://appdkmm.page.link/6R7o";
				iosUrl = "https://appdkmm.page.link/6R7o";
			}
		}

		model.addObject("inflow_channel", inflowChannel);
		model.addObject("aosUrl", aosUrl);
		model.addObject("iosUrl", iosUrl);
		model.addObject("urlServerApi", urlServerApi);
		return model;
	}

	@RequestMapping(value="/promotion.do")
	public ModelAndView promotion(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		String inflowChannel = request.getParameter("inflow_channel");
		if(inflowChannel!=null) {
			if(inflowChannel.equals("")) {
				inflowChannel = (String) request.getAttribute("inflow_channel");
			}
		}
		else {
			inflowChannel = (String) request.getAttribute("inflow_channel");
		}

		String aosUrl = null;
		String iosUrl = null;
		boolean flag = true;
		String userAgent = request.getHeader("User-Agent").toUpperCase();
		String IS_MOBILE = "MOBI";
		if(userAgent.indexOf(IS_MOBILE) > -1) {
			flag = false;
		}
		if(flag){			//웹환경
			model.setViewName("promotion");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //페이스북 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //네이버 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //카카오 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //구글 프로모션
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xFX1A=";
						break;
					case "RkFDRUJPT0s=":        //페이스북
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //네이버
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVI=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //카카오
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU8=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //오프라인001
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //구글
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xF";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xF";
						break;
					default:                //일반유입
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=" + inflowChannel;
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel 없을경우(일반유입)
				aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm";
				iosUrl = "https://apps.apple.com/app/id6443979602";
			}
		}
		else {
			model.setViewName("promotion");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //페이스북 프로모션
						aosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //네이버 프로모션
						aosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //카카오 프로모션
						aosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //구글 프로모션
						aosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						break;
					case "RkFDRUJPT0s=":        //페이스북
						aosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //네이버
						aosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						iosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //카카오
						aosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						iosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //오프라인001
						aosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //구글
						aosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						iosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						break;
					default:                //일반유입
						aosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						iosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel 없을경우(일반유입)
				aosUrl = "https://appdkmm.page.link/6R7o";
				iosUrl = "https://appdkmm.page.link/6R7o";
			}
		}

		model.addObject("inflow_channel", inflowChannel);
		model.addObject("aosUrl", aosUrl);
		model.addObject("iosUrl", iosUrl);
		model.addObject("urlServerApi", urlServerApi);


		String today = CommonUtil.getToday();
		String mode = "current";

		String futureKey = ServletRequestUtils.getStringParameter(request, "futureKey", "");
		if ("3qa@kljh2KslWTEOJk2390ufPmio2".equals(futureKey)) {
			mode = "future";
		}

		List<TCommonCodeModel> list = commonService.selectCommonCodeByPromotion(mode);
		for (TCommonCodeModel commonCode: list) {
			if ("promotion_date".equals(commonCode.getCodeGroup())) {
				String codeValue = commonCode.getCodeValue().replace("future_", "");
				String codeDescription = commonCode.getCodeDescription();

				model.addObject(codeValue, codeDescription);

				if ("start_date".equals(codeValue) && "future".equals(mode)) {
					today = codeDescription;
				}
			} else {
				model.addObject(commonCode.getCodeGroup(), commonCode.getCodeDescription());
			}
		}

		model.addObject("today", today);
		return model;
	}

	@RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
	public void favicon( HttpServletRequest request, HttpServletResponse reponse ) {
		try {
			reponse.sendRedirect(urlMain + "/assets/images/favicon.png");
		} catch (IOException e) {
		}
	}

	// region 설명: 로드벨런싱 체크
	/**
	 * 2022-12-26 Made by Duhyun, Kim
	 * @param args
	 * return : ResponseModel
	 */
	@RequestMapping(value="/checkHealth.do", method = RequestMethod.GET
			, produces = "application/json; charset=utf8" )
	@ResponseBody
	public ResponseModel checkHealth(HttpServletRequest request, HttpServletResponse response) {
		ResponseModel result = new ResponseModel();
		try {
			result.setCode("0000");
		}
		catch (Exception e) {
			result.setCode("0001");
		}
		return result;
	}
	// end region
}
