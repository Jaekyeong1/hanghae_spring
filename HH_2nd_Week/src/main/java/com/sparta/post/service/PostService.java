package com.sparta.post.service;

import com.sparta.post.dto.PostDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.dto.ResponseDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    // 전체 게시물 조회
    @Transactional
    public List<PostDto> findAllPost() {
        List<Post> post = postRepository.findAll();

        List<PostDto> result = new ArrayList<>();

        for (Post p : post) {
            result.add(new PostDto(p));
        }
        return result;
    }

    //선택 게시물 조회
    @Transactional
    public PostDto findOnePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        return new PostDto(post);
    }


    //등록
    @Transactional
    public PostDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);

        return new PostDto(post);
    }

    //게시글 비밀번호 확인
    @Transactional
    public Post checkPw(Long id, String password) {
        Post post = postRepository.findById(id).orElseThrow(IllegalAccessError::new);

        if (post.getPassword().equals(password)) {
            return post;
        } else {
            return new Post();
        }
    }


    //수정
    @Transactional
    public ResponseDto updatePost(Long id, PostRequestDto postDto) {
        Post post = checkPw(id, postDto.getPassword());

        if (post.getId() == null) {
            return new ResponseDto("fail", "비밀번호가 일치하지 않습니다.");
        } else {
            post.updatePost(postDto);
            PostDto responsePostDto = new PostDto(post);
            return new PostResponseDto("success", "게시글 수정 완료", responsePostDto);
        }
    }

    //삭제
    @Transactional
    public ResponseDto deletePost(Long id, String password) {

        Post checkPost = checkPw(id, password);

        if (checkPost.getId() == null) {
            return new ResponseDto("fail", "비밀번호가 일치하지 않습니다.");
        } else {
            postRepository.deleteById(id);
            return new ResponseDto("success", "게시글 삭제 완료");
        }
    }
}
