package crush.myList.domain.ranking.entity;

import crush.myList.domain.playlist.entity.Playlist;
import crush.myList.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "playlist_ranking")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistRanking extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @Column(name = "rank", nullable = false)
    private int rank;

    @Column(name = "like_count", nullable = false)
    private int likeCount;
}
