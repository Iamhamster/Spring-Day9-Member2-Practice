package com.example.memberjpa.controller;

import com.example.memberjpa.dto.MemberRequestDto;
import com.example.memberjpa.dto.MemberResponseDto;
import com.example.memberjpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberRequestDto requestDto){
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/member")
    public ResponseEntity<List<MemberResponseDto>> getMembers(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponseDto> getMemberOne(@PathVariable Long id){
        return ResponseEntity.ok(memberService.getMemberOne(id));
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<MemberResponseDto> update(@PathVariable Long id, @RequestBody MemberRequestDto dto){
        return ResponseEntity.ok(memberService.update(id, dto));
    }

    @DeleteMapping("/member/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }
}
