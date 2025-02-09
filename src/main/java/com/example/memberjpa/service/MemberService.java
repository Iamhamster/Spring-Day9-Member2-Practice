package com.example.memberjpa.service;

import com.example.memberjpa.dto.MemberRequestDto;
import com.example.memberjpa.dto.MemberResponseDto;
import com.example.memberjpa.entity.Member;
import com.example.memberjpa.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponseDto saveMember(MemberRequestDto dto){
        Member member = memberRepository.save(new Member(dto.getName(), dto.getPw(), dto.getEmail()));

        return new MemberResponseDto(member.getId(),member.getName(), member.getEmail());
    }

    public List<MemberResponseDto> getMembers(){
        List<Member> members = memberRepository.findAll();

        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        for (Member member:members) {
            memberResponseDtos.add(new MemberResponseDto(member.getId(), member.getName(), member.getEmail()));
        }

        return memberResponseDtos;
    }

    public MemberResponseDto getMemberOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 메모가 없습니다.")
        );
        return new MemberResponseDto(member.getId(), member.getName(), member.getEmail());
    }

    public MemberResponseDto update(Long id, MemberRequestDto dto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 메모가 없습니다.")
        );
        member.update(dto.getName(), dto.getPw(), dto.getEmail());
        return new MemberResponseDto(member.getId(), member.getName(), member.getEmail());
    }

    public void delete(Long id) {
        if(!memberRepository.existsById(id)){
            throw new IllegalArgumentException("없는 id입니다.");
        }
        memberRepository.deleteById(id);
    }
}
