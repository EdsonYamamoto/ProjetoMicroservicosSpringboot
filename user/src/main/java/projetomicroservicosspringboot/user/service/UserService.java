package projetomicroservicosspringboot.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projetomicroservicosspringboot.user.model.UserModel;
import projetomicroservicosspringboot.user.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    public Iterable<UserModel> list(Pageable pageable){
        log.info("listing all users");
        return userRepository.findAll(pageable);
    }
}
