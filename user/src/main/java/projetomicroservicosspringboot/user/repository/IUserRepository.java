package projetomicroservicosspringboot.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import projetomicroservicosspringboot.user.model.UserModel;

public interface IUserRepository extends PagingAndSortingRepository<UserModel, Long> {
}
