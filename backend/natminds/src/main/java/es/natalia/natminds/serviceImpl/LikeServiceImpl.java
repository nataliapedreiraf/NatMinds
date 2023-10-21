package es.natalia.natminds.serviceImpl;

import es.natalia.natminds.dto.LikeDto;
import es.natalia.natminds.mapper.CommentMapper;
import es.natalia.natminds.mapper.LikeMapper;
import es.natalia.natminds.model.Comment;
import es.natalia.natminds.model.Like;
import es.natalia.natminds.model.User;
import es.natalia.natminds.repository.CommentRepository;
import es.natalia.natminds.repository.LikeRepository;
import es.natalia.natminds.service.LikeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static es.natalia.natminds.specification.CommentSpecifications.*;
import static es.natalia.natminds.specification.CommentSpecifications.byCommentDate;
import static es.natalia.natminds.specification.LikeSpecifications.byLikePostId;
import static es.natalia.natminds.specification.LikeSpecifications.byLikeUserId;


@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;
    @Autowired
    LikeMapper likeMapper;

    @Override
    public Like getLike(Long likeId) {
        Optional<Like> likeEntity = likeRepository.findById(likeId);
        return likeEntity.get();
    }

    @Override
    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void removeLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    @Override
    public List<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public List<LikeDto> findLikes(Long postId, Long userId) {
        Specification<Like> filters = Specification.where(postId == null ? null : byLikePostId(postId))
                .and(userId == null ? null : byLikeUserId(userId));

        return likeRepository.findAll(filters)
                .stream()
                .map(likeMapper::likeToDto)
                .toList();
    }
}
