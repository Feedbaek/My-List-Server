package crush.myList.domain.playlist.entity;

import crush.myList.domain.image.entity.Image;
import crush.myList.domain.member.entity.Member;
import crush.myList.domain.music.Entity.Music;
import crush.myList.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Playlist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(30)")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_image")
    private Image image;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Music> musics = new ArrayList<>();
}
