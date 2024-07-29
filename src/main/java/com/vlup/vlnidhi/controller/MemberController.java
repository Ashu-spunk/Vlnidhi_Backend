package com.vlup.vlnidhi.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vlup.vlnidhi.dto.MemberCodeDto;
import com.vlup.vlnidhi.dto.MemberDto;
import com.vlup.vlnidhi.service.MemberService;




//@AllArgsConstructor
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/member")
public class MemberController {
	
	@Autowired
    private MemberService memberService;
	
	
	@PostMapping("/")
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        MemberDto createdMember = memberService.createMember(memberDto);
        return ResponseEntity.ok(createdMember);
    }

    @GetMapping("/{memberCode}")
    public ResponseEntity<MemberDto> getMemberByMemberCode(@PathVariable String memberCode) {
        Optional<MemberDto> memberDto = memberService.getMemberByMemberCode(memberCode);
        return memberDto.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        List<MemberDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PutMapping("/{memberCode}")
    public ResponseEntity<MemberDto> updateMemberByMemberCode(@PathVariable String memberCode, @RequestBody MemberDto memberDto) {
        Optional<MemberDto> updatedMember = memberService.updateMemberByMemberCode(memberCode, memberDto);
        return updatedMember.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search/")
    public ResponseEntity<List<MemberCodeDto>> getMembers(
            @RequestParam(value = "searchByCode", required = false) String searchByCode) {
        // Call service method to fetch members
        List<MemberCodeDto> memberCodeDtos = memberService.getMembers(searchByCode);

        // Return the list of MemberCodeDto objects
        return new ResponseEntity<>(memberCodeDtos, HttpStatus.OK);
    }
}
