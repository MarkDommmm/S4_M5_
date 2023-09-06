package ra.model.service.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.dto.PostDto;
import ra.model.entity.Post;
import ra.model.service.IGenericService;

public interface IPostService extends IGenericService<Post,Long> {
        void save(PostDto postDto);
        Page<Post> findAll(Pageable pageable);
        Page<Post> findAllByTitleContaining(String title, Pageable pageable);


}
