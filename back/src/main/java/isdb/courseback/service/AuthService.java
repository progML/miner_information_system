package isdb.courseback.service;

import isdb.courseback.model.Brigade;
import isdb.courseback.model.BrigadeRecord;
import isdb.courseback.repository.BrigadeRecordRepository;
import isdb.courseback.repository.BrigadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import isdb.courseback.dto.AuthenticationResponse;
import isdb.courseback.dto.UserDto;
import isdb.courseback.model.User;
import isdb.courseback.repository.UserRepository;
import isdb.courseback.security.JwtProvider;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private BrigadeRecordRepository brigadeRecordRepository;
    private BrigadeRepository brigadeRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;

    @Autowired
    public AuthService(UserRepository userRepository, BrigadeRecordRepository brigadeRecordRepository,
                       BrigadeRepository brigadeRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.brigadeRecordRepository = brigadeRecordRepository;
        this.brigadeRepository = brigadeRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public void signup(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(encodePassword(userDto.getPassword()));
        userRepository.save(user);
    }

    public boolean isUsernameFree(String username) {
        return userRepository.countByUsername(username) == 0;
    }

    public AuthenticationResponse login(UserDto userDto) {
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),
                    userDto.getPassword()));
        } catch (AuthenticationException authenticationException) {
            return AuthenticationResponse.builder()
                    .authenticationToken("")
                    .username("")
                    .build();
        }
        assert authenticate != null;
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        String username = userDto.getUsername();
        Optional<User> optionalUser = userRepository.findByUsername(username);
        Optional<BrigadeRecord> optionalBrigadeRecord = brigadeRecordRepository.findByMinerId(optionalUser.map(User::getId).orElse(0));
        int minerId = optionalUser.map(User::getId).orElse(0);
        String part = optionalBrigadeRecord.map(BrigadeRecord::getPart).orElse("");
        int brigadeId;
        if (part.equals("")) {
            part = "БРИГАДИР";
            brigadeId = brigadeRepository.findByForemanId(minerId).map(Brigade::getBrigadeId).orElse(0);
        } else {
            part = optionalBrigadeRecord.map(BrigadeRecord::getPart).orElse("");
            brigadeId = optionalBrigadeRecord.map(BrigadeRecord::getBrigadeId).orElse(0);
        }
        return AuthenticationResponse.builder()
                .authenticationToken(authenticationToken)
                .minerId(minerId)
                .username(username)
                .part(part)
                .brigadeId(brigadeId)
                .build();
    }

    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal =  (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(Optional.of(principal).get().getUsername()).
                orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
