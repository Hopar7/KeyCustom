package com.ho.edcustom.service;

import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.DTO.Response.TokenResponse;
import com.ho.edcustom.Jwt.JwtTokenProvider;
import com.ho.edcustom.entity.Member;
import com.ho.edcustom.enumSet.ErrorCode;
import com.ho.edcustom.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public HttpResponse createMember(String name,String email,String password){

        if(alreadyUsingemail(email))
        {
            return new HttpResponse(HttpStatus.BAD_REQUEST,ErrorCode.BAD_REQUEST_DUPLICATION,null);
        }

        memberRepository.save(Member.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build());
        return new HttpResponse(HttpStatus.CREATED,ErrorCode.CREATED,null);
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
                    return new HttpResponse(HttpStatus.BAD_REQUEST,ErrorCode.LOGIN_BAD_REQUEST,null);
                }
            }
            else
            {
                return new HttpResponse(HttpStatus.BAD_REQUEST,ErrorCode.LOGIN_BAD_REQUEST,null);
            }
        TokenResponse token = new TokenResponse(jwtTokenProvider.generateToken(member.get()));
        return new HttpResponse(HttpStatus.OK,ErrorCode.SUCCESS,token);
    }
}
