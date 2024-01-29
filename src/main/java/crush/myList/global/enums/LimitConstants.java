package crush.myList.global.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LimitConstants {
    PLAYLIST_LIMIT(4),
    MUSIC_LIMIT(9),

    PLAYLIST_PAGE_SIZE(6);

    private final int limit;
}
