package com.sparta.post.controller;

import com.sparta.post.dto.PostDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.dto.ResponseDto;
import com.sparta.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //전체 게시글 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> findAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findAllPost());
    }

    //선택 게시글 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<ResponseDto> findOnePost(@PathVariable Long id) {
        try {
            PostDto postDto = postService.findOnePost(id);
            return ResponseEntity.status(HttpStatus.OK).body(new PostResponseDto("success", "", postDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "게시글이 존재하지 않습니다."));
        }
    }

    //게시글 작성
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/posts")
    public PostDto resisterPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    //게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(id, requestDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "게시글이 존재하지 않습니다."));
        }

    }

    //게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id, @RequestBody PostRequestDto postDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(id, postDto.getPassword()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "게시글이 존재하지 않습니다."));
        }
    }

}
