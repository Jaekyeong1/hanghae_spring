### 항해99 Spring 1주차

1. 아래의 요구사항을 기반으로 Use Case 그려보기
    - 손으로 그려도 됩니다.
    ![20221129_100618](https://user-images.githubusercontent.com/114788315/204953233-fecd0135-4693-4ec0-9a59-ea862449f67d.png)

    
2. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
    
3. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
    
4. 선택한 게시글 조회 API
    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
    
5. 선택한 게시글 수정 API
    - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
    
6. 선택한 게시글 삭제 API
    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기
    
    ---------------------------------------------------------------------------------------------------
    
1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
  
 - Answer. @RequestBody를 이용해 RequestDto에 있는 변수들을 불러왔다.
  
2. 어떤 상황에 어떤 방식의 request를 써야하나요?

 - Answer. RequestParam : GET방식으로 값을 전달하여 사용할때 사용
          RequestBody : POST,PUT,DELETE,PATCH 등으로 값을 전달할때 사용

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?

 - Answer. RESTful한 API를 설계를 하려고 최대한 맞췄는데, http를 맞춰서 설계를 했지만
          비밀번호 확인같은 부분을 api로 만들어 설계했으면 좋았을 것 같고
          아직 개념이 뒤죽박죽이라 조금 더 깔끔하고 편하게 기능들을 만들 수 있었으면 좋았을 거라는 아쉬움이 있다.

4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

  - Answer. controller : PostController
          entitiy : Post, Timestamped
          repository : PostRepository
          service : PostService

5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
