package crush.myList.domain.search.controller;

import crush.myList.domain.search.dto.MemberDto;
import crush.myList.domain.search.dto.PlaylistDto;
import crush.myList.domain.search.dto.SearchDto;
import crush.myList.domain.search.service.SearchService;
import crush.myList.global.dto.JsonBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Search", description = "검색 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class SearchController {
    private final SearchService searchService;
    @Operation(summary = "검색하기", description = "키워드로 유저와 플레이 리스트를 검색합니다.")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "검색 성공"),
            @ApiResponse(responseCode = "400", description = "검색어가 없음")
    })
    public JsonBody<SearchDto> search(@RequestParam(name = "q") String q) {
        SearchDto searchDto = searchService.search(q);
        return JsonBody.of(HttpStatus.OK.value(), "검색 성공", searchDto);
    }

    @Operation(summary = "플레이리스트 검색결과 더보기")
    @GetMapping("/playlist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "검색 성공"),
            @ApiResponse(responseCode = "400", description = "검색어가 없음")
    })
    public JsonBody<List<PlaylistDto>> searchPlaylist(@RequestParam(name = "q") String q,
                                                      @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {
        List<PlaylistDto> searchRes = searchService.searchPlaylists(q, page);
        return JsonBody.of(HttpStatus.OK.value(), "검색 성공", searchRes);
    }

    @Operation(summary = "멤버 검색결과 더보기")
    @GetMapping("/member")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "검색 성공"),
            @ApiResponse(responseCode = "400", description = "검색어가 없음")
    })
    public JsonBody<List<MemberDto>> searchMember(@RequestParam(name = "q") String q,
                                                  @RequestParam(name = "page", defaultValue = "0", required = false) Integer page) {
        List<MemberDto> searchRes = searchService.searchMembers(q, page);
        return JsonBody.of(HttpStatus.OK.value(), "검색 성공", searchRes);
    }
}
