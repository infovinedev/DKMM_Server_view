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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
		String inflowChannel = request.getParameter("inflow_channel");
		if(inflowChannel!=null) {
			if(inflowChannel.equals("")) {
				inflowChannel = (String) request.getAttribute("inflow_channel");
			}
		}
		else {
			inflowChannel = (String) request.getAttribute("inflow_channel");
		}
		if(inflowChannel!=null) {
			response.sendRedirect(urlMain + "/index.do?inflow_channel=" + inflowChannel);
		}
		else{
			response.sendRedirect(urlMain + "/index.do");
		}
	}

	@RequestMapping(value="/error.do")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		return model;
	}
	
	@RequestMapping(value="/termsofservice/use.do")
	public ModelAndView use(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("termsofservice/use");
		return model;
	}
	
	@RequestMapping(value="/termsofservice/privacy.do")
	public ModelAndView privacy(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("termsofservice/privacy");
		return model;
	}
	
	@RequestMapping(value="/termsofservice/location.do")
	public ModelAndView location(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("termsofservice/location");
		return model;
	}
	
	@RequestMapping(value="/termsofservice/marketing.do")
	public ModelAndView marketing(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("termsofservice/marketing");
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
		if(flag){			//?????????
			model.setViewName("indexWeb");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //???????????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //????????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //????????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //?????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xFX1A=";
						break;
					case "UFBPTV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=UFBPTV9Q";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=UFBPTV9Q";
						break;
					case "UElDQV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=UElDQV9Q";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=UElDQV9Q";
						break;
					case "RkFDRUJPT0s=":        //????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //?????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVI=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //?????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU8=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //????????????001
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //??????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xF";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xF";
						break;
					default:                //????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=" + inflowChannel;
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel ????????????(????????????)
				aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm";
				iosUrl = "https://apps.apple.com/app/id6443979602";
			}
		}
		else {
			model.setViewName("index");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //???????????? ????????????
						aosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //????????? ????????????
						aosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //????????? ????????????
						aosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //?????? ????????????
						aosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						break;
					case "UFBPTV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://appdkmm.page.link/Yihd?inflow_channel=UFBPTV9Q";
						iosUrl = "https://appdkmm.page.link/Yihd?inflow_channel=UFBPTV9Q";
						break;
					case "UElDQV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://appdkmm.page.link/332g?inflow_channel=UElDQV9Q";
						iosUrl = "https://appdkmm.page.link/332g?inflow_channel=UElDQV9Q";
						break;
					case "RkFDRUJPT0s=":        //????????????
						aosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //?????????
						aosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						iosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //?????????
						aosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						iosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //????????????001
						aosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //??????
						aosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						iosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						break;
					default:                //????????????
						aosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						iosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel ????????????(????????????)
				aosUrl = "https://appdkmm.page.link/6R7o";
				iosUrl = "https://appdkmm.page.link/6R7o";
			}
		}

		model.addObject("inflow_channel", inflowChannel);
		model.addObject("aosUrl", aosUrl);
		model.addObject("iosUrl", iosUrl);
		model.addObject("urlMain", urlMain);
		//model.addObject("urlServerApi", urlServerApi);
		return model;
	}
	@RequestMapping(value="/promotion.do")
	public ModelAndView promotion(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		String inflowChannel = request.getParameter("inflow_channel");
		String share = request.getParameter("share");
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
		model.addObject("mobileCheck", flag);
		if(flag){			//?????????
			model.setViewName("promotion");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //???????????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //????????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //????????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //?????? ????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xFX1A=";
						break;
					case "UFBPTV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=UFBPTV9Q";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=UFBPTV9Q";
						break;
					case "UElDQV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=UElDQV9Q";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=UElDQV9Q";
						break;
					case "RkFDRUJPT0s=":        //????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //?????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=TkFWRVI=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //?????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=S0FLQU8=";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //????????????001
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //??????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=R09PR0xF";
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=R09PR0xF";
						break;
					default:                //????????????
						aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm&inflowChannel=" + inflowChannel;
						iosUrl = "https://apps.apple.com/app/id6443979602?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel ????????????(????????????)
				aosUrl = "https://play.google.com/store/apps/details?id=co.kr.infovine.dkmm";
				iosUrl = "https://apps.apple.com/app/id6443979602";
			}
		}
		else {
			model.setViewName("promotion");
			if (inflowChannel != null) {
				switch (inflowChannel) {
					case "RkFDRUJPT0tfUA==":        //???????????? ????????????
						aosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						iosUrl = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
						break;
					case "TkFWRVJfUA==":        //????????? ????????????
						aosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						iosUrl = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
						break;
					case "S0FLQU9fUA==":        //????????? ????????????
						aosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						iosUrl = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
						break;
					case "R09PR0xFX1A=":        //?????? ????????????
						aosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						iosUrl = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
						break;
					case "UFBPTV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://appdkmm.page.link/Yihd?inflow_channel=UFBPTV9Q";
						iosUrl = "https://appdkmm.page.link/Yihd?inflow_channel=UFBPTV9Q";
						break;
					case "UElDQV9Q":        //?????? ???????????? 20230209??????
						aosUrl = "https://appdkmm.page.link/332g?inflow_channel=UElDQV9Q";
						iosUrl = "https://appdkmm.page.link/332g?inflow_channel=UElDQV9Q";
						break;
					case "RkFDRUJPT0s=":        //????????????
						aosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						iosUrl = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
						break;
					case "TkFWRVI=":        //?????????
						aosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						iosUrl = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
						break;
					case "S0FLQU8=":        //?????????
						aosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						iosUrl = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
						break;
					case "T0ZGTElORTAwMQ==":        //????????????001
						aosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						iosUrl = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
						break;
					case "R09PR0xF":        //??????
						aosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						iosUrl = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
						break;
					default:                //????????????
						aosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						iosUrl = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
						break;
				}
			} else {
				//inflow_channel ????????????(????????????)
				aosUrl = "https://appdkmm.page.link/6R7o";
				iosUrl = "https://appdkmm.page.link/6R7o";
			}
		}

		model.addObject("inflow_channel", inflowChannel);
		model.addObject("aosUrl", aosUrl);
		model.addObject("iosUrl", iosUrl);
		model.addObject("urlMain", urlMain);
		//model.addObject("urlServerApi", urlServerApi);


		String today = CommonUtil.getToday();
		String mode = "current";

	/*	String futureKey = ServletRequestUtils.getStringParameter(request, "futureKey", "");
		if ("3qa@kljh2KslWTEOJk2390ufPmio2".equals(futureKey)) {
			mode = "future";
		} ?????? X
	 */
		List<TCommonCodeModel> list = commonService.selectCommonCodeByPromotion(mode);
		for (TCommonCodeModel commonCode: list) {
			if ("promotion_date".equals(commonCode.getCodeGroup())) {
				//String codeValue = commonCode.getCodeValue().replace("future_", ""); ?????? X
				String codeValue = commonCode.getCodeValue();
				String codeDescription = commonCode.getCodeDescription();

				model.addObject(codeValue, codeDescription);

				/*if ("start_date".equals(codeValue) && "future".equals(mode)) {
					today = codeDescription;
				} ?????? X */
				//???????????? ??????????????? ???
				if("close_date".equals(codeValue) && codeDescription != null){
					int compareToday = Integer.parseInt(today); //?????? ??????
					int compareCodeDescription = Integer.parseInt(codeDescription); //???????????? ?????? ??????
					if(compareToday >= compareCodeDescription) {
						RedirectView redirectView = new RedirectView();
						
						if(inflowChannel !=null && share != null){
							redirectView.setUrl("/index.do?inflow_channel=" + inflowChannel + "&share="+share);
						}else if(inflowChannel !=null) {
							redirectView.setUrl("/index.do?inflow_channel="+inflowChannel);
						}else if(share != null) {
							redirectView.setUrl("/index.do?share="+share);
						}else {
							redirectView.setUrl("/index.do");
						}
						redirectView.setExposeModelAttributes(false);
						model.setView(redirectView);
					}
					
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

	// region ??????: ??????????????? ??????
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
