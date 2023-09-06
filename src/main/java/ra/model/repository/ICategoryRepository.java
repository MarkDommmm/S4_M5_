package ra.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Category;

@Repository
public interface ICategoryRepository  extends PagingAndSortingRepository<Category, Long> {

}
