package dw.study.lookie.pr_naver_reservation_api.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.study.lookie.pr_naver_reservation_api.dto.CategoryDto;
import dw.study.lookie.pr_naver_reservation_api.dto.CommentDto;
import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImageDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImageDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPriceDto;
import dw.study.lookie.pr_naver_reservation_api.dto.PromotionDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.service.DisplayService;
import dw.study.lookie.pr_naver_reservation_api.service.MainService;
import dw.study.lookie.pr_naver_reservation_api.service.ReservationService;
import dw.study.lookie.pr_naver_reservation_api.service.UserService;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	@Autowired
	private MainService mainService;
	@Autowired
	private DisplayService displayService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;

	// Main Page
	@ApiOperation(value = "카테고리 목록 조회")
	@ApiResponses({ // Response Message에 대한 Swagger 설명
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception") })
	@GetMapping("/categories") // 카테고리 목록
	public Map<String, Object> categoryList() {
		int size = mainService.getCountCategory();
		List<CategoryDto> list = mainService.getCategoryList();

		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}

	@ApiOperation(value = "상품 목록 조회")
	@ApiResponses({ // Response Message에 대한 Swagger 설명
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception") })
	@GetMapping("/displayinfos") // 상품 목록
	public Map<String, Object> productList(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		int totalCount = mainService.getCountDisplayInfo(categoryId);
		int productCount = MainService.LIMIT; // 여기 추가로 해야함
		List<ProductDto> list = mainService.getDisplayInfos(categoryId, start);

		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("productCount", productCount);
		map.put("products", list);
		return map;
	}

	@ApiOperation(value = "프로모션 목록 조회")
	@ApiResponses({ // Response Message에 대한 Swagger 설명
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception") })
	@GetMapping("/promotions") // 프로모션 목록
	public Map<String, Object> promotionList() {

		List<PromotionDto> list = mainService.getPromotionList();

		int size = mainService.getCountPromotion();

		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}

	// ProductPage
	@ApiOperation(value = "전시 정보 조회")
	@ApiResponses({ // Response Message에 대한 Swagger 설명
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception") })
	@GetMapping("/displayinfos/{displayId}") // 전시정보
	public Map<String, Object> productInfo(@PathVariable(name = "displayId") int displayId) {
		ProductDto productInfo = displayService.getDisplayInfo(displayId);
//		int avgScore = displayService.getAvgScore(displayId);
		List<ProductImageDto> productImages = displayService.getProductImageInfoList(displayId);
		List<DisplayInfoImageDto> displayInfoImages = displayService.getDisplayInfoImageList(displayId);
		List<ProductPriceDto> productPrices = displayService.getProductPriceList(displayId);

		Map<String, Object> map = new HashMap<>();
		map.put("product", productInfo);
		map.put("productImages", productImages);
		map.put("displayInfoImages", displayInfoImages);
//		map.put("avgScore", avgScore);
		map.put("productPrices", productPrices);
		return map;
	}

	@ApiOperation(value = "상품 댓글 조회")
	@ApiResponses({ // Response Message에 대한 Swagger 설명
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception") })
	@GetMapping("/comments")
	public Map<String, Object> productCommentList(
			@RequestParam(name = "productId", required = false, defaultValue = "0") int productId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) { // 상품의 댓글 목록

		int totalCount = displayService.getCountComment(productId);
		int commentCount = displayService.LIMIT; // 여기 추가로 해야함 - 의도를 모르겠음
		List<CommentDto> reservationUserComments = displayService.getCommentList(productId, start);

		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("commentCount", commentCount);
		map.put("reservationUserComments", reservationUserComments);
		return map;

	}

	// Reservation
	@PostMapping("/reservationInfos") // 예약 등록하기
	public Map<String, Object> enrollReservation(Principal principal, @RequestBody ReservationInfoDto reservationInfo) {
		String loginId = principal.getName();
		// user.id 구하기
		int userId = userService.getUserId(loginId);

		reservationInfo.setUserId(userId);
		ReservationInfoDto result = reservationService.enrollReservationInfo(reservationInfo);
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		return map;
	}

	@GetMapping("/reservationInfos") // 주문정보 구하기
	public Map<String, Object> reservationList(Principal principal) {
		String loginId = principal.getName();
		// user.id 구하기
		int userId = userService.getUserId(loginId);
		int size = reservationService.getReservationInfoCount(userId);
		List<ReservationInfoDto> list = reservationService.getReservationInfoList(userId);

		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}

	@PutMapping("/reservationInfos/{id}") // 예약 취소하기
	public Map<String, Object> cancelReservation(Principal principal, @PathVariable(name = "id") int id) {
		String loginId = principal.getName();
		// user.id 구하기
		int userId = userService.getUserId(loginId);
		String result = reservationService.cancelReservation(userId, id);

		Map<String, Object> map = new HashMap<>();
		map.put("result", result);

		return map;
	}

	@GetMapping("/files/{fileId}")
	public void download(@PathVariable(name = "fileId") int fileId, HttpServletResponse response) {
		FileInfo file = displayService.getFileInfo(fileId);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getFileName() + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", file.getConentType());
//        response.setHeader("Content-Length", "" + fileLength);
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		try (FileInputStream fis = new FileInputStream(file.getSaveFileName());
				OutputStream out = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = fis.read(buffer)) != -1) {
				out.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}

	}
}
