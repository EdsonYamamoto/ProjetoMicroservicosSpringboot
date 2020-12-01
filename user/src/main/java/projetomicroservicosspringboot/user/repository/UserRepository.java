package projetomicroservicosspringboot.user.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projetomicroservicosspringboot.user.model.UserModel;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRepository {
    private final IUserRepository iUserRepository;

    public Iterable<UserModel> list(Pageable pageable){
        log.info("listing all users");
        return iUserRepository.findAll(pageable);
    }

    public Iterable<UserModel> list(int pageIndex, int pageSize){
        log.info("listing all users");
        return iUserRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<UserModel> getId(long id){
        log.info("listing user " + id);
        return iUserRepository.findById(id);
    }
    public UserModel saveUser(UserModel user){
        log.info("saving users " + user );
        return iUserRepository.save(user);
    }
    public void deleteUser(UserModel user){
        log.info("deleting user" + user);
        iUserRepository.delete(user);
        return;
    }
}
