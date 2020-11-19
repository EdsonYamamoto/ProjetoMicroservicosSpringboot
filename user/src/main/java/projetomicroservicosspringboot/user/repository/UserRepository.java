package projetomicroservicosspringboot.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import projetomicroservicosspringboot.user.model.UserModel;

public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
}
