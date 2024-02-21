package com.teamsparta.demo111.domain.theater.service

import com.teamsparta.demo111.domain.theater.dto.CreateTheaterRequest
import com.teamsparta.demo111.domain.theater.model.Theater
import com.teamsparta.demo111.domain.theater.repository.TheaterRepository
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address
import org.springframework.stereotype.Service
import javax.swing.text.html.HTML.Tag.S

@Service//해당 클래스가 비즈니스 로직을 처리하는 서비스 클래스임을 나타낸다.
// 클래스를 표시하면, 해당 클래스가 비즈니스 로직을 구현하고 데이터를 처리하는 역할을 한다는 의미를 전달할 수 있다
class TheaterService (//클래스-일종의 설계도, 함수이름네이밍
    private val theaterRepository: TheaterRepository// 생성자주입 DB와 연결이 된 레파지토리: 반환 레파지토리로 주입 받음. 사용함
){//서비스는 저장하기위해 fun 함수네이밍 (필요한 인자- ~Id 혹은 dto등: 반환 동일하게, 반환시 단어 처음에 대문자로 한다.)
    fun createTheater(createTheaterRequest: CreateTheaterRequest) {
        //fun 변수명 (인자로 컨트롤러에서 받은 자료-dto,~id: 자료형 등 들어감)
        //저장하기위해서
            theaterRepository.save(// 시어터 레파지토리.세이브-저장-( 여기서는 시어터  )
                 Theater(
                     theaterName= createTheaterRequest.theaterName,
                     address = createTheaterRequest.address)
            )  //시어터( 저장하기위해 시어터 데이터는 (변수명)시어터 네임,주소 =뒤에는 인자로 받은 자료-크리에이트시어터리퀘스트.시어터네임, 주소만 꺼냄)
              // 저장이됨. 저장이 되서 DB에 들어갔다.


    }

}