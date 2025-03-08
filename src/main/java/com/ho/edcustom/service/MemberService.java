package com.ho.edcustom.service;

import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.Jwt.JwtTokenProvider;
import com.ho.edcustom.entity.Member;
import com.ho.edcustom.enumSet.ErrorCode;
import com.ho.edcustom.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import com.ho.edcustom.Exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.regex.Pattern.matches;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    HttpResponse httpResponse;

    public void createMember(String name,String email,String password){
        memberRepository.save(Member.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build());

    }

    public boolean alreadyUsingemail(String email)
    {
        return memberRepository.findByEmail(email).isPresent();

    }

    public HttpResponse loginMember(String email, String password) {
            Optional<Member> member = memberRepository.findByEmail(email);
            if (member.isPresent()) {
                if (!passwordEncoder.matches(password, member.get().getPassword()))
                {
                    return new HttpResponse(HttpStatus.UNAUTHORIZED,ErrorCode.UNAUTHORIZED,null);
                }
            }
            else
            {
                return new HttpResponse(HttpStatus.UNAUTHORIZED,ErrorCode.UNAUTHORIZED,null);
            }
        return new HttpResponse(HttpStatus.OK,ErrorCode.SUCCESS,jwtTokenProvider.generateToken(member.get()));
    }
}
