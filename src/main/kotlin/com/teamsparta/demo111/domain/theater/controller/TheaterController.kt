package com.teamsparta.demo111.domain.theater.controller

import com.teamsparta.demo111.domain.theater.dto.CreateTheaterRequest
import com.teamsparta.demo111.domain.theater.dto.UpdateTheaterRequest
import com.teamsparta.demo111.domain.theater.service.TheaterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
//내일 코드 마다 주석달기
@RestController//어노테이션으로 클래스에 적용되며, 해당 클래스가 RESTful 웹 서비스의 엔드포인트를 처리하는 컨트롤러임을 나타낸다.
//스프링이 자동으로 해당 클래스를 컨트롤러로 인식하고, HTTP 요청에 대한 처리를 할 수 있게 된다.
@RequestMapping("/api/v1/theater")//인터넷으로 보면 이 주소로 클라이언트 요청을 받는다. 외부주소
//웹 요청과 매핑되는 메소드를 지정하는 데 사용됩니다. 즉, @RequestMapping 어노테이션을 사용하여 특정 URL 경로와
//HTTP 메소드에 대한 요청을 처리하는 메소드를 지정할 수 있다.클래스 수준 또는 메소드 수준에서 사용할 수 있다.

class TheaterController (//컨트롤러는 요청을 받는다. 서비스에게 일을 맡긴다. 응답을 클라이언트에게 준다.
    private val theaterService: TheaterService//생성자주입-시어터서비스: (반환)시어터 서비스(단어 첫 글자를 대문자로 작성함.
){
    @PostMapping//포스트- 이 서버에 저장할때, 그것을 알려주기위해 어노테이션을 붙인다. 포스트 메소드로 보내고, 포스터매핑으로 받는다.
    fun createTheater(//fun 함수네이밍(파라미터안에 )
        @RequestBody createTheaterRequest: CreateTheaterRequest
    // @RequestBody는 필요한 정보를 받기위해서, 필요한 정보가 담긴 dto가 들어간다

    // 리퀘스트(요청)에서는 클라이언트로부터 저장하고 싶은 내용를 받기위해서 만든다.
    // (리퀘스트는 데이터클래스로, 요청받을 정보들을 적는다.-여기서는 시어터이름, 주소 자료타입은 string)
    //여기서는 요청을 받는거고,
    ) {
        theaterService.createTheater(createTheaterRequest)
    //데이터를 처리해줄 서비스로 서비스클래스를 만드는 흐름으로 간다. 그리고 서비스.해당 함수네이밍을 호출한다.
    // 그리고 ( )안에 인자로 필요한 정보 -여기서는해당 dto을-를 넣는다.
    //저장하기위해 시어터서비스.크리에이트시어터 호출 (필요한 인자들-크리에이트시어터리퀘스트)

    }
@PutMapping("/{theaterId}")
 fun updateTheater(@PathVariable theaterId: Long, @RequestBody updateTheaterRequest: UpdateTheaterRequest){

 }

 }
//커멘드+E 최근에 갔던 문서들을 보고 선택할 수 있다. 커멘드 누르고, 변수이름을 클릭하면 해당 문서내용을 볼 수 있다.

//이 프로젝트목적은 시어터(영화관)정보저장이다.
//컨트롤러- 필요한 dto 작성,
//서비스- 모둘(엔티티 필요함- DB와 연결된 문서),DB와 연결시키기, 모둘명네이밍-위에  @Entity, @Table(name = "DB에 테이블명"),
// 클래스 변수네이밍 ()안에 @Colum(name = "DB에 열이름") 밑에 val, var 후에 어플리케이션에서쓰는 변수명: 자료타입 작성 ,
//{ }안에는  @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long = 0L 이 들어간다.(Long 정수타입, 범위가 넒다) 자료형에 따라 값은 0뒤에 붙는게 달라진다.- 이부분 외우기 공통으로 들어감

// 모둘(엔티티)을 만든후, 레파지토리 필요함- 레파지토리만듬.
// 인터페이스 레파지토리 네이밍 :JPA레파지토리 상속<엔티티이름, Id 자료형태> { 경우에따라 getAll~함수등으로 이메일, 닉네임등 찾는다.}
// Jpa레파지토리 상속받는 이유- DB 언어변환(인테리제이와 애플리케이션사이),  함수로 자료등을 찾아준다. 쿼리부분 처리하는 것도 있다.
//컨트롤러에서는 서비스를 주입받고, 서비스에서는 레파지토리를 생성자 주입받는다.

